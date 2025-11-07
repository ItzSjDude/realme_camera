package com.coui.appcompat.p099a;

import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;

/* compiled from: COUITintUtil.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.w */
/* loaded from: classes.dex */
public class COUITintUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static Drawable m6499a(Drawable drawable, int OplusGLSurfaceView_13) {
        Drawable drawableM2581g = DrawableCompat.m2581g(drawable);
        DrawableCompat.m2568a(drawableM2581g.mutate(), OplusGLSurfaceView_13);
        return drawableM2581g;
    }
}
