package com.oplus.camera.sticker.p168ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.oplus.camera.R;

/* compiled from: StickerCategoryContainer.java */
/* renamed from: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class StickerCategoryContainer extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f16366a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Paint f16367b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f16368c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f16369d;

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public StickerCategoryContainer(Context context) {
        super(context);
        this.f16366a = false;
        this.f16367b = null;
        this.f16368c = 0;
        this.f16369d = 0;
        this.f16367b = new Paint();
        this.f16367b.setStrokeWidth(1.0f);
        this.f16367b.setColor(getContext().getColor(R.color.camera_white));
        this.f16367b.setAlpha(51);
        this.f16367b.setAntiAlias(true);
        this.f16368c = context.getResources().getDimensionPixelSize(R.dimen.sticker_music_divider_margin_right);
        this.f16369d = context.getResources().getDimensionPixelSize(R.dimen.sticker_music_divider_margin_top);
        setLayerType(1, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17077a(boolean z) {
        this.f16366a = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.drawLine(0.0f, getHeight(), getWidth(), getHeight(), this.f16367b);
        if (this.f16366a) {
            canvas.drawLine(getWidth() - this.f16368c, this.f16369d, getWidth() - this.f16368c, getHeight() - this.f16369d, this.f16367b);
        }
        canvas.restore();
    }
}
