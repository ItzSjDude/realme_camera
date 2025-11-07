package com.coui.appcompat.widget.seekbar;

/* compiled from: COUISeekBarHelper.java */
/* loaded from: classes.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final int f3101a = android.graphics.Color.argb(12, 0, 0, 0);

    /* renamed from: b_renamed, reason: collision with root package name */
    static final int f3102b = android.graphics.Color.parseColor("#4D4D4D");

    /* renamed from: c_renamed, reason: collision with root package name */
    static final int f3103c = android.graphics.Color.argb(76, 255, 255, 255);

    static int a_renamed(android.view.View view, android.content.res.ColorStateList colorStateList, int i_renamed) {
        return colorStateList == null ? i_renamed : colorStateList.getColorForState(view.getDrawableState(), i_renamed);
    }

    static int a_renamed(android.view.View view, android.content.res.ColorStateList colorStateList) {
        return a_renamed(view, colorStateList, f3101a);
    }

    static boolean a_renamed(android.view.MotionEvent motionEvent, android.view.View view) {
        float x_renamed = motionEvent.getX();
        float y_renamed = motionEvent.getY();
        return x_renamed >= ((float) view.getPaddingLeft()) && x_renamed <= ((float) (view.getWidth() - view.getPaddingRight())) && y_renamed >= 0.0f && y_renamed <= ((float) view.getHeight());
    }
}
