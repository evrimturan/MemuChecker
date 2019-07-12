package com.campaingup.memu.repository;

import com.campaingup.memu.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

    Device findByGuid(String guid);

    void deleteByGuid(String guid);

}
