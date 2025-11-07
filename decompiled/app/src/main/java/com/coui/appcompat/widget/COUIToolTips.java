package com.coui.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.ViewGroupUtils_2;
import com.coui.appcompat.p099a.COUIChangeTextUtil;
import com.coui.appcompat.p099a.COUIDarkModeUtil;
import coui.support.appcompat.R;

/* compiled from: COUIToolTips.java */
/* renamed from: com.coui.appcompat.widget.s */
/* loaded from: classes.dex */
public class COUIToolTips extends PopupWindow {

    /* renamed from: A */
    private Rect f8649A;

    /* renamed from: B */
    private Rect f8650B;

    /* renamed from: C */
    private int f8651C;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Context f8652a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f8653b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private View f8654c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Rect f8655d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Rect f8656e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ViewGroup f8657f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ViewGroup f8658g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private TextView f8659h;

    /* renamed from: OplusGLSurfaceView_13 */
    private ScrollView f8660i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ImageView f8661j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f8662k;

    /* renamed from: OplusGLSurfaceView_14 */
    private View f8663l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Drawable f8664m;

    /* renamed from: OplusGLSurfaceView_11 */
    private Drawable f8665n;

    /* renamed from: o */
    private Drawable f8666o;

    /* renamed from: p */
    private Drawable f8667p;

    /* renamed from: q */
    private int f8668q;

    /* renamed from: r */
    private final int[] f8669r;

    /* renamed from: s */
    private int[] f8670s;

    /* renamed from: t */
    private final Point f8671t;

    /* renamed from: u */
    private float f8672u;

    /* renamed from: v */
    private float f8673v;

    /* renamed from: w */
    private Interpolator f8674w;

    /* renamed from: x */
    private boolean f8675x;

    /* renamed from: y */
    private View.OnLayoutChangeListener f8676y;

    /* renamed from: z */
    private PopupWindow.OnDismissListener f8677z;

    public COUIToolTips(Context context) {
        this(context, 0);
    }

