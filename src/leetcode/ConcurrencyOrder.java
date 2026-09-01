package leetcode;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class ConcurrencyOrder {
    private int threadToRun=1;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition turnChanged = lock.newCondition();

    public ConcurrencyOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while(threadToRun!=1){
                turnChanged.await();
            }

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            threadToRun=2;
            turnChanged.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        lock.lock();
        try {
            while(threadToRun!=2){
                turnChanged.await();
            }
            printSecond.run();
            threadToRun=3;
            turnChanged.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        lock.lock();
        try {
            while(threadToRun!=3){
                turnChanged.await();
            }
            printThird.run();
            turnChanged.signalAll();
        } finally {
            lock.unlock();
        }
    }
}


class ConcurrencyOrderRunner {

    public static void main(String[] args) throws InterruptedException {
        ConcurrencyOrder run = new ConcurrencyOrder();
        Runnable first = () -> System.out.print("first");
        Runnable second = () -> System.out.print("second");
        Runnable third = () -> System.out.print("third");

        run.first(first);
        run.second(second);
        run.third(third);
    }
}
