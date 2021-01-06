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
import com.inso.entity.User;
import com.inso.service.UserService;



@Controller
@ResponseBody
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 查询全部用户集合 pageNum 表示当前是第几页；
	 *  pageSize 表示每页显示多少条数据;
	 *  传入参数 User user是为了进行查询或者模糊查询(当User对象中的属性值username为空时，则进行所有数据的分页，
	 *  当username不为空时，进行模糊查询及分页操作)
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/userList/user", method = RequestMethod.GET)
     public PageResult userList(User user, @RequestParam(value = "page") Integer pageNum, @RequestParam(value = "limit") Integer pageSize) throws Exception{
		// 默认情况下是显示第一页的数据
		if (pageNum == null) {
			pageNum = 1;
		}
		// 默认情况下每页显示10条数据
		if (pageSize == null || pageSize > 30) {
			pageSize = 10;
		}
		PageInfo<User> pb = this.userService.findByPage(user, pageNum, pageSize);
		// 将查询出的结果，封装到PageResult类中
		PageResult result = new PageResult();
		if (pb != null) {
			result.setData(pb.getList());
			result.setCode(0);
			result.setCount(pb.getTotal());
		}
		return result;
 	}
 	
	/**
	 * 查询单个用户(根据用户id)
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/user/userId", method = RequestMethod.GET)
     public  ResponseResult medicineOne(@Param("userId")int userId) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			User user = userService.selectByPrimaryKey(userId);
 			if (user != null){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("查询成功");
 	 			result.setData(user);
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
	 * 查询单个用户
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/select/user/userName", method = RequestMethod.POST)
     public  ResponseResult selectByuserName(@Param("userName")String userName) throws Exception{
  	       
		String userName2 = userName+ "%";
		
    	 ResponseResult result = null;
 		try {
 			List<User> user = userService.selectByuserName(userName2);
 			if (user != null){
 				result = new ResponseResult();
 	 			result.setCode(1);
 	 			result.setMsg("查询成功");
 	 			result.setData(user);
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
	 * 删除多个(也就是进行批量删除)
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/delete/user/users", method = RequestMethod.POST)
	public  ResponseResult deleteByAll(@RequestParam(value = "datas[]") int[] datas) throws Exception{

		ResponseResult result = null;
		try {
			int numb = userService.deleteByAll(datas);
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
	 * 删除单个用户
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/delete/user/userId", method = RequestMethod.POST)
     public  ResponseResult deleteByPrimaryKey(@Param("userId")int userId) throws Exception{
  	       
    	 ResponseResult result = null;
 		try {
 			int numb = userService.deleteByPrimaryKey(userId);
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
	 * 插入单个用户
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/insert/user/user", method = RequestMethod.POST)
     public  ResponseResult insert(@Param("userName")String userName,
    		 @Param("birth")String birth,@Param("userPhone")Long userPhone,
    		 @Param("userAddress")String userAddress,@Param("memberDengji")Integer memberDengji,
    		 @Param("balance")Long balance,@Param("point")Integer point,
    		 @Param("records")String records,@Param("recharge")String recharge,
    		 @Param("userMoney")Long userMoney ) throws Exception{
		TimeChange timeChange = new TimeChange();
		User user = new User();
		user.setUserName(userName);
		user.setBirth(timeChange.dateChange(birth));
		user.setUserPhone(userPhone);
		user.setUserAddress(userAddress);
		user.setMemberDengji(memberDengji);
		user.setBalance(balance);
		user.setPoint(point);
		user.setRecords(records);
		user.setRecharge(timeChange.dateChange(recharge));
		user.setUserMoney(userMoney);

		
    	ResponseResult result = null;
 		try {
 			int numb = userService.insert(user);
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
	 * 修改单个用户
	 * @return
	 * @throws Exception
	 * Writer : MH·J
	 */
	@RequestMapping(value = "/update/user/user", method = RequestMethod.POST)
     public  ResponseResult updateByPrimaryKey(@Param("userId")Integer userId,@Param("userName")String userName,
    		 @Param("birth")String birth,@Param("userPhone")Long userPhone,
    		 @Param("userAddress")String userAddress,@Param("memberDengji")Integer memberDengji,
    		 @Param("balance")Long balance,@Param("point")Integer point,
    		 @Param("records")String records,@Param("recharge")String recharge,
    		 @Param("userMoney")Long userMoney ) throws Exception{
		TimeChange timeChange = new TimeChange();
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setBirth(timeChange.dateChange(birth));
		user.setUserPhone(userPhone);
		user.setUserAddress(userAddress);
		user.setMemberDengji(memberDengji);
		user.setBalance(balance);
		user.setPoint(point);
		user.setRecords(records);
		user.setRecharge(timeChange.dateChange(recharge));
		user.setUserMoney(userMoney);
    	 ResponseResult result = null;
 		try {
 			int numb = userService.updateByPrimaryKey(user);
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
