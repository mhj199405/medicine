package com.inso.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.inso.entity.SoldNote;
import com.inso.service.SoldNoteService;



@Controller
@ResponseBody
public class SoldNoteController {

	@Autowired
	private SoldNoteService soldNoteService;
	
	/**
	 * 查询全部销售记录集合
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/soldNoteList/soldNote", method = RequestMethod.GET)
	public PageResult medicineeList(SoldNote soldNote, @RequestParam(value = "page") Integer pageNum, @RequestParam(value = "limit") Integer pageSize) throws Exception {

		if (pageNum == null) {
			pageNum = 1;
		}
		if (pageSize == null || pageSize > 30) {
			pageSize = 10;
		}
		PageInfo<SoldNote> pb = this.soldNoteService.findByPage(soldNote, pageNum, pageSize);
		PageResult result = new PageResult();
		if (pb != null) {
			result.setData(pb.getList());
			result.setCode(0);
			result.setCount(pb.getTotal());

		}
		return result;
	}
 	
	/**
	 * 查询单个销售记录
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/soldNote/soldNoteId", method = RequestMethod.GET)
     public  ResponseResult medicineOne(@Param("soldId")int soldId) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			SoldNote soldNote = soldNoteService.selectByPrimaryKey(soldId);		
 			if (soldNote != null){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("查询成功");
 	 			result.setData(soldNote);
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
	 * 模糊查询单个销售记录
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/soldNote/solderName", method = RequestMethod.POST)
     public  ResponseResult selectBysolderName(@Param("solderName")String solderName) throws Exception{
  	       
		String solderName2 = solderName+ "%"; 
		
    	 ResponseResult result = null;
 		try {
 			List<SoldNote> soldNote = soldNoteService.selectBysolderName(solderName2);		
 			if (soldNote != null){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("查询成功");
 	 			result.setData(soldNote);
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
	@RequestMapping(value = "/delete/soldNote/soldNotes", method = RequestMethod.POST)
	public  ResponseResult deleteByAll(@RequestParam(value = "datas[]") int[] datas) throws Exception{

		ResponseResult result = null;
		try {
			int numb = soldNoteService.deleteByAll(datas);
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
	 * 删除单个销售记录
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/delete/soldNote/soldNoteId", method = RequestMethod.POST)
     public  ResponseResult deleteByPrimaryKey(@Param("soldId")int soldId) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			int numb = soldNoteService.deleteByPrimaryKey(soldId);		
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
	 * 插入单个销售记录
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/insert/soldNote/soldNote", method = RequestMethod.POST)
     public  ResponseResult insert(@Param("solderName")String solderName,@Param("soldTime")String soldTime,@Param("customerName")String customerName) throws Exception{

		// orid系统生成
		String orderId_Str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		Long orderId  = null;
		if(orderId_Str!=null){
			orderId = Long.parseLong(orderId_Str.toString().trim());
		}

		SoldNote soldNote = new SoldNote(solderName,new TimeChange().dateChange(soldTime),orderId,customerName);
		
    	 ResponseResult result = null;
 		try {
 			int numb = soldNoteService.insert(soldNote);	
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
	 * 修改单个销售记录
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/update/soldNote/soldNote", method = RequestMethod.POST)
     public  ResponseResult updateByPrimaryKey(@Param("soldId")Integer soldId,@Param("solderName")String solderName,@Param("orderId")Long orderId,
    		 @Param("soldTime")String soldTime,@Param("customerName")String customerName) throws Exception{
  	       
    	 ResponseResult result = null;
    	 SoldNote soldNote = new SoldNote();
    	 soldNote.setSoldId(soldId);
    	 soldNote.setSolderName(solderName);
    	 soldNote.setSoldTime(new TimeChange().dateChange(soldTime));
    	 soldNote.setCustomerName(customerName);
    	 soldNote.setOrderId(orderId);
 		try {
 			int numb = soldNoteService.updateByPrimaryKey(soldNote);		
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
