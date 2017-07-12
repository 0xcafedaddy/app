package com.uflowertv.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.uflowertv.wechat.mapper.TreeMapper;
import com.uflowertv.model.Tree;
import com.uflowertv.model.dto.TreeAttributes;
import com.uflowertv.model.dto.TreeData;
import com.uflowertv.service.support.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreeService extends BaseServiceImpl<TreeMapper,Tree> {

	private Logger log = LoggerFactory.getLogger(getClass());
	public List<TreeData> getTreeList(String id){
		log.info("获取菜单树");
        List<TreeData> list = new ArrayList<TreeData>();
        EntityWrapper<Tree> ew = new EntityWrapper<Tree>();
        ew.where("pid="+id);
        List<Tree> treeList = selectList(ew);
		treeList.forEach(tree -> {
			TreeData node = new TreeData();
			node.setId(tree.getId());
			node.setText(tree.getName());
			TreeAttributes attr = new TreeAttributes();
			attr.setUrl(tree.getUrl());
			node.setAttributes(attr);
			node.setState(id=="0"?"closed":"open");
			list.add(node);
		});
		return list;
	}
}
