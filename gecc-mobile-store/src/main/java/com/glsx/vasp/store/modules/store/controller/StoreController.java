package com.glsx.vasp.store.modules.store.controller;

import cn.binarywang.wx.miniapp.api.WxMaQrcodeService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaCodeLineColor;
import com.glsx.vasp.framework.web.R;
import com.glsx.vasp.store.modules.AbstractController;
import com.glsx.vasp.weixin.common.config.WxMaConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Slf4j
@RestController
@RequestMapping("store")
public class StoreController extends AbstractController {

    @GetMapping(value = "info")
    public R info(){
        return R.ok().data(getSessionUser());
    }

    /**
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "/generateQrCode")
    public void generateStoreQrCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取小程序服务实例
        WxMaService wxMaService = WxMaConfiguration.getMaService("");
        // 获取小程序二维码生成实例
        WxMaQrcodeService wxMaQrcodeService = wxMaService.getQrcodeService();
        // 设置小程序二维码线条颜色为黑色
        WxMaCodeLineColor lineColor = new WxMaCodeLineColor("0", "0", "0");
        // 小程序二维码参数
        String scene = getSessionUser().getStoreCode();
        // 初始化页面
        String page = null;// ???

        // 生成二维码图片字节流
        byte[] qrCodeBytes = null;
        try {
            qrCodeBytes = wxMaQrcodeService.createWxaCodeUnlimitBytes(scene, page, 430, false, lineColor, false);
        } catch (Exception e) {
            log.error("生成小程序码出错", e);
        }

        // 设置contentType
        response.setContentType("image/png");

        // 写入response的输出流中
        OutputStream stream = response.getOutputStream();
        stream.write(qrCodeBytes);
        stream.flush();
        stream.close();
    }

}
