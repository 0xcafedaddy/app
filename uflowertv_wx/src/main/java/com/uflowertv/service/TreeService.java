package com.uflowertv.service;

import com.baomidou.framework.annotations.Log;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.uflowertv.dao.TreeMapper;
import com.uflowertv.model.po.Tree;
import com.uflowertv.model.TreeAttributes;
import com.uflowertv.model.TreeData;
import com.uflowertv.service.support.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("treeService")
public class TreeService extends BaseServiceImpl<TreeMapper,Tree> {


	@Log("获取菜单树")
	public List<TreeData> getTreeList(String id){
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
