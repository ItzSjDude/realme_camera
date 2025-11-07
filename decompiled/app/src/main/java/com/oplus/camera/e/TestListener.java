package com.oplus.camera.e_renamed;

/* compiled from: OneCameraStateMachine.java */
/* loaded from: classes2.dex */
public abstract class g_renamed implements com.oplus.camera.e_renamed.d_renamed {
    protected com.oplus.camera.e_renamed.g_renamed.a_renamed p_renamed;
    protected com.oplus.camera.w_renamed.b_renamed q_renamed;
    protected android.os.Handler r_renamed;
    protected java.util.HashMap<java.lang.String, android.media.ImageReader> s_renamed;
    protected java.util.HashMap<java.lang.String, java.lang.Long> t_renamed;
    protected int w_renamed;
    protected android.os.ConditionVariable y_renamed;
    protected final java.lang.Object n_renamed = new java.lang.Object();
    protected android.os.ConditionVariable o_renamed = new android.os.ConditionVariable();
    protected int u_renamed = 3;
    protected int v_renamed = 1;
    protected int x_renamed = 0;
    private long z_renamed = 0;
    private long A_renamed = com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
    private boolean B_renamed = true;
    private boolean C_renamed = false;
    private android.os.ConditionVariable D_renamed = new android.os.ConditionVariable();
    private android.os.ConditionVariable E_renamed = new android.os.ConditionVariable();
    private java.util.concurrent.locks.Lock F_renamed = new java.util.concurrent.locks.ReentrantLock();

    protected abstract void E_renamed();

    protected abstract void F_renamed();

    protected abstract void a_renamed(int i_renamed, com.oplus.camera.e_renamed.d_renamed.b_renamed bVar);

    protected abstract void a_renamed(android.hardware.camera2.CameraDevice cameraDevice, boolean z_renamed);

    protected abstract void a_renamed(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder, com.oplus.camera.e_renamed.d_renamed.OneCamera_5 interfaceC0097d, int i_renamed);

    public g_renamed(int i_renamed) {
        this.p_renamed = null;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = null;
        this.w_renamed = 1;
        this.y_renamed = null;
        com.oplus.camera.w_renamed.c_renamed cVar = new com.oplus.camera.w_renamed.c_renamed("Camera Hal Control Thread" + i_renamed);
        cVar.a_renamed();
        cVar.start();
        this.p_renamed = new com.oplus.camera.e_renamed.g_renamed.a_renamed(cVar.getLooper());
        cVar.getLooper().setMessageLogging(new android.util.LogPrinter(2, "hal-control-handler"));
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("Camera Hal Callback Thread" + i_renamed);
        handlerThread.start();
        this.q_renamed = new com.oplus.camera.w_renamed.b_renamed(handlerThread.getLooper());
        android.os.HandlerThread handlerThread2 = new android.os.HandlerThread("Aps Capture Yuv Thread" + i_renamed);
        handlerThread2.start();
        this.r_renamed = new android.os.Handler(handlerThread2.getLooper());
        this.w_renamed = i_renamed;
        if (1 == i_renamed) {
            this.y_renamed = new android.os.ConditionVariable(true);
        }
        synchronized (this.n_renamed) {
            this.s_renamed = new java.util.HashMap<>();
            this.t_renamed = new java.util.HashMap<>();
        }
    }

    /* compiled from: OneCameraStateMachine.java */
    protected class a_renamed extends com.oplus.camera.w_renamed.b_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private boolean f4450b;

        a_renamed(android.os.Looper looper) {
            super(looper);
            this.f4450b = false;
        }

