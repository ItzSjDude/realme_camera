package com.coui.appcompat.a_renamed;

/* compiled from: COUIOrientationUtil.java */
/* loaded from: classes.dex */
public class l_renamed {
    public static int a_renamed(android.content.Context context) {
        android.graphics.Point pointB = b_renamed(context);
        return (pointB.x_renamed <= pointB.y_renamed || c_renamed(context)) ? 1 : 2;
    }

    public static android.graphics.Point b_renamed(android.content.Context context) {
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        android.graphics.Point point = new android.graphics.Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point;
    }

    public static boolean c_renamed(android.content.Context context) {
        if (!(context instanceof android.app.Activity) || android.os.Build.VERSION.SDK_INT < 24) {
            return false;
        }
        return ((android.app.Activity) context).isInMultiWindowMode();
    }
}
