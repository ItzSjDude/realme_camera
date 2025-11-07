package com.coui.appcompat.p099a;

import android.content.Context;
import android.os.Build;
import android.view.View;

/* compiled from: COUIDarkModeUtil.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class COUIDarkModeUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m6401a(Context context) {
        return 32 == (context.getResources().getConfiguration().uiMode & 48);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m6400a(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            view.setForceDarkAllowed(z);
        }
    }
}
