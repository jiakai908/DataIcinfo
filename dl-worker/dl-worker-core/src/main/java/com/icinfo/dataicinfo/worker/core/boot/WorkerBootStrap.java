package com.icinfo.dataicinfo.worker.core.boot;

import com.icinfo.dataicinfo.biz.com.icinfo.dataicinfo.biz.service.SysPropertiesService;
import com.icinfo.dataicinfo.biz.com.icinfo.dataicinfo.biz.service.WorkerService;
import com.icinfo.dataicinfo.biz.utils.DataLinkFactory;
import com.icinfo.dataicinfo.common.errors.DatalinkException;
import com.icinfo.dataicinfo.common.utils.IPUtils;
import com.icinfo.dataicinfo.domain.worker.WorkerInfo;
import com.icinfo.dataicinfo.worker.core.runtime.WorkerConfig;
import org.apache.commons.lang.StringUtils;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.common.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年12月19
 */
public class WorkerBootStrap {
    private static final Logger logger = LoggerFactory.getLogger(WorkerBootStrap.class);
    private static final String CLASSPATH_URL_PREFIX = "classpath:";

    public void boot(String[] args) {
        try {
            // boot spring
            final ApplicationContextBootStrap appContextBootStrap = new ApplicationContextBootStrap("worker/spring/datalink-worker.xml");
            appContextBootStrap.boot();

            //initial WorkerConfig
            Map<String, String> workerProps;

            if (args.length > 0) {
                String workerPropsFile = args[0];
                workerProps = !workerPropsFile.isEmpty() ?
                        Utils.propsToStringMap(Utils.loadProps(workerPropsFile)) : Collections.<String, String>emptyMap();
            } else {
                workerProps = Utils.propsToStringMap(buildWorkerProps());
            }
        } catch (Throwable e) {
            logger.error("## Something goes wrong when starting up the datalink worker:", e);
            System.exit(1);
        }

    }

    public static void main(String[] args) {
        WorkerBootStrap workerBootStrap = new WorkerBootStrap();
        workerBootStrap.boot(args);
    }

    private Properties buildWorkerProps() throws IOException {
        Properties properties = new Properties();
        String conf = System.getProperty("worker.conf");
        if (!StringUtils.isEmpty(conf)) {
            if (conf.startsWith(CLASSPATH_URL_PREFIX)) {
                conf = StringUtils.substringAfter(conf, CLASSPATH_URL_PREFIX);
                properties.load(WorkerBootStrap.class.getClassLoader().getResourceAsStream(conf));
            } else {
                properties.load(new FileInputStream(conf));
            }
        }

        WorkerInfo workerInfo;
        WorkerService service = DataLinkFactory.getObject(WorkerService.class);
        String clientId = properties.getProperty(CommonClientConfigs.CLIENT_ID_CONFIG);
        if (!StringUtils.isBlank(clientId)) {
            workerInfo = service.getById(Long.valueOf(clientId));
        } else {
            workerInfo = service.getByAddress(IPUtils.getHostIp());
        }

        if (workerInfo != null) {
            properties.setProperty(WorkerConfig.GROUP_ID_CONFIG, String.valueOf(workerInfo.getGroupId()));
            properties.setProperty(WorkerConfig.REST_PORT_CONFIG, workerInfo.getRestPort().toString());
            if (StringUtils.isBlank(clientId)) {
                properties.setProperty(CommonClientConfigs.CLIENT_ID_CONFIG, String.valueOf(workerInfo.getId()));
            }
        } else {
            throw new DatalinkException(String.format("Worker is not found for client id [%s] or ip [%s] ", clientId, IPUtils.getHostIp()));
        }

        //ddl_sync、sync_auto_addcolumn参数从数据库中读取
        SysPropertiesService propertiesService = DataLinkFactory.getObject(SysPropertiesService.class);
        Map<String,String> map = propertiesService.map();
        properties.setProperty(WorkerConfig.DDL_SYNC_CONFIG,StringUtils.isNotBlank((map.get(WorkerConfig.DDL_SYNC_CONFIG))) ? map.get(WorkerConfig.DDL_SYNC_CONFIG) : String.valueOf(WorkerConfig.DDL_SYNC_DEFAULT));
        properties.setProperty(WorkerConfig.SYNC_AUTO_ADD_COLUMN_CONFIG,StringUtils.isNotBlank((map.get(WorkerConfig.SYNC_AUTO_ADD_COLUMN_CONFIG))) ? map.get(WorkerConfig.SYNC_AUTO_ADD_COLUMN_CONFIG) : String.valueOf(WorkerConfig.SYNC_AUTO_ADD_COLUMN_DEFAULT));
        return properties;
    }

}
