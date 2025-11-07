package com.oplus.camera.p172ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.dynamicanimation.p043a.DynamicAnimation;
import androidx.dynamicanimation.p043a.FloatValueHolder;
import androidx.dynamicanimation.p043a.SpringAnimation;
import androidx.dynamicanimation.p043a.SpringForce;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SlowVideoModeSeekBar.java */
/* renamed from: com.oplus.camera.ui.widget.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class SlowVideoModeSeekBar extends View implements DynamicAnimation.IntrinsicsJvm.kt_3 {

    /* renamed from: A */
    private PointF f22762A;

    /* renamed from: B */
    private IntrinsicsJvm.kt_4 f22763B;

    /* renamed from: C */
    private SpringAnimation f22764C;

    /* renamed from: PlatformImplementations.kt_3 */
    private int f22765a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f22766b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f22767c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f22768d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f22769e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f22770f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f22771g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f22772h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f22773i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f22774j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f22775k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f22776l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f22777m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f22778n;

    /* renamed from: o */
    private int f22779o;

    /* renamed from: p */
    private int f22780p;

    /* renamed from: q */
    private int f22781q;

    /* renamed from: r */
    private int f22782r;

    /* renamed from: s */
    private int f22783s;

    /* renamed from: t */
    private long f22784t;

    /* renamed from: u */
    private long f22785u;

    /* renamed from: v */
    private boolean f22786v;

    /* renamed from: w */
    private boolean f22787w;

    /* renamed from: x */
    private Paint f22788x;

    /* renamed from: y */
    private List<PlatformImplementations.kt_3> f22789y;

    /* renamed from: z */
    private List<PointF> f22790z;

    /* compiled from: SlowVideoModeSeekBar.java */
    /* renamed from: com.oplus.camera.ui.widget.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        void onSlowVideoFrameChange(int OplusGLSurfaceView_13);
    }

    public SlowVideoModeSeekBar(Context context) {
        super(context);
        this.f22765a = 0;
        this.f22766b = 0;
        this.f22767c = 0;
        this.f22768d = 0;
        this.f22769e = 0;
        this.f22770f = 0;
        this.f22771g = 0;
        this.f22772h = 0;
        this.f22773i = 0;
        this.f22774j = 0;
        this.f22775k = 0;
        this.f22776l = 0;
        this.f22777m = 0;
        this.f22778n = 0;
        this.f22779o = 0;
        this.f22780p = -1;
        this.f22781q = 0;
        this.f22782r = 0;
        this.f22783s = 0;
        this.f22784t = 0L;
        this.f22785u = 0L;
        this.f22786v = false;
        this.f22787w = false;
        this.f22788x = null;
        this.f22789y = new ArrayList();
        this.f22790z = new ArrayList();
        this.f22762A = new PointF();
        this.f22763B = null;
        this.f22764C = null;
        m24091a(context, (AttributeSet) null, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24091a(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        m24093b(context, attributeSet, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m24093b(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlowVideoModeSeekBar, OplusGLSurfaceView_13, 0);
        Resources resources = context.getResources();
        try {
            try {
                this.f22765a = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, resources.getDimensionPixelSize(R.dimen.slow_video_seekbar_line_width));
                this.f22766b = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, resources.getDimensionPixelSize(R.dimen.slow_video_seekbar_line_height));
                this.f22767c = typedArrayObtainStyledAttributes.getColor(11, context.getColor(R.color.slow_video_seekbar_line_color));
                this.f22768d = typedArrayObtainStyledAttributes.getInt(10, 76);
                this.f22769e = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, resources.getDimensionPixelSize(R.dimen.slow_video_seekbar_node_unselected_size));
                this.f22770f = typedArrayObtainStyledAttributes.getColor(6, context.getColor(R.color.slow_video_seekbar_node_unselected_color));
                this.f22771g = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, resources.getDimensionPixelSize(R.dimen.slow_video_seekbar_node_selected_outer_size));
                this.f22772h = typedArrayObtainStyledAttributes.getColor(2, Util.m24164A(context));
                this.f22773i = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, resources.getDimensionPixelSize(R.dimen.slow_video_seekbar_node_selected_inner_size));
                this.f22774j = typedArrayObtainStyledAttributes.getColor(0, context.getColor(R.color.slow_video_seekbar_node_selected_inner_color));
                this.f22775k = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, resources.getDimensionPixelSize(R.dimen.slow_video_seekbar_node_unselected_text_size));
                this.f22776l = typedArrayObtainStyledAttributes.getColor(8, context.getColor(R.color.slow_video_seekbar_node_unselected_text_color));
                this.f22777m = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, resources.getDimensionPixelSize(R.dimen.slow_video_seekbar_node_selected_text_size));
                this.f22778n = typedArrayObtainStyledAttributes.getColor(4, Util.m24164A(context));
            } catch (Resources.NotFoundException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            typedArrayObtainStyledAttributes.recycle();
            this.f22788x = new Paint();
            this.f22788x.setAntiAlias(true);
            this.f22788x.setStyle(Paint.Style.FILL);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        this.f22762A.x = getLineStartX() + (this.f22780p * (this.f22765a / (this.f22789y.size() - 1)));
        this.f22762A.y = getLineStartY();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m24089a();
        m24096c(canvas);
        m24094b(canvas);
        m24092a(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24092a(Canvas canvas) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f22789y.size(); OplusGLSurfaceView_13++) {
            if (m24095b(OplusGLSurfaceView_13)) {
                this.f22788x.setColor(this.f22778n);
                this.f22788x.setTextSize(this.f22777m);
            } else {
                this.f22788x.setColor(this.f22776l);
                this.f22788x.setTextSize(this.f22775k);
            }
            String strM24100b = this.f22789y.get(OplusGLSurfaceView_13).m24100b();
            float fMeasureText = this.f22788x.measureText(strM24100b);
            Paint.FontMetrics fontMetrics = this.f22788x.getFontMetrics();
            PointF pointF = this.f22790z.get(OplusGLSurfaceView_13);
            float COUIBaseListPopupWindow_12 = pointF.x - (fMeasureText / 2.0f);
            float dimension = pointF.y + getContext().getResources().getDimension(R.dimen.slow_video_seekbar_node_text_margin_top) + (this.f22766b >> 1);
            float f2 = dimension - fontMetrics.top;
            float f3 = pointF.x;
            float f4 = dimension + ((fontMetrics.bottom - fontMetrics.top) / 2.0f);
            canvas.save();
            canvas.rotate(-this.f22782r, f3, f4);
            canvas.drawText(strM24100b, COUIBaseListPopupWindow_12, f2, this.f22788x);
            canvas.restore();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m24095b(int OplusGLSurfaceView_13) {
        return this.f22780p == OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m24094b(Canvas canvas) {
        this.f22788x.setStyle(Paint.Style.FILL);
        this.f22788x.setAlpha(255);
        this.f22788x.setColor(this.f22770f);
        float lineStartX = getLineStartX();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f22789y.size(); OplusGLSurfaceView_13++) {
            float size = (OplusGLSurfaceView_13 * (this.f22765a / (this.f22789y.size() - 1))) + lineStartX;
            float lineStartY = getLineStartY();
            canvas.drawCircle(size, lineStartY, this.f22769e >> 1, this.f22788x);
            if (this.f22790z.size() != this.f22789y.size()) {
                this.f22790z.add(new PointF(size, lineStartY));
            }
        }
        float COUIBaseListPopupWindow_12 = this.f22762A.x;
        float f2 = this.f22762A.y;
        if (this.f22787w) {
            this.f22788x.setColor(this.f22770f);
            canvas.drawCircle(COUIBaseListPopupWindow_12, f2, this.f22769e >> 1, this.f22788x);
        } else {
            this.f22788x.setColor(this.f22772h);
            canvas.drawCircle(COUIBaseListPopupWindow_12, f2, this.f22771g >> 1, this.f22788x);
            this.f22788x.setColor(this.f22774j);
            canvas.drawCircle(COUIBaseListPopupWindow_12, f2, this.f22773i >> 1, this.f22788x);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m24096c(Canvas canvas) {
        this.f22788x.setStyle(Paint.Style.STROKE);
        this.f22788x.setStrokeWidth(this.f22766b);
        this.f22788x.setColor(this.f22767c);
        this.f22788x.setAlpha(this.f22768d);
        float lineStartX = getLineStartX();
        float lineStartY = getLineStartY();
        canvas.drawLine(lineStartX, lineStartY, lineStartX + this.f22765a, lineStartY, this.f22788x);
    }

    private float getLineStartY() {
        return getMeasuredHeight() * 0.26667f;
    }

    private int getLineStartX() {
        return (getMeasuredWidth() - this.f22765a) >> 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    @Override // android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.widget.SlowVideoModeSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24090a(float COUIBaseListPopupWindow_12, float f2) {
        SpringAnimation c0552f = this.f22764C;
        if (c0552f != null) {
            c0552f.m3219b(this);
            this.f22764C.mo3218b();
        }
        this.f22764C = new SpringAnimation(new FloatValueHolder(COUIBaseListPopupWindow_12));
        SpringForce c0553g = new SpringForce(f2);
        c0553g.m3236a(1500.0f);
        c0553g.m3239b(0.5f);
        this.f22764C.m3230a(c0553g);
        PointF pointF = this.f22790z.get(0);
        PointF pointF2 = this.f22790z.get(r4.size() - 1);
        this.f22764C.mo3197e(pointF.x - this.f22769e);
        this.f22764C.mo3198f(pointF2.x + this.f22769e);
        this.f22764C.m3217a(this);
        this.f22764C.mo3191a();
    }

    @Override // androidx.dynamicanimation.p043a.DynamicAnimation.IntrinsicsJvm.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3226a(DynamicAnimation abstractC0549c, float COUIBaseListPopupWindow_12, float f2) {
        this.f22762A.x = COUIBaseListPopupWindow_12;
        postInvalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24089a() {
        int OplusGLSurfaceView_13;
        if (this.f22782r != this.f22783s) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.f22785u) {
                int i2 = (int) (jCurrentAnimationTimeMillis - this.f22784t);
                int i3 = this.f22781q;
                if (!this.f22786v) {
                    i2 = -i2;
                }
                int i4 = i3 + ((i2 * 360) / 1000);
                if (i4 > 0) {
                    OplusGLSurfaceView_13 = i4 % 360;
                } else {
                    OplusGLSurfaceView_13 = (i4 % 360) + 360;
                }
                this.f22782r = OplusGLSurfaceView_13;
                invalidate();
                return;
            }
            this.f22782r = this.f22783s;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24098a(int OplusGLSurfaceView_13, boolean z) {
        int i2 = OplusGLSurfaceView_13 > 0 ? OplusGLSurfaceView_13 % 360 : (OplusGLSurfaceView_13 % 360) + 360;
        if (i2 == this.f22783s) {
            return;
        }
        this.f22783s = i2;
        if (z) {
            this.f22781q = this.f22782r;
            this.f22784t = AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f22783s - this.f22782r;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.f22786v = i3 >= 0;
            this.f22785u = this.f22784t + ((Math.abs(i3) * 1000) / 360);
        } else {
            this.f22782r = this.f22781q;
        }
        invalidate();
    }

    public void setFrameList(List<PlatformImplementations.kt_3> list) {
        if (list != null && !list.isEmpty()) {
            this.f22790z.clear();
            this.f22789y.clear();
            this.f22789y.addAll(list);
        }
        CameraLog.m12959b("SlowVideoModeSeekBar", "setFrameList: " + list);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24097a(int OplusGLSurfaceView_13) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.f22789y.size()) {
                break;
            }
            if (this.f22789y.get(i2).m24099a() == OplusGLSurfaceView_13) {
                this.f22780p = i2;
                this.f22779o = this.f22789y.get(this.f22780p).m24099a();
                break;
            }
            i2++;
        }
        int i3 = this.f22780p;
        if (i3 < 0 || i3 >= this.f22789y.size()) {
            this.f22780p = this.f22789y.size() - 1;
            this.f22779o = this.f22789y.get(this.f22780p).m24099a();
            CameraLog.m12966e("SlowVideoModeSeekBar", "updateSelectedFrame, default index not found, use last index");
        }
        CameraLog.m12959b("SlowVideoModeSeekBar", "updateSelectedFrame, frame: " + OplusGLSurfaceView_13 + ", mSelectedIndex: " + this.f22780p);
    }

    public void setModeFrameChangeListener(IntrinsicsJvm.kt_4 bVar) {
        this.f22763B = bVar;
    }

    /* compiled from: SlowVideoModeSeekBar.java */
    /* renamed from: com.oplus.camera.ui.widget.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private int f22791a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private String f22792b;

        public PlatformImplementations.kt_3(int OplusGLSurfaceView_13, String str) {
            this.f22791a = 0;
            this.f22792b = "";
            this.f22791a = OplusGLSurfaceView_13;
            this.f22792b = str;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public int m24099a() {
            return this.f22791a;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public String m24100b() {
            return this.f22792b;
        }
    }
}
