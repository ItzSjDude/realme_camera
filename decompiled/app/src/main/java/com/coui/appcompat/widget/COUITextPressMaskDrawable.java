package com.coui.appcompat.widget;

import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

/* compiled from: COUITextPressMaskDrawable.java */
/* renamed from: com.coui.appcompat.widget.q */
/* loaded from: classes.dex */
public class COUITextPressMaskDrawable extends ShapeDrawable {
    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        float fMin = Math.min(rect.right - rect.left, rect.bottom - rect.top) / 2.0f;
        setShape(new RoundRectShape(new float[]{fMin, fMin, fMin, fMin, fMin, fMin, fMin, fMin}, null, null));
    }
}
