package com.oplus.camera.sticker.download.thumbnail;

/* compiled from: IThumbDownloadTask.java */
/* loaded from: classes2.dex */
public interface a_renamed {
    java.lang.String getDownloadFilePath(android.content.Context context, java.lang.String str);

    java.lang.String getFirstDownloadFileMd5();

    java.lang.String getFirstDownloadUrl();

    java.lang.String getSecondDownloadFileMd5();

    java.lang.String getSecondDownloadUrl();

    void onFirstDownloadFinish(android.content.Context context, boolean z_renamed, java.lang.String str);

    void onSecondDownloadFinish(android.content.Context context, boolean z_renamed, java.lang.String str);
}
