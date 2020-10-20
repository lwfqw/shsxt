# 多线程（单核cpu宏观上并行，微观上串行）

## 1. 线程状态

![image-20201019213747706](https://www.runoob.com/wp-content/uploads/2014/01/java-thread.jpg)

线程状态。线程可以处于以下状态之一：

- [`NEW`](../../java/lang/Thread.State.html#NEW)  
  尚未启动的线程处于此状态。 
- [`RUNNABLE`](../../java/lang/Thread.State.html#RUNNABLE)  
  在Java虚拟机中执行的线程处于此状态。 
- [`BLOCKED`](../../java/lang/Thread.State.html#BLOCKED)  
  被阻塞等待监视器锁定的线程处于此状态。 
- [`WAITING`](../../java/lang/Thread.State.html#WAITING)  
  正在等待另一个线程执行特定动作的线程处于此状态。 
- [`TIMED_WAITING`](../../java/lang/Thread.State.html#TIMED_WAITING)  
  正在等待另一个线程执行动作达到指定等待时间的线程处于此状态。 
- [`TERMINATED`](../../java/lang/Thread.State.html#TERMINATED)  
  已退出的线程处于此状态。 

一个线程可以在给定时间点处于一个状态。 这些状态是不反映任何操作系统线程状态的虚拟机状态。 

## 2. 线程与进程

* 线程：cup执行与调度的最小单位
* 进程：计算机资源分配的单位
* 联系：进程由一个或多个线程组成

## 3. 线程的实现方式

* 继承Thread类，重写run()方法

   ``

  ```java
  package com.lwf.ThreadLearn;
  
  /**
   * @author lwf
   * @title: SynTest
   * @projectName 10_19Code
   * @description: 同步锁资源
   * @date 2020/10/1916:44
   */
  public class SynTest extends Thread{
          private static  Tick ticks=new Tick();//锁资源
          public SynTest(String name, Tick ticks) {
              super(name);
              this.ticks=ticks;
          }
  
          public SynTest() {
              super();
          }
  
          public SynTest(String name) {
              super(name);
          }
  
          @Override
          public void run() {
              while (true){
                  synchronized (ticks) {//锁资源
                      if(ticks.num>0){
                          System.out.println(this.getName()+"买第"+ticks.num);
                           ticks.num--;
                      }
                      else
                          return;
                  }
                  try {
                      Thread.sleep(200);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          }
  
          public static void main(String[] args) {
              Tick ticks=new Tick();
              ticks.num=100;
              //抢票1
              SynTest ticks1=new SynTest("吴彦祖",ticks);
              SynTest ticks2=new SynTest("罗卫飞");
              SynTest ticks3=new SynTest("永日");
              ticks1.start();
              ticks2.start();
              ticks3.start();
          }
      }
  
  class Tick{
      int num=100;
  }
  ```

* 实现Runable接口，实现run（）方法

  ```
  package com.lwf.ThreadLearn;
  
  /**
   * @author lwf
   * @title: Rubbit
   * @projectName 10_19Code
   * @description: 龟兔赛跑
   * @date 2020/10/1911:10
   */
  public class Rubbit implements Runnable{
      public static void main(String[] args) {
          Rubbit rubbit=new Rubbit(10, 20);
          Rubbit rubbit1=new Rubbit(3, 5);
          Thread thread=new Thread(rubbit1,"乌龟");
          Thread thread1=new Thread(rubbit,"兔子");
          thread.start();
          thread1.start();
      }
      private int all=100;
      private int speed;
      private int had=0;
      private int sleep;
      private  static boolean fin=false;
      public Rubbit(int speed,int sleep) {
          this.speed = speed;
          this.sleep=sleep;
      }
  
      @Override
      public void run() {
          while (true){
              synchronized (Rubbit.class) {
                  if (fin) {
                      return;
                  }
              }
              had += speed;
              System.out.println(Thread.currentThread().getName() + "跑了"+had+"还剩"+(all-had));
              synchronized (Rubbit.class) {
                  if (had >= all) {
                      System.out.println(Thread.currentThread().getName() + "赢了");
                      fin = true;
                  }
              }
              try {
                  Thread.sleep(sleep);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
  
          }
      }
  }
  
  ```

  

* 实现Callable接口，实现call（）方法

  ```java
  package com.lwf.homeWork;
  
  import java.util.concurrent.*;
  
  /**
   * @author lwf
   * @title: TestTwo
   * @projectName 10_19Code      同时实现Runable,CallAble接口，分别实现以下操作
   * @description: 2. 通过2个线程实现 案例:
   * 	一个线程计算1~10000之间所有素数的和
   * 	一个线程计算10000~20000之间所有素数的个数
   * 	最终打印结果
   *
   * @date 2020/10/1919:22
   */
  public class TestTwo implements Runnable, Callable {
      public static void main(String[] args) throws ExecutionException, InterruptedException {
          TestTwo testTwo = new TestTwo();
          ExecutorService pool= Executors.newFixedThreadPool(2);
          pool.submit((Runnable) testTwo);
          Future future= pool.submit((Callable<Object>) testTwo);
          pool.shutdown();
          System.out.println("素数个数"+future.get());
      }
      private int sum=5;//1~10000之间所有素数的和
      private int num=0;//10000~20000之间所有素数的个数
      public static boolean judge(int i){//素数判断
          boolean flag=true;
          for(int i1 = 2;i1<=Math.sqrt(i);i1++){
              if(i%i1==0){
                  return false;
              }
          }
          return flag;
      }
  
      /**
       * 1~10000之间所有素数的和
       */
      @Override
      public void run() {
          for (int i=4;i<10000;i++){
              if(judge(i)){
                  sum+=i;
              }
          }
          System.out.println("和："+sum);
      }
  
      /**
       * 10000~20000之间所有素数的个数
       * @return
       * @throws Exception
       */
      @Override
      public Object call() throws Exception {
         for(int i=10000;i<=20000;i++){
             if (judge(i)){
                 num++;
             }
         }
          return num;
      }
  }
  
  ```

  

* 区别：

  > 实现Thread ：因为类的单继承多实现机制，这种方法灵活性较差
  >
  > 实现Runable接口：这种方法，灵活性好，但是run方法不可抛出异常，这是我个人实现多线程最喜欢的方式
  >
  > 实现Callable接口：这种方法灵活好，run方法可抛出异常，并且有返回值，写的时候不用抛出异常·，一般用于线程池

  ## 4. 线程优先

  每一个 Java 线程都有一个优先级，这样有助于操作系统确定线程的调度顺序。

  Java 线程的优先级是一个整数，其取值范围是 1 （Thread.MIN_PRIORITY ） - 10 （Thread.MAX_PRIORITY ）。

  默认情况下，每一个线程都会分配一个优先级 NORM_PRIORITY（5）。

  具有较高优先级的线程对程序更重要，并且应该在低优先级的线程之前分配处理器资源。但是，线程优先级不能保证线程执行的顺序，而且非常依赖于平台。

  ## 5.线程方法

  | **序号** |                         **方法描述**                         |
  | -------- | :----------------------------------------------------------: |
  | 1        | **public void start()**  			使该线程开始执行；**Java** 虚拟机调用该线程的 run 方法。 |
  | 2        | **public void run()**  			如果该线程是使用独立的 Runnable 运行对象构造的，则调用该 Runnable 对象的 run 方法；否则，该方法不执行任何操作并返回。 |
  | 3        | **public final void setName(String name)**  			改变线程名称，使之与参数 name 相同。 |
  | 4        | **public final void setPriority(int priority)**  			 更改线程的优先级。 |
  | 5        | **public final void setDaemon(boolean on)**  			将该线程标记为守护线程或用户线程。 |
  | 6        | **public final void join(long millisec)**  			等待该线程终止的时间最长为 millis 毫秒。 |
  | 7        |     **public void interrupt()**  			中断线程。      |
  | 8        | **public final boolean isAlive()**  			测试线程是否处于活动状态。 |

  测试线程是否处于活动状态。 上述方法是被Thread对象调用的。下面的方法是Thread类的静态方法。

  | **序号** |                         **方法描述**                         |
  | -------- | :----------------------------------------------------------: |
  | 1        | **public static void yield()**  			暂停当前正在执行的线程对象，并执行其他线程。 |
  | 2        | **public static void sleep(long millisec)**  			在指定的毫秒数内让当前正在执行的线程休眠（暂停执行），此操作受到系统计时器和调度程序精度和准确性的影响。 |
  | 3        | **public static boolean holdsLock(Object x)**  			当且仅当当前线程在指定的对象上保持监视器锁时，才返回 true。 |
  | 4        | **public static Thread currentThread()**  			返回对当前正在执行的线程对象的引用。 |
  | 5        | **public static void dumpStack()**  			将当前线程的堆栈跟踪打印至标准错误流。 |

## 6.同步(数据一致性保障)

* synchronized

  > 同步代码块
  >
  > 同步class
  >
  > 同步对象
  >
  > 同步方法

* volitite

  > jvm轻量级数据一致保障

* ReenTransLock

  >  lock（）和unlock（）方法对代码的访问实现同步

  

