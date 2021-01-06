package com.inso.web;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inso.entity.IncomeMan;
import com.inso.entity.vo.PageResult;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inso.common.DateConsist;
import com.inso.common.Md5Util;
import com.inso.common.ResponseResult;
import com.inso.common.TimeChange;
import com.inso.common.WebDateUtils;
import com.inso.entity.SalaryMan;
import com.inso.entity.Staff;
import com.inso.service.SalaryManService;
import com.inso.service.StaffService;



@Controller
@ResponseBody
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	@Autowired
	private SalaryManService salaryManService;

	/**
	 * 登陆
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/staff/login", method = RequestMethod.POST)
	public ResponseResult loginStaff(@Param("stName")String stName,
									 @Param("stPassword")String stPassword) throws Exception{

		ResponseResult result = null;
		//将密码通过MD5加密
		String md5Password = Md5Util.md5Str(stPassword);
		Map<String,Object> map = new HashMap<String,Object>();
		try {

			Staff staff = staffService.selectByNameAndPassword(stName,md5Password);

			if (staff != null ) {
				// 登录成功
				map.put("stId",staff.getStId());
				map.put("stGrade",staff.getStGrade() );
				map.put("stDepartment", staff.getStDepartment());
				map.put("stName", staff.getStName());

				result = new ResponseResult();
				result.setCode(1);
				result.setMsg("登陆成功");
				result.setData(map);
				return result;
			} else {
				// 登录失败
				result = new ResponseResult();
				result.setCode(2);
				result.setMsg("登陆失败");
				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
			// 返回结果
			result = new ResponseResult();
			result.setCode(3);
			result.setMsg("服务器异常");
		}
		return result;
	}

/*	*//**
	 * 查询全部员工集合
	 * 
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 *//*
	@RequestMapping(value = "/select/staffList/staff", method = RequestMethod.GET)
	public PageResult staffList(Staff staff, @RequestParam(value = "page") Integer pageNum, @RequestParam(value = "limit") Integer pageSize) throws Exception {

		if (pageNum == null) {
			pageNum = 1;
		}
		if (pageSize == null || pageSize > 30) {
			pageSize = 10;
		}
		PageInfo<Staff> pb = this.staffService.findByPage(staff, pageNum, pageSize);
		PageResult result = new PageResult();
		if (pb != null) {
			result.setData(pb.getList());
			result.setCode(0);
			result.setCount(pb.getTotal());

		}
		return result;
	}*/
 	
	/**
	 * 查询单个员工根据员工编号
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/staff/staffId", method = RequestMethod.GET)
     public  ResponseResult staffOne(@Param("stId")int stId) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			Staff staff = staffService.selectByPrimaryKey(stId);
 			if (staff != null){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("查询成功");
 	 			result.setData(staff);
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
 			result.setCode(3);
 			result.setMsg("查询失败");
 		}
 		return result;
 	}


	
	/**
	 * 模糊查询查询单个员工根据员工姓名或员工编号
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/staff/staffName", method = RequestMethod.POST)
     public  ResponseResult retrieveUserByIdAndName(@Param("stName")String stName){
  	     
		 	    
    	ResponseResult result = null;
    	 
    	try {
			Long long_stName = Long.parseLong(stName);
	 		try {
	 			String namei = stName+"%";
	 			List staffList = staffService.retrieveUserBystOrdernum(long_stName);
	 			if (staffList != null){
	 				result = new ResponseResult();
	 	 			result.setCode(1);
	 	 			result.setMsg("查询成功");
	 	 			result.setData(staffList);
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
	 			result.setCode(3);
	 			result.setMsg("查询失败");
	 		}
		} catch (Exception e) {
	 		try {
	 			String namei = stName+"%";
	 			List staffList = staffService.retrieveUserByIdAndName(namei);
	 			if (staffList != null){
	 				result = new ResponseResult();
	 	 			result.setCode(1);
	 	 			result.setMsg("查询成功");
	 	 			result.setData(staffList);
	 	 	 		return result;
	 			} else {
	 				result = new ResponseResult();
	 	 			result.setCode(2);
	 	 			result.setMsg("查询失败");
	 	 	 		return result;
	 			}
	 		} catch (Exception e1) {
	 			e.printStackTrace();
	 			// 返回结果
	 			result = new ResponseResult();
	 			result.setCode(3);
	 			result.setMsg("查询失败");
	 		}
		}
		return result;
    	 
 	}
	
	
	
	
	/**
	 * 模糊查询查询单个员工根据员工bianhao
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	/*@RequestMapping(value = "/select/staff/stOrdernum", method = RequestMethod.POST)
     public  ResponseResult retrieveUserByIdAndName(@Param("stOrdernum")Long stOrdernum) throws Exception{
  	      // System.out.println(names);

    	 ResponseResult result = null;
 		try {
 			Staff staff = staffService.retrieveUserBystOrdernum(stOrdernum);
 			if (staff != null){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("查询成功");
 	 			result.setData(staff);
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
 			result.setCode(3);
 			result.setMsg("查询失败");
 		}
 		return result;
 	}*/
	
	
	
	/**
	 * 删除多个
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/delete/staff/staffs", method = RequestMethod.POST)
	public  ResponseResult deleteByAll(@RequestParam(value = "datas[]") int[] datas) throws Exception{

		ResponseResult result = null;
		try {
			int numb = staffService.deleteByAll(datas);
			int num2 = salaryManService.deleteByAllByStIds(datas);
 			if (numb == 1 ){
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
	 * 删除单个员工
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/delete/staff/staffId", method = RequestMethod.POST)
     public  ResponseResult deleteByPrimaryKey(@Param("stId")int stId) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			int numb = staffService.deleteByPrimaryKey(stId);
 			int num2 = salaryManService.deleteByStId(stId);
 			if (numb == 1 && num2 == 1){
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
	 * 插入单个员工
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/insert/staff/staff", method = RequestMethod.POST)
     public  ResponseResult insert(@Param("StaffstName")String stName,
		    		 @Param("stSex")String stSex,
		    		 @Param("stBirth")String stBirth,
		    		 @Param("stPhone1")Long stPhone1,
		    		 @Param("stPhone2")Long stPhone2,
		    		 @Param("stIds")Long stIds,
		    		 @Param("stDepartment")String stDepartment) throws Exception{

		
		
		// 获得网络时间String
		String format = "yyyy-MM-dd HH:mm:ss";
		String format2 = "yyyyMMddHHmmss";
		WebDateUtils wdu = new  WebDateUtils ();
		System.out.println(wdu.getWebsiteDatetime(DateConsist.WEB_URL2, format) + " [中国科学院国家授时中心]");
		String webTime_String = wdu.getWebsiteDatetime(DateConsist.WEB_URL2, format);
		String webTime2_String = wdu.getWebsiteDatetime(DateConsist.WEB_URL2, format2);
		
		
		
		// 系统生成编号	
 		Long stOrdernum  = null;
 		if(webTime2_String!=null){
 			stOrdernum = Long.parseLong(webTime2_String.toString().trim());
 		}
 		
 		// 设置身份为3
 		Integer stGrade = 3;
 		
 		// 获取出生年份
 		String birthYear_Str = stBirth.substring(0, 4);
 		int birthYear = Integer.parseInt(birthYear_Str);
 		int stAge = 2018 - birthYear;
 		
 		// 设置初始密码 123456
 		String stPassword = "123456";
 		String md5Password = Md5Util.md5Str(stPassword);
 		
 		
 		
		TimeChange timeChange = new TimeChange ();
		Timestamp stCreatTime = timeChange.dateChange(webTime_String);
		Timestamp stUpdateTime = timeChange.dateChange(webTime_String);
 		
 		
		Staff staff = new Staff( );
		staff.setStName(stName);
		staff.setStOrdernum(stOrdernum);
		staff.setStSex(stSex); 
		staff.setStGrade(stGrade);
		staff.setStBirth(timeChange.dateChange(stBirth));
		staff.setStAge(stAge);
		staff.setStPhone1(stPhone1);
		staff.setStPhone2(stPhone2);
		staff.setStIds(stIds);
		staff.setStDepartment(stDepartment);
		staff.setStPassword(md5Password);
		staff.setStCreatTime(stCreatTime);
		staff.setStUpdateTime(stUpdateTime);
		
		SalaryMan salaryMan = new SalaryMan();
 
		ResponseResult result = null;
 		try {
 			int numb = staffService.insert(staff);
 			
 			System.out.println("主键ID："+" " + staff.getStId());
 			
 			int a = 2000;
 			long b = (int)a;
 			salaryMan.setSaNumber(b);
 			salaryMan.setSaLastsalary(b);
 			salaryMan.setStId(staff.getStId());
 			
 			salaryMan.setSaZaotui("新员工未签退");
 			salaryMan.setSaChidao("新员工未签到");
 			salaryMan.setSaOvertime("新员工未加班");
 			salaryManService.insert(salaryMan);
 			
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
 			result.setCode(3);
 			result.setMsg("服务器原因插入失败");
 		}
 		return result;
 	}
	
	/**
	 * 修改单个员工信息
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/update/staff/staff", method = RequestMethod.POST)
     public  ResponseResult updateByPrimaryKey(@Param("StId")Integer stId,
    		 @Param("StaffstName")String stName,
    		 @Param("stSex")String stSex,
    		 @Param("stBirth")String stBirth,
    		 @Param("stPhone1")Long stPhone1,
    		 @Param("stPhone2")Long stPhone2,
    		 @Param("stIds")Long stIds,
    		 @Param("stPassword")String stPassword) throws Exception{
  	       
		Staff staff_select = staffService.selectByPrimaryKey(stId);
		String md5Password = staff_select.getStPassword();
	//	System.out.println("接收前段发来的密码："+stPassword);
	//	System.out.println("得到数据库密码："+staff_select.getStPassword());
	//	System.out.println("初始化加盐密码："+md5Password);

		if (!staff_select.getStPassword().equals(stPassword)){
			md5Password = Md5Util.md5Str(stPassword);
		}
			
		
		// 获得网络时间String
		String format = "yyyy-MM-dd HH:mm:ss";

		WebDateUtils wdu = new  WebDateUtils ();
		System.out.println(wdu.getWebsiteDatetime(DateConsist.WEB_URL2, format) + " [中国科学院国家授时中心]");
		String webTime_String = wdu.getWebsiteDatetime(DateConsist.WEB_URL2, format);
	
 		
 		
 		// 获取出生年份
 		String birthYear_Str = stBirth.substring(0, 4);
 		int birthYear = Integer.parseInt(birthYear_Str);
 		int stAge =  2018 - birthYear;
 		 		
 		
		TimeChange timeChange = new TimeChange ();

		Timestamp stUpdateTime = timeChange.dateChange(webTime_String);
 		
 		
		Staff staff = new Staff( );
		staff.setStId(stId);
		staff.setStName(stName);

		staff.setStSex(stSex); 

		staff.setStBirth(timeChange.dateChange(stBirth));
		staff.setStAge(stAge);
		staff.setStPhone1(stPhone1);
		
		if (stPhone2 != null) {
			staff.setStPhone2(stPhone2);
			staff.setStIds(stIds);
		} 
		
		staff.setStPassword(md5Password);

		staff.setStUpdateTime(stUpdateTime);
		
    	ResponseResult result = null;
 		try {
 			int numb = staffService.updateByPrimaryKey(staff);
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
 			result.setCode(3);
 			result.setMsg("服务器原因修改失败");
 		}
 		return result;
 	}
	
	
	
	/**
	 * 店铺权限分配
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/staff/staffGrade", method = RequestMethod.GET)
     public ResponseResult PermissionsAllocation(@Param("stId")int stId) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			Staff staff = staffService.selectByPrimaryKey(stId);
 			if(staff != null){
 			List<Staff> staffGrade = staffService.selectStaffGrade(staff.getStGrade());
 			
 			staffGrade.add(staff);
 			if (staffGrade != null){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("查询成功");
 	 			result.setData(staffGrade);
 	 	 		return result;
 			} else {
 				result = new ResponseResult();
 	 			result.setCode(2);
 	 			result.setMsg("查询失败");
 	 	 		return result;
 			} 
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 			// 返回结果
 			result = new ResponseResult();
 			result.setCode(3);
 			result.setMsg("查询失败");
 		}
 		return result;
 	}
	
	
	

	
	
	
	
	
	
	
	
}
