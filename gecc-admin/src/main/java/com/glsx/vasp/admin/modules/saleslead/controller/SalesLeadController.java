package com.glsx.vasp.admin.modules.saleslead.controller;

import cn.hutool.db.Page;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.glsx.vasp.admin.modules.saleslead.dto.SalesLeadSearch;
import com.glsx.vasp.admin.modules.saleslead.model.SalesLeadDetails;
import com.glsx.vasp.admin.modules.saleslead.model.SalesLeadListExport;
import com.glsx.vasp.admin.modules.saleslead.model.SalesLeadListModel;
import com.glsx.vasp.admin.modules.saleslead.service.SalesLeadService;
import com.glsx.vasp.framework.web.R;
import com.glsx.vasp.modules.entity.SalesLead;
import com.glsx.vasp.utils.DateUtils;
import com.glsx.vasp.web.Pagination;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/saleslead")
public class SalesLeadController {

    @Autowired
    private SalesLeadService salesLeadService;

    @GetMapping(value = "/list")
    public R list(SalesLeadSearch search, Page page) throws Exception {
        Pagination<SalesLeadListModel> pagination = salesLeadService.search(search, page);
        return R.ok().putPageData(pagination);
    }

    @GetMapping(value = "/export")
    public void export(HttpServletResponse response, SalesLeadSearch search) throws Exception {
        ExcelWriter writer = null;
        OutputStream os = response.getOutputStream();

        Pagination<SalesLeadListModel> pagination = salesLeadService.search(search, null);

        List<SalesLeadListExport> exportList = new ArrayList<>();
        for (SalesLeadListModel slModel : pagination.getList()) {
            SalesLeadListExport export = new SalesLeadListExport();
            BeanUtils.copyProperties(slModel, export);
            exportList.add(export);
        }
        try {
            //添加响应头信息
            response.setHeader("Content-disposition", "attachment; filename=" + "order_" + DateUtils.formatSerial(new Date()) + ExcelTypeEnum.XLSX.getValue());
            response.setContentType("application/msexcel;charset=UTF-8");//设置类型
            response.setHeader("Pragma", "No-cache");//设置头
            response.setHeader("Cache-Control", "no-cache");//设置头
            response.setDateHeader("Expires", 0);//设置日期头

            //实例化 ExcelWriter
            writer = new ExcelWriter(os, ExcelTypeEnum.XLSX, true);

            //实例化表单
            Sheet sheet = new Sheet(1, 0, SalesLeadListExport.class);
            sheet.setSheetName("线索列表");

            //输出
            writer.write(exportList, sheet);
            writer.finish();
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping(value = "/info")
    public R query(Long id) {
        SalesLeadDetails od = salesLeadService.getDetailsById(id);
        return R.ok().data(od);
    }

}
