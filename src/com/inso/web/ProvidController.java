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
import com.inso.entity.Provide;
import com.inso.service.ProvideService;



@Controller
@ResponseBody
public class ProvidController {

	@Autowired
	private ProvideService provideService;
	
	/**
	 * 查询全部供应商集合
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/provideList/provide", method = RequestMethod.GET)
	public PageResult medicineeList(Provide provide, @RequestParam(value = "page") Integer pageNum, @RequestParam(value = "limit") Integer pageSize) throws Exception {

		if (pageNum == null) {
			pageNum = 1;
		}
		if (pageSize == null || pageSize > 30) {
			pageSize = 10;
		}
		PageInfo<Provide> pb = this.provideService.findByPage(provide, pageNum, pageSize);
		PageResult result = new PageResult();
		if (pb != null) {
			result.setData(pb.getList());
			result.setCode(0);
			result.setCount(pb.getTotal());

		}
		return result;
	}
 	
	/**
	 * 查询单个供应商
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/provide/provideId", method = RequestMethod.GET)
     public  ResponseResult medicineOne(@Param("proId")int proId) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			Provide provide = provideService.selectByPrimaryKey(proId);		
 			if (provide != null){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("查询成功");
 	 			result.setData(provide);
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
	 * 模糊查询单个供应商根据名称
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/provide/proName", method = RequestMethod.POST)
     public  ResponseResult selectByproName(@Param("proName")String proName) throws Exception{
  	    
		String proName2 = proName+"%";
		
    	 ResponseResult result = null;
 		try {
 			List<Provide> provide = provideService.selectByproName(proName2);		
 			if (provide != null){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("查询成功");
 	 			result.setData(provide);
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
	@RequestMapping(value = "/delete/provide/provides", method = RequestMethod.POST)
	public  ResponseResult deleteByAll(@RequestParam(value = "datas[]") int[] datas) throws Exception{

		ResponseResult result = null;
		try {
			int numb = provideService.deleteByAll(datas);
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
	 * 删除单个供应商
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/delete/provide/provideId", method = RequestMethod.POST)
     public  ResponseResult deleteByPrimaryKey(@Param("proId")int proId) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			int numb = provideService.deleteByPrimaryKey(proId);	
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
	 * 插入单个供应商
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/insert/provide/provide", method = RequestMethod.POST)
     public  ResponseResult insert(@Param("proName")String proName,@Param("medType")String medType,
    		 @Param("orders")String orders) throws Exception{

    	 ResponseResult result = null;
    	 
    	// orid系统生成
 		String proNum_Str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
 		Long proNum  = null;
 		if(proNum_Str!=null){
 			proNum = Long.parseLong(proNum_Str.toString().trim());
 		}
    	
 		Provide provide = new Provide();
 		provide.setProName(proName);
 		provide.setProNum(proNum);
 		provide.setOrders(orders);
 		provide.setMedType(medType);
 		try {
 			int numb = provideService.insert(provide);		
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
	 * 修改单个供应商
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/update/provide/provide", method = RequestMethod.POST)
     public  ResponseResult updateByPrimaryKey(@Param("proId")Integer proId,@Param("proName")String proName,
    		 @Param("proNum")Long proNum,@Param("medType")String medType,
    		 @Param("orders")String orders) throws Exception{
  	       System.out.println(proId);
 		Provide provide = new Provide();
 		provide.setProName(proName);
 		provide.setProId(proId);
 		provide.setOrders(orders);
 		provide.setMedType(medType);
 		provide.setProNum(proNum);
		
    	 ResponseResult result = null;
 		try {
 			int numb = provideService.updateByPrimaryKey(provide);
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
