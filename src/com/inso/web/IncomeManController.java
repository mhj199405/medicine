package com.inso.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inso.entity.Refund;
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
import com.inso.entity.IncomeMan;
import com.inso.service.IncomeManService;



@Controller
@ResponseBody
public class IncomeManController {

	@Autowired
	private IncomeManService incomeManService;

	/**
	 * 支付方式饼状图
	 * @date:  2019/5/1
	 * @return:
	 */
	@RequestMapping(value = "/pay/statistics",method = RequestMethod.GET)
	public Map staristics(){
		Integer zfb=this.incomeManService.countByCount("支付宝");
		Integer wx=this.incomeManService.countByCount("微信");
		Integer yhk=this.incomeManService.countByCount("银行卡");
		Integer hdfk=this.incomeManService.countByCount("货到付款");
		HashMap<String, Integer> map = new HashMap<>();
		map.put("支付宝",zfb);
		map.put("微信",wx);
		map.put("银行卡",yhk);
		map.put("货到付款",hdfk);
		return map;
	}

	/**
	 * 查询全部收入集合
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/incomeManList/incomeMan", method = RequestMethod.GET)
	public PageResult chargeList(IncomeMan incomeMan, @RequestParam(value = "page") Integer pageNum, @RequestParam(value = "limit") Integer pageSize) throws Exception {

		if (pageNum == null) {
			pageNum = 1;
		}
		if (pageSize == null || pageSize > 30) {
			pageSize = 10;
		}
		PageInfo<IncomeMan> pb = this.incomeManService.findByPage(incomeMan, pageNum, pageSize);
		PageResult result = new PageResult();
		if (pb != null) {
			result.setData(pb.getList());
			result.setCode(0);
			result.setCount(pb.getTotal());

		}
		return result;
	}
 	
	/**
	 * 查询单个收入
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/incomeMan/incomeManId", method = RequestMethod.GET)
     public  ResponseResult medicineOne(@Param("inId")int inId) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			IncomeMan incomeMan = incomeManService.selectByPrimaryKey(inId);
 			if (incomeMan != null){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("查询成功");
 	 			result.setData(incomeMan);
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
	 * 模糊查询单个收入
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/incomeMan/inName", method = RequestMethod.POST)
     public  ResponseResult selectByinName(@Param("inName")String inName) throws Exception{
  	       
		String inName2 = inName + "%";
		
    	 ResponseResult result = null;
 		try {
 			List<IncomeMan> incomeMan = incomeManService.selectByinName(inName2);
 			if (incomeMan != null){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("查询成功");
 	 			result.setData(incomeMan);
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
	 * 删除多个
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/delete/incomeMan/incomeMans", method = RequestMethod.POST)
	public  ResponseResult deleteByAll(@RequestParam(value = "datas[]") int[] datas) throws Exception{

		ResponseResult result = null;
		try {
			int numb = incomeManService.deleteByAll(datas);
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
	 * 删除单个收入
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/delete/incomeMan/incomeManId", method = RequestMethod.POST)
     public  ResponseResult deleteByPrimaryKey(@Param("inId")int inId) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			int numb = incomeManService.deleteByPrimaryKey(inId);
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
	 * 插入单个收入
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/insert/incomeMan/incomeMan", method = RequestMethod.POST)
     public  ResponseResult insert(@Param("inName")String inName,
    		 @Param("inNumber")Integer inNumber,@Param("inOrdernum")Integer inOrdernum,
    		 @Param("inPay")String inPay,@Param("inCard")Integer inCard,
    		 @Param("inCashier")String inCashier,
    		 @Param("inCreateTime")String inCreateTime) throws Exception{
		TimeChange timeChange = new TimeChange();   
		IncomeMan incomeMan = new IncomeMan(inName,inNumber,inOrdernum,inPay,inCard,inCashier,timeChange.dateChange(inCreateTime));
		
    	 ResponseResult result = null;
 		try {
 			int numb = incomeManService.insert(incomeMan);
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
 			result.setMsg("插入失败");
 		}
 		return result;
 	}
	
	/**
	 * 修改单个收入
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/update/incomeMan/incomeMan", method = RequestMethod.POST)
     public  ResponseResult updateByPrimaryKey(@Param("inId")Integer inId,@Param("inName")String inName,
    		 @Param("inNumber")Integer inNumber,@Param("inOrdernum")Integer inOrdernum,
    		 @Param("inPay")String inPay,@Param("inCard")Integer inCard,
    		 @Param("inCashier")String inCashier,
    		 @Param("inCreateTime")String inCreateTime) throws Exception{
		
		TimeChange timeChange = new TimeChange();   
		IncomeMan incomeMan = new IncomeMan(inId,inName,inNumber,inOrdernum,inPay,inCard,inCashier,timeChange.dateChange(inCreateTime));
    	ResponseResult result = null;
 		try {
 			int numb = incomeManService.updateByPrimaryKey(incomeMan);
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
