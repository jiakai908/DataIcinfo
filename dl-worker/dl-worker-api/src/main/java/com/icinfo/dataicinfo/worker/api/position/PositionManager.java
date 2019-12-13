package com.icinfo.dataicinfo.worker.api.position;

import com.icinfo.dataicinfo.domain.Position;

/**
 * 描述:  数据同步位点管理类，负责查询、更新消费位点.<br>
 * PositionManager是Datalink提供的一个公用位点管理组件，如果TaskReader有自己的位点管理机制，用自己的机制即可。
 * @author jkk
 * @date 2019年12月13
 */
public interface PositionManager {

    /**
     * 启动
     */
    void start();

    /**
     * 停止
     */
    void stop();

    /**
     * 是否已经启动
     *
     * @return
     */
    boolean isStart();

    /**
     * 更新消费位点到存储介质(定时更新)
     *
     * @param taskId
     * @param position
     */
    void updatePosition(String taskId, Position position);

    /**
     * 更新消费位点到存储介质(立即更新),调用该方法时需确保Task已经处于关闭状态，否则updatePositionNow和updatePosition会有并发问题
     *
     * @param taskId
     * @param position
     */
    void updatePositionNow(String taskId, Position position);

    /**
     * 获取当前消费到的位点,如果没有则返回null
     *
     * @param taskId
     * @return
     */
    <T extends Position> T getPosition(String taskId);
}
