package com.oplus.camera.filmvideomode;

/* compiled from: FilmModeItemBarData.java */
/* renamed from: com.oplus.camera.filmvideomode.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class FilmModeItemBarData {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f13666a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f13667b = "";

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f13668c = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f13669d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f13670e = -1;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f13671f = -1;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f13672g = true;

    /* renamed from: PlatformImplementations.kt_3 */
    public FilmModeItemBarData m13546a(int OplusGLSurfaceView_13) {
        this.f13666a = OplusGLSurfaceView_13;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public FilmModeItemBarData m13550b(int OplusGLSurfaceView_13) {
        this.f13670e = OplusGLSurfaceView_13;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public FilmModeItemBarData m13552c(int OplusGLSurfaceView_13) {
        this.f13671f = OplusGLSurfaceView_13;
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m13545a() {
        return this.f13670e;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m13549b() {
        return this.f13666a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public FilmModeItemBarData m13548a(boolean z) {
        this.f13668c = z;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m13554c() {
        return this.f13669d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13551b(boolean z) {
        this.f13669d = z;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m13555d() {
        return this.f13667b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public FilmModeItemBarData m13547a(String str) {
        this.f13667b = str;
        return this;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m13556e() {
        return this.f13671f;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m13557f() {
        return this.f13672g;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m13553c(boolean z) {
        this.f13672g = z;
    }

    public String toString() {
        return "FilmModeItemBarData{mPreferenceTitleImage=" + this.f13666a + ", mName='" + this.f13667b + "', mbIsAuto=" + this.f13668c + ", mbIsSelect=" + this.f13669d + ", mAnimationRes=" + this.f13670e + ", mItemIndex=" + this.f13671f + ", mItemEnabled=" + this.f13672g + '}';
    }
}
