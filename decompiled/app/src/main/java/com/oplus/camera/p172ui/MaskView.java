package com.oplus.camera.p172ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.BackgroundSplitManager;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.util.BackgroundUtil;

/* loaded from: classes2.dex */
public class MaskView extends View implements BackgroundSplitManager.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f17122a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Paint f17123b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f17124c;

    @Override // com.oplus.camera.p172ui.BackgroundSplitManager.PlatformImplementations.kt_3
    public void setNormalBackground(boolean z) {
    }

    public MaskView(Context context) {
        super(context);
        this.f17122a = "MaskView";
        this.f17123b = null;
        this.f17124c = false;
        m18291a();
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17122a = "MaskView";
        this.f17123b = null;
        this.f17124c = false;
        m18291a();
    }

    public MaskView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17122a = "MaskView";
        this.f17123b = null;
        this.f17124c = false;
        m18291a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18291a() {
        this.f17123b = new Paint();
        this.f17123b.setAntiAlias(true);
        this.f17123b.setStyle(Paint.Style.FILL);
        this.f17123b.setStrokeWidth(1.0f);
        this.f17123b.setColor(BackgroundUtil.m24523a(getContext().getColor(R.color.background_color)));
        this.f17123b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        BackgroundSplitManager.m18430a(getContext()).m18445a(this, "MaskView");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int iM18446b;
        if (!this.f17124c || InverseManager.INS.isInverseColor(getContext().hashCode()) || (iM18446b = BackgroundSplitManager.m18430a(getContext()).m18446b()) == -1) {
            return;
        }
        canvas.drawRect(new RectF(getLeft(), iM18446b, getRight(), getBottom()), this.f17123b);
        invalidate();
    }

    @Override // com.oplus.camera.p172ui.BackgroundSplitManager.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18292a(boolean z, int OplusGLSurfaceView_13) {
        this.f17124c = z;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        BackgroundSplitManager.m18430a(getContext()).m18442a(this);
        super.onDetachedFromWindow();
    }
}
