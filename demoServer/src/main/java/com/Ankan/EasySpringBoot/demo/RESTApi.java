package com.Ankan.EasySpringBoot.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTApi {
    @GetMapping("/{name}")
      public String paramsFunc(@PathVariable("name") String user) {
            return "Hello "+user;
        }

}
