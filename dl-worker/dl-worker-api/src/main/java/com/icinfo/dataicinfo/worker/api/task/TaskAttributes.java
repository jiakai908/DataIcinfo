package com.icinfo.dataicinfo.worker.api.task;

import java.util.Enumeration;

/**
 * 描述:  TaskAttributes和TaskContext的生命周期是一致的，主要用来支持Task整个生命周期内的数据共享，会话级的数据共享机制请参见TaskSession.<br>
 *
 * @author jkk
 * @date 2019年12月13
 */
public interface TaskAttributes {

    /**
     * Returns the object bound with the specified name in this context, or
     * <code>null</code> if no object is bound under the name.
     */
    <T> T getAttribute(String name);

    /**
     * Binds an object to this context, using the name specified.
     * If an object of the same name is already bound to the context,
     * the object is replaced.
     */
    void setAttribute(String name, Object value);

    /**
     * Removes the object bound with the specified name from
     * this context. If the context does not have an object
     * bound with the specified name, this method does nothing.
     */
    void removeAttribute(String name);

    /**
     * Returns an <code>Enumeration</code> of <code>String</code> objects
     * containing the names of all the objects bound to this context.
     */
    Enumeration<String> getAttributeNames();
}
