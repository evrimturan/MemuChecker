package com.campaingup.memu.controller;
import com.campaingup.memu.helper.Log;
import com.campaingup.memu.object.Device;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class MemuController {

    /*@GetMapping(value="/get", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public ResponseEntity<HttpStatus> index(@RequestParam String name) {

        //a guid in a text file. create if not exists with guid value

        return ResponseEntity.ok(HttpStatus.OK);
    }*/

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

        Log.createLog(device.getGuid(), device.getTime());

        //return new String("Thanks for posting on test " + device.getGuid());
        return device;
    }

}

