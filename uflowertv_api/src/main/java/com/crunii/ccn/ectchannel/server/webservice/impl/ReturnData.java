
package com.crunii.ccn.ectchannel.server.webservice.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>returnData complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="returnData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="msg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnData", propOrder = {
    "code",
    "msg"
})
@XmlSeeAlso({
    DynamicPicInfo.class,
    ComboListInfo.class,
    AppUserLoginCode.class,
    UserInfo.class,
    AppKeyWordInfo.class,
    AppProductInfoList.class,
    BalanceInfo.class,
    AppQueryGuideInfo.class,
    AppQGCInfo.class,
    PortalInfo.class,
    AppSearchResultInfo.class,
    CustInfo.class,
    AppCommonFaultList.class,
    AppBusiHallInfosRt.class,
    AppAreaInfoList.class,
    VodInfoEctChannel.class,
    GoodsInfo.class,
    NewProductOrderInfoEct.class,
    ParentLocker.class,
    ComboCateInfo.class,
    AppBusiOrderList.class,
    OrderCreateInfo.class,
    CustIntegralInfo.class,
    Integral.class,
    AppPayCardResult.class,
    ComboOrderInfo.class,
    PaymentQueryInfo.class,
    AppOrderQueryInfo.class,
    AppPortalHtmlInfo.class,
    NoticeReturnInfo.class,
    ComboValidInfo.class,
    AcctBillInfo.class,
    NewUserInfoEct.class,
    NewAcctInfoEct.class,
    NewCustInfoEct.class,
    BindQueryInfo.class,
    AppLoginInfo.class,
    AppComplainList.class,
    ComboInfo.class,
    BindingMobileNumber.class,
    CreditInfo.class,
    TypeListInfo.class
})
public class ReturnData {

    protected String code;
    protected String msg;

	/**
     * 获取code属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置code属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * 获取msg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置msg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsg(String value) {
        this.msg = value;
    }

	@Override
	public String toString() {
		return "ReturnData [code=" + code + ", msg=" + msg + "]";
	}

}
