package com.oplus.camera.panorama;

/* compiled from: PanoramaCapMode.java */
/* loaded from: classes2.dex */
public class f_renamed extends com.oplus.camera.capmode.BaseMode implements com.oplus.camera.panorama.d_renamed.a_renamed, com.oplus.camera.panorama.g_renamed.a_renamed {
    private static final java.lang.Object i_renamed = new java.lang.Object();
    private android.widget.TextView A_renamed;
    private android.content.res.Resources B_renamed;
    private java.lang.Object C_renamed;
    private android.widget.RelativeLayout D_renamed;
    private com.oplus.camera.ui.camerascreenhint.CameraScreenHintView E_renamed;
    private android.util.Size F_renamed;
    private android.util.Size G_renamed;
    private android.util.Size H_renamed;
    private com.oplus.camera.panorama.PanoramaProgressBar I_renamed;
    private volatile boolean J_renamed;
    private volatile boolean K_renamed;
    private volatile boolean L_renamed;
    private int M_renamed;
    private int N_renamed;
    private int O_renamed;
    private boolean P_renamed;
    private boolean Q_renamed;
    private volatile int R_renamed;
    private byte[] S_renamed;
    private int T_renamed;
    private int U_renamed;
    private int V_renamed;
    private int W_renamed;
    private int X_renamed;
    private int Y_renamed;
    private int Z_renamed;
    private float aa_renamed;
    private int ab_renamed;
    private com.oplus.camera.panorama.g_renamed ac_renamed;
    private android.graphics.Bitmap ad_renamed;
    private android.graphics.Matrix ae_renamed;
    private java.lang.String af_renamed;
    private boolean ag_renamed;
    private int ah_renamed;
    private float ai_renamed;
    private int aj_renamed;
    private com.oplus.camera.panorama.d_renamed ak_renamed;
    private android.graphics.Bitmap al_renamed;
    private android.os.Handler am_renamed;
    com.oplus.camera.panorama.FrontPanoramaGuideView.a_renamed g_renamed;
    com.oplus.camera.panorama.PanoramaProgressBar.RearPanoramaInterface h_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private int p_renamed;
    private int q_renamed;
    private int r_renamed;
    private int s_renamed;
    private boolean t_renamed;
    private boolean u_renamed;
    private boolean v_renamed;
    private boolean w_renamed;
    private android.graphics.Bitmap x_renamed;
    private android.widget.ImageView y_renamed;
    private com.oplus.camera.panorama.FrontPanoramaGuideView z_renamed;

