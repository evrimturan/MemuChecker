package com.campaingup.memu.controller;
import com.campaingup.memu.helper.Log;
import com.campaingup.memu.object.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.campaingup.memu.object.Device;
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
        //System.out.println(deviceguid + " " + time);

        Log.createLog(guid, time);

        if(deviceRepository.existsById(device.getId())) {
            Device entry = deviceRepository.findById(device.getId()).get();
            entry.setTime(time);
            deviceRepository.save(entry);
        }
        else {
            deviceRepository.save(device);
        }


        //return new String("Thanks for posting on test " + device.getGuid());
        return device;
    }

}

