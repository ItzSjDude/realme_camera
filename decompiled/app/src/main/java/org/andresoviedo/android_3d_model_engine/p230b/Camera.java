package org.andresoviedo.android_3d_model_engine.p230b;

import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;

/* compiled from: Camera.java */
/* renamed from: org.andresoviedo.android_3d_model_engine.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class Camera {

    /* renamed from: PlatformImplementations.kt_3 */
    public float f24885a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public float f24886b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public float f24887c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float f24888d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public float f24889e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public float f24890f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public float f24891g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public float f24892h;

    /* renamed from: OplusGLSurfaceView_13 */
    public float f24893i;

    /* renamed from: OplusGLSurfaceView_15 */
    public float f24894j;

    /* renamed from: OplusGLSurfaceView_5 */
    public float f24895k;

    /* renamed from: OplusGLSurfaceView_14 */
    public float f24896l;

    /* renamed from: OplusGLSurfaceView_6 */
    public float f24897m;

    /* renamed from: OplusGLSurfaceView_11 */
    public int f24898n;

    /* renamed from: o */
    private final BoundingBox f24899o;

    /* renamed from: p */
    private final BoundingBox f24900p;

    /* renamed from: q */
    private float[] f24901q;

    /* renamed from: r */
    private long f24902r;

    /* renamed from: s */
    private Object[] f24903s;

    /* renamed from: t */
    private boolean f24904t;

    /* renamed from: u */
    private float[] f24905u;

    /* renamed from: v */
    private float[] f24906v;

    /* renamed from: PlatformImplementations.kt_3 */
    private void m26177a(float COUIBaseListPopupWindow_12, float f2) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m26178b(float COUIBaseListPopupWindow_12) {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m26179c(float COUIBaseListPopupWindow_12) {
    }

    public Camera() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
    }

    public Camera(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this(0.0f, 0.0f, -15.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -0.1f, 0.1f, 0.1f, -0.1f);
    }

    public Camera(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        this.f24899o = new BoundingBox("scene", -0.5f, 0.5f, -0.5f, 0.5f, -0.5f, 0.5f);
        this.f24900p = new BoundingBox("scene", -100.0f, 100.0f, -100.0f, 100.0f, -100.0f, 100.0f);
        this.f24901q = new float[56];
        this.f24904t = false;
        this.f24905u = new float[16];
        this.f24906v = null;
        this.f24885a = COUIBaseListPopupWindow_12;
        this.f24886b = f2;
        this.f24887c = f3;
        this.f24888d = f4;
        this.f24889e = f5;
        this.f24890f = f6;
        this.f24891g = f7;
        this.f24892h = f8;
        this.f24893i = f9;
        this.f24894j = f10;
        this.f24895k = f11;
        this.f24897m = f12;
        this.f24896l = f13;
        this.f24898n = 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float[] m26182a() {
        return this.f24901q;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized void m26183b() {
        if (this.f24903s != null && this.f24902r != 0) {
            String str = (String) this.f24903s[0];
            if (str.equals("translate")) {
                m26177a((((Float) this.f24903s[1]).floatValue() * this.f24902r) / 100.0f, (((Float) this.f24903s[2]).floatValue() * this.f24902r) / 100.0f);
            } else if (str.equals(FFmpegMediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION)) {
                m26179c((((Float) this.f24903s[1]).floatValue() / 100.0f) * this.f24902r);
            }
            this.f24902r--;
            return;
        }
        this.f24903s = null;
        this.f24902r = 100L;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m26180a(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 == 0.0f) {
            return;
        }
        m26178b(COUIBaseListPopupWindow_12);
        this.f24903s = new Object[]{CameraStatisticsUtil.PORTRAIT_ZOOM, Float.valueOf(COUIBaseListPopupWindow_12)};
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m26184c() {
        return this.f24904t;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26181a(boolean z) {
        this.f24904t = z;
    }

    public String toString() {
        return "Camera [xPos=" + this.f24885a + ", yPos=" + this.f24886b + ", zPos=" + this.f24887c + ", xView=" + this.f24888d + ", yView=" + this.f24889e + ", zView=" + this.f24890f + ", xUp=" + this.f24891g + ", yUp=" + this.f24892h + ", zUp=" + this.f24893i + "]";
    }
}
