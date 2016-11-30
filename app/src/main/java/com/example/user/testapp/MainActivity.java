package com.example.user.testapp;

import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);

    }

    public void buttonClick(View view) {
        String YOUR_DEVICE_NAME ="/dev/ttyS0";
        byte[] DATA;
        int TIMEOUT;
        Toast toast;
       // Intent intent = new Intent(this, MainActivity.class);
       // UsbDevice device = (UsbDevice) intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);


        UsbManager manager = (UsbManager) getSystemService(Context.USB_SERVICE);
        HashMap<String, UsbDevice> deviceList = manager.getDeviceList();
        LinkedHashMap<String, UsbDevice> newMap = new LinkedHashMap<String, UsbDevice>(deviceList);
       // UsbDevice device = deviceList.get("deviceName");
        if (newMap.size() > 0) {
            UsbDevice dev = (new ArrayList<UsbDevice>(newMap.values())).get(0);
            toast = Toast.makeText(this, dev.getDeviceName(), Toast.LENGTH_SHORT);
            toast.show();
        }

        toast = Toast.makeText(this, deviceList.size() > 0 ? "1" : "0", Toast.LENGTH_SHORT);
        toast.show();

    }
}
