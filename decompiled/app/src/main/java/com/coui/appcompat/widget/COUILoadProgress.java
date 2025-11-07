package com.coui.appcompat.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.p036h.p037a.AccessibilityManagerCompat;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUILoadProgress extends AppCompatButton {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final int[] f7347g = {R.attr.coui_state_default};

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static final int[] f7348h = {R.attr.coui_state_wait};

    /* renamed from: OplusGLSurfaceView_13 */
    private static final int[] f7349i = {R.attr.coui_state_fail};

    /* renamed from: OplusGLSurfaceView_15 */
    private static final int[] f7350j = {R.attr.coui_state_ing};

    /* renamed from: r */
    private static final DecelerateInterpolator f7351r = new DecelerateInterpolator();

    /* renamed from: PlatformImplementations.kt_3 */
    public int f7352a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int f7353b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f7354c;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected boolean f7355e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected float f7356f;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f7357k;

    /* renamed from: OplusGLSurfaceView_14 */
    private Drawable f7358l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f7359m;

    /* renamed from: OplusGLSurfaceView_11 */
    private InterfaceC1390b f7360n;

    /* renamed from: o */
    private InterfaceC1390b f7361o;

    /* renamed from: p */
    private RunnableC1389a f7362p;

    /* renamed from: q */
    private final AccessibilityManager f7363q;

    /* renamed from: com.coui.appcompat.widget.COUILoadProgress$IntrinsicsJvm.kt_4 */
    public interface InterfaceC1390b {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7147a(COUILoadProgress cOUILoadProgress, int OplusGLSurfaceView_13);
    }

    public void setProgress(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            OplusGLSurfaceView_13 = 0;
        }
        int i2 = this.f7354c;
        if (OplusGLSurfaceView_13 > i2) {
            OplusGLSurfaceView_13 = i2;
        }
        if (OplusGLSurfaceView_13 != this.f7353b) {
            this.f7353b = OplusGLSurfaceView_13;
        }
        if (this.f7355e) {
            this.f7355e = false;
        }
        invalidate();
        m7144a(OplusGLSurfaceView_13);
    }

    public int getProgress() {
        return this.f7353b;
    }

    public void setMax(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            OplusGLSurfaceView_13 = 0;
        }
        if (OplusGLSurfaceView_13 != this.f7354c) {
            this.f7354c = OplusGLSurfaceView_13;
            if (this.f7353b > OplusGLSurfaceView_13) {
                this.f7353b = OplusGLSurfaceView_13;
            }
            invalidate();
        }
    }

    public int getMax() {
        return this.f7354c;
    }

    public void setButtonDrawable(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0 || OplusGLSurfaceView_13 != this.f7357k) {
            this.f7357k = OplusGLSurfaceView_13;
            setButtonDrawable(this.f7357k != 0 ? getResources().getDrawable(this.f7357k) : null);
        }
    }

    public void setButtonDrawable(Drawable drawable) {
        if (drawable != null) {
            Drawable drawable2 = this.f7358l;
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f7358l);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            drawable.setVisible(getVisibility() == 0, false);
            this.f7358l = drawable;
            this.f7358l.setState(null);
            setMinHeight(this.f7358l.getIntrinsicHeight());
        }
        refreshDrawableState();
    }

    public void setState(int OplusGLSurfaceView_13) {
        if (this.f7352a != OplusGLSurfaceView_13) {
            this.f7352a = OplusGLSurfaceView_13;
            refreshDrawableState();
            if (this.f7359m) {
                return;
            }
            this.f7359m = true;
            InterfaceC1390b interfaceC1390b = this.f7360n;
            if (interfaceC1390b != null) {
                interfaceC1390b.m7147a(this, this.f7352a);
            }
            InterfaceC1390b interfaceC1390b2 = this.f7361o;
            if (interfaceC1390b2 != null) {
                interfaceC1390b2.m7147a(this, this.f7352a);
            }
            this.f7359m = false;
        }
    }

    public void setOnStateChangeListener(InterfaceC1390b interfaceC1390b) {
        this.f7360n = interfaceC1390b;
    }

    void setOnStateChangeWidgetListener(InterfaceC1390b interfaceC1390b) {
        this.f7361o = interfaceC1390b;
    }

    @Override // android.view.View
    public boolean performClick() {
        m7143a();
        return super.performClick();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7143a() {
        int OplusGLSurfaceView_13 = this.f7352a;
        if (OplusGLSurfaceView_13 == 0) {
            setState(1);
            return;
        }
        if (OplusGLSurfaceView_13 == 1) {
            setState(2);
        } else if (OplusGLSurfaceView_13 == 2) {
            setState(1);
        } else if (OplusGLSurfaceView_13 == 3) {
            setState(1);
        }
    }

    public int getState() {
        return this.f7352a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m7144a(int OplusGLSurfaceView_13) {
        AccessibilityManager accessibilityManager = this.f7363q;
        if (accessibilityManager != null && accessibilityManager.isEnabled() && AccessibilityManagerCompat.m2658a(this.f7363q)) {
            m7142b();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7142b() {
        RunnableC1389a runnableC1389a = this.f7362p;
        if (runnableC1389a == null) {
            this.f7362p = new RunnableC1389a(this, null);
        } else {
            removeCallbacks(runnableC1389a);
        }
        postDelayed(this.f7362p, 10L);
    }

    /* renamed from: com.coui.appcompat.widget.COUILoadProgress$PlatformImplementations.kt_3 */
    private class RunnableC1389a implements Runnable {
        private RunnableC1389a() {
        }

        /* synthetic */ RunnableC1389a(COUILoadProgress cOUILoadProgress, C13871 c13871) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            COUILoadProgress.this.sendAccessibilityEvent(4);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        RunnableC1389a runnableC1389a = this.f7362p;
        if (runnableC1389a != null) {
            removeCallbacks(runnableC1389a);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 1);
        if (getState() == 0) {
            mergeDrawableStates(iArrOnCreateDrawableState, f7347g);
        }
        if (getState() == 1) {
            mergeDrawableStates(iArrOnCreateDrawableState, f7350j);
        }
        if (getState() == 2) {
            mergeDrawableStates(iArrOnCreateDrawableState, f7348h);
        }
        if (getState() == 3) {
            mergeDrawableStates(iArrOnCreateDrawableState, f7349i);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f7358l != null) {
            this.f7358l.setState(getDrawableState());
            invalidate();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f7358l;
    }

    @Override // android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f7358l;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.widget.COUILoadProgress.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        int mProgress;
        int mState;

        /* synthetic */ SavedState(Parcel parcel, C13871 c13871) {
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mState = ((Integer) parcel.readValue(null)).intValue();
            this.mProgress = ((Integer) parcel.readValue(null)).intValue();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeValue(Integer.valueOf(this.mState));
            parcel.writeValue(Integer.valueOf(this.mProgress));
        }

        public String toString() {
            return "CompoundButton.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " mState = " + this.mState + " mProgress = " + this.mProgress + "}";
        }
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        setFreezesText(true);
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mState = getState();
        savedState.mProgress = this.f7353b;
        return savedState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setState(savedState.mState);
        setProgress(savedState.mProgress);
        requestLayout();
    }

    /* renamed from: com.coui.appcompat.widget.COUILoadProgress$1 */
    class C13871 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ COUILoadProgress f7364a;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7364a.f7356f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f7364a.invalidate();
        }
    }
}
