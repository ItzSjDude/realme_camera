package okhttp3.internal.cache;

/* loaded from: classes2.dex */
public final class DiskLruCache implements java.io.Closeable, java.io.Flushable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final java.lang.String CLEAN = "CLEAN";
    private static final java.lang.String DIRTY = "DIRTY";
    static final java.lang.String JOURNAL_FILE = "journal";
    static final java.lang.String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final java.lang.String JOURNAL_FILE_TEMP = "journal.tmp";
    static final java.util.regex.Pattern LEGAL_KEY_PATTERN = java.util.regex.Pattern.compile("[a_renamed-z0-9_-]{1,120}");
    static final java.lang.String MAGIC = "libcore.io.DiskLruCache";
    private static final java.lang.String READ = "READ";
    private static final java.lang.String REMOVE = "REMOVE";
    static final java.lang.String VERSION_1 = "1";
    private final int appVersion;
    boolean closed;
    final java.io.File directory;
    private final java.util.concurrent.Executor executor;
    final okhttp3.internal.io.FileSystem fileSystem;
    boolean hasJournalErrors;
    boolean initialized;
    private final java.io.File journalFile;
    private final java.io.File journalFileBackup;
    private final java.io.File journalFileTmp;
    okio.BufferedSink journalWriter;
    private long maxSize;
    boolean mostRecentRebuildFailed;
    boolean mostRecentTrimFailed;
    int redundantOpCount;
    final int valueCount;
    private long size = 0;
    final java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache.Entry> lruEntries = new java.util.LinkedHashMap<>(0, 0.75f, true);
    private long nextSequenceNumber = 0;
    private final java.lang.Runnable cleanupRunnable = new java.lang.Runnable() { // from class: okhttp3.internal.cache.DiskLruCache.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (okhttp3.internal.cache.DiskLruCache.this) {
                if ((!okhttp3.internal.cache.DiskLruCache.this.initialized) || okhttp3.internal.cache.DiskLruCache.this.closed) {
                    return;
                }
                try {
                    okhttp3.internal.cache.DiskLruCache.this.trimToSize();
                } catch (java.io.IOException unused) {
                    okhttp3.internal.cache.DiskLruCache.this.mostRecentTrimFailed = true;
                }
                try {
                    if (okhttp3.internal.cache.DiskLruCache.this.journalRebuildRequired()) {
                        okhttp3.internal.cache.DiskLruCache.this.rebuildJournal();
                        okhttp3.internal.cache.DiskLruCache.this.redundantOpCount = 0;
                    }
                } catch (java.io.IOException unused2) {
                    okhttp3.internal.cache.DiskLruCache.this.mostRecentRebuildFailed = true;
                    okhttp3.internal.cache.DiskLruCache.this.journalWriter = okio.Okio.buffer(okio.Okio.blackhole());
                }
            }
        }
    };

    DiskLruCache(okhttp3.internal.io.FileSystem fileSystem, java.io.File file, int i_renamed, int i2, long j_renamed, java.util.concurrent.Executor executor) {
        this.fileSystem = fileSystem;
        this.directory = file;
        this.appVersion = i_renamed;
        this.journalFile = new java.io.File(file, JOURNAL_FILE);
        this.journalFileTmp = new java.io.File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new java.io.File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j_renamed;
        this.executor = executor;
    }

    public synchronized void initialize() throws java.io.IOException {
        if (this.initialized) {
            return;
        }
        if (this.fileSystem.exists(this.journalFileBackup)) {
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.delete(this.journalFileBackup);
            } else {
                this.fileSystem.rename(this.journalFileBackup, this.journalFile);
            }
        }
        if (this.fileSystem.exists(this.journalFile)) {
            try {
                readJournal();
                processJournal();
                this.initialized = true;
                return;
            } catch (java.io.IOException e_renamed) {
                okhttp3.internal.platform.Platform.get().log(5, "DiskLruCache " + this.directory + " is_renamed corrupt: " + e_renamed.getMessage() + ", removing", e_renamed);
                try {
                    delete();
                    this.closed = false;
                } catch (java.lang.Throwable th) {
                    this.closed = false;
                    throw th;
                }
            }
        }
        rebuildJournal();
        this.initialized = true;
    }

    public static okhttp3.internal.cache.DiskLruCache create(okhttp3.internal.io.FileSystem fileSystem, java.io.File file, int i_renamed, int i2, long j_renamed) {
        if (j_renamed <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new java.lang.IllegalArgumentException("valueCount <= 0");
        }
        return new okhttp3.internal.cache.DiskLruCache(fileSystem, file, i_renamed, i2, j_renamed, new java.util.concurrent.ThreadPoolExecutor(0, 1, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), okhttp3.internal.Util.threadFactory("OkHttp DiskLruCache", true)));
    }

    private void readJournal() throws java.io.IOException {
        okio.BufferedSource bufferedSourceBuffer = okio.Okio.buffer(this.fileSystem.source(this.journalFile));
        try {
            java.lang.String utf8LineStrict = bufferedSourceBuffer.readUtf8LineStrict();
            java.lang.String utf8LineStrict2 = bufferedSourceBuffer.readUtf8LineStrict();
            java.lang.String utf8LineStrict3 = bufferedSourceBuffer.readUtf8LineStrict();
            java.lang.String utf8LineStrict4 = bufferedSourceBuffer.readUtf8LineStrict();
            java.lang.String utf8LineStrict5 = bufferedSourceBuffer.readUtf8LineStrict();
            if (!MAGIC.equals(utf8LineStrict) || !"1".equals(utf8LineStrict2) || !java.lang.Integer.toString(this.appVersion).equals(utf8LineStrict3) || !java.lang.Integer.toString(this.valueCount).equals(utf8LineStrict4) || !"".equals(utf8LineStrict5)) {
                throw new java.io.IOException("unexpected journal header: [" + utf8LineStrict + ", " + utf8LineStrict2 + ", " + utf8LineStrict4 + ", " + utf8LineStrict5 + "]");
            }
            int i_renamed = 0;
            while (true) {
                try {
                    readJournalLine(bufferedSourceBuffer.readUtf8LineStrict());
                    i_renamed++;
                } catch (java.io.EOFException unused) {
                    this.redundantOpCount = i_renamed - this.lruEntries.size();
                    if (!bufferedSourceBuffer.exhausted()) {
                        rebuildJournal();
                    } else {
                        this.journalWriter = newJournalWriter();
                    }
                    okhttp3.internal.Util.closeQuietly(bufferedSourceBuffer);
                    return;
                }
            }
        } catch (java.lang.Throwable th) {
            okhttp3.internal.Util.closeQuietly(bufferedSourceBuffer);
            throw th;
        }
    }

    private okio.BufferedSink newJournalWriter() throws java.io.FileNotFoundException {
        return okio.Okio.buffer(new okhttp3.internal.cache.FaultHidingSink(this.fileSystem.appendingSink(this.journalFile)) { // from class: okhttp3.internal.cache.DiskLruCache.2
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // okhttp3.internal.cache.FaultHidingSink
            protected void onException(java.io.IOException iOException) {
                okhttp3.internal.cache.DiskLruCache.this.hasJournalErrors = true;
            }
        });
    }

    private void readJournalLine(java.lang.String str) throws java.io.IOException {
        java.lang.String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new java.io.IOException("unexpected journal line: " + str);
        }
        int i_renamed = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i_renamed);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i_renamed);
            if (iIndexOf == 6 && str.startsWith(REMOVE)) {
                this.lruEntries.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i_renamed, iIndexOf2);
        }
        okhttp3.internal.cache.DiskLruCache.Entry entry = this.lruEntries.get(strSubstring);
        if (entry == null) {
            entry = new okhttp3.internal.cache.DiskLruCache.Entry(strSubstring);
            this.lruEntries.put(strSubstring, entry);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith(CLEAN)) {
            java.lang.String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith(DIRTY)) {
            entry.currentEditor = new okhttp3.internal.cache.DiskLruCache.Editor(entry);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith(READ)) {
            return;
        }
        throw new java.io.IOException("unexpected journal line: " + str);
    }

    private void processJournal() throws java.io.IOException {
        this.fileSystem.delete(this.journalFileTmp);
        java.util.Iterator<okhttp3.internal.cache.DiskLruCache.Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            okhttp3.internal.cache.DiskLruCache.Entry next = it.next();
            int i_renamed = 0;
            if (next.currentEditor == null) {
                while (i_renamed < this.valueCount) {
                    this.size += next.lengths[i_renamed];
                    i_renamed++;
                }
            } else {
                next.currentEditor = null;
                while (i_renamed < this.valueCount) {
                    this.fileSystem.delete(next.cleanFiles[i_renamed]);
                    this.fileSystem.delete(next.dirtyFiles[i_renamed]);
                    i_renamed++;
                }
                it.remove();
            }
        }
    }

    synchronized void rebuildJournal() throws java.io.IOException {
        if (this.journalWriter != null) {
            this.journalWriter.close();
        }
        okio.BufferedSink bufferedSinkBuffer = okio.Okio.buffer(this.fileSystem.sink(this.journalFileTmp));
        try {
            bufferedSinkBuffer.writeUtf8(MAGIC).writeByte(10);
            bufferedSinkBuffer.writeUtf8("1").writeByte(10);
            bufferedSinkBuffer.writeDecimalLong(this.appVersion).writeByte(10);
            bufferedSinkBuffer.writeDecimalLong(this.valueCount).writeByte(10);
            bufferedSinkBuffer.writeByte(10);
            for (okhttp3.internal.cache.DiskLruCache.Entry entry : this.lruEntries.values()) {
                if (entry.currentEditor != null) {
                    bufferedSinkBuffer.writeUtf8(DIRTY).writeByte(32);
                    bufferedSinkBuffer.writeUtf8(entry.key);
                    bufferedSinkBuffer.writeByte(10);
                } else {
                    bufferedSinkBuffer.writeUtf8(CLEAN).writeByte(32);
                    bufferedSinkBuffer.writeUtf8(entry.key);
                    entry.writeLengths(bufferedSinkBuffer);
                    bufferedSinkBuffer.writeByte(10);
                }
            }
            bufferedSinkBuffer.close();
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.rename(this.journalFile, this.journalFileBackup);
            }
            this.fileSystem.rename(this.journalFileTmp, this.journalFile);
            this.fileSystem.delete(this.journalFileBackup);
            this.journalWriter = newJournalWriter();
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } catch (java.lang.Throwable th) {
            bufferedSinkBuffer.close();
            throw th;
        }
    }

    public synchronized okhttp3.internal.cache.DiskLruCache.Snapshot get(java.lang.String str) throws java.io.IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        okhttp3.internal.cache.DiskLruCache.Entry entry = this.lruEntries.get(str);
        if (entry != null && entry.readable) {
            okhttp3.internal.cache.DiskLruCache.Snapshot snapshot = entry.snapshot();
            if (snapshot == null) {
                return null;
            }
            this.redundantOpCount++;
            this.journalWriter.writeUtf8(READ).writeByte(32).writeUtf8(str).writeByte(10);
            if (journalRebuildRequired()) {
                this.executor.execute(this.cleanupRunnable);
            }
            return snapshot;
        }
        return null;
    }

    @javax.annotation.Nullable
    public okhttp3.internal.cache.DiskLruCache.Editor edit(java.lang.String str) throws java.io.IOException {
        return edit(str, -1L);
    }

    synchronized okhttp3.internal.cache.DiskLruCache.Editor edit(java.lang.String str, long j_renamed) throws java.io.IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        okhttp3.internal.cache.DiskLruCache.Entry entry = this.lruEntries.get(str);
        if (j_renamed != -1 && (entry == null || entry.sequenceNumber != j_renamed)) {
            return null;
        }
        if (entry != null && entry.currentEditor != null) {
            return null;
        }
        if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            this.journalWriter.writeUtf8(DIRTY).writeByte(32).writeUtf8(str).writeByte(10);
            this.journalWriter.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (entry == null) {
                entry = new okhttp3.internal.cache.DiskLruCache.Entry(str);
                this.lruEntries.put(str, entry);
            }
            okhttp3.internal.cache.DiskLruCache.Editor editor = new okhttp3.internal.cache.DiskLruCache.Editor(entry);
            entry.currentEditor = editor;
            return editor;
        }
        this.executor.execute(this.cleanupRunnable);
        return null;
    }

    public java.io.File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized void setMaxSize(long j_renamed) {
        this.maxSize = j_renamed;
        if (this.initialized) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public synchronized long size() throws java.io.IOException {
        initialize();
        return this.size;
    }

    synchronized void completeEdit(okhttp3.internal.cache.DiskLruCache.Editor editor, boolean z_renamed) throws java.io.IOException {
        okhttp3.internal.cache.DiskLruCache.Entry entry = editor.entry;
        if (entry.currentEditor != editor) {
            throw new java.lang.IllegalStateException();
        }
        if (z_renamed && !entry.readable) {
            for (int i_renamed = 0; i_renamed < this.valueCount; i_renamed++) {
                if (!editor.written[i_renamed]) {
                    editor.abort();
                    throw new java.lang.IllegalStateException("Newly created entry didn't_renamed create value for index " + i_renamed);
                }
                if (!this.fileSystem.exists(entry.dirtyFiles[i_renamed])) {
                    editor.abort();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.valueCount; i2++) {
            java.io.File file = entry.dirtyFiles[i2];
            if (z_renamed) {
                if (this.fileSystem.exists(file)) {
                    java.io.File file2 = entry.cleanFiles[i2];
                    this.fileSystem.rename(file, file2);
                    long j_renamed = entry.lengths[i2];
                    long size = this.fileSystem.size(file2);
                    entry.lengths[i2] = size;
                    this.size = (this.size - j_renamed) + size;
                }
            } else {
                this.fileSystem.delete(file);
            }
        }
        this.redundantOpCount++;
        entry.currentEditor = null;
        if (entry.readable | z_renamed) {
            entry.readable = true;
            this.journalWriter.writeUtf8(CLEAN).writeByte(32);
            this.journalWriter.writeUtf8(entry.key);
            entry.writeLengths(this.journalWriter);
            this.journalWriter.writeByte(10);
            if (z_renamed) {
                long j2 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j2;
                entry.sequenceNumber = j2;
            }
        } else {
            this.lruEntries.remove(entry.key);
            this.journalWriter.writeUtf8(REMOVE).writeByte(32);
            this.journalWriter.writeUtf8(entry.key);
            this.journalWriter.writeByte(10);
        }
        this.journalWriter.flush();
        if (this.size > this.maxSize || journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    boolean journalRebuildRequired() {
        int i_renamed = this.redundantOpCount;
        return i_renamed >= 2000 && i_renamed >= this.lruEntries.size();
    }

    public synchronized boolean remove(java.lang.String str) throws java.io.IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        okhttp3.internal.cache.DiskLruCache.Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return false;
        }
        boolean zRemoveEntry = removeEntry(entry);
        if (zRemoveEntry && this.size <= this.maxSize) {
            this.mostRecentTrimFailed = false;
        }
        return zRemoveEntry;
    }

    boolean removeEntry(okhttp3.internal.cache.DiskLruCache.Entry entry) throws java.io.IOException {
        if (entry.currentEditor != null) {
            entry.currentEditor.detach();
        }
        for (int i_renamed = 0; i_renamed < this.valueCount; i_renamed++) {
            this.fileSystem.delete(entry.cleanFiles[i_renamed]);
            this.size -= entry.lengths[i_renamed];
            entry.lengths[i_renamed] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.writeUtf8(REMOVE).writeByte(32).writeUtf8(entry.key).writeByte(10);
        this.lruEntries.remove(entry.key);
        if (journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    public synchronized boolean isClosed() {
        return this.closed;
    }

    private synchronized void checkNotClosed() {
        if (isClosed()) {
            throw new java.lang.IllegalStateException("cache is_renamed closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws java.io.IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            this.journalWriter.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws java.io.IOException {
        if (this.initialized && !this.closed) {
            for (okhttp3.internal.cache.DiskLruCache.Entry entry : (okhttp3.internal.cache.DiskLruCache.Entry[]) this.lruEntries.values().toArray(new okhttp3.internal.cache.DiskLruCache.Entry[this.lruEntries.size()])) {
                if (entry.currentEditor != null) {
                    entry.currentEditor.abort();
                }
            }
            trimToSize();
            this.journalWriter.close();
            this.journalWriter = null;
            this.closed = true;
            return;
        }
        this.closed = true;
    }

    void trimToSize() throws java.io.IOException {
        while (this.size > this.maxSize) {
            removeEntry(this.lruEntries.values().iterator().next());
        }
        this.mostRecentTrimFailed = false;
    }

    public void delete() throws java.io.IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public synchronized void evictAll() throws java.io.IOException {
        initialize();
        for (okhttp3.internal.cache.DiskLruCache.Entry entry : (okhttp3.internal.cache.DiskLruCache.Entry[]) this.lruEntries.values().toArray(new okhttp3.internal.cache.DiskLruCache.Entry[this.lruEntries.size()])) {
            removeEntry(entry);
        }
        this.mostRecentTrimFailed = false;
    }

    private void validateKey(java.lang.String str) {
        if (LEGAL_KEY_PATTERN.matcher(str).matches()) {
            return;
        }
        throw new java.lang.IllegalArgumentException("keys must match regex [a_renamed-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public synchronized java.util.Iterator<okhttp3.internal.cache.DiskLruCache.Snapshot> snapshots() throws java.io.IOException {
        initialize();
        return new java.util.Iterator<okhttp3.internal.cache.DiskLruCache.Snapshot>() { // from class: okhttp3.internal.cache.DiskLruCache.3
            final java.util.Iterator<okhttp3.internal.cache.DiskLruCache.Entry> delegate;
            okhttp3.internal.cache.DiskLruCache.Snapshot nextSnapshot;
            okhttp3.internal.cache.DiskLruCache.Snapshot removeSnapshot;

            {
                this.delegate = new java.util.ArrayList(okhttp3.internal.cache.DiskLruCache.this.lruEntries.values()).iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.nextSnapshot != null) {
                    return true;
                }
                synchronized (okhttp3.internal.cache.DiskLruCache.this) {
                    if (okhttp3.internal.cache.DiskLruCache.this.closed) {
                        return false;
                    }
                    while (this.delegate.hasNext()) {
                        okhttp3.internal.cache.DiskLruCache.Snapshot snapshot = this.delegate.next().snapshot();
                        if (snapshot != null) {
                            this.nextSnapshot = snapshot;
                            return true;
                        }
                    }
                    return false;
                }
            }

            @Override // java.util.Iterator
            public okhttp3.internal.cache.DiskLruCache.Snapshot next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                this.removeSnapshot = this.nextSnapshot;
                this.nextSnapshot = null;
                return this.removeSnapshot;
            }

            @Override // java.util.Iterator
            public void remove() {
                okhttp3.internal.cache.DiskLruCache.Snapshot snapshot = this.removeSnapshot;
                if (snapshot == null) {
                    throw new java.lang.IllegalStateException("remove() before next()");
                }
                try {
                    okhttp3.internal.cache.DiskLruCache.this.remove(snapshot.key);
                } catch (java.io.IOException unused) {
                } catch (java.lang.Throwable th) {
                    this.removeSnapshot = null;
                    throw th;
                }
                this.removeSnapshot = null;
            }
        };
    }

    public final class Snapshot implements java.io.Closeable {
        private final java.lang.String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final okio.Source[] sources;

        Snapshot(java.lang.String str, long j_renamed, okio.Source[] sourceArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j_renamed;
            this.sources = sourceArr;
            this.lengths = jArr;
        }

        public java.lang.String key() {
            return this.key;
        }

        @javax.annotation.Nullable
        public okhttp3.internal.cache.DiskLruCache.Editor edit() throws java.io.IOException {
            return okhttp3.internal.cache.DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public okio.Source getSource(int i_renamed) {
            return this.sources[i_renamed];
        }

        public long getLength(int i_renamed) {
            return this.lengths[i_renamed];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (okio.Source source : this.sources) {
                okhttp3.internal.Util.closeQuietly(source);
            }
        }
    }

    public final class Editor {
        private boolean done;
        final okhttp3.internal.cache.DiskLruCache.Entry entry;
        final boolean[] written;

        Editor(okhttp3.internal.cache.DiskLruCache.Entry entry) {
            this.entry = entry;
            this.written = entry.readable ? null : new boolean[okhttp3.internal.cache.DiskLruCache.this.valueCount];
        }

        void detach() {
            if (this.entry.currentEditor == this) {
                for (int i_renamed = 0; i_renamed < okhttp3.internal.cache.DiskLruCache.this.valueCount; i_renamed++) {
                    try {
                        okhttp3.internal.cache.DiskLruCache.this.fileSystem.delete(this.entry.dirtyFiles[i_renamed]);
                    } catch (java.io.IOException unused) {
                    }
                }
                this.entry.currentEditor = null;
            }
        }

        public okio.Source newSource(int i_renamed) {
            synchronized (okhttp3.internal.cache.DiskLruCache.this) {
                if (this.done) {
                    throw new java.lang.IllegalStateException();
                }
                if (!this.entry.readable || this.entry.currentEditor != this) {
                    return null;
                }
                try {
                    return okhttp3.internal.cache.DiskLruCache.this.fileSystem.source(this.entry.cleanFiles[i_renamed]);
                } catch (java.io.FileNotFoundException unused) {
                    return null;
                }
            }
        }

        public okio.Sink newSink(int i_renamed) {
            synchronized (okhttp3.internal.cache.DiskLruCache.this) {
                if (this.done) {
                    throw new java.lang.IllegalStateException();
                }
                if (this.entry.currentEditor != this) {
                    return okio.Okio.blackhole();
                }
                if (!this.entry.readable) {
                    this.written[i_renamed] = true;
                }
                try {
                    return new okhttp3.internal.cache.FaultHidingSink(okhttp3.internal.cache.DiskLruCache.this.fileSystem.sink(this.entry.dirtyFiles[i_renamed])) { // from class: okhttp3.internal.cache.DiskLruCache.Editor.1
                        @Override // okhttp3.internal.cache.FaultHidingSink
                        protected void onException(java.io.IOException iOException) {
                            synchronized (okhttp3.internal.cache.DiskLruCache.this) {
                                okhttp3.internal.cache.DiskLruCache.Editor.this.detach();
                            }
                        }
                    };
                } catch (java.io.FileNotFoundException unused) {
                    return okio.Okio.blackhole();
                }
            }
        }

        public void commit() throws java.io.IOException {
            synchronized (okhttp3.internal.cache.DiskLruCache.this) {
                if (this.done) {
                    throw new java.lang.IllegalStateException();
                }
                if (this.entry.currentEditor == this) {
                    okhttp3.internal.cache.DiskLruCache.this.completeEdit(this, true);
                }
                this.done = true;
            }
        }

        public void abort() throws java.io.IOException {
            synchronized (okhttp3.internal.cache.DiskLruCache.this) {
                if (this.done) {
                    throw new java.lang.IllegalStateException();
                }
                if (this.entry.currentEditor == this) {
                    okhttp3.internal.cache.DiskLruCache.this.completeEdit(this, false);
                }
                this.done = true;
            }
        }

        public void abortUnlessCommitted() {
            synchronized (okhttp3.internal.cache.DiskLruCache.this) {
                if (!this.done && this.entry.currentEditor == this) {
                    try {
                        okhttp3.internal.cache.DiskLruCache.this.completeEdit(this, false);
                    } catch (java.io.IOException unused) {
                    }
                }
            }
        }
    }

    private final class Entry {
        final java.io.File[] cleanFiles;
        okhttp3.internal.cache.DiskLruCache.Editor currentEditor;
        final java.io.File[] dirtyFiles;
        final java.lang.String key;
        final long[] lengths;
        boolean readable;
        long sequenceNumber;

        Entry(java.lang.String str) {
            this.key = str;
            this.lengths = new long[okhttp3.internal.cache.DiskLruCache.this.valueCount];
            this.cleanFiles = new java.io.File[okhttp3.internal.cache.DiskLruCache.this.valueCount];
            this.dirtyFiles = new java.io.File[okhttp3.internal.cache.DiskLruCache.this.valueCount];
            java.lang.StringBuilder sb = new java.lang.StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i_renamed = 0; i_renamed < okhttp3.internal.cache.DiskLruCache.this.valueCount; i_renamed++) {
                sb.append(i_renamed);
                this.cleanFiles[i_renamed] = new java.io.File(okhttp3.internal.cache.DiskLruCache.this.directory, sb.toString());
                sb.append(".tmp");
                this.dirtyFiles[i_renamed] = new java.io.File(okhttp3.internal.cache.DiskLruCache.this.directory, sb.toString());
                sb.setLength(length);
            }
        }

        void setLengths(java.lang.String[] strArr) throws java.io.IOException {
            if (strArr.length != okhttp3.internal.cache.DiskLruCache.this.valueCount) {
                throw invalidLengths(strArr);
            }
            for (int i_renamed = 0; i_renamed < strArr.length; i_renamed++) {
                try {
                    this.lengths[i_renamed] = java.lang.Long.parseLong(strArr[i_renamed]);
                } catch (java.lang.NumberFormatException unused) {
                    throw invalidLengths(strArr);
                }
            }
        }

        void writeLengths(okio.BufferedSink bufferedSink) throws java.io.IOException {
            for (long j_renamed : this.lengths) {
                bufferedSink.writeByte(32).writeDecimalLong(j_renamed);
            }
        }

        private java.io.IOException invalidLengths(java.lang.String[] strArr) throws java.io.IOException {
            throw new java.io.IOException("unexpected journal line: " + java.util.Arrays.toString(strArr));
        }

        okhttp3.internal.cache.DiskLruCache.Snapshot snapshot() throws java.io.IOException {
            if (!java.lang.Thread.holdsLock(okhttp3.internal.cache.DiskLruCache.this)) {
                throw new java.lang.AssertionError();
            }
            okio.Source[] sourceArr = new okio.Source[okhttp3.internal.cache.DiskLruCache.this.valueCount];
            long[] jArr = (long[]) this.lengths.clone();
            for (int i_renamed = 0; i_renamed < okhttp3.internal.cache.DiskLruCache.this.valueCount; i_renamed++) {
                try {
                    sourceArr[i_renamed] = okhttp3.internal.cache.DiskLruCache.this.fileSystem.source(this.cleanFiles[i_renamed]);
                } catch (java.io.FileNotFoundException unused) {
                    for (int i2 = 0; i2 < okhttp3.internal.cache.DiskLruCache.this.valueCount && sourceArr[i2] != null; i2++) {
                        okhttp3.internal.Util.closeQuietly(sourceArr[i2]);
                    }
                    try {
                        okhttp3.internal.cache.DiskLruCache.this.removeEntry(this);
                        return null;
                    } catch (java.io.IOException unused2) {
                        return null;
                    }
                }
            }
            return okhttp3.internal.cache.DiskLruCache.this.new Snapshot(this.key, this.sequenceNumber, sourceArr, jArr);
        }
    }
}
