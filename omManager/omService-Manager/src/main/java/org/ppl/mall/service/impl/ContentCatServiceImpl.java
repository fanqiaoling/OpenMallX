package org.ppl.mall.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ppl.mall.mapper.TbContentCategoryMapper;
import org.ppl.mall.model.TreeNode;
import org.ppl.mall.pojo.TbContentCategory;
import org.ppl.mall.pojo.TbContentCategoryExample;
import org.ppl.mall.service.ContentCatService;
import org.ppl.mall.util.MsgResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 内容分类Service
 * @author PPL
 */
@Service
public class ContentCatServiceImpl implements ContentCatService {

    /*********************Field**********************/
    /*-------------------field-----------------------*/
	@Autowired
	private TbContentCategoryMapper contentCatMapper;


    /*********************Method**********************/
    /*-----------------public method-----------------*/

    /**
	 * 查询内容分类指定父节点ID下的子节点
	 * @param parentId 父节点ID
	 * @return 结果集
	 */
	@Override
	public List<TreeNode> getContentCatList(long parentId) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		TbContentCategoryExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> result = contentCatMapper.selectByExample(example);
		List<TreeNode> nodeList = new ArrayList<>();
		for(TbContentCategory cat:result) {
			TreeNode node = new TreeNode();
			node.setId(cat.getId());
			node.setText(cat.getName());
			node.setState(cat.getIsParent()?"closed":"open");
			nodeList.add(node);
		}
		return nodeList;
	}

    /**
     * 添加内容分类
     * @param parentId 父节点ID
     * @param name 分类名称
     * @return 添加是否成功
     */
	@Override
	public MsgResult addContentCat(long parentId, String name) {
		TbContentCategory parentNode = contentCatMapper.selectByPrimaryKey(parentId);
		parentNode.setIsParent(true);
		contentCatMapper.updateByPrimaryKey(parentNode);
		
		Date curTime = new Date();
		TbContentCategory newNode = new TbContentCategory();
		newNode.setParentId(parentId);
		newNode.setName(name);
		newNode.setStatus(TbContentCategory.CONTENTCAT_NORMAL);
		newNode.setSortOrder(1);
		newNode.setIsParent(false);
		newNode.setCreated(curTime);
		newNode.setUpdated(curTime);
		contentCatMapper.insertSelective(newNode);
		
		return MsgResult.ok(newNode);
	}

    /**
     * 更新内容分类
     * @param id 节点ID
     * @param name 节点新名称
     * @return 更新是否成功
     */
	@Override
	public MsgResult updateContentCat(Long id, String name) {
		TbContentCategory cat = new TbContentCategory();
		cat.setId(id);
		cat.setName(name);
		cat.setUpdated(new Date());
		contentCatMapper.updateByPrimaryKeySelective(cat);
		return MsgResult.ok();
	}

    /**
     * 删除分类(包括子节点)
     * @param id 节点ID
     * @return 删除是否成功
     */
	@Override
	public MsgResult deleteContentCat(Long id) {
		deleteContentCatLoop(id);
		return MsgResult.ok();
	}
	private void deleteContentCatLoop(Long id) {
		TbContentCategory parent = contentCatMapper.selectByPrimaryKey(id);
		contentCatMapper.deleteByPrimaryKey(id);
		if(!parent.getIsParent())
			return;
		TbContentCategoryExample example = new TbContentCategoryExample();
		TbContentCategoryExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(id);
		List<TbContentCategory> list = contentCatMapper.selectByExample(example);
		for(TbContentCategory c:list) {
			deleteContentCatLoop(c.getId());	
		}
	}
}
