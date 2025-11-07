package com.oplus.camera.ui.menu;

/* compiled from: SingleTextItemView.java */
/* loaded from: classes2.dex */
public class j_renamed extends android.widget.TextView implements com.oplus.camera.ui.inverse.a_renamed {
    private boolean A_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    protected com.oplus.camera.ui.CameraUIListener f6457a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.BlurMaskFilter f6458b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f6459c;
    private boolean d_renamed;
    private boolean e_renamed;
    private boolean f_renamed;
    private boolean g_renamed;
    private boolean h_renamed;
    private boolean i_renamed;
    private boolean j_renamed;
    private boolean k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private int p_renamed;
    private int q_renamed;
    private int r_renamed;
    private int s_renamed;
    private int t_renamed;
    private android.graphics.drawable.Drawable u_renamed;
    private android.graphics.Bitmap v_renamed;
    private android.graphics.Canvas w_renamed;
    private java.lang.String x_renamed;
    private java.lang.String y_renamed;
    private android.content.Context z_renamed;

    public j_renamed(android.content.Context context, com.oplus.camera.ui.CameraUIListener cameraUIListener) {
        super(context);
        this.f6457a = null;
        this.f6459c = false;
        this.d_renamed = false;
        this.e_renamed = false;
        this.f_renamed = false;
        this.g_renamed = true;
        this.h_renamed = false;
        this.i_renamed = false;
        this.j_renamed = false;
        this.k_renamed = false;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = 0;
        this.p_renamed = 0;
        this.q_renamed = 0;
        this.r_renamed = 0;
        this.s_renamed = 17;
        this.t_renamed = 0;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.z_renamed = null;
        this.A_renamed = true;
        this.z_renamed = context;
        this.f6457a = cameraUIListener;
        this.n_renamed = this.z_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.menu_option_item_width);
        if (!com.oplus.camera.util.Util.ai_renamed()) {
            this.t_renamed = this.z_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.setting_menu_move_down_y);
        }
        this.f6458b = new android.graphics.BlurMaskFilter(4.0f, android.graphics.BlurMaskFilter.Blur.SOLID);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        int actionMasked;
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.f6457a;
        if (cameraUIListener != null && cameraUIListener.p_renamed() && (actionMasked = motionEvent.getActionMasked()) != 3 && actionMasked != 2) {
            android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(3);
            super.dispatchTouchEvent(motionEventObtain);
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getViewWidth() {
        if (this.l_renamed <= 0 || this.g_renamed || this.e_renamed) {
            if (this.q_renamed == 0 || this.r_renamed == 0 || this.h_renamed) {
                measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
                this.h_renamed = false;
            }
            if (this.e_renamed && this.p_renamed % 180 != 0) {
                int i_renamed = this.q_renamed;
                int i2 = this.r_renamed;
                if (i_renamed <= i2) {
                    i_renamed = i2;
                }
                this.l_renamed = i_renamed;
            } else if (this.i_renamed) {
                this.l_renamed = getNoRotateWidth();
            } else {
                this.l_renamed = this.p_renamed % 180 == 0 ? this.q_renamed : this.r_renamed;
            }
            int i3 = this.p_renamed;
            if (i3 == 90 || i3 == 270) {
                this.l_renamed = this.l_renamed > com.oplus.camera.util.Util.getSettingMenuPanelHeight() ? this.l_renamed : com.oplus.camera.util.Util.getSettingMenuPanelHeight();
            } else {
                int i4 = this.l_renamed;
                int i5 = this.n_renamed;
                if (i4 <= i5) {
                    i4 = i5;
                }
                this.l_renamed = i4;
            }
        }
        return this.l_renamed;
    }

    public int getViewHeight() {
        if (this.m_renamed <= 0 || this.g_renamed || this.e_renamed) {
            if (this.q_renamed == 0 || this.r_renamed == 0 || this.h_renamed) {
                measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
                this.h_renamed = false;
            }
            if (this.e_renamed && this.p_renamed % 180 != 0) {
                int i_renamed = this.q_renamed;
                int i2 = this.r_renamed;
                if (i_renamed <= i2) {
                    i_renamed = i2;
                }
                this.m_renamed = i_renamed;
            } else {
                this.m_renamed = this.p_renamed % 180 == 0 ? this.r_renamed : this.q_renamed;
            }
            int i3 = this.p_renamed;
            if (i3 == 90 || i3 == 270) {
                if (this.e_renamed) {
                    this.m_renamed = this.m_renamed > com.oplus.camera.util.Util.getSettingMenuPanelHeight() ? this.m_renamed : com.oplus.camera.util.Util.getSettingMenuPanelHeight();
                } else {
                    int i4 = this.m_renamed;
                    int i5 = this.n_renamed;
                    if (i4 <= i5) {
                        i4 = i5;
                    }
                    this.m_renamed = i4;
                }
            } else {
                this.m_renamed = this.m_renamed > com.oplus.camera.util.Util.getSettingMenuPanelHeight() ? this.m_renamed : com.oplus.camera.util.Util.getSettingMenuPanelHeight();
            }
        }
        return this.m_renamed;
    }

    public int getNoRotateWidth() {
        if (getPaint() == null || getText() == null || getText().length() <= 0) {
            return 0;
        }
        return (int) getPaint().measureText(getText().toString());
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z_renamed) {
        if (z_renamed) {
            super.onWindowFocusChanged(z_renamed);
        }
    }

    @Override // android.widget.TextView
    public void setText(java.lang.CharSequence charSequence, android.widget.TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        this.h_renamed = true;
    }

    public void setVerticalDraw(boolean z_renamed) {
        this.e_renamed = z_renamed;
        if (this.e_renamed) {
            setIncludeFontPadding(false);
            setLineSpacing(0.0f, 0.9f);
        }
    }

    public void setOriginalText(java.lang.String str) {
        this.x_renamed = str;
        this.i_renamed = true;
        this.y_renamed = null;
        java.lang.String str2 = this.x_renamed;
        if (str2 != null) {
            this.y_renamed = str2.substring(0, 2);
        }
    }

    public void setItemText(java.lang.String str) {
        setItemType(true);
        setVerticalDraw(this.e_renamed);
        getPaint().setAntiAlias(true);
        setTypeface(com.oplus.camera.util.Util.l_renamed(this.z_renamed));
        if (this.f6459c) {
            setText(a_renamed(str));
        } else {
            setText(str);
        }
        if (this.d_renamed) {
            setOriginalText(str);
        }
        this.g_renamed = true;
    }

    public void setItemType(boolean z_renamed) {
        this.j_renamed = z_renamed;
    }

    public void setLayoutGravity(int i_renamed) {
        this.s_renamed = i_renamed;
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z_renamed) {
        super.setEnabled(z_renamed);
        setClickable(z_renamed);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        try {
            if (this.e_renamed) {
                super.onMeasure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
                this.q_renamed = getMeasuredWidth();
                this.r_renamed = getMeasuredHeight();
            } else {
                super.onMeasure(i_renamed, com.oplus.camera.util.Util.U_renamed());
                this.q_renamed = android.view.View.MeasureSpec.getSize(i_renamed);
                this.r_renamed = android.view.View.MeasureSpec.getSize(i2);
                setMeasuredDimension(this.p_renamed % 180 == 0 ? this.q_renamed : this.r_renamed, this.p_renamed % 180 == 0 ? this.r_renamed : this.q_renamed);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.widget.TextView
    public float getShadowDy() {
        return super.getShadowDy() + this.t_renamed;
    }

    public void setShadow(boolean z_renamed) {
        this.A_renamed = z_renamed;
        if (this.A_renamed && !this.k_renamed) {
            setShadowLayer(4.0f, 0.0f, 0.0f, getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_70_percent_transparency));
        } else {
            setShadowLayer(0.0f, 0.0f, 0.0f, getPaint().getColor());
        }
    }

    private java.lang.String a_renamed(java.lang.String str) {
        int iLastIndexOf;
        if (str == null || str.equals("") || (iLastIndexOf = str.lastIndexOf(" ")) >= str.length() - 1 || iLastIndexOf < 0) {
            return str;
        }
        return (str.substring(0, iLastIndexOf) + " ") + "（" + str.substring(iLastIndexOf + 1) + "）";
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 1);
        if (this.k_renamed) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_inverse_color});
        }
        return iArrOnCreateDrawableState;
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        this.k_renamed = z_renamed;
        refreshDrawableState();
        setShadow(this.A_renamed);
        invalidate();
    }
}
