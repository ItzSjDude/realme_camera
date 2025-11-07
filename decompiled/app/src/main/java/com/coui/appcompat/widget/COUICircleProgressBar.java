package com.coui.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
public class COUICircleProgressBar extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f7169a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f7170b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f7171c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f7172d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f7173e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f7174f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f7175g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f7176h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f7177i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f7178j;

    /* renamed from: OplusGLSurfaceView_5 */
    private RunnableC1361a f7179k;

    /* renamed from: OplusGLSurfaceView_14 */
    private AccessibilityManager f7180l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Paint f7181m;

    /* renamed from: OplusGLSurfaceView_11 */
    private Paint f7182n;

    /* renamed from: o */
    private int f7183o;

    /* renamed from: p */
    private int f7184p;

    /* renamed from: q */
    private RectF f7185q;

    /* renamed from: r */
    private float f7186r;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7031b() {
        this.f7181m = new Paint(1);
        this.f7181m.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f7181m.setColor(this.f7169a);
        this.f7181m.setStyle(Paint.Style.STROKE);
        this.f7181m.setStrokeWidth(this.f7174f);
        this.f7181m.setStrokeCap(Paint.Cap.ROUND);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7032c() {
        this.f7182n = new Paint(1);
        this.f7182n.setColor(this.f7170b);
        this.f7182n.setStyle(Paint.Style.STROKE);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7033d() {
        int OplusGLSurfaceView_13 = this.f7175g;
        if (OplusGLSurfaceView_13 > 0) {
            this.f7177i = (int) (this.f7176h / (OplusGLSurfaceView_13 / 360.0f));
            if (360 - this.f7177i < 2) {
                this.f7177i = 360;
            }
            this.f7178j = this.f7177i;
        } else {
            this.f7177i = 0;
            this.f7178j = 0;
        }
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        m7030a(canvas);
        canvas.save();
        int OplusGLSurfaceView_13 = this.f7184p;
        canvas.rotate(-90.0f, OplusGLSurfaceView_13, OplusGLSurfaceView_13);
        canvas.drawArc(this.f7185q, 0.0f, this.f7177i, false, this.f7181m);
        canvas.restore();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7030a(Canvas canvas) {
        this.f7182n.setStrokeWidth(this.f7174f);
        int OplusGLSurfaceView_13 = this.f7184p;
        canvas.drawCircle(OplusGLSurfaceView_13, OplusGLSurfaceView_13, this.f7186r, this.f7182n);
    }

    public void setProgress(int OplusGLSurfaceView_13) {
        Log.OplusGLSurfaceView_13("COUICircleProgressBar", "setProgress: " + OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 < 0) {
            OplusGLSurfaceView_13 = 0;
        }
        int i2 = this.f7175g;
        if (OplusGLSurfaceView_13 > i2) {
            OplusGLSurfaceView_13 = i2;
        }
        if (OplusGLSurfaceView_13 != this.f7176h) {
            this.f7176h = OplusGLSurfaceView_13;
        }
        m7033d();
        m7035a();
    }

    public int getProgress() {
        return this.f7176h;
    }

    public void setMax(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            OplusGLSurfaceView_13 = 0;
        }
        if (OplusGLSurfaceView_13 != this.f7175g) {
            this.f7175g = OplusGLSurfaceView_13;
            if (this.f7176h > OplusGLSurfaceView_13) {
                this.f7176h = OplusGLSurfaceView_13;
            }
        }
        m7033d();
    }

    public int getMax() {
        return this.f7175g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m7035a() {
        AccessibilityManager accessibilityManager = this.f7180l;
        if (accessibilityManager != null && accessibilityManager.isEnabled() && this.f7180l.isTouchExplorationEnabled()) {
            m7034e();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m7034e() {
        RunnableC1361a runnableC1361a = this.f7179k;
        if (runnableC1361a == null) {
            this.f7179k = new RunnableC1361a();
        } else {
            removeCallbacks(runnableC1361a);
        }
        postDelayed(this.f7179k, 10L);
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        setMeasuredDimension(this.f7171c, this.f7172d);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        RunnableC1361a runnableC1361a = this.f7179k;
        if (runnableC1361a != null) {
            removeCallbacks(runnableC1361a);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mProgress = this.f7176h;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        this.f7183o = this.f7174f / 2;
        this.f7184p = getWidth() / 2;
        int i5 = this.f7184p;
        this.f7186r = i5 - this.f7183o;
        float COUIBaseListPopupWindow_12 = this.f7186r;
        this.f7185q = new RectF(i5 - COUIBaseListPopupWindow_12, i5 - COUIBaseListPopupWindow_12, i5 + COUIBaseListPopupWindow_12, i5 + COUIBaseListPopupWindow_12);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.mProgress);
        requestLayout();
    }

    /* renamed from: com.coui.appcompat.widget.COUICircleProgressBar$PlatformImplementations.kt_3 */
    private class RunnableC1361a implements Runnable {
        private RunnableC1361a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            COUICircleProgressBar.this.sendAccessibilityEvent(4);
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.widget.COUICircleProgressBar.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        int mProgress;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mProgress = ((Integer) parcel.readValue(null)).intValue();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeValue(Integer.valueOf(this.mProgress));
        }

        public String toString() {
            return "COUICircleProgressBar.SavedState { " + Integer.toHexString(System.identityHashCode(this)) + " mProgress = " + this.mProgress + " }";
        }
    }

    public void setWidth(int OplusGLSurfaceView_13) {
        this.f7171c = OplusGLSurfaceView_13;
    }

    public void setHeight(int OplusGLSurfaceView_13) {
        this.f7172d = OplusGLSurfaceView_13;
    }

    public void setProgressBarType(int OplusGLSurfaceView_13) {
        this.f7173e = OplusGLSurfaceView_13;
    }

    public void setProgressBarColor(int OplusGLSurfaceView_13) {
        this.f7169a = OplusGLSurfaceView_13;
        m7031b();
    }

    public void setProgressBarBgCircleColor(int OplusGLSurfaceView_13) {
        this.f7170b = OplusGLSurfaceView_13;
        m7032c();
    }
}
