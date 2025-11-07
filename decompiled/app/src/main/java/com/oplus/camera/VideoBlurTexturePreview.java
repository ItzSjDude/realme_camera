package com.oplus.camera;

/* compiled from: SensorManagerClient.java */
/* loaded from: classes2.dex */
public class ac_renamed {
    private android.content.Context g_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final float[] f4084a = new float[3];

    /* renamed from: b_renamed, reason: collision with root package name */
    private final float[] f4085b = new float[9];

    /* renamed from: c_renamed, reason: collision with root package name */
    private final float[] f4086c = new float[3];
    private float[] d_renamed = new float[3];
    private float[] e_renamed = new float[6];
    private boolean f_renamed = false;
    private android.hardware.SensorManager h_renamed = null;
    private android.hardware.Sensor i_renamed = null;
    private android.hardware.Sensor j_renamed = null;
    private android.hardware.Sensor k_renamed = null;
    private android.hardware.SensorEventListener l_renamed = null;
    private android.hardware.SensorEventListener m_renamed = null;
    private android.hardware.SensorEventCallback n_renamed = null;
    private com.oplus.camera.ac_renamed.e_renamed o_renamed = null;
    private com.oplus.camera.ac_renamed.d_renamed p_renamed = null;
    private int q_renamed = -1;

    /* compiled from: SensorManagerClient.java */
    public interface d_renamed {
        boolean a_renamed();

        boolean b_renamed();
    }

    /* compiled from: SensorManagerClient.java */
    public interface e_renamed {
        void a_renamed();

        void a_renamed(int[] iArr);

        void b_renamed();
    }

    /* compiled from: SensorManagerClient.java */
    private class c_renamed extends android.hardware.SensorEventCallback {

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f4094b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private boolean f4095c;
        private boolean d_renamed;

        private c_renamed() {
            this.f4094b = false;
            this.f4095c = false;
            this.d_renamed = false;
        }

