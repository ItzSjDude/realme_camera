package com.oplus.camera.sticker.download;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.camera.CameraLog;
import com.oplus.camera.sticker.StickerMediator;
import com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo;
import com.oplus.camera.sticker.data.BuildInSticker;
import com.oplus.camera.sticker.data.MultiStickerExtendedInfo;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.sticker.data.StickerItemWrapper;
import com.oplus.camera.sticker.p165a.StickerItemTableHelper;
import com.oplus.camera.sticker.p167c.FileUtils;
import com.oplus.camera.sticker.p167c.MD5Utils;
import com.oplus.camera.sticker.provider.FileProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: StickerInstaller.java */
/* renamed from: com.oplus.camera.sticker.download.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class StickerInstaller {
    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m16906a(Context context, BuildInSticker buildInSticker) {
        if (context == null || buildInSticker == null) {
            CameraLog.m12966e("StickerInstaller", "installBuildInSticker, parameter is null! context: " + context);
            return false;
        }
        CameraLog.m12959b("StickerInstaller", "installBuildInSticker, buildInSticker: " + buildInSticker);
        try {
            String strM16809a = FileUtils.m16809a(context, FileUtils.f16224l, buildInSticker.getStickerUUID());
            if (FileUtils.m16815a(context.getAssets().open(buildInSticker.getAssetThumbnailPath()), strM16809a, true, true)) {
                Uri uriM16977a = FileProvider.m16977a(context, "com.oplus.camera.providers.sticker.file.provider", new File(strM16809a));
                StickerItemWrapper stickerItemWrapperObtainStickerItem = buildInSticker.obtainStickerItem();
                stickerItemWrapperObtainStickerItem.setIsBuildIn(true);
                stickerItemWrapperObtainStickerItem.setThumbnailPath(strM16809a);
                stickerItemWrapperObtainStickerItem.setThumbnailFileUri(uriM16977a.toString());
                int materialType = stickerItemWrapperObtainStickerItem.getMaterialType();
                if (materialType == 0) {
                    return m16911b(context, stickerItemWrapperObtainStickerItem, buildInSticker.getAssetFilePath());
                }
                if (materialType == 1) {
                    return m16913c(context, stickerItemWrapperObtainStickerItem, buildInSticker.getAssetFilePath());
                }
                if (materialType == 2) {
                    return m16908a(context, stickerItemWrapperObtainStickerItem, buildInSticker.getAssetFilePath(), buildInSticker.getBackgroundColor());
                }
                CameraLog.m12966e("StickerInstaller", "installBuildInSticker, can not supported material type!");
            } else {
                CameraLog.m12966e("StickerInstaller", "installBuildInSticker, saveThumb fail!");
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("StickerInstaller", "installBuildInSticker, Exception: " + COUIBaseListPopupWindow_8);
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m16907a(Context context, StickerItemWrapper stickerItemWrapper, String str) {
        if (context == null || stickerItemWrapper == null) {
            CameraLog.m12966e("StickerInstaller", "installSticker, parameter is null! context: " + context);
            return false;
        }
        CameraLog.m12959b("StickerInstaller", "installSticker, srcFilePath: " + str + ", stickerItem: " + stickerItemWrapper);
        int materialType = stickerItemWrapper.getMaterialType();
        if (materialType == 0) {
            return m16911b(context, stickerItemWrapper, str);
        }
        if (materialType == 1) {
            return m16913c(context, stickerItemWrapper, str);
        }
        if (materialType == 2) {
            return m16908a(context, stickerItemWrapper, str, null);
        }
        CameraLog.m12966e("StickerInstaller", "installBuildInSticker, can not supported material type!");
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m16911b(Context context, StickerItemWrapper stickerItemWrapper, String str) throws Throwable {
        try {
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("StickerInstaller", "installNormalSticker exception COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
        }
        if (context == null || stickerItemWrapper == null) {
            CameraLog.m12966e("StickerInstaller", "installNormalSticker, null parameter! context: " + context);
            return false;
        }
        if (stickerItemWrapper.getMaterialType() != 0) {
            CameraLog.m12966e("StickerInstaller", "installNormalSticker, not PlatformImplementations.kt_3 normal type! item: " + stickerItemWrapper);
            return false;
        }
        String strM16809a = FileUtils.m16809a(context, FileUtils.f16220h, stickerItemWrapper.getStickerUUID());
        boolean zM16816a = true;
        if (!stickerItemWrapper.isRecycleBin()) {
            if (TextUtils.isEmpty(str)) {
                CameraLog.m12966e("StickerInstaller", "installNormalSticker, file path is empty!");
                return false;
            }
            if (stickerItemWrapper.isBuildIn() && str.startsWith("sticker/material")) {
                zM16816a = FileUtils.m16815a(context.getAssets().open(str), strM16809a, true, true);
            } else {
                zM16816a = FileUtils.m16816a(str, strM16809a);
                if (!zM16816a && !(zM16816a = MD5Utils.m16823a(strM16809a, stickerItemWrapper.getFileMd5()))) {
                    CameraLog.m12966e("StickerInstaller", "installNormalSticker, md5CheckSum error! stickerItem: " + stickerItemWrapper);
                }
            }
        }
        if (zM16816a) {
            stickerItemWrapper.setFileContentUri(FileProvider.m16977a(context, "com.oplus.camera.providers.sticker.file.provider", new File(strM16809a)).toString());
            stickerItemWrapper.setFilePath(strM16809a);
            stickerItemWrapper.setDownloadState(8);
            stickerItemWrapper.setNeedUpdate(false);
            if (!stickerItemWrapper.isBuildIn() && stickerItemWrapper.getDownloadTime() == 0) {
                stickerItemWrapper.setDownloadTime(System.currentTimeMillis());
            }
            return StickerItemTableHelper.m16758a(context, stickerItemWrapper);
        }
        CameraLog.m12966e("StickerInstaller", "installNormalSticker, save saveFile!");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0326 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0307 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: IntrinsicsJvm.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean m16913c(android.content.Context r13, com.oplus.camera.sticker.data.StickerItemWrapper r14, java.lang.String r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 854
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.download.StickerInstaller.m16913c(android.content.Context, com.oplus.camera.sticker.data.StickerItemWrapper, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0234 A[Catch: IOException -> 0x0230, TRY_LEAVE, TryCatch #7 {IOException -> 0x0230, blocks: (B:102:0x022c, B:106:0x0234), top: B:134:0x022c }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0260 A[Catch: IOException -> 0x025c, TRY_LEAVE, TryCatch #11 {IOException -> 0x025c, blocks: (B:116:0x0258, B:120:0x0260), top: B:137:0x0258 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x022c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0258 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0167 A[Catch: Exception -> 0x0213, all -> 0x0254, TRY_LEAVE, TryCatch #1 {all -> 0x0254, blocks: (B:53:0x0161, B:55:0x0167, B:68:0x0196, B:70:0x01c5, B:72:0x01cf, B:73:0x01d6, B:75:0x01e0, B:76:0x01e5, B:100:0x0227), top: B:129:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0196 A[Catch: Exception -> 0x0213, all -> 0x0254, TRY_ENTER, TryCatch #1 {all -> 0x0254, blocks: (B:53:0x0161, B:55:0x0167, B:68:0x0196, B:70:0x01c5, B:72:0x01cf, B:73:0x01d6, B:75:0x01e0, B:76:0x01e5, B:100:0x0227), top: B:129:0x0024 }] */
    /* JADX WARN: Type inference failed for: r5v1, types: [int] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean m16908a(android.content.Context r17, com.oplus.camera.sticker.data.StickerItemWrapper r18, java.lang.String r19, java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 661
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.download.StickerInstaller.m16908a(android.content.Context, com.oplus.camera.sticker.data.StickerItemWrapper, java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static AnimojiStickerExtendedInfo m16903a(String str) {
        if (TextUtils.isEmpty(str)) {
            CameraLog.m12966e("StickerInstaller", "parserAniMojiExtendInfo empty content");
            return null;
        }
        try {
            return (AnimojiStickerExtendedInfo) new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(str, AnimojiStickerExtendedInfo.class);
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("StickerInstaller", "parserAniMojiExtendInfo exception: " + COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static List<MultiStickerExtendedInfo> m16910b(String str) {
        if (TextUtils.isEmpty(str)) {
            CameraLog.m12966e("StickerInstaller", "parserMultiStickerExtendInfo empty content");
            return null;
        }
        try {
            return (List) new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(str, new TypeToken<List<MultiStickerExtendedInfo>>() { // from class: com.oplus.camera.sticker.download.IntrinsicsJvm.kt_3.1
            }.getType());
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("StickerInstaller", "parserMultiStickerExtendInfo exception: " + COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static List<ZipEntry> m16904a(ZipFile zipFile) {
        ArrayList arrayList = new ArrayList();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (!zipEntryNextElement.isDirectory()) {
                arrayList.add(zipEntryNextElement);
            }
        }
        Collections.sort(arrayList, new Comparator<ZipEntry>() { // from class: com.oplus.camera.sticker.download.IntrinsicsJvm.kt_3.2
            @Override // java.util.Comparator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public int compare(ZipEntry zipEntry, ZipEntry zipEntry2) {
                int iM16915a = m16915a(zipEntry.getName());
                int iM16915a2 = m16915a(zipEntry2.getName());
                if (iM16915a > iM16915a2) {
                    return 1;
                }
                return iM16915a < iM16915a2 ? -1 : 0;
            }

            /* renamed from: PlatformImplementations.kt_3 */
            private int m16915a(String str) {
                return str.endsWith("StickerMultiCfg.json") ? 0 : 1;
            }
        });
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m16905a(Context context, List<StickerItem> list, boolean z) {
        if (list == null || list.isEmpty()) {
            CameraLog.m12966e("StickerInstaller", "deleteSticker, list is empty!");
            return;
        }
        ContentValues contentValues = new ContentValues();
        for (StickerItem stickerItem : list) {
            if (stickerItem == null) {
                CameraLog.m12966e("StickerInstaller", "deleteSticker, item is null!");
            } else {
                contentValues.clear();
                StickerItemWrapper stickerItemWrapperM16750a = StickerItemTableHelper.m16750a(context, AFConstants.EXTRA_UUID, stickerItem.getStickerUUID());
                if (stickerItemWrapperM16750a == null) {
                    CameraLog.m12966e("StickerInstaller", "deleteSticker, can not find this sticker! name: " + stickerItem.getStickerName() + ", uuid: " + stickerItem.getStickerUUID());
                } else {
                    CameraLog.m12959b("StickerInstaller", "deleteSticker, start delete one sticker, item: " + stickerItemWrapperM16750a);
                    if (stickerItemWrapperM16750a.isBuildIn()) {
                        contentValues.put("download_time", (Integer) 0);
                        stickerItemWrapperM16750a.setDownloadTime(0L);
                    } else {
                        int iM16902a = m16902a(context, stickerItemWrapperM16750a);
                        if (iM16902a == 0) {
                            contentValues.put("download_time", (Integer) 0);
                            contentValues.put("need_update", (Integer) 0);
                            contentValues.put("file_path", "");
                            contentValues.put("file_content_uri", "");
                            contentValues.put("download_state", (Integer) 0);
                            stickerItemWrapperM16750a.setDownloadTime(0L);
                            stickerItemWrapperM16750a.setNeedUpdate(false);
                            stickerItemWrapperM16750a.setDownloadState(0);
                        } else {
                            CameraLog.m12966e("StickerInstaller", "deleteSticker, delete item fail! result: " + iM16902a + ", name: " + stickerItemWrapperM16750a.getStickerName() + ", uuid: " + stickerItem.getStickerUUID());
                        }
                    }
                    CameraLog.m12959b("StickerInstaller", "deleteSticker, updateStickerItem count: " + StickerItemTableHelper.m16749a(context, AFConstants.EXTRA_UUID, stickerItem.getStickerUUID(), contentValues));
                    if (z) {
                        StickerMediator.m16958a(context).m16972d(stickerItemWrapperM16750a);
                    }
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m16902a(Context context, StickerItemWrapper stickerItemWrapper) {
        if (context == null || stickerItemWrapper == null) {
            CameraLog.m12966e("StickerInstaller", "deleteSticker, parameter is null! context: " + context);
            return -2;
        }
        CameraLog.m12959b("StickerInstaller", "deleteSticker, stickerItem: " + stickerItemWrapper);
        if (stickerItemWrapper.isBuildIn()) {
            return 0;
        }
        int materialType = stickerItemWrapper.getMaterialType();
        if (materialType == 0) {
            return m16909b(context, stickerItemWrapper);
        }
        if (materialType == 1) {
            return m16912c(context, stickerItemWrapper);
        }
        if (materialType != 2) {
            return -1;
        }
        return m16914d(context, stickerItemWrapper);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m16909b(Context context, StickerItemWrapper stickerItemWrapper) {
        File file;
        if (context == null || stickerItemWrapper == null) {
            return -2;
        }
        if (stickerItemWrapper.getMaterialType() != 0) {
            return -3;
        }
        String filePath = stickerItemWrapper.getFilePath();
        try {
            if (TextUtils.isEmpty(stickerItemWrapper.getFilePath())) {
                file = FileProvider.m16979a(context, Uri.parse(stickerItemWrapper.getFileContentUri()));
            } else {
                file = new File(filePath);
            }
            if (file == null) {
                return -4;
            }
            return FileUtils.m16813a(file) ? 0 : -5;
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("StickerInstaller", "deleteNormalSticker exception: " + COUIBaseListPopupWindow_8);
            return -1;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m16912c(Context context, StickerItemWrapper stickerItemWrapper) {
        if (context == null || stickerItemWrapper == null) {
            return -2;
        }
        boolean zM16812a = true;
        if (stickerItemWrapper.getMaterialType() != 1) {
            return -3;
        }
        List<MultiStickerExtendedInfo> listM16768c = StickerItemTableHelper.m16768c(context, stickerItemWrapper);
        if (listM16768c == null || listM16768c.isEmpty()) {
            return -6;
        }
        for (MultiStickerExtendedInfo multiStickerExtendedInfo : listM16768c) {
            zM16812a = zM16812a & FileUtils.m16812a(context, multiStickerExtendedInfo.getFileContentUri16x9()) & FileUtils.m16812a(context, multiStickerExtendedInfo.getFileContentUri4x3()) & FileUtils.m16812a(context, multiStickerExtendedInfo.getFileContentUri1x1());
        }
        if (zM16812a) {
            return StickerItemTableHelper.m16770d(context, stickerItemWrapper) ? 0 : -7;
        }
        return -5;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static int m16914d(Context context, StickerItemWrapper stickerItemWrapper) {
        File file;
        if (context == null || stickerItemWrapper == null) {
            return -2;
        }
        if (stickerItemWrapper.getMaterialType() != 2) {
            return -3;
        }
        String filePath = stickerItemWrapper.getFilePath();
        try {
            if (TextUtils.isEmpty(stickerItemWrapper.getFilePath())) {
                file = FileProvider.m16979a(context, Uri.parse(stickerItemWrapper.getFileContentUri()));
            } else {
                file = new File(filePath);
            }
            if (file == null) {
                return -4;
            }
            if (FileUtils.m16813a(file)) {
                return StickerItemTableHelper.m16766b(context, stickerItemWrapper) ? 0 : -7;
            }
            return -5;
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("StickerInstaller", "deleteAnimojiSticker exception: " + COUIBaseListPopupWindow_8);
            return -1;
        }
    }
}
