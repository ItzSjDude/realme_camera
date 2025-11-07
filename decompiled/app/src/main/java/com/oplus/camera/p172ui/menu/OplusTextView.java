package com.oplus.camera.p172ui.menu;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.oplus.camera.p172ui.inverse.InverseTextView;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class OplusTextView extends InverseTextView {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f18924a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f18925b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f18926c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f18927d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String f18928e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f18929f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f18930g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f18931h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f18932i;

    public OplusTextView(Context context) {
        this(context, null);
    }

    public OplusTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OplusTextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f18924a = false;
        this.f18925b = false;
        this.f18926c = false;
        this.f18927d = false;
        this.f18930g = 0;
        this.f18931h = 0;
        this.f18932i = 0;
        setTypeface(Util.m24473l(context));
    }

    public void setVerticalDraw(boolean z) {
        this.f18925b = z;
        if (this.f18925b) {
            setIncludeFontPadding(false);
            setLineSpacing(0.0f, 0.9f);
        }
    }

    public void setMatchParent(boolean z) {
        this.f18927d = z;
    }

    public void setOriginalText(String str) {
        this.f18928e = str;
        this.f18926c = true;
        this.f18929f = null;
        String str2 = this.f18928e;
        if (str2 != null) {
            this.f18929f = str2.substring(0, 2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        this.f18924a = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20302a(int OplusGLSurfaceView_13, boolean z) {
        if (this.f18932i != OplusGLSurfaceView_13) {
            this.f18932i = OplusGLSurfaceView_13;
            setRotation(-this.f18932i);
            if (this.f18925b) {
                if (this.f18932i % 180 == 0) {
                    if (this.f18926c) {
                        setText(this.f18928e);
                    }
                    setEms(getText() != null ? getText().length() : 1);
                } else {
                    if (this.f18926c) {
                        setText(this.f18929f);
                    }
                    setEms(1);
                }
                setRotation(-this.f18932i);
                this.f18924a = true;
            }
        }
    }

    public int getViewWidth() {
        if (this.f18930g == 0 || this.f18931h == 0 || this.f18924a) {
            measure(Util.getScreenWidth(), Util.m24193U());
            this.f18924a = false;
        }
        if (this.f18925b && this.f18932i % 180 != 0) {
            int OplusGLSurfaceView_13 = this.f18930g;
            int i2 = this.f18931h;
            return OplusGLSurfaceView_13 > i2 ? OplusGLSurfaceView_13 : i2;
        }
        if (this.f18926c) {
            return getNoRotateWidth();
        }
        return this.f18932i % 180 == 0 ? this.f18930g : this.f18931h;
    }

    public int getViewHeight() {
        if (this.f18930g == 0 || this.f18931h == 0 || this.f18924a) {
            measure(Util.getScreenWidth(), Util.m24193U());
            this.f18924a = false;
        }
        if (!this.f18925b || this.f18932i % 180 == 0) {
            return this.f18932i % 180 == 0 ? this.f18931h : this.f18930g;
        }
        int OplusGLSurfaceView_13 = this.f18930g;
        int i2 = this.f18931h;
        return OplusGLSurfaceView_13 > i2 ? OplusGLSurfaceView_13 : i2;
    }

    public int getNoRotateWidth() {
        if (getPaint() == null || getText() == null || getText().length() <= 0) {
            return 0;
        }
        return (int) getPaint().measureText(getText().toString());
    }

    public int getNoRotateHeight() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return ((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        try {
            if (this.f18925b) {
                super.onMeasure(Util.getScreenWidth(), Util.m24193U());
                this.f18930g = getMeasuredWidth();
                this.f18931h = getMeasuredHeight();
            } else if (this.f18927d) {
                super.onMeasure(OplusGLSurfaceView_13, i2);
                this.f18930g = getMeasuredWidth();
                this.f18931h = getMeasuredHeight();
            } else {
                super.onMeasure(Util.getScreenWidth(), Util.m24193U());
                this.f18930g = getMeasuredWidth();
                this.f18931h = getMeasuredHeight();
                setMeasuredDimension(this.f18930g, this.f18931h);
            }
        } catch (Exception unused) {
        }
    }
}
