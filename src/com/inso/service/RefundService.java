package com.inso.service;

import java.util.List;

import com.inso.entity.Medicine;
import com.inso.entity.Refund;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inso.dao.RefundDao;


@Service
public class RefundService {

	@Autowired
	private RefundDao refundDao;
	
	/**
	 * 查询全部退单
	 *  
	 *   @author MH·J
	 */
	public List<Refund> selectAllCharge(){
		
		List<Refund> refund = refundDao.selectAllCharge();
		return refund;
	}
	

	/**
	 * 查询单个退单
	 * 
	 * @author MH·J
	 */
	public Refund selectByPrimaryKey(int chargeId){
		
		Refund refund = refundDao.selectByPrimaryKey(chargeId);
		return refund;
	}
	
	
	
	/**
	 * 模糊查询单个退单
	 * 
	 * @author MH·J
	 */
	public List<Refund> selectBysolderName(String solderName){
		
		List<Refund> refund = refundDao.selectBysolderName(solderName);
		return refund;
	}
	
	
	/**
	 * 删除所有
	 * 
	 * writer : MH·J
	 */
	public int deleteByAll(@Param("datas")int[] datas){
		
		int numb = refundDao.deleteByAll(datas);
		return numb;
	}
	
	
	/**
	 * 删除单个退单
	 * 
	 * writer : MH·J
	 */
	public int deleteByPrimaryKey(Integer chargeId){
		
		int numb = refundDao.deleteByPrimaryKey(chargeId);
		return numb;
	}
	
	/**
	 * 插入单个退单
	 * 
	 *  writer : MH·J
	 */
	public int insert(Refund record){
		
		int numb = refundDao.insert(record);
		return numb;
	}
	
	/**
	 * 修改单个退单
	 * 
	 *   writer : MH·J
	 */
	public int updateByPrimaryKey(Refund record){
		
		int numb = refundDao.updateByPrimaryKey(record);
		return numb;
	}

	/**
	 * 分页查询
	 *
	 * Create By MH·J on 2019/4/22
	 *
	 */
	public PageInfo<Refund> findByPage(Refund refund, Integer pageNum, Integer pageSize) {

		PageHelper.startPage(pageNum, pageSize);
		if (refund.getSolderName() != null && !refund.getSolderName().equals("")) {
			return new PageInfo<Refund>(this.refundDao.selectBysolderName("%"+refund.getSolderName()+"%"));
		}
		return new PageInfo<Refund>(this.refundDao.selectAllCharge());
	}
}
