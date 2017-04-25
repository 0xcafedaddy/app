
package com.crunii.ccn.ectchannel.server.webservice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ectQueryComboData complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ectQueryComboData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}retuenData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ectQueryComboInfo" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}ectQueryComboInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ectQueryComboData", propOrder = {
    "ectQueryComboInfo"
})
public class EctQueryComboData
    extends RetuenData
{

    @XmlElement(nillable = true)
    protected List<EctQueryComboInfo> ectQueryComboInfo;

    /**
     * Gets the value of the ectQueryComboInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ectQueryComboInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEctQueryComboInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EctQueryComboInfo }
     * 
     * 
     */
    public List<EctQueryComboInfo> getEctQueryComboInfo() {
        if (ectQueryComboInfo == null) {
            ectQueryComboInfo = new ArrayList<EctQueryComboInfo>();
        }
        return this.ectQueryComboInfo;
    }

}
