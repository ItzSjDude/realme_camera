package com.coui.appcompat.widget.popupwindow;

/* compiled from: COUIBasePopupWindow.java */
/* loaded from: classes.dex */
public class b_renamed extends android.widget.PopupWindow {
    private static final int[] R_renamed = {android.R_renamed.attr.state_above_anchor};
    private int A_renamed;
    private int B_renamed;
    private int C_renamed;
    private float D_renamed;
    private int[] E_renamed;
    private int[] F_renamed;
    private android.graphics.Rect G_renamed;
    private android.graphics.drawable.Drawable H_renamed;
    private android.graphics.drawable.Drawable I_renamed;
    private android.graphics.drawable.Drawable J_renamed;
    private int K_renamed;
    private int L_renamed;
    private boolean M_renamed;
    private int N_renamed;
    private com.coui.appcompat.widget.popupwindow.b_renamed.a_renamed O_renamed;
    private boolean P_renamed;
    private int Q_renamed;
    private java.lang.ref.WeakReference<android.view.View> S_renamed;
    private final android.view.ViewTreeObserver.OnScrollChangedListener T_renamed;
    private int U_renamed;
    private int V_renamed;
    private int W_renamed;
    private boolean X_renamed;
    private boolean Y_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f3054a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.view.WindowManager f3055b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f3056c;
    private boolean d_renamed;
    private android.view.View e_renamed;
    private android.view.View f_renamed;
    private boolean g_renamed;
    private int h_renamed;
    private int i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private boolean l_renamed;
    private int m_renamed;
    private boolean n_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private boolean q_renamed;
    private boolean r_renamed;
    private boolean s_renamed;
    private boolean t_renamed;
    private android.view.View.OnTouchListener u_renamed;
    private int v_renamed;
    private int w_renamed;
    private int x_renamed;
    private int y_renamed;
    private int z_renamed;

    /* compiled from: COUIBasePopupWindow.java */
    public interface a_renamed {
        void a_renamed();
    }

