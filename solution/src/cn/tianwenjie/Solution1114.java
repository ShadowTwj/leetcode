package cn.tianwenjie;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 信号量实现
 * <p>
 * CountDownLatch实现
 */
//class Foo {
//
//    public Foo() {
//
//    }
//
//    private final Semaphore semaphoreFirst = new Semaphore(0);
//    private final Semaphore semaphoreSecond = new Semaphore(0);
//
//    public void first(Runnable printFirst) throws InterruptedException {
//
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        semaphoreFirst.release();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        semaphoreFirst.acquire();
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        semaphoreSecond.release();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        semaphoreSecond.acquire();
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }
//}

/**
 * CountDownLatch实现
 */
//class Foo {
//
//    public Foo() {
//
//    }
//
//    private final CountDownLatch downLatchFirst = new CountDownLatch(1);
//    private final CountDownLatch downLatchSecond = new CountDownLatch(1);
//
//    public void first(Runnable printFirst) throws InterruptedException {
//
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        downLatchFirst.countDown();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        downLatchFirst.await();
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        downLatchSecond.countDown();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        downLatchSecond.await();
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }
//}


/**
 * AtomicInteger实现
 */
class Foo {

    public Foo() {

    }

    private final AtomicInteger firstJobDone = new AtomicInteger(0);
    private final AtomicInteger secondJobDone = new AtomicInteger(0);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}


public class Solution1114 {

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        foo.first(new Thread(() -> System.out.println("first")));
        foo.first(new Thread(() -> System.out.println("second")));
        foo.first(new Thread(() -> System.out.println("third")));
    }
}
