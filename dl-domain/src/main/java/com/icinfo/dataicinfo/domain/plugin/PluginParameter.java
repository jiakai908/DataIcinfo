package com.icinfo.dataicinfo.domain.plugin;

import com.icinfo.dataicinfo.domain.Parameter;
import com.icinfo.dataicinfo.domain.media.MediaSourceType;

import java.util.Set;

/**
 * 描述:  插件参数基础类<br>
 *
 * @author jkk
 * @date 2019年12月13
 */
public abstract class PluginParameter extends Parameter {
    private final String pluginName;
    private final String pluginClass;
    private final String pluginListenerClass;
    private final Set<MediaSourceType> supportedSourceTypes;
    private boolean perfStatistic;//是否开启性能统计,默认false

    public PluginParameter() {
        this.pluginName = initPluginName();
        this.pluginClass = initPluginClass();
        this.pluginListenerClass = initPluginListenerClass();
        this.supportedSourceTypes = initSupportedSourceTypes();
    }

    public abstract String initPluginName();

    public abstract String initPluginClass();

    public abstract String initPluginListenerClass();

    public abstract Set<MediaSourceType> initSupportedSourceTypes();

    public final String getPluginName() {
        return pluginName;
    }

    public final void setPluginName(String pluginName) {
        //do nothing,just for java bean standard
    }

    public String getPluginListenerClass() {
        return pluginListenerClass;
    }

    public final void setPluginListenerClass(String pluginListenerClass) {
        //do nothing ,just for java bean standard
    }

    public final Set<MediaSourceType> getSupportedSourceTypes() {
        return supportedSourceTypes;
    }

    public final void setSupportedSourceTypes() {
        //do nothing ,just for java bean standard
    }

    public boolean isPerfStatistic() {
        return perfStatistic;
    }

    public void setPerfStatistic(boolean perfStatistic) {
        this.perfStatistic = perfStatistic;
    }
}
