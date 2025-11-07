package com.oplus.p110a;

import android.content.Context;
import android.graphics.Rect;
import com.oplus.camera.CameraLog;
import com.oplus.ocs.camera.OplusBlurPreviewHelper;
import com.sensetime.faceapi.model.FaceOrientation;
import com.sensetime.faceapi.utils.AccelerometerManager;
import com.sensetime.utils.OpenGLUtils;
import com.sensetime.utils.ShakeDetectorUtils;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: OplusBlurProcess.java */
/* renamed from: com.oplus.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class OplusBlurProcess implements ShakeDetectorUtils.OnShakeListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean f9748a = false;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int[] f9749b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int f9750c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static int f9751d = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private static int f9752i = 192;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private OplusBlurPreviewHelper f9754f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Context f9755g;

    /* renamed from: OplusGLSurfaceView_5 */
    private long f9758k;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Object f9753e = new Object();

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f9756h = 0;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f9757j = false;

    /* renamed from: OplusGLSurfaceView_14 */
    private byte[] f9759l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private ByteBuffer f9760m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private IntrinsicsJvm.kt_4 f9761n = null;

    /* renamed from: o */
    private boolean f9762o = false;

    /* renamed from: p */
    private int f9763p = 0;

    /* renamed from: q */
    private int[] f9764q = {-1, -1, -1, -1, -1};

    /* renamed from: r */
    private int f9765r = -1;

    /* renamed from: s */
    private int f9766s = -1;

    /* renamed from: t */
    private int f9767t = -1;

    /* renamed from: u */
    private boolean f9768u = false;

    public OplusBlurProcess() {
        this.f9754f = null;
        this.f9754f = OplusBlurPreviewHelper.getInstance();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8750a(boolean z) {
        this.f9768u = z;
        IntrinsicsJvm.kt_4 bVar = this.f9761n;
        if (bVar != null) {
            bVar.m8762b();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized boolean m8735a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12967f("OplusBlurProcess", "initialize, previewWidth: " + OplusGLSurfaceView_13 + ", previewHeight: " + i2 + ", sInit: " + f9748a);
        if (!f9748a || f9750c != OplusGLSurfaceView_13 || f9751d != i2) {
            f9750c = OplusGLSurfaceView_13;
            f9751d = i2;
            f9748a = true;
            long jCurrentTimeMillis = System.currentTimeMillis();
            CameraLog.m12967f("OplusBlurProcess", "initialize, start");
            CameraLog.m12952a("OplusBlurProcess");
            f9749b = OplusBlurPreviewHelper.getInstance().segInit("/odm/lib64", "/odm/lib/rfsa/adsp", "/odm/etc/camera/sensetime/personseg.bin", "/odm/etc/camera/sensetime/preview_seg.json", OplusGLSurfaceView_13, i2);
            CameraLog.m12958b("OplusBlurProcess");
            CameraLog.m12967f("OplusBlurProcess", "initialize, cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            f9752i = f9749b[1];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("initialize, init Result: ");
        sb.append(f9749b[0] == 0);
        CameraLog.m12967f("OplusBlurProcess", sb.toString());
        return f9749b[0] == 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8749a(Context context) {
        CameraLog.m12967f("OplusBlurProcess", "init, segVersion: " + this.f9754f.segGetVersion() + ", mMaskSize: " + f9752i);
        ShakeDetectorUtils.getInstance(context).registerOnShakeListener(this).start();
        AccelerometerManager.start(context);
        this.f9755g = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8748a() {
        ShakeDetectorUtils.getInstance(this.f9755g).unregisterOnShakeListener(this).stop();
        AccelerometerManager.stop();
        IntrinsicsJvm.kt_4 bVar = this.f9761n;
        if (bVar != null) {
            bVar.m8763c();
            try {
                this.f9761n.join();
            } catch (InterruptedException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            this.f9761n = null;
        }
        this.f9754f.segUnInit();
        synchronized (OplusBlurProcess.class) {
            f9748a = false;
        }
        this.f9755g = null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m8754b(int OplusGLSurfaceView_13, int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        CameraLog.m12954a("OplusBlurProcess", "initRender, previewWidth: " + OplusGLSurfaceView_13 + ", previewHeight: " + i2 + ", previewHandle: " + this.f9754f.bokehPreviewInit(OplusGLSurfaceView_13, i2) + ", previewVersion: " + this.f9754f.bokehPreviewGetVersion() + ", cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m8753b() {
        m8743g();
        OpenGLUtils.destroyTexture(this.f9767t);
        this.f9767t = -1;
        this.f9754f.bokehPreviewDestory();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m8744a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        return this.f9754f.bokehPreviewSetParam(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m8755c() {
        IntrinsicsJvm.kt_4 bVar = this.f9761n;
        if (bVar != null) {
            bVar.m8764d();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m8745a(int OplusGLSurfaceView_13, int i2, int i3, int[] iArr) {
        return this.f9754f.bokehPreviewProcess(OplusGLSurfaceView_13, m8756d(), i2, i3, iArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m8746a(int OplusGLSurfaceView_13, int i2, int i3, Rect[] rectArr, int i4, int i5, int[] iArr, boolean z) throws InterruptedException {
        if (this.f9762o) {
            int iBokehPreviewProcess = this.f9754f.bokehPreviewProcess(OplusGLSurfaceView_13, -2, i4, i5, iArr);
            m8743g();
            return iBokehPreviewProcess;
        }
        if (this.f9761n == null) {
            this.f9761n = new IntrinsicsJvm.kt_4();
            this.f9761n.start();
        }
        if (!this.f9761n.f9779d) {
            return this.f9754f.bokehPreviewProcess(OplusGLSurfaceView_13, -2, i4, i5, iArr);
        }
        int[] iArr2 = {this.f9764q[this.f9763p]};
        if (iArr2[0] <= 0) {
            iArr2[0] = OpenGLUtils.loadTexture(null, i2, i3, -1);
        }
        this.f9754f.bokehPreviewTextureCopy(OplusGLSurfaceView_13, iArr2, false);
        int[] iArr3 = this.f9764q;
        int i6 = this.f9763p;
        iArr3[i6] = iArr2[0];
        int i7 = i6 + 1;
        this.f9763p = i7;
        this.f9763p = i7 % iArr3.length;
        int i8 = f9752i;
        if (this.f9767t <= 0) {
            this.f9767t = OpenGLUtils.loadTexture(null, i8, i8, -1);
        }
        this.f9754f.bokehPreviewTextureResize(iArr2[0], this.f9767t, i8, i8, false);
        byte[] bArr = new byte[i8 * i8 * 4];
        OpenGLUtils.readPix(this.f9767t, i8, i8, bArr);
        if (!this.f9761n.f9779d) {
            return 0;
        }
        IntrinsicsJvm.kt_3 cVarM8760a = this.f9761n.m8760a();
        try {
            this.f9761n.f9780e.put(new PlatformImplementations.kt_3(iArr2[0], bArr, i8, i8, rectArr, z));
        } catch (InterruptedException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        if (!this.f9761n.f9779d) {
            return 0;
        }
        if (cVarM8760a == null) {
            int i9 = this.f9765r;
            if (i9 <= 0) {
                return this.f9754f.bokehPreviewProcess(OplusGLSurfaceView_13, -2, i4, i5, iArr);
            }
            return this.f9754f.bokehPreviewProcess(i9, this.f9766s, i4, i5, iArr);
        }
        int iM8747a = m8747a(cVarM8760a.f9789b);
        this.f9765r = cVarM8760a.f9788a;
        this.f9766s = iM8747a;
        return this.f9754f.bokehPreviewProcess(cVarM8760a.f9788a, iM8747a, i4, i5, iArr);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m8756d() {
        byte[] bArr;
        if (this.f9756h <= 0) {
            return -1;
        }
        synchronized (this.f9753e) {
            bArr = this.f9759l;
        }
        if (this.f9757j && bArr != null) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bArr.length; OplusGLSurfaceView_13++) {
                bArr[OplusGLSurfaceView_13] = -1;
            }
            if (300 < System.currentTimeMillis() - this.f9758k) {
                this.f9757j = false;
            }
        }
        if (bArr == null) {
            return -1;
        }
        int[] iArr = new int[1];
        this.f9754f.bokehPreviewGetMaskTexture(bArr, iArr, true);
        return iArr[0];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m8747a(byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        int[] iArr = new int[1];
        this.f9754f.bokehPreviewGetMaskTexture(bArr, iArr, true);
        return iArr[0];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8752a(byte[] bArr, int OplusGLSurfaceView_13, int i2, byte[] bArr2, boolean z, Rect[] rectArr, int i3, int i4) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        FaceOrientation faceOrientation = AccelerometerManager.getFaceOrientation(z);
        if (rectArr == null || rectArr.length == 0) {
            iArr = new int[0];
            iArr2 = new int[0];
            iArr3 = new int[0];
            iArr4 = new int[0];
            iArr5 = new int[0];
        } else {
            int length = rectArr.length;
            iArr = new int[length];
            iArr2 = new int[length];
            iArr3 = new int[length];
            iArr4 = new int[length];
            iArr5 = new int[length];
            for (int i5 = 0; i5 < length; i5++) {
                iArr[i5] = -1;
                Rect rect = rectArr[i5];
                if (rect != null) {
                    iArr2[i5] = rect.left;
                    iArr3[i5] = rect.top;
                    iArr4[i5] = rect.width();
                    iArr5[i5] = rect.height();
                } else {
                    iArr2[i5] = 0;
                    iArr3[i5] = 0;
                    iArr4[i5] = 0;
                    iArr5[i5] = 0;
                }
            }
        }
        this.f9754f.segExecute(bArr, bArr2, i3, OplusGLSurfaceView_13, i2, faceOrientation.getValue(), i4, iArr, iArr2, iArr3, iArr4, iArr5);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8751a(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, boolean z, Rect[] rectArr) {
        this.f9756h = i3;
        if (this.f9761n == null) {
            this.f9761n = new IntrinsicsJvm.kt_4();
            this.f9761n.start();
        }
        this.f9761n.m8761a(bArr, OplusGLSurfaceView_13, i2, z, rectArr);
    }

    @Override // com.sensetime.utils.ShakeDetectorUtils.OnShakeListener
    public void onShake(boolean z) {
        if (z) {
            m8757e();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m8757e() {
        this.f9757j = true;
        this.f9758k = System.currentTimeMillis();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m8743g() {
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            int[] iArr = this.f9764q;
            if (OplusGLSurfaceView_13 < iArr.length) {
                OpenGLUtils.destroyTexture(iArr[OplusGLSurfaceView_13]);
                this.f9764q[OplusGLSurfaceView_13] = -1;
                OplusGLSurfaceView_13++;
            } else {
                this.f9765r = -1;
                this.f9766s = -1;
                this.f9762o = false;
                return;
            }
        }
    }

    /* compiled from: OplusBlurProcess.java */
    /* renamed from: com.oplus.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends Thread {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int f9777b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final long f9778c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private volatile boolean f9779d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private BlockingQueue<PlatformImplementations.kt_3> f9780e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private BlockingQueue<IntrinsicsJvm.kt_3> f9781f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private Object f9782g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private boolean f9783h;

        /* renamed from: OplusGLSurfaceView_13 */
        private byte[] f9784i;

        /* renamed from: OplusGLSurfaceView_15 */
        private Rect[] f9785j;

        /* renamed from: OplusGLSurfaceView_5 */
        private int f9786k;

        /* renamed from: OplusGLSurfaceView_14 */
        private int f9787l;

        private IntrinsicsJvm.kt_4() {
            this.f9777b = 2;
            this.f9778c = 100L;
            this.f9779d = true;
            this.f9780e = new LinkedBlockingQueue(2);
            this.f9781f = new LinkedBlockingQueue(4);
            this.f9782g = new Object();
            this.f9783h = false;
            this.f9784i = null;
            this.f9785j = null;
            this.f9786k = 0;
            this.f9787l = 0;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException {
            super.run();
            while (this.f9779d && !isInterrupted()) {
                try {
                    if (OplusBlurProcess.this.f9768u) {
                        PlatformImplementations.kt_3 aVarPoll = this.f9780e.poll(100L, TimeUnit.MILLISECONDS);
                        if (aVarPoll != null) {
                            if (this.f9779d && !isInterrupted()) {
                                byte[] bArr = null;
                                if (aVarPoll.f9773e != null && aVarPoll.f9773e.length > 0) {
                                    bArr = new byte[OplusBlurProcess.f9752i * OplusBlurProcess.f9752i];
                                    OplusBlurProcess.this.m8752a(aVarPoll.f9770b, aVarPoll.f9771c, aVarPoll.f9772d, bArr, aVarPoll.f9774f, (Rect[]) null, 1, 1);
                                }
                                synchronized (this.f9782g) {
                                    this.f9781f.offer(OplusBlurProcess.this.new IntrinsicsJvm.kt_3(aVarPoll.f9769a, bArr));
                                }
                            }
                            return;
                        }
                    } else {
                        synchronized (this) {
                            if (!this.f9779d || isInterrupted()) {
                                return;
                            } else {
                                wait();
                            }
                        }
                        if (OplusBlurProcess.this.f9756h > 0) {
                            if (OplusBlurProcess.this.f9760m == null) {
                                OplusBlurProcess.this.f9760m = ByteBuffer.allocate(OplusBlurProcess.f9752i * OplusBlurProcess.f9752i);
                            }
                            OplusBlurProcess.this.f9760m.rewind();
                            OplusBlurProcess.this.m8752a(this.f9784i, this.f9786k, this.f9787l, OplusBlurProcess.this.f9760m.array(), this.f9783h, this.f9785j, 0, 0);
                            synchronized (OplusBlurProcess.this.f9753e) {
                                OplusBlurProcess.this.f9759l = OplusBlurProcess.this.f9760m.array();
                            }
                        }
                    }
                } catch (InterruptedException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                    return;
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_3 m8760a() {
            synchronized (this.f9782g) {
                if (this.f9781f.isEmpty()) {
                    return null;
                }
                while (this.f9781f.size() > 1) {
                    this.f9781f.poll();
                }
                return this.f9781f.poll();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m8761a(byte[] bArr, int OplusGLSurfaceView_13, int i2, boolean z, Rect[] rectArr) {
            this.f9786k = OplusGLSurfaceView_13;
            this.f9787l = i2;
            this.f9783h = z;
            byte[] bArr2 = this.f9784i;
            if (bArr2 == null || bArr.length != bArr2.length) {
                this.f9784i = new byte[bArr.length];
            }
            if (rectArr == null) {
                this.f9785j = new Rect[0];
            } else {
                Rect[] rectArr2 = this.f9785j;
                if (rectArr2 == null || rectArr.length != rectArr2.length) {
                    this.f9785j = new Rect[rectArr.length];
                }
            }
            synchronized (this) {
                System.arraycopy(bArr, 0, this.f9784i, 0, bArr.length);
                if (rectArr != null) {
                    System.arraycopy(rectArr, 0, this.f9785j, 0, rectArr.length);
                }
                notify();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m8762b() {
            synchronized (this) {
                notify();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m8763c() {
            this.f9779d = false;
            interrupt();
            m8764d();
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public void m8764d() {
            this.f9780e.clear();
            this.f9781f.clear();
            OplusBlurProcess.this.f9762o = true;
        }
    }

    /* compiled from: OplusBlurProcess.java */
    /* renamed from: com.oplus.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    private class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        int f9788a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        byte[] f9789b;

        public IntrinsicsJvm.kt_3(int OplusGLSurfaceView_13, byte[] bArr) {
            this.f9788a = 0;
            this.f9789b = null;
            this.f9788a = OplusGLSurfaceView_13;
            this.f9789b = bArr;
        }
    }

    /* compiled from: OplusBlurProcess.java */
    /* renamed from: com.oplus.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        int f9769a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        byte[] f9770b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f9771c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f9772d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        Rect[] f9773e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        boolean f9774f;

        public PlatformImplementations.kt_3(int OplusGLSurfaceView_13, byte[] bArr, int i2, int i3, Rect[] rectArr, boolean z) {
            this.f9769a = 0;
            this.f9770b = null;
            this.f9771c = 0;
            this.f9772d = 0;
            this.f9773e = null;
            this.f9774f = false;
            this.f9769a = OplusGLSurfaceView_13;
            this.f9770b = bArr;
            this.f9771c = i2;
            this.f9772d = i3;
            this.f9773e = rectArr;
            this.f9774f = z;
        }
    }
}
