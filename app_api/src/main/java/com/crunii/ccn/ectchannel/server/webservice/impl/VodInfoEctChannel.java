
package com.crunii.ccn.ectchannel.server.webservice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>vodInfoEctChannel complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="vodInfoEctChannel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}returnData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sQueryDrIsmpOutList" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}sQueryDrIsmpOutItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="sSServiceHeadOut" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}sServiceHeadOut" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vodInfoEctChannel", propOrder = {
    "sQueryDrIsmpOutList",
    "ssServiceHeadOut"
})
public class VodInfoEctChannel
    extends ReturnData
{

    @XmlElement(nillable = true)
    protected List<SQueryDrIsmpOutItem> sQueryDrIsmpOutList;
    @XmlElement(name = "sSServiceHeadOut")
    protected SServiceHeadOut ssServiceHeadOut;

    /**
     * Gets the value of the sQueryDrIsmpOutList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sQueryDrIsmpOutList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSQueryDrIsmpOutList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SQueryDrIsmpOutItem }
     * 
     * 
     */
    public List<SQueryDrIsmpOutItem> getSQueryDrIsmpOutList() {
        if (sQueryDrIsmpOutList == null) {
            sQueryDrIsmpOutList = new ArrayList<SQueryDrIsmpOutItem>();
        }
        return this.sQueryDrIsmpOutList;
    }

    /**
     * 获取ssServiceHeadOut属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SServiceHeadOut }
     *     
     */
    public SServiceHeadOut getSSServiceHeadOut() {
        return ssServiceHeadOut;
    }

    /**
     * 设置ssServiceHeadOut属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SServiceHeadOut }
     *     
     */
    public void setSSServiceHeadOut(SServiceHeadOut value) {
        this.ssServiceHeadOut = value;
    }

}
