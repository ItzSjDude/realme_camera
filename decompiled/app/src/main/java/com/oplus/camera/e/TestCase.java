package com.oplus.camera.e_renamed;

/* compiled from: OneCameraImpl.java */
/* loaded from: classes2.dex */
public class e_renamed extends com.oplus.camera.e_renamed.g_renamed {
    private com.oplus.ocs.camera.CameraUnitClient A_renamed;
    private com.oplus.ocs.camera.CameraDevice B_renamed;
    private com.oplus.camera.e_renamed.d_renamed.e_renamed C_renamed;
    private com.oplus.camera.e_renamed.h_renamed D_renamed;
    private com.oplus.camera.e_renamed.d_renamed.OneCamera_5 E_renamed;
    private com.oplus.camera.e_renamed.d_renamed.a_renamed F_renamed;
    private com.oplus.camera.e_renamed.b_renamed G_renamed;
    private java.util.LinkedHashMap<java.lang.String, android.view.Surface> H_renamed;
    private boolean I_renamed;
    private boolean J_renamed;
    private int K_renamed;
    private java.lang.String L_renamed;
    private boolean M_renamed;
    private boolean N_renamed;
    private boolean O_renamed;
    private boolean P_renamed;
    private int Q_renamed;
    private int R_renamed;
    private int S_renamed;
    private int T_renamed;
    private int U_renamed;
    private int V_renamed;
    private android.media.ImageWriter W_renamed;
    private com.oplus.camera.e_renamed.c_renamed X_renamed;
    private boolean Y_renamed;
    private com.oplus.camera.e_renamed.e_renamed.a_renamed Z_renamed;
    private android.os.ConditionVariable aa_renamed;
    private android.os.ConditionVariable ab_renamed;
    private android.os.ConditionVariable ac_renamed;
    private android.os.ConditionVariable ad_renamed;
    private final android.os.ConditionVariable ae_renamed;
    private com.oplus.camera.v_renamed.c_renamed af_renamed;
    private boolean ag_renamed;
    private volatile boolean ah_renamed;
    private com.oplus.camera.e_renamed.d_renamed.c_renamed ai_renamed;
    private int aj_renamed;
    private com.oplus.ocs.camera.CameraPictureCallback ak_renamed;
    private final com.oplus.ocs.camera.CameraPreviewCallback al_renamed;
    private final com.oplus.camera.c_renamed.a_renamed am_renamed;
    private final com.oplus.camera.e_renamed.a_renamed.a_renamed an_renamed;
    private final java.lang.Object z_renamed;

    static /* synthetic */ int e_renamed(com.oplus.camera.e_renamed.e_renamed eVar, int i_renamed) {
        int i2 = eVar.U_renamed + i_renamed;
        eVar.U_renamed = i2;
        return i2;
    }

