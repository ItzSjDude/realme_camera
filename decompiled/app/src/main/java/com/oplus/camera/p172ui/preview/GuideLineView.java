package com.oplus.camera.p172ui.preview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GuideLineView.java */
/* renamed from: com.oplus.camera.ui.preview.r */
/* loaded from: classes2.dex */
public class GuideLineView extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    private Paint f22349a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Paint f22350b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f22351c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f22352d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private List<IntrinsicsJvm.kt_4> f22353e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private PointF f22354f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private IntrinsicsJvm.kt_3 f22355g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private PlatformImplementations.kt_3 f22356h;

    /* renamed from: OplusGLSurfaceView_13 */
    private PlatformImplementations.kt_3 f22357i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f22358j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Canvas f22359k;

    /* renamed from: OplusGLSurfaceView_14 */
    private Bitmap f22360l;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f22361m;

    public GuideLineView(Context context) {
        super(context);
        this.f22349a = null;
        this.f22350b = null;
        this.f22351c = false;
        this.f22352d = "grid";
        this.f22353e = null;
        this.f22354f = new PointF();
        this.f22355g = new IntrinsicsJvm.kt_3();
        this.f22356h = null;
        this.f22357i = null;
        this.f22358j = 0;
        this.f22359k = null;
        this.f22360l = null;
        this.f22361m = 0.0f;
        m23813a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23813a(Context context) {
        this.f22361m = context.getResources().getDimension(R.dimen.guideline_stroke_width);
        this.f22349a = new Paint();
        this.f22349a.setStyle(Paint.Style.STROKE);
        this.f22349a.setColor(Color.parseColor("#A6ffffff"));
        this.f22349a.setStrokeWidth(this.f22361m);
        this.f22349a.setAntiAlias(true);
        this.f22350b = new Paint();
        this.f22356h = new PlatformImplementations.kt_3();
        this.f22356h.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.ui.preview.r.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                GuideLineView.this.setVisibility(0);
            }
        });
        this.f22357i = new PlatformImplementations.kt_3();
        this.f22357i.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.ui.preview.r.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                GuideLineView.this.setVisibility(8);
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            CameraLog.m12967f("GuideLineView", "onDraw, width or height <= 0");
            return;
        }
        if (this.f22351c) {
            m23811a(width, height);
            int iM23809a = m23809a();
            String str = this.f22352d;
            char c2 = 65535;
            int iHashCode = str.hashCode();
            if (iHashCode != -895939855) {
                if (iHashCode != 3181382) {
                    if (iHashCode == 1497762312 && str.equals("triangle")) {
                        c2 = 1;
                    }
                } else if (str.equals("grid")) {
                    c2 = 0;
                }
            } else if (str.equals("spiral")) {
                c2 = 2;
            }
            if (c2 == 0) {
                m23815c(0, 0, width, height);
            } else if (c2 == 1) {
                m23814b(0, 0, width, height);
            } else if (c2 == 2) {
                float COUIBaseListPopupWindow_12 = 0;
                float f2 = this.f22361m;
                int OplusGLSurfaceView_13 = (int) (COUIBaseListPopupWindow_12 + f2);
                int i2 = (int) (COUIBaseListPopupWindow_12 + f2);
                int iM24426d = Util.m24426d(height, width);
                if (1 == iM24426d || 5 == iM24426d) {
                    float f3 = this.f22361m;
                    width = (int) (width - (f3 * 2.0f));
                    height = (int) (height - (f3 * 2.0f));
                }
                m23812a(OplusGLSurfaceView_13, i2, width, height);
            }
            for (int i3 = 0; i3 < iM23809a; i3++) {
                IntrinsicsJvm.kt_4 bVar = this.f22353e.get(i3);
                if (bVar.f22368b == 0) {
                    this.f22359k.drawLine(bVar.f22369c.x, bVar.f22369c.y, bVar.f22370d.x, bVar.f22370d.y, this.f22349a);
                } else if (1 == bVar.f22368b) {
                    this.f22359k.drawArc(bVar.f22373g, bVar.f22371e, bVar.f22372f, bVar.f22374h, this.f22349a);
                }
            }
            this.f22350b.setAlpha(this.f22358j);
            canvas.drawBitmap(this.f22360l, 0.0f, 0.0f, this.f22350b);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23811a(int OplusGLSurfaceView_13, int i2) {
        Canvas canvas = this.f22359k;
        if (canvas == null || OplusGLSurfaceView_13 != canvas.getWidth() || i2 != this.f22359k.getHeight()) {
            this.f22359k = new Canvas();
        }
        Bitmap bitmap = this.f22360l;
        if (bitmap != null) {
            if (OplusGLSurfaceView_13 != bitmap.getWidth() || i2 != this.f22360l.getHeight()) {
                this.f22360l.recycle();
                this.f22360l = Bitmap.createBitmap(OplusGLSurfaceView_13, i2, Bitmap.Config.ARGB_8888);
            }
        } else {
            this.f22360l = Bitmap.createBitmap(OplusGLSurfaceView_13, i2, Bitmap.Config.ARGB_8888);
        }
        this.f22359k.setBitmap(this.f22360l);
        this.f22359k.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.f22360l;
        if (bitmap != null) {
            bitmap.recycle();
            this.f22360l = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23812a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        float COUIBaseListPopupWindow_12 = i3;
        float f2 = i4;
        if ((1.0f * COUIBaseListPopupWindow_12) / f2 >= this.f22355g.f22381g) {
            this.f22355g.f22383i = f2;
            IntrinsicsJvm.kt_3 cVar = this.f22355g;
            cVar.f22382h = cVar.f22383i * this.f22355g.f22381g;
            IntrinsicsJvm.kt_3 cVar2 = this.f22355g;
            cVar2.f22384j = (COUIBaseListPopupWindow_12 - cVar2.f22382h) * 0.5f;
            this.f22355g.f22385k = 0.0f;
        } else {
            this.f22355g.f22382h = COUIBaseListPopupWindow_12;
            IntrinsicsJvm.kt_3 cVar3 = this.f22355g;
            cVar3.f22383i = cVar3.f22382h / this.f22355g.f22381g;
            this.f22355g.f22384j = 0.0f;
            IntrinsicsJvm.kt_3 cVar4 = this.f22355g;
            cVar4.f22385k = (f2 - cVar4.f22383i) * 0.5f;
        }
        int i5 = 0;
        this.f22353e.get(0).m23827a(OplusGLSurfaceView_13 + this.f22355g.f22384j, (i2 + i4) - this.f22355g.f22385k, this.f22355g.m23838a(0), this.f22355g.m23839b(0), 0, 90);
        int i6 = 1;
        while (i6 < 9) {
            int i7 = i5 + 1;
            IntrinsicsJvm.kt_4 bVar = this.f22353e.get(i5);
            this.f22353e.get(i7).m23827a(bVar.f22369c.x, bVar.f22369c.y, this.f22355g.m23838a(i7), this.f22355g.m23839b(i7), bVar.f22371e - 90, 90);
            i6++;
            i5 = i7;
        }
        IntrinsicsJvm.kt_4 bVar2 = this.f22353e.get(4);
        this.f22353e.get(i5 + 1).m23826a(bVar2.f22370d.x, bVar2.f22370d.y, bVar2.f22369c.x, bVar2.f22370d.y);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m23814b(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13 + i3;
        float f2 = i2;
        float f3 = OplusGLSurfaceView_13;
        this.f22353e.get(0).m23826a(COUIBaseListPopupWindow_12, f2, f3, i2 + i4);
        float f4 = i3;
        float f5 = i4;
        this.f22354f.set((f4 * 0.33333334f) + f3, (f5 * 0.6666667f) + f2);
        this.f22353e.get(1).m23826a(f3, (float) ((Math.pow(f3 - this.f22354f.x, 2.0d) / (this.f22354f.y - r2)) + this.f22354f.y), this.f22354f.x, this.f22354f.y);
        this.f22354f.set(f3 + (f4 * 0.6666667f), (f5 * 0.33333334f) + f2);
        this.f22353e.get(2).m23826a(COUIBaseListPopupWindow_12, (float) ((Math.pow(COUIBaseListPopupWindow_12 - this.f22354f.x, 2.0d) / (this.f22354f.y - f2)) + this.f22354f.y), this.f22354f.x, this.f22354f.y);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m23815c(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
        float f2 = i2;
        float f3 = i4;
        float f4 = (f3 * 0.33333334f) + f2;
        float f5 = OplusGLSurfaceView_13 + i3;
        this.f22353e.get(0).m23826a(COUIBaseListPopupWindow_12, f4, f5, f4);
        float f6 = (f3 * 0.6666667f) + f2;
        this.f22353e.get(1).m23826a(COUIBaseListPopupWindow_12, f6, f5, f6);
        float f7 = i3;
        float f8 = (0.33333334f * f7) + COUIBaseListPopupWindow_12;
        float f9 = i2 + i4;
        this.f22353e.get(2).m23826a(f8, f2, f8, f9);
        float f10 = COUIBaseListPopupWindow_12 + (f7 * 0.6666667f);
        this.f22353e.get(3).m23826a(f10, f2, f10, f9);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23816a(String str) {
        if (str == null || "off".equals(str)) {
            m23817a(false);
            return;
        }
        this.f22352d = str;
        if (this.f22351c) {
            return;
        }
        this.f22351c = true;
        setVisibility(0);
        if (this.f22356h != null) {
            clearAnimation();
            setAnimation(this.f22356h);
            this.f22356h.m23818a(0.0f, 127.5f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m23809a() {
        if (this.f22353e == null) {
            this.f22353e = new ArrayList();
        }
        String str = this.f22352d;
        char c2 = 65535;
        int iHashCode = str.hashCode();
        int OplusGLSurfaceView_13 = 0;
        if (iHashCode != -895939855) {
            if (iHashCode != 3181382) {
                if (iHashCode == 1497762312 && str.equals("triangle")) {
                    c2 = 1;
                }
            } else if (str.equals("grid")) {
                c2 = 0;
            }
        } else if (str.equals("spiral")) {
            c2 = 2;
        }
        if (c2 == 0) {
            OplusGLSurfaceView_13 = 4;
        } else if (c2 == 1) {
            OplusGLSurfaceView_13 = 3;
        } else if (c2 == 2) {
            OplusGLSurfaceView_13 = 10;
        }
        while (this.f22353e.size() < OplusGLSurfaceView_13) {
            this.f22353e.add(new IntrinsicsJvm.kt_4(new PointF(0.0f, 0.0f), new PointF(0.0f, 0.0f)));
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23817a(boolean z) {
        if (this.f22351c) {
            this.f22351c = false;
            clearAnimation();
            if (z) {
                setAnimation(this.f22357i);
                this.f22357i.m23818a(127.5f, 0.0f);
            } else {
                setVisibility(8);
            }
        }
    }

    /* compiled from: GuideLineView.java */
    /* renamed from: com.oplus.camera.ui.preview.r$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends Animation {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private float f22365b = 0.0f;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private float f22366c = 0.0f;

        public PlatformImplementations.kt_3() {
            setDuration(310L);
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float COUIBaseListPopupWindow_12, Transformation transformation) {
            float f2 = this.f22366c;
            float f3 = this.f22365b;
            GuideLineView.this.f22358j = (int) (((f2 - f3) * COUIBaseListPopupWindow_12) + f3);
            GuideLineView.this.invalidate();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m23818a(float COUIBaseListPopupWindow_12, float f2) {
            this.f22365b = COUIBaseListPopupWindow_12;
            this.f22366c = f2;
            start();
        }
    }

    /* compiled from: GuideLineView.java */
    /* renamed from: com.oplus.camera.ui.preview.r$IntrinsicsJvm.kt_3 */
    public static class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final int[] f22375a = {0, 1, 3, 5, 7};

        /* renamed from: IntrinsicsJvm.kt_4 */
        private static final int[] f22376b = {1, 2, 4, 6, 8};

        /* renamed from: IntrinsicsJvm.kt_3 */
        private static final int[] f22377c = {4, 5, 6, 7};

        /* renamed from: IntrinsicsJvm.kt_5 */
        private float[] f22378d = new float[9];

        /* renamed from: COUIBaseListPopupWindow_8 */
        private float f22379e = 0.0f;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private float f22380f = 0.0f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private float f22381g = 0.0f;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private float f22382h = 0.0f;

        /* renamed from: OplusGLSurfaceView_13 */
        private float f22383i = 0.0f;

        /* renamed from: OplusGLSurfaceView_15 */
        private float f22384j = 0.0f;

        /* renamed from: OplusGLSurfaceView_5 */
        private float f22385k = 0.0f;

        public IntrinsicsJvm.kt_3() {
            m23830a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m23830a() {
            float[] fArr = this.f22378d;
            fArr[0] = 1.0f;
            fArr[1] = 1.0f;
            int OplusGLSurfaceView_13 = 2;
            while (true) {
                float[] fArr2 = this.f22378d;
                if (OplusGLSurfaceView_13 >= fArr2.length) {
                    break;
                }
                fArr2[OplusGLSurfaceView_13] = fArr2[OplusGLSurfaceView_13 - 1] + fArr2[OplusGLSurfaceView_13 - 2];
                OplusGLSurfaceView_13++;
            }
            for (int i2 : f22375a) {
                this.f22379e += this.f22378d[i2];
            }
            for (int i3 : f22376b) {
                this.f22380f += this.f22378d[i3];
            }
            this.f22381g = this.f22379e / this.f22380f;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public float m23838a(int OplusGLSurfaceView_13) {
            return (this.f22378d[(r0.length - 1) - OplusGLSurfaceView_13] * this.f22382h) / this.f22379e;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean m23839b(int OplusGLSurfaceView_13) {
            for (int i2 : f22377c) {
                if (i2 == (this.f22378d.length - 1) - OplusGLSurfaceView_13) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: GuideLineView.java */
    /* renamed from: com.oplus.camera.ui.preview.r$IntrinsicsJvm.kt_4 */
    public class IntrinsicsJvm.kt_4 {

        /* renamed from: IntrinsicsJvm.kt_3 */
        private PointF f22369c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private PointF f22370d;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f22368b = 0;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f22371e = 0;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private int f22372f = 0;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private RectF f22373g = null;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private boolean f22374h = false;

        public IntrinsicsJvm.kt_4(PointF pointF, PointF pointF2) {
            this.f22369c = null;
            this.f22370d = null;
            this.f22369c = pointF;
            this.f22370d = pointF2;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m23826a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
            this.f22369c.set(COUIBaseListPopupWindow_12, f2);
            this.f22370d.set(f3, f4);
            this.f22368b = 0;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m23827a(float COUIBaseListPopupWindow_12, float f2, float f3, boolean z, int OplusGLSurfaceView_13, int i2) {
            this.f22370d.set(COUIBaseListPopupWindow_12, f2);
            this.f22371e = OplusGLSurfaceView_13;
            this.f22372f = i2;
            this.f22374h = z;
            this.f22368b = 1;
            if (this.f22373g == null) {
                this.f22373g = new RectF();
            }
            int i3 = OplusGLSurfaceView_13 % 360;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 == 0) {
                float f4 = COUIBaseListPopupWindow_12 + f3;
                this.f22369c.set(f4, f2 - f3);
                this.f22373g.set(COUIBaseListPopupWindow_12 - f3, f2 - (f3 * 2.0f), f4, f2);
                return;
            }
            if (i3 == 90) {
                float f5 = f2 + f3;
                this.f22369c.set(COUIBaseListPopupWindow_12 + f3, f5);
                this.f22373g.set(COUIBaseListPopupWindow_12, f2 - f3, (f3 * 2.0f) + COUIBaseListPopupWindow_12, f5);
            } else if (i3 == 180) {
                float f6 = COUIBaseListPopupWindow_12 - f3;
                this.f22369c.set(f6, f2 + f3);
                this.f22373g.set(f6, f2, COUIBaseListPopupWindow_12 + f3, (f3 * 2.0f) + f2);
            } else {
                if (i3 != 270) {
                    return;
                }
                float f7 = f2 - f3;
                this.f22369c.set(COUIBaseListPopupWindow_12 - f3, f7);
                this.f22373g.set(COUIBaseListPopupWindow_12 - (2.0f * f3), f7, COUIBaseListPopupWindow_12, f2 + f3);
            }
        }
    }
}
