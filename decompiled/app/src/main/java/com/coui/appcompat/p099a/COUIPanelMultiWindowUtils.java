package com.coui.appcompat.p099a;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import coui.support.appcompat.R;

/* compiled from: COUIPanelMultiWindowUtils.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public class COUIPanelMultiWindowUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m6438a(Context context, Configuration configuration) throws Resources.NotFoundException {
        int iM6443b;
        Activity activityM6439a = m6439a(context);
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        if (activityM6439a != null) {
            iM6443b = m6437a(activityM6439a, configuration);
        } else {
            iM6443b = m6443b(context, configuration);
        }
        return iM6443b - m6445c(context, configuration);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m6437a(Activity activity, Configuration configuration) {
        Rect rectM6440a;
        int OplusGLSurfaceView_13 = (!m6444b(activity) || (rectM6440a = m6440a(activity)) == null) ? 0 : rectM6440a.bottom - rectM6440a.top;
        return OplusGLSurfaceView_13 == 0 ? m6443b(activity, configuration) : OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m6443b(Context context, Configuration configuration) throws Resources.NotFoundException {
        int iM6433c = 0;
        if (context == null) {
            return 0;
        }
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int iM6442b = m6442b(context);
        int iM6447d = m6447d(context);
        if (COUINavigationBarUtil.m6432b(context)) {
            if ((((float) configuration.smallestScreenWidthDp) >= 480.0f) || m6441a(configuration)) {
                iM6433c = COUINavigationBarUtil.m6433c(context);
            }
        }
        return (iM6442b - iM6447d) - iM6433c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Rect m6440a(Activity activity) {
        if (activity == null) {
            return null;
        }
        View decorView = activity.getWindow().getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m6444b(Activity activity) {
        return Build.VERSION.SDK_INT >= 24 && activity != null && activity.isInMultiWindowMode();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Activity m6439a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m6442b(Context context) {
        return m6446c(context).y;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static Point m6446c(Context context) {
        WindowManager windowManager;
        Display defaultDisplay;
        Point point = new Point();
        if (context != null && (windowManager = (WindowManager) context.getSystemService("window")) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getRealSize(point);
        }
        return point;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static int m6447d(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static boolean m6448e(Context context) {
        return m6441a(context.getResources().getConfiguration());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m6441a(Configuration configuration) {
        return configuration.orientation == 1;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m6445c(Context context, Configuration configuration) {
        if (context == null || configuration == null) {
            return 0;
        }
        int OplusGLSurfaceView_13 = configuration.smallestScreenWidthDp;
        boolean z = (configuration.screenLayout & 15) == 1;
        boolean z2 = configuration.orientation == 2;
        if (OplusGLSurfaceView_13 >= 480.0f || (!z && z2)) {
            return context.createConfigurationContext(configuration).getResources().getDimensionPixelOffset(R.dimen.coui_bottom_sheet_margin_bottom_if_need);
        }
        return 0;
    }
}
