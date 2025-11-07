package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class OplusSystemPropertiesNative {
    private static final java.lang.String COMPONENT_NAME = "android.os.OplusSystemProperties";
    private static final java.lang.String RESULT = "result";

    public static java.lang.String get(java.lang.String str) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        return get(str, "");
    }

    public static java.lang.String get(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("get").withString("key", str).withString("def", str2).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getString(RESULT);
            }
            responseExecute.checkThrowable(java.lang.IllegalArgumentException.class);
            return str2;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return android.os.SystemProperties.get(str, str2);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before Q_renamed");
    }

    public static int getInt(java.lang.String str, int i_renamed) throws java.lang.Throwable {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getInt").withString("key", str).withInt("def", i_renamed).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getInt(RESULT);
            }
            responseExecute.checkThrowable(java.lang.IllegalArgumentException.class);
            return i_renamed;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return android.os.SystemProperties.getInt(str, i_renamed);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before Q_renamed");
    }

    public static long getLong(java.lang.String str, long j_renamed) throws java.lang.Throwable {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getLong").withString("key", str).withLong("def", j_renamed).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getLong(RESULT);
            }
            responseExecute.checkThrowable(java.lang.IllegalArgumentException.class);
            return j_renamed;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return android.os.SystemProperties.getLong(str, j_renamed);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before Q_renamed");
    }

    public static boolean getBoolean(java.lang.String str, java.lang.Boolean bool) throws java.lang.Throwable {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getBoolean").withString("key", str).withBoolean("def", bool.booleanValue()).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean(RESULT);
            }
            responseExecute.checkThrowable(java.lang.IllegalArgumentException.class);
            return bool.booleanValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return android.os.SystemProperties.getBoolean(str, bool.booleanValue());
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before Q_renamed");
    }

    public static void notifyInitCotaDownloaded() throws java.lang.Throwable {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("notifyInitCotaDownloaded").build()).execute();
            if (responseExecute.isSuccessful()) {
                return;
            }
            responseExecute.checkThrowable(java.lang.IllegalArgumentException.class);
            return;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before R_renamed");
    }
}
