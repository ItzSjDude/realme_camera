package com.oplus.camera.p172ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class RoundImageView extends ImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap f22664a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Shader f22665b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Paint f22666c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float f22667d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private RectF f22668e;

    public RoundImageView(Context context) {
        super(context);
        this.f22666c = new Paint();
        this.f22667d = 0.0f;
        this.f22668e = new RectF();
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22666c = new Paint();
        this.f22667d = 0.0f;
        this.f22668e = new RectF();
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f22666c = new Paint();
        this.f22667d = 0.0f;
        this.f22668e = new RectF();
    }

    public void setBitmap(Bitmap bitmap) {
        this.f22664a = bitmap;
        this.f22665b = new BitmapShader(this.f22664a, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24029a() {
        Bitmap bitmap = this.f22664a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f22664a.recycle();
        }
        this.f22666c.setShader(null);
        this.f22665b = null;
        this.f22664a = null;
    }

    public void setMRadius(float COUIBaseListPopupWindow_12) {
        this.f22667d = COUIBaseListPopupWindow_12;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f22665b != null) {
            canvas.save();
            this.f22666c.setShader(this.f22665b);
            this.f22666c.setAntiAlias(true);
            this.f22668e.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            RectF rectF = this.f22668e;
            float COUIBaseListPopupWindow_12 = this.f22667d;
            canvas.drawRoundRect(rectF, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, this.f22666c);
            canvas.restore();
        }
    }
}
