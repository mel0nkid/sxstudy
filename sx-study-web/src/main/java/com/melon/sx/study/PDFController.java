package com.melon.sx.study;

import com.melon.sx.study.onew.CibaOwRet;
import com.melon.sx.study.onew.CibaService;
import com.melon.sx.study.util.PDFUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author melonkid
 * @date 2021/8/4
 */
@RestController
@RequestMapping(value = "/pdf")
public class PDFController {

  @Autowired private GenerateMathService generateMathService;

  @Autowired private TemplateEngine templateEngine;

  @Autowired private CibaService cibaService;

  /**
   * pdf预览
   *
   * @param response HttpServletResponse
   */
  @GetMapping(value = "/preview")
  public void preview(HttpServletResponse response) {
    List<Map<String, Object>> listVars = new ArrayList<>();
    Map<String, Object> homeworkVars = new HashMap<>(8);
    homeworkVars.put("homework", generateMathService.generate());
    homeworkVars.put("cibaOneWord", cibaService.get());
    listVars.add(homeworkVars);

    PDFUtil.preview(templateEngine, "homework", listVars, response);
  }

  //    /**
  //     * pdf下载
  //     *
  //     * @param response HttpServletResponse
  //     */
  //    @GetMapping(value = "/pdf/download")
  //    public void download(HttpServletResponse response) {
  //        List<Map<String,Object>> listVars = new ArrayList<>(1);
  //        Map<String,Object> variables = new HashMap<>(4);
  //        variables.put("title","测试下载PDF!");
  //
  // variables.put("imageUrl",sslEnabled?"https://localhost:10001/imgs/sg.jpg":"http://localhost:10001/imgs/sg.jpg");
  //        List<Map<String,String>> demoList = new ArrayList<>();
  //        Map<String,String> demoMap = new HashMap<>(8);
  //        demoMap.put("name","哈哈");
  //        demoMap.put("nick","娃娃");
  //        demoMap.put("age","19");
  //        Map<String,String> demoMap2 = new HashMap<>(8);
  //        demoMap2.put("name","天天");
  //        demoMap2.put("nick","饭饭");
  //        demoMap2.put("age","14");
  //        demoList.add(demoMap);
  //        demoList.add(demoMap2);
  //        variables.put("demoList",demoList);
  //        listVars.add(variables);
  //        PdfUtil.download(templateEngine,"pdfPage",listVars,response,"测试打印.pdf");
  //    }

  //    /**
  //     * pdf下载到特定位置
  //     *
  //     */
  //    @GetMapping(value = "/pdf/save")
  //    public BaseResponse<String> pdfSave() {
  //        List<Map<String,Object>> listVars = new ArrayList<>(1);
  //        Map<String,Object> variables = new HashMap<>(4);
  //        variables.put("title","测试下载PDF!");
  //
  // variables.put("imageUrl",sslEnabled?"https://localhost:10001/imgs/sg.jpg":"http://localhost:10001/imgs/sg.jpg");
  //        List<Map<String,String>> demoList = new ArrayList<>();
  //        Map<String,String> demoMap = new HashMap<>(8);
  //        demoMap.put("name","哈哈");
  //        demoMap.put("nick","娃娃");
  //        demoMap.put("age","19");
  //        Map<String,String> demoMap2 = new HashMap<>(8);
  //        demoMap2.put("name","天天");
  //        demoMap2.put("nick","饭饭");
  //        demoMap2.put("age","14");
  //        demoList.add(demoMap);
  //        demoList.add(demoMap2);
  //        variables.put("demoList",demoList);
  //        listVars.add(variables);
  //        // pdf文件下载位置
  //        String pdfPath = CommonUtil.isLinux() ? pdfLinuxPath : pdfWindowsPath + "test.pdf";
  //        PdfUtil.save(templateEngine,"pdfPage",listVars,pdfPath);
  //        return BaseResponse.ok("pdf保存成功");
  //    }

}
