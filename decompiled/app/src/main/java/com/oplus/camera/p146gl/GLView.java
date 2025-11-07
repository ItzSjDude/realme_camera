package com.oplus.camera.p146gl;

import android.graphics.Rect;
import android.view.MotionEvent;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class GLView {

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected GLView f13837c;

    /* renamed from: OplusGLSurfaceView_15 */
    private GLRoot f13844j;

    /* renamed from: OplusGLSurfaceView_5 */
    private ArrayList<GLView> f13845k;

    /* renamed from: OplusGLSurfaceView_14 */
    private GLView f13846l;

    /* renamed from: OplusGLSurfaceView_6 */
    private CanvasAnimation f13847m;

    /* renamed from: PlatformImplementations.kt_3 */
    protected final Rect f13835a = new Rect();

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected final Rect f13836b = new Rect();

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected int f13838d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected int f13839e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected int f13840f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected int f13841g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected int f13842h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    protected int f13843i = 0;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f13848n = 0;

    /* renamed from: o */
    private int f13849o = -1;

    /* renamed from: p */
    private int f13850p = -1;

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo13801a(int OplusGLSurfaceView_13, int i2) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo13804a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m13807a(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean m13808a(MotionEvent motionEvent) {
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo13811b(GLCanvas interfaceC2757h) {
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo13817f() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m13799a() {
        return (this.f13848n & 1) == 0 ? 0 : 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13806a(GLRoot interfaceC2763n) {
        Utils_3.m14289a(this.f13837c == null && this.f13844j == null);
        m13812b(interfaceC2763n);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13810b() {
        Utils_3.m14289a(this.f13837c == null && this.f13844j != null);
        m13818g();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m13814c() {
        ArrayList<GLView> arrayList = this.f13845k;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public GLView m13800a(int OplusGLSurfaceView_13) {
        ArrayList<GLView> arrayList = this.f13845k;
        if (arrayList == null) {
            throw new ArrayIndexOutOfBoundsException(OplusGLSurfaceView_13);
        }
        return arrayList.get(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public GLRoot m13815d() {
        return this.f13844j;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m13816e() {
        GLRoot interfaceC2763nM13815d = m13815d();
        if (interfaceC2763nM13815d != null) {
            interfaceC2763nM13815d.mo13788a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo13803a(GLCanvas interfaceC2757h) {
        mo13811b(interfaceC2757h);
        int iM13814c = m13814c();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM13814c; OplusGLSurfaceView_13++) {
            m13805a(interfaceC2757h, m13800a(OplusGLSurfaceView_13));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m13805a(GLCanvas interfaceC2757h, GLView gLView) {
        if (gLView.m13799a() == 0 || gLView.f13847m != null) {
            interfaceC2757h.mo13959a(gLView.f13835a.left - this.f13841g, gLView.f13835a.top - this.f13840f);
            CanvasAnimation abstractC2755f = gLView.f13847m;
            if (abstractC2755f != null) {
                interfaceC2757h.mo13965a(abstractC2755f.m13949a());
                if (abstractC2755f.m13821b(AnimationTime.m13867b())) {
                    m13816e();
                } else {
                    gLView.f13847m = null;
                }
                abstractC2755f.m13950a(interfaceC2757h);
            }
            gLView.mo13803a(interfaceC2757h);
            if (abstractC2755f != null) {
                interfaceC2757h.mo13985f();
            }
            interfaceC2757h.mo13959a(-r0, -r1);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean m13809a(MotionEvent motionEvent, int OplusGLSurfaceView_13, int i2, GLView gLView, boolean z) {
        Rect rect = gLView.f13835a;
        int i3 = rect.left;
        int i4 = rect.top;
        if (z && !rect.contains(OplusGLSurfaceView_13, i2)) {
            return false;
        }
        motionEvent.offsetLocation(-i3, -i4);
        if (gLView.m13813b(motionEvent)) {
            motionEvent.offsetLocation(i3, i4);
            return true;
        }
        motionEvent.offsetLocation(i3, i4);
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected boolean m13813b(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        GLView gLView = this.f13846l;
        if (gLView != null) {
            if (action == 0) {
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                motionEventObtain.setAction(3);
                m13809a(motionEventObtain, x, y, this.f13846l, false);
                this.f13846l = null;
            } else {
                m13809a(motionEvent, x, y, gLView, false);
                if (action == 3 || action == 1) {
                    this.f13846l = null;
                }
                return true;
            }
        }
        if (action == 0) {
            for (int iM13814c = m13814c() - 1; iM13814c >= 0; iM13814c--) {
                GLView gLViewM13800a = m13800a(iM13814c);
                if (gLViewM13800a.m13799a() == 0 && m13809a(motionEvent, x, y, gLViewM13800a, true)) {
                    this.f13846l = gLViewM13800a;
                    return true;
                }
            }
        }
        return m13808a(motionEvent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13802a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        boolean zM13798b = m13798b(OplusGLSurfaceView_13, i2, i3, i4);
        this.f13848n &= -5;
        m13807a(zM13798b, OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m13798b(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        boolean z = (i3 - OplusGLSurfaceView_13 == this.f13835a.right - this.f13835a.left && i4 - i2 == this.f13835a.bottom - this.f13835a.top) ? false : true;
        this.f13835a.set(OplusGLSurfaceView_13, i2, i3, i4);
        return z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m13812b(GLRoot interfaceC2763n) {
        this.f13844j = interfaceC2763n;
        int iM13814c = m13814c();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM13814c; OplusGLSurfaceView_13++) {
            m13800a(OplusGLSurfaceView_13).m13812b(interfaceC2763n);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void m13818g() {
        int iM13814c = m13814c();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM13814c; OplusGLSurfaceView_13++) {
            m13800a(OplusGLSurfaceView_13).m13818g();
        }
        this.f13844j = null;
    }
}
