package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class EnvironmentNative {
    private static final java.lang.String TAG = "EnvironmentNative";
    private static java.lang.Object sInstance;

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.Object getExternalStorageDirectoryQCompat(java.lang.Object obj) {
        return null;
    }

    private static java.lang.Object getOplusCustomDirectoryForQ() {
        return null;
    }

    private static java.lang.Object getOplusEngineerDirectoryForQ() {
        return null;
    }

    private static java.lang.Object getOplusProductDirectoryForQ() {
        return null;
    }

    private static java.lang.Object getOplusVersionDirectoryForQ() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.Object getUserEnvironmentWrapperQCompat(int i_renamed) {
        return null;
    }

    private static java.lang.Object getVendorDirectoryCompat() {
        return null;
    }

    private static class ReflectInfo {
        private static com.oplus.utils.reflect.RefMethod<java.io.File> getExternalStorageDirectory;

        @com.oplus.utils.reflect.MethodName(params = {int.class})
        private static com.oplus.utils.reflect.RefConstructor<java.lang.Object> userEnvironment;

        private ReflectInfo() {
        }

        static {
            com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) com.oplus.compat.os.EnvironmentNative.ReflectInfo.class, "android.os.Environment$UserEnvironment");
        }
    }

    private EnvironmentNative() {
    }

    public static class UserEnvironment {
        private android.os.Environment.UserEnvironment mUserEnvironment;
        private java.lang.Object mUserEnvironmentWrapper;

        public UserEnvironment(int i_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
                java.lang.Object unused = com.oplus.compat.os.EnvironmentNative.sInstance = com.oplus.compat.os.EnvironmentNative.ReflectInfo.userEnvironment.newInstance(java.lang.Integer.valueOf(i_renamed));
            } else if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
                this.mUserEnvironmentWrapper = com.oplus.compat.os.EnvironmentNative.getUserEnvironmentWrapperQCompat(i_renamed);
            } else {
                if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
                    this.mUserEnvironment = new android.os.Environment.UserEnvironment(i_renamed);
                    return;
                }
                throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
            }
        }

        public java.io.File getExternalStorageDirectory() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
                return (java.io.File) com.oplus.compat.os.EnvironmentNative.ReflectInfo.getExternalStorageDirectory.call(com.oplus.compat.os.EnvironmentNative.sInstance, new java.lang.Object[0]);
            }
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
                return (java.io.File) com.oplus.compat.os.EnvironmentNative.getExternalStorageDirectoryQCompat(this.mUserEnvironmentWrapper);
            }
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
                return this.mUserEnvironment.getExternalStorageDirectory();
            }
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
        }
    }

    public static java.io.File getOplusCustomDirectory() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            return android.os.OplusBaseEnvironment.getOplusCustomDirectory();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (java.io.File) getOplusCustomDirectoryForQ();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public static java.io.File getOplusProductDirectory() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            return android.os.OplusBaseEnvironment.getOplusProductDirectory();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (java.io.File) getOplusProductDirectoryForQ();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public static java.io.File getOplusEngineerDirectory() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            return android.os.OplusBaseEnvironment.getOplusEngineerDirectory();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (java.io.File) getOplusEngineerDirectoryForQ();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public static java.io.File getOplusVersionDirectory() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            return android.os.OplusBaseEnvironment.getOplusVersionDirectory();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (java.io.File) getOplusVersionDirectoryForQ();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public static java.io.File getVendorDirectory() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return android.os.Environment.getVendorDirectory();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.inner.os.EnvironmentWrapper.getVendorDirectory();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (java.io.File) getVendorDirectoryCompat();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.g_renamed()) {
            return android.os.Environment.getVendorDirectory();
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }
}
