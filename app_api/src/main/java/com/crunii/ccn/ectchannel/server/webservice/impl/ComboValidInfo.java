
package com.crunii.ccn.ectchannel.server.webservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>comboValidInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="comboValidInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}returnData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="comboPay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comboPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comboRevise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comboUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="intfSeq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="orderDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="orderTplId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rechargeAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "comboValidInfo", propOrder = {
    "comboPay",
    "comboPrice",
    "comboRevise",
    "comboUnit",
    "intfSeq",
    "orderDesc",
    "orderTplId",
    "rechargeAccount"
})
public class ComboValidInfo
    extends ReturnData
{

    protected String comboPay;
    protected String comboPrice;
    protected String comboRevise;
    protected String comboUnit;
    protected String intfSeq;
    protected String orderDesc;
    protected String orderTplId;
    protected String rechargeAccount;

    /**
     * 获取comboPay属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComboPay() {
        return comboPay;
    }

    /**
     * 设置comboPay属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComboPay(String value) {
        this.comboPay = value;
    }

    /**
     * 获取comboPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComboPrice() {
        return comboPrice;
    }

    /**
     * 设置comboPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComboPrice(String value) {
        this.comboPrice = value;
    }

    /**
     * 获取comboRevise属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComboRevise() {
        return comboRevise;
    }

    /**
     * 设置comboRevise属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComboRevise(String value) {
        this.comboRevise = value;
    }

    /**
     * 获取comboUnit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComboUnit() {
        return comboUnit;
    }

    /**
     * 设置comboUnit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComboUnit(String value) {
        this.comboUnit = value;
    }

    /**
     * 获取intfSeq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntfSeq() {
        return intfSeq;
    }

    /**
     * 设置intfSeq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntfSeq(String value) {
        this.intfSeq = value;
    }

    /**
     * 获取orderDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderDesc() {
        return orderDesc;
    }

    /**
     * 设置orderDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderDesc(String value) {
        this.orderDesc = value;
    }

    /**
     * 获取orderTplId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderTplId() {
        return orderTplId;
    }

    /**
     * 设置orderTplId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderTplId(String value) {
        this.orderTplId = value;
    }

    /**
     * 获取rechargeAccount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRechargeAccount() {
        return rechargeAccount;
    }

    /**
     * 设置rechargeAccount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRechargeAccount(String value) {
        this.rechargeAccount = value;
    }

}
