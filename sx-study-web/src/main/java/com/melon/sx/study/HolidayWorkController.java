package com.melon.sx.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author melonkid
 * @date 2021/8/4
 */
@Controller
@RequestMapping(value = "/holiday")
public class HolidayWorkController {

    @RequestMapping("/work")
    public String work() {
        return "holidaywork";
    }

    @RequestMapping("/pdf")
    public String pdf() {
        return "pdf";
    }
}
