
package com.crunii.ccn.ectchannel.server.webservice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>paymentQuery complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="paymentQuery"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acctBlcLogListItems" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}acctBlcLogListItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="acctId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="certifiedCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="certifiedType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="corpOrgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="invoiceFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="operatedPaymentSerialNbr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="operationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="orgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="payedMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="paymentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="relatedPaymentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="staffId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="staffName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paymentQuery", propOrder = {
    "acctBlcLogListItems",
    "acctId",
    "amount",
    "billAmount",
    "certifiedCode",
    "certifiedType",
    "corpOrgId",
    "invoiceFlag",
    "operatedPaymentSerialNbr",
    "operationType",
    "orgName",
    "payedMethod",
    "paymentDate",
    "paymentId",
    "paymentMethod",
    "relatedPaymentId",
    "remark",
    "staffId",
    "staffName"
})
public class PaymentQuery {

    @XmlElement(nillable = true)
    protected List<AcctBlcLogListItem> acctBlcLogListItems;
    protected String acctId;
    protected String amount;
    protected String billAmount;
    protected String certifiedCode;
    protected String certifiedType;
    protected String corpOrgId;
    protected String invoiceFlag;
    protected String operatedPaymentSerialNbr;
    protected String operationType;
    protected String orgName;
    protected String payedMethod;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar paymentDate;
    protected String paymentId;
    protected String paymentMethod;
    protected String relatedPaymentId;
    protected String remark;
    protected String staffId;
    protected String staffName;

    /**
     * Gets the value of the acctBlcLogListItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acctBlcLogListItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcctBlcLogListItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AcctBlcLogListItem }
     * 
     * 
     */
    public List<AcctBlcLogListItem> getAcctBlcLogListItems() {
        if (acctBlcLogListItems == null) {
            acctBlcLogListItems = new ArrayList<AcctBlcLogListItem>();
        }
        return this.acctBlcLogListItems;
    }

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
     * 获取certifiedCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertifiedCode() {
        return certifiedCode;
    }

    /**
     * 设置certifiedCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertifiedCode(String value) {
        this.certifiedCode = value;
    }

    /**
     * 获取certifiedType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertifiedType() {
        return certifiedType;
    }

    /**
     * 设置certifiedType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertifiedType(String value) {
        this.certifiedType = value;
    }

    /**
     * 获取corpOrgId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorpOrgId() {
        return corpOrgId;
    }

    /**
     * 设置corpOrgId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorpOrgId(String value) {
        this.corpOrgId = value;
    }

    /**
     * 获取invoiceFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceFlag() {
        return invoiceFlag;
    }

    /**
     * 设置invoiceFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceFlag(String value) {
        this.invoiceFlag = value;
    }

    /**
     * 获取operatedPaymentSerialNbr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatedPaymentSerialNbr() {
        return operatedPaymentSerialNbr;
    }

    /**
     * 设置operatedPaymentSerialNbr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatedPaymentSerialNbr(String value) {
        this.operatedPaymentSerialNbr = value;
    }

    /**
     * 获取operationType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * 设置operationType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationType(String value) {
        this.operationType = value;
    }

    /**
     * 获取orgName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置orgName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgName(String value) {
        this.orgName = value;
    }

    /**
     * 获取payedMethod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayedMethod() {
        return payedMethod;
    }

    /**
     * 设置payedMethod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayedMethod(String value) {
        this.payedMethod = value;
    }

    /**
     * 获取paymentDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPaymentDate() {
        return paymentDate;
    }

    /**
     * 设置paymentDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPaymentDate(XMLGregorianCalendar value) {
        this.paymentDate = value;
    }

    /**
     * 获取paymentId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * 设置paymentId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentId(String value) {
        this.paymentId = value;
    }

    /**
     * 获取paymentMethod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * 设置paymentMethod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMethod(String value) {
        this.paymentMethod = value;
    }

    /**
     * 获取relatedPaymentId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelatedPaymentId() {
        return relatedPaymentId;
    }

    /**
     * 设置relatedPaymentId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelatedPaymentId(String value) {
        this.relatedPaymentId = value;
    }

    /**
     * 获取remark属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置remark属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * 获取staffId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStaffId() {
        return staffId;
    }

    /**
     * 设置staffId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStaffId(String value) {
        this.staffId = value;
    }

    /**
     * 获取staffName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * 设置staffName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStaffName(String value) {
        this.staffName = value;
    }

}
