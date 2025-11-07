package com.oplus.camera.ui;

/* loaded from: classes2.dex */
public class RotableTextView extends android.widget.TextView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f5783a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f5784b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f5785c;
    private int d_renamed;
    private int e_renamed;
    private boolean f_renamed;
    private boolean g_renamed;
    private long h_renamed;
    private long i_renamed;

    public RotableTextView(android.content.Context context) {
        super(context);
        this.f5783a = 0;
        this.f5784b = 0;
        this.f5785c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = false;
        this.g_renamed = true;
        this.h_renamed = 0L;
        this.i_renamed = 0L;
    }

    public RotableTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5783a = 0;
        this.f5784b = 0;
        this.f5785c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = false;
        this.g_renamed = true;
        this.h_renamed = 0L;
        this.i_renamed = 0L;
    }

    public RotableTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f5783a = 0;
        this.f5784b = 0;
        this.f5785c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = false;
        this.g_renamed = true;
        this.h_renamed = 0L;
        this.i_renamed = 0L;
    }

    public RotableTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.f5783a = 0;
        this.f5784b = 0;
        this.f5785c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = false;
        this.g_renamed = true;
        this.h_renamed = 0L;
        this.i_renamed = 0L;
    }

    public void setBottomMargin(int i_renamed) {
        this.e_renamed = i_renamed;
        this.d_renamed = ((android.widget.RelativeLayout.LayoutParams) getLayoutParams()).bottomMargin;
    }

    public void a_renamed(int i_renamed, boolean z_renamed) {
        int i2;
        if (isShown()) {
            this.g_renamed = z_renamed;
        } else {
            this.g_renamed = false;
        }
        if (i_renamed >= 0) {
            i2 = i_renamed % 360;
        } else {
            i2 = (i_renamed % 360) + 360;
        }
        if (i2 == this.f5785c) {
            return;
        }
        this.f5785c = i2;
        if (this.g_renamed) {
            this.f5784b = this.f5783a;
            this.h_renamed = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f5785c - this.f5783a;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.f_renamed = i3 >= 0;
            this.i_renamed = this.h_renamed + ((java.lang.Math.abs(i3) * 1000) / 270);
        } else {
            this.f5783a = this.f5785c;
        }
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x0063  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r6) {
        /*
            r5 = this;
            super.onDraw(r6)
            int r6 = r5.f5783a
            int r0 = r5.f5785c
            if (r6 == r0) goto L9e
            long r0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
            long r2 = r5.i_renamed
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L89
            long r2 = r5.h_renamed
            long r0 = r0 - r2
            int r6 = (int) r0
            int r0 = r5.f5784b
            boolean r1 = r5.f_renamed
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
            r5.f5783a = r0
            int r6 = r5.e_renamed
            if (r6 <= 0) goto L85
            android.view.ViewGroup$LayoutParams r6 = r5.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r6 = (android.widget.RelativeLayout.LayoutParams) r6
            boolean r1 = r5.f_renamed
            if (r1 == 0) goto L63
            int r1 = r5.f5785c
            int r2 = r5.f5784b
            if (r1 >= r2) goto L63
            int r1 = r5.d_renamed
            int r3 = r5.e_renamed
            int r3 = r1 - r3
            float r3 = (float) r3
            int r0 = r0 - r2
            int r0 = java.lang.Math.abs(r0)
            float r0 = (float) r0
            int r2 = r5.f5785c
            int r2 = r2 + 360
            int r4 = r5.f5784b
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
            int r1 = r5.d_renamed
            int r2 = r5.e_renamed
            int r2 = r1 - r2
            float r2 = (float) r2
            int r3 = r5.f5784b
            int r0 = r0 - r3
            int r0 = java.lang.Math.abs(r0)
            float r0 = (float) r0
            int r3 = r5.f5785c
            int r4 = r5.f5784b
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
            int r6 = r5.f5785c
            r5.f5783a = r6
            int r6 = r5.e_renamed
            if (r6 <= 0) goto L9e
            android.view.ViewGroup$LayoutParams r6 = r5.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r6 = (android.widget.RelativeLayout.LayoutParams) r6
            int r0 = r5.e_renamed
            r6.bottomMargin = r0
            r5.setLayoutParams(r6)
        L9e:
            int r6 = r5.f5783a
            int r6 = -r6
            float r6 = (float) r6
            r5.setRotation(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.RotableTextView.onDraw(android.graphics.Canvas):void");
    }
}