        @Override // android.hardware.SensorEventCallback, android.hardware.SensorEventListener
        public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
            if (65633 == sensorEvent.sensor.getType()) {
                com.oplus.camera.ac_renamed.this.e_renamed = (float[]) sensorEvent.values.clone();
                if (com.oplus.camera.ac_renamed.this.e_renamed.length >= 3) {
                    this.f4094b = java.lang.Float.compare(com.oplus.camera.ac_renamed.this.e_renamed[3], 1.0f) == 0;
                }
                if (this.f4094b && com.oplus.camera.ac_renamed.this.p_renamed != null && !this.f4095c) {
                    this.d_renamed = false;
                    this.f4095c = com.oplus.camera.ac_renamed.this.p_renamed.a_renamed();
                } else {
                    if (this.f4094b || com.oplus.camera.ac_renamed.this.p_renamed == null || this.d_renamed) {
                        return;
                    }
                    this.f4095c = false;
                    this.d_renamed = true;
                    com.oplus.camera.ac_renamed.this.p_renamed.b_renamed();
                }
            }
        }
    }

    public void a_renamed(com.oplus.camera.ac_renamed.e_renamed eVar) {
        this.o_renamed = eVar;
    }

    public void a_renamed() {
        android.hardware.SensorEventCallback sensorEventCallback = this.n_renamed;
        if (sensorEventCallback != null) {
            com.oplus.camera.ac_renamed.c_renamed cVar = (com.oplus.camera.ac_renamed.c_renamed) sensorEventCallback;
            cVar.d_renamed = false;
            cVar.f4095c = false;
        }
    }

    public ac_renamed(android.content.Context context) {
        this.g_renamed = null;
        this.g_renamed = context;
    }

    public boolean b_renamed() {
        return this.i_renamed != null;
    }

    public void c_renamed() {
        this.h_renamed = null;
    }

    public void a_renamed(com.oplus.camera.ac_renamed.d_renamed dVar) {
        this.p_renamed = dVar;
    }

    private void d_renamed() {
        if (this.h_renamed == null) {
            this.h_renamed = (android.hardware.SensorManager) this.g_renamed.getSystemService("sensor");
        }
        if (this.n_renamed == null) {
            this.n_renamed = new com.oplus.camera.ac_renamed.c_renamed();
        }
        android.hardware.SensorManager sensorManager = this.h_renamed;
        if (sensorManager == null || this.f_renamed) {
            return;
        }
        this.h_renamed.registerListener(this.n_renamed, sensorManager.getDefaultSensor(65633), 2);
        this.f_renamed = true;
        com.oplus.camera.e_renamed.a_renamed("SensorManagerClient", "registerModeDependentSensor, registered.");
    }

    private void e_renamed() {
        if (this.h_renamed == null) {
            this.h_renamed = (android.hardware.SensorManager) this.g_renamed.getSystemService("sensor");
        }
        android.hardware.SensorManager sensorManager = this.h_renamed;
        if (sensorManager == null || this.n_renamed == null || !this.f_renamed) {
            return;
        }
        this.h_renamed.unregisterListener(this.n_renamed, sensorManager.getDefaultSensor(65633));
        this.f_renamed = false;
        com.oplus.camera.e_renamed.a_renamed("SensorManagerClient", "unregisterModeDependentSensor, unregistered.");
    }

    public void a_renamed(int i_renamed) {
        if ((i_renamed & 1) != 0) {
            f_renamed();
        }
        if ((i_renamed & 4) != 0) {
            g_renamed();
        }
        if ((i_renamed & 2) != 0) {
            d_renamed();
        }
    }

    public void b_renamed(int i_renamed) {
        if ((i_renamed & 1) != 0) {
            i_renamed();
        }
        if ((i_renamed & 4) != 0) {
            h_renamed();
        }
        if ((i_renamed & 2) != 0) {
            e_renamed();
        }
    }

    private void f_renamed() {
        com.oplus.camera.e_renamed.a_renamed("SensorManagerClient", "registerGyroSensor");
        if (this.l_renamed == null) {
            try {
                if (this.h_renamed == null) {
                    this.h_renamed = (android.hardware.SensorManager) this.g_renamed.getSystemService("sensor");
                }
                if (this.i_renamed == null) {
                    this.i_renamed = this.h_renamed.getDefaultSensor(4);
                }
                this.l_renamed = new com.oplus.camera.ac_renamed.b_renamed();
                this.h_renamed.registerListener(this.l_renamed, this.i_renamed, 3);
            } catch (java.lang.Exception e2) {
                com.oplus.camera.e_renamed.a_renamed("SensorManagerClient", "registerGproSensor, Exception: " + e2.toString());
            }
        }
    }

    private void g_renamed() {
        com.oplus.camera.e_renamed.a_renamed("SensorManagerClient", "registerAccelerometerListener");
        if (this.m_renamed == null) {
            try {
                if (this.h_renamed == null) {
                    this.h_renamed = (android.hardware.SensorManager) this.g_renamed.getSystemService("sensor");
                }
                if (this.j_renamed == null) {
                    this.j_renamed = this.h_renamed.getDefaultSensor(1);
                }
                this.m_renamed = new com.oplus.camera.ac_renamed.a_renamed();
                this.h_renamed.registerListener(this.m_renamed, this.j_renamed, 3);
                if (com.oplus.camera.util.Util.t_renamed()) {
                    if (this.k_renamed == null) {
                        this.k_renamed = this.h_renamed.getDefaultSensor(2);
                    }
                    this.h_renamed.registerListener(this.m_renamed, this.k_renamed, 3, 2);
                }
            } catch (java.lang.Exception e2) {
                com.oplus.camera.e_renamed.f_renamed("SensorManagerClient", "registerAccelerometerListener, Exception: " + e2.toString());
            }
        }
    }

    private void h_renamed() {
        android.hardware.SensorManager sensorManager;
        com.oplus.camera.e_renamed.a_renamed("SensorManagerClient", "unregisterAccelerometerListener");
        android.hardware.SensorEventListener sensorEventListener = this.m_renamed;
        if (sensorEventListener != null && (sensorManager = this.h_renamed) != null) {
            sensorManager.unregisterListener(sensorEventListener);
            this.m_renamed = null;
        }
        this.j_renamed = null;
    }

    private void i_renamed() {
        android.hardware.SensorManager sensorManager;
        com.oplus.camera.e_renamed.a_renamed("SensorManagerClient", "unregisterGyroSensor");
        android.hardware.SensorEventListener sensorEventListener = this.l_renamed;
        if (sensorEventListener != null && (sensorManager = this.h_renamed) != null) {
            sensorManager.unregisterListener(sensorEventListener);
            this.l_renamed = null;
        }
        this.i_renamed = null;
    }

    /* compiled from: SensorManagerClient.java */
    private class a_renamed implements android.hardware.SensorEventListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f4088b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f4089c;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(android.hardware.Sensor sensor, int i_renamed) {
        }

        private a_renamed() {
            this.f4088b = 0;
            this.f4089c = 0;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
            if (1 == sensorEvent.sensor.getType()) {
                java.lang.System.arraycopy(sensorEvent.values, 0, com.oplus.camera.ac_renamed.this.d_renamed, 0, com.oplus.camera.ac_renamed.this.d_renamed.length);
            } else if (2 == sensorEvent.sensor.getType()) {
                java.lang.System.arraycopy(sensorEvent.values, 0, com.oplus.camera.ac_renamed.this.f4084a, 0, com.oplus.camera.ac_renamed.this.f4084a.length);
            }
            if (com.oplus.camera.util.Util.t_renamed()) {
                android.hardware.SensorManager.getRotationMatrix(com.oplus.camera.ac_renamed.this.f4085b, null, com.oplus.camera.ac_renamed.this.d_renamed, com.oplus.camera.ac_renamed.this.f4084a);
                android.hardware.SensorManager.getOrientation(com.oplus.camera.ac_renamed.this.f4085b, com.oplus.camera.ac_renamed.this.f4086c);
                int degrees = (int) java.lang.Math.toDegrees(com.oplus.camera.ac_renamed.this.f4086c[1]);
                int degrees2 = (int) java.lang.Math.toDegrees(com.oplus.camera.ac_renamed.this.f4086c[2]);
                int iB = com.oplus.camera.util.Util.b_renamed(degrees, degrees2);
                com.oplus.camera.util.Util.a_renamed(degrees, degrees2);
                if (com.oplus.camera.ac_renamed.this.o_renamed == null) {
                    return;
                }
                if ((degrees == this.f4088b && degrees2 == this.f4089c) ? false : true) {
                    com.oplus.camera.ac_renamed.this.o_renamed.a_renamed(new int[]{degrees, degrees2});
                    this.f4088b = degrees;
                    this.f4089c = degrees2;
                    com.oplus.camera.e_renamed.a_renamed("SensorManagerClient", "onSensorChanged, orientationAngles: [" + degrees + ", " + degrees2 + "], orientation: " + iB);
                }
            }
        }
    }

    /* compiled from: SensorManagerClient.java */
    private class b_renamed implements android.hardware.SensorEventListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f4090a;

        /* renamed from: b_renamed, reason: collision with root package name */
        float f4091b;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(android.hardware.Sensor sensor, int i_renamed) {
        }

        private b_renamed() {
            this.f4090a = 0;
            this.f4091b = 0.0f;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
            float fAbs = java.lang.Math.abs(sensorEvent.values[0]) + java.lang.Math.abs(sensorEvent.values[1]) + java.lang.Math.abs(sensorEvent.values[2]);
            int i_renamed = this.f4090a;
            if (i_renamed % 5 == 0) {
                this.f4091b = fAbs;
                this.f4090a = 1;
            } else {
                this.f4091b += fAbs;
                this.f4090a = i_renamed + 1;
            }
            if (1.6f <= this.f4091b) {
                a_renamed();
            } else if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TOUCH_FOCUS_WEAK_MOTION)) {
                if (0.2f <= this.f4091b) {
                    a_renamed();
                }
            } else if (0.8f <= this.f4091b) {
                b_renamed();
            }
            com.oplus.camera.y_renamed.a_renamed(this.f4091b >= com.oplus.camera.y_renamed.a_renamed());
        }

        public void a_renamed() {
            if (com.oplus.camera.ac_renamed.this.o_renamed != null) {
                com.oplus.camera.ac_renamed.this.o_renamed.a_renamed();
            }
        }

        public void b_renamed() {
            if (com.oplus.camera.ac_renamed.this.o_renamed != null) {
                com.oplus.camera.ac_renamed.this.o_renamed.b_renamed();
            }
        }
    }
}
