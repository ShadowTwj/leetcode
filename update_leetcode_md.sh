#!/bin/bash

# 批量处理版本 - 改进文件匹配逻辑
batch_process() {
    local java_dir="$1"
    local md_dir="$2"
    local output_dir="$3"

    echo "开始批量处理..."
    echo "Java文件目录: $java_dir"
    echo "Markdown文件目录: $md_dir"
    echo "输出目录: $output_dir"

    # 创建输出目录
    mkdir -p "$output_dir"

    local count=0
    local failed_count=0

    # 遍历所有Java文件
    for java_file in "$java_dir"/*.java; do
        if [ -f "$java_file" ]; then
            # 提取文件名（不含扩展名和路径）
            local java_basename=$(basename "$java_file" .java)
            echo "🔍 正在处理Java文件: $java_basename"

            # 从Java文件名中提取题目编号和名称
            # 支持格式: [67]二进制求和.java 或 67-二进制求和.java
            local problem_num=""
            local problem_name=""

            if [[ "$java_basename" =~ ^\[([0-9]+)\](.+)$ ]]; then
                # 格式: [67]二进制求和
                problem_num="${BASH_REMATCH[1]}"
                problem_name="${BASH_REMATCH[2]}"
            elif [[ "$java_basename" =~ ^([0-9]+)-(.+)$ ]]; then
                # 格式: 67-二进制求和
                problem_num="${BASH_REMATCH[1]}"
                problem_name="${BASH_REMATCH[2]}"
            else
                # 直接使用文件名
                problem_name="$java_basename"
            fi

            echo "  📝 题目编号: $problem_num"
            echo "  📝 题目名称: $problem_name"

            # 多种方式查找对应的markdown文件
            local md_file=""

            # 方式1: 精确匹配文件名
            if [ -f "$md_dir/$java_basename.md" ]; then
                md_file="$md_dir/$java_basename.md"
                echo "  ✅ 找到精确匹配: $(basename "$md_file")"
            # 方式2: 根据题目编号查找
            elif [ -n "$problem_num" ]; then
                md_file=$(find "$md_dir" -name "*$problem_num*.md" | head -1)
                if [ -f "$md_file" ]; then
                    echo "  ✅ 根据编号找到: $(basename "$md_file")"
                fi
            fi

            # 方式3: 根据题目名称查找
            if [ -z "$md_file" ] && [ -n "$problem_name" ]; then
                md_file=$(find "$md_dir" -name "*$problem_name*.md" | head -1)
                if [ -f "$md_file" ]; then
                    echo "  ✅ 根据名称找到: $(basename "$md_file")"
                fi
            fi

            # 方式4: 模糊匹配
            if [ -z "$md_file" ]; then
                echo "  🔍 尝试模糊匹配..."
                # 列出所有可能的匹配文件
                local possible_files=$(find "$md_dir" -name "*.md" -exec basename {} \; | grep -i "$problem_name" | head -5)
                if [ -n "$possible_files" ]; then
                    echo "  💡 可能的匹配文件:"
                    echo "$possible_files" | sed 's/^/    - /'
                    # 选择第一个匹配的文件
                    local first_match=$(echo "$possible_files" | head -1)
                    md_file="$md_dir/$first_match"
                fi
            fi

            if [ -f "$md_file" ]; then
                local output_file="$output_dir/$(basename "$md_file")"
                echo "  🚀 开始处理..."

                # 调用主处理函数
                if process_single_file "$java_file" "$md_file" "$output_file"; then
                    ((count++))
                else
                    ((failed_count++))
                fi
            else
                echo "  ❌ 未找到对应的markdown文件"
                echo "  💡 请检查以下内容:"
                echo "    - Markdown目录是否正确: $md_dir"
                echo "    - 文件命名是否匹配"
                echo "    - 可用的markdown文件:"
                find "$md_dir" -name "*.md" -exec basename {} \; | head -5 | sed 's/^/      /'
                ((failed_count++))
            fi
            echo "  ────────────────────────────────"
        fi
    done

    echo "📊 批量处理完成:"
    echo "  ✅ 成功处理: $count 个文件"
    echo "  ❌ 处理失败: $failed_count 个文件"
}

# 单文件处理函数
process_single_file() {
    local java_file="$1"
    local source_md="$2"
    local target_md="$3"

    # 提取Java代码 - 提取所有class Solution对应代码
    local temp_code=$(mktemp)

    # 使用awk提取所有class Solution的完整代码块，并删除注释
    awk '
    BEGIN {
        in_solution = 0
        brace_count = 0
        found_class = 0
        solution_count = 0
        prev_line = ""
        solution_comment = ""
    }

    # 保存前一行，用于获取Solution上方的注释
    {
        if (!in_solution) {
            # 检查是否是描述性注释（如"深度优先搜索"）
            # 只匹配行首直接是//的注释，不匹配有缩进的代码注释
            if (/^\/\/[^\/]/ && !/^\/\/[[:space:]]*class/ && !/^\/\/leetcode/) {
                # 提取注释内容，去掉//但保留空格
                solution_comment = $0
                gsub(/^\/\//, "", solution_comment)
                # 去掉前后空格
                gsub(/^[[:space:]]+|[[:space:]]+$/, "", solution_comment)
            }
        }
    }

    # 匹配class Solution行（包括被注释的）
    /^[[:space:]]*\/\/[[:space:]]*class[[:space:]]+Solution[[:space:]]*\{/ || /^[[:space:]]*\/\/class[[:space:]]+Solution[[:space:]]*\{/ || /^[[:space:]]*class[[:space:]]+Solution[[:space:]]*\{/ {
        in_solution = 1
        found_class = 1
        solution_count++
        brace_count = 1

        # 多个Solution，添加代码块分隔
        print ""
        if (solution_comment != "") {
            print "**方法" solution_count "：" solution_comment "**"
        } else {
            print "**方法" solution_count "**"
        }
        # 每个Solution代码块开头
        print "```java"


        # 只删除代码注释（行首无空格缩进的//），保留正常注释（有空格缩进的//）
        if (/^\/\//) {
            # 行首直接是//的代码注释，删除//但保留后面的空格作为缩进
            if (/^\/\/[[:space:]]+/) {
                # 如果//后面有空格，保留这些空格作为缩进
                gsub(/^\/\//, "")
            } else {
                # 如果//后面没有空格，直接删除//
                gsub(/^\/\//, "")
            }
        }
        # 保留有空格缩进的正常注释不处理
        if ($0 !~ /^[[:space:]]*$/) print $0

        next
    }

    # 如果在Solution类内部
    in_solution {
        # 统计大括号（需要先处理注释）
        line = $0
        # 删除行首的注释符号
        gsub(/^[[:space:]]*\/\/[[:space:]]*/, "", line)
        gsub(/^[[:space:]]*\/\//, "", line)

        for (i = 1; i <= length(line); i++) {
            char = substr(line, i, 1)
            if (char == "{") brace_count++
            else if (char == "}") brace_count--
        }

        # 只删除代码注释（行首无空格缩进的//），保留正常注释（有空格缩进的//）
        if (/^\/\//) {
            # 行首直接是//的代码注释，删除//但保留后面的空格作为缩进
            if (/^\/\/[[:space:]]+/) {
                # 如果//后面有空格，保留这些空格作为缩进
                gsub(/^\/\//, "")
            } else {
                # 如果//后面没有空格，直接删除//
                gsub(/^\/\//, "")
            }
        }
        # 保留有空格缩进的正常注释不处理

        # 如果不是空行，则输出
        if ($0 !~ /^[[:space:]]*$/) print $0

        # 如果大括号计数为0，说明class结束
        if (brace_count == 0) {
            in_solution = 0
            # 重置注释变量
            solution_comment = ""
            # 不要exit，继续寻找下一个Solution类
            # 每个Solution代码块结尾
            print "```"
        }
    }

    END {
        if (!found_class) {
            print "// 未找到class Solution" > "/dev/stderr"
        } else {
            print "// 共找到 " solution_count " 个Solution类" > "/dev/stderr"
        }
    }
    ' "$java_file" > "$temp_code"

    if [ ! -s "$temp_code" ]; then
        echo "  ⚠️  警告: 未找到有效代码区域"
        rm "$temp_code"
        return 1
    fi

    # 复制并处理文件
    cp "$source_md" "$target_md"

    if grep -q "#### 题解" "$source_md"; then
        # 替换现有题解
        awk '
        BEGIN { in_solution = 0; in_java_block = 0; printed_new_code = 0 }
        /#### 题解/ { in_solution = 1; print; next }
        in_solution && /^```java/ {
            in_java_block = 1
            if (!printed_new_code) {
                print ""
                print "```java"
                while ((getline line < "'"$temp_code"'") > 0) {
                    print line
                }
                print "```"
                printed_new_code = 1
            }
            next
        }
        in_solution && in_java_block && /^```$/ {
            in_java_block = 0
            next
        }
        in_solution && in_java_block { next }
        { print }
        ' "$target_md" > "${target_md}.tmp"
        mv "${target_md}.tmp" "$target_md"
    else
        # 添加新题解
        echo "" >> "$target_md"
        echo "" >> "$target_md"
        echo "#### 题解" >> "$target_md"
#        echo '```java' >> "$target_md"
        cat "$temp_code" >> "$target_md"
