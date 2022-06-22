package com.dbic.threadtest;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

	
	//我们知道线程池就是线程的集合，线程池集中管理线程，以实现线程的重用，降低资源消耗，提高响应速度等。
	//线程用于执行异步任务，单个的线程既是工作单元也是执行机制，
	//从JDK1.5开始，为了把工作单元与执行机制分离开，
	//Executor框架诞生了，他是一个用于统一创建与运行的接口。Executor框架实现的就是线程池的功能。
	
	//Executor框架包括3大部分：
	//(1)任务。也就是工作单元，包括被执行任务需要实现的接口：Runnable接口或者Callable接口；
	//(2)任务的执行。也就是把任务分派给多个线程的执行机制，包括Executor接口及继承自Executor接口的ExecutorService接口。
	//(3)异步计算的结果。包括Future接口及实现了Future接口的FutureTask类。
	
	//                                               Executor接口
	//				ExecutorService接口继承Executor                                               DefaultExecutor实现Executor 
	//	ScheduledExecutorService接口继承ExecutorService   AbstractExecutorService实现 ExecutorService    
	//												ThreadPoolExecutor,ForkJoinPool 继承AbstractExecutorService
	//ScheduledThreadPoolExecutor 实现ScheduledExecutorService ，继承ThreadPoolExecutor
	
	//从上面的继承关系，实现关系可以看出来
	//它包含了三个executor接口：

	//Executor:运行新任务的简单接口
	//ExecutorService：扩展了Executor，添加了用来管理执行器生命周期和任务生命周期的方法
	//ScheduleExcutorService：扩展了ExecutorService，支持Future和定期执行任务
	
	//核心类     threadpoolexecutor
	//ThreadPoolExecutor一共有七个参数，这七个参数配合起来，构成了线程池强大的功能。
	//corePoolSize：核心线程数量
	
	//maximumPoolSize：线程最大线程数
	
	//workQueue：阻塞队列，存储等待执行的任务，很重要，会对线程池运行过程产生重大影响
	//当我们提交一个新的任务到线程池，线程池会根据当前池中正在运行的线程数量来决定该任务的处理方式。处理方式有三种：
	//1、直接切换（SynchronusQueue）
	//2、无界队列（LinkedBlockingQueue）能够创建的最大线程数为corePoolSize,这时maximumPoolSize就不会起作用了。
	//当线程池中所有的核心线程都是运行状态的时候，新的任务提交就会放入等待队列中。
	//3、有界队列（ArrayBlockingQueue）最大maximumPoolSize，能够降低资源消耗，但是这种方式使得线程池对线程调度变的更困难。
	//因为线程池与队列容量都是有限的。所以想让线程池的吞吐率和处理任务达到一个合理的范围，又想使我们的线程调度相对简单，并且还尽可能降低资源的消耗，我们就需要合理的限制这两个数量
	//分配技巧： [如果想降低资源的消耗包括降低cpu使用率、操作系统资源的消耗、上下文切换的开销等等，
	//可以设置一个较大的队列容量和较小的线程池容量，这样会降低线程池的吞吐量。
	//如果我们提交的任务经常发生阻塞，我们可以调整maximumPoolSize。
	//如果我们的队列容量较小，我们需要把线程池大小设置的大一些，这样cpu的使用率相对来说会高一些。
	//但是如果线程池的容量设置的过大，提高任务的数量过多的时候，并发量会增加，那么线程之间的调度就是一个需要考虑的问题。
	//这样反而可能会降低处理任务的吞吐量。]
	
	//keepAliveTime：线程没有任务执行时最多保持多久时间终止
	//（当线程中的线程数量大于corePoolSize的时候，如果这时没有新的任务提交核心线程外的线程不会立即销毁，而是等待，直到超过keepAliveTime）
	
	//unit：keepAliveTime的时间单位
	
	//threadFactory：线程工厂，用来创建线程，有一个默认的工场来创建线程，这样新创建出来的线程有相同的优先级，是非守护线程、设置好了名称）

	//rejectHandler：当拒绝处理任务时(阻塞队列满)的策略
	//（AbortPolicy默认策略直接抛出异常、CallerRunsPolicy用调用者所在的线程执行任务、DiscardOldestPolicy丢弃队列中最靠前的任务并执行当前任务、DiscardPolicy直接丢弃当前任务）
	
	//corePoolSize、maximumPoolSize、workQueue 三者关系：
	//如果运行的线程数小于corePoolSize的时候，直接创建新线程来处理任务。即使线程池中的其他线程是空闲的。
	//如果运行中的线程数大于corePoolSize且小于maximumPoolSize时，那么只有当workQueue满的时候才创建新的线程去处理任务。
	//如果corePoolSize与maximumPoolSize是相同的，那么创建的线程池大小是固定的。这时有新任务提交，当workQueue未满时，就把请求放入workQueue中。等待空线程从workQueue取出任务。
	//如果workQueue此时也满了，那么就使用另外的拒绝策略参数去执行拒绝策略。
	
	//重要的方法
	//execute();	//提交任务，交给线程池执行	
	//submit();//提交任务，能够返回执行结果 execute+Future
	//shutdown();//关闭线程池，等待任务都执行完
	//shutdownNow();//关闭线程池，不等待任务执行完
	//getTaskCount();//线程池已执行和未执行的任务总数
	//getCompleteTaskCount();//已完成的任务数量
	//getPoolSize();//线程池当前的线程数量
	//getActiveCount();//当前线程池中正在执行任务的线程数量
	
	//线程池生命周期
	//running：能接受新提交的任务，也能处理阻塞队列中的任务
	//shutdown：不能处理新的任务，但是能继续处理阻塞队列中任务
	//stop：不能接收新的任务，也不处理队列中的任务
	//tidying：如果所有的任务都已经终止了，这时有效线程数为0
	//terminated：最终状态
	
	//创建线程池
	//Executors.newCachedThreadPool
	
	public static void main(String[] args)
	throws Exception{
		ExecutorService service = Executors.newCachedThreadPool();
		 //return new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
		//int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue
		//看源码  它是调了new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());这个构造函数
		//newCachedThreadPool是一个根据需要创建新线程的线程池，当一个任务提交时，
		//corePoolSize为0不创建核心线程，SynchronousQueue是一个不存储元素的队列，可以理解为队里永远是满的，因此最终会创建非核心线程来执行任务。
		//对于非核心线程空闲60s时将被回收。因为Integer.MAX_VALUE非常大，可以认为是可以无限创建线程的，在资源有限的情况下容易引起OOM异常
		
		ExecutorService service2 = Executors.newSingleThreadExecutor();
		//return new FinalizableDelegatedExecutorService (new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()));
		//newSingleThreadExecutor是单线程线程池，只有一个核心线程，用唯一的一个共用线程执行任务，保证所有任务按指定顺序执行
		//当一个任务提交时，首先会创建一个核心线程来执行任务，如果超过核心线程的数量，将会放入队列中，
		//因为LinkedBlockingQueue是长度为Integer.MAX_VALUE的队列，可以认为是无界队列，因此往队列中可以插入无限多的任务，在资源有限的时候容易引起OOM异常，
		//同时因为无界队列，maximumPoolSize和keepAliveTime参数将无效，压根就不会创建非核心线程。
		
		ExecutorService service3 = Executors.newFixedThreadPool(3);
		 //return new ThreadPoolExecutor(nThreads, nThreads,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
		//定长线程池，核心线程数和最大线程数由用户传入，可以设置线程的最大并发数，超出在队列等待
		//newFixedThreadPool和SingleThreadExecutor类似，唯一的区别就是核心线程数不同，并且由于使用的是LinkedBlockingQueue，在资源有限的时候容易引起OOM异常。
		
		ExecutorService service4 = Executors.newScheduledThreadPool(3);
		//return new ScheduledThreadPoolExecutor(corePoolSize);  ScheduledThreadPoolExecutor实现ThreadPoolExecutor
		// super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS, new DelayedWorkQueue());
		//定长线程池，核心线程数由用户传入，支持定时和周期任务执行
		//当一个任务提交时，corePoolSize为自定义输入，首先创建核心线程，核心线程满了之后，因此最终会创建非核心线程来执行任务。
		//非核心线程使用后将被回收。因为Integer.MAX_VALUE非常大，可以认为是可以无限创建线程的，在资源有限的情况下容易引起OOM异常。
		//因为使用的DelayedWorkQueue可以实现定时和周期任务。
		//ScheduledExecutorService提供了三种方法可以使用：
		//schedule：延迟后执行任务
		//scheduleAtFixedRate：以指定的速率执行任务
		//scheduleWithFixedDelay：以指定的延迟执行任务
		
		//总结 FixedThreadPool和SingleThreadExecutor 允许的请求队列长度为Integer.MAX_VALUE，可能会堆积大量的请求，从而引起OOM异常
		//CachedThreadPool 和newScheduledThreadPool允许创建的线程数为Integer.MAX_VALUE，可能会创建大量的线程，从而引起OOM异常
		//这就是为什么禁止使用Executors去创建线程池，而是推荐自己去创建ThreadPoolExecutor的原因
		
		//如何定义线程池参数
		//CPU密集型 ： 线程池的大小推荐为CPU数量 + 1，CPU数量可以根据Runtime.availableProcessors方法获取
		//IO密集型 ： CPU数量 * CPU利用率 * (1 + 线程等待时间/线程CPU时间)
		//混合型 ： 将任务分为CPU密集型和IO密集型，然后分别使用不同的线程池去处理，从而使每个线程池可以根据各自的工作负载来调整
		//阻塞队列 ： 推荐使用有界队列，有界队列有助于避免资源耗尽的情况发生
		//拒绝策略 ： 默认采用的是AbortPolicy拒绝策略，直接在程序中抛出RejectedExecutionException异常【因为是运行时异常，不强制catch】，这种处理方式不够优雅。处理拒绝策略有以下几种比较推荐：

		//在程序中捕获RejectedExecutionException异常，在捕获异常中对任务进行处理。
		//针对默认拒绝策略使用CallerRunsPolicy拒绝策略，该策略会将任务交给调用execute的线程执行【一般为主线程】，
		//此时主线程将在一段时间内不能提交任何任务，从而使工作线程处理正在执行的任务。
		//此时提交的线程将被保存在TCP队列中，TCP队列满将会影响客户端，这是一种平缓的性能降低
		//自定义拒绝策略，只需要实现RejectedExecutionHandler接口即可
		//如果任务不是特别重要，使用DiscardPolicy和DiscardOldestPolicy拒绝策略将任务丢弃也是可以的
		//如果使用Executors的静态方法创建ThreadPoolExecutor对象，可以通过使用Semaphore对任务的执行进行限流也可以避免出现OOM异常
		
		ExecutorService service5 = Executors.newWorkStealingPool(20);
		//看过源码的同学都知道之前的线程池都是通过 ThreadPoolExecutor 创建出来的。
		//而创建参数中有一个队列参数用于存放任务。而这些队列的长度都是Integer的最大值。
		//这就导致在实际应用中会造成内存溢出情况。这也是为什么阿里巴巴 java 手册不允许使用 Executors 创建线程池的原因。
		//而 1.8中新增的线程池是基于ForkJoinPool 的扩展.算法思想就是窃取算法。
		//大概的意思就是将任务按照工作线程均分。然后先工作完的线程去帮助没处理完的线程工作。以实现最快完成工作。
		//（大概就是这个意思了）所以它适合处理很耗时的线程。而具体实现跟之前的线程池没啥太大区别

		
		
	}
	
	
}	
