package com.oplus.camera.sticker.download;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.android.providers.downloads.DownloadInfoData;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.camera.CameraLog;
import com.oplus.camera.statistics.model.StickerMsgData;
import com.oplus.camera.sticker.StickerMediator;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.sticker.data.StickerItemWrapper;
import com.oplus.camera.sticker.p165a.StickerItemTableHelper;
import com.oplus.camera.util.Util;
import com.oplus.p188d.p189a.DownloadManager;
import com.oplus.p195os.OplusUsbEnvironment;
import java.io.File;
import java.util.List;

/* compiled from: DownloadManagerHelper.java */
/* renamed from: com.oplus.camera.sticker.download.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class DownloadManagerHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f16232a = File.separator + "OplusOS" + File.separator + "Sticker" + File.separator + StickerMsgData.STICKER_OPER_DOWNLOAD;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static volatile DownloadManagerHelper f16233b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private DownloadStatesCallbackImpl f16234c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Object f16235d = new Object();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m16882b() {
        return "application/x-zip-compressed";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static DownloadManagerHelper m16879a() {
        if (f16233b == null) {
            synchronized (DownloadManagerHelper.class) {
                if (f16233b == null) {
                    f16233b = new DownloadManagerHelper();
                }
            }
        }
        return f16233b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16884a(Context context) {
        if (this.f16234c == null) {
            this.f16234c = new DownloadStatesCallbackImpl(context);
        }
        DownloadManager.m24922a(context, (String) null).m24945a(this.f16234c);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16886b(Context context) {
        DownloadManager.m24922a(context, (String) null).m24944a();
        this.f16234c = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private File m16880a(String str) {
        File externalCacheDir = Util.m24472l().getExternalCacheDir();
        if (externalCacheDir == null) {
            File file = new File(OplusUsbEnvironment.getInternalSdDirectory(Util.m24472l()).getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + Util.m24472l().getPackageName() + File.separator + "cache");
            if (!file.exists() && !file.mkdirs()) {
                CameraLog.m12967f("DownloadManagerHelper", "getDownloadFilePath, cacheDir.mkdirs fail");
            }
            externalCacheDir = file;
        }
        File file2 = new File(externalCacheDir.getAbsolutePath() + f16232a, str);
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.exists() && parentFile.mkdirs()) {
            CameraLog.m12966e("DownloadManagerHelper", "getDownloadFilePath, mkdirs fail! file: " + file2.getPath());
        }
        return file2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m16883a(Context context, StickerItem stickerItem, int OplusGLSurfaceView_13, boolean z) {
        if (stickerItem == null || TextUtils.isEmpty(stickerItem.getFileDownloadUrl())) {
            return -1;
        }
        CameraLog.m12959b("DownloadManagerHelper", "startDownload, downloadType: " + OplusGLSurfaceView_13 + ", allowMobileNetwork: " + z + ", stickerItem: " + stickerItem);
        File fileM16880a = m16880a(stickerItem.getStickerUUID());
        if (OplusGLSurfaceView_13 == 1 && fileM16880a.exists() && !fileM16880a.delete()) {
            CameraLog.m12966e("DownloadManagerHelper", "startDownload, delete exist file fail! path: " + fileM16880a);
            return -2;
        }
        DownloadManager c3618aM24921a = DownloadManager.m24921a(context);
        DownloadManager.COUIBaseListPopupWindow_8 eVar = new DownloadManager.COUIBaseListPopupWindow_8(Uri.parse(stickerItem.getFileDownloadUrl()));
        eVar.m24978a(Uri.fromFile(fileM16880a));
        eVar.m24979a((CharSequence) stickerItem.getStickerName());
        eVar.m24980a(m16882b());
        eVar.m24985c(stickerItem.getFileMd5());
        eVar.m24982b(2);
        eVar.m24981a(true);
        eVar.m24983b(stickerItem.getStickerUUID());
        if (z) {
            eVar.m24977a(7);
        } else {
            eVar.m24977a(6);
        }
        if (OplusGLSurfaceView_13 == 2) {
            eVar.m24984b(true);
        } else {
            eVar.m24984b(false);
        }
        String strM24942a = c3618aM24921a.m24942a(eVar);
        if (TextUtils.isEmpty(strM24942a)) {
            return -3;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_uuid", strM24942a);
        contentValues.put("is_new", (Boolean) false);
        int iM16749a = StickerItemTableHelper.m16749a(context, AFConstants.EXTRA_UUID, stickerItem.getStickerUUID(), contentValues);
        stickerItem.setDownloadUid(strM24942a);
        stickerItem.setStickerNew(false);
        CameraLog.m12959b("DownloadManagerHelper", "startDownload, update download. result: " + iM16749a + ", download: " + strM24942a);
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16885a(Context context, StickerItem stickerItem, boolean z) {
        if (stickerItem == null) {
            CameraLog.m12966e("DownloadManagerHelper", "resumeDownload, sticker item is null!");
            return;
        }
        DownloadManager c3618aM24921a = DownloadManager.m24921a(context);
        if (z) {
            c3618aM24921a.m24936a(7, stickerItem.getDownloadUid());
        } else {
            c3618aM24921a.m24936a(6, stickerItem.getDownloadUid());
        }
        c3618aM24921a.m24947b(stickerItem.getDownloadUid());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16887b(Context context, StickerItem stickerItem, boolean z) {
        if (stickerItem == null) {
            CameraLog.m12966e("DownloadManagerHelper", "restartDownload, sticker item is null!");
            return;
        }
        DownloadManager c3618aM24921a = DownloadManager.m24921a(context);
        try {
            if (z) {
                c3618aM24921a.m24936a(7, stickerItem.getDownloadUid());
            } else {
                c3618aM24921a.m24936a(6, stickerItem.getDownloadUid());
            }
            c3618aM24921a.m24937a(stickerItem.getDownloadUid());
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16889c(Context context, StickerItem stickerItem, boolean z) {
        CameraLog.m12959b("DownloadManagerHelper", "startDownloadSticker, allowAllNetwork: " + z + ", stickerItem: " + stickerItem);
        if (stickerItem == null) {
            CameraLog.m12966e("DownloadManagerHelper", "startDownloadSticker, stickerItem is null!");
            return;
        }
        StickerItemWrapper stickerItemWrapperM16750a = StickerItemTableHelper.m16750a(context, AFConstants.EXTRA_UUID, stickerItem.getStickerUUID());
        if (stickerItemWrapperM16750a == null) {
            CameraLog.m12966e("DownloadManagerHelper", "startDownloadSticker, can not find the sticker in db! stickerItem: " + stickerItem);
            return;
        }
        boolean z2 = stickerItem.getDownloadState() != stickerItemWrapperM16750a.getDownloadState();
        stickerItem.copy(stickerItemWrapperM16750a);
        int downloadState = stickerItem.getDownloadState();
        if (stickerItem.needUpdate()) {
            int iM16883a = m16883a(context, stickerItem, 2, z);
            if (iM16883a != 0) {
                StickerMediator.m16958a(context).m16962a(stickerItem, iM16883a);
                return;
            }
            return;
        }
        if (downloadState == 0) {
            int iM16883a2 = m16883a(context, stickerItem, 1, z);
            if (iM16883a2 != 0) {
                StickerMediator.m16958a(context).m16962a(stickerItem, iM16883a2);
                return;
            }
            return;
        }
        if (downloadState == 1 || downloadState == 2) {
            return;
        }
        if (downloadState == 4) {
            m16885a(context, stickerItem, z);
            return;
        }
        if (downloadState != 8) {
            if (downloadState != 16) {
                return;
            }
            m16887b(context, stickerItem, z);
        } else if (z2) {
            CameraLog.m12966e("DownloadManagerHelper", "startDownloadSticker, download state is different, restart it again!");
            m16887b(context, stickerItem, z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16888c(final Context context) {
        new Thread(new Runnable() { // from class: com.oplus.camera.sticker.download.PlatformImplementations.kt_3.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DownloadManagerHelper.this.f16235d) {
                    List<StickerItem> listM16754a = StickerItemTableHelper.m16754a(context);
                    CameraLog.m12959b("DownloadManagerHelper", "syncDownloadData, unDownloadSticker.size(): " + listM16754a.size());
                    for (StickerItem stickerItem : listM16754a) {
                        if (TextUtils.isEmpty(stickerItem.getDownloadUid())) {
                            CameraLog.m12966e("DownloadManagerHelper", "syncDownloadDataFromDownloadCenter, sticker download uuid is empty! sticker: " + stickerItem);
                            StickerItemTableHelper.m16765b(context, stickerItem);
                        } else {
                            CameraLog.m12959b("DownloadManagerHelper", "unDownloadedSticker: " + stickerItem);
                            DownloadInfoData downloadInfoDataM24940a = DownloadManager.m24921a(context).m24940a(stickerItem.getDownloadUid());
                            CameraLog.m12959b("DownloadManagerHelper", "downloadInfoData: " + downloadInfoDataM24940a);
                            if (downloadInfoDataM24940a != null) {
                                if (downloadInfoDataM24940a.mStatus == 8) {
                                    if (!StickerInstaller.m16907a(context, (StickerItemWrapper) stickerItem, downloadInfoDataM24940a.mFileName)) {
                                        StickerItemTableHelper.m16765b(context, stickerItem);
                                    }
                                } else {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("download_state", Integer.valueOf(downloadInfoDataM24940a.mStatus));
                                    StickerItemTableHelper.m16749a(context, AFConstants.EXTRA_UUID, stickerItem.getStickerUUID(), contentValues);
                                }
                            } else {
                                CameraLog.m12966e("DownloadManagerHelper", "syncDownloadDataFromDownloadCenter, download info is null! sticker: " + stickerItem);
                                StickerItemTableHelper.m16765b(context, stickerItem);
                            }
                        }
                    }
                }
            }
        }).start();
    }
}
