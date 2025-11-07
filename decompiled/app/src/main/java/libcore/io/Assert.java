package libcore.io;

/* compiled from: DiskLruCache.java */
/* loaded from: classes2.dex */
public final class a_renamed implements java.io.Closeable {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.nio.charset.Charset f7910a = java.nio.charset.Charset.forName("UTF-8");

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.io.File f7911b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.io.File f7912c;
    private final java.io.File d_renamed;
    private final int e_renamed;
    private final long f_renamed;
    private final int g_renamed;
    private java.io.Writer i_renamed;
    private int k_renamed;
    private long h_renamed = 0;
    private final java.util.LinkedHashMap<java.lang.String, libcore.io.a_renamed.b_renamed> j_renamed = new java.util.LinkedHashMap<>(0, 0.75f, true);
    private long l_renamed = 0;
    private final java.util.concurrent.ExecutorService m_renamed = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());
    private final java.util.concurrent.Callable<java.lang.Void> n_renamed = new java.util.concurrent.Callable<java.lang.Void>() { // from class: libcore.io.a_renamed.1
        @Override // java.util.concurrent.Callable
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public java.lang.Void call() throws java.lang.Exception {
            synchronized (libcore.io.a_renamed.this) {
                if (libcore.io.a_renamed.this.i_renamed == null) {
                    return null;
                }
                libcore.io.a_renamed.this.j_renamed();
                if (libcore.io.a_renamed.this.h_renamed()) {
                    libcore.io.a_renamed.this.g_renamed();
                    libcore.io.a_renamed.this.k_renamed = 0;
                }
                return null;
            }
        }
    };

    private static <T_renamed> T_renamed[] a_renamed(T_renamed[] tArr, int i_renamed, int i2) {
        int length = tArr.length;
        if (i_renamed > i2) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i_renamed < 0 || i_renamed > length) {
            throw new java.lang.ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i_renamed;
        int iMin = java.lang.Math.min(i3, length - i_renamed);
        T_renamed[] tArr2 = (T_renamed[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), i3));
        java.lang.System.arraycopy(tArr, i_renamed, tArr2, 0, iMin);
        return tArr2;
    }

    public static java.lang.String a_renamed(java.io.InputStream inputStream) throws java.io.IOException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(80);
        while (true) {
            int i_renamed = inputStream.read();
            if (i_renamed == -1) {
                throw new java.io.EOFException();
            }
            if (i_renamed != 10) {
                sb.append((char) i_renamed);
            } else {
                int length = sb.length();
                if (length > 0) {
                    int i2 = length - 1;
                    if (sb.charAt(i2) == '\r_renamed') {
                        sb.setLength(i2);
                    }
                }
                return sb.toString();
            }
        }
    }

    public static void a_renamed(java.io.Closeable closeable) throws java.io.IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.RuntimeException e_renamed) {
                throw e_renamed;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void a_renamed(java.io.File file) throws java.io.IOException {
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new java.lang.IllegalArgumentException("not a_renamed directory: " + file);
        }
        for (java.io.File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                a_renamed(file2);
            }
            if (!file2.delete()) {
                throw new java.io.IOException("failed to delete file: " + file2);
            }
        }
    }

    private a_renamed(java.io.File file, int i_renamed, int i2, long j_renamed) {
        this.f7911b = file;
        this.e_renamed = i_renamed;
        this.f7912c = new java.io.File(file, "journal");
        this.d_renamed = new java.io.File(file, "journal.tmp");
        this.g_renamed = i2;
        this.f_renamed = j_renamed;
    }

    public static libcore.io.a_renamed a_renamed(java.io.File file, int i_renamed, int i2, long j_renamed) throws java.io.IOException {
        if (j_renamed <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new java.lang.IllegalArgumentException("valueCount <= 0");
        }
        libcore.io.a_renamed aVar = new libcore.io.a_renamed(file, i_renamed, i2, j_renamed);
        if (aVar.f7912c.exists()) {
            try {
                aVar.e_renamed();
                aVar.f_renamed();
                aVar.i_renamed = new java.io.BufferedWriter(new java.io.FileWriter(aVar.f7912c, true), 8192);
                return aVar;
            } catch (java.io.IOException unused) {
                aVar.d_renamed();
            }
        }
        file.mkdirs();
        libcore.io.a_renamed aVar2 = new libcore.io.a_renamed(file, i_renamed, i2, j_renamed);
        aVar2.g_renamed();
        return aVar2;
    }

    private void e_renamed() throws java.io.IOException {
        java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(this.f7912c), 8192);
        try {
            java.lang.String strA = a_renamed((java.io.InputStream) bufferedInputStream);
            java.lang.String strA2 = a_renamed((java.io.InputStream) bufferedInputStream);
            java.lang.String strA3 = a_renamed((java.io.InputStream) bufferedInputStream);
            java.lang.String strA4 = a_renamed((java.io.InputStream) bufferedInputStream);
            java.lang.String strA5 = a_renamed((java.io.InputStream) bufferedInputStream);
            if (!"libcore.io.DiskLruCache".equals(strA) || !"1".equals(strA2) || !java.lang.Integer.toString(this.e_renamed).equals(strA3) || !java.lang.Integer.toString(this.g_renamed).equals(strA4) || !"".equals(strA5)) {
                throw new java.io.IOException("unexpected journal header: [" + strA + ", " + strA2 + ", " + strA4 + ", " + strA5 + "]");
            }
            while (true) {
                try {
                    d_renamed(a_renamed((java.io.InputStream) bufferedInputStream));
                } catch (java.io.EOFException unused) {
                    return;
                }
            }
        } finally {
            a_renamed((java.io.Closeable) bufferedInputStream);
        }
    }

    private void d_renamed(java.lang.String str) throws java.io.IOException {
        java.lang.String[] strArrSplit = str.split(" ");
        if (strArrSplit.length < 2) {
            throw new java.io.IOException("unexpected journal line: " + str);
        }
        java.lang.String str2 = strArrSplit[1];
        if (strArrSplit[0].equals("REMOVE") && strArrSplit.length == 2) {
            this.j_renamed.remove(str2);
            return;
        }
        libcore.io.a_renamed.b_renamed bVar = this.j_renamed.get(str2);
        if (bVar == null) {
            bVar = new libcore.io.a_renamed.b_renamed(str2);
            this.j_renamed.put(str2, bVar);
        }
        if (!strArrSplit[0].equals("CLEAN") || strArrSplit.length != this.g_renamed + 2) {
            if (!strArrSplit[0].equals("DIRTY") || strArrSplit.length != 2) {
                if (strArrSplit[0].equals("READ") && strArrSplit.length == 2) {
                    return;
                }
                throw new java.io.IOException("unexpected journal line: " + str);
            }
            bVar.e_renamed = new libcore.io.a_renamed.DiskLruCache_3(bVar);
            return;
        }
        bVar.d_renamed = true;
        bVar.e_renamed = null;
        bVar.a_renamed((java.lang.String[]) a_renamed(strArrSplit, 2, strArrSplit.length));
    }

    private synchronized void f_renamed() throws java.io.IOException {
        b_renamed(this.d_renamed);
        java.util.Iterator<libcore.io.a_renamed.b_renamed> it = this.j_renamed.values().iterator();
        while (it.hasNext()) {
            libcore.io.a_renamed.b_renamed next = it.next();
            int i_renamed = 0;
            if (next.e_renamed == null) {
                while (i_renamed < this.g_renamed) {
                    this.h_renamed += next.f7920c[i_renamed];
                    i_renamed++;
                }
            } else {
                next.e_renamed = null;
                while (i_renamed < this.g_renamed) {
                    b_renamed(next.a_renamed(i_renamed));
                    b_renamed(next.b_renamed(i_renamed));
                    i_renamed++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g_renamed() throws java.io.IOException {
        java.io.BufferedWriter bufferedWriter;
        if (this.i_renamed != null) {
            this.i_renamed.close();
        }
        try {
            bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(this.d_renamed), 8192);
        } catch (java.io.IOException e_renamed) {
            e_renamed.printStackTrace();
        }
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n_renamed");
            bufferedWriter.write("1");
            bufferedWriter.write("\n_renamed");
            bufferedWriter.write(java.lang.Integer.toString(this.e_renamed));
            bufferedWriter.write("\n_renamed");
            bufferedWriter.write(java.lang.Integer.toString(this.g_renamed));
            bufferedWriter.write("\n_renamed");
            bufferedWriter.write("\n_renamed");
            for (libcore.io.a_renamed.b_renamed bVar : this.j_renamed.values()) {
                if (bVar.e_renamed != null) {
                    bufferedWriter.write("DIRTY " + bVar.f7919b + '\n_renamed');
                } else {
                    bufferedWriter.write("CLEAN " + bVar.f7919b + bVar.a_renamed() + '\n_renamed');
                }
            }
            bufferedWriter.close();
            this.d_renamed.renameTo(this.f7912c);
            this.i_renamed = new java.io.BufferedWriter(new java.io.FileWriter(this.f7912c, true), 8192);
        } catch (java.lang.Throwable th) {
            try {
                bufferedWriter.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void b_renamed(java.io.File file) throws java.io.IOException {
        if (file.exists() && !file.delete()) {
            throw new java.io.IOException();
        }
    }

    public synchronized libcore.io.a_renamed.c_renamed a_renamed(java.lang.String str) throws java.io.IOException {
        i_renamed();
        e_renamed(str);
        libcore.io.a_renamed.b_renamed bVar = this.j_renamed.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.d_renamed) {
            return null;
        }
        java.io.InputStream[] inputStreamArr = new java.io.InputStream[this.g_renamed];
        for (int i_renamed = 0; i_renamed < this.g_renamed; i_renamed++) {
            try {
                inputStreamArr[i_renamed] = new java.io.FileInputStream(bVar.a_renamed(i_renamed));
            } catch (java.io.FileNotFoundException unused) {
                return null;
            }
        }
        this.k_renamed++;
        this.i_renamed.append((java.lang.CharSequence) ("READ " + str + '\n_renamed'));
        if (h_renamed()) {
            this.m_renamed.submit(this.n_renamed);
        }
        return new libcore.io.a_renamed.c_renamed(str, bVar.f_renamed, inputStreamArr);
    }

    public libcore.io.a_renamed.DiskLruCache_3 b_renamed(java.lang.String str) throws java.io.IOException {
        return a_renamed(str, -1L);
    }

    private synchronized libcore.io.a_renamed.DiskLruCache_3 a_renamed(java.lang.String str, long j_renamed) throws java.io.IOException {
        i_renamed();
        e_renamed(str);
        libcore.io.a_renamed.b_renamed bVar = this.j_renamed.get(str);
        if (j_renamed != -1 && (bVar == null || bVar.f_renamed != j_renamed)) {
            return null;
        }
        if (bVar == null) {
            bVar = new libcore.io.a_renamed.b_renamed(str);
            this.j_renamed.put(str, bVar);
        } else if (bVar.e_renamed != null) {
            return null;
        }
        libcore.io.a_renamed.DiskLruCache_3 c0153a = new libcore.io.a_renamed.DiskLruCache_3(bVar);
        bVar.e_renamed = c0153a;
        this.i_renamed.write("DIRTY " + str + '\n_renamed');
        this.i_renamed.flush();
        return c0153a;
    }

    public java.io.File a_renamed() {
        return this.f7911b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a_renamed(libcore.io.a_renamed.DiskLruCache_3 c0153a, boolean z_renamed) throws java.io.IOException {
        libcore.io.a_renamed.b_renamed bVar = c0153a.f7915b;
        if (bVar.e_renamed != c0153a) {
            throw new java.lang.IllegalStateException();
        }
        if (z_renamed && !bVar.d_renamed) {
            for (int i_renamed = 0; i_renamed < this.g_renamed; i_renamed++) {
                if (!bVar.b_renamed(i_renamed).exists()) {
                    c0153a.b_renamed();
                    throw new java.lang.IllegalStateException("edit didn't_renamed create file " + i_renamed);
                }
            }
        }
        for (int i2 = 0; i2 < this.g_renamed; i2++) {
            java.io.File fileB = bVar.b_renamed(i2);
            if (z_renamed) {
                if (fileB.exists()) {
                    java.io.File fileA = bVar.a_renamed(i2);
                    fileB.renameTo(fileA);
                    long j_renamed = bVar.f7920c[i2];
                    long length = fileA.length();
                    bVar.f7920c[i2] = length;
                    this.h_renamed = (this.h_renamed - j_renamed) + length;
                }
            } else {
                b_renamed(fileB);
            }
        }
        this.k_renamed++;
        bVar.e_renamed = null;
        if (bVar.d_renamed | z_renamed) {
            bVar.d_renamed = true;
            this.i_renamed.write("CLEAN " + bVar.f7919b + bVar.a_renamed() + '\n_renamed');
            if (z_renamed) {
                long j2 = this.l_renamed;
                this.l_renamed = 1 + j2;
                bVar.f_renamed = j2;
            }
        } else {
            this.j_renamed.remove(bVar.f7919b);
            this.i_renamed.write("REMOVE " + bVar.f7919b + '\n_renamed');
        }
        if (this.h_renamed > this.f_renamed || h_renamed()) {
            this.m_renamed.submit(this.n_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h_renamed() {
        int i_renamed = this.k_renamed;
        return i_renamed >= 2000 && i_renamed >= this.j_renamed.size();
    }

    public synchronized boolean c_renamed(java.lang.String str) throws java.io.IOException {
        i_renamed();
        e_renamed(str);
        libcore.io.a_renamed.b_renamed bVar = this.j_renamed.get(str);
        if (bVar != null && bVar.e_renamed == null) {
            for (int i_renamed = 0; i_renamed < this.g_renamed; i_renamed++) {
                java.io.File fileA = bVar.a_renamed(i_renamed);
                if (!fileA.delete()) {
                    throw new java.io.IOException("failed to delete " + fileA);
                }
                this.h_renamed -= bVar.f7920c[i_renamed];
                bVar.f7920c[i_renamed] = 0;
            }
            this.k_renamed++;
            this.i_renamed.append((java.lang.CharSequence) ("REMOVE " + str + '\n_renamed'));
            this.j_renamed.remove(str);
            if (h_renamed()) {
                this.m_renamed.submit(this.n_renamed);
            }
            return true;
        }
        return false;
    }

    public synchronized boolean b_renamed() {
        return this.i_renamed == null;
    }

    private void i_renamed() {
        if (this.i_renamed == null) {
            throw new java.lang.IllegalStateException("cache is_renamed closed");
        }
    }

    public synchronized void c_renamed() throws java.io.IOException {
        i_renamed();
        j_renamed();
        this.i_renamed.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws java.io.IOException {
        if (this.i_renamed == null) {
            return;
        }
        java.util.Iterator it = new java.util.ArrayList(this.j_renamed.values()).iterator();
        while (it.hasNext()) {
            libcore.io.a_renamed.b_renamed bVar = (libcore.io.a_renamed.b_renamed) it.next();
            if (bVar.e_renamed != null) {
                bVar.e_renamed.b_renamed();
            }
        }
        j_renamed();
        this.i_renamed.close();
        this.i_renamed = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j_renamed() throws java.io.IOException {
        while (this.h_renamed > this.f_renamed) {
            c_renamed(this.j_renamed.entrySet().iterator().next().getKey());
        }
    }

    public void d_renamed() throws java.io.IOException {
        close();
        a_renamed(this.f7911b);
    }

    private void e_renamed(java.lang.String str) {
        if (str.contains(" ") || str.contains("\n_renamed") || str.contains("\r_renamed")) {
            throw new java.lang.IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    /* compiled from: DiskLruCache.java */
    public final class c_renamed implements java.io.Closeable {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final java.lang.String f7922b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final long f7923c;
        private final java.io.InputStream[] d_renamed;

        private c_renamed(java.lang.String str, long j_renamed, java.io.InputStream[] inputStreamArr) {
            this.f7922b = str;
            this.f7923c = j_renamed;
            this.d_renamed = inputStreamArr;
        }

        public java.io.InputStream a_renamed(int i_renamed) {
            return this.d_renamed[i_renamed];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            for (java.io.InputStream inputStream : this.d_renamed) {
                libcore.io.a_renamed.a_renamed((java.io.Closeable) inputStream);
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: libcore.io.a_renamed$a_renamed, reason: collision with other inner class name */
    public final class DiskLruCache_3 {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final libcore.io.a_renamed.b_renamed f7915b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private boolean f7916c;

        private DiskLruCache_3(libcore.io.a_renamed.b_renamed bVar) {
            this.f7915b = bVar;
        }

        public java.io.OutputStream a_renamed(int i_renamed) throws java.io.IOException {
            libcore.io.a_renamed.DiskLruCache_3.DiskLruCache_4 c0154a;
            synchronized (libcore.io.a_renamed.this) {
                if (this.f7915b.e_renamed != this) {
                    throw new java.lang.IllegalStateException();
                }
                c0154a = new libcore.io.a_renamed.DiskLruCache_3.DiskLruCache_4(new java.io.FileOutputStream(this.f7915b.b_renamed(i_renamed)));
            }
            return c0154a;
        }

        public void a_renamed() throws java.io.IOException {
            if (this.f7916c) {
                libcore.io.a_renamed.this.a_renamed(this, false);
                libcore.io.a_renamed.this.c_renamed(this.f7915b.f7919b);
            } else {
                libcore.io.a_renamed.this.a_renamed(this, true);
            }
        }

        public void b_renamed() throws java.io.IOException {
            libcore.io.a_renamed.this.a_renamed(this, false);
        }

        /* compiled from: DiskLruCache.java */
        /* renamed from: libcore.io.a_renamed$a_renamed$a_renamed, reason: collision with other inner class name */
        private class DiskLruCache_4 extends java.io.FilterOutputStream {
            private DiskLruCache_4(java.io.OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i_renamed) throws java.io.IOException {
                try {
                    this.out.write(i_renamed);
                } catch (java.io.IOException unused) {
                    libcore.io.a_renamed.DiskLruCache_3.this.f7916c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
                try {
                    this.out.write(bArr, i_renamed, i2);
                } catch (java.io.IOException unused) {
                    libcore.io.a_renamed.DiskLruCache_3.this.f7916c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                try {
                    this.out.close();
                } catch (java.io.IOException unused) {
                    libcore.io.a_renamed.DiskLruCache_3.this.f7916c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() throws java.io.IOException {
                try {
                    this.out.flush();
                } catch (java.io.IOException unused) {
                    libcore.io.a_renamed.DiskLruCache_3.this.f7916c = true;
                }
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    private final class b_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final java.lang.String f7919b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final long[] f7920c;
        private boolean d_renamed;
        private libcore.io.a_renamed.DiskLruCache_3 e_renamed;
        private long f_renamed;

        private b_renamed(java.lang.String str) {
            this.f7919b = str;
            this.f7920c = new long[libcore.io.a_renamed.this.g_renamed];
        }

        public java.lang.String a_renamed() throws java.io.IOException {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (long j_renamed : this.f7920c) {
                sb.append(' ');
                sb.append(j_renamed);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a_renamed(java.lang.String[] strArr) throws java.io.IOException {
            if (strArr.length != libcore.io.a_renamed.this.g_renamed) {
                throw b_renamed(strArr);
            }
            for (int i_renamed = 0; i_renamed < strArr.length; i_renamed++) {
                try {
                    this.f7920c[i_renamed] = java.lang.Long.parseLong(strArr[i_renamed]);
                } catch (java.lang.NumberFormatException unused) {
                    throw b_renamed(strArr);
                }
            }
        }

        private java.io.IOException b_renamed(java.lang.String[] strArr) throws java.io.IOException {
            throw new java.io.IOException("unexpected journal line: " + java.util.Arrays.toString(strArr));
        }

        public java.io.File a_renamed(int i_renamed) {
            return new java.io.File(libcore.io.a_renamed.this.f7911b, this.f7919b + "." + i_renamed);
        }

        public java.io.File b_renamed(int i_renamed) {
            return new java.io.File(libcore.io.a_renamed.this.f7911b, this.f7919b + "." + i_renamed + ".tmp");
        }
    }
}
