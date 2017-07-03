
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
 * <p>newProductInstance complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="newProductInstance"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="billId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="createDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="mainProdInstId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="offerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="offerInstId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="prodInstId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="prodSpecId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="resTerminalList" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}newResTerminal" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="subBillId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "newProductInstance", propOrder = {
    "billId",
    "createDate",
    "mainProdInstId",
    "offerId",
    "offerInstId",
    "prodInstId",
    "prodSpecId",
    "resTerminalList",
    "status",
    "subBillId"
})
public class NewProductInstance {

    protected String billId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createDate;
    protected String mainProdInstId;
    protected String offerId;
    protected String offerInstId;
    protected String prodInstId;
    protected String prodSpecId;
    @XmlElement(nillable = true)
    protected List<NewResTerminal> resTerminalList;
    protected String status;
    protected String subBillId;

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
     * 获取createDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateDate() {
        return createDate;
    }

    /**
     * 设置createDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateDate(XMLGregorianCalendar value) {
        this.createDate = value;
    }

    /**
     * 获取mainProdInstId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainProdInstId() {
        return mainProdInstId;
    }

    /**
     * 设置mainProdInstId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainProdInstId(String value) {
        this.mainProdInstId = value;
    }

    /**
     * 获取offerId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfferId() {
        return offerId;
    }

    /**
     * 设置offerId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfferId(String value) {
        this.offerId = value;
    }

    /**
     * 获取offerInstId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfferInstId() {
        return offerInstId;
    }

    /**
     * 设置offerInstId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfferInstId(String value) {
        this.offerInstId = value;
    }

    /**
     * 获取prodInstId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProdInstId() {
        return prodInstId;
    }

    /**
     * 设置prodInstId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProdInstId(String value) {
        this.prodInstId = value;
    }

    /**
     * 获取prodSpecId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProdSpecId() {
        return prodSpecId;
    }

    /**
     * 设置prodSpecId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProdSpecId(String value) {
        this.prodSpecId = value;
    }

    /**
     * Gets the value of the resTerminalList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resTerminalList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResTerminalList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NewResTerminal }
     * 
     * 
     */
    public List<NewResTerminal> getResTerminalList() {
        if (resTerminalList == null) {
            resTerminalList = new ArrayList<NewResTerminal>();
        }
        return this.resTerminalList;
    }

    /**
     * 获取status属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * 获取subBillId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubBillId() {
        return subBillId;
    }

    /**
     * 设置subBillId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubBillId(String value) {
        this.subBillId = value;
    }

}