    public COUIToolTips(Context context, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        this.f8655d = new Rect();
        this.f8662k = false;
        this.f8668q = 4;
        this.f8669r = new int[2];
        this.f8670s = new int[2];
        this.f8671t = new Point();
        this.f8676y = new View.OnLayoutChangeListener() { // from class: com.coui.appcompat.widget.s.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                Rect rect = new Rect(i2, i3, i4, i5);
                Rect rect2 = new Rect(i6, i7, i8, i9);
                if (!COUIToolTips.this.isShowing() || rect.equals(rect2) || COUIToolTips.this.f8663l == null) {
                    return;
                }
                COUIToolTips.this.m8130g();
            }
        };
        this.f8677z = new PopupWindow.OnDismissListener() { // from class: com.coui.appcompat.widget.s.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                COUIToolTips.this.f8657f.removeAllViews();
            }
        };
        this.f8652a = context;
        m8133a(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8133a(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        int i2;
        int i3;
        this.f8653b = OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_13 == 0) {
            i2 = R.attr.couiToolTipsStyle;
            i3 = R.style.COUIToolTips;
        } else {
            i2 = R.attr.couiToolTipsDetailFloatingStyle;
            i3 = R.style.COUIToolTips_DetailFloating;
        }
        TypedArray typedArrayObtainStyledAttributes = this.f8652a.obtainStyledAttributes(null, R.styleable.COUIToolTips, i2, i3);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUIToolTips_couiToolTipsBackground);
        drawable.setDither(true);
        this.f8664m = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUIToolTips_couiToolTipsArrowUpDrawable);
        this.f8665n = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUIToolTips_couiToolTipsArrowDownDrawable);
        this.f8666o = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUIToolTips_couiToolTipsArrowLeftDrawable);
        this.f8667p = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUIToolTips_couiToolTipsArrowRightDrawable);
        this.f8651C = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIToolTips_couiToolTipsArrowOverflowOffset, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIToolTips_couiToolTipsMinWidth, 0);
        int i4 = typedArrayObtainStyledAttributes.getInt(R.styleable.COUIToolTips_couiToolTipsContainerLayoutGravity, 0);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.f24489x8b001e88, 0);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIToolTips_couiToolTipsContainerLayoutMarginTop, 0);
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIToolTips_couiToolTipsContainerLayoutMarginEnd, 0);
        int dimensionPixelSize5 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.f24488xb7c384c5, 0);
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.COUIToolTips_couiToolTipsContentTextColor);
        int dimensionPixelSize6 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIToolTips_couiToolTipsViewportOffsetStart, 0);
        int dimensionPixelSize7 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIToolTips_couiToolTipsViewportOffsetTop, 0);
        int dimensionPixelSize8 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIToolTips_couiToolTipsViewportOffsetEnd, 0);
        int dimensionPixelSize9 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIToolTips_couiToolTipsViewportOffsetBottom, 0);
        final int dimensionPixelOffset = this.f8652a.getResources().getDimensionPixelOffset(R.dimen.couiToolTipsCancelButtonInsects);
        typedArrayObtainStyledAttributes.recycle();
        this.f8674w = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f8658g = (ViewGroup) LayoutInflater.from(this.f8652a).inflate(R.layout.coui_tool_tips_layout, (ViewGroup) null);
        this.f8658g.setBackground(drawable);
        this.f8658g.setMinimumWidth(dimensionPixelSize);
        this.f8657f = m8116a(this.f8652a);
        COUIDarkModeUtil.m6400a(this.f8657f, false);
        this.f8659h = (TextView) this.f8658g.findViewById(R.id_renamed.contentTv);
        this.f8660i = (ScrollView) this.f8658g.findViewById(R.id_renamed.scrollView);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f8660i.getLayoutParams();
        layoutParams.gravity = i4;
        layoutParams.setMargins(dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4, dimensionPixelSize5);
        layoutParams.setMarginStart(dimensionPixelSize2);
        layoutParams.setMarginEnd(dimensionPixelSize4);
        this.f8660i.setLayoutParams(layoutParams);
        this.f8659h.setTextSize(0, (int) COUIChangeTextUtil.m6388a(this.f8652a.getResources().getDimensionPixelSize(OplusGLSurfaceView_13 == 0 ? R.dimen.tool_tips_content_text_size : R.dimen.detail_floating_content_text_size), this.f8652a.getResources().getConfiguration().fontScale, 4));
        this.f8659h.setTextColor(colorStateList);
        final ImageView imageView = (ImageView) this.f8658g.findViewById(R.id_renamed.dismissIv);
        if (OplusGLSurfaceView_13 == 0) {
            imageView.setVisibility(0);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.widget.s.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    COUIToolTips.this.dismiss();
                }
            });
        } else {
            imageView.setVisibility(8);
        }
        imageView.post(new Runnable() { // from class: com.coui.appcompat.widget.s.4
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                ViewGroupUtils_2.m2247b(COUIToolTips.this.f8658g, imageView, rect);
                int i5 = dimensionPixelOffset;
                rect.inset(-i5, -i5);
                COUIToolTips.this.f8658g.setTouchDelegate(new TouchDelegate(rect, imageView));
            }
        });
        if (!m8140b(this.f8658g)) {
            this.f8656e = new Rect(dimensionPixelSize6, dimensionPixelSize7, dimensionPixelSize8, dimensionPixelSize9);
        } else {
            this.f8656e = new Rect(dimensionPixelSize8, dimensionPixelSize7, dimensionPixelSize6, dimensionPixelSize9);
        }
        setClippingEnabled(false);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setOnDismissListener(this.f8677z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static ViewGroup m8116a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        return frameLayout;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8134a(View view) {
        m8137a(view, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8137a(View view, boolean z) {
        m8136a(view, 4, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8135a(View view, int OplusGLSurfaceView_13) {
        m8136a(view, OplusGLSurfaceView_13, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8136a(View view, int OplusGLSurfaceView_13, boolean z) {
        if (isShowing()) {
            return;
        }
        this.f8668q = OplusGLSurfaceView_13;
        this.f8654c = view.getRootView();
        int i2 = this.f8668q;
        if (i2 == 32 || i2 == 64) {
            if (m8140b(view)) {
                this.f8668q = this.f8668q == 32 ? 8 : 16;
            } else {
                this.f8668q = this.f8668q != 32 ? 8 : 16;
            }
        }
        this.f8663l = view;
        this.f8654c.getWindowVisibleDisplayFrame(this.f8655d);
        m8131h();
        this.f8649A = new Rect();
        view.getGlobalVisibleRect(this.f8649A);
        this.f8650B = new Rect();
        this.f8654c.getGlobalVisibleRect(this.f8650B);
        int[] iArr = new int[2];
        this.f8654c.getLocationOnScreen(iArr);
        this.f8649A.offset(iArr[0], iArr[1]);
        this.f8650B.offset(iArr[0], iArr[1]);
        Rect rect = this.f8655d;
        rect.left = Math.max(rect.left, this.f8650B.left);
        Rect rect2 = this.f8655d;
        rect2.top = Math.max(rect2.top, this.f8650B.top);
        Rect rect3 = this.f8655d;
        rect3.right = Math.min(rect3.right, this.f8650B.right);
        Rect rect4 = this.f8655d;
        rect4.bottom = Math.min(rect4.bottom, this.f8650B.bottom);
        m8117a();
        m8122b(this.f8649A);
        m8119a(this.f8649A, z);
        setContentView(this.f8657f);
        m8127d();
        m8128e();
        showAtLocation(this.f8654c, 0, this.f8671t.x, this.f8671t.y);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8119a(Rect rect, boolean z) {
        this.f8657f.removeAllViews();
        this.f8657f.addView(this.f8658g);
        if (z) {
            m8118a(rect);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8117a() {
        int dimensionPixelSize = this.f8652a.getResources().getDimensionPixelSize(R.dimen.tool_tips_max_width) + this.f8658g.getPaddingLeft() + this.f8658g.getPaddingRight();
        int OplusGLSurfaceView_13 = this.f8668q;
        if (OplusGLSurfaceView_13 == 8) {
            dimensionPixelSize = Math.min(this.f8655d.right - this.f8649A.right, dimensionPixelSize);
        } else if (OplusGLSurfaceView_13 == 16) {
            dimensionPixelSize = Math.min(this.f8649A.left - this.f8655d.left, dimensionPixelSize);
        }
        int iMin = Math.min(this.f8655d.right - this.f8655d.left, dimensionPixelSize);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f8660i.getLayoutParams();
        this.f8659h.setMaxWidth((((iMin - this.f8658g.getPaddingLeft()) - this.f8658g.getPaddingRight()) - layoutParams.leftMargin) - layoutParams.rightMargin);
        this.f8658g.measure(0, 0);
        setWidth(Math.min(this.f8658g.getMeasuredWidth(), iMin));
        setHeight(this.f8658g.getMeasuredHeight());
        if ((this.f8649A.centerY() - (((m8124c() + this.f8658g.getPaddingTop()) - this.f8658g.getPaddingBottom()) / 2)) + m8124c() >= this.f8655d.bottom) {
            this.f8668q = 4;
            int iMin2 = Math.min(this.f8655d.right - this.f8655d.left, this.f8652a.getResources().getDimensionPixelSize(R.dimen.tool_tips_max_width) + this.f8658g.getPaddingLeft() + this.f8658g.getPaddingRight());
            this.f8659h.setMaxWidth((((iMin2 - this.f8658g.getPaddingLeft()) - this.f8658g.getPaddingRight()) - layoutParams.leftMargin) - layoutParams.rightMargin);
            this.f8658g.measure(0, 0);
            setWidth(Math.min(this.f8658g.getMeasuredWidth(), iMin2));
            setHeight(this.f8658g.getMeasuredHeight());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8118a(Rect rect) {
        this.f8661j = new ImageView(this.f8652a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int OplusGLSurfaceView_13 = this.f8668q;
        if (OplusGLSurfaceView_13 == 4 || OplusGLSurfaceView_13 == 128) {
            this.f8654c.getRootView().getLocationOnScreen(this.f8669r);
            int i2 = this.f8669r[0];
            this.f8654c.getRootView().getLocationInWindow(this.f8669r);
            layoutParams.leftMargin = ((rect.centerX() - this.f8671t.x) - (i2 - this.f8669r[0])) - (this.f8664m.getIntrinsicWidth() / 2);
            layoutParams.rightMargin = (getWidth() - layoutParams.leftMargin) - this.f8664m.getIntrinsicWidth();
            if (this.f8671t.y >= rect.top - this.f8670s[1]) {
                this.f8661j.setBackground(this.f8664m);
                this.f8662k = true;
                layoutParams.topMargin = (this.f8658g.getPaddingTop() - this.f8664m.getIntrinsicHeight()) + this.f8651C;
            } else {
                this.f8661j.setBackground(this.f8665n);
                layoutParams.gravity = 80;
                layoutParams.bottomMargin = (this.f8658g.getPaddingBottom() - this.f8665n.getIntrinsicHeight()) + this.f8651C;
            }
        } else if (OplusGLSurfaceView_13 == 16) {
            this.f8662k = true;
            layoutParams.rightMargin = (this.f8658g.getPaddingRight() - this.f8667p.getIntrinsicWidth()) + this.f8651C;
            layoutParams.leftMargin = (getWidth() - layoutParams.rightMargin) - this.f8667p.getIntrinsicWidth();
            layoutParams.topMargin = ((rect.centerY() - this.f8671t.y) - this.f8670s[1]) - (this.f8667p.getIntrinsicHeight() / 2);
            layoutParams.bottomMargin = (getHeight() - layoutParams.topMargin) - this.f8667p.getIntrinsicHeight();
            this.f8661j.setBackground(this.f8667p);
        } else {
            layoutParams.leftMargin = (this.f8658g.getPaddingLeft() - this.f8666o.getIntrinsicWidth()) + this.f8651C;
            layoutParams.rightMargin = (getWidth() - layoutParams.leftMargin) - this.f8666o.getIntrinsicWidth();
            layoutParams.topMargin = ((rect.centerY() - this.f8671t.y) - this.f8670s[1]) - (this.f8667p.getIntrinsicHeight() / 2);
            layoutParams.bottomMargin = (getHeight() - layoutParams.topMargin) - this.f8667p.getIntrinsicHeight();
            this.f8661j.setBackground(this.f8666o);
        }
        this.f8657f.addView(this.f8661j, layoutParams);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m8122b(Rect rect) {
        int iM8121b;
        int iCenterY;
        int iM8124c;
        int OplusGLSurfaceView_13;
        int i2 = this.f8668q;
        if (i2 == 4) {
            iM8121b = Math.min(rect.centerX() - (m8121b() / 2), this.f8655d.right - m8121b());
            int i3 = rect.top - this.f8655d.top;
            int i4 = this.f8655d.bottom - rect.bottom;
            iM8124c = m8124c();
            if (i3 >= iM8124c) {
                OplusGLSurfaceView_13 = rect.top;
                iCenterY = OplusGLSurfaceView_13 - iM8124c;
            } else if (i4 >= iM8124c) {
                iCenterY = rect.bottom;
            } else if (i3 > i4) {
                iCenterY = this.f8655d.top;
                setHeight(i3);
            } else {
                iCenterY = rect.bottom;
                setHeight(i4);
            }
        } else if (i2 == 128) {
            iM8121b = Math.min(rect.centerX() - (m8121b() / 2), this.f8655d.right - m8121b());
            int i5 = rect.top - this.f8655d.top;
            int i6 = this.f8655d.bottom - rect.bottom;
            iM8124c = m8124c();
            if (i6 >= iM8124c) {
                iCenterY = rect.bottom;
            } else if (i5 >= iM8124c) {
                OplusGLSurfaceView_13 = rect.top;
                iCenterY = OplusGLSurfaceView_13 - iM8124c;
            } else if (i5 > i6) {
                iCenterY = this.f8655d.top;
                setHeight(i5);
            } else {
                iCenterY = rect.bottom;
                setHeight(i6);
            }
        } else {
            iM8121b = i2 == 16 ? rect.left - m8121b() : rect.right;
            iCenterY = rect.centerY() - (((m8124c() + this.f8658g.getPaddingTop()) - this.f8658g.getPaddingBottom()) / 2);
        }
        this.f8654c.getRootView().getLocationOnScreen(this.f8669r);
        int[] iArr = this.f8669r;
        int i7 = iArr[0];
        int i8 = iArr[1];
        this.f8654c.getRootView().getLocationInWindow(this.f8669r);
        int[] iArr2 = this.f8669r;
        int i9 = iArr2[0];
        int i10 = iArr2[1];
        int[] iArr3 = this.f8670s;
        iArr3[0] = i7 - i9;
        iArr3[1] = i8 - i10;
        this.f8671t.set(Math.max(0, (iM8121b - iArr3[0]) - this.f8656e.left), Math.max(0, (iCenterY - this.f8670s[1]) - this.f8656e.top));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m8121b() {
        return (getWidth() - this.f8656e.left) + this.f8656e.right;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int m8124c() {
        return (getHeight() - this.f8656e.top) + this.f8656e.bottom;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8138a(CharSequence charSequence) {
        this.f8659h.setText(charSequence);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m8127d() {
        int OplusGLSurfaceView_13 = this.f8668q;
        if (OplusGLSurfaceView_13 == 4) {
            if ((this.f8649A.centerX() - this.f8670s[0]) - this.f8671t.x >= m8121b()) {
                this.f8672u = 1.0f;
            } else if (m8121b() != 0) {
                int iCenterX = (this.f8649A.centerX() - this.f8670s[0]) - this.f8671t.x;
                if (iCenterX <= 0) {
                    iCenterX = -iCenterX;
                }
                this.f8672u = iCenterX / m8121b();
            } else {
                this.f8672u = 0.5f;
            }
            if (this.f8671t.y >= this.f8649A.top - this.f8670s[1]) {
                this.f8673v = 0.0f;
                return;
            } else {
                this.f8673v = 1.0f;
                return;
            }
        }
        this.f8672u = OplusGLSurfaceView_13 == 16 ? 1.0f : 0.0f;
        this.f8673v = ((this.f8649A.centerY() - this.f8671t.y) - this.f8670s[1]) / m8124c();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m8128e() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, this.f8672u, 1, this.f8673v);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setInterpolator(this.f8674w);
        animationSet.setDuration(300L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.coui.appcompat.widget.s.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f8657f.startAnimation(animationSet);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m8129f() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, this.f8672u, 1, this.f8673v);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(300L);
        animationSet.setInterpolator(this.f8674w);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.coui.appcompat.widget.s.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                COUIToolTips.this.f8675x = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                COUIToolTips.this.m8130g();
                COUIToolTips.this.f8675x = false;
            }
        });
        this.f8657f.startAnimation(animationSet);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (!this.f8675x) {
            m8129f();
        } else {
            m8130g();
            this.f8675x = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m8130g() {
        super.dismiss();
        m8132i();
        this.f8657f.removeAllViews();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8139a(boolean z) {
        if (z) {
            setTouchable(true);
            setFocusable(true);
            setOutsideTouchable(true);
        } else {
            setFocusable(false);
            setOutsideTouchable(false);
        }
        update();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m8131h() {
        m8132i();
        this.f8654c.addOnLayoutChangeListener(this.f8676y);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m8132i() {
        this.f8654c.removeOnLayoutChangeListener(this.f8676y);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m8140b(View view) {
        return view.getLayoutDirection() == 1;
    }
}
