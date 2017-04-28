package com.util.ctvit.gather.commons;

import com.util.ctvit.gather.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * @author wll
 * @date 2015-8-10 上下文处理holder
 * 
 * */
public class ContextHolder {

	/**
	 * 访问令牌
	 */
	private static AccessToken accessToken;

	/**
	 * 
	 * @author wll
	 * @date 2015-8-12
	 * @return 获取访问令牌
	 * */
	public static AccessToken getAccessToken() {
		if (accessToken != null) {
			/**
			 * 访问秘钥有效时间是2小时，大于2小时重新生成
			 * */
			String millis = accessToken.getTimeStamp();
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(Long.valueOf(millis));
			calendar.add(Calendar.HOUR_OF_DAY, 2);
			Date date = new Date();
			if (date.getTime() > calendar.getTimeInMillis()) {
				accessToken = getNewAcessToken();
			}
		} else {
			accessToken = new AccessToken();
			accessToken = getNewAcessToken();

		}
		return accessToken;
	}

	private static AccessToken getNewAcessToken() {

		AccessKey accessKey = new AccessKey();
		accessKey.setAccessKey(CloudConstants.accessKey);
		accessKey.setTimeStamp(String.valueOf(new Date().getTime()));

		// 令牌接口地址
		String url = getHttpRequestUrl("token", "ctvit", "material",
				"getAccessToken");
		ResponseBody rep = HttpClientUtils.post(url, accessKey);
		accessToken = new AccessToken();
		accessToken.setAccessToken((String) JsonUtils.json2Map(rep.getData())
				.get("accessToken"));
		accessToken.setTimeStamp(accessKey.getTimeStamp());
		return accessToken;
	}

	/**
	 * @author wll
	 * @date 2015-8-11
	 * @param interfaceName
	 *            接口
	 * @return 获取接口地址
	 * */
	@SuppressWarnings("unchecked")
	public static String getInterfaceURL(String interfaceName) {
		if (interfaceName == null)
			return "";
		Map<String, Object> interfaceMap = (Map<String, Object>) CloudConstants.interfaceConstant
				.get(interfaceName);
		return (String) interfaceMap.get("interfaceUrl");
	}

	/**
	 * @author wll
	 * @date 2015-8-21
	 * @param domainName
	 *            域名配置名称
	 * @return 域名地址
	 * */

	public static String getDomain(String domainName) {
		if (domainName == null)
			return "";
		return CloudConstants.domainMap.get(domainName)
				+ CloudConstants.splitStr;
	}

	/**
	 * @author wll
	 * @date 2015-8-21
	 *            包编号
	 * @return 公共参数地址
	 * */
	@SuppressWarnings("unchecked")
	public static String getPublicParamter(String packageName) {
 		if (packageName == null)
			return "";
 		Map<String, Object> map = (Map<String, Object>) CloudConstants.publicParameters
 				.get(packageName);
		return map.get("appCode") + CloudConstants.splitStr
				+ map.get("versionId") + CloudConstants.splitStr
				+ map.get("companyId") + CloudConstants.splitStr
				+ map.get("userId") + CloudConstants.splitStr;
	}

	public static String getServiceCode(String serviceCode) {
		if (serviceCode == null)
			return "";
		return CloudConstants.serviceCodes.get(serviceCode)
				+ CloudConstants.splitStr;
	}

	/**
	 * 获取应用公共参数
	 * 
	 * @param target
	 *            指定公共应用标示
	 * @return 获取指定应用公共参数
	 * */
	@SuppressWarnings("unchecked")
	public static PublicAppParamters getPublicParamters(String target) {
		if (target == null)
			return null;
		Map<String, Object> map = (Map<String, Object>) CloudConstants.publicParameters
				.get(target);
		PublicAppParamters p = new PublicAppParamters();
		// 应用标识 应用唯一标识（由荔枝云平台提供）
		String appcode = map.get("appCode") + "";
		// 版本号 接口版本号，当前版本号为V1
		String versionId = map.get("versionId") + "";
		// 企业标识 企业唯一标识（由荔枝云平台提供）
		String companyId = map.get("companyId") + "";
		// 用户唯一标识（用户填充）
		String userId = map.get("userId") + "";
		p.setAppcode(appcode);
		p.setCompanyId(companyId);
		p.setUserId(userId);
		p.setVersionId(versionId);
		return p;
	}

	/**
	 * @author wll
	 * @date 2015-8-21
	 * @param domainName
	 *            域名
	 * @param packageName
	 *            资源包类名
	 * @param serviceCode
	 *            服务类型编号
	 * @param interfaceName
	 *            接口名称
	 * @return 返回请求url
	 */
	public static String getHttpRequestUrl(String domainName,
			String packageName, String serviceCode, String interfaceName) {

		return getDomain(domainName) + getPublicParamter(packageName)
				+ getServiceCode(serviceCode) + getInterfaceURL(interfaceName);
	}
}
