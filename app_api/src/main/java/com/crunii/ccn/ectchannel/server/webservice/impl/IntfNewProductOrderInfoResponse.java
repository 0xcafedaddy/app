
package com.crunii.ccn.ectchannel.server.webservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>intfNewProductOrderInfoResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="intfNewProductOrderInfoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}newProductOrderInfoEct" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "intfNewProductOrderInfoResponse", propOrder = {
    "_return"
})
public class IntfNewProductOrderInfoResponse {

    @XmlElement(name = "return")
    protected NewProductOrderInfoEct _return;

    /**
     * 获取return属性的值。
     * 
     * @return
     *     possible object is
     *     {@link NewProductOrderInfoEct }
     *     
     */
    public NewProductOrderInfoEct getReturn() {
        return _return;
    }

    /**
     * 设置return属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link NewProductOrderInfoEct }
     *     
     */
    public void setReturn(NewProductOrderInfoEct value) {
        this._return = value;
    }

}