
package com.crunii.ccn.ectchannel.server.webservice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>appOrderQueryInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="appOrderQueryInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}returnData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="appOrderQueryList" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}appOrderQuery" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appOrderQueryInfo", propOrder = {
    "appOrderQueryList"
})
public class AppOrderQueryInfo
    extends ReturnData
{

    @XmlElement(nillable = true)
    protected List<AppOrderQuery> appOrderQueryList;

    /**
     * Gets the value of the appOrderQueryList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appOrderQueryList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppOrderQueryList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppOrderQuery }
     * 
     * 
     */
    public List<AppOrderQuery> getAppOrderQueryList() {
        if (appOrderQueryList == null) {
            appOrderQueryList = new ArrayList<AppOrderQuery>();
        }
        return this.appOrderQueryList;
    }

}
