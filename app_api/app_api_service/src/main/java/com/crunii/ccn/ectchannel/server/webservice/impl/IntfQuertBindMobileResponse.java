
package com.crunii.ccn.ectchannel.server.webservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>intfQuertBindMobileResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="intfQuertBindMobileResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}bindingMobileNumber" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "intfQuertBindMobileResponse", propOrder = {
    "_return"
})
public class IntfQuertBindMobileResponse {

    @XmlElement(name = "return")
    protected BindingMobileNumber _return;

    /**
     * 获取return属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BindingMobileNumber }
     *     
     */
    public BindingMobileNumber getReturn() {
        return _return;
    }

    /**
     * 设置return属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BindingMobileNumber }
     *     
     */
    public void setReturn(BindingMobileNumber value) {
        this._return = value;
    }

}
