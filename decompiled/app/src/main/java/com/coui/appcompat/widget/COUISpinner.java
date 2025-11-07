package com.coui.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.ViewUtils_2;
import androidx.core.p036h.p038b.PathInterpolatorCompat_2;
import com.coui.appcompat.p099a.COUIChangeTextUtil;
import com.coui.appcompat.widget.COUIAdapterView;
import com.coui.appcompat.widget.COUIBaseSpinner;
import com.coui.appcompat.widget.COUISpinnerCallback;
import com.coui.appcompat.widget.popupwindow.COUIBaseListPopupWindow;
import com.coui.appcompat.widget.popupwindow.COUIBasePopupWindow;
import com.coui.appcompat.widget.popupwindow.COUIPopupWindow;

/* compiled from: COUISpinner.java */
/* renamed from: com.coui.appcompat.widget.o */
/* loaded from: classes.dex */
public class COUISpinner extends COUIBaseSpinner implements COUISpinnerCallback {

    /* renamed from: H */
    private static final Interpolator f8421H = PathInterpolatorCompat_2.m2772a(0.133f, 0.0f, 0.3f, 1.0f);

    /* renamed from: I */
    private static final Interpolator f8422I;

    /* renamed from: J */
    private static final Interpolator f8423J;

    /* renamed from: K */
    private static final Interpolator f8424K;

    /* renamed from: L */
    private static final Interpolator f8425L;

    /* renamed from: M */
    private final Rect f8426M;

    /* renamed from: N */
    private AnimatorSet f8427N;

    /* renamed from: O */
    private RotateDrawable f8428O;

    /* renamed from: P */
    private int f8429P;

    /* renamed from: Q */
    private int f8430Q;

    /* renamed from: R */
    private boolean f8431R;

    /* renamed from: S */
    private boolean f8432S;

    /* renamed from: T */
    private boolean f8433T;

    /* renamed from: U */
    private boolean f8434U;

    /* renamed from: V */
    private boolean f8435V;

    /* renamed from: W */
    private COUISpinnerCallback.PlatformImplementations.kt_3 f8436W;

    /* renamed from: aa */
    private TextView f8437aa;

    /* renamed from: ab */
    private int f8438ab;

    /* renamed from: ac */
    private float f8439ac;

    /* renamed from: ad */
    private ColorStateList f8440ad;

    /* renamed from: ae */
    private int f8441ae;

    /* renamed from: af */
    private int f8442af;

    /* renamed from: ag */
    private PlatformImplementations.kt_3 f8443ag;

