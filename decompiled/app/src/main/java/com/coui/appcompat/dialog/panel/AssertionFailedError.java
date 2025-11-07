package com.coui.appcompat.dialog.panel;

/* compiled from: COUIBottomSheetDialog.java */
/* loaded from: classes.dex */
public class b_renamed extends com.google.android.material.bottomsheet.BottomSheetDialog {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.view.animation.Interpolator f2514a = new android.view.animation.PathInterpolator(0.0f, 0.0f, 0.15f, 1.0f);

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final android.view.animation.Interpolator f2515b = new android.view.animation.PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final android.view.animation.Interpolator f2516c = f2514a;
    private boolean A_renamed;
    private boolean B_renamed;
    private int C_renamed;
    private int D_renamed;
    private int E_renamed;
    private android.view.View F_renamed;
    private com.a_renamed.a_renamed.f_renamed G_renamed;
    private com.a_renamed.a_renamed.f_renamed H_renamed;
    private android.view.View I_renamed;
    private android.view.ViewGroup J_renamed;
    private int K_renamed;
    private boolean L_renamed;
    private boolean M_renamed;
    private com.google.android.material.bottomsheet.BottomSheetBehavior N_renamed;
    private boolean O_renamed;
    private android.view.inputmethod.InputMethodManager P_renamed;
    private android.animation.AnimatorSet Q_renamed;
    private float R_renamed;
    private float S_renamed;
    private boolean T_renamed;
    private boolean U_renamed;
    private int V_renamed;
    private android.view.View.OnApplyWindowInsetsListener W_renamed;
    private com.coui.appcompat.dialog.panel.g_renamed X_renamed;
    private com.coui.appcompat.dialog.panel.d_renamed Y_renamed;
    private android.view.WindowInsets Z_renamed;
    private android.view.WindowInsets aa_renamed;
    private boolean ab_renamed;
    private boolean ac_renamed;
    private int ad_renamed;
    private android.os.Handler ae_renamed;
    private final int af_renamed;
    private boolean ag_renamed;
    private boolean ah_renamed;
    private com.coui.appcompat.dialog.panel.f_renamed ai_renamed;
    private int aj_renamed;
    private boolean ak_renamed;
    private boolean al_renamed;
    private boolean am_renamed;
    private boolean an_renamed;
    private boolean ao_renamed;
    private int ap_renamed;
    private boolean aq_renamed;
    private android.view.ViewTreeObserver.OnPreDrawListener ar_renamed;
    private android.content.ComponentCallbacks as_renamed;
    private int d_renamed;
    private com.coui.appcompat.widget.IgnoreWindowInsetsFrameLayout e_renamed;
    private android.view.View f_renamed;
    private android.view.View g_renamed;
    private android.view.ViewGroup h_renamed;
    private android.view.View i_renamed;
    private com.coui.appcompat.widget.l_renamed j_renamed;
    private android.view.ViewGroup k_renamed;
    private boolean l_renamed;
    private java.lang.String m_renamed;
    private android.view.View.OnClickListener n_renamed;
    private java.lang.String o_renamed;
    private android.view.View.OnClickListener p_renamed;
    private java.lang.String q_renamed;
    private android.view.View.OnClickListener r_renamed;
    private android.graphics.drawable.Drawable s_renamed;
    private int t_renamed;
    private android.graphics.drawable.Drawable u_renamed;
    private int v_renamed;
    private java.lang.ref.WeakReference<android.app.Activity> w_renamed;
    private boolean x_renamed;
    private android.view.View.OnTouchListener y_renamed;
    private boolean z_renamed;

