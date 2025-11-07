package com.oplus.camera.capmode;

/* compiled from: SensorHelper.java */
/* loaded from: classes2.dex */
class s_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f4294a = "s_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.hardware.SensorEventListener f4295b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private long f4296c = 0;
    private com.oplus.camera.capmode.a_renamed d_renamed = null;

    s_renamed() {
    }

    public void a_renamed(android.content.Context context, com.oplus.camera.capmode.a_renamed aVar) {
        if (this.f4295b != null) {
            com.oplus.camera.e_renamed.b_renamed(f4294a, "initSensor mSensorEventListener already exist");
            return;
        }
        this.d_renamed = aVar;
        android.hardware.SensorManager sensorManager = (android.hardware.SensorManager) context.getSystemService("sensor");
        this.f4295b = new android.hardware.SensorEventCallback() { // from class: com.oplus.camera.capmode.s_renamed.1
            @Override // android.hardware.SensorEventCallback, android.hardware.SensorEventListener
            public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
                if (10 != sensorEvent.sensor.getType() || com.oplus.camera.capmode.s_renamed.this.d_renamed == null || java.lang.System.currentTimeMillis() - com.oplus.camera.capmode.s_renamed.this.f4296c <= com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                    return;
                }
                for (float f_renamed : (float[]) sensorEvent.values.clone()) {
                    if (f_renamed > 0.1f) {
                        com.oplus.camera.capmode.s_renamed.this.d_renamed.aJ_renamed();
                        com.oplus.camera.capmode.s_renamed.this.f4296c = java.lang.System.currentTimeMillis();
                        return;
                    }
                }
            }
        };
        sensorManager.registerListener(this.f4295b, sensorManager.getDefaultSensor(10), 3);
    }

    public void a_renamed(android.content.Context context) {
        if (this.f4295b == null) {
            com.oplus.camera.e_renamed.b_renamed(f4294a, "unInitSensor mSensorEventListener is_renamed null");
            return;
        }
        ((android.hardware.SensorManager) context.getSystemService("sensor")).unregisterListener(this.f4295b);
        this.d_renamed = null;
        this.f4295b = null;
    }
}
