package com.oplus.camera.sticker.data;

/* loaded from: classes2.dex */
public class StickerItemWrapper extends com.oplus.camera.sticker.data.StickerItem implements com.oplus.camera.sticker.download.thumbnail.a_renamed {
    private static final java.lang.String TAG = "StickerItemWrapper";
    private java.lang.String mFilePath = null;
    private java.lang.String mThumbnailPath = null;
    private java.lang.String mLogoPath = null;

    public java.lang.String getFilePath() {
        return this.mFilePath;
    }

    public void setFilePath(java.lang.String str) {
        this.mFilePath = str;
    }

    public java.lang.String getThumbnailPath() {
        return this.mThumbnailPath;
    }

    public void setThumbnailPath(java.lang.String str) {
        this.mThumbnailPath = str;
    }

    public java.lang.String getLogoPath() {
        return this.mLogoPath;
    }

    public void setLogoPath(java.lang.String str) {
        this.mLogoPath = str;
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.a_renamed
    public java.lang.String getFirstDownloadUrl() {
        return getThumbnailUrl();
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.a_renamed
    public java.lang.String getFirstDownloadFileMd5() {
        return getThumbnailMd5();
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.a_renamed
    public void onFirstDownloadFinish(android.content.Context context, boolean z_renamed, java.lang.String str) {
        if (z_renamed) {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("thumbnail_file_uri", com.oplus.camera.sticker.provider.FileProvider.a_renamed(context, new java.io.File(str)).toString());
            contentValues.put("thumbnail_path", str);
            com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(context, com.heytap.accessory.constant.AFConstants.EXTRA_UUID, getStickerUUID(), contentValues);
        }
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.a_renamed
    public java.lang.String getSecondDownloadUrl() {
        return getLogoUrl();
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.a_renamed
    public java.lang.String getSecondDownloadFileMd5() {
        return getLogoMd5();
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.a_renamed
    public void onSecondDownloadFinish(android.content.Context context, boolean z_renamed, java.lang.String str) {
        if (z_renamed) {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("logo_file_uri", com.oplus.camera.sticker.provider.FileProvider.a_renamed(context, new java.io.File(str)).toString());
            contentValues.put("logo_path", str);
            com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(context, com.heytap.accessory.constant.AFConstants.EXTRA_UUID, getStickerUUID(), contentValues);
        }
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.a_renamed
    public java.lang.String getDownloadFilePath(android.content.Context context, java.lang.String str) {
        return com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(context, com.oplus.camera.sticker.c_renamed.b_renamed.l_renamed, com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(str));
    }

    public java.lang.String toDumpString() {
        return "[id_renamed: " + getStickerId() + ", name: " + getStickerName() + ", pos: " + getPosition() + ", reqTime: " + getLastRequestTime() + ", dState: " + getDownloadState() + ", dTime: " + getDownloadTime() + ", dUid: " + getDownloadUid() + ", cId: " + getCategoryId() + ", cPos: " + getCategoryPosition() + ", ver: " + getVersion() + ", pVer: " + getProtocolVersion() + ", attr: " + getAttribute() + ", buildIn: " + isBuildIn() + ", hasMusic: " + hasMusic() + ", nUpdate: " + needUpdate() + ", isNew: " + isStickerNew() + ", valid: " + isValid() + ", uuid: " + getStickerUUID() + ", fileMd5: " + getFileMd5() + ", thumbMd5: " + getThumbnailMd5() + ", logoMd5: " + getLogoMd5() + "]";
    }
}
