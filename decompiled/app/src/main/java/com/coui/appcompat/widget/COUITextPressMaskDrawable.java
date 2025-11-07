package com.coui.appcompat.widget;

/* compiled from: COUITextPressMaskDrawable.java */
/* loaded from: classes.dex */
public class q_renamed extends android.graphics.drawable.ShapeDrawable {
    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        float fMin = java.lang.Math.min(rect.right - rect.left, rect.bottom - rect.top) / 2.0f;
        setShape(new android.graphics.drawable.shapes.RoundRectShape(new float[]{fMin, fMin, fMin, fMin, fMin, fMin, fMin, fMin}, null, null));
    }
}
