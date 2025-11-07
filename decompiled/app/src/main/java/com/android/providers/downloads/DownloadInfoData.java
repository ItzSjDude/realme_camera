package com.android.providers.downloads;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import com.android.providers.downloads.Downloads;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.p188d.p189a.DownloadManager;

/* loaded from: classes.dex */
public class DownloadInfoData {
    public long mCurrentBytes;
    public String mDescription;
    public int mDestination;
    public long mDownloadSpeed;
    public String mErrorMsg;
    public String mExtra;
    public String mFileName;
    public String mHint;
    public long mId;
    public long mLastMod;
    public String mMimeType;
    public String mPackage;
    public long mReason;
    public int mStatisticsId;
    public int mStatus;
    public String mTitle;
    public long mTotalBytes;
    public int mUIVisibility;
    public String mUri;
    public String mUuid;

    public static class BaseReader {
        protected final Cursor mCursor;
        protected final ContentResolver mResolver;

        public BaseReader(ContentResolver contentResolver, Cursor cursor) {
            this.mResolver = contentResolver;
            this.mCursor = cursor;
        }

        public DownloadInfoData newDownloadInfoSimple() {
            DownloadInfoData downloadInfoData = new DownloadInfoData();
            updateFromDatabaseSimple(downloadInfoData);
            return downloadInfoData;
        }

        public void updateFromDatabaseSimple(DownloadInfoData downloadInfoData) {
            downloadInfoData.mId = getLong("_id").longValue();
            downloadInfoData.mUri = getString(Downloads.Impl.COLUMN_URI);
            downloadInfoData.mHint = getString(Downloads.Impl.COLUMN_FILE_NAME_HINT);
            downloadInfoData.mFileName = getString("local_filename");
            downloadInfoData.mMimeType = Intent.normalizeMimeType(getString("media_type"));
            downloadInfoData.mTitle = getString("title");
            downloadInfoData.mDescription = getString(Downloads.Impl.COLUMN_DESCRIPTION);
            downloadInfoData.mErrorMsg = getString(Downloads.Impl.COLUMN_ERROR_MSG);
            downloadInfoData.mDestination = getInt(Downloads.Impl.COLUMN_DESTINATION).intValue();
            int iIntValue = getInt("status_detailed").intValue();
            downloadInfoData.mStatus = DownloadManager.PlatformImplementations.kt_3.m24957b(iIntValue);
            downloadInfoData.mReason = DownloadManager.PlatformImplementations.kt_3.m24955a(iIntValue);
            downloadInfoData.mLastMod = getLong("last_modified_timestamp").longValue();
            downloadInfoData.mPackage = getString(Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE);
            downloadInfoData.mTotalBytes = getLong("total_size").longValue();
            downloadInfoData.mCurrentBytes = getLong("bytes_so_far").longValue();
            downloadInfoData.mUIVisibility = getInt(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI).intValue();
            downloadInfoData.mDownloadSpeed = getLong("download_speed").longValue();
            downloadInfoData.mExtra = getString("extra");
            downloadInfoData.mUuid = getString(AFConstants.EXTRA_UUID);
            downloadInfoData.mStatisticsId = getInt("statistics_id").intValue();
        }

        protected String getString(String str) throws IllegalArgumentException {
            int columnIndexOrThrow = this.mCursor.getColumnIndexOrThrow(str);
            String string = columnIndexOrThrow >= 0 ? this.mCursor.getString(columnIndexOrThrow) : null;
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return string;
        }

        protected Integer getInt(String str) {
            int columnIndex = this.mCursor.getColumnIndex(str);
            return Integer.valueOf(columnIndex >= 0 ? this.mCursor.getInt(columnIndex) : -1);
        }

        protected Long getLong(String str) {
            int columnIndex = this.mCursor.getColumnIndex(str);
            return Long.valueOf(columnIndex >= 0 ? this.mCursor.getLong(columnIndex) : -1L);
        }
    }

    public String toString() {
        return "DownloadInfoData [mId=" + this.mId + ", mUri=" + this.mUri + ", mFileName=" + this.mFileName + ", mMimeType=" + this.mMimeType + ", mStatus=" + this.mStatus + ", mTotalBytes=" + this.mTotalBytes + ", mCurrentBytes=" + this.mCurrentBytes + ", mDestination=" + this.mDestination + ", mErrorMsg=" + this.mErrorMsg + ", mReason=" + this.mReason + ", mPackage=" + this.mPackage + ", mUuid=" + this.mUuid + "]";
    }
}
