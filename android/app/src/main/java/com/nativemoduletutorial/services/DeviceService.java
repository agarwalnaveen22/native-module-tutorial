package com.nativemoduletutorial.services;

import android.content.Context;
import android.os.PowerManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;

public class DeviceService {
    private ReactApplicationContext context;

    public DeviceService(ReactApplicationContext context) {
        this.context = context;
    }

    private boolean isScreenOn = false;
    private boolean isPowerSavingMode = false;

    public WritableMap getDisplayInfo() {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        this.isScreenOn = pm.isInteractive();
        this.isPowerSavingMode = pm.isPowerSaveMode();

        WritableMap displayInfo = new WritableNativeMap();
        displayInfo.putBoolean("isScreenOn", this.isScreenOn);
        displayInfo.putBoolean("isPowerSavingMode", this.isPowerSavingMode);
        return displayInfo;
    }
}