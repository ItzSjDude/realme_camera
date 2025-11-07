package com.oplus.c_renamed.a_renamed.a_renamed.a_renamed;

/* compiled from: BlobCache.java */
/* loaded from: classes2.dex */
public class a_renamed implements java.io.Closeable {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.io.RandomAccessFile f3733a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.io.RandomAccessFile f3734b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.io.RandomAccessFile f3735c;
    private java.nio.channels.FileChannel d_renamed;
    private java.nio.MappedByteBuffer e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;
    private java.io.RandomAccessFile l_renamed;
    private java.io.RandomAccessFile m_renamed;
    private int n_renamed;
    private int o_renamed;
    private byte[] p_renamed = new byte[32];
    private byte[] q_renamed = new byte[20];
    private java.util.zip.Adler32 r_renamed = new java.util.zip.Adler32();
    private com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.a_renamed.BlobCache_2 s_renamed = new com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.a_renamed.BlobCache_2();
    private int t_renamed;
    private int u_renamed;

    /* compiled from: BlobCache.java */
    /* renamed from: com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public static class BlobCache_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        public long f3736a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public byte[] f3737b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f3738c;
    }

    public a_renamed(java.lang.String str, int i_renamed, int i2, boolean z_renamed, int i3) throws java.io.IOException {
        this.f3733a = new java.io.RandomAccessFile(str + ".idx", "rw");
        this.f3734b = new java.io.RandomAccessFile(str + ".0", "rw");
        this.f3735c = new java.io.RandomAccessFile(str + ".1", "rw");
        this.k_renamed = i3;
        if (z_renamed || !d_renamed()) {
            a_renamed(i_renamed, i2);
            if (d_renamed()) {
                return;
            }
            c_renamed();
            throw new java.io.IOException("unable to load index");
        }
    }

    public static void a_renamed(java.lang.String str) {
        b_renamed(str + ".idx");
        b_renamed(str + ".0");
        b_renamed(str + ".1");
    }

    private static void b_renamed(java.lang.String str) {
        try {
            new java.io.File(str).delete();
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b_renamed();
        c_renamed();
    }

    private void c_renamed() {
        a_renamed(this.d_renamed);
        a_renamed(this.f3733a);
        a_renamed(this.f3734b);
        a_renamed(this.f3735c);
    }

    private boolean d_renamed() throws java.io.IOException {
        try {
            this.f3733a.seek(0L);
            this.f3734b.seek(0L);
            this.f3735c.seek(0L);
            byte[] bArr = this.p_renamed;
            if (this.f3733a.read(bArr) != 32) {
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "cannot read header");
                return false;
            }
            if (a_renamed(bArr, 0) != -1289277392) {
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "cannot read header magic");
                return false;
            }
            if (a_renamed(bArr, 24) != this.k_renamed) {
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "version mismatch");
                return false;
            }
            this.f_renamed = a_renamed(bArr, 4);
            this.g_renamed = a_renamed(bArr, 8);
            this.h_renamed = a_renamed(bArr, 12);
            this.i_renamed = a_renamed(bArr, 16);
            this.j_renamed = a_renamed(bArr, 20);
            if (a_renamed(bArr, 0, 28) != a_renamed(bArr, 28)) {
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "header checksum does not match");
                return false;
            }
            if (this.f_renamed <= 0) {
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "invalid max entries");
                return false;
            }
            if (this.g_renamed <= 0) {
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "invalid max bytes");
                return false;
            }
            if (this.h_renamed != 0 && this.h_renamed != 1) {
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "invalid active region");
                return false;
            }
            if (this.i_renamed >= 0 && this.i_renamed <= this.f_renamed) {
                if (this.j_renamed >= 4 && this.j_renamed <= this.g_renamed) {
                    if (this.f3733a.length() != (this.f_renamed * 12 * 2) + 32) {
                        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "invalid index file length");
                        return false;
                    }
                    byte[] bArr2 = new byte[4];
                    if (this.f3734b.read(bArr2) != 4) {
                        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "cannot read data file magic");
                        return false;
                    }
                    if (a_renamed(bArr2, 0) != -1121680112) {
                        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "invalid data file magic");
                        return false;
                    }
                    if (this.f3735c.read(bArr2) != 4) {
                        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "cannot read data file magic");
                        return false;
                    }
                    if (a_renamed(bArr2, 0) != -1121680112) {
                        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "invalid data file magic");
                        return false;
                    }
                    this.d_renamed = this.f3733a.getChannel();
                    this.e_renamed = this.d_renamed.map(java.nio.channels.FileChannel.MapMode.READ_WRITE, 0L, this.f3733a.length());
                    this.e_renamed.order(java.nio.ByteOrder.LITTLE_ENDIAN);
                    e_renamed();
                    return true;
                }
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "invalid active bytes");
                return false;
            }
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "invalid active entries");
            return false;
        } catch (java.io.IOException e_renamed) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.c_renamed("BlobCache", "loadIndex failed.", e_renamed);
            return false;
        }
    }

    private void e_renamed() throws java.io.IOException {
        this.l_renamed = this.h_renamed == 0 ? this.f3734b : this.f3735c;
        this.m_renamed = this.h_renamed == 1 ? this.f3734b : this.f3735c;
        this.l_renamed.setLength(this.j_renamed);
        this.l_renamed.seek(this.j_renamed);
        this.n_renamed = 32;
        this.o_renamed = 32;
        if (this.h_renamed == 0) {
            this.o_renamed += this.f_renamed * 12;
        } else {
            this.n_renamed += this.f_renamed * 12;
        }
    }

    private void a_renamed(int i_renamed, int i2) throws java.io.IOException {
        this.f3733a.setLength(0L);
        this.f3733a.setLength((i_renamed * 12 * 2) + 32);
        this.f3733a.seek(0L);
        byte[] bArr = this.p_renamed;
        b_renamed(bArr, 0, -1289277392);
        b_renamed(bArr, 4, i_renamed);
        b_renamed(bArr, 8, i2);
        b_renamed(bArr, 12, 0);
        b_renamed(bArr, 16, 0);
        b_renamed(bArr, 20, 4);
        b_renamed(bArr, 24, this.k_renamed);
        b_renamed(bArr, 28, a_renamed(bArr, 0, 28));
        this.f3733a.write(bArr);
        this.f3734b.setLength(0L);
        this.f3735c.setLength(0L);
        this.f3734b.seek(0L);
        this.f3735c.seek(0L);
        b_renamed(bArr, 0, -1121680112);
        this.f3734b.write(bArr, 0, 4);
        this.f3735c.write(bArr, 0, 4);
    }

    private void f_renamed() throws java.io.IOException {
        this.h_renamed = 1 - this.h_renamed;
        this.i_renamed = 0;
        this.j_renamed = 4;
        b_renamed(this.p_renamed, 12, this.h_renamed);
        b_renamed(this.p_renamed, 16, this.i_renamed);
        b_renamed(this.p_renamed, 20, this.j_renamed);
        g_renamed();
        e_renamed();
        a_renamed(this.n_renamed);
        a_renamed();
    }

    private void g_renamed() {
        byte[] bArr = this.p_renamed;
        b_renamed(bArr, 28, a_renamed(bArr, 0, 28));
        this.e_renamed.position(0);
        this.e_renamed.put(this.p_renamed);
    }

    private void a_renamed(int i_renamed) {
        byte[] bArr = new byte[1024];
        this.e_renamed.position(i_renamed);
        int i2 = this.f_renamed * 12;
        while (i2 > 0) {
            int iMin = java.lang.Math.min(i2, 1024);
            this.e_renamed.put(bArr, 0, iMin);
            i2 -= iMin;
        }
    }

    public void a_renamed(long j_renamed, byte[] bArr) throws java.io.IOException {
        int length = bArr.length + 24;
        int i_renamed = this.g_renamed;
        if (length > i_renamed) {
            throw new java.lang.RuntimeException("blob is_renamed too large!");
        }
        if (this.j_renamed + 20 + bArr.length > i_renamed || this.i_renamed * 2 >= this.f_renamed) {
            f_renamed();
        }
        if (!a_renamed(j_renamed, this.n_renamed)) {
            this.i_renamed++;
            b_renamed(this.p_renamed, 16, this.i_renamed);
        }
        a_renamed(j_renamed, bArr, bArr.length);
        g_renamed();
    }

    private void a_renamed(long j_renamed, byte[] bArr, int i_renamed) throws java.io.IOException {
        byte[] bArr2 = this.q_renamed;
        int iA = a_renamed(bArr);
        a_renamed(bArr2, 0, j_renamed);
        b_renamed(bArr2, 8, iA);
        b_renamed(bArr2, 12, this.j_renamed);
        b_renamed(bArr2, 16, i_renamed);
        this.l_renamed.write(bArr2);
        this.l_renamed.write(bArr, 0, i_renamed);
        this.e_renamed.putLong(this.t_renamed, j_renamed);
        this.e_renamed.putInt(this.t_renamed + 8, this.j_renamed);
        this.j_renamed += i_renamed + 20;
        b_renamed(this.p_renamed, 20, this.j_renamed);
    }

    public boolean a_renamed(com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.a_renamed.BlobCache_2 c0081a) throws java.io.IOException {
        if (a_renamed(c0081a.f3736a, this.n_renamed) && a_renamed(this.l_renamed, this.u_renamed, c0081a)) {
            return true;
        }
        int i_renamed = this.t_renamed;
        if (!a_renamed(c0081a.f3736a, this.o_renamed) || !a_renamed(this.m_renamed, this.u_renamed, c0081a)) {
            return false;
        }
        if (this.j_renamed + 20 + c0081a.f3738c <= this.g_renamed && this.i_renamed * 2 < this.f_renamed) {
            this.t_renamed = i_renamed;
            try {
                a_renamed(c0081a.f3736a, c0081a.f3737b, c0081a.f3738c);
                this.i_renamed++;
                b_renamed(this.p_renamed, 16, this.i_renamed);
                g_renamed();
            } catch (java.lang.Throwable unused) {
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.c_renamed("BlobCache", "cannot copy over");
            }
        }
        return true;
    }

    private boolean a_renamed(java.io.RandomAccessFile randomAccessFile, int i_renamed, com.oplus.c_renamed.a_renamed.a_renamed.a_renamed.a_renamed.BlobCache_2 c0081a) throws java.io.IOException {
        byte[] bArr = this.q_renamed;
        long filePointer = randomAccessFile.getFilePointer();
        try {
            randomAccessFile.seek(i_renamed);
            if (randomAccessFile.read(bArr) != 20) {
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "cannot read blob header");
                return false;
            }
            long jB = b_renamed(bArr, 0);
            if (jB == 0) {
                return false;
            }
            if (jB != c0081a.f3736a) {
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "blob key does not match: " + jB);
                return false;
            }
            int iA = a_renamed(bArr, 8);
            int iA2 = a_renamed(bArr, 12);
            if (iA2 != i_renamed) {
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "blob offset does not match: " + iA2);
                return false;
            }
            int iA3 = a_renamed(bArr, 16);
            if (iA3 >= 0 && iA3 <= (this.g_renamed - i_renamed) - 20) {
                if (c0081a.f3737b == null || c0081a.f3737b.length < iA3) {
                    c0081a.f3737b = new byte[iA3];
                }
                byte[] bArr2 = c0081a.f3737b;
                c0081a.f3738c = iA3;
                if (randomAccessFile.read(bArr2, 0, iA3) != iA3) {
                    com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "cannot read blob data");
                    return false;
                }
                if (a_renamed(bArr2, 0, iA3) == iA) {
                    return true;
                }
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "blob checksum does not match: " + iA);
                return false;
            }
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "invalid blob length: " + iA3);
            return false;
        } catch (java.lang.Throwable th) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.c_renamed("BlobCache", "getBlob failed.", th);
            return false;
        } finally {
            randomAccessFile.seek(filePointer);
        }
    }

    private boolean a_renamed(long j_renamed, int i_renamed) {
        int i2 = this.f_renamed;
        int i3 = (int) (j_renamed % i2);
        if (i3 < 0) {
            i3 += i2;
        }
        int i4 = i3;
        while (true) {
            int i5 = (i4 * 12) + i_renamed;
            long j2 = this.e_renamed.getLong(i5);
            int i6 = this.e_renamed.getInt(i5 + 8);
            if (i6 == 0) {
                this.t_renamed = i5;
                return false;
            }
            if (j2 == j_renamed) {
                this.t_renamed = i5;
                this.u_renamed = i6;
                return true;
            }
            i4++;
            if (i4 >= this.f_renamed) {
                i4 = 0;
            }
            if (i4 == i3) {
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "corrupted index: clear the slot.");
                this.e_renamed.putInt((i4 * 12) + i_renamed + 8, 0);
            }
        }
    }

    public void a_renamed() {
        try {
            this.e_renamed.force();
        } catch (java.lang.Throwable th) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "sync index failed", th);
        }
    }

    public void b_renamed() {
        a_renamed();
        try {
            this.f3734b.getFD().sync();
        } catch (java.lang.Throwable th) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "sync data file 0 failed", th);
        }
        try {
            this.f3735c.getFD().sync();
        } catch (java.lang.Throwable th2) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.b_renamed("BlobCache", "sync data file 1 failed", th2);
        }
    }

    int a_renamed(byte[] bArr) {
        this.r_renamed.reset();
        this.r_renamed.update(bArr);
        return (int) this.r_renamed.getValue();
    }

    int a_renamed(byte[] bArr, int i_renamed, int i2) {
        this.r_renamed.reset();
        this.r_renamed.update(bArr, i_renamed, i2);
        return (int) this.r_renamed.getValue();
    }

    static void a_renamed(java.io.Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (java.lang.Throwable unused) {
        }
    }

    static int a_renamed(byte[] bArr, int i_renamed) {
        return ((bArr[i_renamed + 3] & 255) << 24) | (bArr[i_renamed] & 255) | ((bArr[i_renamed + 1] & 255) << 8) | ((bArr[i_renamed + 2] & 255) << 16);
    }

    static long b_renamed(byte[] bArr, int i_renamed) {
        long j_renamed = bArr[i_renamed + 7] & 255;
        for (int i2 = 6; i2 >= 0; i2--) {
            j_renamed = (j_renamed << 8) | (bArr[i_renamed + i2] & 255);
        }
        return j_renamed;
    }

    static void b_renamed(byte[] bArr, int i_renamed, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i_renamed + i3] = (byte) (i2 & 255);
            i2 >>= 8;
        }
    }

    static void a_renamed(byte[] bArr, int i_renamed, long j_renamed) {
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i_renamed + i2] = (byte) (255 & j_renamed);
            j_renamed >>= 8;
        }
    }
}
