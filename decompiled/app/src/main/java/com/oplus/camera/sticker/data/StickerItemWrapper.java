package com.oplus.camera.sticker.data;

import android.content.ContentValues;
import android.content.Context;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.camera.sticker.download.thumbnail.IThumbDownloadTask;
import com.oplus.camera.sticker.p165a.StickerItemTableHelper;
import com.oplus.camera.sticker.p167c.FileUtils;
import com.oplus.camera.sticker.provider.FileProvider;
import java.io.File;

/* loaded from: classes2.dex */
public class StickerItemWrapper extends StickerItem implements IThumbDownloadTask {
    private static final String TAG = "StickerItemWrapper";
    private String mFilePath = null;
    private String mThumbnailPath = null;
    private String mLogoPath = null;

    public String getFilePath() {
        return this.mFilePath;
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
    }

    public String getThumbnailPath() {
        return this.mThumbnailPath;
    }

    public void setThumbnailPath(String str) {
        this.mThumbnailPath = str;
    }

    public String getLogoPath() {
        return this.mLogoPath;
    }

    public void setLogoPath(String str) {
        this.mLogoPath = str;
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.IThumbDownloadTask
    public String getFirstDownloadUrl() {
        return getThumbnailUrl();
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.IThumbDownloadTask
    public String getFirstDownloadFileMd5() {
        return getThumbnailMd5();
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.IThumbDownloadTask
    public void onFirstDownloadFinish(Context context, boolean z, String str) {
        if (z) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("thumbnail_file_uri", FileProvider.m16976a(context, new File(str)).toString());
            contentValues.put("thumbnail_path", str);
            StickerItemTableHelper.m16749a(context, AFConstants.EXTRA_UUID, getStickerUUID(), contentValues);
        }
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.IThumbDownloadTask
    public String getSecondDownloadUrl() {
        return getLogoUrl();
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.IThumbDownloadTask
    public String getSecondDownloadFileMd5() {
        return getLogoMd5();
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.IThumbDownloadTask
    public void onSecondDownloadFinish(Context context, boolean z, String str) {
        if (z) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("logo_file_uri", FileProvider.m16976a(context, new File(str)).toString());
            contentValues.put("logo_path", str);
            StickerItemTableHelper.m16749a(context, AFConstants.EXTRA_UUID, getStickerUUID(), contentValues);
        }
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.IThumbDownloadTask
    public String getDownloadFilePath(Context context, String str) {
        return FileUtils.m16809a(context, FileUtils.f16224l, FileUtils.m16810a(str));
    }

    public String toDumpString() {
        return "[id_renamed: " + getStickerId() + ", name: " + getStickerName() + ", pos: " + getPosition() + ", reqTime: " + getLastRequestTime() + ", dState: " + getDownloadState() + ", dTime: " + getDownloadTime() + ", dUid: " + getDownloadUid() + ", cId: " + getCategoryId() + ", cPos: " + getCategoryPosition() + ", ver: " + getVersion() + ", pVer: " + getProtocolVersion() + ", attr: " + getAttribute() + ", buildIn: " + isBuildIn() + ", hasMusic: " + hasMusic() + ", nUpdate: " + needUpdate() + ", isNew: " + isStickerNew() + ", valid: " + isValid() + ", uuid: " + getStickerUUID() + ", fileMd5: " + getFileMd5() + ", thumbMd5: " + getThumbnailMd5() + ", logoMd5: " + getLogoMd5() + "]";
    }
}
