package com.icinfo.dataicinfo.worker.api.util.statistic;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月16
 */
public class BaseWriterStatistic  extends  Statistic{
    private long timeForTotalPush;

    public void setTimeForTotalPush(long timeForTotalPush) {
        this.timeForTotalPush = timeForTotalPush;
    }

    public long getTimeForTotalPush() {
        return timeForTotalPush;
    }
}
