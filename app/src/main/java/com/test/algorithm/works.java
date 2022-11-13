package com.test.algorithm;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * author:YanYang
 * date:2022/11/12 23:48
 */
class works {


    public static void main(String[] args) {
//        newSingledPool();
       works works = new works();
//       works.newFixedPool();
       works.setQuene();
    }


    public void setQuene(){
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        linkedBlockingQueue.add("12345");
        linkedBlockingQueue.add("12346");
        linkedBlockingQueue.add("12347");
        linkedBlockingQueue.add("12348");
        linkedBlockingQueue.add("12349");


        for (int i = 5; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(new Date() + "===" + "1234"+i);
            linkedBlockingQueue.remove("1234"+i);

            System.out.println(new Date() + "===" + linkedBlockingQueue.size());

        }


    };


    public static void newCachedPool() {

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "===" + index);
                }
            });
        }

    }

    public  void newFixedPool() {

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);

       for (int i = 0; i < 10; i++) {
          fixedThreadPool.execute(new TestRunnable(i));
       }

//       fixedThreadPool.shutdown();

       try {
          fixedThreadPool.awaitTermination(10,TimeUnit.MICROSECONDS);
       } catch (InterruptedException e) {
          e.printStackTrace();
       }

       fixedThreadPool.execute(new TestRunnable(10));


//        for (int i = 0; i < 10; i++) {
//            final int index = i;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            fixedThreadPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + "===" + index);
//                }
//            });
//        }

    }

    class TestRunnable implements Runnable{

       int i;
       public  TestRunnable(int i){
          this.i = i;
       }

       @Override
       public void run() {
          try {
             Thread.sleep(1000);
          } catch (InterruptedException e) {
             e.printStackTrace();
          }
          System.out.println(Thread.currentThread().getName() + "===" + i);

       }
    }

    public static void newSingledPool() {

        ExecutorService singledThreadPool = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            singledThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(new Date() + "--" + Thread.currentThread().getName() + "===" + index);
                }
            });
        }
    }


    public static void newScheduledPool() {

        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            scheduledThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(new Date() + "--" + Thread.currentThread().getName() + "===" + index);
                }
            });
        }
    }

    public static void newScheduledPool2() {

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

        scheduledThreadPool.schedule(new Runnable() {

            public void run() {

                System.out.println(new Date() + "--" + Thread.currentThread().getName() + "===" + "delay 3 seconds");

            }

        }, 3, TimeUnit.SECONDS);
    }


   public static void newScheduledPool3() {

      ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

      scheduledThreadPool.scheduleAtFixedRate(new Runnable() {

         public void run() {

            System.out.println("delay 1 seconds, and excute every 3 seconds");

         }

      }, 1, 3, TimeUnit.SECONDS);

   }


}
