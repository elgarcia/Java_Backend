package com.elias;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Crono {
	private LocalTime                   horaActual;
	private ScheduledExecutorService    scheduler;
	private boolean                     isUpdating = false;

	public void inicia() {
		if (!this.isUpdating){
			this.scheduler = Executors.newSingleThreadScheduledExecutor();
			scheduler.scheduleAtFixedRate(() -> {
				this.horaActual = LocalTime.now();
				}, 0, 100, TimeUnit.MILLISECONDS);
			this.isUpdating = true;
		}
	}
	public void para() {
		if (this.isUpdating){
			this.scheduler.shutdown();
			this.isUpdating = false;
			try{
				if (!this.scheduler.awaitTermination(1, TimeUnit.SECONDS)){
					this.scheduler.shutdownNow();
				}
			} catch (InterruptedException e){
				scheduler.shutdownNow();
			}
		}
	}
	public LocalTime getHoraActual() {
		return horaActual;
	}
}
