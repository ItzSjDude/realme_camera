package com.oplus.camera.ui;

/* loaded from: classes2.dex */
public class OplusNumAISeekBar extends com.oplus.camera.ui.OplusNumSeekBar {
    private final android.graphics.Rect T_renamed;
    private int U_renamed;
    private int V_renamed;
    private int W_renamed;
    private int aa_renamed;
    private float ab_renamed;
    private boolean ac_renamed;
    private java.lang.String ad_renamed;
    private int ae_renamed;

    public OplusNumAISeekBar(android.content.Context context) {
        this(context, null);
    }

    public OplusNumAISeekBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OplusNumAISeekBar(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.T_renamed = new android.graphics.Rect();
        this.U_renamed = 0;
        this.V_renamed = 0;
        this.W_renamed = 0;
        this.aa_renamed = 0;
        this.ab_renamed = 0.0f;
        this.ac_renamed = false;
        this.ad_renamed = null;
        this.ae_renamed = 0;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.oplus.camera.R_renamed.styleable.OplusNumSeekBar, i_renamed, 0);
        this.m_renamed = typedArrayObtainStyledAttributes.getColor(44, context.getColor(com.oplus.camera.R_renamed.color.face_beauty_seekbar_track_color));
        this.k_renamed = typedArrayObtainStyledAttributes.getColor(12, context.getColor(com.oplus.camera.R_renamed.color.camera_white));
        this.p_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(30, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.num_seekbar_ai_thumb_radius_on_dragging));
        this.y_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(30, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.num_seekbar_ai_thumb_radius_cut_back));
        this.U_renamed = typedArrayObtainStyledAttributes.getColor(39, context.getColor(com.oplus.camera.R_renamed.color.num_seekbar_thumb_text_shadow_color));
        this.aa_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(38, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.num_seekbar_text_shadow_blur));
        this.V_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(40, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.num_seekbar_text_shadow_offset_x));
        this.W_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(41, getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.num_seekbar_text_shadow_offset_y));
        this.ad_renamed = typedArrayObtainStyledAttributes.getResources().getString(com.oplus.camera.R_renamed.string.camera_ai_beauty_seekbar_text);
        typedArrayObtainStyledAttributes.recycle();
        this.ae_renamed = getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.vertical_face_beauty_seekbar_progress_text_padding_start);
        this.z_renamed = 22.0f;
        this.D_renamed = true;
        this.L_renamed.setShadowLayer(this.aa_renamed, this.V_renamed, this.W_renamed, this.U_renamed);
        this.M_renamed.setShadowLayer(this.aa_renamed, this.V_renamed, this.W_renamed, this.U_renamed);
    }

    @Override // com.oplus.camera.ui.OplusNumSeekBar, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        android.graphics.Paint.FontMetrics fontMetrics = this.L_renamed.getFontMetrics();
        this.ab_renamed = fontMetrics.descent - fontMetrics.ascent;
    }

    @Override // com.oplus.camera.ui.OplusNumSeekBar
    protected float a_renamed(android.graphics.Paint paint, float f_renamed, android.graphics.Rect rect) {
        android.graphics.Paint.FontMetrics fontMetrics = this.L_renamed.getFontMetrics();
        return getPaddingTop() + (this.ab_renamed / 2.0f) + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.G_renamed != null && !this.C_renamed) {
            float y_renamed = motionEvent.getY();
            this.G_renamed.getHitRect(this.T_renamed);
            if (y_renamed < this.T_renamed.top || y_renamed > this.T_renamed.bottom) {
                return false;
            }
            super.dispatchTouchEvent(motionEvent);
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.G_renamed != null) {
            float x_renamed = motionEvent.getX();
            this.G_renamed.getHitRect(this.T_renamed);
            if (x_renamed <= this.T_renamed.left) {
                this.G_renamed.a_renamed(0, true);
            }
            if (x_renamed >= this.T_renamed.right) {
                this.G_renamed.a_renamed(this.G_renamed.getMax(), true);
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.oplus.camera.ui.OplusNumSeekBar
    protected void a_renamed(android.graphics.Canvas canvas, float f_renamed) {
        java.lang.String str;
        float f2;
        a_renamed();
        int progress = getProgress();
        if (1 == this.N_renamed) {
            canvas.rotate(90.0f);
        }
        if (this.ac_renamed) {
            str = null;
        } else {
            str = this.ad_renamed + " ";
        }
        boolean z_renamed = 1 == getLayoutDirection();
        if (this.x_renamed != 0) {
            java.lang.String string = getContext().getString(this.x_renamed);
            if (z_renamed) {
                str = " " + string.replaceAll("[d_renamed%٪ ]", "");
            } else {
                str = string.replaceAll("[d_renamed%٪ ]", "").trim() + " ";
            }
        }
        float fMeasureText = str == null ? 0.0f : this.L_renamed.measureText(str);
        float fE_renamed = e_renamed(progress);
        float fMeasureText2 = this.M_renamed.measureText(this.f5769b);
        float fE2 = e_renamed(this.ac_renamed ? 10 : 100) + fMeasureText + fMeasureText2;
        float fA_renamed = a_renamed(this.L_renamed, f_renamed, this.F_renamed);
        float width = ((android.view.ViewGroup) getParent()).getWidth();
        float f3 = (width - fE2) / 2.0f;
        float fA2 = this.ac_renamed ? com.oplus.camera.util.Util.a_renamed(getContext(), 1.0f) + f3 : f3;
        canvas.save();
        canvas.rotate(-this.P_renamed, getWidth() / 2.0f, getPaddingTop() + (this.ab_renamed / 2.0f));
        if (z_renamed) {
            if (str != null) {
                canvas.drawText(str, (width - fA2) - fMeasureText, fA_renamed, this.L_renamed);
            }
            float f4 = ((width - fA2) - fMeasureText) - fE_renamed;
            canvas.drawText(com.oplus.camera.util.Util.l_renamed(progress), f4, fA_renamed, this.L_renamed);
            canvas.drawText(this.f5769b, f4 - fMeasureText2, fA_renamed, this.M_renamed);
        } else {
            if (str != null) {
                canvas.drawText(str, fA2, fA_renamed, this.L_renamed);
            }
            float f5 = fA2 + fMeasureText;
            if (1 == this.N_renamed) {
                if (1 == this.O_renamed) {
                    f2 = ((width / 2.0f) - this.ae_renamed) - fE_renamed;
                } else {
                    f2 = (width / 2.0f) + this.ae_renamed;
                }
                fA_renamed = -f3;
            } else {
                f2 = f5;
            }
            canvas.drawText(com.oplus.camera.util.Util.l_renamed(progress), f2, fA_renamed, this.L_renamed);
            canvas.drawText(this.f5769b, f5 + fE_renamed, fA_renamed, this.M_renamed);
        }
        canvas.restore();
    }

    public void setFrontStyle(boolean z_renamed) {
        this.ac_renamed = z_renamed;
    }

    @Override // com.oplus.camera.ui.OplusNumSeekBar, com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        this.E_renamed = z_renamed;
        a_renamed("mBackgroundColor", getResources().getColorStateList(this.E_renamed ? com.oplus.camera.R_renamed.color.face_beauty_seekbar_track_color_inverse : com.oplus.camera.R_renamed.color.face_beauty_seekbar_track_color, getContext().getTheme()));
        invalidate();
    }

    public int getmThumbTextShadowColor() {
        return this.U_renamed;
    }

    public void setmThumbTextShadowColor(int i_renamed) {
        this.U_renamed = i_renamed;
    }

    public int getmThumbTextShadowBlur() {
        return this.aa_renamed;
    }

    public void setmThumbTextShadowBlur(int i_renamed) {
        this.aa_renamed = i_renamed;
    }
}
