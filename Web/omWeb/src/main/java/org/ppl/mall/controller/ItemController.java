package org.ppl.mall.controller;

import org.ppl.mall.model.DataGridResult;
import org.ppl.mall.pojo.TbItem;
import org.ppl.mall.service.ItemService;
import org.ppl.mall.util.MsgResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品管理Controller
 * @author Smith
 *
 */

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	//通过id查询单个商品
	@RequestMapping("/{id}")
	@ResponseBody
	public TbItem getItemById(@PathVariable("id") Long itemId) {
		return itemService.getItemById(itemId);
	}
	
	//获取商品列表
	@RequestMapping("/list")
	@ResponseBody
	public DataGridResult<TbItem> getItemList(
			@RequestParam("page") Integer pageNum, 
			@RequestParam("rows") Integer pageSize) {
		return itemService.getItemList(pageNum, pageSize);
	}
	
	//添加商品
	@RequestMapping("/save")
	@ResponseBody
	public MsgResult addItem(TbItem item, String desc) {
		return itemService.addItem(item, desc);
	}
	
	//编辑商品-商品基本信息回显
	@RequestMapping("/edit-query/item/{id}")
	@ResponseBody
	public MsgResult editItemQuery(@PathVariable("id") Long itemId) {
		return MsgResult.ok(itemService.getItemById(itemId));
	}
	
	//编辑商品-商品详情回显
	@RequestMapping("/edit-query/item-desc/{id}")
	@ResponseBody
	public MsgResult editItemDescQuery(@PathVariable("id") Long itemId) {
		return MsgResult.ok(itemService.getItemDescById(itemId));
	}
}
