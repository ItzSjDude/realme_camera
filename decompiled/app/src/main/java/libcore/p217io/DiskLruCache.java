package libcore.p217io;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache.java */
/* renamed from: libcore.io.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public final class DiskLruCache implements Closeable {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Charset f24745a = Charset.forName("UTF-8");

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final File f24746b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final File f24747c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final File f24748d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final int f24749e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final long f24750f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final int f24751g;

    /* renamed from: OplusGLSurfaceView_13 */
    private Writer f24753i;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f24755k;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private long f24752h = 0;

    /* renamed from: OplusGLSurfaceView_15 */
    private final LinkedHashMap<String, IntrinsicsJvm.kt_4> f24754j = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: OplusGLSurfaceView_14 */
    private long f24756l = 0;

    /* renamed from: OplusGLSurfaceView_6 */
    private final ExecutorService f24757m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: OplusGLSurfaceView_11 */
    private final Callable<Void> f24758n = new Callable<Void>() { // from class: libcore.io.PlatformImplementations.kt_3.1
        @Override // java.util.concurrent.Callable
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.f24753i == null) {
                    return null;
                }
                DiskLruCache.this.m25973j();
                if (DiskLruCache.this.m25971h()) {
                    DiskLruCache.this.m25970g();
                    DiskLruCache.this.f24755k = 0;
                }
                return null;
            }
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    private static <T> T[] m25959a(T[] tArr, int OplusGLSurfaceView_13, int i2) {
        int length = tArr.length;
        if (OplusGLSurfaceView_13 > i2) {
            throw new IllegalArgumentException();
        }
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - OplusGLSurfaceView_13;
        int iMin = Math.min(i3, length - OplusGLSurfaceView_13);
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3));
        System.arraycopy(tArr, OplusGLSurfaceView_13, tArr2, 0, iMin);
        return tArr2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m25952a(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder(80);
        while (true) {
            int OplusGLSurfaceView_13 = inputStream.read();
            if (OplusGLSurfaceView_13 == -1) {
                throw new EOFException();
            }
            if (OplusGLSurfaceView_13 != 10) {
                sb.append((char) OplusGLSurfaceView_13);
            } else {
                int length = sb.length();
                if (length > 0) {
                    int i2 = length - 1;
                    if (sb.charAt(i2) == '\r') {
                        sb.setLength(i2);
                    }
                }
                return sb.toString();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25955a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException COUIBaseListPopupWindow_8) {
                throw COUIBaseListPopupWindow_8;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m25956a(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IllegalArgumentException("not PlatformImplementations.kt_3 directory: " + file);
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                m25956a(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    private DiskLruCache(File file, int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15) {
        this.f24746b = file;
        this.f24749e = OplusGLSurfaceView_13;
        this.f24747c = new File(file, "journal");
        this.f24748d = new File(file, "journal.tmp");
        this.f24751g = i2;
        this.f24750f = OplusGLSurfaceView_15;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static DiskLruCache m25954a(File file, int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15) throws IOException {
        if (OplusGLSurfaceView_15 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        DiskLruCache c3965a = new DiskLruCache(file, OplusGLSurfaceView_13, i2, OplusGLSurfaceView_15);
        if (c3965a.f24747c.exists()) {
            try {
                c3965a.m25966e();
                c3965a.m25969f();
                c3965a.f24753i = new BufferedWriter(new FileWriter(c3965a.f24747c, true), 8192);
                return c3965a;
            } catch (IOException unused) {
                c3965a.m25980d();
            }
        }
        file.mkdirs();
        DiskLruCache c3965a2 = new DiskLruCache(file, OplusGLSurfaceView_13, i2, OplusGLSurfaceView_15);
        c3965a2.m25970g();
        return c3965a2;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m25966e() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.f24747c), 8192);
        try {
            String strM25952a = m25952a((InputStream) bufferedInputStream);
            String strM25952a2 = m25952a((InputStream) bufferedInputStream);
            String strM25952a3 = m25952a((InputStream) bufferedInputStream);
            String strM25952a4 = m25952a((InputStream) bufferedInputStream);
            String strM25952a5 = m25952a((InputStream) bufferedInputStream);
            if (!"libcore.io.DiskLruCache".equals(strM25952a) || !"1".equals(strM25952a2) || !Integer.toString(this.f24749e).equals(strM25952a3) || !Integer.toString(this.f24751g).equals(strM25952a4) || !"".equals(strM25952a5)) {
                throw new IOException("unexpected journal header: [" + strM25952a + ", " + strM25952a2 + ", " + strM25952a4 + ", " + strM25952a5 + "]");
            }
            while (true) {
                try {
                    m25963d(m25952a((InputStream) bufferedInputStream));
                } catch (EOFException unused) {
                    return;
                }
            }
        } finally {
            m25955a((Closeable) bufferedInputStream);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m25963d(String str) throws IOException {
        String[] strArrSplit = str.split(" ");
        if (strArrSplit.length < 2) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2 = strArrSplit[1];
        if (strArrSplit[0].equals("REMOVE") && strArrSplit.length == 2) {
            this.f24754j.remove(str2);
            return;
        }
        IntrinsicsJvm.kt_4 bVar = this.f24754j.get(str2);
        if (bVar == null) {
            bVar = new IntrinsicsJvm.kt_4(str2);
            this.f24754j.put(str2, bVar);
        }
        if (!strArrSplit[0].equals("CLEAN") || strArrSplit.length != this.f24751g + 2) {
            if (!strArrSplit[0].equals("DIRTY") || strArrSplit.length != 2) {
                if (strArrSplit[0].equals("READ") && strArrSplit.length == 2) {
                    return;
                }
                throw new IOException("unexpected journal line: " + str);
            }
            bVar.f24768e = new PlatformImplementations.kt_3(bVar);
            return;
        }
        bVar.f24767d = true;
        bVar.f24768e = null;
        bVar.m25991a((String[]) m25959a(strArrSplit, 2, strArrSplit.length));
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private synchronized void m25969f() throws IOException {
        m25960b(this.f24748d);
        Iterator<IntrinsicsJvm.kt_4> it = this.f24754j.values().iterator();
        while (it.hasNext()) {
            IntrinsicsJvm.kt_4 next = it.next();
            int OplusGLSurfaceView_13 = 0;
            if (next.f24768e == null) {
                while (OplusGLSurfaceView_13 < this.f24751g) {
                    this.f24752h += next.f24766c[OplusGLSurfaceView_13];
                    OplusGLSurfaceView_13++;
                }
            } else {
                next.f24768e = null;
                while (OplusGLSurfaceView_13 < this.f24751g) {
                    m25960b(next.m25998a(OplusGLSurfaceView_13));
                    m25960b(next.m26000b(OplusGLSurfaceView_13));
                    OplusGLSurfaceView_13++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public synchronized void m25970g() throws IOException {
        BufferedWriter bufferedWriter;
        if (this.f24753i != null) {
            this.f24753i.close();
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(this.f24748d), 8192);
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\OplusGLSurfaceView_11");
            bufferedWriter.write("1");
            bufferedWriter.write("\OplusGLSurfaceView_11");
            bufferedWriter.write(Integer.toString(this.f24749e));
            bufferedWriter.write("\OplusGLSurfaceView_11");
            bufferedWriter.write(Integer.toString(this.f24751g));
            bufferedWriter.write("\OplusGLSurfaceView_11");
            bufferedWriter.write("\OplusGLSurfaceView_11");
            for (IntrinsicsJvm.kt_4 bVar : this.f24754j.values()) {
                if (bVar.f24768e != null) {
                    bufferedWriter.write("DIRTY " + bVar.f24765b + '\OplusGLSurfaceView_11');
                } else {
                    bufferedWriter.write("CLEAN " + bVar.f24765b + bVar.m25999a() + '\OplusGLSurfaceView_11');
                }
            }
            bufferedWriter.close();
            this.f24748d.renameTo(this.f24747c);
            this.f24753i = new BufferedWriter(new FileWriter(this.f24747c, true), 8192);
        } catch (Throwable th) {
            try {
                bufferedWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m25960b(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized IntrinsicsJvm.kt_3 m25975a(String str) throws IOException {
        m25972i();
        m25967e(str);
        IntrinsicsJvm.kt_4 bVar = this.f24754j.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.f24767d) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f24751g];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f24751g; OplusGLSurfaceView_13++) {
            try {
                inputStreamArr[OplusGLSurfaceView_13] = new FileInputStream(bVar.m25998a(OplusGLSurfaceView_13));
            } catch (FileNotFoundException unused) {
                return null;
            }
        }
        this.f24755k++;
        this.f24753i.append((CharSequence) ("READ " + str + '\OplusGLSurfaceView_11'));
        if (m25971h()) {
            this.f24757m.submit(this.f24758n);
        }
        return new IntrinsicsJvm.kt_3(str, bVar.f24769f, inputStreamArr);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public PlatformImplementations.kt_3 m25976b(String str) throws IOException {
        return m25953a(str, -1L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private synchronized PlatformImplementations.kt_3 m25953a(String str, long OplusGLSurfaceView_15) throws IOException {
        m25972i();
        m25967e(str);
        IntrinsicsJvm.kt_4 bVar = this.f24754j.get(str);
        if (OplusGLSurfaceView_15 != -1 && (bVar == null || bVar.f24769f != OplusGLSurfaceView_15)) {
            return null;
        }
        if (bVar == null) {
            bVar = new IntrinsicsJvm.kt_4(str);
            this.f24754j.put(str, bVar);
        } else if (bVar.f24768e != null) {
            return null;
        }
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(bVar);
        bVar.f24768e = aVar;
        this.f24753i.write("DIRTY " + str + '\OplusGLSurfaceView_11');
        this.f24753i.flush();
        return aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public File m25974a() {
        return this.f24746b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m25957a(PlatformImplementations.kt_3 aVar, boolean z) throws IOException {
        IntrinsicsJvm.kt_4 bVar = aVar.f24761b;
        if (bVar.f24768e != aVar) {
            throw new IllegalStateException();
        }
        if (z && !bVar.f24767d) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f24751g; OplusGLSurfaceView_13++) {
                if (!bVar.m26000b(OplusGLSurfaceView_13).exists()) {
                    aVar.m25986b();
                    throw new IllegalStateException("edit didn't create file " + OplusGLSurfaceView_13);
                }
            }
        }
        for (int i2 = 0; i2 < this.f24751g; i2++) {
            File fileM26000b = bVar.m26000b(i2);
            if (z) {
                if (fileM26000b.exists()) {
                    File fileM25998a = bVar.m25998a(i2);
                    fileM26000b.renameTo(fileM25998a);
                    long OplusGLSurfaceView_15 = bVar.f24766c[i2];
                    long length = fileM25998a.length();
                    bVar.f24766c[i2] = length;
                    this.f24752h = (this.f24752h - OplusGLSurfaceView_15) + length;
                }
            } else {
                m25960b(fileM26000b);
            }
        }
        this.f24755k++;
        bVar.f24768e = null;
        if (bVar.f24767d | z) {
            bVar.f24767d = true;
            this.f24753i.write("CLEAN " + bVar.f24765b + bVar.m25999a() + '\OplusGLSurfaceView_11');
            if (z) {
                long j2 = this.f24756l;
                this.f24756l = 1 + j2;
                bVar.f24769f = j2;
            }
        } else {
            this.f24754j.remove(bVar.f24765b);
            this.f24753i.write("REMOVE " + bVar.f24765b + '\OplusGLSurfaceView_11');
        }
        if (this.f24752h > this.f24750f || m25971h()) {
            this.f24757m.submit(this.f24758n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m25971h() {
        int OplusGLSurfaceView_13 = this.f24755k;
        return OplusGLSurfaceView_13 >= 2000 && OplusGLSurfaceView_13 >= this.f24754j.size();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public synchronized boolean m25979c(String str) throws IOException {
        m25972i();
        m25967e(str);
        IntrinsicsJvm.kt_4 bVar = this.f24754j.get(str);
        if (bVar != null && bVar.f24768e == null) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f24751g; OplusGLSurfaceView_13++) {
                File fileM25998a = bVar.m25998a(OplusGLSurfaceView_13);
                if (!fileM25998a.delete()) {
                    throw new IOException("failed to delete " + fileM25998a);
                }
                this.f24752h -= bVar.f24766c[OplusGLSurfaceView_13];
                bVar.f24766c[OplusGLSurfaceView_13] = 0;
            }
            this.f24755k++;
            this.f24753i.append((CharSequence) ("REMOVE " + str + '\OplusGLSurfaceView_11'));
            this.f24754j.remove(str);
            if (m25971h()) {
                this.f24757m.submit(this.f24758n);
            }
            return true;
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized boolean m25977b() {
        return this.f24753i == null;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m25972i() {
        if (this.f24753i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public synchronized void m25978c() throws IOException {
        m25972i();
        m25973j();
        this.f24753i.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f24753i == null) {
            return;
        }
        Iterator it = new ArrayList(this.f24754j.values()).iterator();
        while (it.hasNext()) {
            IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) it.next();
            if (bVar.f24768e != null) {
                bVar.f24768e.m25986b();
            }
        }
        m25973j();
        this.f24753i.close();
        this.f24753i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public void m25973j() throws IOException {
        while (this.f24752h > this.f24750f) {
            m25979c(this.f24754j.entrySet().iterator().next().getKey());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m25980d() throws IOException {
        close();
        m25956a(this.f24746b);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m25967e(String str) {
        if (str.contains(" ") || str.contains("\OplusGLSurfaceView_11") || str.contains("\r")) {
            throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: libcore.io.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    public final class IntrinsicsJvm.kt_3 implements Closeable {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final String f24771b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final long f24772c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final InputStream[] f24773d;

        private IntrinsicsJvm.kt_3(String str, long OplusGLSurfaceView_15, InputStream[] inputStreamArr) {
            this.f24771b = str;
            this.f24772c = OplusGLSurfaceView_15;
            this.f24773d = inputStreamArr;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public InputStream m26001a(int OplusGLSurfaceView_13) {
            return this.f24773d[OplusGLSurfaceView_13];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            for (InputStream inputStream : this.f24773d) {
                DiskLruCache.m25955a((Closeable) inputStream);
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: libcore.io.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public final class PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final IntrinsicsJvm.kt_4 f24761b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f24762c;

        private PlatformImplementations.kt_3(IntrinsicsJvm.kt_4 bVar) {
            this.f24761b = bVar;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public OutputStream m25984a(int OplusGLSurfaceView_13) throws IOException {
            DiskLruCache_4 c4134a;
            synchronized (DiskLruCache.this) {
                if (this.f24761b.f24768e != this) {
                    throw new IllegalStateException();
                }
                c4134a = new DiskLruCache_4(new FileOutputStream(this.f24761b.m26000b(OplusGLSurfaceView_13)));
            }
            return c4134a;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m25985a() throws IOException {
            if (this.f24762c) {
                DiskLruCache.this.m25957a(this, false);
                DiskLruCache.this.m25979c(this.f24761b.f24765b);
            } else {
                DiskLruCache.this.m25957a(this, true);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m25986b() throws IOException {
            DiskLruCache.this.m25957a(this, false);
        }

        /* compiled from: DiskLruCache.java */
        /* renamed from: libcore.io.PlatformImplementations.kt_3$PlatformImplementations.kt_3$PlatformImplementations.kt_3, reason: collision with other inner class name */
        private class DiskLruCache_4 extends FilterOutputStream {
            private DiskLruCache_4(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int OplusGLSurfaceView_13) throws IOException {
                try {
                    this.out.write(OplusGLSurfaceView_13);
                } catch (IOException unused) {
                    PlatformImplementations.kt_3.this.f24762c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
                try {
                    this.out.write(bArr, OplusGLSurfaceView_13, i2);
                } catch (IOException unused) {
                    PlatformImplementations.kt_3.this.f24762c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    PlatformImplementations.kt_3.this.f24762c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    PlatformImplementations.kt_3.this.f24762c = true;
                }
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: libcore.io.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    private final class IntrinsicsJvm.kt_4 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final String f24765b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final long[] f24766c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f24767d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private PlatformImplementations.kt_3 f24768e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private long f24769f;

        private IntrinsicsJvm.kt_4(String str) {
            this.f24765b = str;
            this.f24766c = new long[DiskLruCache.this.f24751g];
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public String m25999a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long OplusGLSurfaceView_15 : this.f24766c) {
                sb.append(' ');
                sb.append(OplusGLSurfaceView_15);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public void m25991a(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.f24751g) {
                throw m25993b(strArr);
            }
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArr.length; OplusGLSurfaceView_13++) {
                try {
                    this.f24766c[OplusGLSurfaceView_13] = Long.parseLong(strArr[OplusGLSurfaceView_13]);
                } catch (NumberFormatException unused) {
                    throw m25993b(strArr);
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private IOException m25993b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public File m25998a(int OplusGLSurfaceView_13) {
            return new File(DiskLruCache.this.f24746b, this.f24765b + "." + OplusGLSurfaceView_13);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public File m26000b(int OplusGLSurfaceView_13) {
            return new File(DiskLruCache.this.f24746b, this.f24765b + "." + OplusGLSurfaceView_13 + ".tmp");
        }
    }
}
