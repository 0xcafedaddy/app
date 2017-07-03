
package com.crunii.ccn.ectchannel.server.webservice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>newProductOrderInfoEct complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="newProductOrderInfoEct"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}returnData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="orderedProductList" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}newOrderedProductInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "newProductOrderInfoEct", propOrder = {
    "orderedProductList"
})
public class NewProductOrderInfoEct
    extends ReturnData
{

    @XmlElement(nillable = true)
    protected List<NewOrderedProductInfo> orderedProductList;

    /**
     * Gets the value of the orderedProductList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderedProductList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderedProductList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NewOrderedProductInfo }
     * 
     * 
     */
    public List<NewOrderedProductInfo> getOrderedProductList() {
        if (orderedProductList == null) {
            orderedProductList = new ArrayList<NewOrderedProductInfo>();
        }
        return this.orderedProductList;
    }

}
