
package com.crunii.ccn.ectchannel.server.webservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>noticeInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="noticeInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="imageTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noticeContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "noticeInfo", propOrder = {
    "imageTitle",
    "noticeContent",
    "sort"
})
public class NoticeInfo {

    protected String imageTitle;
    protected String noticeContent;
    protected String sort;

    /**
     * 获取imageTitle属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageTitle() {
        return imageTitle;
    }

    /**
     * 设置imageTitle属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageTitle(String value) {
        this.imageTitle = value;
    }

    /**
     * 获取noticeContent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoticeContent() {
        return noticeContent;
    }

    /**
     * 设置noticeContent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoticeContent(String value) {
        this.noticeContent = value;
    }

    /**
     * 获取sort属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSort() {
        return sort;
    }

    /**
     * 设置sort属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSort(String value) {
        this.sort = value;
    }

}
