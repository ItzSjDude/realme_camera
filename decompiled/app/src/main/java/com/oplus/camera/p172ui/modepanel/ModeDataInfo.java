package com.oplus.camera.p172ui.modepanel;

import java.util.Objects;

/* compiled from: ModeDataInfo.java */
/* renamed from: com.oplus.camera.ui.modepanel.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class ModeDataInfo {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f20573a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f20574b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f20575c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f20576d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f20577e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f20578f;

    public ModeDataInfo(String str, boolean z, String str2, int OplusGLSurfaceView_13, int i2, boolean z2) {
        this.f20573a = null;
        this.f20574b = true;
        this.f20575c = true;
        this.f20576d = "position_mode_panel";
        this.f20577e = -1;
        this.f20578f = -1;
        this.f20573a = str;
        this.f20574b = z;
        this.f20576d = str2;
        this.f20577e = OplusGLSurfaceView_13;
        this.f20578f = i2;
        this.f20575c = z2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m21908a() {
        return this.f20573a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m21909b() {
        return this.f20574b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public String m21910c() {
        return this.f20576d;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m21911d() {
        return this.f20577e;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m21912e() {
        return this.f20578f;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m21913f() {
        return this.f20575c;
    }

    public String toString() {
        return "ModeInfo: [mName: " + this.f20573a + ", mbSupportEdit: " + this.f20574b + ", mPosition: " + this.f20576d + ", mRank: " + this.f20577e + ", mId: " + this.f20578f + ", mbSupportFront: " + this.f20575c + "]";
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ModeDataInfo) && this.f20578f == ((ModeDataInfo) obj).f20578f;
    }

    public int hashCode() {
        return Objects.hash(this.f20573a, Boolean.valueOf(this.f20574b), Boolean.valueOf(this.f20575c), this.f20576d, Integer.valueOf(this.f20577e), Integer.valueOf(this.f20578f));
    }
}
