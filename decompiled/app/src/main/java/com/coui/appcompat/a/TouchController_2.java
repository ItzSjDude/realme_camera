package com.coui.appcompat.a_renamed;

/* compiled from: COUIPanelMultiWindowUtils.java */
/* loaded from: classes.dex */
public class m_renamed {
    public static int a_renamed(android.content.Context context, android.content.res.Configuration configuration) throws android.content.res.Resources.NotFoundException {
        int iB;
        android.app.Activity activityA = a_renamed(context);
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        if (activityA != null) {
            iB = a_renamed(activityA, configuration);
        } else {
            iB = b_renamed(context, configuration);
        }
        return iB - c_renamed(context, configuration);
    }

    public static int a_renamed(android.app.Activity activity, android.content.res.Configuration configuration) {
        android.graphics.Rect rectA;
        int i_renamed = (!b_renamed(activity) || (rectA = a_renamed(activity)) == null) ? 0 : rectA.bottom - rectA.top;
        return i_renamed == 0 ? b_renamed(activity, configuration) : i_renamed;
    }

    public static int b_renamed(android.content.Context context, android.content.res.Configuration configuration) throws android.content.res.Resources.NotFoundException {
        int iC = 0;
        if (context == null) {
            return 0;
        }
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int iB = b_renamed(context);
        int iD = d_renamed(context);
        if (com.coui.appcompat.a_renamed.k_renamed.b_renamed(context)) {
            if ((((float) configuration.smallestScreenWidthDp) >= 480.0f) || a_renamed(configuration)) {
                iC = com.coui.appcompat.a_renamed.k_renamed.c_renamed(context);
            }
        }
        return (iB - iD) - iC;
    }

    public static android.graphics.Rect a_renamed(android.app.Activity activity) {
        if (activity == null) {
            return null;
        }
        android.view.View decorView = activity.getWindow().getDecorView();
        android.graphics.Rect rect = new android.graphics.Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    public static boolean b_renamed(android.app.Activity activity) {
        return android.os.Build.VERSION.SDK_INT >= 24 && activity != null && activity.isInMultiWindowMode();
    }

    public static android.app.Activity a_renamed(android.content.Context context) {
        while (context instanceof android.content.ContextWrapper) {
            if (context instanceof android.app.Activity) {
                return (android.app.Activity) context;
            }
            context = ((android.content.ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static int b_renamed(android.content.Context context) {
        return c_renamed(context).y_renamed;
    }

    public static android.graphics.Point c_renamed(android.content.Context context) {
        android.view.WindowManager windowManager;
        android.view.Display defaultDisplay;
        android.graphics.Point point = new android.graphics.Point();
        if (context != null && (windowManager = (android.view.WindowManager) context.getSystemService("window")) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getRealSize(point);
        }
        return point;
    }

    public static int d_renamed(android.content.Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean e_renamed(android.content.Context context) {
        return a_renamed(context.getResources().getConfiguration());
    }

    public static boolean a_renamed(android.content.res.Configuration configuration) {
        return configuration.orientation == 1;
    }

    public static int c_renamed(android.content.Context context, android.content.res.Configuration configuration) {
        if (context == null || configuration == null) {
            return 0;
        }
        int i_renamed = configuration.smallestScreenWidthDp;
        boolean z_renamed = (configuration.screenLayout & 15) == 1;
        boolean z2 = configuration.orientation == 2;
        if (i_renamed >= 480.0f || (!z_renamed && z2)) {
            return context.createConfigurationContext(configuration).getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_bottom_sheet_margin_bottom_if_need);
        }
        return 0;
    }
}
