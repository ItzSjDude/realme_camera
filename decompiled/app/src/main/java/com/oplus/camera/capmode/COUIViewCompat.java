package com.oplus.camera.capmode;

/* compiled from: StickerMode.java */
/* loaded from: classes2.dex */
public class t_renamed extends com.oplus.camera.capmode.w_renamed {
    private int A_renamed;
    private long B_renamed;
    private long C_renamed;
    private boolean D_renamed;
    private com.oplus.camera.Storage.CameraPicture E_renamed;
    private boolean F_renamed;
    private boolean G_renamed;
    private com.oplus.camera.ui.preview.a_renamed.p_renamed H_renamed;
    private com.oplus.camera.sticker.ui.i_renamed I_renamed;
    private final java.lang.Object g_renamed;
    private final java.lang.Runnable h_renamed;
    private com.oplus.camera.sticker.ui.h_renamed i_renamed;
    private com.oplus.camera.sticker.ui.l_renamed j_renamed;
    private com.oplus.camera.ui.preview.a_renamed.v_renamed k_renamed;
    private java.lang.Float l_renamed;
    private java.lang.Float m_renamed;
    private java.lang.Integer n_renamed;
    private java.lang.Integer o_renamed;
    private java.lang.Long p_renamed;
    private android.media.ImageReader q_renamed;
    private android.media.ImageReader r_renamed;
    private int s_renamed;
    private int t_renamed;
    private java.lang.String u_renamed;
    private java.util.HashMap<java.lang.String, java.lang.Long> v_renamed;
    private java.util.HashMap<java.lang.String, java.lang.Integer> w_renamed;
    private java.util.ArrayList<com.oplus.camera.sticker.ui.h_renamed.b_renamed> x_renamed;
    private com.oplus.camera.sticker.ui.c_renamed y_renamed;
    private com.oplus.camera.aps.service.ThumbnailItem z_renamed;

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean checkPreviewResult(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision) {
        return true;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraFeature() {
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getCameraMode() {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultCaptureNumber() {
        return 1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getEffectMenuKeyByMode() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected java.lang.String getFaceBeautyKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_STICKER_FACEBEAUTY_LEVEL_MENU;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected int getFaceBeautyModeIndex() {
        return 4;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public java.lang.String getFilterEffectMenuPreferenceKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_STICKER_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public java.lang.String getFullPictureSizeType() {
        return "16_9";
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected java.lang.String getGuideLineKey() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_LINE_PHOTO;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getImageFormat() {
        return 35;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32782;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportQuickJpeg(com.oplus.camera.e_renamed.c_renamed cVar) {
        return false;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isCaptureModeType() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedAPSProcess() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedTransAnimWhenRecording() {
        return false;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaCodec() {
        return true;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean isVideoModeType() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needPreviewMeta(int i_renamed) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean performSlide(int i_renamed, android.view.MotionEvent motionEvent) {
        return false;
    }

    static /* synthetic */ int d_renamed(com.oplus.camera.capmode.t_renamed tVar) {
        int i_renamed = tVar.t_renamed;
        tVar.t_renamed = i_renamed + 1;
        return i_renamed;
    }

    public t_renamed(android.app.Activity activity, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, com.oplus.camera.ui.preview.a_renamed.t_renamed tVar) {
        super(activity, aVar, cameraUIInterface, tVar);
        this.g_renamed = new java.lang.Object();
        this.h_renamed = new java.lang.Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$Udg34mRWRHTn64j-v8WFCDjd4mQ
            @Override // java.lang.Runnable
            public final void run() throws java.lang.IllegalStateException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                this.f_renamed$0.aj_renamed();
            }
        };
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = new com.oplus.camera.capmode.t_renamed.a_renamed();
        this.l_renamed = null;
        this.m_renamed = null;
        this.n_renamed = null;
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = 0;
        this.t_renamed = 0;
        this.u_renamed = null;
        this.v_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.y_renamed = null;
        this.z_renamed = null;
        this.A_renamed = 0;
        this.B_renamed = 0L;
        this.C_renamed = 0L;
        this.D_renamed = false;
        this.E_renamed = null;
        this.F_renamed = false;
        this.G_renamed = false;
        this.H_renamed = new com.oplus.camera.ui.preview.a_renamed.p_renamed() { // from class: com.oplus.camera.capmode.t_renamed.1
            @Override // com.oplus.camera.ui.preview.a_renamed.p_renamed
            public void a_renamed(com.oplus.camera.ui.menu.levelcontrol.i_renamed iVar) {
            }

            @Override // com.oplus.camera.ui.preview.a_renamed.p_renamed
            public void a_renamed(java.util.ArrayList<com.oplus.camera.sticker.ui.h_renamed.b_renamed> arrayList, final int i_renamed, com.oplus.camera.sticker.data.StickerItem stickerItem, final boolean z_renamed) {
                com.oplus.camera.e_renamed.a_renamed("StickerMode", "updateAdapter, stickerItem: " + stickerItem + ", updateCategoryIndex: " + z_renamed + ", stickerCategoryIndex: " + i_renamed);
                if (com.oplus.camera.capmode.t_renamed.this.x_renamed != null) {
                    com.oplus.camera.capmode.t_renamed.this.x_renamed.clear();
                } else {
                    com.oplus.camera.capmode.t_renamed.this.x_renamed = new java.util.ArrayList();
                }
                com.oplus.camera.capmode.t_renamed.this.x_renamed.addAll(arrayList);
                if (com.oplus.camera.capmode.t_renamed.this.i_renamed == null || com.oplus.camera.capmode.t_renamed.this.mActivity == null || com.oplus.camera.capmode.t_renamed.this.x_renamed.size() <= 0) {
                    return;
                }
                com.oplus.camera.capmode.t_renamed.this.i_renamed.a_renamed(stickerItem, true);
                com.oplus.camera.capmode.t_renamed.this.i_renamed.a_renamed(stickerItem);
                com.oplus.camera.capmode.t_renamed.this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.oplus.camera.capmode.t_renamed.this.i_renamed != null) {
                            com.oplus.camera.capmode.t_renamed.this.i_renamed.a_renamed(com.oplus.camera.capmode.t_renamed.this.x_renamed, i_renamed, z_renamed);
                        }
                    }
                });
            }
        };
        this.I_renamed = new com.oplus.camera.sticker.ui.i_renamed() { // from class: com.oplus.camera.capmode.t_renamed.12
            @Override // com.oplus.camera.sticker.ui.i_renamed
            public void d_renamed() {
            }

            @Override // com.oplus.camera.sticker.ui.i_renamed
            public void a_renamed(boolean z_renamed) {
                com.oplus.camera.e_renamed.a_renamed("StickerMode", "beforeEnterAnimator");
                com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.d_renamed(false, false);
                com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.a_renamed(true, false);
                com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.a_renamed(4, false);
                com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.j_renamed(true, false);
                com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.m_renamed(z_renamed);
                if (com.oplus.camera.capmode.t_renamed.this.mCameraInterface != null) {
                    com.oplus.camera.capmode.t_renamed.this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
                }
                com.oplus.camera.capmode.t_renamed.this.a_renamed(false);
            }

            @Override // com.oplus.camera.sticker.ui.i_renamed
            public void a_renamed() {
                com.oplus.camera.e_renamed.a_renamed("StickerMode", "afterEnterAnimator");
                com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.f_renamed(true, true);
                com.oplus.camera.statistics.CameraStatisticsUtil.onCommon(com.oplus.camera.capmode.t_renamed.this.mActivity, com.oplus.camera.statistics.CameraStatisticsUtil.EVENT_MENU_CLICK, com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_MODE_CLICK_STICKER_MENU, "1"));
                com.oplus.camera.capmode.t_renamed.this.b_renamed(true);
            }

            @Override // com.oplus.camera.sticker.ui.i_renamed
            public void b_renamed() {
                com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.g_renamed(true, true);
                if (com.oplus.camera.capmode.t_renamed.this.mCameraInterface != null && !com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.A_renamed()) {
                    com.oplus.camera.capmode.t_renamed.this.mCameraInterface.a_renamed(true, false);
                }
                com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.d_renamed(false, false);
            }

            @Override // com.oplus.camera.sticker.ui.i_renamed
            public void c_renamed() {
                if (!com.oplus.camera.capmode.t_renamed.this.getIsCapturingState()) {
                    com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.d_renamed(true, true);
                }
                if (com.oplus.camera.capmode.t_renamed.this.mCameraInterface != null && !com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.A_renamed()) {
                    com.oplus.camera.capmode.t_renamed.this.mCameraInterface.d_renamed(true);
                }
                com.oplus.camera.capmode.t_renamed.this.b_renamed(false);
                com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.aB_renamed();
            }

            @Override // com.oplus.camera.sticker.ui.i_renamed
            public void b_renamed(boolean z_renamed) {
                if (z_renamed) {
                    com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.c_renamed(0);
                } else {
                    com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.g_renamed(true, true);
                    if (com.oplus.camera.capmode.t_renamed.this.mCameraInterface != null && !com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.A_renamed()) {
                        com.oplus.camera.capmode.t_renamed.this.mCameraInterface.a_renamed(true, false);
                        com.oplus.camera.capmode.t_renamed.this.mCameraInterface.d_renamed(true);
                    }
                }
                com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.d_renamed(true, true);
                com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.aB_renamed();
            }

            @Override // com.oplus.camera.sticker.ui.i_renamed
            public boolean a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem, int i_renamed) {
                return com.oplus.camera.capmode.t_renamed.this.a_renamed(stickerItem, i_renamed);
            }

            @Override // com.oplus.camera.sticker.ui.i_renamed
            public boolean a_renamed(android.view.View view, com.oplus.camera.sticker.data.StickerItem stickerItem, int i_renamed) {
                return com.oplus.camera.capmode.t_renamed.this.a_renamed(view, stickerItem, i_renamed);
            }

            @Override // com.oplus.camera.sticker.ui.i_renamed
            public void e_renamed() {
                com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.V_renamed();
            }

            @Override // com.oplus.camera.sticker.ui.i_renamed
            public void a_renamed(java.lang.String str) {
                com.oplus.camera.capmode.t_renamed.this.a_renamed(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_MENU_CATERGORY_FLING, str);
            }

            @Override // com.oplus.camera.sticker.ui.i_renamed
            public void b_renamed(java.lang.String str) {
                com.oplus.camera.capmode.t_renamed.this.a_renamed(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_MENU_CATERGORY_CLICK, str);
                com.oplus.camera.capmode.t_renamed.this.a_renamed(str);
            }

            @Override // com.oplus.camera.sticker.ui.i_renamed
            public com.oplus.camera.sticker.data.StickerItem f_renamed() {
                if (com.oplus.camera.capmode.t_renamed.this.mPreviewEffectProcess != null) {
                    return com.oplus.camera.capmode.t_renamed.this.mPreviewEffectProcess.j_renamed();
                }
                return null;
            }

            @Override // com.oplus.camera.sticker.ui.i_renamed
            public void g_renamed() {
                com.oplus.camera.capmode.t_renamed.this.a_renamed();
            }

            @Override // com.oplus.camera.sticker.ui.i_renamed
            public void h_renamed() {
                if (com.oplus.camera.capmode.t_renamed.this.i_renamed != null) {
                    com.oplus.camera.sticker.data.StickerItem stickerItemJ = com.oplus.camera.capmode.t_renamed.this.mPreviewEffectProcess != null ? com.oplus.camera.capmode.t_renamed.this.mPreviewEffectProcess.j_renamed() : null;
                    if (stickerItemJ != null) {
                        com.oplus.camera.ui.preview.a_renamed.q_renamed qVarB = com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(com.oplus.camera.capmode.t_renamed.this.mActivity);
                        java.lang.String stickerUUID = stickerItemJ.getStickerUUID();
                        boolean zA = qVarB.a_renamed(stickerUUID);
                        if (com.oplus.camera.capmode.t_renamed.this.mPreviewEffectProcess != null) {
                            if (zA) {
                                com.oplus.camera.capmode.t_renamed.this.mPreviewEffectProcess.d_renamed();
                            } else {
                                com.oplus.camera.capmode.t_renamed.this.mPreviewEffectProcess.c_renamed();
                            }
                        }
                        qVarB.a_renamed(stickerUUID, !zA);
                        com.oplus.camera.capmode.t_renamed.this.i_renamed.b_renamed(stickerUUID);
                        return;
                    }
                    com.oplus.camera.e_renamed.f_renamed("StickerMode", "onMusicButtonClick, non selected stickerItem!");
                }
            }

            @Override // com.oplus.camera.sticker.ui.i_renamed
            public boolean i_renamed() {
                if (com.oplus.camera.capmode.t_renamed.this.mCameraInterface == null) {
                    return false;
                }
                if (!com.oplus.camera.capmode.t_renamed.this.mCameraInterface.C_renamed() && !com.oplus.camera.capmode.t_renamed.this.mCameraInterface.F_renamed() && !com.oplus.camera.capmode.t_renamed.this.mCameraInterface.E_renamed() && !com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.B_renamed() && !com.oplus.camera.capmode.t_renamed.this.mbInCapturing && com.oplus.camera.capmode.t_renamed.this.isVideoRecordStopped()) {
                    return true;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("canItemClick, !mCameraInterface.isDoubleFinger: ");
                sb.append(!com.oplus.camera.capmode.t_renamed.this.mCameraInterface.C_renamed());
                sb.append(", !mCameraInterface.getCaptureModeChangeState: ");
                sb.append(!com.oplus.camera.capmode.t_renamed.this.mCameraInterface.F_renamed());
                sb.append(", !mCameraUIInterface.isAnimationRunning: ");
                sb.append(!com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.B_renamed());
                sb.append(", isVideoRecordStopped: ");
                sb.append(com.oplus.camera.capmode.t_renamed.this.isVideoRecordStopped());
                sb.append(", !mbInCapturing: ");
                sb.append(!com.oplus.camera.capmode.t_renamed.this.mbInCapturing);
                sb.append(", !mCameraInterface.getSwitchingCameraState: ");
                sb.append(!com.oplus.camera.capmode.t_renamed.this.mCameraInterface.E_renamed());
                com.oplus.camera.e_renamed.f_renamed("StickerMode", sb.toString());
                return false;
            }
        };
        com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mActivity).a_renamed(this.k_renamed);
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void showRecordingTimeUI() {
        this.mCameraUIInterface.a_renamed(getRealVideoTimeRatio(), this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.record_quick_time_margin_top), needShowVideoTime(), true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getNeedCheckTimeStamp() {
        return isFlashState();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void hideViewWhileResume() {
        a_renamed(false, true);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "onResume");
        super.onResume(z_renamed);
        this.B_renamed = java.lang.System.currentTimeMillis();
        this.mPreviewEffectProcess.g_renamed();
        this.i_renamed.a_renamed(z_renamed, isShowAnimojiMenu());
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STICKER)) {
            d_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getBubbleOffsetY(int i_renamed) {
        if (i_renamed != 4) {
            return 0;
        }
        return this.mActivity.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.bubble_type_short_video_offset_y);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onSessionConfigured() {
        super.onSessionConfigured();
        if (this.mCameraInterface.S_renamed()) {
            this.mCameraUIInterface.J_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void closeImageReader() {
        com.oplus.camera.e_renamed.b_renamed("StickerMode", "closeImageReader");
        android.media.ImageReader imageReader = this.q_renamed;
        if (imageReader != null) {
            imageReader.close();
            this.q_renamed = null;
        }
        android.media.ImageReader imageReader2 = this.r_renamed;
        if (imageReader2 != null) {
            imageReader2.close();
            this.r_renamed = null;
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "onPause");
        com.oplus.camera.sticker.ui.l_renamed lVar = this.j_renamed;
        if (lVar != null && lVar.isShowing()) {
            this.j_renamed.dismiss();
        }
        this.i_renamed.b_renamed();
        this.mCameraUIInterface.C_renamed();
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO)) {
            this.mCameraUIInterface.f_renamed(4, true);
        }
        j_renamed();
        super.onPause();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO)) {
            this.mCameraUIInterface.f_renamed(4, true);
        }
        com.oplus.camera.sticker.ui.c_renamed cVar = this.y_renamed;
        if (cVar != null) {
            cVar.a_renamed();
            com.oplus.camera.sticker.ui.c_renamed.b_renamed();
        }
        com.oplus.camera.sticker.ui.h_renamed hVar = this.i_renamed;
        if (hVar != null) {
            hVar.c_renamed();
            this.i_renamed = null;
        }
        com.oplus.camera.sticker.ui.l_renamed lVar = this.j_renamed;
        if (lVar != null) {
            lVar.c_renamed();
            this.j_renamed = null;
        }
        com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mActivity).e_renamed();
        super.onDestroy();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void setOrientation(int i_renamed) {
        this.mOrientation = i_renamed;
        this.i_renamed.b_renamed(this.mOrientation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a_renamed(final com.oplus.camera.sticker.data.StickerItem stickerItem, boolean z_renamed) {
        if (stickerItem == null || this.mCameraInterface.S_renamed() || this.mOneCamera == null) {
            com.oplus.camera.e_renamed.f_renamed("StickerMode", "onStickerItemChange, item: " + stickerItem + ", isBlurAnimRunning: " + this.mCameraInterface.S_renamed() + ", mOneCamera: " + this.mOneCamera);
            return false;
        }
        com.oplus.camera.e_renamed.b_renamed("StickerMode", "onStickerItemChange, item: " + stickerItem);
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_STICKER_PROCESS)) {
            if (this.mPreviewEffectProcess != null && (!this.mPreviewEffectProcess.b_renamed(stickerItem) || z_renamed)) {
                com.oplus.camera.sticker.data.StickerItem stickerItemJ = this.mPreviewEffectProcess.j_renamed();
                if (stickerItemJ != null) {
                    b_renamed(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_MENU_ITEM_USETIME, stickerItemJ.getStickerUUID());
                }
                this.mPreviewEffectProcess.a_renamed(stickerItem);
                if (com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(stickerItem)) {
                    this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.13
                        @Override // java.lang.Runnable
                        public void run() {
                            if (com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface == null) {
                                return;
                            }
                            com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.n_renamed(false, false);
                            com.oplus.camera.capmode.t_renamed.this.b_renamed();
                            com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.j_renamed(true, false);
                        }
                    });
                    if (this.mbCapModeInit) {
                        applyBeautyParam();
                    }
                } else {
                    this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.14
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!com.oplus.camera.capmode.t_renamed.this.mbCapModeInit || com.oplus.camera.capmode.t_renamed.this.isStickerMenuOpen() || com.oplus.camera.capmode.t_renamed.this.mbPaused) {
                                return;
                            }
                            com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.l_renamed(true, false);
                            com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.v_renamed(true);
                        }
                    });
                    if (this.mbCapModeInit) {
                        applyBeautyParam();
                    }
                }
                android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
                editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_CURRENT_STICKER_UUID, stickerItem.getStickerUUID());
                editorEdit.apply();
                if (this.i_renamed != null) {
                    if (stickerItemJ != null && stickerItemJ.getCategoryId() != null && !stickerItemJ.getCategoryId().equals(stickerItem.getCategoryId())) {
                        this.i_renamed.a_renamed(stickerItemJ.getCategoryId());
                    }
                    if (stickerItem.hasMusic()) {
                        this.i_renamed.d_renamed(stickerItem.getStickerUUID());
                        if (this.mPreviewEffectProcess != null) {
                            this.mPreviewEffectProcess.d_renamed();
                        }
                    } else {
                        this.i_renamed.h_renamed();
                        this.mPreviewEffectProcess.c_renamed();
                    }
                    if (stickerItem.getDownloadTime() == 0 && !com.oplus.camera.sticker.data.StickerCategoryItem.MY_CATEGORY_ID.equals(stickerItem.getCategoryId()) && !stickerItem.isRecycleBin()) {
                        com.oplus.camera.sticker.h_renamed.a_renamed(this.mActivity).a_renamed(stickerItem);
                    }
                }
                a_renamed(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_MENU_ITEM_SELECTED, stickerItem.getStickerUUID());
                this.mCameraUIInterface.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.15
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.camera.e_renamed.a_renamed("StickerMode", "onStickerItemChange, success, categoryId: " + stickerItem.getCategoryId());
                        com.oplus.camera.capmode.t_renamed.this.mPreviewEffectProcess.e_renamed();
                    }
                });
                this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.oplus.camera.capmode.t_renamed.this.i_renamed != null) {
                            com.oplus.camera.capmode.t_renamed.this.i_renamed.c_renamed(true);
                        }
                    }
                });
                a_renamed(stickerItem, com.oplus.camera.sticker.data.StickerCategoryItem.MY_CATEGORY_ID.equals(stickerItem.getCategoryId()), com.oplus.camera.statistics.model.StickerMsgData.STICKER_OPER_SELECT);
            } else {
                this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.17
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.oplus.camera.capmode.t_renamed.this.i_renamed != null) {
                            com.oplus.camera.capmode.t_renamed.this.i_renamed.c_renamed(false);
                        }
                    }
                });
                b_renamed(stickerItem);
                a_renamed(stickerItem, com.oplus.camera.sticker.data.StickerCategoryItem.MY_CATEGORY_ID.equals(stickerItem.getCategoryId()), "cancel");
            }
            this.mActivity.runOnUiThread(new com.oplus.camera.capmode.t_renamed.StickerMode_2(stickerItem));
            return true;
        }
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "onStickerItemChange, failed index categoryId: " + stickerItem.getCategoryId());
        return true;
    }

    /* compiled from: StickerMode.java */
    /* renamed from: com.oplus.camera.capmode.t_renamed$18, reason: invalid class name */
    class StickerMode_2 implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ com.oplus.camera.sticker.data.StickerItem f4311a;

        StickerMode_2(com.oplus.camera.sticker.data.StickerItem stickerItem) {
            this.f4311a = stickerItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.oplus.camera.capmode.t_renamed.this.mActivity == null) {
                com.oplus.camera.e_renamed.f_renamed("StickerMode", "onStickerItemChange, mActivity is_renamed null, so return");
                return;
            }
            if (!com.oplus.camera.capmode.t_renamed.this.mbCapModeInit) {
                com.oplus.camera.e_renamed.e_renamed("StickerMode", "onStickerItemChange, already exited from sticker mode, so return");
                return;
            }
            if (!com.oplus.camera.ui.menu.g_renamed.c_renamed()) {
                com.oplus.camera.capmode.t_renamed.this.a_renamed(this.f4311a);
                return;
            }
            com.oplus.camera.ui.menu.g_renamed.d_renamed();
            com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemListB = com.oplus.camera.ui.menu.g_renamed.b_renamed();
            if (basicOptionItemListB != null) {
                final com.oplus.camera.sticker.data.StickerItem stickerItem = this.f4311a;
                basicOptionItemListB.setOnPopUpFadeOutAnimationStartListener(new com.oplus.camera.ui.menu.BasicOptionItemList.OnPopUpFadeOutAnimationStartListener() { // from class: com.oplus.camera.capmode.-$$Lambda$t_renamed$18$9g2NJHlzNOD6SDoUUxskFbcHuSc
                    @Override // com.oplus.camera.ui.menu.BasicOptionItemList.OnPopUpFadeOutAnimationStartListener
                    public final void onPopUpFadeOutAnimationEnd() {
                        this.f_renamed$0.a_renamed(stickerItem);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
            com.oplus.camera.capmode.t_renamed.this.a_renamed(stickerItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed() {
        if (!this.mbCapModeInit || isStickerMenuOpen()) {
            return;
        }
        if (this.mCameraUIInterface.K_renamed()) {
            this.mCameraUIInterface.j_renamed(0);
            this.mCameraUIInterface.j_renamed(true, false);
            this.mCameraUIInterface.a_renamed(0, true);
            b_renamed(true, false);
            return;
        }
        if (supportBeautyButton()) {
            this.mCameraUIInterface.j_renamed(0);
        } else {
            this.mCameraUIInterface.j_renamed(true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        this.mCameraUIInterface.i_renamed(getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_ASSISTANT_LINE));
        this.mCameraUIInterface.q_renamed();
        this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU);
        if (com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(stickerItem) && this.mCameraUIInterface.A_renamed()) {
            this.mCameraUIInterface.m_renamed(true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed() {
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.19
            @Override // java.lang.Runnable
            public void run() {
                if (com.oplus.camera.ui.menu.g_renamed.c_renamed()) {
                    com.oplus.camera.ui.menu.g_renamed.d_renamed();
                }
                com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.i_renamed(com.oplus.camera.capmode.t_renamed.this.getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_ASSISTANT_LINE));
                com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.q_renamed();
                com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.g_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU);
                if (com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(com.oplus.camera.capmode.t_renamed.this.mActivity).a_renamed(com.oplus.camera.capmode.t_renamed.this.mPreferences)) && com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.A_renamed()) {
                    com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.m_renamed(true, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        android.content.SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(com.oplus.camera.ui.CameraUIInterface.KEY_CURRENT_STICKER_UUID, "unselected_uuid");
        editorEdit.apply();
        if (this.mPreviewEffectProcess != null) {
            com.oplus.camera.sticker.data.StickerItem stickerItemJ = this.mPreviewEffectProcess.j_renamed();
            if (stickerItemJ != null) {
                b_renamed(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_MENU_ITEM_USETIME, stickerItemJ.getStickerUUID());
            }
            this.mPreviewEffectProcess.a_renamed((com.oplus.camera.sticker.data.StickerItem) null);
        }
        if (com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(stickerItem)) {
            applyBeautyParam();
            this.mOneCamera.a_renamed((com.oplus.camera.e_renamed.d_renamed.c_renamed) null);
        }
        if (stickerItem != null) {
            if (stickerItem.hasMusic()) {
                this.i_renamed.h_renamed();
                if (this.mPreviewEffectProcess != null) {
                    this.mPreviewEffectProcess.c_renamed();
                }
            }
            a_renamed(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_MENU_ITEM_UNSELECTED, stickerItem.getStickerUUID());
        }
        this.mCameraUIInterface.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.e_renamed.a_renamed("StickerMode", "unselectedStickerItem");
                if (com.oplus.camera.capmode.t_renamed.this.mPreviewEffectProcess != null) {
                    com.oplus.camera.capmode.t_renamed.this.mPreviewEffectProcess.e_renamed();
                }
            }
        });
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean updateViewByEnterCameraType() {
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "updateViewByEnterCameraType, mStickerMenu: " + this.i_renamed);
        if (this.i_renamed == null) {
            return false;
        }
        if (!com.oplus.camera.filmvideomode.b_renamed.b_renamed()) {
            this.i_renamed.d_renamed(false);
            return true;
        }
        com.oplus.camera.filmvideomode.b_renamed.a_renamed(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.capmode.t_renamed.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.filmvideomode.b_renamed.a_renamed((android.animation.ValueAnimator.AnimatorUpdateListener) null);
                com.oplus.camera.capmode.t_renamed.this.i_renamed.d_renamed(false);
            }
        });
        return true;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "onAfterStartPreview");
        if (!this.mCameraUIInterface.A_renamed()) {
            this.i_renamed.a_renamed(true);
            this.i_renamed.b_renamed(true);
        }
        super.onAfterStartPreview(z_renamed);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void beforeSwitchToMode(boolean z_renamed) {
        super.beforeSwitchToMode(z_renamed);
        enableVideoRecordingSound(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int i_renamed) {
        super.cameraIdChanged(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onCameraIdChangedAnimationEnd() {
        this.mCameraUIInterface.f_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE);
    }

    private void d_renamed() {
        boolean z_renamed = com.oplus.camera.l_renamed.c_renamed.c_renamed() || this.mPreferences.getBoolean("pref_allow_network_access", false);
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "initStickerMediator, allowNetworkAccess: " + z_renamed);
        com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mActivity).a_renamed((android.content.Context) this.mActivity);
        com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mActivity).a_renamed(2, true);
        com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mActivity).a_renamed(this.k_renamed);
        if (z_renamed) {
            com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mActivity).f_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "onInitCameraMode");
        this.B_renamed = java.lang.System.currentTimeMillis();
        com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mActivity).a_renamed((android.content.Context) this.mActivity);
        if (this.mPreferences.getBoolean("pref_allow_network_access", false)) {
            com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mActivity).f_renamed();
        }
        this.mPreviewEffectProcess.g_renamed();
        if (this.i_renamed == null) {
            this.y_renamed = new com.oplus.camera.sticker.ui.c_renamed(this.mActivity, com.oplus.camera.R_renamed.drawable.sticker_undownload);
            this.i_renamed = new com.oplus.camera.sticker.ui.h_renamed(this.mActivity, this.mOrientation, com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mActivity).a_renamed(this.mPreferences) != null);
            this.i_renamed.a_renamed(this.I_renamed);
            this.i_renamed.a_renamed(this.y_renamed);
        }
        this.i_renamed.a_renamed();
        this.i_renamed.e_renamed();
        this.i_renamed.b_renamed(this.mOrientation);
        this.mCameraUIInterface.c_renamed(this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_description_common_shutter_button));
        this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, com.oplus.camera.statistics.model.DcsMsgData.FULL);
        this.mHandler.post(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.4
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.capmode.t_renamed.this.i_renamed.c_renamed(com.oplus.camera.capmode.t_renamed.this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, "standard"));
            }
        });
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "onDeinitCameraMode");
        super.onDeInitCameraMode(str);
        this.mCameraUIInterface.E_renamed();
        this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.preview.h_renamed.f4665a.intValue(), 0L, 0L);
        if (this.i_renamed.g_renamed()) {
            this.i_renamed.b_renamed(true, false, true);
        }
        this.i_renamed.f_renamed();
        this.mCameraUIInterface.C_renamed();
        this.mCameraUIInterface.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, com.oplus.camera.statistics.model.DcsMsgData.FULL);
        updateFaceBeautyLevel(0, false);
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.g_renamed(0);
        }
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO)) {
            this.mCameraUIInterface.f_renamed(4, false);
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        super.onBeforePreview();
        com.oplus.camera.e_renamed.a_renamed("StickerMode.onBeforePreview");
        com.oplus.camera.sticker.data.StickerItem stickerItemA = com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mActivity).a_renamed(this.mPreferences);
        if (stickerItemA != null) {
            b_renamed(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_MENU_ITEM_USETIME, stickerItemA.getStickerUUID());
        }
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.a_renamed(stickerItemA);
        } else {
            com.oplus.camera.e_renamed.f_renamed("StickerMode", "updateStickerIndex, mPreferences: " + this.mPreferences);
        }
        this.mHandler.post(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.5
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.capmode.t_renamed.this.i_renamed.c_renamed(com.oplus.camera.capmode.t_renamed.this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, "standard"));
            }
        });
        applyBeautyParam();
        com.oplus.camera.e_renamed.b_renamed("StickerMode.onBeforePreview");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAnimojiOpen() {
        com.oplus.camera.sticker.data.StickerItem stickerItemJ = this.mPreviewEffectProcess != null ? this.mPreviewEffectProcess.j_renamed() : null;
        if (stickerItemJ == null && this.mActivity != null) {
            stickerItemJ = com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mActivity).a_renamed(this.mPreferences);
        }
        return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_OMOJI_PROCESS) && com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(stickerItemJ);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isMultiStickerOpen() {
        return com.oplus.camera.ui.preview.a_renamed.q_renamed.c_renamed(this.mPreviewEffectProcess != null ? this.mPreviewEffectProcess.j_renamed() : null);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAnyModeAnimationRunning() {
        com.oplus.camera.sticker.ui.h_renamed hVar = this.i_renamed;
        if (hVar != null) {
            return hVar.i_renamed();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected java.lang.String[] getCustomBeautyKeys() {
        return com.oplus.camera.ui.CameraUIInterface.KEY_STICKER_CUSTOM_FACEBEAUTY;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int[] getDefaultCustomBeautyValues() {
        return f4357b;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getCurrFilterIndex() {
        int i_renamed = this.mPreferences.getInt(getFilterEffectMenuPreferenceKey(), com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a);
        if (isShowAnimojiMenu()) {
            i_renamed = com.oplus.camera.ui.preview.a_renamed.j_renamed.f6905a;
        }
        return com.oplus.camera.util.Util.a_renamed(i_renamed, 0, getFilterTypeList(this.mCameraId).size() - 1);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.Integer> getFilterNameIdList(int i_renamed) {
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.m_renamed.b_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected java.util.List<java.lang.String> getFilterTypeList(int i_renamed) {
        return com.oplus.camera.ui.preview.a_renamed.j_renamed.m_renamed.a_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected boolean getNeedReduceBitRate() {
        return com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265.equals(this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_CODEC, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_video_codec_default_value)));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void startShortVideoRecording() {
        com.oplus.camera.sticker.ui.h_renamed hVar;
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "startShortVideoRecording");
        if (this.mCameraInterface.C_renamed() || !isVideoRecordStopped() || (hVar = this.i_renamed) == null || hVar.i_renamed()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("startShortVideoRecording, isDoubleFinger: ");
            sb.append(this.mCameraInterface.C_renamed());
            sb.append(", isVideoRecordStopped: ");
            sb.append(isVideoRecordStopped());
            sb.append(", isAnimation: ");
            com.oplus.camera.sticker.ui.h_renamed hVar2 = this.i_renamed;
            sb.append(hVar2 == null ? "null" : java.lang.Boolean.valueOf(hVar2.i_renamed()));
            sb.append(", MenuOpen: ");
            com.oplus.camera.sticker.ui.h_renamed hVar3 = this.i_renamed;
            sb.append(hVar3 != null ? java.lang.Boolean.valueOf(hVar3.g_renamed()) : "null");
            com.oplus.camera.e_renamed.a_renamed("StickerMode", sb.toString());
            return;
        }
        this.mHandler.removeMessages(10);
        try {
            this.mProfile = e_renamed();
        } catch (java.lang.Exception e_renamed) {
            this.mProfile = null;
            com.oplus.camera.e_renamed.a_renamed("StickerMode", "startShortVideoRecording, CamcorderProfile.get fail! ", e_renamed);
        }
        if (this.mProfile != null) {
            android.util.Size previewSize = getPreviewSize(this.mOneCamera.e_renamed());
            com.oplus.camera.e_renamed.a_renamed("StickerMode", "startShortVideoRecording, preview width: " + previewSize.getWidth() + ", preview heigth: " + previewSize.getHeight());
            if (!com.oplus.camera.util.Util.C_renamed() && (previewSize.getWidth() > 1920 || previewSize.getHeight() > 1088)) {
                this.mProfile.videoFrameWidth = com.oplus.camera.capmode.w_renamed.VIDEO_1080P_WIDTH;
                this.mProfile.videoFrameHeight = 912;
            } else {
                this.mProfile.videoFrameWidth = previewSize.getWidth();
                this.mProfile.videoFrameHeight = previewSize.getHeight();
            }
        }
        this.mHandler.removeCallbacks(this.h_renamed);
        this.mHandler.post(this.h_renamed);
    }

    private android.media.CamcorderProfile e_renamed() {
        android.media.CamcorderProfile camcorderProfile;
        try {
            if (android.media.CamcorderProfile.hasProfile(this.mCameraId, 5)) {
                camcorderProfile = android.media.CamcorderProfile.get(this.mCameraId, 5);
            } else {
                camcorderProfile = android.media.CamcorderProfile.get(this.mCameraId, 4);
            }
            return camcorderProfile;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            com.oplus.camera.e_renamed.f_renamed("StickerMode", "getCamcorderProfile, get CamcorderProfile fail");
            return null;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Range<java.lang.Integer> getVideoFpsRange() {
        android.util.Range<java.lang.Integer>[] rangeArrZ = getCameraInfo(this.mCameraId).z_renamed();
        if (rangeArrZ == null || rangeArrZ.length == 0) {
            return super.getVideoFpsRange();
        }
        int i_renamed = -1;
        int iIntValue = 300;
        for (int i2 = 0; i2 < rangeArrZ.length; i2++) {
            if (iIntValue > ((java.lang.Integer) rangeArrZ[i2].getLower()).intValue() && ((java.lang.Integer) rangeArrZ[i2].getUpper()).intValue() == 30) {
                iIntValue = ((java.lang.Integer) rangeArrZ[i2].getLower()).intValue();
                i_renamed = i2;
            }
        }
        if (i_renamed >= 0) {
            return rangeArrZ[i_renamed];
        }
        return super.getVideoFpsRange();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void stopShortVideoRecording() {
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "stopShortVideoRecording, isVideoRecordStarted: " + isVideoRecordStarted());
        if (isVideoRecordStopped()) {
            this.mHandler.removeCallbacks(this.h_renamed);
            return;
        }
        if (isVideoRecordStarting()) {
            this.mWaitRecordStarted.block();
        }
        if (isVideoRecordStarted()) {
            aj_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSupportShowFilterMenu() {
        return super.isSupportShowFilterMenu() && !isAnimojiOpen();
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:122:0x01ce  */
    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 1026
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.t_renamed.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetBeforeCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        if (dcsMsgData == null) {
            return null;
        }
        if (dcsMsgData instanceof com.oplus.camera.statistics.model.CaptureMsgData) {
            return a_renamed(dcsMsgData);
        }
        if (dcsMsgData instanceof com.oplus.camera.statistics.model.VideoRecordMsgData) {
            return b_renamed(dcsMsgData);
        }
        return null;
    }

    private com.oplus.camera.statistics.model.DcsMsgData a_renamed(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        com.oplus.camera.sticker.data.StickerItem stickerItemJ;
        if (dcsMsgData == null || !(dcsMsgData instanceof com.oplus.camera.statistics.model.CaptureMsgData)) {
            return null;
        }
        com.oplus.camera.statistics.model.CaptureMsgData captureMsgData = (com.oplus.camera.statistics.model.CaptureMsgData) dcsMsgData;
        captureMsgData.mCaptureMode = com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER;
        captureMsgData.mCaptureType = 2;
        captureMsgData.mTouchXYValue = this.mCameraInterface.af_renamed();
        captureMsgData.mMemoryValue = java.lang.String.valueOf(com.oplus.camera.util.Util.k_renamed(this.mActivity) / 1024);
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_PROCESS)) {
            captureMsgData.mFilterType = com.oplus.camera.ui.preview.a_renamed.j_renamed.b_renamed(getCurrFilterIndex(), this.mCameraId);
        }
        if (getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_STICKER_PROCESS) && (stickerItemJ = this.mPreviewEffectProcess.j_renamed()) != null) {
            captureMsgData.mStickerName = stickerItemJ.getStickerName();
            captureMsgData.mStickerType = java.lang.String.valueOf(stickerItemJ.getMaterialType());
            captureMsgData.mStickerUuid = stickerItemJ.getStickerUUID();
            captureMsgData.mProtocolVersion = java.lang.String.valueOf(stickerItemJ.getProtocolVersion());
        }
        int[] customBeautyValues = getCustomBeautyValues();
        if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_CUSTOM)) {
            int length = getCustomBeautyKeys().length;
            captureMsgData.mSmooth = isFaceBeautyOrMakeupOpen() ? 102 : 0;
            if (customBeautyValues != null && length == customBeautyValues.length) {
                captureMsgData.parseFaceBeauty(customBeautyValues);
            }
        } else if (getSupportFunction(com.oplus.camera.aps.config.CameraFunction.FACE_BEAUTY_COMMON)) {
            captureMsgData.mSmooth = isFaceBeautyOrMakeupOpen() ? 102 : 0;
            if (customBeautyValues != null) {
                captureMsgData.mSmoothDermabrasion = getCustomBeautyValues()[0];
            }
        }
        if (com.oplus.camera.statistics.model.DcsMsgData.FULL.equals(captureMsgData.mPicSizeType)) {
            captureMsgData.mPicSizeType = "16_9";
        }
        return (com.oplus.camera.statistics.model.CaptureMsgData) super.onGetBeforeCaptureMsgCommonData(captureMsgData);
    }

    private com.oplus.camera.statistics.model.DcsMsgData b_renamed(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        if (dcsMsgData == null || !(dcsMsgData instanceof com.oplus.camera.statistics.model.VideoRecordMsgData)) {
            return null;
        }
        com.oplus.camera.statistics.model.VideoRecordMsgData videoRecordMsgData = (com.oplus.camera.statistics.model.VideoRecordMsgData) dcsMsgData;
        videoRecordMsgData.mLux = java.lang.String.valueOf(this.mDcsLux);
        videoRecordMsgData.mCct = java.lang.String.valueOf(this.mDcsCCT);
        videoRecordMsgData.mIso = java.lang.String.valueOf(this.mDcsIso);
        videoRecordMsgData.mExp = java.lang.String.valueOf(this.mDcsExp);
        com.oplus.camera.sticker.data.StickerItem stickerItemJ = this.mPreviewEffectProcess.j_renamed();
        if (stickerItemJ == null) {
            return null;
        }
        videoRecordMsgData.mStickerName = stickerItemJ.getStickerName();
        videoRecordMsgData.mStickerType = java.lang.String.valueOf(stickerItemJ.getMaterialType());
        videoRecordMsgData.mStickerUuid = stickerItemJ.getStickerUUID();
        videoRecordMsgData.mProtocolVersion = java.lang.String.valueOf(stickerItemJ.getProtocolVersion());
        return (com.oplus.camera.statistics.model.VideoRecordMsgData) super.onGetBeforeCaptureMsgCommonData(videoRecordMsgData);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.statistics.model.DcsMsgData onGetAfterCaptureMsgCommonData(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData, com.oplus.camera.Storage.CameraPicture cameraPicture) {
        com.oplus.camera.statistics.model.CaptureMsgData captureMsgData;
        if (dcsMsgData == null || !(dcsMsgData instanceof com.oplus.camera.statistics.model.CaptureMsgData)) {
            captureMsgData = null;
        } else {
            captureMsgData = (com.oplus.camera.statistics.model.CaptureMsgData) dcsMsgData;
            android.util.Size sizeA = com.oplus.camera.Storage.a_renamed(com.oplus.camera.util.Util.a_renamed(cameraPicture.e_renamed));
            if (sizeA != null) {
                captureMsgData.mWidth = java.lang.String.valueOf(sizeA.getWidth());
                captureMsgData.mHeight = java.lang.String.valueOf(sizeA.getHeight());
            }
            if (android.text.TextUtils.isEmpty(captureMsgData.mFlashMode)) {
                captureMsgData.mFlashMode = "off";
            }
            captureMsgData.mFlashTrigger = com.oplus.camera.a_renamed.a_renamed.a_renamed(getFlashMode());
        }
        return (com.oplus.camera.statistics.model.CaptureMsgData) super.onGetAfterCaptureMsgCommonData(captureMsgData, cameraPicture);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_SETTING.equals(str)) {
            return true;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_SIZE.equals(str)) {
            return false;
        }
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_VIVID_EFFECT.equals(str)) {
            return getSupportFunction(str);
        }
        if ((com.oplus.camera.ui.CameraUIInterface.KEY_FILTER_MENU.equals(str) && (isAnimojiOpen() || isShowAnimojiMenu())) || com.oplus.camera.ui.CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(str)) {
            return false;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getCanAddMenuOption(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            return true;
        }
        return super.getCanAddMenuOption(str);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(com.oplus.camera.e_renamed.c_renamed cVar) {
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "onBeforeSnapping");
        if (isAnimojiOpen()) {
            com.oplus.camera.ui.preview.a_renamed.y_renamed yVarJ = this.mPreviewEffectProcess.j_renamed(16);
            if (yVarJ.a_renamed(16) && !yVarJ.a_renamed()) {
                return false;
            }
        }
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.6
            @Override // java.lang.Runnable
            public void run() {
                if (!com.oplus.camera.capmode.t_renamed.this.mbPaused) {
                    com.oplus.camera.capmode.t_renamed.this.i_renamed.a_renamed(false);
                    com.oplus.camera.capmode.t_renamed.this.i_renamed.b_renamed(false);
                } else {
                    com.oplus.camera.e_renamed.a_renamed("StickerMode", "onBeforeSnapping, return after pause");
                }
            }
        });
        return true;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        a_renamed(false, true);
        if (this.mCameraUIInterface.K_renamed()) {
            this.mCameraUIInterface.a_renamed(false, false, false, false);
        }
        this.mCameraInterface.a_renamed((android.animation.AnimatorListenerAdapter) null, true, false);
        this.mCameraInterface.d_renamed(false);
        this.mCameraUIInterface.g_renamed(4);
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO)) {
            this.mCameraUIInterface.f_renamed(4, true);
        }
        if (!containsBubbleKey(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO)) {
            updateBubbleValue(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO, false);
        }
        super.beforeStartRecording();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void afterStopRecording() {
        if (this.i_renamed.g_renamed()) {
            b_renamed(true, true);
            this.mCameraUIInterface.g_renamed(0);
        } else {
            this.mCameraUIInterface.g_renamed(0);
            super.afterStopRecording();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void stopVideoRestoreUIWithControlUI() {
        if (this.i_renamed.g_renamed()) {
            return;
        }
        b_renamed(true, false);
        this.mCameraInterface.a_renamed(true, false);
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void startShutterButtonProgress() {
        super.startShutterButtonProgress();
    }

    @Override // com.oplus.camera.capmode.w_renamed
    protected void stopShutterButtonProgress() {
        this.mCameraUIInterface.a_renamed(getShutterButtonInfo());
        super.stopShutterButtonProgress();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return !isVideoRecordStopped();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(java.lang.String str) {
        if ("type_video".equals(str)) {
            return false;
        }
        if ("type_preview_frame".equals(str)) {
            return getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_OMOJI_PROCESS) || getSupportFunction(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER);
        }
        if ("type_still_capture_yuv_main".equals(str) || "type_still_capture_yuv_sub".equals(str) || "type_still_capture_yuv_third".equals(str)) {
            return false;
        }
        if ("type_still_capture_jpeg".equals(str)) {
            return !com.oplus.camera.aps.util.AlgoSwitchConfig.getSupportApsCapture();
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.e_renamed.c_renamed getCaptureRequestTag(com.oplus.camera.aps.util.CameraApsDecision cameraApsDecision, boolean z_renamed) {
        com.oplus.camera.e_renamed.c_renamed captureRequestTag = super.getCaptureRequestTag(cameraApsDecision, z_renamed);
        captureRequestTag.ad_renamed = java.lang.System.currentTimeMillis();
        return captureRequestTag;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onFilterItemChange(int i_renamed) {
        super.onFilterItemChange(i_renamed);
        a_renamed(i_renamed);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.mPreviewEffectProcess != null) {
            return false;
        }
        this.mCameraUIInterface.p_renamed().getHitRect(new android.graphics.Rect());
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onShutterButtonLongClick() {
        super.onShutterButtonLongClick();
        this.mCameraUIInterface.a_renamed(new com.oplus.camera.ui.control.b_renamed(1, "button_color_inside_none", "button_shape_ring_none", 0));
        this.mWaitRecordStarted.close();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z_renamed, boolean z2) {
        super.onShutterCallback(z_renamed, z2);
        if (z2) {
            this.mCameraInterface.c_renamed(0);
            this.mCameraInterface.h_renamed();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onThumbnailUpdated(com.oplus.camera.aps.service.ThumbnailItem thumbnailItem) {
        synchronized (this.g_renamed) {
            this.z_renamed = thumbnailItem;
            f_renamed();
            com.oplus.camera.e_renamed.a_renamed("StickerMode", "onThumbnailUpdated, mRequestHash: " + thumbnailItem.mRequestHash + ", mStickerCaptureTime: " + thumbnailItem.mStickerCaptureTime);
        }
    }

    private void f_renamed() {
        if (!h_renamed() || this.z_renamed == null) {
            com.oplus.camera.e_renamed.b_renamed("StickerMode", "savePictureIfReady, mLastThumbnail: " + this.z_renamed);
            return;
        }
        g_renamed();
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.7
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.capmode.t_renamed.this.mbDestroyed) {
                        return;
                    }
                    com.oplus.camera.capmode.t_renamed.this.onAfterPictureTaken(null, false);
                }
            });
        }
    }

    private void g_renamed() {
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "savePictureUseThumb");
        com.oplus.camera.Storage.CameraPicture cameraPicture = new com.oplus.camera.Storage.CameraPicture();
        cameraPicture.f4068c = this.z_renamed.mUri;
        cameraPicture.v_renamed = true;
        cameraPicture.g_renamed = this.z_renamed.mJpegName;
        cameraPicture.f4066a = this.z_renamed.mResolver;
        cameraPicture.l_renamed = this.z_renamed.mDate;
        cameraPicture.E_renamed = this.z_renamed.mbLockScreen;
        cameraPicture.i_renamed = com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER;
        cameraPicture.s_renamed = this.mCameraId;
        cameraPicture.D_renamed = false;
        cameraPicture.h_renamed = getHeicCodecFormat() != null ? getHeicCodecFormat() : com.oplus.camera.statistics.model.CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG;
        cameraPicture.e_renamed = a_renamed(cameraPicture, this.z_renamed.mOriginBitmap, !this.z_renamed.mbMirror, this.mbFrontCamera, this.mOrientation, this.z_renamed.mTimeStamp);
        com.oplus.camera.m_renamed.b_renamed.a_renamed().c_renamed(cameraPicture);
        i_renamed();
        this.E_renamed = cameraPicture;
        if (this.mActivity == null || this.mbPaused) {
            return;
        }
        this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.8
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.capmode.t_renamed.this.pictureTakenCallback(null, 0, 0, com.oplus.camera.util.Util.a_renamed(256), false, false, 0L, 0);
            }
        });
        this.G_renamed = true;
        k_renamed();
    }

    private boolean h_renamed() {
        return (this.l_renamed == null && this.m_renamed == null && this.n_renamed == null && this.o_renamed == null && this.p_renamed == null) ? false : true;
    }

    private void i_renamed() {
        this.z_renamed = null;
        synchronized (this.g_renamed) {
            this.l_renamed = null;
            this.m_renamed = null;
            this.n_renamed = null;
            this.o_renamed = null;
            this.p_renamed = null;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onReceivePreviewCaptureResult(android.hardware.camera2.CaptureResult captureResult) {
        super.onReceivePreviewCaptureResult(captureResult);
        if (this.D_renamed) {
            synchronized (this.g_renamed) {
                this.l_renamed = (java.lang.Float) captureResult.get(android.hardware.camera2.CaptureResult.LENS_FOCAL_LENGTH);
                this.m_renamed = (java.lang.Float) captureResult.get(android.hardware.camera2.CaptureResult.LENS_APERTURE);
                this.n_renamed = (java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.SENSOR_SENSITIVITY);
                this.o_renamed = (java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AWB_MODE);
                this.p_renamed = (java.lang.Long) captureResult.get(android.hardware.camera2.CaptureResult.SENSOR_EXPOSURE_TIME);
                f_renamed();
            }
            this.D_renamed = false;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onStartCapturePreviewData() {
        this.D_renamed = true;
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureCompleted(com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult, com.oplus.camera.e_renamed.c_renamed cVar) {
        super.onCaptureCompleted(cameraCaptureResult, cVar);
        synchronized (this.g_renamed) {
            android.hardware.camera2.CaptureResult captureResult = cameraCaptureResult.getCaptureResult();
            this.l_renamed = (java.lang.Float) captureResult.get(android.hardware.camera2.CaptureResult.LENS_FOCAL_LENGTH);
            this.m_renamed = (java.lang.Float) captureResult.get(android.hardware.camera2.CaptureResult.LENS_APERTURE);
            this.n_renamed = (java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.SENSOR_SENSITIVITY);
            this.o_renamed = (java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AWB_MODE);
            this.p_renamed = (java.lang.Long) captureResult.get(android.hardware.camera2.CaptureResult.SENSOR_EXPOSURE_TIME);
            com.oplus.camera.e_renamed.a_renamed("StickerMode", "onCaptureCompleted, mCurrentFocalLength: " + this.l_renamed + ", mCurrentAperture: " + this.m_renamed + ", mCurrentISO: " + this.n_renamed + ", mCurrentWhiteBalanceMode: " + this.o_renamed + ", mCurrentExposureTime: " + this.p_renamed);
            long j_renamed = cVar.ad_renamed;
            if (this.z_renamed != null && (this.z_renamed.mRequestHash == cVar.hashCode() || j_renamed == this.z_renamed.mStickerCaptureTime)) {
                g_renamed();
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onCaptureCompleted, captureTime: ");
            sb.append(j_renamed);
            sb.append(", mStickerCaptureTime: ");
            sb.append(this.z_renamed != null ? java.lang.Long.valueOf(this.z_renamed.mStickerCaptureTime) : null);
            sb.append(", mRequestHash: ");
            sb.append(this.z_renamed != null ? java.lang.Long.valueOf(this.z_renamed.mRequestHash) : null);
            sb.append(", requestHashCode: ");
            sb.append(cVar.hashCode());
            com.oplus.camera.e_renamed.a_renamed("StickerMode", sb.toString());
        }
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.9
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.capmode.t_renamed.this.mbDestroyed) {
                        return;
                    }
                    com.oplus.camera.capmode.t_renamed.this.onAfterPictureTaken(null, false);
                }
            });
        }
    }

    private byte[] a_renamed(com.oplus.camera.Storage.CameraPicture cameraPicture, android.graphics.Bitmap bitmap, boolean z_renamed, boolean z2, int i_renamed, long j_renamed) throws java.io.IOException {
        android.graphics.Bitmap bitmapA;
        byte[] bArrCompressBitmap;
        if (!z2) {
            bitmapA = com.oplus.camera.util.Util.a_renamed(bitmap, i_renamed, false);
        } else {
            if ((i_renamed == 90 || i_renamed == 270) && z_renamed) {
                i_renamed = (i_renamed + 180) % 360;
            }
            bitmapA = com.oplus.camera.util.Util.a_renamed(bitmap, i_renamed, z_renamed);
        }
        android.graphics.Bitmap bitmap2 = bitmapA;
        byte[] byteArray = null;
        if (getHeicCodecFormat() != null) {
            com.oplus.exif.OplusExifInterface oplusExifInterface = new com.oplus.exif.OplusExifInterface();
            a_renamed(oplusExifInterface, cameraPicture.l_renamed);
            com.oplus.camera.k_renamed.b_renamed bVar = new com.oplus.camera.k_renamed.b_renamed("heic_8bits".equals(getHeicCodecFormat()));
            bVar.a_renamed(bitmap2, 0, 100, oplusExifInterface, cameraPicture.f4066a, cameraPicture.f4068c);
            bVar.a_renamed();
            return null;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FEATURE_DCIP3_SUPPORT)) {
            bArrCompressBitmap = com.oplus.camera.jni.IccProfile.compressBitmap(bitmap2, 100);
        } else {
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                try {
                    bitmap2.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } finally {
                }
            } catch (java.io.IOException e_renamed) {
                e_renamed.printStackTrace();
            }
            if (!bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            bArrCompressBitmap = byteArray;
        }
        return a_renamed(bArrCompressBitmap, cameraPicture.l_renamed);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:24:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:35:0x0072 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:44:? A_renamed[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] a_renamed(byte[] r5, long r6) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.String r0 = "addExif, close exif stream, exception: "
            java.lang.String r1 = "StickerMode"
            com.oplus.exif.OplusExifInterface r2 = new com.oplus.exif.OplusExifInterface
            r2.<init>()
            r3 = 0
            r4.a_renamed(r2, r6)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L36
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L36
            r4.<init>()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L36
            r2.writeExif(r5, r4)     // Catch: java.lang.Exception -> L31 java.lang.Throwable -> L6f
            byte[] r6 = r4.toByteArray()     // Catch: java.lang.Exception -> L31 java.lang.Throwable -> L6f
            r4.close()     // Catch: java.lang.Exception -> L1d
            goto L6a
        L1d:
            r4 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            com.oplus.camera.e_renamed.f_renamed(r1, r4)
            goto L6a
        L31:
            r6 = move-exception
            goto L38
        L33:
            r5 = move-exception
            r4 = r3
            goto L70
        L36:
            r6 = move-exception
            r4 = r3
        L38:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6f
            r7.<init>()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r2 = "addExif, processExif failed, exception: "
            r7.append(r2)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r2 = r6.getMessage()     // Catch: java.lang.Throwable -> L6f
            r7.append(r2)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L6f
            com.oplus.camera.e_renamed.d_renamed(r1, r7, r6)     // Catch: java.lang.Throwable -> L6f
            if (r4 == 0) goto L69
            r4.close()     // Catch: java.lang.Exception -> L56
            goto L69
        L56:
            r4 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            com.oplus.camera.e_renamed.f_renamed(r1, r4)
        L69:
            r6 = r3
        L6a:
            if (r6 != 0) goto L6d
            goto L6e
        L6d:
            r5 = r6
        L6e:
            return r5
        L6f:
            r5 = move-exception
        L70:
            if (r4 == 0) goto L89
            r4.close()     // Catch: java.lang.Exception -> L76
            goto L89
        L76:
            r4 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            com.oplus.camera.e_renamed.f_renamed(r1, r4)
        L89:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.t_renamed.a_renamed(byte[], long):byte[]");
    }

    private void a_renamed(com.oplus.exif.OplusExifInterface oplusExifInterface, long j_renamed) {
        android.location.Location locationY;
        if (oplusExifInterface == null) {
            com.oplus.camera.e_renamed.f_renamed("StickerMode", "buildExif, exifInterface is_renamed null");
            return;
        }
        synchronized (this.g_renamed) {
            if (this.l_renamed != null) {
                oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_FOCAL_LENGTH, new com.oplus.exif.OplusRational((long) (this.l_renamed.floatValue() * 100.0f), 100L)));
            }
            if (this.m_renamed != null) {
                oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_F_NUMBER, new com.oplus.exif.OplusRational((long) (this.m_renamed.floatValue() * 10.0f), 10L)));
            }
            if (this.n_renamed != null) {
                oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_ISO_SPEED_RATINGS, java.lang.Short.valueOf(this.n_renamed.shortValue())));
            }
            short s_renamed = 0;
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_FLASH, java.lang.Short.valueOf((isOpenFlash() || isOpenFrontTorch() || ((isAutoFlash() || isAutoFrontTorch()) && this.mbAutoFlash)) ? (short) 1 : (short) 0)));
            if (this.o_renamed != null) {
                if (this.o_renamed.intValue() != 1) {
                    s_renamed = 1;
                }
                oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_WHITE_BALANCE, java.lang.Short.valueOf(s_renamed)));
            }
            if (this.p_renamed != null) {
                oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_EXPOSURE_TIME, new com.oplus.exif.OplusRational(this.p_renamed.longValue(), com.google.android.exoplayer2.C_renamed.NANOS_PER_SECOND)));
            }
            if (this.mCameraInterface != null && (locationY = this.mCameraInterface.y_renamed()) != null) {
                oplusExifInterface.addGpsTags(locationY.getLatitude(), locationY.getLongitude());
            }
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_USER_COMMENT, com.oplus.exif.OplusExifTag.EXIF_TAG_PREFIX.concat(java.lang.String.valueOf(com.oplus.camera.g_renamed.b_renamed.a_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER, this.mCameraId)))));
            oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_MODEL, com.oplus.camera.util.Util.v_renamed()));
            if (0 != j_renamed) {
                java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy:MM:dd_renamed HH:mm:ss", java.util.Locale.US);
                java.text.SimpleDateFormat simpleDateFormat2 = new java.text.SimpleDateFormat("yyyy:MM:dd_renamed", java.util.Locale.US);
                simpleDateFormat.setTimeZone(java.util.Calendar.getInstance().getTimeZone());
                simpleDateFormat2.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
                oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_DATE_TIME, simpleDateFormat.format(java.lang.Long.valueOf(j_renamed))));
                oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_DATE_TIME_ORIGINAL, simpleDateFormat.format(java.lang.Long.valueOf(j_renamed))));
                java.time.ZonedDateTime zonedDateTimeOfInstant = java.time.ZonedDateTime.ofInstant(java.time.Instant.ofEpochMilli(j_renamed), java.time.ZoneId.systemDefault());
                oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_SUB_SEC_TIME_ORIGINAL, java.time.format.DateTimeFormatter.ofPattern("SSS").format(zonedDateTimeOfInstant)));
                oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_OFFSET_TIME_ORIGINAL, 2, java.time.format.DateTimeFormatter.ofPattern("XXX").format(zonedDateTimeOfInstant)));
                oplusExifInterface.addGpsDateTimeStampTag(j_renamed);
                oplusExifInterface.setTag(oplusExifInterface.buildTag(com.oplus.exif.OplusExifInterface.TAG_GPS_DATE_STAMP, simpleDateFormat2.format(java.lang.Long.valueOf(j_renamed))));
            }
        }
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "onBeforePictureTaken");
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z_renamed) {
        com.oplus.camera.sticker.ui.h_renamed hVar;
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "onAfterPictureTaken");
        if (this.mCameraInterface == null) {
            return;
        }
        if (this.mCameraInterface.i_renamed()) {
            this.mCameraInterface.n_renamed();
            this.mCameraUIInterface.d_renamed(true, false);
        }
        if (!this.mCameraUIInterface.A_renamed()) {
            this.i_renamed.a_renamed(true);
            this.i_renamed.b_renamed(true);
        }
        if (containsBubbleKey(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO) || isShowAnimojiMenu() || (hVar = this.i_renamed) == null || hVar.g_renamed()) {
            return;
        }
        updateBubbleValue(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO, true);
        this.mCameraUIInterface.a_renamed((android.view.View) null, 4, getBubbleOffsetX(4), getBubbleOffsetY(4));
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public android.util.Size getPictureSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        android.util.Size sizeA;
        java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_photo_ratio_default_value));
        java.util.List<android.util.Size> listA = hVar.a_renamed(getImageFormat());
        if (com.oplus.camera.statistics.model.DcsMsgData.FULL.equals(string)) {
            sizeA = com.oplus.camera.util.Util.a_renamed(listA, com.oplus.camera.capmode.BaseMode.PICTURE_SIZE_5M, 0);
        } else {
            sizeA = com.oplus.camera.util.Util.a_renamed(listA, com.oplus.camera.capmode.BaseMode.PICTURE_SIZE_5M, com.oplus.camera.util.Util.a_renamed(string));
        }
        return sizeA != null ? sizeA : super.getPictureSize(hVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public android.util.Size getPreviewSize(com.oplus.camera.e_renamed.h_renamed hVar) {
        android.util.Size sizeA;
        android.util.Size pictureSize = getPictureSize(hVar);
        java.util.List<android.util.Size> listA = hVar.a_renamed();
        int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STICKER_TARGET_PREVIEW_HEIGHT);
        if ("standard".equals(com.oplus.camera.util.Util.a_renamed(pictureSize, this.mCameraId))) {
            sizeA = com.oplus.camera.util.Util.a_renamed(configIntValue, listA, 1.3333333333333333d);
        } else if ("16_9".equals(com.oplus.camera.util.Util.a_renamed(pictureSize, this.mCameraId))) {
            sizeA = com.oplus.camera.util.Util.a_renamed(configIntValue, listA, 1.7777777777777777d);
        } else {
            sizeA = "square".equals(com.oplus.camera.util.Util.a_renamed(pictureSize, this.mCameraId)) ? com.oplus.camera.util.Util.a_renamed(configIntValue, listA, 1.0d) : null;
        }
        return sizeA != null ? sizeA : super.getPreviewSize(hVar);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        if ((this.mCameraInterface == null || this.mCameraInterface.i_renamed()) && !com.oplus.camera.util.Util.C_renamed()) {
            return super.getZSLMode();
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public com.oplus.camera.ui.control.b_renamed getShutterButtonInfo() {
        java.lang.String str = "button_shape_ring_none";
        if (this.mPreferences != null) {
            java.lang.String string = this.mPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_shutter_mode_default_value));
            if (com.oplus.camera.statistics.model.FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE.equals(string)) {
                str = "button_shape_countdown_ten_seconds";
            } else if ("3".equals(string)) {
                str = "button_shape_countdown_three_seconds";
            }
        }
        return com.oplus.camera.util.Util.ao_renamed() ? new com.oplus.camera.ui.control.b_renamed(23) : new com.oplus.camera.ui.control.b_renamed(1, "button_color_inside_none", str, 0);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z_renamed) {
        com.oplus.camera.ui.control.b_renamed shutterButtonInfo = getShutterButtonInfo();
        shutterButtonInfo.b_renamed(0);
        this.mCameraUIInterface.a_renamed(shutterButtonInfo);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needUploadOplusStatistics(java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_FACE_DETECTION.equals(str) && isVideoRecording()) {
            return false;
        }
        return super.needUploadOplusStatistics(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onGetNearMeOnClickData() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i_renamed = this.A_renamed;
        if (i_renamed > 0) {
            java.lang.String str = com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.OMOJI_HUMAN_GENERATE_GIF, java.lang.String.valueOf(i_renamed));
            this.A_renamed = 0;
            sb.append(str);
        }
        int i2 = this.s_renamed;
        if (i2 > 0) {
            java.lang.String str2 = com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_RECYCLEBIN_CLICK, java.lang.String.valueOf(i2));
            this.s_renamed = 0;
            sb.append(str2);
        }
        int i3 = this.t_renamed;
        if (i3 > 0) {
            java.lang.String str3 = com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_RECYCLEBIN_DELETEALL, java.lang.String.valueOf(i3));
            this.t_renamed = 0;
            sb.append(str3);
        }
        a_renamed(this.w_renamed, sb);
        b_renamed(this.v_renamed, sb);
        this.u_renamed = null;
        if (sb.length() > 0) {
            com.oplus.camera.statistics.CameraStatisticsUtil.onCommon(this.mActivity, com.oplus.camera.statistics.CameraStatisticsUtil.EVENT_MENU_CLICK, sb.toString());
        }
        this.B_renamed = java.lang.System.currentTimeMillis() - this.B_renamed;
        long j_renamed = this.B_renamed;
        if (j_renamed > 0) {
            com.oplus.camera.statistics.CameraStatisticsUtil.onCommon(this.mActivity, com.oplus.camera.statistics.CameraStatisticsUtil.EVENT_ENTER_STICKER, com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_MODE_USE_TIME, java.lang.String.valueOf(j_renamed)));
        }
        this.B_renamed = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.String str, java.lang.String str2) {
        if (this.w_renamed == null) {
            this.w_renamed = new java.util.HashMap<>();
        }
        java.lang.String str3 = str + "_" + str2;
        if (this.w_renamed.containsKey(str3)) {
            java.util.HashMap<java.lang.String, java.lang.Integer> map = this.w_renamed;
            map.put(str3, java.lang.Integer.valueOf(map.get(str3).intValue() + 1));
        } else {
            this.w_renamed.put(str3, 1);
        }
    }

    private void a_renamed(java.util.HashMap<java.lang.String, java.lang.Integer> map, java.lang.StringBuilder sb) {
        if (map != null) {
            for (java.lang.String str : map.keySet()) {
                sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(str, java.lang.String.valueOf(map.get(str))));
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private void b_renamed(java.lang.String str, java.lang.String str2) {
        java.lang.String[] strArrSplit;
        if (this.v_renamed == null) {
            this.v_renamed = new java.util.HashMap<>();
        }
        java.lang.String str3 = this.u_renamed;
        if (str3 != null && (strArrSplit = str3.split("\\.")) != null && strArrSplit.length > 1) {
            java.lang.String str4 = str + "_" + strArrSplit[0];
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - java.lang.Long.parseLong(strArrSplit[1]);
            if (this.v_renamed.containsKey(str4)) {
                java.util.HashMap<java.lang.String, java.lang.Long> map = this.v_renamed;
                map.put(str4, java.lang.Long.valueOf(map.get(str4).longValue() + jCurrentTimeMillis));
            } else {
                this.v_renamed.put(str4, java.lang.Long.valueOf(jCurrentTimeMillis));
            }
        }
        this.u_renamed = str2 + "." + java.lang.System.currentTimeMillis();
    }

    private void b_renamed(java.util.HashMap<java.lang.String, java.lang.Long> map, java.lang.StringBuilder sb) {
        if (map != null) {
            for (java.lang.String str : map.keySet()) {
                sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(str, java.lang.String.valueOf(map.get(str))));
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem, int i_renamed) {
        if (this.mCameraInterface == null) {
            return false;
        }
        if (stickerItem == null || this.mCameraInterface.S_renamed() || isAnyModeAnimationRunning()) {
            com.oplus.camera.e_renamed.f_renamed("StickerMode", "onStickerItemClick, item: " + stickerItem + ", isBlurAnimRunning: " + this.mCameraInterface.S_renamed() + ", isAnyModeAnimationRunning: " + isAnyModeAnimationRunning());
            return false;
        }
        if (stickerItem.isRecycleBin()) {
            com.oplus.camera.e_renamed.b_renamed("StickerMode", "onStickerItemClick, recycle_bin_sticker_id");
            com.oplus.camera.sticker.ui.l_renamed lVar = this.j_renamed;
            if (lVar == null || !lVar.isShowing()) {
                this.s_renamed++;
                this.j_renamed = new com.oplus.camera.sticker.ui.l_renamed(this.mActivity);
                this.j_renamed.show();
                this.j_renamed.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.oplus.camera.capmode.t_renamed.10
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(android.content.DialogInterface dialogInterface) {
                        com.oplus.camera.e_renamed.b_renamed("StickerMode", "onStickerItemClick, onDismiss");
                        com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(com.oplus.camera.capmode.t_renamed.this.mActivity).a_renamed(1, true);
                    }
                });
                this.j_renamed.a_renamed(new com.oplus.camera.sticker.ui.l_renamed.a_renamed() { // from class: com.oplus.camera.capmode.t_renamed.11
                    @Override // com.oplus.camera.sticker.ui.l_renamed.a_renamed
                    public void a_renamed() {
                        com.oplus.camera.capmode.t_renamed.d_renamed(com.oplus.camera.capmode.t_renamed.this);
                    }

                    @Override // com.oplus.camera.sticker.ui.l_renamed.a_renamed
                    public void a_renamed(int i2, boolean z_renamed) {
                        com.oplus.camera.capmode.t_renamed.this.a_renamed(i2, z_renamed, "delete");
                    }

                    @Override // com.oplus.camera.sticker.ui.l_renamed.a_renamed
                    public void b_renamed(int i2, boolean z_renamed) {
                        com.oplus.camera.capmode.t_renamed.this.a_renamed(i2, z_renamed, "cancel");
                    }
                });
            }
            return true;
        }
        if (com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mActivity).a_renamed(this.mActivity, stickerItem)) {
            return true;
        }
        a_renamed(stickerItem, false);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a_renamed(android.view.View view, com.oplus.camera.sticker.data.StickerItem stickerItem, int i_renamed) {
        if (stickerItem == null) {
            com.oplus.camera.e_renamed.e_renamed("StickerMode", "onStickwerItemLongClick, item: " + stickerItem);
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onUiModeChanged() {
        super.onUiModeChanged();
        com.oplus.camera.sticker.ui.l_renamed lVar = this.j_renamed;
        if (lVar != null) {
            lVar.b_renamed();
        }
        com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mActivity).a_renamed(this.mActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "updateStickerImageResource");
        com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mActivity).a_renamed(this.H_renamed, com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mActivity).a_renamed(this.mPreferences), z_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
        if (this.mPreviewEffectProcess == null || stickerItem == null || !com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mActivity).b_renamed().d_renamed(stickerItem.getStickerUUID()) || !this.mPreviewEffectProcess.b_renamed(stickerItem)) {
            return;
        }
        this.mPreviewEffectProcess.e_renamed();
    }

    private void a_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "hideStickerMenu, includePanle: " + z2);
        this.i_renamed.a_renamed(4, z_renamed, z2);
        this.i_renamed.a_renamed(false);
    }

    private void b_renamed(boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "showStickerMenu, needAnim: " + z_renamed + ", includePanel: " + z2 + ", isMoreModeShown: " + this.mCameraUIInterface.R_renamed());
        if (this.mCameraUIInterface.R_renamed() || isVideoRecording()) {
            return;
        }
        this.i_renamed.a_renamed(0, z_renamed, z2);
        this.i_renamed.a_renamed(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int i_renamed, boolean z_renamed) {
        super.changeModeAllViewWhenAnimation(i_renamed, z_renamed);
        if (i_renamed != 3) {
            if (i_renamed != 18) {
                return;
            }
            if (z_renamed) {
                b_renamed(true, false);
                return;
            } else {
                a_renamed(true, true);
                return;
            }
        }
        this.i_renamed.a_renamed((z_renamed && this.mbInCapturing) ? false : z_renamed);
        if (z_renamed) {
            b_renamed(true, true);
        } else if (this.i_renamed.g_renamed()) {
            this.i_renamed.b_renamed(true, true, false);
        } else {
            a_renamed(false, true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        a_renamed(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsed() {
        if (this.mCameraInterface.A_renamed() || this.mCameraUIInterface.A_renamed()) {
            return;
        }
        b_renamed(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void startScreenTorch() {
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO)) {
            this.mCameraUIInterface.f_renamed(4, false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void stopScreenTorch() {
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO)) {
            this.mCameraUIInterface.a_renamed((android.view.View) null, 4, getBubbleOffsetX(4), getBubbleOffsetY(4));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopUp() {
        java.lang.String currEffectMenuName = getCurrEffectMenuName();
        if (isStickerMenuOpen()) {
            if (isPanelMode()) {
                this.mCameraUIInterface.a_renamed(this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_mode_sticker));
            }
            this.i_renamed.e_renamed(true);
        } else {
            a_renamed(false, true);
        }
        if ("beauty".equals(currEffectMenuName)) {
            com.oplus.camera.statistics.CameraStatisticsUtil.onCommon(this.mActivity, com.oplus.camera.statistics.CameraStatisticsUtil.EVENT_MENU_CLICK, com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_MODE_CLICK_SMOOTH_MENU, "1"));
        } else if (com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER.equals(currEffectMenuName)) {
            com.oplus.camera.statistics.CameraStatisticsUtil.onCommon(this.mActivity, com.oplus.camera.statistics.CameraStatisticsUtil.EVENT_MENU_CLICK, com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_MODE_CLICK_FILTER_MENU, "1"));
        }
        this.mCameraUIInterface.aB_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopDown(boolean z_renamed) {
        b_renamed(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean showEffectMenu() {
        return !this.i_renamed.g_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isStickerMenuOpen() {
        com.oplus.camera.sticker.ui.h_renamed hVar = this.i_renamed;
        if (hVar == null) {
            return false;
        }
        return hVar.g_renamed();
    }

    public boolean a_renamed() {
        if (!isVideoRecordStopped() || this.i_renamed.i_renamed() || this.mCameraUIInterface.B_renamed()) {
            return true;
        }
        if (!isStickerMenuOpen()) {
            return false;
        }
        if (isPanelMode()) {
            this.mCameraUIInterface.a_renamed(this.mActivity.getString(com.oplus.camera.R_renamed.string.camera_mode_sticker));
            this.mCameraUIInterface.a_renamed(0, true);
        } else {
            this.mCameraUIInterface.a_renamed(0, 1);
        }
        this.i_renamed.e_renamed(false);
        if (!supportBeautyButton()) {
            this.mCameraUIInterface.j_renamed(false, false);
        } else {
            this.mCameraUIInterface.l_renamed(true, false);
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean supportBeautyButton() {
        if (this.mPreviewEffectProcess == null || !com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(this.mPreviewEffectProcess.j_renamed())) {
            return super.supportBeautyButton();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public void forceStopVideoRecording(boolean z_renamed) {
        super.forceStopVideoRecording(z_renamed);
        j_renamed();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "onBackPressed");
        if (a_renamed()) {
            if (isVideoRecordStarted()) {
                j_renamed();
                return super.onBackPressed();
            }
            if (isVideoRecordStarting()) {
                j_renamed();
                stopShortVideoRecording();
            }
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
        com.oplus.camera.e_renamed.a_renamed("StickerMode", "onSingleTapUp");
        android.graphics.Rect rect = new android.graphics.Rect();
        this.mCameraUIInterface.p_renamed().getHitRect(rect);
        if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        if (a_renamed()) {
            return true;
        }
        return isShowAnimojiMenu();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onDown(android.view.MotionEvent motionEvent) {
        return super.onDown(motionEvent);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onSwitchCameraButtonClick() {
        super.onSwitchCameraButtonClick();
        com.oplus.camera.statistics.CameraStatisticsUtil.onCommon(this.mActivity, com.oplus.camera.statistics.CameraStatisticsUtil.EVENT_MENU_CLICK, com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_MODE_SWITCH_CAMERA, "1"));
    }

    private void j_renamed() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.w_renamed();
        }
        com.oplus.camera.ui.widget.LockViewDragLayout.setLongPressState(false);
        com.oplus.camera.ui.widget.LockViewDragLayout.setVolumeDownState(false);
        com.oplus.camera.ui.widget.LockViewDragLayout.setReachBorderState(false);
    }

    /* compiled from: StickerMode.java */
    private class a_renamed implements com.oplus.camera.ui.preview.a_renamed.v_renamed {
        private a_renamed() {
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.v_renamed
        public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) throws java.lang.Throwable {
            if (com.oplus.camera.capmode.t_renamed.this.mbDestroyed) {
                return;
            }
            com.oplus.camera.e_renamed.b_renamed("StickerMode", "onStickerDownloadStarted, item: " + stickerItem.toString());
            java.lang.Integer numC = com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(com.oplus.camera.capmode.t_renamed.this.mActivity).b_renamed().c_renamed(stickerItem.getStickerUUID());
            if (numC != null) {
                com.oplus.camera.capmode.t_renamed.this.i_renamed.a_renamed(stickerItem.getCategoryId(), numC.intValue(), stickerItem.getDownloadState(), stickerItem.getThumbnailFileUri(), !com.oplus.camera.capmode.t_renamed.this.mbPaused, stickerItem);
            }
            com.oplus.camera.capmode.t_renamed.this.C_renamed = java.lang.System.currentTimeMillis();
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.v_renamed
        public void b_renamed(final com.oplus.camera.sticker.data.StickerItem stickerItem) {
            if (com.oplus.camera.capmode.t_renamed.this.mbDestroyed) {
                return;
            }
            if (!com.oplus.camera.capmode.t_renamed.this.isVideoRecording() && !com.oplus.camera.capmode.t_renamed.this.mCameraInterface.S_renamed() && !com.oplus.camera.capmode.t_renamed.this.getIsCapturingState() && com.oplus.camera.capmode.t_renamed.this.mbModePreInit) {
                com.oplus.camera.capmode.t_renamed.this.a_renamed(stickerItem, true);
                com.oplus.camera.capmode.t_renamed.this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.a_renamed.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.oplus.camera.capmode.t_renamed.this.j_renamed == null || !com.oplus.camera.capmode.t_renamed.this.j_renamed.isShowing()) {
                            return;
                        }
                        com.oplus.camera.capmode.t_renamed.this.j_renamed.a_renamed();
                    }
                });
                if (com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface != null) {
                    com.oplus.camera.capmode.t_renamed.this.mCameraUIInterface.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.a_renamed.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.oplus.camera.capmode.t_renamed.this.c_renamed(stickerItem);
                        }
                    });
                }
            }
            com.oplus.camera.capmode.t_renamed.this.a_renamed(false);
            com.oplus.camera.capmode.t_renamed.this.a_renamed(stickerItem, java.lang.System.currentTimeMillis() - com.oplus.camera.capmode.t_renamed.this.C_renamed, com.oplus.camera.statistics.model.StickerMsgData.STICKER_OPER_DOWNLOAD, "0");
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.v_renamed
        public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem, int i_renamed) throws java.lang.Throwable {
            if (com.oplus.camera.capmode.t_renamed.this.mbDestroyed) {
                return;
            }
            java.lang.Integer numC = com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(com.oplus.camera.capmode.t_renamed.this.mActivity).b_renamed().c_renamed(stickerItem.getStickerUUID());
            if (numC != null) {
                com.oplus.camera.capmode.t_renamed.this.i_renamed.a_renamed(stickerItem.getCategoryId(), numC.intValue(), 16, stickerItem.getThumbnailFileUri(), !com.oplus.camera.capmode.t_renamed.this.mbPaused, stickerItem);
            }
            com.oplus.camera.capmode.t_renamed.this.a_renamed(stickerItem, -1L, com.oplus.camera.statistics.model.StickerMsgData.STICKER_OPER_DOWNLOAD, "1");
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.v_renamed
        public void c_renamed(final com.oplus.camera.sticker.data.StickerItem stickerItem) {
            if (com.oplus.camera.capmode.t_renamed.this.mbDestroyed) {
                return;
            }
            com.oplus.camera.capmode.t_renamed.this.mActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.t_renamed.a_renamed.3
                @Override // java.lang.Runnable
                public void run() {
                    if (stickerItem != null) {
                        if (com.oplus.camera.capmode.t_renamed.this.mPreviewEffectProcess != null && com.oplus.camera.capmode.t_renamed.this.mPreviewEffectProcess.j_renamed() != null && android.text.TextUtils.equals(stickerItem.getStickerUUID(), com.oplus.camera.capmode.t_renamed.this.mPreviewEffectProcess.j_renamed().getStickerUUID())) {
                            com.oplus.camera.capmode.t_renamed.this.i_renamed.c_renamed(false);
                            com.oplus.camera.capmode.t_renamed.this.b_renamed(stickerItem);
                            if (com.oplus.camera.ui.preview.a_renamed.q_renamed.b_renamed(stickerItem)) {
                                com.oplus.camera.capmode.t_renamed.this.c_renamed();
                            }
                        }
                        com.oplus.camera.capmode.t_renamed.this.a_renamed(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_RECYCLEBIN_ITEM_DELETE, stickerItem.getStickerUUID());
                    }
                    if (com.oplus.camera.capmode.t_renamed.this.j_renamed == null || !com.oplus.camera.capmode.t_renamed.this.j_renamed.isShowing()) {
                        return;
                    }
                    com.oplus.camera.capmode.t_renamed.this.j_renamed.a_renamed(stickerItem);
                }
            });
            com.oplus.camera.capmode.t_renamed.this.a_renamed(false);
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.v_renamed
        public void d_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem) {
            if (com.oplus.camera.capmode.t_renamed.this.mbDestroyed) {
                return;
            }
            com.oplus.camera.capmode.t_renamed.this.a_renamed(false);
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.v_renamed
        public void a_renamed(int i_renamed) {
            if (com.oplus.camera.capmode.t_renamed.this.mbDestroyed || i_renamed == 0) {
                return;
            }
            if (i_renamed == 1) {
                com.oplus.camera.capmode.t_renamed.this.a_renamed(false);
            } else {
                if (i_renamed != 2) {
                    return;
                }
                if (com.oplus.camera.capmode.t_renamed.this.mCameraInterface.S_renamed()) {
                    com.oplus.camera.capmode.t_renamed.this.a_renamed(false);
                } else {
                    com.oplus.camera.capmode.t_renamed.this.a_renamed(true);
                }
            }
        }

        @Override // com.oplus.camera.ui.preview.a_renamed.v_renamed
        public void a_renamed() {
            if (com.oplus.camera.capmode.t_renamed.this.mbDestroyed) {
                return;
            }
            com.oplus.camera.capmode.t_renamed.this.a_renamed(false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAllowSwitch(com.oplus.camera.d_renamed.a_renamed aVar) {
        if (isShowAnimojiMenu()) {
            return false;
        }
        return super.isAllowSwitch(aVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateRatioType() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.b_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_PHOTO_RATIO, com.oplus.camera.statistics.model.DcsMsgData.FULL);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onFaceBeautyItemValueChange(int i_renamed, int i2, boolean z_renamed) {
        super.onFaceBeautyItemValueChange(i_renamed, i2, z_renamed);
        a_renamed(i_renamed, i2, z_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(false);
        menuClickMsgData.mFuncKeyId = 34;
        menuClickMsgData.mCaptureType = 2;
        c_renamed(menuClickMsgData);
        if (z_renamed) {
            menuClickMsgData.mFuncKeyResult = 1;
        } else {
            menuClickMsgData.mFuncKeyResult = 2;
        }
        menuClickMsgData.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(java.lang.String str) {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(true);
        menuClickMsgData.mFuncKeyId = 34;
        c_renamed(menuClickMsgData);
        menuClickMsgData.mItemValue = str;
        menuClickMsgData.report();
    }

    private void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        if (z_renamed) {
            com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(this.mActivity);
            menuClickMsgData.buildEvent(true);
            menuClickMsgData.mFuncKeyId = 2;
            if (this.mbFrontCamera) {
                menuClickMsgData.mItem = com.oplus.camera.statistics.model.MenuClickMsgData.KEY_COMMON_CUSTOM_BEAUTY[i_renamed];
            }
            menuClickMsgData.mItemValue = java.lang.String.valueOf(i2);
            c_renamed(menuClickMsgData);
            menuClickMsgData.report();
        }
    }

    private void a_renamed(int i_renamed) {
        com.oplus.camera.statistics.model.MenuClickMsgData menuClickMsgData = new com.oplus.camera.statistics.model.MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(true);
        menuClickMsgData.mFuncKeyId = 4;
        menuClickMsgData.mItemValue = com.oplus.camera.ui.preview.a_renamed.j_renamed.b_renamed(i_renamed, this.mCameraId);
        c_renamed(menuClickMsgData);
        menuClickMsgData.report();
    }

    private void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem, boolean z_renamed, java.lang.String str) {
        com.oplus.camera.statistics.model.StickerMsgData stickerMsgData = new com.oplus.camera.statistics.model.StickerMsgData(this.mActivity);
        stickerMsgData.buildEvent(com.oplus.camera.statistics.model.StickerMsgData.EVENT_STICKER_SELECT);
        c_renamed(stickerMsgData);
        stickerMsgData.mStickerName = stickerItem.getStickerName();
        stickerMsgData.mStickerType = java.lang.String.valueOf(stickerItem.getMaterialType());
        stickerMsgData.mStickerUuid = stickerItem.getStickerUUID();
        stickerMsgData.mProtocolVersion = java.lang.String.valueOf(stickerItem.getProtocolVersion());
        if (z_renamed) {
            stickerMsgData.mMyDownload = "true";
        } else {
            stickerMsgData.mMyDownload = "false";
        }
        if (com.oplus.camera.statistics.model.StickerMsgData.STICKER_OPER_SELECT.equals(str)) {
            stickerMsgData.mOperType = com.oplus.camera.statistics.model.StickerMsgData.STICKER_OPER_SELECT;
        } else if ("cancel".equals(str)) {
            stickerMsgData.mOperType = "cancel";
        }
        stickerMsgData.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(com.oplus.camera.sticker.data.StickerItem stickerItem, long j_renamed, java.lang.String str, java.lang.String str2) {
        com.oplus.camera.statistics.model.StickerMsgData stickerMsgData = new com.oplus.camera.statistics.model.StickerMsgData(this.mActivity);
        stickerMsgData.buildEvent("sticker_download");
        c_renamed(stickerMsgData);
        stickerMsgData.mStickerName = stickerItem.getStickerName();
        stickerMsgData.mStickerType = java.lang.String.valueOf(stickerItem.getMaterialType());
        stickerMsgData.mStickerUuid = stickerItem.getStickerUUID();
        stickerMsgData.mProtocolVersion = java.lang.String.valueOf(stickerItem.getProtocolVersion());
        stickerMsgData.mStickerDownloadCostTime = j_renamed;
        stickerMsgData.mZoomValue = java.lang.String.valueOf(this.mCameraInterface.ak_renamed());
        if (com.oplus.camera.statistics.model.StickerMsgData.STICKER_OPER_DOWNLOAD.equals(str)) {
            stickerMsgData.mOperType = com.oplus.camera.statistics.model.StickerMsgData.STICKER_OPER_DOWNLOAD;
        } else if ("cancel".equals(str)) {
            stickerMsgData.mOperType = "cancel";
        }
        if (str2 != null) {
            stickerMsgData.mDownloadResult = str2;
        }
        stickerMsgData.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, boolean z_renamed, java.lang.String str) {
        com.oplus.camera.statistics.model.StickerMsgData stickerMsgData = new com.oplus.camera.statistics.model.StickerMsgData(this.mActivity);
        stickerMsgData.buildEvent(com.oplus.camera.statistics.model.StickerMsgData.EVENT_STICKER_DELETE);
        c_renamed(stickerMsgData);
        stickerMsgData.mSelectCount = i_renamed;
        if (z_renamed) {
            stickerMsgData.mSelectAll = "true";
        } else {
            stickerMsgData.mSelectAll = "false";
        }
        if ("delete".equals(str)) {
            stickerMsgData.mOperType = "delete";
        } else if ("cancel".equals(str)) {
            stickerMsgData.mOperType = "cancel";
        }
        stickerMsgData.report();
    }

    private void c_renamed(com.oplus.camera.statistics.model.DcsMsgData dcsMsgData) {
        if (this.mCameraInterface.i_renamed()) {
            dcsMsgData.mCameraEnterType = java.lang.String.valueOf(1);
        } else if (this.mCameraInterface.m_renamed()) {
            dcsMsgData.mCameraEnterType = java.lang.String.valueOf(3);
        } else {
            dcsMsgData.mCameraEnterType = java.lang.String.valueOf(2);
        }
        dcsMsgData.mCaptureMode = getCameraMode();
        dcsMsgData.mCameraId = this.mCameraInterface.aw_renamed();
        dcsMsgData.mOrientation = this.mOrientation;
        dcsMsgData.mRearOrFront = com.oplus.camera.e_renamed.a_renamed.a_renamed(this.mCameraInterface.aw_renamed()) ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : com.oplus.camera.statistics.model.DcsMsgData.REAR;
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    public boolean getSupportGestureCapture() {
        com.oplus.camera.sticker.ui.l_renamed lVar = this.j_renamed;
        return (lVar == null || !lVar.isShowing()) && super.getSupportGestureCapture();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        a_renamed(true, false);
        if (isBubbleOpen(com.oplus.camera.ui.CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO)) {
            this.mCameraUIInterface.f_renamed(4, true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int i_renamed) {
        super.onMoreModeHidden(i_renamed);
        if (this.mCameraUIInterface.A_renamed()) {
            return;
        }
        b_renamed(true, false);
    }

    @Override // com.oplus.camera.capmode.w_renamed, com.oplus.camera.capmode.BaseMode
    protected boolean isNeedSetZslWhenCapture() {
        return com.oplus.camera.util.Util.C_renamed();
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.e_renamed.d_renamed.a_renamed
    public void onCaptureFirstFrameArrived(android.hardware.camera2.CaptureRequest captureRequest, com.oplus.camera.aps.service.CameraCaptureResult cameraCaptureResult) {
        super.onCaptureFirstFrameArrived(captureRequest, cameraCaptureResult);
        if (this.mCameraInterface != null) {
            this.mCameraInterface.a_renamed(captureRequest, cameraCaptureResult);
        }
        if (this.mActivity == null || this.mbPaused) {
            return;
        }
        this.F_renamed = true;
        k_renamed();
    }

    private void k_renamed() {
        if (this.G_renamed && this.F_renamed) {
            if (this.mCameraInterface != null) {
                this.mCameraInterface.a_renamed(this.E_renamed);
            }
            this.G_renamed = false;
            this.F_renamed = false;
            this.E_renamed = null;
        }
    }
}
