package com.uflowertv.model.dto;

import lombok.Data;

@Data
public class TreeData {
	//必须属性，从DAO获取。
	private String id;
	private String text;
	//非必须属性，取默认值。
	private String state="closed";//根节点使用默认值，closed。末级节点把state赋值成open
	private TreeAttributes attributes = new TreeAttributes();//有url地址的节点时候，从DAO取出url赋值给TreeAttributes的URL属性。
	private String children;
}
