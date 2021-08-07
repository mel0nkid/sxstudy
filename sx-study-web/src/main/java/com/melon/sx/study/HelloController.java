package com.melon.sx.study;

import com.melon.sx.study.onew.CibaOwRet;
import com.melon.sx.study.onew.CibaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HelloController {

  @Autowired
  private PDFService pdfService;

  @Autowired
  private CibaService cibaService;

  @RequestMapping("/hello")
  @ResponseBody
  public String hello() {
    return "hello world!";
  }

  @RequestMapping("/helloCb")
  @ResponseBody
  public CibaOwRet helloCb() {
    return cibaService.get();
  }

  @RequestMapping("/helloth")
  public String hello(
      HttpServletRequest request,
      @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {

    request.setAttribute("name", name);
    return "helloth";
  }

  @RequestMapping("/pdf")
  @ResponseBody
  public String pdf() {
     pdfService.generatePDF();
     return "hello PDF";
  }
}
