package com.nativemoduletutorial.modules;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;

import com.nativemoduletutorial.services.DeviceService;

public class DeviceModule extends ReactContextBaseJavaModule {
    private final DeviceService deviceService;

    public DeviceModule(ReactApplicationContext context) {
        this.deviceService = new DeviceService(context);
    }

    @NonNull
    @Override
    public String getName() {
        return "Device";
    }

    @ReactMethod
    public void getDisplayInfo(Promise promise){
        try {
            WritableMap response = this.deviceService.getDisplayInfo();
            promise.resolve(response);
        } catch(Exception e) {
            promise.reject(e);
        }
    }
}