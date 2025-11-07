package com.oplus.compat.p187os;

import android.os.UserHandle;
import android.util.Log;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;
import com.oplus.utils.reflect.RefObject;

/* loaded from: classes2.dex */
public class UserHandleNative {
    private static final String COMPONENT_NAME = "android.os.UserHandle";
    public static UserHandle CURRENT = null;
    public static UserHandle OWNER = null;
    public static UserHandle SYSTEM = null;
    private static final String TAG = "UserHandleNative";
    public static int USER_ALL;
    public static int USER_CURRENT;
    public static int USER_SYSTEM;

    private static Object getCurrentQCompat() {
        return null;
    }

    private static Object getIdentifierQCompat(UserHandle userHandle) {
        return null;
    }

    private static Object getOwenrQCompat() {
        return null;
    }

    private static Object getUserAllQCompat() {
        return null;
    }

    private static Object getUserCurrentQCompat() {
        return null;
    }

    private static Object getUserSystemQCompat() {
        return null;
    }

    private static Object myUserIdQCompat() {
        return null;
    }

    private UserHandleNative() {
    }

    private static class ReflectInfo {
        private static RefObject<UserHandle> OWNER;
        private static RefObject<UserHandle> SYSTEM;
        private static RefMethod<Integer> getIdentifier;
        private static RefMethod<Integer> myUserId;

        private ReflectInfo() {
        }

        static {
            RefClass.load((Class<?>) ReflectInfo.class, (Class<?>) UserHandle.class);
        }
    }

    static {
        if (VersionUtils.m24888d()) {
            SYSTEM = (UserHandle) ReflectInfo.SYSTEM.get(null);
            OWNER = (UserHandle) ReflectInfo.OWNER.get(null);
            USER_CURRENT = -2;
            USER_ALL = -1;
            CURRENT = UserHandle.CURRENT;
            USER_SYSTEM = 0;
            return;
        }
        if (VersionUtils.m24889e()) {
            OWNER = (UserHandle) getOwenrQCompat();
            USER_CURRENT = ((Integer) getUserCurrentQCompat()).intValue();
            USER_ALL = ((Integer) getUserAllQCompat()).intValue();
            CURRENT = (UserHandle) getCurrentQCompat();
            USER_SYSTEM = ((Integer) getUserSystemQCompat()).intValue();
            return;
        }
        if (VersionUtils.m24895k()) {
            if (VersionUtils.m24890f()) {
                USER_ALL = -1;
            }
            if (VersionUtils.m24893i()) {
                USER_SYSTEM = 0;
            }
            USER_CURRENT = -2;
            CURRENT = UserHandle.CURRENT;
            OWNER = UserHandle.OWNER;
            return;
        }
        Log.COUIBaseListPopupWindow_8(TAG, "not supported before R");
    }

    public static int getAppId(int OplusGLSurfaceView_13) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getAppId").withInt("uid", OplusGLSurfaceView_13).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getInt("appId");
            }
            Log.COUIBaseListPopupWindow_8(TAG, responseExecute.getMessage());
            return 0;
        }
        throw new UnSupportedApiVersionException("Not Supported Before R");
    }

    public static int getUid(int OplusGLSurfaceView_13, int i2) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Response responseExecute = Epona.newCall(new Request.Builder().setComponentName(COMPONENT_NAME).setActionName("getUid").withInt("userId", OplusGLSurfaceView_13).withInt("appId", i2).build()).execute();
            if (responseExecute.isSuccessful()) {
                return responseExecute.getBundle().getInt("uid");
            }
            Log.COUIBaseListPopupWindow_8(TAG, responseExecute.getMessage());
            return 0;
        }
        throw new UnSupportedApiVersionException("Not Supported Before R");
    }

    public static int myUserId() throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            return ((Integer) ReflectInfo.myUserId.call(null, new Object[0])).intValue();
        }
        if (VersionUtils.m24889e()) {
            return ((Integer) myUserIdQCompat()).intValue();
        }
        if (VersionUtils.m24895k()) {
            return UserHandle.myUserId();
        }
        throw new UnSupportedApiVersionException("not supported before L");
    }

    public static int getIdentifier(UserHandle userHandle) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            return ((Integer) ReflectInfo.getIdentifier.call(userHandle, new Object[0])).intValue();
        }
        if (VersionUtils.m24889e()) {
            return ((Integer) getIdentifierQCompat(userHandle)).intValue();
        }
        if (VersionUtils.m24890f()) {
            return userHandle.getIdentifier();
        }
        throw new UnSupportedApiVersionException("not supported before P");
    }

    public static int getUserId(int OplusGLSurfaceView_13) throws UnSupportedApiVersionException {
        if (VersionUtils.m24890f()) {
            return UserHandle.getUserId(OplusGLSurfaceView_13);
        }
        throw new UnSupportedApiVersionException();
    }

    public static UserHandle createUserHandle(int OplusGLSurfaceView_13) throws UnSupportedApiVersionException {
        if (VersionUtils.m24890f()) {
            return new UserHandle(OplusGLSurfaceView_13);
        }
        throw new UnSupportedApiVersionException();
    }
}
