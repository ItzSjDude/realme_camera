package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class UserManagerNative {
    private static final java.lang.String COMPONENT_NAME = "android.os.UserManager";
    private static final java.lang.String RESULT = "result";

    private static java.lang.Object canShowMultiUserEntryCompat(android.content.Context context, int i_renamed) {
        return null;
    }

    private static java.lang.Object createUserForQCompat(android.os.UserManager userManager, java.lang.String str, int i_renamed) {
        return null;
    }

    private static java.lang.Object getUserInfoQCompat(android.os.UserManager userManager, int i_renamed) {
        return null;
    }

    private static java.lang.Object getUsersQCompat(android.content.Context context) {
        return null;
    }

    private UserManagerNative() {
    }

    public static boolean isGuestUser(android.content.Context context) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("isGuestUser").build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean(RESULT);
            }
            return false;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before R_renamed");
    }

    public static com.oplus.compat.content.pm.c_renamed createUser(android.content.Context context, java.lang.String str, int i_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("createUserWithThrow").withString("name", str).withInt(com.android.providers.downloads.Downloads.Impl.COLUMN_FLAGS, i_renamed).build()).execute();
            if (responseExecute.isSuccessful()) {
                return new com.oplus.compat.content.pm.c_renamed(responseExecute.getBundle().getParcelable(RESULT));
            }
            return null;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            java.lang.Object objCreateUserForQCompat = createUserForQCompat((android.os.UserManager) context.getSystemService("user"), str, i_renamed);
            if (objCreateUserForQCompat != null) {
                return new com.oplus.compat.content.pm.c_renamed(objCreateUserForQCompat);
            }
            return null;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before Q_renamed");
    }

    public static com.oplus.compat.content.pm.c_renamed getUserInfo(android.content.Context context, int i_renamed, int i2) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getUserInfo").withInt("userId", i_renamed).build()).execute();
            if (responseExecute.isSuccessful()) {
                return new com.oplus.compat.content.pm.c_renamed(responseExecute.getBundle().getParcelable(RESULT));
            }
            return null;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            java.lang.Object userInfoQCompat = getUserInfoQCompat((android.os.UserManager) context.getSystemService("user"), i2);
            if (userInfoQCompat != null) {
                return new com.oplus.compat.content.pm.c_renamed(userInfoQCompat);
            }
            return null;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            android.content.pm.UserInfo userInfo = ((android.os.UserManager) context.getSystemService("user")).getUserInfo(i2);
            if (userInfo != null) {
                return new com.oplus.compat.content.pm.c_renamed(userInfo);
            }
            return null;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before L_renamed");
    }

    public static boolean isUserUnlockingOrUnlocked(android.content.Context context, android.os.UserHandle userHandle) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("isUserUnlockingOrUnlocked").withParcelable("userHandle", userHandle).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean(RESULT);
            }
            return false;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before R_renamed");
    }

    public static boolean removeUser(android.content.Context context, int i_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("removeUser").withInt("userId", i_renamed).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean(RESULT);
            }
            return false;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before R_renamed");
    }

    public static boolean canAddMoreUsers() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(new com.oplus.epona.Request.Builder().setComponentName(COMPONENT_NAME).setActionName("canAddMoreUsers").build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean(RESULT);
            }
            return false;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before R_renamed");
    }

    public static java.util.List<com.oplus.compat.content.pm.c_renamed> getUsers(android.content.Context context) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            android.os.UserManager userManager = (android.os.UserManager) context.getSystemService("user");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator it = userManager.getUsers().iterator();
            while (it.hasNext()) {
                arrayList.add(new com.oplus.compat.content.pm.c_renamed((android.content.pm.UserInfo) it.next()));
            }
            return arrayList;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before Q_renamed");
    }

    public static boolean isUserIDExist(android.content.Context context, int i_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            android.content.pm.UserInfo userInfo = ((android.os.UserManager) context.getSystemService("user")).getUserInfo(i_renamed);
            return userInfo != null && userInfo.getUserHandle().getIdentifier() == i_renamed;
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before Q_renamed");
    }

    public static boolean canShowMultiUserEntry(android.content.Context context) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        return canShowMultiUserEntry(context, context.getUserId());
    }

    public static boolean canShowMultiUserEntry(android.content.Context context, int i_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (!com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
                return ((java.lang.Boolean) canShowMultiUserEntryCompat(context, i_renamed)).booleanValue();
            }
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not Supported Before Q_renamed");
        }
        if (i_renamed == 888) {
            return false;
        }
        if (android.os.SystemProperties.getBoolean("persist.sys.assert.panic.multi.user.entrance", false)) {
            return true;
        }
        return !com.oplus.content.OplusFeatureConfigManager.getInstance().hasFeature("oplus.software.multiuser_entry_disabled");
    }
}
