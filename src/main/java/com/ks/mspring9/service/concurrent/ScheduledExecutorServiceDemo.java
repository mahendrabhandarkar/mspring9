package com.ks.mspring9.service.concurrent;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledExecutorServiceDemo {

	private Task runnableTask;
	private CallableTask callableTask;

	public static final Logger logger = LoggerFactory.getLogger(ScheduledExecutorServiceDemo.class);

	@Scheduled(initialDelay = 2000, fixedRate = 10000)
//	@Scheduled(cron = "0 * * * * MON-FRI")
//  @SchedulerLock(name = "TaskScheduler_scheduledTask", lockAtLeastFor = "PT5M", lockAtMostFor = "PT14M") -- ShedLock — a Java library
	public void execute() {
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		getTasksToRun().apply(executorService);
		executorService.shutdown();
	}

	public void executeWithMultiThread() {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
		getTasksToRun().apply(executorService);
		executorService.shutdown();
	}

	private Function<ScheduledExecutorService, Void> getTasksToRun()  {

		runnableTask = new Task();
		callableTask = new CallableTask();
		try {
			TimeUnit.SECONDS.sleep(2);
		}catch(InterruptedException ie) {
			logger.error("During Timeout exception gets generated:::" + ie);
		}

		logger.info("Task 1 Current Time:::" + LocalDateTime.now());
		return (executorService -> {
			Future<String> resultFuture = executorService.schedule(callableTask, 1, TimeUnit.SECONDS);
			executorService.scheduleAtFixedRate( runnableTask, 100, 450, TimeUnit.SECONDS);
			executorService.scheduleWithFixedDelay( runnableTask, 100, 150, TimeUnit.SECONDS);
			return null;
		});
	}

}