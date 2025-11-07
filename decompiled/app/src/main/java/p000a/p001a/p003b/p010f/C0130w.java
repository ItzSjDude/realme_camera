package p000a.p001a.p003b.p010f;

import android.content.res.Resources;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.LruCache;
import co.polarr.renderer.entities.BrushItem;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.filters.Basic;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000a.p001a.p003b.p005b.C0016ae;
import p000a.p001a.p003b.p005b.C0024am;
import p000a.p001a.p003b.p005b.C0034aw;
import p000a.p001a.p003b.p005b.C0036ay;
import p000a.p001a.p003b.p005b.C0038b;
import p000a.p001a.p003b.p005b.C0044bf;
import p000a.p001a.p003b.p005b.C0049bk;
import p000a.p001a.p003b.p005b.C0054bp;
import p000a.p001a.p003b.p005b.p006a.AbstractC0008a;
import p000a.p001a.p003b.p005b.p006a.C0010c;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p007c.C0097g;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.w */
/* loaded from: classes.dex */
public class C0130w {

    /* renamed from: PlatformImplementations.kt_3 */
    public static LruCache<String, List<Float>> f605a = new LruCache<>(100);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final float[][] f606b = {new float[]{1.0f, 0.0f, 0.0f, 0.0f}, new float[]{0.0f, 1.0f, 0.0f, 0.0f}, new float[]{0.0f, 0.0f, 1.0f, 0.0f}, new float[]{0.0f, 0.0f, 0.0f, 1.0f}};

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static float f607c = 255.0f;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public final C0044bf f608d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public final C0054bp f609e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public final C0010c f610f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public final C0094d f611g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public final C0094d f612h;

    /* renamed from: OplusGLSurfaceView_13 */
    public final C0094d f613i;

    /* renamed from: OplusGLSurfaceView_15 */
    public final C0094d f614j;

    /* renamed from: OplusGLSurfaceView_5 */
    public final C0094d f615k;

    /* renamed from: OplusGLSurfaceView_14 */
    public final C0034aw f616l;

    /* renamed from: OplusGLSurfaceView_6 */
    public final C0024am f617m;

    /* renamed from: OplusGLSurfaceView_11 */
    public final C0049bk f618n;

    /* renamed from: o */
    public final C0036ay f619o;

    /* renamed from: p */
    public C0094d f620p;

    /* renamed from: q */
    public final Resources f621q;

    /* renamed from: r */
    public final C0038b f622r;

    /* renamed from: t */
    public C0094d f624t;

    /* renamed from: u */
    public C0094d f625u;

    /* renamed from: v */
    public C0094d f626v;

    /* renamed from: w */
    public float f627w;

    /* renamed from: s */
    public BrushItem f623s = new BrushItem();

    /* renamed from: x */
    public float f628x = f607c * 0.5f;