    private int e_renamed(int i2) {
        if (i2 == -1) {
            return 3;
        }
        if (i2 != 2) {
            return i2 != 3 ? 0 : 1;
        }
        return 2;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getAssistViewLayoutType() {
        return 2;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.CameraStatisticsUtil.MakerNote getMakerNote() {
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32775;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportQuickJpeg(com.oplus.camera.e_renamed.c_renamed cVar) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(java.lang.String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isImmediateCapture() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean needCancelToForceStop() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
    }

    @Override // com.oplus.camera.panorama.g_renamed.a_renamed
    public void g_renamed() {
        this.am_renamed.sendEmptyMessage(6);
        synchronized (i_renamed) {
            if (this.ac_renamed != null) {
                this.ac_renamed.a_renamed();
            }
        }
    }

    @Override // com.oplus.camera.panorama.g_renamed.a_renamed
    public void a_renamed(com.arcsoft.camera.burstpmk.ProcessResult processResult) throws java.io.IOException {
        this.J_renamed = false;
        int i2 = processResult.width;
        int i3 = processResult.height;
        if (i2 <= 0 || i3 <= 0) {
            this.am_renamed.sendEmptyMessage(6);
            synchronized (i_renamed) {
                if (this.ac_renamed != null) {
                    this.ac_renamed.a_renamed();
                }
            }
            return;
        }
        byte[] bArr = new byte[processResult.imageData.length];
        com.oplus.camera.jni.FormatConverter.rotateAndMirrorYUV(processResult.imageData, bArr, processResult.imageData.length, new int[]{i2, i2}, new int[]{i3, i3}, i2, i3, 90, false);
        if (getHeicCodecFormat() != null) {
            a_renamed(bArr, i3, i2);
        } else if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FEATURE_DCIP3_SUPPORT)) {
            a_renamed(com.oplus.camera.jni.IccProfile.convertYuv2JpegWithColorProfile(bArr, 95, i3, i2), i3, i2);
        } else {
            try {
                android.graphics.YuvImage yuvImage = new android.graphics.YuvImage(bArr, 17, i3, i2, null);
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                yuvImage.compressToJpeg(new android.graphics.Rect(0, 0, i3, i2), 95, byteArrayOutputStream);
                a_renamed(byteArrayOutputStream.toByteArray(), i3, i2);
                byteArrayOutputStream.close();
            } catch (java.io.IOException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        synchronized (i_renamed) {
            if (this.ac_renamed != null) {
                this.ac_renamed.a_renamed();
            }
        }
    }

    @Override // com.oplus.camera.panorama.g_renamed.a_renamed
    public void b_renamed(final com.arcsoft.camera.burstpmk.ProcessResult processResult) {
        if (this.R_renamed != processResult.direction && this.mActivity != null) {
            this.R_renamed = processResult.direction;
            final android.graphics.Rect rect = processResult.updateSmallImageRect;
            android.graphics.Bitmap bitmapA = com.oplus.camera.panorama.e_renamed.a_renamed(this.mActivity, processResult.smallImageData, rect.right - rect.left, rect.bottom - rect.top);
            if (bitmapA != null) {
                final android.graphics.Bitmap bitmapA2 = com.oplus.camera.util.Util.a_renamed(bitmapA, 0, 0, bitmapA.getWidth(), bitmapA.getHeight(), this.ae_renamed, true);
                this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.panorama.f_renamed.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.oplus.camera.panorama.f_renamed.this.I_renamed != null) {
                            com.oplus.camera.panorama.f_renamed.this.I_renamed.setAnimationState(3 == com.oplus.camera.panorama.f_renamed.this.R_renamed ? 4 : 5);
                            com.oplus.camera.panorama.f_renamed.this.I_renamed.a_renamed();
                        }
                        com.oplus.camera.panorama.f_renamed fVar = com.oplus.camera.panorama.f_renamed.this;
                        fVar.ad_renamed = fVar.a_renamed(fVar.ad_renamed, bitmapA2, rect);
                    }
                });
                return;
            }
            return;
        }
        if (c_renamed(processResult) && this.mActivity != null) {
            final android.graphics.Rect rect2 = processResult.updateSmallImageRect;
            android.graphics.Bitmap bitmapA3 = com.oplus.camera.panorama.e_renamed.a_renamed(this.mActivity, processResult.smallImageData, rect2.right - rect2.left, rect2.bottom - rect2.top);
            if (bitmapA3 != null) {
                final android.graphics.Bitmap bitmapA4 = com.oplus.camera.util.Util.a_renamed(bitmapA3, 0, 0, bitmapA3.getWidth(), bitmapA3.getHeight(), this.ae_renamed, true);
                this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.panorama.f_renamed.10
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.panorama.f_renamed fVar = com.oplus.camera.panorama.f_renamed.this;
                        fVar.ad_renamed = fVar.a_renamed(fVar.ad_renamed, bitmapA4, rect2);
                        com.oplus.camera.panorama.f_renamed.this.am_renamed.removeMessages(5);
                        android.os.Message messageObtainMessage = com.oplus.camera.panorama.f_renamed.this.am_renamed.obtainMessage(5);
                        messageObtainMessage.arg1 = processResult.outputOffset.x_renamed;
                        com.oplus.camera.panorama.f_renamed.this.am_renamed.sendMessage(messageObtainMessage);
                    }
                });
                return;
            }
            return;
        }
        i_renamed();
    }

    private void i_renamed() {
        synchronized (i_renamed) {
            if (this.J_renamed && this.ac_renamed != null) {
                this.ac_renamed.c_renamed();
                this.J_renamed = false;
            }
        }
    }

    public void a_renamed(byte[] bArr, int i2, int i3) {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "onRearPanoramaSave, data: " + bArr + ", mbPaused: " + this.mbPaused);
        if (this.mbPaused) {
            return;
        }
        this.L_renamed = false;
        this.mCameraInterface.c_renamed(com.oplus.camera.util.Util.ao_renamed() ? 7 : 5);
        this.am_renamed.sendEmptyMessage(6);
        if (bArr != null) {
            com.oplus.camera.Storage.CameraPicture cameraPicture = new com.oplus.camera.Storage.CameraPicture();
            cameraPicture.e_renamed = bArr;
            cameraPicture.h_renamed = getHeicCodecFormat() != null ? getHeicCodecFormat() : com.oplus.camera.statistics.model.CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG;
            cameraPicture.t_renamed = com.oplus.camera.util.Util.b_renamed(bArr);
            cameraPicture.mPath = null;
            cameraPicture.o_renamed = i2;
            cameraPicture.p_renamed = i3;
            cameraPicture.D_renamed = true;
            cameraPicture.E_renamed = this.mbDisplayOnLock;
            cameraPicture.d_renamed = this.mCameraInterface.y_renamed();
            if (!this.mbPaused) {
                this.mCameraInterface.a_renamed(cameraPicture, true);
            } else {
                this.L_renamed = true;
            }
        }
    }

    private void a_renamed(byte[] bArr) {
        synchronized (this.C_renamed) {
            if (bArr != null) {
                if (this.x_renamed != null && !this.x_renamed.isRecycled() && this.H_renamed != null) {
                    if (this.ak_renamed == null || !this.ak_renamed.b_renamed()) {
                        if (this.F_renamed != null && this.mActivity != null && bArr.length > 1) {
                            this.x_renamed = com.oplus.camera.panorama.e_renamed.a_renamed(this.mActivity, bArr, this.F_renamed.getWidth(), this.F_renamed.getHeight(), this.F_renamed.getWidth() / 6, this.F_renamed.getHeight() / 6);
                            android.graphics.Matrix matrix = new android.graphics.Matrix();
                            matrix.postRotate(90.0f);
                            matrix.postScale(1.0f, -1.0f);
                            if (this.x_renamed != null) {
                                this.x_renamed = com.oplus.camera.util.Util.a_renamed(this.x_renamed, 0, 0, this.x_renamed.getWidth(), this.x_renamed.getHeight(), matrix, true);
                            }
                        }
                        b_renamed(this.ak_renamed != null ? this.ak_renamed.a_renamed(this.x_renamed) : null);
                        return;
                    }
                    return;
                }
            }
            com.oplus.camera.e_renamed.f_renamed("PanoramaCapMode", "processFrontPreviewFrame, data: " + bArr + ", mFrontPreviewBitmap: " + this.x_renamed + ", mPictureSize: " + this.H_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onPreviewFrameReceived(android.media.Image image) {
        super.onPreviewFrameReceived(image);
        if (image == null || this.mbPaused || !this.v_renamed || !this.u_renamed || (this.mCameraInterface != null && this.mCameraInterface.E_renamed())) {
            com.oplus.camera.e_renamed.b_renamed("PanoramaCapMode", "onPreviewFrameReceived, mbPaused: " + this.mbPaused + ", mbCapInit: " + this.v_renamed + ", mbStartPreviewed: " + this.u_renamed);
            return true;
        }
        if (this.mbFrontCamera) {
            byte[] bArrA = com.oplus.camera.util.Util.a_renamed(image, 17);
            a_renamed(bArrA);
            com.oplus.camera.panorama.d_renamed dVar = this.ak_renamed;
            if (dVar != null) {
                dVar.b_renamed(bArrA);
            }
        } else if (this.J_renamed) {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_PANORAMA_REAR_PROCESS_IMAGE)) {
                synchronized (i_renamed) {
                    if (this.ac_renamed != null) {
                        this.ac_renamed.a_renamed(image);
                        return false;
                    }
                }
            } else {
                java.nio.ByteBuffer[] byteBufferArr = {image.getPlanes()[0].getBuffer(), image.getPlanes()[2].getBuffer()};
                synchronized (i_renamed) {
                    if (this.ac_renamed != null) {
                        this.ac_renamed.a_renamed(byteBufferArr);
                    }
                }
                if (com.oplus.camera.util.Util.c_renamed()) {
                    com.oplus.camera.util.Util.a_renamed(com.oplus.camera.util.Util.a_renamed(image, 17), "dump_rear", java.lang.System.currentTimeMillis() + "_" + this.G_renamed.getWidth() + "x_renamed" + this.G_renamed.getHeight());
                }
            }
        } else {
            this.S_renamed = com.oplus.camera.util.Util.a_renamed(image, 17, this.S_renamed);
            this.am_renamed.removeMessages(7);
            this.am_renamed.obtainMessage(7, this.S_renamed).sendToTarget();
        }
        return true;
    }

    public f_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.j_renamed = com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT;
        this.k_renamed = 282;
        this.l_renamed = 0;
        this.m_renamed = 0;
        this.n_renamed = 0;
        this.o_renamed = 0;
        this.p_renamed = 0;
        this.q_renamed = 0;
        this.r_renamed = 42;
        this.s_renamed = 0;
        this.t_renamed = false;
        this.u_renamed = false;
        this.v_renamed = false;
        this.w_renamed = false;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = null;
        this.A_renamed = null;
        this.B_renamed = null;
        this.C_renamed = new java.lang.Object();
        this.D_renamed = null;
        this.E_renamed = null;
        this.F_renamed = null;
        this.G_renamed = null;
        this.H_renamed = null;
        this.I_renamed = null;
        this.J_renamed = false;
        this.K_renamed = false;
        this.L_renamed = true;
        this.M_renamed = 0;
        this.N_renamed = 0;
        this.O_renamed = 0;
        this.Q_renamed = false;
        this.R_renamed = -1;
        this.S_renamed = null;
        this.T_renamed = 0;
        this.U_renamed = 0;
        this.V_renamed = 0;
        this.W_renamed = 0;
        this.X_renamed = 0;
        this.Y_renamed = 0;
        this.Z_renamed = 0;
        this.aa_renamed = 0.0f;
        this.ab_renamed = 0;
        this.ac_renamed = null;
        this.ad_renamed = null;
        this.ae_renamed = new android.graphics.Matrix();
        this.af_renamed = "normal";
        this.ag_renamed = false;
        this.ah_renamed = 0;
        this.ai_renamed = 0.0f;
        this.aj_renamed = -2;
        this.ak_renamed = null;
        this.al_renamed = null;
        this.am_renamed = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.oplus.camera.panorama.f_renamed.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) throws android.content.res.Resources.NotFoundException {
                switch (message.what) {
                    case 1:
                        if (com.oplus.camera.panorama.f_renamed.this.ak_renamed != null) {
                            com.oplus.camera.panorama.f_renamed.this.ak_renamed.a_renamed();
                        }
                        com.oplus.camera.panorama.f_renamed.this.n_renamed();
                        boolean zBooleanValue = ((java.lang.Boolean) message.obj).booleanValue();
                        com.oplus.camera.panorama.f_renamed.this.a_renamed(zBooleanValue);
                        if (zBooleanValue) {
                            return;
                        }
                        com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.as_renamed();
                        return;
                    case 2:
                        android.graphics.Bitmap bitmap = (android.graphics.Bitmap) message.obj;
                        if (!com.oplus.camera.panorama.f_renamed.this.v_renamed || com.oplus.camera.panorama.f_renamed.this.mbPaused || com.oplus.camera.panorama.f_renamed.this.y_renamed == null || bitmap == null || bitmap.isRecycled() || !com.oplus.camera.g_renamed.a_renamed(com.oplus.camera.panorama.f_renamed.this.mActivity.getApplicationContext()).d_renamed()) {
                            return;
                        }
                        com.oplus.camera.panorama.f_renamed.this.y_renamed.setImageBitmap(bitmap);
                        if (com.oplus.camera.panorama.f_renamed.this.al_renamed != null) {
                            com.oplus.camera.panorama.f_renamed.this.al_renamed.recycle();
                            com.oplus.camera.panorama.f_renamed.this.al_renamed = null;
                        }
                        com.oplus.camera.panorama.f_renamed.this.al_renamed = bitmap;
                        return;
                    case 3:
                        if (!com.oplus.camera.panorama.f_renamed.this.v_renamed || com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.R_renamed()) {
                            return;
                        }
                        com.oplus.camera.panorama.f_renamed.this.b_renamed(((java.lang.Integer) message.obj).intValue());
                        return;
                    case 4:
                        if (com.oplus.camera.panorama.f_renamed.this.J_renamed || com.oplus.camera.panorama.f_renamed.this.I_renamed == null || com.oplus.camera.panorama.f_renamed.this.I_renamed.e_renamed() || -1 == com.oplus.camera.panorama.f_renamed.this.I_renamed.getDirection()) {
                            return;
                        }
                        com.oplus.camera.panorama.f_renamed.this.I_renamed.f_renamed();
                        com.oplus.camera.panorama.f_renamed.this.I_renamed.a_renamed();
                        com.oplus.camera.panorama.f_renamed.this.I_renamed.setAnimationState(6);
                        return;
                    case 5:
                        if (!com.oplus.camera.panorama.f_renamed.this.J_renamed || com.oplus.camera.panorama.f_renamed.this.ad_renamed == null || com.oplus.camera.panorama.f_renamed.this.I_renamed == null) {
                            return;
                        }
                        int i2 = message.arg1;
                        if (com.oplus.camera.panorama.f_renamed.this.ab_renamed == 0) {
                            com.oplus.camera.panorama.f_renamed.this.ab_renamed = i2;
                        }
                        com.oplus.camera.panorama.f_renamed.this.I_renamed.a_renamed(com.oplus.camera.panorama.f_renamed.this.ad_renamed, com.oplus.camera.panorama.f_renamed.this.ad_renamed.getWidth() - com.oplus.camera.panorama.f_renamed.this.U_renamed, (int) ((i2 - com.oplus.camera.panorama.f_renamed.this.ab_renamed) * 0.1f));
                        return;
                    case 6:
                        com.oplus.camera.panorama.f_renamed fVar = com.oplus.camera.panorama.f_renamed.this;
                        fVar.setOrientation(fVar.M_renamed);
                        if (com.oplus.camera.panorama.f_renamed.this.I_renamed != null) {
                            com.oplus.camera.panorama.f_renamed.this.I_renamed.a_renamed(com.oplus.camera.panorama.f_renamed.this.ad_renamed);
                        }
                        com.oplus.camera.panorama.f_renamed.this.K_renamed = false;
                        com.oplus.camera.panorama.f_renamed.this.b_renamed(0);
                        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "handleMessage, MSG_REAR_PANORAMA_FINISH");
                        com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.a_renamed(com.oplus.camera.util.Util.ao_renamed() ? new com.oplus.camera.ui.control.b_renamed(6, "button_color_inside_hasselblad", "button_shape_ring_none", 3) : new com.oplus.camera.ui.control.b_renamed(11, "button_color_inside_none"));
                        com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.g_renamed(0);
                        com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.b_renamed(0, true);
                        com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.c_renamed(0);
                        com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.d_renamed(com.oplus.camera.panorama.f_renamed.this.getFrontEnable() ? 0 : 4);
                        com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.f_renamed(0);
                        if (com.oplus.camera.panorama.f_renamed.this.v_renamed) {
                            if (com.oplus.camera.panorama.f_renamed.this.isPanelMode()) {
                                com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.a_renamed(0, false);
                            } else {
                                com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.a_renamed(0, 1);
                            }
                        }
                        com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.d_renamed(true, false);
                        if (!com.oplus.camera.panorama.f_renamed.this.mCameraInterface.z_renamed()) {
                            com.oplus.camera.panorama.f_renamed.this.mCameraInterface.ac_renamed();
                            com.oplus.camera.panorama.f_renamed.this.mOneCamera.b_renamed(false, false);
                            com.oplus.camera.panorama.f_renamed.this.mOneCamera.a_renamed(4, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
                            com.oplus.camera.panorama.f_renamed.this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(com.oplus.camera.a_renamed.c_renamed()));
                        }
                        com.oplus.camera.panorama.f_renamed.this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) false);
                        com.oplus.camera.panorama.f_renamed.this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
                        com.oplus.camera.panorama.f_renamed.this.t_renamed = false;
                        com.oplus.camera.panorama.f_renamed fVar2 = com.oplus.camera.panorama.f_renamed.this;
                        fVar2.pictureTakenCallback(null, 0, 0, com.oplus.camera.util.Util.a_renamed(fVar2.getImageFormat()), false, false, 0L, 0);
                        return;
                    case 7:
                        synchronized (com.oplus.camera.panorama.f_renamed.i_renamed) {
                            if (!com.oplus.camera.panorama.f_renamed.this.J_renamed && com.oplus.camera.panorama.f_renamed.this.I_renamed != null && com.oplus.camera.panorama.f_renamed.this.G_renamed != null && !com.oplus.camera.panorama.f_renamed.this.K_renamed) {
                                android.graphics.Bitmap bitmapA = com.oplus.camera.panorama.e_renamed.a_renamed(com.oplus.camera.panorama.f_renamed.this.mActivity, (byte[]) message.obj, com.oplus.camera.panorama.f_renamed.this.G_renamed.getWidth(), com.oplus.camera.panorama.f_renamed.this.G_renamed.getHeight(), com.oplus.camera.panorama.f_renamed.this.X_renamed, com.oplus.camera.panorama.f_renamed.this.W_renamed);
                                if (!com.oplus.camera.panorama.f_renamed.this.mbPaused && bitmapA != null) {
                                    android.graphics.Bitmap bitmapA2 = com.oplus.camera.util.Util.a_renamed(bitmapA, 0, 0, bitmapA.getWidth(), bitmapA.getHeight(), com.oplus.camera.panorama.f_renamed.this.ae_renamed, true);
                                    com.oplus.camera.panorama.f_renamed.this.I_renamed.setFrameSize(bitmapA2.getWidth());
                                    com.oplus.camera.panorama.f_renamed.this.I_renamed.a_renamed(bitmapA2, 0, 0);
                                }
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.g_renamed = new com.oplus.camera.panorama.FrontPanoramaGuideView.a_renamed() { // from class: com.oplus.camera.panorama.f_renamed.7
            @Override // com.oplus.camera.panorama.FrontPanoramaGuideView.a_renamed
            public void a_renamed(int i2) {
                if (com.oplus.camera.panorama.f_renamed.this.A_renamed == null || com.oplus.camera.panorama.f_renamed.this.z_renamed == null) {
                    return;
                }
                com.oplus.camera.panorama.f_renamed.this.A_renamed.setText(com.oplus.camera.panorama.f_renamed.this.z_renamed.getCurrentGuideTips());
            }
        };
        this.h_renamed = new com.oplus.camera.panorama.PanoramaProgressBar.RearPanoramaInterface() { // from class: com.oplus.camera.panorama.f_renamed.8
            @Override // com.oplus.camera.panorama.PanoramaProgressBar.RearPanoramaInterface
            public void onReportDirectionChange(int i2) {
                com.oplus.camera.panorama.f_renamed.this.f_renamed(i2);
            }
        };
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        if ("type_still_capture_yuv_main".equals(str)) {
            return false;
        }
        if ("type_preview_frame".equals(str)) {
            return true;
        }
        if ("type_tuning_data_yuv".equals(str)) {
            return false;
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getRearEnable() {
        return this.mCameraInterface.i_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return this.mCameraInterface.i_renamed() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FRONT_PANORAMA_SUPPORT);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "onInitCameraMode()");
        this.v_renamed = true;
        this.u_renamed = false;
        this.P_renamed = false;
        this.B_renamed = this.mActivity.getResources();
        k_renamed();
        this.M_renamed = this.mCameraInterface.u_renamed();
        this.M_renamed = this.mbFrontCamera ? this.M_renamed : 0;
        this.mCameraUIInterface.b_renamed(true);
        b_renamed(true);
        this.mCameraUIInterface.e_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO);
        this.mCameraUIInterface.b_renamed(2);
        this.mCameraUIInterface.c_renamed(this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_description_common_shutter_button));
        j_renamed();
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "onInitCameraMode X_renamed");
    }

    private void j_renamed() {
        com.oplus.camera.ui.a_renamed.a_renamed aVarK = this.mCameraUIInterface.k_renamed();
        if (aVarK != null) {
            aVarK.a_renamed(new com.oplus.camera.ui.a_renamed.a_renamed.b_renamed() { // from class: com.oplus.camera.panorama.f_renamed.11
                @Override // com.oplus.camera.ui.a_renamed.a_renamed.b_renamed
                public void a_renamed(com.oplus.camera.ui.a_renamed.b_renamed bVar) {
                    if (com.oplus.camera.panorama.f_renamed.this.mbFrontCamera && bVar.f_renamed) {
                        if (com.oplus.camera.panorama.f_renamed.this.t_renamed && com.oplus.camera.panorama.f_renamed.this.A_renamed != null && com.oplus.camera.panorama.f_renamed.this.A_renamed.isShown()) {
                            com.oplus.camera.panorama.f_renamed.this.A_renamed.setVisibility(8);
                        }
                        if (com.oplus.camera.panorama.f_renamed.this.t_renamed || com.oplus.camera.panorama.f_renamed.this.E_renamed == null || !com.oplus.camera.panorama.f_renamed.this.E_renamed.isShown()) {
                            return;
                        }
                        com.oplus.camera.panorama.f_renamed.this.E_renamed.b_renamed(false);
                    }
                }

                @Override // com.oplus.camera.ui.a_renamed.a_renamed.b_renamed
                public void a_renamed(int i2) {
                    if (com.oplus.camera.panorama.f_renamed.this.mbFrontCamera) {
                        if (com.oplus.camera.panorama.f_renamed.this.t_renamed && com.oplus.camera.panorama.f_renamed.this.A_renamed != null) {
                            com.oplus.camera.panorama.f_renamed.this.A_renamed.setVisibility(0);
                        }
                        if (com.oplus.camera.panorama.f_renamed.this.t_renamed || com.oplus.camera.panorama.f_renamed.this.E_renamed == null || com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface == null || com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.R_renamed()) {
                            return;
                        }
                        com.oplus.camera.panorama.f_renamed.this.E_renamed.a_renamed(new com.oplus.camera.ui.camerascreenhint.a_renamed.CameraScreenHintInfo_2().a_renamed(com.oplus.camera.panorama.f_renamed.this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_panorama_front_previewing)).a_renamed(true).b_renamed(false).a_renamed(com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg).b_renamed(com.oplus.camera.R_renamed.color.screen_hint_text_color).a_renamed());
                    }
                }
            });
        }
    }

    private void k_renamed() {
        this.s_renamed = com.oplus.camera.util.Util.N_renamed();
        this.j_renamed = com.oplus.camera.util.Util.u_renamed() ? (int) (com.oplus.camera.util.Util.getScreenHeight() / 1.3333333333333333d) : com.oplus.camera.util.Util.getScreenWidth();
        this.k_renamed = this.B_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.panorama_rect_height);
        this.l_renamed = this.B_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.panorama_rect_to_left);
        this.m_renamed = this.B_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.panorama_rect_to_top);
        this.n_renamed = this.B_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.panorama_progressbar_margin_top);
        this.o_renamed = this.B_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.panorama_progressbar_margin_left);
        this.r_renamed = this.B_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.panorama_view_gap);
        int i2 = this.k_renamed;
        this.T_renamed = i2 - (this.n_renamed * 2);
        this.q_renamed = ((this.m_renamed + i2) - this.s_renamed) - this.B_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.panorama_text_extra_offset);
        this.V_renamed = java.lang.Math.round(com.oplus.camera.util.Util.o_renamed() * 150.0f);
        if (this.D_renamed == null || com.oplus.camera.util.Util.t_renamed()) {
            android.view.LayoutInflater layoutInflaterFrom = android.view.LayoutInflater.from(this.mActivity);
            this.D_renamed = (android.widget.RelativeLayout) layoutInflaterFrom.inflate(this.B_renamed.getLayout(com.oplus.camera.R_renamed.layout.panorama), (android.view.ViewGroup) null);
            this.E_renamed = (com.oplus.camera.ui.camerascreenhint.CameraScreenHintView) layoutInflaterFrom.inflate(this.B_renamed.getLayout(com.oplus.camera.R_renamed.layout.camera_screen_hint), (android.view.ViewGroup) null);
            this.E_renamed.setChangeHintColor(true);
            this.E_renamed.setChangeHintTextShadow(true);
            this.E_renamed.setCameraScreenHintInterface(new com.oplus.camera.ui.camerascreenhint.b_renamed() { // from class: com.oplus.camera.panorama.f_renamed.12
                @Override // com.oplus.camera.ui.camerascreenhint.b_renamed
                public boolean a_renamed() {
                    return com.oplus.camera.panorama.f_renamed.this.isBottomGuideEntryViewShown();
                }
            });
            this.y_renamed = (android.widget.ImageView) this.D_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.preview_view);
            this.z_renamed = (com.oplus.camera.panorama.FrontPanoramaGuideView) this.D_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.capture_guide_view);
            this.z_renamed.setOnDirectionChangeListener(this.g_renamed);
            this.A_renamed = (android.widget.TextView) this.D_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.capture_guide_tips);
            this.I_renamed = new com.oplus.camera.panorama.PanoramaProgressBar(this.mActivity);
            this.I_renamed.setRearPanoramaInterface(this.h_renamed);
            this.I_renamed.setForceDarkAllowed(false);
            this.I_renamed.setContentDescription(this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_description_arrow_left_to_right));
            if (com.oplus.camera.util.Util.t_renamed()) {
                r_renamed();
            } else {
                this.I_renamed.setRectMarginLeft(0);
            }
            this.D_renamed.addView(this.E_renamed);
            this.D_renamed.addView(this.I_renamed);
            this.D_renamed.setVisibility(8);
            this.mCameraRootView.removeView(this.D_renamed);
            this.mCameraRootView.addView(this.D_renamed);
        }
        d_renamed(this.mCameraId);
        this.I_renamed.c_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onDeInitCameraMode(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "onDeInitCameraMode()");
        this.v_renamed = false;
        this.t_renamed = false;
        this.P_renamed = false;
        this.E_renamed.b_renamed(false);
        android.os.Handler handler = this.am_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        m_renamed();
        q_renamed();
        if (this.mOneCamera != null) {
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_SCENE_MODE, (android.hardware.camera2.CaptureRequest.Key) 0);
            this.mOneCamera.b_renamed(false, false);
            this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) false);
            this.mOneCamera.a_renamed(4, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
        }
        this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, (java.lang.String) null);
        this.mCameraUIInterface.b_renamed(1);
        com.oplus.camera.ui.a_renamed.a_renamed aVarK = this.mCameraUIInterface.k_renamed();
        if (aVarK != null) {
            aVarK.a_renamed((com.oplus.camera.ui.a_renamed.a_renamed.b_renamed) null);
        }
    }

    private void l_renamed() {
        if (this.D_renamed != null) {
            com.oplus.camera.panorama.PanoramaProgressBar panoramaProgressBar = this.I_renamed;
            if (panoramaProgressBar != null) {
                panoramaProgressBar.d_renamed();
                this.D_renamed.removeView(this.I_renamed);
                this.I_renamed = null;
            }
            if (this.E_renamed != null) {
                this.E_renamed = null;
            }
            if (this.y_renamed != null) {
                this.y_renamed = null;
            }
            com.oplus.camera.panorama.FrontPanoramaGuideView frontPanoramaGuideView = this.z_renamed;
            if (frontPanoramaGuideView != null) {
                frontPanoramaGuideView.b_renamed();
                this.z_renamed = null;
            }
            if (this.A_renamed != null) {
                this.A_renamed = null;
            }
            this.D_renamed.removeAllViews();
            this.mCameraRootView.removeView(this.D_renamed);
            this.D_renamed = null;
        }
        o_renamed();
    }

    private void m_renamed() {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "releaseRearPanorama");
        synchronized (i_renamed) {
            this.J_renamed = false;
            if (this.ac_renamed != null) {
                this.ac_renamed.a_renamed();
                this.ac_renamed.b_renamed();
                this.ac_renamed = null;
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "onResume");
        if (this.I_renamed != null) {
            if (com.oplus.camera.util.Util.t_renamed()) {
                r_renamed();
                this.I_renamed.a_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed, this.n_renamed, this.o_renamed);
            }
            this.I_renamed.c_renamed();
            this.I_renamed.postInvalidate();
        }
        android.widget.RelativeLayout relativeLayout = this.D_renamed;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
            this.D_renamed.setAlpha(1.0f);
        }
        if (this.mbFrontCamera) {
            b_renamed(8);
        }
        this.mCameraUIInterface.g_renamed(0);
        this.mCameraUIInterface.a_renamed(getShutterButtonInfo(), false);
        this.mCameraUIInterface.c_renamed(0);
        this.mCameraUIInterface.d_renamed(getFrontEnable() ? 0 : 4);
        this.mCameraUIInterface.f_renamed(0);
        this.mCameraUIInterface.b_renamed(0, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onCancelTakePicture() {
        this.am_renamed.removeCallbacksAndMessages(null);
        com.oplus.camera.panorama.PanoramaProgressBar panoramaProgressBar = this.I_renamed;
        if (panoramaProgressBar != null) {
            panoramaProgressBar.c_renamed();
            this.I_renamed.postInvalidate();
        }
        this.mCameraUIInterface.a_renamed(getShutterButtonInfo(), false);
        if (this.mbFrontCamera) {
            this.am_renamed.removeMessages(1);
            android.os.Handler handler = this.am_renamed;
            handler.sendMessage(handler.obtainMessage(1, true));
        } else {
            i_renamed();
        }
        this.t_renamed = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "onPause");
        if (this.t_renamed) {
            onCancelTakePicture();
        }
        m_renamed();
        c_renamed(4);
        this.y_renamed.setVisibility(4);
        this.mCameraUIInterface.g_renamed(0);
        if (this.mbFrontCamera) {
            this.E_renamed.b_renamed(false);
        }
        this.u_renamed = false;
        this.K_renamed = false;
        com.oplus.camera.panorama.d_renamed dVar = this.ak_renamed;
        if (dVar != null) {
            dVar.a_renamed();
            this.ak_renamed.b_renamed(false);
            this.ak_renamed.d_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        l_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        com.oplus.camera.panorama.d_renamed dVar = this.ak_renamed;
        if (dVar != null) {
            dVar.e_renamed();
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        if (this.J_renamed || this.t_renamed || this.mbFrontCamera || this.I_renamed == null) {
            return false;
        }
        this.am_renamed.removeMessages(4);
        this.am_renamed.sendEmptyMessageDelayed(4, com.google.android.exoplayer2.DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        return this.I_renamed.a_renamed(motionEvent);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "onBeforePreview");
        this.u_renamed = false;
        if (!this.mbFrontCamera) {
            this.am_renamed.removeMessages(3);
            this.am_renamed.obtainMessage(3, 0).sendToTarget();
        }
        this.mbEnableTuningData = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "onAfterStartPreview");
        final boolean z2 = this.aj_renamed != com.oplus.camera.util.Util.g_renamed();
        if (!this.u_renamed || z2) {
            this.aj_renamed = com.oplus.camera.util.Util.g_renamed();
            this.u_renamed = true;
            this.P_renamed = true;
            this.t_renamed = false;
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.panorama.f_renamed.13
                @Override // java.lang.Runnable
                public void run() throws android.content.res.Resources.NotFoundException {
                    if (com.oplus.camera.panorama.f_renamed.this.mbFrontCamera) {
                        if (com.oplus.camera.panorama.f_renamed.this.ak_renamed != null) {
                            com.oplus.camera.panorama.f_renamed.this.ak_renamed.a_renamed();
                        }
                        com.oplus.camera.panorama.f_renamed.this.a_renamed(true);
                        com.oplus.camera.panorama.f_renamed.this.p_renamed();
                        return;
                    }
                    com.oplus.camera.panorama.f_renamed fVar = com.oplus.camera.panorama.f_renamed.this;
                    fVar.G_renamed = fVar.getPreviewFrameSize(fVar.mOneCamera.e_renamed());
                    com.oplus.camera.panorama.f_renamed fVar2 = com.oplus.camera.panorama.f_renamed.this;
                    fVar2.Z_renamed = fVar2.G_renamed.getWidth() / 2;
                    com.oplus.camera.panorama.f_renamed fVar3 = com.oplus.camera.panorama.f_renamed.this;
                    fVar3.U_renamed = (fVar3.T_renamed * com.oplus.camera.panorama.f_renamed.this.G_renamed.getHeight()) / com.oplus.camera.panorama.f_renamed.this.G_renamed.getWidth();
                    com.oplus.camera.panorama.f_renamed fVar4 = com.oplus.camera.panorama.f_renamed.this;
                    fVar4.X_renamed = fVar4.G_renamed.getWidth() / 8;
                    com.oplus.camera.panorama.f_renamed fVar5 = com.oplus.camera.panorama.f_renamed.this;
                    fVar5.W_renamed = ((fVar5.G_renamed.getHeight() / 8) / 2) * 2;
                    com.oplus.camera.panorama.f_renamed.this.aa_renamed = r0.T_renamed / com.oplus.camera.panorama.f_renamed.this.X_renamed;
                    com.oplus.camera.panorama.f_renamed.this.Y_renamed = com.oplus.camera.util.Util.u_renamed() ? (int) (((com.oplus.camera.util.Util.getScreenHeight() / 1.3333333333333333d) - (com.oplus.camera.panorama.f_renamed.this.o_renamed * 2)) / com.oplus.camera.panorama.f_renamed.this.aa_renamed) : (int) ((com.oplus.camera.util.Util.getScreenWidth() - (com.oplus.camera.panorama.f_renamed.this.o_renamed * 2)) / com.oplus.camera.panorama.f_renamed.this.aa_renamed);
                    if (com.oplus.camera.util.Util.u_renamed()) {
                        com.oplus.camera.panorama.f_renamed.this.Z_renamed = (int) (r0.j_renamed / com.oplus.camera.panorama.f_renamed.this.aa_renamed);
                    }
                    com.oplus.camera.e_renamed.b_renamed("PanoramaCapMode", "onAfterStartPreview, mUpdateRectLimit: " + com.oplus.camera.panorama.f_renamed.this.Z_renamed + ", mRearThumbnailMaxWidth: " + com.oplus.camera.panorama.f_renamed.this.Y_renamed);
                    com.oplus.camera.panorama.f_renamed.this.ae_renamed.reset();
                    com.oplus.camera.panorama.f_renamed.this.ae_renamed.postRotate(90.0f);
                    com.oplus.camera.panorama.f_renamed.this.ae_renamed.postScale(com.oplus.camera.panorama.f_renamed.this.aa_renamed, com.oplus.camera.panorama.f_renamed.this.aa_renamed);
                    synchronized (com.oplus.camera.panorama.f_renamed.i_renamed) {
                        if (com.oplus.camera.panorama.f_renamed.this.ac_renamed == null || z2) {
                            com.oplus.camera.panorama.f_renamed.this.ac_renamed = new com.oplus.camera.panorama.g_renamed(com.oplus.camera.panorama.f_renamed.this.mActivity, com.oplus.camera.panorama.f_renamed.this.G_renamed.getWidth(), com.oplus.camera.panorama.f_renamed.this.G_renamed.getHeight(), com.oplus.camera.panorama.f_renamed.this);
                        }
                    }
                }
            });
            super.onAfterStartPreview(z_renamed);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSessionConfigured() {
        super.onSessionConfigured();
        this.mOneCamera.b_renamed(false, false);
        this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) false);
        this.mOneCamera.a_renamed(4, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "onBeforeSnapping, mOrientation: " + this.M_renamed);
        this.ag_renamed = true;
        if (this.mbFrontCamera) {
            com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "createEngine enter, mbPaused: " + this.mbPaused + ", mbStartPreviewed: " + this.u_renamed);
            if (this.ak_renamed != null && !this.mbPaused && this.u_renamed) {
                boolean z_renamed = this.mCameraInterface.u_renamed() % 180 == 0;
                this.N_renamed = this.mCameraInterface.u_renamed();
                this.ak_renamed.a_renamed(z_renamed);
            }
        }
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.panorama.f_renamed.14
            @Override // java.lang.Runnable
            public void run() {
                if (!com.oplus.camera.panorama.f_renamed.this.mbPaused) {
                    if (!com.oplus.camera.panorama.f_renamed.this.mbFrontCamera) {
                        synchronized (com.oplus.camera.panorama.f_renamed.i_renamed) {
                            if (com.oplus.camera.panorama.f_renamed.this.ac_renamed != null && com.oplus.camera.panorama.f_renamed.this.I_renamed != null) {
                                com.oplus.camera.panorama.f_renamed.this.am_renamed.removeMessages(4);
                                com.oplus.camera.panorama.f_renamed.this.ad_renamed = null;
                                com.oplus.camera.panorama.f_renamed.this.ab_renamed = 0;
                                com.oplus.camera.panorama.f_renamed.this.R_renamed = com.oplus.camera.panorama.f_renamed.this.I_renamed.getDirection();
                                com.oplus.camera.panorama.f_renamed.this.ac_renamed.a_renamed(com.oplus.camera.panorama.f_renamed.this.R_renamed);
                                com.oplus.camera.panorama.f_renamed.this.J_renamed = true;
                                com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.a_renamed(true, false);
                            }
                        }
                        com.oplus.camera.panorama.f_renamed.this.t_renamed = true;
                        com.oplus.camera.panorama.f_renamed fVar = com.oplus.camera.panorama.f_renamed.this;
                        fVar.setOrientation(fVar.M_renamed);
                        com.oplus.camera.panorama.f_renamed.this.b_renamed(0);
                        com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.b_renamed(4, true);
                    }
                    com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.g_renamed(4);
                    com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.d_renamed(4);
                    com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.f_renamed(4);
                    if (com.oplus.camera.panorama.f_renamed.this.isPanelMode()) {
                        com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.a_renamed(8, false);
                    } else {
                        com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.a_renamed(8, 1);
                    }
                    com.oplus.camera.ui.control.b_renamed bVar = com.oplus.camera.util.Util.ao_renamed() ? new com.oplus.camera.ui.control.b_renamed(5, "button_color_inside_hasselblad", "button_shape_ring_none", 3) : new com.oplus.camera.ui.control.b_renamed(10, "button_color_inside_none");
                    bVar.b_renamed(0);
                    com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.a_renamed(bVar);
                    return;
                }
                com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "onBeforeSnapping, return after pause");
            }
        });
        if (1 != this.mOneCamera.p_renamed()) {
            this.mOneCamera.n_renamed();
        }
        this.w_renamed = false;
        this.mOneCamera.b_renamed(true, false);
        this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) true);
        this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "onAfterSnapping");
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.panorama.f_renamed.15
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.panorama.f_renamed.this.mbFrontCamera) {
                    com.oplus.camera.panorama.f_renamed.this.E_renamed.b_renamed(true);
                    com.oplus.camera.panorama.f_renamed.this.mCameraInterface.c_renamed(com.oplus.camera.util.Util.ao_renamed() ? 6 : 4);
                    com.oplus.camera.panorama.f_renamed.this.z_renamed.setNextDirection(1);
                    com.oplus.camera.panorama.f_renamed.this.c_renamed(0);
                    com.oplus.camera.panorama.f_renamed.this.t_renamed = true;
                    return;
                }
                com.oplus.camera.panorama.f_renamed.this.E_renamed.a_renamed(com.oplus.camera.panorama.f_renamed.this.q_renamed, 0, 0, false);
                com.oplus.camera.panorama.f_renamed.this.E_renamed.clearAnimation();
                com.oplus.camera.panorama.f_renamed.this.E_renamed.a_renamed(new com.oplus.camera.ui.camerascreenhint.a_renamed.CameraScreenHintInfo_2().a_renamed(com.oplus.camera.panorama.f_renamed.this.mActivity.getResources().getString(com.oplus.camera.R_renamed.string.camera_panorama_rear_capturing)).a_renamed(false).b_renamed(true).a_renamed());
                com.oplus.camera.panorama.f_renamed.this.mCameraInterface.c_renamed(com.oplus.camera.util.Util.ao_renamed() ? 6 : 4);
                com.oplus.camera.panorama.f_renamed.this.K_renamed = true;
            }
        });
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getCanAddMenuOption(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            return false;
        }
        return super.getCanAddMenuOption(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewFrameSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        int i2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(hVar.a_renamed());
        if (this.mbFrontCamera && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_CONFIGURE_STREAM_SIZE_CUSTOM)) {
            com.oplus.ocs.camera.CameraDeviceInfo cameraDeviceInfoAE = this.mCameraInterface != null ? this.mCameraInterface.aE_renamed() : null;
            int[] iArr = cameraDeviceInfoAE != null ? (int[]) cameraDeviceInfoAE.get(com.oplus.camera.e_renamed.b_renamed.u_renamed) : null;
            if (iArr != null) {
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    if (i3 % 2 == 0 && (i2 = i3 + 1) < iArr.length) {
                        arrayList.add(new android.util.Size(iArr[i3], iArr[i2]));
                    }
                }
            }
        }
        if (this.mbFrontCamera || com.oplus.camera.util.Util.t_renamed()) {
            return com.oplus.camera.util.Util.b_renamed(arrayList, 1.3333333333333333d, com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FRONT_PANORAMA_MAX_HEIGHT));
        }
        int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_REAR_PANORAMA_MAX_HEIGHT);
        android.util.Size sizeB = com.oplus.camera.util.Util.b_renamed(arrayList, com.oplus.camera.util.Util.X_renamed(), configIntValue);
        return sizeB != null ? sizeB : com.oplus.camera.util.Util.c_renamed(arrayList, com.oplus.camera.util.Util.X_renamed(), configIntValue);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        if (this.mbFrontCamera || com.oplus.camera.util.Util.t_renamed()) {
            return com.oplus.camera.util.Util.b_renamed(hVar.a_renamed(256), 1.3333333333333333d);
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar, double d_renamed) {
        if (com.oplus.camera.util.Util.t_renamed()) {
            return super.getPreviewSize(hVar, 1.3333333333333333d);
        }
        return super.getPreviewSize(hVar, d_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar, java.lang.String str) {
        if (com.oplus.camera.util.Util.t_renamed()) {
            return super.getPreviewSize(hVar, 1.3333333333333333d);
        }
        return super.getPreviewSize(hVar, str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        if (com.oplus.camera.util.Util.t_renamed()) {
            return super.getPreviewSize(hVar, 1.3333333333333333d);
        }
        return super.getPreviewSize(hVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        if (this.mbFrontCamera) {
            return super.getZSLMode();
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAllowSwitch(com.oplus.camera.d_renamed.a_renamed aVar) {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "isAllowSwitch, mbStartPreviewed: " + this.u_renamed);
        if (this.P_renamed) {
            return !this.t_renamed && this.u_renamed;
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = super.getShutterButtonInfo();
        if (com.oplus.camera.util.Util.ao_renamed()) {
            shutterButtonInfo.a_renamed(23);
        }
        shutterButtonInfo.c_renamed("button_shape_ring_none");
        return shutterButtonInfo;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:41:0x0089  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 0
            r2 = 1
            switch(r0) {
                case -1724621691: goto L7f;
                case -1686959354: goto L75;
                case -821536541: goto L6a;
                case -260992230: goto L60;
                case -185556839: goto L56;
                case -8789275: goto L4b;
                case 336270991: goto L41;
                case 663120474: goto L37;
                case 1062270711: goto L2d;
                case 1599576324: goto L22;
                case 1705842515: goto L16;
                case 2118868211: goto Lb;
                default: goto L9;
            }
        L9:
            goto L89
        Lb:
            java.lang.String r0 = "pref_camera_tap_shutter_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L89
            r0 = r2
            goto L8a
        L16:
            java.lang.String r0 = "func_reset_auto_focus"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L89
            r0 = 9
            goto L8a
        L22:
            java.lang.String r0 = "pref_support_switch_camera"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L89
            r0 = 10
            goto L8a
        L2d:
            java.lang.String r0 = "pref_time_lapse_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L89
            r0 = 3
            goto L8a
        L37:
            java.lang.String r0 = "func_out_capture"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L89
            r0 = 7
            goto L8a
        L41:
            java.lang.String r0 = "pref_zoom_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L89
            r0 = 4
            goto L8a
        L4b:
            java.lang.String r0 = "pref_front_zoom_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L89
            r0 = 11
            goto L8a
        L56:
            java.lang.String r0 = "pref_camera_gesture_shutter_key"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L89
            r0 = 2
            goto L8a
        L60:
            java.lang.String r0 = "func_iot_capture"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L89
            r0 = 6
            goto L8a
        L6a:
            java.lang.String r0 = "func_out_preview_capture"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L89
            r0 = 8
            goto L8a
        L75:
            java.lang.String r0 = "pref_sstart_preview_sync"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L89
            r0 = r1
            goto L8a
        L7f:
            java.lang.String r0 = "pref_support_rotate_hint_view"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L89
            r0 = 5
            goto L8a
        L89:
            r0 = -1
        L8a:
            switch(r0) {
                case 0: goto Lbd;
                case 1: goto Lbc;
                case 2: goto Lbc;
                case 3: goto Lbc;
                case 4: goto Lbc;
                case 5: goto Lbc;
                case 6: goto Lbc;
                case 7: goto Lbc;
                case 8: goto Lbc;
                case 9: goto Lb3;
                case 10: goto Lac;
                case 11: goto L92;
                default: goto L8d;
            }
        L8d:
            boolean r3 = super.getSupportFunction(r4)
            return r3
        L92:
            boolean r4 = r3.mbFrontCamera
            if (r4 == 0) goto Lab
            java.lang.String r4 = "com.oplus.feature.front.camera.auto.zoom.support"
            boolean r4 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)
            if (r4 == 0) goto Lab
            com.oplus.camera.capmode.a_renamed r4 = r3.mCameraInterface
            if (r4 == 0) goto Lab
            com.oplus.camera.capmode.a_renamed r3 = r3.mCameraInterface
            boolean r3 = r3.i_renamed()
            if (r3 == 0) goto Lab
            return r2
        Lab:
            return r1
        Lac:
            java.lang.String r3 = "com.oplus.feature.front.panorama.support"
            boolean r3 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r3)
            return r3
        Lb3:
            com.oplus.camera.capmode.a_renamed r3 = r3.mCameraInterface
            int r3 = r3.g_renamed()
            if (r3 != r2) goto Lbc
            r1 = r2
        Lbc:
            return r1
        Lbd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.panorama.f_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        this.w_renamed = true;
        this.af_renamed = this.mCameraInterface.ah_renamed();
        if (this.mbFrontCamera) {
            com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "onStopTakePicture, mFrontJpegCount: " + this.O_renamed + ", mbSnapShoting: " + this.t_renamed);
            int i2 = this.O_renamed;
            if (i2 == 0) {
                return false;
            }
            if (this.t_renamed && i2 > 0) {
                this.t_renamed = false;
                this.Q_renamed = true;
                final com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed(11, "button_color_inside_none");
                bVar.b_renamed(0);
                this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.panorama.f_renamed.16
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.a_renamed(bVar);
                    }
                });
                com.oplus.camera.panorama.d_renamed dVar = this.ak_renamed;
                if (dVar != null) {
                    dVar.c_renamed();
                }
            }
            return true;
        }
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "onStopTakePicture, mbPanning: " + this.J_renamed + ", mbSnapShoting: " + this.t_renamed + ", mbRearCapturePicSaveDone: " + this.L_renamed);
        i_renamed();
        return this.t_renamed || this.I_renamed.e_renamed() || !this.L_renamed;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        if (this.mbFrontCamera) {
            this.mCameraUIInterface.d_renamed(true, false);
        }
    }

    public void b_renamed(int i2) {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "setProgressBarVisble, visible: " + i2);
        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView = this.E_renamed;
        if (cameraScreenHintView == null) {
            return;
        }
        if (i2 == 0) {
            cameraScreenHintView.a_renamed(this.q_renamed, 0, 0, false);
            java.lang.String string = this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_panorama_rear_prepare);
            if (this.E_renamed.getHintTextView().getVisibility() != 0 || !string.equals(this.E_renamed.getHintTextView().getText())) {
                this.E_renamed.clearAnimation();
                this.E_renamed.a_renamed(new com.oplus.camera.ui.camerascreenhint.a_renamed.CameraScreenHintInfo_2().a_renamed(string).a_renamed(false).b_renamed(false).a_renamed(com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg).b_renamed(com.oplus.camera.R_renamed.color.screen_hint_text_color).a_renamed());
            }
        } else {
            cameraScreenHintView.b_renamed(false);
        }
        com.oplus.camera.panorama.PanoramaProgressBar panoramaProgressBar = this.I_renamed;
        if (panoramaProgressBar == null || panoramaProgressBar.getVisibility() == i2) {
            return;
        }
        this.I_renamed.setVisibility(i2);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i2) {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "setOrientation(), orientation: " + i2);
        if (this.mbFrontCamera) {
            this.M_renamed = i2;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z_renamed) {
        this.mCameraUIInterface.a_renamed(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int i2) {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "cameraIdChanged, mCameraId: " + this.mCameraId);
        super.cameraIdChanged(i2);
        android.os.Handler handler = this.am_renamed;
        if (handler != null) {
            handler.removeMessages(3);
            this.am_renamed.removeMessages(4);
        }
        com.oplus.camera.panorama.PanoramaProgressBar panoramaProgressBar = this.I_renamed;
        if (panoramaProgressBar != null) {
            panoramaProgressBar.g_renamed();
        }
        m_renamed();
        q_renamed();
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.panorama.f_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.panorama.f_renamed.this.mbPaused) {
                    return;
                }
                com.oplus.camera.panorama.f_renamed fVar = com.oplus.camera.panorama.f_renamed.this;
                fVar.d_renamed(fVar.mCameraId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d_renamed(int i2) {
        com.oplus.camera.panorama.PanoramaProgressBar panoramaProgressBar = this.I_renamed;
        if (panoramaProgressBar != null) {
            panoramaProgressBar.a_renamed(this.j_renamed, this.k_renamed, this.l_renamed, this.m_renamed, this.n_renamed, this.o_renamed);
        }
        if (com.oplus.camera.e_renamed.a_renamed.a_renamed(i2)) {
            this.y_renamed.setImageBitmap(null);
            b_renamed(8);
            return;
        }
        this.y_renamed.setVisibility(8);
        this.M_renamed = 0;
        com.oplus.camera.panorama.PanoramaProgressBar panoramaProgressBar2 = this.I_renamed;
        if (panoramaProgressBar2 != null) {
            panoramaProgressBar2.postInvalidate();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onUpdateCameraSettingMenu() {
        this.mCameraUIInterface.e_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO);
        super.onUpdateCameraSettingMenu();
    }

    @Override // com.oplus.camera.panorama.d_renamed.a_renamed
    public void c_renamed() {
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.panorama.f_renamed.3
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.panorama.f_renamed.this.mCameraUIInterface.a_renamed(true, false);
                }
            });
        }
    }

    @Override // com.oplus.camera.panorama.d_renamed.a_renamed
    public void d_renamed() {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.c_renamed(com.oplus.camera.util.Util.ao_renamed() ? 7 : 5);
        }
    }

    @Override // com.oplus.camera.panorama.d_renamed.a_renamed
    public void a_renamed(boolean z_renamed, byte[] bArr, int i2, int i3) {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "onImageDataSave enter");
        if (bArr != null && this.mCameraInterface != null && this.H_renamed != null) {
            if (z_renamed) {
                i3 = i2;
                i2 = i3;
            }
            com.oplus.camera.Storage.CameraPicture cameraPicture = new com.oplus.camera.Storage.CameraPicture();
            cameraPicture.o_renamed = i2;
            cameraPicture.p_renamed = i3;
            cameraPicture.e_renamed = bArr;
            cameraPicture.h_renamed = getHeicCodecFormat() != null ? getHeicCodecFormat() : com.oplus.camera.statistics.model.CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG;
            cameraPicture.t_renamed = com.oplus.camera.util.Util.b_renamed(cameraPicture.e_renamed);
            cameraPicture.mPath = null;
            cameraPicture.D_renamed = true;
            cameraPicture.E_renamed = this.mbDisplayOnLock;
            cameraPicture.d_renamed = this.mCameraInterface.y_renamed();
            this.mCameraInterface.a_renamed(cameraPicture, true);
        }
        a_renamed();
        this.N_renamed = 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected com.oplus.camera.ui.control.e_renamed.c_renamed getAfterStoreRunnable() {
        return new com.oplus.camera.ui.control.e_renamed.c_renamed() { // from class: com.oplus.camera.panorama.f_renamed.4
            @Override // com.oplus.camera.ui.control.e_renamed.c_renamed
            public void a_renamed(long j_renamed) {
                com.oplus.camera.panorama.f_renamed.this.L_renamed = true;
            }
        };
    }

    public void a_renamed(boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        int dimensionPixelOffset;
        int dimensionPixelSize;
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "initFrontPanorama, mbPaused: " + this.mbPaused + ", mbStartPreviewed: " + this.u_renamed + ", mViewGroup: " + this.D_renamed);
        if (this.mbPaused || this.D_renamed == null || !this.u_renamed || this.mCameraUIInterface.R_renamed()) {
            return;
        }
        synchronized (this.C_renamed) {
            if (this.x_renamed != null) {
                this.x_renamed.recycle();
                this.x_renamed = null;
            }
        }
        this.O_renamed = 0;
        this.H_renamed = getPictureSize(this.mOneCamera.e_renamed());
        this.F_renamed = getPreviewFrameSize(this.mOneCamera.e_renamed());
        if (this.F_renamed != null) {
            synchronized (this.C_renamed) {
                if (com.oplus.camera.util.Util.t_renamed()) {
                    if (com.oplus.camera.util.Util.u_renamed()) {
                        dimensionPixelOffset = this.B_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.full_screen_panorama_front_preview_margin_top);
                    } else {
                        dimensionPixelOffset = this.B_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.out_screen_panorama_front_preview_margin_top);
                    }
                } else {
                    dimensionPixelOffset = this.r_renamed + this.s_renamed;
                }
                this.x_renamed = com.oplus.camera.util.Util.a_renamed((this.F_renamed.getHeight() * 2) / 6, this.F_renamed.getWidth() / 6, android.graphics.Bitmap.Config.ARGB_8888);
                int width = (int) (((this.x_renamed.getWidth() * 1.0f) * this.k_renamed) / this.x_renamed.getHeight());
                android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(width, this.k_renamed);
                layoutParams.addRule(10);
                layoutParams.addRule(9);
                layoutParams.topMargin = dimensionPixelOffset;
                layoutParams.leftMargin = (com.oplus.camera.util.Util.getScreenWidth() - width) / 2;
                if (z_renamed) {
                    this.y_renamed.setImageBitmap(null);
                }
                this.y_renamed.setLayoutParams(layoutParams);
                this.y_renamed.setVisibility(0);
            }
            this.D_renamed.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(14);
            if (com.oplus.camera.util.Util.u_renamed()) {
                dimensionPixelSize = this.B_renamed.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.full_screen_panorama_front_hint_margin_top);
            } else {
                dimensionPixelSize = this.B_renamed.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.front_panorama_guide_tips_margin_top) + this.s_renamed;
            }
            layoutParams2.topMargin = dimensionPixelSize;
            this.A_renamed.setLayoutParams(layoutParams2);
            com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "initFrontPanorama, mPictureSize: " + this.H_renamed.getWidth() + " x_renamed " + this.H_renamed.getHeight() + ", mPreviewFrameSize: " + this.F_renamed.getWidth() + " x_renamed " + this.F_renamed.getHeight());
        }
        this.E_renamed.a_renamed(this.p_renamed, 0, 0, false);
        com.oplus.camera.ui.camerascreenhint.a_renamed aVarA = new com.oplus.camera.ui.camerascreenhint.a_renamed.CameraScreenHintInfo_2().a_renamed(this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_panorama_front_previewing)).a_renamed(true).b_renamed(false).a_renamed(com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg).b_renamed(com.oplus.camera.R_renamed.color.screen_hint_text_color).a_renamed();
        this.E_renamed.setScreenLayoutParams(this.mCameraInterface.aU_renamed());
        this.E_renamed.a_renamed(aVarA);
        b_renamed(false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void hideViewWhileResume() {
        com.oplus.camera.panorama.PanoramaProgressBar panoramaProgressBar = this.I_renamed;
        if (panoramaProgressBar != null) {
            panoramaProgressBar.setVisibility(8);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void showLowMemory() {
        if (this.mbFrontCamera) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.panorama.f_renamed.5
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.panorama.f_renamed.this.E_renamed.a_renamed(new com.oplus.camera.ui.camerascreenhint.a_renamed.CameraScreenHintInfo_2().a_renamed(com.oplus.camera.panorama.f_renamed.this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_toast_camera_Low_memory_hint)).a_renamed(false).b_renamed(true).a_renamed());
                }
            });
        } else {
            this.mCameraUIInterface.a_renamed(com.oplus.camera.R_renamed.string.camera_toast_camera_Low_memory_hint, -1, true, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n_renamed() {
        if (this.u_renamed) {
            pictureTakenCallback(null, 0, 0, com.oplus.camera.util.Util.a_renamed(getImageFormat()), false, false, 0L, 0);
        }
        this.mCameraUIInterface.g_renamed(0);
        if (!this.Q_renamed && !this.mbPaused) {
            com.oplus.camera.ui.control.b_renamed bVar = new com.oplus.camera.ui.control.b_renamed(11, "button_color_inside_none");
            bVar.b_renamed(0);
            this.mCameraUIInterface.a_renamed(bVar);
        }
        this.Q_renamed = false;
        this.mCameraUIInterface.c_renamed(0);
        this.mCameraUIInterface.d_renamed(0);
        this.mCameraUIInterface.f_renamed(0);
        if (isPanelMode()) {
            this.mCameraUIInterface.a_renamed(0, true);
        } else {
            this.mCameraUIInterface.a_renamed(0, 1);
        }
        this.mOneCamera.b_renamed(false, false);
        this.mOneCamera.a_renamed((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, (android.hardware.camera2.CaptureRequest.Key) false);
        this.mOneCamera.a_renamed(4, com.oplus.camera.a_renamed.b_renamed(), com.oplus.camera.a_renamed.b_renamed(), true);
        this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        this.t_renamed = false;
        this.O_renamed = 0;
        c_renamed(4);
    }

    private void o_renamed() {
        synchronized (this.C_renamed) {
            if (this.x_renamed != null) {
                this.x_renamed.recycle();
                this.x_renamed = null;
            }
        }
    }

    public void c_renamed(final int i2) {
        android.view.animation.AlphaAnimation alphaAnimation;
        com.oplus.camera.panorama.FrontPanoramaGuideView frontPanoramaGuideView = this.z_renamed;
        if (frontPanoramaGuideView != null) {
            if (frontPanoramaGuideView.getVisibility() != i2) {
                if (i2 == 0) {
                    b_renamed(false);
                    alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
                } else {
                    alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.0f);
                }
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: com.oplus.camera.panorama.f_renamed.6
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(android.view.animation.Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(android.view.animation.Animation animation) {
                        if (i2 == 0) {
                            com.oplus.camera.panorama.f_renamed.this.z_renamed.setVisibility(i2);
                            com.oplus.camera.panorama.f_renamed.this.A_renamed.setVisibility(i2);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(android.view.animation.Animation animation) {
                        com.oplus.camera.panorama.f_renamed.this.z_renamed.setVisibility(i2);
                        com.oplus.camera.panorama.f_renamed.this.A_renamed.setVisibility(i2);
                    }
                });
                this.A_renamed.clearAnimation();
                this.A_renamed.startAnimation(alphaAnimation);
                this.z_renamed.clearAnimation();
                this.z_renamed.startAnimation(alphaAnimation);
                return;
            }
            android.view.animation.Animation animation = this.z_renamed.getAnimation();
            if (animation != null) {
                animation.reset();
                animation.cancel();
            }
            this.A_renamed.clearAnimation();
            this.A_renamed.setVisibility(i2);
            this.z_renamed.clearAnimation();
            this.z_renamed.setVisibility(i2);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int i2, boolean z_renamed) {
        super.changeModeAllViewWhenAnimation(i2, z_renamed);
        if (i2 == 2) {
            if (z_renamed) {
                com.oplus.camera.util.Util.a_renamed(this.D_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
                return;
            }
            this.E_renamed.b_renamed(false);
            b_renamed(true);
            this.D_renamed.setVisibility(8);
            return;
        }
        if (i2 == 5) {
            if (z_renamed) {
                if (this.mbFrontCamera) {
                    return;
                }
                b_renamed(0);
                return;
            }
            b_renamed(8);
            return;
        }
        if (i2 == 18) {
            if (z_renamed) {
                return;
            }
            com.oplus.camera.util.Util.a_renamed(this.D_renamed, 8, (android.view.animation.Animation.AnimationListener) null, 300L);
        } else if (i2 == 19 && z_renamed) {
            com.oplus.camera.util.Util.a_renamed(this.D_renamed, 0, (android.view.animation.Animation.AnimationListener) null, 300L);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        com.oplus.camera.panorama.PanoramaProgressBar panoramaProgressBar;
        if (dcsMsgData == null || !(dcsMsgData instanceof com.oplus.camera.statistics.model.CaptureMsgData)) {
            return null;
        }
        com.oplus.camera.statistics.model.CaptureMsgData captureMsgData = (com.oplus.camera.statistics.model.CaptureMsgData) dcsMsgData;
        captureMsgData.mShutterType = getCameraShutterType();
        if (this.mbFrontCamera || (panoramaProgressBar = this.I_renamed) == null) {
            return captureMsgData;
        }
        captureMsgData.mPanoramaDirection = e_renamed(panoramaProgressBar.getDirection());
        captureMsgData.mAeAfLock = java.lang.String.valueOf(this.mCameraInterface.ae_renamed());
        captureMsgData.mTouchXYValue = this.mCameraInterface.af_renamed();
        return captureMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        android.hardware.camera2.CaptureResult.Key<int[]> key;
        java.lang.Object obj;
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            com.oplus.camera.e_renamed.f_renamed("PanoramaCapMode", "onPreviewCaptureResult, invalid previewResult: " + cameraPreviewResult);
            return;
        }
        if (this.ag_renamed) {
            this.ag_renamed = false;
            android.hardware.camera2.CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
            if (com.oplus.camera.util.Util.C_renamed()) {
                key = com.oplus.camera.e_renamed.b_renamed.T_renamed;
                obj = com.oplus.camera.e_renamed.b_renamed.U_renamed;
            } else {
                key = com.oplus.camera.e_renamed.b_renamed.ah_renamed;
                obj = com.oplus.camera.e_renamed.b_renamed.W_renamed;
            }
            if (key != null) {
                try {
                    this.ah_renamed = ((int[]) captureResult.get(key))[0];
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
            if (obj != null) {
                try {
                    this.ai_renamed = ((float[]) captureResult.get(obj))[0];
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetAfterCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData, com.oplus.camera.Storage.CameraPicture cameraPicture) {
        if (dcsMsgData != null && (dcsMsgData instanceof com.oplus.camera.statistics.model.CaptureMsgData)) {
            com.oplus.camera.statistics.model.CaptureMsgData captureMsgData = (com.oplus.camera.statistics.model.CaptureMsgData) dcsMsgData;
            if (this.w_renamed) {
                captureMsgData.mShutterType += com.oplus.camera.statistics.model.DcsMsgData.DIVIDER + this.af_renamed;
            } else {
                captureMsgData.mShutterType += "|end";
            }
            android.util.Size sizeA = com.oplus.camera.Storage.a_renamed(com.oplus.camera.util.Util.a_renamed(cameraPicture.e_renamed));
            if (sizeA != null) {
                captureMsgData.mWidth = java.lang.String.valueOf(sizeA.getWidth());
                captureMsgData.mHeight = java.lang.String.valueOf(sizeA.getHeight());
            }
            captureMsgData.mCCT = java.lang.String.valueOf(this.ah_renamed);
            captureMsgData.mLux = java.lang.String.valueOf(this.ai_renamed);
        }
        return super.onGetAfterCaptureMsgCommonData(dcsMsgData, cameraPicture);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getPhotoRatio() {
        if (this.mbFrontCamera) {
            return this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_picture_size_standard);
        }
        return this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_picture_size_full);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getSwitchAnimTime(int i2) {
        if (com.oplus.camera.e_renamed.a_renamed.a_renamed(i2)) {
            return com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PANORAMA_TO_REAL_SWITCH_ANIM_TIME);
        }
        return com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PANORAMA_TO_FRONT_SWITCH_ANIM_TIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f_renamed(int i2) {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(false);
        menuClickMsgData.mCaptureMode = com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA;
        menuClickMsgData.mCaptureType = 0;
        menuClickMsgData.mFuncKeyId = 19;
        menuClickMsgData.mOrientation = this.M_renamed;
        menuClickMsgData.mFuncKeyResult = i2;
        menuClickMsgData.mRearOrFront = this.mbFrontCamera ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
        menuClickMsgData.report();
    }

    public void b_renamed(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            com.oplus.camera.e_renamed.f_renamed("PanoramaCapMode", "sendToUpdateGuideBitmap error, bitmap is_renamed null");
            return;
        }
        android.os.Handler handler = this.am_renamed;
        if (handler != null) {
            handler.removeMessages(2);
            android.os.Message messageObtainMessage = this.am_renamed.obtainMessage(2);
            messageObtainMessage.obj = bitmap;
            messageObtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p_renamed() {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "initFrontManager enter");
        this.ak_renamed = new com.oplus.camera.panorama.d_renamed(this.mActivity, this.F_renamed, android.text.TextUtils.equals(getMirror(), "on_renamed"), this, getCameraInfo(this.mCameraId).j_renamed());
    }

    private void q_renamed() {
        com.oplus.camera.panorama.d_renamed dVar = this.ak_renamed;
        if (dVar != null) {
            dVar.a_renamed();
            this.ak_renamed.d_renamed();
        }
    }

    @Override // com.oplus.camera.panorama.d_renamed.a_renamed
    public int e_renamed() {
        int i2 = this.N_renamed;
        return (i2 + (i2 % 180 == 0 ? 180 : 90)) % 360;
    }

    @Override // com.oplus.camera.panorama.d_renamed.a_renamed
    public boolean f_renamed() {
        return getHeicCodecFormat() != null;
    }

    @Override // com.oplus.camera.panorama.d_renamed.a_renamed
    public void a_renamed(int i2) {
        com.oplus.camera.panorama.FrontPanoramaGuideView frontPanoramaGuideView = this.z_renamed;
        if (frontPanoramaGuideView != null) {
            frontPanoramaGuideView.setNextDirection(i2);
        }
    }

    @Override // com.oplus.camera.panorama.d_renamed.a_renamed
    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("PanoramaCapMode", "sendFrontResetMessage enter");
        if (this.am_renamed == null || this.mbPaused) {
            return;
        }
        this.am_renamed.removeMessages(1);
        android.os.Handler handler = this.am_renamed;
        handler.sendMessage(handler.obtainMessage(1, false));
    }

    @Override // com.oplus.camera.panorama.d_renamed.a_renamed
    public void a_renamed(android.graphics.Bitmap bitmap) {
        b_renamed(bitmap);
    }

    @Override // com.oplus.camera.panorama.d_renamed.a_renamed
    public void b_renamed() {
        this.O_renamed++;
    }

    private boolean c_renamed(com.arcsoft.camera.burstpmk.ProcessResult processResult) {
        return (3 != this.R_renamed ? !(2 != this.R_renamed || processResult.updateSmallImageRect.bottom >= this.Y_renamed) : this.Z_renamed - processResult.updateSmallImageRect.top < this.Y_renamed) && java.lang.Math.abs(processResult.outputOffset.x_renamed - this.ab_renamed) < this.V_renamed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2, android.graphics.Rect rect) {
        if (3 == this.R_renamed) {
            float f_renamed = this.Z_renamed - rect.top;
            float f2 = this.aa_renamed;
            android.graphics.Bitmap bitmapA = com.oplus.camera.util.Util.a_renamed((int) (f_renamed * f2), (int) (this.X_renamed * f2), android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapA);
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (android.graphics.Paint) null);
            }
            canvas.drawBitmap(bitmap2, (int) ((this.Z_renamed - rect.bottom) * this.aa_renamed), rect.left * this.aa_renamed, (android.graphics.Paint) null);
            canvas.save();
            canvas.restore();
            return bitmapA;
        }
        if (2 != this.R_renamed) {
            return null;
        }
        float f3 = rect.bottom;
        float f4 = this.aa_renamed;
        android.graphics.Bitmap bitmapA2 = com.oplus.camera.util.Util.a_renamed((int) (f3 * f4), (int) (this.X_renamed * f4), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas2 = new android.graphics.Canvas(bitmapA2);
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas2.drawBitmap(bitmap, bitmapA2.getWidth() - bitmap.getWidth(), 0.0f, (android.graphics.Paint) null);
        }
        canvas2.drawBitmap(bitmap2, 0.0f, rect.left * this.aa_renamed, (android.graphics.Paint) null);
        canvas2.save();
        canvas2.restore();
        return bitmapA2;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        this.y_renamed.setVisibility(8);
        b_renamed(8);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i2) {
        super.onMoreModeHidden(i2);
        if (com.oplus.camera.e_renamed.a_renamed.a_renamed(this.mCameraId) && 1 != i2) {
            this.y_renamed.setVisibility(0);
            this.E_renamed.a_renamed(new com.oplus.camera.ui.camerascreenhint.a_renamed.CameraScreenHintInfo_2().a_renamed(this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_panorama_front_previewing)).a_renamed(true).b_renamed(false).a_renamed(com.oplus.camera.R_renamed.drawable.screen_hint_textview_bg).b_renamed(com.oplus.camera.R_renamed.color.screen_hint_text_color).a_renamed());
            b_renamed(false);
            return;
        }
        b_renamed(0);
    }

    private void b_renamed(boolean z_renamed) {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.a_renamed(true, true, z_renamed);
        }
    }

    private void r_renamed() {
        android.content.res.Resources resources = com.oplus.camera.MyApplication.d_renamed().getResources();
        if (com.oplus.camera.util.Util.u_renamed()) {
            this.j_renamed = (int) (com.oplus.camera.util.Util.getScreenHeight() / 1.3333333333333333d);
            this.m_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.full_screen_panorama_rect_margin_top);
            this.l_renamed = (com.oplus.camera.util.Util.getScreenWidth() - this.j_renamed) / 2;
        } else {
            this.j_renamed = com.oplus.camera.util.Util.getScreenWidth();
            this.m_renamed = resources.getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.out_screen_panorama_rect_margin_top);
            this.l_renamed = 0;
        }
        this.k_renamed = this.mActivity.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.panorama_rect_height);
        this.I_renamed.setRectMarginLeft(this.l_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.screen.f_renamed.a_renamed getPreferredScreenMode(int i2) {
        if (!com.oplus.camera.util.Util.u_renamed()) {
            return com.oplus.camera.screen.f_renamed.a_renamed.out;
        }
        return com.oplus.camera.screen.f_renamed.a_renamed.full;
    }
}
