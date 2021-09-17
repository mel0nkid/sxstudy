package com.melon.sx.study;

import cn.melonkid.commons.lang.parser.JSONUtil;
import com.melon.sx.study.dao.SensitiveWordDao;
import com.melon.sx.study.domain.SensitiveWordDomain;
import com.melon.sx.study.onew.CibaService;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloController {

  @Autowired
  private PDFService pdfService;

  @Autowired
  private SensitiveWordDao wordDao;

  @Autowired
  private CibaService cibaService;

  @RequestMapping("/hello")
  @ResponseBody
  public String hello() {
    return "hello world!";
  }


  @RequestMapping("/helloth")
  public String hello(
      HttpServletRequest request,
      @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {

    request.setAttribute("name", name);
    return "helloth";
  }

  @RequestMapping("/form")
  public String helloForm(
      HttpServletRequest request, String date) {
    System.out.println(date);
    return "helloth";
  }

  @RequestMapping("/context")
  public String context(
      HttpServletRequest request,
      @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {

    request.setAttribute("name", name);
    return "context";
  }

  @RequestMapping("/pdf")
  @ResponseBody
  public String pdf() {
     pdfService.generatePDF();
     return "hello PDF";
  }

  @RequestMapping("/db")
  @ResponseBody
  public String db() {
    SensitiveWordDomain wordDomain = new SensitiveWordDomain();
    wordDomain.setId(1);
    String word = UUID.randomUUID().toString().substring(0,5);
    wordDomain.setWord(word);
    wordDomain.setMsg("这是测试数据:"+word);
    wordDao.insert(wordDomain);
    wordDomain = wordDao.findByWord(word);
    System.out.println(JSONUtil.toJSONString(wordDomain));
    return "db";
  }

}
