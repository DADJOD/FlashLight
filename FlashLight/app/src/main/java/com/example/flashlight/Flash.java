package com.example.flashlight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;

public class Flash {
    private boolean flash_status;
    private Context context;
    private CameraManager cameraManager;
    private String cameraId;

    public Flash(Context context) {
        this.context = context;
    }

    @SuppressLint("NewApi")
    public void flashOn() {
        cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        try {
            cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
            flash_status = true;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("NewApi")
    public void flashOff() {
        cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        try {
            cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
            flash_status = false;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public boolean isFlash_status() {
        return flash_status;
    }
}