    /* compiled from: COUISpinner.java */
    /* renamed from: com.coui.appcompat.widget.o$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7997a(COUISpinner c1497o, boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m7998b(COUISpinner c1497o, boolean z);
    }

    @Override // com.coui.appcompat.widget.COUIAbsSpinner, com.coui.appcompat.widget.COUIAdapterView
    public /* bridge */ /* synthetic */ SpinnerAdapter getAdapter() {
        return super.getAdapter();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, android.view.View
    public /* bridge */ /* synthetic */ int getBaseline() {
        return super.getBaseline();
    }

    @Override // com.coui.appcompat.widget.COUIAbsSpinner, com.coui.appcompat.widget.COUIAdapterView
    public /* bridge */ /* synthetic */ int getCount() {
        return super.getCount();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ int getDropDownHorizontalOffset() {
        return super.getDropDownHorizontalOffset();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ int getDropDownVerticalOffset() {
        return super.getDropDownVerticalOffset();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ int getDropDownWidth() {
        return super.getDropDownWidth();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ Drawable getPopupBackground() {
        return super.getPopupBackground();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ CharSequence getPrompt() {
        return super.getPrompt();
    }

    @Override // com.coui.appcompat.widget.COUIAbsSpinner, com.coui.appcompat.widget.COUIAdapterView
    public /* bridge */ /* synthetic */ View getSelectedView() {
        return super.getSelectedView();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, android.content.DialogInterface.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
        super.onClick(dialogInterface, OplusGLSurfaceView_13);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, com.coui.appcompat.widget.COUIAbsSpinner, android.view.View
    public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, android.view.View
    public /* bridge */ /* synthetic */ boolean performClick() {
        return super.performClick();
    }

    @Override // com.coui.appcompat.widget.COUIAbsSpinner, android.view.View, android.view.ViewParent
    public /* bridge */ /* synthetic */ void requestLayout() {
        super.requestLayout();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, com.coui.appcompat.widget.COUIAbsSpinner
    public /* bridge */ /* synthetic */ void setAdapter(SpinnerAdapter spinnerAdapter) {
        super.setAdapter(spinnerAdapter);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ void setDropDownHorizontalOffset(int OplusGLSurfaceView_13) {
        super.setDropDownHorizontalOffset(OplusGLSurfaceView_13);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ void setDropDownVerticalOffset(int OplusGLSurfaceView_13) {
        super.setDropDownVerticalOffset(OplusGLSurfaceView_13);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ void setDropDownWidth(int OplusGLSurfaceView_13) {
        super.setDropDownWidth(OplusGLSurfaceView_13);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ void setGravity(int OplusGLSurfaceView_13) {
        super.setGravity(OplusGLSurfaceView_13);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ void setPopupBackgroundDrawable(Drawable drawable) {
        super.setPopupBackgroundDrawable(drawable);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ void setPopupBackgroundResource(int OplusGLSurfaceView_13) {
        super.setPopupBackgroundResource(OplusGLSurfaceView_13);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ void setPrompt(CharSequence charSequence) {
        super.setPrompt(charSequence);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    public /* bridge */ /* synthetic */ void setPromptId(int OplusGLSurfaceView_13) {
        super.setPromptId(OplusGLSurfaceView_13);
    }

    static {
        Interpolator interpolator = f8421H;
        f8422I = interpolator;
        f8423J = interpolator;
        f8424K = PathInterpolatorCompat_2.m2772a(0.15f, 0.0f, 0.0f, 1.0f);
        f8425L = PathInterpolatorCompat_2.m2772a(0.33f, 0.0f, 0.66f, 1.0f);
    }

    public PlatformImplementations.kt_3 getOnPopupWindowActionListener() {
        return this.f8443ag;
    }

    public void setOnPopupWindowActionListener(PlatformImplementations.kt_3 aVar) {
        this.f8443ag = aVar;
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, com.coui.appcompat.widget.COUIAdapterView
    public void setOnItemClickListener(COUIAdapterView.IntrinsicsJvm.kt_4 bVar) {
        setOnItemClickListenerInt(bVar);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, com.coui.appcompat.widget.COUIAbsSpinner, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        RotateDrawable rotateDrawable = this.f8428O;
        if (rotateDrawable == null || !this.f8431R) {
            return;
        }
        int intrinsicWidth = rotateDrawable.getIntrinsicWidth();
        int intrinsicHeight = this.f8428O.getIntrinsicHeight();
        setMeasuredDimension(this.f8438ab + intrinsicWidth + this.f8430Q, m7977a(OplusGLSurfaceView_13, i2));
        boolean z = !ViewUtils_2.m1623a(this);
        int measuredWidth = z ? (getMeasuredWidth() - intrinsicWidth) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop() + ((((getMeasuredHeight() - intrinsicHeight) - getPaddingTop()) - getPaddingBottom()) / 2);
        if (z) {
            intrinsicWidth += measuredWidth;
        }
        this.f8428O.setBounds(measuredWidth, paddingTop, intrinsicWidth, intrinsicHeight + paddingTop);
        this.f8431R = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m7977a(int OplusGLSurfaceView_13, int i2) {
        TextView textView;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 || (textView = this.f8437aa) == null) {
            return size;
        }
        measureChild(textView, OplusGLSurfaceView_13, i2);
        return Math.max(this.f8437aa.getMeasuredHeight(), getMeasuredHeight());
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, com.coui.appcompat.widget.COUIAdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
        this.f8432S = true;
        TextView textView = (TextView) findViewById(R.id_renamed.text1);
        if (textView != null) {
            textView.setTextColor(this.f8440ad);
            m7995n();
            if (textView.getPaint() != null) {
                COUIChangeTextUtil.m6391a(textView, true);
                this.f8437aa = textView;
                m7994m();
            }
        }
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, com.coui.appcompat.widget.COUIAbsSpinner
    /* renamed from: PlatformImplementations.kt_3 */
    void mo6962a(int OplusGLSurfaceView_13, boolean z) {
        int minimumWidth;
        RotateDrawable rotateDrawable;
        if (this.f7095h == null || (rotateDrawable = this.f8428O) == null) {
            minimumWidth = 0;
        } else {
            minimumWidth = this.f8430Q + rotateDrawable.getMinimumWidth();
            if (getLayoutDirection() == 1) {
                this.f7095h.left += minimumWidth;
            } else {
                this.f7095h.right += minimumWidth;
            }
        }
        super.mo6962a(OplusGLSurfaceView_13, z);
        this.f7095h.right -= minimumWidth;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m7994m() {
        TextView textView = this.f8437aa;
        if (textView == null) {
            return;
        }
        float textSize = textView.getTextSize();
        this.f8437aa.setTextSize(0, (int) this.f8439ac);
        if (Build.VERSION.SDK_INT >= 21 || textSize == this.f8439ac) {
            return;
        }
        post(new Runnable() { // from class: com.coui.appcompat.widget.o.1
            @Override // java.lang.Runnable
            public void run() {
                COUISpinner.this.requestLayout();
            }
        });
    }

    public void setSpinnerTextSize(float COUIBaseListPopupWindow_12) {
        this.f8439ac = COUIBaseListPopupWindow_12;
    }

    public void setSpinnerColorResource(int OplusGLSurfaceView_13) {
        setSpinnerColor(getResources().getColorStateList(OplusGLSurfaceView_13));
    }

    public void setSpinnerColor(int OplusGLSurfaceView_13) {
        setSpinnerColor(ColorStateList.valueOf(OplusGLSurfaceView_13));
    }

    public void setSpinnerColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        try {
            this.f8440ad = colorStateList;
            this.f8441ae = this.f8440ad.getDefaultColor();
            this.f8442af = this.f8440ad.getColorForState(new int[]{-16842910}, -16777216);
            if (this.f8437aa != null) {
                this.f8437aa.setTextColor(this.f8440ad);
            }
            if (this.f8428O != null) {
                m7995n();
                invalidate();
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m7995n() {
        int OplusGLSurfaceView_13;
        if (isEnabled()) {
            OplusGLSurfaceView_13 = this.f8441ae;
        } else {
            OplusGLSurfaceView_13 = this.f8442af;
        }
        this.f8428O.setColorFilter(OplusGLSurfaceView_13, PorterDuff.Mode.SRC_IN);
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        TextView textView = this.f8437aa;
        if (textView != null) {
            textView.setEnabled(z);
        }
        if (this.f8428O != null) {
            m7995n();
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8434U = false;
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, com.coui.appcompat.widget.COUIAdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f8434U = true;
        AnimatorSet animatorSet = this.f8427N;
        if (animatorSet != null) {
            animatorSet.end();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner, com.coui.appcompat.widget.COUIAbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        this.f8435V = true;
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        RotateDrawable rotateDrawable = this.f8428O;
        if (rotateDrawable != null) {
            rotateDrawable.draw(canvas);
        }
    }

    @Override // com.coui.appcompat.widget.COUIBaseSpinner
    /* renamed from: PlatformImplementations.kt_3 */
    int mo6974a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        this.f8431R = true;
        if (spinnerAdapter == null) {
            return 0;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition < 0 || selectedItemPosition >= spinnerAdapter.getCount()) {
            return super.mo6974a(spinnerAdapter, drawable);
        }
        int iM7996o = m7996o();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        spinnerAdapter.getItemViewType(selectedItemPosition);
        View view = spinnerAdapter.getView(selectedItemPosition, null, this);
        if (view instanceof TextView) {
            this.f8437aa = (TextView) view;
            COUIChangeTextUtil.m6391a(this.f8437aa, true);
            m7994m();
        }
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        view.measure(iM7996o, iMakeMeasureSpec);
        int measuredWidth = view.getMeasuredWidth();
        this.f8438ab = measuredWidth;
        if (drawable == null) {
            return measuredWidth;
        }
        drawable.getPadding(this.f8426M);
        return measuredWidth + this.f8426M.left + this.f8426M.right;
    }

    /* renamed from: o */
    private int m7996o() {
        int mode = View.MeasureSpec.getMode(this.f7090c);
        int size = View.MeasureSpec.getSize(this.f7090c) - (this.f8428O.getMinimumWidth() + this.f8430Q);
        if (size > 0) {
            return View.MeasureSpec.makeMeasureSpec(size, mode);
        }
        return this.f7090c;
    }

    @Override // com.coui.appcompat.widget.COUIAdapterView
    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo7532e() {
        if (this.f8432S) {
            super.mo7532e();
        }
    }

    @Override // com.coui.appcompat.widget.COUIAbsSpinner, com.coui.appcompat.widget.COUIAdapterView
    public void setSelection(int OplusGLSurfaceView_13) {
        if (!this.f8433T || this.f7100F == null || !this.f7100F.m6988d() || !(this.f7100F instanceof IntrinsicsJvm.kt_4)) {
            super.setSelection(OplusGLSurfaceView_13);
        } else {
            ((IntrinsicsJvm.kt_4) this.f7100F).f8449h = OplusGLSurfaceView_13;
        }
    }

    public void setDropdownDismissCallback(COUISpinnerCallback.PlatformImplementations.kt_3 aVar) {
        this.f8436W = aVar;
    }

    public void setDropdownItemClickListener(COUIAdapterView.IntrinsicsJvm.kt_4 bVar) {
        setOnItemClickListener(bVar);
    }

    public void setDropdownUpdateAfterAnim(boolean z) {
        this.f8433T = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m7979a(float COUIBaseListPopupWindow_12) {
        RotateDrawable rotateDrawable = this.f8428O;
        if (rotateDrawable != null) {
            rotateDrawable.setLevel((int) (COUIBaseListPopupWindow_12 * 10000.0f));
            invalidate();
        }
    }

    /* compiled from: COUISpinner.java */
    /* renamed from: com.coui.appcompat.widget.o$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends COUIBaseSpinner.C1353b implements COUISpinnerCallback.IntrinsicsJvm.kt_4 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        final /* synthetic */ COUISpinner f8445b;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private final COUIBaseListPopupWindow.COUIBaseListPopupWindow_11 f8446e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private final ColorDrawable f8447f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private final int f8448g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private int f8449h;

        /* renamed from: OplusGLSurfaceView_13 */
        private boolean f8450i;

        /* renamed from: OplusGLSurfaceView_15 */
        private COUIPopupWindow f8451j;

        /* renamed from: OplusGLSurfaceView_5 */
        private int f8452k;

        @Override // com.coui.appcompat.widget.popupwindow.COUIBaseListPopupWindow
        /* renamed from: COUIBaseListPopupWindow_10 */
        public void mo8014h() {
            super.mo8014h();
            m8007q();
        }

        @Override // com.coui.appcompat.widget.popupwindow.COUIBaseListPopupWindow, com.coui.appcompat.widget.COUIBaseSpinner.InterfaceC1354c
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo6987c() {
            this.f8483c.dismiss();
        }

        @Override // com.coui.appcompat.widget.COUIBaseSpinner.C1353b, com.coui.appcompat.widget.COUIBaseSpinner.InterfaceC1354c
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo6980a(int OplusGLSurfaceView_13, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean zD = m8034d();
            m6983b();
            m8038f(2);
            mo8014h();
            ListView listViewP = m8045p();
            listViewP.setDivider(null);
            listViewP.setChoiceMode(1);
            listViewP.setTextDirection(OplusGLSurfaceView_13);
            listViewP.setBackgroundColor(this.f8445b.getResources().getColor(coui.support.appcompat.R.color.coui_spinner_popupwindow_listview_bg_color));
            m8002a(listViewP);
            COUIViewCompat.m8184a(listViewP, i2);
            m8040g(this.f8445b.getSelectedItemPosition());
            m8011u();
            if (zD || (viewTreeObserver = this.f8445b.getViewTreeObserver()) == null) {
                return;
            }
            final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.coui.appcompat.widget.o.IntrinsicsJvm.kt_4.5
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (!COUIViewCompat.m8186c(IntrinsicsJvm.kt_4.this.f8445b)) {
                        IntrinsicsJvm.kt_4.this.mo6987c();
                        return;
                    }
                    IntrinsicsJvm.kt_4.this.m6983b();
                    IntrinsicsJvm.kt_4 bVar = IntrinsicsJvm.kt_4.this;
                    bVar.m8002a(bVar.m8045p());
                    IntrinsicsJvm.kt_4.this.mo8014h();
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            m8030a(new COUIBasePopupWindow.PlatformImplementations.kt_3() { // from class: com.coui.appcompat.widget.o.IntrinsicsJvm.kt_4.6
                @Override // com.coui.appcompat.widget.popupwindow.COUIBasePopupWindow.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6984a() {
                    ViewTreeObserver viewTreeObserver2 = IntrinsicsJvm.kt_4.this.f8445b.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        COUIViewTreeObserverCompat.m8237a(viewTreeObserver2, onGlobalLayoutListener);
                    }
                    IntrinsicsJvm.kt_4.super.mo6987c();
                }
            });
        }

        @Override // com.coui.appcompat.widget.popupwindow.COUIListPopupWindow, com.coui.appcompat.widget.popupwindow.COUIPopupWindow.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo7896a(WindowManager.LayoutParams layoutParams) {
            layoutParams.windowAnimations = 0;
        }

        @Override // com.coui.appcompat.widget.popupwindow.COUIListPopupWindow, com.coui.appcompat.widget.popupwindow.COUIPopupWindow.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo8012a(COUIPopupWindow c1503e) {
            this.f8451j = c1503e;
            if (this.f8445b.f8436W != null && this.f8450i) {
                this.f8445b.f8436W.m8018a(this);
            } else {
                m8015i();
            }
        }

        @Override // com.coui.appcompat.widget.popupwindow.COUIListPopupWindow, com.coui.appcompat.widget.popupwindow.COUIPopupWindow.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo8013b(COUIPopupWindow c1503e) {
            if (!this.f8445b.f8433T || this.f8449h == -1) {
                return;
            }
            this.f8445b.f8432S = false;
            this.f8445b.setSelection(this.f8449h);
            this.f8449h = -1;
        }

        /* renamed from: OplusGLSurfaceView_13 */
        public void m8015i() {
            m8006c(this.f8451j);
        }

        @Override // com.coui.appcompat.widget.popupwindow.COUIBaseListPopupWindow
        /* renamed from: OplusGLSurfaceView_15 */
        protected int mo8016j() {
            if (this.f8445b.f7101G == -1) {
                m8032c(this.f8445b.getContext().getResources().getDisplayMetrics().widthPixels);
            }
            if (this.f8445b.f8429P == -1) {
                m8036e(this.f8483c.getMaxAvailableHeight(m8041l(), m8037f(), false));
            }
            return super.mo8016j();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public void m8002a(final ListView listView) {
            if (listView == null) {
                return;
            }
            listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.coui.appcompat.widget.o.IntrinsicsJvm.kt_4.7
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    listView.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (IntrinsicsJvm.kt_4.this.m7999a((View) listView) <= IntrinsicsJvm.kt_4.this.f8452k) {
                        return true;
                    }
                    ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
                    layoutParams.height = IntrinsicsJvm.kt_4.this.f8452k;
                    listView.setLayoutParams(layoutParams);
                    return false;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public int m7999a(View view) {
            int height = view.getHeight();
            return height == 0 ? view.getMeasuredHeight() : height;
        }

        /* renamed from: q */
        private void m8007q() {
            this.f8483c.setTouchInterceptor(this.f8446e);
            this.f8483c.setAnimationStyle(0);
        }

        /* renamed from: r */
        private void m8008r() {
            this.f8447f.setColor(this.f8445b.getResources().getColor(coui.support.appcompat.R.color.coui_spiner_background_color));
            this.f8447f.setAlpha(this.f8448g);
            this.f8483c.setBackgroundDrawable(this.f8447f);
        }

        /* renamed from: s */
        private void m8009s() {
            ListView listViewP = m8045p();
            ViewGroup.LayoutParams layoutParams = listViewP.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            } else {
                layoutParams.width = -1;
                layoutParams.height = -2;
            }
            listViewP.setLayoutParams(layoutParams);
            if (listViewP.getWidth() == 0 || listViewP.getHeight() == 0) {
                listViewP.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 0), View.MeasureSpec.makeMeasureSpec(layoutParams.height, Integer.MIN_VALUE));
            }
        }

        /* renamed from: t */
        private AnimatorSet m8010t() {
            final ListView listViewP = m8045p();
            final Drawable drawableE = m8035e();
            AnimatorSet animatorSet = new AnimatorSet();
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setInterpolator(COUISpinner.f8422I);
            valueAnimatorOfFloat.setDuration(300L);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.o.IntrinsicsJvm.kt_4.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IntrinsicsJvm.kt_4.this.f8445b.m7979a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 102);
            valueAnimatorOfInt.setDuration(350L);
            valueAnimatorOfInt.setStartDelay(150L);
            valueAnimatorOfInt.setInterpolator(COUISpinner.f8425L);
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.o.IntrinsicsJvm.kt_4.9
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    drawableE.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat2.setDuration(350L);
            valueAnimatorOfFloat2.setStartDelay(150L);
            valueAnimatorOfFloat2.setInterpolator(COUISpinner.f8424K);
            valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.o.IntrinsicsJvm.kt_4.10
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    listViewP.setTranslationY((-IntrinsicsJvm.kt_4.this.m7999a((View) r0)) * (1.0f - fFloatValue));
                }
            });
            animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfInt).with(valueAnimatorOfFloat2);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.widget.o.IntrinsicsJvm.kt_4.11
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    listViewP.setTranslationY(-IntrinsicsJvm.kt_4.this.m7999a((View) r2));
                    drawableE.setAlpha(0);
                    if (IntrinsicsJvm.kt_4.this.f8445b.f8443ag != null) {
                        IntrinsicsJvm.kt_4.this.f8445b.f8443ag.m7997a(IntrinsicsJvm.kt_4.this.f8445b, true);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (IntrinsicsJvm.kt_4.this.f8445b.f8443ag != null) {
                        IntrinsicsJvm.kt_4.this.f8445b.f8443ag.m7997a(IntrinsicsJvm.kt_4.this.f8445b, false);
                    }
                }
            });
            return animatorSet;
        }

        /* renamed from: OplusGLSurfaceView_5 */
        AnimatorSet m8017k() {
            AnimatorSet animatorSet = new AnimatorSet();
            final ListView listViewP = m8045p();
            final Drawable drawableE = m8035e();
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(102, 0);
            valueAnimatorOfInt.setInterpolator(COUISpinner.f8425L);
            valueAnimatorOfInt.setDuration(300L);
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.o.IntrinsicsJvm.kt_4.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    drawableE.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setInterpolator(COUISpinner.f8424K);
            valueAnimatorOfFloat.setDuration(300L);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.o.IntrinsicsJvm.kt_4.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    listViewP.setTranslationY((-IntrinsicsJvm.kt_4.this.m7999a((View) r0)) * fFloatValue);
                }
            });
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
            valueAnimatorOfFloat2.setDuration(300L);
            valueAnimatorOfFloat2.setInterpolator(COUISpinner.f8422I);
            valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.o.IntrinsicsJvm.kt_4.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IntrinsicsJvm.kt_4.this.f8445b.m7979a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            animatorSet.play(valueAnimatorOfInt).with(valueAnimatorOfFloat).with(valueAnimatorOfFloat2);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.widget.o.IntrinsicsJvm.kt_4.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (IntrinsicsJvm.kt_4.this.f8445b.f8443ag != null) {
                        IntrinsicsJvm.kt_4.this.f8445b.f8443ag.m7998b(IntrinsicsJvm.kt_4.this.f8445b, false);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (IntrinsicsJvm.kt_4.this.f8445b.f8443ag != null) {
                        IntrinsicsJvm.kt_4.this.f8445b.f8443ag.m7998b(IntrinsicsJvm.kt_4.this.f8445b, true);
                    }
                }
            });
            return animatorSet;
        }

        /* renamed from: u */
        private void m8011u() {
            m8007q();
            m8008r();
            m8009s();
            if (this.f8445b.f8427N != null) {
                this.f8445b.f8427N.end();
            }
            this.f8445b.f8427N = m8010t();
            this.f8445b.f8427N.addListener(new PlatformImplementations.kt_3(null));
            this.f8445b.f8427N.start();
            if (this.f8445b.f8435V) {
                this.f8445b.f8435V = false;
                this.f8445b.f8427N.end();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private void m8006c(COUIPopupWindow c1503e) {
            if (this.f8445b.f8427N != null) {
                this.f8445b.f8427N.end();
            }
            this.f8445b.f8427N = m8017k();
            this.f8445b.f8427N.addListener(new PlatformImplementations.kt_3(this.f8445b.f8434U ? null : c1503e));
            this.f8445b.f8427N.start();
            if (this.f8445b.f8434U) {
                this.f8445b.f8434U = false;
                c1503e.m8102b();
                this.f8445b.f8427N.end();
            }
        }

        /* compiled from: COUISpinner.java */
        /* renamed from: com.coui.appcompat.widget.o$IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
        private class PlatformImplementations.kt_3 extends AnimatorListenerAdapter {

            /* renamed from: IntrinsicsJvm.kt_4 */
            private final COUIPopupWindow f8473b;

            public PlatformImplementations.kt_3(COUIPopupWindow c1503e) {
                this.f8473b = c1503e;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IntrinsicsJvm.kt_4.this.f8445b.f8427N = null;
                COUIPopupWindow c1503e = this.f8473b;
                if (c1503e != null) {
                    c1503e.m8102b();
                }
            }
        }
    }
}
