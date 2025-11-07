package com.oplus.camera.m_renamed;

/* compiled from: ProcessQueueThread.java */
/* loaded from: classes2.dex */
public abstract class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected java.util.concurrent.ExecutorService f4883a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f4884b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f4885c = 0;
    private volatile int d_renamed = 0;
    private boolean e_renamed = false;
    private com.oplus.camera.m_renamed.d_renamed.a_renamed f_renamed = null;

    /* compiled from: ProcessQueueThread.java */
    public interface a_renamed {
        void a_renamed();
    }

    protected abstract void b_renamed();

    protected abstract void b_renamed(com.oplus.camera.Storage.CameraPicture cameraPicture) throws java.lang.Exception;

    static /* synthetic */ int a_renamed(com.oplus.camera.m_renamed.d_renamed dVar) {
        int i_renamed = dVar.f4885c;
        dVar.f4885c = i_renamed - 1;
        return i_renamed;
    }

    static /* synthetic */ int c_renamed(com.oplus.camera.m_renamed.d_renamed dVar) {
        int i_renamed = dVar.f4884b;
        dVar.f4884b = i_renamed - 1;
        return i_renamed;
    }

    public void a_renamed(com.oplus.camera.m_renamed.d_renamed.a_renamed aVar) {
        synchronized (this) {
            this.f_renamed = aVar;
        }
    }

    public void d_renamed() {
        b_renamed();
        if (this.f4883a == null) {
            this.f4883a = java.util.concurrent.Executors.newSingleThreadExecutor();
        }
    }

    public int e_renamed() {
        int i_renamed;
        com.oplus.camera.e_renamed.a_renamed("ProcessQueueThread", "getSaveListRawCount");
        synchronized (this) {
            i_renamed = this.f4884b;
        }
        return i_renamed;
    }

    public synchronized boolean f_renamed() {
        return this.f4885c > 50;
    }

    public synchronized boolean g_renamed() {
        return this.f4885c == 0;
    }

    public synchronized void h_renamed() {
        this.d_renamed++;
        com.oplus.camera.e_renamed.a_renamed("ProcessQueueThread", "afterAddFrame, mCaptureSize: " + this.d_renamed);
    }

    public synchronized void i_renamed() {
        this.d_renamed--;
        com.oplus.camera.e_renamed.a_renamed("ProcessQueueThread", "onPicReceiveFromAPS, mCaptureSize: " + this.d_renamed);
    }

    public synchronized boolean j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("ProcessQueueThread", "imageCaptureListIsEmpty, mCaptureSize: " + this.d_renamed);
        return this.d_renamed == 0;
    }

    public final void c_renamed(final com.oplus.camera.Storage.CameraPicture cameraPicture) {
        com.oplus.camera.e_renamed.a_renamed("ProcessQueueThread", "pictureArrive, width: " + cameraPicture.o_renamed + ", height: " + cameraPicture.p_renamed + ", orientation: " + cameraPicture.t_renamed + ", uri: " + cameraPicture.f4068c + ", title: " + cameraPicture.g_renamed);
        synchronized (this) {
            this.f4885c++;
            if ("raw".equals(cameraPicture.h_renamed)) {
                this.f4884b++;
            }
        }
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ONLY_HIGH_PICTURE_SIZE_HEIF_IN_APS) || com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA.equals(cameraPicture.i_renamed) || (!("heic_8bits".equalsIgnoreCase(cameraPicture.h_renamed) || "heic_10bits".equalsIgnoreCase(cameraPicture.h_renamed)) || cameraPicture.X_renamed)) {
            this.f4883a.submit(new java.lang.Runnable() { // from class: com.oplus.camera.m_renamed.d_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            com.oplus.camera.m_renamed.d_renamed.this.b_renamed(cameraPicture);
                            synchronized (com.oplus.camera.m_renamed.d_renamed.this) {
                                com.oplus.camera.m_renamed.d_renamed.a_renamed(com.oplus.camera.m_renamed.d_renamed.this);
                                if (com.oplus.camera.m_renamed.d_renamed.this.f_renamed != null) {
                                    com.oplus.camera.m_renamed.d_renamed.this.f_renamed.a_renamed();
                                }
                                if ("raw".equals(cameraPicture.h_renamed)) {
                                    com.oplus.camera.m_renamed.d_renamed.c_renamed(com.oplus.camera.m_renamed.d_renamed.this);
                                }
                                com.oplus.camera.m_renamed.d_renamed.this.a_renamed();
                            }
                        } catch (java.lang.Exception e_renamed) {
                            e_renamed.printStackTrace();
                            synchronized (com.oplus.camera.m_renamed.d_renamed.this) {
                                com.oplus.camera.m_renamed.d_renamed.a_renamed(com.oplus.camera.m_renamed.d_renamed.this);
                                if (com.oplus.camera.m_renamed.d_renamed.this.f_renamed != null) {
                                    com.oplus.camera.m_renamed.d_renamed.this.f_renamed.a_renamed();
                                }
                                if ("raw".equals(cameraPicture.h_renamed)) {
                                    com.oplus.camera.m_renamed.d_renamed.c_renamed(com.oplus.camera.m_renamed.d_renamed.this);
                                }
                                com.oplus.camera.m_renamed.d_renamed.this.a_renamed();
                            }
                        }
                    } catch (java.lang.Throwable th) {
                        synchronized (com.oplus.camera.m_renamed.d_renamed.this) {
                            com.oplus.camera.m_renamed.d_renamed.a_renamed(com.oplus.camera.m_renamed.d_renamed.this);
                            if (com.oplus.camera.m_renamed.d_renamed.this.f_renamed != null) {
                                com.oplus.camera.m_renamed.d_renamed.this.f_renamed.a_renamed();
                            }
                            if ("raw".equals(cameraPicture.h_renamed)) {
                                com.oplus.camera.m_renamed.d_renamed.c_renamed(com.oplus.camera.m_renamed.d_renamed.this);
                            }
                            com.oplus.camera.m_renamed.d_renamed.this.a_renamed();
                            throw th;
                        }
                    }
                }
            });
            return;
        }
        try {
            try {
                b_renamed(cameraPicture);
                synchronized (this) {
                    this.f4885c--;
                    if (this.f_renamed != null) {
                        this.f_renamed.a_renamed();
                    }
                    if ("raw".equals(cameraPicture.h_renamed)) {
                        this.f4884b--;
                    }
                    a_renamed();
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
                synchronized (this) {
                    this.f4885c--;
                    if (this.f_renamed != null) {
                        this.f_renamed.a_renamed();
                    }
                    if ("raw".equals(cameraPicture.h_renamed)) {
                        this.f4884b--;
                    }
                    a_renamed();
                }
            }
        } catch (java.lang.Throwable th) {
            synchronized (this) {
                this.f4885c--;
                if (this.f_renamed != null) {
                    this.f_renamed.a_renamed();
                }
                if ("raw".equals(cameraPicture.h_renamed)) {
                    this.f4884b--;
                }
                a_renamed();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed() {
        if (this.e_renamed && g_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("ProcessQueueThread", "checkAndKillProcess will kill camera process");
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    public synchronized void k_renamed() {
        if (this.f_renamed != null) {
            this.f_renamed.a_renamed();
        }
    }
}
