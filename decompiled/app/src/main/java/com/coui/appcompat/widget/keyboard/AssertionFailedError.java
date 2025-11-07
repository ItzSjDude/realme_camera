package com.coui.appcompat.widget.keyboard;

/* loaded from: classes.dex */
public class SecurityKeyboardView extends android.view.View implements android.view.View.OnClickListener {
    private static int[][][] aJ_renamed;
    private static int[][] aK_renamed;
    private com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3[] A_renamed;
    private com.coui.appcompat.widget.keyboard.SecurityKeyboardView.b_renamed B_renamed;
    private int C_renamed;
    private int D_renamed;
    private boolean E_renamed;
    private boolean F_renamed;
    private boolean G_renamed;
    private int H_renamed;
    private int I_renamed;
    private int J_renamed;
    private int K_renamed;
    private int L_renamed;
    private int M_renamed;
    private boolean N_renamed;
    private android.graphics.Paint O_renamed;
    private android.graphics.Rect P_renamed;
    private long Q_renamed;
    private long R_renamed;
    private int S_renamed;
    private int T_renamed;
    private int U_renamed;
    private int V_renamed;
    private int W_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    android.os.Handler f2970a;
    private java.lang.StringBuilder aA_renamed;
    private boolean aB_renamed;
    private android.graphics.Rect aC_renamed;
    private android.graphics.Bitmap aD_renamed;
    private boolean aE_renamed;
    private android.graphics.Canvas aF_renamed;
    private android.view.accessibility.AccessibilityManager aG_renamed;
    private android.media.AudioManager aH_renamed;
    private int aM_renamed;
    private int aN_renamed;
    private android.content.res.ColorStateList aO_renamed;
    private android.content.res.ColorStateList aP_renamed;
    private android.graphics.drawable.Drawable aQ_renamed;
    private android.graphics.drawable.Drawable aR_renamed;
    private android.graphics.Typeface aS_renamed;
    private com.coui.appcompat.widget.keyboard.SecurityKeyboardView.c_renamed aT_renamed;
    private int aU_renamed;
    private int aV_renamed;
    private int aW_renamed;
    private int aX_renamed;
    private int aY_renamed;
    private int aZ_renamed;
    private long aa_renamed;
    private long ab_renamed;
    private int[] ac_renamed;
    private android.view.GestureDetector ad_renamed;
    private int ae_renamed;
    private int af_renamed;
    private int ag_renamed;
    private int ah_renamed;
    private boolean ai_renamed;
    private com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 aj_renamed;
    private android.graphics.Rect ak_renamed;
    private boolean al_renamed;
    private com.coui.appcompat.widget.keyboard.SecurityKeyboardView.d_renamed am_renamed;
    private int an_renamed;
    private boolean ao_renamed;
    private int ap_renamed;
    private float aq_renamed;
    private float ar_renamed;
    private android.graphics.drawable.Drawable as_renamed;
    private int[] av_renamed;
    private int aw_renamed;
    private int ax_renamed;
    private long ay_renamed;
    private boolean az_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected java.util.List<java.lang.Integer> f2971b;
    private boolean ba_renamed;
    private int bb_renamed;
    private boolean bc_renamed;
    private float bd_renamed;
    private int be_renamed;
    private int bf_renamed;
    private java.lang.String[] bg_renamed;
    private int bh_renamed;
    private android.content.res.ColorStateList bi_renamed;
    private int bj_renamed;
    private int bk_renamed;
    private int bl_renamed;
    private java.util.ArrayList<com.coui.appcompat.widget.keyboard.SecurityKeyboardView.a_renamed> bm_renamed;
    private java.util.ArrayList<android.graphics.drawable.Drawable> bn_renamed;
    private android.graphics.drawable.Drawable bo_renamed;
    private java.util.List<int[]> bp_renamed;
    private int bq_renamed;
    private com.coui.appcompat.widget.keyboard.a_renamed e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private float j_renamed;
    private int k_renamed;
    private float l_renamed;
    private android.widget.TextView m_renamed;
    private com.coui.appcompat.widget.popupwindow.e_renamed n_renamed;
    private int o_renamed;
    private int p_renamed;
    private int q_renamed;
    private final int[] r_renamed;
    private android.widget.PopupWindow s_renamed;
    private android.view.View t_renamed;
    private com.coui.appcompat.widget.keyboard.SecurityKeyboardView u_renamed;
    private boolean v_renamed;
    private android.view.View w_renamed;
    private int x_renamed;
    private int y_renamed;
    private java.util.Map<com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3, android.view.View> z_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final int[] f2969c = {-5};
    private static final int[] d_renamed = {android.R_renamed.attr.state_long_pressable};
    private static final int at_renamed = android.view.ViewConfiguration.getLongPressTimeout();
    private static int au_renamed = 12;
    private static final int[] aI_renamed = {android.R_renamed.attr.state_window_focused, 1, android.R_renamed.attr.state_selected, 2, android.R_renamed.attr.state_focused, 4, android.R_renamed.attr.state_enabled, 8, android.R_renamed.attr.state_pressed, 16, android.R_renamed.attr.state_activated, 32, android.R_renamed.attr.state_accelerated, 64, android.R_renamed.attr.state_hovered, 128, android.R_renamed.attr.state_drag_can_accept, 256, android.R_renamed.attr.state_drag_hovered, 512};
    private static int aL_renamed = coui.support.appcompat.R_renamed.styleable.ViewDrawableStates.length;

    public interface b_renamed {
        void a_renamed();

        void a_renamed(int i_renamed);

        void a_renamed(int i_renamed, int[] iArr);

        void a_renamed(java.lang.CharSequence charSequence);

        void b_renamed();

        void b_renamed(int i_renamed);

        void c_renamed();

        void d_renamed();
    }

    public interface c_renamed {
        void a_renamed(java.lang.String str, int i_renamed);
    }

    public void setVerticalCorrection(int i_renamed) {
    }

    static {
        int[] iArr = aI_renamed;
        int length = iArr.length / 2;
        if (length != aL_renamed) {
            throw new java.lang.IllegalStateException("VIEW_STATE_IDS array length does not match ViewDrawableStates style array");
        }
        int[] iArr2 = new int[iArr.length];
        for (int i_renamed = 0; i_renamed < aL_renamed; i_renamed++) {
            int i2 = coui.support.appcompat.R_renamed.styleable.ViewDrawableStates[i_renamed];
            int i3 = 0;
            while (true) {
                int[] iArr3 = aI_renamed;
                if (i3 < iArr3.length) {
                    if (iArr3[i3] == i2) {
                        int i4 = i_renamed * 2;
                        iArr2[i4] = i2;
                        iArr2[i4 + 1] = iArr3[i3 + 1];
                    }
                    i3 += 2;
                }
            }
        }
        int i5 = 1 << length;
        aJ_renamed = new int[i5][][];
        aK_renamed = new int[i5][];
        for (int i6 = 0; i6 < aK_renamed.length; i6++) {
            aK_renamed[i6] = new int[java.lang.Integer.bitCount(i6)];
            int i7 = 0;
            for (int i8 = 0; i8 < iArr2.length; i8 += 2) {
                if ((iArr2[i8 + 1] & i6) != 0) {
                    aK_renamed[i6][i7] = iArr2[i8];
                    i7++;
                }
            }
        }
    }

