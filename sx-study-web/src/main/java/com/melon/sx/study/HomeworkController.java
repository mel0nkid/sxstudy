package com.melon.sx.study;

import com.melon.sx.study.model.HomeworkModel;
import com.melon.sx.study.onew.CibaOwRet;
import com.melon.sx.study.onew.CibaService;
import com.melon.sx.study.util.DateUtil;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/homework")
public class HomeworkController {

  @Autowired private GenerateMathService generateMathService;

  @Autowired private CibaService cibaService;

  @RequestMapping("/generate")
  public String generate(HttpServletRequest request, String date) {
    if(StringUtils.isBlank(date)) {
      date = DateUtil.formatSimple(new Date());
    }

    // 作业
    HomeworkModel homeworkModel = generateMathService.generate();

    // 格言
    CibaOwRet cibaOwRet = cibaService.get(date);

    request.setAttribute("homework", homeworkModel);
    request.setAttribute("cibaOneWord", cibaOwRet);
    return "homework";
  }
}
