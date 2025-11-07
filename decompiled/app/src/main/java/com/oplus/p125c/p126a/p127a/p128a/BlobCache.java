package com.oplus.p125c.p126a.p127a.p128a;

import com.oplus.p125c.p126a.p135e.Debugger.kt;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.Adler32;

/* compiled from: BlobCache.java */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class BlobCache implements Closeable {

    /* renamed from: PlatformImplementations.kt_3 */
    private RandomAccessFile f10472a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private RandomAccessFile f10473b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RandomAccessFile f10474c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private FileChannel f10475d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private MappedByteBuffer f10476e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f10477f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f10478g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f10479h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f10480i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f10481j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f10482k;

    /* renamed from: OplusGLSurfaceView_14 */
    private RandomAccessFile f10483l;

    /* renamed from: OplusGLSurfaceView_6 */
    private RandomAccessFile f10484m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f10485n;

    /* renamed from: o */
    private int f10486o;

    /* renamed from: p */
    private byte[] f10487p = new byte[32];

    /* renamed from: q */
    private byte[] f10488q = new byte[20];

    /* renamed from: r */
    private Adler32 f10489r = new Adler32();

    /* renamed from: s */
    private PlatformImplementations.kt_3 f10490s = new PlatformImplementations.kt_3();

    /* renamed from: t */
    private int f10491t;

    /* renamed from: u */
    private int f10492u;

    /* compiled from: BlobCache.java */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public long f10493a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public byte[] f10494b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f10495c;
    }

    public BlobCache(String str, int OplusGLSurfaceView_13, int i2, boolean z, int i3) throws IOException {
        this.f10472a = new RandomAccessFile(str + ".idx", "rw");
        this.f10473b = new RandomAccessFile(str + ".0", "rw");
        this.f10474c = new RandomAccessFile(str + ".1", "rw");
        this.f10482k = i3;
        if (z || !m9392d()) {
            m9381a(OplusGLSurfaceView_13, i2);
            if (m9392d()) {
                return;
            }
            m9391c();
            throw new IOException("unable to load index");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m9384a(String str) {
        m9389b(str + ".idx");
        m9389b(str + ".0");
        m9389b(str + ".1");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m9389b(String str) {
        try {
            new File(str).delete();
        } catch (Throwable unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m9401b();
        m9391c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m9391c() {
        m9383a(this.f10475d);
        m9383a(this.f10472a);
        m9383a(this.f10473b);
        m9383a(this.f10474c);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m9392d() throws IOException {
        try {
            this.f10472a.seek(0L);
            this.f10473b.seek(0L);
            this.f10474c.seek(0L);
            byte[] bArr = this.f10487p;
            if (this.f10472a.read(bArr) != 32) {
                Debugger.kt.m9505b("BlobCache", "cannot read header");
                return false;
            }
            if (m9379a(bArr, 0) != -1289277392) {
                Debugger.kt.m9505b("BlobCache", "cannot read header magic");
                return false;
            }
            if (m9379a(bArr, 24) != this.f10482k) {
                Debugger.kt.m9505b("BlobCache", "version mismatch");
                return false;
            }
            this.f10477f = m9379a(bArr, 4);
            this.f10478g = m9379a(bArr, 8);
            this.f10479h = m9379a(bArr, 12);
            this.f10480i = m9379a(bArr, 16);
            this.f10481j = m9379a(bArr, 20);
            if (m9397a(bArr, 0, 28) != m9379a(bArr, 28)) {
                Debugger.kt.m9505b("BlobCache", "header checksum does not match");
                return false;
            }
            if (this.f10477f <= 0) {
                Debugger.kt.m9505b("BlobCache", "invalid max entries");
                return false;
            }
            if (this.f10478g <= 0) {
                Debugger.kt.m9505b("BlobCache", "invalid max bytes");
                return false;
            }
            if (this.f10479h != 0 && this.f10479h != 1) {
                Debugger.kt.m9505b("BlobCache", "invalid active region");
                return false;
            }
            if (this.f10480i >= 0 && this.f10480i <= this.f10477f) {
                if (this.f10481j >= 4 && this.f10481j <= this.f10478g) {
                    if (this.f10472a.length() != (this.f10477f * 12 * 2) + 32) {
                        Debugger.kt.m9505b("BlobCache", "invalid index file length");
                        return false;
                    }
                    byte[] bArr2 = new byte[4];
                    if (this.f10473b.read(bArr2) != 4) {
                        Debugger.kt.m9505b("BlobCache", "cannot read data file magic");
                        return false;
                    }
                    if (m9379a(bArr2, 0) != -1121680112) {
                        Debugger.kt.m9505b("BlobCache", "invalid data file magic");
                        return false;
                    }
                    if (this.f10474c.read(bArr2) != 4) {
                        Debugger.kt.m9505b("BlobCache", "cannot read data file magic");
                        return false;
                    }
                    if (m9379a(bArr2, 0) != -1121680112) {
                        Debugger.kt.m9505b("BlobCache", "invalid data file magic");
                        return false;
                    }
                    this.f10475d = this.f10472a.getChannel();
                    this.f10476e = this.f10475d.map(FileChannel.MapMode.READ_WRITE, 0L, this.f10472a.length());
                    this.f10476e.order(ByteOrder.LITTLE_ENDIAN);
                    m9393e();
                    return true;
                }
                Debugger.kt.m9505b("BlobCache", "invalid active bytes");
                return false;
            }
            Debugger.kt.m9505b("BlobCache", "invalid active entries");
            return false;
        } catch (IOException COUIBaseListPopupWindow_8) {
            Debugger.kt.m9508c("BlobCache", "loadIndex failed.", COUIBaseListPopupWindow_8);
            return false;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m9393e() throws IOException {
        this.f10483l = this.f10479h == 0 ? this.f10473b : this.f10474c;
        this.f10484m = this.f10479h == 1 ? this.f10473b : this.f10474c;
        this.f10483l.setLength(this.f10481j);
        this.f10483l.seek(this.f10481j);
        this.f10485n = 32;
        this.f10486o = 32;
        if (this.f10479h == 0) {
            this.f10486o += this.f10477f * 12;
        } else {
            this.f10485n += this.f10477f * 12;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9381a(int OplusGLSurfaceView_13, int i2) throws IOException {
        this.f10472a.setLength(0L);
        this.f10472a.setLength((OplusGLSurfaceView_13 * 12 * 2) + 32);
        this.f10472a.seek(0L);
        byte[] bArr = this.f10487p;
        m9390b(bArr, 0, -1289277392);
        m9390b(bArr, 4, OplusGLSurfaceView_13);
        m9390b(bArr, 8, i2);
        m9390b(bArr, 12, 0);
        m9390b(bArr, 16, 0);
        m9390b(bArr, 20, 4);
        m9390b(bArr, 24, this.f10482k);
        m9390b(bArr, 28, m9397a(bArr, 0, 28));
        this.f10472a.write(bArr);
        this.f10473b.setLength(0L);
        this.f10474c.setLength(0L);
        this.f10473b.seek(0L);
        this.f10474c.seek(0L);
        m9390b(bArr, 0, -1121680112);
        this.f10473b.write(bArr, 0, 4);
        this.f10474c.write(bArr, 0, 4);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m9394f() throws IOException {
        this.f10479h = 1 - this.f10479h;
        this.f10480i = 0;
        this.f10481j = 4;
        m9390b(this.f10487p, 12, this.f10479h);
        m9390b(this.f10487p, 16, this.f10480i);
        m9390b(this.f10487p, 20, this.f10481j);
        m9395g();
        m9393e();
        m9380a(this.f10485n);
        m9398a();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m9395g() {
        byte[] bArr = this.f10487p;
        m9390b(bArr, 28, m9397a(bArr, 0, 28));
        this.f10476e.position(0);
        this.f10476e.put(this.f10487p);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9380a(int OplusGLSurfaceView_13) {
        byte[] bArr = new byte[1024];
        this.f10476e.position(OplusGLSurfaceView_13);
        int i2 = this.f10477f * 12;
        while (i2 > 0) {
            int iMin = Math.min(i2, 1024);
            this.f10476e.put(bArr, 0, iMin);
            i2 -= iMin;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9399a(long OplusGLSurfaceView_15, byte[] bArr) throws IOException {
        int length = bArr.length + 24;
        int OplusGLSurfaceView_13 = this.f10478g;
        if (length > OplusGLSurfaceView_13) {
            throw new RuntimeException("blob is too large!");
        }
        if (this.f10481j + 20 + bArr.length > OplusGLSurfaceView_13 || this.f10480i * 2 >= this.f10477f) {
            m9394f();
        }
        if (!m9386a(OplusGLSurfaceView_15, this.f10485n)) {
            this.f10480i++;
            m9390b(this.f10487p, 16, this.f10480i);
        }
        m9382a(OplusGLSurfaceView_15, bArr, bArr.length);
        m9395g();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m9382a(long OplusGLSurfaceView_15, byte[] bArr, int OplusGLSurfaceView_13) throws IOException {
        byte[] bArr2 = this.f10488q;
        int iM9396a = m9396a(bArr);
        m9385a(bArr2, 0, OplusGLSurfaceView_15);
        m9390b(bArr2, 8, iM9396a);
        m9390b(bArr2, 12, this.f10481j);
        m9390b(bArr2, 16, OplusGLSurfaceView_13);
        this.f10483l.write(bArr2);
        this.f10483l.write(bArr, 0, OplusGLSurfaceView_13);
        this.f10476e.putLong(this.f10491t, OplusGLSurfaceView_15);
        this.f10476e.putInt(this.f10491t + 8, this.f10481j);
        this.f10481j += OplusGLSurfaceView_13 + 20;
        m9390b(this.f10487p, 20, this.f10481j);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m9400a(PlatformImplementations.kt_3 aVar) throws IOException {
        if (m9386a(aVar.f10493a, this.f10485n) && m9387a(this.f10483l, this.f10492u, aVar)) {
            return true;
        }
        int OplusGLSurfaceView_13 = this.f10491t;
        if (!m9386a(aVar.f10493a, this.f10486o) || !m9387a(this.f10484m, this.f10492u, aVar)) {
            return false;
        }
        if (this.f10481j + 20 + aVar.f10495c <= this.f10478g && this.f10480i * 2 < this.f10477f) {
            this.f10491t = OplusGLSurfaceView_13;
            try {
                m9382a(aVar.f10493a, aVar.f10494b, aVar.f10495c);
                this.f10480i++;
                m9390b(this.f10487p, 16, this.f10480i);
                m9395g();
            } catch (Throwable unused) {
                Debugger.kt.m9507c("BlobCache", "cannot copy over");
            }
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m9387a(RandomAccessFile randomAccessFile, int OplusGLSurfaceView_13, PlatformImplementations.kt_3 aVar) throws IOException {
        byte[] bArr = this.f10488q;
        long filePointer = randomAccessFile.getFilePointer();
        try {
            randomAccessFile.seek(OplusGLSurfaceView_13);
            if (randomAccessFile.read(bArr) != 20) {
                Debugger.kt.m9505b("BlobCache", "cannot read blob header");
                return false;
            }
            long jM9388b = m9388b(bArr, 0);
            if (jM9388b == 0) {
                return false;
            }
            if (jM9388b != aVar.f10493a) {
                Debugger.kt.m9505b("BlobCache", "blob key does not match: " + jM9388b);
                return false;
            }
            int iM9379a = m9379a(bArr, 8);
            int iM9379a2 = m9379a(bArr, 12);
            if (iM9379a2 != OplusGLSurfaceView_13) {
                Debugger.kt.m9505b("BlobCache", "blob offset does not match: " + iM9379a2);
                return false;
            }
            int iM9379a3 = m9379a(bArr, 16);
            if (iM9379a3 >= 0 && iM9379a3 <= (this.f10478g - OplusGLSurfaceView_13) - 20) {
                if (aVar.f10494b == null || aVar.f10494b.length < iM9379a3) {
                    aVar.f10494b = new byte[iM9379a3];
                }
                byte[] bArr2 = aVar.f10494b;
                aVar.f10495c = iM9379a3;
                if (randomAccessFile.read(bArr2, 0, iM9379a3) != iM9379a3) {
                    Debugger.kt.m9505b("BlobCache", "cannot read blob data");
                    return false;
                }
                if (m9397a(bArr2, 0, iM9379a3) == iM9379a) {
                    return true;
                }
                Debugger.kt.m9505b("BlobCache", "blob checksum does not match: " + iM9379a);
                return false;
            }
            Debugger.kt.m9505b("BlobCache", "invalid blob length: " + iM9379a3);
            return false;
        } catch (Throwable th) {
            Debugger.kt.m9508c("BlobCache", "getBlob failed.", th);
            return false;
        } finally {
            randomAccessFile.seek(filePointer);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m9386a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        int i2 = this.f10477f;
        int i3 = (int) (OplusGLSurfaceView_15 % i2);
        if (i3 < 0) {
            i3 += i2;
        }
        int i4 = i3;
        while (true) {
            int i5 = (i4 * 12) + OplusGLSurfaceView_13;
            long j2 = this.f10476e.getLong(i5);
            int i6 = this.f10476e.getInt(i5 + 8);
            if (i6 == 0) {
                this.f10491t = i5;
                return false;
            }
            if (j2 == OplusGLSurfaceView_15) {
                this.f10491t = i5;
                this.f10492u = i6;
                return true;
            }
            i4++;
            if (i4 >= this.f10477f) {
                i4 = 0;
            }
            if (i4 == i3) {
                Debugger.kt.m9505b("BlobCache", "corrupted index: clear the slot.");
                this.f10476e.putInt((i4 * 12) + OplusGLSurfaceView_13 + 8, 0);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9398a() {
        try {
            this.f10476e.force();
        } catch (Throwable th) {
            Debugger.kt.m9506b("BlobCache", "sync index failed", th);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m9401b() {
        m9398a();
        try {
            this.f10473b.getFD().sync();
        } catch (Throwable th) {
            Debugger.kt.m9506b("BlobCache", "sync data file 0 failed", th);
        }
        try {
            this.f10474c.getFD().sync();
        } catch (Throwable th2) {
            Debugger.kt.m9506b("BlobCache", "sync data file 1 failed", th2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int m9396a(byte[] bArr) {
        this.f10489r.reset();
        this.f10489r.update(bArr);
        return (int) this.f10489r.getValue();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int m9397a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        this.f10489r.reset();
        this.f10489r.update(bArr, OplusGLSurfaceView_13, i2);
        return (int) this.f10489r.getValue();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m9383a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int m9379a(byte[] bArr, int OplusGLSurfaceView_13) {
        return ((bArr[OplusGLSurfaceView_13 + 3] & 255) << 24) | (bArr[OplusGLSurfaceView_13] & 255) | ((bArr[OplusGLSurfaceView_13 + 1] & 255) << 8) | ((bArr[OplusGLSurfaceView_13 + 2] & 255) << 16);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static long m9388b(byte[] bArr, int OplusGLSurfaceView_13) {
        long OplusGLSurfaceView_15 = bArr[OplusGLSurfaceView_13 + 7] & 255;
        for (int i2 = 6; i2 >= 0; i2--) {
            OplusGLSurfaceView_15 = (OplusGLSurfaceView_15 << 8) | (bArr[OplusGLSurfaceView_13 + i2] & 255);
        }
        return OplusGLSurfaceView_15;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static void m9390b(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[OplusGLSurfaceView_13 + i3] = (byte) (i2 & 255);
            i2 >>= 8;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m9385a(byte[] bArr, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[OplusGLSurfaceView_13 + i2] = (byte) (255 & OplusGLSurfaceView_15);
            OplusGLSurfaceView_15 >>= 8;
        }
    }
}
