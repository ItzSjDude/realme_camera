package com.oplus.camera.gl_renamed;

/* loaded from: classes2.dex */
public class GLView {

    /* renamed from: c_renamed, reason: collision with root package name */
    protected com.oplus.camera.gl_renamed.GLView f4570c;
    private com.oplus.camera.gl_renamed.n_renamed j_renamed;
    private java.util.ArrayList<com.oplus.camera.gl_renamed.GLView> k_renamed;
    private com.oplus.camera.gl_renamed.GLView l_renamed;
    private com.oplus.camera.gl_renamed.f_renamed m_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    protected final android.graphics.Rect f4568a = new android.graphics.Rect();

    /* renamed from: b_renamed, reason: collision with root package name */
    protected final android.graphics.Rect f4569b = new android.graphics.Rect();
    protected int d_renamed = 0;
    protected int e_renamed = 0;
    protected int f_renamed = 0;
    protected int g_renamed = 0;
    protected int h_renamed = 0;
    protected int i_renamed = 0;
    private int n_renamed = 0;
    private int o_renamed = -1;
    private int p_renamed = -1;

    protected void a_renamed(int i_renamed, int i2) {
    }

    protected void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, int i_renamed) {
    }

    protected void a_renamed(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
    }

    protected boolean a_renamed(android.view.MotionEvent motionEvent) {
        return false;
    }

    protected void b_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
    }

    protected void f_renamed() {
    }

    public int a_renamed() {
        return (this.n_renamed & 1) == 0 ? 0 : 1;
    }

    public void a_renamed(com.oplus.camera.gl_renamed.n_renamed nVar) {
        com.oplus.camera.gl_renamed.y_renamed.a_renamed(this.f4570c == null && this.j_renamed == null);
        b_renamed(nVar);
    }

    public void b_renamed() {
        com.oplus.camera.gl_renamed.y_renamed.a_renamed(this.f4570c == null && this.j_renamed != null);
        g_renamed();
    }

    public int c_renamed() {
        java.util.ArrayList<com.oplus.camera.gl_renamed.GLView> arrayList = this.k_renamed;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public com.oplus.camera.gl_renamed.GLView a_renamed(int i_renamed) {
        java.util.ArrayList<com.oplus.camera.gl_renamed.GLView> arrayList = this.k_renamed;
        if (arrayList == null) {
            throw new java.lang.ArrayIndexOutOfBoundsException(i_renamed);
        }
        return arrayList.get(i_renamed);
    }

    public com.oplus.camera.gl_renamed.n_renamed d_renamed() {
        return this.j_renamed;
    }

    public void e_renamed() {
        com.oplus.camera.gl_renamed.n_renamed nVarD = d_renamed();
        if (nVarD != null) {
            nVarD.a_renamed();
        }
    }

    protected void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar) {
        b_renamed(hVar);
        int iC = c_renamed();
        for (int i_renamed = 0; i_renamed < iC; i_renamed++) {
            a_renamed(hVar, a_renamed(i_renamed));
        }
    }

    protected void a_renamed(com.oplus.camera.gl_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.GLView gLView) {
        if (gLView.a_renamed() == 0 || gLView.m_renamed != null) {
            hVar.a_renamed(gLView.f4568a.left - this.g_renamed, gLView.f4568a.top - this.f_renamed);
            com.oplus.camera.gl_renamed.f_renamed fVar = gLView.m_renamed;
            if (fVar != null) {
                hVar.a_renamed(fVar.a_renamed());
                if (fVar.b_renamed(com.oplus.camera.gl_renamed.b_renamed.b_renamed())) {
                    e_renamed();
                } else {
                    gLView.m_renamed = null;
                }
                fVar.a_renamed(hVar);
            }
            gLView.a_renamed(hVar);
            if (fVar != null) {
                hVar.f_renamed();
            }
            hVar.a_renamed(-r0, -r1);
        }
    }

    protected boolean a_renamed(android.view.MotionEvent motionEvent, int i_renamed, int i2, com.oplus.camera.gl_renamed.GLView gLView, boolean z_renamed) {
        android.graphics.Rect rect = gLView.f4568a;
        int i3 = rect.left;
        int i4 = rect.top;
        if (z_renamed && !rect.contains(i_renamed, i2)) {
            return false;
        }
        motionEvent.offsetLocation(-i3, -i4);
        if (gLView.b_renamed(motionEvent)) {
            motionEvent.offsetLocation(i3, i4);
            return true;
        }
        motionEvent.offsetLocation(i3, i4);
        return false;
    }

    protected boolean b_renamed(android.view.MotionEvent motionEvent) {
        int x_renamed = (int) motionEvent.getX();
        int y_renamed = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        com.oplus.camera.gl_renamed.GLView gLView = this.l_renamed;
        if (gLView != null) {
            if (action == 0) {
                android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
                motionEventObtain.setAction(3);
                a_renamed(motionEventObtain, x_renamed, y_renamed, this.l_renamed, false);
                this.l_renamed = null;
            } else {
                a_renamed(motionEvent, x_renamed, y_renamed, gLView, false);
                if (action == 3 || action == 1) {
                    this.l_renamed = null;
                }
                return true;
            }
        }
        if (action == 0) {
            for (int iC = c_renamed() - 1; iC >= 0; iC--) {
                com.oplus.camera.gl_renamed.GLView gLViewA = a_renamed(iC);
                if (gLViewA.a_renamed() == 0 && a_renamed(motionEvent, x_renamed, y_renamed, gLViewA, true)) {
                    this.l_renamed = gLViewA;
                    return true;
                }
            }
        }
        return a_renamed(motionEvent);
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        boolean zB = b_renamed(i_renamed, i2, i3, i4);
        this.n_renamed &= -5;
        a_renamed(zB, i_renamed, i2, i3, i4);
    }

    private boolean b_renamed(int i_renamed, int i2, int i3, int i4) {
        boolean z_renamed = (i3 - i_renamed == this.f4568a.right - this.f4568a.left && i4 - i2 == this.f4568a.bottom - this.f4568a.top) ? false : true;
        this.f4568a.set(i_renamed, i2, i3, i4);
        return z_renamed;
    }

    protected void b_renamed(com.oplus.camera.gl_renamed.n_renamed nVar) {
        this.j_renamed = nVar;
        int iC = c_renamed();
        for (int i_renamed = 0; i_renamed < iC; i_renamed++) {
            a_renamed(i_renamed).b_renamed(nVar);
        }
    }

    protected void g_renamed() {
        int iC = c_renamed();
        for (int i_renamed = 0; i_renamed < iC; i_renamed++) {
            a_renamed(i_renamed).g_renamed();
        }
        this.j_renamed = null;
    }
}
