package com.oplus.camera.p172ui.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import androidx.core.p027a.ContextCompat;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.menu.facebeauty.RotateAnimationView;

/* loaded from: classes2.dex */
public class SplitBackgroundView extends RotateAnimationView {

    /* renamed from: OplusGLSurfaceView_5 */
    private Paint f22691k;

    /* renamed from: OplusGLSurfaceView_14 */
    private Paint f22692l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Paint f22693m;

    /* renamed from: OplusGLSurfaceView_11 */
    private Paint f22694n;

    /* renamed from: o */
    private RectF f22695o;

    /* renamed from: p */
    private Rect f22696p;

    /* renamed from: q */
    private boolean f22697q;

    /* renamed from: r */
    private int[] f22698r;

    /* renamed from: s */
    private int f22699s;

    /* renamed from: t */
    private boolean f22700t;

    public SplitBackgroundView(Context context) {
        this(context, null);
    }

    public SplitBackgroundView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SplitBackgroundView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f22691k = null;
        this.f22692l = null;
        this.f22693m = null;
        this.f22694n = null;
        this.f22695o = null;
        this.f22696p = new Rect();
        this.f22697q = false;
        this.f22698r = new int[2];
        this.f22699s = 0;
        this.f22700t = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oplus.camera.ui.widget.SplitBackgroundView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SplitBackgroundView.this.f22695o = new RectF(r0.getPaddingLeft(), SplitBackgroundView.this.getPaddingTop(), SplitBackgroundView.this.getWidth() - SplitBackgroundView.this.getPaddingRight(), SplitBackgroundView.this.getHeight() - SplitBackgroundView.this.getPaddingBottom());
                SplitBackgroundView.this.postInvalidate();
            }
        });
        m24041b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m24041b() {
        this.f22691k = new Paint();
        this.f22691k.setAntiAlias(true);
        this.f22691k.setStyle(Paint.Style.FILL);
        this.f22691k.setStrokeWidth(5.0f);
        this.f22691k.setColor(ContextCompat.m2254c(getContext(), R.color.color_white_with_20_percent_transparency));
        this.f22691k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.f22692l = new Paint();
        this.f22692l.setAntiAlias(true);
        this.f22692l.setStyle(Paint.Style.FILL);
        this.f22692l.setStrokeWidth(5.0f);
        this.f22692l.setColor(ContextCompat.m2254c(getContext(), R.color.color_black_with_30_percent_transparency));
        this.f22692l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f7  */
    @Override // com.oplus.camera.p172ui.menu.facebeauty.RotateAnimationView, android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r19) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.widget.SplitBackgroundView.onDraw(android.graphics.Canvas):void");
    }

    public void setInterceptTouchEvent(boolean z) {
        this.f22700t = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24042a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        Rect rect = this.f22696p;
        rect.left = OplusGLSurfaceView_13;
        rect.top = i2;
        rect.right = OplusGLSurfaceView_13 + i3;
        rect.bottom = i2 + i4;
        postInvalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return isEnabled() ? super.onTouchEvent(motionEvent) : this.f22700t;
    }

    public void setSplitBackground(boolean z) {
        this.f22697q = z;
    }

    public void setOrientation(int OplusGLSurfaceView_13) {
        this.f22699s = OplusGLSurfaceView_13;
    }
}
