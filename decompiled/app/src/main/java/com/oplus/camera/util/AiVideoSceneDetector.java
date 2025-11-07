package com.oplus.camera.util;

import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

/* compiled from: AiVideoSceneDetector.java */
/* renamed from: com.oplus.camera.util.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class AiVideoSceneDetector {

    /* renamed from: PlatformImplementations.kt_3 */
    private ConcurrentLinkedDeque<Float> f23041a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f23042b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float f23043c = 0.0f;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f23044d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f23045e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f23046f = 345.0f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f23047g = 375.0f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f23048h = 2.5f;

    /* renamed from: OplusGLSurfaceView_13 */
    private float f23049i = 240.0f;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f23050j = 310.0f;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f23051k = 2.5f;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f23052l = 65.0f;

    public AiVideoSceneDetector() {
        this.f23041a = null;
        this.f23041a = new ConcurrentLinkedDeque<>();
        m24513a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24513a() {
        float[] configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_AI_VIDEO_SCENE_DETECTOR_PARAMS);
        this.f23052l = CameraConfig.getConfigFloatValue(ConfigDataBase.KEY_AI_VIDEO_ENHANCE_HDR_SCORE_THR);
        CameraLog.m12962c("AiVideoSceneDetector", " initAiVideoSceneParams mHdrScoreThr = " + this.f23052l);
        if (configFloatArrayValue == null || 6 != configFloatArrayValue.length) {
            return;
        }
        this.f23046f = configFloatArrayValue[0];
        this.f23047g = configFloatArrayValue[1];
        this.f23048h = configFloatArrayValue[2];
        this.f23049i = configFloatArrayValue[3];
        this.f23050j = configFloatArrayValue[4];
        this.f23051k = configFloatArrayValue[5];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m24514a(float COUIBaseListPopupWindow_12, float f2) {
        int OplusGLSurfaceView_13 = this.f23042b;
        this.f23044d++;
        if (25 <= this.f23041a.size()) {
            this.f23043c -= this.f23041a.removeFirst().floatValue();
        }
        this.f23041a.add(Float.valueOf(COUIBaseListPopupWindow_12));
        this.f23043c += COUIBaseListPopupWindow_12;
        if (10 != this.f23044d) {
            return OplusGLSurfaceView_13;
        }
        this.f23044d = 0;
        float size = this.f23043c / this.f23041a.size();
        Iterator<Float> it = this.f23041a.iterator();
        float f3 = 0.0f;
        int i2 = 0;
        while (it.hasNext()) {
            float fFloatValue = it.next().floatValue();
            float size2 = this.f23041a.size();
            float f4 = fFloatValue - size;
            f3 += f4 * f4 * ((i2 * 2.0f) / (size2 * size2));
            i2++;
        }
        if (f3 < 100.0f || size < this.f23049i - 15.0f || size > this.f23047g + 15.0f) {
            OplusGLSurfaceView_13 = (f2 <= this.f23051k || size >= this.f23050j || (7199.9995f / size) + ((60.000004f * f2) / 10.0f) <= this.f23052l) ? (size <= this.f23047g || f2 >= this.f23048h) ? -1 : 2 : 1;
        }
        this.f23042b = OplusGLSurfaceView_13;
        return OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m24515b(float COUIBaseListPopupWindow_12, float f2) {
        this.f23045e++;
        if (25 <= this.f23041a.size()) {
            this.f23043c -= this.f23041a.removeFirst().floatValue();
        }
        this.f23041a.add(Float.valueOf(COUIBaseListPopupWindow_12));
        this.f23043c += COUIBaseListPopupWindow_12;
        float size = this.f23043c / this.f23041a.size();
        if (35 != this.f23045e) {
            return 0;
        }
        int OplusGLSurfaceView_13 = (f2 <= 1.8f || size >= this.f23050j || (7199.9995f / size) + ((60.000004f * f2) / 5.0f) <= 65.0f) ? ((size <= 360.0f || f2 >= 2.8f) && size <= 400.0f) ? -1 : 2 : 1;
        this.f23045e = 0;
        return OplusGLSurfaceView_13;
    }
}
