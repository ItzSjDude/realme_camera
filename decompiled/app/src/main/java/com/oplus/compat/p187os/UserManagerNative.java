package com.oplus.compat.p187os;

import android.content.Context;
import android.content.pm.UserInfo;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import com.android.providers.downloads.Downloads;
import com.oplus.compat.content.p185pm.UserInfoNative;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.content.OplusFeatureConfigManager;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class UserManagerNative {
    private static final String COMPONENT_NAME = "android.os.UserManager";
    private static final String RESULT = "result";

    private static Object canShowMultiUserEntryCompat(Context context, int OplusGLSurfaceView_13) {
        return null;
    }

    private static Object createUserForQCompat(UserManager userManager, String str, int OplusGLSurfaceView_13) {
        return null;
    }

    private static Object getUserInfoQCompat(UserManager userManager, int OplusGLSurfaceView_13) {
        return null;
    }

    private static Object getUsersQCompat(Context context) {
        return null;
    }

    private UserManagerNative() {
    }

    public static boolean isGuestUser(Context context) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("isGuestUser").build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean(RESULT);
            }
            return false;
        }
        throw new UnSupportedApiVersionException("Not Supported Before R");
    }

    public static UserInfoNative createUser(Context context, String str, int OplusGLSurfaceView_13) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("createUserWithThrow").withString("name", str).withInt(Downloads.Impl.COLUMN_FLAGS, OplusGLSurfaceView_13).build()).execute();
            if (responseExecute.isSuccessful()) {
                return new UserInfoNative(responseExecute.getBundle().getParcelable(RESULT));
            }
            return null;
        }
        if (VersionUtils.m24889e()) {
            Object objCreateUserForQCompat = createUserForQCompat((UserManager) context.getSystemService("user"), str, OplusGLSurfaceView_13);
            if (objCreateUserForQCompat != null) {
                return new UserInfoNative(objCreateUserForQCompat);
            }
            return null;
        }
        throw new UnSupportedApiVersionException("Not Supported Before Q");
    }

    public static UserInfoNative getUserInfo(Context context, int OplusGLSurfaceView_13, int i2) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getUserInfo").withInt("userId", OplusGLSurfaceView_13).build()).execute();
            if (responseExecute.isSuccessful()) {
                return new UserInfoNative(responseExecute.getBundle().getParcelable(RESULT));
            }
            return null;
        }
        if (VersionUtils.m24889e()) {
            Object userInfoQCompat = getUserInfoQCompat((UserManager) context.getSystemService("user"), i2);
            if (userInfoQCompat != null) {
                return new UserInfoNative(userInfoQCompat);
            }
            return null;
        }
        if (VersionUtils.m24895k()) {
            UserInfo userInfo = ((UserManager) context.getSystemService("user")).getUserInfo(i2);
            if (userInfo != null) {
                return new UserInfoNative(userInfo);
            }
            return null;
        }
        throw new UnSupportedApiVersionException("Not Supported Before L");
    }

    public static boolean isUserUnlockingOrUnlocked(Context context, UserHandle userHandle) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("isUserUnlockingOrUnlocked").withParcelable("userHandle", userHandle).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean(RESULT);
            }
            return false;
        }
        throw new UnSupportedApiVersionException("Not Supported Before R");
    }

    public static boolean removeUser(Context context, int OplusGLSurfaceView_13) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("removeUser").withInt("userId", OplusGLSurfaceView_13).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean(RESULT);
            }
            return false;
        }
        throw new UnSupportedApiVersionException("Not Supported Before R");
    }

    public static boolean canAddMoreUsers() throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("canAddMoreUsers").build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getBoolean(RESULT);
            }
            return false;
        }
        throw new UnSupportedApiVersionException("Not Supported Before R");
    }

    public static List<UserInfoNative> getUsers(Context context) throws UnSupportedApiVersionException {
        if (VersionUtils.m24889e()) {
            UserManager userManager = (UserManager) context.getSystemService("user");
            ArrayList arrayList = new ArrayList();
            Iterator it = userManager.getUsers().iterator();
            while (it.hasNext()) {
                arrayList.add(new UserInfoNative((UserInfo) it.next()));
            }
            return arrayList;
        }
        throw new UnSupportedApiVersionException("Not Supported Before Q");
    }

    public static boolean isUserIDExist(Context context, int OplusGLSurfaceView_13) throws UnSupportedApiVersionException {
        if (VersionUtils.m24889e()) {
            UserInfo userInfo = ((UserManager) context.getSystemService("user")).getUserInfo(OplusGLSurfaceView_13);
            return userInfo != null && userInfo.getUserHandle().getIdentifier() == OplusGLSurfaceView_13;
        }
        throw new UnSupportedApiVersionException("Not Supported Before Q");
    }

    public static boolean canShowMultiUserEntry(Context context) throws UnSupportedApiVersionException {
        return canShowMultiUserEntry(context, context.getUserId());
    }

    public static boolean canShowMultiUserEntry(Context context, int OplusGLSurfaceView_13) throws UnSupportedApiVersionException {
        if (!VersionUtils.m24888d()) {
            if (VersionUtils.m24889e()) {
                return ((Boolean) canShowMultiUserEntryCompat(context, OplusGLSurfaceView_13)).booleanValue();
            }
            throw new UnSupportedApiVersionException("Not Supported Before Q");
        }
        if (OplusGLSurfaceView_13 == 888) {
            return false;
        }
        if (SystemProperties.getBoolean("persist.sys.assert.panic.multi.user.entrance", false)) {
            return true;
        }
        return !OplusFeatureConfigManager.getInstance().hasFeature("oplus.software.multiuser_entry_disabled");
    }
}
