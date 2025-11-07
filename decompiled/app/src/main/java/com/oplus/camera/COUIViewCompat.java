package com.oplus.camera;

/* compiled from: ModeFacade.java */
/* loaded from: classes2.dex */
class t_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.oplus.camera.capmode.ModeManager f5580a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.CameraManager.n_renamed f5581b;

    protected t_renamed(com.oplus.camera.capmode.ModeManager modeManager, com.oplus.camera.CameraManager.n_renamed nVar) {
        this.f5580a = null;
        this.f5581b = null;
        this.f5580a = modeManager;
        this.f5581b = nVar;
    }

    protected synchronized void a_renamed() {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            oVarG.f4027b.beforePreview();
        } else {
            this.f5580a.r_renamed();
        }
    }

    protected synchronized java.lang.String b_renamed() {
        com.oplus.camera.CameraManager.o_renamed oVarI;
        com.oplus.camera.capmode.BaseMode baseMode;
        if (this.f5581b == null || (oVarI = this.f5581b.i_renamed()) == null || (baseMode = oVarI.f4027b) == null) {
            return null;
        }
        return baseMode.getCameraMode();
    }

    protected synchronized void a_renamed(boolean z_renamed) {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            oVarG.f4027b.afterStartPreview(z_renamed);
        } else {
            this.f5580a.c_renamed(z_renamed);
        }
    }

    protected synchronized android.util.Size a_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        return a_renamed(hVar, null);
    }

    protected synchronized android.util.Size a_renamed(android.util.Size size) {
        android.util.Size sizeA;
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            sizeA = oVarG.f4027b.getPreviewSurfaceSize(size);
        } else {
            sizeA = this.f5580a.a_renamed(size);
        }
        return sizeA;
    }

    protected synchronized android.util.Size a_renamed(com.oplus.camera.e_renamed.h_renamed hVar, java.lang.String str) {
        android.util.Size sizeA;
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            sizeA = oVarG.f4027b.getPreviewSize(hVar, str);
        } else {
            sizeA = this.f5580a.a_renamed(hVar, str);
        }
        return sizeA;
    }

    protected synchronized android.util.Size b_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        android.util.Size sizeC;
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            sizeC = oVarG.f4027b.getPictureSize(hVar);
        } else {
            sizeC = this.f5580a.c_renamed(hVar);
        }
        return sizeC;
    }

    protected synchronized int c_renamed() {
        int iR;
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            iR = oVarG.f4027b.getDefaultAFMode();
        } else {
            iR = this.f5580a.R_renamed();
        }
        return iR;
    }

    protected synchronized int d_renamed() {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            return oVarG.f4027b.getOperatingMode();
        }
        return this.f5580a.e_renamed();
    }

    protected synchronized android.util.Size c_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            return oVarG.f4027b.getPreviewFrameSize(hVar);
        }
        return this.f5580a.b_renamed(hVar);
    }

    protected synchronized boolean a_renamed(java.lang.String str) {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            return oVarG.f4027b.needSurface(str);
        }
        return this.f5580a.n_renamed(str);
    }

    protected synchronized void a_renamed(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder) {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            oVarG.f4027b.setConfigureParameter(builder);
        } else if (this.f5580a != null) {
            this.f5580a.a_renamed(builder);
        }
    }

    protected synchronized void e_renamed() {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            oVarG.f4027b.onSessionConfigured();
        } else {
            this.f5580a.bo_renamed();
        }
    }

    protected synchronized boolean f_renamed() {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            return oVarG.f4027b.isShowBeauty3D();
        }
        return this.f5580a.bq_renamed();
    }

    protected synchronized boolean b_renamed(java.lang.String str) {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            return oVarG.f4027b.getSupportFunction(str);
        }
        return this.f5580a.j_renamed(str);
    }

    protected synchronized com.oplus.camera.CameraManager.o_renamed g_renamed() {
        com.oplus.camera.CameraManager.o_renamed oVarH;
        if (this.f5581b != null && (oVarH = this.f5581b.h_renamed()) != null) {
            if (oVarH.f4027b != null) {
                return oVarH;
            }
        }
        return null;
    }

    protected synchronized com.oplus.camera.capmode.BaseMode h_renamed() {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            return oVarG.f4027b;
        }
        return this.f5580a.a_renamed(this.f5580a.n_renamed());
    }

    protected synchronized java.lang.String i_renamed() {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            return oVarG.f4028c;
        }
        return this.f5580a.n_renamed();
    }

    public synchronized void a_renamed(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            oVarG.f4027b.onRawImageReceived(cameraPictureImage);
        } else {
            this.f5580a.a_renamed(cameraPictureImage);
        }
    }

    public synchronized boolean b_renamed(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            return oVarG.f4027b.consumeImage(cameraPictureImage);
        }
        return this.f5580a.b_renamed(cameraPictureImage);
    }

    public synchronized void j_renamed() {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            oVarG.f4027b.beforeConfig();
        } else {
            this.f5580a.dw_renamed();
        }
    }

    public synchronized void b_renamed(boolean z_renamed) {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            oVarG.f4027b.setFlashTemporaryDisabled(z_renamed);
        } else {
            this.f5580a.v_renamed(z_renamed);
        }
    }

    public synchronized boolean k_renamed() {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            return oVarG.f4027b.isSatOpen();
        }
        return this.f5580a.isSatOpen();
    }

    public synchronized boolean l_renamed() {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            return oVarG.f4027b.isMultiVideoMode();
        }
        return this.f5580a.cQ_renamed();
    }

    public synchronized void m_renamed() {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            oVarG.f4027b.closeImageReader();
        } else {
            this.f5580a.ae_renamed();
        }
    }

    public synchronized boolean n_renamed() {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            return oVarG.f4027b.isAutoFocus();
        }
        return this.f5580a.dz_renamed();
    }

    public synchronized boolean c_renamed(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        com.oplus.camera.CameraManager.o_renamed oVarG = g_renamed();
        if (oVarG != null) {
            return oVarG.f4027b.onImageReceived(cameraPictureImage);
        }
        return this.f5580a.c_renamed(cameraPictureImage);
    }
}
