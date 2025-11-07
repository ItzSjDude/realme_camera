package com.coui.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatImageView;
import com.coui.appcompat.p099a.COUIRoundRectUtil;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIRoundImageView extends AppCompatImageView {

    /* renamed from: A */
    private float f7687A;

    /* renamed from: B */
    private Drawable f7688B;

    /* renamed from: C */
    private Bitmap f7689C;

    /* renamed from: D */
    private float f7690D;

    /* renamed from: E */
    private int f7691E;

    /* renamed from: F */
    private Paint f7692F;

    /* renamed from: G */
    private int f7693G;

    /* renamed from: PlatformImplementations.kt_3 */
    private final RectF f7694a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final RectF f7695b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f7696c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Context f7697d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f7698e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f7699f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f7700g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private RectF f7701h;

    /* renamed from: OplusGLSurfaceView_13 */
    private RectF f7702i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Drawable f7703j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Drawable f7704k;

    /* renamed from: OplusGLSurfaceView_14 */
    private Bitmap f7705l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f7706m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f7707n;

    /* renamed from: o */
    private int f7708o;

    /* renamed from: p */
    private int f7709p;

    /* renamed from: q */
    private BitmapShader f7710q;

    /* renamed from: r */
    private int f7711r;

    /* renamed from: s */
    private int f7712s;

    /* renamed from: t */
    private int f7713t;

    /* renamed from: u */
    private Paint f7714u;

    /* renamed from: v */
    private Paint f7715v;

    /* renamed from: w */
    private int f7716w;

    /* renamed from: x */
    private Matrix f7717x;

    /* renamed from: y */
    private BitmapShader f7718y;

    /* renamed from: z */
    private int f7719z;

    public COUIRoundImageView(Context context) {
        super(context);
        this.f7694a = new RectF();
        this.f7695b = new RectF();
        this.f7717x = new Matrix();
        this.f7697d = context;
        this.f7714u = new Paint();
        this.f7714u.setAntiAlias(true);
        m7407c();
        this.f7715v = new Paint();
        this.f7715v.setAntiAlias(true);
        this.f7715v.setColor(getResources().getColor(R.color.coui_roundimageview_outcircle_color));
        this.f7715v.setStrokeWidth(1.0f);
        this.f7715v.setStyle(Paint.Style.STROKE);
        this.f7696c = 0;
        this.f7719z = getResources().getDimensionPixelSize(R.dimen.coui_roundimageview_default_radius);
        setupShader(getDrawable());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7407c() {
        this.f7692F = new Paint();
        this.f7692F.setStrokeWidth(2.0f);
        this.f7692F.setStyle(Paint.Style.STROKE);
        this.f7692F.setAntiAlias(true);
        this.f7692F.setColor(getResources().getColor(R.color.coui_border));
    }

    public COUIRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7694a = new RectF();
        this.f7695b = new RectF();
        if (attributeSet != null) {
            this.f7693G = attributeSet.getStyleAttribute();
        }
        this.f7717x = new Matrix();
        this.f7697d = context;
        this.f7714u = new Paint();
        this.f7714u.setAntiAlias(true);
        this.f7714u.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        m7407c();
        this.f7715v = new Paint();
        this.f7715v.setAntiAlias(true);
        this.f7715v.setStrokeWidth(2.0f);
        this.f7715v.setStyle(Paint.Style.STROKE);
        this.f7704k = context.getResources().getDrawable(R.drawable.coui_round_image_view_shadow);
        this.f7706m = this.f7704k.getIntrinsicWidth();
        this.f7707n = this.f7704k.getIntrinsicHeight();
        this.f7708o = (int) context.getResources().getDimension(R.dimen.coui_roundimageView_src_width);
        this.f7709p = this.f7708o;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIRoundImageView);
        this.f7700g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIRoundImageView_couiBorderRadius, (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.f7696c = typedArrayObtainStyledAttributes.getInt(R.styleable.COUIRoundImageView_couiType, 0);
        this.f7698e = typedArrayObtainStyledAttributes.getBoolean(R.styleable.COUIRoundImageView_couiHasBorder, false);
        this.f7699f = typedArrayObtainStyledAttributes.getBoolean(R.styleable.COUIRoundImageView_couiHasDefaultPic, true);
        this.f7716w = typedArrayObtainStyledAttributes.getColor(R.styleable.f24475xe33a2384, 0);
        this.f7715v.setColor(this.f7716w);
        m7409a();
        setupShader(getDrawable());
        typedArrayObtainStyledAttributes.recycle();
    }

    public COUIRoundImageView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f7694a = new RectF();
        this.f7695b = new RectF();
        m7409a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7409a() {
        this.f7695b.set(0.0f, 0.0f, this.f7706m, this.f7707n);
        this.f7713t = this.f7706m - this.f7708o;
        this.f7694a.set(this.f7695b);
        RectF rectF = this.f7694a;
        int OplusGLSurfaceView_13 = this.f7713t;
        rectF.inset(OplusGLSurfaceView_13 / 2, OplusGLSurfaceView_13 / 2);
    }

    public void setHasBorder(boolean z) {
        this.f7698e = z;
    }

    public void setOutCircleColor(int OplusGLSurfaceView_13) {
        this.f7716w = OplusGLSurfaceView_13;
        this.f7715v.setColor(OplusGLSurfaceView_13);
        invalidate();
    }

    public void setHasDefaultPic(boolean z) {
        this.f7699f = z;
    }

    public void setBorderRectRadius(int OplusGLSurfaceView_13) {
        this.f7700g = OplusGLSurfaceView_13;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f7690D = 1.0f;
        Bitmap bitmap = this.f7689C;
        if (bitmap != null) {
            int OplusGLSurfaceView_13 = this.f7696c;
            if (OplusGLSurfaceView_13 == 0) {
                this.f7691E = Math.min(bitmap.getWidth(), this.f7689C.getHeight());
                this.f7690D = (this.f7719z * 1.0f) / this.f7691E;
            } else if (OplusGLSurfaceView_13 == 1) {
                this.f7690D = Math.max((getWidth() * 1.0f) / this.f7689C.getWidth(), (getHeight() * 1.0f) / this.f7689C.getHeight());
            } else if (OplusGLSurfaceView_13 == 2) {
                this.f7690D = Math.max((getWidth() * 1.0f) / this.f7706m, (getHeight() * 1.0f) / this.f7707n);
                this.f7717x.reset();
                Matrix matrix = this.f7717x;
                float COUIBaseListPopupWindow_12 = this.f7690D;
                matrix.setScale(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
                this.f7710q.setLocalMatrix(this.f7717x);
                this.f7714u.setShader(this.f7710q);
                canvas.drawRect(this.f7701h, this.f7714u);
                return;
            }
            Matrix matrix2 = this.f7717x;
            float f2 = this.f7690D;
            matrix2.setScale(f2, f2);
            BitmapShader bitmapShader = this.f7718y;
            if (bitmapShader != null) {
                bitmapShader.setLocalMatrix(this.f7717x);
                this.f7714u.setShader(this.f7718y);
            }
        }
        int i2 = this.f7696c;
        if (i2 == 0) {
            if (this.f7698e) {
                float f3 = this.f7687A;
                canvas.drawCircle(f3, f3, f3, this.f7714u);
                float f4 = this.f7687A;
                canvas.drawCircle(f4, f4, f4 - 0.5f, this.f7715v);
                return;
            }
            float f5 = this.f7687A;
            canvas.drawCircle(f5, f5, f5, this.f7714u);
            return;
        }
        if (i2 == 1) {
            if (this.f7701h == null) {
                this.f7701h = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            }
            if (this.f7702i == null) {
                this.f7702i = new RectF(1.0f, 1.0f, getWidth() - 1.0f, getHeight() - 1.0f);
            }
            if (this.f7698e) {
                canvas.drawPath(COUIRoundRectUtil.m6450a().m6452a(this.f7701h, this.f7700g), this.f7714u);
                canvas.drawPath(COUIRoundRectUtil.m6450a().m6452a(this.f7702i, this.f7700g - 1.0f), this.f7715v);
            } else {
                canvas.drawPath(COUIRoundRectUtil.m6450a().m6452a(this.f7701h, this.f7700g), this.f7714u);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Bitmap m7410b() {
        m7408d();
        this.f7710q = new BitmapShader(this.f7689C, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.f7710q.setLocalMatrix(this.f7717x);
        this.f7714u.setShader(this.f7710q);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f7706m, this.f7707n, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        this.f7700g = this.f7708o / 2;
        canvas.drawPath(COUIRoundRectUtil.m6450a().m6452a(this.f7694a, this.f7700g), this.f7714u);
        this.f7704k.setBounds(0, 0, this.f7706m, this.f7707n);
        this.f7704k.draw(canvas);
        return bitmapCreateBitmap;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7408d() {
        this.f7717x.reset();
        float COUIBaseListPopupWindow_12 = (float) ((this.f7708o * 1.0d) / this.f7711r);
        float f2 = (float) ((this.f7709p * 1.0d) / this.f7712s);
        if (COUIBaseListPopupWindow_12 <= 1.0f) {
            COUIBaseListPopupWindow_12 = 1.0f;
        }
        if (f2 <= 1.0f) {
            f2 = 1.0f;
        }
        float fMax = Math.max(COUIBaseListPopupWindow_12, f2);
        float f3 = (this.f7708o - (this.f7711r * fMax)) * 0.5f;
        float f4 = (this.f7709p - (this.f7712s * fMax)) * 0.5f;
        this.f7717x.setScale(fMax, fMax);
        Matrix matrix = this.f7717x;
        int OplusGLSurfaceView_13 = this.f7713t;
        matrix.postTranslate(((int) (f3 + 0.5f)) + (OplusGLSurfaceView_13 / 2), ((int) (f4 + 0.5f)) + (OplusGLSurfaceView_13 / 2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        int i5 = this.f7696c;
        if (i5 == 1 || i5 == 2) {
            this.f7701h = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.f7702i = new RectF(1.0f, 1.0f, getWidth() - 1.0f, getHeight() - 1.0f);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        if (this.f7696c == 0) {
            int iMin = Math.min(getMeasuredHeight(), getMeasuredWidth());
            if (iMin == 0) {
                iMin = this.f7719z;
            }
            this.f7719z = iMin;
            int i3 = this.f7719z;
            this.f7687A = i3 / 2.0f;
            setMeasuredDimension(i3, i3);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        setupShader(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int OplusGLSurfaceView_13) {
        super.setImageResource(OplusGLSurfaceView_13);
        setupShader(this.f7697d.getResources().getDrawable(OplusGLSurfaceView_13));
    }

    private void setupShader(Drawable drawable) {
        this.f7688B = getDrawable();
        Drawable drawable2 = this.f7688B;
        if (drawable2 == null || drawable == null) {
            if (this.f7703j != null || !this.f7699f) {
                return;
            }
            this.f7688B = getResources().getDrawable(R.drawable.coui_ic_contact_picture);
            this.f7703j = getResources().getDrawable(R.drawable.coui_ic_contact_picture);
        } else if (drawable2 != drawable) {
            this.f7688B = drawable;
        }
        this.f7711r = this.f7688B.getIntrinsicWidth();
        this.f7712s = this.f7688B.getIntrinsicHeight();
        this.f7689C = m7406a(this.f7688B);
        if (this.f7696c == 2) {
            this.f7705l = m7410b();
            this.f7710q = new BitmapShader(this.f7705l, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        }
        Bitmap bitmap = this.f7689C;
        if (bitmap != null) {
            this.f7718y = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap m7406a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public void setType(int OplusGLSurfaceView_13) {
        if (this.f7696c != OplusGLSurfaceView_13) {
            this.f7696c = OplusGLSurfaceView_13;
            if (this.f7696c == 0) {
                int iMin = Math.min(getMeasuredHeight(), getMeasuredWidth());
                if (iMin == 0) {
                    iMin = this.f7719z;
                }
                this.f7719z = iMin;
                this.f7687A = this.f7719z / 2.0f;
            }
            invalidate();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f7688B != null) {
            this.f7688B.setState(getDrawableState());
            setupShader(this.f7688B);
            invalidate();
        }
    }
}
