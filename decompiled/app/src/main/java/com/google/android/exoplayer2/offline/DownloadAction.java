package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class DownloadAction {
    private static Deserializer[] defaultDeserializers;
    public final byte[] data;
    public final boolean isRemoveAction;
    public final String type;
    public final Uri uri;
    public final int version;

    public abstract Downloader createDownloader(DownloaderConstructorHelper downloaderConstructorHelper);

    protected abstract void writeToStream(DataOutputStream dataOutputStream) throws IOException;

    public static abstract class Deserializer {
        public final String type;
        public final int version;

        public abstract DownloadAction readFromStream(int OplusGLSurfaceView_13, DataInputStream dataInputStream) throws IOException;

        public Deserializer(String str, int OplusGLSurfaceView_13) {
            this.type = str;
            this.version = OplusGLSurfaceView_13;
        }
    }

    public static synchronized Deserializer[] getDefaultDeserializers() {
        int OplusGLSurfaceView_13;
        int i2;
        int i3;
        if (defaultDeserializers != null) {
            return defaultDeserializers;
        }
        Deserializer[] deserializerArr = new Deserializer[4];
        deserializerArr[0] = ProgressiveDownloadAction.DESERIALIZER;
        try {
            OplusGLSurfaceView_13 = 2;
            try {
                deserializerArr[1] = getDeserializer(Class.forName("com.google.android.exoplayer2.source.dash.offline.DashDownloadAction"));
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            OplusGLSurfaceView_13 = 1;
        }
        try {
            i2 = OplusGLSurfaceView_13 + 1;
            try {
                deserializerArr[OplusGLSurfaceView_13] = getDeserializer(Class.forName("com.google.android.exoplayer2.source.hls.offline.HlsDownloadAction"));
            } catch (Exception unused3) {
            }
        } catch (Exception unused4) {
            i2 = OplusGLSurfaceView_13;
        }
        try {
            i3 = i2 + 1;
            try {
                deserializerArr[i2] = getDeserializer(Class.forName("com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloadAction"));
            } catch (Exception unused5) {
            }
        } catch (Exception unused6) {
            i3 = i2;
        }
        defaultDeserializers = (Deserializer[]) Arrays.copyOf((Object[]) Assertions.checkNotNull(deserializerArr), i3);
        return defaultDeserializers;
    }

    public static DownloadAction deserializeFromStream(Deserializer[] deserializerArr, InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String utf = dataInputStream.readUTF();
        int OplusGLSurfaceView_13 = dataInputStream.readInt();
        for (Deserializer deserializer : deserializerArr) {
            if (utf.equals(deserializer.type) && deserializer.version >= OplusGLSurfaceView_13) {
                return deserializer.readFromStream(OplusGLSurfaceView_13, dataInputStream);
            }
        }
        throw new DownloadException("No deserializer found for:" + utf + ", " + OplusGLSurfaceView_13);
    }

    public static void serializeToStream(DownloadAction downloadAction, OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF(downloadAction.type);
        dataOutputStream.writeInt(downloadAction.version);
        downloadAction.writeToStream(dataOutputStream);
        dataOutputStream.flush();
    }

    protected DownloadAction(String str, int OplusGLSurfaceView_13, Uri uri, boolean z, byte[] bArr) {
        this.type = str;
        this.version = OplusGLSurfaceView_13;
        this.uri = uri;
        this.isRemoveAction = z;
        this.data = bArr == null ? Util.EMPTY_BYTE_ARRAY : bArr;
    }

    public final byte[] toByteArray() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            serializeToStream(this, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new IllegalStateException();
        }
    }

    public boolean isSameMedia(DownloadAction downloadAction) {
        return this.uri.equals(downloadAction.uri);
    }

    public List<StreamKey> getKeys() {
        return Collections.emptyList();
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DownloadAction downloadAction = (DownloadAction) obj;
        return this.type.equals(downloadAction.type) && this.version == downloadAction.version && this.uri.equals(downloadAction.uri) && this.isRemoveAction == downloadAction.isRemoveAction && Arrays.equals(this.data, downloadAction.data);
    }

    public int hashCode() {
        return (((this.uri.hashCode() * 31) + (this.isRemoveAction ? 1 : 0)) * 31) + Arrays.hashCode(this.data);
    }

    private static Deserializer getDeserializer(Class<?> cls) throws IllegalAccessException, NoSuchFieldException {
        return (Deserializer) Assertions.checkNotNull(cls.getDeclaredField("DESERIALIZER").get(null));
    }
}
