package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
public final class CameraUnitClient extends com.oplus.ocs.base.common.api.g_renamed<java.lang.Object, com.oplus.ocs.camera.CameraUnitClient> {
    public static final int BLUR_VALUE_DEFAULT = 60;
    public static final int COLOR_TEMPERATURE_AUTO = -1;
    public static final java.lang.String KEY_BOKEH_STATE = "BOKEH_STATE";
    private static final int SUPPORT_ASYNC_AUTH_VERSION = 300001;
    private static final java.lang.String TAG = "CameraUnitClient";
    private com.oplus.ocs.camera.CameraStateCallback mCameraStateCallback;
    private com.oplus.ocs.camera.CameraUnitClientAdapter mCameraUnitClientAdapter;
    private android.os.Handler mFailHandler;
    private com.oplus.ocs.base.common.api.e_renamed mFailListener;
    private android.os.Handler mSuccessHandler;
    private com.oplus.ocs.base.common.api.f_renamed mSuccessListener;
    private java.util.concurrent.atomic.AtomicBoolean mbAuthFailedBeforeCallbackSet;
    private int mbAuthFailedCode;
    private java.util.concurrent.atomic.AtomicBoolean mbAuthSuccessBeforeCallbackSet;
    private static final java.util.List<com.oplus.ocs.base.common.Feature> mFeatures = new java.util.ArrayList();
    private static final com.oplus.ocs.base.common.api.a_renamed.f_renamed<com.oplus.ocs.camera.CameraClient> CUSTOMER_CODE = new com.oplus.ocs.base.common.api.a_renamed.f_renamed<>();
    private static final com.oplus.ocs.base.common.api.a_renamed.AbstractC0143a<com.oplus.ocs.camera.CameraClient, java.lang.Object> CLIENT_BUILDER = new com.oplus.ocs.camera.CameraClientBuilder();
    private static final com.oplus.ocs.base.common.api.a_renamed<java.lang.Object> API = new com.oplus.ocs.base.common.api.a_renamed<>("CameraClient.API", CLIENT_BUILDER, CUSTOMER_CODE);

