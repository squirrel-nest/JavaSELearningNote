/*
 * DataSynBase.java
 * <p>Title:大客户业务质量实时监视系统</p>
 * <p>Description:数据同步</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2007</p>
 * <p>Company:福建富士通信息软件有限公司</p>
 *  @author $Author: lindsh $
 * @version $Revision: 1.2 $
 * @since $Date: 2007/06/20 06:21:59 $
 *
 */

package com.ffcs.util.domain.datasynchronization;

/**
 * 数据同步传递参数类
 */
public class CircuitSynBase {
   private Integer id;
   private Integer property;
   private String output;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Integer getProperty() {
        return property;
    }

    public void setProperty(Integer property) {
        this.property = property;
    }


   
}
