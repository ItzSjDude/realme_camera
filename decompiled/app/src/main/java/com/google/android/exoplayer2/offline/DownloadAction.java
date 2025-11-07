package com.google.android.exoplayer2.offline;

/* loaded from: classes.dex */
public abstract class DownloadAction {
    private static com.google.android.exoplayer2.offline.DownloadAction.Deserializer[] defaultDeserializers;
    public final byte[] data;
    public final boolean isRemoveAction;
    public final java.lang.String type;
    public final android.net.Uri uri;
    public final int version;

    public abstract com.google.android.exoplayer2.offline.Downloader createDownloader(com.google.android.exoplayer2.offline.DownloaderConstructorHelper downloaderConstructorHelper);

    protected abstract void writeToStream(java.io.DataOutputStream dataOutputStream) throws java.io.IOException;

    public static abstract class Deserializer {
        public final java.lang.String type;
        public final int version;

        public abstract com.google.android.exoplayer2.offline.DownloadAction readFromStream(int i_renamed, java.io.DataInputStream dataInputStream) throws java.io.IOException;

        public Deserializer(java.lang.String str, int i_renamed) {
            this.type = str;
            this.version = i_renamed;
        }
    }

    public static synchronized com.google.android.exoplayer2.offline.DownloadAction.Deserializer[] getDefaultDeserializers() {
        int i_renamed;
        int i2;
        int i3;
        if (defaultDeserializers != null) {
            return defaultDeserializers;
        }
        com.google.android.exoplayer2.offline.DownloadAction.Deserializer[] deserializerArr = new com.google.android.exoplayer2.offline.DownloadAction.Deserializer[4];
        deserializerArr[0] = com.google.android.exoplayer2.offline.ProgressiveDownloadAction.DESERIALIZER;
        try {
            i_renamed = 2;
            try {
                deserializerArr[1] = getDeserializer(java.lang.Class.forName("com.google.android.exoplayer2.source.dash.offline.DashDownloadAction"));
            } catch (java.lang.Exception unused) {
            }
        } catch (java.lang.Exception unused2) {
            i_renamed = 1;
        }
        try {
            i2 = i_renamed + 1;
            try {
                deserializerArr[i_renamed] = getDeserializer(java.lang.Class.forName("com.google.android.exoplayer2.source.hls.offline.HlsDownloadAction"));
            } catch (java.lang.Exception unused3) {
            }
        } catch (java.lang.Exception unused4) {
            i2 = i_renamed;
        }
        try {
            i3 = i2 + 1;
            try {
                deserializerArr[i2] = getDeserializer(java.lang.Class.forName("com.google.android.exoplayer2.source.smoothstreaming.offline.SsDownloadAction"));
            } catch (java.lang.Exception unused5) {
            }
        } catch (java.lang.Exception unused6) {
            i3 = i2;
        }
        defaultDeserializers = (com.google.android.exoplayer2.offline.DownloadAction.Deserializer[]) java.util.Arrays.copyOf((java.lang.Object[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(deserializerArr), i3);
        return defaultDeserializers;
    }

    public static com.google.android.exoplayer2.offline.DownloadAction deserializeFromStream(com.google.android.exoplayer2.offline.DownloadAction.Deserializer[] deserializerArr, java.io.InputStream inputStream) throws java.io.IOException {
        java.io.DataInputStream dataInputStream = new java.io.DataInputStream(inputStream);
        java.lang.String utf = dataInputStream.readUTF();
        int i_renamed = dataInputStream.readInt();
        for (com.google.android.exoplayer2.offline.DownloadAction.Deserializer deserializer : deserializerArr) {
            if (utf.equals(deserializer.type) && deserializer.version >= i_renamed) {
                return deserializer.readFromStream(i_renamed, dataInputStream);
            }
        }
        throw new com.google.android.exoplayer2.offline.DownloadException("No deserializer found for:" + utf + ", " + i_renamed);
    }

    public static void serializeToStream(com.google.android.exoplayer2.offline.DownloadAction downloadAction, java.io.OutputStream outputStream) throws java.io.IOException {
        java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(outputStream);
        dataOutputStream.writeUTF(downloadAction.type);
        dataOutputStream.writeInt(downloadAction.version);
        downloadAction.writeToStream(dataOutputStream);
        dataOutputStream.flush();
    }

    protected DownloadAction(java.lang.String str, int i_renamed, android.net.Uri uri, boolean z_renamed, byte[] bArr) {
        this.type = str;
        this.version = i_renamed;
        this.uri = uri;
        this.isRemoveAction = z_renamed;
        this.data = bArr == null ? com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY : bArr;
    }

    public final byte[] toByteArray() {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            serializeToStream(this, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (java.io.IOException unused) {
            throw new java.lang.IllegalStateException();
        }
    }

    public boolean isSameMedia(com.google.android.exoplayer2.offline.DownloadAction downloadAction) {
        return this.uri.equals(downloadAction.uri);
    }

    public java.util.List<com.google.android.exoplayer2.offline.StreamKey> getKeys() {
        return java.util.Collections.emptyList();
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.offline.DownloadAction downloadAction = (com.google.android.exoplayer2.offline.DownloadAction) obj;
        return this.type.equals(downloadAction.type) && this.version == downloadAction.version && this.uri.equals(downloadAction.uri) && this.isRemoveAction == downloadAction.isRemoveAction && java.util.Arrays.equals(this.data, downloadAction.data);
    }

    public int hashCode() {
        return (((this.uri.hashCode() * 31) + (this.isRemoveAction ? 1 : 0)) * 31) + java.util.Arrays.hashCode(this.data);
    }

    private static com.google.android.exoplayer2.offline.DownloadAction.Deserializer getDeserializer(java.lang.Class<?> cls) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        return (com.google.android.exoplayer2.offline.DownloadAction.Deserializer) com.google.android.exoplayer2.util.Assertions.checkNotNull(cls.getDeclaredField("DESERIALIZER").get(null));
    }
}
