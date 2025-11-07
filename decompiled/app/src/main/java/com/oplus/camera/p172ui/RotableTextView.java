package com.oplus.camera.p172ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: classes2.dex */
public class RotableTextView extends TextView {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f17216a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f17217b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f17218c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f17219d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f17220e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f17221f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f17222g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private long f17223h;

    /* renamed from: OplusGLSurfaceView_13 */
    private long f17224i;

    public RotableTextView(Context context) {
        super(context);
        this.f17216a = 0;
        this.f17217b = 0;
        this.f17218c = 0;
        this.f17219d = 0;
        this.f17220e = 0;
        this.f17221f = false;
        this.f17222g = true;
        this.f17223h = 0L;
        this.f17224i = 0L;
    }

    public RotableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17216a = 0;
        this.f17217b = 0;
        this.f17218c = 0;
        this.f17219d = 0;
        this.f17220e = 0;
        this.f17221f = false;
        this.f17222g = true;
        this.f17223h = 0L;
        this.f17224i = 0L;
    }

    public RotableTextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17216a = 0;
        this.f17217b = 0;
        this.f17218c = 0;
        this.f17219d = 0;
        this.f17220e = 0;
        this.f17221f = false;
        this.f17222g = true;
        this.f17223h = 0L;
        this.f17224i = 0L;
    }

    public RotableTextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f17216a = 0;
        this.f17217b = 0;
        this.f17218c = 0;
        this.f17219d = 0;
        this.f17220e = 0;
        this.f17221f = false;
        this.f17222g = true;
        this.f17223h = 0L;
        this.f17224i = 0L;
    }

    public void setBottomMargin(int OplusGLSurfaceView_13) {
        this.f17220e = OplusGLSurfaceView_13;
        this.f17219d = ((RelativeLayout.LayoutParams) getLayoutParams()).bottomMargin;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18344a(int OplusGLSurfaceView_13, boolean z) {
        int i2;
        if (isShown()) {
            this.f17222g = z;
        } else {
            this.f17222g = false;
        }
        if (OplusGLSurfaceView_13 >= 0) {
            i2 = OplusGLSurfaceView_13 % 360;
        } else {
            i2 = (OplusGLSurfaceView_13 % 360) + 360;
        }
        if (i2 == this.f17218c) {
            return;
        }
        this.f17218c = i2;
        if (this.f17222g) {
            this.f17217b = this.f17216a;
            this.f17223h = AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f17218c - this.f17216a;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.f17221f = i3 >= 0;
            this.f17224i = this.f17223h + ((Math.abs(i3) * 1000) / 270);
        } else {
            this.f17216a = this.f17218c;
        }
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r6) {
        /*
            r5 = this;
            super.onDraw(r6)
            int r6 = r5.f17216a
            int r0 = r5.f17218c
            if (r6 == r0) goto L9e
            long r0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
            long r2 = r5.f17224i
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L89
            long r2 = r5.f17223h
            long r0 = r0 - r2
            int r6 = (int) r0
            int r0 = r5.f17217b
            boolean r1 = r5.f17221f
            if (r1 == 0) goto L1e
            goto L1f
        L1e:
            int r6 = -r6
        L1f:
            int r6 = r6 * 270
            int r6 = r6 / 1000
            int r0 = r0 + r6
            if (r0 < 0) goto L29
            int r0 = r0 % 360
            goto L2d
        L29:
            int r0 = r0 % 360
            int r0 = r0 + 360
        L2d:
            r5.f17216a = r0
            int r6 = r5.f17220e
            if (r6 <= 0) goto L85
            android.view.ViewGroup$LayoutParams r6 = r5.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r6 = (android.widget.RelativeLayout.LayoutParams) r6
            boolean r1 = r5.f17221f
            if (r1 == 0) goto L63
            int r1 = r5.f17218c
            int r2 = r5.f17217b
            if (r1 >= r2) goto L63
            int r1 = r5.f17219d
            int r3 = r5.f17220e
            int r3 = r1 - r3
            float r3 = (float) r3
            int r0 = r0 - r2
            int r0 = java.lang.Math.abs(r0)
            float r0 = (float) r0
            int r2 = r5.f17218c
            int r2 = r2 + 360
            int r4 = r5.f17217b
            int r2 = r2 - r4
            int r2 = java.lang.Math.abs(r2)
            float r2 = (float) r2
            float r0 = r0 / r2
            float r3 = r3 * r0
            int r0 = (int) r3
            int r1 = r1 - r0
            r6.bottomMargin = r1
            goto L82
        L63:
            int r1 = r5.f17219d
            int r2 = r5.f17220e
            int r2 = r1 - r2
            float r2 = (float) r2
            int r3 = r5.f17217b
            int r0 = r0 - r3
            int r0 = java.lang.Math.abs(r0)
            float r0 = (float) r0
            int r3 = r5.f17218c
            int r4 = r5.f17217b
            int r3 = r3 - r4
            int r3 = java.lang.Math.abs(r3)
            float r3 = (float) r3
            float r0 = r0 / r3
            float r2 = r2 * r0
            int r0 = (int) r2
            int r1 = r1 - r0
            r6.bottomMargin = r1
        L82:
            r5.setLayoutParams(r6)
        L85:
            r5.invalidate()
            goto L9e
        L89:
            int r6 = r5.f17218c
            r5.f17216a = r6
            int r6 = r5.f17220e
            if (r6 <= 0) goto L9e
            android.view.ViewGroup$LayoutParams r6 = r5.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r6 = (android.widget.RelativeLayout.LayoutParams) r6
            int r0 = r5.f17220e
            r6.bottomMargin = r0
            r5.setLayoutParams(r6)
        L9e:
            int r6 = r5.f17216a
            int r6 = -r6
            float r6 = (float) r6
            r5.setRotation(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.RotableTextView.onDraw(android.graphics.Canvas):void");
    }
}
