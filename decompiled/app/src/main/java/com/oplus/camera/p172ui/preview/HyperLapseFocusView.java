package com.oplus.camera.p172ui.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class HyperLapseFocusView extends ImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f20806a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f20807b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f20808c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f20809d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f20810e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f20811f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f20812g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f20813h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f20814i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f20815j;

    /* renamed from: OplusGLSurfaceView_5 */
    private long f20816k;

    /* renamed from: OplusGLSurfaceView_14 */
    private InterfaceC3382a f20817l;

    /* renamed from: com.oplus.camera.ui.preview.HyperLapseFocusView$PlatformImplementations.kt_3 */
    public interface InterfaceC3382a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo22158a(int OplusGLSurfaceView_13, int i2);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo22159a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo22160b(int OplusGLSurfaceView_13, int i2);

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo22161b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo22162c();
    }

    public HyperLapseFocusView(Context context) {
        super(context);
        this.f20806a = 0;
        this.f20807b = 0;
        this.f20808c = 0;
        this.f20809d = 0;
        this.f20810e = 0;
        this.f20811f = 0;
        this.f20812g = 0;
        this.f20813h = 0;
        this.f20814i = 0;
        this.f20815j = 0;
        this.f20816k = 0L;
        this.f20817l = null;
    }

    public HyperLapseFocusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20806a = 0;
        this.f20807b = 0;
        this.f20808c = 0;
        this.f20809d = 0;
        this.f20810e = 0;
        this.f20811f = 0;
        this.f20812g = 0;
        this.f20813h = 0;
        this.f20814i = 0;
        this.f20815j = 0;
        this.f20816k = 0L;
        this.f20817l = null;
    }

    public HyperLapseFocusView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f20806a = 0;
        this.f20807b = 0;
        this.f20808c = 0;
        this.f20809d = 0;
        this.f20810e = 0;
        this.f20811f = 0;
        this.f20812g = 0;
        this.f20813h = 0;
        this.f20814i = 0;
        this.f20815j = 0;
        this.f20816k = 0L;
        this.f20817l = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22157a(InterfaceC3382a interfaceC3382a) {
        this.f20815j = (Util.getScreenHeight() - Util.m24187O()) - Util.m24190R();
        this.f20817l = interfaceC3382a;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterfaceC3382a interfaceC3382a = this.f20817l;
        if (interfaceC3382a != null && (interfaceC3382a.mo22159a() || this.f20817l.mo22161b())) {
            CameraLog.m12954a("HyperLapseFocusView", "onTouchEvent, return");
            return false;
        }
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int action = motionEvent.getAction();
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (action == 0) {
            this.f20808c = rawX;
            this.f20809d = rawY;
            this.f20806a = rawX;
            this.f20807b = rawY;
            this.f20816k = System.currentTimeMillis();
        } else if (action != 1) {
            if (action == 2) {
                int OplusGLSurfaceView_13 = rawX - this.f20808c;
                int i2 = rawY - this.f20809d;
                this.f20810e = getLeft() + OplusGLSurfaceView_13;
                this.f20811f = getTop() + i2;
                this.f20812g = getRight() + OplusGLSurfaceView_13;
                this.f20813h = getBottom() + i2;
                if (this.f20812g > Util.getScreenWidth()) {
                    this.f20812g = Util.getScreenWidth();
                    this.f20810e = this.f20812g - measuredWidth;
                }
                int i3 = this.f20810e;
                int i4 = this.f20814i;
                if (i3 < i4) {
                    this.f20810e = i4;
                    this.f20812g = measuredWidth;
                }
                int i5 = this.f20811f;
                int i6 = this.f20814i;
                if (i5 < i6) {
                    this.f20811f = i6;
                    this.f20813h = measuredHeight;
                }
                int i7 = this.f20813h;
                int i8 = this.f20815j;
                if (i7 > i8) {
                    this.f20813h = i8;
                    this.f20811f = this.f20813h - measuredHeight;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
                layoutParams.setMargins(this.f20810e, this.f20811f, 0, 0);
                setLayoutParams(layoutParams);
                this.f20808c = rawX;
                this.f20809d = rawY;
            }
        } else {
            if (Math.abs(rawX - this.f20806a) < 5 || Math.abs(rawY - this.f20807b) < 5) {
                if (this.f20817l != null) {
                    if (500 < System.currentTimeMillis() - this.f20816k) {
                        this.f20817l.mo22160b(rawX, rawY);
                    } else {
                        this.f20817l.mo22158a(rawX, rawY);
                    }
                }
                return true;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams2.setMargins(this.f20810e, this.f20811f, 0, 0);
            setLayoutParams(layoutParams2);
            InterfaceC3382a interfaceC3382a2 = this.f20817l;
            if (interfaceC3382a2 != null) {
                interfaceC3382a2.mo22162c();
            }
        }
        return true;
    }
}
