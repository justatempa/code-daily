package life.runfast.jdkapi.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author justatempa
 * @description
 * @datetime 2023/6/28 13:02
 */
public class DeadLock {
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    public static void main(String[] args) {

        new Thread(() -> {
            lock1.lock();
            System.out.println("1 - lock1 lock");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock2.lock();
            System.out.println("1 - lock2 lock");
            lock1.unlock();
            lock2.unlock();
        }, "Thread - 1").start();

        new Thread(() -> {
            lock2.lock();
            System.out.println("2 - lock2 lock");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock1.lock();
            System.out.println("2 - lock1 lock");
            lock2.unlock();
            lock1.unlock();
        }, "Thread - 2").start();
    }
}