    public b_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        this.h_renamed = 0;
        this.i_renamed = 1;
        this.j_renamed = true;
        this.k_renamed = false;
        this.l_renamed = true;
        this.m_renamed = -1;
        this.p_renamed = true;
        this.q_renamed = false;
        this.s_renamed = true;
        this.t_renamed = false;
        this.E_renamed = new int[2];
        this.F_renamed = new int[2];
        this.G_renamed = new android.graphics.Rect();
        this.N_renamed = 1000;
        this.P_renamed = false;
        this.Q_renamed = -1;
        this.T_renamed = new android.view.ViewTreeObserver.OnScrollChangedListener() { // from class: com.coui.appcompat.widget.popupwindow.b_renamed.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                android.view.View view = com.coui.appcompat.widget.popupwindow.b_renamed.this.S_renamed != null ? (android.view.View) com.coui.appcompat.widget.popupwindow.b_renamed.this.S_renamed.get() : null;
                if (view == null || com.coui.appcompat.widget.popupwindow.b_renamed.this.f_renamed == null) {
                    return;
                }
                android.view.WindowManager.LayoutParams layoutParams = (android.view.WindowManager.LayoutParams) com.coui.appcompat.widget.popupwindow.b_renamed.this.f_renamed.getLayoutParams();
                com.coui.appcompat.widget.popupwindow.b_renamed bVar = com.coui.appcompat.widget.popupwindow.b_renamed.this;
                bVar.a_renamed(bVar.a_renamed(view, layoutParams, bVar.U_renamed, com.coui.appcompat.widget.popupwindow.b_renamed.this.V_renamed, com.coui.appcompat.widget.popupwindow.b_renamed.this.W_renamed));
                com.coui.appcompat.widget.popupwindow.b_renamed.this.update(layoutParams.x_renamed, layoutParams.y_renamed, -1, -1, true);
            }
        };
        this.f3054a = context;
        this.f3055b = (android.view.WindowManager) context.getSystemService("window");
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.PopupWindow, i_renamed, i2);
        android.content.res.TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.PopupWindowCompat, i_renamed, i2);
        android.graphics.drawable.Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.PopupWindow_android_popupBackground);
        this.D_renamed = typedArrayObtainStyledAttributes2.getDimension(coui.support.appcompat.R_renamed.styleable.PopupWindowCompat_supportPopupElevation, 0.0f);
        this.X_renamed = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R_renamed.styleable.PopupWindow_overlapAnchor, false);
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(coui.support.appcompat.R_renamed.styleable.PopupWindowCompat_android_popupAnimationStyle, -1);
        this.Q_renamed = resourceId == coui.support.appcompat.R_renamed.style.Animation_COUI_PopupWindow ? -1 : resourceId;
        typedArrayObtainStyledAttributes2.recycle();
        typedArrayObtainStyledAttributes.recycle();
        setBackgroundDrawable(drawable);
    }

    public b_renamed() {
        this(null, 0, 0);
    }

    public b_renamed(android.view.View view, int i_renamed, int i2) {
        this(view, i_renamed, i2, false);
    }

    public b_renamed(android.view.View view, int i_renamed, int i2, boolean z_renamed) {
        this.h_renamed = 0;
        this.i_renamed = 1;
        this.j_renamed = true;
        this.k_renamed = false;
        this.l_renamed = true;
        this.m_renamed = -1;
        this.p_renamed = true;
        this.q_renamed = false;
        this.s_renamed = true;
        this.t_renamed = false;
        this.E_renamed = new int[2];
        this.F_renamed = new int[2];
        this.G_renamed = new android.graphics.Rect();
        this.N_renamed = 1000;
        this.P_renamed = false;
        this.Q_renamed = -1;
        this.T_renamed = new android.view.ViewTreeObserver.OnScrollChangedListener() { // from class: com.coui.appcompat.widget.popupwindow.b_renamed.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                android.view.View view2 = com.coui.appcompat.widget.popupwindow.b_renamed.this.S_renamed != null ? (android.view.View) com.coui.appcompat.widget.popupwindow.b_renamed.this.S_renamed.get() : null;
                if (view2 == null || com.coui.appcompat.widget.popupwindow.b_renamed.this.f_renamed == null) {
                    return;
                }
                android.view.WindowManager.LayoutParams layoutParams = (android.view.WindowManager.LayoutParams) com.coui.appcompat.widget.popupwindow.b_renamed.this.f_renamed.getLayoutParams();
                com.coui.appcompat.widget.popupwindow.b_renamed bVar = com.coui.appcompat.widget.popupwindow.b_renamed.this;
                bVar.a_renamed(bVar.a_renamed(view2, layoutParams, bVar.U_renamed, com.coui.appcompat.widget.popupwindow.b_renamed.this.V_renamed, com.coui.appcompat.widget.popupwindow.b_renamed.this.W_renamed));
                com.coui.appcompat.widget.popupwindow.b_renamed.this.update(layoutParams.x_renamed, layoutParams.y_renamed, -1, -1, true);
            }
        };
        if (view != null) {
            this.f3054a = view.getContext();
            this.f3055b = (android.view.WindowManager) this.f3054a.getSystemService("window");
        }
        setContentView(view);
        setWidth(i_renamed);
        setHeight(i2);
        setFocusable(z_renamed);
    }

    @Override // android.widget.PopupWindow
    public android.graphics.drawable.Drawable getBackground() {
        return this.H_renamed;
    }

    @Override // android.widget.PopupWindow
    public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        this.H_renamed = drawable;
        if (this.H_renamed instanceof android.graphics.drawable.StateListDrawable) {
            this.J_renamed = null;
            this.I_renamed = null;
        }
    }

    @Override // android.widget.PopupWindow
    public float getElevation() {
        return this.D_renamed;
    }

    @Override // android.widget.PopupWindow
    public void setElevation(float f_renamed) {
        this.D_renamed = f_renamed;
    }

    @Override // android.widget.PopupWindow
    public int getAnimationStyle() {
        return this.Q_renamed;
    }

    @Override // android.widget.PopupWindow
    public void setIgnoreCheekPress() {
        this.P_renamed = true;
    }

    @Override // android.widget.PopupWindow
    public void setAnimationStyle(int i_renamed) {
        this.Q_renamed = i_renamed;
    }

    @Override // android.widget.PopupWindow
    public android.view.View getContentView() {
        return this.e_renamed;
    }

    @Override // android.widget.PopupWindow
    public void setContentView(android.view.View view) {
        android.view.View view2;
        if (isShowing()) {
            return;
        }
        this.e_renamed = view;
        if (this.f3054a == null && (view2 = this.e_renamed) != null) {
            this.f3054a = view2.getContext();
        }
        if (this.f3055b == null && this.e_renamed != null) {
            this.f3055b = (android.view.WindowManager) this.f3054a.getSystemService("window");
        }
        android.content.Context context = this.f3054a;
        if (context == null || this.t_renamed) {
            return;
        }
        setAttachedInDecor(context.getApplicationInfo().targetSdkVersion >= 22);
    }

    @Override // android.widget.PopupWindow
    public void setTouchInterceptor(android.view.View.OnTouchListener onTouchListener) {
        this.u_renamed = onTouchListener;
    }

    @Override // android.widget.PopupWindow
    public boolean isFocusable() {
        return this.g_renamed;
    }

    @Override // android.widget.PopupWindow
    public void setFocusable(boolean z_renamed) {
        this.g_renamed = z_renamed;
    }

    @Override // android.widget.PopupWindow
    public int getInputMethodMode() {
        return this.h_renamed;
    }

    @Override // android.widget.PopupWindow
    public void setInputMethodMode(int i_renamed) {
        this.h_renamed = i_renamed;
    }

    @Override // android.widget.PopupWindow
    public void setSoftInputMode(int i_renamed) {
        this.i_renamed = i_renamed;
    }

    @Override // android.widget.PopupWindow
    public int getSoftInputMode() {
        return this.i_renamed;
    }

    @Override // android.widget.PopupWindow
    public boolean isTouchable() {
        return this.j_renamed;
    }

    @Override // android.widget.PopupWindow
    public void setTouchable(boolean z_renamed) {
        this.j_renamed = z_renamed;
    }

    @Override // android.widget.PopupWindow
    public boolean isOutsideTouchable() {
        return this.k_renamed;
    }

    @Override // android.widget.PopupWindow
    public void setOutsideTouchable(boolean z_renamed) {
        this.k_renamed = z_renamed;
    }

    @Override // android.widget.PopupWindow
    public boolean isClippingEnabled() {
        return this.l_renamed;
    }

    @Override // android.widget.PopupWindow
    public void setClippingEnabled(boolean z_renamed) {
        this.l_renamed = z_renamed;
    }

    public void setClipToScreenEnabled(boolean z_renamed) {
        this.o_renamed = z_renamed;
        setClippingEnabled(!z_renamed);
    }

    @Override // android.widget.PopupWindow
    public boolean isSplitTouchEnabled() {
        android.content.Context context;
        return (this.m_renamed >= 0 || (context = this.f3054a) == null) ? this.m_renamed == 1 : context.getApplicationInfo().targetSdkVersion >= 11;
    }

    @Override // android.widget.PopupWindow
    public void setSplitTouchEnabled(boolean z_renamed) {
        this.m_renamed = z_renamed ? 1 : 0;
    }

    public boolean isLayoutInScreenEnabled() {
        return this.n_renamed;
    }

    public void setLayoutInScreenEnabled(boolean z_renamed) {
        this.n_renamed = z_renamed;
    }

    @Override // android.widget.PopupWindow
    public boolean isAttachedInDecor() {
        return this.s_renamed;
    }

    @Override // android.widget.PopupWindow
    public void setAttachedInDecor(boolean z_renamed) {
        this.s_renamed = z_renamed;
        this.t_renamed = true;
    }

    public void setLayoutInsetDecor(boolean z_renamed) {
        this.q_renamed = z_renamed;
    }

    @Override // android.widget.PopupWindow
    public void setWindowLayoutType(int i_renamed) {
        this.N_renamed = i_renamed;
    }

    @Override // android.widget.PopupWindow
    public int getWindowLayoutType() {
        return this.N_renamed;
    }

    @Override // android.widget.PopupWindow
    public void setTouchModal(boolean z_renamed) {
        this.r_renamed = !z_renamed;
    }

    @Override // android.widget.PopupWindow
    public void setWindowLayoutMode(int i_renamed, int i2) {
        this.v_renamed = i_renamed;
        this.y_renamed = i2;
    }

    @Override // android.widget.PopupWindow
    public int getHeight() {
        return this.z_renamed;
    }

    @Override // android.widget.PopupWindow
    public void setHeight(int i_renamed) {
        this.z_renamed = i_renamed;
    }

    @Override // android.widget.PopupWindow
    public int getWidth() {
        return this.w_renamed;
    }

    @Override // android.widget.PopupWindow
    public void setWidth(int i_renamed) {
        this.w_renamed = i_renamed;
    }

    @Override // android.widget.PopupWindow
    public boolean isShowing() {
        return this.f3056c;
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(android.view.View view, int i_renamed, int i2, int i3) {
        showAtLocation(view.getWindowToken(), i_renamed, i2, i3);
    }

    public void showAtLocation(android.os.IBinder iBinder, int i_renamed, int i2, int i3) {
        if (isShowing() || this.e_renamed == null) {
            return;
        }
        d_renamed();
        this.f3056c = true;
        this.d_renamed = false;
        android.view.WindowManager.LayoutParams layoutParamsA = a_renamed(iBinder);
        layoutParamsA.windowAnimations = c_renamed();
        b_renamed(layoutParamsA);
        if (i_renamed == 0) {
            i_renamed = com.google.android.material.badge.BadgeDrawable.TOP_START;
        }
        layoutParamsA.gravity = i_renamed;
        layoutParamsA.x_renamed = i2;
        layoutParamsA.y_renamed = i3;
        int i4 = this.y_renamed;
        if (i4 < 0) {
            this.A_renamed = i4;
            layoutParamsA.height = i4;
        }
        int i5 = this.v_renamed;
        if (i5 < 0) {
            this.x_renamed = i5;
            layoutParamsA.width = i5;
        }
        a_renamed(layoutParamsA);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(android.view.View view) {
        showAsDropDown(view, 0, 0);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(android.view.View view, int i_renamed, int i2) {
        showAsDropDown(view, i_renamed, i2, com.google.android.material.badge.BadgeDrawable.TOP_START);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(android.view.View view, int i_renamed, int i2, int i3) {
        if (isShowing() || this.e_renamed == null) {
            return;
        }
        a_renamed(view, i_renamed, i2, i3);
        this.f3056c = true;
        this.d_renamed = true;
        android.view.WindowManager.LayoutParams layoutParamsA = a_renamed(view.getWindowToken());
        b_renamed(layoutParamsA);
        a_renamed(a_renamed(view, layoutParamsA, i_renamed, i2, i3));
        int i4 = this.y_renamed;
        if (i4 < 0) {
            this.A_renamed = i4;
            layoutParamsA.height = i4;
        }
        int i5 = this.v_renamed;
        if (i5 < 0) {
            this.x_renamed = i5;
            layoutParamsA.width = i5;
        }
        layoutParamsA.windowAnimations = c_renamed();
        a_renamed(layoutParamsA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed) {
        if (z_renamed != this.M_renamed) {
            this.M_renamed = z_renamed;
            if (this.H_renamed != null) {
                android.graphics.drawable.Drawable drawable = this.I_renamed;
                if (drawable != null) {
                    if (this.M_renamed) {
                        this.f_renamed.setBackgroundDrawable(drawable);
                        return;
                    } else {
                        this.f_renamed.setBackgroundDrawable(this.J_renamed);
                        return;
                    }
                }
                this.f_renamed.refreshDrawableState();
            }
        }
    }

    @Override // android.widget.PopupWindow
    public boolean isAboveAnchor() {
        return this.M_renamed;
    }

    private void b_renamed(android.view.WindowManager.LayoutParams layoutParams) {
        android.view.View view = this.e_renamed;
        if (view == null || this.f3054a == null || this.f3055b == null) {
            throw new java.lang.IllegalStateException("You must specify a_renamed valid content view by_renamed calling setContentView() before attempting to show the popup.");
        }
        if (this.H_renamed != null) {
            android.view.ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            int i_renamed = (layoutParams2 == null || layoutParams2.height != -2) ? -1 : -2;
            com.coui.appcompat.widget.popupwindow.b_renamed.COUIBasePopupWindow_3 c0063b = new com.coui.appcompat.widget.popupwindow.b_renamed.COUIBasePopupWindow_3(this.f3054a);
            android.widget.FrameLayout.LayoutParams layoutParams3 = new android.widget.FrameLayout.LayoutParams(-1, i_renamed);
            c0063b.setBackgroundDrawable(this.H_renamed);
            c0063b.addView(this.e_renamed, layoutParams3);
            this.f_renamed = c0063b;
        } else {
            this.f_renamed = view;
        }
        androidx.core.h_renamed.v_renamed.a_renamed(this.f_renamed, this.D_renamed);
        this.Y_renamed = com.coui.appcompat.widget.t_renamed.b_renamed(this.f_renamed) == 2;
        this.B_renamed = layoutParams.width;
        this.C_renamed = layoutParams.height;
    }

    void a_renamed(android.view.WindowManager.LayoutParams layoutParams) {
        android.content.Context context = this.f3054a;
        if (context != null) {
            layoutParams.packageName = context.getPackageName();
        }
        this.f_renamed.setFitsSystemWindows(this.q_renamed);
        b_renamed();
        this.f3055b.addView(this.f_renamed, layoutParams);
    }

    @android.annotation.SuppressLint({"NewApi"})
    private void b_renamed() {
        android.view.View view;
        java.lang.ref.WeakReference<android.view.View> weakReference = this.S_renamed;
        if (weakReference == null || (view = weakReference.get()) == null || !this.Y_renamed) {
            return;
        }
        this.f_renamed.setLayoutDirection(view.getLayoutDirection());
    }

    private android.view.WindowManager.LayoutParams a_renamed(android.os.IBinder iBinder) {
        android.view.WindowManager.LayoutParams layoutParams = new android.view.WindowManager.LayoutParams();
        layoutParams.gravity = com.google.android.material.badge.BadgeDrawable.TOP_START;
        int i_renamed = this.w_renamed;
        this.x_renamed = i_renamed;
        layoutParams.width = i_renamed;
        int i2 = this.z_renamed;
        this.A_renamed = i2;
        layoutParams.height = i2;
        android.graphics.drawable.Drawable drawable = this.H_renamed;
        if (drawable != null) {
            layoutParams.format = drawable.getOpacity();
        } else {
            layoutParams.format = -3;
        }
        layoutParams.flags = a_renamed(layoutParams.flags);
        layoutParams.type = this.N_renamed;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = this.i_renamed;
        layoutParams.setTitle("PopupWindow:" + java.lang.Integer.toHexString(hashCode()));
        return layoutParams;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:12:0x001f A_renamed[PHI: r4
      0x001f: PHI (r4v3 int) = (r4v2 int), (r4v21 int) binds: [B_renamed:11:0x001d, B_renamed:8:0x0017] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int a_renamed(int r4) {
        /*
            r3 = this;
            r0 = -8815129(0xffffffffff797de7, float:-3.316315E38)
            r4 = r4 & r0
            boolean r0 = r3.P_renamed
            if (r0 == 0) goto Lc
            r0 = 32768(0x8000, float:4.5918E-41)
            r4 = r4 | r0
        Lc:
            boolean r0 = r3.g_renamed
            r1 = 131072(0x20000, float:1.83671E-40)
            if (r0 != 0) goto L1a
            r4 = r4 | 8
            int r0 = r3.h_renamed
            r2 = 1
            if (r0 != r2) goto L20
            goto L1f
        L1a:
            int r0 = r3.h_renamed
            r2 = 2
            if (r0 != r2) goto L20
        L1f:
            r4 = r4 | r1
        L20:
            boolean r0 = r3.j_renamed
            if (r0 != 0) goto L26
            r4 = r4 | 16
        L26:
            boolean r0 = r3.k_renamed
            if (r0 == 0) goto L2d
            r0 = 262144(0x40000, float:3.67342E-40)
            r4 = r4 | r0
        L2d:
            boolean r0 = r3.l_renamed
            if (r0 != 0) goto L33
            r4 = r4 | 512(0x200, float:7.175E-43)
        L33:
            boolean r0 = r3.isSplitTouchEnabled()
            if (r0 == 0) goto L3c
            r0 = 8388608(0x800000, float:1.17549435E-38)
            r4 = r4 | r0
        L3c:
            boolean r0 = r3.n_renamed
            if (r0 == 0) goto L42
            r4 = r4 | 256(0x100, float:3.59E-43)
        L42:
            boolean r0 = r3.q_renamed
            if (r0 == 0) goto L49
            r0 = 65536(0x10000, float:9.18355E-41)
            r4 = r4 | r0
        L49:
            boolean r0 = r3.r_renamed
            if (r0 == 0) goto L4f
            r4 = r4 | 32
        L4f:
            boolean r3 = r3.s_renamed
            if (r3 == 0) goto L56
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = r4 | r3
        L56:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.popupwindow.b_renamed.a_renamed(int):int");
    }

    private int c_renamed() {
        int i_renamed = this.Q_renamed;
        if (i_renamed != -1) {
            return i_renamed;
        }
        if (this.d_renamed) {
            return this.M_renamed ? coui.support.appcompat.R_renamed.style.Animation_COUI_DropDownUp : coui.support.appcompat.R_renamed.style.Animation_COUI_DropDownDown;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @android.annotation.SuppressLint({"NewApi"})
    public boolean a_renamed(android.view.View view, android.view.WindowManager.LayoutParams layoutParams, int i_renamed, int i2, int i3) {
        boolean z_renamed;
        int height = view.getHeight();
        int width = view.getWidth();
        int i4 = this.X_renamed ? i2 - height : i2;
        view.getLocationInWindow(this.E_renamed);
        int[] iArr = this.E_renamed;
        layoutParams.x_renamed = iArr[0] + i_renamed;
        layoutParams.y_renamed = iArr[1] + height + i4;
        int absoluteGravity = android.view.Gravity.getAbsoluteGravity(i3, view.getLayoutDirection()) & 7;
        if (absoluteGravity == 5) {
            layoutParams.x_renamed -= this.B_renamed - width;
        }
        layoutParams.gravity = 51;
        view.getLocationOnScreen(this.F_renamed);
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i5 = this.F_renamed[1] + height + i4;
        android.view.View rootView = view.getRootView();
        if (i5 + this.C_renamed > rect.bottom || (layoutParams.x_renamed + this.B_renamed) - rootView.getWidth() > 0) {
            if (this.p_renamed) {
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                view.requestRectangleOnScreen(new android.graphics.Rect(scrollX, scrollY, this.B_renamed + scrollX + i_renamed, this.C_renamed + scrollY + height + i4), true);
            }
            view.getLocationInWindow(this.E_renamed);
            int[] iArr2 = this.E_renamed;
            layoutParams.x_renamed = iArr2[0] + i_renamed;
            layoutParams.y_renamed = iArr2[1] + height + i4;
            if (absoluteGravity == 5) {
                layoutParams.x_renamed -= this.B_renamed - width;
            }
            view.getLocationOnScreen(this.F_renamed);
            int i6 = rect.bottom;
            int[] iArr3 = this.F_renamed;
            z_renamed = ((i6 - iArr3[1]) - height) - i4 < (iArr3[1] - i4) - rect.top;
            if (z_renamed) {
                layoutParams.gravity = 83;
                layoutParams.y_renamed = (rootView.getHeight() - this.E_renamed[1]) + i4;
            } else {
                layoutParams.y_renamed = this.E_renamed[1] + height + i4;
            }
        } else {
            z_renamed = false;
        }
        if (this.o_renamed) {
            int i7 = rect.right - rect.left;
            int i8 = layoutParams.x_renamed + layoutParams.width;
            if (i8 > i7) {
                layoutParams.x_renamed -= i8 - i7;
            }
            if (layoutParams.x_renamed < rect.left) {
                layoutParams.x_renamed = rect.left;
                layoutParams.width = java.lang.Math.min(layoutParams.width, i7);
            }
            if (z_renamed) {
                int i9 = (this.F_renamed[1] + i4) - this.C_renamed;
                if (i9 < 0) {
                    layoutParams.y_renamed += i9;
                }
            } else {
                layoutParams.y_renamed = java.lang.Math.max(layoutParams.y_renamed, rect.top);
            }
        }
        layoutParams.gravity |= com.google.android.exoplayer2.C_renamed.ENCODING_PCM_MU_LAW;
        this.K_renamed = (this.E_renamed[0] - layoutParams.x_renamed) + (height / 2);
        this.L_renamed = (this.E_renamed[1] - layoutParams.y_renamed) + (width / 2);
        return z_renamed;
    }

    @Override // android.widget.PopupWindow
    public int getMaxAvailableHeight(android.view.View view) {
        return getMaxAvailableHeight(view, 0);
    }

    @Override // android.widget.PopupWindow
    public int getMaxAvailableHeight(android.view.View view, int i_renamed) {
        return getMaxAvailableHeight(view, i_renamed, false);
    }

    @Override // android.widget.PopupWindow
    public int getMaxAvailableHeight(android.view.View view, int i_renamed, boolean z_renamed) {
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int[] iArr = this.E_renamed;
        view.getLocationOnScreen(iArr);
        int i2 = rect.bottom;
        if (z_renamed) {
            i2 = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int iMax = java.lang.Math.max((i2 - (iArr[1] + view.getHeight())) - i_renamed, (iArr[1] - rect.top) + i_renamed);
        android.graphics.drawable.Drawable drawable = this.H_renamed;
        if (drawable == null) {
            return iMax;
        }
        drawable.getPadding(this.G_renamed);
        return iMax - (this.G_renamed.top + this.G_renamed.bottom);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (!isShowing() || this.f_renamed == null) {
            return;
        }
        this.f3056c = false;
        d_renamed();
        try {
            this.f3055b.removeViewImmediate(this.f_renamed);
        } finally {
            android.view.View view = this.f_renamed;
            android.view.View view2 = this.e_renamed;
            if (view != view2 && (view instanceof android.view.ViewGroup)) {
                ((android.view.ViewGroup) view).removeView(view2);
            }
            this.f_renamed = null;
            com.coui.appcompat.widget.popupwindow.b_renamed.a_renamed aVar = this.O_renamed;
            if (aVar != null) {
                aVar.a_renamed();
            }
        }
    }

    public void a_renamed(com.coui.appcompat.widget.popupwindow.b_renamed.a_renamed aVar) {
        this.O_renamed = aVar;
    }

    @Override // android.widget.PopupWindow
    public void update() {
        if (!isShowing() || this.e_renamed == null) {
            return;
        }
        android.view.WindowManager.LayoutParams layoutParams = (android.view.WindowManager.LayoutParams) this.f_renamed.getLayoutParams();
        boolean z_renamed = false;
        int iC = c_renamed();
        if (iC != layoutParams.windowAnimations) {
            layoutParams.windowAnimations = iC;
            z_renamed = true;
        }
        int iA = a_renamed(layoutParams.flags);
        if (iA != layoutParams.flags) {
            layoutParams.flags = iA;
            z_renamed = true;
        }
        if (z_renamed) {
            b_renamed();
            this.f3055b.updateViewLayout(this.f_renamed, layoutParams);
        }
    }

    @Override // android.widget.PopupWindow
    public void update(int i_renamed, int i2) {
        android.view.WindowManager.LayoutParams layoutParams = (android.view.WindowManager.LayoutParams) this.f_renamed.getLayoutParams();
        update(layoutParams.x_renamed, layoutParams.y_renamed, i_renamed, i2, false);
    }

    @Override // android.widget.PopupWindow
    public void update(int i_renamed, int i2, int i3, int i4) {
        update(i_renamed, i2, i3, i4, false);
    }

    @Override // android.widget.PopupWindow
    public void update(int i_renamed, int i2, int i3, int i4, boolean z_renamed) {
        if (i3 != -1) {
            this.x_renamed = i3;
            setWidth(i3);
        }
        if (i4 != -1) {
            this.A_renamed = i4;
            setHeight(i4);
        }
        if (!isShowing() || this.e_renamed == null) {
            return;
        }
        android.view.WindowManager.LayoutParams layoutParams = (android.view.WindowManager.LayoutParams) this.f_renamed.getLayoutParams();
        int i5 = this.v_renamed;
        if (i5 >= 0) {
            i5 = this.x_renamed;
        }
        if (i3 != -1 && layoutParams.width != i5) {
            this.x_renamed = i5;
            layoutParams.width = i5;
            z_renamed = true;
        }
        int i6 = this.y_renamed;
        if (i6 >= 0) {
            i6 = this.A_renamed;
        }
        if (i4 != -1 && layoutParams.height != i6) {
            this.A_renamed = i6;
            layoutParams.height = i6;
            z_renamed = true;
        }
        if (layoutParams.x_renamed != i_renamed) {
            layoutParams.x_renamed = i_renamed;
            z_renamed = true;
        }
        if (layoutParams.y_renamed != i2) {
            layoutParams.y_renamed = i2;
            z_renamed = true;
        }
        int iC = c_renamed();
        if (iC != layoutParams.windowAnimations) {
            layoutParams.windowAnimations = iC;
            z_renamed = true;
        }
        int iA = a_renamed(layoutParams.flags);
        if (iA != layoutParams.flags) {
            layoutParams.flags = iA;
            z_renamed = true;
        }
        if (z_renamed) {
            b_renamed();
            this.f3055b.updateViewLayout(this.f_renamed, layoutParams);
        }
    }

    @Override // android.widget.PopupWindow
    public void update(android.view.View view, int i_renamed, int i2) {
        a_renamed(view, false, 0, 0, true, i_renamed, i2, this.W_renamed);
    }

    @Override // android.widget.PopupWindow
    public void update(android.view.View view, int i_renamed, int i2, int i3, int i4) {
        a_renamed(view, true, i_renamed, i2, true, i3, i4, this.W_renamed);
    }

    private void a_renamed(android.view.View view, boolean z_renamed, int i_renamed, int i2, boolean z2, int i3, int i4, int i5) {
        int i6 = i3;
        int i7 = i4;
        if (!isShowing() || this.e_renamed == null) {
            return;
        }
        java.lang.ref.WeakReference<android.view.View> weakReference = this.S_renamed;
        boolean z3 = true;
        boolean z4 = z_renamed && !(this.U_renamed == i_renamed && this.V_renamed == i2);
        if (weakReference == null || weakReference.get() != view || (z4 && !this.d_renamed)) {
            a_renamed(view, i_renamed, i2, i5);
        } else if (z4) {
            this.U_renamed = i_renamed;
            this.V_renamed = i2;
            this.W_renamed = i5;
        }
        android.view.WindowManager.LayoutParams layoutParams = (android.view.WindowManager.LayoutParams) this.f_renamed.getLayoutParams();
        if (z2) {
            if (i6 == -1) {
                i6 = this.B_renamed;
            } else {
                this.B_renamed = i6;
            }
            if (i7 == -1) {
                i7 = this.C_renamed;
            } else {
                this.C_renamed = i7;
            }
        }
        int i8 = i6;
        int i9 = i7;
        int i10 = layoutParams.x_renamed;
        int i11 = layoutParams.y_renamed;
        if (z_renamed) {
            a_renamed(a_renamed(view, layoutParams, i_renamed, i2, i5));
        } else {
            a_renamed(a_renamed(view, layoutParams, this.U_renamed, this.V_renamed, this.W_renamed));
        }
        int i12 = layoutParams.x_renamed;
        int i13 = layoutParams.y_renamed;
        if (i10 == layoutParams.x_renamed && i11 == layoutParams.y_renamed) {
            z3 = false;
        }
        update(i12, i13, i8, i9, z3);
    }

    private void d_renamed() {
        java.lang.ref.WeakReference<android.view.View> weakReference = this.S_renamed;
        android.view.View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.T_renamed);
        }
        this.S_renamed = null;
    }

    private void a_renamed(android.view.View view, int i_renamed, int i2, int i3) {
        d_renamed();
        this.S_renamed = new java.lang.ref.WeakReference<>(view);
        android.view.ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.T_renamed);
        }
        this.U_renamed = i_renamed;
        this.V_renamed = i2;
        this.W_renamed = i3;
    }

    /* compiled from: COUIBasePopupWindow.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.b_renamed$b_renamed, reason: collision with other inner class name */
    private class COUIBasePopupWindow_3 extends android.widget.FrameLayout {
        public COUIBasePopupWindow_3(android.content.Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected int[] onCreateDrawableState(int i_renamed) {
            if (com.coui.appcompat.widget.popupwindow.b_renamed.this.M_renamed) {
                int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 1);
                android.view.View.mergeDrawableStates(iArrOnCreateDrawableState, com.coui.appcompat.widget.popupwindow.b_renamed.R_renamed);
                return iArrOnCreateDrawableState;
            }
            return super.onCreateDrawableState(i_renamed);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
            android.view.KeyEvent.DispatcherState keyDispatcherState;
            if (keyEvent.getKeyCode() == 4) {
                if (getKeyDispatcherState() == null) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    android.view.KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                    com.coui.appcompat.widget.popupwindow.b_renamed.this.dismiss();
                    return true;
                }
                return super.dispatchKeyEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
            if (com.coui.appcompat.widget.popupwindow.b_renamed.this.u_renamed == null || !com.coui.appcompat.widget.popupwindow.b_renamed.this.u_renamed.onTouch(this, motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }

        @Override // android.view.View
        public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
            int x_renamed = (int) motionEvent.getX();
            int y_renamed = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x_renamed < 0 || x_renamed >= getWidth() || y_renamed < 0 || y_renamed >= getHeight())) {
                com.coui.appcompat.widget.popupwindow.b_renamed.this.dismiss();
                return true;
            }
            if (motionEvent.getAction() == 4) {
                com.coui.appcompat.widget.popupwindow.b_renamed.this.dismiss();
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
        public void sendAccessibilityEvent(int i_renamed) {
            if (com.coui.appcompat.widget.popupwindow.b_renamed.this.e_renamed != null) {
                com.coui.appcompat.widget.popupwindow.b_renamed.this.e_renamed.sendAccessibilityEvent(i_renamed);
            } else {
                super.sendAccessibilityEvent(i_renamed);
            }
        }
    }
}
