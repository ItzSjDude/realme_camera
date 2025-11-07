package co.polarr.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p000a.p001a.p003b.p010f.C0125r;

/* loaded from: classes.dex */
public class PolarrPainter {
    public static final float BUFFER_THES = 5.0f;
    public static final float DETLA_MOVEMENT = 10.0f;

    /* renamed from: K */
    public static final PorterDuffXfermode f5077K = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    public static final float MAX_FADE_THRES = 20.0f;
    public static final boolean USE_PATH_HISTORY = true;

    /* renamed from: A */
    public PathMeasure f5078A;

    /* renamed from: B */
    public float f5079B;

    /* renamed from: C */
    public int f5080C;

    /* renamed from: D */
    public int f5081D;

    /* renamed from: E */
    public float f5082E;

    /* renamed from: F */
    public float f5083F;

    /* renamed from: G */
    public float f5084G;

    /* renamed from: H */
    public int f5085H;

    /* renamed from: I */
    public BrushStyle f5086I;

    /* renamed from: J */
    public Canvas f5087J;

    /* renamed from: PlatformImplementations.kt_3 */
    public final Context f5088a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Bitmap f5089b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Bitmap f5090c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Bitmap f5091d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public Bitmap f5092e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public Bitmap f5093f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public Bitmap f5094g;

    /* renamed from: s */
    public double f5106s;

    /* renamed from: t */
    public float f5107t;

    /* renamed from: u */
    public float f5108u;

    /* renamed from: v */
    public int f5109v;

    /* renamed from: z */
    public Path f5113z;

    /* renamed from: q */
    public porender_qbdmL f5104q = porender_qbdmL.IDLE;

    /* renamed from: r */
    public BrushStyle f5105r = null;

    /* renamed from: x */
    public List<porender_iuAiH> f5111x = new ArrayList();

    /* renamed from: OplusGLSurfaceView_11 */
    public float[] f5101n = new float[2];

    /* renamed from: o */
    public float[] f5102o = new float[2];

    /* renamed from: w */
    public float[] f5110w = new float[2];

    /* renamed from: COUIBaseListPopupWindow_10 */
    public Paint f5095h = new Paint();

    /* renamed from: OplusGLSurfaceView_13 */
    public Paint f5096i = new Paint();

    /* renamed from: OplusGLSurfaceView_14 */
    public Canvas f5099l = new Canvas();

    /* renamed from: OplusGLSurfaceView_5 */
    public Canvas f5098k = new Canvas();

    /* renamed from: OplusGLSurfaceView_6 */
    public Canvas f5100m = new Canvas();

    /* renamed from: OplusGLSurfaceView_15 */
    public Canvas f5097j = new Canvas();

    /* renamed from: p */
    public Matrix f5103p = new Matrix();

    /* renamed from: y */
    public int f5112y = 0;

    public enum BrushStyle {
        MARKER("brush/brush8.png", 0.04f, 5.0f, 0.0f, 1, 0.8f, false),
        PENCIL("brush/dot10.png", 0.1f, 360.0f, 0.5f, 5, 1.0f, true),
        PAINTING("brush/pen2.png", 0.025f, 0.0f, 0.0f, 1, 1.0f, false);

        public final boolean canFade;
        public final int maxFlow;
        public final float maxRot;
        public final float paintAlpha;
        public final float randomRange;
        public final String resName;
        public final float spacing;

        BrushStyle(String str, float COUIBaseListPopupWindow_12, float f2, float f3, int OplusGLSurfaceView_13, float f4, boolean z) {
            this.resName = str;
            this.spacing = COUIBaseListPopupWindow_12;
            this.maxRot = f2;
            this.randomRange = f3;
            this.maxFlow = OplusGLSurfaceView_13;
            this.paintAlpha = f4;
            this.canFade = z;
        }
    }

