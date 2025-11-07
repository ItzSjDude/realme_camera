package com.oplus.camera.sticker.download.thumbnail;

import android.content.Context;

/* compiled from: IThumbDownloadTask.java */
/* renamed from: com.oplus.camera.sticker.download.thumbnail.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public interface IThumbDownloadTask {
    String getDownloadFilePath(Context context, String str);

    String getFirstDownloadFileMd5();

    String getFirstDownloadUrl();

    String getSecondDownloadFileMd5();

    String getSecondDownloadUrl();

    void onFirstDownloadFinish(Context context, boolean z, String str);

    void onSecondDownloadFinish(Context context, boolean z, String str);
}
