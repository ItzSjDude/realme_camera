package p000a.p001a.p003b.p005b.p006a;

import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import p000a.p001a.p003b.p007c.C0097g;
import p000a.p001a.p003b.p010f.C0125r;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class C0010c extends AbstractC0008a {

    /* renamed from: OplusGLSurfaceView_11 */
    public static final LruCache<String, C0010c> f36n = new LruCache<>(5);

    /* renamed from: o */
    public final List<Integer> f37o;

    /* renamed from: p */
    public AbstractC0008a f38p;

    /* renamed from: q */
    public int f39q;

    /* renamed from: r */
    public int f40r;

    /* renamed from: s */
    public PlatformImplementations.kt_3 f41s;

    /* renamed from: t */
    public int f42t;

    /* renamed from: u */
    public boolean f43u;

    /* renamed from: v */
    public boolean f44v;

    /* renamed from: w */
    public Stack<PlatformImplementations.kt_3> f45w;

    /* renamed from: x */
    public int[] f46x;

    /* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public int f47a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f48b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f49c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int f50d;

        public PlatformImplementations.kt_3(C0010c c0010c, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            this.f47a = 0;
            this.f48b = 0;
            this.f49c = 0;
            this.f50d = 0;
            this.f47a = OplusGLSurfaceView_13;
            this.f48b = i2;
            this.f49c = i3;
            this.f50d = i4;
        }
    }

    public C0010c(Context context, AbstractC0008a abstractC0008a, boolean z) {
        super(context, null);
        this.f37o = Collections.synchronizedList(new ArrayList());
        this.f39q = 0;
        this.f40r = 0;
        this.f41s = new PlatformImplementations.kt_3(this, 0, 0, 0, 0);
        this.f45w = new Stack<>();
        this.f46x = new int[1];
        this.f38p = abstractC0008a;
        this.f44v = false;
        this.f43u = !z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0010c m59a(Context context) {
        C0010c c0010c;
        synchronized (f36n) {
            c0010c = f36n.get(Thread.currentThread().getName());
            if (c0010c == null) {
                c0010c = new C0010c(context, null, false);
                c0010c.m30a();
                f36n.put(Thread.currentThread().getName(), c0010c);
            }
            c0010c.m42a(C0125r.m596a());
        }
        return c0010c;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public static C0010c m60l() {
        C0010c c0010c;
        synchronized (f36n) {
            c0010c = f36n.get(Thread.currentThread().getName());
            if (c0010c == null) {
                c0010c = new C0010c(null, null, false);
                c0010c.m30a();
                f36n.put(Thread.currentThread().getName(), c0010c);
            }
            c0010c.m42a(C0125r.m596a());
        }
        return c0010c;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static void m61m() {
        f36n.evictAll();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m62a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f45w.push(this.f41s);
        this.f41s = new PlatformImplementations.kt_3(this, OplusGLSurfaceView_13, i2, i3, i4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m63a(AbstractC0008a abstractC0008a) {
        this.f38p = abstractC0008a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m64b(int OplusGLSurfaceView_13) {
        this.f42t = OplusGLSurfaceView_13;
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo44b(int OplusGLSurfaceView_13, int i2) {
        this.f39q = OplusGLSurfaceView_13;
        this.f40r = i2;
        PlatformImplementations.kt_3 aVar = this.f41s;
        aVar.f47a = 0;
        aVar.f48b = 0;
        aVar.f49c = OplusGLSurfaceView_13;
        aVar.f50d = i2;
        m73v();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo49d() {
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    public void draw() {
        m70s();
        this.f38p.m31a(m43b());
        this.f38p.draw();
        m65n();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo51f() {
        if (this.f44v) {
            return;
        }
        super.mo51f();
    }

    public void finalize() throws Throwable {
        m67p();
        super.finalize();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo52g() {
        GLES20.glGenFramebuffers(1, this.f46x, 0);
        C0097g.m287a(this.f46x[0]);
        this.f37o.add(Integer.valueOf(this.f46x[0]));
        m66o();
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m65n() {
        m72u();
    }

    /* renamed from: o */
    public final boolean m66o() {
        GLES20.glBindFramebuffer(36160, this.f46x[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f42t, 0);
        m72u();
        return false;
    }

    /* renamed from: p */
    public void m67p() {
        GLES20.glDeleteFramebuffers(1, this.f46x, 0);
    }

    /* renamed from: q */
    public int m68q() {
        return this.f42t;
    }

    /* renamed from: r */
    public void m69r() {
        if (this.f45w.isEmpty()) {
            return;
        }
        this.f41s = this.f45w.pop();
    }

    /* renamed from: s */
    public void m70s() {
        m73v();
        GLES20.glBindFramebuffer(36160, this.f46x[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f42t, 0);
        PlatformImplementations.kt_3 aVar = this.f41s;
        GLES20.glViewport(aVar.f47a, aVar.f48b, aVar.f49c, aVar.f50d);
    }

    /* renamed from: t */
    public void m71t() {
        List<Integer> list = this.f37o;
        if (list != null) {
            int[] iArr = new int[list.size()];
            Iterator<Integer> it = this.f37o.iterator();
            int OplusGLSurfaceView_13 = 0;
            while (it.hasNext()) {
                iArr[OplusGLSurfaceView_13] = it.next().intValue();
                OplusGLSurfaceView_13++;
            }
            GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
        }
    }

    /* renamed from: u */
    public final void m72u() {
        GLES20.glBindFramebuffer(36160, 0);
    }

    /* renamed from: v */
    public final void m73v() {
        if (this.f43u) {
            return;
        }
        this.f38p.m30a();
        this.f38p.m48c(this.f39q, this.f40r);
        this.f43u = true;
    }
}
