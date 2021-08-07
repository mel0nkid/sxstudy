package com.melon.sx.study;

import com.melon.sx.study.model.HomeworkModel;
import com.melon.sx.study.onew.CibaOwRet;
import com.melon.sx.study.onew.CibaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/homework")
public class HomeworkController {

  @Autowired private GenerateMathService generateMathService;

  @Autowired private CibaService cibaService;

  @RequestMapping("/generate")
  public String generate(HttpServletRequest request) {
    HomeworkModel homeworkModel = generateMathService.generate();
    CibaOwRet cibaOwRet = cibaService.get();

    request.setAttribute("homework", homeworkModel);
    request.setAttribute("cibaOneWord", cibaOwRet);

    return "homework";
  }
}
