package com.astrolink.logic.listener;

import com.astrolink.system.pool.JobThreadListener;


public abstract class JobThread extends Thread {

	private Object key;
	private JobThreadListener listener;

	public void setKey(Object key) {
		this.key = key;
	}

	public Object getKey() {
		return this.key;
	}

	public void setListener(JobThreadListener listener) {
		this.listener = listener;
	}

	public JobThreadListener getListener() {
		return this.listener;
	}

	public abstract void exec();

	public void run() {

		exec();

		if (this.listener != null) {
			this.listener.jobFinished(this.key);
		}

	}

}
