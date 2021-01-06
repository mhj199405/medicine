package com.inso.web;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inso.common.DateConsist;
import com.inso.common.ResponseResult;
import com.inso.common.WebDateUtils;
import com.inso.entity.SalaryMan;
import com.inso.service.SalaryManService;



@Controller
@ResponseBody
public class SalaryManController {

	@Autowired
	private SalaryManService salaryManService;
	
	/**
	 * 查询全部薪资集合
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/salaryManList/salaryMan", method = RequestMethod.GET)
     public  ResponseResult medicineeList() throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			List<SalaryMan> salaryMan = salaryManService.selectAllCharge();
 			if (salaryMan != null){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("查询成功");
 	 			result.setData(salaryMan);
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
	 * 查询单个薪资
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/salaryMan/salaryManId", method = RequestMethod.GET)
     public  ResponseResult medicineOne(@Param("saId")int saId) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			SalaryMan salaryMan = salaryManService.selectByPrimaryKey(saId);
 			if (salaryMan != null){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("查询成功");
 	 			result.setData(salaryMan);
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
	 * 查询单个薪资
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/salaryMan/stId", method = RequestMethod.GET)
	public  ResponseResult selectByStId(@Param("stId")int stId) throws Exception{
		
		ResponseResult result = null;
		try {
			SalaryMan salaryMan = salaryManService.selectByStId(stId);
			if (salaryMan != null){
				result = new ResponseResult();
				result.setCode(1);
				result.setMsg("查询成功");
				result.setData(salaryMan);
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
	 * 模糊查询 by stName
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/salaryMan/LikeStName", method = RequestMethod.POST)
	public  ResponseResult selectAllSalaryManByLikeStName(@Param("stName")String stName) throws Exception{
		String stName2 = stName+"%";
		ResponseResult result = null;
		try {
			List<SalaryMan> salaryMan = salaryManService.selectAllSalaryManByLikeStName(stName2);
			if (salaryMan != null){
				result = new ResponseResult();
				result.setCode(1);
				result.setMsg("查询成功");
				result.setData(salaryMan);
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
	 * 删除单个薪资
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/delete/salaryMan/salaryManId", method = RequestMethod.POST)
     public  ResponseResult deleteByPrimaryKey(@Param("salaryManId")int salaryManId) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			int numb = salaryManService.deleteByPrimaryKey(salaryManId);
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
	 * 插入单个薪资
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/insert/salaryMan/salaryMan", method = RequestMethod.POST)
     public  ResponseResult insert(@Param("record")SalaryMan record) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			int numb = salaryManService.insert(record);
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
	 * 修改单个薪资
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/update/salaryMan/salaryMan", method = RequestMethod.POST)
     public  ResponseResult updateByPrimaryKey(@Param("saId")Integer saId,
    		 @Param("saNumber")Long saNumber ) throws Exception{
  	       
		SalaryMan salaryMan = new SalaryMan();		
		salaryMan.setSaId(saId);
		salaryMan.setSaNumber(saNumber);
    	 ResponseResult result = null;
 		try {
 			int numb = salaryManService.updateByPrimaryKey(salaryMan);
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
 			result.setMsg("修改失败");
 		}
 		return result;
 	}
	
	
	
	/**
	 * 签到
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/update/salaryMan/qiandao", method = RequestMethod.POST)
     public  ResponseResult qiandao(@Param("stId")Integer stId) throws Exception{
  	       
		
		// 获得网络时间String
		String format = "HHmmss";

		WebDateUtils wdu = new  WebDateUtils ();
		System.out.println(wdu.getWebsiteDatetime(DateConsist.WEB_URL2, format) + " [中国科学院国家授时中心]");
		String webTime_String = wdu.getWebsiteDatetime(DateConsist.WEB_URL2, format);
	
		long a = Long.parseLong(webTime_String);
		long b = 90000;
		String saChidao = " ";
		SalaryMan salaryMan = salaryManService.selectByStId(stId);	
		if (a > b){
			saChidao = "是";
			
			// 得到原来工资
			Long saNumber = salaryMan.getSaNumber();
				
			if (saNumber != null){
				// 得到zuihou工资
				saNumber = salaryMan.getSaLastsalary();
			}
			// 迟到 工资减去10
			Long saLastsalary = saNumber - 10;
			
			salaryMan.setSaLastsalary(saLastsalary);
		} else {
			saChidao = "否";
		}
		
		salaryMan.setSaChidao(saChidao);


    	 ResponseResult result = null;
 		try {
 			int numb = salaryManService.updateByPrimaryKey(salaryMan);
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
 			result.setMsg("修改失败");
 		}
 		return result;
 	}
	
	
	/**
	 * 签退
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/update/salaryMan/qiantui", method = RequestMethod.POST)
     public  ResponseResult qiantui(@Param("stId")Integer stId) throws Exception{
  	       
		// 获得网络时间String
		String format = "HHmmss";

		WebDateUtils wdu = new  WebDateUtils ();
		System.out.println(wdu.getWebsiteDatetime(DateConsist.WEB_URL2, format) + " [中国科学院国家授时中心]");
		//拿到当前时间（百度）的时分秒的字符串
		String webTime_String = wdu.getWebsiteDatetime(DateConsist.WEB_URL2, format);
		SalaryMan salaryMan = salaryManService.selectByStId(stId);	
		long a = Long.parseLong(webTime_String);
		long b = 170000;
		System.out.println(new Date(b)+"===================");
		String Zaotui = " ";
		String Jiaban = " ";
		if (a < b){
			Zaotui = "是";
			Jiaban = "没加班";
			// 得到原来工资
			Long saNumber = salaryMan.getSaNumber();
			
			
			if (saNumber != null){
				// 得到zuihou工资
				saNumber = salaryMan.getSaLastsalary();
			}
			
			// 属于早退 工资减去10 
			Long saLastsalary = saNumber - 10;
			salaryMan.setSaLastsalary(saLastsalary);
		} else {
			Zaotui = "否";
			Jiaban = "加班";
		}
		
		salaryMan.setSaZaotui(Zaotui);
		salaryMan.setSaOvertime(Jiaban);

    	 ResponseResult result = null;
 		try {
 			int numb = salaryManService.updateByPrimaryKey(salaryMan);
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
 			result.setMsg("修改失败");
 		}
 		return result;
 	}
	
}