    public SecurityKeyboardView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, coui.support.appcompat.R_renamed.attr.securityKeyboardViewStyle);
    }

    public SecurityKeyboardView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, coui.support.appcompat.R_renamed.style.SecurityKeyboardView);
    }

    public SecurityKeyboardView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.f_renamed = -1;
        this.r_renamed = new int[2];
        this.E_renamed = false;
        this.F_renamed = true;
        this.G_renamed = true;
        this.V_renamed = -1;
        this.W_renamed = -1;
        this.ac_renamed = new int[12];
        this.ag_renamed = -1;
        this.ak_renamed = new android.graphics.Rect(0, 0, 0, 0);
        this.am_renamed = new com.coui.appcompat.widget.keyboard.SecurityKeyboardView.d_renamed();
        this.ap_renamed = 1;
        this.av_renamed = new int[au_renamed];
        this.aA_renamed = new java.lang.StringBuilder(1);
        this.aC_renamed = new android.graphics.Rect();
        this.f2971b = new java.util.ArrayList();
        this.aN_renamed = 0;
        this.aQ_renamed = null;
        this.aR_renamed = null;
        this.aS_renamed = null;
        this.aU_renamed = 0;
        this.aV_renamed = 0;
        this.aW_renamed = 0;
        this.aX_renamed = 0;
        this.aY_renamed = 0;
        this.aZ_renamed = 0;
        this.ba_renamed = true;
        this.bb_renamed = -1;
        this.bc_renamed = false;
        this.bd_renamed = -1.0f;
        this.be_renamed = -1;
        this.bf_renamed = -1;
        this.bg_renamed = null;
        this.bj_renamed = -1;
        this.bk_renamed = 2;
        this.bl_renamed = -1;
        this.bm_renamed = new java.util.ArrayList<>();
        this.bn_renamed = new java.util.ArrayList<>();
        this.bp_renamed = new java.util.ArrayList();
        if (attributeSet != null) {
            this.bq_renamed = attributeSet.getStyleAttribute();
            if (this.bq_renamed == 0) {
                this.bq_renamed = i_renamed;
            }
        } else {
            this.bq_renamed = i_renamed;
        }
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView, i_renamed, coui.support.appcompat.R_renamed.style.SecurityKeyboardView);
        android.view.LayoutInflater layoutInflater = (android.view.LayoutInflater) context.getSystemService("layout_inflater");
        this.as_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiSecurityKeyBackground);
        this.C_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiVerticalCorrection, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiKeyPreviewLayout, 0);
        this.p_renamed = typedArrayObtainStyledAttributes.getDimensionPixelOffset(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiKeyPreviewOffset, 0);
        this.q_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiKeyPreviewHeight, 80);
        this.aM_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiKeyPreviewWidth, 80);
        this.h_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiSecurityKeyTextSize, 18);
        this.i_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiSecurityKeyTextColor, -16777216);
        this.g_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiLabelTextSize, 14);
        this.ah_renamed = typedArrayObtainStyledAttributes.getResourceId(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiPopupLayout, 0);
        this.k_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiShadowColor, 0);
        this.j_renamed = typedArrayObtainStyledAttributes.getFloat(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiShadowRadius, 0.0f);
        this.aN_renamed = typedArrayObtainStyledAttributes.getInt(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiKeyBoardType, 0);
        this.aO_renamed = typedArrayObtainStyledAttributes.getColorStateList(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiTextColor);
        this.aP_renamed = typedArrayObtainStyledAttributes.getColorStateList(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiGoTextColor);
        this.aQ_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiSpecialKeyBg);
        this.aR_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiEndKeyBg);
        this.bi_renamed = typedArrayObtainStyledAttributes.getColorStateList(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiItemSymbolsColor);
        this.bo_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.SecurityKeyboardView_couiSpecialItemBg);
        this.l_renamed = 0.5f;
        this.n_renamed = new com.coui.appcompat.widget.popupwindow.e_renamed(context);
        if (resourceId != 0) {
            this.m_renamed = (android.widget.TextView) layoutInflater.inflate(resourceId, (android.view.ViewGroup) null);
            this.o_renamed = (int) this.m_renamed.getTextSize();
            this.n_renamed.setContentView(this.m_renamed);
            this.n_renamed.setBackgroundDrawable(null);
        } else {
            this.F_renamed = false;
        }
        this.n_renamed.setTouchable(false);
        this.n_renamed.a_renamed(new com.coui.appcompat.widget.popupwindow.e_renamed.b_renamed() { // from class: com.coui.appcompat.widget.keyboard.SecurityKeyboardView.1
            @Override // com.coui.appcompat.widget.popupwindow.e_renamed.b_renamed
            public void a_renamed(android.view.WindowManager.LayoutParams layoutParams) {
                layoutParams.flags |= 8192;
                layoutParams.setTitle("COUISecurityPopupWindow");
            }
        });
        this.s_renamed = new android.widget.PopupWindow(context);
        this.s_renamed.setBackgroundDrawable(null);
        this.w_renamed = this;
        this.O_renamed = new android.graphics.Paint();
        this.O_renamed.setAntiAlias(true);
        this.O_renamed.setTextSize(0);
        this.O_renamed.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.O_renamed.setAlpha(255);
        this.P_renamed = new android.graphics.Rect(0, 0, 0, 0);
        this.z_renamed = new java.util.HashMap();
        android.graphics.drawable.Drawable drawable = this.as_renamed;
        if (drawable != null) {
            drawable.getPadding(this.P_renamed);
        }
        this.an_renamed = (int) (getResources().getDisplayMetrics().density * 500.0f);
        this.ao_renamed = true;
        this.aG_renamed = (android.view.accessibility.AccessibilityManager) getContext().getSystemService("accessibility");
        this.aH_renamed = (android.media.AudioManager) context.getSystemService(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_AUDIO);
        n_renamed();
        setKeyboardType(1);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    @android.annotation.SuppressLint({"HandlerLeak"})
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        i_renamed();
        if (this.f2970a == null) {
            this.f2970a = new android.os.Handler() { // from class: com.coui.appcompat.widget.keyboard.SecurityKeyboardView.2
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) {
                    int i_renamed = message.what;
                    if (i_renamed == 1) {
                        com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.d_renamed(message.arg1);
                        return;
                    }
                    if (i_renamed == 2) {
                        android.util.Log.d_renamed("SecurityKeyboardView", "handleMessage MSG_REMOVE_PREVIEW");
                        com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.m_renamed.setVisibility(4);
                    } else if (i_renamed != 3) {
                        if (i_renamed != 4) {
                            return;
                        }
                        com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.a_renamed((android.view.MotionEvent) message.obj);
                    } else if (com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.k_renamed()) {
                        sendMessageDelayed(android.os.Message.obtain(this, 3), 50L);
                    }
                }
            };
        }
    }

    private void i_renamed() {
        if (this.ad_renamed == null) {
            this.ad_renamed = new android.view.GestureDetector(getContext(), new android.view.GestureDetector.SimpleOnGestureListener() { // from class: com.coui.appcompat.widget.keyboard.SecurityKeyboardView.3
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f_renamed, float f2) {
                    if (com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.al_renamed) {
                        return false;
                    }
                    float fAbs = java.lang.Math.abs(f_renamed);
                    float fAbs2 = java.lang.Math.abs(f2);
                    float x_renamed = motionEvent2.getX() - motionEvent.getX();
                    float y_renamed = motionEvent2.getY() - motionEvent.getY();
                    int width = com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.getWidth() / 2;
                    int height = com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.getHeight() / 2;
                    com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.am_renamed.a_renamed(1000);
                    float fB_renamed = com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.am_renamed.b_renamed();
                    float fC_renamed = com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.am_renamed.c_renamed();
                    boolean z_renamed = true;
                    if (f_renamed <= com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.an_renamed || fAbs2 >= fAbs || x_renamed <= width) {
                        if (f_renamed >= (-com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.an_renamed) || fAbs2 >= fAbs || x_renamed >= (-width)) {
                            if (f2 >= (-com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.an_renamed) || fAbs >= fAbs2 || y_renamed >= (-height)) {
                                if (f2 <= com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.an_renamed || fAbs >= fAbs2 / 2.0f || y_renamed <= height) {
                                    z_renamed = false;
                                } else if (!com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.ao_renamed || fC_renamed >= f2 / 4.0f) {
                                    com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.e_renamed();
                                    return true;
                                }
                            } else if (!com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.ao_renamed || fC_renamed <= f2 / 4.0f) {
                                com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.d_renamed();
                                return true;
                            }
                        } else if (!com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.ao_renamed || fB_renamed <= f_renamed / 4.0f) {
                            com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.c_renamed();
                            return true;
                        }
                    } else if (!com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.ao_renamed || fB_renamed >= f_renamed / 4.0f) {
                        com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.b_renamed();
                        return true;
                    }
                    if (z_renamed) {
                        com.coui.appcompat.widget.keyboard.SecurityKeyboardView securityKeyboardView = com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this;
                        securityKeyboardView.a_renamed(securityKeyboardView.W_renamed, com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.L_renamed, com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.M_renamed, motionEvent.getEventTime());
                    }
                    return false;
                }
            });
            this.ad_renamed.setIsLongpressEnabled(false);
        }
    }

    protected com.coui.appcompat.widget.keyboard.SecurityKeyboardView.b_renamed getOnKeyboardActionListener() {
        return this.B_renamed;
    }

    public void setOnKeyboardActionListener(com.coui.appcompat.widget.keyboard.SecurityKeyboardView.b_renamed bVar) {
        this.B_renamed = bVar;
    }

    public void setKeyBackground(android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            this.as_renamed = drawable;
            this.as_renamed.getPadding(this.P_renamed);
            invalidate();
        }
    }

    public void setKeyTextColor(int i_renamed) {
        if (i_renamed != this.i_renamed) {
            this.i_renamed = i_renamed;
            invalidate();
        }
    }

    public void setTextColor(android.content.res.ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.aO_renamed = colorStateList;
            invalidate();
        }
    }

    public void setGoTextColor(android.content.res.ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.aP_renamed = colorStateList;
            invalidate();
        }
    }

    public void setSpecialKeyBg(android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            this.aQ_renamed = drawable;
            invalidate();
        }
    }

    public void setEndKeyBg(android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            this.aR_renamed = drawable;
            invalidate();
        }
    }

    public void setItemTextColor(android.content.res.ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.bi_renamed = colorStateList;
            o_renamed();
            invalidate();
        }
    }

    public void setSpecialItemBg(android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            this.bo_renamed = drawable;
            o_renamed();
            invalidate();
        }
    }

    public com.coui.appcompat.widget.keyboard.a_renamed getKeyboard() {
        return this.e_renamed;
    }

    public void setKeyboard(com.coui.appcompat.widget.keyboard.a_renamed aVar) {
        if (this.e_renamed != null) {
            c_renamed(-1);
        }
        l_renamed();
        this.e_renamed = aVar;
        java.util.List<com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3> listA = this.e_renamed.a_renamed();
        this.A_renamed = (com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3[]) listA.toArray(new com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3[listA.size()]);
        requestLayout();
        this.aE_renamed = true;
        a_renamed();
        a_renamed(aVar);
        this.z_renamed.clear();
        this.ag_renamed = -1;
        this.ai_renamed = true;
    }

    public void setNewShifted(int i_renamed) {
        com.coui.appcompat.widget.keyboard.a_renamed aVar = this.e_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed);
            a_renamed();
        }
    }

    public int getNewShifted() {
        com.coui.appcompat.widget.keyboard.a_renamed aVar = this.e_renamed;
        if (aVar != null) {
            return aVar.d_renamed();
        }
        return -1;
    }

    public void setPreviewEnabled(boolean z_renamed) {
        this.F_renamed = z_renamed;
    }

    public void setPopupParent(android.view.View view) {
        this.w_renamed = view;
    }

    public void a_renamed(int i_renamed, int i2) {
        this.x_renamed = i_renamed;
        this.y_renamed = i2;
        if (this.n_renamed.isShowing()) {
            android.util.Log.d_renamed("SecurityKeyboardView", "PopupView is_renamed Showing");
            this.n_renamed.dismiss();
        }
    }

    public void setProximityCorrectionEnabled(boolean z_renamed) {
        this.N_renamed = z_renamed;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        m_renamed();
    }

    private java.lang.CharSequence a_renamed(java.lang.CharSequence charSequence) {
        return (getNewShifted() < 1 || charSequence == null || charSequence.length() >= 3 || !java.lang.Character.isLowerCase(charSequence.charAt(0))) ? charSequence : charSequence.toString().toUpperCase();
    }

    @Override // android.view.View
    public void onMeasure(int i_renamed, int i2) {
        if (this.e_renamed == null) {
            setMeasuredDimension(getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        } else {
            setMeasuredDimension(android.view.View.MeasureSpec.getSize(i_renamed), this.e_renamed.b_renamed() + getPaddingTop() + getPaddingBottom());
        }
    }

    private void a_renamed(com.coui.appcompat.widget.keyboard.a_renamed aVar) {
        com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3[] c0060aArr;
        if (aVar == null || (c0060aArr = this.A_renamed) == null) {
            return;
        }
        int length = c0060aArr.length;
        int iMin = 0;
        for (com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a : c0060aArr) {
            iMin += java.lang.Math.min(c0060a.e_renamed, c0060a.f_renamed) + c0060a.g_renamed;
        }
        if (iMin < 0 || length == 0) {
            return;
        }
        this.D_renamed = (int) ((iMin * 1.4f) / length);
        int i_renamed = this.D_renamed;
        this.D_renamed = i_renamed * i_renamed;
    }

    @Override // android.view.View
    public void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        super.onSizeChanged(i_renamed, i2, i3, i4);
        com.coui.appcompat.widget.keyboard.a_renamed aVar = this.e_renamed;
        this.aD_renamed = null;
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (this.aB_renamed || this.aD_renamed == null || this.aE_renamed) {
            j_renamed();
        }
        canvas.drawBitmap(this.aD_renamed, 0.0f, 0.0f, (android.graphics.Paint) null);
        if (h_renamed()) {
            a_renamed(canvas, this.bh_renamed);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:130:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:133:0x0247  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j_renamed() {
        /*
            Method dump skipped, instructions count: 786
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.keyboard.SecurityKeyboardView.j_renamed():void");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:14:0x003f A_renamed[PHI: r6
      0x003f: PHI (r6v9 int) = (r6v3 int), (r6v11 int) binds: [B_renamed:13:0x003d, B_renamed:10:0x0039] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:31:0x0086 A_renamed[PHI: r12 r13
      0x0086: PHI (r12v2 int) = (r12v1 int), (r12v5 int) binds: [B_renamed:16:0x0044, B_renamed:20:0x004e] A_renamed[DONT_GENERATE, DONT_INLINE]
      0x0086: PHI (r13v2 int) = (r13v1 int), (r13v5 int) binds: [B_renamed:16:0x0044, B_renamed:20:0x004e] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int a_renamed(int r19, int r20, int[] r21) {
        /*
            Method dump skipped, instructions count: 179
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.keyboard.SecurityKeyboardView.a_renamed(int, int, int[]):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, int i2, int i3, long j_renamed) {
        if (i_renamed != -1) {
            com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3[] c0060aArr = this.A_renamed;
            if (i_renamed < c0060aArr.length) {
                com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a = c0060aArr[i_renamed];
                if (c0060a.m_renamed != null) {
                    this.B_renamed.a_renamed(c0060a.m_renamed);
                    this.B_renamed.b_renamed(-1);
                } else {
                    int i4 = c0060a.f2985a[0];
                    int[] iArr = new int[au_renamed];
                    java.util.Arrays.fill(iArr, -1);
                    a_renamed(i2, i3, iArr);
                    if (this.az_renamed) {
                        if (this.ax_renamed != -1) {
                            this.B_renamed.a_renamed(-5, f2969c);
                            a_renamed(i4, c0060a);
                        } else {
                            this.ax_renamed = 0;
                        }
                        i4 = c0060a.f2985a[this.ax_renamed];
                    }
                    a_renamed(i4, c0060a);
                    this.B_renamed.a_renamed(i4, iArr);
                    this.B_renamed.b_renamed(i4);
                }
                this.aw_renamed = i_renamed;
                this.ay_renamed = j_renamed;
            }
        }
    }

    private java.lang.CharSequence b_renamed(com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a) {
        if (this.az_renamed) {
            this.aA_renamed.setLength(0);
            java.lang.StringBuilder sb = this.aA_renamed;
            int[] iArr = c0060a.f2985a;
            int i_renamed = this.ax_renamed;
            sb.append((char) iArr[i_renamed >= 0 ? i_renamed : 0]);
            return a_renamed(this.aA_renamed);
        }
        return a_renamed(c0060a.f2986b);
    }

    private void c_renamed(int i_renamed) {
        int i2 = this.f_renamed;
        com.coui.appcompat.widget.popupwindow.e_renamed eVar = this.n_renamed;
        this.f_renamed = i_renamed;
        com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3[] c0060aArr = this.A_renamed;
        int i3 = this.f_renamed;
        if (i2 != i3) {
            if (i2 != -1 && c0060aArr.length > i2) {
                com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a = c0060aArr[i2];
                c0060a.a_renamed(i3 == -1);
                a_renamed(i2);
                int i4 = c0060a.f2985a[0];
                c_renamed(256, i4);
                c_renamed(65536, i4);
            }
            int i5 = this.f_renamed;
            if (i5 != -1 && c0060aArr.length > i5) {
                com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a2 = c0060aArr[i5];
                c0060a2.a_renamed();
                a_renamed(this.f_renamed);
                int i6 = c0060a2.f2985a[0];
                a_renamed(128, i6, c0060a2);
                a_renamed(32768, i6, c0060a2);
            }
        }
        boolean zF = f_renamed(this.f_renamed);
        if (i2 != this.f_renamed && this.F_renamed && zF) {
            this.f2970a.removeMessages(1);
            if (eVar.isShowing() && i_renamed == -1) {
                android.os.Handler handler = this.f2970a;
                handler.sendMessageDelayed(handler.obtainMessage(2), 75L);
            }
            if (i_renamed != -1) {
                if (eVar.isShowing() && this.m_renamed.getVisibility() == 0) {
                    d_renamed(i_renamed);
                } else {
                    d_renamed(i_renamed);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed(int i_renamed) {
        com.coui.appcompat.widget.popupwindow.e_renamed eVar = this.n_renamed;
        com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3[] c0060aArr = this.A_renamed;
        if (i_renamed < 0 || i_renamed >= c0060aArr.length) {
            return;
        }
        com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a = c0060aArr[i_renamed];
        if (c0060a.f2987c != null) {
            this.m_renamed.setCompoundDrawables(null, null, null, c0060a.d_renamed != null ? c0060a.d_renamed : c0060a.f2987c);
            this.m_renamed.setText((java.lang.CharSequence) null);
        } else {
            this.m_renamed.setCompoundDrawables(null, null, null, null);
            this.m_renamed.setText(b_renamed(c0060a));
            if (c0060a.f2986b.length() > 1 && c0060a.f2985a.length < 2) {
                this.m_renamed.setTextSize(0, this.h_renamed);
                this.m_renamed.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
            } else {
                this.m_renamed.setTextSize(0, this.o_renamed);
                this.m_renamed.setTypeface(this.aS_renamed);
            }
        }
        this.m_renamed.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        int i2 = this.aM_renamed;
        int i3 = this.q_renamed;
        android.view.ViewGroup.LayoutParams layoutParams = this.m_renamed.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i2;
            layoutParams.height = i3;
        }
        if (!this.E_renamed) {
            this.H_renamed = ((c0060a.i_renamed + (c0060a.e_renamed / 2)) - (this.aM_renamed / 2)) + getPaddingLeft();
            this.I_renamed = (c0060a.j_renamed - i3) + this.p_renamed;
        } else {
            this.H_renamed = 160 - (this.m_renamed.getMeasuredWidth() / 2);
            this.I_renamed = -this.m_renamed.getMeasuredHeight();
        }
        this.f2970a.removeMessages(2);
        getLocationInWindow(this.r_renamed);
        int[] iArr = this.r_renamed;
        iArr[0] = iArr[0] + this.x_renamed;
        iArr[1] = iArr[1] + this.y_renamed;
        this.m_renamed.getBackground().setState(c0060a.r_renamed != 0 ? d_renamed : EMPTY_STATE_SET);
        int i4 = this.H_renamed;
        int[] iArr2 = this.r_renamed;
        this.H_renamed = i4 + iArr2[0];
        this.I_renamed += iArr2[1];
        getLocationOnScreen(iArr2);
        if (this.I_renamed + this.r_renamed[1] < 0) {
            if (c0060a.i_renamed + c0060a.e_renamed <= getWidth() / 2) {
                this.H_renamed += (int) (c0060a.e_renamed * 2.5d);
            } else {
                this.H_renamed -= (int) (c0060a.e_renamed * 2.5d);
            }
            this.I_renamed += i3;
        }
        if (eVar.isShowing()) {
            eVar.update(this.H_renamed, this.I_renamed, i2, i3);
        } else {
            eVar.setWidth(i2);
            eVar.setHeight(i3);
            eVar.showAtLocation(this.w_renamed, 0, this.H_renamed, this.I_renamed);
        }
        this.m_renamed.setVisibility(0);
    }

    private void c_renamed(int i_renamed, int i2) {
        java.lang.String string;
        android.view.accessibility.AccessibilityManager accessibilityManager = this.aG_renamed;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        android.view.accessibility.AccessibilityEvent accessibilityEventObtain = android.view.accessibility.AccessibilityEvent.obtain(i_renamed);
        onInitializeAccessibilityEvent(accessibilityEventObtain);
        if (i2 != 10) {
            switch (i2) {
                case -6:
                    string = getContext().getString(coui.support.appcompat.R_renamed.string.keyboardview_keycode_alt);
                    break;
                case -5:
                    string = getContext().getString(coui.support.appcompat.R_renamed.string.keyboardview_keycode_delete);
                    break;
                case -4:
                    string = getContext().getString(coui.support.appcompat.R_renamed.string.keyboardview_keycode_done);
                    break;
                case -3:
                    string = getContext().getString(coui.support.appcompat.R_renamed.string.keyboardview_keycode_cancel);
                    break;
                case -2:
                    string = getContext().getString(coui.support.appcompat.R_renamed.string.keyboardview_keycode_mode_change);
                    break;
                case -1:
                    string = getContext().getString(coui.support.appcompat.R_renamed.string.keyboardview_keycode_shift);
                    break;
                default:
                    string = java.lang.String.valueOf((char) i2);
                    break;
            }
        } else {
            string = getContext().getString(coui.support.appcompat.R_renamed.string.keyboardview_keycode_enter);
        }
        accessibilityEventObtain.getText().add(string);
        this.aG_renamed.sendAccessibilityEvent(accessibilityEventObtain);
    }

    public void a_renamed() {
        this.aC_renamed.union(0, 0, getWidth(), getHeight());
        this.aB_renamed = true;
        invalidate();
    }

    public void a_renamed(int i_renamed) {
        com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3[] c0060aArr = this.A_renamed;
        if (c0060aArr != null && i_renamed >= 0 && i_renamed < c0060aArr.length) {
            com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a = c0060aArr[i_renamed];
            this.aj_renamed = c0060a;
            this.aC_renamed.union(c0060a.i_renamed + getPaddingLeft(), c0060a.j_renamed + getPaddingTop(), c0060a.i_renamed + c0060a.e_renamed + getPaddingLeft(), c0060a.j_renamed + c0060a.f_renamed + getPaddingTop());
            j_renamed();
            invalidate(c0060a.i_renamed + getPaddingLeft(), c0060a.j_renamed + getPaddingTop(), c0060a.i_renamed + c0060a.e_renamed + getPaddingLeft(), c0060a.j_renamed + c0060a.f_renamed + getPaddingTop());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a_renamed(android.view.MotionEvent motionEvent) {
        int i_renamed;
        if (this.ah_renamed != 0 && (i_renamed = this.V_renamed) >= 0) {
            com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3[] c0060aArr = this.A_renamed;
            if (i_renamed < c0060aArr.length) {
                boolean zA = a_renamed(c0060aArr[i_renamed]);
                if (zA) {
                    this.ai_renamed = true;
                    c_renamed(-1);
                }
                return zA;
            }
        }
        return false;
    }

    protected boolean a_renamed(com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a) {
        com.coui.appcompat.widget.keyboard.a_renamed aVar;
        int i_renamed = c0060a.r_renamed;
        if (i_renamed == 0) {
            return false;
        }
        this.t_renamed = this.z_renamed.get(c0060a);
        android.view.View view = this.t_renamed;
        if (view == null) {
            this.t_renamed = ((android.view.LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(this.ah_renamed, (android.view.ViewGroup) null);
            this.u_renamed = (com.coui.appcompat.widget.keyboard.SecurityKeyboardView) this.t_renamed.findViewById(android.R_renamed.id_renamed.keyboardView);
            android.view.View viewFindViewById = this.t_renamed.findViewById(android.R_renamed.id_renamed.closeButton);
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(this);
            }
            this.u_renamed.setOnKeyboardActionListener(new com.coui.appcompat.widget.keyboard.SecurityKeyboardView.b_renamed() { // from class: com.coui.appcompat.widget.keyboard.SecurityKeyboardView.4
                @Override // com.coui.appcompat.widget.keyboard.SecurityKeyboardView.b_renamed
                public void a_renamed() {
                }

                @Override // com.coui.appcompat.widget.keyboard.SecurityKeyboardView.b_renamed
                public void b_renamed() {
                }

                @Override // com.coui.appcompat.widget.keyboard.SecurityKeyboardView.b_renamed
                public void c_renamed() {
                }

                @Override // com.coui.appcompat.widget.keyboard.SecurityKeyboardView.b_renamed
                public void d_renamed() {
                }

                @Override // com.coui.appcompat.widget.keyboard.SecurityKeyboardView.b_renamed
                public void a_renamed(int i2, int[] iArr) {
                    com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.B_renamed.a_renamed(i2, iArr);
                    com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.m_renamed();
                }

                @Override // com.coui.appcompat.widget.keyboard.SecurityKeyboardView.b_renamed
                public void a_renamed(java.lang.CharSequence charSequence) {
                    com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.B_renamed.a_renamed(charSequence);
                    com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.m_renamed();
                }

                @Override // com.coui.appcompat.widget.keyboard.SecurityKeyboardView.b_renamed
                public void a_renamed(int i2) {
                    com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.B_renamed.a_renamed(i2);
                }

                @Override // com.coui.appcompat.widget.keyboard.SecurityKeyboardView.b_renamed
                public void b_renamed(int i2) {
                    com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.B_renamed.b_renamed(i2);
                }
            });
            if (c0060a.n_renamed != null) {
                aVar = new com.coui.appcompat.widget.keyboard.a_renamed(getContext(), i_renamed, c0060a.n_renamed, -1, getPaddingRight() + getPaddingLeft());
            } else {
                aVar = new com.coui.appcompat.widget.keyboard.a_renamed(getContext(), i_renamed);
            }
            this.u_renamed.setKeyboard(aVar);
            this.u_renamed.setPopupParent(this);
            this.t_renamed.measure(android.view.View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), android.view.View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
            this.z_renamed.put(c0060a, this.t_renamed);
        } else {
            this.u_renamed = (com.coui.appcompat.widget.keyboard.SecurityKeyboardView) view.findViewById(android.R_renamed.id_renamed.keyboardView);
        }
        getLocationInWindow(this.r_renamed);
        this.ae_renamed = c0060a.i_renamed + getPaddingLeft();
        this.af_renamed = c0060a.j_renamed + getPaddingTop();
        this.ae_renamed = (this.ae_renamed + c0060a.e_renamed) - this.t_renamed.getMeasuredWidth();
        this.af_renamed -= this.t_renamed.getMeasuredHeight();
        int paddingRight = this.ae_renamed + this.t_renamed.getPaddingRight() + this.r_renamed[0];
        int paddingBottom = this.af_renamed + this.t_renamed.getPaddingBottom() + this.r_renamed[1];
        this.u_renamed.a_renamed(paddingRight < 0 ? 0 : paddingRight, paddingBottom);
        this.u_renamed.setNewShifted(getNewShifted());
        this.s_renamed.setContentView(this.t_renamed);
        this.s_renamed.setWidth(this.t_renamed.getMeasuredWidth());
        this.s_renamed.setHeight(this.t_renamed.getMeasuredHeight());
        this.s_renamed.showAtLocation(this, 0, paddingRight, paddingBottom);
        this.v_renamed = true;
        a_renamed();
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(android.view.MotionEvent motionEvent) {
        android.view.accessibility.AccessibilityManager accessibilityManager = this.aG_renamed;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled() && motionEvent.getPointerCount() == 1) {
            int action = motionEvent.getAction();
            if (action == 7) {
                motionEvent.setAction(2);
            } else if (action == 9) {
                motionEvent.setAction(0);
            } else if (action == 10) {
                motionEvent.setAction(1);
            }
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction();
        long eventTime = motionEvent.getEventTime();
        boolean zA = true;
        if (pointerCount != this.ap_renamed) {
            if (pointerCount == 1) {
                android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(eventTime, eventTime, 0, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
                boolean zA2 = a_renamed(motionEventObtain, false);
                motionEventObtain.recycle();
                zA = action == 1 ? a_renamed(motionEvent, true) : zA2;
            } else {
                android.view.MotionEvent motionEventObtain2 = android.view.MotionEvent.obtain(eventTime, eventTime, 1, this.aq_renamed, this.ar_renamed, motionEvent.getMetaState());
                zA = a_renamed(motionEventObtain2, true);
                motionEventObtain2.recycle();
            }
        } else if (pointerCount == 1) {
            zA = a_renamed(motionEvent, false);
            this.aq_renamed = motionEvent.getX();
            this.ar_renamed = motionEvent.getY();
        }
        this.ap_renamed = pointerCount;
        return zA;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:113:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:122:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:148:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:65:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:68:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:71:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:74:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a_renamed(android.view.MotionEvent r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 866
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.keyboard.SecurityKeyboardView.a_renamed(android.view.MotionEvent, boolean):boolean");
    }

    private void e_renamed(int i_renamed) {
        java.lang.String string;
        android.view.accessibility.AccessibilityManager accessibilityManager = this.aG_renamed;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        if (i_renamed == 0) {
            string = getContext().getString(coui.support.appcompat.R_renamed.string.coui_keyboardview_keycode_asterisk);
        } else if (i_renamed == 1) {
            string = getContext().getString(coui.support.appcompat.R_renamed.string.coui_keyboardview_keycode_minus);
        } else if (i_renamed == 2) {
            string = getContext().getString(coui.support.appcompat.R_renamed.string.coui_keyboardview_keycode_atsymbol);
        } else {
            string = i_renamed != 3 ? null : getContext().getString(coui.support.appcompat.R_renamed.string.coui_keyboardview_keycode_dollar);
        }
        if (string != null) {
            announceForAccessibility(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k_renamed() {
        com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a = this.A_renamed[this.ag_renamed];
        a_renamed(this.V_renamed, c0060a.i_renamed, c0060a.j_renamed, this.ay_renamed);
        return true;
    }

    protected void b_renamed() {
        this.B_renamed.b_renamed();
    }

    protected void c_renamed() {
        this.B_renamed.a_renamed();
    }

    protected void d_renamed() {
        this.B_renamed.c_renamed();
    }

    protected void e_renamed() {
        this.B_renamed.d_renamed();
    }

    public void f_renamed() {
        if (this.n_renamed.isShowing()) {
            this.n_renamed.dismiss();
        }
        this.bb_renamed = -1;
        l_renamed();
        m_renamed();
        this.aD_renamed = null;
        this.aF_renamed = null;
        this.z_renamed.clear();
    }

    private void l_renamed() {
        android.os.Handler handler = this.f2970a;
        if (handler != null) {
            handler.removeMessages(3);
            this.f2970a.removeMessages(4);
            this.f2970a.removeMessages(1);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_renamed() {
        if (this.s_renamed.isShowing()) {
            this.s_renamed.dismiss();
            this.v_renamed = false;
            a_renamed();
        }
    }

    private void n_renamed() {
        this.aw_renamed = -1;
        this.ax_renamed = 0;
        this.ay_renamed = -1L;
        this.az_renamed = false;
    }

    private void a_renamed(long j_renamed, int i_renamed) {
        if (i_renamed == -1) {
            return;
        }
        com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a = this.A_renamed[i_renamed];
        if (c0060a.f2985a.length <= 1) {
            if (j_renamed > this.ay_renamed + 800 || i_renamed != this.aw_renamed) {
                n_renamed();
                return;
            }
            return;
        }
        this.az_renamed = true;
        if (j_renamed < this.ay_renamed + 800 && i_renamed == this.aw_renamed) {
            this.ax_renamed = (this.ax_renamed + 1) % c0060a.f2985a.length;
        } else {
            this.ax_renamed = -1;
        }
    }

    private void a_renamed(android.graphics.Canvas canvas, int i_renamed) {
        float f_renamed = this.bf_renamed;
        java.lang.String[] strArr = this.bg_renamed;
        float length = (f_renamed - ((strArr.length - 1) * this.bd_renamed)) / strArr.length;
        for (int i2 = 0; i2 < this.bg_renamed.length; i2++) {
            android.graphics.drawable.Drawable drawableD = this.bm_renamed.get(i2).d_renamed();
            if (drawableD != null) {
                int paddingLeft = getPaddingLeft() + i_renamed;
                int i3 = this.be_renamed + paddingLeft;
                float f2 = i2;
                float f3 = length * f2;
                int paddingTop = (int) (getPaddingTop() + f3 + (this.bd_renamed * f2));
                float paddingTop2 = getPaddingTop() + f3 + (f2 * this.bd_renamed);
                drawableD.setBounds(paddingLeft, paddingTop, i3, (int) (paddingTop + length));
                drawableD.draw(canvas);
                this.bm_renamed.get(i2).b_renamed(paddingTop2 + length);
                this.bm_renamed.get(i2).a_renamed(paddingTop2);
            }
        }
        for (int i4 = 0; i4 < this.bg_renamed.length; i4++) {
            android.text.TextPaint textPaint = this.bm_renamed.get(i4).h_renamed;
            android.graphics.Paint.FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
            if (this.bg_renamed[i4] != null) {
                canvas.drawText(this.bg_renamed[i4], getPaddingLeft() + ((this.be_renamed - ((int) textPaint.measureText(r4))) / 2) + i_renamed, (int) (((((getPaddingTop() + this.bk_renamed) + (i4 * (this.bd_renamed + length))) + (length / 2.0f)) - ((fontMetricsInt.descent - fontMetricsInt.ascent) / 2)) - fontMetricsInt.ascent), textPaint);
            }
        }
    }

    private void a_renamed(int i_renamed, com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a) {
        com.coui.appcompat.widget.keyboard.SecurityKeyboardView.c_renamed cVar = this.aT_renamed;
        if (cVar == null || i_renamed == -1 || i_renamed == -2 || i_renamed == -6 || i_renamed == -7) {
            return;
        }
        if (i_renamed == 10) {
            cVar.a_renamed("", 2);
            return;
        }
        if (i_renamed == 32) {
            cVar.a_renamed(" ", 0);
            return;
        }
        if (i_renamed == -5) {
            cVar.a_renamed("", 1);
            return;
        }
        java.lang.String string = c0060a.f2986b == null ? null : a_renamed(c0060a.f2986b).toString();
        if (string != null) {
            this.aT_renamed.a_renamed(string, 0);
        }
    }

    private void o_renamed() {
        int length = this.bg_renamed.length;
        if (length < 0) {
            return;
        }
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            this.bn_renamed.add(this.bo_renamed.getConstantState().newDrawable());
            this.bm_renamed.add(new com.coui.appcompat.widget.keyboard.SecurityKeyboardView.a_renamed(this.bn_renamed.get(i_renamed), this.bg_renamed[i_renamed]));
        }
        for (int i2 = 0; i2 < length; i2++) {
            int[][][] iArr = aJ_renamed;
            int[][] iArr2 = aK_renamed;
            iArr[i2] = new int[iArr2.length][];
            java.lang.System.arraycopy(iArr2, 0, iArr[i2], 0, iArr2.length);
        }
        this.bp_renamed.clear();
        this.f2971b.clear();
        for (int i3 = 0; i3 < length; i3++) {
            this.bp_renamed.add(new int[aL_renamed]);
            this.f2971b.add(new java.lang.Integer(0));
            a_renamed(i3, this.bm_renamed.get(i3).d_renamed());
            android.content.res.ColorStateList colorStateList = this.bi_renamed;
            if (colorStateList != null) {
                this.bm_renamed.get(i3).h_renamed.setColor(colorStateList.getColorForState(b_renamed(i3), this.bi_renamed.getDefaultColor()));
            }
        }
    }

    protected void a_renamed(int i_renamed, android.graphics.drawable.Drawable drawable) {
        this.f2971b.set(i_renamed, java.lang.Integer.valueOf(this.f2971b.get(i_renamed).intValue() | 1024));
        b_renamed(i_renamed, drawable);
    }

    protected void b_renamed(int i_renamed, android.graphics.drawable.Drawable drawable) {
        int[] iArrB = b_renamed(i_renamed);
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(iArrB);
    }

    protected int[] b_renamed(int i_renamed) {
        int iIntValue = this.f2971b.get(i_renamed).intValue();
        if ((iIntValue & 1024) != 0) {
            this.bp_renamed.set(i_renamed, b_renamed(i_renamed, 0));
            this.f2971b.set(i_renamed, java.lang.Integer.valueOf(iIntValue & (-1025)));
        }
        return this.bp_renamed.get(i_renamed);
    }

    protected int[] b_renamed(int i_renamed, int i2) {
        int iIntValue = this.f2971b.get(i_renamed).intValue();
        int i3 = (this.f2971b.get(i_renamed).intValue() & 16384) != 0 ? 16 : 0;
        if ((iIntValue & 32) == 0) {
            i3 |= 8;
        }
        if (hasWindowFocus()) {
            i3 |= 1;
        }
        int[] iArr = aJ_renamed[i_renamed][i3];
        if (i2 == 0) {
            return iArr;
        }
        if (iArr != null) {
            int[] iArr2 = new int[iArr.length + i2];
            java.lang.System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            return iArr2;
        }
        return new int[i2];
    }

    private void a_renamed(int i_renamed, boolean z_renamed) {
        int iIntValue = this.f2971b.get(i_renamed).intValue();
        this.f2971b.set(i_renamed, java.lang.Integer.valueOf(z_renamed ? iIntValue | 16384 : iIntValue & (-16385)));
    }

    private int d_renamed(int i_renamed, int i2) {
        java.lang.String[] strArr;
        int length;
        if (!h_renamed() || (strArr = this.bg_renamed) == null || (length = strArr.length) <= 0) {
            return -1;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (i_renamed >= getPaddingLeft() && i_renamed <= this.be_renamed + getPaddingLeft()) {
                float f_renamed = i2;
                if (f_renamed >= this.bm_renamed.get(i3).a_renamed() && f_renamed <= this.bm_renamed.get(i3).b_renamed()) {
                    return i3;
                }
            }
        }
        return -1;
    }

    private void setItemRestore(int i_renamed) {
        a_renamed(i_renamed, false);
        android.graphics.drawable.Drawable drawableD = this.bm_renamed.get(i_renamed).d_renamed();
        java.lang.String strC = this.bm_renamed.get(i_renamed).c_renamed();
        a_renamed(i_renamed, drawableD);
        if (strC == null || this.bi_renamed == null) {
            return;
        }
        int[] iArrB = b_renamed(i_renamed);
        android.content.res.ColorStateList colorStateList = this.bi_renamed;
        this.bm_renamed.get(i_renamed).h_renamed.setColor(colorStateList.getColorForState(iArrB, colorStateList.getDefaultColor()));
        invalidate();
    }

    public boolean g_renamed() {
        return this.ba_renamed;
    }

    public void setKeyboardViewEnabled(boolean z_renamed) {
        this.ba_renamed = z_renamed;
    }

    public void setOnKeyboardCharListener(com.coui.appcompat.widget.keyboard.SecurityKeyboardView.c_renamed cVar) {
        this.aT_renamed = cVar;
    }

    public void setKeyboardType(int i_renamed) {
        this.aS_renamed = android.graphics.Typeface.DEFAULT;
        this.aU_renamed = getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_security_keyboard_lower_letter_text_size);
        this.aW_renamed = getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_security_keyboard_space_label_text_size);
        this.aV_renamed = getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_security_keyboard_lower_letter_text_size);
        this.aX_renamed = getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_security_keyboard_end_label_text_size);
        this.bj_renamed = getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_security_numeric_keyboard_special_text_size);
        this.aY_renamed = getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_password_kbd_symbols_special_symbols_textSize);
        this.aZ_renamed = getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_password_kbd_skip_symbols_key_labelSize);
        this.bd_renamed = getResources().getDimension(coui.support.appcompat.R_renamed.dimen.coui_password_numeric_keyboard_line_width);
        this.bg_renamed = getResources().getStringArray(coui.support.appcompat.R_renamed.array.coui_security_numeric_keyboard_special_symbol);
        this.bh_renamed = getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_security_numeric_keyboard_special_symbol_offset);
        this.be_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_security_password_numeric_delete_dimen_keyWidth);
        this.bf_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_security_password_numeric_special_height);
        this.be_renamed = (int) (this.be_renamed * com.coui.appcompat.widget.keyboard.a_renamed.a_renamed(getContext()));
        this.bf_renamed = (int) (this.bf_renamed * com.coui.appcompat.widget.keyboard.a_renamed.a_renamed(getContext()));
        this.bd_renamed *= com.coui.appcompat.widget.keyboard.a_renamed.a_renamed(getContext());
        this.bh_renamed = (int) (this.bh_renamed * com.coui.appcompat.widget.keyboard.a_renamed.a_renamed(getContext()));
        o_renamed();
    }

    public boolean h_renamed() {
        return this.e_renamed.e_renamed() == 3;
    }

    private void a_renamed(int i_renamed, int i2, com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a) {
        android.view.accessibility.AccessibilityManager accessibilityManager = this.aG_renamed;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        android.view.accessibility.AccessibilityEvent accessibilityEventObtain = android.view.accessibility.AccessibilityEvent.obtain(i_renamed);
        onInitializeAccessibilityEvent(accessibilityEventObtain);
        java.lang.String string = null;
        java.lang.String string2 = c0060a.f2986b == null ? null : a_renamed(c0060a.f2986b).toString();
        if (i2 != -7) {
            if (i2 != -6) {
                if (i2 == -5) {
                    string = getContext().getString(coui.support.appcompat.R_renamed.string.keyboardview_keycode_delete);
                } else if (i2 != -2) {
                    if (i2 != -1) {
                        if (i2 == 10) {
                            string = getContext().getString(coui.support.appcompat.R_renamed.string.keyboardview_keycode_enter);
                        } else {
                            string = java.lang.String.valueOf((char) i2);
                        }
                    } else if (getNewShifted() == 2) {
                        string = getContext().getString(coui.support.appcompat.R_renamed.string.coui_keyboard_view_keycode_low_shift);
                    } else if (getNewShifted() == 0) {
                        string = getContext().getString(coui.support.appcompat.R_renamed.string.coui_keyboardview_keycode_initialcapitalization);
                    } else if (getNewShifted() == 1) {
                        string = getContext().getString(coui.support.appcompat.R_renamed.string.coui_keyboardview_keycode_capslock);
                    }
                } else if (string2 != null && string2.equals("ABC")) {
                    string = getContext().getString(coui.support.appcompat.R_renamed.string.coui_keyboardview_keycode_letters);
                } else if (string2 != null && string2.equals("?#+")) {
                    string = getContext().getString(coui.support.appcompat.R_renamed.string.coui_keyboardview_keycode_symbol);
                }
            } else if (string2 != null && string2.equals("ABC")) {
                string = getContext().getString(coui.support.appcompat.R_renamed.string.coui_keyboardview_keycode_letters);
            } else if (string2 != null && string2.equals("123")) {
                string = getContext().getString(coui.support.appcompat.R_renamed.string.coui_keyboardview_keycode_number);
            }
        } else if (string2 != null && string2.equals("?#+")) {
            string = getContext().getString(coui.support.appcompat.R_renamed.string.coui_keyboardview_keycode_symbol);
        } else if (string2 != null && string2.equals("$¥€")) {
            string = getContext().getString(coui.support.appcompat.R_renamed.string.coui_keyboardview_keycode_moresymbols);
        }
        if (i2 == -5 || i2 == -2 || i2 == -1 || i2 == 10 || i2 == -6 || i2 == -7) {
            announceForAccessibility(string);
            return;
        }
        if (c0060a.o_renamed != null) {
            announceForAccessibility(c0060a.o_renamed.toString());
        } else if (c0060a.f2986b != null) {
            announceForAccessibility(c0060a.f2986b.toString());
        } else {
            accessibilityEventObtain.getText().add(java.lang.String.valueOf((char) i2));
            this.aG_renamed.sendAccessibilityEvent(accessibilityEventObtain);
        }
    }

    private boolean f_renamed(int i_renamed) {
        if (this.f2970a == null) {
            android.util.Log.d_renamed("SecurityKeyboardView", "handler is_renamed null");
            return false;
        }
        if (i_renamed == -1) {
            android.util.Log.d_renamed("SecurityKeyboardView", "handler isn't_renamed null and keyIndex is_renamed -1");
            android.os.Handler handler = this.f2970a;
            handler.sendMessageDelayed(handler.obtainMessage(2), 75L);
            return false;
        }
        int i2 = this.A_renamed[i_renamed].f2985a[0];
        if (this.A_renamed[i_renamed].f2986b != null && i2 != -1 && i2 != -5 && i2 != -2 && i2 != 10 && i2 != 32 && i2 != -6 && i2 != -7) {
            return true;
        }
        android.os.Handler handler2 = this.f2970a;
        handler2.sendMessageDelayed(handler2.obtainMessage(2), 75L);
        return false;
    }

    private static class d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final float[] f2979a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final float[] f2980b;

        /* renamed from: c_renamed, reason: collision with root package name */
        final long[] f2981c;
        float d_renamed;
        float e_renamed;

        private d_renamed() {
            this.f2979a = new float[4];
            this.f2980b = new float[4];
            this.f2981c = new long[4];
        }

        public void a_renamed() {
            this.f2981c[0] = 0;
        }

        public void a_renamed(android.view.MotionEvent motionEvent) {
            long eventTime = motionEvent.getEventTime();
            int historySize = motionEvent.getHistorySize();
            for (int i_renamed = 0; i_renamed < historySize; i_renamed++) {
                a_renamed(motionEvent.getHistoricalX(i_renamed), motionEvent.getHistoricalY(i_renamed), motionEvent.getHistoricalEventTime(i_renamed));
            }
            a_renamed(motionEvent.getX(), motionEvent.getY(), eventTime);
        }

        private void a_renamed(float f_renamed, float f2, long j_renamed) {
            long[] jArr = this.f2981c;
            int i_renamed = -1;
            int i2 = 0;
            while (i2 < 4 && jArr[i2] != 0) {
                if (jArr[i2] < j_renamed - 200) {
                    i_renamed = i2;
                }
                i2++;
            }
            if (i2 == 4 && i_renamed < 0) {
                i_renamed = 0;
            }
            if (i_renamed == i2) {
                i_renamed--;
            }
            float[] fArr = this.f2979a;
            float[] fArr2 = this.f2980b;
            if (i_renamed >= 0) {
                int i3 = i_renamed + 1;
                int i4 = (4 - i_renamed) - 1;
                java.lang.System.arraycopy(fArr, i3, fArr, 0, i4);
                java.lang.System.arraycopy(fArr2, i3, fArr2, 0, i4);
                java.lang.System.arraycopy(jArr, i3, jArr, 0, i4);
                i2 -= i3;
            }
            fArr[i2] = f_renamed;
            fArr2[i2] = f2;
            jArr[i2] = j_renamed;
            int i5 = i2 + 1;
            if (i5 < 4) {
                jArr[i5] = 0;
            }
        }

        public void a_renamed(int i_renamed) {
            a_renamed(i_renamed, Float.MAX_VALUE);
        }

        public void a_renamed(int i_renamed, float f_renamed) {
            float fMin;
            float fMin2;
            float[] fArr;
            float[] fArr2 = this.f2979a;
            float[] fArr3 = this.f2980b;
            long[] jArr = this.f2981c;
            int i2 = 0;
            float f2 = fArr2[0];
            float f3 = fArr3[0];
            long j_renamed = jArr[0];
            while (i2 < 4 && jArr[i2] != 0) {
                i2++;
            }
            int i3 = 1;
            float f4 = 0.0f;
            float f5 = 0.0f;
            while (i3 < i2) {
                int i4 = (int) (jArr[i3] - j_renamed);
                if (i4 == 0) {
                    fArr = fArr2;
                } else {
                    float f6 = i4;
                    float f7 = (fArr2[i3] - f2) / f6;
                    fArr = fArr2;
                    float f8 = i_renamed;
                    float f9 = f7 * f8;
                    if (f4 != 0.0f) {
                        f9 = (f4 + f9) * 0.5f;
                    }
                    float f10 = ((fArr3[i3] - f3) / f6) * f8;
                    f5 = f5 == 0.0f ? f10 : (f5 + f10) * 0.5f;
                    f4 = f9;
                }
                i3++;
                fArr2 = fArr;
            }
            if (f4 < 0.0f) {
                fMin = java.lang.Math.max(f4, -f_renamed);
            } else {
                fMin = java.lang.Math.min(f4, f_renamed);
            }
            this.e_renamed = fMin;
            if (f5 < 0.0f) {
                fMin2 = java.lang.Math.max(f5, -f_renamed);
            } else {
                fMin2 = java.lang.Math.min(f5, f_renamed);
            }
            this.d_renamed = fMin2;
        }

        public float b_renamed() {
            return this.e_renamed;
        }

        public float c_renamed() {
            return this.d_renamed;
        }
    }

    private class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public java.lang.String f2976a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public android.graphics.drawable.Drawable f2977b;
        private int d_renamed = 0;
        private int e_renamed = 0;
        private float f_renamed = 0.0f;
        private float g_renamed = 0.0f;
        private android.text.TextPaint h_renamed = new android.text.TextPaint(1);

        public a_renamed(android.graphics.drawable.Drawable drawable, java.lang.String str) {
            this.f2976a = null;
            this.f2977b = null;
            this.h_renamed.setAntiAlias(true);
            this.h_renamed.setTextSize(com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.bj_renamed);
            this.h_renamed.setTypeface(com.coui.appcompat.widget.keyboard.SecurityKeyboardView.this.aS_renamed);
            this.f2976a = str;
            this.f2977b = drawable;
        }

        public float a_renamed() {
            return this.f_renamed;
        }

        public void a_renamed(float f_renamed) {
            this.f_renamed = f_renamed;
        }

        public float b_renamed() {
            return this.g_renamed;
        }

        public void b_renamed(float f_renamed) {
            this.g_renamed = f_renamed;
        }

        public java.lang.String c_renamed() {
            java.lang.String str = this.f2976a;
            if (str != null) {
                return str;
            }
            return null;
        }

        public android.graphics.drawable.Drawable d_renamed() {
            android.graphics.drawable.Drawable drawable = this.f2977b;
            if (drawable != null) {
                return drawable;
            }
            return null;
        }
    }
}
