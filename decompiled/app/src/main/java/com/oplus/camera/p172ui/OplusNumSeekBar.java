package com.oplus.camera.p172ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.coui.appcompat.widget.seekbar.COUISeekBar;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.inverse.InverseAble;
import com.oplus.camera.util.Util;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class OplusNumSeekBar extends FrameLayout implements InverseAble {

    /* renamed from: A */
    protected float f17142A;

    /* renamed from: B */
    protected boolean f17143B;

    /* renamed from: C */
    protected boolean f17144C;

    /* renamed from: D */
    protected boolean f17145D;

    /* renamed from: E */
    protected boolean f17146E;

    /* renamed from: F */
    protected Rect f17147F;

    /* renamed from: G */
    protected COUISeekBar f17148G;

    /* renamed from: H */
    protected float f17149H;

    /* renamed from: I */
    protected float f17150I;

    /* renamed from: J */
    protected float f17151J;

    /* renamed from: K */
    protected float f17152K;

    /* renamed from: L */
    protected Paint f17153L;

    /* renamed from: M */
    protected Paint f17154M;

    /* renamed from: N */
    protected int f17155N;

    /* renamed from: O */
    protected int f17156O;

    /* renamed from: P */
    protected int f17157P;

    /* renamed from: Q */
    protected int f17158Q;

    /* renamed from: R */
    protected int f17159R;

    /* renamed from: S */
    protected boolean f17160S;

    /* renamed from: T */
    private int f17161T;

    /* renamed from: U */
    private long f17162U;

    /* renamed from: V */
    private float f17163V;

    /* renamed from: W */
    private float f17164W;

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean f17165a;

    /* renamed from: aa */
    private int f17166aa;

    /* renamed from: ab */
    private int f17167ab;

    /* renamed from: ac */
    private int f17168ac;

    /* renamed from: ad */
    private InterfaceC3101a f17169ad;

    /* renamed from: ae */
    private float f17170ae;

    /* renamed from: af */
    private float f17171af;

    /* renamed from: ag */
    private long f17172ag;

    /* renamed from: ah */
    private long f17173ah;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected String f17174b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected int f17175c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected int f17176d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected int f17177e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected int f17178f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected int f17179g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected int f17180h;

    /* renamed from: OplusGLSurfaceView_13 */
    protected int f17181i;

    /* renamed from: OplusGLSurfaceView_15 */
    protected int f17182j;

    /* renamed from: OplusGLSurfaceView_5 */
    protected int f17183k;

    /* renamed from: OplusGLSurfaceView_14 */
    protected int f17184l;

    /* renamed from: OplusGLSurfaceView_6 */
    protected int f17185m;

    /* renamed from: OplusGLSurfaceView_11 */
    protected int f17186n;

    /* renamed from: o */
    protected int f17187o;

    /* renamed from: p */
    protected int f17188p;

    /* renamed from: q */
    protected int f17189q;

    /* renamed from: r */
    protected int f17190r;

    /* renamed from: s */
    protected int f17191s;

    /* renamed from: t */
    protected int f17192t;

    /* renamed from: u */
    protected int f17193u;

    /* renamed from: v */
    protected int f17194v;

    /* renamed from: w */
    protected int f17195w;

    /* renamed from: x */
    protected int f17196x;

    /* renamed from: y */
    protected int f17197y;

    /* renamed from: z */
    protected float f17198z;

    /* renamed from: com.oplus.camera.ui.OplusNumSeekBar$PlatformImplementations.kt_3 */
    public interface InterfaceC3101a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo18327a(OplusNumSeekBar oplusNumSeekBar, int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo18328a(OplusNumSeekBar oplusNumSeekBar, int OplusGLSurfaceView_13, boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo18329a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo18330b(OplusNumSeekBar oplusNumSeekBar, int OplusGLSurfaceView_13);
    }

    public OplusNumSeekBar(Context context) {
        this(context, null);
    }

    public OplusNumSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OplusNumSeekBar(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17165a = false;
        this.f17174b = "";
        this.f17175c = 0;
        this.f17176d = 0;
        this.f17177e = 0;
        this.f17178f = 0;
        this.f17179g = 0;
        this.f17180h = 0;
        this.f17181i = 0;
        this.f17182j = 0;
        this.f17183k = 0;
        this.f17184l = 0;
        this.f17185m = 0;
        this.f17186n = 0;
        this.f17187o = 0;
        this.f17188p = 0;
        this.f17189q = 0;
        this.f17190r = 0;
        this.f17191s = 0;
        this.f17192t = 0;
        this.f17193u = 0;
        this.f17194v = 0;
        this.f17195w = 0;
        this.f17196x = 0;
        this.f17198z = 0.0f;
        this.f17142A = 0.0f;
        this.f17143B = false;
        this.f17144C = false;
        this.f17145D = false;
        this.f17146E = false;
        this.f17147F = null;
        this.f17148G = null;
        this.f17149H = 0.0f;
        this.f17150I = 0.0f;
        this.f17151J = 0.0f;
        this.f17152K = 0.0f;
        this.f17153L = null;
        this.f17154M = null;
        this.f17155N = 0;
        this.f17156O = 0;
        this.f17157P = 0;
        this.f17158Q = 0;
        this.f17159R = 0;
        this.f17160S = false;
        this.f17161T = 0;
        this.f17162U = 0L;
        this.f17163V = 0.0f;
        this.f17164W = 0.0f;
        this.f17166aa = 0;
        this.f17167ab = 0;
        this.f17168ac = 0;
        this.f17169ad = null;
        this.f17170ae = 0.0f;
        this.f17171af = 0.0f;
        this.f17172ag = 0L;
        this.f17173ah = 0L;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OplusNumSeekBar, OplusGLSurfaceView_13, 0);
        this.f17155N = typedArrayObtainStyledAttributes.getInt(7, 0);
        this.f17156O = typedArrayObtainStyledAttributes.getInt(19, 0);
        this.f17181i = typedArrayObtainStyledAttributes.getInt(6, 0);
        this.f17182j = typedArrayObtainStyledAttributes.getInt(5, 100);
        this.f17161T = typedArrayObtainStyledAttributes.getInt(8, this.f17181i);
        this.f17175c = typedArrayObtainStyledAttributes.getDimensionPixelSize(46, (int) getResources().getDimension(R.dimen.num_seekbar_track_size));
        this.f17176d = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, (int) getResources().getDimension(R.dimen.num_seekbar_second_track_size));
        this.f17188p = typedArrayObtainStyledAttributes.getDimensionPixelSize(30, (int) getResources().getDimension(R.dimen.num_seekbar_thumb_radius_on_dragging));
        this.f17180h = typedArrayObtainStyledAttributes.getDimensionPixelSize(29, getResources().getDimensionPixelSize(R.dimen.num_seekbar_thumb_radius));
        this.f17191s = typedArrayObtainStyledAttributes.getDimensionPixelSize(32, getResources().getDimensionPixelSize(R.dimen.num_seekbar_thumb_shadow_radius));
        this.f17177e = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, (int) getResources().getDimension(R.dimen.num_seekbar_section_radius));
        this.f17178f = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, (int) getResources().getDimension(R.dimen.num_seekbar_section_click_radius));
        this.f17185m = typedArrayObtainStyledAttributes.getColor(44, context.getColor(R.color.camera_white));
        this.f17186n = typedArrayObtainStyledAttributes.getColor(45, context.getColor(R.color.face_beauty_seekbar_track_color_inverse));
        this.f17184l = typedArrayObtainStyledAttributes.getColor(9, Util.m24164A(getContext()));
        this.f17183k = typedArrayObtainStyledAttributes.getColor(12, context.getColor(R.color.camera_white));
        this.f17192t = typedArrayObtainStyledAttributes.getDimensionPixelSize(42, (int) context.getApplicationContext().getResources().getDimension(R.dimen.num_seekbar_thumb_text_size));
        this.f17193u = typedArrayObtainStyledAttributes.getDimensionPixelSize(28, (int) context.getApplicationContext().getResources().getDimension(R.dimen.num_seekbar_thumb_text_size));
        this.f17179g = this.f17184l;
        this.f17194v = typedArrayObtainStyledAttributes.getColor(34, this.f17185m);
        this.f17195w = typedArrayObtainStyledAttributes.getColor(35, context.getColor(R.color.inverse_text_color));
        this.f17162U = typedArrayObtainStyledAttributes.getInteger(0, 200);
        this.f17187o = typedArrayObtainStyledAttributes.getInteger(14, 0);
        this.f17196x = typedArrayObtainStyledAttributes.getResourceId(43, 0);
        this.f17145D = typedArrayObtainStyledAttributes.getBoolean(33, false);
        this.f17166aa = typedArrayObtainStyledAttributes.getDimensionPixelSize(37, 0);
        this.f17167ab = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, 0);
        this.f17168ac = typedArrayObtainStyledAttributes.getDimensionPixelSize(15, 0);
        this.f17189q = typedArrayObtainStyledAttributes.getDimensionPixelSize(24, getResources().getDimensionPixelSize(R.dimen.num_seekbar_thumb_circle_stroke_width));
        this.f17190r = typedArrayObtainStyledAttributes.getDimensionPixelSize(24, getResources().getDimensionPixelSize(R.dimen.num_seekbar_thumb_circle_stroke_width_on_dragging));
        this.f17165a = typedArrayObtainStyledAttributes.getBoolean(17, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f17174b = this.f17165a ? "%" : "";
        this.f17153L = new Paint();
        this.f17153L.setAntiAlias(true);
        this.f17153L.setStrokeCap(Paint.Cap.ROUND);
        this.f17153L.setTextAlign(Paint.Align.LEFT);
        this.f17153L.setColor(this.f17194v);
        this.f17153L.setTextSize(this.f17192t);
        this.f17153L.setTypeface(Util.m24411c(false));
        this.f17154M = new Paint();
        this.f17154M.setAntiAlias(true);
        this.f17154M.setStrokeCap(Paint.Cap.ROUND);
        this.f17154M.setTextAlign(Paint.Align.LEFT);
        this.f17154M.setColor(this.f17194v);
        this.f17154M.setTextSize(this.f17193u);
        this.f17154M.setTypeface(Util.m24505y());
        m18319a(this.f17153L);
        this.f17147F = new Rect();
        m18314e();
        m18313d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m18319a(Paint paint) {
        String strM18312b = m18312b(paint);
        this.f17149H = paint.measureText("-");
        this.f17150I = paint.measureText(strM18312b);
        this.f17151J = paint.measureText(strM18312b + strM18312b);
        this.f17152K = paint.measureText(strM18312b + strM18312b + strM18312b);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m18312b(Paint paint) {
        float COUIBaseListPopupWindow_12 = 0.0f;
        String str = null;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 10; OplusGLSurfaceView_13++) {
            String strM24474l = Util.m24474l(OplusGLSurfaceView_13);
            float fMeasureText = paint.measureText(strM24474l);
            if (fMeasureText > COUIBaseListPopupWindow_12) {
                str = strM24474l;
                COUIBaseListPopupWindow_12 = fMeasureText;
            }
        }
        return str;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m18313d() {
        setClipChildren(false);
        setClipToPadding(false);
        this.f17185m = getResources().getColor(R.color.camera_white, getContext().getTheme());
        this.f17186n = getResources().getColor(R.color.face_beauty_seekbar_track_color_inverse, getContext().getTheme());
        this.f17194v = this.f17185m;
        this.f17195w = getResources().getColor(R.color.inverse_text_color, getContext().getTheme());
        this.f17166aa = (int) getResources().getDimension(R.dimen.blur_seekbar_thumb_text_padding_seek_bar);
        m18309a(LayoutInflater.from(getContext()).inflate(R.layout.color_seekbar_layout, (ViewGroup) this, true));
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f17148G.setEnabled(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18309a(View view) {
        this.f17148G = (COUISeekBar) view.findViewById(R.id_renamed.color_seek_bar);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f17148G.getLayoutParams();
        if (1 == this.f17155N) {
            layoutParams.width = (int) Util.m24456h(R.dimen.vertical_face_beauty_seekbar_height);
            layoutParams.gravity = 17;
        } else {
            layoutParams.width = -1;
            layoutParams.gravity = 81;
        }
        this.f17148G.setLayoutParams(layoutParams);
        this.f17148G.setMax(1000);
        this.f17148G.setOnSeekBarChangeListener(new COUISeekBar.InterfaceC1517b() { // from class: com.oplus.camera.ui.OplusNumSeekBar.1
            @Override // com.coui.appcompat.widget.seekbar.COUISeekBar.InterfaceC1517b
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8177a(COUISeekBar cOUISeekBar, int OplusGLSurfaceView_13, boolean z) {
                OplusNumSeekBar oplusNumSeekBar = OplusNumSeekBar.this;
                oplusNumSeekBar.f17161T = oplusNumSeekBar.m18315f(OplusGLSurfaceView_13);
                if (OplusNumSeekBar.this.f17169ad != null) {
                    InterfaceC3101a interfaceC3101a = OplusNumSeekBar.this.f17169ad;
                    OplusNumSeekBar oplusNumSeekBar2 = OplusNumSeekBar.this;
                    interfaceC3101a.mo18328a(oplusNumSeekBar2, oplusNumSeekBar2.f17161T, z);
                }
                OplusNumSeekBar.this.postInvalidate();
            }

            @Override // com.coui.appcompat.widget.seekbar.COUISeekBar.InterfaceC1517b
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo8176a(COUISeekBar cOUISeekBar) {
                if (OplusNumSeekBar.this.f17169ad != null) {
                    OplusNumSeekBar.this.setThumbOnDragging(true);
                    InterfaceC3101a interfaceC3101a = OplusNumSeekBar.this.f17169ad;
                    OplusNumSeekBar oplusNumSeekBar = OplusNumSeekBar.this;
                    interfaceC3101a.mo18327a(oplusNumSeekBar, oplusNumSeekBar.m18315f(cOUISeekBar.getProgress()));
                }
            }

            @Override // com.coui.appcompat.widget.seekbar.COUISeekBar.InterfaceC1517b
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo8178b(COUISeekBar cOUISeekBar) {
                if (OplusNumSeekBar.this.f17169ad != null) {
                    OplusNumSeekBar.this.setThumbOnDragging(false);
                    InterfaceC3101a interfaceC3101a = OplusNumSeekBar.this.f17169ad;
                    OplusNumSeekBar oplusNumSeekBar = OplusNumSeekBar.this;
                    interfaceC3101a.mo18330b(oplusNumSeekBar, oplusNumSeekBar.m18315f(cOUISeekBar.getProgress()));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m18315f(int OplusGLSurfaceView_13) {
        return this.f17181i + Math.round((this.f17163V * OplusGLSurfaceView_13) / this.f17148G.getMax());
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m18314e() {
        if (this.f17181i == this.f17182j) {
            this.f17181i = 0;
            this.f17182j = 100;
        }
        int OplusGLSurfaceView_13 = this.f17181i;
        int i2 = this.f17182j;
        if (OplusGLSurfaceView_13 > i2) {
            this.f17182j = OplusGLSurfaceView_13;
            this.f17181i = i2;
        }
        int i3 = this.f17161T;
        int i4 = this.f17181i;
        if (i3 < i4) {
            this.f17161T = i4;
        }
        int i5 = this.f17161T;
        int i6 = this.f17182j;
        if (i5 > i6) {
            this.f17161T = i6;
        }
        int i7 = this.f17176d;
        int i8 = this.f17175c;
        if (i7 < i8) {
            this.f17176d = i8 + ((int) getResources().getDimension(R.dimen.num_seekbar_height_distance));
        }
        int i9 = this.f17180h;
        int i10 = this.f17176d;
        if (i9 <= i10) {
            this.f17180h = i10 + ((int) getResources().getDimension(R.dimen.num_seekbar_height_distance));
        }
        this.f17163V = this.f17182j - this.f17181i;
        m18323c(this.f17161T);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        this.f17153L.getTextBounds("0123456789", 0, 10, this.f17147F);
        String minText = getMinText();
        this.f17153L.getTextBounds(minText, 0, minText.length(), this.f17147F);
        this.f17170ae = (getPaddingLeft() + Math.max(this.f17188p, this.f17147F.width() / 2.0f)) - this.f17198z;
        String maxText = getMaxText();
        this.f17153L.getTextBounds(maxText, 0, maxText.length(), this.f17147F);
        this.f17171af = (getMeasuredWidth() - getPaddingRight()) - Math.max(this.f17188p, this.f17147F.width() / 2.0f);
        int i3 = this.f17167ab;
        if (i3 != 0 && i3 > this.f17170ae) {
            this.f17170ae = i3;
        }
        if (this.f17168ac != 0 && getMeasuredWidth() - this.f17168ac < this.f17171af) {
            this.f17171af = getMeasuredWidth() - this.f17168ac;
        }
        this.f17164W = this.f17171af - this.f17170ae;
    }

    protected int getYTop() {
        return getPaddingTop() + (getHeight() / 2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        mo18306a(canvas, getYTop());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo18306a(Canvas canvas, float COUIBaseListPopupWindow_12) {
        Paint paint = this.f17153L;
        paint.setColor(this.f17146E ? this.f17195w : this.f17194v);
        paint.getTextBounds("0123456789", 0, 10, this.f17147F);
        int progress = getProgress();
        String str = null;
        boolean z = 1 == getLayoutDirection();
        if (this.f17196x != 0) {
            String string = getContext().getString(this.f17196x);
            if (z) {
                str = " " + string.replaceAll("[IntrinsicsJvm.kt_5%٪ ]", "");
            } else {
                str = string.replaceAll("[IntrinsicsJvm.kt_5%٪ ]", "").trim() + " ";
            }
        }
        float fMeasureText = str == null ? 0.0f : paint.measureText(str);
        float fM18326e = m18326e(progress);
        float fMeasureText2 = paint.measureText(this.f17174b);
        float fM18326e2 = m18326e(100) + fMeasureText + fMeasureText2;
        float width = this.f17142A;
        if (this.f17145D) {
            width = (((getWidth() - getPaddingStart()) - getPaddingEnd()) - fM18326e2) / 2.0f;
            COUIBaseListPopupWindow_12 = (COUIBaseListPopupWindow_12 - this.f17166aa) - getPaddingTop();
        }
        float fMo18305a = mo18305a(paint, COUIBaseListPopupWindow_12, this.f17147F);
        if (z) {
            float paddingEnd = width + getPaddingEnd();
            if (str != null) {
                canvas.drawText(str, (getWidth() - paddingEnd) - fMeasureText, fMo18305a, this.f17153L);
            }
            canvas.drawText(Util.m24474l(progress), ((getWidth() - paddingEnd) - fMeasureText) - fM18326e, fMo18305a, this.f17153L);
            canvas.drawText(this.f17174b, (((getWidth() - paddingEnd) - fMeasureText) - fM18326e) - fMeasureText2, fMo18305a, this.f17153L);
            return;
        }
        float paddingStart = width + getPaddingStart();
        if (str != null) {
            canvas.drawText(str, paddingStart, fMo18305a, this.f17153L);
        }
        float f2 = paddingStart + fMeasureText;
        canvas.drawText(Util.m24474l(progress), f2, fMo18305a, this.f17153L);
        canvas.drawText(this.f17174b, f2 + fM18326e, fMo18305a, this.f17153L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18318a(int OplusGLSurfaceView_13, boolean z) {
        int i2;
        if (OplusGLSurfaceView_13 >= 0) {
            i2 = OplusGLSurfaceView_13 % 360;
        } else {
            i2 = (OplusGLSurfaceView_13 % 360) + 360;
        }
        if (i2 == this.f17159R) {
            return;
        }
        this.f17159R = i2;
        if (z) {
            this.f17158Q = this.f17157P;
            this.f17172ag = AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f17159R - this.f17157P;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.f17160S = i3 >= 0;
            this.f17173ah = this.f17172ag + ((Math.abs(i3) * 1000) / 360);
        } else {
            this.f17157P = this.f17159R;
        }
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m18317a() {
        int OplusGLSurfaceView_13;
        if (this.f17157P != this.f17159R) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.f17173ah) {
                int i2 = (int) (jCurrentAnimationTimeMillis - this.f17172ag);
                int i3 = this.f17158Q;
                if (!this.f17160S) {
                    i2 = -i2;
                }
                int i4 = i3 + ((i2 * 360) / 1000);
                if (i4 >= 0) {
                    OplusGLSurfaceView_13 = i4 % 360;
                } else {
                    OplusGLSurfaceView_13 = (i4 % 360) + 360;
                }
                this.f17157P = OplusGLSurfaceView_13;
                invalidate();
                return;
            }
            this.f17157P = this.f17159R;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected float mo18305a(Paint paint, float COUIBaseListPopupWindow_12, Rect rect) {
        return COUIBaseListPopupWindow_12 - rect.height();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18322b() {
        animate().setDuration(this.f17162U).setListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.OplusNumSeekBar.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                OplusNumSeekBar.this.setThumbOnDragging(false);
                OplusNumSeekBar oplusNumSeekBar = OplusNumSeekBar.this;
                oplusNumSeekBar.f17143B = false;
                oplusNumSeekBar.invalidate();
                if (OplusNumSeekBar.this.f17169ad != null) {
                    InterfaceC3101a interfaceC3101a = OplusNumSeekBar.this.f17169ad;
                    OplusNumSeekBar oplusNumSeekBar2 = OplusNumSeekBar.this;
                    interfaceC3101a.mo18328a(oplusNumSeekBar2, oplusNumSeekBar2.getProgress(), true);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                OplusNumSeekBar.this.setThumbOnDragging(true);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                OplusNumSeekBar.this.setThumbOnDragging(false);
                OplusNumSeekBar oplusNumSeekBar = OplusNumSeekBar.this;
                oplusNumSeekBar.f17143B = false;
                oplusNumSeekBar.invalidate();
            }
        }).start();
        InterfaceC3101a interfaceC3101a = this.f17169ad;
        if (interfaceC3101a != null) {
            interfaceC3101a.mo18330b(this, getProgress());
        }
    }

    private String getMinText() {
        return Util.m24474l(-50);
    }

    private String getMaxText() {
        return Util.m24474l(this.f17182j);
    }

    public float getMin() {
        return this.f17181i;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public OplusNumSeekBar m18316a(int OplusGLSurfaceView_13) {
        this.f17182j = OplusGLSurfaceView_13;
        this.f17163V = this.f17182j - this.f17181i;
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public OplusNumSeekBar m18321b(int OplusGLSurfaceView_13) {
        this.f17181i = OplusGLSurfaceView_13;
        this.f17163V = this.f17182j - this.f17181i;
        this.f17148G.setStartFromMiddle(OplusGLSurfaceView_13 < 0);
        return this;
    }

    public float getMax() {
        return this.f17182j;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public OplusNumSeekBar m18323c(int OplusGLSurfaceView_13) {
        if (this.f17161T != OplusGLSurfaceView_13) {
            this.f17161T = OplusGLSurfaceView_13;
            InterfaceC3101a interfaceC3101a = this.f17169ad;
            if (interfaceC3101a != null) {
                interfaceC3101a.mo18328a(this, getProgress(), false);
            }
        }
        if (!this.f17144C) {
            this.f17142A = ((this.f17164W / this.f17163V) * (this.f17161T - this.f17181i)) + this.f17170ae;
        }
        COUISeekBar cOUISeekBar = this.f17148G;
        if (cOUISeekBar != null && 0.0f != this.f17163V) {
            cOUISeekBar.setProgress((int) (((this.f17161T - this.f17181i) * cOUISeekBar.getMax()) / this.f17163V));
        }
        return this;
    }

    public int getProgress() {
        return this.f17161T;
    }

    public void setOnProgressChangedListener(InterfaceC3101a interfaceC3101a) {
        this.f17169ad = interfaceC3101a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m18324c() {
        return this.f17144C;
    }

    public void setThumbOnDragging(boolean z) {
        this.f17144C = z;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat("progress", this.f17161T);
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f17161T = bundle.getInt("progress");
            super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
            m18323c(this.f17161T);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public OplusNumSeekBar m18325d(int OplusGLSurfaceView_13) {
        this.f17187o = OplusGLSurfaceView_13;
        return this;
    }

    public void setInverseColor(boolean z) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        this.f17146E = z;
        Paint paint = this.f17153L;
        if (paint != null) {
            paint.setColor(z ? this.f17195w : this.f17194v);
            this.f17154M.setColor(z ? this.f17195w : this.f17194v);
        }
        m18320a("mBackgroundColor", getResources().getColorStateList(this.f17146E ? R.color.face_beauty_seekbar_track_color_inverse : R.color.face_beauty_seekbar_track_color, getContext().getTheme()));
        invalidate();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected float m18326e(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            return this.f17149H + m18326e(Math.abs(getProgress()));
        }
        if (OplusGLSurfaceView_13 < 10) {
            return this.f17150I;
        }
        if (OplusGLSurfaceView_13 < 100) {
            return this.f17151J;
        }
        return this.f17152K;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m18320a(String str, Object obj) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field declaredField = this.f17148G.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(this.f17148G, obj);
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("OplusNumSeekBar", "reflectSomethingNeed, something may be wrong: " + COUIBaseListPopupWindow_8);
        }
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        COUISeekBar cOUISeekBar = this.f17148G;
        if (cOUISeekBar != null) {
            cOUISeekBar.invalidate();
        }
    }

    @Override // android.view.View
    public void postInvalidate() {
        super.postInvalidate();
        COUISeekBar cOUISeekBar = this.f17148G;
        if (cOUISeekBar != null) {
            cOUISeekBar.postInvalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterfaceC3101a interfaceC3101a = this.f17169ad;
        if (interfaceC3101a == null || interfaceC3101a.mo18329a()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }
}