    public static /* synthetic */ class porender_YuvEf {

        /* renamed from: PlatformImplementations.kt_3 */
        public static final /* synthetic */ int[] f5114a = new int[porender_qbdmL.values().length];

        static {
            try {
                f5114a[porender_qbdmL.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5114a[porender_qbdmL.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5114a[porender_qbdmL.MOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5114a[porender_qbdmL.DONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class porender_iuAiH {

        /* renamed from: PlatformImplementations.kt_3 */
        public float f5115a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public float f5116b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f5117c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public float f5118d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public boolean f5119e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public BrushStyle f5120f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public Path f5121g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public boolean f5122h;

        public porender_iuAiH(PolarrPainter polarrPainter) {
        }

        public /* synthetic */ porender_iuAiH(PolarrPainter polarrPainter, porender_YuvEf porender_yuvef) {
            this(polarrPainter);
        }
    }

    public enum porender_qbdmL {
        IDLE,
        START,
        MOVE,
        DONE
    }

    public PolarrPainter(Context context) {
        this.f5088a = context;
        updateBrushStyle(BrushStyle.MARKER);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bitmap m5390a(Bitmap bitmap, Rect rect) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Matrix matrix = new Matrix();
        matrix.postTranslate(-rect.left, -rect.top);
        canvas.drawBitmap(bitmap, matrix, null);
        return bitmapCreateBitmap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m5391a() {
        this.f5099l.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f5100m.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f5098k.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f5097j.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0088  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m5392a(int r10) {
        /*
            r9 = this;
            android.graphics.Picture r0 = new android.graphics.Picture
            r0.<init>()
            android.graphics.Bitmap r1 = r9.f5092e
            int r1 = r1.getWidth()
            android.graphics.Bitmap r2 = r9.f5092e
            int r2 = r2.getHeight()
            android.graphics.Canvas r1 = r0.beginRecording(r1, r2)
            r9.f5099l = r1
            java.util.List<co.polarr.renderer.PolarrPainter$porender_iuAiH> r1 = r9.f5111x
            java.lang.Object r10 = r1.get(r10)
            co.polarr.renderer.PolarrPainter$porender_iuAiH r10 = (co.polarr.renderer.PolarrPainter.porender_iuAiH) r10
            boolean r1 = co.polarr.renderer.PolarrPainter.porender_iuAiH.m5405a(r10)
            if (r1 == 0) goto L29
            r9.m5391a()
            return
        L29:
            android.graphics.PathMeasure r1 = new android.graphics.PathMeasure
            r1.<init>()
            co.polarr.renderer.PolarrPainter$BrushStyle r2 = co.polarr.renderer.PolarrPainter.porender_iuAiH.m5415g(r10)
            co.polarr.renderer.PolarrPainter$BrushStyle r3 = r9.f5105r
            if (r2 == r3) goto L4d
            co.polarr.renderer.PolarrPainter$BrushStyle r2 = co.polarr.renderer.PolarrPainter.porender_iuAiH.m5415g(r10)
            r9.updateBrushStyle(r2)
        L3d:
            float r2 = co.polarr.renderer.PolarrPainter.porender_iuAiH.m5416h(r10)
            float r3 = co.polarr.renderer.PolarrPainter.porender_iuAiH.m5410c(r10)
            int r4 = co.polarr.renderer.PolarrPainter.porender_iuAiH.m5408b(r10)
            r9.updateBrushSize(r2, r3, r4)
            goto L6a
        L4d:
            float r2 = r9.f5107t
            float r3 = co.polarr.renderer.PolarrPainter.porender_iuAiH.m5416h(r10)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L3d
            float r2 = r9.f5108u
            float r3 = co.polarr.renderer.PolarrPainter.porender_iuAiH.m5410c(r10)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L3d
            int r2 = r9.f5109v
            int r3 = co.polarr.renderer.PolarrPainter.porender_iuAiH.m5408b(r10)
            if (r2 == r3) goto L6a
            goto L3d
        L6a:
            r2 = 0
            r9.f5079B = r2
            android.graphics.Path r3 = co.polarr.renderer.PolarrPainter.porender_iuAiH.m5414f(r10)
            r4 = 0
            r1.setPath(r3, r4)
            float r3 = co.polarr.renderer.PolarrPainter.porender_iuAiH.m5413e(r10)
            float r5 = r9.f5079B
            float r6 = r9.f5082E
            r7 = 1084227584(0x40a00000, float:5.0)
            float r7 = r7 * r6
            r8 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 * r7
            float r5 = r5 + r8
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 <= 0) goto L8c
            float r3 = r3 - r7
            r9.m5394a(r1, r3, r6, r4)
        L8c:
            float r3 = r1.getLength()
            float r5 = r9.f5082E
            boolean r10 = co.polarr.renderer.PolarrPainter.porender_iuAiH.m5412d(r10)
            r9.m5394a(r1, r3, r5, r10)
            r0.endRecording()
            android.graphics.Canvas r10 = r9.f5087J
            r0.draw(r10)
            android.graphics.Paint r10 = r9.f5095h
            r0 = 0
            r10.setXfermode(r0)
            android.graphics.Canvas r10 = r9.f5098k
            float r1 = r9.f5108u
            r3 = 1132396544(0x437f0000, float:255.0)
            float r1 = r1 * r3
            int r1 = (int) r1
            int r3 = r9.f5109v
            int r3 = android.graphics.Color.red(r3)
            int r5 = r9.f5109v
            int r5 = android.graphics.Color.green(r5)
            int r6 = r9.f5109v
            int r6 = android.graphics.Color.blue(r6)
            int r1 = android.graphics.Color.argb(r1, r3, r5, r6)
            r10.drawColor(r1)
            android.graphics.Paint r10 = r9.f5095h
            android.graphics.PorterDuffXfermode r1 = co.polarr.renderer.PolarrPainter.f5077K
            r10.setXfermode(r1)
            android.graphics.Canvas r10 = r9.f5098k
            android.graphics.Bitmap r1 = r9.f5092e
            android.graphics.Paint r3 = r9.f5095h
            r10.drawBitmap(r1, r2, r2, r3)
            android.graphics.Paint r10 = r9.f5095h
            r10.setXfermode(r0)
            android.graphics.Canvas r10 = r9.f5097j
            android.graphics.Bitmap r1 = r9.f5089b
            r10.drawBitmap(r1, r2, r2, r0)
            android.graphics.Canvas r10 = r9.f5098k
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.CLEAR
            r10.drawColor(r4, r0)
            android.graphics.Canvas r9 = r9.f5087J
            android.graphics.PorterDuff$Mode r10 = android.graphics.PorterDuff.Mode.CLEAR
            r9.drawColor(r4, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: co.polarr.renderer.PolarrPainter.m5392a(int):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m5393a(Bitmap bitmap, float COUIBaseListPopupWindow_12) {
        int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iArr.length; OplusGLSurfaceView_13++) {
            int i2 = iArr[OplusGLSurfaceView_13];
            if (Color.alpha(i2) != 0) {
                int iAlpha = (int) (Color.alpha(i2) * COUIBaseListPopupWindow_12);
                if (iAlpha > 0) {
                    iArr[OplusGLSurfaceView_13] = Color.argb(iAlpha, Color.red(i2), Color.green(i2), Color.blue(i2));
                } else {
                    iArr[OplusGLSurfaceView_13] = 0;
                }
            }
        }
        bitmap.setPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m5394a(PathMeasure pathMeasure, float COUIBaseListPopupWindow_12, float f2, boolean z) {
        float f3 = this.f5079B;
        while (true) {
            float f4 = this.f5079B;
            if (f4 >= COUIBaseListPopupWindow_12) {
                break;
            }
            pathMeasure.getPosTan(f4, this.f5102o, this.f5110w);
            float[] fArr = this.f5110w;
            double dAtan2 = Math.atan2(fArr[0], fArr[1]);
            if (this.f5079B == 0.0f) {
                this.f5106s = dAtan2;
            }
            double dMax = Math.max(this.f5106s - this.f5105r.maxRot, Math.min(this.f5106s + this.f5105r.maxRot, dAtan2));
            double dRandom = dMax;
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f5105r.maxFlow; OplusGLSurfaceView_13++) {
                if (this.f5105r.randomRange > 0.0f) {
                    dRandom = (Math.random() * 360.0d * this.f5105r.randomRange) + dMax;
                }
                this.f5103p.reset();
                this.f5103p.postTranslate((-this.f5080C) / 2.0f, ((-this.f5081D) / 2.0f) + 0.0f);
                this.f5103p.postRotate((float) dRandom, 0.0f, 0.0f);
                Matrix matrix = this.f5103p;
                float[] fArr2 = this.f5102o;
                matrix.postTranslate(fArr2[0], fArr2[1]);
                if (z) {
                    this.f5096i.setAlpha((int) (this.f5108u * this.f5105r.paintAlpha * 255.0f * ((COUIBaseListPopupWindow_12 - this.f5079B) / (COUIBaseListPopupWindow_12 - f3))));
                }
                this.f5099l.drawBitmap(this.f5094g, this.f5103p, this.f5096i);
            }
            this.f5079B += f2;
        }
        if (z) {
            this.f5096i = new Paint();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m5395a(porender_qbdmL porender_qbdml, float[] fArr, float[] fArr2) {
        int OplusGLSurfaceView_13 = porender_YuvEf.f5114a[porender_qbdml.ordinal()];
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 == 2) {
                float[] fArr3 = this.f5101n;
                fArr3[0] = fArr[0];
                fArr3[1] = fArr[1];
                this.f5079B = 0.0f;
                this.f5113z = new Path();
                this.f5078A = new PathMeasure();
                this.f5104q = porender_qbdml;
                this.f5113z.moveTo(fArr[0], fArr[1]);
                return;
            }
            porender_YuvEf porender_yuvef = null;
            if (OplusGLSurfaceView_13 != 3) {
                if (OplusGLSurfaceView_13 != 4) {
                    return;
                }
                float COUIBaseListPopupWindow_12 = fArr[0];
                float[] fArr4 = this.f5101n;
                this.f5113z.quadTo(fArr4[0], fArr4[1], (COUIBaseListPopupWindow_12 + fArr4[0]) / 2.0f, (fArr[1] + fArr4[1]) / 2.0f);
                float[] fArr5 = this.f5101n;
                fArr5[0] = fArr[0];
                fArr5[1] = fArr[1];
                this.f5078A.setPath(this.f5113z, false);
                float length = this.f5078A.getLength();
                boolean z = fArr2 != null && this.f5105r.canFade && C0125r.m592a(fArr2, this.f5101n) > this.f5082E * 20.0f;
                porender_iuAiH porender_iuaih = new porender_iuAiH(this, porender_yuvef);
                porender_iuaih.f5115a = this.f5079B;
                m5394a(this.f5078A, length, this.f5082E, z);
                m5398d();
                porender_iuaih.f5121g = this.f5113z;
                porender_iuaih.f5120f = this.f5105r;
                porender_iuaih.f5116b = this.f5107t;
                porender_iuaih.f5117c = this.f5109v;
                porender_iuaih.f5118d = this.f5108u;
                porender_iuaih.f5119e = z;
                this.f5112y++;
                this.f5111x.add(porender_iuaih);
                this.f5095h.setXfermode(null);
                this.f5098k.drawColor(Color.argb((int) (this.f5108u * 255.0f), Color.red(this.f5109v), Color.green(this.f5109v), Color.blue(this.f5109v)));
                this.f5095h.setXfermode(f5077K);
                this.f5098k.drawBitmap(this.f5092e, 0.0f, 0.0f, this.f5095h);
                this.f5095h.setXfermode(null);
                this.f5097j.drawBitmap(this.f5089b, 0.0f, 0.0f, (Paint) null);
                this.f5098k.drawColor(0, PorterDuff.Mode.CLEAR);
                this.f5099l.drawColor(0, PorterDuff.Mode.CLEAR);
                porender_qbdml = porender_qbdmL.IDLE;
            } else {
                if (C0125r.m592a(fArr, this.f5101n) <= 10.0f) {
                    return;
                }
                float f2 = fArr[0];
                float[] fArr6 = this.f5101n;
                this.f5113z.quadTo(fArr6[0], fArr6[1], (f2 + fArr6[0]) / 2.0f, (fArr[1] + fArr6[1]) / 2.0f);
                float[] fArr7 = this.f5101n;
                fArr7[0] = fArr[0];
                fArr7[1] = fArr[1];
                this.f5078A.setPath(this.f5113z, false);
                float length2 = this.f5078A.getLength();
                float f3 = this.f5079B;
                float f4 = this.f5082E;
                float f5 = 5.0f * f4;
                if (length2 > f3 + (2.0f * f5)) {
                    m5394a(this.f5078A, length2 - f5, f4, false);
                }
                this.f5100m.drawColor(0, PorterDuff.Mode.CLEAR);
                this.f5098k.drawColor(Color.argb((int) (this.f5108u * 255.0f), Color.red(this.f5109v), Color.green(this.f5109v), Color.blue(this.f5109v)));
                this.f5095h.setXfermode(f5077K);
                this.f5098k.drawBitmap(this.f5092e, 0.0f, 0.0f, this.f5095h);
                this.f5095h.setXfermode(null);
                this.f5100m.drawBitmap(this.f5089b, 0.0f, 0.0f, (Paint) null);
                this.f5098k.drawColor(0, PorterDuff.Mode.CLEAR);
            }
        }
        this.f5104q = porender_qbdml;
    }

    public void addPoint(float[] fArr) {
        m5395a(porender_qbdmL.MOVE, fArr, null);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final int m5396b() {
        for (int OplusGLSurfaceView_13 = this.f5112y - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
            if (this.f5111x.get(OplusGLSurfaceView_13).f5122h) {
                return OplusGLSurfaceView_13;
            }
        }
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final void m5397c() {
        m5391a();
        m5400f();
        for (int iM5396b = m5396b(); iM5396b < this.f5112y; iM5396b++) {
            m5392a(iM5396b);
        }
        m5399e();
    }

    public boolean canRedo() {
        return this.f5112y < this.f5111x.size();
    }

    public boolean canUndo() {
        return this.f5112y > 0;
    }

    public void clear() {
        m5391a();
        m5398d();
        int OplusGLSurfaceView_13 = this.f5112y;
        if (OplusGLSurfaceView_13 == 0 || this.f5111x.get(OplusGLSurfaceView_13 - 1).f5122h) {
            return;
        }
        porender_iuAiH porender_iuaih = new porender_iuAiH(this, null);
        porender_iuaih.f5122h = true;
        this.f5111x.add(porender_iuaih);
        this.f5112y++;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public final void m5398d() {
        while (this.f5111x.size() > this.f5112y) {
            this.f5111x.remove(r0.size() - 1);
        }
    }

    public void draw(Canvas canvas) {
        if (this.f5089b == null) {
            return;
        }
        canvas.drawBitmap(this.f5090c, 0.0f, 0.0f, (Paint) null);
        if (this.f5104q == porender_qbdmL.MOVE) {
            canvas.drawBitmap(this.f5091d, 0.0f, 0.0f, (Paint) null);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public final void m5399e() {
        updateBrushStyle(this.f5086I);
        updateBrushSize(this.f5083F, this.f5084G, this.f5085H);
        this.f5099l = this.f5087J;
        this.f5099l.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    public void endBrush(float[] fArr, float[] fArr2) {
        m5395a(porender_qbdmL.DONE, fArr, fArr2);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public final void m5400f() {
        this.f5083F = this.f5107t;
        this.f5084G = this.f5108u;
        this.f5085H = this.f5109v;
        this.f5086I = this.f5105r;
        this.f5087J = this.f5099l;
    }

    public Bitmap getLastPaintBitmap() {
        return this.f5090c;
    }

    public void redo() {
        if (canRedo()) {
            m5400f();
            m5392a(this.f5112y);
            m5399e();
            this.f5112y++;
        }
    }

    public void reset() {
        clear();
        this.f5111x.clear();
        this.f5112y = 0;
    }

    public void setLastPaintBitmap(Bitmap bitmap) {
        Canvas canvas = this.f5097j;
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f5097j.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    public void startBrush(float[] fArr) {
        m5395a(porender_qbdmL.START, fArr, null);
    }

    public void undo() {
        if (canUndo()) {
            this.f5112y--;
            m5397c();
        }
    }

    public void updateBrushSize(float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13) {
        Bitmap bitmapCreateScaledBitmap;
        this.f5107t = COUIBaseListPopupWindow_12;
        this.f5108u = f2;
        this.f5109v = OplusGLSurfaceView_13;
        if (COUIBaseListPopupWindow_12 == 0.0f) {
            COUIBaseListPopupWindow_12 = 1.0f;
        }
        if (COUIBaseListPopupWindow_12 == 1.0f) {
            bitmapCreateScaledBitmap = this.f5093f.copy(Bitmap.Config.ARGB_8888, true);
        } else if (this.f5093f.getWidth() != this.f5093f.getHeight()) {
            Bitmap bitmap = this.f5093f;
            Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), (int) (this.f5093f.getHeight() * COUIBaseListPopupWindow_12), false);
            bitmapCreateScaledBitmap = m5390a(bitmapCreateScaledBitmap2, new Rect(0, 0, (int) (this.f5093f.getWidth() * COUIBaseListPopupWindow_12), bitmapCreateScaledBitmap2.getHeight()));
        } else {
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(this.f5093f, (int) (r5.getWidth() * COUIBaseListPopupWindow_12), (int) (this.f5093f.getHeight() * COUIBaseListPopupWindow_12), false);
        }
        if (this.f5105r.paintAlpha < 1.0f) {
            m5393a(bitmapCreateScaledBitmap, this.f5105r.paintAlpha);
        }
        this.f5094g = bitmapCreateScaledBitmap;
        this.f5080C = this.f5094g.getWidth();
        this.f5081D = this.f5094g.getHeight();
        this.f5082E = this.f5094g.getWidth() * this.f5105r.spacing;
        this.f5082E = Math.max(this.f5082E, 0.1f);
    }

    public void updateBrushStyle(BrushStyle brushStyle) {
        this.f5105r = brushStyle;
        try {
            this.f5093f = BitmapFactory.decodeStream(this.f5088a.getAssets().open(this.f5105r.resName), null, new BitmapFactory.Options());
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        float COUIBaseListPopupWindow_12 = this.f5107t;
        if (COUIBaseListPopupWindow_12 != 0.0f) {
            updateBrushSize(COUIBaseListPopupWindow_12, this.f5108u, this.f5109v);
        }
    }

    public void updateSize(int OplusGLSurfaceView_13, int i2) {
        this.f5089b = Bitmap.createBitmap(OplusGLSurfaceView_13, i2, Bitmap.Config.ARGB_8888);
        this.f5092e = Bitmap.createBitmap(OplusGLSurfaceView_13, i2, Bitmap.Config.ARGB_8888);
        this.f5090c = Bitmap.createBitmap(OplusGLSurfaceView_13, i2, Bitmap.Config.ARGB_8888);
        this.f5091d = Bitmap.createBitmap(OplusGLSurfaceView_13, i2, Bitmap.Config.ARGB_8888);
        this.f5097j.setBitmap(this.f5090c);
        this.f5098k.setBitmap(this.f5089b);
        this.f5099l.setBitmap(this.f5092e);
        this.f5100m.setBitmap(this.f5091d);
    }
}
