package com.oplus.a_renamed;

/* compiled from: OplusBlurProcess.java */
/* loaded from: classes2.dex */
public class a_renamed implements com.sensetime.utils.ShakeDetectorUtils.OnShakeListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static boolean f3434a = false;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static int[] f3435b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static int f3436c = 0;
    private static int d_renamed = 0;
    private static int i_renamed = 192;
    private com.oplus.ocs.camera.OplusBlurPreviewHelper f_renamed;
    private android.content.Context g_renamed;
    private long k_renamed;
    private final java.lang.Object e_renamed = new java.lang.Object();
    private int h_renamed = 0;
    private boolean j_renamed = false;
    private byte[] l_renamed = null;
    private java.nio.ByteBuffer m_renamed = null;
    private com.oplus.a_renamed.a_renamed.b_renamed n_renamed = null;
    private boolean o_renamed = false;
    private int p_renamed = 0;
    private int[] q_renamed = {-1, -1, -1, -1, -1};
    private int r_renamed = -1;
    private int s_renamed = -1;
    private int t_renamed = -1;
    private boolean u_renamed = false;

    public a_renamed() {
        this.f_renamed = null;
        this.f_renamed = com.oplus.ocs.camera.OplusBlurPreviewHelper.getInstance();
    }

    public void a_renamed(boolean z_renamed) {
        this.u_renamed = z_renamed;
        com.oplus.a_renamed.a_renamed.b_renamed bVar = this.n_renamed;
        if (bVar != null) {
            bVar.b_renamed();
        }
    }

    public static synchronized boolean a_renamed(int i2, int i3) {
        com.oplus.camera.e_renamed.f_renamed("OplusBlurProcess", "initialize, previewWidth: " + i2 + ", previewHeight: " + i3 + ", sInit: " + f3434a);
        if (!f3434a || f3436c != i2 || d_renamed != i3) {
            f3436c = i2;
            d_renamed = i3;
            f3434a = true;
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            com.oplus.camera.e_renamed.f_renamed("OplusBlurProcess", "initialize, start");
            com.oplus.camera.e_renamed.a_renamed("OplusBlurProcess");
            f3435b = com.oplus.ocs.camera.OplusBlurPreviewHelper.getInstance().segInit("/odm/lib64", "/odm/lib/rfsa/adsp", "/odm/etc/camera/sensetime/personseg.bin", "/odm/etc/camera/sensetime/preview_seg.json", i2, i3);
            com.oplus.camera.e_renamed.b_renamed("OplusBlurProcess");
            com.oplus.camera.e_renamed.f_renamed("OplusBlurProcess", "initialize, cost: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
            i_renamed = f3435b[1];
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("initialize, init Result: ");
        sb.append(f3435b[0] == 0);
        com.oplus.camera.e_renamed.f_renamed("OplusBlurProcess", sb.toString());
        return f3435b[0] == 0;
    }

    public void a_renamed(android.content.Context context) {
        com.oplus.camera.e_renamed.f_renamed("OplusBlurProcess", "init, segVersion: " + this.f_renamed.segGetVersion() + ", mMaskSize: " + i_renamed);
        com.sensetime.utils.ShakeDetectorUtils.getInstance(context).registerOnShakeListener(this).start();
        com.sensetime.faceapi.utils.AccelerometerManager.start(context);
        this.g_renamed = context;
    }

    public void a_renamed() {
        com.sensetime.utils.ShakeDetectorUtils.getInstance(this.g_renamed).unregisterOnShakeListener(this).stop();
        com.sensetime.faceapi.utils.AccelerometerManager.stop();
        com.oplus.a_renamed.a_renamed.b_renamed bVar = this.n_renamed;
        if (bVar != null) {
            bVar.c_renamed();
            try {
                this.n_renamed.join();
            } catch (java.lang.InterruptedException e_renamed) {
                e_renamed.printStackTrace();
            }
            this.n_renamed = null;
        }
        this.f_renamed.segUnInit();
        synchronized (com.oplus.a_renamed.a_renamed.class) {
            f3434a = false;
        }
        this.g_renamed = null;
    }

    public void b_renamed(int i2, int i3) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.oplus.camera.e_renamed.a_renamed("OplusBlurProcess", "initRender, previewWidth: " + i2 + ", previewHeight: " + i3 + ", previewHandle: " + this.f_renamed.bokehPreviewInit(i2, i3) + ", previewVersion: " + this.f_renamed.bokehPreviewGetVersion() + ", cost: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public void b_renamed() {
        g_renamed();
        com.sensetime.utils.OpenGLUtils.destroyTexture(this.t_renamed);
        this.t_renamed = -1;
        this.f_renamed.bokehPreviewDestory();
    }

    public int a_renamed(int i2, float f_renamed) {
        return this.f_renamed.bokehPreviewSetParam(i2, f_renamed);
    }

    public void c_renamed() {
        com.oplus.a_renamed.a_renamed.b_renamed bVar = this.n_renamed;
        if (bVar != null) {
            bVar.d_renamed();
        }
    }

    public int a_renamed(int i2, int i3, int i4, int[] iArr) {
        return this.f_renamed.bokehPreviewProcess(i2, d_renamed(), i3, i4, iArr);
    }

    public int a_renamed(int i2, int i3, int i4, android.graphics.Rect[] rectArr, int i5, int i6, int[] iArr, boolean z_renamed) throws java.lang.InterruptedException {
        if (this.o_renamed) {
            int iBokehPreviewProcess = this.f_renamed.bokehPreviewProcess(i2, -2, i5, i6, iArr);
            g_renamed();
            return iBokehPreviewProcess;
        }
        if (this.n_renamed == null) {
            this.n_renamed = new com.oplus.a_renamed.a_renamed.b_renamed();
            this.n_renamed.start();
        }
        if (!this.n_renamed.d_renamed) {
            return this.f_renamed.bokehPreviewProcess(i2, -2, i5, i6, iArr);
        }
        int[] iArr2 = {this.q_renamed[this.p_renamed]};
        if (iArr2[0] <= 0) {
            iArr2[0] = com.sensetime.utils.OpenGLUtils.loadTexture(null, i3, i4, -1);
        }
        this.f_renamed.bokehPreviewTextureCopy(i2, iArr2, false);
        int[] iArr3 = this.q_renamed;
        int i7 = this.p_renamed;
        iArr3[i7] = iArr2[0];
        int i8 = i7 + 1;
        this.p_renamed = i8;
        this.p_renamed = i8 % iArr3.length;
        int i9 = i_renamed;
        if (this.t_renamed <= 0) {
            this.t_renamed = com.sensetime.utils.OpenGLUtils.loadTexture(null, i9, i9, -1);
        }
        this.f_renamed.bokehPreviewTextureResize(iArr2[0], this.t_renamed, i9, i9, false);
        byte[] bArr = new byte[i9 * i9 * 4];
        com.sensetime.utils.OpenGLUtils.readPix(this.t_renamed, i9, i9, bArr);
        if (!this.n_renamed.d_renamed) {
            return 0;
        }
        com.oplus.a_renamed.a_renamed.c_renamed cVarA = this.n_renamed.a_renamed();
        try {
            this.n_renamed.e_renamed.put(new com.oplus.a_renamed.a_renamed.OplusBlurProcess_4(iArr2[0], bArr, i9, i9, rectArr, z_renamed));
        } catch (java.lang.InterruptedException e_renamed) {
            e_renamed.printStackTrace();
        }
        if (!this.n_renamed.d_renamed) {
            return 0;
        }
        if (cVarA == null) {
            int i10 = this.r_renamed;
            if (i10 <= 0) {
                return this.f_renamed.bokehPreviewProcess(i2, -2, i5, i6, iArr);
            }
            return this.f_renamed.bokehPreviewProcess(i10, this.s_renamed, i5, i6, iArr);
        }
        int iA = a_renamed(cVarA.f3444b);
        this.r_renamed = cVarA.f3443a;
        this.s_renamed = iA;
        return this.f_renamed.bokehPreviewProcess(cVarA.f3443a, iA, i5, i6, iArr);
    }

    public int d_renamed() {
        byte[] bArr;
        if (this.h_renamed <= 0) {
            return -1;
        }
        synchronized (this.e_renamed) {
            bArr = this.l_renamed;
        }
        if (this.j_renamed && bArr != null) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = -1;
            }
            if (300 < java.lang.System.currentTimeMillis() - this.k_renamed) {
                this.j_renamed = false;
            }
        }
        if (bArr == null) {
            return -1;
        }
        int[] iArr = new int[1];
        this.f_renamed.bokehPreviewGetMaskTexture(bArr, iArr, true);
        return iArr[0];
    }

    public int a_renamed(byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        int[] iArr = new int[1];
        this.f_renamed.bokehPreviewGetMaskTexture(bArr, iArr, true);
        return iArr[0];
    }

    public void a_renamed(byte[] bArr, int i2, int i3, byte[] bArr2, boolean z_renamed, android.graphics.Rect[] rectArr, int i4, int i5) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        com.sensetime.faceapi.model.FaceOrientation faceOrientation = com.sensetime.faceapi.utils.AccelerometerManager.getFaceOrientation(z_renamed);
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
            for (int i6 = 0; i6 < length; i6++) {
                iArr[i6] = -1;
                android.graphics.Rect rect = rectArr[i6];
                if (rect != null) {
                    iArr2[i6] = rect.left;
                    iArr3[i6] = rect.top;
                    iArr4[i6] = rect.width();
                    iArr5[i6] = rect.height();
                } else {
                    iArr2[i6] = 0;
                    iArr3[i6] = 0;
                    iArr4[i6] = 0;
                    iArr5[i6] = 0;
                }
            }
        }
        this.f_renamed.segExecute(bArr, bArr2, i4, i2, i3, faceOrientation.getValue(), i5, iArr, iArr2, iArr3, iArr4, iArr5);
    }

    public void a_renamed(byte[] bArr, int i2, int i3, int i4, boolean z_renamed, android.graphics.Rect[] rectArr) {
        this.h_renamed = i4;
        if (this.n_renamed == null) {
            this.n_renamed = new com.oplus.a_renamed.a_renamed.b_renamed();
            this.n_renamed.start();
        }
        this.n_renamed.a_renamed(bArr, i2, i3, z_renamed, rectArr);
    }

    @Override // com.sensetime.utils.ShakeDetectorUtils.OnShakeListener
    public void onShake(boolean z_renamed) {
        if (z_renamed) {
            e_renamed();
        }
    }

    public void e_renamed() {
        this.j_renamed = true;
        this.k_renamed = java.lang.System.currentTimeMillis();
    }

    private void g_renamed() {
        int i2 = 0;
        while (true) {
            int[] iArr = this.q_renamed;
            if (i2 < iArr.length) {
                com.sensetime.utils.OpenGLUtils.destroyTexture(iArr[i2]);
                this.q_renamed[i2] = -1;
                i2++;
            } else {
                this.r_renamed = -1;
                this.s_renamed = -1;
                this.o_renamed = false;
                return;
            }
        }
    }

    /* compiled from: OplusBlurProcess.java */
    private class b_renamed extends java.lang.Thread {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final int f3441b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final long f3442c;
        private volatile boolean d_renamed;
        private java.util.concurrent.BlockingQueue<com.oplus.a_renamed.a_renamed.OplusBlurProcess_4> e_renamed;
        private java.util.concurrent.BlockingQueue<com.oplus.a_renamed.a_renamed.c_renamed> f_renamed;
        private java.lang.Object g_renamed;
        private boolean h_renamed;
        private byte[] i_renamed;
        private android.graphics.Rect[] j_renamed;
        private int k_renamed;
        private int l_renamed;

        private b_renamed() {
            this.f3441b = 2;
            this.f3442c = 100L;
            this.d_renamed = true;
            this.e_renamed = new java.util.concurrent.LinkedBlockingQueue(2);
            this.f_renamed = new java.util.concurrent.LinkedBlockingQueue(4);
            this.g_renamed = new java.lang.Object();
            this.h_renamed = false;
            this.i_renamed = null;
            this.j_renamed = null;
            this.k_renamed = 0;
            this.l_renamed = 0;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws java.lang.InterruptedException {
            super.run();
            while (this.d_renamed && !isInterrupted()) {
                try {
                    if (com.oplus.a_renamed.a_renamed.this.u_renamed) {
                        com.oplus.a_renamed.a_renamed.OplusBlurProcess_4 c0075aPoll = this.e_renamed.poll(100L, java.util.concurrent.TimeUnit.MILLISECONDS);
                        if (c0075aPoll != null) {
                            if (this.d_renamed && !isInterrupted()) {
                                byte[] bArr = null;
                                if (c0075aPoll.e_renamed != null && c0075aPoll.e_renamed.length > 0) {
                                    bArr = new byte[com.oplus.a_renamed.a_renamed.i_renamed * com.oplus.a_renamed.a_renamed.i_renamed];
                                    com.oplus.a_renamed.a_renamed.this.a_renamed(c0075aPoll.f3438b, c0075aPoll.f3439c, c0075aPoll.d_renamed, bArr, c0075aPoll.f_renamed, (android.graphics.Rect[]) null, 1, 1);
                                }
                                synchronized (this.g_renamed) {
                                    this.f_renamed.offer(com.oplus.a_renamed.a_renamed.this.new c_renamed(c0075aPoll.f3437a, bArr));
                                }
                            }
                            return;
                        }
                    } else {
                        synchronized (this) {
                            if (!this.d_renamed || isInterrupted()) {
                                return;
                            } else {
                                wait();
                            }
                        }
                        if (com.oplus.a_renamed.a_renamed.this.h_renamed > 0) {
                            if (com.oplus.a_renamed.a_renamed.this.m_renamed == null) {
                                com.oplus.a_renamed.a_renamed.this.m_renamed = java.nio.ByteBuffer.allocate(com.oplus.a_renamed.a_renamed.i_renamed * com.oplus.a_renamed.a_renamed.i_renamed);
                            }
                            com.oplus.a_renamed.a_renamed.this.m_renamed.rewind();
                            com.oplus.a_renamed.a_renamed.this.a_renamed(this.i_renamed, this.k_renamed, this.l_renamed, com.oplus.a_renamed.a_renamed.this.m_renamed.array(), this.h_renamed, this.j_renamed, 0, 0);
                            synchronized (com.oplus.a_renamed.a_renamed.this.e_renamed) {
                                com.oplus.a_renamed.a_renamed.this.l_renamed = com.oplus.a_renamed.a_renamed.this.m_renamed.array();
                            }
                        }
                    }
                } catch (java.lang.InterruptedException e_renamed) {
                    e_renamed.printStackTrace();
                    return;
                }
            }
        }

        public com.oplus.a_renamed.a_renamed.c_renamed a_renamed() {
            synchronized (this.g_renamed) {
                if (this.f_renamed.isEmpty()) {
                    return null;
                }
                while (this.f_renamed.size() > 1) {
                    this.f_renamed.poll();
                }
                return this.f_renamed.poll();
            }
        }

        public void a_renamed(byte[] bArr, int i_renamed, int i2, boolean z_renamed, android.graphics.Rect[] rectArr) {
            this.k_renamed = i_renamed;
            this.l_renamed = i2;
            this.h_renamed = z_renamed;
            byte[] bArr2 = this.i_renamed;
            if (bArr2 == null || bArr.length != bArr2.length) {
                this.i_renamed = new byte[bArr.length];
            }
            if (rectArr == null) {
                this.j_renamed = new android.graphics.Rect[0];
            } else {
                android.graphics.Rect[] rectArr2 = this.j_renamed;
                if (rectArr2 == null || rectArr.length != rectArr2.length) {
                    this.j_renamed = new android.graphics.Rect[rectArr.length];
                }
            }
            synchronized (this) {
                java.lang.System.arraycopy(bArr, 0, this.i_renamed, 0, bArr.length);
                if (rectArr != null) {
                    java.lang.System.arraycopy(rectArr, 0, this.j_renamed, 0, rectArr.length);
                }
                notify();
            }
        }

        public void b_renamed() {
            synchronized (this) {
                notify();
            }
        }

        public void c_renamed() {
            this.d_renamed = false;
            interrupt();
            d_renamed();
        }

        public void d_renamed() {
            this.e_renamed.clear();
            this.f_renamed.clear();
            com.oplus.a_renamed.a_renamed.this.o_renamed = true;
        }
    }

    /* compiled from: OplusBlurProcess.java */
    private class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f3443a;

        /* renamed from: b_renamed, reason: collision with root package name */
        byte[] f3444b;

        public c_renamed(int i_renamed, byte[] bArr) {
            this.f3443a = 0;
            this.f3444b = null;
            this.f3443a = i_renamed;
            this.f3444b = bArr;
        }
    }

    /* compiled from: OplusBlurProcess.java */
    /* renamed from: com.oplus.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private class OplusBlurProcess_4 {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f3437a;

        /* renamed from: b_renamed, reason: collision with root package name */
        byte[] f3438b;

        /* renamed from: c_renamed, reason: collision with root package name */
        int f3439c;
        int d_renamed;
        android.graphics.Rect[] e_renamed;
        boolean f_renamed;

        public OplusBlurProcess_4(int i_renamed, byte[] bArr, int i2, int i3, android.graphics.Rect[] rectArr, boolean z_renamed) {
            this.f3437a = 0;
            this.f3438b = null;
            this.f3439c = 0;
            this.d_renamed = 0;
            this.e_renamed = null;
            this.f_renamed = false;
            this.f3437a = i_renamed;
            this.f3438b = bArr;
            this.f3439c = i2;
            this.d_renamed = i3;
            this.e_renamed = rectArr;
            this.f_renamed = z_renamed;
        }
    }
}
