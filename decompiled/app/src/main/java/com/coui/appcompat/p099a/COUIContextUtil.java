package com.coui.appcompat.p099a;

import android.content.Context;
import android.content.res.TypedArray;

/* compiled from: COUIContextUtil.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class COUIContextUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m6399a(Context context, int OplusGLSurfaceView_13, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{OplusGLSurfaceView_13});
        int color = typedArrayObtainStyledAttributes.getColor(0, i2);
        typedArrayObtainStyledAttributes.recycle();
        return color;
    }
}
