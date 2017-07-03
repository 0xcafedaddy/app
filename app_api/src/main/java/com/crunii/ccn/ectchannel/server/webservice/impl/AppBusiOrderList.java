
package com.crunii.ccn.ectchannel.server.webservice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>appBusiOrderList complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="appBusiOrderList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}returnData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="appBusiOrderList" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}appBusiOrder" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appBusiOrderList", propOrder = {
    "appBusiOrderList"
})
public class AppBusiOrderList
    extends ReturnData
{

    @XmlElement(nillable = true)
    protected List<AppBusiOrder> appBusiOrderList;

    /**
     * Gets the value of the appBusiOrderList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appBusiOrderList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppBusiOrderList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppBusiOrder }
     * 
     * 
     */
    public List<AppBusiOrder> getAppBusiOrderList() {
        if (appBusiOrderList == null) {
            appBusiOrderList = new ArrayList<AppBusiOrder>();
        }
        return this.appBusiOrderList;
    }

}
