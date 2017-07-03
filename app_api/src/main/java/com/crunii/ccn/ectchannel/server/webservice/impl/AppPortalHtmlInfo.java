
package com.crunii.ccn.ectchannel.server.webservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>appPortalHtmlInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="appPortalHtmlInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}returnData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="htmlStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appPortalHtmlInfo", propOrder = {
    "htmlStr"
})
public class AppPortalHtmlInfo
    extends ReturnData
{

    protected String htmlStr;

    /**
     * 获取htmlStr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHtmlStr() {
        return htmlStr;
    }

    /**
     * 设置htmlStr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHtmlStr(String value) {
        this.htmlStr = value;
    }

}
