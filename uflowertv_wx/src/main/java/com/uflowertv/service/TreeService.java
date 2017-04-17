package com.uflowertv.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uflowertv.dao.TreeMapper;
import com.uflowertv.model.Tree;
import com.uflowertv.model.TreeAttributes;
import com.uflowertv.model.TreeData;
import com.uflowertv.model.TreeExample;

@Service
public class TreeService{
	private transient final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private TreeMapper treeMapper;
	
	public List<TreeData> getTreeList(String id){
		log.info("获取菜单树");
		TreeExample example = new TreeExample();
		example.createCriteria().andPidEqualTo(id);
		List<Tree> treeList = treeMapper.selectByExample(example);
		List<TreeData> list = new ArrayList<TreeData>();
		for (Tree tree : treeList) {
			TreeData node = new TreeData();
			node.setId(tree.getId());
			node.setText(tree.getName());
			TreeAttributes attr = new TreeAttributes();
			attr.setUrl(tree.getUrl());
			node.setAttributes(attr);
			node.setState(id=="0"?"closed":"open");
			list.add(node);
		}
		return list;
	}
}
