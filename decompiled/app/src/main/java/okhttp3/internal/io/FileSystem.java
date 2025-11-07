package okhttp3.internal.io;

/* loaded from: classes2.dex */
public interface FileSystem {
    public static final okhttp3.internal.io.FileSystem SYSTEM = new okhttp3.internal.io.FileSystem() { // from class: okhttp3.internal.io.FileSystem.1
        @Override // okhttp3.internal.io.FileSystem
        public okio.Source source(java.io.File file) throws java.io.FileNotFoundException {
            return okio.Okio.source(file);
        }

        @Override // okhttp3.internal.io.FileSystem
        public okio.Sink sink(java.io.File file) throws java.io.FileNotFoundException {
            try {
                return okio.Okio.sink(file);
            } catch (java.io.FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return okio.Okio.sink(file);
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public okio.Sink appendingSink(java.io.File file) throws java.io.FileNotFoundException {
            try {
                return okio.Okio.appendingSink(file);
            } catch (java.io.FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return okio.Okio.appendingSink(file);
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public void delete(java.io.File file) throws java.io.IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new java.io.IOException("failed to delete " + file);
        }

        @Override // okhttp3.internal.io.FileSystem
        public boolean exists(java.io.File file) {
            return file.exists();
        }

        @Override // okhttp3.internal.io.FileSystem
        public long size(java.io.File file) {
            return file.length();
        }

        @Override // okhttp3.internal.io.FileSystem
        public void rename(java.io.File file, java.io.File file2) throws java.io.IOException {
            delete(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new java.io.IOException("failed to rename " + file + " to " + file2);
        }

        @Override // okhttp3.internal.io.FileSystem
        public void deleteContents(java.io.File file) throws java.io.IOException {
            java.io.File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new java.io.IOException("not a_renamed readable directory: " + file);
            }
            for (java.io.File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                if (!file2.delete()) {
                    throw new java.io.IOException("failed to delete " + file2);
                }
            }
        }
    };

    okio.Sink appendingSink(java.io.File file) throws java.io.FileNotFoundException;

    void delete(java.io.File file) throws java.io.IOException;

    void deleteContents(java.io.File file) throws java.io.IOException;

    boolean exists(java.io.File file);

    void rename(java.io.File file, java.io.File file2) throws java.io.IOException;

    okio.Sink sink(java.io.File file) throws java.io.FileNotFoundException;

    long size(java.io.File file);

    okio.Source source(java.io.File file) throws java.io.FileNotFoundException;
}
