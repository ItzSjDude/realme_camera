package com.oplus.camera.p172ui.preview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.oplus.camera.CameraLog;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p187os.SystemPropertiesNative;

/* loaded from: classes2.dex */
public class ScreenHoleView extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f20884a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f20885b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f20886c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f20887d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f20888e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f20889f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Paint f20890g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Rect f20891h;

    public ScreenHoleView(Context context) {
        this(context, null);
    }

    public ScreenHoleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScreenHoleView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f20884a = 0;
        this.f20885b = 0;
        this.f20886c = 0;
        this.f20887d = 0;
        this.f20888e = 0;
        this.f20889f = 0;
        this.f20890g = null;
        this.f20891h = null;
        m22203a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22203a() {
        this.f20890g = new Paint(1);
        this.f20890g.setColor(-16777216);
        this.f20890g.setStyle(Paint.Style.FILL);
    }

    public void setHolePosition(Rect rect) {
        CameraLog.m12959b("ScreenHoleView", "setHolePosition, rect: " + rect);
        this.f20891h = rect;
        m22205b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22205b() {
        Rect rect = this.f20891h;
        if (rect == null || rect.isEmpty()) {
            return;
        }
        int screenHoleExpandSize = getScreenHoleExpandSize();
        this.f20884a = this.f20891h.left - screenHoleExpandSize;
        this.f20885b = this.f20891h.right + screenHoleExpandSize;
        this.f20886c = this.f20891h.top - screenHoleExpandSize;
        this.f20887d = this.f20891h.bottom + screenHoleExpandSize;
        if (this.f20884a < 0) {
            this.f20884a = 0;
        }
        if (this.f20886c < 0) {
            this.f20886c = 0;
        }
        this.f20888e = (this.f20887d - this.f20886c) / 2;
        int OplusGLSurfaceView_13 = this.f20891h.right - this.f20891h.left;
        int i2 = this.f20891h.bottom - this.f20891h.top;
        if (OplusGLSurfaceView_13 == i2) {
            this.f20889f = 1;
        } else if (OplusGLSurfaceView_13 > i2) {
            this.f20889f = 2;
        } else {
            this.f20889f = 0;
        }
    }

    private int getScreenHoleExpandSize() {
        try {
            return SystemPropertiesNative.getInt("screen_hole_expand_size", 15);
        } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return 15;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int OplusGLSurfaceView_13 = this.f20889f;
        if (OplusGLSurfaceView_13 == 1) {
            m22204a(canvas);
        } else {
            if (OplusGLSurfaceView_13 != 2) {
                return;
            }
            m22206b(canvas);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22204a(Canvas canvas) {
        int OplusGLSurfaceView_13 = this.f20888e;
        if (OplusGLSurfaceView_13 <= 0) {
            return;
        }
        canvas.drawCircle(this.f20884a + OplusGLSurfaceView_13, this.f20886c + OplusGLSurfaceView_13, OplusGLSurfaceView_13, this.f20890g);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22206b(Canvas canvas) {
        if (this.f20888e <= 0) {
            return;
        }
        canvas.drawArc(this.f20884a, this.f20886c, (r0 * 2) + r1, this.f20887d, 90.0f, 180.0f, false, this.f20890g);
        int OplusGLSurfaceView_13 = this.f20884a;
        int i2 = this.f20888e;
        canvas.drawRect(OplusGLSurfaceView_13 + i2, this.f20886c, this.f20885b - i2, this.f20887d, this.f20890g);
        canvas.drawArc(r0 - (this.f20888e * 2), this.f20886c, this.f20885b, this.f20887d, 90.0f, -180.0f, false, this.f20890g);
    }
}
