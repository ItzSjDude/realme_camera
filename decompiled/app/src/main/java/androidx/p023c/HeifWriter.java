package androidx.p023c;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.p023c.HeifEncoder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: HeifWriter.java */
/* renamed from: androidx.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public final class HeifWriter implements AutoCloseable {

    /* renamed from: PlatformImplementations.kt_3 */
    int f2096a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final int f2097b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    final int f2098c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    final int f2099d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    MediaMuxer f2101f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    int[] f2103h;

    /* renamed from: OplusGLSurfaceView_13 */
    int f2104i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final int f2105j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final HandlerThread f2106k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final Handler f2107l;

    /* renamed from: OplusGLSurfaceView_6 */
    private HeifEncoder f2108m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f2109n;

    /* renamed from: COUIBaseListPopupWindow_8 */
    final IntrinsicsJvm.kt_3 f2100e = new IntrinsicsJvm.kt_3();

    /* renamed from: COUIBaseListPopupWindow_11 */
    final AtomicBoolean f2102g = new AtomicBoolean(false);

    /* renamed from: o */
    private final List<Pair<Integer, ByteBuffer>> f2110o = new ArrayList();

    /* compiled from: HeifWriter.java */
    /* renamed from: androidx.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final String f2112a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final FileDescriptor f2113b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final int f2114c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final int f2115d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private final int f2116e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private boolean f2117f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private int f2118g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private int f2119h;

        /* renamed from: OplusGLSurfaceView_13 */
        private int f2120i;

        /* renamed from: OplusGLSurfaceView_15 */
        private int f2121j;

        /* renamed from: OplusGLSurfaceView_5 */
        private Handler f2122k;

        public PlatformImplementations.kt_3(FileDescriptor fileDescriptor, int OplusGLSurfaceView_13, int i2, int i3) {
            this(null, fileDescriptor, OplusGLSurfaceView_13, i2, i3);
        }

        private PlatformImplementations.kt_3(String str, FileDescriptor fileDescriptor, int OplusGLSurfaceView_13, int i2, int i3) {
            this.f2117f = true;
            this.f2118g = 100;
            this.f2119h = 1;
            this.f2120i = 0;
            this.f2121j = 0;
            if (OplusGLSurfaceView_13 <= 0 || i2 <= 0) {
                throw new IllegalArgumentException("Invalid image size: " + OplusGLSurfaceView_13 + "x" + i2);
            }
            this.f2112a = str;
            this.f2113b = fileDescriptor;
            this.f2114c = OplusGLSurfaceView_13;
            this.f2115d = i2;
            this.f2116e = i3;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public PlatformImplementations.kt_3 m1817a(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 != 0 && OplusGLSurfaceView_13 != 90 && OplusGLSurfaceView_13 != 180 && OplusGLSurfaceView_13 != 270) {
                throw new IllegalArgumentException("Invalid rotation angle: " + OplusGLSurfaceView_13);
            }
            this.f2121j = OplusGLSurfaceView_13;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public PlatformImplementations.kt_3 m1819a(boolean z) {
            this.f2117f = z;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public PlatformImplementations.kt_3 m1821b(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > 100) {
                throw new IllegalArgumentException("Invalid quality: " + OplusGLSurfaceView_13);
            }
            this.f2118g = OplusGLSurfaceView_13;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public PlatformImplementations.kt_3 m1822c(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 <= 0) {
                throw new IllegalArgumentException("Invalid maxImage: " + OplusGLSurfaceView_13);
            }
            this.f2119h = OplusGLSurfaceView_13;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public PlatformImplementations.kt_3 m1823d(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 < 0) {
                throw new IllegalArgumentException("Invalid primaryIndex: " + OplusGLSurfaceView_13);
            }
            this.f2120i = OplusGLSurfaceView_13;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public PlatformImplementations.kt_3 m1818a(Handler handler) {
            this.f2122k = handler;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public HeifWriter m1820a() throws IOException {
            return new HeifWriter(this.f2112a, this.f2113b, this.f2114c, this.f2115d, this.f2121j, this.f2117f, this.f2118g, this.f2119h, this.f2120i, this.f2116e, this.f2122k);
        }
    }

    @SuppressLint({"WrongConstant"})
    HeifWriter(String str, FileDescriptor fileDescriptor, int OplusGLSurfaceView_13, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, Handler handler) throws IOException {
        if (i6 >= i5) {
            throw new IllegalArgumentException("Invalid maxImages (" + i5 + ") or primaryIndex (" + i6 + ")");
        }
        this.f2096a = 1;
        this.f2097b = i3;
        this.f2105j = i7;
        this.f2098c = i5;
        this.f2099d = i6;
        Looper looper = handler != null ? handler.getLooper() : null;
        if (looper == null) {
            this.f2106k = new HandlerThread("HeifEncoderThread", -2);
            this.f2106k.start();
            looper = this.f2106k.getLooper();
        } else {
            this.f2106k = null;
        }
        this.f2107l = new Handler(looper);
        this.f2101f = str != null ? new MediaMuxer(str, 3) : new MediaMuxer(fileDescriptor, 3);
        this.f2108m = new HeifEncoder(OplusGLSurfaceView_13, i2, z, i4, this.f2105j, this.f2107l, new IntrinsicsJvm.kt_4());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1811a() {
        m1809a(false);
        this.f2109n = true;
        this.f2108m.m1793a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1814a(Bitmap bitmap) {
        m1810b(2);
        synchronized (this) {
            if (this.f2108m != null) {
                this.f2108m.m1794a(bitmap);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1812a(int OplusGLSurfaceView_13, byte[] bArr, int i2, int i3) {
        m1809a(true);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i3);
        byteBufferAllocateDirect.put(bArr, i2, i3);
        byteBufferAllocateDirect.flip();
        synchronized (this.f2110o) {
            this.f2110o.add(new Pair<>(Integer.valueOf(OplusGLSurfaceView_13), byteBufferAllocateDirect));
        }
        m1815b();
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: IntrinsicsJvm.kt_4 */
    void m1815b() {
        Pair<Integer, ByteBuffer> pairRemove;
        if (!this.f2102g.get()) {
            return;
        }
        while (true) {
            synchronized (this.f2110o) {
                if (this.f2110o.isEmpty()) {
                    return;
                } else {
                    pairRemove = this.f2110o.remove(0);
                }
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.set(((ByteBuffer) pairRemove.second).position(), ((ByteBuffer) pairRemove.second).remaining(), 0L, 16);
            this.f2101f.writeSampleData(this.f2103h[((Integer) pairRemove.first).intValue()], (ByteBuffer) pairRemove.second, bufferInfo);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1813a(long OplusGLSurfaceView_15) throws Exception {
        m1809a(true);
        synchronized (this) {
            if (this.f2108m != null) {
                this.f2108m.m1795b();
            }
        }
        this.f2100e.m1825a(OplusGLSurfaceView_15);
        m1815b();
        m1816c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1809a(boolean z) {
        if (this.f2109n != z) {
            throw new IllegalStateException("Already started");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1808a(int OplusGLSurfaceView_13) {
        if (this.f2105j == OplusGLSurfaceView_13) {
            return;
        }
        throw new IllegalStateException("Not valid in input mode " + this.f2105j);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m1810b(int OplusGLSurfaceView_13) {
        m1809a(true);
        m1808a(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m1816c() {
        MediaMuxer mediaMuxer = this.f2101f;
        if (mediaMuxer != null) {
            mediaMuxer.stop();
            this.f2101f.release();
            this.f2101f = null;
        }
        HeifEncoder c0360c = this.f2108m;
        if (c0360c != null) {
            c0360c.close();
            synchronized (this) {
                this.f2108m = null;
            }
        }
    }

    /* compiled from: HeifWriter.java */
    /* renamed from: androidx.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_4 */
    class IntrinsicsJvm.kt_4 extends HeifEncoder.PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f2124b;

        IntrinsicsJvm.kt_4() {
        }

        @Override // androidx.p023c.HeifEncoder.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo1800a(HeifEncoder c0360c, MediaFormat mediaFormat) {
            if (this.f2124b) {
                return;
            }
            if (HeifWriter.this.f2103h != null) {
                m1824a(new IllegalStateException("Output format changed after muxer started"));
                return;
            }
            try {
                HeifWriter.this.f2096a = mediaFormat.getInteger("grid-rows") * mediaFormat.getInteger("grid-cols");
            } catch (ClassCastException | NullPointerException unused) {
                HeifWriter.this.f2096a = 1;
            }
            HeifWriter c0361d = HeifWriter.this;
            c0361d.f2103h = new int[c0361d.f2098c];
            if (HeifWriter.this.f2097b > 0) {
                Log.IntrinsicsJvm.kt_5("HeifWriter", "setting rotation: " + HeifWriter.this.f2097b);
                HeifWriter.this.f2101f.setOrientationHint(HeifWriter.this.f2097b);
            }
            int OplusGLSurfaceView_13 = 0;
            while (OplusGLSurfaceView_13 < HeifWriter.this.f2103h.length) {
                mediaFormat.setInteger("is-default", OplusGLSurfaceView_13 == HeifWriter.this.f2099d ? 1 : 0);
                HeifWriter.this.f2103h[OplusGLSurfaceView_13] = HeifWriter.this.f2101f.addTrack(mediaFormat);
                OplusGLSurfaceView_13++;
            }
            HeifWriter.this.f2101f.start();
            HeifWriter.this.f2102g.set(true);
            HeifWriter.this.m1815b();
        }

        @Override // androidx.p023c.HeifEncoder.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo1801a(HeifEncoder c0360c, ByteBuffer byteBuffer) {
            if (this.f2124b) {
                return;
            }
            if (HeifWriter.this.f2103h == null) {
                m1824a(new IllegalStateException("Output buffer received before format info"));
                return;
            }
            if (HeifWriter.this.f2104i < HeifWriter.this.f2098c * HeifWriter.this.f2096a) {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                bufferInfo.set(byteBuffer.position(), byteBuffer.remaining(), 0L, 0);
                HeifWriter.this.f2101f.writeSampleData(HeifWriter.this.f2103h[HeifWriter.this.f2104i / HeifWriter.this.f2096a], byteBuffer, bufferInfo);
            }
            HeifWriter.this.f2104i++;
            if (HeifWriter.this.f2104i == HeifWriter.this.f2098c * HeifWriter.this.f2096a) {
                m1824a((Exception) null);
            }
        }

        @Override // androidx.p023c.HeifEncoder.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo1798a(HeifEncoder c0360c) {
            m1824a((Exception) null);
        }

        @Override // androidx.p023c.HeifEncoder.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo1799a(HeifEncoder c0360c, MediaCodec.CodecException codecException) {
            m1824a(codecException);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m1824a(Exception exc) {
            if (this.f2124b) {
                return;
            }
            this.f2124b = true;
            HeifWriter.this.f2100e.m1826a(exc);
        }
    }

    /* compiled from: HeifWriter.java */
    /* renamed from: androidx.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_3 */
    static class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean f2125a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Exception f2126b;

        IntrinsicsJvm.kt_3() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        synchronized void m1825a(long OplusGLSurfaceView_15) throws Exception {
            if (OplusGLSurfaceView_15 < 0) {
                throw new IllegalArgumentException("timeoutMs is negative");
            }
            if (OplusGLSurfaceView_15 == 0) {
                while (!this.f2125a) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                while (!this.f2125a && OplusGLSurfaceView_15 > 0) {
                    try {
                        wait(OplusGLSurfaceView_15);
                    } catch (InterruptedException unused2) {
                    }
                    OplusGLSurfaceView_15 -= System.currentTimeMillis() - jCurrentTimeMillis;
                }
            }
            if (!this.f2125a) {
                this.f2125a = true;
                this.f2126b = new TimeoutException("timed out waiting for result");
            }
            if (this.f2126b != null) {
                throw this.f2126b;
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        synchronized void m1826a(Exception exc) {
            if (!this.f2125a) {
                this.f2125a = true;
                this.f2126b = exc;
                notifyAll();
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.f2107l.postAtFrontOfQueue(new Runnable() { // from class: androidx.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HeifWriter.this.m1816c();
                } catch (Exception unused) {
                }
            }
        });
    }
}
