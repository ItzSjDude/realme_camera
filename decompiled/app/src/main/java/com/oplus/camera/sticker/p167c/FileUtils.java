package com.oplus.camera.sticker.p167c;

import android.content.Context;
import android.net.Uri;
import android.os.FileUtils;
import android.system.ErrnoException;
import android.system.Os;
import android.text.TextUtils;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.sticker.provider.FileProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: FileUtils.java */
/* renamed from: com.oplus.camera.sticker.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class FileUtils {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final String f16213a = File.separator + ApsConstant.CAPTURE_MODE_STICKER;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final String f16214b = File.separator + "category";

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final String f16215c = File.separator + "material";

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static final String f16216d = File.separator + "multi";

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static final String f16217e = File.separator + "animoji";

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static final String f16218f = File.separator + "icon";

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static final String f16219g = f16213a + f16214b;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static final String f16220h = f16213a + f16215c;

    /* renamed from: OplusGLSurfaceView_13 */
    public static final String f16221i = f16220h + f16216d;

    /* renamed from: OplusGLSurfaceView_15 */
    public static final String f16222j = f16220h + f16217e;

    /* renamed from: OplusGLSurfaceView_5 */
    public static final String f16223k = f16213a + File.separator + "tmp";

    /* renamed from: OplusGLSurfaceView_14 */
    public static final String f16224l;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f16213a);
        sb.append(f16218f);
        f16224l = sb.toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m16810a(String str) {
        String[] strArrSplit = str.split("/");
        return (strArrSplit == null || strArrSplit.length <= 0) ? str : strArrSplit[strArrSplit.length - 1];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized String m16809a(Context context, String str, String str2) {
        String str3;
        str3 = context.getFilesDir() + str + File.separator + str2;
        File parentFile = new File(str3).getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            CameraLog.m12966e("FileUtils", "getFileSavePath, mkdirs fail! filePath: " + str3);
        }
        return str3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m16815a(InputStream inputStream, String str, boolean z, boolean z2) throws Throwable {
        if (inputStream != null) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            File file = new File(str);
                            if (!file.exists()) {
                                File parentFile = file.getParentFile();
                                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                                    CameraLog.m12966e("FileUtils", "saveInputStream, mkdirs fail!, replace: " + z);
                                    if (z2 && inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException COUIBaseListPopupWindow_8) {
                                            COUIBaseListPopupWindow_8.printStackTrace();
                                        }
                                    }
                                    return false;
                                }
                                if (!file.createNewFile()) {
                                    CameraLog.m12966e("FileUtils", "saveInputStream, createNewFile fail!, replace: " + z);
                                }
                            } else {
                                if (!z) {
                                    CameraLog.m12959b("FileUtils", "saveInputStream, file is exist!");
                                    if (z2 && inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    return false;
                                }
                                if (!file.delete()) {
                                    CameraLog.m12966e("FileUtils", "saveInputStream, delete exist file fail!");
                                    if (z2 && inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    return false;
                                }
                                if (!file.createNewFile()) {
                                    CameraLog.m12966e("FileUtils", "saveInputStream, createNewFile fail!");
                                    if (z2 && inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    return false;
                                }
                            }
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int OplusGLSurfaceView_13 = inputStream.read(bArr, 0, bArr.length);
                                    if (OplusGLSurfaceView_13 == -1) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, OplusGLSurfaceView_13);
                                }
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                                if (z2 && inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                return true;
                            } catch (FileNotFoundException e7) {
                                fileOutputStream = fileOutputStream2;
                                COUIBaseListPopupWindow_8 = e7;
                                COUIBaseListPopupWindow_8.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                    }
                                }
                                if (z2 && inputStream != null) {
                                    inputStream.close();
                                }
                                return false;
                            } catch (IOException e9) {
                                fileOutputStream = fileOutputStream2;
                                COUIBaseListPopupWindow_8 = e9;
                                COUIBaseListPopupWindow_8.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                    }
                                }
                                if (z2 && inputStream != null) {
                                    inputStream.close();
                                }
                                return false;
                            } catch (Throwable th) {
                                fileOutputStream = fileOutputStream2;
                                th = th;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e11) {
                                        e11.printStackTrace();
                                    }
                                }
                                if (!z2 || inputStream == null) {
                                    throw th;
                                }
                                try {
                                    inputStream.close();
                                    throw th;
                                } catch (IOException e12) {
                                    e12.printStackTrace();
                                    throw th;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (FileNotFoundException e13) {
                    COUIBaseListPopupWindow_8 = e13;
                } catch (IOException e14) {
                    COUIBaseListPopupWindow_8 = e14;
                }
            } catch (IOException e15) {
                e15.printStackTrace();
            }
        }
        if (z2 && inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized boolean m16813a(File file) {
        if (file == null) {
            throw new IllegalArgumentException("deleteExistFile, file is null!");
        }
        return !file.exists() || file.delete();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static synchronized boolean m16818b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m16813a(new File(str));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m16814a(File file, File file2) throws IOException, ErrnoException {
        if (file == null || file2 == null) {
            CameraLog.m12966e("FileUtils", "copyFile, srcFile or dest file is null! srcFile: " + file);
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            if (file2.exists()) {
                file2.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            FileUtils.copy(fileInputStream, fileOutputStream);
            Os.fsync(fileOutputStream.getFD());
            return true;
        } catch (ErrnoException | IOException unused) {
            CameraLog.m12967f("FileUtils", "copyFile, catch exception");
            return false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m16817b(File file, File file2) {
        if (!m16814a(file, file2)) {
            return false;
        }
        if (file.delete()) {
            return true;
        }
        CameraLog.m12966e("FileUtils", "cutFile, delete srcFile fail! srcFile: " + file);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m16816a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            CameraLog.m12966e("FileUtils", "cutFile, srcFilePath or desFilePath is empty! srcFilePath: " + str);
            return false;
        }
        return m16817b(new File(str), new File(str2));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m16811a(ZipFile zipFile, ZipEntry zipEntry) throws Exception {
        InputStream inputStream = null;
        if (zipFile == null || zipEntry == null) {
            CameraLog.m12966e("FileUtils", "getFileContentFromZipEntry null parameter! zipFile: " + zipFile);
            return null;
        }
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int OplusGLSurfaceView_13 = inputStream.read(bArr, 0, 1024);
                if (OplusGLSurfaceView_13 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, OplusGLSurfaceView_13);
            }
            return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m16819c(String str) {
        if (TextUtils.isEmpty(str)) {
            CameraLog.m12966e("FileUtils", "deleteAllFilesFromPath, empty path");
            return false;
        }
        File file = new File(str);
        if (file.isFile()) {
            CameraLog.m12966e("FileUtils", "deleteAllFilesFromPath, is PlatformImplementations.kt_3 file, not path");
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    if (!file2.delete()) {
                        m16819c(file2.getAbsolutePath());
                    }
                } else {
                    CameraLog.m12959b("FileUtils", "deleteAllFilesFromPath, file: " + file2.getAbsolutePath());
                    if (!file2.delete()) {
                        CameraLog.m12966e("FileUtils", "deleteAllFilesFromPath, delete file fail! path: " + file2.getAbsolutePath());
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m16812a(Context context, String str) {
        try {
            Uri uri = Uri.parse(str);
            if (uri == null) {
                return false;
            }
            return m16813a(FileProvider.m16979a(context, uri));
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("FileUtils", "deleteFile, exception: " + COUIBaseListPopupWindow_8);
            return false;
        }
    }
}
