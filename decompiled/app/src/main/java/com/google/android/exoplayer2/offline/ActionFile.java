package com.google.android.exoplayer2.offline;

/* loaded from: classes.dex */
public final class ActionFile {
    static final int VERSION = 0;
    private final java.io.File actionFile;
    private final com.google.android.exoplayer2.util.AtomicFile atomicFile;

    public ActionFile(java.io.File file) {
        this.actionFile = file;
        this.atomicFile = new com.google.android.exoplayer2.util.AtomicFile(file);
    }

    public com.google.android.exoplayer2.offline.DownloadAction[] load(com.google.android.exoplayer2.offline.DownloadAction.Deserializer... deserializerArr) throws java.io.IOException {
        if (!this.actionFile.exists()) {
            return new com.google.android.exoplayer2.offline.DownloadAction[0];
        }
        try {
            java.io.InputStream inputStreamOpenRead = this.atomicFile.openRead();
            java.io.DataInputStream dataInputStream = new java.io.DataInputStream(inputStreamOpenRead);
            int i_renamed = dataInputStream.readInt();
            if (i_renamed > 0) {
                throw new java.io.IOException("Unsupported action file version: " + i_renamed);
            }
            int i2 = dataInputStream.readInt();
            com.google.android.exoplayer2.offline.DownloadAction[] downloadActionArr = new com.google.android.exoplayer2.offline.DownloadAction[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                downloadActionArr[i3] = com.google.android.exoplayer2.offline.DownloadAction.deserializeFromStream(deserializerArr, dataInputStream);
            }
            com.google.android.exoplayer2.util.Util.closeQuietly(inputStreamOpenRead);
            return downloadActionArr;
        } catch (java.lang.Throwable th) {
            com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) null);
            throw th;
        }
    }

    public void store(com.google.android.exoplayer2.offline.DownloadAction... downloadActionArr) throws java.lang.Throwable {
        java.io.DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new java.io.DataOutputStream(this.atomicFile.startWrite());
            try {
                dataOutputStream.writeInt(0);
                dataOutputStream.writeInt(downloadActionArr.length);
                for (com.google.android.exoplayer2.offline.DownloadAction downloadAction : downloadActionArr) {
                    com.google.android.exoplayer2.offline.DownloadAction.serializeToStream(downloadAction, dataOutputStream);
                }
                this.atomicFile.endWrite(dataOutputStream);
                com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) null);
            } catch (java.lang.Throwable th) {
                th = th;
                com.google.android.exoplayer2.util.Util.closeQuietly(dataOutputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            dataOutputStream = null;
        }
    }
}
