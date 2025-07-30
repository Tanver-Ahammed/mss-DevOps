package com.devops.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.io.*;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/lucky-number")
    public Map<String, Object> luckyNumber() {
        Map<String, Object> response = new HashMap<>();
        response.put("luckyNumber", new Random().nextInt(100));
        response.put("containerId", readContainerId());
        return response;
    }

    private String readContainerId() {
        try (BufferedReader br = new BufferedReader(new FileReader("/proc/self/cgroup"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("/docker/")) {
                    String id = extractContainerId(line, "/docker/");
                    if (id != null) return id;
                } else if (line.contains("/kubepods/")) {
                    String id = extractContainerIdFromKubepods(line);
                    if (id != null) return id;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Not found";
    }

    private String extractContainerId(String line, String prefix) {
        int idx = line.indexOf(prefix);
        if (idx >= 0) {
            String substr = line.substring(idx + prefix.length());
            int endIdx = substr.indexOf('/');
            if (endIdx < 0) endIdx = substr.length();
            return substr.substring(0, endIdx);
        }
        return null;
    }

    private String extractContainerIdFromKubepods(String line) {
        int idx = line.indexOf("cri-containerd-");
        if (idx >= 0) {
            String substr = line.substring(idx + "cri-containerd-".length());
            int endIdx = substr.indexOf(".scope");
            if (endIdx < 0) endIdx = substr.length();
            return substr.substring(0, endIdx);
        }
        return null;
    }
}
