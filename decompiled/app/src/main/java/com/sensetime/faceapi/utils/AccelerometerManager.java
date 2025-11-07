package com.sensetime.faceapi.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.sensetime.faceapi.model.FaceOrientation;

/* loaded from: classes2.dex */
public class AccelerometerManager {
    private static AccelerometerManager instance;
    private AccelerometerSensorListener mAccListener;
    private boolean mHasStarted = false;
    private SensorManager mSensorManager;

    private AccelerometerManager() {
    }

    public static AccelerometerManager getInstance() {
        if (instance == null) {
            instance = new AccelerometerManager();
        }
        return instance;
    }

    public static void start(Context context) {
        getInstance().registerListener(context);
    }

    public static void stop() {
        getInstance().unregisterListener();
    }

    public static FaceOrientation getFaceOrientation(boolean z) {
        return getFaceOrientation(getDir(z));
    }

    public static FaceOrientation getFaceOrientation(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return FaceOrientation.UP;
        }
        if (OplusGLSurfaceView_13 == 1) {
            return FaceOrientation.LEFT;
        }
        if (OplusGLSurfaceView_13 == 2) {
            return FaceOrientation.DOWN;
        }
        if (OplusGLSurfaceView_13 == 3) {
            return FaceOrientation.RIGHT;
        }
        return FaceOrientation.UNKNOWN;
    }

    public static int getDegree(boolean z) {
        return getDir(z) * 90;
    }

    public static int getDegree() {
        return getDir() * 90;
    }

    public static int getDir(boolean z) {
        return getInstance().getDirection(z);
    }

    public static int getDir() {
        return getDir(false);
    }

    private int getDirection(boolean z) {
        AccelerometerSensorListener accelerometerSensorListener = this.mAccListener;
        if (accelerometerSensorListener == null) {
            return -1;
        }
        int OplusGLSurfaceView_13 = accelerometerSensorListener.dir;
        return (z && (OplusGLSurfaceView_13 & 1) == 1) ? OplusGLSurfaceView_13 ^ 2 : OplusGLSurfaceView_13;
    }

    private void registerListener(Context context) {
        if (this.mHasStarted) {
            return;
        }
        this.mHasStarted = true;
        this.mSensorManager = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        Sensor defaultSensor = this.mSensorManager.getDefaultSensor(1);
        if (defaultSensor != null) {
            this.mAccListener = new AccelerometerSensorListener();
            this.mSensorManager.registerListener(this.mAccListener, defaultSensor, 3);
        }
    }

    private void unregisterListener() {
        SensorManager sensorManager;
        if (!this.mHasStarted || (sensorManager = this.mSensorManager) == null) {
            return;
        }
        this.mHasStarted = false;
        sensorManager.unregisterListener(this.mAccListener);
    }

    private class AccelerometerSensorListener implements SensorEventListener {
        private int dir;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int OplusGLSurfaceView_13) {
        }

        private AccelerometerSensorListener() {
            this.dir = -1;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float COUIBaseListPopupWindow_12 = sensorEvent.values[0];
                float f2 = sensorEvent.values[1];
                if (Math.abs(COUIBaseListPopupWindow_12) > 0.5f || Math.abs(f2) > 0.5f) {
                    if (Math.abs(COUIBaseListPopupWindow_12) > Math.abs(f2)) {
                        if (COUIBaseListPopupWindow_12 > 0.0f) {
                            this.dir = 0;
                            return;
                        } else {
                            this.dir = 2;
                            return;
                        }
                    }
                    if (f2 > 0.0f) {
                        this.dir = 1;
                    } else {
                        this.dir = 3;
                    }
                }
            }
        }
    }
}
