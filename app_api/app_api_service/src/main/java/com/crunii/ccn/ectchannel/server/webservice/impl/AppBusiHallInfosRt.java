
package com.crunii.ccn.ectchannel.server.webservice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>appBusiHallInfosRt complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="appBusiHallInfosRt"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}returnData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="appBusiHallInfos" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}appBusiHallInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appBusiHallInfosRt", propOrder = {
    "appBusiHallInfos"
})
public class AppBusiHallInfosRt
    extends ReturnData
{

    @XmlElement(nillable = true)
    protected List<AppBusiHallInfo> appBusiHallInfos;

    /**
     * Gets the value of the appBusiHallInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appBusiHallInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppBusiHallInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppBusiHallInfo }
     * 
     * 
     */
    public List<AppBusiHallInfo> getAppBusiHallInfos() {
        if (appBusiHallInfos == null) {
            appBusiHallInfos = new ArrayList<AppBusiHallInfo>();
        }
        return this.appBusiHallInfos;
    }

}
