package com.coui.appcompat.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUISnackBar extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final PathInterpolator f7759a = new PathInterpolator(0.3f, 0.0f, 1.0f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final PathInterpolator f7760b = new PathInterpolator(0.0f, 0.0f, 0.15f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final PathInterpolator f7761c = new PathInterpolator(0.1f, 0.0f, 0.1f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final PathInterpolator f7762d = new PathInterpolator(0.1f, 0.0f, 0.1f, 1.0f);

    /* renamed from: OplusGLSurfaceView_6 */
    private static int f7763m;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final int f7764e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final int f7765f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final int f7766g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final int f7767h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final int f7768i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final int f7769j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final int f7770k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final int f7771l;

    /* renamed from: OplusGLSurfaceView_11 */
    private ViewGroup f7772n;

    /* renamed from: o */
    private ViewGroup f7773o;

    /* renamed from: p */
    private TextView f7774p;

    /* renamed from: q */
    private TextView f7775q;

    /* renamed from: r */
    private ImageView f7776r;

    /* renamed from: s */
    private View f7777s;

    /* renamed from: t */
    private int f7778t;

    /* renamed from: u */
    private int f7779u;

    /* renamed from: v */
    private int f7780v;

    /* renamed from: w */
    private String f7781w;

    /* renamed from: x */
    private Runnable f7782x;

    /* renamed from: y */
    private InterfaceC1429b f7783y;

    /* renamed from: com.coui.appcompat.widget.COUISnackBar$IntrinsicsJvm.kt_4 */
    public interface InterfaceC1429b {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7446a(COUISnackBar cOUISnackBar);
    }

    public COUISnackBar(Context context) {
        super(context);
        this.f7764e = getResources().getDimensionPixelSize(R.dimen.coui_snack_bar_max_width);
        this.f7765f = getResources().getDimensionPixelSize(R.dimen.coui_snack_bar_action_max_width);
        this.f7766g = getResources().getDimensionPixelSize(R.dimen.coui_snack_bar_child_margin_vertical);
        this.f7767h = getResources().getDimensionPixelSize(R.dimen.coui_snack_bar_child_margin_horizontal);
        this.f7768i = getResources().getDimensionPixelSize(R.dimen.coui_snack_bar_action_margin_vertical);
        this.f7769j = getResources().getDimensionPixelSize(R.dimen.coui_snack_bar_context_margin_start_with_icon);
        this.f7770k = getResources().getDimensionPixelSize(R.dimen.coui_snack_bar_action_margin_top_horizontal);
        this.f7771l = getResources().getDimensionPixelSize(R.dimen.coui_snack_bar_off_screen_width_offset);
        m7434a(context, (AttributeSet) null);
    }

    public COUISnackBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7764e = getResources().getDimensionPixelSize(R.dimen.coui_snack_bar_max_width);
        this.f7765f = getResources().getDimensionPixelSize(R.dimen.coui_snack_bar_action_max_width);
        this.f7766g = getResources().getDimensionPixelSize(R.dimen.coui_snack_bar_child_margin_vertical);
        this.f7767h = getResources().getDimensionPixelSize(R.dimen.coui_snack_bar_child_margin_horizontal);
        this.f7768i = getResources().getDimensionPixelSize(R.dimen.coui_snack_bar_action_margin_vertical);
        this.f7769j = getResources().getDimensionPixelSize(R.dimen.coui_snack_bar_context_margin_start_with_icon);
        this.f7770k = getResources().getDimensionPixelSize(R.dimen.coui_snack_bar_action_margin_top_horizontal);
        this.f7771l = getResources().getDimensionPixelSize(R.dimen.coui_snack_bar_off_screen_width_offset);
        m7434a(context, attributeSet);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Runnable runnable;
        super.setEnabled(z);
        this.f7775q.setEnabled(z);
        this.f7774p.setEnabled(z);
        this.f7776r.setEnabled(z);
        if (getDuration() == 0 || (runnable = this.f7782x) == null) {
            return;
        }
        removeCallbacks(runnable);
        postDelayed(this.f7782x, getDuration());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7444a() {
        Runnable runnable = this.f7782x;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        m7440d();
    }

    public void setContentText(int OplusGLSurfaceView_13) {
        setContentText(getResources().getString(OplusGLSurfaceView_13));
    }

    public void setContentText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f7774p.setVisibility(8);
            Runnable runnable = this.f7782x;
            if (runnable != null) {
                removeCallbacks(runnable);
                return;
            }
            return;
        }
        this.f7774p.setText(str);
        this.f7781w = str;
    }

    public void setOnStatusChangeListener(InterfaceC1429b interfaceC1429b) {
        this.f7783y = interfaceC1429b;
    }

    private void setActionText(String str) {
        this.f7775q.setText(str);
    }

    public String getContentText() {
        return String.valueOf(this.f7774p.getText());
    }

    public TextView getContentView() {
        return this.f7774p;
    }

    public TextView getActionView() {
        return this.f7775q;
    }

    public String getActionText() {
        return String.valueOf(this.f7775q.getText());
    }

    public int getDuration() {
        return this.f7779u;
    }

    public void setDuration(int OplusGLSurfaceView_13) {
        this.f7779u = OplusGLSurfaceView_13;
    }

    /* renamed from: com.coui.appcompat.widget.COUISnackBar$1 */
    class ViewOnClickListenerC14261 implements View.OnClickListener {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ View.OnClickListener f7784a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final /* synthetic */ COUISnackBar f7785b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f7784a.onClick(view);
            COUISnackBar cOUISnackBar = this.f7785b;
            cOUISnackBar.removeCallbacks(cOUISnackBar.f7782x);
            this.f7785b.m7444a();
        }
    }

    private void setParent(ViewGroup viewGroup) {
        this.f7772n = viewGroup;
    }

    public void setIconDrawable(int OplusGLSurfaceView_13) {
        setIconDrawable(getResources().getDrawable(OplusGLSurfaceView_13, getContext().getTheme()));
    }

    public void setIconDrawable(Drawable drawable) {
        if (drawable == null) {
            this.f7776r.setVisibility(8);
        } else {
            this.f7776r.setVisibility(0);
            this.f7776r.setImageDrawable(drawable);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m7438c() {
        return this.f7776r.getDrawable() != null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7434a(Context context, AttributeSet attributeSet) {
        this.f7777s = inflate(context, R.layout.coui_snack_bar_item, this);
        this.f7773o = (ViewGroup) this.f7777s.findViewById(R.id_renamed.snack_bar);
        this.f7774p = (TextView) this.f7777s.findViewById(R.id_renamed.tv_snack_bar_content);
        this.f7775q = (TextView) this.f7777s.findViewById(R.id_renamed.tv_snack_bar_action);
        this.f7776r = (ImageView) this.f7777s.findViewById(R.id_renamed.iv_snack_bar_icon);
        f7763m = new ViewGroup.MarginLayoutParams(context, attributeSet).bottomMargin;
        setVisibility(8);
        this.f7782x = new RunnableC1428a(this, null);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUISnackBar, 0, 0);
        try {
            try {
                if (typedArrayObtainStyledAttributes.getString(R.styleable.COUISnackBar_defaultSnackBarContentText) != null) {
                    setContentText(typedArrayObtainStyledAttributes.getString(R.styleable.COUISnackBar_defaultSnackBarContentText));
                    setDuration(typedArrayObtainStyledAttributes.getInt(R.styleable.COUISnackBar_snackBarDisappearTime, 0));
                }
                setIconDrawable(typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUISnackBar_couiSnackBarIcon));
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("COUISnackBar", "Failure setting COUISnackBar " + COUIBaseListPopupWindow_8.getMessage());
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7440d() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f7777s, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(f7761c);
        objectAnimatorOfFloat.setDuration(180L);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.widget.COUISnackBar.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUISnackBar.this.f7777s.setVisibility(8);
                if (COUISnackBar.this.f7772n != null) {
                    COUISnackBar.this.f7772n.removeView(COUISnackBar.this.f7777s);
                }
                if (COUISnackBar.this.f7783y != null) {
                    COUISnackBar.this.f7783y.m7446a(COUISnackBar.this);
                }
            }
        });
        objectAnimatorOfFloat.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int mode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
        int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
        int maxWidth = getMaxWidth();
        if (maxWidth > 0 && mode != 0) {
            OplusGLSurfaceView_13 = View.MeasureSpec.makeMeasureSpec(Math.min(maxWidth, size), mode);
        }
        super.onMeasure(OplusGLSurfaceView_13, i2);
        this.f7778t = (int) this.f7774p.getPaint().measureText(this.f7781w);
        this.f7780v = (this.f7764e - (this.f7767h * 3)) - this.f7775q.getMeasuredWidth();
    }

    private int getMaxWidth() {
        int measuredWidth;
        ViewGroup viewGroup = this.f7772n;
        if (viewGroup == null || (measuredWidth = viewGroup.getMeasuredWidth()) == 0) {
            return 0;
        }
        return measuredWidth + (this.f7771l * 2);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        m7445b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m7445b() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f7774p.getLayoutParams();
        layoutParams.setMarginStart(m7438c() ? this.f7769j : this.f7767h);
        this.f7774p.setLayoutParams(layoutParams);
        if (m7441e()) {
            m7442f();
        } else {
            m7443g();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m7441e() {
        int measuredWidth;
        int measuredWidth2 = this.f7778t + this.f7775q.getMeasuredWidth();
        if (m7438c()) {
            measuredWidth = this.f7776r.getMeasuredWidth() + this.f7767h + (this.f7769j * 2);
        } else {
            measuredWidth = this.f7767h * 3;
        }
        if (measuredWidth2 + measuredWidth > this.f7773o.getMeasuredWidth() - (this.f7773o.getPaddingLeft() + this.f7773o.getPaddingRight())) {
            return true;
        }
        if (this.f7774p.getLineCount() > 1) {
            return true;
        }
        if (this.f7778t > this.f7780v) {
            return true;
        }
        return this.f7775q.getMeasuredWidth() >= this.f7765f;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m7442f() {
        if (m7438c()) {
            ((RelativeLayout.LayoutParams) this.f7776r.getLayoutParams()).topMargin = ((this.f7774p.getMeasuredHeight() - this.f7776r.getMeasuredHeight()) / 2) + this.f7766g;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f7775q.getLayoutParams();
        layoutParams.topMargin = this.f7766g + this.f7774p.getMeasuredHeight() + this.f7770k;
        layoutParams.bottomMargin = this.f7768i;
        this.f7775q.setLayoutParams(layoutParams);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m7443g() {
        int iM7432a = m7432a(this.f7774p);
        int iM7432a2 = m7432a(this.f7775q);
        int iMax = Math.max(iM7432a, iM7432a2);
        if (!m7438c()) {
            if (iM7432a > iM7432a2) {
                m7435a(this.f7775q, iM7432a);
                return;
            } else {
                m7435a(this.f7774p, iM7432a2);
                return;
            }
        }
        int iM7432a3 = m7432a(this.f7776r);
        int iMax2 = Math.max(iM7432a3, iMax);
        if (iMax2 == iM7432a3) {
            m7435a(this.f7774p, iM7432a3);
            m7435a(this.f7775q, iM7432a3);
        } else if (iMax2 == iM7432a) {
            m7435a(this.f7776r, iM7432a);
            m7435a(this.f7775q, iM7432a);
        } else {
            m7435a(this.f7776r, iM7432a2);
            m7435a(this.f7775q, iM7432a2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m7432a(View view) {
        if (view == null) {
            return 0;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7435a(View view, int OplusGLSurfaceView_13) {
        if (view == null || m7432a(view) == OplusGLSurfaceView_13) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        int measuredHeight = (OplusGLSurfaceView_13 - view.getMeasuredHeight()) / 2;
        view.offsetTopAndBottom(measuredHeight - layoutParams.topMargin);
        layoutParams.topMargin = measuredHeight;
        layoutParams.bottomMargin = measuredHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r4 = r4.getAction()
            r0 = 1
            if (r4 == 0) goto L2a
            if (r4 == r0) goto L10
            r1 = 2
            if (r4 == r1) goto L2a
            r1 = 3
            if (r4 == r1) goto L10
            goto L31
        L10:
            java.lang.Runnable r4 = r3.f7782x
            if (r4 == 0) goto L31
            int r4 = r3.getDuration()
            if (r4 == 0) goto L31
            java.lang.Runnable r4 = r3.f7782x
            r3.removeCallbacks(r4)
            java.lang.Runnable r4 = r3.f7782x
            int r1 = r3.getDuration()
            long r1 = (long) r1
            r3.postDelayed(r4, r1)
            goto L31
        L2a:
            java.lang.Runnable r4 = r3.f7782x
            if (r4 == 0) goto L31
            r3.removeCallbacks(r4)
        L31:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.COUISnackBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: com.coui.appcompat.widget.COUISnackBar$PlatformImplementations.kt_3 */
    private class RunnableC1428a implements Runnable {
        private RunnableC1428a() {
        }

        /* synthetic */ RunnableC1428a(COUISnackBar cOUISnackBar, ViewOnClickListenerC14261 viewOnClickListenerC14261) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            COUISnackBar.this.m7444a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f7782x);
        this.f7772n = null;
    }
}
