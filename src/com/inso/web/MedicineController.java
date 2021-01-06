package com.inso.web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inso.common.*;
import com.inso.entity.vo.PageResult;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.inso.entity.Medicine;
import com.inso.service.MedicineService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller

public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    /**
     * 是否过期统计图
     * @date:  2019/5/1
     * @return:
     */

    @RequestMapping(value = "/medicine/statistics",method = RequestMethod.GET)
    @ResponseBody
    public Map staristics(){
        int noOut=0;  //未过期数量
        int inOut=0;     //已过期数量
        String format = "yyyy-MM-dd HH:mm:ss";
        WebDateUtils wdu = new  WebDateUtils ();
        //获取当前时间
        String websiteDate = wdu.getWebsiteDatetime(DateConsist.WEB_URL2, format);
        Timestamp newTime = Timestamp.valueOf(websiteDate);

        List<Medicine> medicineList = this.medicineService.selectAllMedicine();
        for (Medicine medicine : medicineList) {
            //过期时间和当前时间比较
            Timestamp saveDate = medicine.getSaveDate();
            if (saveDate.before(newTime)){
                //System.out.println("save小于new 未过期");
                //未过期
                noOut++;
            }else{
                //已过期
                inOut++;
            }

        }
        //总数
        int totalCount = medicineList.size();
        /*//计算比例
        //创建数值转换对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        //精确到小数点后两位
        numberFormat.setMaximumFractionDigits(2);
        //计算未过期百分比
        String noOutPercent = numberFormat.format((float) noOut / (float) totalCount * 100);
        String inOutPercent = numberFormat.format((float) inOut / (float) totalCount * 100);
        System.out.println(noOutPercent+"====================="+inOutPercent);*/

        HashMap<String, Integer> map = new HashMap<>();
        map.put("未过期",noOut);
        map.put("已过期",inOut);
        map.put("总数",totalCount);
        return map;
    }



    /**
     * 批量上传
     * @param data
     */
    @RequestMapping(value = "/medicine/upload",method = RequestMethod.POST)
    @ResponseBody
    public void uploadShopingOrder(@RequestParam(value="filename") MultipartFile data) {
        ModelAndView mv = new ModelAndView();
        try {
            InputStream is = data.getInputStream();
            HSSFWorkbook workbook = new HSSFWorkbook(is);
            HSSFSheet sheetAt = workbook.getSheetAt(0);
            TimeChange timeChange = new TimeChange();
            SystemTimeTypeTimestamp sttt = new SystemTimeTypeTimestamp();
            ArrayList<Medicine> list = new ArrayList<>();
            for (Row row : sheetAt) {
                //跳过标题(首行)
                if (row.getRowNum() == 0) {
                    continue;
                }
                //读取第一行的数据
                String medName = row.getCell(0).getStringCellValue();
                row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                String price = row.getCell(1).getStringCellValue();
                row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                String medNum = row.getCell(2).getStringCellValue();
                String prouductDate = row.getCell(3).getStringCellValue();
                String saveDate = row.getCell(4).getStringCellValue();
                String producter = row.getCell(5).getStringCellValue();
                String prouductArea = row.getCell(6).getStringCellValue();
                row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
                String phone = row.getCell(7).getStringCellValue();

                Medicine medicine = new Medicine();
                medicine.setMedName(medName);
                medicine.setMedNum(Integer.parseInt(medNum));
                medicine.setPrice(Long.parseLong(price));
                medicine.setPhone(Long.parseLong(phone));
                medicine.setProuductDate(timeChange.dateChange(prouductDate));
                medicine.setSaveDate(timeChange.dateChange(saveDate));
                medicine.setProducter(producter);
                medicine.setProuductArea(prouductArea);
                medicine.setCareatTime(sttt.getSystemTimeTypeTimestap());
                medicine.setUpdateTime(sttt.getSystemTimeTypeTimestap());
                this.medicineService.insert(medicine);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件上传异常！！");

        }
    }

    /**
     * 查询全部药品集合
     *
     * @return
     * @throws Exception Writer : MH·J
     */
    @ResponseBody
    @RequestMapping(value = "/select/medicineList/medicine", method = RequestMethod.GET)
    public PageResult medicineeList(Medicine medicine, @RequestParam(value = "page") Integer pageNum, @RequestParam(value = "limit") Integer pageSize) throws Exception {

        if (pageNum == null) {

            pageNum = 1;
        }
        if (pageSize == null || pageSize > 30) {
            pageSize = 10;
        }
        PageInfo<Medicine> pb = this.medicineService.findByPage(medicine, pageNum, pageSize);
        PageResult result = new PageResult();
        if (pb != null) {
            result.setData(pb.getList());
            result.setCode(0);
            result.setCount(pb.getTotal());

        }
        return result;
    }

    /**
     * 查询单个药品
     *
     * @return
     * @throws Exception Writer : MH·J
     */
    @ResponseBody
    @RequestMapping(value = "/select/medicine/medicineId", method = RequestMethod.GET)
    public ResponseResult medicineOne(@Param("mId") int mId) throws Exception {

        ResponseResult result = null;
        try {
            Medicine medicine = medicineService.selectByPrimaryKey(mId);
            if (medicine != null) {
                result = new ResponseResult();
                result.setCode(1);
                result.setMsg("查询成功");
                result.setData(medicine);
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
     * 查询单个药品根据药品名
     *
     * @return
     * @throws Exception Writer : MH·J
     */
    @ResponseBody
    @RequestMapping(value = "/select/medicine/medName", method = RequestMethod.POST)
    public ResponseResult selectBymedName(@Param("medName") String medName) throws Exception {
        String medName2 = medName + "%";
        ResponseResult result = null;
        try {
            List<Medicine> medicine = medicineService.selectBymedName(medName2);
            if (medicine != null) {
                result = new ResponseResult();
                result.setCode(1);
                result.setMsg("查询成功");
                result.setData(medicine);
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
     *
     * @return
     * @throws Exception Writer : MH·J
     */
    @ResponseBody
    @RequestMapping(value = "/delete/medicine/medicines", method = RequestMethod.POST)
    public ResponseResult deleteByAll(@RequestParam(value = "datas[]") int[] datas) throws Exception {

        ResponseResult result = null;
        try {
            int numb = medicineService.deleteByAll(datas);
            if (numb == 1) {
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
     * 删除单个药品
     *
     * @return
     * @throws Exception Writer : MH·J
     */
    @ResponseBody
    @RequestMapping(value = "/delete/medicine/medicineId", method = RequestMethod.POST)
    public ResponseResult deleteByPrimaryKey(@Param("mId") int mId) throws Exception {

        ResponseResult result = null;
        try {
            int numb = medicineService.deleteByPrimaryKey(mId);
            if (numb == 1) {
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
     * 插入单个药品
     *
     * @return
     * @throws Exception Writer : MH·J
     */
    @ResponseBody
    @RequestMapping(value = "/insert/medicine/medicine", method = RequestMethod.POST)
    public ResponseResult insert(@Param("medName") String medName, @Param("price") Long price, @Param("medNum") Integer medNum, @Param("prouductDate") String prouductDate,
                                 @Param("saveDate") String saveDate,
                                 @Param("producter") String producter, @Param("prouductArea") String prouductArea,
                                 @Param("phone") Long phone) throws Exception {
        System.out.println("daole");

        TimeChange timeChange = new TimeChange();
        SystemTimeTypeTimestamp sttt = new SystemTimeTypeTimestamp();
        System.out.println(sttt.getSystemTimeTypeTimestap());
        Medicine medicine = new Medicine(medName, price, medNum,
                timeChange.dateChange(prouductDate), timeChange.dateChange(saveDate),
                producter, prouductArea,
                phone, sttt.getSystemTimeTypeTimestap(),
                sttt.getSystemTimeTypeTimestap());

        ResponseResult result = null;
        try {
            int numb = medicineService.insert(medicine);
            if (numb == 1) {
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
     * 修改单个药品
     *
     * @return
     * @throws Exception Writer : MH·J
     */
    @RequestMapping(value = "/update/medicine/medicine", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult updateByPrimaryKey(@Param("mId") Integer mId,
                                             @Param("medName") String medName,
                                             @Param("price") Long price, @Param("medNum") Integer medNum,
                                             @Param("prouductDate") String prouductDate,
                                             @Param("saveDate") String saveDate,
                                             @Param("producter") String producter,
                                             @Param("prouductArea") String prouductArea,
                                             @Param("phone") Long phone,
                                             @Param("careatTime") String careatTime) throws Exception {


        TimeChange timeChange = new TimeChange();
        SystemTimeTypeTimestamp sttt = new SystemTimeTypeTimestamp();
        System.out.println(sttt.getSystemTimeTypeTimestap());
        Medicine medicine = new Medicine(mId, medName, price, medNum,
                timeChange.dateChange(prouductDate), timeChange.dateChange(saveDate),
                producter, prouductArea,
                phone, timeChange.dateChange(careatTime),
                sttt.getSystemTimeTypeTimestap());

        ResponseResult result = null;
        try {
            int numb = medicineService.updateByPrimaryKey(medicine);
            if (numb == 1) {
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
