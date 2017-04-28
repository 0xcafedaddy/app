package com.util.skye;


public class TreeData {
	
	public TreeData(){}
	public TreeData(String id,String text){
		this.id = id;
		this.text = text;
	}
	
	//必须属性，从DAO获取。
	private String id = "";
	private String text = "";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	//扩展属性etree使用
	private String targetId;//拖拽到某个节点
	private String parentId;//在某个节点下增加
	private String point;//拖拽的状态
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	//非必须属性，取默认值。
	private String state="closed";//根节点使用默认值，closed。末级节点把state赋值成open
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

	private TreeAttributes attributes = new TreeAttributes("");//有url地址的节点时候，从DAO取出url赋值给TreeAttributes的URL属性。
	//默认值。
	private String checked="";
	private String children="";
	private String iconCls;

	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getChildren() {
		return children;
	}
	public void setChildren(String children) {
		this.children = children;
	}
	public TreeAttributes getAttributes() {
		return attributes;
	}
	public void setAttributes(TreeAttributes attributes) {
		this.attributes = attributes;
	}
	
	public static TreeData initRoot(){
		TreeData td = new TreeData();
		td.setText("菜单");
		td.setId("0");
		TreeAttributes ta = new TreeAttributes("");
		td.setAttributes(ta);
		return td;
	}
	

	/**
	 * 构建一个根节点
	 */
	public void buildRootTree(){
		this.setState("closed");
	}
	
	/**
	 * 构建一个叶节点(末级节点)
	 */
	public void buildLeafTree(){
		this.setState("open");
	}
	
	/**
	 * 构建一个文字为 "暂无菜单" 的tree
	 * @return
	 */
	public static TreeData initializeTree(){
		
		TreeData tree = new TreeData();
		tree.setId(String.valueOf(-2));
		tree.setText("暂无菜单");
		
		//设置成末级节点
		tree.buildLeafTree();
		
		TreeAttributes ta = new TreeAttributes("");
		tree.setAttributes(ta);
		return tree;
	}
}
