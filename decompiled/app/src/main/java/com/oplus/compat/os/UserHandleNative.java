package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class UserHandleNative {
    private static final java.lang.String COMPONENT_NAME = "android.os.UserHandle";
    public static android.os.UserHandle CURRENT = null;
    public static android.os.UserHandle OWNER = null;
    public static android.os.UserHandle SYSTEM = null;
    private static final java.lang.String TAG = "UserHandleNative";
    public static int USER_ALL;
    public static int USER_CURRENT;
    public static int USER_SYSTEM;

    private static java.lang.Object getCurrentQCompat() {
        return null;
    }

    private static java.lang.Object getIdentifierQCompat(android.os.UserHandle userHandle) {
        return null;
    }

    private static java.lang.Object getOwenrQCompat() {
        return null;
    }

    private static java.lang.Object getUserAllQCompat() {
        return null;
    }

    private static java.lang.Object getUserCurrentQCompat() {
        return null;
    }

    private static java.lang.Object getUserSystemQCompat() {
        return null;
    }

    private static java.lang.Object myUserIdQCompat() {
        return null;
    }

    private UserHandleNative() {
    }

    private static class ReflectInfo {
        private static com.oplus.utils.reflect.RefObject<android.os.UserHandle> OWNER;
        private static com.oplus.utils.reflect.RefObject<android.os.UserHandle> SYSTEM;
        private static com.oplus.utils.reflect.RefMethod<java.lang.Integer> getIdentifier;
        private static com.oplus.utils.reflect.RefMethod<java.lang.Integer> myUserId;

        private ReflectInfo() {
        }

        static {
            com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) com.oplus.compat.os.UserHandleNative.ReflectInfo.class, (java.lang.Class<?>) android.os.UserHandle.class);
        }
    }

    static {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            SYSTEM = (android.os.UserHandle) com.oplus.compat.os.UserHandleNative.ReflectInfo.SYSTEM.get(null);
            OWNER = (android.os.UserHandle) com.oplus.compat.os.UserHandleNative.ReflectInfo.OWNER.get(null);
            USER_CURRENT = -2;
            USER_ALL = -1;
            CURRENT = android.os.UserHandle.CURRENT;
            USER_SYSTEM = 0;
            return;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            OWNER = (android.os.UserHandle) getOwenrQCompat();
            USER_CURRENT = ((java.lang.Integer) getUserCurrentQCompat()).intValue();
            USER_ALL = ((java.lang.Integer) getUserAllQCompat()).intValue();
            CURRENT = (android.os.UserHandle) getCurrentQCompat();
            USER_SYSTEM = ((java.lang.Integer) getUserSystemQCompat()).intValue();
            return;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.f_renamed()) {
                USER_ALL = -1;
            }
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.i_renamed()) {
                USER_SYSTEM = 0;
            }
            USER_CURRENT = -2;
            CURRENT = android.os.UserHandle.CURRENT;
            OWNER = android.os.UserHandle.OWNER;
            return;
        }
        android.util.Log.e_renamed(TAG, "not supported before R_renamed");
    }

    public static int getAppId(int i_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getAppId").withInt("uid", i_renamed).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getInt("appId");
            }
            android.util.Log.e_renamed(TAG, responseExecute.getMessage());
            return 0;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before R_renamed");
    }

    public static int getUid(int i_renamed, int i2) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getUid").withInt("userId", i_renamed).withInt("appId", i2).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getInt("uid");
            }
            android.util.Log.e_renamed(TAG, responseExecute.getMessage());
            return 0;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before R_renamed");
    }

    public static int myUserId() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            return ((java.lang.Integer) com.oplus.compat.os.UserHandleNative.ReflectInfo.myUserId.call(null, new java.lang.Object[0])).intValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return ((java.lang.Integer) myUserIdQCompat()).intValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            return android.os.UserHandle.myUserId();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before L_renamed");
    }

    public static int getIdentifier(android.os.UserHandle userHandle) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            return ((java.lang.Integer) com.oplus.compat.os.UserHandleNative.ReflectInfo.getIdentifier.call(userHandle, new java.lang.Object[0])).intValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return ((java.lang.Integer) getIdentifierQCompat(userHandle)).intValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.f_renamed()) {
            return userHandle.getIdentifier();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before P_renamed");
    }

    public static int getUserId(int i_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.f_renamed()) {
            return android.os.UserHandle.getUserId(i_renamed);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public static android.os.UserHandle createUserHandle(int i_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.f_renamed()) {
            return new android.os.UserHandle(i_renamed);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }
}
