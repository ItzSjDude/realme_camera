package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class COUIRoundImageView extends androidx.appcompat.widget.AppCompatImageView {
    private float A_renamed;
    private android.graphics.drawable.Drawable B_renamed;
    private android.graphics.Bitmap C_renamed;
    private float D_renamed;
    private int E_renamed;
    private android.graphics.Paint F_renamed;
    private int G_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.graphics.RectF f2818a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.RectF f2819b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f2820c;
    private android.content.Context d_renamed;
    private boolean e_renamed;
    private boolean f_renamed;
    private int g_renamed;
    private android.graphics.RectF h_renamed;
    private android.graphics.RectF i_renamed;
    private android.graphics.drawable.Drawable j_renamed;
    private android.graphics.drawable.Drawable k_renamed;
    private android.graphics.Bitmap l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private int p_renamed;
    private android.graphics.BitmapShader q_renamed;
    private int r_renamed;
    private int s_renamed;
    private int t_renamed;
    private android.graphics.Paint u_renamed;
    private android.graphics.Paint v_renamed;
    private int w_renamed;
    private android.graphics.Matrix x_renamed;
    private android.graphics.BitmapShader y_renamed;
    private int z_renamed;

    public COUIRoundImageView(android.content.Context context) {
        super(context);
        this.f2818a = new android.graphics.RectF();
        this.f2819b = new android.graphics.RectF();
        this.x_renamed = new android.graphics.Matrix();
        this.d_renamed = context;
        this.u_renamed = new android.graphics.Paint();
        this.u_renamed.setAntiAlias(true);
        c_renamed();
        this.v_renamed = new android.graphics.Paint();
        this.v_renamed.setAntiAlias(true);
        this.v_renamed.setColor(getResources().getColor(coui.support.appcompat.R_renamed.color.coui_roundimageview_outcircle_color));
        this.v_renamed.setStrokeWidth(1.0f);
        this.v_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.f2820c = 0;
        this.z_renamed = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_roundimageview_default_radius);
        setupShader(getDrawable());
    }

    private void c_renamed() {
        this.F_renamed = new android.graphics.Paint();
        this.F_renamed.setStrokeWidth(2.0f);
        this.F_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.F_renamed.setAntiAlias(true);
        this.F_renamed.setColor(getResources().getColor(coui.support.appcompat.R_renamed.color.coui_border));
    }

    public COUIRoundImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2818a = new android.graphics.RectF();
        this.f2819b = new android.graphics.RectF();
        if (attributeSet != null) {
            this.G_renamed = attributeSet.getStyleAttribute();
        }
        this.x_renamed = new android.graphics.Matrix();
        this.d_renamed = context;
        this.u_renamed = new android.graphics.Paint();
        this.u_renamed.setAntiAlias(true);
        this.u_renamed.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_OVER));
        c_renamed();
        this.v_renamed = new android.graphics.Paint();
        this.v_renamed.setAntiAlias(true);
        this.v_renamed.setStrokeWidth(2.0f);
        this.v_renamed.setStyle(android.graphics.Paint.Style.STROKE);
        this.k_renamed = context.getResources().getDrawable(coui.support.appcompat.R_renamed.drawable.coui_round_image_view_shadow);
        this.m_renamed = this.k_renamed.getIntrinsicWidth();
        this.n_renamed = this.k_renamed.getIntrinsicHeight();
        this.o_renamed = (int) context.getResources().getDimension(coui.support.appcompat.R_renamed.dimen.coui_roundimageView_src_width);
        this.p_renamed = this.o_renamed;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIRoundImageView);
        this.g_renamed = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIRoundImageView_couiBorderRadius, (int) android.util.TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.f2820c = typedArrayObtainStyledAttributes.getInt(coui.support.appcompat.R_renamed.styleable.COUIRoundImageView_couiType, 0);
        this.e_renamed = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R_renamed.styleable.COUIRoundImageView_couiHasBorder, false);
        this.f_renamed = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R_renamed.styleable.COUIRoundImageView_couiHasDefaultPic, true);
        this.w_renamed = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R_renamed.styleable.COUIRoundImageView_couiRoundImageViewOutCircleColor, 0);
        this.v_renamed.setColor(this.w_renamed);
        a_renamed();
        setupShader(getDrawable());
        typedArrayObtainStyledAttributes.recycle();
    }

    public COUIRoundImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f2818a = new android.graphics.RectF();
        this.f2819b = new android.graphics.RectF();
        a_renamed();
    }

    public void a_renamed() {
        this.f2819b.set(0.0f, 0.0f, this.m_renamed, this.n_renamed);
        this.t_renamed = this.m_renamed - this.o_renamed;
        this.f2818a.set(this.f2819b);
        android.graphics.RectF rectF = this.f2818a;
        int i_renamed = this.t_renamed;
        rectF.inset(i_renamed / 2, i_renamed / 2);
    }

    public void setHasBorder(boolean z_renamed) {
        this.e_renamed = z_renamed;
    }

    public void setOutCircleColor(int i_renamed) {
        this.w_renamed = i_renamed;
        this.v_renamed.setColor(i_renamed);
        invalidate();
    }

    public void setHasDefaultPic(boolean z_renamed) {
        this.f_renamed = z_renamed;
    }

    public void setBorderRectRadius(int i_renamed) {
        this.g_renamed = i_renamed;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        this.D_renamed = 1.0f;
        android.graphics.Bitmap bitmap = this.C_renamed;
        if (bitmap != null) {
            int i_renamed = this.f2820c;
            if (i_renamed == 0) {
                this.E_renamed = java.lang.Math.min(bitmap.getWidth(), this.C_renamed.getHeight());
                this.D_renamed = (this.z_renamed * 1.0f) / this.E_renamed;
            } else if (i_renamed == 1) {
                this.D_renamed = java.lang.Math.max((getWidth() * 1.0f) / this.C_renamed.getWidth(), (getHeight() * 1.0f) / this.C_renamed.getHeight());
            } else if (i_renamed == 2) {
                this.D_renamed = java.lang.Math.max((getWidth() * 1.0f) / this.m_renamed, (getHeight() * 1.0f) / this.n_renamed);
                this.x_renamed.reset();
                android.graphics.Matrix matrix = this.x_renamed;
                float f_renamed = this.D_renamed;
                matrix.setScale(f_renamed, f_renamed);
                this.q_renamed.setLocalMatrix(this.x_renamed);
                this.u_renamed.setShader(this.q_renamed);
                canvas.drawRect(this.h_renamed, this.u_renamed);
                return;
            }
            android.graphics.Matrix matrix2 = this.x_renamed;
            float f2 = this.D_renamed;
            matrix2.setScale(f2, f2);
            android.graphics.BitmapShader bitmapShader = this.y_renamed;
            if (bitmapShader != null) {
                bitmapShader.setLocalMatrix(this.x_renamed);
                this.u_renamed.setShader(this.y_renamed);
            }
        }
        int i2 = this.f2820c;
        if (i2 == 0) {
            if (this.e_renamed) {
                float f3 = this.A_renamed;
                canvas.drawCircle(f3, f3, f3, this.u_renamed);
                float f4 = this.A_renamed;
                canvas.drawCircle(f4, f4, f4 - 0.5f, this.v_renamed);
                return;
            }
            float f5 = this.A_renamed;
            canvas.drawCircle(f5, f5, f5, this.u_renamed);
            return;
        }
        if (i2 == 1) {
            if (this.h_renamed == null) {
                this.h_renamed = new android.graphics.RectF(0.0f, 0.0f, getWidth(), getHeight());
            }
            if (this.i_renamed == null) {
                this.i_renamed = new android.graphics.RectF(1.0f, 1.0f, getWidth() - 1.0f, getHeight() - 1.0f);
            }
            if (this.e_renamed) {
                canvas.drawPath(com.coui.appcompat.a_renamed.o_renamed.a_renamed().a_renamed(this.h_renamed, this.g_renamed), this.u_renamed);
                canvas.drawPath(com.coui.appcompat.a_renamed.o_renamed.a_renamed().a_renamed(this.i_renamed, this.g_renamed - 1.0f), this.v_renamed);
            } else {
                canvas.drawPath(com.coui.appcompat.a_renamed.o_renamed.a_renamed().a_renamed(this.h_renamed, this.g_renamed), this.u_renamed);
            }
        }
    }

    public android.graphics.Bitmap b_renamed() {
        d_renamed();
        this.q_renamed = new android.graphics.BitmapShader(this.C_renamed, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        this.q_renamed.setLocalMatrix(this.x_renamed);
        this.u_renamed.setShader(this.q_renamed);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(this.m_renamed, this.n_renamed, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        this.g_renamed = this.o_renamed / 2;
        canvas.drawPath(com.coui.appcompat.a_renamed.o_renamed.a_renamed().a_renamed(this.f2818a, this.g_renamed), this.u_renamed);
        this.k_renamed.setBounds(0, 0, this.m_renamed, this.n_renamed);
        this.k_renamed.draw(canvas);
        return bitmapCreateBitmap;
    }

    private void d_renamed() {
        this.x_renamed.reset();
        float f_renamed = (float) ((this.o_renamed * 1.0d) / this.r_renamed);
        float f2 = (float) ((this.p_renamed * 1.0d) / this.s_renamed);
        if (f_renamed <= 1.0f) {
            f_renamed = 1.0f;
        }
        if (f2 <= 1.0f) {
            f2 = 1.0f;
        }
        float fMax = java.lang.Math.max(f_renamed, f2);
        float f3 = (this.o_renamed - (this.r_renamed * fMax)) * 0.5f;
        float f4 = (this.p_renamed - (this.s_renamed * fMax)) * 0.5f;
        this.x_renamed.setScale(fMax, fMax);
        android.graphics.Matrix matrix = this.x_renamed;
        int i_renamed = this.t_renamed;
        matrix.postTranslate(((int) (f3 + 0.5f)) + (i_renamed / 2), ((int) (f4 + 0.5f)) + (i_renamed / 2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        super.onSizeChanged(i_renamed, i2, i3, i4);
        int i5 = this.f2820c;
        if (i5 == 1 || i5 == 2) {
            this.h_renamed = new android.graphics.RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.i_renamed = new android.graphics.RectF(1.0f, 1.0f, getWidth() - 1.0f, getHeight() - 1.0f);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        if (this.f2820c == 0) {
            int iMin = java.lang.Math.min(getMeasuredHeight(), getMeasuredWidth());
            if (iMin == 0) {
                iMin = this.z_renamed;
            }
            this.z_renamed = iMin;
            int i3 = this.z_renamed;
            this.A_renamed = i3 / 2.0f;
            setMeasuredDimension(i3, i3);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        super.setImageDrawable(drawable);
        setupShader(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i_renamed) {
        super.setImageResource(i_renamed);
        setupShader(this.d_renamed.getResources().getDrawable(i_renamed));
    }

    private void setupShader(android.graphics.drawable.Drawable drawable) {
        this.B_renamed = getDrawable();
        android.graphics.drawable.Drawable drawable2 = this.B_renamed;
        if (drawable2 == null || drawable == null) {
            if (this.j_renamed != null || !this.f_renamed) {
                return;
            }
            this.B_renamed = getResources().getDrawable(coui.support.appcompat.R_renamed.drawable.coui_ic_contact_picture);
            this.j_renamed = getResources().getDrawable(coui.support.appcompat.R_renamed.drawable.coui_ic_contact_picture);
        } else if (drawable2 != drawable) {
            this.B_renamed = drawable;
        }
        this.r_renamed = this.B_renamed.getIntrinsicWidth();
        this.s_renamed = this.B_renamed.getIntrinsicHeight();
        this.C_renamed = a_renamed(this.B_renamed);
        if (this.f2820c == 2) {
            this.l_renamed = b_renamed();
            this.q_renamed = new android.graphics.BitmapShader(this.l_renamed, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        }
        android.graphics.Bitmap bitmap = this.C_renamed;
        if (bitmap != null) {
            this.y_renamed = new android.graphics.BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        }
    }

    private android.graphics.Bitmap a_renamed(android.graphics.drawable.Drawable drawable) {
        if (drawable instanceof android.graphics.drawable.BitmapDrawable) {
            return ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public void setType(int i_renamed) {
        if (this.f2820c != i_renamed) {
            this.f2820c = i_renamed;
            if (this.f2820c == 0) {
                int iMin = java.lang.Math.min(getMeasuredHeight(), getMeasuredWidth());
                if (iMin == 0) {
                    iMin = this.z_renamed;
                }
                this.z_renamed = iMin;
                this.A_renamed = this.z_renamed / 2.0f;
            }
            invalidate();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.B_renamed != null) {
            this.B_renamed.setState(getDrawableState());
            setupShader(this.B_renamed);
            invalidate();
        }
    }
}
