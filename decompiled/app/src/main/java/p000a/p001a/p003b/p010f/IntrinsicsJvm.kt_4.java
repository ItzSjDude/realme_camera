package p000a.p001a.p003b.p010f;

import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import android.util.Log;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.MagicEraserHistoryItem;
import co.polarr.renderer.entities.MagicEraserPath;
import co.polarr.renderer.entities.Mesh;
import co.polarr.renderer.filters.Basic;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000a.p001a.p003b.p005b.C0019ah;
import p000a.p001a.p003b.p005b.C0028aq;
import p000a.p001a.p003b.p005b.C0044bf;
import p000a.p001a.p003b.p005b.C0047bi;
import p000a.p001a.p003b.p005b.C0073j;
import p000a.p001a.p003b.p005b.C0077n;
import p000a.p001a.p003b.p005b.C0078o;
import p000a.p001a.p003b.p005b.C0083t;
import p000a.p001a.p003b.p005b.C0087x;
import p000a.p001a.p003b.p005b.p006a.AbstractC0008a;
import p000a.p001a.p003b.p005b.p006a.C0010c;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p007c.C0097g;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.z */
/* loaded from: classes.dex */
public class C0133z {

    /* renamed from: PlatformImplementations.kt_3 */
    public Resources f659a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Context f660b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f661c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public C0094d f662d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public C0094d[] f663e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public float[][] f664f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int f665g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public MagicEraserHistoryItem f666h;

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean f667i;

    /* renamed from: OplusGLSurfaceView_15 */
    public int f668j;

    /* renamed from: OplusGLSurfaceView_5 */
    public C0094d f669k;

    /* renamed from: OplusGLSurfaceView_14 */
    public C0094d f670l;

    /* renamed from: OplusGLSurfaceView_6 */
    public C0094d f671m;

    /* renamed from: OplusGLSurfaceView_11 */
    public C0094d f672n;

    /* renamed from: o */
    public boolean f673o;

    /* renamed from: p */
    public int f674p;

    /* renamed from: q */
    public float[] f675q;

    /* renamed from: r */
    public C0087x f676r;

    /* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.z$IntrinsicsJvm.kt_4 */
    public class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public C0094d f677a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public IntrinsicsJvm.kt_5 f678b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public List<IntrinsicsJvm.kt_3> f679c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public RectF f680d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public C0094d f681e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public C0094d f682f;

