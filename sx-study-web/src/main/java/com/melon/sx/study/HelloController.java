package com.melon.sx.study;

import com.melon.sx.study.onew.CibaService;
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
}
