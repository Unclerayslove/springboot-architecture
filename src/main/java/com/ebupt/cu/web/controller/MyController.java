package com.ebupt.cu.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebupt.cu.result.R;

/**
 * @ClassName CorpOperatorController
 * @Description
 * @Author Leipei
 * @Date 2020/11/9 18:32
 * @Version V1.0
 **/
@RestController
@RequestMapping(value = "/prefix")
public class MyController {

    @GetMapping("/test")
    public R test() {
        return R.success();
    }

}
