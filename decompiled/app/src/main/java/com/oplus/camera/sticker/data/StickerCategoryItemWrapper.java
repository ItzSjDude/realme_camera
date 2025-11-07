package com.oplus.camera.sticker.data;

/* loaded from: classes2.dex */
public class StickerCategoryItemWrapper extends com.oplus.camera.sticker.data.StickerCategoryItem implements com.oplus.camera.sticker.download.thumbnail.a_renamed {
    private static final java.lang.String TAG = "StickerCategoryItemWrapper";
    private java.lang.String mIconPath = null;
    private java.lang.String mIconHighlightPath = null;

    public StickerCategoryItemWrapper() {
    }

    public StickerCategoryItemWrapper(com.oplus.camera.sticker.data.StickerCategoryItem stickerCategoryItem) {
        setCategoryName(stickerCategoryItem.getCategoryName());
        setIconUrl(stickerCategoryItem.getIconUrl());
        setIconFileUri(stickerCategoryItem.getIconFileUri());
        setIconMd5(stickerCategoryItem.getIconMd5());
        setIconHighlightUrl(stickerCategoryItem.getIconHighlightUrl());
        setIconHighlightFileUri(stickerCategoryItem.getIconHighlightFileUri());
        setIconHighlightMd5(stickerCategoryItem.getIconHighlightMd5());
        setLastRequestTime(stickerCategoryItem.getLastRequestTime());
        setReadableId(stickerCategoryItem.getReadableId());
        setPosition(stickerCategoryItem.getPosition());
        setCategoryNew(stickerCategoryItem.isCategoryNew());
        setCategoryValid(stickerCategoryItem.isCategoryValid());
    }

    public java.lang.String getIconPath() {
        return this.mIconPath;
    }

    public void setIconPath(java.lang.String str) {
        this.mIconPath = str;
    }

    public java.lang.String getIconHighlightPath() {
        return this.mIconHighlightPath;
    }

    public void setIconHighlightPath(java.lang.String str) {
        this.mIconHighlightPath = str;
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.a_renamed
    public java.lang.String getFirstDownloadUrl() {
        return getIconUrl();
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.a_renamed
    public java.lang.String getFirstDownloadFileMd5() {
        return getIconMd5();
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.a_renamed
    public void onFirstDownloadFinish(android.content.Context context, boolean z_renamed, java.lang.String str) {
        if (z_renamed) {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("icon_file_uri", com.oplus.camera.sticker.provider.FileProvider.a_renamed(context, new java.io.File(str)).toString());
            contentValues.put("icon_path", str);
            com.oplus.camera.sticker.a_renamed.a_renamed.a_renamed(context, "readable_id", getReadableId(), contentValues);
            com.oplus.camera.e_renamed.a_renamed(TAG, "onFirstDownloadFinish, getCategoryName: " + toDumpString());
        }
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.a_renamed
    public java.lang.String getSecondDownloadUrl() {
        return getIconHighlightUrl();
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.a_renamed
    public java.lang.String getSecondDownloadFileMd5() {
        return getIconHighlightMd5();
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.a_renamed
    public void onSecondDownloadFinish(android.content.Context context, boolean z_renamed, java.lang.String str) {
        if (z_renamed) {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("icon_highlight_file_uri", com.oplus.camera.sticker.provider.FileProvider.a_renamed(context, new java.io.File(str)).toString());
            contentValues.put("icon_highlight_path", str);
            com.oplus.camera.sticker.a_renamed.a_renamed.a_renamed(context, "readable_id", getReadableId(), contentValues);
            com.oplus.camera.e_renamed.a_renamed(TAG, "onSecondDownloadFinish, getCategoryName: " + toDumpString());
        }
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.a_renamed
    public java.lang.String getDownloadFilePath(android.content.Context context, java.lang.String str) {
        return com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(context, com.oplus.camera.sticker.c_renamed.b_renamed.g_renamed, com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(str));
    }

    public java.lang.String toDumpString() {
        return "[id_renamed: " + getReadableId() + ", pos: " + getPosition() + ", reqTime: " + getLastRequestTime() + ", isNew: " + isCategoryNew() + ", valid: " + isCategoryValid() + ", name: " + getCategoryName() + ", iconPath: " + getIconPath() + ", iconMd5: " + getIconMd5() + ", iconHPath: " + getIconHighlightPath() + ", iconHMd5: " + getIconHighlightMd5() + "]";
    }
}
