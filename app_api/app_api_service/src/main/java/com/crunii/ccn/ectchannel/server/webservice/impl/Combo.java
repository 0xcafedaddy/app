
package com.crunii.ccn.ectchannel.server.webservice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>combo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="combo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="comboAdviceLs" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}combo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="comboAlias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comboBaseInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comboCate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comboChildLs" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}combo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="comboDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comboDetail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comboId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comboImage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comboName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comboPay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comboPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comboRevise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comboSort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comboSubtitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dgContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isHot" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isRestrict" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="orderTplId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rechargeAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="restrictNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="restrictSurpNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="timeEnd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="timeStart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "combo", propOrder = {
    "comboAdviceLs",
    "comboAlias",
    "comboBaseInfo",
    "comboCate",
    "comboChildLs",
    "comboDesc",
    "comboDetail",
    "comboId",
    "comboImage",
    "comboName",
    "comboPay",
    "comboPrice",
    "comboRevise",
    "comboSort",
    "comboSubtitle",
    "dgContent",
    "isHot",
    "isRestrict",
    "isTime",
    "orderTplId",
    "rechargeAccount",
    "restrictNum",
    "restrictSurpNum",
    "timeEnd",
    "timeStart"
})
public class Combo {

    @XmlElement(nillable = true)
    protected List<Combo> comboAdviceLs;
    protected String comboAlias;
    protected String comboBaseInfo;
    protected String comboCate;
    @XmlElement(nillable = true)
    protected List<Combo> comboChildLs;
    protected String comboDesc;
    protected String comboDetail;
    protected String comboId;
    protected String comboImage;
    protected String comboName;
    protected String comboPay;
    protected String comboPrice;
    protected String comboRevise;
    protected String comboSort;
    protected String comboSubtitle;
    protected String dgContent;
    protected String isHot;
    protected String isRestrict;
    protected String isTime;
    protected String orderTplId;
    protected String rechargeAccount;
    protected String restrictNum;
    protected String restrictSurpNum;
    protected String timeEnd;
    protected String timeStart;

    /**
     * Gets the value of the comboAdviceLs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comboAdviceLs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComboAdviceLs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Combo }
     * 
     * 
     */
    public List<Combo> getComboAdviceLs() {
        if (comboAdviceLs == null) {
            comboAdviceLs = new ArrayList<Combo>();
        }
        return this.comboAdviceLs;
    }

    /**
     * 获取comboAlias属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComboAlias() {
        return comboAlias;
    }

    /**
     * 设置comboAlias属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComboAlias(String value) {
        this.comboAlias = value;
    }

    /**
     * 获取comboBaseInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComboBaseInfo() {
        return comboBaseInfo;
    }

    /**
     * 设置comboBaseInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComboBaseInfo(String value) {
        this.comboBaseInfo = value;
    }

    /**
     * 获取comboCate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComboCate() {
        return comboCate;
    }

    /**
     * 设置comboCate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComboCate(String value) {
        this.comboCate = value;
    }

    /**
     * Gets the value of the comboChildLs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comboChildLs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComboChildLs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Combo }
     * 
     * 
     */
    public List<Combo> getComboChildLs() {
        if (comboChildLs == null) {
            comboChildLs = new ArrayList<Combo>();
        }
        return this.comboChildLs;
    }

    /**
     * 获取comboDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComboDesc() {
        return comboDesc;
    }

    /**
     * 设置comboDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComboDesc(String value) {
        this.comboDesc = value;
    }

    /**
     * 获取comboDetail属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComboDetail() {
        return comboDetail;
    }

    /**
     * 设置comboDetail属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComboDetail(String value) {
        this.comboDetail = value;
    }

    /**
     * 获取comboId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComboId() {
        return comboId;
    }

    /**
     * 设置comboId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComboId(String value) {
        this.comboId = value;
    }

    /**
     * 获取comboImage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComboImage() {
        return comboImage;
    }

    /**
     * 设置comboImage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComboImage(String value) {
        this.comboImage = value;
    }

    /**
     * 获取comboName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComboName() {
        return comboName;
    }

    /**
     * 设置comboName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComboName(String value) {
        this.comboName = value;
    }

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
     * 获取comboSort属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComboSort() {
        return comboSort;
    }

    /**
     * 设置comboSort属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComboSort(String value) {
        this.comboSort = value;
    }

    /**
     * 获取comboSubtitle属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComboSubtitle() {
        return comboSubtitle;
    }

    /**
     * 设置comboSubtitle属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComboSubtitle(String value) {
        this.comboSubtitle = value;
    }

    /**
     * 获取dgContent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDgContent() {
        return dgContent;
    }

    /**
     * 设置dgContent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDgContent(String value) {
        this.dgContent = value;
    }

    /**
     * 获取isHot属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsHot() {
        return isHot;
    }

    /**
     * 设置isHot属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsHot(String value) {
        this.isHot = value;
    }

    /**
     * 获取isRestrict属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsRestrict() {
        return isRestrict;
    }

    /**
     * 设置isRestrict属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsRestrict(String value) {
        this.isRestrict = value;
    }

    /**
     * 获取isTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsTime() {
        return isTime;
    }

    /**
     * 设置isTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsTime(String value) {
        this.isTime = value;
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

    /**
     * 获取restrictNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRestrictNum() {
        return restrictNum;
    }

    /**
     * 设置restrictNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRestrictNum(String value) {
        this.restrictNum = value;
    }

    /**
     * 获取restrictSurpNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRestrictSurpNum() {
        return restrictSurpNum;
    }

    /**
     * 设置restrictSurpNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRestrictSurpNum(String value) {
        this.restrictSurpNum = value;
    }

    /**
     * 获取timeEnd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeEnd() {
        return timeEnd;
    }

    /**
     * 设置timeEnd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeEnd(String value) {
        this.timeEnd = value;
    }

    /**
     * 获取timeStart属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeStart() {
        return timeStart;
    }

    /**
     * 设置timeStart属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeStart(String value) {
        this.timeStart = value;
    }

}
