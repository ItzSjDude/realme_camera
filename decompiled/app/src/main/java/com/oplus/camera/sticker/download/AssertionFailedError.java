package com.oplus.camera.sticker.download;

/* compiled from: DownloadStatesCallbackImpl.java */
/* loaded from: classes2.dex */
public class b_renamed implements com.oplus.d_renamed.a_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f5456a;

    public b_renamed(android.content.Context context) {
        this.f5456a = null;
        this.f5456a = context;
    }

    @Override // com.oplus.d_renamed.a_renamed.b_renamed
    public void a_renamed(java.util.List<com.android.providers.downloads.DownloadInfoData> list) {
        if (list == null || list.isEmpty()) {
            com.oplus.camera.e_renamed.e_renamed("DownloadStateCallbackImpl", "onDownloadInserted, dataList is_renamed empty!");
            return;
        }
        java.util.Iterator<com.android.providers.downloads.DownloadInfoData> it = list.iterator();
        while (it.hasNext()) {
            a_renamed(it.next(), false);
        }
    }

    @Override // com.oplus.d_renamed.a_renamed.b_renamed
    public void b_renamed(java.util.List<com.android.providers.downloads.DownloadInfoData> list) {
        if (list == null || list.isEmpty()) {
            com.oplus.camera.e_renamed.e_renamed("DownloadStateCallbackImpl", "onDownloadUpdated, dataList is_renamed empty!");
            return;
        }
        java.util.Iterator<com.android.providers.downloads.DownloadInfoData> it = list.iterator();
        while (it.hasNext()) {
            a_renamed(it.next(), false);
        }
    }

    @Override // com.oplus.d_renamed.a_renamed.b_renamed
    public void c_renamed(java.util.List<com.android.providers.downloads.DownloadInfoData> list) {
        if (list == null || list.isEmpty()) {
            com.oplus.camera.e_renamed.e_renamed("DownloadStateCallbackImpl", "onDownloadDeleted, dataList is_renamed empty!");
            return;
        }
        java.util.Iterator<com.android.providers.downloads.DownloadInfoData> it = list.iterator();
        while (it.hasNext()) {
            a_renamed(it.next(), true);
        }
    }

    @Override // com.oplus.d_renamed.a_renamed.b_renamed
    public void d_renamed(java.util.List<com.android.providers.downloads.DownloadInfoData> list) {
        if (list == null || list.isEmpty()) {
            com.oplus.camera.e_renamed.e_renamed("DownloadStateCallbackImpl", "onDownloadTimeout, dataList is_renamed empty!");
            return;
        }
        java.util.Iterator<com.android.providers.downloads.DownloadInfoData> it = list.iterator();
        while (it.hasNext()) {
            a_renamed(it.next(), true);
        }
    }

    private void a_renamed(com.android.providers.downloads.DownloadInfoData downloadInfoData, boolean z_renamed) {
        if (downloadInfoData == null) {
            com.oplus.camera.e_renamed.e_renamed("DownloadStateCallbackImpl", "handleDownloadStateChanged, downloadInfo is_renamed null!");
            return;
        }
        com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapperA = com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(this.f5456a, "download_uuid", downloadInfoData.mUuid);
        if (stickerItemWrapperA == null) {
            com.oplus.camera.e_renamed.e_renamed("DownloadStateCallbackImpl", "handleDownloadStateChanged, can't_renamed find the sticker item with download uuid.");
            return;
        }
        if (z_renamed) {
            e_renamed(stickerItemWrapperA, downloadInfoData);
            return;
        }
        int i_renamed = downloadInfoData.mStatus;
        if (i_renamed == 1) {
            a_renamed(stickerItemWrapperA, downloadInfoData);
            return;
        }
        if (i_renamed == 2) {
            b_renamed(stickerItemWrapperA, downloadInfoData);
            return;
        }
        if (i_renamed == 4) {
            c_renamed(stickerItemWrapperA, downloadInfoData);
            return;
        }
        if (i_renamed == 8) {
            d_renamed(stickerItemWrapperA, downloadInfoData);
        } else if (i_renamed == 16) {
            a_renamed(stickerItemWrapperA, downloadInfoData, false);
        } else {
            com.oplus.camera.e_renamed.e_renamed("DownloadStateCallbackImpl", "handleDownloadStateChanged, unsupported download status!");
        }
    }

    private void a_renamed(com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper, com.android.providers.downloads.DownloadInfoData downloadInfoData) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("is_new", (java.lang.Boolean) false);
        contentValues.put("download_state", java.lang.Integer.valueOf(downloadInfoData.mStatus));
        com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(this.f5456a, com.heytap.accessory.constant.AFConstants.EXTRA_UUID, stickerItemWrapper.getStickerUUID(), contentValues);
        stickerItemWrapper.setStickerNew(false);
        stickerItemWrapper.setDownloadState(downloadInfoData.mStatus);
    }

    private void b_renamed(com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper, com.android.providers.downloads.DownloadInfoData downloadInfoData) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("download_state", java.lang.Integer.valueOf(downloadInfoData.mStatus));
        com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(this.f5456a, com.heytap.accessory.constant.AFConstants.EXTRA_UUID, stickerItemWrapper.getStickerUUID(), contentValues);
        stickerItemWrapper.setStickerNew(false);
        stickerItemWrapper.setDownloadState(downloadInfoData.mStatus);
    }

    private void c_renamed(com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper, com.android.providers.downloads.DownloadInfoData downloadInfoData) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("download_state", java.lang.Integer.valueOf(downloadInfoData.mStatus));
        com.oplus.camera.e_renamed.b_renamed("DownloadStateCallbackImpl", "handleDownloadPaused, count: " + com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(this.f5456a, com.heytap.accessory.constant.AFConstants.EXTRA_UUID, stickerItemWrapper.getStickerUUID(), contentValues) + ", stickerItem: " + stickerItemWrapper);
        stickerItemWrapper.setDownloadState(downloadInfoData.mStatus);
        com.oplus.camera.sticker.h_renamed.a_renamed(this.f5456a).b_renamed(stickerItemWrapper, a_renamed(downloadInfoData));
    }

    private void d_renamed(com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper, com.android.providers.downloads.DownloadInfoData downloadInfoData) {
        if (stickerItemWrapper.isDownloaded() && !stickerItemWrapper.needUpdate()) {
            com.oplus.camera.e_renamed.e_renamed("DownloadStateCallbackImpl", "handleDownloadSuccess, downloaded are not need update");
            return;
        }
        boolean zA = com.oplus.camera.sticker.download.c_renamed.a_renamed(this.f5456a, stickerItemWrapper, downloadInfoData.mFileName);
        com.oplus.camera.e_renamed.b_renamed("DownloadStateCallbackImpl", "handleDownloadSuccess, result: " + zA + "stickerItem: " + stickerItemWrapper);
        if (zA) {
            com.oplus.camera.sticker.h_renamed.a_renamed(this.f5456a).b_renamed(stickerItemWrapper);
            return;
        }
        com.oplus.camera.e_renamed.e_renamed("DownloadStateCallbackImpl", "handleDownloadSuccess, installSticker sticker fail! stickerItem: " + stickerItemWrapper);
        a_renamed(stickerItemWrapper, downloadInfoData, true);
    }

    private int a_renamed(com.android.providers.downloads.DownloadInfoData downloadInfoData) {
        int i_renamed = (int) downloadInfoData.mReason;
        if (i_renamed == 1011) {
            return -49;
        }
        if (i_renamed == 1012) {
            return -50;
        }
        switch (i_renamed) {
            case 1:
                return -26;
            case 2:
                return -25;
            case 3:
                return -24;
            case 4:
                break;
            case 5:
                return -21;
            case 6:
                return -23;
            case 7:
                return -22;
            default:
                switch (i_renamed) {
                    case 1000:
                        return -40;
                    case com.heytap.accessory.CommonStatusCodes.AUTHENTICATE_SUCCESS /* 1001 */:
                        return -41;
                    case 1002:
                        return -42;
                    default:
                        switch (i_renamed) {
                            case com.heytap.accessory.CommonStatusCodes.AUTHCODE_EXPECTED /* 1004 */:
                                return -43;
                            case com.heytap.accessory.CommonStatusCodes.VERSION_INCOMPATIBLE /* 1005 */:
                                return -44;
                            case com.heytap.accessory.CommonStatusCodes.AUTHCODE_RECYCLE /* 1006 */:
                                return -45;
                            case com.heytap.accessory.CommonStatusCodes.AUTHCODE_INVALID /* 1007 */:
                                return -46;
                            case com.heytap.accessory.CommonStatusCodes.CAPABILITY_EXCEPTION /* 1008 */:
                                return -47;
                            case com.heytap.accessory.CommonStatusCodes.INTERNAL_EXCEPTION /* 1009 */:
                                return -48;
                            default:
                                com.oplus.camera.e_renamed.e_renamed("DownloadStateCallbackImpl", "getDownloadErrorCode, unknown error!");
                                if (downloadInfoData.mStatus != 4) {
                                    return -40;
                                }
                                break;
                        }
                }
        }
        return -20;
    }

    private void a_renamed(com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper, com.android.providers.downloads.DownloadInfoData downloadInfoData, boolean z_renamed) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("download_state", (java.lang.Integer) 16);
        com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(this.f5456a, com.heytap.accessory.constant.AFConstants.EXTRA_UUID, stickerItemWrapper.getStickerUUID(), contentValues);
        com.oplus.camera.e_renamed.e_renamed("DownloadStateCallbackImpl", "handleDownloadFail, isCopyFileError: " + z_renamed + ", stickerItem: " + stickerItemWrapper);
        stickerItemWrapper.setDownloadState(16);
        if (z_renamed) {
            com.oplus.camera.sticker.h_renamed.a_renamed(this.f5456a).a_renamed(stickerItemWrapper, -51);
        } else {
            com.oplus.camera.sticker.h_renamed.a_renamed(this.f5456a).a_renamed(stickerItemWrapper, a_renamed(downloadInfoData));
        }
    }

    private void e_renamed(com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper, com.android.providers.downloads.DownloadInfoData downloadInfoData) {
        if (stickerItemWrapper.getDownloadState() == 8) {
            com.oplus.camera.e_renamed.e_renamed("DownloadStateCallbackImpl", "handleDownloadDelete, sticker is_renamed download successful! stickerItem: " + stickerItemWrapper);
            return;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("download_state", (java.lang.Integer) 0);
        com.oplus.camera.e_renamed.b_renamed("DownloadStateCallbackImpl", "handleDownloadDelete, count: " + com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(this.f5456a, com.heytap.accessory.constant.AFConstants.EXTRA_UUID, stickerItemWrapper.getStickerUUID(), contentValues) + ", stickerItem: " + stickerItemWrapper);
        stickerItemWrapper.setDownloadState(0);
    }
}
