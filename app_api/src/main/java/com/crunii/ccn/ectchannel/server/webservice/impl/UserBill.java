
package com.crunii.ccn.ectchannel.server.webservice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>userBill complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="userBill"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acctId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="acctServiceItemFeeList" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}feeListItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billingCycleId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ppyAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="servId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userBill", propOrder = {
    "acctId",
    "acctServiceItemFeeList",
    "amount",
    "billAmount",
    "billId",
    "billingCycleId",
    "ppyAmount",
    "servId"
})
public class UserBill {

    protected String acctId;
    @XmlElement(nillable = true)
    protected List<FeeListItem> acctServiceItemFeeList;
    protected String amount;
    protected String billAmount;
    protected String billId;
    protected String billingCycleId;
    protected String ppyAmount;
    protected String servId;

    /**
     * 获取acctId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctId() {
        return acctId;
    }

    /**
     * 设置acctId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctId(String value) {
        this.acctId = value;
    }

    /**
     * Gets the value of the acctServiceItemFeeList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acctServiceItemFeeList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcctServiceItemFeeList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeeListItem }
     * 
     * 
     */
    public List<FeeListItem> getAcctServiceItemFeeList() {
        if (acctServiceItemFeeList == null) {
            acctServiceItemFeeList = new ArrayList<FeeListItem>();
        }
        return this.acctServiceItemFeeList;
    }

    /**
     * 获取amount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmount() {
        return amount;
    }

    /**
     * 设置amount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmount(String value) {
        this.amount = value;
    }

    /**
     * 获取billAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillAmount() {
        return billAmount;
    }

    /**
     * 设置billAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillAmount(String value) {
        this.billAmount = value;
    }

    /**
     * 获取billId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillId() {
        return billId;
    }

    /**
     * 设置billId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillId(String value) {
        this.billId = value;
    }

    /**
     * 获取billingCycleId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingCycleId() {
        return billingCycleId;
    }

    /**
     * 设置billingCycleId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingCycleId(String value) {
        this.billingCycleId = value;
    }

    /**
     * 获取ppyAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPpyAmount() {
        return ppyAmount;
    }

    /**
     * 设置ppyAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPpyAmount(String value) {
        this.ppyAmount = value;
    }

    /**
     * 获取servId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServId() {
        return servId;
    }

    /**
     * 设置servId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServId(String value) {
        this.servId = value;
    }

}
