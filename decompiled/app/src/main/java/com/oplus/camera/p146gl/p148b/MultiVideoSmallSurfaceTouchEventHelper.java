package com.oplus.camera.p146gl.p148b;

import android.graphics.Rect;
import android.view.MotionEvent;
import com.oplus.camera.p172ui.preview.CameraScreenNail;
import com.oplus.camera.util.Util;

/* compiled from: MultiVideoSmallSurfaceTouchEventHelper.java */
/* renamed from: com.oplus.camera.gl.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class MultiVideoSmallSurfaceTouchEventHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private static MultiVideoSmallSurfaceTouchEventHelper f13931a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f13932b = false;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f13933c = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float f13934d = 0.0f;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f13935e = 0.0f;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f13936f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f13937g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f13938h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f13939i = 0;

    private MultiVideoSmallSurfaceTouchEventHelper() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static MultiVideoSmallSurfaceTouchEventHelper m13880a() {
        if (f13931a == null) {
            f13931a = new MultiVideoSmallSurfaceTouchEventHelper();
        }
        return f13931a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m13882a(MotionEvent motionEvent, CameraScreenNail c3445h) {
        int screenWidth;
        int OplusGLSurfaceView_13;
        int screenHeight;
        int i2;
        Rect rectM23462B = c3445h.m23462B();
        float rawX = motionEvent.getRawX() - c3445h.m23495z();
        float rawY = motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f13932b = false;
            this.f13933c = false;
            if (rectM23462B.contains((int) rawX, (int) rawY)) {
                this.f13932b = true;
                this.f13934d = rawX;
                this.f13935e = rawY;
            }
        } else if (action != 1) {
            if (action == 2) {
                float COUIBaseListPopupWindow_12 = rawX - this.f13934d;
                float f2 = rawY - this.f13935e;
                if (this.f13932b && (COUIBaseListPopupWindow_12 != 0.0f || f2 != 0.0f)) {
                    this.f13933c = true;
                    this.f13934d = rawX;
                    this.f13935e = rawY;
                    boolean zM24498u = Util.m24498u();
                    int i3 = (int) (rectM23462B.left + COUIBaseListPopupWindow_12);
                    int i4 = (int) (rectM23462B.top + f2);
                    int settingMenuPanelHeight = zM24498u ? this.f13938h : Util.getSettingMenuPanelHeight() + this.f13938h;
                    if (zM24498u) {
                        screenWidth = c3445h.m23461A() - rectM23462B.width();
                        OplusGLSurfaceView_13 = this.f13937g;
                    } else {
                        screenWidth = Util.getScreenWidth() - rectM23462B.width();
                        OplusGLSurfaceView_13 = this.f13937g;
                    }
                    int i5 = screenWidth - OplusGLSurfaceView_13;
                    if (zM24498u) {
                        screenHeight = Util.getScreenHeight() - rectM23462B.height();
                        i2 = this.f13939i;
                    } else {
                        screenHeight = (Util.getScreenHeight() - Util.m24187O()) - rectM23462B.height();
                        i2 = this.f13939i;
                    }
                    c3445h.m23474e(Math.min(Math.max(i3, this.f13936f), i5), Math.min(Math.max(settingMenuPanelHeight, i4), screenHeight - i2));
                    return true;
                }
            }
        } else {
            if (this.f13932b && this.f13933c) {
                this.f13932b = false;
                this.f13933c = false;
                return true;
            }
            this.f13932b = false;
            this.f13933c = false;
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13881a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f13936f = OplusGLSurfaceView_13;
        this.f13938h = i2;
        this.f13937g = i3;
        this.f13939i = i4;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m13883b() {
        return this.f13933c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m13884c() {
        return this.f13932b;
    }
}
