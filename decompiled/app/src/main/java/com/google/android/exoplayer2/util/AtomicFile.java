package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class AtomicFile {
    private static final java.lang.String TAG = "AtomicFile";
    private final java.io.File backupName;
    private final java.io.File baseName;

    public AtomicFile(java.io.File file) {
        this.baseName = file;
        this.backupName = new java.io.File(file.getPath() + ".bak");
    }

    public void delete() {
        this.baseName.delete();
        this.backupName.delete();
    }

    public java.io.OutputStream startWrite() throws java.io.IOException {
        if (this.baseName.exists()) {
            if (!this.backupName.exists()) {
                if (!this.baseName.renameTo(this.backupName)) {
                    com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Couldn't_renamed rename file " + this.baseName + " to backup file " + this.backupName);
                }
            } else {
                this.baseName.delete();
            }
        }
        try {
            return new com.google.android.exoplayer2.util.AtomicFile.AtomicFileOutputStream(this.baseName);
        } catch (java.io.FileNotFoundException e_renamed) {
            java.io.File parentFile = this.baseName.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new java.io.IOException("Couldn't_renamed create directory " + this.baseName, e_renamed);
            }
            try {
                return new com.google.android.exoplayer2.util.AtomicFile.AtomicFileOutputStream(this.baseName);
            } catch (java.io.FileNotFoundException e2) {
                throw new java.io.IOException("Couldn't_renamed create " + this.baseName, e2);
            }
        }
    }

    public void endWrite(java.io.OutputStream outputStream) throws java.io.IOException {
        outputStream.close();
        this.backupName.delete();
    }

    public java.io.InputStream openRead() throws java.io.FileNotFoundException {
        restoreBackup();
        return new java.io.FileInputStream(this.baseName);
    }

    private void restoreBackup() {
        if (this.backupName.exists()) {
            this.baseName.delete();
            this.backupName.renameTo(this.baseName);
        }
    }

    private static final class AtomicFileOutputStream extends java.io.OutputStream {
        private boolean closed = false;
        private final java.io.FileOutputStream fileOutputStream;

        public AtomicFileOutputStream(java.io.File file) throws java.io.FileNotFoundException {
            this.fileOutputStream = new java.io.FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            flush();
            try {
                this.fileOutputStream.getFD().sync();
            } catch (java.io.IOException e_renamed) {
                com.google.android.exoplayer2.util.Log.w_renamed(com.google.android.exoplayer2.util.AtomicFile.TAG, "Failed to sync file descriptor:", e_renamed);
            }
            this.fileOutputStream.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws java.io.IOException {
            this.fileOutputStream.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i_renamed) throws java.io.IOException {
            this.fileOutputStream.write(i_renamed);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws java.io.IOException {
            this.fileOutputStream.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
            this.fileOutputStream.write(bArr, i_renamed, i2);
        }
    }
}
