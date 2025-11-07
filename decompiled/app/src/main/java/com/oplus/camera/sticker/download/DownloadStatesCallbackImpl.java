package com.oplus.camera.sticker.download;

import android.content.ContentValues;
import android.content.Context;
import com.android.providers.downloads.DownloadInfoData;
import com.heytap.accessory.CommonStatusCodes;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.camera.CameraLog;
import com.oplus.camera.sticker.StickerMediator;
import com.oplus.camera.sticker.data.StickerItemWrapper;
import com.oplus.camera.sticker.p165a.StickerItemTableHelper;
import com.oplus.p188d.p189a.DownloadStatesCallback;
import java.util.Iterator;
import java.util.List;

/* compiled from: DownloadStatesCallbackImpl.java */
/* renamed from: com.oplus.camera.sticker.download.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class DownloadStatesCallbackImpl implements DownloadStatesCallback {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f16238a;

    public DownloadStatesCallbackImpl(Context context) {
        this.f16238a = null;
        this.f16238a = context;
    }

    @Override // com.oplus.p188d.p189a.DownloadStatesCallback
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16898a(List<DownloadInfoData> list) {
        if (list == null || list.isEmpty()) {
            CameraLog.m12966e("DownloadStateCallbackImpl", "onDownloadInserted, dataList is empty!");
            return;
        }
        Iterator<DownloadInfoData> it = list.iterator();
        while (it.hasNext()) {
            m16891a(it.next(), false);
        }
    }

    @Override // com.oplus.p188d.p189a.DownloadStatesCallback
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16899b(List<DownloadInfoData> list) {
        if (list == null || list.isEmpty()) {
            CameraLog.m12966e("DownloadStateCallbackImpl", "onDownloadUpdated, dataList is empty!");
            return;
        }
        Iterator<DownloadInfoData> it = list.iterator();
        while (it.hasNext()) {
            m16891a(it.next(), false);
        }
    }

    @Override // com.oplus.p188d.p189a.DownloadStatesCallback
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo16900c(List<DownloadInfoData> list) {
        if (list == null || list.isEmpty()) {
            CameraLog.m12966e("DownloadStateCallbackImpl", "onDownloadDeleted, dataList is empty!");
            return;
        }
        Iterator<DownloadInfoData> it = list.iterator();
        while (it.hasNext()) {
            m16891a(it.next(), true);
        }
    }

    @Override // com.oplus.p188d.p189a.DownloadStatesCallback
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo16901d(List<DownloadInfoData> list) {
        if (list == null || list.isEmpty()) {
            CameraLog.m12966e("DownloadStateCallbackImpl", "onDownloadTimeout, dataList is empty!");
            return;
        }
        Iterator<DownloadInfoData> it = list.iterator();
        while (it.hasNext()) {
            m16891a(it.next(), true);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16891a(DownloadInfoData downloadInfoData, boolean z) {
        if (downloadInfoData == null) {
            CameraLog.m12966e("DownloadStateCallbackImpl", "handleDownloadStateChanged, downloadInfo is null!");
            return;
        }
        StickerItemWrapper stickerItemWrapperM16750a = StickerItemTableHelper.m16750a(this.f16238a, "download_uuid", downloadInfoData.mUuid);
        if (stickerItemWrapperM16750a == null) {
            CameraLog.m12966e("DownloadStateCallbackImpl", "handleDownloadStateChanged, can't find the sticker item with download uuid.");
            return;
        }
        if (z) {
            m16897e(stickerItemWrapperM16750a, downloadInfoData);
            return;
        }
        int OplusGLSurfaceView_13 = downloadInfoData.mStatus;
        if (OplusGLSurfaceView_13 == 1) {
            m16892a(stickerItemWrapperM16750a, downloadInfoData);
            return;
        }
        if (OplusGLSurfaceView_13 == 2) {
            m16894b(stickerItemWrapperM16750a, downloadInfoData);
            return;
        }
        if (OplusGLSurfaceView_13 == 4) {
            m16895c(stickerItemWrapperM16750a, downloadInfoData);
            return;
        }
        if (OplusGLSurfaceView_13 == 8) {
            m16896d(stickerItemWrapperM16750a, downloadInfoData);
        } else if (OplusGLSurfaceView_13 == 16) {
            m16893a(stickerItemWrapperM16750a, downloadInfoData, false);
        } else {
            CameraLog.m12966e("DownloadStateCallbackImpl", "handleDownloadStateChanged, unsupported download status!");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16892a(StickerItemWrapper stickerItemWrapper, DownloadInfoData downloadInfoData) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_new", (Boolean) false);
        contentValues.put("download_state", Integer.valueOf(downloadInfoData.mStatus));
        StickerItemTableHelper.m16749a(this.f16238a, AFConstants.EXTRA_UUID, stickerItemWrapper.getStickerUUID(), contentValues);
        stickerItemWrapper.setStickerNew(false);
        stickerItemWrapper.setDownloadState(downloadInfoData.mStatus);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m16894b(StickerItemWrapper stickerItemWrapper, DownloadInfoData downloadInfoData) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_state", Integer.valueOf(downloadInfoData.mStatus));
        StickerItemTableHelper.m16749a(this.f16238a, AFConstants.EXTRA_UUID, stickerItemWrapper.getStickerUUID(), contentValues);
        stickerItemWrapper.setStickerNew(false);
        stickerItemWrapper.setDownloadState(downloadInfoData.mStatus);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m16895c(StickerItemWrapper stickerItemWrapper, DownloadInfoData downloadInfoData) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_state", Integer.valueOf(downloadInfoData.mStatus));
        CameraLog.m12959b("DownloadStateCallbackImpl", "handleDownloadPaused, count: " + StickerItemTableHelper.m16749a(this.f16238a, AFConstants.EXTRA_UUID, stickerItemWrapper.getStickerUUID(), contentValues) + ", stickerItem: " + stickerItemWrapper);
        stickerItemWrapper.setDownloadState(downloadInfoData.mStatus);
        StickerMediator.m16958a(this.f16238a).m16968b(stickerItemWrapper, m16890a(downloadInfoData));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m16896d(StickerItemWrapper stickerItemWrapper, DownloadInfoData downloadInfoData) {
        if (stickerItemWrapper.isDownloaded() && !stickerItemWrapper.needUpdate()) {
            CameraLog.m12966e("DownloadStateCallbackImpl", "handleDownloadSuccess, downloaded are not need update");
            return;
        }
        boolean zM16907a = StickerInstaller.m16907a(this.f16238a, stickerItemWrapper, downloadInfoData.mFileName);
        CameraLog.m12959b("DownloadStateCallbackImpl", "handleDownloadSuccess, result: " + zM16907a + "stickerItem: " + stickerItemWrapper);
        if (zM16907a) {
            StickerMediator.m16958a(this.f16238a).m16967b(stickerItemWrapper);
            return;
        }
        CameraLog.m12966e("DownloadStateCallbackImpl", "handleDownloadSuccess, installSticker sticker fail! stickerItem: " + stickerItemWrapper);
        m16893a(stickerItemWrapper, downloadInfoData, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m16890a(DownloadInfoData downloadInfoData) {
        int OplusGLSurfaceView_13 = (int) downloadInfoData.mReason;
        if (OplusGLSurfaceView_13 == 1011) {
            return -49;
        }
        if (OplusGLSurfaceView_13 == 1012) {
            return -50;
        }
        switch (OplusGLSurfaceView_13) {
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
                switch (OplusGLSurfaceView_13) {
                    case 1000:
                        return -40;
                    case CommonStatusCodes.AUTHENTICATE_SUCCESS /* 1001 */:
                        return -41;
                    case 1002:
                        return -42;
                    default:
                        switch (OplusGLSurfaceView_13) {
                            case CommonStatusCodes.AUTHCODE_EXPECTED /* 1004 */:
                                return -43;
                            case CommonStatusCodes.VERSION_INCOMPATIBLE /* 1005 */:
                                return -44;
                            case CommonStatusCodes.AUTHCODE_RECYCLE /* 1006 */:
                                return -45;
                            case CommonStatusCodes.AUTHCODE_INVALID /* 1007 */:
                                return -46;
                            case CommonStatusCodes.CAPABILITY_EXCEPTION /* 1008 */:
                                return -47;
                            case CommonStatusCodes.INTERNAL_EXCEPTION /* 1009 */:
                                return -48;
                            default:
                                CameraLog.m12966e("DownloadStateCallbackImpl", "getDownloadErrorCode, unknown error!");
                                if (downloadInfoData.mStatus != 4) {
                                    return -40;
                                }
                                break;
                        }
                }
        }
        return -20;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16893a(StickerItemWrapper stickerItemWrapper, DownloadInfoData downloadInfoData, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_state", (Integer) 16);
        StickerItemTableHelper.m16749a(this.f16238a, AFConstants.EXTRA_UUID, stickerItemWrapper.getStickerUUID(), contentValues);
        CameraLog.m12966e("DownloadStateCallbackImpl", "handleDownloadFail, isCopyFileError: " + z + ", stickerItem: " + stickerItemWrapper);
        stickerItemWrapper.setDownloadState(16);
        if (z) {
            StickerMediator.m16958a(this.f16238a).m16962a(stickerItemWrapper, -51);
        } else {
            StickerMediator.m16958a(this.f16238a).m16962a(stickerItemWrapper, m16890a(downloadInfoData));
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m16897e(StickerItemWrapper stickerItemWrapper, DownloadInfoData downloadInfoData) {
        if (stickerItemWrapper.getDownloadState() == 8) {
            CameraLog.m12966e("DownloadStateCallbackImpl", "handleDownloadDelete, sticker is download successful! stickerItem: " + stickerItemWrapper);
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_state", (Integer) 0);
        CameraLog.m12959b("DownloadStateCallbackImpl", "handleDownloadDelete, count: " + StickerItemTableHelper.m16749a(this.f16238a, AFConstants.EXTRA_UUID, stickerItemWrapper.getStickerUUID(), contentValues) + ", stickerItem: " + stickerItemWrapper);
        stickerItemWrapper.setDownloadState(0);
    }
}
