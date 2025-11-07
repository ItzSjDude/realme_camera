package com.coui.appcompat.a_renamed;

/* compiled from: COUIContextUtil.java */
/* loaded from: classes.dex */
public class d_renamed {
    public static int a_renamed(android.content.Context context, int i_renamed, int i2) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i_renamed});
        int color = typedArrayObtainStyledAttributes.getColor(0, i2);
        typedArrayObtainStyledAttributes.recycle();
        return color;
    }
}
