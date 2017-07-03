
package com.crunii.ccn.ectchannel.server.webservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>payFeeResultExtend complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="payFeeResultExtend"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}payFeeResult"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="activeInfo" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}activeInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payFeeResultExtend", propOrder = {
    "activeInfo"
})
public class PayFeeResultExtend
    extends PayFeeResult
{

    protected ActiveInfo activeInfo;

    /**
     * 获取activeInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveInfo }
     *     
     */
    public ActiveInfo getActiveInfo() {
        return activeInfo;
    }

    /**
     * 设置activeInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveInfo }
     *     
     */
    public void setActiveInfo(ActiveInfo value) {
        this.activeInfo = value;
    }

}