    public e_renamed(int i_renamed) {
        super(i_renamed);
        this.z_renamed = new java.lang.Object();
        this.A_renamed = null;
        this.B_renamed = null;
        this.C_renamed = null;
        this.D_renamed = null;
        this.E_renamed = null;
        this.F_renamed = null;
        this.G_renamed = null;
        this.H_renamed = null;
        this.I_renamed = false;
        this.J_renamed = true;
        this.K_renamed = 0;
        this.L_renamed = "off";
        this.M_renamed = false;
        this.N_renamed = false;
        this.O_renamed = true;
        this.P_renamed = true;
        this.Q_renamed = 4;
        this.R_renamed = 1;
        this.S_renamed = 1;
        this.T_renamed = 0;
        this.U_renamed = 0;
        this.V_renamed = 0;
        this.W_renamed = null;
        this.X_renamed = null;
        this.Y_renamed = false;
        this.Z_renamed = new com.oplus.camera.e_renamed.e_renamed.a_renamed();
        this.aa_renamed = new android.os.ConditionVariable();
        this.ab_renamed = new android.os.ConditionVariable();
        this.ac_renamed = new android.os.ConditionVariable();
        this.ad_renamed = new android.os.ConditionVariable();
        this.ae_renamed = new android.os.ConditionVariable(true);
        this.af_renamed = null;
        this.ag_renamed = false;
        this.ah_renamed = false;
        this.ai_renamed = null;
        this.aj_renamed = 0;
        this.ak_renamed = null;
        this.al_renamed = new com.oplus.ocs.camera.CameraPreviewCallback() { // from class: com.oplus.camera.e_renamed.e_renamed.4
            @Override // com.oplus.ocs.camera.CameraPreviewCallback
            public void onPreviewMetaReceived(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
                int i2;
                java.lang.String str;
                if (cameraPreviewResult != null) {
                    com.oplus.camera.e_renamed.a_renamed("CameraPreviewCallback.onPreviewMetaReceived", "55pv_PreviewMetaReceived", cameraPreviewResult.getCaptureResult() != null ? cameraPreviewResult.getCaptureResult().getFrameNumber() : 1L);
                    str = (java.lang.String) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_CAMERA_TYPE);
                    i2 = (com.oplus.camera.e_renamed.a_renamed.c_renamed(com.oplus.camera.e_renamed.e_renamed.this.aj_renamed) && (com.oplus.ocs.camera.CameraUnitClient.CameraType.FRONT_MAIN.equals(str) || com.oplus.ocs.camera.CameraUnitClient.CameraType.FRONT_WIDE.equals(str))) ? 2 : 1;
                } else {
                    i2 = 1;
                    str = null;
                }
                if ((!com.oplus.camera.e_renamed.e_renamed.this.I_renamed || !com.oplus.camera.e_renamed.e_renamed.this.J_renamed) && cameraPreviewResult != null) {
                    com.oplus.camera.e_renamed.a_renamed("CameraStartupPerformance.onFirstFrameArrived");
                    if (!com.oplus.camera.e_renamed.a_renamed.c_renamed(com.oplus.camera.e_renamed.e_renamed.this.aj_renamed) || (!com.oplus.ocs.camera.CameraUnitClient.CameraType.FRONT_MAIN.equals(str) && !com.oplus.ocs.camera.CameraUnitClient.CameraType.FRONT_WIDE.equals(str))) {
                        com.oplus.camera.e_renamed.e_renamed.this.I_renamed = true;
                    } else {
                        com.oplus.camera.e_renamed.e_renamed.this.J_renamed = true;
                    }
                    com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "CameraPreviewCallback, onPreviewMetaReceived, first frame arrive, mCameraRole: " + i2 + ", mPreviewRequestHash: " + com.oplus.camera.e_renamed.e_renamed.this.K_renamed);
                    com.oplus.camera.e_renamed.e_renamed.this.ac_renamed.open();
                    if (com.oplus.camera.e_renamed.e_renamed.this.ai_renamed != null) {
                        com.oplus.camera.e_renamed.e_renamed.this.ai_renamed.a_renamed(cameraPreviewResult.getCaptureResult(), i2, (java.lang.String) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_CAMERA_MODE));
                    }
                    com.oplus.camera.e_renamed.b_renamed("CameraStartupPerformance.onFirstFrameArrived");
                }
                if (com.oplus.camera.e_renamed.e_renamed.this.ai_renamed != null && cameraPreviewResult != null) {
                    com.oplus.camera.e_renamed.e_renamed.this.ai_renamed.a_renamed(cameraPreviewResult.getCaptureResult());
                }
                if (cameraPreviewResult != null) {
                    if (com.oplus.camera.e_renamed.e_renamed.this.ai_renamed != null) {
                        com.oplus.camera.e_renamed.e_renamed.this.ai_renamed.a_renamed(cameraPreviewResult);
                    }
                    if (cameraPreviewResult.getCaptureResult() != null) {
                        java.lang.Object obj = cameraPreviewResult.get((android.hardware.camera2.CaptureResult.Key<java.lang.Object>) android.hardware.camera2.CaptureResult.CONTROL_AF_MODE);
                        if (obj instanceof java.lang.Integer) {
                            com.oplus.camera.e_renamed.e_renamed.this.Q_renamed = ((java.lang.Integer) obj).intValue();
                        }
                        java.lang.Object obj2 = cameraPreviewResult.get((android.hardware.camera2.CaptureResult.Key<java.lang.Object>) android.hardware.camera2.CaptureResult.CONTROL_AE_MODE);
                        if (obj2 instanceof java.lang.Integer) {
                            com.oplus.camera.e_renamed.e_renamed.this.R_renamed = ((java.lang.Integer) obj2).intValue();
                        }
                    }
                    if (com.oplus.camera.e_renamed.e_renamed.this.am_renamed != null) {
                        com.oplus.camera.e_renamed.e_renamed.this.am_renamed.a_renamed(null, null, cameraPreviewResult.getCaptureResult());
                    }
                    if (com.oplus.camera.e_renamed.e_renamed.this.an_renamed != null) {
                        com.oplus.camera.e_renamed.e_renamed.this.an_renamed.a_renamed(null, null, cameraPreviewResult.getCaptureResult());
                    }
                    if (com.oplus.camera.e_renamed.e_renamed.this.ai_renamed != null) {
                        com.oplus.camera.e_renamed.e_renamed.this.ai_renamed.a_renamed(null, null, cameraPreviewResult.getCaptureResult(), i2);
                    }
                    com.oplus.camera.e_renamed.d_renamed("CameraPreviewCallback.onPreviewMetaReceived", "55pv_PreviewMetaReceived");
                }
            }

            @Override // com.oplus.ocs.camera.CameraPreviewCallback
            public void onPreviewReceived(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
                if (com.oplus.camera.e_renamed.e_renamed.this.ai_renamed == null || cameraPreviewResult == null) {
                    return;
                }
                com.oplus.camera.e_renamed.a_renamed("CameraPreviewCallback.onPreviewReceived", "58pv_PreviewReceived TS", cameraPreviewResult.getCaptureResult() != null ? ((java.lang.Long) cameraPreviewResult.get(com.oplus.ocs.camera.CameraParameter.PREVIEW_RESULT_IMAGE_TIME_STAMP)).longValue() : 1L);
                com.oplus.camera.e_renamed.e_renamed.this.ai_renamed.b_renamed(cameraPreviewResult);
                com.oplus.camera.e_renamed.d_renamed("CameraPreviewCallback.onPreviewReceived", "58pv_PreviewReceived TS");
            }

            @Override // com.oplus.ocs.camera.CameraPreviewCallback
            public void onVideoReceived(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
                if (com.oplus.camera.e_renamed.e_renamed.this.ai_renamed != null) {
                    com.oplus.camera.e_renamed.a_renamed("CameraPreviewCallback.onVideoReceived", "60pv_VideoReceived", com.oplus.camera.d_renamed.d_renamed.longValue());
                    com.oplus.camera.e_renamed.e_renamed.this.ai_renamed.a_renamed(new com.oplus.camera.aps.util.CameraApsResult(cameraPreviewResult));
                    com.oplus.camera.e_renamed.d_renamed("CameraPreviewCallback.onVideoReceived", "60pv_VideoReceived");
                }
            }

            @Override // com.oplus.ocs.camera.CameraPreviewCallback
            public void onPreviewFrameReceived(android.media.Image image) {
                if (com.oplus.camera.e_renamed.e_renamed.this.ai_renamed != null) {
                    com.oplus.camera.e_renamed.a_renamed("CameraPreviewCallback.onPreviewFrameReceived size: " + image.getWidth() + "x_renamed" + image.getHeight(), "60pv_PreviewFrameReceived", com.oplus.camera.d_renamed.d_renamed.longValue());
                    com.oplus.camera.e_renamed.e_renamed.this.ai_renamed.a_renamed(image);
                    com.oplus.camera.e_renamed.d_renamed("CameraPreviewCallback.onPreviewFrameReceived size: " + image.getWidth() + "x_renamed" + image.getHeight(), "60pv_PreviewFrameReceived");
                }
            }

            @Override // com.oplus.ocs.camera.CameraPreviewCallback
            public void onPreviewCaptureProgressed(android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.CaptureResult captureResult) {
                if (com.oplus.camera.e_renamed.e_renamed.this.ai_renamed != null) {
                    com.oplus.camera.e_renamed.a_renamed("CameraPreviewCallback.onPreviewCaptureProgressed", "52pv_PreviewCaptureProgressed", captureResult.getFrameNumber());
                    com.oplus.camera.e_renamed.e_renamed.this.ai_renamed.a_renamed((android.hardware.camera2.CameraCaptureSession) null, captureRequest, captureResult);
                    com.oplus.camera.e_renamed.d_renamed("CameraPreviewCallback.onPreviewCaptureProgressed", "52pv_PreviewCaptureProgressed");
                }
            }

            @Override // com.oplus.ocs.camera.CameraPreviewCallback
            public void onHalPreviewCollected(long j_renamed) {
                com.oplus.camera.e_renamed.e_renamed.this.ai_renamed.a_renamed(j_renamed);
            }

            @Override // com.oplus.ocs.camera.CameraPreviewCallback
            public java.util.Map<java.lang.String, java.lang.Object> generateImageInfo(android.media.Image image) {
                if (com.oplus.camera.e_renamed.e_renamed.this.ai_renamed != null) {
                    return com.oplus.camera.e_renamed.e_renamed.this.ai_renamed.b_renamed(image);
                }
                return null;
            }
        };
        this.am_renamed = new com.oplus.camera.c_renamed.a_renamed() { // from class: com.oplus.camera.e_renamed.e_renamed.5
            @Override // com.oplus.camera.c_renamed.a_renamed
            public void a_renamed() {
                com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "mApertureControllerCallback, mCameraRole: " + com.oplus.camera.e_renamed.e_renamed.this.w_renamed + ", onApertureSwitchDone, needCapture: " + b_renamed());
                if (!b_renamed() || com.oplus.camera.e_renamed.e_renamed.this.F_renamed == null) {
                    return;
                }
                a_renamed(false);
                com.oplus.camera.e_renamed.e_renamed eVar = com.oplus.camera.e_renamed.e_renamed.this;
                eVar.a_renamed(eVar.S_renamed, com.oplus.camera.e_renamed.e_renamed.this.X_renamed, com.oplus.camera.e_renamed.e_renamed.this.F_renamed);
            }
        };
        this.an_renamed = new com.oplus.camera.e_renamed.a_renamed.a_renamed() { // from class: com.oplus.camera.e_renamed.e_renamed.6
            @Override // com.oplus.camera.e_renamed.a_renamed.a_renamed
            public void a_renamed() {
                com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "mZoomStateCallback, onZoomChangeDone, mCameraRole: " + com.oplus.camera.e_renamed.e_renamed.this.w_renamed + ", needCapture: " + b_renamed());
                if (com.oplus.camera.e_renamed.e_renamed.this.C_renamed != null) {
                    com.oplus.camera.e_renamed.e_renamed.this.C_renamed.a_renamed(b_renamed());
                    if (b_renamed()) {
                        a_renamed(false);
                    }
                }
            }
        };
    }

    @Override // com.oplus.camera.e_renamed.g_renamed
    protected void a_renamed(final int i_renamed, final com.oplus.camera.e_renamed.d_renamed.b_renamed bVar) {
        if (this.u_renamed != 3) {
            com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "openCameraDevice, mCameraRole: " + this.w_renamed + ", mDeviceState: " + this.u_renamed);
            if (this.u_renamed != 2) {
                return;
            }
            com.oplus.camera.e_renamed.b_renamed("OneCameraImpl", "openCameraDevice, mDeviceState now is_renamed closing, block to device to closed.");
            this.aa_renamed.block();
        }
        try {
            B_renamed(0);
            this.aa_renamed.close();
            if (this.A_renamed == null) {
                this.A_renamed = com.oplus.ocs.camera.CameraUnit.getCameraClient(com.oplus.camera.util.Util.l_renamed());
            }
            com.oplus.camera.perf.b_renamed.c_renamed("launch_open_camera");
            com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "openCamera start, mCameraRole: " + this.w_renamed + ", cameraId: " + i_renamed);
            com.oplus.camera.e_renamed.a_renamed("CameraStartupPerformance.openCamera");
            this.A_renamed.openCamera(com.oplus.camera.e_renamed.a_renamed.b_renamed(i_renamed), new com.oplus.ocs.camera.CameraStateCallback() { // from class: com.oplus.camera.e_renamed.e_renamed.1
                @Override // com.oplus.ocs.camera.CameraStateCallback
                public void onCameraOpened(com.oplus.ocs.camera.CameraDevice cameraDevice) {
                    com.oplus.camera.perf.b_renamed.c_renamed("launch_camera_opened");
                    com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "onCameraOpened, mCameraNum: " + com.oplus.camera.e_renamed.e_renamed.this.w_renamed + ", cameraDevic: " + cameraDevice);
                    com.oplus.camera.e_renamed.a_renamed("CameraStartupPerformance.onCameraOpened");
                    com.oplus.camera.e_renamed.e_renamed.this.aj_renamed = i_renamed;
                    com.oplus.camera.w_renamed.a_renamed.a_renamed().a_renamed(com.oplus.camera.util.Util.l_renamed(), "connected_camera_ids", java.lang.String.valueOf(i_renamed));
                    com.oplus.camera.w_renamed.a_renamed.a_renamed().a_renamed(com.oplus.camera.util.Util.l_renamed(), "active_camera_type", com.oplus.camera.e_renamed.a_renamed.b_renamed(i_renamed));
                    com.oplus.camera.e_renamed.e_renamed.this.B_renamed = cameraDevice;
                    if (!com.oplus.camera.util.Util.C_renamed()) {
                        try {
                            com.oplus.camera.e_renamed.e_renamed.this.ag_renamed = com.oplus.camera.e_renamed.e_renamed.this.D_renamed.f_renamed() == 1;
                            com.oplus.camera.e_renamed.b_renamed("OneCameraImpl", "onCameraOpened, mbMtkLowMemoryPlatform: " + com.oplus.camera.e_renamed.e_renamed.this.ag_renamed);
                        } catch (java.lang.IllegalArgumentException e_renamed) {
                            com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "onCameraOpened, exception: " + e_renamed.getMessage());
                        }
                    }
                    com.oplus.camera.e_renamed.e_renamed.this.B_renamed(1);
                    com.oplus.camera.e_renamed.e_renamed.this.aa_renamed.open();
                    com.oplus.camera.e_renamed.b_renamed("CameraStartupPerformance.onCameraOpened");
                }

                @Override // com.oplus.ocs.camera.CameraStateCallback
                public void onCameraClosed() {
                    com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "onCameraClosed, mCameraRole: " + com.oplus.camera.e_renamed.e_renamed.this.w_renamed);
                    com.oplus.camera.w_renamed.a_renamed.a_renamed().c_renamed();
                    com.oplus.camera.e_renamed.e_renamed.this.B_renamed = null;
                    com.oplus.camera.e_renamed.e_renamed.this.I_renamed = false;
                    if (com.oplus.camera.e_renamed.a_renamed.c_renamed(com.oplus.camera.e_renamed.e_renamed.this.aj_renamed)) {
                        com.oplus.camera.e_renamed.e_renamed.this.J_renamed = true;
                    }
                    com.oplus.camera.e_renamed.e_renamed.this.B_renamed(3);
                    com.oplus.camera.e_renamed.e_renamed.this.q_renamed.postAtFrontOfQueue(new java.lang.Runnable() { // from class: com.oplus.camera.e_renamed.e_renamed.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bVar.b_renamed(com.oplus.camera.e_renamed.e_renamed.this.w_renamed);
                        }
                    });
                    com.oplus.camera.e_renamed.e_renamed.this.aa_renamed.open();
                    com.oplus.camera.e_renamed.e_renamed.this.o_renamed.open();
                }

                @Override // com.oplus.ocs.camera.CameraStateCallback
                public void onCameraDisconnected() {
                    com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "onCameraDisconnected, mCameraRole: " + com.oplus.camera.e_renamed.e_renamed.this.w_renamed);
                    com.oplus.camera.e_renamed.e_renamed.this.b_renamed(true);
                    com.oplus.camera.e_renamed.e_renamed.this.K_renamed();
                    com.oplus.camera.e_renamed.e_renamed.this.w_renamed(false);
                    bVar.a_renamed(true, com.oplus.camera.e_renamed.e_renamed.this.w_renamed);
                }

                @Override // com.oplus.ocs.camera.CameraStateCallback
                public void onCameraError(com.oplus.ocs.camera.CameraStateCallback.CameraErrorResult cameraErrorResult) {
                    com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "onCameraError, mCameraRole: " + com.oplus.camera.e_renamed.e_renamed.this.w_renamed + ", error: " + cameraErrorResult.getErrorCode());
                    com.oplus.camera.w_renamed.a_renamed.a_renamed().c_renamed();
                    com.oplus.camera.e_renamed.e_renamed.this.b_renamed(true);
                    com.oplus.camera.e_renamed.e_renamed.this.K_renamed();
                    com.oplus.camera.e_renamed.e_renamed.this.w_renamed(false);
                    if (1 == cameraErrorResult.getErrorCode()) {
                        bVar.a_renamed(false, com.oplus.camera.e_renamed.e_renamed.this.w_renamed);
                    } else {
                        bVar.a_renamed(cameraErrorResult.getErrorCode(), com.oplus.camera.e_renamed.e_renamed.this.w_renamed);
                    }
                }

                @Override // com.oplus.ocs.camera.CameraStateCallback
                public void onSessionConfigured() {
                    com.oplus.camera.perf.b_renamed.c_renamed("launch_session_configured");
                    com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "onSessionConfigured, mCameraRole: " + com.oplus.camera.e_renamed.e_renamed.this.w_renamed + ", mSessionCallback:" + com.oplus.camera.e_renamed.e_renamed.this.E_renamed);
                    com.oplus.camera.e_renamed.a_renamed("CameraStartupPerformance.onCameraCaptureSessionConfigured");
                    com.oplus.camera.e_renamed.e_renamed.this.B_renamed(5);
                    com.oplus.camera.e_renamed.e_renamed.this.I_renamed = false;
                    if (com.oplus.camera.e_renamed.a_renamed.c_renamed(com.oplus.camera.e_renamed.e_renamed.this.aj_renamed)) {
                        com.oplus.camera.e_renamed.e_renamed.this.J_renamed = false;
                    }
                    com.oplus.camera.e_renamed.e_renamed.this.ab_renamed.open();
                    com.oplus.camera.e_renamed.b_renamed("CameraStartupPerformance.onCameraCaptureSessionConfigured");
                }

                @Override // com.oplus.ocs.camera.CameraStateCallback
                public void onSessionConfigureFail(com.oplus.ocs.camera.CameraStateCallback.CameraErrorResult cameraErrorResult) {
                    java.lang.String str;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("onSessionConfigureFail, mCameraRole: ");
                    sb.append(com.oplus.camera.e_renamed.e_renamed.this.w_renamed);
                    sb.append(", result: ");
                    if (cameraErrorResult != null) {
                        str = cameraErrorResult.getErrorCode() + cameraErrorResult.getErrorInfo();
                    } else {
                        str = "null";
                    }
                    sb.append(str);
                    com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", sb.toString());
                    com.oplus.camera.e_renamed.e_renamed.this.B_renamed(6);
                    if (com.oplus.camera.e_renamed.e_renamed.this.E_renamed != null) {
                        com.oplus.camera.e_renamed.e_renamed.this.E_renamed.a_renamed();
                    }
                    com.oplus.camera.e_renamed.e_renamed.this.ab_renamed.open();
                }

                @Override // com.oplus.ocs.camera.CameraStateCallback
                public void onSessionClosed() {
                    if (com.oplus.camera.e_renamed.e_renamed.this.E_renamed != null) {
                        com.oplus.camera.e_renamed.e_renamed.this.B_renamed(8);
                        com.oplus.camera.e_renamed.e_renamed.this.E_renamed.a_renamed((com.oplus.camera.e_renamed.c_renamed) null, com.oplus.camera.e_renamed.e_renamed.this.w_renamed);
                        com.oplus.camera.e_renamed.e_renamed.this.E_renamed.b_renamed(com.oplus.camera.e_renamed.e_renamed.this.w_renamed);
                    }
                    com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "onSessionClosed, last session closed, mCameraRole: " + com.oplus.camera.e_renamed.e_renamed.this.w_renamed + ", mDeviceState: " + com.oplus.camera.e_renamed.e_renamed.this.u_renamed);
                }
            }, this.q_renamed);
            com.oplus.camera.e_renamed.b_renamed("CameraStartupPerformance.openCamera");
            if (this.G_renamed == null) {
                this.G_renamed = new com.oplus.camera.e_renamed.b_renamed();
            }
            a_renamed(true);
            com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "openCameraDevice, mCameraRole: " + this.w_renamed + ", block in_renamed mDeviceState: " + this.u_renamed);
            this.aa_renamed.block();
        } catch (java.lang.SecurityException e_renamed) {
            e_renamed.printStackTrace();
            if (bVar != null) {
                bVar.a_renamed(true, this.w_renamed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K_renamed() {
        this.aa_renamed.open();
        this.ab_renamed.open();
        this.ac_renamed.open();
        this.ad_renamed.open();
        this.ae_renamed.open();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public int c_renamed() {
        if (this.u_renamed != 3 && this.u_renamed != 2) {
            com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "getLogicId, mCameraId: " + this.aj_renamed);
            return this.aj_renamed;
        }
        com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "getLogicId, mCameraId: -1");
        return -1;
    }

    public boolean D_renamed() {
        return com.oplus.camera.e_renamed.a_renamed.a_renamed(this.aj_renamed);
    }

    @Override // com.oplus.camera.e_renamed.g_renamed, com.oplus.camera.e_renamed.d_renamed
    public boolean a_renamed() {
        return 3 == this.u_renamed;
    }

    @Override // com.oplus.camera.e_renamed.g_renamed, com.oplus.camera.e_renamed.d_renamed
    public boolean b_renamed() {
        return 2 == this.u_renamed;
    }

    @Override // com.oplus.camera.e_renamed.g_renamed
    protected void a_renamed(android.hardware.camera2.CameraDevice cameraDevice, boolean z_renamed) {
        if (this.u_renamed != 5 && this.u_renamed != 8 && this.u_renamed != 7 && this.u_renamed != 1 && this.u_renamed != 0 && this.u_renamed != 6) {
            com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "closeCameraDevice, mCameraRole: " + this.w_renamed + ", return for mDeviceState: " + this.u_renamed);
            return;
        }
        if (this.B_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("CameraSwitchModePerformance.closeCameraDevice");
            com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "closeCameraDevice start, mCameraRole: " + this.w_renamed + ", needDelay: " + z_renamed);
            this.ae_renamed.block();
            B_renamed(2);
            this.aa_renamed.close();
            this.B_renamed.close(true, z_renamed);
            a_renamed(true);
            com.oplus.camera.e_renamed.b_renamed("OneCameraImpl", "closeCameraDevice, mCameraRole: " + this.w_renamed + ", block in_renamed mDeviceState: " + this.u_renamed);
            this.B_renamed = null;
            this.aa_renamed.block();
            com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "closeCameraDevice X_renamed, mCameraRole: " + this.w_renamed);
            com.oplus.camera.e_renamed.b_renamed("CameraSwitchModePerformance.closeCameraDevice");
            return;
        }
        B_renamed(3);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(com.oplus.camera.e_renamed.d_renamed.e_renamed eVar) {
        this.C_renamed = eVar;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public com.oplus.camera.e_renamed.h_renamed e_renamed() {
        return this.D_renamed;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(com.oplus.camera.e_renamed.h_renamed hVar) {
        this.D_renamed = hVar;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void g_renamed() {
        this.p_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.e_renamed.e_renamed.7
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "stopRepeating, mCameraRole: " + com.oplus.camera.e_renamed.e_renamed.this.w_renamed);
                if (com.oplus.camera.e_renamed.e_renamed.this.B_renamed != null) {
                    com.oplus.camera.e_renamed.a_renamed("stopRepeating");
                    com.oplus.camera.e_renamed.e_renamed.this.B_renamed.stopPreview();
                    com.oplus.camera.e_renamed.b_renamed("stopRepeating");
                }
            }
        });
    }

    private void L_renamed() {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "waitRecordingFinish, mCameraRole: " + this.w_renamed + ", isCloseStreamTaskFinished: " + d_renamed("type_video"));
        if (!d_renamed("type_video") || !d_renamed("type_video_frame")) {
            this.ad_renamed.block();
            if (this.p_renamed.hasCallbacks(this.Z_renamed)) {
                this.p_renamed.removeCallbacks(this.Z_renamed);
                this.Z_renamed.run();
            }
        }
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "waitRecordingFinish, x_renamed, mCameraRole: " + this.w_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void h_renamed() {
        this.p_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.e_renamed.e_renamed.8
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.e_renamed.this.B_renamed.abortCaptures();
            }
        });
    }

    @Override // com.oplus.camera.e_renamed.g_renamed
    protected void E_renamed() {
        com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "closeOldSession, mCameraRole: " + this.w_renamed + ", mDeviceState: " + this.u_renamed);
        if (5 == this.u_renamed) {
            this.M_renamed = false;
            com.oplus.camera.e_renamed.c_renamed cVar = this.X_renamed;
            if (cVar != null) {
                cVar.f4425c = false;
            }
            L_renamed();
            B_renamed(7);
            this.Z_renamed.a_renamed(true);
            try {
                if (this.B_renamed != null) {
                    com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "closeOldSession, begin to stopRepeating, mCameraRole: " + this.w_renamed);
                    com.oplus.camera.e_renamed.a_renamed("CameraSwitchModePerformance.stopRepeating");
                    this.B_renamed.closeSession();
                    com.oplus.camera.e_renamed.b_renamed("CameraSwitchModePerformance.stopRepeating");
                    this.K_renamed = 0;
                    Q_renamed();
                }
            } catch (java.lang.IllegalStateException e_renamed) {
                com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "closeOldSession, mCameraRole: " + this.w_renamed + ", e_renamed: " + e_renamed);
                Q_renamed();
                B_renamed(6);
            }
        }
    }

    @Override // com.oplus.camera.e_renamed.g_renamed
    protected void F_renamed() {
        if (this.E_renamed == null || this.u_renamed != 5) {
            return;
        }
        this.ac_renamed.close();
        if (this.E_renamed.a_renamed(this.w_renamed)) {
            com.oplus.camera.e_renamed.b_renamed("OneCameraImpl", "onSessionConfigured, block in_renamed, mCameraRole: " + this.w_renamed + ", mDeviceState: " + this.u_renamed);
            this.ac_renamed.block();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M_renamed() {
        com.oplus.camera.e_renamed.d_renamed.e_renamed eVar;
        if (!N_renamed() || this.M_renamed) {
            return;
        }
        com.oplus.camera.e_renamed.b_renamed("OneCameraImpl", "checkFrontFlash, flash required, but ae_renamed not converged, mCameraRole: " + this.w_renamed + ", mbAeAfLocked: " + this.M_renamed);
        if (!D_renamed() || (eVar = this.C_renamed) == null) {
            return;
        }
        eVar.a_renamed();
    }

    private boolean N_renamed() {
        if (D_renamed() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TORCH_SOFT_LIGHT)) {
            return false;
        }
        return "on_renamed".equals(this.L_renamed) || ("auto".equals(this.L_renamed) && this.N_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed, com.oplus.camera.e_renamed.c_renamed cVar, com.oplus.camera.e_renamed.d_renamed.a_renamed aVar) {
        if (z_renamed) {
            this.Y_renamed = true;
            this.B_renamed.setParameter((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.BURST_SHOT_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "on_renamed");
            a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        a_renamed(z_renamed ? com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CSHOT_FIRST_REQUEST_NUM) : 1, cVar, aVar);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void i_renamed() {
        this.Y_renamed = false;
        com.oplus.ocs.camera.CameraDevice cameraDevice = this.B_renamed;
        if (cameraDevice != null) {
            cameraDevice.setParameter((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.BURST_SHOT_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "off");
        }
        a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean O_renamed() {
        com.oplus.camera.e_renamed.a_renamed.a_renamed aVar = this.an_renamed;
        if (aVar == null || !aVar.c_renamed()) {
            return true;
        }
        com.oplus.camera.e_renamed.b_renamed("OneCameraImpl", "checkZoomState, isZoomChanging, mCameraRole: " + this.w_renamed);
        this.an_renamed.a_renamed(true);
        return false;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(final int i_renamed, final com.oplus.camera.e_renamed.c_renamed cVar, final com.oplus.camera.e_renamed.d_renamed.a_renamed aVar) {
        this.p_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.e_renamed.e_renamed.9
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.e_renamed.this.M_renamed();
                boolean zO = com.oplus.camera.e_renamed.e_renamed.this.O_renamed();
                com.oplus.camera.e_renamed.e_renamed.this.X_renamed = cVar;
                com.oplus.camera.e_renamed.e_renamed.this.F_renamed = aVar;
                com.oplus.camera.e_renamed.e_renamed.this.S_renamed = i_renamed;
                com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "burstCapture, pictureNum: " + i_renamed + ", requestTag: " + cVar + ", mbBurstShot: " + cVar.j_renamed + ", checkZoomState: " + zO + ", featureType: " + cVar.X_renamed + ", ev_renamed list: " + java.util.Arrays.toString(cVar.L_renamed));
                if (!com.oplus.camera.util.Util.C_renamed() && cVar.j_renamed && com.oplus.camera.e_renamed.e_renamed.this.U_renamed >= com.oplus.camera.util.Util.d_renamed) {
                    com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "burstCapture, mMtkCShortRequestNum reach max, return!");
                    return;
                }
                com.oplus.camera.e_renamed.d_renamed.a_renamed aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.checkIfLockAutoExposure();
                }
                if (!zO) {
                    com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "burstCapture, checkZoomState false, return!");
                    return;
                }
                if (com.oplus.camera.e_renamed.e_renamed.this.u_renamed == 5) {
                    try {
                        com.oplus.camera.e_renamed.e_renamed.this.F_renamed = aVar;
                        com.oplus.camera.e_renamed.a_renamed("CameraCapturePerformance.doCapture", "05ct_doCapture: " + i_renamed, com.oplus.camera.d_renamed.d_renamed.longValue());
                        com.oplus.camera.e_renamed.e_renamed.this.b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Object>>) com.oplus.ocs.camera.CameraParameter.REQUEST_TAG, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Object>) cVar);
                        com.oplus.camera.e_renamed.e_renamed.this.b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Long>>) com.oplus.ocs.camera.CameraParameter.CAPTURE_TIME, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Long>) java.lang.Long.valueOf(cVar.ab_renamed));
                        com.oplus.camera.e_renamed.e_renamed.this.B_renamed.takePicture(com.oplus.camera.e_renamed.e_renamed.this.ak_renamed, com.oplus.camera.e_renamed.e_renamed.this.r_renamed);
                        if (!com.oplus.camera.util.Util.C_renamed()) {
                            com.oplus.camera.e_renamed.e_renamed.e_renamed(com.oplus.camera.e_renamed.e_renamed.this, 1);
                        }
                        com.oplus.camera.e_renamed.d_renamed("CameraCapturePerformance.doCapture", "05ct_doCapture: " + i_renamed);
                        com.oplus.camera.e_renamed.e_renamed.this.H_renamed();
                        return;
                    } catch (java.lang.Exception e_renamed) {
                        com.oplus.camera.e_renamed.d_renamed.a_renamed aVar3 = aVar;
                        if (aVar3 != null) {
                            aVar3.onCaptureCanceled(cVar);
                        }
                        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "burstCapture, exception: " + e_renamed.getMessage());
                        return;
                    }
                }
                com.oplus.camera.e_renamed.d_renamed.a_renamed aVar4 = aVar;
                if (aVar4 != null) {
                    aVar4.onCaptureCanceled(cVar);
                }
            }
        });
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(java.lang.String str) {
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.SUPER_TEXT_VERTICES, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) str);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public <T_renamed> void a_renamed(android.hardware.camera2.CaptureRequest.Key<T_renamed> key, T_renamed t_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setParameter, key: " + key.getName() + ", value: " + t_renamed);
        if (this.B_renamed != null) {
            c_renamed(key, (android.hardware.camera2.CaptureRequest.Key<T_renamed>) t_renamed);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public <T_renamed> void a_renamed(com.oplus.ocs.camera.CameraParameter.PreviewKey<T_renamed> previewKey, T_renamed t_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setParameter, key: " + previewKey.getKeyName() + ", value: " + t_renamed);
        if (this.B_renamed != null) {
            b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<T_renamed>>) previewKey, (com.oplus.ocs.camera.CameraParameter.PreviewKey<T_renamed>) t_renamed);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public <T_renamed> void b_renamed(android.hardware.camera2.CaptureRequest.Key<T_renamed> key, T_renamed t_renamed) {
        if (this.B_renamed != null) {
            c_renamed(key, (android.hardware.camera2.CaptureRequest.Key<T_renamed>) t_renamed);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(float f_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setFocusDistance, distance: " + f_renamed + ", restartPreview: " + z_renamed);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>>) com.oplus.ocs.camera.CameraParameter.FOCUS_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>) 0);
        c_renamed(android.hardware.camera2.CaptureRequest.LENS_FOCUS_DISTANCE, (android.hardware.camera2.CaptureRequest.Key) java.lang.Float.valueOf(f_renamed));
        if (z_renamed) {
            a_renamed(this.al_renamed, 0);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public int p_renamed() {
        return this.Q_renamed;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public java.lang.String q_renamed() {
        return this.L_renamed;
    }

    public void c_renamed(int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setFocusMode, focusMode: " + i_renamed + ", needTrigger: " + z_renamed);
        a_renamed(i_renamed, com.oplus.camera.a_renamed.a_renamed(), com.oplus.camera.a_renamed.a_renamed(), z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(int i_renamed, android.hardware.camera2.params.MeteringRectangle[] meteringRectangleArr, android.hardware.camera2.params.MeteringRectangle[] meteringRectangleArr2, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setFocusMode, focusMode: " + i_renamed + ", needTrigger: " + z_renamed + ", afRegion: " + java.util.Arrays.toString(meteringRectangleArr) + ", aeRegion: " + java.util.Arrays.toString(meteringRectangleArr2));
        if (com.oplus.camera.a_renamed.b_renamed().equals(meteringRectangleArr) || com.oplus.camera.a_renamed.b_renamed().equals(meteringRectangleArr2)) {
            a_renamed(i_renamed, com.oplus.camera.a_renamed.a_renamed(), com.oplus.camera.a_renamed.a_renamed(), z_renamed);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(int i_renamed, android.graphics.RectF rectF, android.graphics.RectF rectF2, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setFocusMode, mCameraRole: " + this.w_renamed + ", focusMode: " + i_renamed + ", needTrigger: " + z_renamed + ", afRegion: " + rectF + ", aeRegion: " + rectF2);
        if (this.B_renamed == null) {
            return;
        }
        if (i_renamed != 1) {
            if (i_renamed == 3) {
                if (z_renamed) {
                    c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER, (android.hardware.camera2.CaptureRequest.Key) 0);
                }
                b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>>) com.oplus.ocs.camera.CameraParameter.FOCUS_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>) 2);
            } else if (i_renamed == 4) {
                b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>>) com.oplus.ocs.camera.CameraParameter.FOCUS_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>) 1);
            }
        } else if (z_renamed) {
            b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>>) com.oplus.ocs.camera.CameraParameter.FOCUS_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>) 3);
        } else {
            b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>>) com.oplus.ocs.camera.CameraParameter.FOCUS_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>) 4);
        }
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<android.graphics.RectF>>) com.oplus.ocs.camera.CameraParameter.AF_REGIONS, (com.oplus.ocs.camera.CameraParameter.PreviewKey<android.graphics.RectF>) rectF);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<android.graphics.RectF>>) com.oplus.ocs.camera.CameraParameter.AE_REGIONS, (com.oplus.ocs.camera.CameraParameter.PreviewKey<android.graphics.RectF>) rectF2);
        if (com.oplus.camera.a_renamed.a_renamed().equals(rectF2)) {
            c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AE_REGIONS, (android.hardware.camera2.CaptureRequest.Key) com.oplus.camera.a_renamed.b_renamed());
        }
        if (com.oplus.camera.a_renamed.a_renamed().equals(rectF)) {
            c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AF_REGIONS, (android.hardware.camera2.CaptureRequest.Key) com.oplus.camera.a_renamed.b_renamed());
        }
        a_renamed(this.al_renamed, 0);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(com.oplus.camera.e_renamed.i_renamed iVar) {
        if (this.B_renamed != null) {
            android.util.Pair pairA = a_renamed("com.oplus.control.af_renamed.region", (java.lang.String) iVar.a_renamed());
            c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(com.oplus.camera.e_renamed.i_renamed iVar) {
        android.util.Pair pairA = a_renamed("com.oplus.control.ae_renamed.region", (java.lang.String) iVar.a_renamed());
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void n_renamed() {
        c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_MODE, (android.hardware.camera2.CaptureRequest.Key) 1);
        c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, (android.hardware.camera2.CaptureRequest.Key) 1);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void o_renamed() {
        this.p_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.e_renamed.e_renamed.10
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.e_renamed.e_renamed.this.B_renamed != null) {
                    com.oplus.camera.e_renamed.e_renamed.this.c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER, (android.hardware.camera2.CaptureRequest.Key) 2);
                    com.oplus.camera.e_renamed.e_renamed eVar = com.oplus.camera.e_renamed.e_renamed.this;
                    eVar.a_renamed(eVar.al_renamed, 1);
                }
            }
        });
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void d_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "cancelAutoFocus, mCameraRole: " + this.w_renamed);
        if (!D_renamed()) {
            this.p_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.e_renamed.e_renamed.11
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.e_renamed.e_renamed.this.B_renamed != null) {
                        com.oplus.camera.e_renamed.e_renamed.this.c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER, (android.hardware.camera2.CaptureRequest.Key) 2);
                        com.oplus.camera.e_renamed.e_renamed eVar = com.oplus.camera.e_renamed.e_renamed.this;
                        eVar.a_renamed(eVar.al_renamed, 1);
                    }
                }
            });
            c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(i_renamed));
            c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AF_REGIONS, (android.hardware.camera2.CaptureRequest.Key) com.oplus.camera.a_renamed.b_renamed());
            b_renamed(new com.oplus.camera.e_renamed.i_renamed(com.oplus.camera.a_renamed.b_renamed()[0]));
            a_renamed(new com.oplus.camera.e_renamed.i_renamed(com.oplus.camera.a_renamed.b_renamed()[0]));
        }
        c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_MODE, (android.hardware.camera2.CaptureRequest.Key) 1);
        c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AE_REGIONS, (android.hardware.camera2.CaptureRequest.Key) com.oplus.camera.a_renamed.b_renamed());
        a_renamed(this.al_renamed, 0);
        c_renamed(i_renamed, true);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void e_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setAISceneMode, mCameraRole: " + this.w_renamed + ", enable: " + i_renamed);
        android.util.Pair pairA = a_renamed("com.oplus.ai_renamed.scene.app.enable", (java.lang.String) new int[]{i_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(java.lang.String str, boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setFilter, filterType: " + str + ", filterOpen: " + z_renamed + ", vignette: " + z2);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.FILTER_TYPE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) str);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.FILTER_OPEN, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(z_renamed));
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.FILTER_WITHVIGNETTE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(z2));
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void f_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setFrameFlag, frameFlag: " + i_renamed);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>>) com.oplus.ocs.camera.CameraParameter.FRAME_FLAG, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>) java.lang.Integer.valueOf(i_renamed));
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void e_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setCaptureForVideo, enable: " + z_renamed);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.CAPTURE_FOR_VIDEO, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(z_renamed));
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void f_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setOutCapture, outCapture: " + z_renamed);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.REAR_MIRROR_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(z_renamed));
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void g_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setStarVideoEnable, mbStarVideoEnable: " + z_renamed);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.STAR_VIDEO_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (z_renamed ? "on_renamed" : "off"));
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed, java.lang.String str, int[] iArr) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setFaceBeautyParam, enable: " + z_renamed + ", faceVersion: " + str + ", faceBeautyParam:" + iArr);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.FACE_BEAUTY_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (z_renamed ? "on_renamed" : "off"));
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.FACE_BEAUTY_VERSION, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) str);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]>>) com.oplus.ocs.camera.CameraParameter.FACE_BEAUTY_PARAM, (com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]>) iArr);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed, int i_renamed, java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setVideoNeonParam, enable: " + z_renamed + ", videoFusionEffect: " + i_renamed + ", videoNeonParams:" + str);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.VIDEO_NEON_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (z_renamed ? "on_renamed" : "off"));
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>>) com.oplus.ocs.camera.CameraParameter.VIDEO_FUSION_EFFECT, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>) java.lang.Integer.valueOf(i_renamed));
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.VIDEO_NEON_PARAMS, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) str);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void h_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "enableDeRedEye, enable: " + z_renamed);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.FACE_DERED_EYE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (z_renamed ? "on_renamed" : "off"));
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed, java.lang.String str, long j_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "enableBurstShot, enable: " + z_renamed + ", path: " + str);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.BURST_SHOT_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (z_renamed ? "on_renamed" : "off"));
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.BURST_SHOT_PATH, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) str);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Long>>) com.oplus.ocs.camera.CameraParameter.BURST_SHOT_FLAG_ID, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Long>) java.lang.Long.valueOf(j_renamed));
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed, android.os.Bundle bundle) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setWaterCaptureParam, enable: " + z_renamed);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.WATERMARK_CAPTURE_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (z_renamed ? "on_renamed" : "off"));
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<android.os.Bundle>>) com.oplus.ocs.camera.CameraParameter.WATERMARK_PARAM, (com.oplus.ocs.camera.CameraParameter.PreviewKey<android.os.Bundle>) bundle);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void g_renamed(int i_renamed) {
        android.util.Pair pairA = a_renamed("com.oplus.capture.request.picture.size.scale", (java.lang.String) new int[]{i_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void p_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setPIEnableList, mCameraRole: " + this.w_renamed + ", enableList: " + java.lang.Integer.toBinaryString(i_renamed));
        android.util.Pair pairA = a_renamed("com.oplus.camera.pi.enable_list", (java.lang.String) new int[]{i_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    public void b_renamed(java.lang.String str, int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setFaceBeautyLevel, cameraType: " + str + ", level: " + i_renamed);
        android.util.Pair pairA = a_renamed("com.oplus.facebeauty.level", (java.lang.String) new int[]{i_renamed});
        a_renamed(str, (android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void h_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setFaceBeautyLevel, mCameraRole: " + this.w_renamed + ", level: " + i_renamed);
        android.util.Pair pairA = a_renamed("com.oplus.facebeauty.level", (java.lang.String) new int[]{i_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(java.lang.String str, int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setMakeupParam, makeType: " + str + ", makeValue: " + i_renamed);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.MAKEUP_TYPE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) str);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>>) com.oplus.ocs.camera.CameraParameter.MAKEUP_VALUE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>) java.lang.Integer.valueOf(i_renamed));
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(int[] iArr) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setCustomBeautyValues, mCameraRole: " + this.w_renamed + ", values: " + java.util.Arrays.toString(iArr));
        android.util.Pair pairA = a_renamed("com.oplus.facebeauty.custom", (java.lang.String) iArr);
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void t_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setApertureValue, mCameraRole: " + this.w_renamed + ", value: " + i_renamed);
        android.util.Pair pairA = a_renamed("com.oplus.iris.aperture.value", (java.lang.String) new int[]{i_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void c_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setHDRMode, hdrMode: " + str);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.CAPTURE_HDR_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) str);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void q_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setVHdrRequest, mCameraRole: " + this.w_renamed + ", enable: " + z_renamed);
        if (z_renamed) {
            android.util.Pair pairA = a_renamed("com.mediatek.hdrfeature.hdrMode", (java.lang.String) new int[]{this.T_renamed});
            c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(final boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setAutoExposureLock, mCameraRole: " + this.w_renamed + ", aeLock: " + z_renamed);
        c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AE_LOCK, (android.hardware.camera2.CaptureRequest.Key) java.lang.Boolean.valueOf(z_renamed));
        if (z_renamed && !com.oplus.camera.util.Util.C_renamed()) {
            c_renamed(com.oplus.camera.e_renamed.b_renamed.bA_renamed, (android.hardware.camera2.CaptureRequest.Key<java.lang.Integer>) java.lang.Integer.valueOf(z2 ? 1 : 0));
        }
        this.p_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.e_renamed.e_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.e_renamed.this.M_renamed = z_renamed;
            }
        });
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void l_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setLongShotEnable, mCameraRole: " + this.w_renamed + ", enable: " + z_renamed);
        android.util.Pair pairA = a_renamed("com.oplus.longshot.enable", (java.lang.String) new int[]{z_renamed ? 1 : 0});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void k_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setAheadCaptureFrameNum, num: " + i_renamed);
        android.util.Pair pairA = a_renamed("com.oplus.ahead.capture.frame.num", (java.lang.String) new int[]{i_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void l_renamed(int i_renamed) {
        android.util.Pair pairA = a_renamed("com.oplus.ahead.night.ev0", (java.lang.String) new int[]{i_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void m_renamed(boolean z_renamed) {
        if (this.B_renamed == null) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setZsl, zsl: " + z_renamed);
        if (com.oplus.camera.util.Util.C_renamed()) {
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_ENABLE_ZSL, (android.hardware.camera2.CaptureRequest.Key) java.lang.Boolean.valueOf(z_renamed));
            }
        } else {
            android.util.Pair pairA = a_renamed("com.mediatek.control.capture.zsl.mode", (java.lang.String) new byte[]{z_renamed ? (byte) 1 : (byte) 0});
            c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(java.lang.String str, int[] iArr) {
        android.util.Pair pairA = a_renamed(str, (java.lang.String) iArr);
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.b_renamed("OneCameraImpl", "setFlashMode, mCameraRole: " + this.w_renamed + ", value: " + str);
        if (str == null || this.B_renamed == null) {
            return;
        }
        com.oplus.camera.w_renamed.a_renamed.a_renamed().a_renamed(com.oplus.camera.util.Util.l_renamed(), "flash_mode", str);
        com.oplus.camera.v_renamed.c_renamed cVar = this.af_renamed;
        if (cVar != null) {
            cVar.a_renamed(str);
        }
        this.L_renamed = str;
        char c2 = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != 3551) {
            if (iHashCode != 109935) {
                if (iHashCode != 3005871) {
                    if (iHashCode == 110547964 && str.equals(com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH)) {
                        c2 = 3;
                    }
                } else if (str.equals("auto")) {
                    c2 = 2;
                }
            } else if (str.equals("off")) {
                c2 = 1;
            }
        } else if (str.equals("on_renamed")) {
            c2 = 0;
        }
        if (c2 == 0) {
            b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.FLASH_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "on_renamed");
            return;
        }
        if (c2 == 1) {
            b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.FLASH_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "off");
        } else if (c2 == 2) {
            b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.FLASH_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "auto");
        } else {
            if (c2 != 3) {
                return;
            }
            b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.FLASH_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) com.oplus.ocs.camera.CameraParameter.FlashMode.FLASH_TORCH);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void c_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setFrontModeAutoEnable: " + z_renamed);
        c_renamed(com.oplus.camera.e_renamed.b_renamed.d_renamed, (android.hardware.camera2.CaptureRequest.Key<java.lang.Integer>) java.lang.Integer.valueOf(z_renamed ? 1 : 0));
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void d_renamed(boolean z_renamed) {
        this.N_renamed = z_renamed;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void s_renamed() {
        synchronized (this.z_renamed) {
            if (this.W_renamed != null) {
                com.oplus.camera.e_renamed.b_renamed("OneCameraImpl", "closeImageWriter, mCameraRole: " + this.w_renamed);
                this.W_renamed.close();
                this.W_renamed = null;
            }
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public <T_renamed> void c_renamed(android.hardware.camera2.CaptureRequest.Key key, T_renamed t_renamed) {
        if (this.u_renamed != 5) {
            com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "set, illegal state: " + this.u_renamed + ", key: " + key.getName() + ", value: " + t_renamed);
            return;
        }
        com.oplus.ocs.camera.CameraDevice cameraDevice = this.B_renamed;
        if (cameraDevice != null) {
            cameraDevice.setParameter((android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) key, (android.hardware.camera2.CaptureRequest.Key) t_renamed);
        }
    }

    public <T_renamed> void a_renamed(java.lang.String str, android.hardware.camera2.CaptureRequest.Key key, T_renamed t_renamed) {
        if (this.u_renamed != 5) {
            com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "set, illegal state: " + this.u_renamed + ", key: " + key.getName() + ", value: " + t_renamed);
            return;
        }
        com.oplus.ocs.camera.CameraDevice cameraDevice = this.B_renamed;
        if (cameraDevice != null) {
            cameraDevice.setParameter(str, (android.hardware.camera2.CaptureRequest.Key<android.hardware.camera2.CaptureRequest.Key>) key, (android.hardware.camera2.CaptureRequest.Key) t_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T_renamed> void b_renamed(com.oplus.ocs.camera.CameraParameter.PreviewKey<T_renamed> previewKey, T_renamed t_renamed) {
        if (this.u_renamed != 5) {
            com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "set, illegal state: " + this.u_renamed + ", previewKey: " + previewKey.getKeyName() + ", value: " + t_renamed);
            return;
        }
        com.oplus.ocs.camera.CameraDevice cameraDevice = this.B_renamed;
        if (cameraDevice != null) {
            cameraDevice.setParameter((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<T_renamed>>) previewKey, (com.oplus.ocs.camera.CameraParameter.PreviewKey<T_renamed>) t_renamed);
        }
    }

    private <T_renamed> void c_renamed(com.oplus.ocs.camera.CameraParameter.PreviewKey previewKey, T_renamed t_renamed) {
        if (this.u_renamed != 5) {
            com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "setZoomTarget, illegal state: " + this.u_renamed + ", previewKey: " + previewKey.getKeyName() + ", value: " + t_renamed);
            return;
        }
        com.oplus.ocs.camera.CameraDevice cameraDevice = this.B_renamed;
        if (cameraDevice != null) {
            cameraDevice.setParameter((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey>) previewKey, (com.oplus.ocs.camera.CameraParameter.PreviewKey) t_renamed);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public int[] a_renamed(android.hardware.camera2.CaptureResult.Key<?> key, android.hardware.camera2.CaptureResult captureResult) {
        java.lang.Object objA = com.oplus.camera.e_renamed.b_renamed.a_renamed(captureResult, key);
        if (objA == null || !(objA instanceof int[])) {
            return null;
        }
        int[] iArr = (int[]) objA;
        if (iArr.length > 0) {
            return iArr;
        }
        return null;
    }

    public void h_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "startFaceDetection, cameraType: " + str + ", mDeviceState: " + this.u_renamed);
        com.oplus.camera.e_renamed.a_renamed("startFaceDetection");
        a_renamed(str, android.hardware.camera2.CaptureRequest.STATISTICS_FACE_DETECT_MODE, (android.hardware.camera2.CaptureRequest.Key) 1);
        com.oplus.camera.e_renamed.b_renamed("startFaceDetection");
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void k_renamed() {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "startFaceDetection, mCameraRole: " + this.w_renamed + ", mDeviceState: " + this.u_renamed);
        com.oplus.camera.e_renamed.a_renamed("startFaceDetection");
        c_renamed(android.hardware.camera2.CaptureRequest.STATISTICS_FACE_DETECT_MODE, (android.hardware.camera2.CaptureRequest.Key) 1);
        com.oplus.camera.e_renamed.b_renamed("startFaceDetection");
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void o_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setMTKTrackFocusState, isTrackFocusOpen: " + z_renamed);
        android.util.Pair pairA = a_renamed("com.oplus.track.focus.config.enable", (java.lang.String) new int[]{z_renamed ? 1 : 0});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(com.oplus.camera.e_renamed.d_renamed.c_renamed cVar) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setRepeatingRequest, mCameraRole: " + this.w_renamed + ", previewCallback: " + cVar + ", mDeviceState: " + this.u_renamed);
        if (cVar != null) {
            this.ai_renamed = cVar;
        }
        a_renamed(this.al_renamed, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(final com.oplus.ocs.camera.CameraPreviewCallback cameraPreviewCallback, int i_renamed) {
        com.oplus.camera.e_renamed.c_renamed cVar;
        if (this.u_renamed != 5 || ((cVar = this.X_renamed) != null && cVar.f4425c)) {
            com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "startPreview, illegal state: " + this.u_renamed);
            return;
        }
        this.p_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.e_renamed.e_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.e_renamed.e_renamed.this.u_renamed != 5 || com.oplus.camera.e_renamed.e_renamed.this.B_renamed == null) {
                    return;
                }
                com.oplus.camera.e_renamed.e_renamed.this.a_renamed(cameraPreviewCallback);
            }
        });
    }

    private void P_renamed() {
        com.oplus.camera.e_renamed.a_renamed("builderOutputSurfaces");
        if (this.H_renamed == null) {
            this.H_renamed = new java.util.LinkedHashMap<>();
        }
        com.oplus.camera.e_renamed.d_renamed.OneCamera_5 interfaceC0097d = this.E_renamed;
        if (interfaceC0097d != null) {
            interfaceC0097d.a_renamed(this.H_renamed, this.w_renamed);
        }
        com.oplus.camera.e_renamed.b_renamed("builderOutputSurfaces");
    }

    private <T_renamed> android.util.Pair<android.hardware.camera2.CaptureRequest.Key, T_renamed> a_renamed(java.lang.String str, T_renamed t_renamed) {
        return new android.util.Pair<>(new android.hardware.camera2.CaptureRequest.Key(str, t_renamed.getClass()), t_renamed);
    }

    private void Q_renamed() {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "releaseResource, mCameraRole: " + this.w_renamed);
        com.oplus.camera.e_renamed.a_renamed("releaseResource");
        java.util.LinkedHashMap<java.lang.String, android.view.Surface> linkedHashMap = this.H_renamed;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
        com.oplus.camera.e_renamed.b_renamed("releaseResource");
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void i_renamed(boolean z_renamed) {
        c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AWB_MODE, (android.hardware.camera2.CaptureRequest.Key) 1);
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
            android.util.Pair pairA = a_renamed("org.codeaurora.qcamera3.manualWB.partial_mwb_mode", (java.lang.String) new int[]{0});
            c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
        }
        if (z_renamed) {
            a_renamed(this.al_renamed, 0);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(int i_renamed, boolean z_renamed) {
        if (com.oplus.camera.util.Util.C_renamed() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
            android.util.Pair pairA = a_renamed("org.codeaurora.qcamera3.manualWB.partial_mwb_mode", (java.lang.String) new int[]{1});
            c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
            android.util.Pair pairA2 = a_renamed("org.codeaurora.qcamera3.manualWB.color_temperature", (java.lang.String) new int[]{i_renamed});
            c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA2.first, (android.hardware.camera2.CaptureRequest.Key) pairA2.second);
        }
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]>>) com.oplus.ocs.camera.CameraParameter.COLOR_TEMPERATURE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]>) new int[]{i_renamed});
        if (z_renamed) {
            a_renamed(this.al_renamed, 0);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void i_renamed(int i_renamed) {
        android.util.Pair pairA = a_renamed("org.codeaurora.qcamera3.exposure_metering.exposure_metering_mode", (java.lang.String) new int[]{i_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(int i_renamed, boolean z_renamed) {
        if (i_renamed == -1) {
            this.O_renamed = true;
        } else {
            this.O_renamed = false;
            if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
                c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE, (android.hardware.camera2.CaptureRequest.Key) 0);
            }
        }
        if (this.O_renamed && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
            if (this.P_renamed) {
                c_renamed(com.oplus.camera.e_renamed.b_renamed.p_renamed, (android.hardware.camera2.CaptureRequest.Key<int[]>) new int[]{this.V_renamed});
                c_renamed(com.oplus.camera.e_renamed.b_renamed.q_renamed, (android.hardware.camera2.CaptureRequest.Key<long[]>) new long[]{0});
            }
        } else if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
            if (!this.P_renamed) {
                c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE, (android.hardware.camera2.CaptureRequest.Key) 0);
                c_renamed(com.oplus.camera.e_renamed.b_renamed.p_renamed, (android.hardware.camera2.CaptureRequest.Key<int[]>) new int[]{2});
            } else {
                c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE, (android.hardware.camera2.CaptureRequest.Key) 1);
                c_renamed(com.oplus.camera.e_renamed.b_renamed.p_renamed, (android.hardware.camera2.CaptureRequest.Key<int[]>) new int[]{0});
                this.V_renamed = 0;
            }
            c_renamed(com.oplus.camera.e_renamed.b_renamed.q_renamed, (android.hardware.camera2.CaptureRequest.Key<long[]>) new long[]{i_renamed});
        }
        int iU = e_renamed().u_renamed();
        com.oplus.camera.e_renamed.b_renamed("OneCameraImpl", "setIso, mCameraRole: " + this.w_renamed + ", iso: " + i_renamed + ", maxISOValue: " + iU);
        if (i_renamed > iU) {
            c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_POST_RAW_SENSITIVITY_BOOST, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf((int) ((i_renamed / iU) * 100.0f)));
            c_renamed(android.hardware.camera2.CaptureRequest.SENSOR_SENSITIVITY, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(iU));
        } else {
            c_renamed(android.hardware.camera2.CaptureRequest.SENSOR_SENSITIVITY, (android.hardware.camera2.CaptureRequest.Key) java.lang.Integer.valueOf(i_renamed));
            c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_POST_RAW_SENSITIVITY_BOOST, (android.hardware.camera2.CaptureRequest.Key) 100);
        }
        if (z_renamed) {
            a_renamed(this.al_renamed, 0);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(long j_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setExposureTime, mCameraRole: " + this.w_renamed + ", exposureTime: " + j_renamed);
        if (j_renamed == -1) {
            this.P_renamed = true;
        } else {
            this.P_renamed = false;
            if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
                c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE, (android.hardware.camera2.CaptureRequest.Key) 0);
            }
        }
        if (this.P_renamed && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
            if (this.O_renamed) {
                c_renamed(com.oplus.camera.e_renamed.b_renamed.p_renamed, (android.hardware.camera2.CaptureRequest.Key<int[]>) new int[]{this.V_renamed});
                c_renamed(com.oplus.camera.e_renamed.b_renamed.q_renamed, (android.hardware.camera2.CaptureRequest.Key<long[]>) new long[]{0});
            }
        } else if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MMCAMERA_PROFESSIONAL)) {
            if (!this.O_renamed) {
                c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE, (android.hardware.camera2.CaptureRequest.Key) 0);
                c_renamed(com.oplus.camera.e_renamed.b_renamed.p_renamed, (android.hardware.camera2.CaptureRequest.Key<int[]>) new int[]{2});
            } else {
                c_renamed(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE, (android.hardware.camera2.CaptureRequest.Key) 1);
                c_renamed(com.oplus.camera.e_renamed.b_renamed.p_renamed, (android.hardware.camera2.CaptureRequest.Key<int[]>) new int[]{1});
                this.V_renamed = 1;
            }
            c_renamed(com.oplus.camera.e_renamed.b_renamed.q_renamed, (android.hardware.camera2.CaptureRequest.Key<long[]>) new long[]{j_renamed});
            c_renamed(com.oplus.camera.e_renamed.b_renamed.q_renamed, (android.hardware.camera2.CaptureRequest.Key<long[]>) new long[]{j_renamed});
        }
        c_renamed(android.hardware.camera2.CaptureRequest.SENSOR_EXPOSURE_TIME, (android.hardware.camera2.CaptureRequest.Key) java.lang.Long.valueOf(j_renamed));
        if (z_renamed) {
            a_renamed(this.al_renamed, 0);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed, boolean z2) {
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.FOCUS_PEAKING_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(z_renamed));
        if (z2) {
            a_renamed(this.al_renamed, 0);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void r_renamed() {
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.FLASH_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "off");
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void j_renamed(boolean z_renamed) {
        if (this.R_renamed == 0 && this.L_renamed.equals("on_renamed")) {
            b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.FLASH_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "on_renamed");
        } else if (this.R_renamed == 0 && this.L_renamed.equals("auto")) {
            b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.FLASH_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) "auto");
        }
        if (z_renamed) {
            a_renamed(this.al_renamed, 0);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void j_renamed(int i_renamed) {
        android.util.Pair pairA = a_renamed("com.oplus.slogan.enable", (java.lang.String) new int[]{i_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(android.os.Bundle bundle) {
        if (this.B_renamed != null) {
            b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<android.os.Bundle>>) com.oplus.ocs.camera.CameraParameter.WATERMARK_PARAM, (com.oplus.ocs.camera.CameraParameter.PreviewKey<android.os.Bundle>) bundle);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(long j_renamed) {
        c_renamed(com.oplus.camera.e_renamed.b_renamed.D_renamed, (android.hardware.camera2.CaptureRequest.Key<java.lang.Long>) java.lang.Long.valueOf(j_renamed));
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(byte b2) {
        com.oplus.camera.e_renamed.b_renamed("OneCameraImpl", "setMovieLogEnable, mCameraRole: " + this.w_renamed + ", enable: " + ((int) b2));
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Byte>>) com.oplus.ocs.camera.CameraParameter.MOVIE_LOG_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Byte>) java.lang.Byte.valueOf(b2));
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(byte b2) {
        com.oplus.camera.e_renamed.b_renamed("OneCameraImpl", "setMovieHdrEnable, mCameraRole: " + this.w_renamed + ", enable: " + ((int) b2));
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Byte>>) com.oplus.ocs.camera.CameraParameter.MOVIE_HDR_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Byte>) java.lang.Byte.valueOf(b2));
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void k_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setMirror, mCameraRole: " + this.w_renamed + ", enable: " + z_renamed);
        android.util.Pair pairA = a_renamed(com.oplus.camera.util.Util.C_renamed() ? "com.oplus.mirror.enable" : "com.mediatek.control.capture.flipmode", (java.lang.String) new int[]{z_renamed ? 1 : 0});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public boolean d_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "isCloseStreamTaskFinished, mCameraRole: " + this.w_renamed + ", getSurfaceType: " + this.Z_renamed.c_renamed() + ", isFinished: " + this.Z_renamed.a_renamed() + ", isNeedWaitCloseStream: " + this.Z_renamed.b_renamed());
        return (str.equals(this.Z_renamed.c_renamed()) && !this.Z_renamed.a_renamed() && this.Z_renamed.b_renamed()) ? false : true;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.e_renamed.c_renamed cVar;
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "closeCaptureStream, type: " + str + ", restartPreview: " + z_renamed);
        if ("type_still_capture_raw".equals(str) && (cVar = this.X_renamed) != null) {
            cVar.f4425c = false;
        }
        if (z_renamed) {
            a_renamed(this.al_renamed, 0);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public boolean j_renamed() {
        com.oplus.ocs.camera.CameraDevice cameraDevice = this.B_renamed;
        if (cameraDevice == null) {
            return false;
        }
        return cameraDevice.notifyLastCaptureFrame();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void m_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setLongExposuereScene, scene: " + i_renamed);
        c_renamed(com.oplus.camera.e_renamed.b_renamed.A_renamed, (android.hardware.camera2.CaptureRequest.Key<java.lang.Integer>) java.lang.Integer.valueOf(i_renamed));
    }

    /* compiled from: OneCameraImpl.java */
    private class a_renamed implements java.lang.Runnable {

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.lang.String f4445b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private boolean f4446c;
        private boolean d_renamed;
        private boolean e_renamed;
        private boolean f_renamed;

        private a_renamed() {
            this.f4445b = null;
            this.f4446c = false;
            this.d_renamed = false;
            this.e_renamed = false;
            this.f_renamed = true;
        }

        public void a_renamed(boolean z_renamed, boolean z2) {
            this.e_renamed = z_renamed;
            this.f_renamed = z2;
        }

        public void a_renamed(boolean z_renamed) {
            com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setFinish, mCameraRole: " + com.oplus.camera.e_renamed.e_renamed.this.w_renamed + ", finish: " + z_renamed);
            this.d_renamed = z_renamed;
        }

        public boolean a_renamed() {
            return this.d_renamed;
        }

        public boolean b_renamed() {
            return this.f_renamed;
        }

        public java.lang.String c_renamed() {
            return this.f4445b;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "CloseStreamTask, mCameraRole: " + com.oplus.camera.e_renamed.e_renamed.this.w_renamed + ", mOutSurfaceMap: " + com.oplus.camera.e_renamed.e_renamed.this.H_renamed.get(this.f4445b) + ", mSurfaceType: " + this.f4445b + ", mbWillCloseSession:" + this.e_renamed);
            a_renamed(true);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void n_renamed(boolean z_renamed) {
        this.Z_renamed.a_renamed(true, z_renamed);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void e_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "closeStream, mCameraRole: " + this.w_renamed + ", type: " + str);
        if (this.u_renamed == 7 || this.u_renamed == 5) {
            this.p_renamed.post(this.Z_renamed);
        }
        this.ad_renamed.open();
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void n_renamed(int i_renamed) {
        android.util.Pair pairA = a_renamed("com.oplus.camera.3d.api.state", (java.lang.String) new int[]{i_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(float f_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setBokehLevel, mCameraRole: " + this.w_renamed + ", level: " + f_renamed);
        android.util.Pair pairA = a_renamed("com.oplus.bokeh.level", (java.lang.String) new float[]{f_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void o_renamed(int i_renamed) {
        android.util.Pair pairA = a_renamed("com.oplus.supernight.mode", (java.lang.String) new int[]{i_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void q_renamed(int i_renamed) {
        android.util.Pair pairA = a_renamed(com.oplus.camera.util.Util.C_renamed() ? "com.oplus.rear.remosaic.enable" : "com.mediatek.control.capture.remosaicenable", (java.lang.String) new int[]{i_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void r_renamed(int i_renamed) {
        c_renamed(com.oplus.camera.e_renamed.b_renamed.aS_renamed, (android.hardware.camera2.CaptureRequest.Key<int[]>) new int[]{i_renamed});
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void s_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setCaptureRaw10, format: " + i_renamed);
        c_renamed(com.oplus.camera.e_renamed.b_renamed.aT_renamed, (android.hardware.camera2.CaptureRequest.Key<int[]>) new int[]{i_renamed});
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void u_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setBracketMode, mCameraRole: " + this.w_renamed + ", mode: " + i_renamed);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]>>) com.oplus.ocs.camera.CameraParameter.PREVIEW_BRACKET_MODE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]>) new int[]{i_renamed});
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void v_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.b_renamed("OneCameraImpl", "updateAsdSceneValue, mCameraRole: " + this.w_renamed + ", value: " + i_renamed);
        c_renamed(com.oplus.camera.e_renamed.b_renamed.bz_renamed, (android.hardware.camera2.CaptureRequest.Key<java.lang.Integer>) java.lang.Integer.valueOf(i_renamed));
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void r_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setRearAicolorEnable, mCameraRole: " + this.w_renamed + ", enable: " + z_renamed);
        android.util.Pair pairA = a_renamed("com.oplus.aicolor.rear.enable", (java.lang.String) new int[]{z_renamed ? 1 : 0});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void s_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setVideoNeonEnable, mCameraRole: " + this.w_renamed + ", enable: " + z_renamed);
        c_renamed(com.oplus.camera.e_renamed.b_renamed.bD_renamed, (android.hardware.camera2.CaptureRequest.Key<int[]>) new int[]{z_renamed ? 1 : 0});
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.VIDEO_NEON_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (z_renamed ? "on_renamed" : "off"));
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void t_renamed(boolean z_renamed) {
        c_renamed(com.oplus.camera.e_renamed.b_renamed.bC_renamed, (android.hardware.camera2.CaptureRequest.Key<int[]>) new int[]{z_renamed ? 1 : 0});
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.VIDEO_BLUR_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) (z_renamed ? "on_renamed" : "off"));
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void u_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setMtkAIShutterEnable, mtkAIShutterEnable: " + z_renamed);
        android.util.Pair pairA = a_renamed("com.mediatek.3afeature.aishutCapture", (java.lang.String) new int[]{z_renamed ? 1 : 0});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(byte[] bArr) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setTuningDataEnable, mCameraRole: " + this.w_renamed + ", type: " + java.util.Arrays.toString(bArr));
        c_renamed(com.oplus.camera.e_renamed.b_renamed.aO_renamed, (android.hardware.camera2.CaptureRequest.Key<byte[]>) bArr);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public int t_renamed() {
        return this.U_renamed;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public com.oplus.camera.e_renamed.c_renamed v_renamed() {
        return this.X_renamed;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void w_renamed() {
        this.U_renamed = 0;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void p_renamed(boolean z_renamed) {
        if (z_renamed) {
            c_renamed(com.oplus.camera.e_renamed.b_renamed.aw_renamed, (android.hardware.camera2.CaptureRequest.Key<int[]>) new int[]{1});
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void v_renamed(boolean z_renamed) {
        android.util.Pair pairA = a_renamed(com.oplus.camera.util.Util.C_renamed() ? "com.oplus.ultra.resolution.mode" : "com.oplus.ultra.high.resolution.enable", (java.lang.String) new int[]{z_renamed ? 1 : 0});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(boolean z_renamed, java.lang.String str) {
        int[] iArrA;
        if (this.D_renamed.J_renamed() && z_renamed && (iArrA = this.D_renamed.a_renamed(str)) != null) {
            android.util.Pair pairA = a_renamed("com.mediatek.smvrfeature.smvrMode", (java.lang.String) iArrA);
            c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(android.util.Range range) {
        if (range == null) {
            return;
        }
        com.oplus.camera.e_renamed.b_renamed("OneCameraImpl", "setVideoFpsRange: " + range.toString() + ", mCameraRole: " + this.w_renamed);
        if (this.D_renamed.J_renamed()) {
            a_renamed(this.al_renamed, 0);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void w_renamed(int i_renamed) {
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]>>) com.oplus.ocs.camera.CameraParameter.PICTURE_EXIF_FLAG, (com.oplus.ocs.camera.CameraParameter.PreviewKey<int[]>) new int[]{i_renamed});
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void x_renamed(boolean z_renamed) {
        if (com.oplus.camera.util.Util.C_renamed()) {
            return;
        }
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setMsnr, mCameraRole: " + this.w_renamed + ", enable: " + z_renamed);
        android.util.Pair pairA = a_renamed("com.mediatek.control.capture.singleYuvNr.mode", (java.lang.String) new int[]{z_renamed ? 1 : 0});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void x_renamed() {
        com.oplus.camera.e_renamed.a_renamed.a_renamed aVar = this.an_renamed;
        if (aVar != null) {
            aVar.d_renamed();
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void y_renamed(boolean z_renamed) {
        if (this.B_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setZoomActive, active: " + z_renamed);
            b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.ZOOM_ACTIVE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(z_renamed));
            a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(float f_renamed) {
        if (this.B_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setZoomTarget, zoom: " + f_renamed);
            c_renamed(com.oplus.ocs.camera.CameraParameter.ZOOM_TARGET, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Float>) new float[]{f_renamed});
            a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void z_renamed(boolean z_renamed) {
        android.util.Pair pairA = a_renamed("com.oplus.salient.object.detection.enable", (java.lang.String) new int[]{z_renamed ? 1 : 0});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(com.oplus.camera.v_renamed.c_renamed cVar) {
        this.af_renamed = cVar;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void f_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setOffsetTime, mCameraRole: " + this.w_renamed + ", offsetTime: " + str);
        android.util.Pair pairA = a_renamed("com.oplus.picture.offset.time", (java.lang.String) str.getBytes());
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(byte[] bArr) {
        c_renamed(com.oplus.camera.e_renamed.b_renamed.f4420a, (android.hardware.camera2.CaptureRequest.Key<byte[]>) bArr);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void x_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.b_renamed("OneCameraImpl", "setNightIso, mCameraRole: " + this.w_renamed + ", iso: " + i_renamed);
        android.util.Pair pairA = a_renamed("com.oplus.sensor.night.sensitivity", (java.lang.String) new int[]{i_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
        a_renamed(this.al_renamed, 0);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(long j_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setNightExposureTime, mCameraRole: " + this.w_renamed + ", exposureTime: " + j_renamed);
        android.util.Pair pairA = a_renamed("com.oplus.sensor.night.exposureTime", (java.lang.String) new long[]{j_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
        a_renamed(this.al_renamed, 0);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void c_renamed(long j_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setHighPictureProExposureTime, mCameraRole: " + this.w_renamed + ", exposureTime: " + j_renamed);
        android.util.Pair pairA = a_renamed("com.oplus.highpicture.professional.exposureTime", (java.lang.String) new long[]{j_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
        a_renamed(this.al_renamed, 0);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void B_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setMicrospurEnable, enable: " + z_renamed);
        int[] iArr = new int[1];
        iArr[0] = z_renamed ? 0 : 2;
        android.util.Pair pairA = a_renamed("com.oplus.fallback.disableMask", (java.lang.String) iArr);
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void y_renamed(int i_renamed) {
        android.util.Pair pairA = a_renamed("com.oplus.highpicture.professional.enable", (java.lang.String) new int[]{i_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void A_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setTrackEnable, mCameraRole: " + this.w_renamed + ", enable: " + z_renamed);
        android.util.Pair pairA = a_renamed("com.oplus.sod.enable", (java.lang.String) new byte[]{z_renamed ? (byte) 1 : (byte) 0});
        if (this.B_renamed == null || !J_renamed()) {
            return;
        }
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void b_renamed(int[] iArr) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "trackTouchRegion, region: " + java.util.Arrays.toString(iArr));
        android.util.Pair pairA = a_renamed("com.oplus.sod.touch.region", (java.lang.String) iArr);
        if (this.B_renamed == null || !J_renamed()) {
            return;
        }
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void C_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setPortraitNeon, enable: " + z_renamed);
        android.util.Pair pairA = a_renamed("com.oplus.portrait.neon", (java.lang.String) new int[]{z_renamed ? 1 : 0});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void D_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setVideoRetention, enable: " + z_renamed);
        android.util.Pair pairA = a_renamed("com.oplus.video.retention", (java.lang.String) new int[]{z_renamed ? 1 : 0});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void z_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setLSDEnable, enable: " + i_renamed);
        android.util.Pair pairA = a_renamed("com.oplus.lsd.enable", (java.lang.String) new int[]{i_renamed});
        c_renamed((android.hardware.camera2.CaptureRequest.Key) pairA.first, (android.hardware.camera2.CaptureRequest.Key) pairA.second);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void g_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setGestureCaptureEnable, enable: " + str);
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>>) com.oplus.ocs.camera.CameraParameter.KEY_GESTURE_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String>) str);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public com.oplus.ocs.camera.CameraDeviceInfo a_renamed(java.lang.String str, java.lang.String str2) {
        com.oplus.camera.e_renamed.c_renamed("OneCameraImpl", "getCameraDeviceInfo, modeName: " + str + ", cameraType: " + str2);
        com.oplus.ocs.camera.CameraDevice cameraDevice = this.B_renamed;
        if (cameraDevice != null) {
            return cameraDevice.getCameraDeviceInfo(str, str2);
        }
        return null;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public com.oplus.ocs.camera.CameraDeviceConfig.Builder y_renamed() {
        return this.B_renamed.createCameraDeviceConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.ocs.camera.CameraPreviewCallback cameraPreviewCallback) {
        com.oplus.camera.e_renamed.a_renamed("setRepeatingRequest", "50pv_setRepeatingRequest", com.oplus.camera.d_renamed.d_renamed.longValue());
        java.util.LinkedHashMap<java.lang.String, android.view.Surface> linkedHashMap = this.H_renamed;
        if (linkedHashMap == null || linkedHashMap.size() == 0) {
            P_renamed();
        }
        this.B_renamed.startPreview(this.H_renamed, cameraPreviewCallback, this.q_renamed);
        com.oplus.camera.perf.b_renamed.c_renamed("launch_request_repeating");
        com.oplus.camera.e_renamed.d_renamed("setRepeatingRequest", "50pv_setRepeatingRequest");
    }

    @Override // com.oplus.camera.e_renamed.g_renamed
    protected void a_renamed(com.oplus.ocs.camera.CameraDeviceConfig.Builder builder, com.oplus.camera.e_renamed.d_renamed.OneCamera_5 interfaceC0097d, int i_renamed) {
        com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "createNewSession");
        if (this.B_renamed == null) {
            com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "createNewSession, mCameraDevice is_renamed null");
            return;
        }
        com.oplus.camera.w_renamed.a_renamed.a_renamed().a_renamed(com.oplus.camera.util.Util.l_renamed(), com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_CAPTURE_MODE, java.lang.Integer.valueOf(i_renamed));
        B_renamed(4);
        Q_renamed();
        this.ab_renamed.close();
        com.oplus.camera.e_renamed.a_renamed("createNewSession");
        this.E_renamed = interfaceC0097d;
        if (a_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("OneCameraImpl", "createNewSession, camera device has been closed");
        } else {
            com.oplus.camera.e_renamed.d_renamed.OneCamera_5 interfaceC0097d2 = this.E_renamed;
            if (interfaceC0097d2 != null) {
                interfaceC0097d2.a_renamed(builder);
            }
            this.B_renamed.configure(builder.build());
            com.oplus.camera.perf.b_renamed.c_renamed("launch_create_session");
        }
        this.ab_renamed.block();
        com.oplus.camera.e_renamed.b_renamed("createNewSession");
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(com.oplus.ocs.camera.CameraPictureCallback cameraPictureCallback) {
        this.ak_renamed = cameraPictureCallback;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public boolean u_renamed() {
        com.oplus.camera.e_renamed.c_renamed("OneCameraImpl", "getRecordingLockStatus, mbRecordingLockStatus: " + this.ah_renamed);
        return this.ah_renamed;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void w_renamed(boolean z_renamed) {
        synchronized (this.ae_renamed) {
            com.oplus.camera.e_renamed.c_renamed("OneCameraImpl", "setRecordingLockStatus, status: " + z_renamed + ", mbRecordingLockStatus: " + this.ah_renamed);
            if (this.ah_renamed && !z_renamed) {
                this.ae_renamed.open();
            }
            this.ah_renamed = z_renamed;
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(com.oplus.ocs.camera.CameraRecordingCallback cameraRecordingCallback, android.os.Handler handler) {
        com.oplus.camera.e_renamed.c_renamed("OneCameraImpl", "startRecording, mDeviceState: " + this.u_renamed);
        this.ae_renamed.close();
        w_renamed(true);
        if (5 == this.u_renamed) {
            this.B_renamed.startRecording(cameraRecordingCallback, handler);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void z_renamed() {
        com.oplus.camera.e_renamed.c_renamed("OneCameraImpl", "stopRecording, mDeviceState: " + this.u_renamed);
        if (this.B_renamed != null && 5 == this.u_renamed) {
            this.B_renamed.stopRecording();
        }
        this.ae_renamed.open();
        w_renamed(false);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void A_renamed() {
        com.oplus.camera.e_renamed.c_renamed("OneCameraImpl", "pauseRecording, mDeviceState: " + this.u_renamed);
        if (5 == this.u_renamed) {
            this.B_renamed.pauseRecording();
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void B_renamed() {
        com.oplus.camera.e_renamed.c_renamed("OneCameraImpl", "resumeRecording, mDeviceState: " + this.u_renamed);
        if (5 == this.u_renamed) {
            this.B_renamed.resumeRecording();
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, android.hardware.camera2.CaptureResult captureResult, int i_renamed, int i2, int i3) {
        com.oplus.ocs.camera.CameraDevice cameraDevice = this.B_renamed;
        return cameraDevice != null ? cameraDevice.processBitmap(bitmap, captureResult, i_renamed, i2, i3) : bitmap;
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void E_renamed(boolean z_renamed) {
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>>) com.oplus.ocs.camera.CameraParameter.KEY_EDGE_FILTER_ENABLE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Boolean>) java.lang.Boolean.valueOf(z_renamed));
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(java.lang.String[] strArr) {
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String[]>>) com.oplus.ocs.camera.CameraParameter.KEY_EDGE_FILTER_PARAM, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.String[]>) strArr);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void a_renamed(float f_renamed, float f2) {
        com.oplus.camera.e_renamed.a_renamed("OneCameraImpl", "setCurTemperature, temperature: " + f_renamed + ", threshold: " + f2);
        c_renamed(com.oplus.camera.e_renamed.b_renamed.f4422c, (android.hardware.camera2.CaptureRequest.Key<float[]>) new float[]{f_renamed, f2});
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void d_renamed(long j_renamed) {
        com.oplus.ocs.camera.CameraDevice cameraDevice = this.B_renamed;
        if (cameraDevice != null) {
            cameraDevice.updateThumbnailMap(j_renamed);
        }
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void A_renamed(int i_renamed) {
        b_renamed((com.oplus.ocs.camera.CameraParameter.PreviewKey<com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>>) com.oplus.ocs.camera.CameraParameter.VIDEO_EIS_RECORD_STATE, (com.oplus.ocs.camera.CameraParameter.PreviewKey<java.lang.Integer>) java.lang.Integer.valueOf(i_renamed));
        a_renamed(this.al_renamed, 0);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void C_renamed() {
        B_renamed(3);
    }

    @Override // com.oplus.camera.e_renamed.d_renamed
    public void F_renamed(boolean z_renamed) {
        com.oplus.ocs.camera.CameraDevice cameraDevice = this.B_renamed;
        if (cameraDevice != null) {
            cameraDevice.stopPreview(z_renamed);
        }
    }
}
