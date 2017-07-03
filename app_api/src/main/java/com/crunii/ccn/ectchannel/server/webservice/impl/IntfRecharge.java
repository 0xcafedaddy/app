
package com.crunii.ccn.ectchannel.server.webservice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>intfRecharge complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="intfRecharge"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SoNbr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="channelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SubChannel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OpId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TerminalId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PayDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="queryType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="queryNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ls" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}payIn" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "intfRecharge", propOrder = {
    "soNbr",
    "channelCode",
    "subChannel",
    "opId",
    "terminalId",
    "payDate",
    "queryType",
    "queryNo",
    "ls"
})
public class IntfRecharge {

    @XmlElement(name = "SoNbr")
    protected String soNbr;
    protected String channelCode;
    @XmlElement(name = "SubChannel")
    protected String subChannel;
    @XmlElement(name = "OpId")
    protected String opId;
    @XmlElement(name = "TerminalId")
    protected String terminalId;
    @XmlElement(name = "PayDate")
    protected String payDate;
    protected String queryType;
    protected String queryNo;
    protected List<PayIn> ls;

    /**
     * 获取soNbr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoNbr() {
        return soNbr;
    }

    /**
     * 设置soNbr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoNbr(String value) {
        this.soNbr = value;
    }

    /**
     * 获取channelCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * 设置channelCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelCode(String value) {
        this.channelCode = value;
    }

    /**
     * 获取subChannel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubChannel() {
        return subChannel;
    }

    /**
     * 设置subChannel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubChannel(String value) {
        this.subChannel = value;
    }

    /**
     * 获取opId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpId() {
        return opId;
    }

    /**
     * 设置opId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpId(String value) {
        this.opId = value;
    }

    /**
     * 获取terminalId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalId() {
        return terminalId;
    }

    /**
     * 设置terminalId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalId(String value) {
        this.terminalId = value;
    }

    /**
     * 获取payDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayDate() {
        return payDate;
    }

    /**
     * 设置payDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayDate(String value) {
        this.payDate = value;
    }

    /**
     * 获取queryType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryType() {
        return queryType;
    }

    /**
     * 设置queryType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryType(String value) {
        this.queryType = value;
    }

    /**
     * 获取queryNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryNo() {
        return queryNo;
    }

    /**
     * 设置queryNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryNo(String value) {
        this.queryNo = value;
    }

    /**
     * Gets the value of the ls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PayIn }
     * 
     * 
     */
    public List<PayIn> getLs() {
        if (ls == null) {
            ls = new ArrayList<PayIn>();
        }
        return this.ls;
    }

}
