package com.google.android.exoplayer2.source.hls.offline;

import android.net.Uri;
import com.google.android.exoplayer2.offline.DownloadAction;
import com.google.android.exoplayer2.offline.DownloaderConstructorHelper;
import com.google.android.exoplayer2.offline.SegmentDownloadAction;
import com.google.android.exoplayer2.offline.StreamKey;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class HlsDownloadAction extends SegmentDownloadAction {
    private static final int VERSION = 1;
    private static final String TYPE = "hls";
    public static final DownloadAction.Deserializer DESERIALIZER = new SegmentDownloadAction.SegmentDownloadActionDeserializer(TYPE, 1) { // from class: com.google.android.exoplayer2.source.hls.offline.HlsDownloadAction.1
        @Override // com.google.android.exoplayer2.offline.SegmentDownloadAction.SegmentDownloadActionDeserializer
        protected StreamKey readKey(int OplusGLSurfaceView_13, DataInputStream dataInputStream) throws IOException {
            if (OplusGLSurfaceView_13 > 0) {
                return super.readKey(OplusGLSurfaceView_13, dataInputStream);
            }
            return new StreamKey(dataInputStream.readInt(), dataInputStream.readInt());
        }

        @Override // com.google.android.exoplayer2.offline.SegmentDownloadAction.SegmentDownloadActionDeserializer
        protected DownloadAction createDownloadAction(Uri uri, boolean z, byte[] bArr, List<StreamKey> list) {
            return new HlsDownloadAction(uri, z, bArr, list);
        }
    };

    public static HlsDownloadAction createDownloadAction(Uri uri, byte[] bArr, List<StreamKey> list) {
        return new HlsDownloadAction(uri, false, bArr, list);
    }

    public static HlsDownloadAction createRemoveAction(Uri uri, byte[] bArr) {
        return new HlsDownloadAction(uri, true, bArr, Collections.emptyList());
    }

    @Deprecated
    public HlsDownloadAction(Uri uri, boolean z, byte[] bArr, List<StreamKey> list) {
        super(TYPE, 1, uri, z, bArr, list);
    }

    @Override // com.google.android.exoplayer2.offline.DownloadAction
    public HlsDownloader createDownloader(DownloaderConstructorHelper downloaderConstructorHelper) {
        return new HlsDownloader(this.uri, this.keys, downloaderConstructorHelper);
    }
}
