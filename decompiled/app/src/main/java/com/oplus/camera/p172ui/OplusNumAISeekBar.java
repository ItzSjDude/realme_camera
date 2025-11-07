package com.oplus.camera.p172ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class OplusNumAISeekBar extends OplusNumSeekBar {

    /* renamed from: T */
    private final Rect f17133T;

    /* renamed from: U */
    private int f17134U;

    /* renamed from: V */
    private int f17135V;

    /* renamed from: W */
    private int f17136W;

    /* renamed from: aa */
    private int f17137aa;

    /* renamed from: ab */
    private float f17138ab;

    /* renamed from: ac */
    private boolean f17139ac;

    /* renamed from: ad */
    private String f17140ad;

    /* renamed from: ae */
    private int f17141ae;

    public OplusNumAISeekBar(Context context) {
        this(context, null);
    }

    public OplusNumAISeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OplusNumAISeekBar(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17133T = new Rect();
        this.f17134U = 0;
        this.f17135V = 0;
        this.f17136W = 0;
        this.f17137aa = 0;
        this.f17138ab = 0.0f;
        this.f17139ac = false;
        this.f17140ad = null;
        this.f17141ae = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OplusNumSeekBar, OplusGLSurfaceView_13, 0);
        this.f17185m = typedArrayObtainStyledAttributes.getColor(44, context.getColor(R.color.face_beauty_seekbar_track_color));
        this.f17183k = typedArrayObtainStyledAttributes.getColor(12, context.getColor(R.color.camera_white));
        this.f17188p = typedArrayObtainStyledAttributes.getDimensionPixelSize(30, getResources().getDimensionPixelSize(R.dimen.num_seekbar_ai_thumb_radius_on_dragging));
        this.f17197y = typedArrayObtainStyledAttributes.getDimensionPixelSize(30, getResources().getDimensionPixelSize(R.dimen.num_seekbar_ai_thumb_radius_cut_back));
        this.f17134U = typedArrayObtainStyledAttributes.getColor(39, context.getColor(R.color.num_seekbar_thumb_text_shadow_color));
        this.f17137aa = typedArrayObtainStyledAttributes.getDimensionPixelSize(38, getResources().getDimensionPixelSize(R.dimen.num_seekbar_text_shadow_blur));
        this.f17135V = typedArrayObtainStyledAttributes.getDimensionPixelSize(40, getResources().getDimensionPixelSize(R.dimen.num_seekbar_text_shadow_offset_x));
        this.f17136W = typedArrayObtainStyledAttributes.getDimensionPixelSize(41, getResources().getDimensionPixelSize(R.dimen.num_seekbar_text_shadow_offset_y));
        this.f17140ad = typedArrayObtainStyledAttributes.getResources().getString(R.string.camera_ai_beauty_seekbar_text);
        typedArrayObtainStyledAttributes.recycle();
        this.f17141ae = getResources().getDimensionPixelOffset(R.dimen.vertical_face_beauty_seekbar_progress_text_padding_start);
        this.f17198z = 22.0f;
        this.f17145D = true;
        this.f17153L.setShadowLayer(this.f17137aa, this.f17135V, this.f17136W, this.f17134U);
        this.f17154M.setShadowLayer(this.f17137aa, this.f17135V, this.f17136W, this.f17134U);
    }

    @Override // com.oplus.camera.p172ui.OplusNumSeekBar, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        Paint.FontMetrics fontMetrics = this.f17153L.getFontMetrics();
        this.f17138ab = fontMetrics.descent - fontMetrics.ascent;
    }

    @Override // com.oplus.camera.p172ui.OplusNumSeekBar
    /* renamed from: PlatformImplementations.kt_3 */
    protected float mo18305a(Paint paint, float COUIBaseListPopupWindow_12, Rect rect) {
        Paint.FontMetrics fontMetrics = this.f17153L.getFontMetrics();
        return getPaddingTop() + (this.f17138ab / 2.0f) + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f17148G != null && !this.f17144C) {
            float y = motionEvent.getY();
            this.f17148G.getHitRect(this.f17133T);
            if (y < this.f17133T.top || y > this.f17133T.bottom) {
                return false;
            }
            super.dispatchTouchEvent(motionEvent);
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f17148G != null) {
            float x = motionEvent.getX();
            this.f17148G.getHitRect(this.f17133T);
            if (x <= this.f17133T.left) {
                this.f17148G.m8173a(0, true);
            }
            if (x >= this.f17133T.right) {
                this.f17148G.m8173a(this.f17148G.getMax(), true);
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.oplus.camera.p172ui.OplusNumSeekBar
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo18306a(Canvas canvas, float COUIBaseListPopupWindow_12) {
        String str;
        float f2;
        m18317a();
        int progress = getProgress();
        if (1 == this.f17155N) {
            canvas.rotate(90.0f);
        }
        if (this.f17139ac) {
            str = null;
        } else {
            str = this.f17140ad + " ";
        }
        boolean z = 1 == getLayoutDirection();
        if (this.f17196x != 0) {
            String string = getContext().getString(this.f17196x);
            if (z) {
                str = " " + string.replaceAll("[IntrinsicsJvm.kt_5%٪ ]", "");
            } else {
                str = string.replaceAll("[IntrinsicsJvm.kt_5%٪ ]", "").trim() + " ";
            }
        }
        float fMeasureText = str == null ? 0.0f : this.f17153L.measureText(str);
        float fE = m18326e(progress);
        float fMeasureText2 = this.f17154M.measureText(this.f17174b);
        float fE2 = m18326e(this.f17139ac ? 10 : 100) + fMeasureText + fMeasureText2;
        float fMo18305a = mo18305a(this.f17153L, COUIBaseListPopupWindow_12, this.f17147F);
        float width = ((ViewGroup) getParent()).getWidth();
        float f3 = (width - fE2) / 2.0f;
        float fM24208a = this.f17139ac ? Util.m24208a(getContext(), 1.0f) + f3 : f3;
        canvas.save();
        canvas.rotate(-this.f17157P, getWidth() / 2.0f, getPaddingTop() + (this.f17138ab / 2.0f));
        if (z) {
            if (str != null) {
                canvas.drawText(str, (width - fM24208a) - fMeasureText, fMo18305a, this.f17153L);
            }
            float f4 = ((width - fM24208a) - fMeasureText) - fE;
            canvas.drawText(Util.m24474l(progress), f4, fMo18305a, this.f17153L);
            canvas.drawText(this.f17174b, f4 - fMeasureText2, fMo18305a, this.f17154M);
        } else {
            if (str != null) {
                canvas.drawText(str, fM24208a, fMo18305a, this.f17153L);
            }
            float f5 = fM24208a + fMeasureText;
            if (1 == this.f17155N) {
                if (1 == this.f17156O) {
                    f2 = ((width / 2.0f) - this.f17141ae) - fE;
                } else {
                    f2 = (width / 2.0f) + this.f17141ae;
                }
                fMo18305a = -f3;
            } else {
                f2 = f5;
            }
            canvas.drawText(Util.m24474l(progress), f2, fMo18305a, this.f17153L);
            canvas.drawText(this.f17174b, f5 + fE, fMo18305a, this.f17154M);
        }
        canvas.restore();
    }

    public void setFrontStyle(boolean z) {
        this.f17139ac = z;
    }

    @Override // com.oplus.camera.p172ui.OplusNumSeekBar, com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f17146E = z;
        m18320a("mBackgroundColor", getResources().getColorStateList(this.f17146E ? R.color.face_beauty_seekbar_track_color_inverse : R.color.face_beauty_seekbar_track_color, getContext().getTheme()));
        invalidate();
    }

    public int getmThumbTextShadowColor() {
        return this.f17134U;
    }

    public void setmThumbTextShadowColor(int OplusGLSurfaceView_13) {
        this.f17134U = OplusGLSurfaceView_13;
    }

    public int getmThumbTextShadowBlur() {
        return this.f17137aa;
    }

    public void setmThumbTextShadowBlur(int OplusGLSurfaceView_13) {
        this.f17137aa = OplusGLSurfaceView_13;
    }
}
