package com.oplus.camera.capmode;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.coui.appcompat.dialog.app.COUIAlertDialog;
import com.meicam.sdk.NvsStreamingContext;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Camera;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.R;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.doubleexposure.ClipVideoInfo;
import com.oplus.camera.doubleexposure.DecodeVideoRequest;
import com.oplus.camera.doubleexposure.VideoClipManager;
import com.oplus.camera.doubleexposure.BlurViewHideCallback;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.p172ui.widget.VideoClipView;
import com.oplus.camera.p181w.CameraThreadExector;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.DoubleExposureMsgData;
import com.oplus.camera.statistics.model.ReminderMsgData;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.camera.util.Util;
import com.oplus.camera.util.storage.MediaStoreUtil;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/* compiled from: DoubleExposureMode.java */
/* renamed from: com.oplus.camera.capmode.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class DoubleExposureMode extends CommonVideoMode implements View.OnClickListener {

    /* renamed from: A */
    private boolean f12857A;

    /* renamed from: B */
    private boolean f12858B;

    /* renamed from: C */
    private final DialogInterface.OnClickListener f12859C;

    /* renamed from: D */
    private BlurViewHideCallback f12860D;

    /* renamed from: E */
    private final DialogInterface.OnClickListener f12861E;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PlatformImplementations.kt_3 f12862g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private PlatformImplementations.kt_3 f12863h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f12864i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f12865j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f12866k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f12867l;

    /* renamed from: OplusGLSurfaceView_6 */
    private String f12868m;

    /* renamed from: OplusGLSurfaceView_11 */
    private String f12869n;

    /* renamed from: o */
    private ClipVideoInfo f12870o;

    /* renamed from: p */
    private ClipVideoInfo f12871p;

    /* renamed from: q */
    private COUIAlertDialog f12872q;

    /* renamed from: r */
    private int f12873r;

    /* renamed from: s */
    private RotateImageView f12874s;

    /* renamed from: t */
    private VideoClipView f12875t;

    /* renamed from: u */
    private boolean f12876u;

    /* renamed from: v */
    private boolean f12877v;

    /* renamed from: w */
    private boolean f12878w;

    /* renamed from: x */
    private boolean f12879x;

    /* renamed from: y */
    private long f12880y;

    /* renamed from: z */
    private long f12881z;

    /* compiled from: DoubleExposureMode.java */
    /* renamed from: com.oplus.camera.capmode.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    enum PlatformImplementations.kt_3 {
        FIRST_STAGE_PREVIEW,
        FIRST_STAGE_RECORDING,
        FIRST_STAGE_PAUSED,
        SECOND_STAGE_PREVIEW,
        SECOND_STAGE_RECORDING,
        SECOND_STAGE_PAUSED,
        SECOND_STAGE_REPLAY
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public String getCameraFeature() {
        return ApsConstant.FEATURE_REC_DOUBLE_EXPOSURE;
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.REC_MODE_DOUBLE_EXPOSURE;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return true;
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32779;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getRearEnable() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportFaceView() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
        return false;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public String getVideoSizeType() {
        return "video_size_720p";
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected long getVideoTimeLimit() {
        return 15000L;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isDoubleExposureOpen() {
        return true;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean isNeedAudioEncode() {
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaCodec() {
        return true;
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaRecorderNotUseAPS() {
        return true;
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return false;
    }

    public DoubleExposureMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f12862g = PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW;
        this.f12863h = PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW;
        this.f12864i = true;
        this.f12865j = false;
        this.f12866k = false;
        this.f12867l = false;
        this.f12868m = "";
        this.f12869n = "";
        this.f12870o = null;
        this.f12871p = null;
        this.f12873r = 0;
        this.f12874s = null;
        this.f12875t = null;
        this.f12876u = false;
        this.f12877v = false;
        this.f12878w = false;
        this.f12879x = false;
        this.f12880y = 0L;
        this.f12881z = 0L;
        this.f12857A = false;
        this.f12858B = false;
        this.f12859C = new DialogInterface.OnClickListener() { // from class: com.oplus.camera.capmode.COUIBaseListPopupWindow_11.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                if (PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW == DoubleExposureMode.this.m12444f()) {
                    DoubleExposureMode.this.m12438a(PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW);
                    DoubleExposureMode.this.mCameraUIInterface.mo18123aM();
                    DoubleExposureMode.this.m12431t();
                    DoubleExposureMode.this.m12429r();
                    if (DoubleExposureMode.this.f12867l) {
                        DoubleExposureMode.this.m12440a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE0, "cancel");
                    } else {
                        DoubleExposureMode.this.m12440a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE1, "cancel");
                    }
                } else if (PlatformImplementations.kt_3.SECOND_STAGE_REPLAY == DoubleExposureMode.this.m12444f()) {
                    DoubleExposureMode.this.m12438a(PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW);
                    DoubleExposureMode.this.mCameraUIInterface.mo18124aN();
                    DoubleExposureMode viewOnClickListenerC2653g = DoubleExposureMode.this;
                    viewOnClickListenerC2653g.m12399a(viewOnClickListenerC2653g.f12870o, false, null);
                    DoubleExposureMode.this.m12430s();
                    DoubleExposureMode.this.m12440a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE2, "cancel");
                }
                MainShutterButtonInfo shutterButtonInfo = DoubleExposureMode.this.getShutterButtonInfo();
                shutterButtonInfo.m19236c(PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW == DoubleExposureMode.this.m12444f());
                DoubleExposureMode.this.mCameraUIInterface.mo18091a(shutterButtonInfo);
                DoubleExposureMode.this.m12427p();
                DoubleExposureMode.this.m12428q();
            }
        };
        this.f12860D = new BlurViewHideCallback() { // from class: com.oplus.camera.capmode.COUIBaseListPopupWindow_11.5
            @Override // com.oplus.camera.doubleexposure.BlurViewHideCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12448a() {
                CameraLog.m12954a("DoubleExposureMode", "hideBlurView, mState: " + DoubleExposureMode.this.m12444f());
                if ((DoubleExposureMode.this.m12444f() == PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW || DoubleExposureMode.this.m12444f() == PlatformImplementations.kt_3.SECOND_STAGE_REPLAY) && DoubleExposureMode.this.mCameraUIInterface != null) {
                    DoubleExposureMode.this.mCameraUIInterface.mo18128aR();
                    DoubleExposureMode.this.f12858B = false;
                }
            }
        };
        this.f12861E = new DialogInterface.OnClickListener() { // from class: com.oplus.camera.capmode.COUIBaseListPopupWindow_11.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int OplusGLSurfaceView_13) {
                if (PlatformImplementations.kt_3.SECOND_STAGE_REPLAY == DoubleExposureMode.this.m12444f()) {
                    DoubleExposureMode.this.m12440a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE2, "exit");
                }
                if (PlatformImplementations.kt_3.FIRST_STAGE_PAUSED == DoubleExposureMode.this.m12444f() || PlatformImplementations.kt_3.SECOND_STAGE_PAUSED == DoubleExposureMode.this.m12444f()) {
                    DoubleExposureMode.this.stopShortVideoRecording();
                }
                DoubleExposureMode.this.cancelOp(false);
            }
        };
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public int getVideoFps() {
        return getVideoFrameRate();
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        super.onBeforePreview();
        this.mPreviewEffectProcess.mo22846k(this.mPreferences.getInt(CameraUIInterface.KEY_DOUBLE_EXPOSURE_EFFECT_TYPE, 5));
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        super.onAfterStartPreview(z);
        boolean z2 = this.mPreferences.getBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE, true);
        if (this.mPreferences.getBoolean(CameraUIInterface.KEY_DOUBLE_EXPOSURE_TIPS, true) || z2) {
            this.mPreferences.edit().putInt(CameraUIInterface.KEY_DOUBLE_EXPOSURE_OPEN_COUNT, this.f12873r).apply();
        }
        if (z && z2) {
            this.mCameraUIInterface.mo18234k(5);
        }
        m12427p();
        m12428q();
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void beforeSwitchToMode(boolean z) {
        super.beforeSwitchToMode(z);
        m12438a(PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW);
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void beforeSwitchCamera() {
        super.beforeSwitchCamera();
        this.f12858B = false;
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22856q();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:110:0x019e  */
    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.DoubleExposureMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        String strM13305d = CameraEntry.m13305d(str);
        if (CameraUIInterface.KEY_TORCH_MODE.equals(strM13305d) || CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE.equals(strM13305d) || CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(strM13305d)) {
            return PlatformImplementations.kt_3.SECOND_STAGE_REPLAY != m12444f() && getSupportFunction(strM13305d);
        }
        if (CameraUIInterface.KEY_SETTING.equals(strM13305d)) {
            return (PlatformImplementations.kt_3.SECOND_STAGE_REPLAY == m12444f() || PlatformImplementations.kt_3.SECOND_STAGE_RECORDING == m12444f()) ? false : true;
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        if (CameraUIInterface.KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE.equals(str) && PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW == m12444f()) {
            m12404b(R.string.camera_double_exposure_first_video_hint);
            return;
        }
        SharedPreferences sharedPreferences2 = this.mPreferences;
        String str2 = DoubleExposureMsgData.KEY_VIDEO_OPEN_TYPE_VALUE_FIRST_GUIDE;
        if (sharedPreferences2 != null && CameraUIInterface.KEY_DOUBLE_EXPOSURE_TIPS.equals(str)) {
            if (this.mPreferences.getBoolean(CameraUIInterface.KEY_DOUBLE_EXPOSURE_TIPS, false)) {
                return;
            }
            m12404b(R.string.camera_double_exposure_first_video_hint);
            m12441a(String.valueOf(-1), String.valueOf(SystemClock.uptimeMillis() - this.f12881z), DoubleExposureMsgData.KEY_VIDEO_EXIT_TYPE_VALUE_CLICK, DoubleExposureMsgData.KEY_VIDEO_OPEN_TYPE_VALUE_FIRST_GUIDE);
            return;
        }
        if (this.mPreferences != null && CameraUIInterface.KEY_DOUBLE_EXPOSURE_OPEN_COUNT.equals(str)) {
            int OplusGLSurfaceView_13 = this.mPreferences.getInt(CameraUIInterface.KEY_DOUBLE_EXPOSURE_OPEN_COUNT, 0);
            boolean z = this.mPreferences.getBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE, true);
            if (3 == OplusGLSurfaceView_13) {
                this.f12881z = SystemClock.uptimeMillis();
                this.mCameraUIInterface.mo18086a(this.mActivity.findViewById(R.id_renamed.load_video_button), 16, 0, this.mActivity.getResources().getDimensionPixelSize(R.dimen.video_clip_view_tip_offset));
                return;
            } else {
                if (z || 3 <= OplusGLSurfaceView_13 || PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW != m12444f()) {
                    return;
                }
                m12404b(R.string.camera_double_exposure_first_video_hint);
                return;
            }
        }
        if (CameraUIInterface.KEY_DOUBLE_EXPOSURE_EFFECT_TYPE.equals(str)) {
            if (5 == this.mPreferences.getInt(CameraUIInterface.KEY_DOUBLE_EXPOSURE_EFFECT_TYPE, 5)) {
                m12440a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_EFFECT, "mixed");
                return;
            } else {
                m12440a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_EFFECT, "silhouette");
                return;
            }
        }
        if (this.mPreferences != null && CameraUIInterface.KEY_DOUBLE_EXPOSURE_GUID_PAGE_AND_DURATION.equals(str)) {
            String string = this.mPreferences.getString(CameraUIInterface.KEY_DOUBLE_EXPOSURE_GUID_PAGE_AND_DURATION, "");
            String[] strArrSplit = TextUtils.isEmpty(string) ? null : string.split(":");
            if (strArrSplit == null || 2 >= strArrSplit.length) {
                return;
            }
            boolean z2 = this.mPreferences.getBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE, true);
            String str3 = strArrSplit[0];
            String str4 = strArrSplit[1];
            String str5 = strArrSplit[2];
            if (!z2) {
                str2 = DoubleExposureMsgData.KEY_VIDEO_OPEN_TYPE_VALUE_DURABLE_GUIDE;
            }
            m12441a(str3, str4, str5, str2);
            return;
        }
        if (!CameraUIInterface.KEY_VIDEO_FLASH_MODE.equals(str) || !this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_FLASH_MODE, "off").equals("off") || Camera.f10610l || Camera.f10611m) {
            return;
        }
        m12427p();
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        this.f12858B = m12444f() != PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW;
        this.f12876u = false;
        this.mCameraUIInterface.mo18210f(16, true);
        m12446h();
        super.onPause();
    }

    /* compiled from: DoubleExposureMode.java */
    /* renamed from: com.oplus.camera.capmode.COUIBaseListPopupWindow_11$4, reason: invalid class name */
    static /* synthetic */ class DoubleExposureMode_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f12891a = new int[PlatformImplementations.kt_3.values().length];

        static {
            try {
                f12891a[PlatformImplementations.kt_3.SECOND_STAGE_REPLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12891a[PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12891a[PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public MainShutterButtonInfo getShutterButtonInfo() {
        MainShutterButtonInfo c3200b;
        if (DoubleExposureMode_3.f12891a[m12444f().ordinal()] == 1) {
            c3200b = new MainShutterButtonInfo(21, "button_color_inside_none", "button_shape_ring_none", 0);
        } else {
            c3200b = super.getShutterButtonInfo();
        }
        c3200b.m19232b(true);
        return c3200b;
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        super.beforeStartRecording(true);
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$COUIBaseListPopupWindow_11$Ab908pFMcIPky9npln3j7gKumG0
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m12394D();
            }
        });
        if (PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW == this.f12862g) {
            m12438a(PlatformImplementations.kt_3.FIRST_STAGE_RECORDING);
            this.f12864i = false;
            this.mCameraUIInterface.mo18118aH();
        } else if (PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW == this.f12862g) {
            m12438a(PlatformImplementations.kt_3.SECOND_STAGE_RECORDING);
            this.f12864i = false;
            this.mCameraUIInterface.mo18119aI();
            m12432u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void m12394D() {
        this.mCameraUIInterface.mo18221h(15000);
        MainShutterButtonInfo c3200b = new MainShutterButtonInfo();
        c3200b.m19226a(22);
        c3200b.m19230b(1);
        c3200b.m19232b(true);
        this.mCameraUIInterface.mo18091a(c3200b);
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.BaseMode
    public void afterStartRecording() {
        displayScreenHintIconInSwitchOn();
        super.afterStartRecording();
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode
    protected void onStopVideoRecording(boolean z) {
        resetTimeUi();
        super.onStopVideoRecording(z);
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void stopVideoRecordThread() {
        super.stopVideoRecordThread();
        if (isRecordFileValid()) {
            if (PlatformImplementations.kt_3.FIRST_STAGE_RECORDING == m12444f() || PlatformImplementations.kt_3.FIRST_STAGE_PAUSED == m12444f()) {
                m12438a(PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW);
            } else if (PlatformImplementations.kt_3.SECOND_STAGE_RECORDING == m12444f() || PlatformImplementations.kt_3.SECOND_STAGE_PAUSED == m12444f()) {
                m12438a(PlatformImplementations.kt_3.SECOND_STAGE_REPLAY);
            }
            m12427p();
            m12428q();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onVideoLoadedDone(ClipVideoInfo c2683b, VideoClipManager.PlatformImplementations.kt_3 aVar) {
        CameraLog.m12954a("DoubleExposureMode", "onVideoLoadedDone, clipVideoInfo: " + c2683b);
        this.f12865j = false;
        this.f12868m = c2683b.m12899c();
        this.f12870o = c2683b;
        m12398a(this.f12870o, aVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onVideoRecordingFinish() {
        CameraLog.m12954a("DoubleExposureMode", "onVideoRecordingFinish, mState: " + m12444f());
        if (PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW == this.f12862g || PlatformImplementations.kt_3.FIRST_STAGE_RECORDING == this.f12862g || PlatformImplementations.kt_3.FIRST_STAGE_PAUSED == this.f12862g) {
            m12438a(PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW);
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$COUIBaseListPopupWindow_11$4opmBrVgitep2sfakXINTMxGH_s
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m12393C();
                }
            });
            this.f12868m = this.mVideoFilename;
            this.f12870o = new ClipVideoInfo(this.f12868m);
            m12398a(this.f12870o, (VideoClipManager.PlatformImplementations.kt_3) null);
        } else if (PlatformImplementations.kt_3.SECOND_STAGE_REPLAY == this.f12862g || PlatformImplementations.kt_3.SECOND_STAGE_RECORDING == this.f12862g || PlatformImplementations.kt_3.SECOND_STAGE_PAUSED == this.f12862g) {
            m12438a(PlatformImplementations.kt_3.SECOND_STAGE_REPLAY);
            m12420j();
        }
        m12427p();
        m12428q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ void m12393C() {
        MainShutterButtonInfo c3200b = new MainShutterButtonInfo(6, "button_color_inside_red", "button_shape_ring_none", 1);
        c3200b.m19232b(true);
        this.mCameraUIInterface.mo18091a(c3200b);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onVideoRecordingFail() {
        CameraLog.m12954a("DoubleExposureMode", "onVideoRecordingFail, mState: " + m12444f());
        if (PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW == this.f12862g || PlatformImplementations.kt_3.FIRST_STAGE_RECORDING == this.f12862g) {
            m12395a(R.string.camera_double_exposure_recording_hint, 3000);
            m12408c(R.string.camera_double_exposure_recording_hint);
            m12438a(PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW);
            m12406b(false);
        }
        if (PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW == m12444f()) {
            m12395a(R.string.camera_double_exposure_recording_hint, 3000);
            m12408c(R.string.camera_double_exposure_recording_hint);
        } else if (PlatformImplementations.kt_3.SECOND_STAGE_REPLAY == this.f12862g || PlatformImplementations.kt_3.SECOND_STAGE_RECORDING == this.f12862g) {
            m12395a(R.string.camera_double_exposure_recording_hint, 3000);
            m12408c(R.string.camera_double_exposure_recording_hint);
            m12438a(PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW);
            MainShutterButtonInfo c3200b = new MainShutterButtonInfo(6, "button_color_inside_red", "button_shape_ring_none", 1);
            c3200b.m19232b(true);
            this.mCameraUIInterface.mo18091a(c3200b);
            m12398a(this.f12870o, (VideoClipManager.PlatformImplementations.kt_3) null);
        }
        m12427p();
        m12428q();
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.COUIBaseListPopupWindow_11.7
            @Override // java.lang.Runnable
            public void run() {
                if (DoubleExposureMode.this.mCameraUIInterface != null) {
                    DoubleExposureMode.this.mCameraUIInterface.mo18258q();
                }
            }
        });
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m12420j() {
        CameraLog.m12954a("DoubleExposureMode", "onSecondStateRecordingFinish, mVideoFilename: " + this.mVideoFilename);
        this.f12880y = SystemClock.uptimeMillis();
        this.f12869n = this.mVideoFilename;
        this.f12871p = new ClipVideoInfo(this.f12869n);
        m12439a("2", this.f12871p);
        this.mCameraUIInterface.mo18120aJ();
        m12399a(this.f12871p, true, null);
        m12440a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE2, "save");
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$COUIBaseListPopupWindow_11$QrIApx6ya19IfzkdE1LRi9eT_6E
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m12392B();
            }
        });
        displayScreenHintIconInSwitchOn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void m12392B() {
        MainShutterButtonInfo c3200b = new MainShutterButtonInfo(17, "button_color_inside_none", "button_shape_ring_none", 0);
        c3200b.m19232b(true);
        this.mCameraUIInterface.mo18091a(c3200b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12398a(ClipVideoInfo c2683b, VideoClipManager.PlatformImplementations.kt_3 aVar) {
        CameraLog.m12954a("DoubleExposureMode", "onFirstStageDone, clipVideoInfo: " + c2683b);
        m12438a(PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW);
        if (aVar == null) {
            m12439a("1", c2683b);
            this.mCameraUIInterface.mo18121aK();
            m12399a(c2683b, false, null);
            this.f12867l = false;
            m12440a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE1, "save");
            return;
        }
        m12399a(c2683b, false, new DoubleExposureMode_4(c2683b, aVar));
    }

    /* compiled from: DoubleExposureMode.java */
    /* renamed from: com.oplus.camera.capmode.COUIBaseListPopupWindow_11$8, reason: invalid class name */
    class DoubleExposureMode_4 implements VideoClipManager.PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ ClipVideoInfo f12895a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final /* synthetic */ VideoClipManager.PlatformImplementations.kt_3 f12896b;

        DoubleExposureMode_4(ClipVideoInfo c2683b, VideoClipManager.PlatformImplementations.kt_3 aVar) {
            this.f12895a = c2683b;
            this.f12896b = aVar;
        }

        @Override // com.oplus.camera.doubleexposure.VideoClipManager.PlatformImplementations.kt_3
        public void onVideoClipDone() {
            DoubleExposureMode.this.m12439a("0", this.f12895a);
            this.f12896b.onVideoClipDone();
            DoubleExposureMode.this.mCameraUIInterface.mo18121aK();
            DoubleExposureMode.this.f12867l = true;
            DoubleExposureMode.this.m12440a(DoubleExposureMsgData.KEY_FUNC_ITEM_VALUE_PAGE0, "save");
            DoubleExposureMode.this.mHandler.postDelayed(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$COUIBaseListPopupWindow_11$8$0efWdS0GwEZU-NkYEKbxO39diSs
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m12449a();
                }
            }, 300L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public /* synthetic */ void m12449a() {
            DoubleExposureMode.this.m12427p();
            DoubleExposureMode.this.m12428q();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m12406b(final boolean z) {
        CameraLog.m12954a("DoubleExposureMode", "onSecondStageDone, isNeedButtonAnim: " + z);
        m12431t();
        m12447i();
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$COUIBaseListPopupWindow_11$WfuJubcaFTMSvrsIEp1XRw80AJk
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m12413d(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public /* synthetic */ void m12413d(boolean z) {
        MainShutterButtonInfo c3200b;
        if (this.mActivity == null || this.mActivity.isFinishing()) {
            return;
        }
        this.mCameraUIInterface.mo18122aL();
        if (z) {
            c3200b = new MainShutterButtonInfo(19, "button_color_inside_red", "button_shape_ring_none", 0);
        } else {
            c3200b = new MainShutterButtonInfo(6, "button_color_inside_red", "button_shape_ring_none", 1);
        }
        c3200b.m19232b(true);
        this.mCameraUIInterface.mo18091a(c3200b);
        this.f12857A = false;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m12421k() {
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.capmode.COUIBaseListPopupWindow_11.9
            @Override // java.lang.Runnable
            public void run() {
                DoubleExposureMode.this.m12423l();
            }
        }, "clear cache video");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public void m12423l() {
        CameraLog.m12954a("DoubleExposureMode", "deleteCacheVideos");
        File[] fileArrListFiles = new File(m12433v()).listFiles(new FileFilter() { // from class: com.oplus.camera.capmode.COUIBaseListPopupWindow_11.10
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.getName().contains(".mp4");
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (File file : fileArrListFiles) {
            file.delete();
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    /* renamed from: onVideoShutterButtonClick */
    public void m17833aj() {
        CameraLog.m12954a("DoubleExposureMode", "onVideoShutterButtonClick, mState: " + m12444f());
        if (m12426o()) {
            CameraLog.m12954a("DoubleExposureMode", "onVideoShutterButtonClick, need wait hide blur");
            return;
        }
        if (this.f12857A) {
            CameraLog.m12954a("DoubleExposureMode", "onVideoShutterButtonClick Cannot record while saving");
            return;
        }
        if (PlatformImplementations.kt_3.SECOND_STAGE_REPLAY == m12444f()) {
            this.f12857A = true;
            m12438a(PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW);
            this.mCurrentVideoValues.put("relative_path", super.getRelativePath());
            this.mCurrentVideoUri = MediaStoreUtil.m24650a(this.mActivity, this.mActivity.getContentResolver(), this.mCurrentVideoValues);
            CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$COUIBaseListPopupWindow_11$MxAImdDgNZkqG68REGzO_fnvx2A
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.COUIBaseListPopupWindow_12$0.m12391A();
                }
            }, "save-video");
        } else {
            if (this.mCameraUIInterface != null && !getSupportMenu(CameraUIInterface.KEY_SETTING)) {
                this.mCameraUIInterface.mo18204e(CameraUIInterface.KEY_SETTING);
            }
            super.m17833aj();
        }
        if (!this.mbLowBatteryDisabled) {
            m12427p();
            m12428q();
        }
        this.f12858B = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0083 A[Catch: IOException -> 0x007f, TRY_LEAVE, TryCatch #4 {IOException -> 0x007f, blocks: (B:34:0x007b, B:38:0x0083), top: B:44:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void m12391A() throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            android.app.Activity r1 = r5.mActivity     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            android.net.Uri r2 = r5.mCurrentVideoUri     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            java.lang.String r3 = "rw"
            android.os.ParcelFileDescriptor r1 = r1.openFileDescriptor(r2, r3)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            r5.mVideoFileDescriptor = r1     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            java.lang.String r2 = r5.mVideoFilename     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L38
            android.os.ParcelFileDescriptor r3 = r5.mVideoFileDescriptor     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L38
            java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L38
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L38
            android.os.FileUtils.copy(r1, r2)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            r1.close()     // Catch: java.io.IOException -> L4c
            r2.close()     // Catch: java.io.IOException -> L4c
            goto L57
        L2d:
            r5 = move-exception
            goto L36
        L2f:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L43
        L34:
            r5 = move-exception
            r2 = r0
        L36:
            r0 = r1
            goto L79
        L38:
            r2 = move-exception
            r4 = r2
            r2 = r0
            r0 = r1
            r1 = r4
            goto L43
        L3e:
            r5 = move-exception
            r2 = r0
            goto L79
        L41:
            r1 = move-exception
            r2 = r0
        L43:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L78
            if (r0 == 0) goto L4e
            r0.close()     // Catch: java.io.IOException -> L4c
            goto L4e
        L4c:
            r0 = move-exception
            goto L54
        L4e:
            if (r2 == 0) goto L57
            r2.close()     // Catch: java.io.IOException -> L4c
            goto L57
        L54:
            r0.printStackTrace()
        L57:
            com.oplus.camera.ui.control.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_5 r0 = new com.oplus.camera.ui.control.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_5
            r0.<init>()
            r1 = 1
            r0.f18298k = r1
            android.net.Uri r2 = r5.mCurrentVideoUri
            r0.f18291d = r2
            r2 = 0
            java.lang.String r3 = r5.getVideoTitle()
            r5.addVideoToMediaStore(r0, r2, r3)
            r5.closeVideoFileDescriptor()
            r5.m12425n()
            r5.m12406b(r1)
            r5.m12401a(r0)
            return
        L78:
            r5 = move-exception
        L79:
            if (r0 == 0) goto L81
            r0.close()     // Catch: java.io.IOException -> L7f
            goto L81
        L7f:
            r0 = move-exception
            goto L87
        L81:
            if (r2 == 0) goto L8a
            r2.close()     // Catch: java.io.IOException -> L7f
            goto L8a
        L87:
            r0.printStackTrace()
        L8a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.DoubleExposureMode.m12391A():void");
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        super.onResume(z);
        if (this.f12878w && !this.f12879x) {
            this.f12878w = false;
            this.f12879x = false;
            CameraLog.m12954a("DoubleExposureMode", "DoubleExposureMode, onResume, mbNeedRestore");
            return;
        }
        if (this.f12865j) {
            this.f12865j = false;
            this.mCameraUIInterface.mo18122aL();
            return;
        }
        int OplusGLSurfaceView_13 = DoubleExposureMode_3.f12891a[this.f12862g.ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            m12420j();
            return;
        }
        if (OplusGLSurfaceView_13 == 2) {
            m12406b(false);
            m12424m();
        } else {
            if (OplusGLSurfaceView_13 != 3) {
                return;
            }
            ClipVideoInfo c2683b = this.f12870o;
            if (c2683b != null) {
                m12398a(c2683b, (VideoClipManager.PlatformImplementations.kt_3) null);
                return;
            }
            this.f12858B = false;
            m12438a(PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW);
            m12406b(false);
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m12424m() {
        if (this.mPreviewEffectProcess != null && this.f12866k) {
            this.mPreviewEffectProcess.mo22857r();
            this.mPreviewEffectProcess.mo22846k(this.mPreferences.getInt(CameraUIInterface.KEY_DOUBLE_EXPOSURE_EFFECT_TYPE, 5));
        }
        this.f12866k = true;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m12425n() {
        m12429r();
        m12430s();
        this.f12868m = "";
        this.f12869n = "";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void revertOp() {
        if (PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW == m12444f()) {
            CameraLog.m12954a("DoubleExposureMode", "revertOp, not PlatformImplementations.kt_3 valid state");
        } else if (m12426o()) {
            CameraLog.m12954a("DoubleExposureMode", "revertOp, need wait hide blur");
        } else {
            CameraLog.m12954a("DoubleExposureMode", "revertOp");
            m12445g();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cancelOp(boolean z) {
        if (m12426o()) {
            CameraLog.m12954a("DoubleExposureMode", "cancelOp, need wait hide blur");
            return;
        }
        CameraLog.m12954a("DoubleExposureMode", "cancelOp, showDialog: " + z);
        if (z) {
            m12442a(false);
        } else {
            m12438a(PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW);
            this.mCameraUIInterface.mo18123aM();
            m12431t();
            m12429r();
            m12430s();
            MainShutterButtonInfo shutterButtonInfo = getShutterButtonInfo();
            shutterButtonInfo.m19236c(true);
            this.mCameraUIInterface.mo18091a(shutterButtonInfo);
        }
        m12427p();
        m12428q();
    }

    /* renamed from: o */
    private boolean m12426o() {
        return this.f12858B && PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW != m12444f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m12427p() {
        boolean z = this.mPreferences.getBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE, true);
        boolean z2 = this.mPreferences.getBoolean(CameraUIInterface.KEY_DOUBLE_EXPOSURE_TIPS, true);
        if (z || m12434w() || (z2 && 3 == this.f12873r && PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW != m12444f())) {
            m12409c(!m12436y());
            m12409c(!m12436y());
        } else if (PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW == m12444f()) {
            m12404b(R.string.camera_double_exposure_first_video_hint);
        } else if (PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW == m12444f()) {
            m12404b(R.string.camera_double_exposure_two_video_hint);
        } else {
            m12409c(!m12436y());
            m12409c(!m12436y());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m12428q() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$COUIBaseListPopupWindow_11$F4tCr_7WQEqiBCbXYiJpcWvyiUM
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m12437z();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void m12437z() {
        if (this.f12874s != null && !m12434w()) {
            if (PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW == m12444f()) {
                Util.m24270a(this.f12874s, 0, (Animation.AnimationListener) null, 200L);
                return;
            } else if (PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW == m12444f()) {
                Util.m24270a(this.f12874s, 0, (Animation.AnimationListener) null, 200L);
                return;
            } else {
                Util.m24270a(this.f12874s, 8, (Animation.AnimationListener) null, 200L);
                return;
            }
        }
        Util.m24270a(this.f12874s, 8, (Animation.AnimationListener) null, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m12429r() {
        File file = new File(this.f12868m);
        if (file.exists() && m12403a(file)) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m12430s() {
        File file = new File(this.f12869n);
        if (file.exists() && m12403a(file)) {
            file.delete();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m12403a(File file) {
        return file.getAbsolutePath().startsWith(m12433v());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12401a(final Thumbnail.IntrinsicsJvm.kt_5 dVar) {
        if (this.mCameraInterface != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.COUIBaseListPopupWindow_11.11
                @Override // java.lang.Runnable
                public void run() {
                    DoubleExposureMode.this.mCameraInterface.mo10484a(dVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m12431t() {
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22854o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12399a(ClipVideoInfo c2683b, boolean z, VideoClipManager.PlatformImplementations.kt_3 aVar) {
        if (this.mbPaused) {
            CameraLog.m12954a("DoubleExposureMode", "decodeVideo, cancel decode video, mbPaused: " + this.mbPaused);
            return;
        }
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22784a(new DecodeVideoRequest(c2683b, z, aVar, this.f12860D));
        }
    }

    /* renamed from: u */
    private void m12432u() {
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22855p();
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean onVideoRecordingPause() {
        if (PlatformImplementations.kt_3.FIRST_STAGE_RECORDING == this.f12862g) {
            m12438a(PlatformImplementations.kt_3.FIRST_STAGE_PAUSED);
        } else if (PlatformImplementations.kt_3.SECOND_STAGE_RECORDING == this.f12862g) {
            m12438a(PlatformImplementations.kt_3.SECOND_STAGE_PAUSED);
        }
        return super.onVideoRecordingPause();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean onVideoRecordingResume() {
        if (PlatformImplementations.kt_3.FIRST_STAGE_PAUSED == this.f12862g) {
            m12438a(PlatformImplementations.kt_3.FIRST_STAGE_RECORDING);
        } else if (PlatformImplementations.kt_3.SECOND_STAGE_PAUSED == this.f12862g) {
            m12438a(PlatformImplementations.kt_3.SECOND_STAGE_RECORDING);
        }
        return super.onVideoRecordingResume();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public PlatformImplementations.kt_3 m12444f() {
        return this.f12862g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12438a(PlatformImplementations.kt_3 aVar) {
        this.f12863h = this.f12862g;
        this.f12862g = aVar;
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.COUIBaseListPopupWindow_11.12
            @Override // java.lang.Runnable
            public void run() {
                if (DoubleExposureMode.this.mCameraUIInterface != null) {
                    if (PlatformImplementations.kt_3.SECOND_STAGE_REPLAY == DoubleExposureMode.this.f12863h || PlatformImplementations.kt_3.SECOND_STAGE_REPLAY == DoubleExposureMode.this.f12862g) {
                        DoubleExposureMode.this.mCameraUIInterface.mo18258q();
                    }
                }
            }
        });
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void startLoadVideo(boolean z) {
        if (this.mbDisplayOnLock) {
            this.f12876u = true;
            Util.m24326aO();
            return;
        }
        this.f12876u = false;
        this.f12865j = true;
        if (this.mPreferences != null && initVideoFileDescriptor()) {
            RotateImageView rotateImageView = this.f12874s;
            if (rotateImageView != null) {
                Util.m24270a(rotateImageView, 8, (Animation.AnimationListener) null, 200L);
            }
            m12443b(DoubleExposureMsgData.KEY_FUNC_ID_VALUE_TO_GALLERY);
            this.mPreferences.edit().putString(CameraUIInterface.KEY_VIDEO_CLIP_SAVE_PATH, this.mVideoFilename).apply();
            this.mPreferences.edit().putBoolean(CameraUIInterface.KEY_DOUBLE_EXPOSURE_TIPS, false).apply();
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            intent.setPackage(Util.m24327aP());
            intent.putExtra("from-Camera-For-Limit", true);
            intent.putExtra("limit_type", 0);
            intent.putExtra("animation_type", 0);
            this.mActivity.startActivityForResult(intent, 11111);
            this.mActivity.overridePendingTransition(R.anim.gallery_video_in, R.anim.camera_video_out);
            return;
        }
        this.f12865j = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setDisplayOnLock(boolean z) {
        super.setDisplayOnLock(z);
        if (this.mbDisplayOnLock || !this.f12876u) {
            return;
        }
        startLoadVideo(false);
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected String getVideoSavePath() {
        String strM12433v;
        if (PlatformImplementations.kt_3.SECOND_STAGE_RECORDING == this.f12862g || PlatformImplementations.kt_3.FIRST_STAGE_RECORDING == this.f12862g || this.f12865j) {
            strM12433v = m12433v();
        } else {
            strM12433v = super.getVideoSavePath();
        }
        CameraLog.m12954a("DoubleExposureMode", "getVideoSavePath, path: " + strM12433v + ", mState: " + this.f12862g);
        return strM12433v;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getRelativePath() {
        if (PlatformImplementations.kt_3.SECOND_STAGE_RECORDING == this.f12862g || PlatformImplementations.kt_3.FIRST_STAGE_RECORDING == this.f12862g) {
            return m12433v();
        }
        return super.getRelativePath();
    }

    /* renamed from: v */
    private String m12433v() {
        return this.mActivity.getDataDir().getAbsolutePath() + File.separator + "files" + File.separator;
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean isNeedGenerateUri() {
        return this.f12864i;
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() throws Resources.NotFoundException {
        CameraLog.m12954a("DoubleExposureMode", "onInitCameraMode");
        super.onInitCameraMode();
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.capmode.COUIBaseListPopupWindow_11.2
            @Override // java.lang.Runnable
            public void run() throws Exception {
                if (DoubleExposureMode.this.f12877v) {
                    return;
                }
                NvsStreamingContext.init(DoubleExposureMode.this.mActivity.getApplicationContext(), "assets:/meicam.lic", 1);
                DoubleExposureMode.this.f12877v = true;
                if (DoubleExposureMode.this.mCameraUIInterface != null) {
                    DoubleExposureMode.this.mCameraUIInterface.mo18126aP();
                }
            }
        }, "init NvsStreamingContext");
        if (this.mPreferences != null) {
            boolean z = this.mPreferences.getBoolean(CameraUIInterface.KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE, true);
            boolean z2 = this.mPreferences.getBoolean(CameraUIInterface.KEY_DOUBLE_EXPOSURE_TIPS, true);
            if (z || z2) {
                this.f12873r = this.mPreferences.getInt(CameraUIInterface.KEY_DOUBLE_EXPOSURE_OPEN_COUNT, 0);
                this.f12873r++;
            }
        }
        this.f12875t = (VideoClipView) this.mActivity.findViewById(R.id_renamed.video_clip_view);
        m12435x();
        this.f12876u = false;
        this.f12857A = false;
    }

    /* renamed from: w */
    private boolean m12434w() {
        if (this.f12875t == null && this.mActivity != null) {
            this.f12875t = (VideoClipView) this.mActivity.findViewById(R.id_renamed.video_clip_view);
        }
        VideoClipView viewOnClickListenerC3522e = this.f12875t;
        return viewOnClickListenerC3522e != null && viewOnClickListenerC3522e.m24132d();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m12404b(int OplusGLSurfaceView_13) {
        if (this.mCameraUIInterface != null && (PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW == m12444f() || PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW == m12444f())) {
            this.mCameraUIInterface.mo18073a(OplusGLSurfaceView_13, 0, false, false, true, false, false, true, 5000, true);
        } else {
            m12409c(!m12436y());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m12409c(boolean z) {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18108a(true, false, z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12395a(int OplusGLSurfaceView_13, int i2) {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18073a(OplusGLSurfaceView_13, 0, true, false, false, false, false, true, i2, true);
        }
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        CameraLog.m12954a("DoubleExposureMode", "onDeInitCameraMode");
        super.onDeInitCameraMode(str);
        RotateImageView rotateImageView = this.f12874s;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(8);
        }
        m12446h();
        this.f12876u = false;
        this.f12857A = false;
        this.mCameraUIInterface.mo18125aO();
        this.mCameraUIInterface.mo18203e(5, true);
        this.mCameraUIInterface.mo18130aT();
        m12421k();
        this.mCameraUIInterface.mo18210f(16, true);
        m12409c(false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getZoomBarOffset() {
        if (PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW == m12444f()) {
            return (int) this.mActivity.getResources().getDimension(R.dimen.effect_menu_zoom_margin_bottom);
        }
        return super.getZoomBarOffset();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void restoreDefaultMode(boolean z) {
        CameraLog.m12966e("DoubleExposureMode", "restoreDefaultMode, isNeedKeepCurrentMode: " + z);
        super.restoreDefaultMode(z);
        this.f12878w = TextUtils.equals(this.mCameraUIInterface.mo18132aV(), getCameraMode());
        this.f12879x = z;
        this.mCameraUIInterface.mo18047M(PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW == m12444f() || PlatformImplementations.kt_3.SECOND_STAGE_RECORDING == m12444f() || PlatformImplementations.kt_3.FIRST_STAGE_RECORDING == m12444f() || !this.f12879x);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12442a(boolean z) {
        if (PlatformImplementations.kt_3.SECOND_STAGE_REPLAY == m12444f() || z) {
            m12446h();
            this.f12872q = new COUIAlertDialog.PlatformImplementations.kt_3(this.mActivity).m6600f(1).setNeutralButton(R.string.camera_double_exposure_exit_hint, this.f12861E).setNegativeButton(R.string.camera_double_exposure_cancel, (DialogInterface.OnClickListener) null).create();
            if (this.mActivity.isFinishing()) {
                return;
            }
            this.f12872q.show();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m12445g() {
        if (PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW == m12444f() || PlatformImplementations.kt_3.SECOND_STAGE_REPLAY == m12444f()) {
            m12446h();
            this.f12872q = new COUIAlertDialog.PlatformImplementations.kt_3(this.mActivity).m6600f(1).setNeutralButton(R.string.camera_double_exposure_replay_last_video_hint, this.f12859C).setNegativeButton(R.string.camera_double_exposure_cancel, (DialogInterface.OnClickListener) null).create();
            if (this.mActivity.isFinishing()) {
                return;
            }
            this.f12872q.show();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m12446h() {
        COUIAlertDialog dialogInterfaceC1289b = this.f12872q;
        if (dialogInterfaceC1289b == null || !dialogInterfaceC1289b.isShowing()) {
            return;
        }
        this.f12872q.dismiss();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        if (PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW != m12444f()) {
            if (PlatformImplementations.kt_3.FIRST_STAGE_RECORDING != m12444f() && PlatformImplementations.kt_3.SECOND_STAGE_RECORDING != m12444f()) {
                m12442a(true);
            } else if (this.mRecordingTotalTime >= getRecordingMinTime(false)) {
                this.mActivity.findViewById(R.id_renamed.video_pause_resume).performClick();
                m12442a(true);
            }
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void stopShortVideoRecording() {
        if (isVideoRecordStarted()) {
            m17833aj();
        } else {
            this.mHandler.removeMessages(10);
            this.mHandler.sendEmptyMessage(10);
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        if (this.f12874s != null) {
            this.f12874s = null;
        }
        super.onDestroy();
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) {
        RotateImageView rotateImageView = this.f12874s;
        if (rotateImageView != null) {
            rotateImageView.m18348a(OplusGLSurfaceView_13, true);
        }
        super.setOrientation(OplusGLSurfaceView_13);
    }

    /* renamed from: x */
    private void m12435x() throws Resources.NotFoundException {
        if (this.f12874s == null) {
            this.f12874s = new RotateImageView(this.mActivity);
            this.f12874s.setId(R.id_renamed.professional_parameter_bottom_guide_entry);
            this.f12874s.setImageResource(R.drawable.professional_guide_tip);
            int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_size);
            int settingMenuPanelHeight = Util.getSettingMenuPanelHeight() + this.mActivity.getResources().getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_margin_top);
            int dimensionPixelSize2 = this.mActivity.getResources().getDimensionPixelSize(R.dimen.common_bottom_guide_professional_entry_margin_end);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.setMargins(0, settingMenuPanelHeight, 0, 0);
            layoutParams.setMarginEnd(dimensionPixelSize2);
            this.f12874s.setLayoutParams(layoutParams);
            this.f12874s.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.capmode.-$$Lambda$xW5jzJJ1VZaBFepN-Obd1Hssr3U
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.COUIBaseListPopupWindow_12$0.onClick(view);
                }
            });
        }
        this.mCameraUIInterface.mo18087a((View) this.f12874s, ApsConstant.REC_MODE_DOUBLE_EXPOSURE, 3, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onModeShownTips(int OplusGLSurfaceView_13) {
        m12408c(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12440a(String str, String str2) {
        if (this.mActivity == null) {
            return;
        }
        DoubleExposureMsgData doubleExposureMsgData = new DoubleExposureMsgData(this.mActivity.getApplicationContext());
        doubleExposureMsgData.buildEventId("funcValue_select");
        doubleExposureMsgData.mFuncKeyId = DoubleExposureMsgData.KEY_FUNC_ID_VALUE;
        doubleExposureMsgData.mCaptureMode = getCameraMode();
        doubleExposureMsgData.mCameraId = getProperCameraId(this.mCameraId);
        doubleExposureMsgData.mFuncKeyItem = str;
        doubleExposureMsgData.mFuncKeyValue = str2;
        doubleExposureMsgData.report();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12443b(String str) {
        if (this.mActivity == null) {
            return;
        }
        DoubleExposureMsgData doubleExposureMsgData = new DoubleExposureMsgData(this.mActivity.getApplicationContext());
        doubleExposureMsgData.buildEventId("funcKey_click");
        doubleExposureMsgData.mFuncKeyId = str;
        doubleExposureMsgData.mCaptureMode = getCameraMode();
        doubleExposureMsgData.mCameraId = getProperCameraId(this.mCameraId);
        doubleExposureMsgData.mFuncKeyResult = String.valueOf(2);
        doubleExposureMsgData.report();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12439a(String str, ClipVideoInfo c2683b) {
        if (this.mActivity == null) {
            return;
        }
        DoubleExposureMsgData doubleExposureMsgData = new DoubleExposureMsgData(this.mActivity.getApplicationContext());
        doubleExposureMsgData.buildEventId(DoubleExposureMsgData.EVENT_FUNCTION_PARAMS_VIDEO_CLIP);
        doubleExposureMsgData.mPageId = str;
        doubleExposureMsgData.mOrientation = this.mOrientation;
        doubleExposureMsgData.mCaptureMode = getCameraMode();
        doubleExposureMsgData.mCameraId = getProperCameraId(this.mCameraId);
        if (c2683b != null) {
            if (!c2683b.m12904h()) {
                doubleExposureMsgData.mVideoTime = String.valueOf(c2683b.m12901e() - c2683b.m12900d());
                doubleExposureMsgData.mVideoRecMode = c2683b.m12897b();
                doubleExposureMsgData.mVideoFps = String.valueOf(c2683b.m12893a());
                doubleExposureMsgData.report();
                return;
            }
            m12400a(doubleExposureMsgData, c2683b);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12400a(final DoubleExposureMsgData doubleExposureMsgData, final ClipVideoInfo c2683b) {
        if (c2683b == null || TextUtils.isEmpty(c2683b.m12899c())) {
            return;
        }
        CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.capmode.COUIBaseListPopupWindow_11.3
            @Override // java.lang.Runnable
            public void run() throws IOException, IllegalArgumentException {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(c2683b.m12899c());
                    doubleExposureMsgData.mVideoFps = String.valueOf(mediaMetadataRetriever.extractMetadata(20));
                    doubleExposureMsgData.mVideoTime = String.valueOf(mediaMetadataRetriever.extractMetadata(9));
                    String strValueOf = String.valueOf(mediaMetadataRetriever.extractMetadata(18));
                    String strValueOf2 = String.valueOf(mediaMetadataRetriever.extractMetadata(19));
                    mediaMetadataRetriever.release();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(strValueOf2);
                    stringBuffer.append("x");
                    stringBuffer.append(strValueOf);
                    doubleExposureMsgData.mVideoRecMode = stringBuffer.toString();
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
                doubleExposureMsgData.report();
            }
        }, "setClipVideoInfo");
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m12447i() {
        if (this.mActivity == null || this.mCurrentVideoUri == null) {
            return;
        }
        DoubleExposureMsgData doubleExposureMsgData = new DoubleExposureMsgData(this.mActivity.getApplicationContext());
        doubleExposureMsgData.buildEventId(DoubleExposureMsgData.EVENT_FUNCTION_PARAMS_VIDEO_PLAYBACK);
        doubleExposureMsgData.mPageId = "2";
        doubleExposureMsgData.mOrientation = this.mOrientation;
        doubleExposureMsgData.mCaptureMode = getCameraMode();
        doubleExposureMsgData.mCameraId = getProperCameraId(this.mCameraId);
        doubleExposureMsgData.mDuration = String.valueOf(SystemClock.uptimeMillis() - this.f12880y);
        doubleExposureMsgData.report();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m12408c(int OplusGLSurfaceView_13) {
        ReminderMsgData reminderMsgData = new ReminderMsgData(this.mActivity, false);
        switch (OplusGLSurfaceView_13) {
            case R.string.camera_double_exposure_nobody_hint /* 2131755312 */:
                reminderMsgData.mReminderTypeValue = ReminderMsgData.TYPE_ADVICE;
                reminderMsgData.mReminderCodeValue = "no_face";
                break;
            case R.string.camera_double_exposure_recording_hint /* 2131755313 */:
                reminderMsgData.mReminderTypeValue = ReminderMsgData.TYPE_DISABLE_CODE;
                reminderMsgData.mReminderCodeValue = ReminderMsgData.CODE_TIME_SHORT;
                break;
            case R.string.mode_double_exposure_move_closer /* 2131756529 */:
                reminderMsgData.mReminderTypeValue = "bokeh_code";
                reminderMsgData.mReminderCodeValue = ReminderMsgData.CODE_MOVE_CLOSER;
                break;
            case R.string.mode_double_exposure_video_cannot_resolve /* 2131756531 */:
                reminderMsgData.mReminderTypeValue = ReminderMsgData.TYPE_DISABLE_CODE;
                reminderMsgData.mReminderCodeValue = ReminderMsgData.CODE_VIDEO_UNPARSEABLE;
                break;
            default:
                return;
        }
        reminderMsgData.mCameraId = getProperCameraId(this.mCameraId);
        reminderMsgData.mCaptureMode = getCameraMode();
        reminderMsgData.mOrientation = this.mOrientation;
        reminderMsgData.mRearOrFront = this.mbFrontCamera ? DcsMsgData.FRONT : DcsMsgData.REAR;
        reminderMsgData.report();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12441a(String str, String str2, String str3, String str4) {
        if (this.mActivity == null) {
            return;
        }
        DoubleExposureMsgData doubleExposureMsgData = new DoubleExposureMsgData(this.mActivity.getApplicationContext());
        doubleExposureMsgData.buildEventId(DoubleExposureMsgData.EVENT_FUNCTION_PARAMS_GUIDE_PAGE);
        char c2 = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c2 = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c2 = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            doubleExposureMsgData.mPageId = DoubleExposureMsgData.KEY_VIDEO_PAGE_ID_VALUE_FROM_VIDEO_OVERLAY;
        } else if (c2 == 1) {
            doubleExposureMsgData.mPageId = DoubleExposureMsgData.KEY_VIDEO_PAGE_ID_VALUE_FROM_SCENE_VIDEO;
        } else if (c2 == 2) {
            doubleExposureMsgData.mPageId = DoubleExposureMsgData.KEY_VIDEO_PAGE_ID_VALUE_FROM_PORTRAIT_VIDEO;
        } else {
            doubleExposureMsgData.mPageId = DoubleExposureMsgData.KEY_VIDEO_PAGE_ID_VALUE_FROM_GUIDE_GALLERY;
        }
        doubleExposureMsgData.mPageDuration = str2;
        doubleExposureMsgData.mCaptureMode = getCameraMode();
        doubleExposureMsgData.mCameraId = getProperCameraId(this.mCameraId);
        doubleExposureMsgData.mExitType = str3.trim();
        doubleExposureMsgData.mOpenType = str4;
        doubleExposureMsgData.report();
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        super.onGetBeforeCaptureMsgCommonData(dcsMsgData);
        if (dcsMsgData instanceof VideoRecordMsgData) {
            VideoRecordMsgData videoRecordMsgData = (VideoRecordMsgData) dcsMsgData;
            if (5 == this.mPreferences.getInt(CameraUIInterface.KEY_DOUBLE_EXPOSURE_EFFECT_TYPE, 5)) {
                videoRecordMsgData.mDoubleExposureEffect = "mixed";
            } else {
                videoRecordMsgData.mDoubleExposureEffect = "silhouette";
            }
        }
        return dcsMsgData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id_renamed.professional_parameter_bottom_guide_entry || this.mCameraUIInterface == null || this.mCameraInterface == null || this.mCameraInterface.mo10450F()) {
            return;
        }
        m12443b(DoubleExposureMsgData.KEY_FUNC_ID_VALUE_i);
        this.mCameraUIInterface.mo18234k(5);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean shouldHideBlur() {
        boolean z = (m12444f() == PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW || m12444f() == PlatformImplementations.kt_3.SECOND_STAGE_REPLAY) ? false : true;
        CameraLog.m12954a("DoubleExposureMode", "shouldHideBlur, shouldHideBlur: " + z);
        return z;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isBottomGuideEntryViewShown() {
        return PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW == m12444f() || PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW == m12444f();
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.BaseMode
    public void displayScreenHintIconInSwitchOn() {
        if (!needUpdateFlashIcon()) {
            this.mCameraUIInterface.mo18108a(false, true, true);
        } else {
            super.displayScreenHintIconInSwitchOn();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needUpdateFlashIcon() {
        return (PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW == m12444f() || PlatformImplementations.kt_3.SECOND_STAGE_PREVIEW == m12444f() || PlatformImplementations.kt_3.SECOND_STAGE_REPLAY == m12444f()) ? false : true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        super.onMoreModeShown();
        View viewFindViewById = this.mActivity.findViewById(R.id_renamed.load_video_button);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        RotateImageView rotateImageView = this.f12874s;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(8);
        }
        this.mCameraUIInterface.mo18203e(5, true);
    }

    @Override // com.oplus.camera.capmode.CommonVideoMode, com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) {
        super.onMoreModeHidden(OplusGLSurfaceView_13);
        View viewFindViewById = this.mActivity.findViewById(R.id_renamed.load_video_button);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
        RotateImageView rotateImageView = this.f12874s;
        if (rotateImageView != null) {
            rotateImageView.setVisibility(0);
        }
        m12427p();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAllowSwitch(CameraConstant.PlatformImplementations.kt_3 aVar) {
        if (aVar == CameraConstant.PlatformImplementations.kt_3.MODE && this.f12862g != PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW) {
            CameraLog.m12967f("DoubleExposureMode", "isAllowSwitch, not preview state, can't swith mode.");
            return false;
        }
        return super.isAllowSwitch(aVar);
    }

    /* renamed from: y */
    private boolean m12436y() {
        return this.mCameraUIInterface != null && isVideoFlashTorchOpen() && needUpdateFlashIcon();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isHideHeadLine() {
        if (PlatformImplementations.kt_3.FIRST_STAGE_PREVIEW != m12444f() || m12434w()) {
            return true;
        }
        return super.isHideHeadLine();
    }
}
