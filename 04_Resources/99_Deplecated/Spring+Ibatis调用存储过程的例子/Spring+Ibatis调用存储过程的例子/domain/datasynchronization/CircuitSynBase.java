/*
 * DataSynBase.java
 * <p>Title:��ͻ�ҵ������ʵʱ����ϵͳ</p>
 * <p>Description:����ͬ��</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2007</p>
 * <p>Company:������ʿͨ��Ϣ������޹�˾</p>
 *  @author $Author: lindsh $
 * @version $Revision: 1.2 $
 * @since $Date: 2007/06/20 06:21:59 $
 *
 */

package com.ffcs.util.domain.datasynchronization;

/**
 * ����ͬ�����ݲ�����
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
