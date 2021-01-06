package com.inso.web;

import java.util.List;

import com.inso.entity.Medicine;
import com.inso.entity.vo.PageResult;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inso.common.ResponseResult;
import com.inso.common.TimeChange;
import com.inso.entity.Member;
import com.inso.service.MemberService;



@Controller
@ResponseBody
public class MemberController {

	@Autowired
	private MemberService memberService;

	/**
	 * 查询全部药品集合
	 *
	 * @return
	 * @throws Exception Writer : MH·J
	 */
	@RequestMapping(value = "/select/memberList/member", method = RequestMethod.GET)
	public PageResult medicineeList(Member member, @RequestParam(value = "page") Integer pageNum, @RequestParam(value = "limit") Integer pageSize) throws Exception {

		if (pageNum == null) {
			pageNum = 1;
		}
		if (pageSize == null || pageSize > 30) {
			pageSize = 10;
		}
		PageInfo<Member> pb = this.memberService.findByPage(member, pageNum, pageSize);
		PageResult result = new PageResult();
		if (pb != null) {
			result.setData(pb.getList());
			result.setCode(0);
			result.setCount(pb.getTotal());

		}
		return result;
	}

	/**
	 * 查询单个会员等级
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/member/memberId", method = RequestMethod.GET)
     public  ResponseResult medicineOne(@Param("memberId")int memberId) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			Member member = memberService.selectByPrimaryKey(memberId);
 			if (member != null){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("查询成功");
 	 			result.setData(member);
 	 	 		return result;
 			} else {
 				result = new ResponseResult();
 	 			result.setCode(2);
 	 			result.setMsg("查询失败");
 	 	 		return result;
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 			// 返回结果
 			result = new ResponseResult();
 			result.setCode(2);
 			result.setMsg("查询失败");
 		}
 		return result;
 	}
	
	
	
	/**
	 * 模糊查询单个会员等级
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/member/memberGarde", method = RequestMethod.POST)
     public  ResponseResult selectBymemberGarde(@Param("memberGarde")int memberGarde) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			List<Member> member = memberService.selectBymemberGarde(memberGarde);
 			if (member != null){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("查询成功");
 	 			result.setData(member);
 	 	 		return result;
 			} else {
 				result = new ResponseResult();
 	 			result.setCode(2);
 	 			result.setMsg("查询失败");
 	 	 		return result;
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 			// 返回结果
 			result = new ResponseResult();
 			result.setCode(2);
 			result.setMsg("查询失败");
 		}
 		return result;
 	}


	
	/**
	 * 删除多个
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/delete/member/members", method = RequestMethod.POST)
	public  ResponseResult deleteByAll(@RequestParam(value = "datas[]") int[] datas) throws Exception{

		ResponseResult result = null;
		try {
			int numb = memberService.deleteByAll(datas);
			if (numb == 1){
				result = new ResponseResult();
				result.setCode(1);
				result.setMsg("删除成功");
				return result;
			} else {
				result = new ResponseResult();
				result.setCode(2);
				result.setMsg("删除失败");
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 返回结果
			result = new ResponseResult();
			result.setCode(3);
			result.setMsg("删除失败");
		}
		return result;
	}
	
	
	
	/**
	 * 删除单个会员等级
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/delete/member/memberId", method = RequestMethod.POST)
     public  ResponseResult deleteByPrimaryKey(@Param("memberId")int memberId) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			int numb = memberService.deleteByPrimaryKey(memberId);
 			if (numb == 1){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("删除成功");
 	 	 		return result;
 			} else {
 				result = new ResponseResult();
 	 			result.setCode(2);
 	 			result.setMsg("删除失败");
 	 	 		return result;
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 			// 返回结果
 			result = new ResponseResult();
 			result.setCode(2);
 			result.setMsg("删除失败");
 		}
 		return result;
 	}
	
	
	/**
	 * 插入单个会员等级
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/insert/member/member", method = RequestMethod.POST)
     public  ResponseResult insert(@Param("memberGarde")Integer memberGarde,
    		 @Param("memberLipin")String memberLipin,
    		 @Param("memberLasttime")String memberLasttime) throws Exception{
		Member member = new Member(memberGarde,memberLipin,new TimeChange().dateChange(memberLasttime));
    	 ResponseResult result = null;
 		try {
 			int numb = memberService.insert(member);
 			if (numb == 1){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("插入成功");
 	 	 		return result;
 			} else {
 				result = new ResponseResult();
 	 			result.setCode(2);
 	 			result.setMsg("插入失败");
 	 	 		return result;
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 			// 返回结果
 			result = new ResponseResult();
 			result.setCode(2);
 			result.setMsg("插入失败");
 		}
 		return result;
 	}
	
	/**
	 * 修改单个药品
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/update/member/member", method = RequestMethod.POST)
     public  ResponseResult updateByPrimaryKey(@Param("memberId")Integer memberId,
    		 @Param("memberGarde")Integer memberGarde,
    		 @Param("memberLipin")String memberLipin,
    		 @Param("memberLasttime")String memberLasttime) throws Exception{
		Member member = new Member(memberId,memberGarde,memberLipin,new TimeChange().dateChange(memberLasttime));
  	       
    	 ResponseResult result = null;
 		try {
 			int numb = memberService.updateByPrimaryKey(member);
 			if (numb == 1){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("修改成功");
 	 	 		return result;
 			} else {
 				result = new ResponseResult();
 	 			result.setCode(2);
 	 			result.setMsg("修改失败");
 	 	 		return result;
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 			// 返回结果
 			result = new ResponseResult();
 			result.setCode(2);
 			result.setMsg("修改失败");
 		}
 		return result;
 	}
}
