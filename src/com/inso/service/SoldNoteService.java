package com.inso.service;

import java.util.List;

import com.inso.entity.Medicine;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inso.dao.SoldNoteDao;
import com.inso.entity.SoldNote;


@Service
public class SoldNoteService {

    @Autowired
    private SoldNoteDao soldNoteDao;

    /**
     * 查询全部销售记录
     * * writer : MH·J
     */
    public List<SoldNote> selectAllSoldNote() {

        List<SoldNote> soldNote = soldNoteDao.selectAllSoldNote();
        return soldNote;
    }


    /**
     * 查询单个销售记录
     * * writer : MH·J
     */
    public SoldNote selectByPrimaryKey(Integer soldId) {

        SoldNote soldNote = soldNoteDao.selectByPrimaryKey(soldId);
        return soldNote;
    }


    /**
     * 模糊查询单个销售记录根据名称
     * * writer : MH·J
     */
    public List<SoldNote> selectBysolderName(String solderName) {

        List<SoldNote> soldNote = soldNoteDao.selectBysolderName(solderName);
        return soldNote;
    }

    /**
     * 删除单个销售记录
     * <p>
     * writer : MH·J
     */
    public int deleteByPrimaryKey(Integer soldId) {

        int numb = soldNoteDao.deleteByPrimaryKey(soldId);
        return numb;
    }


    /**
     * 删除所以
     * <p>
     * writer : MH·J
     */
    public int deleteByAll(@Param("datas") int[] datas) {

        int numb = soldNoteDao.deleteByAll(datas);
        return numb;
    }


    /**
     * 插入单个销售记录
     * <p>
     * * writer : MH·J
     */
    public int insert(SoldNote record) {

        int numb = soldNoteDao.insert(record);
        return numb;
    }

    /**
     * 修改单个药品
     * <p>
     * writer : MH·J
     */
    public int updateByPrimaryKey(SoldNote record) {

        int numb = soldNoteDao.updateByPrimaryKey(record);
        return numb;
    }

    /**
     * 分页查询
     * Create By MH·J on 2019/4/21
     */
    public PageInfo<SoldNote> findByPage(SoldNote soldNote, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        if (soldNote.getSolderName() != null && !soldNote.getSolderName().equals("")) {
            return new PageInfo<SoldNote>(this.soldNoteDao.selectBysolderName("%" + soldNote.getSolderName() + "%"));
        }
        return new PageInfo<SoldNote>(this.soldNoteDao.selectAllSoldNote());

    }
}
