package com.oplus.camera.p146gl;

import android.util.Log;
import java.util.Iterator;
import java.util.WeakHashMap;

/* compiled from: BasicTexture.java */
/* renamed from: com.oplus.camera.gl.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public abstract class BasicTexture implements Texture {

    /* renamed from: OplusGLSurfaceView_15 */
    private static WeakHashMap<BasicTexture, Object> f13965j = new WeakHashMap<>();

    /* renamed from: OplusGLSurfaceView_5 */
    private static ThreadLocal f13966k = new ThreadLocal();

    /* renamed from: PlatformImplementations.kt_3 */
    public int f13967a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int f13968b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected int f13969c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected int f13970d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected int f13971e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected int f13972f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected GLCanvas f13973g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private long f13974h;

    /* renamed from: OplusGLSurfaceView_13 */
    private long f13975i;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f13976l;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected abstract boolean mo13931b(GLCanvas interfaceC2757h);

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean mo13933d() {
        return false;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public abstract int mo13942m();

    protected BasicTexture(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2) {
        this.f13967a = -1;
        this.f13968b = -1;
        this.f13969c = -1;
        this.f13973g = null;
        this.f13974h = 0L;
        this.f13975i = 0L;
        m13927a(interfaceC2757h);
        this.f13969c = OplusGLSurfaceView_13;
        this.f13970d = i2;
        synchronized (f13965j) {
            f13965j.put(this, null);
        }
    }

    protected BasicTexture() {
        this(null, 0, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m13922a() {
        synchronized (f13965j) {
            Iterator<BasicTexture> it = f13965j.keySet().iterator();
            while (it.hasNext()) {
                it.next().mo13946q();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m13923b() {
        synchronized (f13965j) {
            for (BasicTexture abstractC2752c : f13965j.keySet()) {
                abstractC2752c.f13970d = 0;
                abstractC2752c.m13927a((GLCanvas) null);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m13927a(GLCanvas interfaceC2757h) {
        this.f13973g = interfaceC2757h;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public GLCanvas m13932c() {
        return this.f13973g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13925a(int OplusGLSurfaceView_13, int i2) {
        this.f13967a = OplusGLSurfaceView_13;
        this.f13968b = i2;
        this.f13971e = OplusGLSurfaceView_13;
        this.f13972f = i2;
        if (this.f13971e > 4096 || this.f13972f > 4096) {
            Log.w("BasicTexture", String.format("texture is too large: %IntrinsicsJvm.kt_5 x %IntrinsicsJvm.kt_5", Integer.valueOf(this.f13971e), Integer.valueOf(this.f13972f)), new Exception());
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m13934e() {
        return this.f13969c;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int mo13935f() {
        return this.f13967a;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int mo13936g() {
        return this.f13968b;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public int m13937h() {
        return this.f13971e;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public int m13938i() {
        return this.f13972f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13926a(long OplusGLSurfaceView_15) {
        this.f13974h = OplusGLSurfaceView_15;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public long m13939j() {
        return this.f13974h;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13930b(long OplusGLSurfaceView_15) {
        this.f13975i = OplusGLSurfaceView_15;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public long m13940k() {
        return this.f13975i;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m13941l() {
        return this.f13976l;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m13929a(boolean z) {
        this.f13976l = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13928a(GLCanvas interfaceC2757h, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        interfaceC2757h.mo13968a(this, OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public boolean m13943n() {
        return this.f13970d == 1;
    }

    /* renamed from: o */
    public void mo13944o() {
        m13924s();
    }

    /* renamed from: p */
    public void m13945p() {
        this.f13970d = 0;
        m13927a((GLCanvas) null);
    }

    /* renamed from: q */
    public void mo13946q() {
        m13924s();
    }

    /* renamed from: s */
    private void m13924s() {
        GLCanvas interfaceC2757h = this.f13973g;
        if (interfaceC2757h != null && this.f13969c != -1) {
            interfaceC2757h.mo13978a(this);
            this.f13969c = -1;
        }
        this.f13970d = 0;
        m13927a((GLCanvas) null);
    }

    protected void finalize() {
        f13966k.set(BasicTexture.class);
        mo13944o();
        f13966k.set(null);
    }
}
