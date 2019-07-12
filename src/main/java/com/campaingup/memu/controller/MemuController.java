package com.campaingup.memu.controller;
import com.campaingup.memu.helper.Log;
import com.campaingup.memu.entity.Device;
import com.campaingup.memu.service.MemuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.campaingup.memu.repository.DeviceRepository;


@Controller
public class MemuController {

    @Autowired
    private MemuService memuService;

    @GetMapping(value="/get")
    @ResponseBody
    public String getResponseController(@RequestParam("name") String name) {

        return new String("Thanks for getting " + name);
    }


    @PostMapping(value = "/")
    @ResponseBody
    public String postResponseController(
            @RequestBody String str) {
        //return new String("Thanks For Posting!!!");
        return new String("Thanks for posting " + str);
    }

    @PostMapping(value = "/test", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Device testPostResponseController(
            @RequestBody Device device) {

        return memuService.create(device);
    }

    @PostMapping(value = "/monitoring", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String monitoringPostResponseController(
            @RequestBody Device device) {

        return memuService.read(device);

    }

    @PostMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String deletePostResponseController(
            @RequestBody Device device) {

        return memuService.delete(device);

    }


}

