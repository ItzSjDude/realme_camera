package p000a.p001a.p003b.p005b.p006a;

import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import p000a.p001a.p003b.p005b.C0015ad;
import p000a.p001a.p003b.p005b.C0023al;
import p000a.p001a.p003b.p005b.C0033av;
import p000a.p001a.p003b.p005b.C0048bj;
import p000a.p001a.p003b.p005b.C0062bx;
import p000a.p001a.p003b.p005b.C0065c;
import p000a.p001a.p003b.p005b.C0069f;
import p000a.p001a.p003b.p005b.C0074k;
import p000a.p001a.p003b.p005b.C0075l;
import p000a.p001a.p003b.p005b.C0079p;
import p000a.p001a.p003b.p007c.C0097g;
import p000a.p001a.p003b.p010f.C0113f;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class C0011d extends AbstractC0008a {

    /* renamed from: OplusGLSurfaceView_11 */
    public Queue<AbstractC0008a> f51n;

    /* renamed from: o */
    public List<AbstractC0008a> f52o;

    /* renamed from: p */
    public int f53p;

    /* renamed from: q */
    public int f54q;

    /* renamed from: r */
    public int f55r;

    /* renamed from: s */
    public int f56s;

    /* renamed from: t */
    public int[] f57t;

    /* renamed from: u */
    public int[] f58u;

    /* renamed from: v */
    public int f59v;

    public C0011d(Context context, Resources resources) {
        super(context, resources);
        this.f53p = 0;
        this.f54q = 0;
        this.f55r = 0;
        this.f56s = 2;
        this.f57t = new int[1];
        this.f58u = new int[this.f56s];
        this.f59v = 0;
        this.f52o = new ArrayList();
        this.f51n = new ConcurrentLinkedQueue();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m74a(AbstractC0008a abstractC0008a) {
        this.f51n.add(abstractC0008a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m75a(Context context) {
        this.f21a = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m76a(AbstractC0008a abstractC0008a, boolean z) {
        abstractC0008a.f21a = this.f21a;
        if (this.f21a.isLutRender && ((abstractC0008a instanceof C0065c) || (abstractC0008a instanceof C0033av) || (abstractC0008a instanceof C0069f) || (abstractC0008a instanceof C0062bx) || (abstractC0008a instanceof C0023al) || (abstractC0008a instanceof C0074k) || (abstractC0008a instanceof C0048bj) || (abstractC0008a instanceof C0075l) || (abstractC0008a instanceof C0079p) || (abstractC0008a instanceof C0015ad))) {
            return false;
        }
        if (!z && (abstractC0008a instanceof C0009b) && ((C0009b) abstractC0008a).mo24l()) {
            return false;
        }
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f58u[this.f59v % 2], 0);
        int OplusGLSurfaceView_13 = this.f59v;
        abstractC0008a.m31a(OplusGLSurfaceView_13 == 0 ? m43b() : this.f58u[(OplusGLSurfaceView_13 - 1) % 2]);
        abstractC0008a.m42a(this.f30j);
        abstractC0008a.draw();
        this.f59v++;
        return true;
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo44b(int OplusGLSurfaceView_13, int i2) {
        this.f53p = OplusGLSurfaceView_13;
        this.f54q = i2;
        m93y();
        m79e(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m77b(AbstractC0008a abstractC0008a) {
        return m76a(abstractC0008a, false);
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo49d() {
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m78d(int OplusGLSurfaceView_13, int i2) {
        int[] iArr = this.f58u;
        iArr[0] = OplusGLSurfaceView_13;
        iArr[1] = i2;
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    public void draw() {
        m91w();
        m83o();
        m84p();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public final void m79e(int OplusGLSurfaceView_13, int i2) {
        this.f53p = OplusGLSurfaceView_13;
        this.f54q = i2;
        m94z();
        GLES20.glBindFramebuffer(36160, this.f57t[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f58u[0], 0);
        m92x();
    }

    @Override // p000a.p001a.p003b.p005b.p006a.AbstractC0008a
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo52g() {
        m81m();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public final void m80l() {
        GLES20.glBindFramebuffer(36160, this.f57t[0]);
        GLES20.glViewport(0, 0, this.f53p, this.f54q);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public final void m81m() {
        m82n();
        GLES20.glGenFramebuffers(1, this.f57t, 0);
        C0097g.m287a(this.f57t[0]);
        GLES20.glGenTextures(this.f56s, this.f58u, 0);
        for (int OplusGLSurfaceView_13 : this.f58u) {
            C0097g.m306c(OplusGLSurfaceView_13);
        }
        for (int i2 = 0; i2 < this.f56s; i2++) {
            GLES20.glBindTexture(3553, this.f58u[i2]);
            C0113f.m487b();
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m82n() {
        GLES20.glDeleteFramebuffers(1, this.f57t, 0);
        GLES20.glDeleteTextures(this.f56s, this.f58u, 0);
        C0097g.m309d(this.f57t[0]);
        for (int OplusGLSurfaceView_13 : this.f58u) {
            C0097g.m312e(OplusGLSurfaceView_13);
        }
        GLES20.glFlush();
    }

    /* renamed from: o */
    public void m83o() {
        if (this.f55r > 0) {
            boolean z = false;
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f52o.size(); OplusGLSurfaceView_13++) {
                z = z || m77b(this.f52o.get(OplusGLSurfaceView_13));
            }
            if (z) {
                return;
            }
            m76a(this.f52o.get(0), true);
        }
    }

    /* renamed from: p */
    public void m84p() {
        m92x();
    }

    /* renamed from: q */
    public List<AbstractC0008a> m85q() {
        return this.f52o;
    }

    /* renamed from: r */
    public int m86r() {
        int OplusGLSurfaceView_13 = this.f59v;
        return OplusGLSurfaceView_13 == 0 ? m43b() : this.f58u[(OplusGLSurfaceView_13 - 1) % 2];
    }

    /* renamed from: s */
    public void m87s() {
        m92x();
    }

    /* renamed from: t */
    public void m88t() {
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f58u[this.f59v % 2], 0);
        this.f59v++;
    }

    /* renamed from: u */
    public void m89u() {
        m82n();
    }

    /* renamed from: v */
    public void m90v() {
        m80l();
    }

    /* renamed from: w */
    public void m91w() {
        m93y();
        this.f59v = 0;
        m80l();
    }

    /* renamed from: x */
    public final void m92x() {
        GLES20.glBindRenderbuffer(36161, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    /* renamed from: y */
    public final void m93y() {
        while (true) {
            AbstractC0008a abstractC0008aPoll = this.f51n.poll();
            if (abstractC0008aPoll == null) {
                return;
            }
            abstractC0008aPoll.m30a();
            abstractC0008aPoll.m48c(this.f53p, this.f54q);
            this.f52o.add(abstractC0008aPoll);
            this.f55r++;
        }
    }

    /* renamed from: z */
    public final void m94z() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f56s; OplusGLSurfaceView_13++) {
            GLES20.glBindTexture(3553, this.f58u[OplusGLSurfaceView_13]);
            GLES20.glTexImage2D(3553, 0, 6408, this.f53p, this.f54q, 0, 6408, 5121, null);
        }
    }
}