        @Override // com.oplus.camera.w_renamed.b_renamed
        public void a_renamed(java.lang.Runnable runnable) {
            if (!this.f4450b) {
                com.oplus.camera.e_renamed.b_renamed("OneCameraStateMachine", "postRunnable, mbEnabled:" + this.f4450b);
                return;
            }
            super.a_renamed(runnable);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.oplus.camera.e_renamed.b_renamed("OneCameraStateMachine", "handleMessage, mCameraRole: " + com.oplus.camera.e_renamed.g_renamed.this.w_renamed + ", msg: " + message.what);
            switch (message.what) {
                case 2:
                    if (message.obj instanceof com.oplus.camera.e_renamed.d_renamed.b_renamed) {
                        com.oplus.camera.e_renamed.c_renamed("OneCameraStateMachine", "handleMessage, open camera, cameraId: " + message.arg1 + ", openType: " + message.arg2);
                        if (message.obj instanceof com.oplus.camera.e_renamed.d_renamed.b_renamed) {
                            com.oplus.camera.e_renamed.g_renamed.this.b_renamed(message.arg1, (com.oplus.camera.e_renamed.d_renamed.b_renamed) message.obj);
                            ((com.oplus.camera.e_renamed.d_renamed.b_renamed) message.obj).c_renamed(message.arg1);
                            break;
                        }
                    } else {
                        com.oplus.camera.e_renamed.b_renamed("OneCameraStateMachine", "handleMessage, not open camera, openCallback: " + message.obj);
                        break;
                    }
                    break;
                case 3:
                    com.oplus.camera.e_renamed.g_renamed.b_renamed bVar = (com.oplus.camera.e_renamed.g_renamed.b_renamed) message.obj;
                    com.oplus.camera.e_renamed.g_renamed.this.a_renamed(bVar.f4451a, bVar.f4452b, bVar.f4453c);
                    com.oplus.camera.e_renamed.g_renamed.this.p_renamed.removeMessages(8);
                    message = com.oplus.camera.e_renamed.g_renamed.this.p_renamed.obtainMessage(8);
                    message.sendToTarget();
                    break;
                case 4:
                    com.oplus.camera.e_renamed.a_renamed("OneCameraStateMachine", com.oplus.camera.e_renamed.g_renamed.this.p_renamed, "closing camera");
                    com.oplus.camera.e_renamed.g_renamed.this.p_renamed.removeCallbacksAndMessages(null);
                    if (com.oplus.camera.e_renamed.g_renamed.this.B_renamed) {
                        com.oplus.camera.e_renamed.g_renamed.this.a_renamed(message.obj != null ? (android.hardware.camera2.CameraDevice) message.obj : null, message.arg1);
                        break;
                    } else {
                        com.oplus.camera.e_renamed.b_renamed("OneCameraStateMachine", "don't_renamed close camera and run open flow");
                        com.oplus.camera.e_renamed.g_renamed.this.B_renamed = true;
                        break;
                    }
                case 5:
                    com.oplus.camera.e_renamed.g_renamed.this.a_renamed(message.obj != null ? (android.hardware.camera2.CameraDevice) message.obj : null, 1 == message.arg1);
                    break;
                case 6:
                    com.oplus.camera.e_renamed.g_renamed.this.D_renamed();
                    com.oplus.camera.e_renamed.g_renamed.this.E_renamed();
                    break;
                case 7:
                    if (com.oplus.camera.e_renamed.g_renamed.this.u_renamed == 1 || com.oplus.camera.e_renamed.g_renamed.this.u_renamed == 8 || com.oplus.camera.e_renamed.g_renamed.this.u_renamed == 6) {
                        ((com.oplus.camera.e_renamed.d_renamed.b_renamed) message.obj).a_renamed(com.oplus.camera.e_renamed.g_renamed.this.w_renamed);
                        break;
                    }
                    break;
                case 8:
                    com.oplus.camera.e_renamed.g_renamed.this.F_renamed();
                    break;
            }
            com.oplus.camera.e_renamed.a_renamed("OneCameraStateMachine", "handleMessage x_renamed, mCameraRole: " + com.oplus.camera.e_renamed.g_renamed.this.w_renamed + ", msg: " + message.what);
        }

