package com.uflowertv.model;

import com.util.properties.ConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：uflowertv_api   
 *
 * 类描述：封装api返回结果, 输出实体类
 * 类名称：com.uflowertv.model.ApiResult     
 * 创建人：liguoliang 
 * 创建时间：2016年9月27日 下午2:08:58   
 * 修改人：
 * 修改时间：2016年9月27日 下午2:08:58   
 * 修改备注：   
 * @version   V1.0
 */
public class ApiResult{
	private Logger log = LoggerFactory.getLogger(getClass());
    private static ConfigReader _cr;
    static {
        _cr = new ConfigReader("/ErrorCode.properties");
    }
    private Integer code;
    private String msg;

    public ApiResult() {
		// TODO Auto-generated constructor stub
	}
    public ApiResult(int code) {
        this.code = code;
        this.msg = this.code == null ? "请求成功" : _cr.get(String.valueOf(this.code));
        if (log.isInfoEnabled()) {
            log.info(this.getMsg());
        }
    }
    
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getMsg() {
		return this.msg == null ? "未知错误!" : this.msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
