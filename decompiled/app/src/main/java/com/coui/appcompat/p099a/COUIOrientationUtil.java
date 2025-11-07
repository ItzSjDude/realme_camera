package com.coui.appcompat.p099a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;

/* compiled from: COUIOrientationUtil.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public class COUIOrientationUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m6434a(Context context) {
        Point pointM6435b = m6435b(context);
        return (pointM6435b.x <= pointM6435b.y || m6436c(context)) ? 1 : 2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Point m6435b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m6436c(Context context) {
        if (!(context instanceof Activity) || Build.VERSION.SDK_INT < 24) {
            return false;
        }
        return ((Activity) context).isInMultiWindowMode();
    }
}
