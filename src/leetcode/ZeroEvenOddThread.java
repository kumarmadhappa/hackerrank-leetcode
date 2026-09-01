package leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOddThread {
    private int n;
    private boolean printZero;
    private final ReentrantLock lock;
    private final Condition cond;
    private int printedNumber;


    public ZeroEvenOddThread(int n) {
        this.n = n;
        printZero = true;
        lock = new ReentrantLock();
        cond = lock.newCondition();
        printedNumber = 1;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (printedNumber <= n && !printZero) {
                    cond.await();
                }
                if (printedNumber > n) {
                    cond.signalAll();
                    return;
                }
                printNumber.accept(0);
                printZero = false;
                cond.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (printedNumber <= n && (printedNumber % 2 != 0 || printZero)) {
                    cond.await();
                }
                if (printedNumber > n) {
                    cond.signalAll();
                    return;
                }
                printNumber.accept(printedNumber);
                printedNumber++;
                printZero = true;
                cond.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (printedNumber <= n && (printedNumber % 2 == 0 || printZero)) {
                    cond.await();
                }
                if (printedNumber > n) {
                    cond.signalAll();
                    return;
                }
                printNumber.accept(printedNumber);
                printedNumber++;
                printZero = true;
                cond.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}

class ZeroEvenOddThreadRunner {
    public static void main(String[] args) {
        int n = 2;
        ZeroEvenOddThread zeroEvenOddThread = new ZeroEvenOddThread(n);
        IntConsumer printNumber = System.out::print;

        Thread zeroThread = new Thread(() -> {
            try {
                zeroEvenOddThread.zero(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread oddThread = new Thread(() -> {
            try {
                zeroEvenOddThread.odd(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread evenThread = new Thread(() -> {
            try {
                zeroEvenOddThread.even(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        zeroThread.start();
        oddThread.start();
        evenThread.start();

        try {
            zeroThread.join();
            oddThread.join();
            evenThread.join();
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
