package com.oplus.camera.capmode;

import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorEventCallback;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.oplus.camera.CameraLog;

/* compiled from: SensorHelper.java */
/* renamed from: com.oplus.camera.capmode.s */
/* loaded from: classes2.dex */
class SensorHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f12981a = "s";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private SensorEventListener f12982b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private long f12983c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CameraInterface f12984d = null;

    SensorHelper() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12597a(Context context, CameraInterface interfaceC2646a) {
        if (this.f12982b != null) {
            CameraLog.m12959b(f12981a, "initSensor mSensorEventListener already exist");
            return;
        }
        this.f12984d = interfaceC2646a;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f12982b = new SensorEventCallback() { // from class: com.oplus.camera.capmode.s.1
            @Override // android.hardware.SensorEventCallback, android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (10 != sensorEvent.sensor.getType() || SensorHelper.this.f12984d == null || System.currentTimeMillis() - SensorHelper.this.f12983c <= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                    return;
                }
                for (float COUIBaseListPopupWindow_12 : (float[]) sensorEvent.values.clone()) {
                    if (COUIBaseListPopupWindow_12 > 0.1f) {
                        SensorHelper.this.f12984d.mo10508aJ();
                        SensorHelper.this.f12983c = System.currentTimeMillis();
                        return;
                    }
                }
            }
        };
        sensorManager.registerListener(this.f12982b, sensorManager.getDefaultSensor(10), 3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12596a(Context context) {
        if (this.f12982b == null) {
            CameraLog.m12959b(f12981a, "unInitSensor mSensorEventListener is null");
            return;
        }
        ((SensorManager) context.getSystemService("sensor")).unregisterListener(this.f12982b);
        this.f12984d = null;
        this.f12982b = null;
    }
}
