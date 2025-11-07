package com.oplus.camera;

/* loaded from: classes2.dex */
public class Storage implements com.oplus.camera.d_renamed {
    private static android.content.Context B_renamed;
    public static final java.lang.String g_renamed = android.os.Environment.DIRECTORY_DCIM;
    public static final java.lang.String h_renamed = g_renamed + java.io.File.separator + "Camera" + java.io.File.separator;
    public static java.lang.String i_renamed = null;
    public static java.lang.String j_renamed = null;
    public static java.lang.String k_renamed = null;
    public static java.lang.String l_renamed = null;
    public static java.lang.String m_renamed = null;
    public static java.lang.String n_renamed = null;
    public static java.lang.String o_renamed = null;
    public static java.lang.String p_renamed = null;
    public static java.lang.String q_renamed = null;
    public static java.lang.String r_renamed = null;
    public static java.lang.String s_renamed = null;
    public static java.lang.String t_renamed = null;
    public static java.lang.String u_renamed = "uninitied";
    public static int v_renamed = 0;
    public static int w_renamed = 0;
    public static boolean x_renamed = false;
    public static boolean y_renamed = false;
    private static final java.lang.String z_renamed = "image/" + ".jpeg".substring(1);
    private static final android.net.Uri A_renamed = android.net.Uri.parse("content://com.open.gallery.smart.provider").buildUpon().appendPath("fast_captures").build();
    private static java.lang.String C_renamed = null;
    private static boolean D_renamed = false;

    public static void a_renamed(android.content.Context context) {
        com.oplus.camera.e_renamed.b_renamed("Storage", "initializeStoragePath()");
        b_renamed(context);
        c_renamed(context);
        o_renamed = com.oplus.os.OplusUsbEnvironment.getInternalSdDirectory(context).getAbsolutePath() + java.io.File.separator + context.getResources().getString(com.oplus.camera.R_renamed.string.camera_image_bucket_name);
        q_renamed = com.oplus.os.OplusUsbEnvironment.getInternalSdDirectory(context).getAbsolutePath() + java.io.File.separator + context.getResources().getString(com.oplus.camera.R_renamed.string.camera_video_bucket_name);
        s_renamed = com.oplus.camera.util.Util.E_renamed(context).getAbsolutePath();
        if (D_renamed) {
            t_renamed = context.getCacheDir().getAbsolutePath() + java.io.File.separator + context.getResources().getString(com.oplus.camera.R_renamed.string.camera_thumbnail_bucket_name);
        } else {
            t_renamed = com.oplus.os.OplusUsbEnvironment.getInternalSdDirectory(context).getAbsolutePath() + java.io.File.separator + context.getResources().getString(com.oplus.camera.R_renamed.string.camera_post_bucket_name);
        }
        n_renamed = com.oplus.camera.l_renamed.c_renamed.a_renamed(o_renamed);
        p_renamed = com.oplus.camera.l_renamed.c_renamed.a_renamed(q_renamed);
        r_renamed = com.oplus.camera.l_renamed.c_renamed.a_renamed(s_renamed);
        B_renamed = context;
        y_renamed = g_renamed() <= 8.0d;
    }

    public static void b_renamed(android.content.Context context) {
        java.io.File externalSdDirectory = com.oplus.os.OplusUsbEnvironment.getExternalSdDirectory(context);
        if (externalSdDirectory != null) {
            java.lang.String absolutePath = externalSdDirectory.getAbsolutePath();
            com.oplus.camera.e_renamed.b_renamed("Storage", "initializeExternalSdBucketName, externalSdPath: " + absolutePath);
            java.lang.String str = j_renamed;
            if (str == null || !str.startsWith(absolutePath)) {
                j_renamed = externalSdDirectory.getAbsolutePath() + java.io.File.separator + context.getResources().getString(com.oplus.camera.R_renamed.string.camera_image_bucket_name);
                l_renamed = externalSdDirectory.getAbsolutePath() + java.io.File.separator + context.getResources().getString(com.oplus.camera.R_renamed.string.camera_video_bucket_name);
                i_renamed = com.oplus.camera.l_renamed.c_renamed.a_renamed(j_renamed);
                k_renamed = com.oplus.camera.l_renamed.c_renamed.a_renamed(l_renamed);
            }
        }
    }

