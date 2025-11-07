package com.oplus.camera.doubleexposure;

import android.text.TextUtils;

/* compiled from: ClipVideoInfo.java */
/* renamed from: com.oplus.camera.doubleexposure.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ClipVideoInfo {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f13177a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private long f13178b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private long f13179c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f13180d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f13181e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f13182f = "";

    public ClipVideoInfo(String str) {
        this.f13177a = "";
        this.f13178b = -1L;
        this.f13179c = -1L;
        this.f13180d = false;
        this.f13177a = str;
        this.f13178b = -1L;
        this.f13179c = -1L;
        this.f13180d = false;
    }

    public ClipVideoInfo(String str, long OplusGLSurfaceView_15, long j2, boolean z) {
        this.f13177a = "";
        this.f13178b = -1L;
        this.f13179c = -1L;
        this.f13180d = false;
        this.f13177a = str;
        this.f13178b = OplusGLSurfaceView_15;
        this.f13179c = j2;
        this.f13180d = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m12893a() {
        return this.f13181e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12894a(int OplusGLSurfaceView_13) {
        this.f13181e = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m12897b() {
        return this.f13182f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12896a(String str) {
        this.f13182f = str;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public String m12899c() {
        return this.f13177a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public long m12900d() {
        return this.f13178b;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public long m12901e() {
        return this.f13179c;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m12902f() {
        return this.f13180d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12895a(long OplusGLSurfaceView_15) {
        this.f13178b = OplusGLSurfaceView_15;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12898b(long OplusGLSurfaceView_15) {
        this.f13179c = OplusGLSurfaceView_15;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m12903g() {
        return m12902f();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m12904h() {
        return -1 == this.f13178b || -1 == this.f13179c || this.f13181e == 0 || TextUtils.isEmpty(this.f13182f);
    }

    public String toString() {
        return "ClipVideoInfo{mPath='" + this.f13177a + "', mClipStartTime=" + this.f13178b + ", mClipEndTime=" + this.f13179c + ", mbClipped=" + this.f13180d + '}';
    }
}
