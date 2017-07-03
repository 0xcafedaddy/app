
package com.crunii.ccn.ectchannel.server.webservice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>custIntegralInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="custIntegralInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}returnData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="integralList" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}integral" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="nextPage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "custIntegralInfo", propOrder = {
    "integralList",
    "nextPage"
})
public class CustIntegralInfo
    extends ReturnData
{

    @XmlElement(nillable = true)
    protected List<Integral> integralList;
    protected String nextPage;

    /**
     * Gets the value of the integralList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the integralList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntegralList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integral }
     * 
     * 
     */
    public List<Integral> getIntegralList() {
        if (integralList == null) {
            integralList = new ArrayList<Integral>();
        }
        return this.integralList;
    }

    /**
     * 获取nextPage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextPage() {
        return nextPage;
    }

    /**
     * 设置nextPage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextPage(String value) {
        this.nextPage = value;
    }

}
