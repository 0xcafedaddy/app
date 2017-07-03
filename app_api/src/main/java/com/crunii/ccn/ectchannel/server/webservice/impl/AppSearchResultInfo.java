
package com.crunii.ccn.ectchannel.server.webservice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>appSearchResultInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="appSearchResultInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}returnData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="appSearchResult" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}appSearchResult" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appSearchResultInfo", propOrder = {
    "appSearchResult"
})
public class AppSearchResultInfo
    extends ReturnData
{

    @XmlElement(nillable = true)
    protected List<AppSearchResult> appSearchResult;

    /**
     * Gets the value of the appSearchResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appSearchResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppSearchResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppSearchResult }
     * 
     * 
     */
    public List<AppSearchResult> getAppSearchResult() {
        if (appSearchResult == null) {
            appSearchResult = new ArrayList<AppSearchResult>();
        }
        return this.appSearchResult;
    }

}
