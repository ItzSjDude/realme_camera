package com.oplus.compat.p187os;

import android.os.Environment;
import android.os.OplusBaseEnvironment;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.inner.os.EnvironmentWrapper;
import com.oplus.utils.reflect.MethodName;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefConstructor;
import com.oplus.utils.reflect.RefMethod;
import java.io.File;

/* loaded from: classes2.dex */
public class EnvironmentNative {
    private static final String TAG = "EnvironmentNative";
    private static Object sInstance;

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getExternalStorageDirectoryQCompat(Object obj) {
        return null;
    }

    private static Object getOplusCustomDirectoryForQ() {
        return null;
    }

    private static Object getOplusEngineerDirectoryForQ() {
        return null;
    }

    private static Object getOplusProductDirectoryForQ() {
        return null;
    }

    private static Object getOplusVersionDirectoryForQ() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getUserEnvironmentWrapperQCompat(int OplusGLSurfaceView_13) {
        return null;
    }

    private static Object getVendorDirectoryCompat() {
        return null;
    }

    private static class ReflectInfo {
        private static RefMethod<File> getExternalStorageDirectory;

        @MethodName(params = {int.class})
        private static RefConstructor<Object> userEnvironment;

        private ReflectInfo() {
        }

        static {
            RefClass.load((Class<?>) ReflectInfo.class, "android.os.Environment$UserEnvironment");
        }
    }

    private EnvironmentNative() {
    }

    public static class UserEnvironment {
        private Environment.UserEnvironment mUserEnvironment;
        private Object mUserEnvironmentWrapper;

        public UserEnvironment(int OplusGLSurfaceView_13) throws UnSupportedApiVersionException {
            if (VersionUtils.m24888d()) {
                Object unused = EnvironmentNative.sInstance = ReflectInfo.userEnvironment.newInstance(Integer.valueOf(OplusGLSurfaceView_13));
            } else if (VersionUtils.m24889e()) {
                this.mUserEnvironmentWrapper = EnvironmentNative.getUserEnvironmentWrapperQCompat(OplusGLSurfaceView_13);
            } else {
                if (VersionUtils.m24895k()) {
                    this.mUserEnvironment = new Environment.UserEnvironment(OplusGLSurfaceView_13);
                    return;
                }
                throw new UnSupportedApiVersionException();
            }
        }

        public File getExternalStorageDirectory() throws UnSupportedApiVersionException {
            if (VersionUtils.m24888d()) {
                return (File) ReflectInfo.getExternalStorageDirectory.call(EnvironmentNative.sInstance, new Object[0]);
            }
            if (VersionUtils.m24889e()) {
                return (File) EnvironmentNative.getExternalStorageDirectoryQCompat(this.mUserEnvironmentWrapper);
            }
            if (VersionUtils.m24895k()) {
                return this.mUserEnvironment.getExternalStorageDirectory();
            }
            throw new UnSupportedApiVersionException();
        }
    }

    public static File getOplusCustomDirectory() throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            return OplusBaseEnvironment.getOplusCustomDirectory();
        }
        if (VersionUtils.m24889e()) {
            return (File) getOplusCustomDirectoryForQ();
        }
        throw new UnSupportedApiVersionException();
    }

    public static File getOplusProductDirectory() throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            return OplusBaseEnvironment.getOplusProductDirectory();
        }
        if (VersionUtils.m24889e()) {
            return (File) getOplusProductDirectoryForQ();
        }
        throw new UnSupportedApiVersionException();
    }

    public static File getOplusEngineerDirectory() throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            return OplusBaseEnvironment.getOplusEngineerDirectory();
        }
        if (VersionUtils.m24889e()) {
            return (File) getOplusEngineerDirectoryForQ();
        }
        throw new UnSupportedApiVersionException();
    }

    public static File getOplusVersionDirectory() throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            return OplusBaseEnvironment.getOplusVersionDirectory();
        }
        if (VersionUtils.m24889e()) {
            return (File) getOplusVersionDirectoryForQ();
        }
        throw new UnSupportedApiVersionException();
    }

    public static File getVendorDirectory() throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return Environment.getVendorDirectory();
        }
        if (VersionUtils.m24886b()) {
            return EnvironmentWrapper.getVendorDirectory();
        }
        if (VersionUtils.m24889e()) {
            return (File) getVendorDirectoryCompat();
        }
        if (VersionUtils.m24891g()) {
            return Environment.getVendorDirectory();
        }
        throw new UnSupportedApiVersionException();
    }
}