    public b_renamed(android.content.Context context, int i_renamed) {
        super(context, a_renamed(context, i_renamed));
        this.d_renamed = 0;
        this.l_renamed = true;
        this.x_renamed = false;
        this.z_renamed = true;
        this.A_renamed = true;
        this.B_renamed = true;
        this.E_renamed = 0;
        this.K_renamed = 0;
        this.L_renamed = true;
        this.M_renamed = false;
        this.R_renamed = 0.0f;
        this.S_renamed = 0.0f;
        this.T_renamed = false;
        this.U_renamed = false;
        this.V_renamed = 0;
        this.W_renamed = null;
        this.X_renamed = null;
        this.af_renamed = 500;
        this.ag_renamed = false;
        this.ah_renamed = false;
        this.aj_renamed = 0;
        this.am_renamed = true;
        this.an_renamed = false;
        this.ao_renamed = false;
        this.aq_renamed = false;
        this.ar_renamed = new android.view.ViewTreeObserver.OnPreDrawListener() { // from class: com.coui.appcompat.dialog.panel.b_renamed.6
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                com.coui.appcompat.dialog.panel.b_renamed.this.t_renamed();
                if (!com.coui.appcompat.dialog.panel.b_renamed.this.ah_renamed || com.coui.appcompat.dialog.panel.b_renamed.this.s_renamed()) {
                    com.coui.appcompat.dialog.panel.b_renamed.this.ah_renamed = false;
                    com.coui.appcompat.dialog.panel.b_renamed bVar = com.coui.appcompat.dialog.panel.b_renamed.this;
                    bVar.a_renamed(0, true, bVar.u_renamed());
                } else if (com.coui.appcompat.dialog.panel.b_renamed.this.J_renamed != null) {
                    com.coui.appcompat.dialog.panel.b_renamed bVar2 = com.coui.appcompat.dialog.panel.b_renamed.this;
                    bVar2.d_renamed = bVar2.g_renamed.getMeasuredHeight();
                    int measuredHeight = com.coui.appcompat.dialog.panel.b_renamed.this.O_renamed ? com.coui.appcompat.dialog.panel.b_renamed.this.d_renamed : com.coui.appcompat.dialog.panel.b_renamed.this.J_renamed.getMeasuredHeight() + com.coui.appcompat.a_renamed.y_renamed.a_renamed(com.coui.appcompat.dialog.panel.b_renamed.this.J_renamed, 3);
                    if (com.coui.appcompat.dialog.panel.b_renamed.this.M_renamed) {
                        measuredHeight = com.coui.appcompat.dialog.panel.b_renamed.this.K_renamed;
                    }
                    com.coui.appcompat.dialog.panel.b_renamed.this.J_renamed.setTranslationY(measuredHeight);
                    com.coui.appcompat.dialog.panel.b_renamed.this.f_renamed.setAlpha(0.0f);
                    return true;
                }
                return true;
            }
        };
        this.as_renamed = new android.content.ComponentCallbacks() { // from class: com.coui.appcompat.dialog.panel.b_renamed.7
            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(android.content.res.Configuration configuration) {
                com.coui.appcompat.dialog.panel.b_renamed.this.a_renamed(configuration);
            }
        };
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, coui.support.appcompat.R_renamed.styleable.COUIBottomSheetDialog, coui.support.appcompat.R_renamed.attr.couiBottomSheetDialogStyle, i_renamed);
        this.s_renamed = a_renamed(typedArrayObtainStyledAttributes, coui.support.appcompat.R_renamed.styleable.COUIBottomSheetDialog_panelDragViewIcon, coui.support.appcompat.R_renamed.drawable.coui_panel_drag_view);
        this.t_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUIBottomSheetDialog_panelDragViewTintColor, context.getResources().getColor(coui.support.appcompat.R_renamed.color.coui_panel_drag_view_color));
        this.u_renamed = a_renamed(typedArrayObtainStyledAttributes, coui.support.appcompat.R_renamed.styleable.COUIBottomSheetDialog_panelBackground, coui.support.appcompat.R_renamed.drawable.coui_panel_bg_without_shadow);
        this.v_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUIBottomSheetDialog_panelBackgroundTintColor, context.getResources().getColor(coui.support.appcompat.R_renamed.color.coui_panel_layout_tint));
        typedArrayObtainStyledAttributes.recycle();
        android.graphics.drawable.Drawable drawable = this.u_renamed;
        if (drawable != null) {
            drawable.setTint(this.v_renamed);
        }
        if (context instanceof android.app.Activity) {
            this.w_renamed = new java.lang.ref.WeakReference<>((android.app.Activity) context);
        }
    }

    static int a_renamed(android.content.Context context, int i_renamed) {
        if (((i_renamed >>> 24) & 255) >= 1) {
            return i_renamed;
        }
        android.util.TypedValue typedValue = new android.util.TypedValue();
        context.getTheme().resolveAttribute(coui.support.appcompat.R_renamed.attr.couiBottomSheetDialogStyle, typedValue, true);
        return typedValue.resourceId;
    }

    private android.graphics.drawable.Drawable a_renamed(android.content.res.TypedArray typedArray, int i_renamed, int i2) {
        android.graphics.drawable.Drawable drawable = typedArray != null ? typedArray.getDrawable(i_renamed) : null;
        return drawable == null ? getContext().getResources().getDrawable(i2, getContext().getTheme()) : drawable;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.f_renamed, android.app.Dialog
    public void setContentView(int i_renamed) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        setContentView(getLayoutInflater().inflate(i_renamed, (android.view.ViewGroup) null));
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.f_renamed, android.app.Dialog
    public void setContentView(android.view.View view) throws android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException {
        if (view == null) {
            throw new java.lang.IllegalArgumentException("ContentView can't_renamed be_renamed null");
        }
        com.coui.appcompat.a_renamed.t_renamed.a_renamed().a_renamed(getContext());
        if (!this.x_renamed) {
            this.j_renamed = a_renamed(view.getContext());
            w_renamed();
            this.i_renamed = view;
            this.j_renamed.b_renamed(this.i_renamed);
            super.setContentView(this.j_renamed);
            this.J_renamed = (android.view.ViewGroup) this.j_renamed.getParent();
        } else if (view != null) {
            this.i_renamed = view;
            super.setContentView(view);
            this.J_renamed = (android.view.ViewGroup) view.getParent();
        }
        this.F_renamed = this.J_renamed;
    }

    private com.coui.appcompat.widget.l_renamed a_renamed(android.content.Context context) {
        com.coui.appcompat.widget.l_renamed lVar = new com.coui.appcompat.widget.l_renamed(context);
        android.graphics.drawable.Drawable drawable = this.s_renamed;
        if (drawable != null) {
            drawable.setTint(this.t_renamed);
            lVar.setDragViewDrawable(this.s_renamed);
        }
        lVar.setBackground(this.u_renamed);
        return lVar;
    }

    private void f_renamed() {
        if (this.j_renamed != null) {
            this.j_renamed.setLayoutParams(new android.widget.FrameLayout.LayoutParams(f_renamed(getContext().getResources().getConfiguration()), -2));
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.f_renamed, android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        g_renamed();
        h_renamed();
        i_renamed();
    }

    private void g_renamed() {
        this.N_renamed = getBehavior();
        com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior = this.N_renamed;
        if (bottomSheetBehavior instanceof com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) {
            ((com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) bottomSheetBehavior).a_renamed(this.K_renamed);
            ((com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) this.N_renamed).a_renamed(this.L_renamed);
            if (this.M_renamed) {
                ((com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) this.N_renamed).b_renamed(4);
            } else {
                ((com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) this.N_renamed).b_renamed(3);
            }
            this.C_renamed = (int) getContext().getResources().getDimension(coui.support.appcompat.R_renamed.dimen.coui_panel_pull_up_max_offset);
            ((com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) this.N_renamed).a_renamed(new com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior.a_renamed() { // from class: com.coui.appcompat.dialog.panel.b_renamed.1
                @Override // com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior.a_renamed
                public void a_renamed(android.view.View view, int i_renamed) {
                    if (i_renamed == 1) {
                        if (android.os.Build.VERSION.SDK_INT < 30 || com.coui.appcompat.dialog.panel.b_renamed.this.s_renamed() || com.coui.appcompat.dialog.panel.b_renamed.this.ai_renamed == null || com.coui.appcompat.dialog.panel.b_renamed.this.ai_renamed.b_renamed() || com.coui.appcompat.dialog.panel.b_renamed.this.j_renamed.getRootWindowInsets() == null || !com.coui.appcompat.dialog.panel.b_renamed.this.j_renamed.getRootWindowInsets().isVisible(android.view.WindowInsets.Type.ime())) {
                            return;
                        }
                        com.coui.appcompat.dialog.panel.b_renamed.this.ak_renamed = true;
                        com.coui.appcompat.dialog.panel.b_renamed.this.ai_renamed.a_renamed(com.coui.appcompat.dialog.panel.b_renamed.this.j_renamed, new com.coui.appcompat.dialog.panel.f_renamed.a_renamed() { // from class: com.coui.appcompat.dialog.panel.b_renamed.1.1
                            @Override // com.coui.appcompat.dialog.panel.f_renamed.a_renamed
                            public boolean a_renamed(int i2) {
                                return true;
                            }

                            @Override // com.coui.appcompat.dialog.panel.f_renamed.a_renamed
                            public void a_renamed(android.view.WindowInsetsAnimationController windowInsetsAnimationController, boolean z_renamed) {
                                com.coui.appcompat.dialog.panel.b_renamed.this.ak_renamed = z_renamed;
                            }
                        });
                        return;
                    }
                    if (i_renamed == 2) {
                        if ((com.coui.appcompat.dialog.panel.b_renamed.this.N_renamed instanceof com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) && ((com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) com.coui.appcompat.dialog.panel.b_renamed.this.N_renamed).a_renamed() && !com.coui.appcompat.dialog.panel.b_renamed.this.ak_renamed) {
                            com.coui.appcompat.dialog.panel.b_renamed.this.r_renamed();
                            return;
                        }
                        return;
                    }
                    if (i_renamed != 3) {
                        if (i_renamed != 5) {
                            return;
                        }
                        if (android.os.Build.VERSION.SDK_INT >= 30 && com.coui.appcompat.dialog.panel.b_renamed.this.ai_renamed != null) {
                            com.coui.appcompat.dialog.panel.b_renamed.this.ai_renamed.e_renamed();
                        }
                        com.coui.appcompat.dialog.panel.b_renamed.this.dismiss();
                        return;
                    }
                    if (android.os.Build.VERSION.SDK_INT >= 30 && !com.coui.appcompat.dialog.panel.b_renamed.this.s_renamed() && com.coui.appcompat.dialog.panel.b_renamed.this.ai_renamed != null && com.coui.appcompat.dialog.panel.b_renamed.this.ai_renamed.a_renamed() && com.coui.appcompat.dialog.panel.b_renamed.this.ak_renamed) {
                        com.coui.appcompat.dialog.panel.b_renamed.this.ak_renamed = false;
                        com.coui.appcompat.dialog.panel.b_renamed.this.am_renamed = true;
                        com.coui.appcompat.dialog.panel.b_renamed.this.ai_renamed.e_renamed();
                    }
                    com.coui.appcompat.dialog.panel.b_renamed.this.an_renamed = false;
                }

                @Override // com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior.a_renamed
                public void a_renamed(android.view.View view, float f_renamed) {
                    if (android.os.Build.VERSION.SDK_INT < 30 || com.coui.appcompat.dialog.panel.b_renamed.this.s_renamed() || com.coui.appcompat.dialog.panel.b_renamed.this.ai_renamed == null || !com.coui.appcompat.dialog.panel.b_renamed.this.ai_renamed.a_renamed()) {
                        return;
                    }
                    int i_renamed = ((com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) com.coui.appcompat.dialog.panel.b_renamed.this.N_renamed).h_renamed;
                    if (i_renamed == 1 || i_renamed == 2 || i_renamed == 3) {
                        com.coui.appcompat.dialog.panel.b_renamed.this.ak_renamed = true;
                        com.coui.appcompat.dialog.panel.b_renamed.this.ai_renamed.a_renamed(1, (int) ((com.coui.appcompat.dialog.panel.b_renamed.this.J_renamed.getHeight() + com.coui.appcompat.a_renamed.y_renamed.a_renamed(com.coui.appcompat.dialog.panel.b_renamed.this.J_renamed, 3)) * java.lang.Math.max(0.0f, 1.0f - f_renamed)));
                    }
                }
            });
        }
    }

    private void h_renamed() {
        android.view.Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
            window.setLayout(-1, -1);
            window.setGravity(80);
        }
    }

    private void i_renamed() {
        this.e_renamed = (com.coui.appcompat.widget.IgnoreWindowInsetsFrameLayout) findViewById(coui.support.appcompat.R_renamed.id_renamed.container);
        this.f_renamed = findViewById(coui.support.appcompat.R_renamed.id_renamed.panel_outside);
        android.view.View view = this.f_renamed;
        if (view != null) {
            android.view.View.OnTouchListener onTouchListener = this.y_renamed;
            if (onTouchListener != null) {
                view.setOnTouchListener(onTouchListener);
            }
            this.f_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.coui.appcompat.dialog.panel.b_renamed.11
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view2) {
                    if (com.coui.appcompat.dialog.panel.b_renamed.this.z_renamed && com.coui.appcompat.dialog.panel.b_renamed.this.isShowing() && com.coui.appcompat.dialog.panel.b_renamed.this.A_renamed) {
                        com.coui.appcompat.dialog.panel.b_renamed.this.cancel();
                    }
                }
            });
        }
        this.g_renamed = findViewById(coui.support.appcompat.R_renamed.id_renamed.coordinator);
        this.h_renamed = (android.view.ViewGroup) findViewById(coui.support.appcompat.R_renamed.id_renamed.design_bottom_sheet);
        android.view.ViewGroup viewGroup = this.h_renamed;
        if (viewGroup != null) {
            if (this.x_renamed) {
                viewGroup.setBackground(null);
            } else {
                viewGroup.setBackground(this.u_renamed);
            }
            this.h_renamed.setOutlineProvider(new android.view.ViewOutlineProvider() { // from class: com.coui.appcompat.dialog.panel.b_renamed.12
                @Override // android.view.ViewOutlineProvider
                public void getOutline(android.view.View view2, android.graphics.Outline outline) {
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), com.coui.appcompat.dialog.panel.b_renamed.this.ap_renamed);
                }
            });
            this.h_renamed.setClipToOutline(true);
        }
    }

    private void j_renamed() {
        int iD = com.coui.appcompat.a_renamed.m_renamed.d_renamed(getContext()) + getContext().getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_panel_normal_padding_top);
        android.view.View view = this.g_renamed;
        if (view != null) {
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = iD;
            this.g_renamed.setLayoutParams(layoutParams);
        }
        f_renamed();
        b_renamed(getContext());
        d_renamed(getContext().getResources().getConfiguration());
        e_renamed(getContext().getResources().getConfiguration());
        c_renamed(getContext().getResources().getConfiguration());
        b_renamed(getContext().getResources().getConfiguration());
    }

    private void b_renamed(android.content.res.Configuration configuration) {
        android.view.Window window = getWindow();
        if (window != null) {
            if (configuration != null) {
                window.setNavigationBarColor(getContext().createConfigurationContext(configuration).getResources().getColor(coui.support.appcompat.R_renamed.color.coui_panel_navigation_bar_color));
            } else {
                window.setNavigationBarColor(getContext().getResources().getColor(coui.support.appcompat.R_renamed.color.coui_panel_navigation_bar_color));
            }
        }
    }

    private void b_renamed(android.content.Context context) {
        this.ap_renamed = context.getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_bottom_sheet_bg_bottom_corner_radius);
        this.h_renamed.invalidateOutline();
    }

    private void a_renamed(boolean z_renamed, android.content.res.Configuration configuration) {
        android.view.ViewGroup viewGroup;
        if (!this.O_renamed || this.j_renamed == null || (viewGroup = this.h_renamed) == null) {
            return;
        }
        android.view.ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        android.view.ViewGroup.LayoutParams layoutParams2 = this.j_renamed.getLayoutParams();
        if (z_renamed) {
            layoutParams.height = -2;
            this.j_renamed.setLayoutAtMaxHeight(true);
            layoutParams2.height = com.coui.appcompat.a_renamed.m_renamed.a_renamed(getContext(), configuration);
        } else {
            layoutParams.height = com.coui.appcompat.a_renamed.m_renamed.a_renamed(getContext(), configuration) - getContext().getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_bottom_sheet_margin_bottom_if_need);
            layoutParams2.height = -1;
        }
        this.h_renamed.setLayoutParams(layoutParams);
        this.j_renamed.setLayoutParams(layoutParams2);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ae_renamed = new android.os.Handler(android.os.Looper.getMainLooper(), new android.os.Handler.Callback() { // from class: com.coui.appcompat.dialog.panel.b_renamed.13
            @Override // android.os.Handler.Callback
            public boolean handleMessage(android.os.Message message) {
                if (message.what != 500) {
                    return false;
                }
                if (android.os.Build.VERSION.SDK_INT >= 30) {
                    com.coui.appcompat.dialog.panel.b_renamed.this.ai_renamed.e_renamed();
                }
                com.coui.appcompat.dialog.panel.b_renamed bVar = com.coui.appcompat.dialog.panel.b_renamed.this;
                bVar.a_renamed(0, true, bVar.u_renamed());
                return true;
            }
        });
        j_renamed();
        android.view.Window window = getWindow();
        if (window != null) {
            d_renamed().a_renamed(window.getAttributes().type);
            int i_renamed = window.getAttributes().softInputMode & 15;
            if (i_renamed == 5 && android.os.Build.VERSION.SDK_INT >= 30 && !s_renamed() && !this.ao_renamed) {
                this.ag_renamed = true;
                this.ah_renamed = true;
                i_renamed = 0;
            }
            window.setSoftInputMode(i_renamed | 16);
            a_renamed(window);
        }
        android.view.View view = this.f_renamed;
        if (view != null) {
            view.getViewTreeObserver().addOnPreDrawListener(this.ar_renamed);
        }
        getContext().registerComponentCallbacks(this.as_renamed);
        if (this.N_renamed instanceof com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) {
            this.X_renamed = this.B_renamed ? v_renamed() : null;
            ((com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) this.N_renamed).a_renamed(this.X_renamed);
        }
        if (this.ah_renamed) {
            k_renamed();
        }
        m_renamed();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        if (d_renamed() != null) {
            d_renamed().b_renamed();
            this.Y_renamed = null;
        }
        android.view.Window window = getWindow();
        if (window != null) {
            window.getDecorView().setOnApplyWindowInsetsListener(null);
            this.W_renamed = null;
        }
        a_renamed(this.Q_renamed);
        if (this.as_renamed != null) {
            getContext().unregisterComponentCallbacks(this.as_renamed);
        }
        com.google.android.material.bottomsheet.BottomSheetBehavior bottomSheetBehavior = this.N_renamed;
        if (bottomSheetBehavior instanceof com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) {
            ((com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) bottomSheetBehavior).a_renamed((com.coui.appcompat.dialog.panel.g_renamed) null);
            this.X_renamed = null;
        }
        if (this.ai_renamed != null && android.os.Build.VERSION.SDK_INT >= 30) {
            this.ai_renamed.e_renamed();
        }
        e_renamed(true);
        this.ae_renamed.removeCallbacksAndMessages(null);
        this.ae_renamed = null;
        super.onDetachedFromWindow();
    }

    private void k_renamed() {
        if (android.os.Build.VERSION.SDK_INT < 30 || this.ai_renamed != null) {
            return;
        }
        this.ai_renamed = new com.coui.appcompat.dialog.panel.f_renamed();
        android.os.Handler handler = this.ae_renamed;
        handler.sendMessageDelayed(android.os.Message.obtain(handler, 500, null), 500L);
        this.ai_renamed.a_renamed(this.j_renamed, new com.coui.appcompat.dialog.panel.f_renamed.a_renamed() { // from class: com.coui.appcompat.dialog.panel.b_renamed.14
            @Override // com.coui.appcompat.dialog.panel.f_renamed.a_renamed
            public boolean a_renamed(int i_renamed) {
                com.coui.appcompat.dialog.panel.b_renamed.this.am_renamed = true;
                com.coui.appcompat.dialog.panel.b_renamed.this.ah_renamed = (i_renamed & android.view.WindowInsets.Type.ime()) != 0;
                return com.coui.appcompat.dialog.panel.b_renamed.this.ah_renamed;
            }

            @Override // com.coui.appcompat.dialog.panel.f_renamed.a_renamed
            public void a_renamed(android.view.WindowInsetsAnimationController windowInsetsAnimationController, boolean z_renamed) {
                if (z_renamed) {
                    com.coui.appcompat.dialog.panel.b_renamed.this.ae_renamed.removeMessages(500);
                    com.coui.appcompat.dialog.panel.b_renamed bVar = com.coui.appcompat.dialog.panel.b_renamed.this;
                    bVar.a_renamed(z_renamed ? bVar.aj_renamed : 0, true, com.coui.appcompat.dialog.panel.b_renamed.this.u_renamed());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l_renamed() {
        if (this.ai_renamed == null || android.os.Build.VERSION.SDK_INT < 30 || s_renamed()) {
            return;
        }
        this.ag_renamed = false;
        if (this.ai_renamed.d_renamed() && this.ai_renamed.a_renamed()) {
            this.ai_renamed.a_renamed(true);
        } else {
            this.P_renamed.showSoftInput(this.j_renamed.findFocus(), 2);
        }
    }

    private void m_renamed() {
        if (getWindow() == null || this.W_renamed != null) {
            return;
        }
        android.view.View decorView = getWindow().getDecorView();
        this.W_renamed = new android.view.View.OnApplyWindowInsetsListener() { // from class: com.coui.appcompat.dialog.panel.b_renamed.15
            @Override // android.view.View.OnApplyWindowInsetsListener
            public android.view.WindowInsets onApplyWindowInsets(android.view.View view, android.view.WindowInsets windowInsets) throws android.content.res.Resources.NotFoundException {
                if (com.coui.appcompat.dialog.panel.b_renamed.this.P_renamed == null) {
                    com.coui.appcompat.dialog.panel.b_renamed bVar = com.coui.appcompat.dialog.panel.b_renamed.this;
                    bVar.P_renamed = (android.view.inputmethod.InputMethodManager) bVar.getContext().getSystemService("input_method");
                }
                if (com.coui.appcompat.dialog.panel.b_renamed.this.s_renamed()) {
                    com.coui.appcompat.widget.l_renamed lVar = com.coui.appcompat.dialog.panel.b_renamed.this.j_renamed;
                    if (com.coui.appcompat.dialog.panel.b_renamed.this.am_renamed) {
                        com.coui.appcompat.dialog.panel.b_renamed.this.d_renamed().a_renamed(com.coui.appcompat.dialog.panel.b_renamed.this.getContext(), lVar, windowInsets);
                    }
                    com.coui.appcompat.dialog.panel.b_renamed.this.getWindow().setNavigationBarColor(com.coui.appcompat.dialog.panel.b_renamed.this.getContext().getResources().getColor(coui.support.appcompat.R_renamed.color.coui_common_background_color));
                } else if (com.coui.appcompat.dialog.panel.b_renamed.this.am_renamed) {
                    boolean z_renamed = com.coui.appcompat.dialog.panel.b_renamed.this.getContext().getResources().getBoolean(coui.support.appcompat.R_renamed.bool.is_coui_bottom_sheet_ime_adjust_in_constraint_layout);
                    com.coui.appcompat.dialog.panel.b_renamed.this.d_renamed().a_renamed(com.coui.appcompat.dialog.panel.b_renamed.this.getContext(), z_renamed ? com.coui.appcompat.dialog.panel.b_renamed.this.j_renamed : com.coui.appcompat.dialog.panel.b_renamed.this.h_renamed, windowInsets);
                    com.coui.appcompat.dialog.panel.b_renamed bVar2 = com.coui.appcompat.dialog.panel.b_renamed.this;
                    bVar2.aj_renamed = z_renamed ? bVar2.d_renamed().c_renamed() : bVar2.d_renamed().e_renamed();
                }
                com.coui.appcompat.dialog.panel.b_renamed.this.Z_renamed = windowInsets;
                view.onApplyWindowInsets(com.coui.appcompat.dialog.panel.b_renamed.this.Z_renamed);
                return com.coui.appcompat.dialog.panel.b_renamed.this.Z_renamed;
            }
        };
        decorView.setOnApplyWindowInsetsListener(this.W_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e_renamed(boolean z_renamed) {
        if (getWindow() == null || android.os.Build.VERSION.SDK_INT < 30) {
            return;
        }
        int i_renamed = 0;
        if (z_renamed) {
            this.al_renamed = false;
            getWindow().getDecorView().setWindowInsetsAnimationCallback(null);
        } else {
            if (this.al_renamed) {
                return;
            }
            this.al_renamed = true;
            getWindow().getDecorView().setWindowInsetsAnimationCallback(new android.view.WindowInsetsAnimation.Callback(i_renamed) { // from class: com.coui.appcompat.dialog.panel.b_renamed.16
                @Override // android.view.WindowInsetsAnimation.Callback
                public void onPrepare(android.view.WindowInsetsAnimation windowInsetsAnimation) throws android.content.res.Resources.NotFoundException {
                    if ((windowInsetsAnimation.getTypeMask() & android.view.WindowInsets.Type.ime()) != 0) {
                        boolean z2 = com.coui.appcompat.dialog.panel.b_renamed.this.getContext().getResources().getBoolean(coui.support.appcompat.R_renamed.bool.is_coui_bottom_sheet_ime_adjust_in_constraint_layout);
                        com.coui.appcompat.dialog.panel.b_renamed bVar = com.coui.appcompat.dialog.panel.b_renamed.this;
                        bVar.k_renamed = z2 ? bVar.j_renamed : bVar.h_renamed;
                        com.coui.appcompat.dialog.panel.b_renamed bVar2 = com.coui.appcompat.dialog.panel.b_renamed.this;
                        bVar2.an_renamed = !bVar2.s_renamed() && (com.coui.appcompat.dialog.panel.b_renamed.this.ai_renamed == null || !com.coui.appcompat.dialog.panel.b_renamed.this.ai_renamed.c_renamed());
                        com.coui.appcompat.dialog.panel.b_renamed.this.am_renamed = !r3.an_renamed;
                        com.coui.appcompat.dialog.panel.b_renamed bVar3 = com.coui.appcompat.dialog.panel.b_renamed.this;
                        bVar3.d_renamed = com.coui.appcompat.a_renamed.m_renamed.a_renamed(bVar3.getContext(), com.coui.appcompat.dialog.panel.b_renamed.this.getContext().getResources().getConfiguration());
                    }
                }

                @Override // android.view.WindowInsetsAnimation.Callback
                public android.view.WindowInsets onProgress(android.view.WindowInsets windowInsets, java.util.List<android.view.WindowInsetsAnimation> list) throws android.content.res.Resources.NotFoundException {
                    boolean z2 = false;
                    int i2 = com.coui.appcompat.dialog.panel.b_renamed.this.Z_renamed != null ? com.coui.appcompat.dialog.panel.b_renamed.this.Z_renamed.getInsets(android.view.WindowInsets.Type.ime()).bottom : 0;
                    if (com.coui.appcompat.a_renamed.m_renamed.e_renamed(com.coui.appcompat.dialog.panel.b_renamed.this.getContext()) && i2 > (com.coui.appcompat.dialog.panel.b_renamed.this.d_renamed * 5) / 6) {
                        z2 = true;
                    }
                    if (com.coui.appcompat.dialog.panel.b_renamed.this.d_renamed() == null || !com.coui.appcompat.dialog.panel.b_renamed.this.an_renamed || z2 || com.coui.appcompat.dialog.panel.b_renamed.this.ab_renamed || com.coui.appcompat.dialog.panel.b_renamed.this.ak_renamed) {
                        com.coui.appcompat.dialog.panel.b_renamed.this.aa_renamed = null;
                    } else {
                        com.coui.appcompat.dialog.panel.b_renamed.this.aa_renamed = windowInsets;
                        com.coui.appcompat.dialog.panel.b_renamed.this.d_renamed().a_renamed(com.coui.appcompat.dialog.panel.b_renamed.this.getContext(), com.coui.appcompat.dialog.panel.b_renamed.this.k_renamed, com.coui.appcompat.dialog.panel.b_renamed.this.aa_renamed);
                    }
                    return windowInsets;
                }

                @Override // android.view.WindowInsetsAnimation.Callback
                public void onEnd(android.view.WindowInsetsAnimation windowInsetsAnimation) throws android.content.res.Resources.NotFoundException {
                    if ((windowInsetsAnimation.getTypeMask() & android.view.WindowInsets.Type.ime()) != 0) {
                        if (!com.coui.appcompat.dialog.panel.b_renamed.this.an_renamed) {
                            return;
                        }
                        int i2 = com.coui.appcompat.dialog.panel.b_renamed.this.aa_renamed != null ? com.coui.appcompat.dialog.panel.b_renamed.this.aa_renamed.getInsets(android.view.WindowInsets.Type.ime()).bottom : 0;
                        if ((com.coui.appcompat.dialog.panel.b_renamed.this.Z_renamed != null ? com.coui.appcompat.dialog.panel.b_renamed.this.Z_renamed.getInsets(android.view.WindowInsets.Type.ime()).bottom : 0) == 0 && com.coui.appcompat.dialog.panel.b_renamed.this.Z_renamed != null && com.coui.appcompat.dialog.panel.b_renamed.this.d_renamed() != null) {
                            if (i2 > 0) {
                                com.coui.appcompat.dialog.panel.b_renamed.this.d_renamed().a_renamed(com.coui.appcompat.dialog.panel.b_renamed.this.getContext(), com.coui.appcompat.dialog.panel.b_renamed.this.k_renamed, com.coui.appcompat.dialog.panel.b_renamed.this.Z_renamed);
                            } else {
                                com.coui.appcompat.dialog.panel.b_renamed.this.d_renamed().a_renamed(com.coui.appcompat.dialog.panel.b_renamed.this.j_renamed);
                            }
                        }
                        com.coui.appcompat.dialog.panel.b_renamed.this.an_renamed = false;
                        com.coui.appcompat.dialog.panel.b_renamed.this.am_renamed = true;
                    }
                    super.onEnd(windowInsetsAnimation);
                }
            });
        }
    }

    public android.view.View a_renamed() {
        return this.i_renamed;
    }

    @Override // android.app.Dialog
    public void hide() {
        com.coui.appcompat.widget.l_renamed lVar;
        if (!this.x_renamed || (lVar = this.j_renamed) == null || lVar.findFocus() == null) {
            super.hide();
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        q_renamed();
        b_renamed(true);
    }

    public void a_renamed(boolean z_renamed) {
        this.ac_renamed = z_renamed;
    }

    public void a_renamed(int i_renamed) {
        this.ad_renamed = i_renamed;
    }

    public void b_renamed(boolean z_renamed) {
        if (isShowing() && z_renamed && !this.ab_renamed) {
            r_renamed();
            if (this.N_renamed.getState() == 5) {
                p_renamed();
                return;
            } else {
                o_renamed();
                return;
            }
        }
        n_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n_renamed() {
        super.dismiss();
    }

    private void o_renamed() {
        a_renamed(0, false, (android.animation.Animator.AnimatorListener) new android.animation.AnimatorListenerAdapter() { // from class: com.coui.appcompat.dialog.panel.b_renamed.17
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.coui.appcompat.dialog.panel.b_renamed.this.ab_renamed = false;
                if (!com.coui.appcompat.dialog.panel.b_renamed.this.ac_renamed) {
                    com.coui.appcompat.dialog.panel.b_renamed.this.n_renamed();
                    return;
                }
                com.coui.appcompat.dialog.panel.b_renamed bVar = com.coui.appcompat.dialog.panel.b_renamed.this;
                android.animation.ValueAnimator valueAnimatorB = bVar.b_renamed(bVar.ad_renamed);
                if (valueAnimatorB == null) {
                    com.coui.appcompat.dialog.panel.b_renamed.this.n_renamed();
                } else {
                    valueAnimatorB.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.coui.appcompat.dialog.panel.b_renamed.17.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(android.animation.Animator animator2) {
                            com.coui.appcompat.dialog.panel.b_renamed.this.n_renamed();
                        }
                    });
                    valueAnimatorB.start();
                }
            }
        });
    }

    private void p_renamed() {
        android.animation.ValueAnimator valueAnimatorB = this.ac_renamed ? b_renamed(this.ad_renamed) : null;
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.setInterpolator(f2516c);
        animatorSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.coui.appcompat.dialog.panel.b_renamed.18
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.coui.appcompat.dialog.panel.b_renamed.this.ab_renamed = true;
                super.onAnimationStart(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                com.coui.appcompat.dialog.panel.b_renamed.this.ab_renamed = false;
                super.onAnimationCancel(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.coui.appcompat.dialog.panel.b_renamed.this.ab_renamed = false;
                com.coui.appcompat.dialog.panel.b_renamed.this.n_renamed();
            }
        });
        if (valueAnimatorB == null) {
            animatorSet.playTogether(f_renamed(false));
        } else {
            animatorSet.playTogether(f_renamed(false), valueAnimatorB);
        }
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, boolean z_renamed, android.animation.Animator.AnimatorListener animatorListener) {
        int measuredHeight;
        int i2;
        float fAbs;
        android.animation.AnimatorSet animatorSet = this.Q_renamed;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.T_renamed = true;
            this.Q_renamed.end();
        }
        this.d_renamed = this.g_renamed.getMeasuredHeight();
        if (this.O_renamed) {
            measuredHeight = this.d_renamed;
        } else {
            measuredHeight = this.J_renamed.getMeasuredHeight();
        }
        android.view.ViewGroup viewGroup = this.J_renamed;
        if (viewGroup == null || measuredHeight <= 0) {
            return;
        }
        int height = viewGroup.getHeight() + com.coui.appcompat.a_renamed.y_renamed.a_renamed(this.J_renamed, 3);
        if (z_renamed) {
            if (this.M_renamed) {
                measuredHeight = this.K_renamed;
            }
            i2 = measuredHeight + i_renamed;
        } else {
            i2 = (int) this.R_renamed;
        }
        if (z_renamed) {
            height = 0;
        } else if (this.M_renamed && this.N_renamed.getState() == 4) {
            height = this.K_renamed;
        }
        this.Q_renamed = new android.animation.AnimatorSet();
        if (z_renamed) {
            fAbs = java.lang.Math.abs(((i2 - height) * 120.0f) / this.d_renamed) + 300.0f;
            this.Q_renamed.setDuration((long) fAbs);
            this.Q_renamed.setInterpolator(f2514a);
        } else {
            height -= this.V_renamed;
            fAbs = java.lang.Math.abs(((i2 - height) * 50.0f) / this.d_renamed) + 200.0f;
            this.Q_renamed.setInterpolator(f2515b);
        }
        this.Q_renamed.setDuration((long) fAbs);
        if (animatorListener != null) {
            this.Q_renamed.addListener(animatorListener);
        }
        this.Q_renamed.playTogether(a_renamed(i2, height, i_renamed), f_renamed(z_renamed));
        this.Q_renamed.start();
        this.ab_renamed = !z_renamed;
    }

    private android.animation.ValueAnimator a_renamed(final int i_renamed, final int i2, int i3) {
        final float f_renamed;
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(i_renamed, i2);
        if (!this.ah_renamed || d_renamed() == null) {
            f_renamed = 0.0f;
        } else {
            f_renamed = i3 != 0 ? i3 : java.lang.Math.abs(d_renamed().d_renamed());
        }
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.dialog.panel.b_renamed.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                if (com.coui.appcompat.dialog.panel.b_renamed.this.J_renamed != null) {
                    float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                    com.coui.appcompat.dialog.panel.b_renamed.this.J_renamed.setTranslationY(fFloatValue);
                    if (!com.coui.appcompat.dialog.panel.b_renamed.this.T_renamed) {
                        com.coui.appcompat.dialog.panel.b_renamed.this.R_renamed = fFloatValue;
                    }
                    com.coui.appcompat.dialog.panel.b_renamed.this.T_renamed = false;
                    if (com.coui.appcompat.dialog.panel.b_renamed.this.ah_renamed) {
                        float f2 = f_renamed;
                        if (f2 == 0.0f || i_renamed <= i2 || fFloatValue > f2) {
                            return;
                        }
                        com.coui.appcompat.dialog.panel.b_renamed.this.l_renamed();
                        com.coui.appcompat.dialog.panel.b_renamed.this.ah_renamed = false;
                    }
                }
            }
        });
        return valueAnimatorOfFloat;
    }

    private android.animation.ValueAnimator f_renamed(boolean z_renamed) {
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(this.S_renamed, z_renamed ? 1.0f : 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.dialog.panel.b_renamed.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                if (com.coui.appcompat.dialog.panel.b_renamed.this.f_renamed != null) {
                    com.coui.appcompat.dialog.panel.b_renamed.this.S_renamed = fFloatValue;
                    com.coui.appcompat.dialog.panel.b_renamed.this.f_renamed.setAlpha(com.coui.appcompat.dialog.panel.b_renamed.this.S_renamed);
                }
            }
        });
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.animation.ValueAnimator b_renamed(int i_renamed) {
        if (com.coui.appcompat.a_renamed.k_renamed.b_renamed(getContext()) && getWindow() != null) {
            final android.view.Window window = getWindow();
            int navigationBarColor = window.getNavigationBarColor();
            if (android.graphics.Color.alpha(i_renamed) == 0) {
                i_renamed = android.graphics.Color.argb(1, android.graphics.Color.red(i_renamed), android.graphics.Color.green(i_renamed), android.graphics.Color.blue(i_renamed));
            }
            if (navigationBarColor != i_renamed) {
                android.animation.ValueAnimator valueAnimatorOfObject = android.animation.ValueAnimator.ofObject(new android.animation.ArgbEvaluator(), java.lang.Integer.valueOf(navigationBarColor), java.lang.Integer.valueOf(i_renamed));
                valueAnimatorOfObject.setDuration(200L);
                valueAnimatorOfObject.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.dialog.panel.b_renamed.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                        window.setNavigationBarColor(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                return valueAnimatorOfObject;
            }
        }
        return null;
    }

    public void b_renamed() {
        android.animation.AnimatorSet animatorSet;
        if (this.J_renamed == null || (animatorSet = this.Q_renamed) == null || animatorSet.isRunning()) {
            return;
        }
        a_renamed(this.J_renamed);
    }

    private void a_renamed(android.view.View view) {
        if (view == null) {
            return;
        }
        if (this.H_renamed == null || this.I_renamed != view) {
            this.I_renamed = view;
            this.H_renamed = com.a_renamed.a_renamed.j_renamed.c_renamed().b_renamed();
            this.H_renamed.a_renamed(com.a_renamed.a_renamed.g_renamed.b_renamed(3.8d, 20.0d));
            this.H_renamed.a_renamed(new com.a_renamed.a_renamed.h_renamed() { // from class: com.coui.appcompat.dialog.panel.b_renamed.5
                @Override // com.a_renamed.a_renamed.h_renamed
                public void b_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                }

                @Override // com.a_renamed.a_renamed.h_renamed
                public void c_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                }

                @Override // com.a_renamed.a_renamed.h_renamed
                public void d_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                }

                @Override // com.a_renamed.a_renamed.h_renamed
                public void a_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                    if (com.coui.appcompat.dialog.panel.b_renamed.this.H_renamed == null || com.coui.appcompat.dialog.panel.b_renamed.this.I_renamed == null) {
                        return;
                    }
                    int iC = (int) fVar.c_renamed();
                    if (iC >= 100) {
                        com.coui.appcompat.dialog.panel.b_renamed.this.H_renamed.b_renamed(0.0d);
                    }
                    com.coui.appcompat.dialog.panel.b_renamed.this.I_renamed.setTranslationY(iC);
                }
            });
        }
        this.H_renamed.b_renamed(100.0d);
    }

    private void q_renamed() {
        com.a_renamed.a_renamed.f_renamed fVar = this.H_renamed;
        if (fVar == null || fVar.e_renamed() == 0.0d) {
            return;
        }
        this.H_renamed.j_renamed();
        this.H_renamed = null;
    }

    public void a_renamed(android.view.View.OnTouchListener onTouchListener) {
        this.y_renamed = onTouchListener;
        android.view.View view = this.f_renamed;
        if (view != null) {
            view.setOnTouchListener(this.y_renamed);
        }
    }

    public void c_renamed(boolean z_renamed) {
        this.M_renamed = z_renamed;
        if (z_renamed) {
            this.O_renamed = false;
        }
    }

    public void d_renamed(boolean z_renamed) {
        if (this.B_renamed != z_renamed) {
            this.B_renamed = z_renamed;
            if (this.N_renamed instanceof com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) {
                this.X_renamed = this.B_renamed ? v_renamed() : null;
                ((com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) this.N_renamed).a_renamed(this.X_renamed);
            }
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, android.app.Dialog
    public void setCancelable(boolean z_renamed) {
        super.setCancelable(z_renamed);
        this.z_renamed = z_renamed;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z_renamed) {
        super.setCanceledOnTouchOutside(z_renamed);
        if (z_renamed && !this.z_renamed) {
            this.z_renamed = true;
        }
        this.A_renamed = z_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r_renamed() {
        com.coui.appcompat.dialog.panel.f_renamed fVar;
        android.view.inputmethod.InputMethodManager inputMethodManager = this.P_renamed;
        if (inputMethodManager == null || !inputMethodManager.isActive()) {
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 30 && getWindow() != null) {
            this.am_renamed = false;
        }
        if (!this.ak_renamed) {
            this.P_renamed.hideSoftInputFromWindow(this.h_renamed.getWindowToken(), 0);
        } else {
            if (android.os.Build.VERSION.SDK_INT < 30 || (fVar = this.ai_renamed) == null) {
                return;
            }
            fVar.e_renamed();
        }
    }

    public com.coui.appcompat.widget.l_renamed c_renamed() {
        return this.j_renamed;
    }

    private void a_renamed(android.view.Window window) {
        int i_renamed;
        if (window == null) {
            return;
        }
        android.view.View decorView = window.getDecorView();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            int systemUiVisibility = decorView.getSystemUiVisibility() | 1024;
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            if (com.coui.appcompat.a_renamed.e_renamed.a_renamed(getContext())) {
                i_renamed = systemUiVisibility & (-8193) & (-17);
            } else {
                i_renamed = android.os.Build.VERSION.SDK_INT >= 23 ? systemUiVisibility | 256 : systemUiVisibility | 16;
            }
            decorView.setSystemUiVisibility(i_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s_renamed() {
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.w_renamed;
        return (weakReference == null || weakReference.get() == null || !com.coui.appcompat.a_renamed.m_renamed.b_renamed(this.w_renamed.get())) ? false : true;
    }

    public com.coui.appcompat.dialog.panel.d_renamed d_renamed() {
        if (this.Y_renamed == null) {
            this.Y_renamed = new com.coui.appcompat.dialog.panel.d_renamed();
        }
        return this.Y_renamed;
    }

    private void a_renamed(android.animation.Animator animator) {
        if (animator == null || !animator.isRunning()) {
            return;
        }
        animator.end();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t_renamed() {
        android.view.View view = this.f_renamed;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this.ar_renamed);
        }
    }

    public void a_renamed(android.content.res.Configuration configuration) {
        this.U_renamed = true;
        if (d_renamed() != null) {
            d_renamed().a_renamed(this.j_renamed);
            d_renamed().a_renamed();
        }
        f_renamed();
        d_renamed(configuration);
        e_renamed(configuration);
        c_renamed(configuration);
        b_renamed(getContext().createConfigurationContext(configuration));
        b_renamed(configuration);
    }

    private void c_renamed(android.content.res.Configuration configuration) {
        this.d_renamed = com.coui.appcompat.a_renamed.m_renamed.a_renamed(getContext(), configuration);
        if (this.O_renamed) {
            a_renamed(((float) configuration.smallestScreenWidthDp) < 480.0f && !(configuration.orientation == 2), configuration);
        }
    }

    private void d_renamed(android.content.res.Configuration configuration) {
        if (this.J_renamed == null) {
            return;
        }
        com.coui.appcompat.a_renamed.y_renamed.a_renamed(this.J_renamed, 3, com.coui.appcompat.a_renamed.m_renamed.c_renamed(getContext(), configuration));
    }

    private void e_renamed(android.content.res.Configuration configuration) {
        com.coui.appcompat.widget.l_renamed lVar = this.j_renamed;
        if (lVar == null || this.J_renamed == null) {
            return;
        }
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) lVar.getLayoutParams();
        androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed eVar = (androidx.coordinatorlayout.widget.CoordinatorLayout.e_renamed) this.J_renamed.getLayoutParams();
        if (layoutParams == null || eVar == null) {
            return;
        }
        int iF = f_renamed(configuration);
        eVar.width = iF;
        layoutParams.width = iF;
        this.J_renamed.setLayoutParams(eVar);
        this.j_renamed.setLayoutParams(layoutParams);
    }

    private int f_renamed(android.content.res.Configuration configuration) {
        int i_renamed = configuration.smallestScreenWidthDp;
        boolean z_renamed = (configuration.screenLayout & 15) == 1;
        boolean z2 = configuration.orientation == 2;
        if (i_renamed >= 480.0f || (!z_renamed && z2)) {
            return (int) getContext().getResources().getDimension(coui.support.appcompat.R_renamed.dimen.coui_panel_landscape_width);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.animation.Animator.AnimatorListener u_renamed() {
        return new android.animation.AnimatorListenerAdapter() { // from class: com.coui.appcompat.dialog.panel.b_renamed.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                if (com.coui.appcompat.dialog.panel.b_renamed.this.N_renamed == null || com.coui.appcompat.dialog.panel.b_renamed.this.N_renamed.getState() != 5) {
                    return;
                }
                ((com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) com.coui.appcompat.dialog.panel.b_renamed.this.N_renamed).b_renamed(3);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                if (com.coui.appcompat.dialog.panel.b_renamed.this.J_renamed != null) {
                    com.coui.appcompat.dialog.panel.b_renamed.this.J_renamed.setTranslationY(com.coui.appcompat.dialog.panel.b_renamed.this.R_renamed);
                    if (com.coui.appcompat.dialog.panel.b_renamed.this.N_renamed != null && com.coui.appcompat.dialog.panel.b_renamed.this.N_renamed.getState() == 3 && com.coui.appcompat.dialog.panel.b_renamed.this.aq_renamed) {
                        com.coui.appcompat.dialog.panel.b_renamed.this.J_renamed.performHapticFeedback(14);
                    }
                }
                if (com.coui.appcompat.dialog.panel.b_renamed.this.ag_renamed && android.os.Build.VERSION.SDK_INT >= 30) {
                    com.coui.appcompat.dialog.panel.b_renamed.this.ai_renamed.e_renamed();
                    com.coui.appcompat.dialog.panel.b_renamed.this.P_renamed.showSoftInput(com.coui.appcompat.dialog.panel.b_renamed.this.j_renamed.findFocus(), 2);
                }
                com.coui.appcompat.dialog.panel.b_renamed.this.e_renamed(false);
            }
        };
    }

    private com.coui.appcompat.dialog.panel.g_renamed v_renamed() {
        return new com.coui.appcompat.dialog.panel.g_renamed() { // from class: com.coui.appcompat.dialog.panel.b_renamed.9
            @Override // com.coui.appcompat.dialog.panel.g_renamed
            public int a_renamed(int i_renamed, int i2) {
                if (com.coui.appcompat.dialog.panel.b_renamed.this.G_renamed != null && com.coui.appcompat.dialog.panel.b_renamed.this.G_renamed.e_renamed() != 0.0d) {
                    com.coui.appcompat.dialog.panel.b_renamed.this.G_renamed.j_renamed();
                    return com.coui.appcompat.dialog.panel.b_renamed.this.D_renamed;
                }
                int iA = androidx.core.c_renamed.a_renamed.a_renamed((int) (com.coui.appcompat.dialog.panel.b_renamed.this.F_renamed.getPaddingBottom() - (i_renamed * 0.19999999f)), 0, java.lang.Math.min(com.coui.appcompat.dialog.panel.b_renamed.this.C_renamed, com.coui.appcompat.dialog.panel.b_renamed.this.J_renamed.getTop()));
                if (com.coui.appcompat.dialog.panel.b_renamed.this.D_renamed != iA) {
                    com.coui.appcompat.dialog.panel.b_renamed.this.D_renamed = iA;
                    com.coui.appcompat.dialog.panel.b_renamed bVar = com.coui.appcompat.dialog.panel.b_renamed.this;
                    bVar.d_renamed(bVar.D_renamed);
                }
                return com.coui.appcompat.dialog.panel.b_renamed.this.D_renamed;
            }

            @Override // com.coui.appcompat.dialog.panel.g_renamed
            public void a_renamed(int i_renamed) {
                com.coui.appcompat.dialog.panel.b_renamed.this.d_renamed(false);
                int top = com.coui.appcompat.dialog.panel.b_renamed.this.J_renamed.getTop() - (i_renamed - com.coui.appcompat.dialog.panel.b_renamed.this.D_renamed);
                com.coui.appcompat.dialog.panel.b_renamed bVar = com.coui.appcompat.dialog.panel.b_renamed.this;
                bVar.c_renamed(bVar.D_renamed - top);
            }

            @Override // com.coui.appcompat.dialog.panel.g_renamed
            public void a_renamed() {
                com.coui.appcompat.dialog.panel.b_renamed.this.d_renamed(0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed(final int i_renamed) {
        this.G_renamed = com.a_renamed.a_renamed.j_renamed.c_renamed().b_renamed();
        this.G_renamed.a_renamed(com.a_renamed.a_renamed.g_renamed.b_renamed(6.0d, 42.0d));
        this.E_renamed = 0;
        this.G_renamed.a_renamed(new com.a_renamed.a_renamed.h_renamed() { // from class: com.coui.appcompat.dialog.panel.b_renamed.10
            @Override // com.a_renamed.a_renamed.h_renamed
            public void c_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
            }

            @Override // com.a_renamed.a_renamed.h_renamed
            public void d_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
            }

            @Override // com.a_renamed.a_renamed.h_renamed
            public void a_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                if (com.coui.appcompat.dialog.panel.b_renamed.this.G_renamed == null || com.coui.appcompat.dialog.panel.b_renamed.this.J_renamed == null) {
                    return;
                }
                if (fVar.h_renamed() && fVar.e_renamed() == 0.0d) {
                    com.coui.appcompat.dialog.panel.b_renamed.this.G_renamed.j_renamed();
                    return;
                }
                int iC = (int) fVar.c_renamed();
                com.coui.appcompat.dialog.panel.b_renamed.this.J_renamed.offsetTopAndBottom(iC - com.coui.appcompat.dialog.panel.b_renamed.this.E_renamed);
                com.coui.appcompat.dialog.panel.b_renamed.this.E_renamed = iC;
                com.coui.appcompat.dialog.panel.b_renamed.this.d_renamed(i_renamed - iC);
            }

            @Override // com.a_renamed.a_renamed.h_renamed
            public void b_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                if ((com.coui.appcompat.dialog.panel.b_renamed.this.N_renamed instanceof com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) && com.coui.appcompat.dialog.panel.b_renamed.this.F_renamed != null) {
                    com.coui.appcompat.dialog.panel.b_renamed.this.D_renamed = 0;
                    com.coui.appcompat.dialog.panel.b_renamed.this.d_renamed(0);
                    ((com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior) com.coui.appcompat.dialog.panel.b_renamed.this.N_renamed).setStateInternal(3);
                }
                com.coui.appcompat.dialog.panel.b_renamed.this.d_renamed(true);
            }
        });
        this.G_renamed.b_renamed(i_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed(int i_renamed) {
        android.view.View view = this.F_renamed;
        if (view != null) {
            view.setPadding(view.getPaddingLeft(), this.F_renamed.getPaddingTop(), this.F_renamed.getPaddingRight(), i_renamed);
        }
    }

    public void a_renamed(android.graphics.drawable.Drawable drawable) {
        com.coui.appcompat.widget.l_renamed lVar = this.j_renamed;
        if (lVar == null || drawable == null || this.u_renamed == drawable) {
            return;
        }
        this.u_renamed = drawable;
        lVar.setBackground(this.u_renamed);
    }

    public void a_renamed(boolean z_renamed, java.lang.String str, android.view.View.OnClickListener onClickListener, java.lang.String str2, android.view.View.OnClickListener onClickListener2, java.lang.String str3, android.view.View.OnClickListener onClickListener3) {
        this.l_renamed = z_renamed;
        a_renamed(str, onClickListener);
        b_renamed(str2, onClickListener2);
        c_renamed(str3, onClickListener3);
        w_renamed();
    }

    private void w_renamed() {
        com.coui.appcompat.widget.l_renamed lVar = this.j_renamed;
        if (lVar != null) {
            lVar.setDividerVisibility(this.l_renamed);
            this.j_renamed.a_renamed(this.m_renamed, this.n_renamed);
            this.j_renamed.b_renamed(this.o_renamed, this.p_renamed);
            this.j_renamed.c_renamed(this.q_renamed, this.r_renamed);
            this.j_renamed.b_renamed();
        }
    }

    public void a_renamed(java.lang.String str, android.view.View.OnClickListener onClickListener) {
        this.m_renamed = str;
        this.n_renamed = onClickListener;
    }

    public void b_renamed(java.lang.String str, android.view.View.OnClickListener onClickListener) {
        this.o_renamed = str;
        this.p_renamed = onClickListener;
    }

    public void c_renamed(java.lang.String str, android.view.View.OnClickListener onClickListener) {
        this.q_renamed = str;
        this.r_renamed = onClickListener;
    }

    public android.widget.Button e_renamed() {
        if (getWindow() != null) {
            return (android.widget.Button) getWindow().findViewById(android.R_renamed.id_renamed.button3);
        }
        return null;
    }
}
