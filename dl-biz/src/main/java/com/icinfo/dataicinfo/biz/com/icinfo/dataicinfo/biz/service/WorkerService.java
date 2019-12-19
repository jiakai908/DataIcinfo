package com.icinfo.dataicinfo.biz.com.icinfo.dataicinfo.biz.service;

import com.icinfo.dataicinfo.domain.worker.WorkerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月19
 */
public interface WorkerService {
    List<WorkerInfo> getList();

    Boolean insert(WorkerInfo workerInfo);

    Boolean update(WorkerInfo workerInfo);

    Boolean delete(Long id);

    WorkerInfo getById(Long id);

    WorkerInfo getByAddress(String ip);

    Integer workerCount();

//    List<StatisDetail> getCountByGroup();

    List<WorkerInfo> getListForQuery(@Param("groupId")Long groupId);
}
