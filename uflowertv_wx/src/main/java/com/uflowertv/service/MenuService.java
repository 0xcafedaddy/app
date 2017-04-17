package com.uflowertv.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uflowertv.dao.ConfigurationMapper;
import com.uflowertv.model.Configuration;
import com.uflowertv.model.Content;
import com.uflowertv.util.xml.XMLUtil;

import io.github.elkan1788.mpsdk4j.vo.api.Menu;
/**
 * 
 * 版权所有：2016-油菜花
 * 项目名称：Weixin   
 *
 * 类描述：微信菜单业务功能
 * 类名称：com.uflowertv.service.MenuService     
 * 创建人：liguoliang 
 * 创建时间：2016年8月15日 下午12:15:49   
 * 修改人：
 * 修改时间：2016年8月15日 下午12:15:49   
 * 修改备注：   
 * @version   V1.0
 */
@Service
public class MenuService {
	private transient final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private ConfigurationMapper configurationMapper;
	/**
	 * 更新菜单
	 * @Title: createMenu
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Menu[] createMenu(){
		log.info("更新微信菜单");
		//获取菜单信息
		Configuration configuration = configurationMapper.selectByPrimaryKey("menu");
		
		Document document = XMLUtil.strToDoc(configuration.getValue());
		Element root = document.getRootElement();
		
		//一级菜单
		Element oneMenuElement = (Element) root.selectSingleNode("//onemenu");
		String oneMenuName = oneMenuElement.attributeValue("name");
		List<Element> subOneMenuElement = oneMenuElement.elements();
		
		List<Menu> oneMenuList = new ArrayList<Menu>();
		for (Element element : subOneMenuElement) {
			String name = element.attributeValue("name");
			String id = element.attributeValue("type");
			String key = element.attributeValue("key");
			Menu subOneMenu = new Menu(name,id,key);
			oneMenuList.add(subOneMenu);
		}
		
		Menu oneMenu = new Menu();
		oneMenu.setName(oneMenuName);
		oneMenu.setSubButtons(oneMenuList);
		
		//二级菜单
		Element twoMenuElement = (Element) root.selectSingleNode("//twomenu");
		String twoMenuName = twoMenuElement.attributeValue("name");
		List<Element> subTwoMenuElement = twoMenuElement.elements();
		List<Menu> twoMenuList = new ArrayList<Menu>();
		for (Element element : subTwoMenuElement) {
			String name = element.attributeValue("name");
			String id = element.attributeValue("type");
			String key = element.attributeValue("key");
			Menu subTwoMenu = new Menu(name,id,key);
			twoMenuList.add(subTwoMenu);
		}
		
		Menu twoMenu = new Menu();
		twoMenu.setName(twoMenuName);
		twoMenu.setSubButtons(twoMenuList);
		
		
		//三级菜单
		Element threeMenuElement = (Element) root.selectSingleNode("//threemenu");
		String threeMenuName = threeMenuElement.attributeValue("name");
		List<Element> subThreeMenuElement = threeMenuElement.elements();
		List<Menu> threeMenuList = new ArrayList<Menu>();
		for (Element element : subThreeMenuElement) {
			String name = element.attributeValue("name");
			String id = element.attributeValue("type");
			String key = element.attributeValue("key");
			Menu subThreeMenu = new Menu(name,id,key);
			threeMenuList.add(subThreeMenu);
		}
		
		Menu threeMenu = new Menu();
		threeMenu.setName(threeMenuName);
		threeMenu.setSubButtons(threeMenuList);
		
		Menu[] customerMenus = {oneMenu,twoMenu,threeMenu};
		return customerMenus;
	}
	/**
	 * 微信客服消息
	 * @Title: getContents
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Content> getContents(String param){
		log.info("机器人自动回复");
    	String path = this.getClass().getClassLoader().getResource("menu.xml").getPath();
    	Document document = XMLUtil.loadXML(path);
    	Element root = document.getRootElement();
    	List<Content> list = new ArrayList<Content>();
    	if(StringUtils.isBlank(param)){
    		Element onemenu = (Element) root.selectSingleNode("//onemenu");
    		List<Element> elements = onemenu.elements();
    		for (Element element : elements) {
    			String message =  element.attributeValue("message");
    			String id = element.attributeValue("id");
    			Content content = new Content(id,message);
    			list.add(content);
    		}
    		return list;
		}else{
			Element submenu = (Element) root.selectSingleNode("//submenu[@id='"+param+"']");
			List<Element> elements = submenu.elements();
			if(elements!=null && elements.size() >0){
				for (Element element : elements) {
					String message =  element.attributeValue("message");
	    			String id = element.attributeValue("id");
	    			Content content = new Content(id,message);
	    			list.add(content);
				}
				return list;
			}
		}
		Content content = new Content();
		content.setMessage("详情请拔打客服电话");
		content.setId("-1");
		list.add(content);
    	return list;
    }
}