    public static void c_renamed(android.content.Context context) {
        boolean z2 = false;
        java.util.List<android.content.pm.ResolveInfo> listQueryIntentActivities = context.getApplicationContext().getPackageManager().queryIntentActivities(new android.content.Intent("com.oplusos.gallery3d.action.fastcapture.sandbox"), 0);
        if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
            z2 = true;
        }
        D_renamed = z2;
    }

    public static com.oplus.camera.Storage.CameraPicture a_renamed(com.oplus.camera.Storage.CameraPicture cameraPicture) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        android.net.Uri uriA;
        com.oplus.camera.e_renamed.b_renamed("Storage", "addImage, " + cameraPicture);
        android.net.Uri uri = null;
        if (cameraPicture.n_renamed > -1 && -1 == cameraPicture.m_renamed) {
            return null;
        }
        java.lang.String strA = cameraPicture.g_renamed != null ? cameraPicture.g_renamed : com.oplus.camera.util.Util.a_renamed(cameraPicture.l_renamed);
        if ("off".equals(u_renamed)) {
            str = o_renamed;
        } else {
            str = j_renamed;
        }
        if (cameraPicture.h_renamed == null || com.oplus.camera.statistics.model.CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG.equalsIgnoreCase(cameraPicture.h_renamed)) {
            str2 = ".jpg";
        } else if ("raw".equalsIgnoreCase(cameraPicture.h_renamed)) {
            str2 = ".dng";
        } else {
            if (!"heic_8bits".equalsIgnoreCase(cameraPicture.h_renamed) && !"heic_10bits".equalsIgnoreCase(cameraPicture.h_renamed)) {
                return null;
            }
            str2 = ".heic";
        }
        if (cameraPicture.m_renamed > -1) {
            str3 = cameraPicture.k_renamed + java.io.File.separator + strA + str2;
            a_renamed(cameraPicture.k_renamed);
        } else {
            str3 = str + java.io.File.separator + strA + str2;
        }
        if ("raw".equalsIgnoreCase(cameraPicture.h_renamed)) {
            C_renamed = strA;
        } else if (C_renamed != null && cameraPicture.g_renamed == null) {
            str3 = str + java.io.File.separator + C_renamed + str2;
            C_renamed = null;
        }
        if ("raw".equalsIgnoreCase(cameraPicture.h_renamed) && cameraPicture.i_renamed.equals(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_NIGHT)) {
            com.oplus.camera.e_renamed.a_renamed("Storage", "addImage, nightNode Raw return");
            return null;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues(12);
        contentValues.put("title", strA);
        contentValues.put("_display_name", strA + str2);
        contentValues.put("datetaken", java.lang.Long.valueOf(cameraPicture.l_renamed));
        if ("raw".equals(cameraPicture.h_renamed)) {
            contentValues.put("mime_type", "image/x_renamed-adobe-dng");
        } else if (com.oplus.camera.statistics.model.CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG.equals(cameraPicture.h_renamed)) {
            contentValues.put("mime_type", "image/jpeg");
        } else if ("heic_8bits".equals(cameraPicture.h_renamed) || "heic_10bits".equals(cameraPicture.h_renamed)) {
            contentValues.put("mime_type", "image/heic");
            contentValues.put(com.android.providers.downloads.Downloads.Impl._DATA, str3);
        }
        contentValues.put("orientation", java.lang.Integer.valueOf(cameraPicture.t_renamed));
        contentValues.put("_size", java.lang.Integer.valueOf((int) new java.io.File(str3).length()));
        contentValues.put("relative_path", e_renamed(cameraPicture));
        boolean z2 = false;
        try {
            if (cameraPicture.W_renamed && ("heic_8bits".equals(cameraPicture.h_renamed) || "heic_10bits".equals(cameraPicture.h_renamed))) {
                uriA = cameraPicture.f4068c;
            } else {
                uriA = com.oplus.camera.util.d_renamed.a_renamed(c_renamed("on_renamed".equals(u_renamed) && d_renamed()), contentValues);
            }
            uri = uriA;
            com.oplus.camera.e_renamed.a_renamed("Storage", "addImage, insertImage, uri: " + uri);
            contentValues.put(com.android.providers.downloads.Downloads.Impl._DATA, str3);
            contentValues.put("media_id", java.lang.Long.valueOf(android.content.ContentUris.parseId(uri)));
            c_renamed(cameraPicture, contentValues, uri);
            if (cameraPicture.D_renamed) {
                if ("heic_8bits".equalsIgnoreCase(cameraPicture.h_renamed) && !cameraPicture.W_renamed) {
                    a_renamed(true, cameraPicture, uri);
                } else if ("heic_10bits".equalsIgnoreCase(cameraPicture.h_renamed) && !cameraPicture.W_renamed) {
                    a_renamed(false, cameraPicture, uri);
                } else if (cameraPicture.e_renamed != null) {
                    a_renamed(uri, cameraPicture);
                }
            } else if (!"heic_8bits".equalsIgnoreCase(cameraPicture.h_renamed) && !"heic_10bits".equalsIgnoreCase(cameraPicture.h_renamed)) {
                com.oplus.camera.e_renamed.b_renamed("Storage", "addImage, path: " + str3);
                a_renamed(uri, cameraPicture.f4066a, cameraPicture.e_renamed);
                b_renamed(uri, cameraPicture);
            }
            if (cameraPicture.E_renamed && cameraPicture.m_renamed == -1) {
                a_renamed(uri, com.oplus.camera.util.Util.l_renamed().getContentResolver());
                if (cameraPicture.V_renamed != null) {
                    cameraPicture.V_renamed.a_renamed();
                }
            }
        } catch (java.lang.Throwable th) {
            com.oplus.camera.e_renamed.d_renamed("Storage", "Failed to write MediaStore.", th);
        }
        cameraPicture.f4068c = uri;
        cameraPicture.mPath = str3;
        cameraPicture.B_renamed = true;
        if (".jpg".equals(str2) && (cameraPicture.n_renamed == -1 || cameraPicture.n_renamed == 1)) {
            z2 = true;
        }
        cameraPicture.C_renamed = z2;
        return cameraPicture;
    }

    private static com.oplus.exif.OplusExifInterface f_renamed(com.oplus.camera.Storage.CameraPicture cameraPicture) {
        com.oplus.exif.OplusExifInterface oplusExifInterface = new com.oplus.exif.OplusExifInterface();
        try {
            oplusExifInterface.readExif(cameraPicture.e_renamed);
        } catch (java.io.IOException e_renamed) {
            e_renamed.printStackTrace();
        }
        oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_USER_COMMENT, com.oplus.exif.OplusExifTag.EXIF_TAG_PREFIX.concat(java.lang.String.valueOf(com.oplus.camera.g_renamed.b_renamed.a_renamed(cameraPicture.i_renamed, cameraPicture.s_renamed)))));
        oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_ORIENTATION, java.lang.Integer.valueOf(cameraPicture.t_renamed)));
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy:MM:dd_renamed HH:mm:ss", java.util.Locale.US);
        java.text.SimpleDateFormat simpleDateFormat2 = new java.text.SimpleDateFormat("yyyy:MM:dd_renamed", java.util.Locale.US);
        simpleDateFormat2.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        simpleDateFormat.setTimeZone(java.util.Calendar.getInstance().getTimeZone());
        oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_DATE_TIME, simpleDateFormat.format(java.lang.Long.valueOf(cameraPicture.l_renamed))));
        oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_DATE_TIME_ORIGINAL, simpleDateFormat.format(java.lang.Long.valueOf(cameraPicture.l_renamed))));
        java.time.ZonedDateTime zonedDateTimeOfInstant = java.time.ZonedDateTime.ofInstant(java.time.Instant.ofEpochMilli(cameraPicture.l_renamed), java.time.ZoneId.systemDefault());
        oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_SUB_SEC_TIME_ORIGINAL, java.time.format.DateTimeFormatter.ofPattern("SSS").format(zonedDateTimeOfInstant)));
        oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_OFFSET_TIME_ORIGINAL, 2, java.time.format.DateTimeFormatter.ofPattern("XXX").format(zonedDateTimeOfInstant)));
        oplusExifInterface.addGpsDateTimeStampTag(cameraPicture.l_renamed);
        oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_GPS_DATE_STAMP, simpleDateFormat2.format(java.lang.Long.valueOf(cameraPicture.l_renamed))));
        if (cameraPicture.d_renamed != null) {
            oplusExifInterface.addGpsTags(cameraPicture.d_renamed.getLatitude(), cameraPicture.d_renamed.getLongitude());
        }
        return oplusExifInterface;
    }

    private static void a_renamed(android.net.Uri uri, com.oplus.camera.Storage.CameraPicture cameraPicture) throws java.io.IOException {
        com.oplus.exif.OplusExifInterface oplusExifInterfaceF = f_renamed(cameraPicture);
        java.io.OutputStream outputStreamOpenOutputStream = null;
        try {
            try {
                try {
                    outputStreamOpenOutputStream = cameraPicture.f4066a.openOutputStream(uri);
                    if (outputStreamOpenOutputStream != null) {
                        oplusExifInterfaceF.writeExif(cameraPicture.e_renamed, outputStreamOpenOutputStream);
                    }
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.close();
                    }
                } catch (java.io.IOException e_renamed) {
                    e_renamed.printStackTrace();
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.close();
                    }
                }
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
            }
        } catch (java.lang.Throwable th) {
            if (outputStreamOpenOutputStream != null) {
                try {
                    outputStreamOpenOutputStream.close();
                } catch (java.io.IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static java.lang.String a_renamed(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        if ("off".equals(u_renamed)) {
            str3 = o_renamed;
        } else {
            str3 = j_renamed;
        }
        if (!"".equals(str2)) {
            return str3 + '/' + str + "." + str2;
        }
        return str3 + "/Cshot/" + str;
    }

    public static java.lang.String a_renamed() {
        return s_renamed;
    }

    public static java.lang.String b_renamed() {
        return t_renamed;
    }

    public static boolean c_renamed() {
        return D_renamed;
    }

    public static void a_renamed(java.lang.String str) {
        if (D_renamed || new java.io.File(str).exists()) {
            return;
        }
        com.oplus.camera.q_renamed.a_renamed.f_renamed(str);
    }

    public static boolean a_renamed(android.net.Uri uri, android.content.ContentResolver contentResolver, byte[] bArr) throws java.io.IOException {
        if (bArr == null) {
            return false;
        }
        java.io.OutputStream outputStreamOpenOutputStream = null;
        try {
            try {
                outputStreamOpenOutputStream = contentResolver.openOutputStream(uri, "w_renamed");
                if (outputStreamOpenOutputStream == null) {
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            outputStreamOpenOutputStream.close();
                        } catch (java.io.IOException e_renamed) {
                            e_renamed.printStackTrace();
                        }
                    }
                    return false;
                }
                outputStreamOpenOutputStream.write(bArr);
                outputStreamOpenOutputStream.flush();
                if (outputStreamOpenOutputStream != null) {
                    try {
                        outputStreamOpenOutputStream.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return true;
            } catch (java.io.IOException e3) {
                e3.printStackTrace();
                if (outputStreamOpenOutputStream != null) {
                    try {
                        outputStreamOpenOutputStream.close();
                    } catch (java.io.IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return false;
            }
        } catch (java.lang.Throwable th) {
            if (outputStreamOpenOutputStream != null) {
                try {
                    outputStreamOpenOutputStream.close();
                } catch (java.io.IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static void b_renamed(android.net.Uri uri, com.oplus.camera.Storage.CameraPicture cameraPicture) throws java.io.IOException {
        com.oplus.exif.OplusExifTag oplusExifTagBuildTag;
        if (cameraPicture == null || uri == null) {
            return;
        }
        if (!android.text.TextUtils.isEmpty(cameraPicture.G_renamed) || cameraPicture.R_renamed) {
            java.io.OutputStream outputStreamOpenOutputStream = null;
            try {
                try {
                    try {
                        com.oplus.exif.OplusExifInterface oplusExifInterface = new com.oplus.exif.OplusExifInterface();
                        if (cameraPicture.e_renamed != null) {
                            oplusExifInterface.readExif(cameraPicture.e_renamed);
                        }
                        com.oplus.exif.OplusExifTag tag = oplusExifInterface.getTag(com.oplus.exif.OplusExifInterface.TAG_USER_COMMENT);
                        if (android.text.TextUtils.isEmpty(cameraPicture.G_renamed)) {
                            oplusExifTagBuildTag = null;
                        } else {
                            oplusExifTagBuildTag = oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_MAKER_NOTE, cameraPicture.G_renamed);
                            oplusExifInterface.setTag(oplusExifTagBuildTag);
                        }
                        if (cameraPicture.R_renamed && tag == null) {
                            tag = oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_USER_COMMENT, com.oplus.exif.OplusExifTag.EXIF_TAG_PREFIX.concat(java.lang.String.valueOf(8192)));
                            oplusExifInterface.setTag(tag);
                        }
                        if (oplusExifTagBuildTag == null && tag == null) {
                            return;
                        }
                        outputStreamOpenOutputStream = cameraPicture.f4066a.openOutputStream(uri);
                        oplusExifInterface.writeExif(cameraPicture.e_renamed, outputStreamOpenOutputStream);
                        if (outputStreamOpenOutputStream != null) {
                            outputStreamOpenOutputStream.close();
                        }
                    } catch (java.io.IOException e_renamed) {
                        e_renamed.printStackTrace();
                    }
                } catch (java.io.IOException e2) {
                    e2.printStackTrace();
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.close();
                    }
                }
            } catch (java.lang.Throwable th) {
                if (outputStreamOpenOutputStream != null) {
                    try {
                        outputStreamOpenOutputStream.close();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public static boolean a_renamed(boolean z2) {
        java.lang.String internalSdState = com.oplus.os.OplusUsbEnvironment.getInternalSdState(B_renamed);
        com.oplus.camera.e_renamed.a_renamed("Storage", "hasInternalStorage, requireWriteAccess: " + z2 + ", state: " + internalSdState);
        if (!"mounted".equals(internalSdState)) {
            return !z2 && "mounted_ro".equals(internalSdState);
        }
        if (z2) {
            return i_renamed();
        }
        return true;
    }

    private static boolean i_renamed() {
        java.lang.String str = com.oplus.os.OplusUsbEnvironment.getInternalSdDirectory(B_renamed).toString() + "/DCIM/Camera";
        java.io.File file = new java.io.File(str);
        if (file.exists() && !file.isDirectory()) {
            com.oplus.camera.e_renamed.a_renamed("Storage", "checkInternalFsWritable, result: " + file.renameTo(d_renamed(str)));
        }
        if (!file.exists() && !com.oplus.camera.q_renamed.a_renamed.f_renamed(file.getAbsolutePath())) {
            com.oplus.camera.e_renamed.a_renamed("Storage", "checkInternalFsWritable, directory.exists(): " + file.exists());
            if (!file.exists()) {
                return false;
            }
        }
        com.oplus.camera.e_renamed.a_renamed("Storage", "checkInternalFsWritable, writable: " + file.canWrite());
        return file.canWrite();
    }

    public static boolean b_renamed(boolean z2) {
        java.lang.String externalSdState = com.oplus.os.OplusUsbEnvironment.getExternalSdState(B_renamed);
        com.oplus.camera.e_renamed.a_renamed("Storage", "hasStorage, state: " + externalSdState + ", requireWriteAccess: " + z2);
        if (!"mounted".equals(externalSdState)) {
            return !z2 && "mounted_ro".equals(externalSdState);
        }
        if (!z2) {
            return true;
        }
        boolean zK = k_renamed();
        com.oplus.camera.e_renamed.a_renamed("Storage", "hasStorage, writable: " + zK);
        if (zK || "mounted_ro".equals(externalSdState) || j_renamed()) {
            return zK;
        }
        return true;
    }

    public static boolean d_renamed() {
        android.content.Context context = B_renamed;
        if (context == null) {
            return false;
        }
        java.lang.String externalSdState = com.oplus.os.OplusUsbEnvironment.getExternalSdState(context);
        com.oplus.camera.e_renamed.a_renamed("Storage", "hasSdCard(), state: " + externalSdState);
        return "mounted".equals(externalSdState);
    }

    private static boolean j_renamed() {
        java.io.File externalSdDirectory;
        if (!"mounted".equals(com.oplus.os.OplusUsbEnvironment.getExternalSdState(B_renamed)) || (externalSdDirectory = com.oplus.os.OplusUsbEnvironment.getExternalSdDirectory(B_renamed)) == null) {
            return false;
        }
        try {
            return new android.os.StatFs(externalSdDirectory.toString()).getAvailableBlocks() > 0;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return false;
        }
    }

    private static boolean k_renamed() {
        return com.oplus.camera.q_renamed.a_renamed.a_renamed();
    }

    private static java.io.File d_renamed(java.lang.String str) {
        java.lang.String str2 = str + java.lang.System.currentTimeMillis();
        java.io.File file = new java.io.File(str2);
        while (file.exists()) {
            file = new java.io.File(str2 + "_" + new java.util.Random().nextInt(100000));
        }
        com.oplus.camera.e_renamed.e_renamed("Storage", "getBackupFile, file: " + file.getPath());
        return file;
    }

    public static java.lang.String e_renamed() {
        return u_renamed;
    }

    public static void a_renamed(com.oplus.camera.ComboPreferences comboPreferences, java.lang.String str) {
        int iB;
        x_renamed = d_renamed();
        y_renamed = g_renamed() <= 8.0d;
        com.oplus.camera.e_renamed.a_renamed("Storage", "updateStoragePlace, before sStoragePlace: " + u_renamed + ", sStorageOverrideState: " + v_renamed + ", sbSmallEmmc: " + y_renamed + ", sbHasSDCard: " + x_renamed);
        v_renamed = 0;
        u_renamed = str;
        boolean zEquals = "off".equals(u_renamed);
        if (!zEquals && !f_renamed()) {
            v_renamed = 5;
            u_renamed = "invalid";
            w_renamed = 3;
            return;
        }
        w_renamed = b_renamed(u_renamed);
        int i2 = w_renamed;
        if (i2 == 1) {
            if (zEquals) {
                if (!x_renamed || 1 == (iB = b_renamed("on_renamed")) || 2 == iB) {
                    v_renamed = 1;
                } else if (iB == 0) {
                    v_renamed = 2;
                }
            } else {
                int iB2 = b_renamed("off");
                if (1 == iB2 || 2 == iB2) {
                    v_renamed = 4;
                } else if (iB2 == 0) {
                    v_renamed = 3;
                }
            }
            u_renamed = "invalid";
        } else if (i2 == 2 || i2 == 3) {
            v_renamed = 5;
            u_renamed = "invalid";
            w_renamed = 3;
        }
        com.oplus.camera.e_renamed.a_renamed("Storage", "updateStoragePlace, after sStoragePlace: " + u_renamed + ", sStorageOverrideState: " + v_renamed);
    }

    private static android.os.storage.StorageVolume a_renamed(android.os.storage.StorageManager storageManager, java.io.File file) {
        if (storageManager == null) {
            return null;
        }
        return storageManager.getStorageVolume(file);
    }

    public static boolean f_renamed() {
        int oplusReadOnlyType;
        android.os.storage.StorageVolume storageVolumeA = a_renamed((android.os.storage.StorageManager) B_renamed.getSystemService("storage"), com.oplus.os.OplusUsbEnvironment.getExternalSdDirectory(B_renamed));
        if (storageVolumeA == null) {
            com.oplus.camera.e_renamed.a_renamed("Storage", "checkExternalState, sdCardStorageVolumn is_renamed null");
            return false;
        }
        try {
            oplusReadOnlyType = com.oplus.compat.os.storage.StorageVolumeNative.getOplusReadOnlyType(storageVolumeA);
        } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e_renamed) {
            e_renamed.printStackTrace();
            oplusReadOnlyType = 0;
        }
        com.oplus.camera.e_renamed.a_renamed("Storage", "checkExternalState: readOnlyTypeState: " + oplusReadOnlyType);
        return (1 == oplusReadOnlyType || 2 == oplusReadOnlyType || -1 == oplusReadOnlyType) ? false : true;
    }

    public static int b_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("Storage", "getStorageStatus, storagePlace: " + str);
        if (str == null || "invalid".equals(str) || "uninitied".equals(str)) {
            return 2;
        }
        long jC = c_renamed(str);
        com.oplus.camera.e_renamed.a_renamed("Storage", "remaining: " + jC);
        if (-2 == jC) {
            return 3;
        }
        return 52428800 >= jC ? 1 : 0;
    }

    public static double g_renamed() {
        try {
            android.os.StatFs statFs = new android.os.StatFs(com.oplus.os.OplusUsbEnvironment.getInternalSdDirectory(B_renamed).toString());
            return (statFs.getBlockSizeLong() * statFs.getBlockCountLong()) / 1.073741824E9d;
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.d_renamed("Storage", "getInternalTotalStorage, Fail to access statfs", e_renamed);
            return -2.0d;
        }
    }

    public static long c_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("Storage", "getAvailableStorage, sContext: " + B_renamed + ", storagePlace: " + str);
        android.content.Context context = B_renamed;
        if (context == null) {
            return -2L;
        }
        boolean zB = false;
        java.lang.String string = null;
        java.io.File internalSdDirectory = com.oplus.os.OplusUsbEnvironment.getInternalSdDirectory(context);
        if ("on_renamed".equals(str)) {
            internalSdDirectory = com.oplus.os.OplusUsbEnvironment.getExternalSdDirectory(B_renamed);
        }
        if (internalSdDirectory == null) {
            com.oplus.camera.e_renamed.f_renamed("Storage", "getAvailableStorage, file is_renamed null");
            return -2L;
        }
        if ("off".equals(str)) {
            string = internalSdDirectory.toString();
            zB = a_renamed(true);
        } else if ("on_renamed".equals(str)) {
            string = internalSdDirectory.toString();
            zB = b_renamed(true);
        }
        if (!zB) {
            return -2L;
        }
        com.oplus.camera.e_renamed.a_renamed("Storage", "getAvailableStorage, dir: " + string);
        try {
            android.os.StatFs statFs = new android.os.StatFs(string);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.d_renamed("Storage", "Fail to access statfs", e_renamed);
            return -2L;
        }
    }

    private static void a_renamed(com.oplus.camera.Storage.CameraPicture cameraPicture, android.content.ContentValues contentValues, android.net.Uri uri) {
        if (cameraPicture == null || uri == null) {
            return;
        }
        long id_renamed = -1;
        try {
            android.net.Uri uriA = com.oplus.camera.util.d_renamed.a_renamed(A_renamed, contentValues);
            if (uriA != null) {
                id_renamed = android.content.ContentUris.parseId(uriA);
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.f_renamed("Storage", "newImageForGallery, " + e_renamed);
        }
        com.oplus.camera.e_renamed.b_renamed("Storage", "newImageForGallery, result:" + id_renamed);
    }

    private static void b_renamed(com.oplus.camera.Storage.CameraPicture cameraPicture, android.content.ContentValues contentValues, android.net.Uri uri) {
        if (cameraPicture == null || uri == null) {
            return;
        }
        int iA = -1;
        try {
            long id_renamed = android.content.ContentUris.parseId(uri);
            iA = com.oplus.camera.util.d_renamed.a_renamed(A_renamed, contentValues, "media_id=" + id_renamed, (java.lang.String[]) null);
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.f_renamed("Storage", "updateImageForGallery, " + e_renamed);
        }
        com.oplus.camera.e_renamed.b_renamed("Storage", "updateImageForGallery, result:" + iA);
    }

    private static void c_renamed(com.oplus.camera.Storage.CameraPicture cameraPicture, android.content.ContentValues contentValues, android.net.Uri uri) {
        if (cameraPicture == null || uri == null) {
            return;
        }
        long id_renamed = -1;
        try {
            android.net.Uri uriA = com.oplus.camera.util.d_renamed.a_renamed(A_renamed, contentValues);
            if (uriA != null) {
                id_renamed = android.content.ContentUris.parseId(uriA);
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.f_renamed("Storage", "addImageForGallery insert, e_renamed: " + e_renamed);
        }
        com.oplus.camera.e_renamed.b_renamed("Storage", "addImageForGallery insert, result: " + id_renamed);
        int iA = -1;
        try {
            long id2 = android.content.ContentUris.parseId(uri);
            iA = com.oplus.camera.util.d_renamed.a_renamed(A_renamed, contentValues, "media_id=" + id2, (java.lang.String[]) null);
        } catch (java.lang.Exception e2) {
            com.oplus.camera.e_renamed.f_renamed("Storage", "addImageForGallery update, e_renamed: " + e2);
        }
        com.oplus.camera.e_renamed.b_renamed("Storage", "addImageForGallery update, result: " + iA);
    }

    private static void g_renamed(com.oplus.camera.Storage.CameraPicture cameraPicture) {
        if (cameraPicture == null || cameraPicture.f4068c == null) {
            return;
        }
        int iA = -1;
        try {
            long id_renamed = android.content.ContentUris.parseId(cameraPicture.f4068c);
            iA = com.oplus.camera.util.d_renamed.a_renamed(A_renamed, "media_id=" + id_renamed, (java.lang.String[]) null);
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.f_renamed("Storage", "deleteImageForGallery, " + e_renamed);
        }
        com.oplus.camera.e_renamed.b_renamed("Storage", "deleteImageForGallery, result:" + iA);
    }

    /* JADX WARN: Can't_renamed wrap try/catch for region: R_renamed(11:24|(1:26)(11:28|(2:30|(1:43)(2:35|(1:37)(2:38|(1:42))))(15:44|(2:46|(1:59)(2:51|(1:53)(2:54|(1:58))))(2:60|(1:75)(2:65|(1:67)(2:68|(1:74))))|76|(1:78)(2:79|(1:83))|112|84|(1:89)(1:88)|90|110|91|(1:93)(2:94|(1:98))|99|106|(1:108)|109)|73|76|(0)(0)|112|84|(7:86|89|90|110|91|(0)(0)|99)(0)|106|(0)|109)|27|76|(0)(0)|112|84|(0)(0)|106|(0)|109) */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:103:0x03e7, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:104:0x03e8, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B_renamed:108:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:78:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:79:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:86:0x0328 A_renamed[Catch: Throwable -> 0x03e7, TryCatch #1 {Throwable -> 0x03e7, blocks: (B_renamed:84:0x031e, B_renamed:86:0x0328, B_renamed:90:0x0331), top: B_renamed:112:0x031e }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:89:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:93:0x03c6 A_renamed[Catch: Throwable -> 0x03e5, TryCatch #0 {Throwable -> 0x03e5, blocks: (B_renamed:91:0x0339, B_renamed:93:0x03c6, B_renamed:99:0x03e1, B_renamed:94:0x03cc, B_renamed:96:0x03d4, B_renamed:98:0x03dc), top: B_renamed:110:0x0339 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:94:0x03cc A_renamed[Catch: Throwable -> 0x03e5, TryCatch #0 {Throwable -> 0x03e5, blocks: (B_renamed:91:0x0339, B_renamed:93:0x03c6, B_renamed:99:0x03e1, B_renamed:94:0x03cc, B_renamed:96:0x03d4, B_renamed:98:0x03dc), top: B_renamed:110:0x0339 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.net.Uri b_renamed(final com.oplus.camera.Storage.CameraPicture r16) {
        /*
            Method dump skipped, instructions count: 1034
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.Storage.b_renamed(com.oplus.camera.Storage$CameraPicture):android.net.Uri");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:53:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c_renamed(com.oplus.camera.Storage.CameraPicture r11) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.Storage.c_renamed(com.oplus.camera.Storage$CameraPicture):void");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:101:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:104:0x0319 A_renamed[Catch: Throwable -> 0x0437, TryCatch #9 {Throwable -> 0x0437, blocks: (B_renamed:102:0x0315, B_renamed:104:0x0319, B_renamed:106:0x031f, B_renamed:109:0x033a, B_renamed:111:0x0344, B_renamed:115:0x034d, B_renamed:116:0x0369, B_renamed:118:0x0377, B_renamed:120:0x038a, B_renamed:121:0x039e, B_renamed:107:0x0331, B_renamed:122:0x03fc), top: B_renamed:174:0x0315 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:122:0x03fc A_renamed[Catch: Throwable -> 0x0437, TRY_LEAVE, TryCatch #9 {Throwable -> 0x0437, blocks: (B_renamed:102:0x0315, B_renamed:104:0x0319, B_renamed:106:0x031f, B_renamed:109:0x033a, B_renamed:111:0x0344, B_renamed:115:0x034d, B_renamed:116:0x0369, B_renamed:118:0x0377, B_renamed:120:0x038a, B_renamed:121:0x039e, B_renamed:107:0x0331, B_renamed:122:0x03fc), top: B_renamed:174:0x0315 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:79:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:82:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:83:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:90:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:95:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:98:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:99:0x02f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.oplus.camera.Storage.CameraPicture d_renamed(com.oplus.camera.Storage.CameraPicture r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.Storage.d_renamed(com.oplus.camera.Storage$CameraPicture):com.oplus.camera.Storage$CameraPicture");
    }

    private static void a_renamed(java.lang.String str, long j2) {
        com.oplus.camera.e_renamed.a_renamed("Storage", "changeLastModified, path: " + str + ", date: " + j2);
        try {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                file.setLastModified(j2);
            }
            com.oplus.camera.e_renamed.a_renamed("Storage", "changeLastModified, lastModified: " + file.lastModified());
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            com.oplus.camera.e_renamed.f_renamed("Storage", "changeLastModified, exception");
        }
        com.oplus.camera.e_renamed.a_renamed("Storage", "changeLastModified X_renamed, path: " + str + ", date: " + j2);
    }

    public static void a_renamed(android.net.Uri uri) {
        java.lang.String path;
        int iLastIndexOf;
        java.lang.String scheme = uri.getScheme();
        if (android.text.TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file") || (path = uri.getPath()) == null || (iLastIndexOf = path.lastIndexOf("/")) <= 0) {
            return;
        }
        java.lang.String strSubstring = path.substring(0, iLastIndexOf);
        if (android.text.TextUtils.isEmpty(strSubstring) || new java.io.File(strSubstring).exists()) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("Storage", "ensurePathExist folder: " + strSubstring + ", result: " + com.oplus.camera.q_renamed.a_renamed.f_renamed(strSubstring));
    }

    public static android.net.Uri c_renamed(boolean z2) {
        if (z2) {
            return android.provider.MediaStore.Images.Media.getContentUri(h_renamed());
        }
        return android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    public static android.net.Uri d_renamed(boolean z2) {
        if (z2) {
            return android.provider.MediaStore.Video.Media.getContentUri(h_renamed());
        }
        return android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }

    public static java.lang.String h_renamed() {
        android.os.storage.StorageVolume storageVolumeA = a_renamed((android.os.storage.StorageManager) B_renamed.getSystemService("storage"), com.oplus.os.OplusUsbEnvironment.getExternalSdDirectory(B_renamed));
        return storageVolumeA == null ? "" : storageVolumeA.getUuid().toLowerCase();
    }

    public static android.util.Size a_renamed(android.media.ExifInterface exifInterface) {
        if (exifInterface == null) {
            return null;
        }
        android.util.Size size = new android.util.Size(exifInterface.getAttributeInt("ImageWidth", 0), exifInterface.getAttributeInt("ImageLength", 0));
        if (size.getWidth() <= 0 || size.getHeight() <= 0) {
            return null;
        }
        return size;
    }

    public static void a_renamed(android.net.Uri uri, android.content.ContentResolver contentResolver) {
        if (uri == null || contentResolver == null) {
            return;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("media_id", java.lang.Long.valueOf(android.content.ContentUris.parseId(uri)));
        try {
            com.oplus.camera.util.d_renamed.a_renamed(android.net.Uri.parse("content://com.open.gallery.smart.provider/locked_pictures"), contentValues);
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.a_renamed("Storage", "addImageToLockScreenGallery, err: ", e_renamed);
        }
    }

    private static java.lang.String h_renamed(com.oplus.camera.Storage.CameraPicture cameraPicture) {
        java.lang.String str = java.io.File.separator;
        if (cameraPicture == null || cameraPicture.m_renamed <= -1) {
            return str;
        }
        return java.io.File.separator + cameraPicture.k_renamed.substring(cameraPicture.k_renamed.indexOf("Cshot")) + java.io.File.separator;
    }

    public static java.lang.String e_renamed(com.oplus.camera.Storage.CameraPicture cameraPicture) {
        if (cameraPicture != null && cameraPicture.m_renamed > -1) {
            return h_renamed + cameraPicture.k_renamed.substring(cameraPicture.k_renamed.indexOf("Cshot")) + java.io.File.separator;
        }
        return h_renamed;
    }

    private static void a_renamed(boolean z2, com.oplus.camera.Storage.CameraPicture cameraPicture, android.net.Uri uri) {
        com.oplus.exif.OplusExifInterface oplusExifInterfaceF;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.oplus.camera.k_renamed.b_renamed bVar = new com.oplus.camera.k_renamed.b_renamed(z2);
        if (cameraPicture.f4067b != null) {
            oplusExifInterfaceF = com.oplus.camera.k_renamed.a_renamed.a_renamed(cameraPicture.f4067b, cameraPicture.l_renamed);
        } else {
            oplusExifInterfaceF = f_renamed(cameraPicture);
        }
        com.oplus.exif.OplusExifInterface oplusExifInterface = oplusExifInterfaceF;
        if (z2) {
            com.oplus.camera.k_renamed.a_renamed.a_renamed(cameraPicture, B_renamed);
            bVar.a_renamed(cameraPicture.M_renamed, cameraPicture.t_renamed, 97, oplusExifInterface, cameraPicture.f4066a, uri);
            bVar.a_renamed();
        } else {
            bVar.a_renamed(cameraPicture.e_renamed, oplusExifInterface, cameraPicture.o_renamed, cameraPicture.p_renamed, cameraPicture.q_renamed, cameraPicture.r_renamed, 1, 97, cameraPicture.t_renamed, cameraPicture.f4066a, uri);
            bVar.a_renamed();
        }
        com.oplus.camera.e_renamed.b_renamed("Storage", "processHeicEncode, costTime: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public static class CameraPicture {
        public com.oplus.camera.ui.control.e_renamed A_renamed;

        /* renamed from: a_renamed, reason: collision with root package name */
        public android.content.ContentResolver f4066a = null;

        /* renamed from: b_renamed, reason: collision with root package name */
        public com.oplus.camera.aps.util.CameraApsExifData f4067b = null;

        /* renamed from: c_renamed, reason: collision with root package name */
        public android.net.Uri f4068c = null;
        public android.location.Location d_renamed = null;
        public byte[] e_renamed = null;
        public android.graphics.Bitmap f_renamed = null;
        public java.lang.String g_renamed = null;
        public java.lang.String mPath = null;
        public java.lang.String h_renamed = null;
        public java.lang.String i_renamed = null;
        public com.oplus.camera.e_renamed.c_renamed.a_renamed j_renamed = null;
        public java.lang.String k_renamed = null;
        public long l_renamed = 0;
        public long m_renamed = -1;
        public int n_renamed = -1;
        public int o_renamed = 0;
        public int p_renamed = 0;
        public int q_renamed = 0;
        public int r_renamed = 0;
        public int s_renamed = 0;
        public int t_renamed = 0;
        public int u_renamed = 0;
        public boolean v_renamed = false;
        public boolean w_renamed = false;
        public boolean x_renamed = false;
        public com.oplus.camera.ui.control.e_renamed.b_renamed y_renamed = null;
        public com.oplus.camera.ui.control.e_renamed.b_renamed z_renamed = null;
        public boolean B_renamed = false;
        public boolean C_renamed = false;
        public boolean D_renamed = false;
        public boolean E_renamed = false;
        public java.lang.String F_renamed = null;
        public java.lang.String G_renamed = null;
        public long H_renamed = 0;
        public long I_renamed = 0;
        public boolean J_renamed = false;
        public com.oplus.camera.a_renamed.e_renamed K_renamed = null;
        public android.graphics.Bitmap L_renamed = null;
        public android.graphics.Bitmap M_renamed = null;
        public com.oplus.camera.a_renamed.d_renamed N_renamed = null;
        public com.oplus.camera.screen.a_renamed O_renamed = null;
        public boolean P_renamed = false;
        public int Q_renamed = 0;
        public boolean R_renamed = false;
        public boolean S_renamed = false;
        public boolean T_renamed = false;
        public com.oplus.camera.ui.control.e_renamed.c_renamed U_renamed = null;
        public com.oplus.camera.capmode.f_renamed V_renamed = null;
        public boolean W_renamed = false;
        public boolean X_renamed = false;
        public boolean Y_renamed = false;

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("CameraPicture: [width: ");
            sb.append(this.o_renamed);
            sb.append(", height: ");
            sb.append(this.p_renamed);
            sb.append(", mStride: ");
            sb.append(this.q_renamed);
            sb.append(", mScanline: ");
            sb.append(this.r_renamed);
            sb.append(", jpegName: ");
            sb.append(this.mPath);
            sb.append(", mBurstShotFlagId: ");
            sb.append(this.m_renamed);
            sb.append(", mCshotPath: ");
            sb.append(this.k_renamed);
            sb.append(", cameraId: ");
            sb.append(this.s_renamed);
            sb.append(", format: ");
            sb.append(this.h_renamed);
            sb.append(", mMarkerNote: ");
            sb.append(this.G_renamed);
            sb.append(", mRecBurstNum: ");
            sb.append(this.n_renamed);
            sb.append(", mTitle: ");
            sb.append(this.g_renamed);
            sb.append(", mDate: ");
            sb.append(this.l_renamed);
            sb.append(", mCapMode: ");
            sb.append(this.i_renamed);
            sb.append(", mbWriteExifByApp: ");
            sb.append(this.D_renamed);
            sb.append(", picture data: ");
            byte[] bArr = this.e_renamed;
            sb.append(bArr != null ? java.lang.Integer.valueOf(bArr.length) : null);
            sb.append(", mbNeedStoreImage: ");
            sb.append(this.v_renamed);
            sb.append(", uri: ");
            sb.append(this.f4068c);
            sb.append(", mbEncodeHeifByAps: ");
            sb.append(this.W_renamed);
            sb.append(", mbIsSuperTextOpen: ");
            sb.append(this.T_renamed);
            sb.append(", isHighPictureSize:");
            sb.append(this.X_renamed);
            sb.append("]");
            return sb.toString();
        }
    }
}
