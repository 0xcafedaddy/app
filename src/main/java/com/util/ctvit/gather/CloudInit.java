package com.util.ctvit.gather;//package com.ctvit.lizhiclound.utils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.ctvit.exception.PaasRequestException;
//import com.ctvit.lizhiclound.action.CloudUserAction;
//import com.ctvit.lizhiclound.bean.cloudUserBean.CloudChnls;
//import com.ctvit.lizhiclound.bean.cloudUserBean.CloudDepartment;
//import com.ctvit.lizhiclound.bean.cloudUserBean.CloudLog;
//
//public class CloudInit {
//	@Autowired
//	private CloudDAO cloudDAO;
//	@Autowired
//	private CloudUserAction cloudUserAction;
//
//	//定时更新库表
//	public void execute() {
//		//栏目
//		List<CloudChnls> chnlsList = cloudUserAction.getChnlInfo();
//		List<CloudChnls> chnlsTable = cloudDAO.queryAllCloudChnl();
//		if (chnlsList != null && chnlsList.size() > 0) {
//			for (CloudChnls chnls : chnlsList) {
//				CloudLog cloudLog = new CloudLog();
//				cloudLog.setPid(chnls.getChannelid());
//				cloudLog.setName("paas");
//				if (chnlsTable.indexOf(chnls) != -1) {
//					CloudChnls chnls2 = chnlsTable.get(chnlsTable.indexOf(chnls));
//					chnls.setChannelid(chnls2.getChannelid());
//					cloudDAO.updatedCloudChnl(chnls, cloudLog);
//				} else {
//					cloudDAO.registerCloudChnl(chnls, cloudLog);
//				}
//			}
//		}
//		//组织
//		List<CloudDepartment> orgsList = cloudUserAction.getOrgInfo();
//		List<CloudDepartment> orgsTable = cloudDAO.queryAllCloudOrg();
//		List<CloudDepartment> registerOrgs = new ArrayList<CloudDepartment>();
//		List<CloudDepartment> updatedOrgs = new ArrayList<CloudDepartment>();
//		if (orgsList != null && orgsList.size() > 0) {
//			for (CloudDepartment org : orgsList) {
//				if (orgsTable.indexOf(org) != -1) {
//					CloudDepartment orgs = orgsTable.get(orgsTable.indexOf(org));
//					org.setDepartmentid(orgs.getDepartmentid());
//					updatedOrgs.add(org);
//				} else {
//					registerOrgs.add(org);
//				}
//			}
//		}
//		//组织
//		if (registerOrgs != null && registerOrgs.size() > 0) {
//			cloudDAO.registerCloudOrg(registerOrgs);
//		} else if (updatedOrgs != null && updatedOrgs.size() > 0) {
//			cloudDAO.updatedCloudOrg(updatedOrgs);
//		} else {
//			throw new PaasRequestException("获取组织信息失败！");
//		}
//	}
//}
