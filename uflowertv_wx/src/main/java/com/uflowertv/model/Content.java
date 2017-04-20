package com.uflowertv.model;

import lombok.Data;

/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：wxpublic   
 *
 * 类描述：
 * 类名称：com.uflowertv.model.Content     
 * 创建人：liguoliang 
 * 创建时间：2016年9月8日 上午10:06:45   
 * 修改人：
 * 修改时间：2016年9月8日 上午10:06:45   
 * 修改备注：   
 * @version   V1.0
 */
@Data
public class Content {
    private String id ;
    private String message ;

	public Content() {
		// TODO Auto-generated constructor stub
	}

	public Content(String id, String message) {
		super();
		this.id = id;
		this.message = message;
	}


}
