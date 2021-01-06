package com.inso.service;

import java.util.List;

import com.inso.entity.Medicine;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inso.dao.ProvideDao;
import com.inso.entity.Provide;



@Service
public class ProvideService {

	@Autowired
	private ProvideDao provideDao;
	
	/**
	 * 查询全部供应商
	 * 
	 *   @author MH·J
	 */
	public List<Provide> selectAllProvide(){
		
		List<Provide> provide = provideDao.selectAllProvide();		
		return provide;
	}
	

	/**
	 * 查询单个供应商
	 *  
	 *  @author MH·J
	 */
	public Provide selectByPrimaryKey(Integer proId){
		
		Provide provide = provideDao.selectByPrimaryKey(proId);		
		return provide;
	}
	
	
	/**
	 * 模糊查询单个供应商根据名称
	 *  
	 *  @author MH·J
	 */
	public List<Provide> selectByproName(String proName){
		
		List<Provide> provide = provideDao.selectByproName(proName);		
		return provide;
	}
	
	
	
	/**
	 * 删除单个供应商
	 *  
	 *  @author MH·J
	 */
	public int deleteByPrimaryKey(Integer proId){
		
		int numb = provideDao.deleteByPrimaryKey(proId);		
		return numb;
	}
	
	
	/**
	 * 删除所有
	 *  
	 *  @author MH·J
	 */
	public int deleteByAll(@Param("datas")int[] datas){
		
		int numb = provideDao.deleteByAll(datas);		
		return numb;
	}
	
	
	/**
	 * 插入单个供应商
	 *  
	 *  @author MH·J
	 */
	public int insert(Provide record){
		
		int numb = provideDao.insert(record);		
		return numb;
	}
	
	/**
	 * 修改单个供应商
	 *  
	 *  @author MH·J
	 */
	public int updateByPrimaryKey(Provide record){
		
		int numb = provideDao.updateByPrimaryKey(record);		
		return numb;
	}

	/**
	 * 分页查询
	 *
	 * Create By MH·J on 2019/4/20
	 *
	 */
	public PageInfo<Provide> findByPage(Provide provide, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		if (provide.getProName() != null && !provide.getProName().equals("")) {
			return new PageInfo<Provide>(this.provideDao.selectByproName("%"+provide.getProName()+"%"));
		}
		return new PageInfo<Provide>(this.provideDao.selectAllProvide());
	}
}
