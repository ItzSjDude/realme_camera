package com.oplus.camera.p172ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.oplus.camera.R;

/* compiled from: RotableViewWithText.java */
/* renamed from: com.oplus.camera.ui.t */
/* loaded from: classes2.dex */
public class RotableViewWithText extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f22494a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f22495b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f22496c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f22497d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f22498e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f22499f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private long f22500g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private long f22501h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Bitmap f22502i;

    /* renamed from: OplusGLSurfaceView_15 */
    private String f22503j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Paint f22504k;

    public RotableViewWithText(Context context) {
        this(context, null);
    }

    public RotableViewWithText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotableViewWithText(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f22494a = 0;
        this.f22495b = 0;
        this.f22496c = 0;
        this.f22497d = 0;
        this.f22498e = false;
        this.f22499f = true;
        this.f22500g = 0L;
        this.f22501h = 0L;
        this.f22502i = null;
        this.f22503j = null;
        this.f22504k = null;
        this.f22504k = new Paint();
        this.f22504k.setTextSize(getContext().getResources().getDimension(R.dimen.rotableview_text_size));
        this.f22504k.setColor(getContext().getColor(R.color.camera_white));
        this.f22504k.setTextAlign(Paint.Align.CENTER);
        this.f22504k.setFlags(1);
    }

    public void setText(String str) {
        this.f22503j = str;
    }

    public void setImage(Bitmap bitmap) {
        this.f22502i = bitmap;
    }

    public void setViewGap(int OplusGLSurfaceView_13) {
        this.f22497d = OplusGLSurfaceView_13;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23913a(int OplusGLSurfaceView_13, boolean z) {
        int i2;
        if (isShown()) {
            this.f22499f = z;
        } else {
            this.f22499f = false;
        }
        if (OplusGLSurfaceView_13 >= 0) {
            i2 = OplusGLSurfaceView_13 % 360;
        } else {
            i2 = (OplusGLSurfaceView_13 % 360) + 360;
        }
        if (i2 == this.f22496c) {
            return;
        }
        this.f22496c = i2;
        if (this.f22499f) {
            this.f22495b = this.f22494a;
            this.f22500g = AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f22496c - this.f22494a;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.f22498e = i3 >= 0;
            this.f22501h = this.f22500g + ((Math.abs(i3) * 1000) / 270);
        } else {
            this.f22494a = this.f22496c;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int height;
        int OplusGLSurfaceView_13;
        if (this.f22494a != this.f22496c) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.f22501h) {
                int i2 = (int) (jCurrentAnimationTimeMillis - this.f22500g);
                int i3 = this.f22495b;
                if (!this.f22498e) {
                    i2 = -i2;
                }
                int i4 = i3 + ((i2 * 270) / 1000);
                if (i4 >= 0) {
                    OplusGLSurfaceView_13 = i4 % 360;
                } else {
                    OplusGLSurfaceView_13 = (i4 % 360) + 360;
                }
                this.f22494a = OplusGLSurfaceView_13;
                invalidate();
            } else {
                this.f22494a = this.f22496c;
            }
        }
        canvas.rotate(-this.f22494a, getWidth() / 2, getHeight() / 2);
        boolean zIsEmpty = TextUtils.isEmpty(this.f22503j);
        int i5 = (int) (this.f22504k.getFontMetrics().bottom - this.f22504k.getFontMetrics().top);
        int i6 = this.f22497d;
        if (!zIsEmpty) {
            canvas.drawText(this.f22503j, getWidth() / 2.0f, ((getHeight() - (this.f22502i.getHeight() + i6)) / 2) + this.f22502i.getHeight() + i6 + (i5 / 2), this.f22504k);
        }
        if (this.f22502i != null) {
            int width = (getWidth() - this.f22502i.getWidth()) / 2;
            if (zIsEmpty) {
                height = (getHeight() - this.f22502i.getHeight()) / 2;
            } else {
                height = (getHeight() - ((this.f22502i.getHeight() + i5) + i6)) / 2;
            }
            canvas.drawBitmap(this.f22502i, width, height, (Paint) null);
        }
    }
}