    @android.annotation.SuppressLint({"StaticFieldLeak"})
    private static com.oplus.ocs.camera.CameraUnitClient sCameraUnitClient = null;
    private static boolean sbAuthed = false;
    private static boolean sbSupportAsyncAuthenticate = false;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface BokehState {
        public static final int CAMERA_CALIBRATION = 8;
        public static final int CAMERA_COVERGED_MAIN = 10;
        public static final int CAMERA_COVERGED_SUB = 7;
        public static final int CAMERA_SINGLE = 9;
        public static final int DEPTH_EFFECT_SUCCESS = 1;
        public static final int INVALID = -1;
        public static final int LOW_LIGHT = 4;
        public static final int NO_DEPTH_EFFECT = 0;
        public static final int SUBJECT_NOT_FOUND = 5;
        public static final int TOO_FAR = 3;
        public static final int TOO_NEAR = 2;
        public static final int TOUCH_TO_FOCUS = 6;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface CameraMode {
        public static final java.lang.String FASTVIDEO_MODE = "fastvideo_mode";
        public static final java.lang.String FISH_EYE_MODE = "fisheye_mode";
        public static final java.lang.String HIGH_DEFINITION_MODE = "high_definition_mode";
        public static final java.lang.String HIGH_PIXEL_MODE = "high_pixel_mode";
        public static final java.lang.String ID_PHOTO_MODE = "id_photo_mode";
        public static final java.lang.String LONG_EXPOSURE_MODE = "long_exposure_mode";
        public static final java.lang.String MACRO_MODE = "macro_mode";
        public static final java.lang.String MICROSCOPE_CAPTURE_MODE = "microscope_capture_mode";
        public static final java.lang.String MICROSCOPE_VIDEO_MODE = "microscope_video_mode";
        public static final java.lang.String MOVIE_MODE = "movie_mode";
        public static final java.lang.String MULTI_CAMERA_MODE = "multi_camera_mode";
        public static final java.lang.String NIGHT_MODE = "night_mode";
        public static final java.lang.String PANORAMA_MODE = "panorama_mode";
        public static final java.lang.String PHOTO_MODE = "photo_mode";
        public static final java.lang.String PORTRAIT_MODE = "portrait_mode";
        public static final java.lang.String PROFESSIONAL_MODE = "professional_mode";
        public static final java.lang.String SLOW_VIDEO_MODE = "slowvideo_mode";
        public static final java.lang.String STAR_CAPTURE_MODE = "star_capture_mode";
        public static final java.lang.String STAR_VIDEO_MODE = "star_video_mode";
        public static final java.lang.String STICKER_MODE = "sticker_mode";
        public static final java.lang.String STREET_MODE = "street_mode";
        public static final java.lang.String SUPER_TEXT_MODE = "super_text_mode";
        public static final java.lang.String THREE_D_PHOTO_MODE = "3d_photo_mode";
        public static final java.lang.String TIME_LAPSE_PRO_MODE = "time_lapse_pro_mode";
        public static final java.lang.String ULTRA_HIGH_RESOLUTION_MODE = "ultraHD_mode";
        public static final java.lang.String VIDEO_MODE = "video_mode";
        public static final java.lang.String XPAN_MODE = "xpan_mode";
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface CameraType {
        public static final java.lang.String FRONT_DUAL = "front_dual";
        public static final java.lang.String FRONT_MAIN = "front_main";
        public static final java.lang.String FRONT_WIDE = "front_wide";
        public static final java.lang.String REAR_MACRO = "rear_macro";
        public static final java.lang.String REAR_MAIN = "rear_main";
        public static final java.lang.String REAR_MAIN_FRONT_MAIN = "rear_main_front_main";
        public static final java.lang.String REAR_MAIN_FRONT_SUB = "rear_main_front_sub";
        public static final java.lang.String REAR_MAIN_REAR_TELE = "rear_main_rear_tele";
        public static final java.lang.String REAR_MAIN_REAR_WIDE = "rear_main_rear_wide";
        public static final java.lang.String REAR_MICROSCOPE = "rear_microscope";
        public static final java.lang.String REAR_MONO_CAMERA_1 = "rear_mono_1";
        public static final java.lang.String REAR_MONO_CAMERA_2 = "rear_mono_2";
        public static final java.lang.String REAR_PORTRAIT = "rear_portrait";
        public static final java.lang.String REAR_PORTRAIT_MONO_1 = "rear_portrait_mono_1";
        public static final java.lang.String REAR_PORTRAIT_MONO_2 = "rear_portrait_mono_2";
        public static final java.lang.String REAR_SAT = "rear_sat";
        public static final java.lang.String REAR_SECOND_PORTRAIT = "rear_second_portrait";
        public static final java.lang.String REAR_TELE = "rear_tele";
        public static final java.lang.String REAR_TOF_3D_CAMERA = "rear_tof_3d";
        public static final java.lang.String REAR_WIDE = "rear_wide";
        public static final java.lang.String REAR_WIDE_REAR_TELE = "rear_wide_rear_tele";
    }

    @Override // com.oplus.ocs.base.common.api.g_renamed
    public int getVersion() {
        return 341000;
    }

    @Override // com.oplus.ocs.base.common.api.g_renamed
    public boolean hasFeature(java.lang.String str) {
        return true;
    }

    @Override // com.oplus.ocs.base.common.api.g_renamed
    protected void init() {
    }

    private CameraUnitClient(android.content.Context context, com.oplus.ocs.camera.CameraUnitClientAdapter cameraUnitClientAdapter) {
        super(context, API, null, new com.oplus.ocs.base.internal.a_renamed(context.getPackageName(), 341000, mFeatures), (sbAuthed || sbSupportAsyncAuthenticate) ? false : true);
        this.mCameraUnitClientAdapter = null;
        this.mCameraStateCallback = null;
        this.mSuccessListener = null;
        this.mFailListener = null;
        this.mSuccessHandler = null;
        this.mFailHandler = null;
        this.mbAuthSuccessBeforeCallbackSet = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.mbAuthFailedBeforeCallbackSet = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.mbAuthFailedCode = -1;
        this.mCameraUnitClientAdapter = cameraUnitClientAdapter;
        this.mCameraUnitClientAdapter.initialize(context);
        handleAuthenticate(context);
    }

    protected static synchronized com.oplus.ocs.camera.CameraUnitClient initialize(android.content.Context context) {
        if (sCameraUnitClient != null) {
            sCameraUnitClient.addThis2Cache();
            return sCameraUnitClient;
        }
        checkRuntimeEnvironment(context);
        return sCameraUnitClient;
    }

    public void openCamera(java.lang.String str, com.oplus.ocs.camera.CameraStateCallback cameraStateCallback, android.os.Handler handler) {
        com.oplus.ocs.camera.CameraUnitClientAdapter cameraUnitClientAdapter = this.mCameraUnitClientAdapter;
        if (cameraUnitClientAdapter == null) {
            throw new java.lang.RuntimeException("CameraUnitInterface has already destroyed, call it before destroy() ");
        }
        cameraUnitClientAdapter.openCamera(str, cameraStateCallback, handler);
    }

    public com.oplus.ocs.camera.CameraDeviceInfo getCameraDeviceInfo(java.lang.String str, java.lang.String str2) {
        com.oplus.ocs.camera.CameraUnitClientAdapter cameraUnitClientAdapter = this.mCameraUnitClientAdapter;
        if (cameraUnitClientAdapter == null) {
            throw new java.lang.RuntimeException("CameraUnitInterface has already destroyed, call it before destroy() ");
        }
        try {
            return new com.oplus.ocs.camera.CameraDeviceInfo(cameraUnitClientAdapter.getCameraDeviceInfo(str, str2));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static void checkRuntimeEnvironment(android.content.Context context) {
        try {
            com.oplus.ocs.camera.CameraUnitClientAdapter cameraUnitClientAdapter = new com.oplus.ocs.camera.CameraUnitClientAdapter();
            if (cameraUnitClientAdapter.checkAuthenticationPermission(context, "3.490.24", 341000)) {
                try {
                    sbAuthed = cameraUnitClientAdapter.isAuthedClient(context);
                } catch (java.lang.Throwable th) {
                    android.util.Log.w_renamed(TAG, "The current sdk does not have isAuthedClient interface " + th.getMessage());
                }
                sbSupportAsyncAuthenticate = isSupportAsyncAuthenticate(context);
                sCameraUnitClient = new com.oplus.ocs.camera.CameraUnitClient(context, cameraUnitClientAdapter);
                return;
            }
            android.util.Log.e_renamed(TAG, "checkRuntimeEnvironment, checkAuthenticationPermission fail");
        } catch (java.lang.Error e_renamed) {
            e_renamed.printStackTrace();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getAllSupportCameraMode() {
        com.oplus.ocs.camera.CameraUnitClientAdapter cameraUnitClientAdapter = this.mCameraUnitClientAdapter;
        if (cameraUnitClientAdapter == null) {
            throw new java.lang.RuntimeException("CameraUnitInterface has already destroyed, call it before destroy() ");
        }
        return cameraUnitClientAdapter.getAllSupportCameraMode();
    }

    public java.util.List<java.lang.String> getAllSupportCameraType() {
        com.oplus.ocs.camera.CameraUnitClientAdapter cameraUnitClientAdapter = this.mCameraUnitClientAdapter;
        if (cameraUnitClientAdapter == null) {
            throw new java.lang.RuntimeException("CameraUnitInterface has already destroyed, call it before destroy() ");
        }
        return cameraUnitClientAdapter.getAllSupportCameraType();
    }

    public static void release() {
        com.oplus.ocs.camera.CameraUnitClient cameraUnitClient = sCameraUnitClient;
        if (cameraUnitClient != null) {
            cameraUnitClient.destroy();
            sCameraUnitClient = null;
        }
    }

    public static void initLog(android.content.Context context) {
        com.oplus.ocs.camera.common.util.CameraUnitLog.initLog(context);
    }

    public static boolean isSupportAsyncAuthenticate(android.content.Context context) {
        return com.oplus.ocs.base.common.api.g_renamed.checkInternal(context);
    }

    @Override // com.oplus.ocs.base.common.api.g_renamed
    public com.oplus.ocs.camera.CameraUnitClient addOnConnectionSucceedListener(com.oplus.ocs.base.common.api.f_renamed fVar, android.os.Handler handler) {
        if (!sbSupportAsyncAuthenticate) {
            return (com.oplus.ocs.camera.CameraUnitClient) super.addOnConnectionSucceedListener(fVar, handler);
        }
        this.mSuccessListener = fVar;
        this.mSuccessHandler = handler;
        if (sbAuthed || this.mbAuthSuccessBeforeCallbackSet.get()) {
            this.mbAuthSuccessBeforeCallbackSet.set(false);
            authSuccess();
        }
        return this;
    }

    @Override // com.oplus.ocs.base.common.api.g_renamed
    public com.oplus.ocs.camera.CameraUnitClient addOnConnectionFailedListener(com.oplus.ocs.base.common.api.e_renamed eVar, android.os.Handler handler) {
        if (!sbSupportAsyncAuthenticate) {
            return (com.oplus.ocs.camera.CameraUnitClient) super.addOnConnectionFailedListener(eVar, handler);
        }
        this.mFailListener = eVar;
        this.mFailHandler = handler;
        if (this.mbAuthFailedBeforeCallbackSet.get()) {
            authFail(this.mbAuthFailedCode);
            this.mbAuthFailedBeforeCallbackSet.set(false);
        }
        return this;
    }

    private void destroy() {
        com.oplus.ocs.camera.CameraUnitClientAdapter cameraUnitClientAdapter = this.mCameraUnitClientAdapter;
        if (cameraUnitClientAdapter != null) {
            cameraUnitClientAdapter.release();
            this.mCameraUnitClientAdapter = null;
            this.mCameraStateCallback = null;
            this.mSuccessListener = null;
            this.mFailListener = null;
            this.mSuccessHandler = null;
            this.mFailHandler = null;
            sbAuthed = false;
            sbSupportAsyncAuthenticate = false;
        }
    }

    private void handleAuthenticate(android.content.Context context) {
        android.util.Log.i_renamed(TAG, "handleAuthenticate, isAuthed: " + sbAuthed + ", supportAsyncAuth: " + sbSupportAsyncAuthenticate);
        if (sbAuthed || !sbSupportAsyncAuthenticate) {
            return;
        }
        handleAsyncAuthenticate(context);
    }

    private void handleAsyncAuthenticate(final android.content.Context context) {
        new java.lang.Thread(new java.lang.Runnable() { // from class: com.oplus.ocs.camera.CameraUnitClient.1
            @Override // java.lang.Runnable
            public void run() {
                android.content.Context context2 = context;
                new com.oplus.ocs.base.common.api.d_renamed(context2, context2.getPackageName(), "CAMERA_CLIENT", android.os.Process.myPid(), true, new com.oplus.ocs.base.IAuthenticationListener.Stub() { // from class: com.oplus.ocs.camera.CameraUnitClient.1.1
                    @Override // com.oplus.ocs.base.IAuthenticationListener
                    public void onSuccess(com.oplus.ocs.base.common.CapabilityInfo capabilityInfo) throws android.os.RemoteException {
                        android.util.Log.i_renamed(com.oplus.ocs.camera.CameraUnitClient.TAG, "handleAsyncAuthenticate, onSuccess");
                        com.oplus.ocs.camera.CameraUnitClient.this.authSuccess();
                    }

                    @Override // com.oplus.ocs.base.IAuthenticationListener
                    public void onFail(int i_renamed) throws android.os.RemoteException {
                        android.util.Log.w_renamed(com.oplus.ocs.camera.CameraUnitClient.TAG, "handleAsyncAuthenticate, onFailed errorCode: " + i_renamed);
                        com.oplus.ocs.camera.CameraUnitClient.this.authFail(i_renamed);
                    }
                }).b_renamed();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void authSuccess() {
        com.oplus.ocs.base.common.api.f_renamed fVar = this.mSuccessListener;
        if (fVar != null) {
            android.os.Handler handler = this.mSuccessHandler;
            if (handler == null) {
                fVar.a_renamed();
                return;
            } else {
                handler.postAtFrontOfQueue(new java.lang.Runnable() { // from class: com.oplus.ocs.camera.CameraUnitClient.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.ocs.camera.CameraUnitClient.this.mSuccessListener.a_renamed();
                    }
                });
                return;
            }
        }
        this.mbAuthSuccessBeforeCallbackSet.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void authFail(final int i_renamed) {
        com.oplus.ocs.base.common.api.e_renamed eVar = this.mFailListener;
        if (eVar != null) {
            android.os.Handler handler = this.mFailHandler;
            if (handler == null) {
                eVar.a_renamed(new com.oplus.ocs.base.common.a_renamed(i_renamed));
                return;
            } else {
                handler.postAtFrontOfQueue(new java.lang.Runnable() { // from class: com.oplus.ocs.camera.CameraUnitClient.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.ocs.camera.CameraUnitClient.this.mFailListener.a_renamed(new com.oplus.ocs.base.common.a_renamed(i_renamed));
                    }
                });
                return;
            }
        }
        this.mbAuthFailedBeforeCallbackSet.set(true);
    }
}