        public void a_renamed(boolean z_renamed) {
            this.f4450b = z_renamed;
        }
    }

    protected void G_renamed() {
        if (this.y_renamed != null) {
            com.oplus.camera.e_renamed.b_renamed("OneCameraStateMachine", "openMainCameraOpenBlock, mCameraRole: " + this.w_renamed);
            this.y_renamed.open();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.hardware.camera2.CameraDevice cameraDevice, int i_renamed) {
        com.oplus.camera.e_renamed.b_renamed("OneCameraStateMachine", "closeCameraDecision, mCameraRole: " + this.w_renamed + ", mDeviceState: " + this.u_renamed);
        int i2 = this.u_renamed;
        if (i2 == 1 || i2 == 8 || i2 == 0 || i2 == 5 || i2 == 6) {
            com.oplus.camera.e_renamed.b_renamed("OneCameraStateMachine", "closeCameraDecision, mCameraRole: " + this.w_renamed + ",  quick close");
            android.os.Message messageObtainMessage = this.p_renamed.obtainMessage();
            messageObtainMessage.what = 5;
            messageObtainMessage.obj = cameraDevice;
            messageObtainMessage.arg1 = i_renamed;
            this.p_renamed.sendMessage(messageObtainMessage);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(int i_renamed, com.oplus.camera.e_renamed.d_renamed.b_renamed bVar, int i2) {
        com.oplus.camera.e_renamed.c_renamed("OneCameraStateMachine", "openCamera, send open message, cameraId: " + i_renamed + ", this: " + this);
        android.os.Message messageObtainMessage = this.p_renamed.obtainMessage();
        messageObtainMessage.what = 2;
        messageObtainMessage.obj = bVar;
        messageObtainMessage.arg1 = i_renamed;
        messageObtainMessage.arg2 = i2;
        this.p_renamed.sendMessage(messageObtainMessage);
        com.oplus.camera.e_renamed.a_renamed("OneCameraStateMachine", this.p_renamed, "dump-after-enqueue-open-camera");
    }

    public void b_renamed(int i_renamed, com.oplus.camera.e_renamed.d_renamed.b_renamed bVar) {
        com.oplus.camera.e_renamed.c_renamed("OneCameraStateMachine", "openCamera, mCameraRole: " + this.w_renamed + ", cameraId: " + i_renamed + ", this: " + this);
        com.oplus.camera.e_renamed.a_renamed("OneCameraStateMachine", this.p_renamed, "dump-before-open");
        this.p_renamed.removeCallbacksAndMessages(null);
        if (this.C_renamed) {
            this.B_renamed = false;
        } else {
            this.A_renamed = com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
        }
        b_renamed(false);
        if (c_renamed() == -1) {
            com.oplus.camera.e_renamed.c_renamed("OneCameraStateMachine", "openCamera, mCameraRole: " + this.w_renamed + ", normal open");
        } else {
            com.oplus.camera.e_renamed.c_renamed("OneCameraStateMachine", "openCamera, mCameraRole: " + this.w_renamed + ", close then open");
            a_renamed((android.hardware.camera2.CameraDevice) null, false);
        }
        a_renamed(i_renamed, bVar);
        this.B_renamed = true;
        android.os.Message messageObtainMessage = this.p_renamed.obtainMessage();
        messageObtainMessage.what = 7;
        messageObtainMessage.obj = bVar;
        this.p_renamed.sendMessageAtFrontOfQueue(messageObtainMessage);
        com.oplus.camera.e_renamed.a_renamed("OneCameraStateMachine", this.p_renamed, "openCamera");
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed, android.hardware.camera2.CameraDevice cameraDevice, boolean z2) {
        com.oplus.camera.e_renamed.f_renamed("OneCameraStateMachine", "closeCamera, mCameraRole: " + this.w_renamed + ",  mCameraDevice: " + cameraDevice + ", fromError: " + z_renamed + ", needDelay: " + z2);
        android.os.Message messageObtainMessage = this.p_renamed.obtainMessage();
        messageObtainMessage.what = 4;
        messageObtainMessage.obj = cameraDevice;
        messageObtainMessage.arg1 = z2 ? 1 : 0;
        this.B_renamed = true;
        this.p_renamed.sendMessageAtFrontOfQueue(messageObtainMessage);
        com.oplus.camera.e_renamed.a_renamed("OneCameraStateMachine", this.p_renamed, "closeCamera");
    }

    public void b_renamed(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder, com.oplus.camera.e_renamed.d_renamed.OneCamera_5 interfaceC0097d, int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraStateMachine", "createCaptureSession");
        android.os.Message messageObtainMessage = this.p_renamed.obtainMessage();
        messageObtainMessage.what = 3;
        com.oplus.camera.e_renamed.g_renamed.b_renamed bVar = new com.oplus.camera.e_renamed.g_renamed.b_renamed();
        bVar.f4451a = builder;
        bVar.f4452b = interfaceC0097d;
        bVar.f4453c = i_renamed;
        messageObtainMessage.obj = bVar;
        this.p_renamed.sendMessage(messageObtainMessage);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void f_renamed() {
        com.oplus.camera.e_renamed.a_renamed("OneCameraStateMachine", "closeSession, mCameraRole: " + this.w_renamed);
        android.os.Message messageObtainMessage = this.p_renamed.obtainMessage();
        messageObtainMessage.what = 6;
        messageObtainMessage.obj = null;
        messageObtainMessage.arg1 = 0;
        this.p_renamed.sendMessage(messageObtainMessage);
    }

    protected void B_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.f_renamed("OneCameraStateMachine", "setDeviceState, mCameraRole: " + this.w_renamed + ",  mDeviceState: " + this.u_renamed + " -> " + i_renamed);
        if (this.u_renamed == 5 && i_renamed == 3) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            this.o_renamed.close();
            this.o_renamed.block(1000L);
            com.oplus.camera.e_renamed.f_renamed("OneCameraStateMachine", "setDeviceState, wait close: " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        }
        this.u_renamed = i_renamed;
        if (this.u_renamed == 5) {
            this.p_renamed.a_renamed(true);
        } else {
            this.p_renamed.a_renamed(false);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(int i_renamed) {
        synchronized (this.n_renamed) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, android.media.ImageReader>> it = this.s_renamed.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().close();
            }
            this.s_renamed.clear();
            this.t_renamed.clear();
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void c_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.c_renamed("OneCameraStateMachine", "discardFreeBuffers, format: " + i_renamed);
        synchronized (this.n_renamed) {
            java.lang.String[] strArr = null;
            try {
                if (35 == i_renamed) {
                    strArr = new java.lang.String[]{"type_still_capture_yuv_main", "type_still_capture_yuv_mfnr", "type_still_capture_yuv_sub", "type_still_capture_yuv_third", "type_tuning_data_yuv"};
                } else if (32 == i_renamed) {
                    strArr = new java.lang.String[]{"type_still_capture_raw", "type_tuning_data_raw"};
                }
                if (strArr != null) {
                    for (java.lang.String str : strArr) {
                        if (this.s_renamed.containsKey(str)) {
                            this.s_renamed.get(str).discardFreeBuffers();
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void d_renamed() {
        this.q_renamed.getLooper().quitSafely();
        this.p_renamed.getLooper().quitSafely();
        this.r_renamed.getLooper().quitSafely();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(final boolean z_renamed) {
        com.oplus.camera.util.Util.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.e_renamed.g_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.a_renamed("OneCameraStateMachine", "broadcastRearCamera, enterRearCamera: " + z_renamed);
                android.content.Intent intent = new android.content.Intent("com.oplus.rearcamera");
                intent.putExtra("command", z_renamed ? "enterrear" : "exitrear");
                com.oplus.camera.util.Util.l_renamed().sendBroadcast(intent);
            }
        });
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(int i_renamed) {
        this.v_renamed = i_renamed;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public android.os.Handler l_renamed() {
        return this.p_renamed;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void m_renamed() {
        com.oplus.camera.e_renamed.a_renamed("OneCameraStateMachine", "removeStaleCameraMessage");
        com.oplus.camera.e_renamed.g_renamed.a_renamed aVar = this.p_renamed;
        if (aVar != null) {
            if (aVar.hasMessages(4)) {
                com.oplus.camera.e_renamed.a_renamed("OneCameraStateMachine", "openCamera, open after close, don't_renamed need close, just remove close msg.");
                this.p_renamed.removeMessages(4);
            }
            if (this.p_renamed.hasMessages(2)) {
                com.oplus.camera.e_renamed.a_renamed("OneCameraStateMachine", "openCamera, open again, remove the old open message.");
                this.p_renamed.removeMessages(2);
            }
        }
    }

    public void H_renamed() {
        this.F_renamed.lock();
        try {
            this.E_renamed.close();
            this.D_renamed.close();
        } finally {
            this.F_renamed.unlock();
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("OneCameraStateMachine", "openLock, mCameraRole: " + this.w_renamed + ", openboth : " + z_renamed);
        this.F_renamed.lock();
        try {
            this.D_renamed.open();
            if (z_renamed) {
                this.E_renamed.open();
            }
        } finally {
            this.F_renamed.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D_renamed() {
        long j_renamed = com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS - this.A_renamed;
        if (j_renamed > 1) {
            com.oplus.camera.e_renamed.b_renamed("OneCameraStateMachine", "blockCloseOldSession begin, mCameraRole: " + this.w_renamed + ", leftWaitingTime: " + j_renamed);
            this.E_renamed.block(j_renamed);
            this.A_renamed = com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
            this.E_renamed.open();
            com.oplus.camera.e_renamed.b_renamed("OneCameraStateMachine", "blockCloseOldSession end, mCameraRole: " + this.w_renamed);
        }
    }

    public boolean I_renamed() {
        return 5 == this.u_renamed;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public boolean a_renamed() {
        return 3 == this.u_renamed;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public boolean b_renamed() {
        return 2 == this.u_renamed;
    }

    public boolean J_renamed() {
        int i_renamed = this.u_renamed;
        return 1 == i_renamed || 4 == i_renamed || 5 == i_renamed;
    }

    /* compiled from: OneCameraStateMachine.java */
    private class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        com.oplus.ocs.camera.CameraDeviceConfig.Builder f4451a;

        /* renamed from: b_renamed, reason: collision with root package name */
        com.oplus.camera.e_renamed.d_renamed.OneCamera_5 f4452b;

        /* renamed from: c_renamed, reason: collision with root package name */
        int f4453c;

        private b_renamed() {
            this.f4451a = null;
            this.f4452b = null;
            this.f4453c = 0;
        }
    }
}
