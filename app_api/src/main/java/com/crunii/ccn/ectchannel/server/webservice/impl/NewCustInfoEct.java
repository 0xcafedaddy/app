
package com.crunii.ccn.ectchannel.server.webservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>newCustInfoEct complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="newCustInfoEct"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}returnData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="custInfo" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}newCustInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "newCustInfoEct", propOrder = {
    "custInfo"
})
public class NewCustInfoEct
    extends ReturnData
{

    protected NewCustInfo custInfo;

    /**
     * 获取custInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link NewCustInfo }
     *     
     */
    public NewCustInfo getCustInfo() {
        return custInfo;
    }

    /**
     * 设置custInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link NewCustInfo }
     *     
     */
    public void setCustInfo(NewCustInfo value) {
        this.custInfo = value;
    }

}
