package com.melon.sx.study.impl;

import com.melon.sx.study.GenerateMathService;
import com.melon.sx.study.PDFService;
import com.melon.sx.study.util.PDFUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author melonkid
 * @date 2021/8/4
 */
@Service
public class PDFServiceImpl implements PDFService {

  @Autowired private GenerateMathService generateMathService;

  @Override
  public void generatePDF() {
//    String html = PDFUtil.parseThymeleafTemplate(generateMathService.generate());
//    PDFUtil.generatePdfFromHtml(html);
    System.out.println("");
  }
}
