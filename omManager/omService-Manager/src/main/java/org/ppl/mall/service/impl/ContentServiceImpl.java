package org.ppl.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.ppl.mall.jedis.JedisClient;
import org.ppl.mall.mapper.TbContentMapper;
import org.ppl.mall.model.DataGridResult;
import org.ppl.mall.pojo.TbContent;
import org.ppl.mall.pojo.TbContentExample;
import org.ppl.mall.pojo.TbContentExample.Criteria;
import org.ppl.mall.service.ContentService;
import org.ppl.mall.util.JsonUtils;
import org.ppl.mall.util.MsgResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 内容Service
 * @author PPL
 */
@Service
public class ContentServiceImpl implements ContentService {

	/*********************Field**********************/
	/*-------------------field-----------------------*/
	@Autowired
	private TbContentMapper contentMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${redis.content_list}")
	private String CONTENT_LIST;


    /*********************Method**********************/
    /*-----------------public method-----------------*/

    /**
     * 分页查询内容列表
     * @param catId 内容ID
     * @param pageNum 页号
     * @param pageSize 页长
     * @return DataGrid格式结果集
     */
	@Override
	public DataGridResult<TbContent> getContentList(Long catId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(catId);
		List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		DataGridResult<TbContent> dgResult = new DataGridResult<>();
		dgResult.setTotal(pageInfo.getTotal());
		dgResult.setRows(pageInfo.getList());
		return dgResult;
	}

    /**
     * 查询内容列表
     * @param catId 内容ID
     * @return List<TbContent>
     */
	@Override
	public List<TbContent> getContentList(Long catId) {
		//优先查询redis缓存
		String json = jedisClient.hget(CONTENT_LIST, catId.toString());
		if(StringUtils.isNotBlank(json)) {
			List<TbContent> list = JsonUtils.jsonToList(json, TbContent.class);
			System.out.println("get data from Redis!!!");
			return list;
		}
		
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(catId);
		List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);
		System.out.println("get data from Mysql!!!");
		
		//首次查询，将结果保存到redis缓存
		jedisClient.hset(CONTENT_LIST, catId.toString(), JsonUtils.objectToJson(list));
		return list;
	}

    /**
     * 添加内容
     * @param content pojo
     * @return 添加是否成功
     */
	@Override
	public MsgResult addContent(TbContent content) {
		Date curTime = new Date();
		content.setCreated(curTime);
		content.setUpdated(curTime);
		contentMapper.insertSelective(content);
		//更新数据后删除redis
		jedisClient.hdel(CONTENT_LIST, content.getCategoryId().toString());
		return MsgResult.ok();
	}

    /**
     * 删除内容
     * @param id 内容ID
     * @return 删除是否成功
     */
	@Override
	public MsgResult deleteContents(Long id) {
		//删除前保留cid用于删除缓存
		TbContent content = contentMapper.selectByPrimaryKey(id);
		Long cid = content.getCategoryId();
		contentMapper.deleteByPrimaryKey(id);
		//更新数据后删除redis
		jedisClient.hdel(CONTENT_LIST, cid.toString());
		return MsgResult.ok();
	}

    /**
     * 编辑内容
     * @param content pojo
     * @return 编辑是否成功
     */
	@Override
	public MsgResult editContent(TbContent content) {
		content.setUpdated(new Date());
		contentMapper.updateByPrimaryKeySelective(content);
		//更新数据后删除redis
		jedisClient.hdel(CONTENT_LIST, content.getCategoryId().toString());
		return MsgResult.ok();
	}
}
