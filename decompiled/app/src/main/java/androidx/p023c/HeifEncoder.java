package androidx.p023c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Range;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import com.oplus.tblplayer.misc.IMediaFormat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: HeifEncoder.java */
/* renamed from: androidx.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public final class HeifEncoder implements SurfaceTexture.OnFrameAvailableListener, AutoCloseable {

    /* renamed from: OplusGLSurfaceView_11 */
    private static final MediaCodecList f2052n = new MediaCodecList(0);

    /* renamed from: A */
    private EglWindowSurface f2053A;

    /* renamed from: B */
    private EglRectBlt f2054B;

    /* renamed from: C */
    private int f2055C;

    /* renamed from: PlatformImplementations.kt_3 */
    MediaCodec f2058a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final PlatformImplementations.kt_3 f2059b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    final Handler f2060c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    final int f2061d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    final int f2062e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    final int f2063f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    final int f2064g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    final int f2065h;

    /* renamed from: OplusGLSurfaceView_13 */
    final int f2066i;

    /* renamed from: OplusGLSurfaceView_15 */
    final boolean f2067j;

    /* renamed from: OplusGLSurfaceView_5 */
    boolean f2068k;

    /* renamed from: OplusGLSurfaceView_6 */
    IntrinsicsJvm.kt_3 f2070m;

    /* renamed from: o */
    private final HandlerThread f2071o;

    /* renamed from: p */
    private final int f2072p;

    /* renamed from: q */
    private final int f2073q;

    /* renamed from: r */
    private int f2074r;

    /* renamed from: s */
    private final Rect f2075s;

    /* renamed from: t */
    private final Rect f2076t;

    /* renamed from: u */
    private ByteBuffer f2077u;

    /* renamed from: x */
    private SurfaceTexture f2080x;

    /* renamed from: y */
    private Surface f2081y;

    /* renamed from: z */
    private Surface f2082z;

    /* renamed from: v */
    private final ArrayList<ByteBuffer> f2078v = new ArrayList<>();

    /* renamed from: w */
    private final ArrayList<ByteBuffer> f2079w = new ArrayList<>();

    /* renamed from: OplusGLSurfaceView_14 */
    final ArrayList<Integer> f2069l = new ArrayList<>();

    /* renamed from: D */
    private final float[] f2056D = new float[16];

    /* renamed from: E */
    private final AtomicBoolean f2057E = new AtomicBoolean(false);

    /* compiled from: HeifEncoder.java */
    /* renamed from: androidx.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public static abstract class PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        public abstract void mo1798a(HeifEncoder c0360c);

        /* renamed from: PlatformImplementations.kt_3 */
        public abstract void mo1799a(HeifEncoder c0360c, MediaCodec.CodecException codecException);

        /* renamed from: PlatformImplementations.kt_3 */
        public abstract void mo1800a(HeifEncoder c0360c, MediaFormat mediaFormat);

        /* renamed from: PlatformImplementations.kt_3 */
        public abstract void mo1801a(HeifEncoder c0360c, ByteBuffer byteBuffer);
    }

    public HeifEncoder(int OplusGLSurfaceView_13, int i2, boolean z, int i3, int i4, Handler handler, PlatformImplementations.kt_3 aVar) throws Exception {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        boolean z2;
        int i5;
        int i6;
        MediaFormat mediaFormatCreateVideoFormat;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        if (OplusGLSurfaceView_13 < 0 || i2 < 0 || i3 < 0 || i3 > 100) {
            throw new IllegalArgumentException("invalid encoder inputs");
        }
        int i7 = 512;
        int i8 = 1;
        boolean z3 = z & (OplusGLSurfaceView_13 > 512 || i2 > 512);
        try {
            this.f2058a = MediaCodec.createEncoderByType("image/vnd.android.heic");
            capabilitiesForType = this.f2058a.getCodecInfo().getCapabilitiesForType("image/vnd.android.heic");
        } catch (Exception unused) {
            this.f2058a = MediaCodec.createByCodecName(m1789e());
            MediaCodecInfo.CodecCapabilities capabilitiesForType2 = this.f2058a.getCodecInfo().getCapabilitiesForType(MimeTypes.VIDEO_H265);
            z3 |= !capabilitiesForType2.getVideoCapabilities().isSizeSupported(OplusGLSurfaceView_13, i2);
            codecCapabilities = capabilitiesForType2;
            z2 = false;
        }
        if (!capabilitiesForType.getVideoCapabilities().isSizeSupported(OplusGLSurfaceView_13, i2)) {
            this.f2058a.release();
            this.f2058a = null;
            throw new Exception();
        }
        codecCapabilities = capabilitiesForType;
        z2 = true;
        this.f2072p = i4;
        this.f2059b = aVar;
        Looper looper = handler != null ? handler.getLooper() : null;
        if (looper == null) {
            this.f2071o = new HandlerThread("HeifEncoderThread", -2);
            this.f2071o.start();
            looper = this.f2071o.getLooper();
        } else {
            this.f2071o = null;
        }
        this.f2060c = new Handler(looper);
        boolean z4 = i4 == 1 || i4 == 2;
        int i9 = z4 ? 2130708361 : 2135033992;
        boolean z5 = (z3 && !z2) || i4 == 2;
        this.f2061d = OplusGLSurfaceView_13;
        this.f2062e = i2;
        this.f2067j = z3;
        if (z3) {
            i6 = ((i2 + 512) - 1) / 512;
            i8 = ((OplusGLSurfaceView_13 + 512) - 1) / 512;
            i5 = 512;
        } else {
            i7 = this.f2061d;
            i5 = this.f2062e;
            i6 = 1;
        }
        if (z2) {
            mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat("image/vnd.android.heic", this.f2061d, this.f2062e);
        } else {
            mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H265, i7, i5);
        }
        if (z3) {
            mediaFormatCreateVideoFormat.setInteger("tile-width", i7);
            mediaFormatCreateVideoFormat.setInteger("tile-height", i5);
            mediaFormatCreateVideoFormat.setInteger("grid-cols", i8);
            mediaFormatCreateVideoFormat.setInteger("grid-rows", i6);
        }
        if (z2) {
            this.f2063f = OplusGLSurfaceView_13;
            this.f2064g = i2;
            this.f2065h = 1;
            this.f2066i = 1;
        } else {
            this.f2063f = i7;
            this.f2064g = i5;
            this.f2065h = i6;
            this.f2066i = i8;
        }
        this.f2073q = this.f2065h * this.f2066i;
        mediaFormatCreateVideoFormat.setInteger("OplusGLSurfaceView_13-frame-interval", 0);
        mediaFormatCreateVideoFormat.setInteger("color-format", i9);
        mediaFormatCreateVideoFormat.setInteger(IMediaFormat.KEY_FRAME_RATE, this.f2073q);
        if (this.f2073q > 1) {
            mediaFormatCreateVideoFormat.setInteger("operating-rate", 120);
        } else {
            mediaFormatCreateVideoFormat.setInteger("operating-rate", 30);
        }
        if (z4 && !z5) {
            Log.IntrinsicsJvm.kt_5("HeifEncoder", "Setting fixed pts gap");
            mediaFormatCreateVideoFormat.setLong("max-pts-gap-to-encoder", -1000000L);
        }
        MediaCodecInfo.EncoderCapabilities encoderCapabilities = codecCapabilities.getEncoderCapabilities();
        if (encoderCapabilities.isBitrateModeSupported(0)) {
            Log.IntrinsicsJvm.kt_5("HeifEncoder", "Setting bitrate mode to constant quality");
            Range<Integer> qualityRange = encoderCapabilities.getQualityRange();
            Log.IntrinsicsJvm.kt_5("HeifEncoder", "Quality range: " + qualityRange);
            mediaFormatCreateVideoFormat.setInteger("bitrate-mode", 0);
            mediaFormatCreateVideoFormat.setInteger("quality", (int) (((double) ((Integer) qualityRange.getLower()).intValue()) + (((double) ((((Integer) qualityRange.getUpper()).intValue() - ((Integer) qualityRange.getLower()).intValue()) * i3)) / 100.0d)));
        } else {
            if (encoderCapabilities.isBitrateModeSupported(2)) {
                Log.IntrinsicsJvm.kt_5("HeifEncoder", "Setting bitrate mode to constant bitrate");
                mediaFormatCreateVideoFormat.setInteger("bitrate-mode", 2);
            } else {
                Log.IntrinsicsJvm.kt_5("HeifEncoder", "Setting bitrate mode to variable bitrate");
                mediaFormatCreateVideoFormat.setInteger("bitrate-mode", 1);
            }
            mediaFormatCreateVideoFormat.setInteger("bitrate", ((Integer) codecCapabilities.getVideoCapabilities().getBitrateRange().clamp(Integer.valueOf((int) ((((((OplusGLSurfaceView_13 * i2) * 1.5d) * 8.0d) * 0.25d) * i3) / 100.0d)))).intValue());
        }
        this.f2058a.setCallback(new IntrinsicsJvm.kt_4(), this.f2060c);
        this.f2058a.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        if (z4) {
            this.f2082z = this.f2058a.createInputSurface();
            this.f2070m = new IntrinsicsJvm.kt_3(z5);
            if (z5) {
                this.f2053A = new EglWindowSurface(this.f2082z);
                this.f2053A.m1780b();
                this.f2054B = new EglRectBlt(new Texture2dProgram(i4 == 2 ? 0 : 1), this.f2061d, this.f2062e);
                this.f2055C = this.f2054B.m1770a();
                if (i4 == 1) {
                    this.f2080x = new SurfaceTexture(this.f2055C, true);
                    this.f2080x.setOnFrameAvailableListener(this);
                    this.f2080x.setDefaultBufferSize(this.f2061d, this.f2062e);
                    this.f2081y = new Surface(this.f2080x);
                }
                this.f2053A.m1781c();
            } else {
                this.f2081y = this.f2082z;
            }
        } else {
            for (int i10 = 0; i10 < 2; i10++) {
                this.f2078v.add(ByteBuffer.allocateDirect(((this.f2061d * this.f2062e) * 3) / 2));
            }
        }
        this.f2076t = new Rect(0, 0, this.f2063f, this.f2064g);
        this.f2075s = new Rect();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String m1789e() {
        String name = null;
        String name2 = null;
        for (MediaCodecInfo mediaCodecInfo : f2052n.getCodecInfos()) {
            if (mediaCodecInfo.isEncoder()) {
                try {
                    MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(MimeTypes.VIDEO_H265);
                    if (capabilitiesForType.getVideoCapabilities().isSizeSupported(512, 512)) {
                        if (capabilitiesForType.getEncoderCapabilities().isBitrateModeSupported(0)) {
                            if (mediaCodecInfo.isHardwareAccelerated()) {
                                return mediaCodecInfo.getName();
                            }
                            if (name == null) {
                                name = mediaCodecInfo.getName();
                            }
                        }
                        if (name2 == null) {
                            name2 = mediaCodecInfo.getName();
                        }
                    } else {
                        continue;
                    }
                } catch (IllegalArgumentException unused) {
                    continue;
                }
            }
        }
        return name != null ? name : name2;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m1790f() {
        GLES20.glViewport(0, 0, this.f2063f, this.f2064g);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f2065h; OplusGLSurfaceView_13++) {
            for (int i2 = 0; i2 < this.f2066i; i2++) {
                int i3 = this.f2063f;
                int i4 = i2 * i3;
                int i5 = this.f2064g;
                int i6 = OplusGLSurfaceView_13 * i5;
                this.f2075s.set(i4, i6, i3 + i4, i5 + i6);
                try {
                    this.f2054B.m1772a(this.f2055C, Texture2dProgram.f2128b, this.f2075s);
                    EglWindowSurface c0359b = this.f2053A;
                    int i7 = this.f2074r;
                    this.f2074r = i7 + 1;
                    c0359b.m1779a(m1785a(i7) * 1000);
                    this.f2053A.m1782d();
                } catch (RuntimeException COUIBaseListPopupWindow_8) {
                    if (!this.f2057E.get()) {
                        throw COUIBaseListPopupWindow_8;
                    }
                    return;
                }
            }
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            if (this.f2053A == null) {
                return;
            }
            this.f2053A.m1780b();
            surfaceTexture.updateTexImage();
            surfaceTexture.getTransformMatrix(this.f2056D);
            if (this.f2070m.m1806a(surfaceTexture.getTimestamp(), m1785a((this.f2074r + this.f2073q) - 1))) {
                m1790f();
            }
            surfaceTexture.releaseTexImage();
            this.f2053A.m1781c();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1793a() {
        this.f2058a.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1794a(Bitmap bitmap) {
        if (this.f2072p != 2) {
            throw new IllegalStateException("addBitmap is only allowed in bitmap input mode");
        }
        if (this.f2070m.m1806a(m1785a(this.f2074r) * 1000, m1785a((this.f2074r + this.f2073q) - 1))) {
            synchronized (this) {
                if (this.f2053A == null) {
                    return;
                }
                this.f2053A.m1780b();
                this.f2054B.m1771a(this.f2055C, bitmap);
                m1790f();
                this.f2053A.m1781c();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m1795b() {
        int OplusGLSurfaceView_13 = this.f2072p;
        if (OplusGLSurfaceView_13 == 2) {
            this.f2070m.m1805a(0L);
        } else if (OplusGLSurfaceView_13 == 0) {
            m1788a((byte[]) null);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private long m1785a(int OplusGLSurfaceView_13) {
        return ((OplusGLSurfaceView_13 * 1000000) / this.f2073q) + 132;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1788a(byte[] bArr) {
        ByteBuffer byteBufferM1791g = m1791g();
        if (byteBufferM1791g == null) {
            return;
        }
        byteBufferM1791g.clear();
        if (bArr != null) {
            byteBufferM1791g.put(bArr);
        }
        byteBufferM1791g.flip();
        synchronized (this.f2079w) {
            this.f2079w.add(byteBufferM1791g);
        }
        this.f2060c.post(new Runnable() { // from class: androidx.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.1
            @Override // java.lang.Runnable
            public void run() throws MediaCodec.CryptoException {
                HeifEncoder.this.m1796c();
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m1796c() throws MediaCodec.CryptoException {
        while (true) {
            ByteBuffer byteBufferM1792h = m1792h();
            if (byteBufferM1792h == null || this.f2069l.isEmpty()) {
                return;
            }
            int iIntValue = this.f2069l.remove(0).intValue();
            boolean z = this.f2074r % this.f2073q == 0 && byteBufferM1792h.remaining() == 0;
            if (!z) {
                Image inputImage = this.f2058a.getInputImage(iIntValue);
                int OplusGLSurfaceView_13 = this.f2063f;
                int i2 = this.f2074r;
                int i3 = this.f2066i;
                int i4 = (i2 % i3) * OplusGLSurfaceView_13;
                int i5 = this.f2064g;
                int i6 = ((i2 / i3) % this.f2065h) * i5;
                this.f2075s.set(i4, i6, OplusGLSurfaceView_13 + i4, i5 + i6);
                m1786a(byteBufferM1792h, inputImage, this.f2061d, this.f2062e, this.f2075s, this.f2076t);
            }
            MediaCodec mediaCodec = this.f2058a;
            int iCapacity = z ? 0 : mediaCodec.getInputBuffer(iIntValue).capacity();
            int i7 = this.f2074r;
            this.f2074r = i7 + 1;
            mediaCodec.queueInputBuffer(iIntValue, 0, iCapacity, m1785a(i7), z ? 4 : 0);
            if (z || this.f2074r % this.f2073q == 0) {
                m1787a(z);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m1786a(ByteBuffer byteBuffer, Image image, int OplusGLSurfaceView_13, int i2, Rect rect, Rect rect2) {
        int i3;
        int i4;
        if (rect.width() != rect2.width() || rect.height() != rect2.height()) {
            throw new IllegalArgumentException("src and dst rect size are different!");
        }
        if (OplusGLSurfaceView_13 % 2 == 0 && i2 % 2 == 0) {
            int i5 = 2;
            if (rect.left % 2 == 0 && rect.top % 2 == 0 && rect.right % 2 == 0 && rect.bottom % 2 == 0 && rect2.left % 2 == 0 && rect2.top % 2 == 0 && rect2.right % 2 == 0 && rect2.bottom % 2 == 0) {
                Image.Plane[] planes = image.getPlanes();
                int i6 = 0;
                while (i6 < planes.length) {
                    ByteBuffer buffer = planes[i6].getBuffer();
                    int pixelStride = planes[i6].getPixelStride();
                    int iMin = Math.min(rect.width(), OplusGLSurfaceView_13 - rect.left);
                    int iMin2 = Math.min(rect.height(), i2 - rect.top);
                    if (i6 > 0) {
                        i4 = ((OplusGLSurfaceView_13 * i2) * (i6 + 3)) / 4;
                        i3 = i5;
                    } else {
                        i3 = 1;
                        i4 = 0;
                    }
                    for (int i7 = 0; i7 < iMin2 / i3; i7++) {
                        byteBuffer.position(((((rect.top / i3) + i7) * OplusGLSurfaceView_13) / i3) + i4 + (rect.left / i3));
                        buffer.position((((rect2.top / i3) + i7) * planes[i6].getRowStride()) + ((rect2.left * pixelStride) / i3));
                        int i8 = 0;
                        while (true) {
                            int i9 = iMin / i3;
                            if (i8 < i9) {
                                buffer.put(byteBuffer.get());
                                if (pixelStride > 1 && i8 != i9 - 1) {
                                    buffer.position((buffer.position() + pixelStride) - 1);
                                }
                                i8++;
                            }
                        }
                    }
                    i6++;
                    i5 = 2;
                }
                return;
            }
        }
        throw new IllegalArgumentException("src or dst are not aligned!");
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ByteBuffer m1791g() {
        ByteBuffer byteBufferRemove;
        synchronized (this.f2078v) {
            while (!this.f2068k && this.f2078v.isEmpty()) {
                try {
                    this.f2078v.wait();
                } catch (InterruptedException unused) {
                }
            }
            byteBufferRemove = this.f2068k ? null : this.f2078v.remove(0);
        }
        return byteBufferRemove;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ByteBuffer m1792h() {
        if (!this.f2068k && this.f2077u == null) {
            synchronized (this.f2079w) {
                this.f2077u = this.f2079w.isEmpty() ? null : this.f2079w.remove(0);
            }
        }
        if (this.f2068k) {
            return null;
        }
        return this.f2077u;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1787a(boolean z) {
        synchronized (this.f2078v) {
            this.f2068k = z | this.f2068k;
            this.f2078v.add(this.f2077u);
            this.f2078v.notifyAll();
        }
        this.f2077u = null;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    void m1797d() {
        this.f2057E.set(true);
        MediaCodec mediaCodec = this.f2058a;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f2058a.release();
            this.f2058a = null;
        }
        synchronized (this.f2078v) {
            this.f2068k = true;
            this.f2078v.notifyAll();
        }
        synchronized (this) {
            if (this.f2054B != null) {
                this.f2054B.m1774a(false);
                this.f2054B = null;
            }
            if (this.f2053A != null) {
                this.f2053A.m1778a();
                this.f2053A = null;
            }
            if (this.f2080x != null) {
                this.f2080x.release();
                this.f2080x = null;
            }
        }
    }

    /* compiled from: HeifEncoder.java */
    /* renamed from: androidx.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_3 */
    private class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final boolean f2087a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        long f2088b = -1;

        /* renamed from: IntrinsicsJvm.kt_3 */
        long f2089c = -1;

        /* renamed from: IntrinsicsJvm.kt_5 */
        long f2090d = -1;

        /* renamed from: COUIBaseListPopupWindow_8 */
        long f2091e = -1;

        /* renamed from: COUIBaseListPopupWindow_12 */
        long f2092f = -1;

        /* renamed from: COUIBaseListPopupWindow_11 */
        boolean f2093g;

        IntrinsicsJvm.kt_3(boolean z) {
            this.f2087a = z;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        synchronized void m1805a(long OplusGLSurfaceView_15) {
            if (this.f2087a) {
                if (this.f2088b < 0) {
                    this.f2088b = OplusGLSurfaceView_15;
                }
            } else if (this.f2090d < 0) {
                this.f2090d = OplusGLSurfaceView_15 / 1000;
            }
            m1803a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        synchronized boolean m1806a(long OplusGLSurfaceView_15, long j2) {
            boolean z;
            z = this.f2088b < 0 || OplusGLSurfaceView_15 <= this.f2088b;
            if (z) {
                this.f2091e = j2;
            }
            this.f2089c = OplusGLSurfaceView_15;
            m1803a();
            return z;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        synchronized void m1807b(long OplusGLSurfaceView_15) {
            this.f2092f = OplusGLSurfaceView_15;
            m1803a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m1803a() {
            if (this.f2093g) {
                return;
            }
            if (this.f2090d < 0) {
                long OplusGLSurfaceView_15 = this.f2088b;
                if (OplusGLSurfaceView_15 >= 0 && this.f2089c >= OplusGLSurfaceView_15) {
                    long j2 = this.f2091e;
                    if (j2 < 0) {
                        m1804b();
                        return;
                    }
                    this.f2090d = j2;
                }
            }
            long j3 = this.f2090d;
            if (j3 < 0 || j3 > this.f2092f) {
                return;
            }
            m1804b();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m1804b() {
            HeifEncoder.this.f2060c.post(new Runnable() { // from class: androidx.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (HeifEncoder.this.f2058a != null) {
                        HeifEncoder.this.f2058a.signalEndOfInputStream();
                    }
                }
            });
            this.f2093g = true;
        }
    }

    /* compiled from: HeifEncoder.java */
    /* renamed from: androidx.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    class IntrinsicsJvm.kt_4 extends MediaCodec.Callback {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f2086b;

        IntrinsicsJvm.kt_4() {
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            if (mediaCodec != HeifEncoder.this.f2058a) {
                return;
            }
            if (!"image/vnd.android.heic".equals(mediaFormat.getString(IMediaFormat.KEY_MIME))) {
                mediaFormat.setString(IMediaFormat.KEY_MIME, "image/vnd.android.heic");
                mediaFormat.setInteger("width", HeifEncoder.this.f2061d);
                mediaFormat.setInteger("height", HeifEncoder.this.f2062e);
                if (HeifEncoder.this.f2067j) {
                    mediaFormat.setInteger("tile-width", HeifEncoder.this.f2063f);
                    mediaFormat.setInteger("tile-height", HeifEncoder.this.f2064g);
                    mediaFormat.setInteger("grid-rows", HeifEncoder.this.f2065h);
                    mediaFormat.setInteger("grid-cols", HeifEncoder.this.f2066i);
                }
            }
            HeifEncoder.this.f2059b.mo1800a(HeifEncoder.this, mediaFormat);
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(MediaCodec mediaCodec, int OplusGLSurfaceView_13) throws MediaCodec.CryptoException {
            if (mediaCodec != HeifEncoder.this.f2058a || HeifEncoder.this.f2068k) {
                return;
            }
            HeifEncoder.this.f2069l.add(Integer.valueOf(OplusGLSurfaceView_13));
            HeifEncoder.this.m1796c();
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(MediaCodec mediaCodec, int OplusGLSurfaceView_13, MediaCodec.BufferInfo bufferInfo) {
            if (mediaCodec != HeifEncoder.this.f2058a || this.f2086b) {
                return;
            }
            if (bufferInfo.size > 0 && (bufferInfo.flags & 2) == 0) {
                ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(OplusGLSurfaceView_13);
                outputBuffer.position(bufferInfo.offset);
                outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                if (HeifEncoder.this.f2070m != null) {
                    HeifEncoder.this.f2070m.m1807b(bufferInfo.presentationTimeUs);
                }
                HeifEncoder.this.f2059b.mo1801a(HeifEncoder.this, outputBuffer);
            }
            this.f2086b = ((bufferInfo.flags & 4) != 0) | this.f2086b;
            mediaCodec.releaseOutputBuffer(OplusGLSurfaceView_13, false);
            if (this.f2086b) {
                m1802a(null);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            if (mediaCodec != HeifEncoder.this.f2058a) {
                return;
            }
            Log.COUIBaseListPopupWindow_8("HeifEncoder", "onError: " + codecException);
            m1802a(codecException);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m1802a(MediaCodec.CodecException codecException) {
            HeifEncoder.this.m1797d();
            if (codecException == null) {
                HeifEncoder.this.f2059b.mo1798a(HeifEncoder.this);
            } else {
                HeifEncoder.this.f2059b.mo1799a(HeifEncoder.this, codecException);
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.f2078v) {
            this.f2068k = true;
            this.f2078v.notifyAll();
        }
        this.f2060c.postAtFrontOfQueue(new Runnable() { // from class: androidx.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.2
            @Override // java.lang.Runnable
            public void run() {
                HeifEncoder.this.m1797d();
            }
        });
    }
}
