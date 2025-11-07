package com.oplus.camera.util;

/* compiled from: AiVideoSceneDetector.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.concurrent.ConcurrentLinkedDeque<java.lang.Float> f7318a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7319b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    private float f7320c = 0.0f;
    private int d_renamed = 0;
    private int e_renamed = 0;
    private float f_renamed = 345.0f;
    private float g_renamed = 375.0f;
    private float h_renamed = 2.5f;
    private float i_renamed = 240.0f;
    private float j_renamed = 310.0f;
    private float k_renamed = 2.5f;
    private float l_renamed = 65.0f;

    public a_renamed() {
        this.f7318a = null;
        this.f7318a = new java.util.concurrent.ConcurrentLinkedDeque<>();
        a_renamed();
    }

    private void a_renamed() {
        float[] configFloatArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigFloatArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_VIDEO_SCENE_DETECTOR_PARAMS);
        this.l_renamed = com.oplus.camera.aps.config.CameraConfig.getConfigFloatValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_AI_VIDEO_ENHANCE_HDR_SCORE_THR);
        com.oplus.camera.e_renamed.c_renamed("AiVideoSceneDetector", " initAiVideoSceneParams mHdrScoreThr = " + this.l_renamed);
        if (configFloatArrayValue == null || 6 != configFloatArrayValue.length) {
            return;
        }
        this.f_renamed = configFloatArrayValue[0];
        this.g_renamed = configFloatArrayValue[1];
        this.h_renamed = configFloatArrayValue[2];
        this.i_renamed = configFloatArrayValue[3];
        this.j_renamed = configFloatArrayValue[4];
        this.k_renamed = configFloatArrayValue[5];
    }

    public int a_renamed(float f_renamed, float f2) {
        int i_renamed = this.f7319b;
        this.d_renamed++;
        if (25 <= this.f7318a.size()) {
            this.f7320c -= this.f7318a.removeFirst().floatValue();
        }
        this.f7318a.add(java.lang.Float.valueOf(f_renamed));
        this.f7320c += f_renamed;
        if (10 != this.d_renamed) {
            return i_renamed;
        }
        this.d_renamed = 0;
        float size = this.f7320c / this.f7318a.size();
        java.util.Iterator<java.lang.Float> it = this.f7318a.iterator();
        float f3 = 0.0f;
        int i2 = 0;
        while (it.hasNext()) {
            float fFloatValue = it.next().floatValue();
            float size2 = this.f7318a.size();
            float f4 = fFloatValue - size;
            f3 += f4 * f4 * ((i2 * 2.0f) / (size2 * size2));
            i2++;
        }
        if (f3 < 100.0f || size < this.i_renamed - 15.0f || size > this.g_renamed + 15.0f) {
            i_renamed = (f2 <= this.k_renamed || size >= this.j_renamed || (7199.9995f / size) + ((60.000004f * f2) / 10.0f) <= this.l_renamed) ? (size <= this.g_renamed || f2 >= this.h_renamed) ? -1 : 2 : 1;
        }
        this.f7319b = i_renamed;
        return i_renamed;
    }

    public int b_renamed(float f_renamed, float f2) {
        this.e_renamed++;
        if (25 <= this.f7318a.size()) {
            this.f7320c -= this.f7318a.removeFirst().floatValue();
        }
        this.f7318a.add(java.lang.Float.valueOf(f_renamed));
        this.f7320c += f_renamed;
        float size = this.f7320c / this.f7318a.size();
        if (35 != this.e_renamed) {
            return 0;
        }
        int i_renamed = (f2 <= 1.8f || size >= this.j_renamed || (7199.9995f / size) + ((60.000004f * f2) / 5.0f) <= 65.0f) ? ((size <= 360.0f || f2 >= 2.8f) && size <= 400.0f) ? -1 : 2 : 1;
        this.e_renamed = 0;
        return i_renamed;
    }
}
