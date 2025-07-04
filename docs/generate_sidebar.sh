#!/bin/bash

# 脚本用于自动生成 docs/leetcode/_sidebar.md 文件
# 扫描 docs/leetcode 目录下的所有 .md 文件（除了 README.md）
# 提取文件标题并生成侧边栏格式

#LEETCODE_DIR="docs/leetcode"
LEETCODE_DIR=$1
SIDEBAR_FILE="$LEETCODE_DIR/_sidebar.md"

# 检查目录是否存在
if [ ! -d "$LEETCODE_DIR" ]; then
    echo "错误: 目录 $LEETCODE_DIR 不存在"
    exit 1
fi

# 创建临时文件存储结果
TEMP_FILE=$(mktemp)

# 写入文件头部
echo "<!-- docs/_sidebar.md -->" > "$TEMP_FILE"
echo "" >> "$TEMP_FILE"

# 函数：提取文件标题
extract_title() {
    local file="$1"
    local filename=$(basename "$file" .md)

    # 尝试从文件中提取标题（查找第一个 ### 标题）
    local title=$(head -10 "$file" | grep -m1 "^### " | sed 's/^### //')

    if [ -n "$title" ]; then
        echo "$title"
    else
        # 如果没有找到 ### 标题，使用文件名
        echo "$filename"
    fi
}

# 函数：从文件名提取数字用于排序
extract_number() {
    local filename="$1"
    # 提取文件名中的数字部分
    echo "$filename" | grep -o -E '[0-9]+' | head -1
}

# 收集所有符合条件的文件
declare -a files=()
for file in "$LEETCODE_DIR"/*.md; do
    if [ -f "$file" ]; then
        filename=$(basename "$file")
        # 排除 README.md, _sidebar.md, _sidebar_backup.md
        if [[ "$filename" != "README.md" && "$filename" != "_sidebar.md" && "$filename" != "_sidebar_backup.md" ]]; then
            files+=("$file")
        fi
    fi
done

# 对文件进行分类和排序
declare -a lcp_files=()
declare -a numbered_files=()
declare -a other_files=()

for file in "${files[@]}"; do
    filename=$(basename "$file" .md)
    if [[ "$filename" =~ ^lcp ]]; then
        lcp_files+=("$file")
    elif [[ "$filename" =~ [0-9] ]]; then
        numbered_files+=("$file")
    else
        other_files+=("$file")
    fi
done

# 对lcp文件按文件名排序
if [ ${#lcp_files[@]} -gt 0 ]; then
    IFS=$'\n' lcp_files=($(printf '%s\n' "${lcp_files[@]}" | sort))
fi

# 对包含数字的文件按数字排序
if [ ${#numbered_files[@]} -gt 0 ]; then
    IFS=$'\n' numbered_files=($(for file in "${numbered_files[@]}"; do
        filename=$(basename "$file" .md)
        number=$(extract_number "$filename")
        printf "%04d %s\n" "${number:-9999}" "$file"
    done | sort -n | cut -d' ' -f2-))
fi

# 对其他文件按文件名排序
if [ ${#other_files[@]} -gt 0 ]; then
    IFS=$'\n' other_files=($(printf '%s\n' "${other_files[@]}" | sort))
fi

# 生成侧边栏条目
generate_sidebar_entry() {
    local file="$1"
    local filename=$(basename "$file" .md)
    local title=$(extract_title "$file")
    local relative_path="/leetcode/$filename.md"

    # 根据文件名格式决定显示格式
    if [[ "$filename" =~ ^\[.*\] ]]; then
        # 对于 [数字]标题 格式的文件
        echo "* [$title]($relative_path)"
    elif [[ "$filename" =~ ^leetcode[0-9] ]]; then
        # 对于 leetcode数字 格式的文件，提取数字
        local number=$(echo "$filename" | grep -o -E '[0-9]+')
        echo "* [$number $title]($relative_path)"
    elif [[ "$filename" =~ ^lcp ]]; then
        # 对于 lcp 文件
        echo "* [$title]($relative_path)"
    else
        # 其他格式
        echo "* [$title]($relative_path)"
    fi
}

# 按顺序生成所有条目：lcp文件 -> 数字文件 -> 其他文件
for file in "${lcp_files[@]}"; do
    generate_sidebar_entry "$file" >> "$TEMP_FILE"
done

for file in "${numbered_files[@]}"; do
    generate_sidebar_entry "$file" >> "$TEMP_FILE"
done

for file in "${other_files[@]}"; do
    generate_sidebar_entry "$file" >> "$TEMP_FILE"
done

# 添加空行结尾
echo "" >> "$TEMP_FILE"

# 将临时文件内容写入目标文件
mv "$TEMP_FILE" "$SIDEBAR_FILE"

echo "已成功生成 $SIDEBAR_FILE"
echo "共处理了 $((${#lcp_files[@]} + ${#numbered_files[@]} + ${#other_files[@]})) 个文件"
echo "  - LCP文件: ${#lcp_files[@]} 个"
echo "  - 数字编号文件: ${#numbered_files[@]} 个"
echo "  - 其他文件: ${#other_files[@]} 个"