#        echo '```' >> "$target_md"
    fi

    rm "$temp_code"
    echo "  ✅ 完成: $(basename "$target_md")"
}

# 基础路径配置
BASE_PATH="/Users/tianwj/workspace/other/leetcode"
JAVA_BASE_PATH="$BASE_PATH/question/src/cn/tianwenjie/leetcode/editor/cn/"
SOURCE_MD_BASE_PATH="$BASE_PATH/question/src/cn/tianwenjie/leetcode/editor/cn/doc/content/"
TARGET_MD_BASE_PATH="$BASE_PATH/docs/leetcode/"

# 主程序
main() {
    case $# in
        1)
           # 批量处理模式，基础路径
           if [ "$1" = "--batch" ]; then
               batch_process  "$JAVA_BASE_PATH" "$SOURCE_MD_BASE_PATH" "$TARGET_MD_BASE_PATH"
           else
              # 单文件处理，基础路径
              process_single_file "$JAVA_BASE_PATH$1.java" "$SOURCE_MD_BASE_PATH$1.md" "$TARGET_MD_BASE_PATH$1.md"
           fi
           ;;
        3)
            # 单文件处理，全路径
            process_single_file "$1" "$2" "$3"
            ;;
        4)
            # 批量处理模式，全路径
            if [ "$1" = "--batch" ]; then
                batch_process "$2" "$3" "$4"
            else
                echo "参数错误"
                show_usage
                exit 1
            fi
            ;;
        *)
            show_usage
            exit 1
            ;;
    esac
}

show_usage() {
    echo "使用方法:"
    echo "  单文件: $0 <java文件> <源markdown文件> <目标markdown文件>"
    echo "  批量:   $0 --batch <java文件目录> <markdown文件目录> <输出目录>"
    echo ""
    echo "示例:"
    echo "  $0 '[67]二进制求和.java' '67-二进制求和.md' 'output/67-二进制求和-solution.md'"
    echo "  $0 --batch 'java_files/' 'md_files/' 'output/'"
}

# 运行主程序
main "$@"