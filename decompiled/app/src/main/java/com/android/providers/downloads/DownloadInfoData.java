package com.android.providers.downloads;

/* loaded from: classes.dex */
public class DownloadInfoData {
    public long mCurrentBytes;
    public java.lang.String mDescription;
    public int mDestination;
    public long mDownloadSpeed;
    public java.lang.String mErrorMsg;
    public java.lang.String mExtra;
    public java.lang.String mFileName;
    public java.lang.String mHint;
    public long mId;
    public long mLastMod;
    public java.lang.String mMimeType;
    public java.lang.String mPackage;
    public long mReason;
    public int mStatisticsId;
    public int mStatus;
    public java.lang.String mTitle;
    public long mTotalBytes;
    public int mUIVisibility;
    public java.lang.String mUri;
    public java.lang.String mUuid;

    public static class BaseReader {
        protected final android.database.Cursor mCursor;
        protected final android.content.ContentResolver mResolver;

        public BaseReader(android.content.ContentResolver contentResolver, android.database.Cursor cursor) {
            this.mResolver = contentResolver;
            this.mCursor = cursor;
        }

        public com.android.providers.downloads.DownloadInfoData newDownloadInfoSimple() {
            com.android.providers.downloads.DownloadInfoData downloadInfoData = new com.android.providers.downloads.DownloadInfoData();
            updateFromDatabaseSimple(downloadInfoData);
            return downloadInfoData;
        }

        public void updateFromDatabaseSimple(com.android.providers.downloads.DownloadInfoData downloadInfoData) {
            downloadInfoData.mId = getLong("_id").longValue();
            downloadInfoData.mUri = getString(com.android.providers.downloads.Downloads.Impl.COLUMN_URI);
            downloadInfoData.mHint = getString(com.android.providers.downloads.Downloads.Impl.COLUMN_FILE_NAME_HINT);
            downloadInfoData.mFileName = getString("local_filename");
            downloadInfoData.mMimeType = android.content.Intent.normalizeMimeType(getString("media_type"));
            downloadInfoData.mTitle = getString("title");
            downloadInfoData.mDescription = getString(com.android.providers.downloads.Downloads.Impl.COLUMN_DESCRIPTION);
            downloadInfoData.mErrorMsg = getString(com.android.providers.downloads.Downloads.Impl.COLUMN_ERROR_MSG);
            downloadInfoData.mDestination = getInt(com.android.providers.downloads.Downloads.Impl.COLUMN_DESTINATION).intValue();
            int iIntValue = getInt("status_detailed").intValue();
            downloadInfoData.mStatus = com.oplus.d_renamed.a_renamed.a_renamed.DownloadManager_6.b_renamed(iIntValue);
            downloadInfoData.mReason = com.oplus.d_renamed.a_renamed.a_renamed.DownloadManager_6.a_renamed(iIntValue);
            downloadInfoData.mLastMod = getLong("last_modified_timestamp").longValue();
            downloadInfoData.mPackage = getString(com.android.providers.downloads.Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE);
            downloadInfoData.mTotalBytes = getLong("total_size").longValue();
            downloadInfoData.mCurrentBytes = getLong("bytes_so_far").longValue();
            downloadInfoData.mUIVisibility = getInt(com.android.providers.downloads.Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI).intValue();
            downloadInfoData.mDownloadSpeed = getLong("download_speed").longValue();
            downloadInfoData.mExtra = getString("extra");
            downloadInfoData.mUuid = getString(com.heytap.accessory.constant.AFConstants.EXTRA_UUID);
            downloadInfoData.mStatisticsId = getInt("statistics_id").intValue();
        }

        protected java.lang.String getString(java.lang.String str) throws java.lang.IllegalArgumentException {
            int columnIndexOrThrow = this.mCursor.getColumnIndexOrThrow(str);
            java.lang.String string = columnIndexOrThrow >= 0 ? this.mCursor.getString(columnIndexOrThrow) : null;
            if (android.text.TextUtils.isEmpty(string)) {
                return null;
            }
            return string;
        }

        protected java.lang.Integer getInt(java.lang.String str) {
            int columnIndex = this.mCursor.getColumnIndex(str);
            return java.lang.Integer.valueOf(columnIndex >= 0 ? this.mCursor.getInt(columnIndex) : -1);
        }

        protected java.lang.Long getLong(java.lang.String str) {
            int columnIndex = this.mCursor.getColumnIndex(str);
            return java.lang.Long.valueOf(columnIndex >= 0 ? this.mCursor.getLong(columnIndex) : -1L);
        }
    }

    public java.lang.String toString() {
        return "DownloadInfoData [mId=" + this.mId + ", mUri=" + this.mUri + ", mFileName=" + this.mFileName + ", mMimeType=" + this.mMimeType + ", mStatus=" + this.mStatus + ", mTotalBytes=" + this.mTotalBytes + ", mCurrentBytes=" + this.mCurrentBytes + ", mDestination=" + this.mDestination + ", mErrorMsg=" + this.mErrorMsg + ", mReason=" + this.mReason + ", mPackage=" + this.mPackage + ", mUuid=" + this.mUuid + "]";
    }
}
