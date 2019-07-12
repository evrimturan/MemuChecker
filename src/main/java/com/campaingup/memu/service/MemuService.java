package com.campaingup.memu.service;


import com.campaingup.memu.entity.Device;
import com.campaingup.memu.helper.Log;
import com.campaingup.memu.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MemuService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Transactional
    public Device create(Device device) {
        String guid = device.getGuid();
        String time = device.getTime();

        Device entry = deviceRepository.findByGuid(guid);

        if(entry == null) {
            deviceRepository.save(device);
        }
        else {
            entry.setTime(time);
            deviceRepository.save(entry);
            return entry;
        }

        return device;


        //System.out.println(device.getId() + " " + device.getGuid() + " " + device.getTime());

        //Log.createLog(guid, time);


        /*Boolean inRepo = false;
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


        return new String("Thanks for posting on test " + device.getGuid());
        return device;*/
    }


    @Transactional
    public String read(Device device) {
        String guid = device.getGuid();

        Device entry = deviceRepository.findByGuid(guid);

        if(entry == null){
            return "0";
        }

        return entry.getTime();


        /*System.out.println(device.getId() + " " + device.getGuid() + " " + device.getTime());

        Iterable<Device> deviceList = deviceRepository.findAll();
        for(Device query: deviceList) {
            if(guid.equals(query.getGuid())) {
                return query.getTime();
            }

        }

        return "0";*/
    }

    @Transactional
    public String delete(Device device) {

        String guid = device.getGuid();

        //System.out.println(device.getId() + " " + device.getGuid() + " " + device.getTime());

        if(guid.equals("DeleteAll")) {
            deviceRepository.deleteAll();
            return "1";
        }

        Device entry = deviceRepository.findByGuid(guid);

        if(entry == null) {
            return "0";
        }

        deviceRepository.deleteByGuid(guid);
        return entry.getGuid();

    }

    public List<Device> getPage(int pageNumber, int pageSize) {

        Pageable pagable = PageRequest.of(pageNumber, pageSize);

        Page<Device> page = deviceRepository.findAll(pagable);

        return page.getContent();
    }


}
