package com.oplus.camera;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.location.Location;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Size;
import com.android.providers.downloads.Downloads;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.util.CameraApsExifData;
import com.oplus.camera.capmode.ContentOperatedCallback;
import com.oplus.camera.p136a.PictureTakenCallback;
import com.oplus.camera.p136a.SuperTextResultProcessor;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p144g.C2735b;
import com.oplus.camera.p152k.HeicProcessUtil;
import com.oplus.camera.p152k.HeicProcessor;
import com.oplus.camera.p153l.RegionCommonFeatureAdapter;
import com.oplus.camera.p160q.DocumentUtil;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.screen.GalleryPreviewUpdateCallback;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.util.ContentProviderUtil;
import com.oplus.camera.util.Util;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p187os.storage.StorageVolumeNative;
import com.oplus.exif.OplusExifInterface;
import com.oplus.exif.OplusExifTag;
import com.oplus.p195os.OplusUsbEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class Storage implements CameraConstant {

    /* renamed from: B */
    private static Context f12078B;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static final String f12081g = Environment.DIRECTORY_DCIM;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static final String f12082h = f12081g + File.separator + "Camera" + File.separator;

    /* renamed from: OplusGLSurfaceView_13 */
    public static String f12083i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    public static String f12084j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    public static String f12085k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    public static String f12086l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    public static String f12087m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    public static String f12088n = null;

    /* renamed from: o */
    public static String f12089o = null;

    /* renamed from: p */
    public static String f12090p = null;

    /* renamed from: q */
    public static String f12091q = null;

    /* renamed from: r */
    public static String f12092r = null;

    /* renamed from: s */
    public static String f12093s = null;

    /* renamed from: t */
    public static String f12094t = null;

    /* renamed from: u */
    public static String f12095u = "uninitied";

    /* renamed from: v */
    public static int f12096v = 0;

    /* renamed from: w */
    public static int f12097w = 0;

    /* renamed from: x */
    public static boolean f12098x = false;

    /* renamed from: y */
    public static boolean f12099y = false;

    /* renamed from: z */
    private static final String f12100z = "image/" + ".jpeg".substring(1);

    /* renamed from: A */
    private static final Uri f12077A = Uri.parse("content://com.open.gallery.smart.provider").buildUpon().appendPath("fast_captures").build();

    /* renamed from: C */
    private static String f12079C = null;

    /* renamed from: D */
    private static boolean f12080D = false;

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m11111a(Context context) {
        CameraLog.m12959b("Storage", "initializeStoragePath()");
        m11125b(context);
        m11131c(context);
        f12089o = OplusUsbEnvironment.getInternalSdDirectory(context).getAbsolutePath() + File.separator + context.getResources().getString(R.string.camera_image_bucket_name);
        f12091q = OplusUsbEnvironment.getInternalSdDirectory(context).getAbsolutePath() + File.separator + context.getResources().getString(R.string.camera_video_bucket_name);
        f12093s = Util.m24172E(context).getAbsolutePath();
        if (f12080D) {
            f12094t = context.getCacheDir().getAbsolutePath() + File.separator + context.getResources().getString(R.string.camera_thumbnail_bucket_name);
        } else {
            f12094t = OplusUsbEnvironment.getInternalSdDirectory(context).getAbsolutePath() + File.separator + context.getResources().getString(R.string.camera_post_bucket_name);
        }
        f12088n = RegionCommonFeatureAdapter.m14523a(f12089o);
        f12090p = RegionCommonFeatureAdapter.m14523a(f12091q);
        f12092r = RegionCommonFeatureAdapter.m14523a(f12093s);
        f12078B = context;
        f12099y = m11143g() <= 8.0d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m11125b(Context context) {
        File externalSdDirectory = OplusUsbEnvironment.getExternalSdDirectory(context);
        if (externalSdDirectory != null) {
            String absolutePath = externalSdDirectory.getAbsolutePath();
            CameraLog.m12959b("Storage", "initializeExternalSdBucketName, externalSdPath: " + absolutePath);
            String str = f12084j;
            if (str == null || !str.startsWith(absolutePath)) {
                f12084j = externalSdDirectory.getAbsolutePath() + File.separator + context.getResources().getString(R.string.camera_image_bucket_name);
                f12086l = externalSdDirectory.getAbsolutePath() + File.separator + context.getResources().getString(R.string.camera_video_bucket_name);
                f12083i = RegionCommonFeatureAdapter.m14523a(f12084j);
                f12085k = RegionCommonFeatureAdapter.m14523a(f12086l);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m11131c(Context context) {
        boolean z = false;
        List<ResolveInfo> listQueryIntentActivities = context.getApplicationContext().getPackageManager().queryIntentActivities(new Intent("com.oplusos.gallery3d.action.fastcapture.sandbox"), 0);
        if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
            z = true;
        }
        f12080D = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static CameraPicture m11108a(CameraPicture cameraPicture) {
        String str;
        String str2;
        String str3;
        Uri uriM24532a;
        CameraLog.m12959b("Storage", "addImage, " + cameraPicture);
        Uri uri = null;
        if (cameraPicture.f12141n > -1 && -1 == cameraPicture.f12140m) {
            return null;
        }
        String strM24246a = cameraPicture.f12134g != null ? cameraPicture.f12134g : Util.m24246a(cameraPicture.f12139l);
        if ("off".equals(f12095u)) {
            str = f12089o;
        } else {
            str = f12084j;
        }
        if (cameraPicture.f12135h == null || CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG.equalsIgnoreCase(cameraPicture.f12135h)) {
            str2 = ".jpg";
        } else if ("raw".equalsIgnoreCase(cameraPicture.f12135h)) {
            str2 = ".dng";
        } else {
            if (!"heic_8bits".equalsIgnoreCase(cameraPicture.f12135h) && !"heic_10bits".equalsIgnoreCase(cameraPicture.f12135h)) {
                return null;
            }
            str2 = ".heic";
        }
        if (cameraPicture.f12140m > -1) {
            str3 = cameraPicture.f12138k + File.separator + strM24246a + str2;
            m11117a(cameraPicture.f12138k);
        } else {
            str3 = str + File.separator + strM24246a + str2;
        }
        if ("raw".equalsIgnoreCase(cameraPicture.f12135h)) {
            f12079C = strM24246a;
        } else if (f12079C != null && cameraPicture.f12134g == null) {
            str3 = str + File.separator + f12079C + str2;
            f12079C = null;
        }
        if ("raw".equalsIgnoreCase(cameraPicture.f12135h) && cameraPicture.f12136i.equals(ApsConstant.CAPTURE_MODE_NIGHT)) {
            CameraLog.m12954a("Storage", "addImage, nightNode Raw return");
            return null;
        }
        ContentValues contentValues = new ContentValues(12);
        contentValues.put("title", strM24246a);
        contentValues.put("_display_name", strM24246a + str2);
        contentValues.put("datetaken", Long.valueOf(cameraPicture.f12139l));
        if ("raw".equals(cameraPicture.f12135h)) {
            contentValues.put("mime_type", "image/x-adobe-dng");
        } else if (CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG.equals(cameraPicture.f12135h)) {
            contentValues.put("mime_type", "image/jpeg");
        } else if ("heic_8bits".equals(cameraPicture.f12135h) || "heic_10bits".equals(cameraPicture.f12135h)) {
            contentValues.put("mime_type", "image/heic");
            contentValues.put(Downloads.Impl._DATA, str3);
        }
        contentValues.put("orientation", Integer.valueOf(cameraPicture.f12147t));
        contentValues.put("_size", Integer.valueOf((int) new File(str3).length()));
        contentValues.put("relative_path", m11140e(cameraPicture));
        boolean z = false;
        try {
            if (cameraPicture.f12125W && ("heic_8bits".equals(cameraPicture.f12135h) || "heic_10bits".equals(cameraPicture.f12135h))) {
                uriM24532a = cameraPicture.f12130c;
            } else {
                uriM24532a = ContentProviderUtil.m24532a(m11130c("on".equals(f12095u) && m11138d()), contentValues);
            }
            uri = uriM24532a;
            CameraLog.m12954a("Storage", "addImage, insertImage, uri: " + uri);
            contentValues.put(Downloads.Impl._DATA, str3);
            contentValues.put("media_id", Long.valueOf(ContentUris.parseId(uri)));
            m11133c(cameraPicture, contentValues, uri);
            if (cameraPicture.f12106D) {
                if ("heic_8bits".equalsIgnoreCase(cameraPicture.f12135h) && !cameraPicture.f12125W) {
                    m11119a(true, cameraPicture, uri);
                } else if ("heic_10bits".equalsIgnoreCase(cameraPicture.f12135h) && !cameraPicture.f12125W) {
                    m11119a(false, cameraPicture, uri);
                } else if (cameraPicture.f12132e != null) {
                    m11114a(uri, cameraPicture);
                }
            } else if (!"heic_8bits".equalsIgnoreCase(cameraPicture.f12135h) && !"heic_10bits".equalsIgnoreCase(cameraPicture.f12135h)) {
                CameraLog.m12959b("Storage", "addImage, path: " + str3);
                m11120a(uri, cameraPicture.f12128a, cameraPicture.f12132e);
                m11126b(uri, cameraPicture);
            }
            if (cameraPicture.f12107E && cameraPicture.f12140m == -1) {
                m11113a(uri, Util.m24472l().getContentResolver());
                if (cameraPicture.f12124V != null) {
                    cameraPicture.f12124V.mo10440a();
                }
            }
        } catch (Throwable th) {
            CameraLog.m12965d("Storage", "Failed to write MediaStore.", th);
        }
        cameraPicture.f12130c = uri;
        cameraPicture.mPath = str3;
        cameraPicture.f12104B = true;
        if (".jpg".equals(str2) && (cameraPicture.f12141n == -1 || cameraPicture.f12141n == 1)) {
            z = true;
        }
        cameraPicture.f12105C = z;
        return cameraPicture;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static OplusExifInterface m11141f(CameraPicture cameraPicture) {
        OplusExifInterface oplusExifInterface = new OplusExifInterface();
        try {
            oplusExifInterface.readExif(cameraPicture.f12132e);
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_USER_COMMENT, OplusExifTag.EXIF_TAG_PREFIX.concat(String.valueOf(C2735b.m13773a(cameraPicture.f12136i, cameraPicture.f12146s)))));
        oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_ORIENTATION, Integer.valueOf(cameraPicture.f12147t)));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy:MM:dd", Locale.US);
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        simpleDateFormat.setTimeZone(Calendar.getInstance().getTimeZone());
        oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_DATE_TIME, simpleDateFormat.format(Long.valueOf(cameraPicture.f12139l))));
        oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_DATE_TIME_ORIGINAL, simpleDateFormat.format(Long.valueOf(cameraPicture.f12139l))));
        ZonedDateTime zonedDateTimeOfInstant = ZonedDateTime.ofInstant(Instant.ofEpochMilli(cameraPicture.f12139l), ZoneId.systemDefault());
        oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_SUB_SEC_TIME_ORIGINAL, DateTimeFormatter.ofPattern("SSS").format(zonedDateTimeOfInstant)));
        oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_OFFSET_TIME_ORIGINAL, 2, DateTimeFormatter.ofPattern("XXX").format(zonedDateTimeOfInstant)));
        oplusExifInterface.addGpsDateTimeStampTag(cameraPicture.f12139l);
        oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_GPS_DATE_STAMP, simpleDateFormat2.format(Long.valueOf(cameraPicture.f12139l))));
        if (cameraPicture.f12131d != null) {
            oplusExifInterface.addGpsTags(cameraPicture.f12131d.getLatitude(), cameraPicture.f12131d.getLongitude());
        }
        return oplusExifInterface;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m11114a(Uri uri, CameraPicture cameraPicture) throws IOException {
        OplusExifInterface oplusExifInterfaceM11141f = m11141f(cameraPicture);
        OutputStream outputStreamOpenOutputStream = null;
        try {
            try {
                try {
                    outputStreamOpenOutputStream = cameraPicture.f12128a.openOutputStream(uri);
                    if (outputStreamOpenOutputStream != null) {
                        oplusExifInterfaceM11141f.writeExif(cameraPicture.f12132e, outputStreamOpenOutputStream);
                    }
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.close();
                    }
                } catch (IOException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.close();
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            if (outputStreamOpenOutputStream != null) {
                try {
                    outputStreamOpenOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m11110a(String str, String str2) {
        String str3;
        if ("off".equals(f12095u)) {
            str3 = f12089o;
        } else {
            str3 = f12084j;
        }
        if (!"".equals(str2)) {
            return str3 + '/' + str + "." + str2;
        }
        return str3 + "/Cshot/" + str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m11109a() {
        return f12093s;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m11124b() {
        return f12094t;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m11134c() {
        return f12080D;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m11117a(String str) {
        if (f12080D || new File(str).exists()) {
            return;
        }
        DocumentUtil.m16210f(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m11120a(Uri uri, ContentResolver contentResolver, byte[] bArr) throws IOException {
        if (bArr == null) {
            return false;
        }
        OutputStream outputStreamOpenOutputStream = null;
        try {
            try {
                outputStreamOpenOutputStream = contentResolver.openOutputStream(uri, "w");
                if (outputStreamOpenOutputStream == null) {
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            outputStreamOpenOutputStream.close();
                        } catch (IOException COUIBaseListPopupWindow_8) {
                            COUIBaseListPopupWindow_8.printStackTrace();
                        }
                    }
                    return false;
                }
                outputStreamOpenOutputStream.write(bArr);
                outputStreamOpenOutputStream.flush();
                if (outputStreamOpenOutputStream != null) {
                    try {
                        outputStreamOpenOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return true;
            } catch (IOException e3) {
                e3.printStackTrace();
                if (outputStreamOpenOutputStream != null) {
                    try {
                        outputStreamOpenOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (outputStreamOpenOutputStream != null) {
                try {
                    outputStreamOpenOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m11126b(Uri uri, CameraPicture cameraPicture) throws IOException {
        OplusExifTag oplusExifTagBuildTag;
        if (cameraPicture == null || uri == null) {
            return;
        }
        if (!TextUtils.isEmpty(cameraPicture.f12109G) || cameraPicture.f12120R) {
            OutputStream outputStreamOpenOutputStream = null;
            try {
                try {
                    try {
                        OplusExifInterface oplusExifInterface = new OplusExifInterface();
                        if (cameraPicture.f12132e != null) {
                            oplusExifInterface.readExif(cameraPicture.f12132e);
                        }
                        OplusExifTag tag = oplusExifInterface.getTag(OplusExifInterface.TAG_USER_COMMENT);
                        if (TextUtils.isEmpty(cameraPicture.f12109G)) {
                            oplusExifTagBuildTag = null;
                        } else {
                            oplusExifTagBuildTag = oplusExifInterface.buildTag(OplusExifInterface.TAG_MAKER_NOTE, cameraPicture.f12109G);
                            oplusExifInterface.setTag(oplusExifTagBuildTag);
                        }
                        if (cameraPicture.f12120R && tag == null) {
                            tag = oplusExifInterface.buildTag(OplusExifInterface.TAG_USER_COMMENT, OplusExifTag.EXIF_TAG_PREFIX.concat(String.valueOf(8192)));
                            oplusExifInterface.setTag(tag);
                        }
                        if (oplusExifTagBuildTag == null && tag == null) {
                            return;
                        }
                        outputStreamOpenOutputStream = cameraPicture.f12128a.openOutputStream(uri);
                        oplusExifInterface.writeExif(cameraPicture.f12132e, outputStreamOpenOutputStream);
                        if (outputStreamOpenOutputStream != null) {
                            outputStreamOpenOutputStream.close();
                        }
                    } catch (IOException COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.close();
                    }
                }
            } catch (Throwable th) {
                if (outputStreamOpenOutputStream != null) {
                    try {
                        outputStreamOpenOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m11121a(boolean z) {
        String internalSdState = OplusUsbEnvironment.getInternalSdState(f12078B);
        CameraLog.m12954a("Storage", "hasInternalStorage, requireWriteAccess: " + z + ", state: " + internalSdState);
        if (!"mounted".equals(internalSdState)) {
            return !z && "mounted_ro".equals(internalSdState);
        }
        if (z) {
            return m11147i();
        }
        return true;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private static boolean m11147i() {
        String str = OplusUsbEnvironment.getInternalSdDirectory(f12078B).toString() + "/DCIM/Camera";
        File file = new File(str);
        if (file.exists() && !file.isDirectory()) {
            CameraLog.m12954a("Storage", "checkInternalFsWritable, result: " + file.renameTo(m11137d(str)));
        }
        if (!file.exists() && !DocumentUtil.m16210f(file.getAbsolutePath())) {
            CameraLog.m12954a("Storage", "checkInternalFsWritable, directory.exists(): " + file.exists());
            if (!file.exists()) {
                return false;
            }
        }
        CameraLog.m12954a("Storage", "checkInternalFsWritable, writable: " + file.canWrite());
        return file.canWrite();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m11128b(boolean z) {
        String externalSdState = OplusUsbEnvironment.getExternalSdState(f12078B);
        CameraLog.m12954a("Storage", "hasStorage, state: " + externalSdState + ", requireWriteAccess: " + z);
        if (!"mounted".equals(externalSdState)) {
            return !z && "mounted_ro".equals(externalSdState);
        }
        if (!z) {
            return true;
        }
        boolean zM11149k = m11149k();
        CameraLog.m12954a("Storage", "hasStorage, writable: " + zM11149k);
        if (zM11149k || "mounted_ro".equals(externalSdState) || m11148j()) {
            return zM11149k;
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static boolean m11138d() {
        Context context = f12078B;
        if (context == null) {
            return false;
        }
        String externalSdState = OplusUsbEnvironment.getExternalSdState(context);
        CameraLog.m12954a("Storage", "hasSdCard(), state: " + externalSdState);
        return "mounted".equals(externalSdState);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private static boolean m11148j() {
        File externalSdDirectory;
        if (!"mounted".equals(OplusUsbEnvironment.getExternalSdState(f12078B)) || (externalSdDirectory = OplusUsbEnvironment.getExternalSdDirectory(f12078B)) == null) {
            return false;
        }
        try {
            return new StatFs(externalSdDirectory.toString()).getAvailableBlocks() > 0;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private static boolean m11149k() {
        return DocumentUtil.m16196a();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static File m11137d(String str) {
        String str2 = str + System.currentTimeMillis();
        File file = new File(str2);
        while (file.exists()) {
            file = new File(str2 + "_" + new Random().nextInt(100000));
        }
        CameraLog.m12966e("Storage", "getBackupFile, file: " + file.getPath());
        return file;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static String m11139e() {
        return f12095u;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m11115a(ComboPreferences comboPreferences, String str) {
        int iM11122b;
        f12098x = m11138d();
        f12099y = m11143g() <= 8.0d;
        CameraLog.m12954a("Storage", "updateStoragePlace, before sStoragePlace: " + f12095u + ", sStorageOverrideState: " + f12096v + ", sbSmallEmmc: " + f12099y + ", sbHasSDCard: " + f12098x);
        f12096v = 0;
        f12095u = str;
        boolean zEquals = "off".equals(f12095u);
        if (!zEquals && !m11142f()) {
            f12096v = 5;
            f12095u = "invalid";
            f12097w = 3;
            return;
        }
        f12097w = m11122b(f12095u);
        int OplusGLSurfaceView_13 = f12097w;
        if (OplusGLSurfaceView_13 == 1) {
            if (zEquals) {
                if (!f12098x || 1 == (iM11122b = m11122b("on")) || 2 == iM11122b) {
                    f12096v = 1;
                } else if (iM11122b == 0) {
                    f12096v = 2;
                }
            } else {
                int iM11122b2 = m11122b("off");
                if (1 == iM11122b2 || 2 == iM11122b2) {
                    f12096v = 4;
                } else if (iM11122b2 == 0) {
                    f12096v = 3;
                }
            }
            f12095u = "invalid";
        } else if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3) {
            f12096v = 5;
            f12095u = "invalid";
            f12097w = 3;
        }
        CameraLog.m12954a("Storage", "updateStoragePlace, after sStoragePlace: " + f12095u + ", sStorageOverrideState: " + f12096v);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static StorageVolume m11106a(StorageManager storageManager, File file) {
        if (storageManager == null) {
            return null;
        }
        return storageManager.getStorageVolume(file);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static boolean m11142f() {
        int oplusReadOnlyType;
        StorageVolume storageVolumeM11106a = m11106a((StorageManager) f12078B.getSystemService("storage"), OplusUsbEnvironment.getExternalSdDirectory(f12078B));
        if (storageVolumeM11106a == null) {
            CameraLog.m12954a("Storage", "checkExternalState, sdCardStorageVolumn is null");
            return false;
        }
        try {
            oplusReadOnlyType = StorageVolumeNative.getOplusReadOnlyType(storageVolumeM11106a);
        } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            oplusReadOnlyType = 0;
        }
        CameraLog.m12954a("Storage", "checkExternalState: readOnlyTypeState: " + oplusReadOnlyType);
        return (1 == oplusReadOnlyType || 2 == oplusReadOnlyType || -1 == oplusReadOnlyType) ? false : true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m11122b(String str) {
        CameraLog.m12954a("Storage", "getStorageStatus, storagePlace: " + str);
        if (str == null || "invalid".equals(str) || "uninitied".equals(str)) {
            return 2;
        }
        long jM11129c = m11129c(str);
        CameraLog.m12954a("Storage", "remaining: " + jM11129c);
        if (-2 == jM11129c) {
            return 3;
        }
        return 52428800 >= jM11129c ? 1 : 0;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static double m11143g() {
        try {
            StatFs statFs = new StatFs(OplusUsbEnvironment.getInternalSdDirectory(f12078B).toString());
            return (statFs.getBlockSizeLong() * statFs.getBlockCountLong()) / 1.073741824E9d;
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("Storage", "getInternalTotalStorage, Fail to access statfs", COUIBaseListPopupWindow_8);
            return -2.0d;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static long m11129c(String str) {
        CameraLog.m12954a("Storage", "getAvailableStorage, sContext: " + f12078B + ", storagePlace: " + str);
        Context context = f12078B;
        if (context == null) {
            return -2L;
        }
        boolean zM11128b = false;
        String string = null;
        File internalSdDirectory = OplusUsbEnvironment.getInternalSdDirectory(context);
        if ("on".equals(str)) {
            internalSdDirectory = OplusUsbEnvironment.getExternalSdDirectory(f12078B);
        }
        if (internalSdDirectory == null) {
            CameraLog.m12967f("Storage", "getAvailableStorage, file is null");
            return -2L;
        }
        if ("off".equals(str)) {
            string = internalSdDirectory.toString();
            zM11128b = m11121a(true);
        } else if ("on".equals(str)) {
            string = internalSdDirectory.toString();
            zM11128b = m11128b(true);
        }
        if (!zM11128b) {
            return -2L;
        }
        CameraLog.m12954a("Storage", "getAvailableStorage, dir: " + string);
        try {
            StatFs statFs = new StatFs(string);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("Storage", "Fail to access statfs", COUIBaseListPopupWindow_8);
            return -2L;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m11116a(CameraPicture cameraPicture, ContentValues contentValues, Uri uri) {
        if (cameraPicture == null || uri == null) {
            return;
        }
        long id_renamed = -1;
        try {
            Uri uriM24532a = ContentProviderUtil.m24532a(f12077A, contentValues);
            if (uriM24532a != null) {
                id_renamed = ContentUris.parseId(uriM24532a);
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("Storage", "newImageForGallery, " + COUIBaseListPopupWindow_8);
        }
        CameraLog.m12959b("Storage", "newImageForGallery, result:" + id_renamed);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m11127b(CameraPicture cameraPicture, ContentValues contentValues, Uri uri) {
        if (cameraPicture == null || uri == null) {
            return;
        }
        int iM24527a = -1;
        try {
            long id_renamed = ContentUris.parseId(uri);
            iM24527a = ContentProviderUtil.m24527a(f12077A, contentValues, "media_id=" + id_renamed, (String[]) null);
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("Storage", "updateImageForGallery, " + COUIBaseListPopupWindow_8);
        }
        CameraLog.m12959b("Storage", "updateImageForGallery, result:" + iM24527a);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static void m11133c(CameraPicture cameraPicture, ContentValues contentValues, Uri uri) {
        if (cameraPicture == null || uri == null) {
            return;
        }
        long id_renamed = -1;
        try {
            Uri uriM24532a = ContentProviderUtil.m24532a(f12077A, contentValues);
            if (uriM24532a != null) {
                id_renamed = ContentUris.parseId(uriM24532a);
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("Storage", "addImageForGallery insert, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
        }
        CameraLog.m12959b("Storage", "addImageForGallery insert, result: " + id_renamed);
        int iM24527a = -1;
        try {
            long id2 = ContentUris.parseId(uri);
            iM24527a = ContentProviderUtil.m24527a(f12077A, contentValues, "media_id=" + id2, (String[]) null);
        } catch (Exception e2) {
            CameraLog.m12967f("Storage", "addImageForGallery update, COUIBaseListPopupWindow_8: " + e2);
        }
        CameraLog.m12959b("Storage", "addImageForGallery update, result: " + iM24527a);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static void m11144g(CameraPicture cameraPicture) {
        if (cameraPicture == null || cameraPicture.f12130c == null) {
            return;
        }
        int iM24528a = -1;
        try {
            long id_renamed = ContentUris.parseId(cameraPicture.f12130c);
            iM24528a = ContentProviderUtil.m24528a(f12077A, "media_id=" + id_renamed, (String[]) null);
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("Storage", "deleteImageForGallery, " + COUIBaseListPopupWindow_8);
        }
        CameraLog.m12959b("Storage", "deleteImageForGallery, result:" + iM24528a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:24|(1:26)(11:28|(2:30|(1:43)(2:35|(1:37)(2:38|(1:42))))(15:44|(2:46|(1:59)(2:51|(1:53)(2:54|(1:58))))(2:60|(1:75)(2:65|(1:67)(2:68|(1:74))))|76|(1:78)(2:79|(1:83))|112|84|(1:89)(1:88)|90|110|91|(1:93)(2:94|(1:98))|99|106|(1:108)|109)|73|76|(0)(0)|112|84|(7:86|89|90|110|91|(0)(0)|99)(0)|106|(0)|109)|27|76|(0)(0)|112|84|(0)(0)|106|(0)|109) */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x03e7, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x03e8, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0328 A[Catch: Throwable -> 0x03e7, TryCatch #1 {Throwable -> 0x03e7, blocks: (B:84:0x031e, B:86:0x0328, B:90:0x0331), top: B:112:0x031e }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03c6 A[Catch: Throwable -> 0x03e5, TryCatch #0 {Throwable -> 0x03e5, blocks: (B:91:0x0339, B:93:0x03c6, B:99:0x03e1, B:94:0x03cc, B:96:0x03d4, B:98:0x03dc), top: B:110:0x0339 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03cc A[Catch: Throwable -> 0x03e5, TryCatch #0 {Throwable -> 0x03e5, blocks: (B:91:0x0339, B:93:0x03c6, B:99:0x03e1, B:94:0x03cc, B:96:0x03d4, B:98:0x03dc), top: B:110:0x0339 }] */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.net.Uri m11123b(final com.oplus.camera.Storage.CameraPicture r16) {
        /*
            Method dump skipped, instructions count: 1034
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.Storage.m11123b(com.oplus.camera.Storage$CameraPicture):android.net.Uri");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x015b  */
    /* renamed from: IntrinsicsJvm.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m11132c(com.oplus.camera.Storage.CameraPicture r11) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.Storage.m11132c(com.oplus.camera.Storage$CameraPicture):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0319 A[Catch: Throwable -> 0x0437, TryCatch #9 {Throwable -> 0x0437, blocks: (B:102:0x0315, B:104:0x0319, B:106:0x031f, B:109:0x033a, B:111:0x0344, B:115:0x034d, B:116:0x0369, B:118:0x0377, B:120:0x038a, B:121:0x039e, B:107:0x0331, B:122:0x03fc), top: B:174:0x0315 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03fc A[Catch: Throwable -> 0x0437, TRY_LEAVE, TryCatch #9 {Throwable -> 0x0437, blocks: (B:102:0x0315, B:104:0x0319, B:106:0x031f, B:109:0x033a, B:111:0x0344, B:115:0x034d, B:116:0x0369, B:118:0x0377, B:120:0x038a, B:121:0x039e, B:107:0x0331, B:122:0x03fc), top: B:174:0x0315 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02f5  */
    /* renamed from: IntrinsicsJvm.kt_5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.oplus.camera.Storage.CameraPicture m11136d(com.oplus.camera.Storage.CameraPicture r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.Storage.m11136d(com.oplus.camera.Storage$CameraPicture):com.oplus.camera.Storage$CameraPicture");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m11118a(String str, long OplusGLSurfaceView_15) {
        CameraLog.m12954a("Storage", "changeLastModified, path: " + str + ", date: " + OplusGLSurfaceView_15);
        try {
            File file = new File(str);
            if (file.exists()) {
                file.setLastModified(OplusGLSurfaceView_15);
            }
            CameraLog.m12954a("Storage", "changeLastModified, lastModified: " + file.lastModified());
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            CameraLog.m12967f("Storage", "changeLastModified, exception");
        }
        CameraLog.m12954a("Storage", "changeLastModified X, path: " + str + ", date: " + OplusGLSurfaceView_15);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m11112a(Uri uri) {
        String path;
        int iLastIndexOf;
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file") || (path = uri.getPath()) == null || (iLastIndexOf = path.lastIndexOf("/")) <= 0) {
            return;
        }
        String strSubstring = path.substring(0, iLastIndexOf);
        if (TextUtils.isEmpty(strSubstring) || new File(strSubstring).exists()) {
            return;
        }
        CameraLog.m12954a("Storage", "ensurePathExist folder: " + strSubstring + ", result: " + DocumentUtil.m16210f(strSubstring));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static Uri m11130c(boolean z) {
        if (z) {
            return MediaStore.Images.Media.getContentUri(m11145h());
        }
        return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static Uri m11135d(boolean z) {
        if (z) {
            return MediaStore.Video.Media.getContentUri(m11145h());
        }
        return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static String m11145h() {
        StorageVolume storageVolumeM11106a = m11106a((StorageManager) f12078B.getSystemService("storage"), OplusUsbEnvironment.getExternalSdDirectory(f12078B));
        return storageVolumeM11106a == null ? "" : storageVolumeM11106a.getUuid().toLowerCase();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Size m11107a(ExifInterface exifInterface) {
        if (exifInterface == null) {
            return null;
        }
        Size size = new Size(exifInterface.getAttributeInt("ImageWidth", 0), exifInterface.getAttributeInt("ImageLength", 0));
        if (size.getWidth() <= 0 || size.getHeight() <= 0) {
            return null;
        }
        return size;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m11113a(Uri uri, ContentResolver contentResolver) {
        if (uri == null || contentResolver == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("media_id", Long.valueOf(ContentUris.parseId(uri)));
        try {
            ContentProviderUtil.m24532a(Uri.parse("content://com.open.gallery.smart.provider/locked_pictures"), contentValues);
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12956a("Storage", "addImageToLockScreenGallery, err: ", COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static String m11146h(CameraPicture cameraPicture) {
        String str = File.separator;
        if (cameraPicture == null || cameraPicture.f12140m <= -1) {
            return str;
        }
        return File.separator + cameraPicture.f12138k.substring(cameraPicture.f12138k.indexOf("Cshot")) + File.separator;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static String m11140e(CameraPicture cameraPicture) {
        if (cameraPicture != null && cameraPicture.f12140m > -1) {
            return f12082h + cameraPicture.f12138k.substring(cameraPicture.f12138k.indexOf("Cshot")) + File.separator;
        }
        return f12082h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m11119a(boolean z, CameraPicture cameraPicture, Uri uri) {
        OplusExifInterface oplusExifInterfaceM11141f;
        long jCurrentTimeMillis = System.currentTimeMillis();
        HeicProcessor c2789b = new HeicProcessor(z);
        if (cameraPicture.f12129b != null) {
            oplusExifInterfaceM11141f = HeicProcessUtil.m14498a(cameraPicture.f12129b, cameraPicture.f12139l);
        } else {
            oplusExifInterfaceM11141f = m11141f(cameraPicture);
        }
        OplusExifInterface oplusExifInterface = oplusExifInterfaceM11141f;
        if (z) {
            HeicProcessUtil.m14499a(cameraPicture, f12078B);
            c2789b.m14506a(cameraPicture.f12115M, cameraPicture.f12147t, 97, oplusExifInterface, cameraPicture.f12128a, uri);
            c2789b.m14505a();
        } else {
            c2789b.m14507a(cameraPicture.f12132e, oplusExifInterface, cameraPicture.f12142o, cameraPicture.f12143p, cameraPicture.f12144q, cameraPicture.f12145r, 1, 97, cameraPicture.f12147t, cameraPicture.f12128a, uri);
            c2789b.m14505a();
        }
        CameraLog.m12959b("Storage", "processHeicEncode, costTime: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public static class CameraPicture {

        /* renamed from: A */
        public Thumbnail f12103A;

        /* renamed from: PlatformImplementations.kt_3 */
        public ContentResolver f12128a = null;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public CameraApsExifData f12129b = null;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public Uri f12130c = null;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public Location f12131d = null;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public byte[] f12132e = null;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public Bitmap f12133f = null;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public String f12134g = null;
        public String mPath = null;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public String f12135h = null;

        /* renamed from: OplusGLSurfaceView_13 */
        public String f12136i = null;

        /* renamed from: OplusGLSurfaceView_15 */
        public CameraRequestTag.PlatformImplementations.kt_3 f12137j = null;

        /* renamed from: OplusGLSurfaceView_5 */
        public String f12138k = null;

        /* renamed from: OplusGLSurfaceView_14 */
        public long f12139l = 0;

        /* renamed from: OplusGLSurfaceView_6 */
        public long f12140m = -1;

        /* renamed from: OplusGLSurfaceView_11 */
        public int f12141n = -1;

        /* renamed from: o */
        public int f12142o = 0;

        /* renamed from: p */
        public int f12143p = 0;

        /* renamed from: q */
        public int f12144q = 0;

        /* renamed from: r */
        public int f12145r = 0;

        /* renamed from: s */
        public int f12146s = 0;

        /* renamed from: t */
        public int f12147t = 0;

        /* renamed from: u */
        public int f12148u = 0;

        /* renamed from: v */
        public boolean f12149v = false;

        /* renamed from: w */
        public boolean f12150w = false;

        /* renamed from: x */
        public boolean f12151x = false;

        /* renamed from: y */
        public Thumbnail.IntrinsicsJvm.kt_4 f12152y = null;

        /* renamed from: z */
        public Thumbnail.IntrinsicsJvm.kt_4 f12153z = null;

        /* renamed from: B */
        public boolean f12104B = false;

        /* renamed from: C */
        public boolean f12105C = false;

        /* renamed from: D */
        public boolean f12106D = false;

        /* renamed from: E */
        public boolean f12107E = false;

        /* renamed from: F */
        public String f12108F = null;

        /* renamed from: G */
        public String f12109G = null;

        /* renamed from: H */
        public long f12110H = 0;

        /* renamed from: I */
        public long f12111I = 0;

        /* renamed from: J */
        public boolean f12112J = false;

        /* renamed from: K */
        public SuperTextResultProcessor f12113K = null;

        /* renamed from: L */
        public Bitmap f12114L = null;

        /* renamed from: M */
        public Bitmap f12115M = null;

        /* renamed from: N */
        public PictureTakenCallback f12116N = null;

        /* renamed from: O */
        public GalleryPreviewUpdateCallback f12117O = null;

        /* renamed from: P */
        public boolean f12118P = false;

        /* renamed from: Q */
        public int f12119Q = 0;

        /* renamed from: R */
        public boolean f12120R = false;

        /* renamed from: S */
        public boolean f12121S = false;

        /* renamed from: T */
        public boolean f12122T = false;

        /* renamed from: U */
        public Thumbnail.IntrinsicsJvm.kt_3 f12123U = null;

        /* renamed from: V */
        public ContentOperatedCallback f12124V = null;

        /* renamed from: W */
        public boolean f12125W = false;

        /* renamed from: X */
        public boolean f12126X = false;

        /* renamed from: Y */
        public boolean f12127Y = false;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CameraPicture: [width: ");
            sb.append(this.f12142o);
            sb.append(", height: ");
            sb.append(this.f12143p);
            sb.append(", mStride: ");
            sb.append(this.f12144q);
            sb.append(", mScanline: ");
            sb.append(this.f12145r);
            sb.append(", jpegName: ");
            sb.append(this.mPath);
            sb.append(", mBurstShotFlagId: ");
            sb.append(this.f12140m);
            sb.append(", mCshotPath: ");
            sb.append(this.f12138k);
            sb.append(", cameraId: ");
            sb.append(this.f12146s);
            sb.append(", format: ");
            sb.append(this.f12135h);
            sb.append(", mMarkerNote: ");
            sb.append(this.f12109G);
            sb.append(", mRecBurstNum: ");
            sb.append(this.f12141n);
            sb.append(", mTitle: ");
            sb.append(this.f12134g);
            sb.append(", mDate: ");
            sb.append(this.f12139l);
            sb.append(", mCapMode: ");
            sb.append(this.f12136i);
            sb.append(", mbWriteExifByApp: ");
            sb.append(this.f12106D);
            sb.append(", picture data: ");
            byte[] bArr = this.f12132e;
            sb.append(bArr != null ? Integer.valueOf(bArr.length) : null);
            sb.append(", mbNeedStoreImage: ");
            sb.append(this.f12149v);
            sb.append(", uri: ");
            sb.append(this.f12130c);
            sb.append(", mbEncodeHeifByAps: ");
            sb.append(this.f12125W);
            sb.append(", mbIsSuperTextOpen: ");
            sb.append(this.f12122T);
            sb.append(", isHighPictureSize:");
            sb.append(this.f12126X);
            sb.append("]");
            return sb.toString();
        }
    }
}
