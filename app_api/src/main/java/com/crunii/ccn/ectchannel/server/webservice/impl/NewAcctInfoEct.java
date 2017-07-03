
package com.crunii.ccn.ectchannel.server.webservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>newAcctInfoEct complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="newAcctInfoEct"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}returnData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="account" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}newAccount" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "newAcctInfoEct", propOrder = {
    "account"
})
public class NewAcctInfoEct
    extends ReturnData
{

    protected NewAccount account;

    /**
     * 获取account属性的值。
     * 
     * @return
     *     possible object is
     *     {@link NewAccount }
     *     
     */
    public NewAccount getAccount() {
        return account;
    }

    /**
     * 设置account属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link NewAccount }
     *     
     */
    public void setAccount(NewAccount value) {
        this.account = value;
    }

}
