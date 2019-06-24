package com.campaingup.memu.controller;
import com.campaingup.memu.helper.Log;
import com.campaingup.memu.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.campaingup.memu.repository.DeviceRepository;


@Controller
public class MemuController {

    @Autowired
    private DeviceRepository deviceRepository;

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

        String guid = device.getGuid();
        String time = device.getTime();


        System.out.println(device.getId() + " " + device.getGuid() + " " + device.getTime());

        Log.createLog(guid, time);


        Boolean inRepo = false;
        Iterable<Device> deviceList= deviceRepository.findAll();
        for(Device entry : deviceList) {
            if(guid.equals(entry.getGuid())) {
                entry.setTime(time);
                deviceRepository.save(entry);
                return entry;
            }
        }

        if(!inRepo) {
            deviceRepository.save(device);
        }


        //return new String("Thanks for posting on test " + device.getGuid());
        return device;
    }

    @PostMapping(value = "/monitoring", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String monitoringPostResponseController(
            @RequestBody Device device) {

        String guid = device.getGuid();

        System.out.println(device.getId() + " " + device.getGuid() + " " + device.getTime());

        Iterable<Device> deviceList = deviceRepository.findAll();
        for(Device query: deviceList) {
            if(guid.equals(query.getGuid())) {
                return query.getTime();
            }

        }

        return "0";

    }

}

