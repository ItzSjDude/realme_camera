package com.oplus.camera.p172ui.preview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.ImageView;
import com.oplus.camera.util.Util;

/* compiled from: BlurCoverBg.java */
/* renamed from: com.oplus.camera.ui.preview.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class BlurCoverBg extends ImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f21914a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f21915b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f21916c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Paint f21917d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Rect f21918e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Rect f21919f;

    public BlurCoverBg(Context context) {
        super(context);
        this.f21914a = 0;
        this.f21915b = 0;
        this.f21916c = 0;
        this.f21917d = null;
        this.f21918e = null;
        this.f21919f = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f21917d == null) {
            this.f21917d = new Paint();
        }
        this.f21917d.setColor(this.f21916c);
        Rect rect = this.f21918e;
        if (rect == null) {
            this.f21918e = new Rect(0, 0, getWidth(), this.f21914a);
        } else {
            rect.set(0, 0, getWidth(), this.f21914a);
        }
        Rect rect2 = this.f21919f;
        if (rect2 == null) {
            this.f21919f = new Rect(0, this.f21915b, getWidth(), getHeight());
        } else {
            rect2.set(0, this.f21915b, getWidth(), getHeight());
        }
        canvas.drawRect(this.f21918e, this.f21917d);
        canvas.drawRect(this.f21919f, this.f21917d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23180a(int OplusGLSurfaceView_13, int i2) {
        this.f21914a = Util.m24186N() + OplusGLSurfaceView_13;
        this.f21915b = this.f21914a + i2;
    }

    public void setDrawColor(int OplusGLSurfaceView_13) {
        this.f21916c = OplusGLSurfaceView_13;
    }
}
