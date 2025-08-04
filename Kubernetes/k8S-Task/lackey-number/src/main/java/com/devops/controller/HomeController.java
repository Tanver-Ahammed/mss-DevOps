package com.devops.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.io.*;

@RestController
@RequestMapping("/api")
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/lucky-number")
    public Map<String, Object> luckyNumber() throws InterruptedException {
        Map<String, Object> response = new HashMap<>();
        response.put("luckyNumber", new Random().nextInt(100));
        Thread.sleep(10000);
        log.info("lucky-number: {}\n", response.get("luckyNumber"));
        return response;
    }

}
