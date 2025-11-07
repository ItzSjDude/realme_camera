package com.coui.appcompat.widget;

/* compiled from: COUIRedDotDrawable.java */
/* loaded from: classes.dex */
public class m_renamed extends android.graphics.drawable.Drawable {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f2991a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f2992b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.coui.appcompat.a_renamed.g_renamed f2993c;
    private android.graphics.RectF d_renamed;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i_renamed) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
    }

    public m_renamed(int i_renamed, int i2, android.content.Context context, android.graphics.RectF rectF) {
        this.f2991a = i_renamed;
        this.f2992b = i2;
        this.d_renamed = rectF;
        this.f2993c = new com.coui.appcompat.a_renamed.g_renamed(context, null, coui.support.appcompat.R_renamed.styleable.COUIHintRedDot, 0, coui.support.appcompat.R_renamed.style.Widget_COUI_COUIHintRedDot_Small);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        this.f2993c.a_renamed(canvas, this.f2991a, this.f2992b, this.d_renamed);
    }
}
