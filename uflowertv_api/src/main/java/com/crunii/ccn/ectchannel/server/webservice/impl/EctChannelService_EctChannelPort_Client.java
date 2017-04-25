
package com.crunii.ccn.ectchannel.server.webservice.impl;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 3.1.8
 * 2016-12-09T11:07:47.625+08:00
 * Generated source version: 3.1.8
 * 
 */
public final class EctChannelService_EctChannelPort_Client {

    private static final QName SERVICE_NAME = new QName("http://impl.webservice.server.ectchannel.ccn.crunii.com/", "EctChannelService");

    private EctChannelService_EctChannelPort_Client() {
    }

    public static void main(String args[]) throws Exception {
        URL wsdlURL = EctChannelService_Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        EctChannelService_Service ss = new EctChannelService_Service(wsdlURL, SERVICE_NAME);
        EctChannelService port = ss.getEctChannelPort();  
        
        {
        System.out.println("Invoking intfDynamicPic...");
        String _intfDynamicPic_cateId = "";
        String _intfDynamicPic_channelCode = "";
        DynamicPicInfo _intfDynamicPic__return = port.intfDynamicPic(_intfDynamicPic_cateId, _intfDynamicPic_channelCode);
        System.out.println("intfDynamicPic.result=" + _intfDynamicPic__return);


        }
        {
        System.out.println("Invoking intfGetLoginCode...");
        String _intfGetLoginCode_icMacType = "";
        String _intfGetLoginCode_zhinengkahao = "";
        String _intfGetLoginCode_channelCode = "";
        AppUserLoginCode _intfGetLoginCode__return = port.intfGetLoginCode(_intfGetLoginCode_icMacType, _intfGetLoginCode_zhinengkahao, _intfGetLoginCode_channelCode);
        System.out.println("intfGetLoginCode.result=" + _intfGetLoginCode__return);


        }
        {
        System.out.println("Invoking intfComboList...");
        String _intfComboList_cateId = "";
        String _intfComboList_channelCode = "";
        String _intfComboList_pageNo = "";
        String _intfComboList_pageSize = "";
        ComboListInfo _intfComboList__return = port.intfComboList(_intfComboList_cateId, _intfComboList_channelCode, _intfComboList_pageNo, _intfComboList_pageSize);
        System.out.println("intfComboList.result=" + _intfComboList__return);


        }
        {
        System.out.println("Invoking intfUserInfo...");
        String _intfUserInfo_queryNo = "";
        String _intfUserInfo_queryType = "";
        String _intfUserInfo_channelCode = "";
        UserInfo _intfUserInfo__return = port.intfUserInfo(_intfUserInfo_queryNo, _intfUserInfo_queryType, _intfUserInfo_channelCode);
        System.out.println("intfUserInfo.result=" + _intfUserInfo__return);


        }
        {
        System.out.println("Invoking intfSendMsgCode...");
        String _intfSendMsgCode_loginCode = "";
        String _intfSendMsgCode_channelCode = "";
        ReturnData _intfSendMsgCode__return = port.intfSendMsgCode(_intfSendMsgCode_loginCode, _intfSendMsgCode_channelCode);
        System.out.println("intfSendMsgCode.result=" + _intfSendMsgCode__return);


        }
        {
        System.out.println("Invoking intfCheckMsgRandomCode...");
        String _intfCheckMsgRandomCode_accNbr = "";
        String _intfCheckMsgRandomCode_msgRandomCode = "";
        String _intfCheckMsgRandomCode_channelCode = "";
        ReturnData _intfCheckMsgRandomCode__return = port.intfCheckMsgRandomCode(_intfCheckMsgRandomCode_accNbr, _intfCheckMsgRandomCode_msgRandomCode, _intfCheckMsgRandomCode_channelCode);
        System.out.println("intfCheckMsgRandomCode.result=" + _intfCheckMsgRandomCode__return);


        }
        {
        System.out.println("Invoking intfAppKeyWordInfo...");
        String _intfAppKeyWordInfo_menuNumber = "";
        String _intfAppKeyWordInfo_channelCode = "";
        AppKeyWordInfo _intfAppKeyWordInfo__return = port.intfAppKeyWordInfo(_intfAppKeyWordInfo_menuNumber, _intfAppKeyWordInfo_channelCode);
        System.out.println("intfAppKeyWordInfo.result=" + _intfAppKeyWordInfo__return);


        }
        {
        System.out.println("Invoking intfModifyPasswd...");
        String _intfModifyPasswd_loginCode = "";
        String _intfModifyPasswd_oldPasswd = "";
        String _intfModifyPasswd_newPasswd = "";
        String _intfModifyPasswd_channelCode = "";
        ReturnData _intfModifyPasswd__return = port.intfModifyPasswd(_intfModifyPasswd_loginCode, _intfModifyPasswd_oldPasswd, _intfModifyPasswd_newPasswd, _intfModifyPasswd_channelCode);
        System.out.println("intfModifyPasswd.result=" + _intfModifyPasswd__return);


        }
        {
        System.out.println("Invoking intfQueryProductInfoList...");
        String _intfQueryProductInfoList_qryType = "";
        String _intfQueryProductInfoList_qryId = "";
        String _intfQueryProductInfoList_channelCode = "";
        AppProductInfoList _intfQueryProductInfoList__return = port.intfQueryProductInfoList(_intfQueryProductInfoList_qryType, _intfQueryProductInfoList_qryId, _intfQueryProductInfoList_channelCode);
        System.out.println("intfQueryProductInfoList.result=" + _intfQueryProductInfoList__return);


        }
        {
        System.out.println("Invoking intfBalanceInfo...");
        String _intfBalanceInfo_queryNo = "";
        String _intfBalanceInfo_queryType = "";
        String _intfBalanceInfo_channelCode = "";
        BalanceInfo _intfBalanceInfo__return = port.intfBalanceInfo(_intfBalanceInfo_queryNo, _intfBalanceInfo_queryType, _intfBalanceInfo_channelCode);
        System.out.println("intfBalanceInfo.result=" + _intfBalanceInfo__return);


        }
        {
        System.out.println("Invoking intfChangeActiveAccNbr...");
        String _intfChangeActiveAccNbr_channelCode = "";
        String _intfChangeActiveAccNbr_custId = "";
        String _intfChangeActiveAccNbr_accNbr = "";
        ReturnData _intfChangeActiveAccNbr__return = port.intfChangeActiveAccNbr(_intfChangeActiveAccNbr_channelCode, _intfChangeActiveAccNbr_custId, _intfChangeActiveAccNbr_accNbr);
        System.out.println("intfChangeActiveAccNbr.result=" + _intfChangeActiveAccNbr__return);


        }
        {
        System.out.println("Invoking intfQueryGuide...");
        String _intfQueryGuide_ableId = "";
        String _intfQueryGuide_channelCode = "";
        AppQueryGuideInfo _intfQueryGuide__return = port.intfQueryGuide(_intfQueryGuide_ableId, _intfQueryGuide_channelCode);
        System.out.println("intfQueryGuide.result=" + _intfQueryGuide__return);


        }
        {
        System.out.println("Invoking intfTVPortalImage...");
        String _intfTVPortalImage_channelCode = "";
        PortalInfo _intfTVPortalImage__return = port.intfTVPortalImage(_intfTVPortalImage_channelCode);
        System.out.println("intfTVPortalImage.result=" + _intfTVPortalImage__return);


        }
        {
        System.out.println("Invoking intfQueryGuideClassification...");
        String _intfQueryGuideClassification_parent = "";
        String _intfQueryGuideClassification_channelCode = "";
        AppQGCInfo _intfQueryGuideClassification__return = port.intfQueryGuideClassification(_intfQueryGuideClassification_parent, _intfQueryGuideClassification_channelCode);
        System.out.println("intfQueryGuideClassification.result=" + _intfQueryGuideClassification__return);


        }
        {
        System.out.println("Invoking intfBindRemove...");
        String _intfBindRemove_custId = "";
        String _intfBindRemove_userId = "";
        String _intfBindRemove_channelCode = "";
        ReturnData _intfBindRemove__return = port.intfBindRemove(_intfBindRemove_custId, _intfBindRemove_userId, _intfBindRemove_channelCode);
        System.out.println("intfBindRemove.result=" + _intfBindRemove__return);


        }
        {
        System.out.println("Invoking intfIntegralCreate...");
        String _intfIntegralCreate_orderId = "";
        String _intfIntegralCreate_custId = "";
        String _intfIntegralCreate_bussType = "";
        String _intfIntegralCreate_note = "";
        String _intfIntegralCreate_channelCode = "";
        ReturnData _intfIntegralCreate__return = port.intfIntegralCreate(_intfIntegralCreate_orderId, _intfIntegralCreate_custId, _intfIntegralCreate_bussType, _intfIntegralCreate_note, _intfIntegralCreate_channelCode);
        System.out.println("intfIntegralCreate.result=" + _intfIntegralCreate__return);


        }
        {
        System.out.println("Invoking intfSendPhoneCode...");
        String _intfSendPhoneCode_mobilePhone = "";
        String _intfSendPhoneCode_channelCode = "";
        ReturnData _intfSendPhoneCode__return = port.intfSendPhoneCode(_intfSendPhoneCode_mobilePhone, _intfSendPhoneCode_channelCode);
        System.out.println("intfSendPhoneCode.result=" + _intfSendPhoneCode__return);


        }
        {
        System.out.println("Invoking intfQuerySearchResult...");
        String _intfQuerySearchResult_keyWord = "";
        String _intfQuerySearchResult_condition = "";
        String _intfQuerySearchResult_channelCode = "";
        AppSearchResultInfo _intfQuerySearchResult__return = port.intfQuerySearchResult(_intfQuerySearchResult_keyWord, _intfQuerySearchResult_condition, _intfQuerySearchResult_channelCode);
        System.out.println("intfQuerySearchResult.result=" + _intfQuerySearchResult__return);


        }
        {
        System.out.println("Invoking intfRetrievePasswd...");
        String _intfRetrievePasswd_loginCode = "";
        String _intfRetrievePasswd_phoneCode = "";
        String _intfRetrievePasswd_passwd = "";
        String _intfRetrievePasswd_channelCode = "";
        ReturnData _intfRetrievePasswd__return = port.intfRetrievePasswd(_intfRetrievePasswd_loginCode, _intfRetrievePasswd_phoneCode, _intfRetrievePasswd_passwd, _intfRetrievePasswd_channelCode);
        System.out.println("intfRetrievePasswd.result=" + _intfRetrievePasswd__return);


        }
        {
        System.out.println("Invoking intfCustInfo...");
        String _intfCustInfo_queryNo = "";
        String _intfCustInfo_queryType = "";
        String _intfCustInfo_channelCode = "";
        CustInfo _intfCustInfo__return = port.intfCustInfo(_intfCustInfo_queryNo, _intfCustInfo_queryType, _intfCustInfo_channelCode);
        System.out.println("intfCustInfo.result=" + _intfCustInfo__return);


        }
        {
        System.out.println("Invoking intfEctServiceRel...");
        String _intfEctServiceRel_serviceId = "";
        String _intfEctServiceRel_serviceType = "";
        EctQueryComboData _intfEctServiceRel__return = port.intfEctServiceRel(_intfEctServiceRel_serviceId, _intfEctServiceRel_serviceType);
        System.out.println("intfEctServiceRel.result=" + _intfEctServiceRel__return);


        }
        {
        System.out.println("Invoking intfChangeNumber...");
        String _intfChangeNumber_userId = "";
        String _intfChangeNumber_newPhone = "";
        String _intfChangeNumber_newMail = "";
        String _intfChangeNumber_channelCode = "";
        ReturnData _intfChangeNumber__return = port.intfChangeNumber(_intfChangeNumber_userId, _intfChangeNumber_newPhone, _intfChangeNumber_newMail, _intfChangeNumber_channelCode);
        System.out.println("intfChangeNumber.result=" + _intfChangeNumber__return);


        }
        {
        System.out.println("Invoking intfQueryCommonfaultList...");
        String _intfQueryCommonfaultList_channelCode = "";
        AppCommonFaultList _intfQueryCommonfaultList__return = port.intfQueryCommonfaultList(_intfQueryCommonfaultList_channelCode);
        System.out.println("intfQueryCommonfaultList.result=" + _intfQueryCommonfaultList__return);


        }
        {
        System.out.println("Invoking intfGoodsAccept...");
        String _intfGoodsAccept_orderId = "";
        String _intfGoodsAccept_custId = "";
        String _intfGoodsAccept_goodsId = "";
        String _intfGoodsAccept_goodsAmount = "";
        String _intfGoodsAccept_relaNumber = "";
        String _intfGoodsAccept_channelCode = "";
        ReturnData _intfGoodsAccept__return = port.intfGoodsAccept(_intfGoodsAccept_orderId, _intfGoodsAccept_custId, _intfGoodsAccept_goodsId, _intfGoodsAccept_goodsAmount, _intfGoodsAccept_relaNumber, _intfGoodsAccept_channelCode);
        System.out.println("intfGoodsAccept.result=" + _intfGoodsAccept__return);


        }
        {
        System.out.println("Invoking intfPortalImage...");
        String _intfPortalImage_channelCode = "";
        PortalInfo _intfPortalImage__return = port.intfPortalImage(_intfPortalImage_channelCode);
        System.out.println("intfPortalImage.result=" + _intfPortalImage__return);


        }
        {
        System.out.println("Invoking intfQueryBusiHallInfo...");
        String _intfQueryBusiHallInfo_areaId = "";
        String _intfQueryBusiHallInfo_type = "";
        String _intfQueryBusiHallInfo_channelCode = "";
        AppBusiHallInfosRt _intfQueryBusiHallInfo__return = port.intfQueryBusiHallInfo(_intfQueryBusiHallInfo_areaId, _intfQueryBusiHallInfo_type, _intfQueryBusiHallInfo_channelCode);
        System.out.println("intfQueryBusiHallInfo.result=" + _intfQueryBusiHallInfo__return);


        }
        {
        System.out.println("Invoking intfUserReg...");
        String _intfUserReg_icMacType = "";
        String _intfUserReg_zhinengkahao = "";
        String _intfUserReg_nickName = "";
        String _intfUserReg_cardType = "";
        String _intfUserReg_kehukahao = "";
        String _intfUserReg_loginCode = "";
        String _intfUserReg_mobilePhone = "";
        String _intfUserReg_phoneCode = "";
        String _intfUserReg_passwd = "";
        String _intfUserReg_email = "";
        String _intfUserReg_address = "";
        String _intfUserReg_channelCode = "";
        ReturnData _intfUserReg__return = port.intfUserReg(_intfUserReg_icMacType, _intfUserReg_zhinengkahao, _intfUserReg_nickName, _intfUserReg_cardType, _intfUserReg_kehukahao, _intfUserReg_loginCode, _intfUserReg_mobilePhone, _intfUserReg_phoneCode, _intfUserReg_passwd, _intfUserReg_email, _intfUserReg_address, _intfUserReg_channelCode);
        System.out.println("intfUserReg.result=" + _intfUserReg__return);


        }
        {
        System.out.println("Invoking intfNewSendMsg...");
        String _intfNewSendMsg_phone = "";
        String _intfNewSendMsg_msgType = "";
        String _intfNewSendMsg_msgCategory = "";
        String _intfNewSendMsg_channelCode = "";
        ReturnData _intfNewSendMsg__return = port.intfNewSendMsg(_intfNewSendMsg_phone, _intfNewSendMsg_msgType, _intfNewSendMsg_msgCategory, _intfNewSendMsg_channelCode);
        System.out.println("intfNewSendMsg.result=" + _intfNewSendMsg__return);


        }
        {
        System.out.println("Invoking intfQueryAreaInfoList...");
        String _intfQueryAreaInfoList_channelCode = "";
        AppAreaInfoList _intfQueryAreaInfoList__return = port.intfQueryAreaInfoList(_intfQueryAreaInfoList_channelCode);
        System.out.println("intfQueryAreaInfoList.result=" + _intfQueryAreaInfoList__return);


        }
        {
        System.out.println("Invoking intfQueryVodInfo...");
        String _intfQueryVodInfo_servId = "";
        String _intfQueryVodInfo_startDate = "";
        String _intfQueryVodInfo_endDate = "";
        String _intfQueryVodInfo_channelCode = "";
        VodInfoEctChannel _intfQueryVodInfo__return = port.intfQueryVodInfo(_intfQueryVodInfo_servId, _intfQueryVodInfo_startDate, _intfQueryVodInfo_endDate, _intfQueryVodInfo_channelCode);
        System.out.println("intfQueryVodInfo.result=" + _intfQueryVodInfo__return);


        }
        {
        System.out.println("Invoking intfGoodsList...");
        String _intfGoodsList_channelCode = "";
        GoodsInfo _intfGoodsList__return = port.intfGoodsList(_intfGoodsList_channelCode);
        System.out.println("intfGoodsList.result=" + _intfGoodsList__return);


        }
        {
        System.out.println("Invoking intfNewProductOrderInfo...");
        String _intfNewProductOrderInfo_prodInstId = "";
        String _intfNewProductOrderInfo_channelCode = "";
        NewProductOrderInfoEct _intfNewProductOrderInfo__return = port.intfNewProductOrderInfo(_intfNewProductOrderInfo_prodInstId, _intfNewProductOrderInfo_channelCode);
        System.out.println("intfNewProductOrderInfo.result=" + _intfNewProductOrderInfo__return);


        }
        {
        System.out.println("Invoking intfParentLocker...");
        String _intfParentLocker_channelCode = "";
        String _intfParentLocker_custId = "";
        String _intfParentLocker_dealType = "";
        String _intfParentLocker_passwd = "";
        String _intfParentLocker_newPasswd = "";
        ParentLocker _intfParentLocker__return = port.intfParentLocker(_intfParentLocker_channelCode, _intfParentLocker_custId, _intfParentLocker_dealType, _intfParentLocker_passwd, _intfParentLocker_newPasswd);
        System.out.println("intfParentLocker.result=" + _intfParentLocker__return);


        }
        {
        System.out.println("Invoking intfComboCate...");
        String _intfComboCate_channelCode = "";
        ComboCateInfo _intfComboCate__return = port.intfComboCate(_intfComboCate_channelCode);
        System.out.println("intfComboCate.result=" + _intfComboCate__return);


        }
        {
        System.out.println("Invoking intfQueryBusiOrderList...");
        String _intfQueryBusiOrderList_custId = "";
        String _intfQueryBusiOrderList_startTime = "";
        String _intfQueryBusiOrderList_endTime = "";
        String _intfQueryBusiOrderList_channelCode = "";
        AppBusiOrderList _intfQueryBusiOrderList__return = port.intfQueryBusiOrderList(_intfQueryBusiOrderList_custId, _intfQueryBusiOrderList_startTime, _intfQueryBusiOrderList_endTime, _intfQueryBusiOrderList_channelCode);
        System.out.println("intfQueryBusiOrderList.result=" + _intfQueryBusiOrderList__return);


        }
        {
        System.out.println("Invoking intfRecharge...");
        String _intfRecharge_soNbr = "";
        String _intfRecharge_channelCode = "";
        String _intfRecharge_subChannel = "";
        String _intfRecharge_opId = "";
        String _intfRecharge_terminalId = "";
        String _intfRecharge_payDate = "";
        String _intfRecharge_queryType = "";
        String _intfRecharge_queryNo = "";
        java.util.List<PayIn> _intfRecharge_ls = null;
        PayFeeResultExtend _intfRecharge__return = port.intfRecharge(_intfRecharge_soNbr, _intfRecharge_channelCode, _intfRecharge_subChannel, _intfRecharge_opId, _intfRecharge_terminalId, _intfRecharge_payDate, _intfRecharge_queryType, _intfRecharge_queryNo, _intfRecharge_ls);
        System.out.println("intfRecharge.result=" + _intfRecharge__return);


        }
        {
        System.out.println("Invoking intfOrderAppoint...");
        String _intfOrderAppoint_operName = "";
        String _intfOrderAppoint_sex = "";
        String _intfOrderAppoint_dealType = "";
        String _intfOrderAppoint_productType = "";
        String _intfOrderAppoint_mobile = "";
        String _intfOrderAppoint_address = "";
        String _intfOrderAppoint_note = "";
        String _intfOrderAppoint_channelCode = "";
        String _intfOrderAppoint_comboId = "";
        String _intfOrderAppoint_terminalNumber = "";
        String _intfOrderAppoint_merchantOrderid = "";
        String _intfOrderAppoint_paySerialNu = "";
        OrderCreateInfo _intfOrderAppoint__return = port.intfOrderAppoint(_intfOrderAppoint_operName, _intfOrderAppoint_sex, _intfOrderAppoint_dealType, _intfOrderAppoint_productType, _intfOrderAppoint_mobile, _intfOrderAppoint_address, _intfOrderAppoint_note, _intfOrderAppoint_channelCode, _intfOrderAppoint_comboId, _intfOrderAppoint_terminalNumber, _intfOrderAppoint_merchantOrderid, _intfOrderAppoint_paySerialNu);
        System.out.println("intfOrderAppoint.result=" + _intfOrderAppoint__return);


        }
        {
        System.out.println("Invoking intfQueryCardTypeInfo...");
        String _intfQueryCardTypeInfo_typePassword = "";
        String _intfQueryCardTypeInfo_channelCode = "";
        QueryCardTypeResult _intfQueryCardTypeInfo__return = port.intfQueryCardTypeInfo(_intfQueryCardTypeInfo_typePassword, _intfQueryCardTypeInfo_channelCode);
        System.out.println("intfQueryCardTypeInfo.result=" + _intfQueryCardTypeInfo__return);


        }
        {
        System.out.println("Invoking intfModCredit...");
        String _intfModCredit_acctId = "";
        String _intfModCredit_serviceId = "";
        String _intfModCredit_credit = "";
        String _intfModCredit_channelId = "";
        ReturnData _intfModCredit__return = port.intfModCredit(_intfModCredit_acctId, _intfModCredit_serviceId, _intfModCredit_credit, _intfModCredit_channelId);
        System.out.println("intfModCredit.result=" + _intfModCredit__return);


        }
        {
        System.out.println("Invoking intfQueryCustIntegral...");
        String _intfQueryCustIntegral_custId = "";
        String _intfQueryCustIntegral_channelId = "";
        String _intfQueryCustIntegral_channelCode = "";
        String _intfQueryCustIntegral_startTime = "";
        String _intfQueryCustIntegral_endTime = "";
        String _intfQueryCustIntegral_pageNo = "";
        String _intfQueryCustIntegral_pageSize = "";
        CustIntegralInfo _intfQueryCustIntegral__return = port.intfQueryCustIntegral(_intfQueryCustIntegral_custId, _intfQueryCustIntegral_channelId, _intfQueryCustIntegral_channelCode, _intfQueryCustIntegral_startTime, _intfQueryCustIntegral_endTime, _intfQueryCustIntegral_pageNo, _intfQueryCustIntegral_pageSize);
        System.out.println("intfQueryCustIntegral.result=" + _intfQueryCustIntegral__return);


        }
        {
        System.out.println("Invoking intfPayCard...");
        String _intfPayCard_qryType = "";
        String _intfPayCard_qryId = "";
        String _intfPayCard_cardNum = "";
        String _intfPayCard_cardPswd = "";
        String _intfPayCard_channelId = "";
        String _intfPayCard_rechargeType = "";
        Long _intfPayCard_userId = null;
        AppPayCardResult _intfPayCard__return = port.intfPayCard(_intfPayCard_qryType, _intfPayCard_qryId, _intfPayCard_cardNum, _intfPayCard_cardPswd, _intfPayCard_channelId, _intfPayCard_rechargeType, _intfPayCard_userId);
        System.out.println("intfPayCard.result=" + _intfPayCard__return);


        }
        {
        System.out.println("Invoking intfOrderComplain...");
        String _intfOrderComplain_operName = "";
        String _intfOrderComplain_dealType = "";
        String _intfOrderComplain_theme = "";
        String _intfOrderComplain_content = "";
        String _intfOrderComplain_mobile = "";
        String _intfOrderComplain_address = "";
        String _intfOrderComplain_channelCode = "";
        OrderCreateInfo _intfOrderComplain__return = port.intfOrderComplain(_intfOrderComplain_operName, _intfOrderComplain_dealType, _intfOrderComplain_theme, _intfOrderComplain_content, _intfOrderComplain_mobile, _intfOrderComplain_address, _intfOrderComplain_channelCode);
        System.out.println("intfOrderComplain.result=" + _intfOrderComplain__return);


        }
        {
        System.out.println("Invoking intfComboOrder...");
        String _intfComboOrder_servNo = "";
        String _intfComboOrder_comboId = "";
        String _intfComboOrder_channelCode = "";
        String _intfComboOrder_intfSeq = "";
        String _intfComboOrder_prePayTpye = "";
        ComboOrderInfo _intfComboOrder__return = port.intfComboOrder(_intfComboOrder_servNo, _intfComboOrder_comboId, _intfComboOrder_channelCode, _intfComboOrder_intfSeq, _intfComboOrder_prePayTpye);
        System.out.println("intfComboOrder.result=" + _intfComboOrder__return);


        }
        {
        System.out.println("Invoking intfQueryPayment...");
        String _intfQueryPayment_acctId = "";
        String _intfQueryPayment_corpOrgId = "";
        String _intfQueryPayment_startDate = "";
        String _intfQueryPayment_endDate = "";
        String _intfQueryPayment_qryOnetimeFee = "";
        String _intfQueryPayment_channelCode = "";
        PaymentQueryInfo _intfQueryPayment__return = port.intfQueryPayment(_intfQueryPayment_acctId, _intfQueryPayment_corpOrgId, _intfQueryPayment_startDate, _intfQueryPayment_endDate, _intfQueryPayment_qryOnetimeFee, _intfQueryPayment_channelCode);
        System.out.println("intfQueryPayment.result=" + _intfQueryPayment__return);


        }
        {
        System.out.println("Invoking intfOrderQuery...");
        String _intfOrderQuery_mobile = "";
        String _intfOrderQuery_startTime = "";
        String _intfOrderQuery_endTime = "";
        String _intfOrderQuery_channelCode = "";
        AppOrderQueryInfo _intfOrderQuery__return = port.intfOrderQuery(_intfOrderQuery_mobile, _intfOrderQuery_startTime, _intfOrderQuery_endTime, _intfOrderQuery_channelCode);
        System.out.println("intfOrderQuery.result=" + _intfOrderQuery__return);


        }
        {
        System.out.println("Invoking intfPortalHtml...");
        String _intfPortalHtml_isCOA = "";
        String _intfPortalHtml_cateOrArticleId = "";
        String _intfPortalHtml_channelCode = "";
        AppPortalHtmlInfo _intfPortalHtml__return = port.intfPortalHtml(_intfPortalHtml_isCOA, _intfPortalHtml_cateOrArticleId, _intfPortalHtml_channelCode);
        System.out.println("intfPortalHtml.result=" + _intfPortalHtml__return);


        }
        {
        System.out.println("Invoking intfNoticeInfo...");
        String _intfNoticeInfo_channelCode = "";
        NoticeReturnInfo _intfNoticeInfo__return = port.intfNoticeInfo(_intfNoticeInfo_channelCode);
        System.out.println("intfNoticeInfo.result=" + _intfNoticeInfo__return);


        }
        {
        System.out.println("Invoking intfComboValid...");
        String _intfComboValid_servNo = "";
        String _intfComboValid_comboId = "";
        String _intfComboValid_channelCode = "";
        ComboValidInfo _intfComboValid__return = port.intfComboValid(_intfComboValid_servNo, _intfComboValid_comboId, _intfComboValid_channelCode);
        System.out.println("intfComboValid.result=" + _intfComboValid__return);


        }
        {
        System.out.println("Invoking intfAcctBillInfo...");
        String _intfAcctBillInfo_accountId = "";
        String _intfAcctBillInfo_month = "";
        String _intfAcctBillInfo_ownCorpOrg = "";
        String _intfAcctBillInfo_channelCode = "";
        AcctBillInfo _intfAcctBillInfo__return = port.intfAcctBillInfo(_intfAcctBillInfo_accountId, _intfAcctBillInfo_month, _intfAcctBillInfo_ownCorpOrg, _intfAcctBillInfo_channelCode);
        System.out.println("intfAcctBillInfo.result=" + _intfAcctBillInfo__return);


        }
        {
        System.out.println("Invoking intfNewUserInfo...");
        String _intfNewUserInfo_custId = "";
        String _intfNewUserInfo_channelCode = "";
        NewUserInfoEct _intfNewUserInfo__return = port.intfNewUserInfo(_intfNewUserInfo_custId, _intfNewUserInfo_channelCode);
        System.out.println("intfNewUserInfo.result=" + _intfNewUserInfo__return);


        }
        {
        System.out.println("Invoking intfNewAcctInfo...");
        String _intfNewAcctInfo_acctId = "";
        String _intfNewAcctInfo_corpOrgId = "";
        String _intfNewAcctInfo_channelCode = "";
        NewAcctInfoEct _intfNewAcctInfo__return = port.intfNewAcctInfo(_intfNewAcctInfo_acctId, _intfNewAcctInfo_corpOrgId, _intfNewAcctInfo_channelCode);
        System.out.println("intfNewAcctInfo.result=" + _intfNewAcctInfo__return);


        }
        {
        System.out.println("Invoking intfNewCustInfo...");
        String _intfNewCustInfo_queryNo = "";
        String _intfNewCustInfo_queryType = "";
        String _intfNewCustInfo_channelCode = "";
        NewCustInfoEct _intfNewCustInfo__return = port.intfNewCustInfo(_intfNewCustInfo_queryNo, _intfNewCustInfo_queryType, _intfNewCustInfo_channelCode);
        System.out.println("intfNewCustInfo.result=" + _intfNewCustInfo__return);


        }
        {
        System.out.println("Invoking intfBindQuery...");
        String _intfBindQuery_userId = "";
        String _intfBindQuery_channelCode = "";
        BindQueryInfo _intfBindQuery__return = port.intfBindQuery(_intfBindQuery_userId, _intfBindQuery_channelCode);
        System.out.println("intfBindQuery.result=" + _intfBindQuery__return);


        }
        {
        System.out.println("Invoking intfUserLoginInfo...");
        String _intfUserLoginInfo_loginType = "";
        String _intfUserLoginInfo_loginCode = "";
        String _intfUserLoginInfo_passWord = "";
        String _intfUserLoginInfo_channelCode = "";
        AppLoginInfo _intfUserLoginInfo__return = port.intfUserLoginInfo(_intfUserLoginInfo_loginType, _intfUserLoginInfo_loginCode, _intfUserLoginInfo_passWord, _intfUserLoginInfo_channelCode);
        System.out.println("intfUserLoginInfo.result=" + _intfUserLoginInfo__return);


        }
        {
        System.out.println("Invoking intfQueryComplainList...");
        String _intfQueryComplainList_searchNo = "";
        String _intfQueryComplainList_startDate = "";
        String _intfQueryComplainList_endDate = "";
        String _intfQueryComplainList_channelCode = "";
        AppComplainList _intfQueryComplainList__return = port.intfQueryComplainList(_intfQueryComplainList_searchNo, _intfQueryComplainList_startDate, _intfQueryComplainList_endDate, _intfQueryComplainList_channelCode);
        System.out.println("intfQueryComplainList.result=" + _intfQueryComplainList__return);


        }
        {
        System.out.println("Invoking intfComboInfo...");
        String _intfComboInfo_comboId = "";
        String _intfComboInfo_channelCode = "";
        ComboInfo _intfComboInfo__return = port.intfComboInfo(_intfComboInfo_comboId, _intfComboInfo_channelCode);
        System.out.println("intfComboInfo.result=" + _intfComboInfo__return);


        }
        {
        System.out.println("Invoking intfBindUserInfo...");
        String _intfBindUserInfo_custName = "";
        String _intfBindUserInfo_cardNo = "";
        String _intfBindUserInfo_userId = "";
        String _intfBindUserInfo_qryType = "";
        String _intfBindUserInfo_channelCode = "";
        ReturnData _intfBindUserInfo__return = port.intfBindUserInfo(_intfBindUserInfo_custName, _intfBindUserInfo_cardNo, _intfBindUserInfo_userId, _intfBindUserInfo_qryType, _intfBindUserInfo_channelCode);
        System.out.println("intfBindUserInfo.result=" + _intfBindUserInfo__return);


        }
        {
        System.out.println("Invoking intfQuertBindMobile...");
        String _intfQuertBindMobile_mnAndUN = "";
        String _intfQuertBindMobile_channelCode = "";
        BindingMobileNumber _intfQuertBindMobile__return = port.intfQuertBindMobile(_intfQuertBindMobile_mnAndUN, _intfQuertBindMobile_channelCode);
        System.out.println("intfQuertBindMobile.result=" + _intfQuertBindMobile__return);


        }
        {
        System.out.println("Invoking intfQueryCredit...");
        String _intfQueryCredit_acctId = "";
        String _intfQueryCredit_serviceId = "";
        String _intfQueryCredit_channelId = "";
        CreditInfo _intfQueryCredit__return = port.intfQueryCredit(_intfQueryCredit_acctId, _intfQueryCredit_serviceId, _intfQueryCredit_channelId);
        System.out.println("intfQueryCredit.result=" + _intfQueryCredit__return);


        }
        {
        System.out.println("Invoking intfQueryTypeInfo...");
        String _intfQueryTypeInfo_typeCode = "";
        String _intfQueryTypeInfo_channelCode = "";
        TypeListInfo _intfQueryTypeInfo__return = port.intfQueryTypeInfo(_intfQueryTypeInfo_typeCode, _intfQueryTypeInfo_channelCode);
        System.out.println("intfQueryTypeInfo.result=" + _intfQueryTypeInfo__return);


        }

        System.exit(0);
    }

}