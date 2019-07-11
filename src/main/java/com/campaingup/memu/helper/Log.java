package com.campaingup.memu.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;

public class Log {

    public Log() {

    }

    public static void createLog(String guid, String time) {

        ArrayList<String> deviceDetails = new ArrayList<>();
        Boolean inDevices = false;
        long timeInMillis = Long.parseLong(time);
        deviceDetails.clear();
        String filePath = System.getProperty("user.dir") + "/src" + "/Devices.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while(line != null) {
                deviceDetails.add(line);
                //to Console
                //System.out.println(line);
                line = reader.readLine();
            }
            reader.close();

            //System.out.println(deviceDetails);

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false));

            for(String details : deviceDetails) {
                String detailID = details.split("\\s")[0];
                if(detailID.equals(guid)) {
                    writer.write(detailID + " " + timeInMillis);
                    inDevices = true;
                }
                else {
                    writer.write(details);

                }
                writer.newLine();
            }
            if(!inDevices) {
                writer.write(guid + " " + timeInMillis);
            }
            writer.close();


        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
