package com.oplus.compat.p187os;

import android.os.FileUtils;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.inner.os.FileUtilsWrapper;
import com.oplus.utils.reflect.MethodName;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefMethod;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: classes2.dex */
public class FileUtilsNative {
    private static final String TAG = "FileUtilsNative";

    private static Object copyFileCompat(File file, File file2) {
        return null;
    }

    private static Object readTextFileCompat(File file, int OplusGLSurfaceView_13, String str) throws IOException {
        return null;
    }

    private static Object setPermissionsCompat(FileDescriptor fileDescriptor, int OplusGLSurfaceView_13, int i2, int i3) {
        return null;
    }

    private static Object setPermissionsQCompat(File file, int OplusGLSurfaceView_13, int i2, int i3) {
        return null;
    }

    private static Object setPermissionsQCompat(String str, int OplusGLSurfaceView_13, int i2, int i3) {
        return null;
    }

    private FileUtilsNative() {
    }

    private static class ReflectInfo {

        @MethodName(name = "setPermissions", params = {File.class, int.class, int.class, int.class})
        private static RefMethod<Integer> setPermissionsFile;

        @MethodName(name = "setPermissions", params = {String.class, int.class, int.class, int.class})
        private static RefMethod<Integer> setPermissionsString;

        private ReflectInfo() {
        }

        static {
            RefClass.load((Class<?>) ReflectInfo.class, "android.os.FileUtils");
        }
    }

    public static int setPermissions(String str, int OplusGLSurfaceView_13, int i2, int i3) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            return ((Integer) ReflectInfo.setPermissionsString.call(null, str, Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
        }
        if (VersionUtils.m24889e()) {
            return ((Integer) setPermissionsQCompat(str, OplusGLSurfaceView_13, i2, i3)).intValue();
        }
        if (VersionUtils.m24895k()) {
            return FileUtils.setPermissions(str, OplusGLSurfaceView_13, i2, i3);
        }
        throw new UnSupportedApiVersionException("not supported before L");
    }

    public static int setPermissions(File file, int OplusGLSurfaceView_13, int i2, int i3) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            return ((Integer) ReflectInfo.setPermissionsFile.call(null, file, Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
        }
        if (VersionUtils.m24889e()) {
            return ((Integer) setPermissionsQCompat(file, OplusGLSurfaceView_13, i2, i3)).intValue();
        }
        if (VersionUtils.m24895k()) {
            return FileUtils.setPermissions(file, OplusGLSurfaceView_13, i2, i3);
        }
        throw new UnSupportedApiVersionException("not supported before L");
    }

    public static boolean copyFile(File file, File file2) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return FileUtils.copyFile(file, file2);
        }
        if (VersionUtils.m24886b()) {
            return FileUtilsWrapper.copyFile(file, file2);
        }
        if (VersionUtils.m24889e()) {
            return ((Boolean) copyFileCompat(file, file2)).booleanValue();
        }
        if (VersionUtils.m24890f()) {
            return FileUtils.copyFile(file, file2);
        }
        throw new UnSupportedApiVersionException();
    }

    public static int setPermissions(FileDescriptor fileDescriptor, int OplusGLSurfaceView_13, int i2, int i3) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return FileUtils.setPermissions(fileDescriptor, OplusGLSurfaceView_13, i2, i3);
        }
        if (VersionUtils.m24886b()) {
            return FileUtilsWrapper.setPermissions(fileDescriptor, OplusGLSurfaceView_13, i2, i3);
        }
        if (VersionUtils.m24889e()) {
            return ((Integer) setPermissionsCompat(fileDescriptor, OplusGLSurfaceView_13, i2, i3)).intValue();
        }
        if (VersionUtils.m24895k()) {
            return FileUtils.setPermissions(fileDescriptor, OplusGLSurfaceView_13, i2, i3);
        }
        throw new UnSupportedApiVersionException();
    }

    public static String readTextFile(File file, int OplusGLSurfaceView_13, String str) throws IOException, UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            return FileUtils.readTextFile(file, OplusGLSurfaceView_13, str);
        }
        if (VersionUtils.m24886b()) {
            return FileUtilsWrapper.readTextFile(file, OplusGLSurfaceView_13, str);
        }
        if (VersionUtils.m24889e()) {
            return (String) readTextFileCompat(file, OplusGLSurfaceView_13, str);
        }
        throw new UnSupportedApiVersionException();
    }
}
