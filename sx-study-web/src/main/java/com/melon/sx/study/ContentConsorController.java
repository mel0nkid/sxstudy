package com.melon.sx.study;

import com.melon.sx.study.dto.ContentCheckRet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ContentConsor
 *
 * @author imelonkid
 * @date 2021/09/17 12:14
 **/
@Controller
@RequestMapping(value = "/content")
public class ContentConsorController {

    @Autowired
    private ContentCensorService contentCensorService;

    @RequestMapping("/check/text")
    public String checkText() {
        return "textcheck";
    }

    /**
     * @param request HttpServletResponse
     */
    @RequestMapping(value = "/check/text/do", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ContentCheckRet doCheckContent(HttpServletRequest request,
        @RequestParam(value = "content") String content) {
        ContentCheckRet checkRet = contentCensorService.checkContent(content);
        return checkRet;
    }

}
