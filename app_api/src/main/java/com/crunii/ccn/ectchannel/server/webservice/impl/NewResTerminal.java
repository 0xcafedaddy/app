
package com.crunii.ccn.ectchannel.server.webservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>newResTerminal complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="newResTerminal"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="resCodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="resEquNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="resEquNo2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="resType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="resTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "newResTerminal", propOrder = {
    "resCode",
    "resCodeName",
    "resEquNo",
    "resEquNo2",
    "resType",
    "resTypeName"
})
public class NewResTerminal {

    protected String resCode;
    protected String resCodeName;
    protected String resEquNo;
    protected String resEquNo2;
    protected String resType;
    protected String resTypeName;

    /**
     * 获取resCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResCode() {
        return resCode;
    }

    /**
     * 设置resCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResCode(String value) {
        this.resCode = value;
    }

    /**
     * 获取resCodeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResCodeName() {
        return resCodeName;
    }

    /**
     * 设置resCodeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResCodeName(String value) {
        this.resCodeName = value;
    }

    /**
     * 获取resEquNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResEquNo() {
        return resEquNo;
    }

    /**
     * 设置resEquNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResEquNo(String value) {
        this.resEquNo = value;
    }

    /**
     * 获取resEquNo2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResEquNo2() {
        return resEquNo2;
    }

    /**
     * 设置resEquNo2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResEquNo2(String value) {
        this.resEquNo2 = value;
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
     * 获取resTypeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResTypeName() {
        return resTypeName;
    }

    /**
     * 设置resTypeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResTypeName(String value) {
        this.resTypeName = value;
    }

}