    public C0130w(Context context, Resources resources) {
        this.f621q = resources;
        this.f608d = new C0044bf(context, resources);
        this.f609e = new C0054bp(context, resources);
        this.f610f = C0010c.m59a(context);
        this.f622r = new C0038b(resources, context);
        this.f622r.m30a();
        int[] iArr = new int[5];
        C0113f.m480a(iArr.length, iArr, 0, 6408, 1, 1);
        this.f611g = C0113f.m486b(iArr[0], 6408, 1, 1);
        this.f612h = C0113f.m486b(iArr[1], 6408, 1, 1);
        GLES20.glBindTexture(3553, this.f612h.f387a);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9728.0f);
        GLES20.glBindTexture(3553, 0);
        this.f614j = C0113f.m486b(iArr[2], 6408, 1, 1);
        this.f613i = C0113f.m486b(iArr[3], 6408, 1, 1);
        this.f615k = C0113f.m486b(iArr[4], 6408, 1, 1);
        this.f617m = C0024am.m110a(resources, context);
        this.f618n = C0049bk.m162a(resources, context);
        this.f619o = C0036ay.m138a(resources, context);
        this.f616l = C0034aw.m136a(resources, context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static double m624a(double IntrinsicsJvm.kt_5) {
        return ((C0123p.m566a(IntrinsicsJvm.kt_5) / 10.0d) * 9.0d) + 1.0d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static List<Float> m625a(BrushItem brushItem, PointF pointF, float COUIBaseListPopupWindow_12, float f2) {
        float[] fArr;
        float[] fArr2;
        float f3 = brushItem.size * f607c;
        float f4 = brushItem.spacing;
        float[] fArr3 = new float[4];
        float[] fArr4 = {1.0f / COUIBaseListPopupWindow_12, 1.0f / f2};
        float[] fArr5 = {pointF.x * COUIBaseListPopupWindow_12, pointF.y * f2, 0.5f};
        ArrayList arrayList = new ArrayList();
        if (brushItem.prevPoint == null) {
            brushItem.prevPoint = new float[]{fArr5[0], fArr5[1], fArr5[2]};
            if (!"paint".equals(brushItem.mode)) {
                fArr5[0] = fArr5[0] * fArr4[0];
                fArr5[1] = fArr5[1] * fArr4[1];
                brushItem.points.add(Float.valueOf(fArr5[0]));
                brushItem.points.add(Float.valueOf(fArr5[1]));
                brushItem.points.add(Float.valueOf(fArr5[2]));
            }
        } else {
            if ("paint".equals(brushItem.mode)) {
                float f5 = fArr5[1];
                float[] fArr6 = brushItem.prevPoint;
                fArr = fArr4;
                fArr3[3] = (float) Math.atan2(f5 - fArr6[1], fArr5[0] - fArr6[0]);
            } else {
                fArr = fArr4;
            }
            int iMax = Math.max((int) (f4 * f3 * fArr5[2]), 1);
            float fM592a = C0125r.m592a(fArr5, brushItem.prevPoint);
            if (fM592a >= iMax) {
                float f6 = 0.0f;
                if (brushItem.interpolate) {
                    int OplusGLSurfaceView_13 = iMax;
                    while (true) {
                        float f7 = OplusGLSurfaceView_13;
                        if (f7 > fM592a) {
                            break;
                        }
                        try {
                            C0125r.m595a(brushItem.prevPoint, fArr5, f7 / fM592a, fArr3);
                            arrayList.add(Float.valueOf(fArr3[0]));
                            arrayList.add(Float.valueOf(fArr3[1]));
                            arrayList.add(Float.valueOf(fArr3[2]));
                            if ("paint".equals(brushItem.mode)) {
                                arrayList.add(Float.valueOf(fArr3[3]));
                            }
                            OplusGLSurfaceView_13 += iMax;
                        } catch (OutOfMemoryError COUIBaseListPopupWindow_8) {
                            COUIBaseListPopupWindow_8.printStackTrace();
                        }
                        COUIBaseListPopupWindow_8.printStackTrace();
                    }
                    if (!"paint".equals(brushItem.mode)) {
                        OplusGLSurfaceView_13 = 3;
                    }
                    int size = arrayList.size();
                    int i2 = size - OplusGLSurfaceView_13;
                    brushItem.prevPoint = new float[]{((Float) arrayList.get(i2)).floatValue(), ((Float) arrayList.get(i2 + 1)).floatValue(), ((Float) arrayList.get(i2 + 2)).floatValue()};
                    int i3 = 0;
                    while (i3 < size) {
                        if (brushItem.randomize > f6) {
                            fArr2 = fArr;
                            double IntrinsicsJvm.kt_5 = f3;
                            arrayList.set(i3, Float.valueOf((float) (((Float) arrayList.get(i3)).floatValue() + ((Math.random() - 0.5d) * brushItem.randomize * IntrinsicsJvm.kt_5))));
                            arrayList.set(i3 + 1, Float.valueOf((float) (((Float) arrayList.get(r6)).floatValue() + ((Math.random() - 0.5d) * brushItem.randomize * IntrinsicsJvm.kt_5))));
                        } else {
                            fArr2 = fArr;
                        }
                        arrayList.set(i3, Float.valueOf(((Float) arrayList.get(i3)).floatValue() * fArr2[0]));
                        int i4 = i3 + 1;
                        arrayList.set(i4, Float.valueOf(((Float) arrayList.get(i4)).floatValue() * fArr2[1]));
                        i3 += OplusGLSurfaceView_13;
                        fArr = fArr2;
                        f6 = 0.0f;
                    }
                    brushItem.points.addAll(arrayList);
                } else {
                    float[] fArr7 = fArr;
                    fArr3[0] = fArr5[0];
                    fArr3[1] = fArr5[1];
                    fArr3[2] = fArr5[2];
                    arrayList.add(Float.valueOf(fArr3[0]));
                    arrayList.add(Float.valueOf(fArr3[1]));
                    arrayList.add(Float.valueOf(fArr3[2]));
                    if ("paint".equals(brushItem.mode)) {
                        arrayList.add(Float.valueOf(fArr3[3]));
                    }
                    OplusGLSurfaceView_13 = "paint".equals(brushItem.mode) ? 4 : 3;
                    int size2 = arrayList.size();
                    int i5 = size2 - OplusGLSurfaceView_13;
                    brushItem.prevPoint = new float[]{((Float) arrayList.get(i5)).floatValue(), ((Float) arrayList.get(i5 + 1)).floatValue(), ((Float) arrayList.get(i5 + 2)).floatValue()};
                    for (int i6 = 0; i6 < size2; i6 += OplusGLSurfaceView_13) {
                        if (brushItem.randomize > 0.0f) {
                            double d2 = f3;
                            arrayList.set(i6, Float.valueOf((float) (((Float) arrayList.get(i6)).floatValue() + ((Math.random() - 0.5d) * brushItem.randomize * d2))));
                            arrayList.set(i6 + 1, Float.valueOf((float) (((Float) arrayList.get(r6)).floatValue() + ((Math.random() - 0.5d) * brushItem.randomize * d2))));
                        }
                        arrayList.set(i6, Float.valueOf(((Float) arrayList.get(i6)).floatValue() * fArr7[0]));
                        int i7 = i6 + 1;
                        arrayList.set(i7, Float.valueOf(((Float) arrayList.get(i7)).floatValue() * fArr7[1]));
                    }
                    brushItem.points.addAll(arrayList);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m626a() {
        f605a.evictAll();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m627a(List<PointF> list, BrushItem brushItem, float COUIBaseListPopupWindow_12, float f2) {
        brushItem.points.clear();
        brushItem.prevPoint = null;
        Iterator<PointF> it = list.iterator();
        while (it.hasNext()) {
            m625a(brushItem, it.next(), COUIBaseListPopupWindow_12, f2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m628a(int OplusGLSurfaceView_13) {
        int i2 = this.f612h.f387a;
        if (OplusGLSurfaceView_13 != i2) {
            C0094d c0094d = this.f624t;
            C0113f.m478a(OplusGLSurfaceView_13, i2, c0094d.f388b, c0094d.f389c);
        }
        m629a(this.f612h.f387a, this.f611g.f387a, 0.0f, 0.0f, 1.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m629a(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, float f2, float f3) {
        GLES20.glDisable(3042);
        this.f619o.m31a(OplusGLSurfaceView_13);
        C0036ay c0036ay = this.f619o;
        c0036ay.f164r = this.f624t.f387a;
        Matrix.setIdentityM(c0036ay.getMatrix(), 0);
        Matrix.translateM(this.f619o.getMatrix(), 0, COUIBaseListPopupWindow_12, f2, 0.0f);
        Matrix.scaleM(this.f619o.getMatrix(), 0, f3, f3, 1.0f);
        m630a(this.f619o, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m630a(AbstractC0008a abstractC0008a, int OplusGLSurfaceView_13) {
        C0010c c0010cM60l = C0010c.m60l();
        c0010cM60l.m64b(OplusGLSurfaceView_13);
        c0010cM60l.m42a(C0125r.m596a());
        C0094d c0094d = this.f624t;
        c0010cM60l.m48c(c0094d.f388b, c0094d.f389c);
        c0010cM60l.m63a(abstractC0008a);
        c0010cM60l.m70s();
        abstractC0008a.draw();
        c0010cM60l.m65n();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m631a(AbstractC0008a abstractC0008a, C0094d c0094d) {
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
    public final void m632a(C0094d c0094d) {
        GLES20.glBindTexture(3553, c0094d.f387a);
        C0113f.m491c(33071, 33071, 9729, 9729);
        GLES20.glBindTexture(3553, 0);
        this.f610f.m64b(c0094d.f387a);
        this.f610f.m42a(C0125r.m596a());
        this.f610f.m48c(c0094d.f388b, c0094d.f389c);
        this.f610f.m70s();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        m644b();
        this.f610f.m65n();
        GLES20.glFinish();
        GLES20.glFlush();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m633a(Context context, BrushItem brushItem) {
        C0054bp c0054bp;
        C0094d next;
        this.f628x = Math.max(10.0f, brushItem.size * f607c);
        float COUIBaseListPopupWindow_12 = brushItem.spacing;
        this.f627w = (float) m624a(brushItem.hardness);
        if (!"paint".equals(brushItem.mode)) {
            C0044bf c0044bf = this.f608d;
            c0044bf.f195n = this.f628x;
            c0044bf.f196o = this.f627w;
            c0044bf.f197p = brushItem.flow;
            c0044bf.f198q = brushItem.channel;
            c0044bf.f199r = brushItem.erase;
            c0044bf.f200s = false;
            return;
        }
        boolean z = brushItem.erase;
        if (z) {
            C0044bf c0044bf2 = this.f608d;
            c0044bf2.f199r = z;
            c0044bf2.f195n = this.f628x;
            c0044bf2.f196o = this.f627w;
            c0044bf2.f197p = brushItem.flow;
            c0044bf2.f198q = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
            return;
        }
        C0054bp c0054bp2 = this.f609e;
        c0054bp2.f277n = this.f628x;
        c0054bp2.f278o = brushItem.flow;
        if (context.brushes.get(brushItem.texture) != null) {
            c0054bp = this.f609e;
            next = context.brushes.get(brushItem.texture);
        } else {
            c0054bp = this.f609e;
            next = context.brushes.values().iterator().next();
        }
        c0054bp.f279p = next.f387a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m634a(Context context, BrushItem brushItem, C0094d c0094d) {
        GLES20.glDisable(3042);
        brushItem.interpolate = true;
        if (CameraStatisticsUtil.PORTRAIT_BLUR.equals(brushItem.texture) || "mosaic".equals(brushItem.texture) || "dot".equals(brushItem.texture) || "eraser".equals(brushItem.texture)) {
            brushItem.mode = "effect";
        } else {
            brushItem.mode = "paint";
        }
        this.f625u = c0094d;
        this.f620p = context.intermediateTexture;
        this.f623s = brushItem;
        this.f623s.points.clear();
        this.f623s.prevPoint = null;
        this.f610f.m64b(this.f620p.f387a);
        this.f610f.m42a(C0125r.m596a());
        C0010c c0010c = this.f610f;
        C0094d c0094d2 = this.f620p;
        c0010c.m48c(c0094d2.f388b, c0094d2.f389c);
        this.f610f.m70s();
        if ("effect".equals(this.f623s.mode)) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        } else {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        }
        m644b();
        this.f610f.m65n();
        if (CameraStatisticsUtil.PORTRAIT_BLUR.equals(this.f623s.texture)) {
            m650f();
        } else if ("mosaic".equals(this.f623s.texture)) {
            m638a("square");
        } else if ("dot".equals(this.f623s.texture)) {
            m638a("dot");
        } else {
            m632a(this.f614j);
        }
        C0094d c0094d3 = this.f620p;
        C0094d c0094d4 = context.paintTexture;
        C0113f.m490b(c0094d3, c0094d4.f388b, c0094d4.f389c);
        m633a(context, this.f623s);
        this.f610f.m64b(this.f620p.f387a);
        this.f610f.m42a(C0125r.m596a());
        C0010c c0010c2 = this.f610f;
        C0094d c0094d5 = this.f620p;
        c0010c2.m48c(c0094d5.f388b, c0094d5.f389c);
        this.f610f.m70s();
        if ("effect".equals(this.f623s.mode)) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        } else {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        }
        m644b();
        this.f610f.m65n();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m635a(Context context, BrushItem brushItem, BrushItem brushItem2, boolean z, boolean z2) {
        C0054bp c0054bp;
        C0094d next;
        if (brushItem == null) {
            brushItem = new BrushItem();
        }
        if (brushItem2 == null) {
            brushItem2 = this.f623s;
        }
        if (z2) {
            brushItem.size = brushItem2.size;
            brushItem.hardness = brushItem2.hardness;
            brushItem.flow = brushItem2.flow;
        }
        brushItem2.points = brushItem.points;
        brushItem2.size = brushItem.size;
        brushItem2.spacing = brushItem.spacing;
        brushItem2.hardness = brushItem.hardness;
        brushItem2.flow = brushItem.flow;
        brushItem2.channel = brushItem.channel;
        brushItem2.erase = brushItem.erase;
        brushItem2.mode = brushItem.mode;
        brushItem2.texture = brushItem.texture;
        brushItem2.randomize = brushItem.randomize;
        brushItem2.interpolate = brushItem.interpolate;
        BrushItem brushItem3 = this.f623s;
        brushItem3.mode = brushItem.mode;
        brushItem3.texture = brushItem.texture;
        brushItem3.randomize = brushItem.randomize;
        brushItem3.interpolate = brushItem.interpolate;
        brushItem3.erase = brushItem2.erase;
        this.f628x = Math.max(10.0f, brushItem2.size * f607c);
        float COUIBaseListPopupWindow_12 = brushItem2.spacing;
        this.f627w = (float) m624a(brushItem2.hardness);
        C0094d c0094d = context.paintTexture;
        int OplusGLSurfaceView_13 = c0094d.f388b;
        int i2 = c0094d.f389c;
        if (!"paint".equals(brushItem2.mode)) {
            C0044bf c0044bf = this.f608d;
            c0044bf.f195n = this.f628x;
            c0044bf.f196o = this.f627w;
            c0044bf.f197p = brushItem2.flow;
            c0044bf.f198q = brushItem2.channel;
            c0044bf.f199r = brushItem2.erase;
            c0044bf.f200s = false;
            if (z) {
                C0016ae.m99a(context.glRenderView.m274c(), context).f76r = this.f628x;
                C0016ae.m99a(context.glRenderView.m274c(), context).f77s = this.f627w;
                C0016ae.m99a(context.glRenderView.m274c(), context).f78t = brushItem2.flow;
                return;
            }
            return;
        }
        boolean z3 = brushItem2.erase;
        if (z3) {
            C0044bf c0044bf2 = this.f608d;
            c0044bf2.f199r = z3;
            c0044bf2.f195n = this.f628x;
            c0044bf2.f196o = this.f627w;
            c0044bf2.f197p = brushItem2.flow;
            c0044bf2.f198q = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
            return;
        }
        C0054bp c0054bp2 = this.f609e;
        c0054bp2.f277n = this.f628x;
        c0054bp2.f278o = brushItem2.flow;
        if (context.brushes.get(brushItem2.texture) != null) {
            c0054bp = this.f609e;
            next = context.brushes.get(brushItem2.texture);
        } else {
            c0054bp = this.f609e;
            next = context.brushes.values().iterator().next();
        }
        c0054bp.f279p = next.f387a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m636a(Context context, BrushItem brushItem, boolean z) {
        List<Float> list;
        if (brushItem.blend) {
            return;
        }
        BrushItem brushItem2 = new BrushItem();
        if (brushItem.pointId == null || (list = brushItem.points) == null || list.isEmpty()) {
            String str = brushItem.pointId;
            if (str != null) {
                brushItem.points = f605a.get(str);
            }
        } else {
            f605a.put(brushItem.pointId, brushItem.points);
        }
        m635a(context, brushItem, brushItem2, z, false);
        List<Float> list2 = brushItem2.points;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        m639a(brushItem2.points);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0142  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m637a(co.polarr.renderer.entities.Context r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p003b.p010f.C0130w.m637a(co.polarr.renderer.entities.Context, boolean):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m638a(String str) {
        C0094d c0094d = this.f624t;
        int OplusGLSurfaceView_13 = c0094d.f388b;
        int i2 = c0094d.f389c;
        float COUIBaseListPopupWindow_12 = this.f623s.mosaicSize;
        C0094d c0094d2 = this.f614j;
        C0113f.m490b(c0094d2, OplusGLSurfaceView_13, i2);
        GLES20.glBindTexture(3553, c0094d2.f387a);
        C0113f.m491c(33071, 33071, 9728, 9728);
        GLES20.glBindTexture(3553, 0);
        C0034aw c0034aw = this.f616l;
        c0034aw.f158r = str;
        c0034aw.f159s = COUIBaseListPopupWindow_12;
        c0034aw.f160t = c0094d.f388b;
        c0034aw.f161u = c0094d.f389c;
        c0034aw.f162v = this.f626v.f387a;
        c0034aw.m31a(c0094d.f387a);
        m631a(this.f616l, c0094d2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m639a(List<Float> list) {
        C0044bf c0044bf;
        boolean z;
        if (!"paint".equals(this.f623s.mode)) {
            c0044bf = this.f608d;
            z = false;
        } else if (!this.f623s.erase) {
            this.f609e.m208a(list);
            return;
        } else {
            c0044bf = this.f608d;
            z = true;
        }
        c0044bf.m154a(list, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m640a(List<PointF> list, float COUIBaseListPopupWindow_12, float f2, float f3) {
        GLES20.glDisable(3042);
        this.f610f.m64b(this.f620p.f387a);
        this.f610f.m42a(C0125r.m596a());
        C0010c c0010c = this.f610f;
        C0094d c0094d = this.f620p;
        c0010c.m48c(c0094d.f388b, c0094d.f389c);
        this.f610f.m70s();
        ArrayList arrayList = new ArrayList();
        for (PointF pointF : list) {
            BrushItem brushItem = this.f623s;
            C0094d c0094d2 = this.f620p;
            arrayList.addAll(m625a(brushItem, pointF, c0094d2.f388b, c0094d2.f389c));
        }
        m639a(arrayList);
        this.f610f.m65n();
        m642a(false, COUIBaseListPopupWindow_12, f2, f3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m641a(boolean z) {
        C0038b c0038b;
        C0094d c0094d;
        GLES20.glFinish();
        "effect".equals(this.f623s.mode);
        this.f610f.m64b(this.f625u.f387a);
        this.f610f.m42a(C0125r.m596a());
        C0010c c0010c = this.f610f;
        C0094d c0094d2 = this.f625u;
        c0010c.m48c(c0094d2.f388b, c0094d2.f389c);
        this.f610f.m70s();
        Basic basic = Basic.getInstance(this.f621q);
        basic.setNeedClear(false);
        GLES20.glEnable(3042);
        GLES20.glBlendEquation(32774);
        GLES20.glBlendFuncSeparate(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771, 0, 1);
        if ("effect".equals(this.f623s.mode)) {
            this.f622r.m42a(C0125r.m596a());
            this.f622r.m31a(this.f620p.f387a);
            C0038b c0038b2 = this.f622r;
            c0038b2.f170q = 1.0f;
            c0038b2.f171r = 1.0f;
            if (CameraStatisticsUtil.PORTRAIT_BLUR.equals(this.f623s.texture) || "mosaic".equals(this.f623s.texture) || "dot".equals(this.f623s.texture) || z) {
                c0038b = this.f622r;
                c0094d = this.f614j;
            } else {
                c0038b = this.f622r;
                c0094d = this.f624t;
            }
            c0038b.f172s = c0094d.f387a;
            this.f622r.draw();
        } else {
            GLES20.glBlendFunc(1, 771);
            basic.setInputTextureId(this.f620p.f387a);
            basic.draw();
        }
        GLES20.glDisable(3042);
        this.f610f.m65n();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m642a(boolean z, float COUIBaseListPopupWindow_12, float f2, float f3) {
        C0038b c0038b;
        C0094d c0094d;
        this.f610f.m64b(this.f625u.f387a);
        this.f610f.m42a(C0125r.m596a());
        C0010c c0010c = this.f610f;
        C0094d c0094d2 = this.f625u;
        c0010c.m48c(c0094d2.f388b, c0094d2.f389c);
        this.f610f.m70s();
        Basic basic = Basic.getInstance(this.f621q);
        basic.setNeedClear(false);
        Matrix.translateM(basic.getMatrix(), 0, COUIBaseListPopupWindow_12, f2, 0.0f);
        Matrix.scaleM(basic.getMatrix(), 0, f3, f3, 1.0f);
        if (!z) {
            GLES20.glClear(16384);
            GLES20.glDisable(3042);
            basic.setInputTextureId(this.f611g.f387a);
            basic.draw();
        }
        GLES20.glEnable(3042);
        GLES20.glBlendEquation(32774);
        GLES20.glBlendFuncSeparate(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771, 0, 1);
        if ("effect".equals(this.f623s.mode)) {
            this.f622r.m42a(C0125r.m596a());
            Matrix.translateM(this.f622r.getMatrix(), 0, COUIBaseListPopupWindow_12, f2, 0.0f);
            Matrix.scaleM(this.f622r.getMatrix(), 0, f3, f3, 1.0f);
            this.f622r.m31a(this.f620p.f387a);
            C0038b c0038b2 = this.f622r;
            c0038b2.f170q = 1.0f;
            c0038b2.f171r = 1.0f;
            if (CameraStatisticsUtil.PORTRAIT_BLUR.equals(this.f623s.texture) || "mosaic".equals(this.f623s.texture) || "dot".equals(this.f623s.texture) || z) {
                c0038b = this.f622r;
                c0094d = this.f614j;
            } else {
                c0038b = this.f622r;
                c0094d = this.f624t;
            }
            c0038b.f172s = c0094d.f387a;
            this.f622r.draw();
        } else {
            GLES20.glBlendFunc(1, 771);
            basic.setInputTextureId(this.f620p.f387a);
            basic.draw();
        }
        GLES20.glDisable(3042);
        this.f610f.m65n();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m643a(float[] fArr) {
        GLES20.glColorMask(fArr[0] != 0.0f, fArr[1] != 0.0f, fArr[2] != 0.0f, fArr[3] != 0.0f);
        GLES20.glClear(16384);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m644b() {
        m643a(new float[]{1.0f, 1.0f, 1.0f, 1.0f});
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m645b(C0094d c0094d) {
        this.f626v = c0094d;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public C0094d m646c() {
        return this.f612h;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m647c(C0094d c0094d) {
        this.f624t = c0094d;
        C0113f.m490b(this.f611g, c0094d.f388b, c0094d.f389c);
        C0113f.m490b(this.f612h, c0094d.f388b, c0094d.f389c);
        C0113f.m490b(this.f613i, c0094d.f388b, c0094d.f389c);
        m632a(this.f612h);
        C0113f.m478a(c0094d.f387a, this.f611g.f387a, c0094d.f388b, c0094d.f389c);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m648d() {
        GLES20.glDisable(3042);
        this.f625u = this.f611g;
        m641a(false);
        m651g();
        GLES20.glBindTexture(3553, this.f612h.f387a);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9728.0f);
        GLES20.glBindTexture(3553, 0);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m649e() {
        C0094d c0094d = this.f611g;
        if (c0094d != null) {
            C0097g.m288a(c0094d);
            C0097g.m312e(this.f611g.f387a);
        }
        C0094d c0094d2 = this.f612h;
        if (c0094d2 != null) {
            C0097g.m288a(c0094d2);
            C0097g.m312e(this.f612h.f387a);
        }
        C0094d c0094d3 = this.f614j;
        if (c0094d3 != null) {
            C0097g.m288a(c0094d3);
            C0097g.m312e(this.f614j.f387a);
        }
        C0094d c0094d4 = this.f615k;
        if (c0094d4 != null) {
            C0097g.m288a(c0094d4);
            C0097g.m312e(this.f615k.f387a);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public final void m650f() {
        C0094d c0094d = this.f624t;
        int OplusGLSurfaceView_13 = c0094d.f388b;
        int i2 = c0094d.f389c;
        while (true) {
            if (OplusGLSurfaceView_13 <= 2048 && i2 <= 2048) {
                float COUIBaseListPopupWindow_12 = 1.0f / OplusGLSurfaceView_13;
                float f2 = 1.0f / i2;
                C0094d c0094d2 = this.f614j;
                C0094d c0094d3 = this.f620p;
                C0113f.m490b(c0094d2, OplusGLSurfaceView_13, i2);
                C0113f.m490b(c0094d3, OplusGLSurfaceView_13, i2);
                GLES20.glBindTexture(3553, c0094d2.f387a);
                C0113f.m491c(33071, 33071, 9729, 9729);
                GLES20.glBindTexture(3553, 0);
                C0024am c0024am = this.f617m;
                c0024am.f116s = Context.overlayMesh;
                c0024am.f115r = new float[]{COUIBaseListPopupWindow_12, 0.0f};
                c0024am.m31a(this.f624t.f387a);
                m631a(this.f617m, c0094d3);
                C0024am c0024am2 = this.f617m;
                c0024am2.f115r = new float[]{0.0f, f2};
                c0024am2.m31a(c0094d3.f387a);
                m631a(this.f617m, c0094d2);
                C0024am c0024am3 = this.f617m;
                c0024am3.f115r = new float[]{COUIBaseListPopupWindow_12, 0.0f};
                c0024am3.m31a(c0094d2.f387a);
                m631a(this.f617m, c0094d3);
                C0024am c0024am4 = this.f617m;
                c0024am4.f115r = new float[]{0.0f, f2};
                c0024am4.m31a(c0094d3.f387a);
                m631a(this.f617m, c0094d2);
                return;
            }
            OplusGLSurfaceView_13 >>= 1;
            i2 >>= 1;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public final void m651g() {
        C0094d c0094d = this.f612h;
        C0113f.m478a(c0094d.f387a, this.f613i.f387a, c0094d.f388b, c0094d.f389c);
        this.f618n.m31a(this.f611g.f387a);
        C0049bk c0049bk = this.f618n;
        c0049bk.f218r = this.f624t.f387a;
        c0049bk.f219s = this.f613i.f387a;
        c0049bk.f220t = this.f620p.f387a;
        m631a(c0049bk, this.f612h);
    }
}
