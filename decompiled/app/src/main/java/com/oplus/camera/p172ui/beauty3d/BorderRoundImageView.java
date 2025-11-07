package com.oplus.camera.p172ui.beauty3d;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class BorderRoundImageView extends ImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    private Paint f17607a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Paint f17608b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Bitmap f17609c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Canvas f17610d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private BitmapShader f17611e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Matrix f17612f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f17613g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f17614h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f17615i;

    public BorderRoundImageView(Context context) {
        this(context, null);
    }

    public BorderRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BorderRoundImageView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet);
        this.f17607a = new Paint(1);
        this.f17608b = new Paint(1);
        this.f17609c = null;
        this.f17610d = new Canvas();
        this.f17611e = null;
        this.f17612f = new Matrix();
        this.f17613g = 0.0f;
        this.f17614h = 0;
        this.f17615i = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.borderRoundImageView, OplusGLSurfaceView_13, 0);
        this.f17613g = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, getResources().getDimensionPixelSize(R.dimen.beauty3d_edit_recyclerview_item_border_width));
        this.f17614h = typedArrayObtainStyledAttributes.getColor(0, Util.m24164A(context));
        typedArrayObtainStyledAttributes.recycle();
        this.f17608b.setStyle(Paint.Style.STROKE);
        this.f17608b.setStrokeWidth(this.f17613g);
        this.f17608b.setColor(this.f17614h);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmapM18568a = m18568a(getDrawable());
        if (bitmapM18568a != null) {
            int iMin = Math.min(getWidth(), getHeight());
            if (this.f17611e == null || !bitmapM18568a.equals(this.f17609c)) {
                this.f17609c = bitmapM18568a;
                this.f17611e = new BitmapShader(this.f17609c, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            }
            if (this.f17611e != null) {
                float COUIBaseListPopupWindow_12 = iMin;
                this.f17612f.setScale((COUIBaseListPopupWindow_12 - (this.f17613g * 2.0f)) / bitmapM18568a.getWidth(), (COUIBaseListPopupWindow_12 - (this.f17613g * 2.0f)) / bitmapM18568a.getHeight());
                this.f17611e.setLocalMatrix(this.f17612f);
            }
            this.f17607a.setShader(this.f17611e);
            float f2 = iMin / 2.0f;
            if (this.f17615i) {
                canvas.drawCircle(f2, f2, f2 - (this.f17613g / 2.0f), this.f17608b);
            }
            float f3 = this.f17613g;
            canvas.translate(f3, f3);
            float f4 = this.f17613g;
            canvas.drawCircle(f2 - f4, f2 - f4, f2 - f4, this.f17607a);
            return;
        }
        super.onDraw(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap m18568a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (!(drawable instanceof ColorDrawable)) {
            return null;
        }
        Rect bounds = drawable.getBounds();
        int OplusGLSurfaceView_13 = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        int color = ((ColorDrawable) drawable).getColor();
        Bitmap bitmapM24215a = Util.m24215a(OplusGLSurfaceView_13, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = this.f17610d;
        if (canvas != null) {
            canvas.setBitmap(bitmapM24215a);
            this.f17610d.drawARGB(Color.alpha(color), Color.red(color), Color.green(color), Color.blue(color));
        }
        return bitmapM24215a;
    }

    public void setHighLight(boolean z) {
        this.f17615i = z;
        invalidate();
    }
}
