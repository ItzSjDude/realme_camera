package com.oplus.camera.ui.menu;

/* loaded from: classes2.dex */
public class OplusTextView extends com.oplus.camera.ui.inverse.InverseTextView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f6326a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f6327b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f6328c;
    private boolean d_renamed;
    private java.lang.String e_renamed;
    private java.lang.String f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;

    public OplusTextView(android.content.Context context) {
        this(context, null);
    }

    public OplusTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OplusTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6326a = false;
        this.f6327b = false;
        this.f6328c = false;
        this.d_renamed = false;
        this.g_renamed = 0;
        this.h_renamed = 0;
        this.i_renamed = 0;
        setTypeface(com.oplus.camera.util.Util.l_renamed(context));
    }

    public void setVerticalDraw(boolean z_renamed) {
        this.f6327b = z_renamed;
        if (this.f6327b) {
            setIncludeFontPadding(false);
            setLineSpacing(0.0f, 0.9f);
        }
    }

    public void setMatchParent(boolean z_renamed) {
        this.d_renamed = z_renamed;
    }

    public void setOriginalText(java.lang.String str) {
        this.e_renamed = str;
        this.f6328c = true;
        this.f_renamed = null;
        java.lang.String str2 = this.e_renamed;
        if (str2 != null) {
            this.f_renamed = str2.substring(0, 2);
        }
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
        this.f6326a = true;
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        if (this.i_renamed != i_renamed) {
            this.i_renamed = i_renamed;
            setRotation(-this.i_renamed);
            if (this.f6327b) {
                if (this.i_renamed % 180 == 0) {
                    if (this.f6328c) {
                        setText(this.e_renamed);
                    }
                    setEms(getText() != null ? getText().length() : 1);
                } else {
                    if (this.f6328c) {
                        setText(this.f_renamed);
                    }
                    setEms(1);
                }
                setRotation(-this.i_renamed);
                this.f6326a = true;
            }
        }
    }

    public int getViewWidth() {
        if (this.g_renamed == 0 || this.h_renamed == 0 || this.f6326a) {
            measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
            this.f6326a = false;
        }
        if (this.f6327b && this.i_renamed % 180 != 0) {
            int i_renamed = this.g_renamed;
            int i2 = this.h_renamed;
            return i_renamed > i2 ? i_renamed : i2;
        }
        if (this.f6328c) {
            return getNoRotateWidth();
        }
        return this.i_renamed % 180 == 0 ? this.g_renamed : this.h_renamed;
    }

    public int getViewHeight() {
        if (this.g_renamed == 0 || this.h_renamed == 0 || this.f6326a) {
            measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
            this.f6326a = false;
        }
        if (!this.f6327b || this.i_renamed % 180 == 0) {
            return this.i_renamed % 180 == 0 ? this.h_renamed : this.g_renamed;
        }
        int i_renamed = this.g_renamed;
        int i2 = this.h_renamed;
        return i_renamed > i2 ? i_renamed : i2;
    }

    public int getNoRotateWidth() {
        if (getPaint() == null || getText() == null || getText().length() <= 0) {
            return 0;
        }
        return (int) getPaint().measureText(getText().toString());
    }

    public int getNoRotateHeight() {
        android.graphics.Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return ((int) java.lang.Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        try {
            if (this.f6327b) {
                super.onMeasure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
                this.g_renamed = getMeasuredWidth();
                this.h_renamed = getMeasuredHeight();
            } else if (this.d_renamed) {
                super.onMeasure(i_renamed, i2);
                this.g_renamed = getMeasuredWidth();
                this.h_renamed = getMeasuredHeight();
            } else {
                super.onMeasure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
                this.g_renamed = getMeasuredWidth();
                this.h_renamed = getMeasuredHeight();
                setMeasuredDimension(this.g_renamed, this.h_renamed);
            }
        } catch (java.lang.Exception unused) {
        }
    }
}
