package com.oplus.compat.content;

/* compiled from: ContextNative.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static java.lang.String f7452a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public static int f7453b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public static int f7454c;

    private static java.lang.Object a_renamed() {
        return null;
    }

    private static java.lang.Object b_renamed(android.content.Context context) {
        return null;
    }

    static {
        try {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
                f7452a = "statusbar";
                f7453b = 33554432;
                f7454c = 67108864;
            } else if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
                f7452a = (java.lang.String) a_renamed();
                f7453b = 33554432;
                f7454c = 67108864;
            } else {
                if (com.oplus.compat.b_renamed.a_renamed.c_renamed.h_renamed()) {
                    f7452a = "statusbar";
                    return;
                }
                throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.e_renamed("ContextNative", th.toString());
        }
    }

    public static void a_renamed(android.content.Intent intent) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName("android.content.Context").setActionName("startActivity").withParcelable("intent", intent).build()).execute();
            if (responseExecute.isSuccessful()) {
                return;
            }
            android.util.Log.e_renamed("ContextNative", responseExecute.getMessage());
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public static android.view.Display a_renamed(android.content.Context context) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return context.getDisplay();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.inner.content.ContextWrapper.getDisplay(context);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (android.view.Display) b_renamed(context);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.i_renamed()) {
            return context.getDisplay();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }
}
