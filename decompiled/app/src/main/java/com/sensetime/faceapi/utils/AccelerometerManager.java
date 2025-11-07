package com.sensetime.faceapi.utils;

/* loaded from: classes2.dex */
public class AccelerometerManager {
    private static com.sensetime.faceapi.utils.AccelerometerManager instance;
    private com.sensetime.faceapi.utils.AccelerometerManager.AccelerometerSensorListener mAccListener;
    private boolean mHasStarted = false;
    private android.hardware.SensorManager mSensorManager;

    private AccelerometerManager() {
    }

    public static com.sensetime.faceapi.utils.AccelerometerManager getInstance() {
        if (instance == null) {
            instance = new com.sensetime.faceapi.utils.AccelerometerManager();
        }
        return instance;
    }

    public static void start(android.content.Context context) {
        getInstance().registerListener(context);
    }

    public static void stop() {
        getInstance().unregisterListener();
    }

    public static com.sensetime.faceapi.model.FaceOrientation getFaceOrientation(boolean z_renamed) {
        return getFaceOrientation(getDir(z_renamed));
    }

    public static com.sensetime.faceapi.model.FaceOrientation getFaceOrientation(int i_renamed) {
        if (i_renamed == 0) {
            return com.sensetime.faceapi.model.FaceOrientation.UP;
        }
        if (i_renamed == 1) {
            return com.sensetime.faceapi.model.FaceOrientation.LEFT;
        }
        if (i_renamed == 2) {
            return com.sensetime.faceapi.model.FaceOrientation.DOWN;
        }
        if (i_renamed == 3) {
            return com.sensetime.faceapi.model.FaceOrientation.RIGHT;
        }
        return com.sensetime.faceapi.model.FaceOrientation.UNKNOWN;
    }

    public static int getDegree(boolean z_renamed) {
        return getDir(z_renamed) * 90;
    }

    public static int getDegree() {
        return getDir() * 90;
    }

    public static int getDir(boolean z_renamed) {
        return getInstance().getDirection(z_renamed);
    }

    public static int getDir() {
        return getDir(false);
    }

    private int getDirection(boolean z_renamed) {
        com.sensetime.faceapi.utils.AccelerometerManager.AccelerometerSensorListener accelerometerSensorListener = this.mAccListener;
        if (accelerometerSensorListener == null) {
            return -1;
        }
        int i_renamed = accelerometerSensorListener.dir;
        return (z_renamed && (i_renamed & 1) == 1) ? i_renamed ^ 2 : i_renamed;
    }

    private void registerListener(android.content.Context context) {
        if (this.mHasStarted) {
            return;
        }
        this.mHasStarted = true;
        this.mSensorManager = (android.hardware.SensorManager) context.getApplicationContext().getSystemService("sensor");
        android.hardware.Sensor defaultSensor = this.mSensorManager.getDefaultSensor(1);
        if (defaultSensor != null) {
            this.mAccListener = new com.sensetime.faceapi.utils.AccelerometerManager.AccelerometerSensorListener();
            this.mSensorManager.registerListener(this.mAccListener, defaultSensor, 3);
        }
    }

    private void unregisterListener() {
        android.hardware.SensorManager sensorManager;
        if (!this.mHasStarted || (sensorManager = this.mSensorManager) == null) {
            return;
        }
        this.mHasStarted = false;
        sensorManager.unregisterListener(this.mAccListener);
    }

    private class AccelerometerSensorListener implements android.hardware.SensorEventListener {
        private int dir;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(android.hardware.Sensor sensor, int i_renamed) {
        }

        private AccelerometerSensorListener() {
            this.dir = -1;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float f_renamed = sensorEvent.values[0];
                float f2 = sensorEvent.values[1];
                if (java.lang.Math.abs(f_renamed) > 0.5f || java.lang.Math.abs(f2) > 0.5f) {
                    if (java.lang.Math.abs(f_renamed) > java.lang.Math.abs(f2)) {
                        if (f_renamed > 0.0f) {
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
