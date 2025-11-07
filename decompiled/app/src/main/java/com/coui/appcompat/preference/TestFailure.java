package com.coui.appcompat.preference;

/* compiled from: COUIRecommendedDrawable.java */
/* loaded from: classes.dex */
public class f_renamed extends com.google.android.material.shape.MaterialShapeDrawable {

    /* renamed from: a_renamed, reason: collision with root package name */
    private float f2675a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f2676b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.Paint f2677c = new android.graphics.Paint(1);
    private android.graphics.Path d_renamed = new android.graphics.Path();

    public f_renamed(float f_renamed, int i_renamed) {
        this.f2675a = f_renamed;
        this.f2676b = i_renamed;
        this.f2677c.setColor(this.f2676b);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        this.d_renamed.reset();
        this.d_renamed = com.coui.appcompat.a_renamed.o_renamed.a_renamed().a_renamed(getBounds(), this.f2675a);
        canvas.drawPath(this.d_renamed, this.f2677c);
    }
}
