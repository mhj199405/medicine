package com.inso.service;

import java.util.List;

import com.inso.entity.Refund;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inso.dao.IncomeManDao;
import com.inso.entity.IncomeMan;


/**
 * 
 * @author MH·J
 *
 */
@Service
public class IncomeManService {

	@Autowired
	private IncomeManDao incomeManDao;
	
	/**
	 * 查询全部收入
	 *  
	 *   @author MH·J
	 */
	public List<IncomeMan> selectAllIncomeMan(){
		
		List<IncomeMan> incomeMan = incomeManDao.selectAllIncomeMan();		
		return incomeMan;
	}
	

	/**
	 * 查询单个收入
	 * 
	 * @author MH·J
	 */
	public IncomeMan selectByPrimaryKey(Integer inId){
		
		IncomeMan incomeMan = incomeManDao.selectByPrimaryKey(inId);		
		return incomeMan;
	}
	
	
	/**
	 * 模糊查询单个收入
	 * 
	 * @author MH·J
	 */
	public List<IncomeMan> selectByinName(String inName){
		
		List<IncomeMan> incomeMan = incomeManDao.selectByinName(inName);		
		return incomeMan;
	}
	
	
	/**
	 * 删除所有
	 * 
	 * writer : MH·J
	 */
	public int deleteByAll(@Param("datas")int[] datas){
		
		int numb = incomeManDao.deleteByAll(datas);
		return numb;
	}
	
	
	/**
	 * 删除单个收入
	 * 
	 * writer : MH·J
	 */
	public int deleteByPrimaryKey(Integer inId){
		
		int numb = incomeManDao.deleteByPrimaryKey(inId);		
		return numb;
	}
	
	/**
	 * 插入单个收入
	 * 
	 *  writer : MH·J
	 */
	public int insert(IncomeMan record){
		
		int numb = incomeManDao.insert(record);		
		return numb;
	}
	
	/**
	 * 修改单个收入
	 * 
	 *   writer : MH·J
	 */
	public int updateByPrimaryKey(IncomeMan record){
		
		int numb = incomeManDao.updateByPrimaryKey(record);		
		return numb;
	}

	/**
	 * 分页+搜索+findAll
	 * @param incomeMan
	 * @param pageNum
	 * @param pageSize
     * @return
     */
	public PageInfo<IncomeMan> findByPage(IncomeMan incomeMan, Integer pageNum, Integer pageSize) {

		PageHelper.startPage(pageNum, pageSize);
		if (incomeMan.getInName() != null && !incomeMan.getInName().equals("")) {
			return new PageInfo<IncomeMan>(this.incomeManDao.selectByinName("%"+incomeMan.getInName()+"%"));
		}
		return new PageInfo<IncomeMan>(this.incomeManDao.selectAllIncomeMan());

	}

	/**
	 * 分组统计支付方式
	 * @date:  2019/5/1
	 * @return:
	 */
	public Integer countByCount(String inPay) {
		return this.incomeManDao.countByCount(inPay);
	}


}
