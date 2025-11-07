package com.coui.appcompat.a_renamed;

/* compiled from: COUIDarkModeUtil.java */
/* loaded from: classes.dex */
public class e_renamed {
    public static boolean a_renamed(android.content.Context context) {
        return 32 == (context.getResources().getConfiguration().uiMode & 48);
    }

    public static void a_renamed(android.view.View view, boolean z_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            view.setForceDarkAllowed(z_renamed);
        }
    }
}
