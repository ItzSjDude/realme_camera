package com.oplus.camera.sticker.download;

/* compiled from: DownloadManagerHelper.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f5451a = java.io.File.separator + "OplusOS" + java.io.File.separator + "Sticker" + java.io.File.separator + com.oplus.camera.statistics.model.StickerMsgData.STICKER_OPER_DOWNLOAD;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static volatile com.oplus.camera.sticker.download.a_renamed f5452b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.sticker.download.b_renamed f5453c = null;
    private java.lang.Object d_renamed = new java.lang.Object();

    private java.lang.String b_renamed() {
        return "application/x_renamed-zip-compressed";
    }

    public static com.oplus.camera.sticker.download.a_renamed a_renamed() {
        if (f5452b == null) {
            synchronized (com.oplus.camera.sticker.download.a_renamed.class) {
                if (f5452b == null) {
                    f5452b = new com.oplus.camera.sticker.download.a_renamed();
                }
            }
        }
        return f5452b;
    }

    public void a_renamed(android.content.Context context) {
        if (this.f5453c == null) {
            this.f5453c = new com.oplus.camera.sticker.download.b_renamed(context);
        }
        com.oplus.d_renamed.a_renamed.a_renamed.a_renamed(context, (java.lang.String) null).a_renamed(this.f5453c);
    }

    public void b_renamed(android.content.Context context) {
        com.oplus.d_renamed.a_renamed.a_renamed.a_renamed(context, (java.lang.String) null).a_renamed();
        this.f5453c = null;
    }

    private java.io.File a_renamed(java.lang.String str) {
        java.io.File externalCacheDir = com.oplus.camera.util.Util.l_renamed().getExternalCacheDir();
        if (externalCacheDir == null) {
            java.io.File file = new java.io.File(com.oplus.os.OplusUsbEnvironment.getInternalSdDirectory(com.oplus.camera.util.Util.l_renamed()).getAbsolutePath() + java.io.File.separator + "Android" + java.io.File.separator + "data" + java.io.File.separator + com.oplus.camera.util.Util.l_renamed().getPackageName() + java.io.File.separator + "cache");
            if (!file.exists() && !file.mkdirs()) {
                com.oplus.camera.e_renamed.f_renamed("DownloadManagerHelper", "getDownloadFilePath, cacheDir.mkdirs fail");
            }
            externalCacheDir = file;
        }
        java.io.File file2 = new java.io.File(externalCacheDir.getAbsolutePath() + f5451a, str);
        java.io.File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.exists() && parentFile.mkdirs()) {
            com.oplus.camera.e_renamed.e_renamed("DownloadManagerHelper", "getDownloadFilePath, mkdirs fail! file: " + file2.getPath());
        }
        return file2;
    }

    public int a_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItem stickerItem, int i_renamed, boolean z_renamed) {
        if (stickerItem == null || android.text.TextUtils.isEmpty(stickerItem.getFileDownloadUrl())) {
            return -1;
        }
        com.oplus.camera.e_renamed.b_renamed("DownloadManagerHelper", "startDownload, downloadType: " + i_renamed + ", allowMobileNetwork: " + z_renamed + ", stickerItem: " + stickerItem);
        java.io.File fileA = a_renamed(stickerItem.getStickerUUID());
        if (i_renamed == 1 && fileA.exists() && !fileA.delete()) {
            com.oplus.camera.e_renamed.e_renamed("DownloadManagerHelper", "startDownload, delete exist file fail! path: " + fileA);
            return -2;
        }
        com.oplus.d_renamed.a_renamed.a_renamed aVarA = com.oplus.d_renamed.a_renamed.a_renamed.a_renamed(context);
        com.oplus.d_renamed.a_renamed.a_renamed.e_renamed eVar = new com.oplus.d_renamed.a_renamed.a_renamed.e_renamed(android.net.Uri.parse(stickerItem.getFileDownloadUrl()));
        eVar.a_renamed(android.net.Uri.fromFile(fileA));
        eVar.a_renamed((java.lang.CharSequence) stickerItem.getStickerName());
        eVar.a_renamed(b_renamed());
        eVar.c_renamed(stickerItem.getFileMd5());
        eVar.b_renamed(2);
        eVar.a_renamed(true);
        eVar.b_renamed(stickerItem.getStickerUUID());
        if (z_renamed) {
            eVar.a_renamed(7);
        } else {
            eVar.a_renamed(6);
        }
        if (i_renamed == 2) {
            eVar.b_renamed(true);
        } else {
            eVar.b_renamed(false);
        }
        java.lang.String strA = aVarA.a_renamed(eVar);
        if (android.text.TextUtils.isEmpty(strA)) {
            return -3;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("download_uuid", strA);
        contentValues.put("is_new", (java.lang.Boolean) false);
        int iA = com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(context, com.heytap.accessory.constant.AFConstants.EXTRA_UUID, stickerItem.getStickerUUID(), contentValues);
        stickerItem.setDownloadUid(strA);
        stickerItem.setStickerNew(false);
        com.oplus.camera.e_renamed.b_renamed("DownloadManagerHelper", "startDownload, update download. result: " + iA + ", download: " + strA);
        return 0;
    }

    public void a_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItem stickerItem, boolean z_renamed) {
        if (stickerItem == null) {
            com.oplus.camera.e_renamed.e_renamed("DownloadManagerHelper", "resumeDownload, sticker item is_renamed null!");
            return;
        }
        com.oplus.d_renamed.a_renamed.a_renamed aVarA = com.oplus.d_renamed.a_renamed.a_renamed.a_renamed(context);
        if (z_renamed) {
            aVarA.a_renamed(7, stickerItem.getDownloadUid());
        } else {
            aVarA.a_renamed(6, stickerItem.getDownloadUid());
        }
        aVarA.b_renamed(stickerItem.getDownloadUid());
    }

    public void b_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItem stickerItem, boolean z_renamed) {
        if (stickerItem == null) {
            com.oplus.camera.e_renamed.e_renamed("DownloadManagerHelper", "restartDownload, sticker item is_renamed null!");
            return;
        }
        com.oplus.d_renamed.a_renamed.a_renamed aVarA = com.oplus.d_renamed.a_renamed.a_renamed.a_renamed(context);
        try {
            if (z_renamed) {
                aVarA.a_renamed(7, stickerItem.getDownloadUid());
            } else {
                aVarA.a_renamed(6, stickerItem.getDownloadUid());
            }
            aVarA.a_renamed(stickerItem.getDownloadUid());
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
    }

    public void c_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItem stickerItem, boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("DownloadManagerHelper", "startDownloadSticker, allowAllNetwork: " + z_renamed + ", stickerItem: " + stickerItem);
        if (stickerItem == null) {
            com.oplus.camera.e_renamed.e_renamed("DownloadManagerHelper", "startDownloadSticker, stickerItem is_renamed null!");
            return;
        }
        com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapperA = com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(context, com.heytap.accessory.constant.AFConstants.EXTRA_UUID, stickerItem.getStickerUUID());
        if (stickerItemWrapperA == null) {
            com.oplus.camera.e_renamed.e_renamed("DownloadManagerHelper", "startDownloadSticker, can not find the sticker in_renamed db_renamed! stickerItem: " + stickerItem);
            return;
        }
        boolean z2 = stickerItem.getDownloadState() != stickerItemWrapperA.getDownloadState();
        stickerItem.copy(stickerItemWrapperA);
        int downloadState = stickerItem.getDownloadState();
        if (stickerItem.needUpdate()) {
            int iA = a_renamed(context, stickerItem, 2, z_renamed);
            if (iA != 0) {
                com.oplus.camera.sticker.h_renamed.a_renamed(context).a_renamed(stickerItem, iA);
                return;
            }
            return;
        }
        if (downloadState == 0) {
            int iA2 = a_renamed(context, stickerItem, 1, z_renamed);
            if (iA2 != 0) {
                com.oplus.camera.sticker.h_renamed.a_renamed(context).a_renamed(stickerItem, iA2);
                return;
            }
            return;
        }
        if (downloadState == 1 || downloadState == 2) {
            return;
        }
        if (downloadState == 4) {
            a_renamed(context, stickerItem, z_renamed);
            return;
        }
        if (downloadState != 8) {
            if (downloadState != 16) {
                return;
            }
            b_renamed(context, stickerItem, z_renamed);
        } else if (z2) {
            com.oplus.camera.e_renamed.e_renamed("DownloadManagerHelper", "startDownloadSticker, download state is_renamed different, restart it again!");
            b_renamed(context, stickerItem, z_renamed);
        }
    }

    public void c_renamed(final android.content.Context context) {
        new java.lang.Thread(new java.lang.Runnable() { // from class: com.oplus.camera.sticker.download.a_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.oplus.camera.sticker.download.a_renamed.this.d_renamed) {
                    java.util.List<com.oplus.camera.sticker.data.StickerItem> listA = com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(context);
                    com.oplus.camera.e_renamed.b_renamed("DownloadManagerHelper", "syncDownloadData, unDownloadSticker.size(): " + listA.size());
                    for (com.oplus.camera.sticker.data.StickerItem stickerItem : listA) {
                        if (android.text.TextUtils.isEmpty(stickerItem.getDownloadUid())) {
                            com.oplus.camera.e_renamed.e_renamed("DownloadManagerHelper", "syncDownloadDataFromDownloadCenter, sticker download uuid is_renamed empty! sticker: " + stickerItem);
                            com.oplus.camera.sticker.a_renamed.b_renamed.b_renamed(context, stickerItem);
                        } else {
                            com.oplus.camera.e_renamed.b_renamed("DownloadManagerHelper", "unDownloadedSticker: " + stickerItem);
                            com.android.providers.downloads.DownloadInfoData downloadInfoDataA = com.oplus.d_renamed.a_renamed.a_renamed.a_renamed(context).a_renamed(stickerItem.getDownloadUid());
                            com.oplus.camera.e_renamed.b_renamed("DownloadManagerHelper", "downloadInfoData: " + downloadInfoDataA);
                            if (downloadInfoDataA != null) {
                                if (downloadInfoDataA.mStatus == 8) {
                                    if (!com.oplus.camera.sticker.download.c_renamed.a_renamed(context, (com.oplus.camera.sticker.data.StickerItemWrapper) stickerItem, downloadInfoDataA.mFileName)) {
                                        com.oplus.camera.sticker.a_renamed.b_renamed.b_renamed(context, stickerItem);
                                    }
                                } else {
                                    android.content.ContentValues contentValues = new android.content.ContentValues();
                                    contentValues.put("download_state", java.lang.Integer.valueOf(downloadInfoDataA.mStatus));
                                    com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(context, com.heytap.accessory.constant.AFConstants.EXTRA_UUID, stickerItem.getStickerUUID(), contentValues);
                                }
                            } else {
                                com.oplus.camera.e_renamed.e_renamed("DownloadManagerHelper", "syncDownloadDataFromDownloadCenter, download info is_renamed null! sticker: " + stickerItem);
                                com.oplus.camera.sticker.a_renamed.b_renamed.b_renamed(context, stickerItem);
                            }
                        }
                    }
                }
            }
        }).start();
    }
}
