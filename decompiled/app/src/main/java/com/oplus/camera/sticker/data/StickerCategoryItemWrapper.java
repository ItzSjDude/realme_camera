package com.oplus.camera.sticker.data;

import android.content.ContentValues;
import android.content.Context;
import com.oplus.camera.CameraLog;
import com.oplus.camera.sticker.download.thumbnail.IThumbDownloadTask;
import com.oplus.camera.sticker.p165a.StickerCategoryTableHelper;
import com.oplus.camera.sticker.p167c.FileUtils;
import com.oplus.camera.sticker.provider.FileProvider;
import java.io.File;

/* loaded from: classes2.dex */
public class StickerCategoryItemWrapper extends StickerCategoryItem implements IThumbDownloadTask {
    private static final String TAG = "StickerCategoryItemWrapper";
    private String mIconPath = null;
    private String mIconHighlightPath = null;

    public StickerCategoryItemWrapper() {
    }

    public StickerCategoryItemWrapper(StickerCategoryItem stickerCategoryItem) {
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

    public String getIconPath() {
        return this.mIconPath;
    }

    public void setIconPath(String str) {
        this.mIconPath = str;
    }

    public String getIconHighlightPath() {
        return this.mIconHighlightPath;
    }

    public void setIconHighlightPath(String str) {
        this.mIconHighlightPath = str;
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.IThumbDownloadTask
    public String getFirstDownloadUrl() {
        return getIconUrl();
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.IThumbDownloadTask
    public String getFirstDownloadFileMd5() {
        return getIconMd5();
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.IThumbDownloadTask
    public void onFirstDownloadFinish(Context context, boolean z, String str) {
        if (z) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("icon_file_uri", FileProvider.m16976a(context, new File(str)).toString());
            contentValues.put("icon_path", str);
            StickerCategoryTableHelper.m16740a(context, "readable_id", getReadableId(), contentValues);
            CameraLog.m12954a(TAG, "onFirstDownloadFinish, getCategoryName: " + toDumpString());
        }
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.IThumbDownloadTask
    public String getSecondDownloadUrl() {
        return getIconHighlightUrl();
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.IThumbDownloadTask
    public String getSecondDownloadFileMd5() {
        return getIconHighlightMd5();
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.IThumbDownloadTask
    public void onSecondDownloadFinish(Context context, boolean z, String str) {
        if (z) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("icon_highlight_file_uri", FileProvider.m16976a(context, new File(str)).toString());
            contentValues.put("icon_highlight_path", str);
            StickerCategoryTableHelper.m16740a(context, "readable_id", getReadableId(), contentValues);
            CameraLog.m12954a(TAG, "onSecondDownloadFinish, getCategoryName: " + toDumpString());
        }
    }

    @Override // com.oplus.camera.sticker.download.thumbnail.IThumbDownloadTask
    public String getDownloadFilePath(Context context, String str) {
        return FileUtils.m16809a(context, FileUtils.f16219g, FileUtils.m16810a(str));
    }

    public String toDumpString() {
        return "[id_renamed: " + getReadableId() + ", pos: " + getPosition() + ", reqTime: " + getLastRequestTime() + ", isNew: " + isCategoryNew() + ", valid: " + isCategoryValid() + ", name: " + getCategoryName() + ", iconPath: " + getIconPath() + ", iconMd5: " + getIconMd5() + ", iconHPath: " + getIconHighlightPath() + ", iconHMd5: " + getIconHighlightMd5() + "]";
    }
}
