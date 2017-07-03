package com.uflowertv.base;

import com.uflowertv.bean.ResponseError;
import com.uflowertv.bean.dto.AccessToken;
import com.uflowertv.bean.dto.TransParmeter;
import com.uflowertv.bean.dto.TransResult;
import com.util.commons.ConstantHolder;
import com.util.connection.HttpClientUtils;
import com.util.json.JsonUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：Weixin   
 *
 * 类描述：微信工具类
 * 类名称：com.imooc.util.WeixinUtil     
 * 创建人：liguoliang 
 * 创建时间：2016年8月9日 下午5:19:54   
 * 修改人：
 * 修改时间：2016年8月9日 下午5:19:54   
 * 修改备注：   
 * @version   V1.0
 */
public class BaseFunction {
	
	private static Log log = LogFactory.getLog(BaseFunction.class);
	
	private static AccessToken accessToken;
	
	/**
	 * 获取accessToken
	 * @Title: getAccessToken
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 */
	public static AccessToken getAccessToken() {
		if (accessToken != null) {
			/**
			 * 访问秘钥有效时间是2小时，大于2小时重新生成
			 * */
			String millis = accessToken.getExpiresIn();
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
		// 令牌接口地址
		String url = ConstantHolder.ACCESS_TOKEN_URL.replace("APPID", ConstantHolder.APPID).replace("APPSECRET", ConstantHolder.APPSECRET);
		String json =  HttpClientUtils.get(url);
		accessToken = new AccessToken();
		if(json!=null){
			accessToken.setToken((String) JsonUtils.json2Map(json).get("access_token"));
			accessToken.setExpiresIn(String.valueOf(new Date().getTime()));
		}
		log.info("token:"+accessToken.getToken());
		return accessToken;
	}
	
	
	
	public static String createMenu(String token,String message){
		String url = ConstantHolder.CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
		String json = HttpClientUtils.jaxRestful(url, message);
		ResponseError response = JsonUtils.json2Bean(json, ResponseError.class);
		if(response.getErrcode() !=0){
			log.error("创建菜单失败," + " 返回Code: " + response.getErrcode() + "返回Message: " + response.getErrmsg());
			return response.getErrmsg();
		}
		return response.getErrmsg();
	}
	
	/**
	 * 删除菜单
	 * @Title: deleteMenu
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param token
	 * @return
	 */
	public static String deleteMenu(String token) {
		String url = ConstantHolder.DELETE_MENU_URL.replace("ACCESS_TOKEN", token);
		String json = HttpClientUtils.get(url);
		ResponseError rep = JsonUtils.json2Bean(json, ResponseError.class);
		if(rep.getErrcode() != 0){
			log.error("删除菜单失败," + " 返回Code: " + rep.getErrcode() + "返回Message: " + rep.getErrmsg());
			return rep.getErrmsg();
		}
		return rep.getErrmsg();
	}
	
	
	/**
	 * 百度翻译
	 * @Title: baidufanyi
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param words
	 * @return
	 */
	public static String baidufanyi(String words){
		// 对appId+源文+随机数+token计算md5值
		String appid = ConstantHolder.FANYI_APPID;
		String salt = ConstantHolder.FANYI_SALT;
		String sign = DigestUtils.md5Hex(new StringBuilder().append(appid).append(words).append(salt).append(ConstantHolder.FANYI_TOKEN).toString());
		TransParmeter params = new TransParmeter(words,ConstantHolder.FANYI_FROM,ConstantHolder.FANYI_TO,appid,salt,sign);
		String json = HttpClientUtils.post(ConstantHolder.BAIDUFANYI, params);
		//{"from":"zh","to":"en","trans_result":[{"src":"\u7231\u4f60","dst":"love you"}]}
		TransParmeter transParmeter = JsonUtils.json2Bean(json, TransParmeter.class);
		String result = null;
		if(transParmeter.getError_code()!=0){
			log.error("翻译失败," + " 返回Code: " + transParmeter.getError_code() + "返回Message: " + transParmeter.getError_msg());
			return transParmeter.getError_msg();
		}
		List<TransResult> list = JsonUtils.json2List(transParmeter.getTrans_result(), TransResult.class);
		StringBuffer dst = new StringBuffer();
		for (TransResult transResult : list) {
			dst.append(transResult.getDst());
		}
		try {
			result = URLDecoder.decode(dst.toString(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.getStackTrace();
		}
		return result;
	}
}
