
package com.crunii.ccn.ectchannel.server.webservice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>appProductInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="appProductInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="appOrderedProductInfo" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}appOrderedProductInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="isMainServ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="offerNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="resType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appProductInfo", propOrder = {
    "appOrderedProductInfo",
    "isMainServ",
    "offerNo",
    "resType",
    "status"
})
public class AppProductInfo {

    @XmlElement(nillable = true)
    protected List<AppOrderedProductInfo> appOrderedProductInfo;
    protected String isMainServ;
    protected String offerNo;
    protected String resType;
    protected String status;

    /**
     * Gets the value of the appOrderedProductInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appOrderedProductInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppOrderedProductInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppOrderedProductInfo }
     * 
     * 
     */
    public List<AppOrderedProductInfo> getAppOrderedProductInfo() {
        if (appOrderedProductInfo == null) {
            appOrderedProductInfo = new ArrayList<AppOrderedProductInfo>();
        }
        return this.appOrderedProductInfo;
    }

    /**
     * 获取isMainServ属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsMainServ() {
        return isMainServ;
    }

    /**
     * 设置isMainServ属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsMainServ(String value) {
        this.isMainServ = value;
    }

    /**
     * 获取offerNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfferNo() {
        return offerNo;
    }

    /**
     * 设置offerNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfferNo(String value) {
        this.offerNo = value;
    }

    /**
     * 获取resType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResType() {
        return resType;
    }

    /**
     * 设置resType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResType(String value) {
        this.resType = value;
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

}
