package com.coui.appcompat.widget.seekbar;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: COUISeekBarHelper.java */
/* renamed from: com.coui.appcompat.widget.seekbar.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class COUISeekBarHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    static final int f8746a = Color.argb(12, 0, 0, 0);

    /* renamed from: IntrinsicsJvm.kt_4 */
    static final int f8747b = Color.parseColor("#4D4D4D");

    /* renamed from: IntrinsicsJvm.kt_3 */
    static final int f8748c = Color.argb(76, 255, 255, 255);

    /* renamed from: PlatformImplementations.kt_3 */
    static int m8181a(View view, ColorStateList colorStateList, int OplusGLSurfaceView_13) {
        return colorStateList == null ? OplusGLSurfaceView_13 : colorStateList.getColorForState(view.getDrawableState(), OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int m8180a(View view, ColorStateList colorStateList) {
        return m8181a(view, colorStateList, f8746a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static boolean m8182a(MotionEvent motionEvent, View view) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return x >= ((float) view.getPaddingLeft()) && x <= ((float) (view.getWidth() - view.getPaddingRight())) && y >= 0.0f && y <= ((float) view.getHeight());
    }
}
