package com.oplus.camera.p172ui.inverse;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class InverseMakeupItemView extends InverseImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f18697a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Bitmap f18698b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Paint f18699c;

    public InverseMakeupItemView(Context context) {
        this(context, null);
    }

    public InverseMakeupItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InverseMakeupItemView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f18697a = 0;
        this.f18698b = null;
        this.f18699c = null;
    }

    public void setCornerMark(int OplusGLSurfaceView_13) {
        this.f18697a = OplusGLSurfaceView_13;
        if (this.f18697a != 0) {
            if (Util.m24354aq()) {
                int i2 = this.f18697a;
                if (1 == i2) {
                    this.f18698b = Util.m24480n(R.drawable.makeup_corner_mark_exclusive_cn);
                } else if (2 == i2) {
                    this.f18698b = Util.m24480n(R.drawable.makeup_corner_mark_custom_cn);
                }
            } else {
                int i3 = this.f18697a;
                if (1 == i3) {
                    this.f18698b = Util.m24480n(R.drawable.makeup_corner_mark_exclusive_en);
                } else if (2 == i3) {
                    this.f18698b = Util.m24480n(R.drawable.makeup_corner_mark_custom_en);
                }
            }
            this.f18699c = new Paint();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        super.onDraw(canvas);
        if (this.f18697a == 0 || (bitmap = this.f18698b) == null) {
            return;
        }
        canvas.drawBitmap(bitmap, getPaddingStart(), getPaddingEnd(), this.f18699c);
    }
}
