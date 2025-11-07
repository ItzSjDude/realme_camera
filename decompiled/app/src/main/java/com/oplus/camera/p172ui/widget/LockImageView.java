package com.oplus.camera.p172ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class LockImageView extends ImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap f22607a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Bitmap f22608b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Paint f22609c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float f22610d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f22611e;

    public LockImageView(Context context) {
        super(context);
        this.f22607a = null;
        this.f22608b = null;
        this.f22609c = null;
        this.f22610d = 0.0f;
        this.f22611e = false;
        m23975a();
    }

    public LockImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22607a = null;
        this.f22608b = null;
        this.f22609c = null;
        this.f22610d = 0.0f;
        this.f22611e = false;
        m23975a();
    }

    public LockImageView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f22607a = null;
        this.f22608b = null;
        this.f22609c = null;
        this.f22610d = 0.0f;
        this.f22611e = false;
        m23975a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23975a() {
        this.f22607a = BitmapFactory.decodeResource(getResources(), R.drawable.icon_locked);
        this.f22608b = BitmapFactory.decodeResource(getResources(), R.drawable.icon_unlock);
        this.f22609c = new Paint();
        this.f22609c.setAntiAlias(true);
    }

    @Override // android.view.View
    public void setAlpha(float COUIBaseListPopupWindow_12) {
        super.setAlpha(COUIBaseListPopupWindow_12);
    }

    public void setChangIcon(float COUIBaseListPopupWindow_12) {
        this.f22610d = COUIBaseListPopupWindow_12;
        invalidate();
    }

    public void setLock(boolean z) {
        this.f22611e = z;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (1.0f < this.f22610d) {
            this.f22610d = 1.0f;
        }
        this.f22609c.setAlpha((int) (this.f22610d * 255.0f));
        canvas.drawBitmap(this.f22607a, (getWidth() - this.f22607a.getWidth()) / 2, (getHeight() - this.f22607a.getHeight()) / 2, this.f22609c);
        this.f22609c.setAlpha((int) ((1.0f - this.f22610d) * 255.0f));
        canvas.drawBitmap(this.f22608b, (getWidth() - this.f22608b.getWidth()) / 2, (getHeight() - this.f22608b.getHeight()) / 2, this.f22609c);
    }
}
