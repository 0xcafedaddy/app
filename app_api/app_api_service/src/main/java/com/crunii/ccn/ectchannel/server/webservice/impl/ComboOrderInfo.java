
package com.crunii.ccn.ectchannel.server.webservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>comboOrderInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="comboOrderInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}returnData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="activeInfo" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}activeInfo" minOccurs="0"/&gt;
 *         &lt;element name="balance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="doneCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "comboOrderInfo", propOrder = {
    "activeInfo",
    "balance",
    "doneCode"
})
public class ComboOrderInfo
    extends ReturnData
{

    protected ActiveInfo activeInfo;
    protected String balance;
    protected String doneCode;

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

    /**
     * 获取balance属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalance() {
        return balance;
    }

    /**
     * 设置balance属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalance(String value) {
        this.balance = value;
    }

    /**
     * 获取doneCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoneCode() {
        return doneCode;
    }

    /**
     * 设置doneCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoneCode(String value) {
        this.doneCode = value;
    }

}
