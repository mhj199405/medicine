package com.inso.service;

import java.util.List;

import com.inso.entity.Medicine;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inso.dao.UserDao;
import com.inso.entity.User;


@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 查询全部用户
     *
     * @author MH·J
     */
    public List<User> selectAllCharge() {

        List<User> user = userDao.selectAllUser();
        return user;
    }


    /**
     * 查询单个用户
     *
     * @author MH·J
     */
    public User selectByPrimaryKey(int chargeId) {

        User user = userDao.selectByPrimaryKey(chargeId);
        return user;
    }


    /**
     * 模糊查询单个用户
     *
     * @author MH·J
     */
    public List<User> selectByuserName(String userName) {

        List<User> user = userDao.selectByuserName(userName);
        return user;
    }


    /**
     * 删除单个用户
     * <p>
     * writer : MH·J
     */
    public int deleteByPrimaryKey(Integer chargeId) {

        int numb = userDao.deleteByPrimaryKey(chargeId);
        return numb;
    }


    /**
     * 删除所有
     * <p>
     * writer : MH·J
     */
    public int deleteByAll(@Param("datas") int[] datas) {

        int numb = userDao.deleteByAll(datas);
        return numb;
    }


    /**
     * 插入单个用户
     * <p>
     * writer : MH·J
     */
    public int insert(User record) {

        int numb = userDao.insert(record);
        return numb;
    }

    /**
     * 修改单个用户
     * <p>
     * writer : MH·J
     */
    public int updateByPrimaryKey(User record) {

        int numb = userDao.updateByPrimaryKey(record);
        return numb;
    }

    /**
     * 分页查询
     * <p>
     * Create By MH·J on 2019/4/22
     */
    public PageInfo<User> findByPage(User user, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        // 进行一个判断，如果传入的参数对象User中,username的值不为空，则调用selectByuserName进行模糊查询
        if (user.getUserName() != null && !user.getUserName().equals("")) {
            return new PageInfo<>(this.userDao.selectByuserName("%" + user.getUserName() + "%"));
        }
        // 如果传入的对象User中的属性值username为空，则调用selectAllUser方法查询所有的用户
        return new PageInfo<>(this.userDao.selectAllUser());
    }
}
