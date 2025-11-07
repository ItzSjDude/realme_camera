package com.sensetime.utils;

/* loaded from: classes2.dex */
public class ShakeDetectorUtils implements android.hardware.SensorEventListener {
    private static final java.lang.String TAG = "ShakeDetectorUtils";
    private static com.sensetime.utils.ShakeDetectorUtils sInstance;
    private long mLastDetectTime;
    private float mLastX;
    private float mLastY;
    private float mLastZ;
    private android.hardware.SensorManager mSensorManager;
    private boolean mShaking;
    private int mIntervalTime = 20;
    private float mThreshold = 0.08f;
    private java.util.List<com.sensetime.utils.ShakeDetectorUtils.OnShakeListener> mListeners = new java.util.concurrent.CopyOnWriteArrayList();

    public interface OnShakeListener {
        void onShake(boolean z_renamed);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i_renamed) {
    }

    private ShakeDetectorUtils(android.content.Context context) {
        this.mSensorManager = (android.hardware.SensorManager) context.getSystemService("sensor");
    }

    public static com.sensetime.utils.ShakeDetectorUtils getInstance(android.content.Context context) {
        synchronized (com.sensetime.utils.ShakeDetectorUtils.class) {
            if (sInstance != null) {
                return sInstance;
            }
            if (sInstance == null) {
                sInstance = new com.sensetime.utils.ShakeDetectorUtils(context);
            }
            return sInstance;
        }
    }

    public void start() {
        android.hardware.SensorManager sensorManager = this.mSensorManager;
        if (sensorManager == null) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "start, mSensorManager is_renamed null");
            return;
        }
        android.hardware.Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        if (defaultSensor != null) {
            this.mSensorManager.registerListener(this, defaultSensor, 1);
        } else {
            com.oplus.camera.e_renamed.f_renamed(TAG, "start, sensor is_renamed null");
        }
    }

    public void stop() {
        android.hardware.SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public com.sensetime.utils.ShakeDetectorUtils registerOnShakeListener(com.sensetime.utils.ShakeDetectorUtils.OnShakeListener onShakeListener) {
        if (!this.mListeners.contains(onShakeListener)) {
            this.mListeners.add(onShakeListener);
        }
        return this;
    }

    public com.sensetime.utils.ShakeDetectorUtils unregisterOnShakeListener(com.sensetime.utils.ShakeDetectorUtils.OnShakeListener onShakeListener) {
        this.mListeners.remove(onShakeListener);
        return this;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long j_renamed = jCurrentTimeMillis - this.mLastDetectTime;
        if (j_renamed < this.mIntervalTime) {
            return;
        }
        this.mLastDetectTime = jCurrentTimeMillis;
        float f_renamed = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        float f4 = f_renamed - this.mLastX;
        float f5 = f2 - this.mLastY;
        float f6 = f3 - this.mLastZ;
        this.mLastX = f_renamed;
        this.mLastY = f2;
        this.mLastZ = f3;
        this.mShaking = ((float) java.lang.Math.sqrt((double) (((f4 * f4) + (f5 * f5)) + (f6 * f6)))) / ((float) j_renamed) > this.mThreshold;
        notifyListeners(this.mShaking);
    }

    private void notifyListeners(boolean z_renamed) {
        java.util.Iterator<com.sensetime.utils.ShakeDetectorUtils.OnShakeListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onShake(z_renamed);
        }
    }

    public boolean isShaking() {
        return this.mShaking;
    }

    public void setThreshold(float f_renamed) {
        this.mThreshold = f_renamed;
    }

    public float getThreshold() {
        return this.mThreshold;
    }
}
