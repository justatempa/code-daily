package life.runfast.jdkapi.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author justatempa
 * @description
 * @datetime 2023/6/14 21:49
 */
public class ThreadPoolDemo {
    private static Executor executor = new ThreadPoolExecutor(1, 2,
            60, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2));

    public static void main(String[] args) {
        executor.execute(() -> {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("********************");
        executor.execute(() -> {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("----------------------");
    }
}
