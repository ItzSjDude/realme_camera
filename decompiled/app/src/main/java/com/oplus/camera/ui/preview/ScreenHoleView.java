package com.oplus.camera.ui.preview;

/* loaded from: classes2.dex */
public class ScreenHoleView extends android.view.View {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6815a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6816b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6817c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private android.graphics.Paint g_renamed;
    private android.graphics.Rect h_renamed;

    public ScreenHoleView(android.content.Context context) {
        this(context, null);
    }

    public ScreenHoleView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScreenHoleView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6815a = 0;
        this.f6816b = 0;
        this.f6817c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = null;
        this.h_renamed = null;
        a_renamed();
    }

    private void a_renamed() {
        this.g_renamed = new android.graphics.Paint(1);
        this.g_renamed.setColor(-16777216);
        this.g_renamed.setStyle(android.graphics.Paint.Style.FILL);
    }

    public void setHolePosition(android.graphics.Rect rect) {
        com.oplus.camera.e_renamed.b_renamed("ScreenHoleView", "setHolePosition, rect: " + rect);
        this.h_renamed = rect;
        b_renamed();
    }

    private void b_renamed() {
        android.graphics.Rect rect = this.h_renamed;
        if (rect == null || rect.isEmpty()) {
            return;
        }
        int screenHoleExpandSize = getScreenHoleExpandSize();
        this.f6815a = this.h_renamed.left - screenHoleExpandSize;
        this.f6816b = this.h_renamed.right + screenHoleExpandSize;
        this.f6817c = this.h_renamed.top - screenHoleExpandSize;
        this.d_renamed = this.h_renamed.bottom + screenHoleExpandSize;
        if (this.f6815a < 0) {
            this.f6815a = 0;
        }
        if (this.f6817c < 0) {
            this.f6817c = 0;
        }
        this.e_renamed = (this.d_renamed - this.f6817c) / 2;
        int i_renamed = this.h_renamed.right - this.h_renamed.left;
        int i2 = this.h_renamed.bottom - this.h_renamed.top;
        if (i_renamed == i2) {
            this.f_renamed = 1;
        } else if (i_renamed > i2) {
            this.f_renamed = 2;
        } else {
            this.f_renamed = 0;
        }
    }

    private int getScreenHoleExpandSize() {
        try {
            return com.oplus.compat.os.SystemPropertiesNative.getInt("screen_hole_expand_size", 15);
        } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e_renamed) {
            e_renamed.printStackTrace();
            return 15;
        }
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int i_renamed = this.f_renamed;
        if (i_renamed == 1) {
            a_renamed(canvas);
        } else {
            if (i_renamed != 2) {
                return;
            }
            b_renamed(canvas);
        }
    }

    private void a_renamed(android.graphics.Canvas canvas) {
        int i_renamed = this.e_renamed;
        if (i_renamed <= 0) {
            return;
        }
        canvas.drawCircle(this.f6815a + i_renamed, this.f6817c + i_renamed, i_renamed, this.g_renamed);
    }

    private void b_renamed(android.graphics.Canvas canvas) {
        if (this.e_renamed <= 0) {
            return;
        }
        canvas.drawArc(this.f6815a, this.f6817c, (r0 * 2) + r1, this.d_renamed, 90.0f, 180.0f, false, this.g_renamed);
        int i_renamed = this.f6815a;
        int i2 = this.e_renamed;
        canvas.drawRect(i_renamed + i2, this.f6817c, this.f6816b - i2, this.d_renamed, this.g_renamed);
        canvas.drawArc(r0 - (this.e_renamed * 2), this.f6817c, this.f6816b, this.d_renamed, 90.0f, -180.0f, false, this.g_renamed);
    }
}
