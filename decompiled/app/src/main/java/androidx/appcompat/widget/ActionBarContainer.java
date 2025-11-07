package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import androidx.core.p036h.ViewCompat;
import com.sensetime.stmobile.STMobileHumanActionNative;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    Drawable f1448a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    Drawable f1449b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    Drawable f1450c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean f1451d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean f1452e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f1453f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private View f1454g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private View f1455h;

    /* renamed from: OplusGLSurfaceView_13 */
    private View f1456i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f1457j;

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewCompat.m2850a(this, new ActionBarBackgroundDrawable(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f1448a = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f1449b = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.f1457j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        if (getId() == R.id_renamed.split_action_bar) {
            this.f1451d = true;
            this.f1450c = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.f1451d ? !(this.f1448a != null || this.f1449b != null) : this.f1450c == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1455h = findViewById(R.id_renamed.action_bar);
        this.f1456i = findViewById(R.id_renamed.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1448a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1448a);
        }
        this.f1448a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1455h;
            if (view != null) {
                this.f1448a.setBounds(view.getLeft(), this.f1455h.getTop(), this.f1455h.getRight(), this.f1455h.getBottom());
            }
        }
        boolean z = true;
        if (!this.f1451d ? this.f1448a != null || this.f1449b != null : this.f1450c != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1449b;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1449b);
        }
        this.f1449b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1452e && (drawable2 = this.f1449b) != null) {
                drawable2.setBounds(this.f1454g.getLeft(), this.f1454g.getTop(), this.f1454g.getRight(), this.f1454g.getBottom());
            }
        }
        boolean z = true;
        if (!this.f1451d ? this.f1448a != null || this.f1449b != null : this.f1450c != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1450c;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1450c);
        }
        this.f1450c = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1451d && (drawable2 = this.f1450c) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1451d ? !(this.f1448a != null || this.f1449b != null) : this.f1450c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        super.setVisibility(OplusGLSurfaceView_13);
        boolean z = OplusGLSurfaceView_13 == 0;
        Drawable drawable = this.f1448a;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f1449b;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f1450c;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1448a && !this.f1451d) || (drawable == this.f1449b && this.f1452e) || ((drawable == this.f1450c && this.f1451d) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1448a;
        if (drawable != null && drawable.isStateful()) {
            this.f1448a.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1449b;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1449b.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1450c;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f1450c.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1448a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1449b;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1450c;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean z) {
        this.f1453f = z;
        setDescendantFocusability(z ? 393216 : STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1453f || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ScrollingTabContainerView c0315ak) {
        View view = this.f1454g;
        if (view != null) {
            removeView(view);
        }
        this.f1454g = c0315ak;
        if (c0315ak != null) {
            addView(c0315ak);
            ViewGroup.LayoutParams layoutParams = c0315ak.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            c0315ak.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.f1454g;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0) {
            return super.startActionModeForChild(view, callback, OplusGLSurfaceView_13);
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m1215a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m1216b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int iM1216b;
        int i3;
        if (this.f1455h == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i3 = this.f1457j) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(OplusGLSurfaceView_13, i2);
        if (this.f1455h == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        View view = this.f1454g;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (!m1215a(this.f1455h)) {
            iM1216b = m1216b(this.f1455h);
        } else {
            iM1216b = !m1215a(this.f1456i) ? m1216b(this.f1456i) : 0;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(iM1216b + m1216b(this.f1454g), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a A[PHI: r0
      0x004a: PHI (r0v8 boolean) = (r0v1 boolean), (r0v1 boolean), (r0v0 boolean) binds: [B:31:0x00a7, B:33:0x00ab, B:15:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            super.onLayout(r6, r7, r8, r9, r10)
            android.view.View r6 = r5.f1454g
            r8 = 8
            r10 = 1
            r0 = 0
            if (r6 == 0) goto L13
            int r1 = r6.getVisibility()
            if (r1 == r8) goto L13
            r1 = r10
            goto L14
        L13:
            r1 = r0
        L14:
            if (r6 == 0) goto L35
            int r2 = r6.getVisibility()
            if (r2 == r8) goto L35
            int r8 = r5.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r6.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r3 = r6.getMeasuredHeight()
            int r3 = r8 - r3
            int r4 = r2.bottomMargin
            int r3 = r3 - r4
            int r2 = r2.bottomMargin
            int r8 = r8 - r2
            r6.layout(r7, r3, r9, r8)
        L35:
            boolean r7 = r5.f1451d
            if (r7 == 0) goto L4d
            android.graphics.drawable.Drawable r6 = r5.f1450c
            if (r6 == 0) goto L4a
            int r7 = r5.getMeasuredWidth()
            int r8 = r5.getMeasuredHeight()
            r6.setBounds(r0, r0, r7, r8)
            goto Lc0
        L4a:
            r10 = r0
            goto Lc0
        L4d:
            android.graphics.drawable.Drawable r7 = r5.f1448a
            if (r7 == 0) goto La5
            android.view.View r7 = r5.f1455h
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L77
            android.graphics.drawable.Drawable r7 = r5.f1448a
            android.view.View r8 = r5.f1455h
            int r8 = r8.getLeft()
            android.view.View r9 = r5.f1455h
            int r9 = r9.getTop()
            android.view.View r0 = r5.f1455h
            int r0 = r0.getRight()
            android.view.View r2 = r5.f1455h
            int r2 = r2.getBottom()
            r7.setBounds(r8, r9, r0, r2)
            goto La4
        L77:
            android.view.View r7 = r5.f1456i
            if (r7 == 0) goto L9f
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L9f
            android.graphics.drawable.Drawable r7 = r5.f1448a
            android.view.View r8 = r5.f1456i
            int r8 = r8.getLeft()
            android.view.View r9 = r5.f1456i
            int r9 = r9.getTop()
            android.view.View r0 = r5.f1456i
            int r0 = r0.getRight()
            android.view.View r2 = r5.f1456i
            int r2 = r2.getBottom()
            r7.setBounds(r8, r9, r0, r2)
            goto La4
        L9f:
            android.graphics.drawable.Drawable r7 = r5.f1448a
            r7.setBounds(r0, r0, r0, r0)
        La4:
            r0 = r10
        La5:
            r5.f1452e = r1
            if (r1 == 0) goto L4a
            android.graphics.drawable.Drawable r7 = r5.f1449b
            if (r7 == 0) goto L4a
            int r8 = r6.getLeft()
            int r9 = r6.getTop()
            int r0 = r6.getRight()
            int r6 = r6.getBottom()
            r7.setBounds(r8, r9, r0, r6)
        Lc0:
            if (r10 == 0) goto Lc5
            r5.invalidate()
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }
}
