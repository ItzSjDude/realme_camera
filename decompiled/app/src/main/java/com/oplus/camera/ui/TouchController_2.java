package com.oplus.camera.ui;

/* compiled from: HistogramView.java */
/* loaded from: classes2.dex */
public class m_renamed extends android.view.View {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f6317a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private float f6318b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private float f6319c;
    private boolean d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private boolean h_renamed;
    private boolean i_renamed;
    private float j_renamed;
    private float k_renamed;
    private float[][] l_renamed;
    private float[] m_renamed;
    private float[] n_renamed;
    private float[] o_renamed;
    private float p_renamed;
    private android.graphics.Bitmap q_renamed;
    private android.graphics.Paint r_renamed;
    private android.graphics.Paint s_renamed;
    private android.graphics.Paint t_renamed;
    private android.graphics.Paint u_renamed;
    private android.graphics.Paint v_renamed;
    private android.graphics.Paint w_renamed;
    private android.graphics.Paint x_renamed;
    private android.graphics.Paint y_renamed;
    private android.view.animation.Interpolator z_renamed;

    public m_renamed(android.content.Context context) {
        this(context, null);
    }

    public m_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6317a = "HistogramView";
        this.f6318b = 0.0f;
        this.f6319c = 0.0f;
        this.d_renamed = false;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.h_renamed = false;
        this.i_renamed = false;
        this.j_renamed = 0.0f;
        this.k_renamed = 0.0f;
        this.l_renamed = (float[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) float.class, 256, 3);
        this.m_renamed = new float[256];
        this.n_renamed = new float[256];
        this.o_renamed = new float[256];
        this.p_renamed = 0.0f;
        this.q_renamed = null;
        this.r_renamed = new android.graphics.Paint();
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = null;
        a_renamed();
        this.z_renamed = android.view.animation.AnimationUtils.loadInterpolator(getContext(), com.oplus.camera.R_renamed.anim.accelerate_decelerate_path_interpolator);
    }

    private void a_renamed() {
        this.r_renamed.setFlags(1);
        this.r_renamed.setColor(-16777216);
        this.r_renamed.setAlpha(0);
        this.s_renamed = new android.graphics.Paint();
        this.s_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.histogram_red));
        this.s_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.t_renamed = new android.graphics.Paint();
        this.t_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.histogram_green));
        this.t_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.u_renamed = new android.graphics.Paint();
        this.u_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.histogram_blue));
        this.u_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.v_renamed = new android.graphics.Paint();
        this.v_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.histogram_rg_overlay_yellow));
        this.v_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.w_renamed = new android.graphics.Paint();
        this.w_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.histogram_gb_overlay_cyan));
        this.w_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.x_renamed = new android.graphics.Paint();
        this.x_renamed.setColor(getResources().getColor(com.oplus.camera.R_renamed.color.histogram_rb_overlay_megenta));
        this.x_renamed.setStyle(android.graphics.Paint.Style.FILL);
        this.y_renamed = new android.graphics.Paint();
        this.y_renamed.setColor(-1);
        this.y_renamed.setStyle(android.graphics.Paint.Style.FILL);
    }

    public void a_renamed(float[] fArr, float[] fArr2, float[] fArr3, float f_renamed) {
        this.m_renamed = fArr;
        this.n_renamed = fArr2;
        this.o_renamed = fArr3;
        this.p_renamed = f_renamed;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        this.q_renamed = android.graphics.Bitmap.createBitmap(i_renamed, i2, android.graphics.Bitmap.Config.RGB_565);
        this.j_renamed = i_renamed;
        this.k_renamed = i2;
        super.onSizeChanged(i_renamed, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        android.graphics.Bitmap bitmap = this.q_renamed;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.r_renamed);
            float f_renamed = this.j_renamed / 256.0f;
            float f2 = this.k_renamed / (this.p_renamed * 4.0f);
            int i_renamed = 0;
            while (i_renamed < 256) {
                int i2 = i_renamed < 2 ? i_renamed + 2 : i_renamed > 253 ? i_renamed - 2 : i_renamed;
                float fA_renamed = a_renamed(this.m_renamed, i2);
                float fA2 = a_renamed(this.n_renamed, i2);
                float fA3 = a_renamed(this.o_renamed, i2);
                float[][] fArr = this.l_renamed;
                fArr[i_renamed][0] = fA_renamed * f2;
                fArr[i_renamed][1] = fA2 * f2;
                fArr[i_renamed][2] = fA3 * f2;
                float f3 = fArr[i_renamed][0];
                float f4 = this.k_renamed;
                if (f3 > f4) {
                    fArr[i_renamed][0] = f4;
                }
                float[][] fArr2 = this.l_renamed;
                float f5 = fArr2[i_renamed][1];
                float f6 = this.k_renamed;
                if (f5 > f6) {
                    fArr2[i_renamed][1] = f6;
                }
                float[][] fArr3 = this.l_renamed;
                float f7 = fArr3[i_renamed][2];
                float f8 = this.k_renamed;
                if (f7 > f8) {
                    fArr3[i_renamed][2] = f8;
                }
                float f9 = f_renamed * i_renamed;
                a_renamed(canvas, f9, this.k_renamed, f9 + ((f_renamed * 4.0f) / 2.0f), this.l_renamed[i_renamed]);
                i_renamed += 4;
            }
        }
    }

    private float a_renamed(float[] fArr, int i_renamed) {
        return ((((fArr[i_renamed - 2] + fArr[i_renamed - 1]) + fArr[i_renamed]) + fArr[i_renamed + 1]) + fArr[i_renamed + 2]) / 5.0f;
    }

    private void a_renamed(android.graphics.Canvas canvas, float f_renamed, float f2, float f3, float[] fArr) {
        char c2 = fArr[0] > fArr[1] ? fArr[0] > fArr[2] ? fArr[1] > fArr[2] ? (char) 0 : (char) 1 : (char) 3 : fArr[0] > fArr[2] ? (char) 5 : fArr[1] > fArr[2] ? (char) 4 : (char) 2;
        if (c2 == 0) {
            canvas.drawRect(f_renamed, f2 - fArr[2], f3, f2, this.y_renamed);
            canvas.drawRect(f_renamed, f2 - fArr[1], f3, f2 - fArr[2], this.v_renamed);
            canvas.drawRect(f_renamed, f2 - fArr[0], f3, f2 - fArr[1], this.s_renamed);
            return;
        }
        if (c2 == 1) {
            canvas.drawRect(f_renamed, f2 - fArr[1], f3, f2, this.y_renamed);
            canvas.drawRect(f_renamed, f2 - fArr[2], f3, f2 - fArr[1], this.x_renamed);
            canvas.drawRect(f_renamed, f2 - fArr[0], f3, f2 - fArr[2], this.s_renamed);
            return;
        }
        if (c2 == 2) {
            canvas.drawRect(f_renamed, f2 - fArr[0], f3, f2, this.y_renamed);
            canvas.drawRect(f_renamed, f2 - fArr[1], f3, f2 - fArr[0], this.w_renamed);
            canvas.drawRect(f_renamed, f2 - fArr[2], f3, f2 - fArr[1], this.u_renamed);
            return;
        }
        if (c2 == 3) {
            canvas.drawRect(f_renamed, f2 - fArr[1], f3, f2, this.y_renamed);
            canvas.drawRect(f_renamed, f2 - fArr[0], f3, f2 - fArr[1], this.x_renamed);
            canvas.drawRect(f_renamed, f2 - fArr[2], f3, f2 - fArr[0], this.u_renamed);
        } else if (c2 == 4) {
            canvas.drawRect(f_renamed, f2 - fArr[0], f3, f2, this.y_renamed);
            canvas.drawRect(f_renamed, f2 - fArr[2], f3, f2 - fArr[0], this.w_renamed);
            canvas.drawRect(f_renamed, f2 - fArr[1], f3, f2 - fArr[2], this.t_renamed);
        } else {
            if (c2 != 5) {
                return;
            }
            canvas.drawRect(f_renamed, f2 - fArr[2], f3, f2, this.y_renamed);
            canvas.drawRect(f_renamed, f2 - fArr[0], f3, f2 - fArr[2], this.v_renamed);
            canvas.drawRect(f_renamed, f2 - fArr[1], f3, f2 - fArr[0], this.t_renamed);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.i_renamed) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.d_renamed = false;
                this.f6318b = rawX;
                this.f6319c = rawY;
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) getParent();
                if (viewGroup != null) {
                    int[] iArr = new int[2];
                    viewGroup.getLocationInWindow(iArr);
                    this.f_renamed = viewGroup.getMeasuredHeight();
                    this.e_renamed = viewGroup.getMeasuredWidth();
                    this.g_renamed = iArr[0];
                }
            } else if (action != 1) {
                if (action == 2 && rawX >= 0.0f && rawX <= this.e_renamed) {
                    if (rawY >= this.g_renamed && rawY <= this.f_renamed + r2) {
                        float f_renamed = rawX - this.f6318b;
                        float f2 = rawY - this.f6319c;
                        if (!this.d_renamed) {
                            if (java.lang.Math.sqrt((f_renamed * f_renamed) + (f2 * f2)) < 2.0d) {
                                this.d_renamed = false;
                            } else {
                                this.d_renamed = true;
                            }
                        }
                        float x_renamed = f_renamed + getX();
                        float y_renamed = getY() + f2;
                        float width = this.e_renamed - getWidth();
                        float height = this.f_renamed - getHeight();
                        if (x_renamed < 0.0f) {
                            x_renamed = 0.0f;
                        } else if (x_renamed > width) {
                            x_renamed = width;
                        }
                        if (y_renamed < 0.0f) {
                            y_renamed = 0.0f;
                        } else if (y_renamed > height) {
                            y_renamed = height;
                        }
                        setX(x_renamed);
                        setY(y_renamed);
                        this.f6318b = rawX;
                        this.f6319c = rawY;
                    }
                }
            } else if (this.h_renamed && this.d_renamed) {
                if (this.f6318b <= this.e_renamed / 2) {
                    animate().setInterpolator(this.z_renamed).setDuration(500L).x_renamed(0.0f).start();
                } else {
                    animate().setInterpolator(this.z_renamed).setDuration(500L).x_renamed(this.e_renamed - getWidth()).start();
                }
            }
        }
        boolean z_renamed = this.d_renamed;
        return z_renamed ? z_renamed : super.onTouchEvent(motionEvent);
    }
}
