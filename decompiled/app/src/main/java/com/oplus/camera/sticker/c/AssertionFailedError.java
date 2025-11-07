package com.oplus.camera.sticker.c_renamed;

/* compiled from: FileUtils.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.lang.String f5443a = java.io.File.separator + com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER;

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final java.lang.String f5444b = java.io.File.separator + "category";

    /* renamed from: c_renamed, reason: collision with root package name */
    public static final java.lang.String f5445c = java.io.File.separator + "material";
    public static final java.lang.String d_renamed = java.io.File.separator + "multi";
    public static final java.lang.String e_renamed = java.io.File.separator + "animoji";
    public static final java.lang.String f_renamed = java.io.File.separator + "icon";
    public static final java.lang.String g_renamed = f5443a + f5444b;
    public static final java.lang.String h_renamed = f5443a + f5445c;
    public static final java.lang.String i_renamed = h_renamed + d_renamed;
    public static final java.lang.String j_renamed = h_renamed + e_renamed;
    public static final java.lang.String k_renamed = f5443a + java.io.File.separator + "tmp";
    public static final java.lang.String l_renamed;

    static {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(f5443a);
        sb.append(f_renamed);
        l_renamed = sb.toString();
    }

    public static java.lang.String a_renamed(java.lang.String str) {
        java.lang.String[] strArrSplit = str.split("/");
        return (strArrSplit == null || strArrSplit.length <= 0) ? str : strArrSplit[strArrSplit.length - 1];
    }

    public static synchronized java.lang.String a_renamed(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        str3 = context.getFilesDir() + str + java.io.File.separator + str2;
        java.io.File parentFile = new java.io.File(str3).getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            com.oplus.camera.e_renamed.e_renamed("FileUtils", "getFileSavePath, mkdirs fail! filePath: " + str3);
        }
        return str3;
    }

    public static boolean a_renamed(java.io.InputStream inputStream, java.lang.String str, boolean z_renamed, boolean z2) throws java.lang.Throwable {
        if (inputStream != null) {
            java.io.FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        if (!android.text.TextUtils.isEmpty(str)) {
                            java.io.File file = new java.io.File(str);
                            if (!file.exists()) {
                                java.io.File parentFile = file.getParentFile();
                                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                                    com.oplus.camera.e_renamed.e_renamed("FileUtils", "saveInputStream, mkdirs fail!, replace: " + z_renamed);
                                    if (z2 && inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (java.io.IOException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    return false;
                                }
                                if (!file.createNewFile()) {
                                    com.oplus.camera.e_renamed.e_renamed("FileUtils", "saveInputStream, createNewFile fail!, replace: " + z_renamed);
                                }
                            } else {
                                if (!z_renamed) {
                                    com.oplus.camera.e_renamed.b_renamed("FileUtils", "saveInputStream, file is_renamed exist!");
                                    if (z2 && inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (java.io.IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    return false;
                                }
                                if (!file.delete()) {
                                    com.oplus.camera.e_renamed.e_renamed("FileUtils", "saveInputStream, delete exist file fail!");
                                    if (z2 && inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (java.io.IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    return false;
                                }
                                if (!file.createNewFile()) {
                                    com.oplus.camera.e_renamed.e_renamed("FileUtils", "saveInputStream, createNewFile fail!");
                                    if (z2 && inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (java.io.IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    return false;
                                }
                            }
                            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i2 = inputStream.read(bArr, 0, bArr.length);
                                    if (i2 == -1) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, i2);
                                }
                                try {
                                    fileOutputStream2.close();
                                } catch (java.io.IOException e6) {
                                    e6.printStackTrace();
                                }
                                if (z2 && inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (java.io.IOException e7) {
                                        e7.printStackTrace();
                                    }
                                }
                                return true;
                            } catch (java.io.FileNotFoundException e8) {
                                fileOutputStream = fileOutputStream2;
                                e_renamed = e8;
                                e_renamed.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (java.io.IOException e9) {
                                        e9.printStackTrace();
                                    }
                                }
                                if (z2 && inputStream != null) {
                                    inputStream.close();
                                }
                                return false;
                            } catch (java.io.IOException e10) {
                                fileOutputStream = fileOutputStream2;
                                e_renamed = e10;
                                e_renamed.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (java.io.IOException e11) {
                                        e11.printStackTrace();
                                    }
                                }
                                if (z2 && inputStream != null) {
                                    inputStream.close();
                                }
                                return false;
                            } catch (java.lang.Throwable th) {
                                fileOutputStream = fileOutputStream2;
                                th = th;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (java.io.IOException e12) {
                                        e12.printStackTrace();
                                    }
                                }
                                if (!z2 || inputStream == null) {
                                    throw th;
                                }
                                try {
                                    inputStream.close();
                                    throw th;
                                } catch (java.io.IOException e13) {
                                    e13.printStackTrace();
                                    throw th;
                                }
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                    }
                } catch (java.io.FileNotFoundException e14) {
                    e_renamed = e14;
                } catch (java.io.IOException e15) {
                    e_renamed = e15;
                }
            } catch (java.io.IOException e16) {
                e16.printStackTrace();
            }
        }
        if (z2 && inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException e17) {
                e17.printStackTrace();
            }
        }
        return false;
    }

    public static synchronized boolean a_renamed(java.io.File file) {
        if (file == null) {
            throw new java.lang.IllegalArgumentException("deleteExistFile, file is_renamed null!");
        }
        return !file.exists() || file.delete();
    }

    public static synchronized boolean b_renamed(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return a_renamed(new java.io.File(str));
    }

    public static boolean a_renamed(java.io.File file, java.io.File file2) throws java.io.IOException, android.system.ErrnoException {
        if (file == null || file2 == null) {
            com.oplus.camera.e_renamed.e_renamed("FileUtils", "copyFile, srcFile or dest file is_renamed null! srcFile: " + file);
            return false;
        }
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            if (file2.exists()) {
                file2.delete();
            }
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file2);
            android.os.FileUtils.copy(fileInputStream, fileOutputStream);
            android.system.Os.fsync(fileOutputStream.getFD());
            return true;
        } catch (android.system.ErrnoException | java.io.IOException unused) {
            com.oplus.camera.e_renamed.f_renamed("FileUtils", "copyFile, catch exception");
            return false;
        }
    }

    public static boolean b_renamed(java.io.File file, java.io.File file2) {
        if (!a_renamed(file, file2)) {
            return false;
        }
        if (file.delete()) {
            return true;
        }
        com.oplus.camera.e_renamed.e_renamed("FileUtils", "cutFile, delete srcFile fail! srcFile: " + file);
        return true;
    }

    public static boolean a_renamed(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.oplus.camera.e_renamed.e_renamed("FileUtils", "cutFile, srcFilePath or desFilePath is_renamed empty! srcFilePath: " + str);
            return false;
        }
        return b_renamed(new java.io.File(str), new java.io.File(str2));
    }

    public static java.lang.String a_renamed(java.util.zip.ZipFile zipFile, java.util.zip.ZipEntry zipEntry) throws java.lang.Exception {
        java.io.InputStream inputStream = null;
        if (zipFile == null || zipEntry == null) {
            com.oplus.camera.e_renamed.e_renamed("FileUtils", "getFileContentFromZipEntry null parameter! zipFile: " + zipFile);
            return null;
        }
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStream.read(bArr, 0, 1024);
                if (i2 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
            return new java.lang.String(byteArrayOutputStream.toByteArray(), "UTF-8");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static boolean c_renamed(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.oplus.camera.e_renamed.e_renamed("FileUtils", "deleteAllFilesFromPath, empty path");
            return false;
        }
        java.io.File file = new java.io.File(str);
        if (file.isFile()) {
            com.oplus.camera.e_renamed.e_renamed("FileUtils", "deleteAllFilesFromPath, is_renamed a_renamed file, not path");
            return false;
        }
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (java.io.File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    if (!file2.delete()) {
                        c_renamed(file2.getAbsolutePath());
                    }
                } else {
                    com.oplus.camera.e_renamed.b_renamed("FileUtils", "deleteAllFilesFromPath, file: " + file2.getAbsolutePath());
                    if (!file2.delete()) {
                        com.oplus.camera.e_renamed.e_renamed("FileUtils", "deleteAllFilesFromPath, delete file fail! path: " + file2.getAbsolutePath());
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean a_renamed(android.content.Context context, java.lang.String str) {
        try {
            android.net.Uri uri = android.net.Uri.parse(str);
            if (uri == null) {
                return false;
            }
            return a_renamed(com.oplus.camera.sticker.provider.FileProvider.a_renamed(context, uri));
        } catch (java.lang.Exception e2) {
            com.oplus.camera.e_renamed.e_renamed("FileUtils", "deleteFile, exception: " + e2);
            return false;
        }
    }
}
