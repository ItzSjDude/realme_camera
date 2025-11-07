package com.oplus.compat.content;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Display;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.inner.content.ContextWrapper;

/* compiled from: ContextNative.java */
/* renamed from: com.oplus.compat.content.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class ContextNative {

    /* renamed from: PlatformImplementations.kt_3 */
    public static String f23263a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int f23264b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int f23265c;

    /* renamed from: PlatformImplementations.kt_3 */
    private static Object m24901a() {
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Object m24903b(Context context) {
        return null;
    }

    static {
        try {
            if (VersionUtils.m24886b()) {
                f23263a = "statusbar";
                f23264b = 33554432;
                f23265c = 67108864;
            } else if (VersionUtils.m24889e()) {
                f23263a = (String) m24901a();
                f23264b = 33554432;
                f23265c = 67108864;
            } else {
                if (VersionUtils.m24892h()) {
                    f23263a = "statusbar";
                    return;
                }
                throw new UnSupportedApiVersionException();
            }
        } catch (Throwable th) {
            Log.COUIBaseListPopupWindow_8("ContextNative", th.toString());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24902a(Intent intent) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName("android.content.Context").setActionName("startActivity").withParcelable("intent", intent).build()).execute();
            if (responseExecute.isSuccessful()) {
                return;
            }
            Log.COUIBaseListPopupWindow_8("ContextNative", responseExecute.getMessage());
            return;
        }
        throw new UnSupportedApiVersionException();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Display m24900a(Context context) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return context.getDisplay();
        }
        if (VersionUtils.m24886b()) {
            return ContextWrapper.getDisplay(context);
        }
        if (VersionUtils.m24889e()) {
            return (Display) m24903b(context);
        }
        if (VersionUtils.m24893i()) {
            return context.getDisplay();
        }
        throw new UnSupportedApiVersionException();
    }
}