        public IntrinsicsJvm.kt_4(C0133z c0133z) {
            this.f679c = new ArrayList();
        }
    }

    /* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.z$IntrinsicsJvm.kt_3 */
    public static class IntrinsicsJvm.kt_3 extends C0094d {

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int f683e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public int f684f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public float[] f685g;

        /* renamed from: PlatformImplementations.kt_3 */
        public static IntrinsicsJvm.kt_3 m690a(C0094d c0094d) {
            IntrinsicsJvm.kt_3 cVar = new IntrinsicsJvm.kt_3();
            cVar.f387a = c0094d.f387a;
            cVar.f388b = c0094d.f388b;
            cVar.f389c = c0094d.f389c;
            cVar.f390d = c0094d.f390d;
            return cVar;
        }
    }

    /* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.z$IntrinsicsJvm.kt_5 */
    public class IntrinsicsJvm.kt_5 {

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_3 f686a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public C0094d f687b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public C0094d f688c;

        public IntrinsicsJvm.kt_5(C0133z c0133z, IntrinsicsJvm.kt_3 cVar, C0094d c0094d, C0094d c0094d2) {
            this.f686a = cVar;
            this.f687b = c0094d;
            this.f688c = c0094d2;
        }
    }

    public C0133z(Resources resources, C0120m c0120m) {
        int OplusGLSurfaceView_13 = this.f661c;
        this.f663e = new C0094d[OplusGLSurfaceView_13];
        this.f664f = new float[OplusGLSurfaceView_13][];
        this.f659a = resources;
        this.f660b = new Context();
        this.f660b.mesh = Mesh.plane(new Mesh.Options(true, false, false, 1));
        this.f660b.shaderUtil = c0120m;
        this.f665g = 0;
        int[] iArr = new int[3];
        C0113f.m480a(3, iArr, 0, 6408, 1, 1);
        this.f662d = C0113f.m486b(iArr[0], 6408, 1, 1);
        this.f670l = C0113f.m486b(iArr[1], 6408, 1, 1);
        this.f671m = C0113f.m486b(iArr[2], 6408, 1, 1);
        this.f669k = m664a(1, 1);
        this.f672n = m664a(1, 1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float[] m662a(RectF rectF, float COUIBaseListPopupWindow_12, float f2, float f3) {
        float f4 = f3 * 2.0f;
        float fMin = Math.min(Math.max(Math.round(rectF.width() * COUIBaseListPopupWindow_12) + f4, 0.0f), COUIBaseListPopupWindow_12) / COUIBaseListPopupWindow_12;
        float fMin2 = Math.min(Math.max(Math.round(rectF.height() * f2) + f4, 0.0f), f2) / f2;
        float fMin3 = Math.min(Math.max(Math.round(rectF.left * COUIBaseListPopupWindow_12) - f3, 0.0f), COUIBaseListPopupWindow_12 - fMin) / COUIBaseListPopupWindow_12;
        float fMin4 = Math.min(Math.max(Math.round(rectF.top * f2) - f3, 0.0f), f2 - fMin2) / f2;
        float f5 = 1.0f / fMin;
        float f6 = 1.0f / fMin2;
        float[] fArrM596a = C0125r.m596a();
        Matrix.translateM(fArrM596a, 0, (-1.0f) - ((fMin3 * 2.0f) * f5), (fMin4 * 2.0f * f6) + 1.0f, 0.0f);
        Matrix.scaleM(fArrM596a, 0, f5, f6, 1.0f);
        Matrix.translateM(fArrM596a, 0, 1.0f, -1.0f, 0.0f);
        return fArrM596a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final int m663a(int OplusGLSurfaceView_13, int i2, int i3) {
        return Math.max(i2, Math.min(OplusGLSurfaceView_13, i3));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final C0094d m664a(int OplusGLSurfaceView_13, int i2) {
        C0094d c0094dM665a = m665a(6408, 5131, OplusGLSurfaceView_13, i2);
        GLES20.glBindTexture(3553, c0094dM665a.f387a);
        C0113f.m491c(33071, 33071, 9728, 9728);
        GLES20.glBindTexture(3553, 0);
        return c0094dM665a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final C0094d m665a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int[] iArr = new int[1];
        C0113f.m481a(iArr.length, iArr, 0, OplusGLSurfaceView_13, i2, i3, i4);
        return C0113f.m486b(iArr[0], OplusGLSurfaceView_13, i3, i4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final C0094d m666a(C0094d c0094d, int OplusGLSurfaceView_13) {
        C0094d c0094dM684b = m684b(c0094d.f388b, c0094d.f389c);
        C0083t c0083tM246a = C0083t.m246a(this.f659a, this.f660b);
        c0083tM246a.m31a(c0094d.f387a);
        c0083tM246a.f348r = OplusGLSurfaceView_13;
        m676a(c0083tM246a, c0094dM684b);
        return c0094dM684b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final C0094d m667a(IntrinsicsJvm.kt_4 bVar, int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 + 1;
        int iMin = Math.min(6, i2);
        C0094d c0094d = bVar.f678b.f687b;
        int i3 = 1;
        while (i3 <= i2) {
            m680a(bVar, bVar.f678b, iMin);
            m681a(bVar, bVar.f678b, (OplusGLSurfaceView_13 < 1 || i3 != i2) ? bVar.f679c.get(OplusGLSurfaceView_13) : bVar.f679c.get(OplusGLSurfaceView_13 - 1), c0094d);
            i3++;
        }
        if (this.f673o) {
            GLES30.glFinish();
        }
        return c0094d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final C0094d m668a(IntrinsicsJvm.kt_3 cVar) {
        C0094d c0094dM684b = m684b(cVar.f388b, cVar.f389c);
        C0077n c0077nM238a = C0077n.m238a(this.f659a, this.f660b);
        c0077nM238a.f328r = cVar.f387a;
        m676a(c0077nM238a, c0094dM684b);
        m679a(cVar, c0094dM684b);
        C0113f.m490b(c0094dM684b, cVar.f683e, cVar.f684f);
        AbstractC0008a abstractC0008aM5425a = Basic.m5425a(this.f659a, this.f660b);
        abstractC0008aM5425a.m31a(cVar.f387a);
        abstractC0008aM5425a.m42a(cVar.f685g);
        m676a(abstractC0008aM5425a, c0094dM684b);
        return c0094dM684b;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0062  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final p000a.p001a.p003b.p010f.C0133z.IntrinsicsJvm.kt_5 m669a(p000a.p001a.p003b.p010f.C0133z.IntrinsicsJvm.kt_4 r7, p000a.p001a.p003b.p007c.C0094d r8, p000a.p001a.p003b.p007c.C0094d r9, p000a.p001a.p003b.p010f.C0133z.IntrinsicsJvm.kt_3 r10) {
        /*
            r6 = this;
            int r0 = r10.f683e
            int r1 = r10.f684f
            r2 = 34842(0x881a, float:4.8824E-41)
            r3 = 5131(0x140b, float:7.19E-42)
            p000a.p001a.p003b.p010f.C0113f.m483a(r8, r2, r3, r0, r1)
            android.content.res.Resources r0 = r6.f659a
            co.polarr.renderer.entities.Context r1 = r6.f660b
            PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.aq r0 = p000a.p001a.p003b.p005b.C0028aq.m116a(r0, r1)
            float[] r1 = r10.f685g
            r0.f135v = r1
            int r1 = r10.f387a
            r0.f131r = r1
            r1 = 2
            float[] r2 = new float[r1]
            int r3 = r10.f388b
            float r3 = (float) r3
            r4 = 0
            r2[r4] = r3
            int r3 = r10.f389c
            float r3 = (float) r3
            r5 = 1
            r2[r5] = r3
            r0.f132s = r2
            PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5 r7 = r7.f677a
            float[] r1 = new float[r1]
            int r2 = r7.f388b
            float r2 = (float) r2
            r1[r4] = r2
            int r7 = r7.f389c
            float r7 = (float) r7
            r1[r5] = r7
            r0.f133t = r1
            boolean r7 = r6.f667i
            if (r7 == 0) goto L62
            co.polarr.renderer.entities.MagicEraserHistoryItem r7 = r6.f666h
            java.util.List<java.lang.Float> r7 = r7.randomLists
            int r7 = r7.size()
            int r1 = r6.f668j
            if (r7 <= r1) goto L62
            co.polarr.renderer.entities.MagicEraserHistoryItem r7 = r6.f666h
            java.util.List<java.lang.Float> r7 = r7.randomLists
            int r2 = r1 + 1
            r6.f668j = r2
            java.lang.Object r7 = r7.get(r1)
            java.lang.Float r7 = (java.lang.Float) r7
            float r7 = r7.floatValue()
            r0.f134u = r7
            goto L76
        L62:
            double r1 = java.lang.Math.random()
            float r7 = (float) r1
            r0.f134u = r7
            co.polarr.renderer.entities.MagicEraserHistoryItem r7 = r6.f666h
            java.util.List<java.lang.Float> r7 = r7.randomLists
            float r1 = r0.f134u
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r7.add(r1)
        L76:
            float[] r7 = r10.f685g
            r0.m42a(r7)
            r6.m676a(r0, r8)
            PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.z$IntrinsicsJvm.kt_5 r7 = new PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.z$IntrinsicsJvm.kt_5
            r7.<init>(r6, r10, r9, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p003b.p010f.C0133z.m669a(PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.z$IntrinsicsJvm.kt_4, PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5, PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5, PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.z$IntrinsicsJvm.kt_3):PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.z$IntrinsicsJvm.kt_5");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final IntrinsicsJvm.kt_5 m670a(IntrinsicsJvm.kt_4 bVar, IntrinsicsJvm.kt_5 dVar, C0094d c0094d, IntrinsicsJvm.kt_3 cVar) {
        C0094d c0094d2 = dVar.f688c;
        C0094d c0094d3 = bVar.f682f;
        C0113f.m483a(c0094d3, 34842, 5131, cVar.f683e, cVar.f684f);
        C0078o c0078oM240a = C0078o.m240a(this.f659a, this.f660b);
        float[] fArr = cVar.f685g;
        c0078oM240a.f336x = fArr;
        c0078oM240a.f331s = cVar.f387a;
        c0078oM240a.f330r = c0094d.f387a;
        c0078oM240a.f332t = c0094d2.f387a;
        c0078oM240a.f333u = new float[]{cVar.f388b, cVar.f389c};
        c0078oM240a.f334v = new float[]{c0094d.f388b, c0094d.f389c};
        C0094d c0094d4 = bVar.f677a;
        c0078oM240a.f335w = new float[]{c0094d4.f388b, c0094d4.f389c};
        c0078oM240a.m42a(fArr);
        m676a(c0078oM240a, c0094d3);
        m679a(c0094d2, c0094d3);
        return new IntrinsicsJvm.kt_5(this, cVar, c0094d, c0094d2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<Float> m671a(List<PointF> list, float COUIBaseListPopupWindow_12) {
        ArrayList arrayList = new ArrayList();
        this.f675q = null;
        Iterator<PointF> it = list.iterator();
        while (it.hasNext()) {
            m683a(arrayList, it.next(), COUIBaseListPopupWindow_12);
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m672a() {
        m689c(-1, -1);
        C0094d c0094d = this.f662d;
        if (c0094d != null) {
            C0097g.m288a(c0094d);
            C0097g.m312e(this.f662d.f387a);
        }
        C0094d c0094d2 = this.f671m;
        if (c0094d2 != null) {
            C0097g.m288a(c0094d2);
            C0097g.m312e(this.f671m.f387a);
        }
        C0094d c0094d3 = this.f670l;
        if (c0094d3 != null) {
            C0097g.m288a(c0094d3);
            C0097g.m312e(this.f670l.f387a);
        }
        C0094d c0094d4 = this.f669k;
        if (c0094d4 != null) {
            m677a(c0094d4);
            this.f669k = null;
        }
        C0094d c0094d5 = this.f672n;
        if (c0094d5 != null) {
            m677a(c0094d5);
            this.f672n = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m673a(int OplusGLSurfaceView_13) {
        if (this.f661c <= 0) {
            return;
        }
        Basic basicM5425a = Basic.m5425a(this.f659a, this.f660b);
        basicM5425a.setNeedClear(false);
        C0010c c0010cM60l = C0010c.m60l();
        c0010cM60l.m64b(OplusGLSurfaceView_13);
        C0094d c0094d = this.f662d;
        c0010cM60l.m48c(c0094d.f388b, c0094d.f389c);
        c0010cM60l.m70s();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        basicM5425a.m31a(this.f662d.f387a);
        basicM5425a.draw();
        for (int i2 = 0; i2 < this.f665g; i2++) {
            C0094d c0094d2 = this.f663e[i2];
            Matrix.invertM(basicM5425a.getMatrix(), 0, this.f664f[i2], 0);
            basicM5425a.m31a(c0094d2.f387a);
            basicM5425a.draw();
        }
        c0010cM60l.m65n();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m674a(int OplusGLSurfaceView_13, int i2, Rect rect) {
        C0113f.m488b(i2, rect.width(), rect.height());
        C0113f.m479a(OplusGLSurfaceView_13, i2, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x01bb  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m675a(int r20, co.polarr.renderer.entities.MagicEraserPath r21) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p003b.p010f.C0133z.m675a(int, co.polarr.renderer.entities.MagicEraserPath):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m676a(AbstractC0008a abstractC0008a, C0094d c0094d) {
        C0010c c0010cM60l = C0010c.m60l();
        c0010cM60l.m64b(c0094d.f387a);
        c0010cM60l.m42a(C0125r.m596a());
        c0010cM60l.m48c(c0094d.f388b, c0094d.f389c);
        c0010cM60l.m63a(abstractC0008a);
        c0010cM60l.m70s();
        abstractC0008a.draw();
        c0010cM60l.m65n();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m677a(C0094d c0094d) {
        int OplusGLSurfaceView_13 = c0094d.f387a;
        if (OplusGLSurfaceView_13 != 0) {
            C0113f.m476a(OplusGLSurfaceView_13);
            C0097g.m312e(c0094d.f387a);
        }
        c0094d.f387a = 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m678a(C0094d c0094d, int OplusGLSurfaceView_13, MagicEraserPath magicEraserPath, int i2, int i3, float COUIBaseListPopupWindow_12, float f2, float f3) {
        C0094d c0094d2 = this.f662d;
        C0113f.m490b(c0094d, c0094d2.f388b, c0094d2.f389c);
        C0044bf c0044bf = new C0044bf(this.f660b, this.f659a);
        c0044bf.f196o = (float) C0130w.m624a(1.0d);
        c0044bf.f197p = 1.0f;
        c0044bf.f198q = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
        C0010c c0010cM60l = C0010c.m60l();
        c0010cM60l.m64b(c0094d.f387a);
        c0010cM60l.m48c(c0094d.f388b, c0094d.f389c);
        c0010cM60l.m70s();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        List<PointF> list = magicEraserPath.points;
        if (list != null && !list.isEmpty()) {
            float f4 = magicEraserPath.radius * 2.0f;
            c0044bf.f195n = f4;
            c0044bf.m154a(m671a(magicEraserPath.points, f4), false);
        }
        c0010cM60l.m65n();
        GLES20.glViewport(0, 0, i2, i3);
        Basic basicM5425a = Basic.m5425a(this.f659a, this.f660b);
        Matrix.scaleM(basicM5425a.getMatrix(), 0, 1.0f, -1.0f, 1.0f);
        Matrix.translateM(basicM5425a.getMatrix(), 0, COUIBaseListPopupWindow_12, f2, 0.0f);
        Matrix.scaleM(basicM5425a.getMatrix(), 0, f3, f3, 1.0f);
        basicM5425a.m31a(OplusGLSurfaceView_13);
        basicM5425a.draw();
        if (this.f676r == null) {
            this.f676r = new C0087x(this.f659a, this.f660b);
            this.f676r.m30a();
        }
        this.f660b.overlayMask = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
        C0087x c0087x = this.f676r;
        c0087x.f356r = 0.5f;
        c0087x.m31a(c0094d.f387a);
        Matrix.setIdentityM(this.f676r.getMatrix(), 0);
        Matrix.scaleM(this.f676r.getMatrix(), 0, 1.0f, -1.0f, 1.0f);
        GLES20.glEnable(3042);
        GLES20.glBlendEquation(32774);
        GLES20.glBlendFunc(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
        this.f676r.draw();
        GLES20.glDisable(3042);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m679a(C0094d c0094d, C0094d c0094d2) {
        int OplusGLSurfaceView_13 = c0094d2.f387a;
        c0094d2.f387a = c0094d.f387a;
        c0094d.f387a = OplusGLSurfaceView_13;
        int i2 = c0094d2.f388b;
        c0094d2.f388b = c0094d.f388b;
        c0094d.f388b = i2;
        int i3 = c0094d2.f389c;
        c0094d2.f389c = c0094d.f389c;
        c0094d.f389c = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0109  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m680a(p000a.p001a.p003b.p010f.C0133z.IntrinsicsJvm.kt_4 r20, p000a.p001a.p003b.p010f.C0133z.IntrinsicsJvm.kt_5 r21, int r22) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p003b.p010f.C0133z.m680a(PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.z$IntrinsicsJvm.kt_4, PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.z$IntrinsicsJvm.kt_5, int):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m681a(IntrinsicsJvm.kt_4 bVar, IntrinsicsJvm.kt_5 dVar, IntrinsicsJvm.kt_3 cVar, C0094d c0094d) {
        C0094d c0094d2 = bVar.f681e;
        C0094d c0094d3 = dVar.f688c;
        C0113f.m490b(c0094d2, cVar.f683e, cVar.f684f);
        C0047bi c0047biM158a = C0047bi.m158a(this.f659a, this.f660b);
        float[] fArr = cVar.f685g;
        c0047biM158a.f215w = fArr;
        c0047biM158a.f212t = c0094d3.f387a;
        c0047biM158a.f211s = cVar.f387a;
        c0047biM158a.f210r = c0094d.f387a;
        c0047biM158a.f213u = new float[]{c0094d.f388b, c0094d.f389c};
        C0094d c0094d4 = bVar.f677a;
        c0047biM158a.f214v = new float[]{c0094d4.f388b, c0094d4.f389c};
        c0047biM158a.m42a(fArr);
        m676a(c0047biM158a, c0094d2);
        m679a(c0094d, c0094d2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public final void m682a(IntrinsicsJvm.kt_3 cVar, C0094d c0094d, int OplusGLSurfaceView_13, RectF rectF, int i2) {
        GLES30.glGetError();
        C0094d c0094dM667a = null;
        IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4();
        bVar.f677a = cVar;
        bVar.f680d = rectF;
        bVar.f678b = null;
        bVar.f679c = new ArrayList();
        int i3 = 1;
        bVar.f681e = m684b(1, 1);
        bVar.f682f = this.f669k;
        this.f673o = false;
        float fMin = Math.min(bVar.f680d.width(), 1.0f);
        float fMin2 = Math.min(bVar.f680d.height(), 1.0f);
        C0094d c0094d2 = this.f670l;
        float COUIBaseListPopupWindow_12 = fMin * fMin2 * c0094d2.f389c * c0094d2.f388b;
        Log.IntrinsicsJvm.kt_5("POLARR_SDK", "pixels:" + Math.round(COUIBaseListPopupWindow_12));
        if (COUIBaseListPopupWindow_12 > 1.0E7f) {
            this.f673o = true;
            i3 = 3;
        } else if (COUIBaseListPopupWindow_12 > 2000000.0f) {
            this.f673o = true;
            i3 = 2;
        } else if (COUIBaseListPopupWindow_12 > 1000000.0f) {
            this.f673o = true;
        } else {
            if (COUIBaseListPopupWindow_12 > 500000.0f) {
                this.f673o = true;
            }
            i3 = 0;
        }
        if (this.f673o) {
            this.f674p = Math.min(this.f674p, 3);
            this.f674p = Math.max(this.f674p, 0);
            i3 += this.f674p;
        }
        IntrinsicsJvm.kt_3 cVarM690a = IntrinsicsJvm.kt_3.m690a(m666a(cVar, c0094d.f387a));
        bVar.f679c.add(cVarM690a);
        int i4 = OplusGLSurfaceView_13 * 2;
        cVarM690a.f683e = m663a(Math.round(cVarM690a.f388b * bVar.f680d.width()) + i4, 0, cVarM690a.f388b);
        cVarM690a.f684f = m663a(Math.round(cVarM690a.f389c * bVar.f680d.height()) + i4, 0, cVarM690a.f389c);
        float f2 = OplusGLSurfaceView_13;
        cVarM690a.f685g = m662a(bVar.f680d, cVarM690a.f388b, cVarM690a.f389c, f2);
        while (cVarM690a.f683e > OplusGLSurfaceView_13 && cVarM690a.f684f > OplusGLSurfaceView_13) {
            cVarM690a = IntrinsicsJvm.kt_3.m690a(m685b(cVarM690a));
            cVarM690a.f683e = m663a(Math.round(cVarM690a.f388b * bVar.f680d.width()) + i4, 0, cVarM690a.f388b);
            cVarM690a.f684f = m663a(Math.round(cVarM690a.f389c * bVar.f680d.height()) + i4, 0, cVarM690a.f389c);
            cVarM690a.f685g = m662a(bVar.f680d, cVarM690a.f388b, cVarM690a.f389c, f2);
            bVar.f679c.add(cVarM690a);
        }
        int size = bVar.f679c.size() - 3;
        for (int i5 = size; i5 >= i3; i5--) {
            IntrinsicsJvm.kt_3 cVar2 = bVar.f679c.get(i5);
            bVar.f678b = i5 == size ? m669a(bVar, this.f672n, m668a(cVar2), cVar2) : m670a(bVar, bVar.f678b, c0094dM667a, cVar2);
            c0094dM667a = m667a(bVar, i5);
            GLES20.glFinish();
            if (i5 == i3) {
                Basic basicM5425a = Basic.m5425a(this.f659a, this.f660b);
                basicM5425a.setNeedClear(false);
                C0010c c0010cM60l = C0010c.m60l();
                c0010cM60l.m64b(i2);
                c0010cM60l.m48c(cVar.f388b, cVar.f389c);
                c0010cM60l.m70s();
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16384);
                basicM5425a.m31a(cVar2.f387a);
                basicM5425a.draw();
                Matrix.invertM(basicM5425a.getMatrix(), 0, cVar2.f685g, 0);
                basicM5425a.m31a(c0094dM667a.f387a);
                basicM5425a.draw();
                c0010cM60l.m65n();
                m677a(bVar.f681e);
                Iterator<IntrinsicsJvm.kt_3> it = bVar.f679c.iterator();
                while (it.hasNext()) {
                    m677a(it.next());
                }
            }
        }
        GLES30.glFlush();
        GLES30.glGetError();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m683a(List<Float> list, PointF pointF, float COUIBaseListPopupWindow_12) {
        float[] fArr = new float[4];
        C0094d c0094d = this.f662d;
        float f2 = c0094d.f388b;
        float f3 = c0094d.f389c;
        float[] fArr2 = {1.0f / f2, 1.0f / f3};
        float[] fArr3 = {pointF.x * f2, (1.0f - pointF.y) * f3, 0.5f};
        if (this.f675q == null) {
            this.f675q = new float[]{fArr3[0], fArr3[1], fArr3[2]};
            fArr3[0] = fArr3[0] * fArr2[0];
            fArr3[1] = fArr3[1] * fArr2[1];
            list.add(Float.valueOf(fArr3[0]));
            list.add(Float.valueOf(fArr3[1]));
            list.add(Float.valueOf(fArr3[2]));
            return;
        }
        int OplusGLSurfaceView_13 = (int) (COUIBaseListPopupWindow_12 * 0.3f * fArr3[2]);
        if (OplusGLSurfaceView_13 < 1) {
            OplusGLSurfaceView_13 = 1;
        }
        float fM592a = C0125r.m592a(fArr3, this.f675q);
        if (fM592a >= OplusGLSurfaceView_13) {
            ArrayList arrayList = new ArrayList();
            int i2 = OplusGLSurfaceView_13;
            while (true) {
                float f4 = i2;
                if (f4 > fM592a) {
                    break;
                }
                try {
                    C0125r.m595a(this.f675q, fArr3, f4 / fM592a, fArr);
                    arrayList.add(Float.valueOf(fArr[0]));
                    arrayList.add(Float.valueOf(fArr[1]));
                    arrayList.add(Float.valueOf(fArr[2]));
                    i2 += OplusGLSurfaceView_13;
                } catch (OutOfMemoryError COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                    return;
                }
                COUIBaseListPopupWindow_8.printStackTrace();
                return;
            }
            int size = arrayList.size();
            int i3 = size - 3;
            this.f675q = new float[]{((Float) arrayList.get(i3)).floatValue(), ((Float) arrayList.get(i3 + 1)).floatValue(), ((Float) arrayList.get(i3 + 2)).floatValue()};
            for (int i4 = 0; i4 < size; i4 += 3) {
                arrayList.set(i4, Float.valueOf(((Float) arrayList.get(i4)).floatValue() * fArr2[0]));
                int i5 = i4 + 1;
                arrayList.set(i5, Float.valueOf(((Float) arrayList.get(i5)).floatValue() * fArr2[1]));
            }
            list.addAll(arrayList);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final C0094d m684b(int OplusGLSurfaceView_13, int i2) {
        int[] iArr = new int[1];
        C0113f.m480a(iArr.length, iArr, 0, 6408, OplusGLSurfaceView_13, i2);
        return C0113f.m486b(iArr[0], 6408, OplusGLSurfaceView_13, i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final C0094d m685b(C0094d c0094d) {
        C0094d c0094dM684b = m684b(c0094d.f388b >> 1, c0094d.f389c >> 1);
        Basic basicM5425a = Basic.m5425a(this.f659a, this.f660b);
        basicM5425a.m31a(c0094d.f387a);
        m676a(basicM5425a, c0094dM684b);
        return c0094dM684b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m686b() {
        C0083t.m247m();
        C0077n.m239m();
        C0047bi.m159m();
        C0019ah.m104m();
        C0073j.m234m();
        C0078o.m241m();
        C0028aq.m117m();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m687b(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f674p = i4;
        C0113f.m490b(this.f662d, i2, i3);
        m689c(OplusGLSurfaceView_13, -1);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m688b(int OplusGLSurfaceView_13, int i2, Rect rect) {
        C0113f.m489b(OplusGLSurfaceView_13, i2, rect);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m689c(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 > 0) {
            Basic basicM5425a = Basic.m5425a(this.f659a, this.f660b);
            basicM5425a.m31a(OplusGLSurfaceView_13);
            m676a(basicM5425a, this.f662d);
        }
        if (i2 != 0) {
            this.f665g = -1;
            m673a(i2);
        }
        for (C0094d c0094d : this.f663e) {
            if (c0094d != null) {
                m677a(c0094d);
            }
        }
        for (int i3 = 0; i3 < this.f661c; i3++) {
            this.f663e[i3] = null;
            this.f664f[i3] = null;
        }
        this.f665g = 0;
    }
}
