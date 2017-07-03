
package com.crunii.ccn.ectchannel.server.webservice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>newAccount complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="newAccount"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}result"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="serviceBalanceList" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}newServiceBalance" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "newAccount", propOrder = {
    "accountId",
    "serviceBalanceList"
})
public class NewAccount
    extends Result
{

    protected String accountId;
    @XmlElement(nillable = true)
    protected List<NewServiceBalance> serviceBalanceList;

    /**
     * 获取accountId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 设置accountId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountId(String value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the serviceBalanceList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceBalanceList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceBalanceList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NewServiceBalance }
     * 
     * 
     */
    public List<NewServiceBalance> getServiceBalanceList() {
        if (serviceBalanceList == null) {
            serviceBalanceList = new ArrayList<NewServiceBalance>();
        }
        return this.serviceBalanceList;
    }

}
