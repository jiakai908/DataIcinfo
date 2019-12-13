package com.icinfo.dataicinfo.contract;

import java.io.Serializable;

/**
 * 描述:  <br>
 * Record Source Identifier.
 * <p>
 * Identify the Source of the Record,consist of two parts:namespace and name,
 * in different case they have different meanings.
 * <p>
 * e.g.
 * 1,in database case,namespace may means schema, name may means table-name.
 * 2,in file case ,namespace may meas directory,names may means file-name.
 * <p>
 *
 * @author jkk
 * @date 2019年12月13
 */
public class RSI implements Serializable {
    private String namespace;
    private String name;

    public RSI(String namespace, String name) {
        this.namespace = namespace;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        RSI rsi = (RSI) obj;
        if (!namespace.equals(rsi.namespace)) return false;
        return name.equals(rsi.name);
    }

    @Override
    public int hashCode() {
        int result = namespace.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getName() {
        return name;
    }
}
