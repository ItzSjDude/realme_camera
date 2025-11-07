package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class FileUtilsNative {
    private static final java.lang.String TAG = "FileUtilsNative";

    private static java.lang.Object copyFileCompat(java.io.File file, java.io.File file2) {
        return null;
    }

    private static java.lang.Object readTextFileCompat(java.io.File file, int i_renamed, java.lang.String str) throws java.io.IOException {
        return null;
    }

    private static java.lang.Object setPermissionsCompat(java.io.FileDescriptor fileDescriptor, int i_renamed, int i2, int i3) {
        return null;
    }

    private static java.lang.Object setPermissionsQCompat(java.io.File file, int i_renamed, int i2, int i3) {
        return null;
    }

    private static java.lang.Object setPermissionsQCompat(java.lang.String str, int i_renamed, int i2, int i3) {
        return null;
    }

    private FileUtilsNative() {
    }

    private static class ReflectInfo {

        @com.oplus.utils.reflect.MethodName(name = "setPermissions", params = {java.io.File.class, int.class, int.class, int.class})
        private static com.oplus.utils.reflect.RefMethod<java.lang.Integer> setPermissionsFile;

        @com.oplus.utils.reflect.MethodName(name = "setPermissions", params = {java.lang.String.class, int.class, int.class, int.class})
        private static com.oplus.utils.reflect.RefMethod<java.lang.Integer> setPermissionsString;

        private ReflectInfo() {
        }

        static {
            com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) com.oplus.compat.os.FileUtilsNative.ReflectInfo.class, "android.os.FileUtils");
        }
    }

    public static int setPermissions(java.lang.String str, int i_renamed, int i2, int i3) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            return ((java.lang.Integer) com.oplus.compat.os.FileUtilsNative.ReflectInfo.setPermissionsString.call(null, str, java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3))).intValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return ((java.lang.Integer) setPermissionsQCompat(str, i_renamed, i2, i3)).intValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            return android.os.FileUtils.setPermissions(str, i_renamed, i2, i3);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before L_renamed");
    }

    public static int setPermissions(java.io.File file, int i_renamed, int i2, int i3) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            return ((java.lang.Integer) com.oplus.compat.os.FileUtilsNative.ReflectInfo.setPermissionsFile.call(null, file, java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3))).intValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return ((java.lang.Integer) setPermissionsQCompat(file, i_renamed, i2, i3)).intValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            return android.os.FileUtils.setPermissions(file, i_renamed, i2, i3);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before L_renamed");
    }

    public static boolean copyFile(java.io.File file, java.io.File file2) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return android.os.FileUtils.copyFile(file, file2);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.inner.os.FileUtilsWrapper.copyFile(file, file2);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return ((java.lang.Boolean) copyFileCompat(file, file2)).booleanValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.f_renamed()) {
            return android.os.FileUtils.copyFile(file, file2);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public static int setPermissions(java.io.FileDescriptor fileDescriptor, int i_renamed, int i2, int i3) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return android.os.FileUtils.setPermissions(fileDescriptor, i_renamed, i2, i3);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.inner.os.FileUtilsWrapper.setPermissions(fileDescriptor, i_renamed, i2, i3);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return ((java.lang.Integer) setPermissionsCompat(fileDescriptor, i_renamed, i2, i3)).intValue();
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
            return android.os.FileUtils.setPermissions(fileDescriptor, i_renamed, i2, i3);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }

    public static java.lang.String readTextFile(java.io.File file, int i_renamed, java.lang.String str) throws java.io.IOException, com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            return android.os.FileUtils.readTextFile(file, i_renamed, str);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            return com.oplus.inner.os.FileUtilsWrapper.readTextFile(file, i_renamed, str);
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            return (java.lang.String) readTextFileCompat(file, i_renamed, str);
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
    }
}
