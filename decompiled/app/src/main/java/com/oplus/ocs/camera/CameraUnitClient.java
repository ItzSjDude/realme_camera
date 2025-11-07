package com.oplus.ocs.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import com.oplus.ocs.base.IAuthenticationListener;
import com.oplus.ocs.base.common.C3650a;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.common.Feature;
import com.oplus.ocs.base.common.api.AbstractC3658g;
import com.oplus.ocs.base.common.api.C3652a;
import com.oplus.ocs.base.common.api.C3655d;
import com.oplus.ocs.base.common.api.InterfaceC3656e;
import com.oplus.ocs.base.common.api.InterfaceC3657f;
import com.oplus.ocs.base.internal.C3676a;
import com.oplus.ocs.camera.common.util.CameraUnitLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class CameraUnitClient extends AbstractC3658g<Object, CameraUnitClient> {
    public static final int BLUR_VALUE_DEFAULT = 60;
    public static final int COLOR_TEMPERATURE_AUTO = -1;
    public static final String KEY_BOKEH_STATE = "BOKEH_STATE";
    private static final int SUPPORT_ASYNC_AUTH_VERSION = 300001;
    private static final String TAG = "CameraUnitClient";
    private CameraStateCallback mCameraStateCallback;
    private CameraUnitClientAdapter mCameraUnitClientAdapter;
    private Handler mFailHandler;
    private InterfaceC3656e mFailListener;
    private Handler mSuccessHandler;
    private InterfaceC3657f mSuccessListener;
    private AtomicBoolean mbAuthFailedBeforeCallbackSet;
    private int mbAuthFailedCode;
    private AtomicBoolean mbAuthSuccessBeforeCallbackSet;
    private static final List<Feature> mFeatures = new ArrayList();
    private static final C3652a.COUIBaseListPopupWindow_12<CameraClient> CUSTOMER_CODE = new C3652a.COUIBaseListPopupWindow_12<>();
    private static final C3652a.PlatformImplementations.kt_3<CameraClient, Object> CLIENT_BUILDER = new CameraClientBuilder();
    private static final C3652a<Object> API = new C3652a<>("CameraClient.API", CLIENT_BUILDER, CUSTOMER_CODE);

    @SuppressLint({"StaticFieldLeak"})
    private static CameraUnitClient sCameraUnitClient = null;
    private static boolean sbAuthed = false;
    private static boolean sbSupportAsyncAuthenticate = false;

    @Retention(RetentionPolicy.SOURCE)
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

    @Retention(RetentionPolicy.SOURCE)
    public @interface CameraMode {
        public static final String FASTVIDEO_MODE = "fastvideo_mode";
        public static final String FISH_EYE_MODE = "fisheye_mode";
        public static final String HIGH_DEFINITION_MODE = "high_definition_mode";
        public static final String HIGH_PIXEL_MODE = "high_pixel_mode";
        public static final String ID_PHOTO_MODE = "id_photo_mode";
        public static final String LONG_EXPOSURE_MODE = "long_exposure_mode";
        public static final String MACRO_MODE = "macro_mode";
        public static final String MICROSCOPE_CAPTURE_MODE = "microscope_capture_mode";
        public static final String MICROSCOPE_VIDEO_MODE = "microscope_video_mode";
        public static final String MOVIE_MODE = "movie_mode";
        public static final String MULTI_CAMERA_MODE = "multi_camera_mode";
        public static final String NIGHT_MODE = "night_mode";
        public static final String PANORAMA_MODE = "panorama_mode";
        public static final String PHOTO_MODE = "photo_mode";
        public static final String PORTRAIT_MODE = "portrait_mode";
        public static final String PROFESSIONAL_MODE = "professional_mode";
        public static final String SLOW_VIDEO_MODE = "slowvideo_mode";
        public static final String STAR_CAPTURE_MODE = "star_capture_mode";
        public static final String STAR_VIDEO_MODE = "star_video_mode";
        public static final String STICKER_MODE = "sticker_mode";
        public static final String STREET_MODE = "street_mode";
        public static final String SUPER_TEXT_MODE = "super_text_mode";
        public static final String THREE_D_PHOTO_MODE = "3d_photo_mode";
        public static final String TIME_LAPSE_PRO_MODE = "time_lapse_pro_mode";
        public static final String ULTRA_HIGH_RESOLUTION_MODE = "ultraHD_mode";
        public static final String VIDEO_MODE = "video_mode";
        public static final String XPAN_MODE = "xpan_mode";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CameraType {
        public static final String FRONT_DUAL = "front_dual";
        public static final String FRONT_MAIN = "front_main";
        public static final String FRONT_WIDE = "front_wide";
        public static final String REAR_MACRO = "rear_macro";
        public static final String REAR_MAIN = "rear_main";
        public static final String REAR_MAIN_FRONT_MAIN = "rear_main_front_main";
        public static final String REAR_MAIN_FRONT_SUB = "rear_main_front_sub";
        public static final String REAR_MAIN_REAR_TELE = "rear_main_rear_tele";
        public static final String REAR_MAIN_REAR_WIDE = "rear_main_rear_wide";
        public static final String REAR_MICROSCOPE = "rear_microscope";
        public static final String REAR_MONO_CAMERA_1 = "rear_mono_1";
        public static final String REAR_MONO_CAMERA_2 = "rear_mono_2";
        public static final String REAR_PORTRAIT = "rear_portrait";
        public static final String REAR_PORTRAIT_MONO_1 = "rear_portrait_mono_1";
        public static final String REAR_PORTRAIT_MONO_2 = "rear_portrait_mono_2";
        public static final String REAR_SAT = "rear_sat";
        public static final String REAR_SECOND_PORTRAIT = "rear_second_portrait";
        public static final String REAR_TELE = "rear_tele";
        public static final String REAR_TOF_3D_CAMERA = "rear_tof_3d";
        public static final String REAR_WIDE = "rear_wide";
        public static final String REAR_WIDE_REAR_TELE = "rear_wide_rear_tele";
    }

    @Override // com.oplus.ocs.base.common.api.AbstractC3658g
    public int getVersion() {
        return 341000;
    }

    @Override // com.oplus.ocs.base.common.api.AbstractC3658g
    public boolean hasFeature(String str) {
        return true;
    }

    @Override // com.oplus.ocs.base.common.api.AbstractC3658g
    protected void init() {
    }

    private CameraUnitClient(Context context, CameraUnitClientAdapter cameraUnitClientAdapter) {
        super(context, API, null, new C3676a(context.getPackageName(), 341000, mFeatures), (sbAuthed || sbSupportAsyncAuthenticate) ? false : true);
        this.mCameraUnitClientAdapter = null;
        this.mCameraStateCallback = null;
        this.mSuccessListener = null;
        this.mFailListener = null;
        this.mSuccessHandler = null;
        this.mFailHandler = null;
        this.mbAuthSuccessBeforeCallbackSet = new AtomicBoolean(false);
        this.mbAuthFailedBeforeCallbackSet = new AtomicBoolean(false);
        this.mbAuthFailedCode = -1;
        this.mCameraUnitClientAdapter = cameraUnitClientAdapter;
        this.mCameraUnitClientAdapter.initialize(context);
        handleAuthenticate(context);
    }

    protected static synchronized CameraUnitClient initialize(Context context) {
        if (sCameraUnitClient != null) {
            sCameraUnitClient.addThis2Cache();
            return sCameraUnitClient;
        }
        checkRuntimeEnvironment(context);
        return sCameraUnitClient;
    }

    public void openCamera(String str, CameraStateCallback cameraStateCallback, Handler handler) {
        CameraUnitClientAdapter cameraUnitClientAdapter = this.mCameraUnitClientAdapter;
        if (cameraUnitClientAdapter == null) {
            throw new RuntimeException("CameraUnitInterface has already destroyed, call it before destroy() ");
        }
        cameraUnitClientAdapter.openCamera(str, cameraStateCallback, handler);
    }

    public CameraDeviceInfo getCameraDeviceInfo(String str, String str2) {
        CameraUnitClientAdapter cameraUnitClientAdapter = this.mCameraUnitClientAdapter;
        if (cameraUnitClientAdapter == null) {
            throw new RuntimeException("CameraUnitInterface has already destroyed, call it before destroy() ");
        }
        try {
            return new CameraDeviceInfo(cameraUnitClientAdapter.getCameraDeviceInfo(str, str2));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static void checkRuntimeEnvironment(Context context) {
        try {
            CameraUnitClientAdapter cameraUnitClientAdapter = new CameraUnitClientAdapter();
            if (cameraUnitClientAdapter.checkAuthenticationPermission(context, "3.490.24", 341000)) {
                try {
                    sbAuthed = cameraUnitClientAdapter.isAuthedClient(context);
                } catch (Throwable th) {
                    Log.w(TAG, "The current sdk does not have isAuthedClient interface " + th.getMessage());
                }
                sbSupportAsyncAuthenticate = isSupportAsyncAuthenticate(context);
                sCameraUnitClient = new CameraUnitClient(context, cameraUnitClientAdapter);
                return;
            }
            Log.COUIBaseListPopupWindow_8(TAG, "checkRuntimeEnvironment, checkAuthenticationPermission fail");
        } catch (Error COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Map<String, List<String>> getAllSupportCameraMode() {
        CameraUnitClientAdapter cameraUnitClientAdapter = this.mCameraUnitClientAdapter;
        if (cameraUnitClientAdapter == null) {
            throw new RuntimeException("CameraUnitInterface has already destroyed, call it before destroy() ");
        }
        return cameraUnitClientAdapter.getAllSupportCameraMode();
    }

    public List<String> getAllSupportCameraType() {
        CameraUnitClientAdapter cameraUnitClientAdapter = this.mCameraUnitClientAdapter;
        if (cameraUnitClientAdapter == null) {
            throw new RuntimeException("CameraUnitInterface has already destroyed, call it before destroy() ");
        }
        return cameraUnitClientAdapter.getAllSupportCameraType();
    }

    public static void release() {
        CameraUnitClient cameraUnitClient = sCameraUnitClient;
        if (cameraUnitClient != null) {
            cameraUnitClient.destroy();
            sCameraUnitClient = null;
        }
    }

    public static void initLog(Context context) {
        CameraUnitLog.initLog(context);
    }

    public static boolean isSupportAsyncAuthenticate(Context context) {
        return AbstractC3658g.checkInternal(context);
    }

    @Override // com.oplus.ocs.base.common.api.AbstractC3658g
    public CameraUnitClient addOnConnectionSucceedListener(InterfaceC3657f interfaceC3657f, Handler handler) {
        if (!sbSupportAsyncAuthenticate) {
            return (CameraUnitClient) super.addOnConnectionSucceedListener(interfaceC3657f, handler);
        }
        this.mSuccessListener = interfaceC3657f;
        this.mSuccessHandler = handler;
        if (sbAuthed || this.mbAuthSuccessBeforeCallbackSet.get()) {
            this.mbAuthSuccessBeforeCallbackSet.set(false);
            authSuccess();
        }
        return this;
    }

    @Override // com.oplus.ocs.base.common.api.AbstractC3658g
    public CameraUnitClient addOnConnectionFailedListener(InterfaceC3656e interfaceC3656e, Handler handler) {
        if (!sbSupportAsyncAuthenticate) {
            return (CameraUnitClient) super.addOnConnectionFailedListener(interfaceC3656e, handler);
        }
        this.mFailListener = interfaceC3656e;
        this.mFailHandler = handler;
        if (this.mbAuthFailedBeforeCallbackSet.get()) {
            authFail(this.mbAuthFailedCode);
            this.mbAuthFailedBeforeCallbackSet.set(false);
        }
        return this;
    }

    private void destroy() {
        CameraUnitClientAdapter cameraUnitClientAdapter = this.mCameraUnitClientAdapter;
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

    private void handleAuthenticate(Context context) {
        Log.OplusGLSurfaceView_13(TAG, "handleAuthenticate, isAuthed: " + sbAuthed + ", supportAsyncAuth: " + sbSupportAsyncAuthenticate);
        if (sbAuthed || !sbSupportAsyncAuthenticate) {
            return;
        }
        handleAsyncAuthenticate(context);
    }

    private void handleAsyncAuthenticate(final Context context) {
        new Thread(new Runnable() { // from class: com.oplus.ocs.camera.CameraUnitClient.1
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                new C3655d(context2, context2.getPackageName(), "CAMERA_CLIENT", Process.myPid(), true, new IAuthenticationListener.Stub() { // from class: com.oplus.ocs.camera.CameraUnitClient.1.1
                    @Override // com.oplus.ocs.base.IAuthenticationListener
                    public void onSuccess(CapabilityInfo capabilityInfo) throws RemoteException {
                        Log.OplusGLSurfaceView_13(CameraUnitClient.TAG, "handleAsyncAuthenticate, onSuccess");
                        CameraUnitClient.this.authSuccess();
                    }

                    @Override // com.oplus.ocs.base.IAuthenticationListener
                    public void onFail(int OplusGLSurfaceView_13) throws RemoteException {
                        Log.w(CameraUnitClient.TAG, "handleAsyncAuthenticate, onFailed errorCode: " + OplusGLSurfaceView_13);
                        CameraUnitClient.this.authFail(OplusGLSurfaceView_13);
                    }
                }).m25050b();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void authSuccess() {
        InterfaceC3657f interfaceC3657f = this.mSuccessListener;
        if (interfaceC3657f != null) {
            Handler handler = this.mSuccessHandler;
            if (handler == null) {
                interfaceC3657f.m25053a();
                return;
            } else {
                handler.postAtFrontOfQueue(new Runnable() { // from class: com.oplus.ocs.camera.CameraUnitClient.2
                    @Override // java.lang.Runnable
                    public void run() {
                        CameraUnitClient.this.mSuccessListener.m25053a();
                    }
                });
                return;
            }
        }
        this.mbAuthSuccessBeforeCallbackSet.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void authFail(final int OplusGLSurfaceView_13) {
        InterfaceC3656e interfaceC3656e = this.mFailListener;
        if (interfaceC3656e != null) {
            Handler handler = this.mFailHandler;
            if (handler == null) {
                interfaceC3656e.m25052a(new C3650a(OplusGLSurfaceView_13));
                return;
            } else {
                handler.postAtFrontOfQueue(new Runnable() { // from class: com.oplus.ocs.camera.CameraUnitClient.3
                    @Override // java.lang.Runnable
                    public void run() {
                        CameraUnitClient.this.mFailListener.m25052a(new C3650a(OplusGLSurfaceView_13));
                    }
                });
                return;
            }
        }
        this.mbAuthFailedBeforeCallbackSet.set(true);
    }
}
