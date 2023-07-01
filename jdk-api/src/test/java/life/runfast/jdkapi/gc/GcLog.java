package life.runfast.jdkapi.gc;

/**
 * @author justatempa
 * @description
 * @datetime 2023/6/28 20:45
 */
public class GcLog {
    /**
     *

     -XX:NewSize=5242880
     -XX:MaxNewSize=5242880
     -XX:InitialHeapSize=10485760
     -XX:MaxHeapSize=10485760
     -XX:SurvivorRatio=8
     -XX:PretenureSizeThreshold=10485760
     -XX:+UseParNewGC
     -XX:+UseConcMarkSweepGC
     -XX:+PrintGCDetails
     -XX:+PrintGCTimeStamps
     -Xloggc:gc.log


     XX:NewSize和XX:MaxNewSize初始新生代和最大新生代的大小，为5MB

     XX:InitialHeapSize和XX:MaxHeapSize：初始堆内存大小和最大堆内存大小，为10MB

     XX:SurvivorRatio：新生代中Eden区和Survivor区的大小比例，8代表Eden区占整个新生代区域的80%

     XX:PretenureSizeThreshold：指定大对象的阈值是10MB

     UseParNewGC新生代用的是ParNewGC垃圾回收器

     XX:+UseConcMarkSweepGC老年代用的是CMS垃圾回收器

     XX:+PrintGCDetails：打印详细的GC日志

     XX:+PrintGCTimeStamps：打印出每次GC发生的时间

     Xloggc:gc.log：将GC日志写入gc.log文件中
     ————————————————
     版权声明：本文为CSDN博主「Java佳佳」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     原文链接：https://blog.csdn.net/Java_zhujia/article/details/128075559
     */
    public static void main(String[] args) {
        GcLog gcLog = new GcLog();
        while (true) {
            gcLog.createByte(1);
            sleepNs(1);
            gcLog.createByte(1);
            sleepNs(1);
            gcLog.createByte(2);
            sleepNs(1);
            gcLog.createByte(3);
            sleepNs(1);
            gcLog.createByte(10);
        }


    }

    private void createByte(int n) {
        new Thread(() -> {
            byte[] b = new byte[n * 1024 * 1024];
            System.out.println(n + " M new");
            sleepNs(10);
        }).start();

    }

    public static void sleepNs(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
