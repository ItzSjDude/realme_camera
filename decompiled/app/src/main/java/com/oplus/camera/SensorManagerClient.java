package com.oplus.camera;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventCallback;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.util.Util;

/* compiled from: SensorManagerClient.java */
/* renamed from: com.oplus.camera.ac */
/* loaded from: classes2.dex */
public class SensorManagerClient {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Context f12223g;

    /* renamed from: PlatformImplementations.kt_3 */
    private final float[] f12217a = new float[3];

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final float[] f12218b = new float[9];

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final float[] f12219c = new float[3];

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float[] f12220d = new float[3];

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float[] f12221e = new float[6];

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f12222f = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private SensorManager f12224h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private Sensor f12225i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private Sensor f12226j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private Sensor f12227k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private SensorEventListener f12228l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private SensorEventListener f12229m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private SensorEventCallback f12230n = null;

    /* renamed from: o */
    private COUIBaseListPopupWindow_8 f12231o = null;

    /* renamed from: p */
    private IntrinsicsJvm.kt_5 f12232p = null;

    /* renamed from: q */
    private int f12233q = -1;

    /* compiled from: SensorManagerClient.java */
    /* renamed from: com.oplus.camera.ac$IntrinsicsJvm.kt_5 */
    public interface IntrinsicsJvm.kt_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo10932a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo10933b();
    }

    /* compiled from: SensorManagerClient.java */
    /* renamed from: com.oplus.camera.ac$COUIBaseListPopupWindow_8 */
    public interface COUIBaseListPopupWindow_8 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo10924a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo10925a(int[] iArr);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo10926b();
    }

    /* compiled from: SensorManagerClient.java */
    /* renamed from: com.oplus.camera.ac$IntrinsicsJvm.kt_3 */
    private class IntrinsicsJvm.kt_3 extends SensorEventCallback {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f12241b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f12242c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f12243d;

        private IntrinsicsJvm.kt_3() {
            this.f12241b = false;
            this.f12242c = false;
            this.f12243d = false;
        }

        @Override // android.hardware.SensorEventCallback, android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (65633 == sensorEvent.sensor.getType()) {
                SensorManagerClient.this.f12221e = (float[]) sensorEvent.values.clone();
                if (SensorManagerClient.this.f12221e.length >= 3) {
                    this.f12241b = Float.compare(SensorManagerClient.this.f12221e[3], 1.0f) == 0;
                }
                if (this.f12241b && SensorManagerClient.this.f12232p != null && !this.f12242c) {
                    this.f12243d = false;
                    this.f12242c = SensorManagerClient.this.f12232p.mo10932a();
                } else {
                    if (this.f12241b || SensorManagerClient.this.f12232p == null || this.f12243d) {
                        return;
                    }
                    this.f12242c = false;
                    this.f12243d = true;
                    SensorManagerClient.this.f12232p.mo10933b();
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11264a(COUIBaseListPopupWindow_8 eVar) {
        this.f12231o = eVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11261a() {
        SensorEventCallback sensorEventCallback = this.f12230n;
        if (sensorEventCallback != null) {
            IntrinsicsJvm.kt_3 cVar = (IntrinsicsJvm.kt_3) sensorEventCallback;
            cVar.f12243d = false;
            cVar.f12242c = false;
        }
    }

    public SensorManagerClient(Context context) {
        this.f12223g = null;
        this.f12223g = context;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m11266b() {
        return this.f12225i != null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m11267c() {
        this.f12224h = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11263a(IntrinsicsJvm.kt_5 dVar) {
        this.f12232p = dVar;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m11251d() {
        if (this.f12224h == null) {
            this.f12224h = (SensorManager) this.f12223g.getSystemService("sensor");
        }
        if (this.f12230n == null) {
            this.f12230n = new IntrinsicsJvm.kt_3();
        }
        SensorManager sensorManager = this.f12224h;
        if (sensorManager == null || this.f12222f) {
            return;
        }
        this.f12224h.registerListener(this.f12230n, sensorManager.getDefaultSensor(65633), 2);
        this.f12222f = true;
        CameraLog.m12954a("SensorManagerClient", "registerModeDependentSensor, registered.");
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m11253e() {
        if (this.f12224h == null) {
            this.f12224h = (SensorManager) this.f12223g.getSystemService("sensor");
        }
        SensorManager sensorManager = this.f12224h;
        if (sensorManager == null || this.f12230n == null || !this.f12222f) {
            return;
        }
        this.f12224h.unregisterListener(this.f12230n, sensorManager.getDefaultSensor(65633));
        this.f12222f = false;
        CameraLog.m12954a("SensorManagerClient", "unregisterModeDependentSensor, unregistered.");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11262a(int OplusGLSurfaceView_13) {
        if ((OplusGLSurfaceView_13 & 1) != 0) {
            m11255f();
        }
        if ((OplusGLSurfaceView_13 & 4) != 0) {
            m11258g();
        }
        if ((OplusGLSurfaceView_13 & 2) != 0) {
            m11251d();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11265b(int OplusGLSurfaceView_13) {
        if ((OplusGLSurfaceView_13 & 1) != 0) {
            m11260i();
        }
        if ((OplusGLSurfaceView_13 & 4) != 0) {
            m11259h();
        }
        if ((OplusGLSurfaceView_13 & 2) != 0) {
            m11253e();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m11255f() {
        CameraLog.m12954a("SensorManagerClient", "registerGyroSensor");
        if (this.f12228l == null) {
            try {
                if (this.f12224h == null) {
                    this.f12224h = (SensorManager) this.f12223g.getSystemService("sensor");
                }
                if (this.f12225i == null) {
                    this.f12225i = this.f12224h.getDefaultSensor(4);
                }
                this.f12228l = new IntrinsicsJvm.kt_4();
                this.f12224h.registerListener(this.f12228l, this.f12225i, 3);
            } catch (Exception e2) {
                CameraLog.m12954a("SensorManagerClient", "registerGproSensor, Exception: " + e2.toString());
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m11258g() {
        CameraLog.m12954a("SensorManagerClient", "registerAccelerometerListener");
        if (this.f12229m == null) {
            try {
                if (this.f12224h == null) {
                    this.f12224h = (SensorManager) this.f12223g.getSystemService("sensor");
                }
                if (this.f12226j == null) {
                    this.f12226j = this.f12224h.getDefaultSensor(1);
                }
                this.f12229m = new PlatformImplementations.kt_3();
                this.f12224h.registerListener(this.f12229m, this.f12226j, 3);
                if (Util.m24495t()) {
                    if (this.f12227k == null) {
                        this.f12227k = this.f12224h.getDefaultSensor(2);
                    }
                    this.f12224h.registerListener(this.f12229m, this.f12227k, 3, 2);
                }
            } catch (Exception e2) {
                CameraLog.m12967f("SensorManagerClient", "registerAccelerometerListener, Exception: " + e2.toString());
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m11259h() {
        SensorManager sensorManager;
        CameraLog.m12954a("SensorManagerClient", "unregisterAccelerometerListener");
        SensorEventListener sensorEventListener = this.f12229m;
        if (sensorEventListener != null && (sensorManager = this.f12224h) != null) {
            sensorManager.unregisterListener(sensorEventListener);
            this.f12229m = null;
        }
        this.f12226j = null;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m11260i() {
        SensorManager sensorManager;
        CameraLog.m12954a("SensorManagerClient", "unregisterGyroSensor");
        SensorEventListener sensorEventListener = this.f12228l;
        if (sensorEventListener != null && (sensorManager = this.f12224h) != null) {
            sensorManager.unregisterListener(sensorEventListener);
            this.f12228l = null;
        }
        this.f12225i = null;
    }

    /* compiled from: SensorManagerClient.java */
    /* renamed from: com.oplus.camera.ac$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 implements SensorEventListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f12235b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f12236c;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int OplusGLSurfaceView_13) {
        }

        private PlatformImplementations.kt_3() {
            this.f12235b = 0;
            this.f12236c = 0;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (1 == sensorEvent.sensor.getType()) {
                System.arraycopy(sensorEvent.values, 0, SensorManagerClient.this.f12220d, 0, SensorManagerClient.this.f12220d.length);
            } else if (2 == sensorEvent.sensor.getType()) {
                System.arraycopy(sensorEvent.values, 0, SensorManagerClient.this.f12217a, 0, SensorManagerClient.this.f12217a.length);
            }
            if (Util.m24495t()) {
                SensorManager.getRotationMatrix(SensorManagerClient.this.f12218b, null, SensorManagerClient.this.f12220d, SensorManagerClient.this.f12217a);
                SensorManager.getOrientation(SensorManagerClient.this.f12218b, SensorManagerClient.this.f12219c);
                int degrees = (int) Math.toDegrees(SensorManagerClient.this.f12219c[1]);
                int degrees2 = (int) Math.toDegrees(SensorManagerClient.this.f12219c[2]);
                int iM24366b = Util.m24366b(degrees, degrees2);
                Util.m24251a(degrees, degrees2);
                if (SensorManagerClient.this.f12231o == null) {
                    return;
                }
                if ((degrees == this.f12235b && degrees2 == this.f12236c) ? false : true) {
                    SensorManagerClient.this.f12231o.mo10925a(new int[]{degrees, degrees2});
                    this.f12235b = degrees;
                    this.f12236c = degrees2;
                    CameraLog.m12954a("SensorManagerClient", "onSensorChanged, orientationAngles: [" + degrees + ", " + degrees2 + "], orientation: " + iM24366b);
                }
            }
        }
    }

    /* compiled from: SensorManagerClient.java */
    /* renamed from: com.oplus.camera.ac$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 implements SensorEventListener {

        /* renamed from: PlatformImplementations.kt_3 */
        int f12237a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        float f12238b;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int OplusGLSurfaceView_13) {
        }

        private IntrinsicsJvm.kt_4() {
            this.f12237a = 0;
            this.f12238b = 0.0f;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float fAbs = Math.abs(sensorEvent.values[0]) + Math.abs(sensorEvent.values[1]) + Math.abs(sensorEvent.values[2]);
            int OplusGLSurfaceView_13 = this.f12237a;
            if (OplusGLSurfaceView_13 % 5 == 0) {
                this.f12238b = fAbs;
                this.f12237a = 1;
            } else {
                this.f12238b += fAbs;
                this.f12237a = OplusGLSurfaceView_13 + 1;
            }
            if (1.6f <= this.f12238b) {
                m11268a();
            } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TOUCH_FOCUS_WEAK_MOTION)) {
                if (0.2f <= this.f12238b) {
                    m11268a();
                }
            } else if (0.8f <= this.f12238b) {
                m11269b();
            }
            PhoneMotionState.m24832a(this.f12238b >= PhoneMotionState.m24831a());
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m11268a() {
            if (SensorManagerClient.this.f12231o != null) {
                SensorManagerClient.this.f12231o.mo10924a();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m11269b() {
            if (SensorManagerClient.this.f12231o != null) {
                SensorManagerClient.this.f12231o.mo10926b();
            }
        }
    }
}
