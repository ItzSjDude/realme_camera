package com.oplus.camera.aps.service;

/* loaded from: classes2.dex */
public class ThumbnailCategory {
    public com.oplus.camera.aps.service.ThumbnailItem mThumbnailItem = null;
    public com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult mPictureResult = null;
    public com.oplus.camera.statistics.model.CaptureMsgData mCaptureMsgData = null;
    public com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage mCameraPictureImage = null;

    public boolean isValid() {
        com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult;
        return this.mThumbnailItem != null && (cameraPictureResult = this.mPictureResult) != null && ((java.lang.Boolean) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_IS_VALID)).booleanValue() && this.mThumbnailItem.mIdentity == ((java.lang.Long) this.mPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY)).longValue() && ((java.lang.Long) this.mPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_IMAGE_TIME_STAMP)).equals(this.mPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_META_TIME_STAMP));
    }

    public java.lang.String toString() {
        if (isValid()) {
            return this.mThumbnailItem.toString();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("ThumbnailCategory is_renamed invalid! thumbnail.identity: ");
        com.oplus.camera.aps.service.ThumbnailItem thumbnailItem = this.mThumbnailItem;
        sb.append(thumbnailItem != null ? thumbnailItem.mIdentity : -1L);
        sb.append(", meta.mergeIdentity: ");
        com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult = this.mPictureResult;
        sb.append(cameraPictureResult != null ? ((java.lang.Long) cameraPictureResult.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_MERGE_IDENTITY)).longValue() : -1L);
        sb.append(", meta.timeStamp: ");
        com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult2 = this.mPictureResult;
        sb.append(cameraPictureResult2 != null ? ((java.lang.Long) cameraPictureResult2.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_META_TIME_STAMP)).longValue() : -1L);
        sb.append(", image.timeStamp: ");
        com.oplus.ocs.camera.CameraPictureCallback.CameraPictureResult cameraPictureResult3 = this.mPictureResult;
        sb.append(cameraPictureResult3 != null ? ((java.lang.Long) cameraPictureResult3.get(com.oplus.ocs.camera.CameraParameter.IMAGE_CATEGORY_IMAGE_TIME_STAMP)).longValue() : -1L);
        return sb.toString();
    }
}
