package com.google.android.exoplayer2.source.dash.offline;

import android.net.Uri;
import com.google.android.exoplayer2.offline.DownloadAction;
import com.google.android.exoplayer2.offline.DownloaderConstructorHelper;
import com.google.android.exoplayer2.offline.SegmentDownloadAction;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class DashDownloadAction extends SegmentDownloadAction {
    private static final int VERSION = 0;
    private static final String TYPE = "dash";
    public static final DownloadAction.Deserializer DESERIALIZER = new SegmentDownloadAction.SegmentDownloadActionDeserializer(TYPE, 0) { // from class: com.google.android.exoplayer2.source.dash.offline.DashDownloadAction.1
        @Override // com.google.android.exoplayer2.offline.SegmentDownloadAction.SegmentDownloadActionDeserializer
        protected DownloadAction createDownloadAction(Uri uri, boolean z, byte[] bArr, List<StreamKey> list) {
            return new DashDownloadAction(uri, z, bArr, list);
        }
    };

    public static DashDownloadAction createDownloadAction(Uri uri, byte[] bArr, List<StreamKey> list) {
        return new DashDownloadAction(uri, false, bArr, list);
    }

    public static DashDownloadAction createRemoveAction(Uri uri, byte[] bArr) {
        return new DashDownloadAction(uri, true, bArr, Collections.emptyList());
    }

    @Deprecated
    public DashDownloadAction(Uri uri, boolean z, byte[] bArr, List<StreamKey> list) {
        super(TYPE, 0, uri, z, bArr, list);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadAction
    public DashDownloader createDownloader(DownloaderConstructorHelper downloaderConstructorHelper) {
        return new DashDownloader(this.uri, this.keys, downloaderConstructorHelper);
    }
}
