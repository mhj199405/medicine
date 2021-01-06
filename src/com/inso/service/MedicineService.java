package com.inso.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inso.dao.MedicineDao;
import com.inso.entity.Medicine;
import org.springframework.util.StringUtils;


@Service
public class MedicineService {

    @Autowired
    private MedicineDao medicineDao;

    /**
     * 查询全部药品
     * * writer : MH·J
     */
    public List<Medicine> selectAllMedicine() {

        List<Medicine> medicine = medicineDao.selectAllMedicine();
        return medicine;
    }


    /**
     * 查询单个药品
     * * writer : MH·J
     */
    public Medicine selectByPrimaryKey(Integer mId) {

        Medicine medicine = medicineDao.selectByPrimaryKey(mId);
        return medicine;
    }


    /**
     * 查询单个药品根据药品名
     * * writer : MH·J
     */
    public List<Medicine> selectBymedName(String medName) {

        List<Medicine> medicine = medicineDao.selectBymedName(medName);
        return medicine;
    }


    /**
     * 删除所有
     * <p>
     * writer : MH·J
     */
    public int deleteByAll(@Param("datas") int[] datas) {

        int numb = medicineDao.deleteByAll(datas);
        return numb;
    }


    /**
     * 删除单个药品
     * <p>
     * writer : MH·J
     */
    public int deleteByPrimaryKey(Integer mId) {

        int numb = medicineDao.deleteByPrimaryKey(mId);
        return numb;
    }

    /**
     * 插入单个药品
     * <p>
     * * writer : MH·J
     */
    public int insert(Medicine record) {

        int numb = medicineDao.insert(record);
        return numb;
    }

    /**
     * 修改单个药品
     * <p>
     * writer : MH·J
     */
    public int updateByPrimaryKey(Medicine record) {

        int numb = medicineDao.updateByPrimaryKey(record);
        return numb;
    }


    public PageInfo<Medicine> findByPage(Medicine medicine, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        if (medicine.getMedName() != null && !medicine.getMedName().equals("")) {
            return new PageInfo<Medicine>(this.medicineDao.selectBymedName("%"+medicine.getMedName()+"%"));
        }
        return new PageInfo<Medicine>(this.medicineDao.selectAllMedicine());

    }
}
