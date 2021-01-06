package com.inso.service;

import java.util.List;

import com.inso.entity.Medicine;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inso.dao.MemberDao;
import com.inso.entity.Member;



@Service
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	
	/**
	 * 查询全部会员等级
	 *  
	 *   @author MH·J
	 */
	public List<Member> selectAllCharge(){
		
		List<Member> member = memberDao.selectAllMember();		
		return member;
	}
	

	/**
	 * 查询单个会员等级
	 * 
	 * @author MH·J
	 */
	public Member selectByPrimaryKey(int memberId){
		
		Member member = memberDao.selectByPrimaryKey(memberId);		
		return member;
	}
	
	
	
	/**
	 * 模糊查询单个会员等级
	 * 
	 * @author MH·J
	 */
	public List<Member> selectBymemberGarde(int memberGarde){
		
		List<Member> member = memberDao.selectBymemberGarde(memberGarde);		
		return member;
	}
	
	
	/**
	 * 删除单个会员等级
	 * 
	 * writer : MH·J
	 */
	public int deleteByPrimaryKey(Integer memberId){
		
		int numb = memberDao.deleteByPrimaryKey(memberId);		
		return numb;
	}
	
	/**
	 * 删除所有
	 * 
	 * writer : MH·J
	 */
	public int deleteByAll(@Param("datas")int[] datas){
		
		int numb = memberDao.deleteByAll(datas);
		return numb;
	}
	
	/**
	 * 插入单个会员等级
	 * 
	 *  writer : MH·J
	 */
	public int insert(Member record){
		
		int numb = memberDao.insert(record);		
		return numb;
	}
	
	/**
	 * 修改单个会员等级
	 * 
	 *   writer : MH·J
	 */
	public int updateByPrimaryKey(Member record){
		
		int numb = memberDao.updateByPrimaryKey(record);		
		return numb;
	}

	/**
	 * 查询所有并分页搜索
	 * @param member
	 * @param pageNum
	 * @param pageSize
     * @return
     */
	public PageInfo<Member> findByPage(Member member, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		if (member.getMemberGarde() != null && !member.getMemberGarde().equals("")) {
			return new PageInfo<Member>(this.memberDao.selectBymemberGarde(member.getMemberGarde()));
		}
		return new PageInfo<Member>(this.memberDao.selectAllMember());

	}
}
