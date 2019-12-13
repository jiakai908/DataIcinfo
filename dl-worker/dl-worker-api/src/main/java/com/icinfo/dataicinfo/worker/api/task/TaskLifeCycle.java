package com.icinfo.dataicinfo.worker.api.task;

import com.ucar.datalink.common.errors.DatalinkException;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月13
 */
public abstract class TaskLifeCycle {
    private volatile boolean running = false;

    public boolean isRunning() {
        return this.running;
    }

    public void start(){
        if (this.running){
            throw new DatalinkException(this.getClass().getName() + " has startup , don\'t repeat start");
        }else {
            this.running = true;
        }
    }

    public void stop(){
        if (!this.running){
            throw new DatalinkException(this.getClass().getName() + " isn\'t start , please check");
        }else {
            this.running = false;
        }
    }
}
