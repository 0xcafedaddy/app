package com.uflowertv.wechat.service;

import com.baomidou.framework.annotations.Log;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.uflowertv.wechat.mapper.TreeMapper;
import com.uflowertv.wechat.model.Tree;
import com.uflowertv.bean.dto.TreeAttributes;
import com.uflowertv.bean.dto.TreeData;
import com.uflowertv.wechat.service.support.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
