package com.oplus.camera.aps.service;

import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPictureCallback;

/* loaded from: classes2.dex */
public class ThumbnailCategory {
    public ThumbnailItem mThumbnailItem = null;
    public CameraPictureCallback.CameraPictureResult mPictureResult = null;
    public CaptureMsgData mCaptureMsgData = null;
    public CameraPictureCallback.CameraPictureImage mCameraPictureImage = null;

    public boolean isValid() {
        CameraPictureCallback.CameraPictureResult cameraPictureResult;
        return this.mThumbnailItem != null && (cameraPictureResult = this.mPictureResult) != null && ((Boolean) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_IS_VALID)).booleanValue() && this.mThumbnailItem.mIdentity == ((Long) this.mPictureResult.get(CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY)).longValue() && ((Long) this.mPictureResult.get(CameraParameter.IMAGE_CATEGORY_IMAGE_TIME_STAMP)).equals(this.mPictureResult.get(CameraParameter.IMAGE_CATEGORY_META_TIME_STAMP));
    }

    public String toString() {
        if (isValid()) {
            return this.mThumbnailItem.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ThumbnailCategory is invalid! thumbnail.identity: ");
        ThumbnailItem thumbnailItem = this.mThumbnailItem;
        sb.append(thumbnailItem != null ? thumbnailItem.mIdentity : -1L);
        sb.append(", meta.mergeIdentity: ");
        CameraPictureCallback.CameraPictureResult cameraPictureResult = this.mPictureResult;
        sb.append(cameraPictureResult != null ? ((Long) cameraPictureResult.get(CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY)).longValue() : -1L);
        sb.append(", meta.timeStamp: ");
        CameraPictureCallback.CameraPictureResult cameraPictureResult2 = this.mPictureResult;
        sb.append(cameraPictureResult2 != null ? ((Long) cameraPictureResult2.get(CameraParameter.IMAGE_CATEGORY_META_TIME_STAMP)).longValue() : -1L);
        sb.append(", image.timeStamp: ");
        CameraPictureCallback.CameraPictureResult cameraPictureResult3 = this.mPictureResult;
        sb.append(cameraPictureResult3 != null ? ((Long) cameraPictureResult3.get(CameraParameter.IMAGE_CATEGORY_IMAGE_TIME_STAMP)).longValue() : -1L);
        return sb.toString();
    }
}
