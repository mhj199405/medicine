package com.inso.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inso.dao.IntoManDao;
import com.inso.entity.IntoMan;



@Service
public class IntoManService {

	@Autowired
	private IntoManDao intoManDao;
	
	/**
	 * 查询全部进货
	 *  
	 *   @author MH·J
	 */
	public List<IntoMan> selectAllIntoMan(){
		
		List<IntoMan> intoMan = intoManDao.selectAllIntoMan();		
		return intoMan;
	}
	

	/**
	 * 查询单个进货
	 * 
	 * @author MH·J
	 */
	public IntoMan selectByPrimaryKey(Integer intoId){
		
		IntoMan intoMan = intoManDao.selectByPrimaryKey(intoId);		
		return intoMan;
	}
	
	
	/**
	 * 模糊查询单个进货
	 * 
	 * @author MH·J
	 */
	public List<IntoMan> selectByintoName(String intoName){
		
		List<IntoMan> intoMan = intoManDao.selectByintoName(intoName);		
		return intoMan;
	}
	
	
	/**
	 * 删除所有
	 * 
	 * writer : MH·J
	 */
	public int deleteByAll(@Param("datas")int[] datas){
		
		int numb = intoManDao.deleteByAll(datas);
		return numb;
	}
	
	
	
	/**
	 * 删除单个进货
	 * 
	 * writer : MH·J
	 */
	public int deleteByPrimaryKey(Integer intoId){
		
		int numb = intoManDao.deleteByPrimaryKey(intoId);		
		return numb;
	}
	
	/**
	 * 插入单个进货
	 * 
	 *  writer : MH·J
	 */
	public int insert(IntoMan record){
		
		int numb = intoManDao.insert(record);		
		return numb;
	}
	
	/**
	 * 修改单个进货
	 * 
	 *   writer : MH·J
	 */
	public int updateByPrimaryKey(IntoMan record){
		
		int numb = intoManDao.updateByPrimaryKey(record);		
		return numb;
	}

	/**
	 * 分页 搜索
	 * @param intoMan
	 * @param pageNum
	 * @param pageSize
     * @return
     */
	public PageInfo<IntoMan> findByPage(IntoMan intoMan, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		if (intoMan.getIntoName() != null && !intoMan.getIntoName().equals("")) {
			return new PageInfo<IntoMan>(this.intoManDao.selectByintoName("%"+intoMan.getIntoName()+"%"));
		}
		return new PageInfo<IntoMan>(this.intoManDao.selectAllIntoMan());


	}
}
