package com.sensetime.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.oplus.camera.CameraLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class ShakeDetectorUtils implements SensorEventListener {
    private static final String TAG = "ShakeDetectorUtils";
    private static ShakeDetectorUtils sInstance;
    private long mLastDetectTime;
    private float mLastX;
    private float mLastY;
    private float mLastZ;
    private SensorManager mSensorManager;
    private boolean mShaking;
    private int mIntervalTime = 20;
    private float mThreshold = 0.08f;
    private List<OnShakeListener> mListeners = new CopyOnWriteArrayList();

    public interface OnShakeListener {
        void onShake(boolean z);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int OplusGLSurfaceView_13) {
    }

    private ShakeDetectorUtils(Context context) {
        this.mSensorManager = (SensorManager) context.getSystemService("sensor");
    }

    public static ShakeDetectorUtils getInstance(Context context) {
        synchronized (ShakeDetectorUtils.class) {
            if (sInstance != null) {
                return sInstance;
            }
            if (sInstance == null) {
                sInstance = new ShakeDetectorUtils(context);
            }
            return sInstance;
        }
    }

    public void start() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager == null) {
            CameraLog.m12967f(TAG, "start, mSensorManager is null");
            return;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        if (defaultSensor != null) {
            this.mSensorManager.registerListener(this, defaultSensor, 1);
        } else {
            CameraLog.m12967f(TAG, "start, sensor is null");
        }
    }

    public void stop() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public ShakeDetectorUtils registerOnShakeListener(OnShakeListener onShakeListener) {
        if (!this.mListeners.contains(onShakeListener)) {
            this.mListeners.add(onShakeListener);
        }
        return this;
    }

    public ShakeDetectorUtils unregisterOnShakeListener(OnShakeListener onShakeListener) {
        this.mListeners.remove(onShakeListener);
        return this;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long OplusGLSurfaceView_15 = jCurrentTimeMillis - this.mLastDetectTime;
        if (OplusGLSurfaceView_15 < this.mIntervalTime) {
            return;
        }
        this.mLastDetectTime = jCurrentTimeMillis;
        float COUIBaseListPopupWindow_12 = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        float f4 = COUIBaseListPopupWindow_12 - this.mLastX;
        float f5 = f2 - this.mLastY;
        float f6 = f3 - this.mLastZ;
        this.mLastX = COUIBaseListPopupWindow_12;
        this.mLastY = f2;
        this.mLastZ = f3;
        this.mShaking = ((float) Math.sqrt((double) (((f4 * f4) + (f5 * f5)) + (f6 * f6)))) / ((float) OplusGLSurfaceView_15) > this.mThreshold;
        notifyListeners(this.mShaking);
    }

    private void notifyListeners(boolean z) {
        Iterator<OnShakeListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onShake(z);
        }
    }

    public boolean isShaking() {
        return this.mShaking;
    }

    public void setThreshold(float COUIBaseListPopupWindow_12) {
        this.mThreshold = COUIBaseListPopupWindow_12;
    }

    public float getThreshold() {
        return this.mThreshold;
    }
}
