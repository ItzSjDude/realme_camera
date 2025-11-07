package com.oplus.camera.p161r;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;

/* compiled from: SLVBaseMode.java */
/* renamed from: com.oplus.camera.r.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public abstract class SLVBaseMode {

    /* renamed from: PlatformImplementations.kt_3 */
    protected Activity f15859a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected CameraUIInterface f15860b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected PlatformImplementations.kt_3 f15861c = null;

    /* compiled from: SLVBaseMode.java */
    /* renamed from: com.oplus.camera.r.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo16228a(String str);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo16229b(String str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    abstract int mo16219a();

    /* renamed from: PlatformImplementations.kt_3 */
    protected String mo16221a(String str) {
        return "";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo16223a(int OplusGLSurfaceView_13, Uri uri, ContentValues contentValues, String str) {
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo16224b() {
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int mo16225c() {
        return Integer.MAX_VALUE;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo16226d() {
    }

    public SLVBaseMode(Activity activity, CameraUIInterface cameraUIInterface) {
        this.f15859a = activity;
        this.f15860b = cameraUIInterface;
        CameraLog.m12954a("SLVBaseMode", " enter");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public MainShutterButtonInfo mo16220a(int OplusGLSurfaceView_13) {
        MainShutterButtonInfo c3200b;
        if (OplusGLSurfaceView_13 == 1) {
            c3200b = new MainShutterButtonInfo(6, "button_color_inside_red", "button_shape_dial_still", 1);
        } else {
            if (OplusGLSurfaceView_13 != 2) {
                if (OplusGLSurfaceView_13 != 3) {
                    return null;
                }
                MainShutterButtonInfo c3200b2 = new MainShutterButtonInfo();
                c3200b2.m19227a("button_color_inside_none");
                c3200b2.m19226a(4);
                return c3200b2;
            }
            c3200b = new MainShutterButtonInfo(5, "button_color_inside_red", "button_shape_dial_still", 1);
        }
        return c3200b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16222a(PlatformImplementations.kt_3 aVar) {
        this.f15861c = aVar;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo16227e() {
        this.f15859a = null;
        this.f15860b = null;
        this.f15861c = null;
        CameraLog.m12954a("SLVBaseMode", "exit");
    }
}
