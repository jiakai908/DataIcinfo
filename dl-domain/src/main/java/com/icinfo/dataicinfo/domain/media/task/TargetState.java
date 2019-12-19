package com.icinfo.dataicinfo.domain.media.task;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月17
 */
public enum TargetState {
    STARTED,
    PAUSED;

    public static List<TargetState> getAllStates() {
        return Lists.newArrayList(PAUSED, STARTED);
    }
}
