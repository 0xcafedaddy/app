
package com.crunii.ccn.ectchannel.server.webservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>comboInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="comboInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}returnData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="combo" type="{http://impl.webservice.server.ectchannel.ccn.crunii.com/}combo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "comboInfo", propOrder = {
    "combo"
})
public class ComboInfo
    extends ReturnData
{

    protected Combo combo;

    /**
     * 获取combo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Combo }
     *     
     */
    public Combo getCombo() {
        return combo;
    }

    /**
     * 设置combo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Combo }
     *     
     */
    public void setCombo(Combo value) {
        this.combo = value;
    }

}
