package com.oplus.camera.p172ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Wheel.java */
/* renamed from: com.oplus.camera.ui.widget.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class Wheel extends View {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final int f22868b = Color.argb(46, 255, 255, 255);

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final int f22869c = Color.argb(255, 255, 255, 255);

    /* renamed from: PlatformImplementations.kt_3 */
    public final Rect f22870a;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final List<PlatformImplementations.kt_3> f22871d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f22872e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Drawable f22873f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f22874g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f22875h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f22876i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Drawable f22877j;

    /* renamed from: OplusGLSurfaceView_5 */
    private IntrinsicsJvm.kt_3 f22878k;

    /* renamed from: OplusGLSurfaceView_14 */
    private Bitmap f22879l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Bitmap f22880m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f22881n;

    /* renamed from: o */
    private final Rect f22882o;

    /* renamed from: p */
    private final Rect f22883p;

    /* renamed from: q */
    private Paint f22884q;

    /* renamed from: r */
    private boolean f22885r;

    /* renamed from: s */
    private int f22886s;

    /* renamed from: t */
    private int f22887t;

    /* renamed from: u */
    private float f22888u;

    /* renamed from: v */
    private final Rect f22889v;

    /* renamed from: w */
    private float f22890w;

    /* renamed from: x */
    private int f22891x;

    /* renamed from: y */
    private Drawable f22892y;

    /* renamed from: z */
    private float f22893z;

    /* compiled from: Wheel.java */
    /* renamed from: com.oplus.camera.ui.widget.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    public static abstract class PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        public void m24140a(Wheel c3523f) {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void mo24079a(Wheel c3523f, int OplusGLSurfaceView_13, boolean z) {
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo24080b(Wheel c3523f) {
        }
    }

    /* compiled from: Wheel.java */
    /* renamed from: com.oplus.camera.ui.widget.COUIBaseListPopupWindow_12$IntrinsicsJvm.kt_3 */
    public static class IntrinsicsJvm.kt_3 extends Drawable {

        /* renamed from: PlatformImplementations.kt_3 */
        protected int f22899a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        protected int f22900b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        protected int f22901c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        protected final float f22902d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        protected final int f22903e;

        /* renamed from: COUIBaseListPopupWindow_11 */
        protected int f22905g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        protected final int f22906h;

        /* renamed from: COUIBaseListPopupWindow_12 */
        protected final int f22904f = 0;

        /* renamed from: OplusGLSurfaceView_13 */
        protected final Paint f22907i = new Paint();

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        public IntrinsicsJvm.kt_3(Resources resources, int OplusGLSurfaceView_13) {
            this.f22903e = OplusGLSurfaceView_13;
            this.f22906h = Wheel.m24135a(resources, 12.0f);
            this.f22902d = Wheel.m24135a(resources, 7.0f);
            this.f22907i.setStyle(Paint.Style.STROKE);
            this.f22907i.setStrokeWidth(Wheel.m24135a(resources, 1.5f));
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            int OplusGLSurfaceView_13;
            Rect bounds = getBounds();
            if (this.f22903e == 0 && (OplusGLSurfaceView_13 = this.f22906h) > 0) {
                int iWidth = (int) (bounds.width() / this.f22902d);
                int i2 = ((bounds.top + bounds.bottom) / 2) - (this.f22906h / 2);
                int i3 = OplusGLSurfaceView_13 + i2;
                m24141a(bounds, bounds.left);
                float COUIBaseListPopupWindow_12 = i2;
                float f2 = i3;
                canvas.drawLine(bounds.left, COUIBaseListPopupWindow_12, bounds.left, f2, this.f22907i);
                for (int i4 = 1; i4 <= iWidth; i4++) {
                    int iRound = Math.round(bounds.left + (bounds.width() * (i4 / iWidth)));
                    m24141a(bounds, iRound);
                    float f3 = iRound;
                    canvas.drawLine(f3, COUIBaseListPopupWindow_12, f3, f2, this.f22907i);
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public int m24142a() {
            return this.f22899a;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int m24145b() {
            return this.f22900b;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int m24146c() {
            return this.f22901c;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m24141a(Rect rect, int OplusGLSurfaceView_13) {
            int iM24142a = m24142a();
            if (iM24142a < 0) {
                this.f22907i.setColor(Wheel.f22868b);
                return;
            }
            int iM24145b = m24145b();
            if (this.f22903e != 0) {
                return;
            }
            float fWidth = rect.left + ((rect.width() * iM24142a) / m24146c());
            float COUIBaseListPopupWindow_12 = iM24145b;
            if (Math.abs(COUIBaseListPopupWindow_12 - fWidth) <= 2.0f) {
                this.f22907i.setColor(Wheel.f22868b);
                return;
            }
            if (COUIBaseListPopupWindow_12 < fWidth) {
                if (OplusGLSurfaceView_13 < iM24145b || OplusGLSurfaceView_13 > fWidth) {
                    this.f22907i.setColor(Wheel.f22868b);
                    return;
                } else {
                    this.f22907i.setColor(Wheel.f22869c);
                    return;
                }
            }
            if (OplusGLSurfaceView_13 > iM24145b || OplusGLSurfaceView_13 < fWidth) {
                this.f22907i.setColor(Wheel.f22868b);
            } else {
                this.f22907i.setColor(Wheel.f22869c);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int OplusGLSurfaceView_13) {
            this.f22907i.setAlpha(OplusGLSurfaceView_13);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.f22907i.setColorFilter(colorFilter);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        final void m24143a(int OplusGLSurfaceView_13) {
            this.f22900b = OplusGLSurfaceView_13;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        final void m24144a(int OplusGLSurfaceView_13, int i2, int i3) {
            this.f22901c = OplusGLSurfaceView_13;
            this.f22899a = i2;
            this.f22905g = i3;
        }
    }

    /* compiled from: Wheel.java */
    /* renamed from: com.oplus.camera.ui.widget.COUIBaseListPopupWindow_12$IntrinsicsJvm.kt_4 */
    private static final class IntrinsicsJvm.kt_4 extends Drawable {

        /* renamed from: PlatformImplementations.kt_3 */
        private static float f22894a = 24.0f;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private static float f22895b = 2.5f;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final Paint f22896c = new Paint();

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final int f22897d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private final int f22898e;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        public IntrinsicsJvm.kt_4(Resources resources, int OplusGLSurfaceView_13) {
            this.f22896c.setStyle(Paint.Style.STROKE);
            this.f22896c.setAntiAlias(true);
            this.f22896c.setColor(Wheel.f22869c);
            this.f22896c.setStrokeWidth(Wheel.m24135a(resources, f22895b));
            this.f22897d = Wheel.m24135a(resources, f22894a);
            this.f22898e = OplusGLSurfaceView_13;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            if (this.f22898e != 0) {
                return;
            }
            float fRound = Math.round(bounds.left + (bounds.width() / 2));
            canvas.drawLine(fRound, bounds.top, fRound, bounds.bottom, this.f22896c);
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.f22897d;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.f22897d;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int OplusGLSurfaceView_13) {
            this.f22896c.setAlpha(OplusGLSurfaceView_13);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.f22896c.setColorFilter(colorFilter);
        }
    }

    public Wheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22871d = new ArrayList();
        this.f22872e = 50;
        this.f22881n = 0;
        this.f22882o = new Rect();
        this.f22883p = new Rect();
        this.f22886s = 100;
        this.f22887t = 0;
        this.f22889v = new Rect();
        this.f22870a = new Rect();
        this.f22893z = 1.2f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24139a(PlatformImplementations.kt_3 aVar) {
        this.f22871d.add(aVar);
    }

    public int getCenterValue() {
        return this.f22872e;
    }

    public int getFadingEdgeLength() {
        return this.f22881n;
    }

    public int getMaxValue() {
        return this.f22886s;
    }

    public int getValue() {
        return this.f22891x;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int iMax = Math.max(0, (getWidth() - paddingLeft) - 0);
        int iMax2 = Math.max(0, (getHeight() - paddingTop) - paddingBottom);
        int iSaveLayer = canvas.saveLayer(paddingLeft, paddingTop, paddingLeft + iMax, paddingTop + iMax2, null);
        try {
            Drawable drawable = this.f22892y;
            if (drawable == null) {
                if (this.f22878k == null) {
                    this.f22878k = new IntrinsicsJvm.kt_3(getResources(), this.f22887t);
                }
                drawable = this.f22878k;
            }
            if (drawable instanceof IntrinsicsJvm.kt_3) {
                if (this.f22887t == 0) {
                    ((IntrinsicsJvm.kt_3) drawable).m24143a(this.f22876i);
                }
                ((IntrinsicsJvm.kt_3) drawable).m24144a(this.f22886s, this.f22872e, this.f22891x);
            }
            drawable.setBounds(this.f22870a);
            drawable.draw(canvas);
            Drawable drawable2 = this.f22873f;
            if (drawable2 == null) {
                if (this.f22877j == null) {
                    this.f22877j = new IntrinsicsJvm.kt_4(getResources(), this.f22887t);
                    this.f22875h = this.f22877j.getIntrinsicWidth();
                    this.f22874g = this.f22877j.getIntrinsicHeight();
                }
                drawable2 = this.f22877j;
            }
            int OplusGLSurfaceView_13 = this.f22875h;
            int i2 = this.f22874g;
            if (this.f22887t == 1 || OplusGLSurfaceView_13 <= 0 || OplusGLSurfaceView_13 > iMax) {
                OplusGLSurfaceView_13 = iMax;
            }
            if (this.f22887t == 0 || i2 <= 0 || i2 > iMax2) {
                i2 = iMax2;
            }
            int i3 = paddingLeft + ((iMax - OplusGLSurfaceView_13) / 2);
            int i4 = paddingTop + ((iMax2 - i2) / 2);
            drawable2.setBounds(i3, i4, OplusGLSurfaceView_13 + i3, i2 + i4);
            drawable2.draw(canvas);
            if (this.f22881n > 0) {
                int width = getWidth();
                int height = getHeight();
                if (this.f22884q == null) {
                    this.f22884q = new Paint();
                    this.f22884q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                }
                if (this.f22887t == 0) {
                    if (this.f22880m == null || this.f22880m.getWidth() != this.f22881n || this.f22880m.getHeight() != 1) {
                        this.f22880m = Bitmap.createBitmap(this.f22881n, 1, Bitmap.Config.ARGB_8888);
                        this.f22879l = Bitmap.createBitmap(this.f22881n, 1, Bitmap.Config.ARGB_8888);
                        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0, -1});
                        gradientDrawable.setBounds(0, 0, this.f22880m.getWidth(), this.f22880m.getHeight());
                        gradientDrawable.draw(new Canvas(this.f22880m));
                        gradientDrawable.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
                        gradientDrawable.draw(new Canvas(this.f22879l));
                    }
                    this.f22883p.set(0, 0, this.f22880m.getWidth(), this.f22880m.getHeight());
                    this.f22882o.set(0, 0, this.f22881n, height);
                    canvas.drawBitmap(this.f22880m, this.f22883p, this.f22882o, this.f22884q);
                    this.f22882o.set(width - this.f22881n, 0, width, height);
                    canvas.drawBitmap(this.f22879l, this.f22883p, this.f22882o, this.f22884q);
                }
            }
        } finally {
            canvas.restoreToCount(iSaveLayer);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        m24138c();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            float r0 = r5.getX()
            float r1 = r5.getY()
            int r5 = r5.getAction()
            r2 = 1
            if (r5 == 0) goto L8b
            r1 = 0
            if (r5 == r2) goto L72
            r3 = 2
            if (r5 == r3) goto L1a
            r0 = 3
            if (r5 == r0) goto L72
            goto Laf
        L1a:
            int r5 = r4.f22887t
            if (r5 == 0) goto L1f
            goto L6e
        L1f:
            android.graphics.Rect r5 = r4.f22870a
            android.graphics.Rect r3 = r4.f22889v
            r5.set(r3)
            android.graphics.Rect r5 = r4.f22870a
            float r3 = r4.f22888u
            float r0 = r0 - r3
            int r0 = java.lang.Math.round(r0)
            r5.offset(r0, r1)
            android.graphics.Rect r5 = r4.f22870a
            int r5 = r5.left
            int r0 = r4.f22876i
            if (r5 <= r0) goto L43
            android.graphics.Rect r5 = r4.f22870a
            int r3 = r5.left
            int r0 = r0 - r3
            r5.offset(r0, r1)
            goto L53
        L43:
            android.graphics.Rect r5 = r4.f22870a
            int r5 = r5.right
            int r0 = r4.f22876i
            if (r5 >= r0) goto L53
            android.graphics.Rect r5 = r4.f22870a
            int r3 = r5.right
            int r0 = r0 - r3
            r5.offset(r0, r1)
        L53:
            int r5 = r4.f22876i
            android.graphics.Rect r0 = r4.f22870a
            int r0 = r0.left
            int r5 = r5 - r0
            float r5 = (float) r5
            android.graphics.Rect r0 = r4.f22870a
            int r0 = r0.width()
            float r0 = (float) r0
            float r5 = r5 / r0
            int r0 = r4.f22886s
            float r0 = (float) r0
            float r0 = r0 * r5
            int r5 = java.lang.Math.round(r0)
            r4.m24136a(r5, r1, r2)
        L6e:
            r4.invalidate()
            goto Laf
        L72:
            r4.f22885r = r1
            java.util.List<com.oplus.camera.ui.widget.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3> r5 = r4.f22871d
            int r5 = r5.size()
            int r5 = r5 - r2
        L7b:
            if (r5 < 0) goto Laf
            java.util.List<com.oplus.camera.ui.widget.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3> r0 = r4.f22871d
            java.lang.Object r0 = r0.get(r5)
            com.oplus.camera.ui.widget.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 r0 = (com.oplus.camera.p172ui.widget.Wheel.PlatformImplementations.kt_3) r0
            r0.mo24080b(r4)
            int r5 = r5 + (-1)
            goto L7b
        L8b:
            r4.f22888u = r0
            r4.f22890w = r1
            r4.f22885r = r2
            android.graphics.Rect r5 = r4.f22889v
            android.graphics.Rect r0 = r4.f22870a
            r5.set(r0)
            java.util.List<com.oplus.camera.ui.widget.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3> r5 = r4.f22871d
            int r5 = r5.size()
            int r5 = r5 - r2
        L9f:
            if (r5 < 0) goto Laf
            java.util.List<com.oplus.camera.ui.widget.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3> r0 = r4.f22871d
            java.lang.Object r0 = r0.get(r5)
            com.oplus.camera.ui.widget.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 r0 = (com.oplus.camera.p172ui.widget.Wheel.PlatformImplementations.kt_3) r0
            r0.m24140a(r4)
            int r5 = r5 + (-1)
            goto L9f
        Laf:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.widget.Wheel.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24136a(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        if (OplusGLSurfaceView_13 < 0) {
            OplusGLSurfaceView_13 = 0;
        } else {
            int i2 = this.f22886s;
            if (OplusGLSurfaceView_13 > i2) {
                OplusGLSurfaceView_13 = i2;
            }
        }
        if (this.f22891x == OplusGLSurfaceView_13) {
            return;
        }
        this.f22891x = OplusGLSurfaceView_13;
        if (z) {
            m24138c();
            invalidate();
        }
        for (int size = this.f22871d.size() - 1; size >= 0; size--) {
            this.f22871d.get(size).mo24079a(this, OplusGLSurfaceView_13, z2);
        }
    }

    public void setCenterValue(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            OplusGLSurfaceView_13 = -1;
        } else {
            int i2 = this.f22886s;
            if (OplusGLSurfaceView_13 > i2) {
                OplusGLSurfaceView_13 = i2;
            }
        }
        if (this.f22872e == OplusGLSurfaceView_13) {
            return;
        }
        this.f22872e = OplusGLSurfaceView_13;
        invalidate();
    }

    public void setCurrentValueIndicatorDrawable(Drawable drawable) {
        this.f22873f = drawable;
    }

    @Override // android.view.View
    public void setFadingEdgeLength(int OplusGLSurfaceView_13) {
        if (this.f22881n == OplusGLSurfaceView_13) {
            return;
        }
        this.f22881n = OplusGLSurfaceView_13;
        this.f22880m = null;
        this.f22879l = null;
        invalidate();
    }

    public void setMaxValue(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            OplusGLSurfaceView_13 = 0;
        }
        int i2 = this.f22886s;
        if (i2 == OplusGLSurfaceView_13) {
            return;
        }
        if (i2 > OplusGLSurfaceView_13) {
            this.f22872e = Math.min(this.f22872e, OplusGLSurfaceView_13);
            if (this.f22891x > OplusGLSurfaceView_13) {
                this.f22891x = OplusGLSurfaceView_13;
                m24136a(this.f22891x, false, false);
            }
        }
        this.f22886s = OplusGLSurfaceView_13;
        m24138c();
        invalidate();
    }

    public void setValue(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            OplusGLSurfaceView_13 = 0;
        } else {
            int i2 = this.f22886s;
            if (OplusGLSurfaceView_13 > i2) {
                OplusGLSurfaceView_13 = i2;
            }
        }
        m24136a(OplusGLSurfaceView_13, true, false);
    }

    public void setWheelDrawable(Drawable drawable) {
        this.f22892y = drawable;
    }

    public void setWheelLengthRatio(float COUIBaseListPopupWindow_12) {
        this.f22893z = COUIBaseListPopupWindow_12;
        m24138c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m24138c() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int iMax = Math.max(0, (getWidth() - paddingLeft) - paddingRight);
        int iMax2 = Math.max(0, (getHeight() - paddingTop) - paddingBottom);
        int OplusGLSurfaceView_13 = this.f22886s;
        if (OplusGLSurfaceView_13 <= 0) {
            Log.w("Wheel", "updateWheelBounds, Invalid max value");
            return;
        }
        float COUIBaseListPopupWindow_12 = this.f22891x / OplusGLSurfaceView_13;
        if (this.f22887t != 0) {
            return;
        }
        this.f22876i = paddingLeft + (iMax / 2);
        int iRound = Math.round(iMax * this.f22893z);
        Drawable drawable = this.f22892y;
        int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
        if (intrinsicHeight <= 0 || intrinsicHeight > iMax2) {
            intrinsicHeight = iMax2;
        }
        this.f22870a.set(0, 0, iRound, intrinsicHeight);
        this.f22870a.offsetTo(this.f22876i - Math.round(iRound * COUIBaseListPopupWindow_12), paddingTop + ((iMax2 - intrinsicHeight) / 2));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m24135a(Resources resources, float COUIBaseListPopupWindow_12) {
        return Math.round(COUIBaseListPopupWindow_12 * (resources.getDisplayMetrics().densityDpi / 160.0f));
    }
}
