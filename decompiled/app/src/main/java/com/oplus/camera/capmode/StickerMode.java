package com.oplus.camera.capmode;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.location.Location;
import android.media.CamcorderProfile;
import android.media.ImageReader;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.exoplayer2.C1547C;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.R;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.service.CameraCaptureResult;
import com.oplus.camera.aps.service.ThumbnailItem;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.aps.util.CameraApsDecision;
import com.oplus.camera.filmvideomode.FilmAnimatorUtil;
import com.oplus.camera.jni.IccProfile;
import com.oplus.camera.p136a.CaptureMsgDataReportUtil;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p144g.C2735b;
import com.oplus.camera.p152k.HeicProcessor;
import com.oplus.camera.p153l.RegionCommonFeatureAdapter;
import com.oplus.camera.p154m.ImageSaverThread;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.menu.BasicOptionItemList;
import com.oplus.camera.p172ui.menu.PopUpWindowManager;
import com.oplus.camera.p172ui.menu.levelcontrol.GLModelParam;
import com.oplus.camera.p172ui.preview.CameraScreenNail;
import com.oplus.camera.p172ui.preview.p177a.TexturePreview;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.ImageStickerTools;
import com.oplus.camera.p172ui.preview.p177a.ImageCallback;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.p172ui.preview.p177a.StickerDownloadListener;
import com.oplus.camera.p172ui.widget.LockViewDragLayout;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.FocusAimMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.statistics.model.StickerMsgData;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.camera.sticker.StickerMediator;
import com.oplus.camera.sticker.data.StickerCategoryItem;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.sticker.p168ui.ImageDownloader;
import com.oplus.camera.sticker.p168ui.StickerMenu;
import com.oplus.camera.sticker.p168ui.StickerRecycleBinDialog;
import com.oplus.camera.sticker.p168ui.StickerMenuListener;
import com.oplus.camera.util.Util;
import com.oplus.exif.OplusExifInterface;
import com.oplus.exif.OplusExifTag;
import com.oplus.exif.OplusRational;
import com.oplus.ocs.camera.CameraParameter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: StickerMode.java */
/* renamed from: com.oplus.camera.capmode.t */
/* loaded from: classes2.dex */
public class StickerMode extends VideoMode {

    /* renamed from: A */
    private int f12986A;

    /* renamed from: B */
    private long f12987B;

    /* renamed from: C */
    private long f12988C;

    /* renamed from: D */
    private boolean f12989D;

    /* renamed from: E */
    private Storage.CameraPicture f12990E;

    /* renamed from: F */
    private boolean f12991F;

    /* renamed from: G */
    private boolean f12992G;

    /* renamed from: H */
    private ImageCallback f12993H;

    /* renamed from: I */
    private StickerMenuListener f12994I;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Object f12995g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final Runnable f12996h;

    /* renamed from: OplusGLSurfaceView_13 */
    private StickerMenu f12997i;

    /* renamed from: OplusGLSurfaceView_15 */
    private StickerRecycleBinDialog f12998j;

    /* renamed from: OplusGLSurfaceView_5 */
    private StickerDownloadListener f12999k;

    /* renamed from: OplusGLSurfaceView_14 */
    private Float f13000l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Float f13001m;

    /* renamed from: OplusGLSurfaceView_11 */
    private Integer f13002n;

    /* renamed from: o */
    private Integer f13003o;

    /* renamed from: p */
    private Long f13004p;

    /* renamed from: q */
    private ImageReader f13005q;

    /* renamed from: r */
    private ImageReader f13006r;

    /* renamed from: s */
    private int f13007s;

    /* renamed from: t */
    private int f13008t;

    /* renamed from: u */
    private String f13009u;

    /* renamed from: v */
    private HashMap<String, Long> f13010v;

    /* renamed from: w */
    private HashMap<String, Integer> f13011w;

    /* renamed from: x */
    private ArrayList<StickerMenu.IntrinsicsJvm.kt_4> f13012x;

    /* renamed from: y */
    private ImageDownloader f13013y;

    /* renamed from: z */
    private ThumbnailItem f13014z;

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean checkPreviewResult(CameraApsDecision cameraApsDecision) {
        return true;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public String getCameraFeature() {
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_STICKER;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultCaptureNumber() {
        return 1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getEffectMenuKeyByMode() {
        return CameraUIInterface.KEY_FILTER_MENU;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getFaceBeautyKey() {
        return CameraUIInterface.KEY_STICKER_FACEBEAUTY_LEVEL_MENU;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected int getFaceBeautyModeIndex() {
        return 4;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public String getFilterEffectMenuPreferenceKey() {
        return CameraUIInterface.KEY_STICKER_FILTER_INDEX;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getFullPictureSizeType() {
        return "16_9";
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected String getGuideLineKey() {
        return CameraUIInterface.KEY_LINE_PHOTO;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getImageFormat() {
        return 35;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32782;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportQuickJpeg(CameraRequestTag c2693c) {
        return false;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
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

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isUseMediaCodec() {
        return true;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean isVideoModeType() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needPreviewMeta(int OplusGLSurfaceView_13) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean performSlide(int OplusGLSurfaceView_13, MotionEvent motionEvent) {
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    static /* synthetic */ int m12642d(StickerMode c2666t) {
        int OplusGLSurfaceView_13 = c2666t.f13008t;
        c2666t.f13008t = OplusGLSurfaceView_13 + 1;
        return OplusGLSurfaceView_13;
    }

    public StickerMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f12995g = new Object();
        this.f12996h = new Runnable() { // from class: com.oplus.camera.capmode.-$$Lambda$Udg34mRWRHTn64j-v8WFCDjd4mQ
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                this.COUIBaseListPopupWindow_12$0.m17833aj();
            }
        };
        this.f12997i = null;
        this.f12998j = null;
        this.f12999k = new PlatformImplementations.kt_3();
        this.f13000l = null;
        this.f13001m = null;
        this.f13002n = null;
        this.f13003o = null;
        this.f13004p = null;
        this.f13005q = null;
        this.f13006r = null;
        this.f13007s = 0;
        this.f13008t = 0;
        this.f13009u = null;
        this.f13010v = null;
        this.f13011w = null;
        this.f13012x = null;
        this.f13013y = null;
        this.f13014z = null;
        this.f12986A = 0;
        this.f12987B = 0L;
        this.f12988C = 0L;
        this.f12989D = false;
        this.f12990E = null;
        this.f12991F = false;
        this.f12992G = false;
        this.f12993H = new ImageCallback() { // from class: com.oplus.camera.capmode.t.1
            @Override // com.oplus.camera.p172ui.preview.p177a.ImageCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12656a(GLModelParam c3284i) {
            }

            @Override // com.oplus.camera.p172ui.preview.p177a.ImageCallback
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12657a(ArrayList<StickerMenu.IntrinsicsJvm.kt_4> arrayList, final int OplusGLSurfaceView_13, StickerItem stickerItem, final boolean z) {
                CameraLog.m12954a("StickerMode", "updateAdapter, stickerItem: " + stickerItem + ", updateCategoryIndex: " + z + ", stickerCategoryIndex: " + OplusGLSurfaceView_13);
                if (StickerMode.this.f13012x != null) {
                    StickerMode.this.f13012x.clear();
                } else {
                    StickerMode.this.f13012x = new ArrayList();
                }
                StickerMode.this.f13012x.addAll(arrayList);
                if (StickerMode.this.f12997i == null || StickerMode.this.mActivity == null || StickerMode.this.f13012x.size() <= 0) {
                    return;
                }
                StickerMode.this.f12997i.m17116a(stickerItem, true);
                StickerMode.this.f12997i.m17115a(stickerItem);
                StickerMode.this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.t.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (StickerMode.this.f12997i != null) {
                            StickerMode.this.f12997i.m17122a(StickerMode.this.f13012x, OplusGLSurfaceView_13, z);
                        }
                    }
                });
            }
        };
        this.f12994I = new StickerMenuListener() { // from class: com.oplus.camera.capmode.t.12
            @Override // com.oplus.camera.sticker.p168ui.StickerMenuListener
            /* renamed from: IntrinsicsJvm.kt_5 */
            public void mo12670d() {
            }

            @Override // com.oplus.camera.sticker.p168ui.StickerMenuListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12663a(boolean z) {
                CameraLog.m12954a("StickerMode", "beforeEnterAnimator");
                StickerMode.this.mCameraUIInterface.mo18200d(false, false);
                StickerMode.this.mCameraUIInterface.mo18107a(true, false);
                StickerMode.this.mCameraUIInterface.mo18077a(4, false);
                StickerMode.this.mCameraUIInterface.mo18232j(true, false);
                StickerMode.this.mCameraUIInterface.mo18243m(z);
                if (StickerMode.this.mCameraInterface != null) {
                    StickerMode.this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
                }
                StickerMode.this.m12618a(false);
            }

            @Override // com.oplus.camera.sticker.p168ui.StickerMenuListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12661a() {
                CameraLog.m12954a("StickerMode", "afterEnterAnimator");
                StickerMode.this.mCameraUIInterface.mo18213f(true, true);
                CameraStatisticsUtil.onCommon(StickerMode.this.mActivity, CameraStatisticsUtil.EVENT_MENU_CLICK, CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_MODE_CLICK_STICKER_MENU, "1"));
                StickerMode.this.m12635b(true);
            }

            @Override // com.oplus.camera.sticker.p168ui.StickerMenuListener
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo12666b() {
                StickerMode.this.mCameraUIInterface.mo18218g(true, true);
                if (StickerMode.this.mCameraInterface != null && !StickerMode.this.mCameraUIInterface.mo18023A()) {
                    StickerMode.this.mCameraInterface.mo10492a(true, false);
                }
                StickerMode.this.mCameraUIInterface.mo18200d(false, false);
            }

            @Override // com.oplus.camera.sticker.p168ui.StickerMenuListener
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo12669c() {
                if (!StickerMode.this.getIsCapturingState()) {
                    StickerMode.this.mCameraUIInterface.mo18200d(true, true);
                }
                if (StickerMode.this.mCameraInterface != null && !StickerMode.this.mCameraUIInterface.mo18023A()) {
                    StickerMode.this.mCameraInterface.mo10563d(true);
                }
                StickerMode.this.m12635b(false);
                StickerMode.this.mCameraUIInterface.mo18112aB();
            }

            @Override // com.oplus.camera.sticker.p168ui.StickerMenuListener
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo12668b(boolean z) {
                if (z) {
                    StickerMode.this.mCameraUIInterface.mo18184c(0);
                } else {
                    StickerMode.this.mCameraUIInterface.mo18218g(true, true);
                    if (StickerMode.this.mCameraInterface != null && !StickerMode.this.mCameraUIInterface.mo18023A()) {
                        StickerMode.this.mCameraInterface.mo10492a(true, false);
                        StickerMode.this.mCameraInterface.mo10563d(true);
                    }
                }
                StickerMode.this.mCameraUIInterface.mo18200d(true, true);
                StickerMode.this.mCameraUIInterface.mo18112aB();
            }

            @Override // com.oplus.camera.sticker.p168ui.StickerMenuListener
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo12665a(StickerItem stickerItem, int OplusGLSurfaceView_13) {
                return StickerMode.this.m12624a(stickerItem, OplusGLSurfaceView_13);
            }

            @Override // com.oplus.camera.sticker.p168ui.StickerMenuListener
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo12664a(View view, StickerItem stickerItem, int OplusGLSurfaceView_13) {
                return StickerMode.this.m12620a(view, stickerItem, OplusGLSurfaceView_13);
            }

            @Override // com.oplus.camera.sticker.p168ui.StickerMenuListener
            /* renamed from: COUIBaseListPopupWindow_8 */
            public void mo12671e() {
                StickerMode.this.mCameraUIInterface.mo18061V();
            }

            @Override // com.oplus.camera.sticker.p168ui.StickerMenuListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12662a(String str) {
                StickerMode.this.m12616a(CameraStatisticsUtil.STICKER_MENU_CATERGORY_FLING, str);
            }

            @Override // com.oplus.camera.sticker.p168ui.StickerMenuListener
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo12667b(String str) {
                StickerMode.this.m12616a(CameraStatisticsUtil.STICKER_MENU_CATERGORY_CLICK, str);
                StickerMode.this.m12615a(str);
            }

            @Override // com.oplus.camera.sticker.p168ui.StickerMenuListener
            /* renamed from: COUIBaseListPopupWindow_12 */
            public StickerItem mo12672f() {
                if (StickerMode.this.mPreviewEffectProcess != null) {
                    return StickerMode.this.mPreviewEffectProcess.mo22842j();
                }
                return null;
            }

            @Override // com.oplus.camera.sticker.p168ui.StickerMenuListener
            /* renamed from: COUIBaseListPopupWindow_11 */
            public void mo12673g() {
                StickerMode.this.m12654a();
            }

            @Override // com.oplus.camera.sticker.p168ui.StickerMenuListener
            /* renamed from: COUIBaseListPopupWindow_10 */
            public void mo12674h() {
                if (StickerMode.this.f12997i != null) {
                    StickerItem stickerItemMo22842j = StickerMode.this.mPreviewEffectProcess != null ? StickerMode.this.mPreviewEffectProcess.mo22842j() : null;
                    if (stickerItemMo22842j != null) {
                        ImageStickerTools c3420qM22687b = ImageStickerTools.m22687b(StickerMode.this.mActivity);
                        String stickerUUID = stickerItemMo22842j.getStickerUUID();
                        boolean zM22717a = c3420qM22687b.m22717a(stickerUUID);
                        if (StickerMode.this.mPreviewEffectProcess != null) {
                            if (zM22717a) {
                                StickerMode.this.mPreviewEffectProcess.mo22822d();
                            } else {
                                StickerMode.this.mPreviewEffectProcess.mo22817c();
                            }
                        }
                        c3420qM22687b.m22715a(stickerUUID, !zM22717a);
                        StickerMode.this.f12997i.m17128b(stickerUUID);
                        return;
                    }
                    CameraLog.m12967f("StickerMode", "onMusicButtonClick, non selected stickerItem!");
                }
            }

            @Override // com.oplus.camera.sticker.p168ui.StickerMenuListener
            /* renamed from: OplusGLSurfaceView_13 */
            public boolean mo12675i() {
                if (StickerMode.this.mCameraInterface == null) {
                    return false;
                }
                if (!StickerMode.this.mCameraInterface.mo10447C() && !StickerMode.this.mCameraInterface.mo10450F() && !StickerMode.this.mCameraInterface.mo10449E() && !StickerMode.this.mCameraUIInterface.mo18025B() && !StickerMode.this.mbInCapturing && StickerMode.this.isVideoRecordStopped()) {
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("canItemClick, !mCameraInterface.isDoubleFinger: ");
                sb.append(!StickerMode.this.mCameraInterface.mo10447C());
                sb.append(", !mCameraInterface.getCaptureModeChangeState: ");
                sb.append(!StickerMode.this.mCameraInterface.mo10450F());
                sb.append(", !mCameraUIInterface.isAnimationRunning: ");
                sb.append(!StickerMode.this.mCameraUIInterface.mo18025B());
                sb.append(", isVideoRecordStopped: ");
                sb.append(StickerMode.this.isVideoRecordStopped());
                sb.append(", !mbInCapturing: ");
                sb.append(!StickerMode.this.mbInCapturing);
                sb.append(", !mCameraInterface.getSwitchingCameraState: ");
                sb.append(!StickerMode.this.mCameraInterface.mo10449E());
                CameraLog.m12967f("StickerMode", sb.toString());
                return false;
            }
        };
        ImageStickerTools.m22687b(this.mActivity).m22714a(this.f12999k);
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void showRecordingTimeUI() {
        this.mCameraUIInterface.mo18096a(getRealVideoTimeRatio(), this.mActivity.getResources().getDimensionPixelSize(R.dimen.record_quick_time_margin_top), needShowVideoTime(), true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getNeedCheckTimeStamp() {
        return isFlashState();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void hideViewWhileResume() {
        m12619a(false, true);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        CameraLog.m12954a("StickerMode", "onResume");
        super.onResume(z);
        this.f12987B = System.currentTimeMillis();
        this.mPreviewEffectProcess.mo22833g();
        this.f12997i.m17124a(z, isShowAnimojiMenu());
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER)) {
            m12643d();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getBubbleOffsetY(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 4) {
            return 0;
        }
        return this.mActivity.getResources().getDimensionPixelSize(R.dimen.bubble_type_short_video_offset_y);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onSessionConfigured() {
        super.onSessionConfigured();
        if (this.mCameraInterface.mo10463S()) {
            this.mCameraUIInterface.mo18040J();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void closeImageReader() {
        CameraLog.m12959b("StickerMode", "closeImageReader");
        ImageReader imageReader = this.f13005q;
        if (imageReader != null) {
            imageReader.close();
            this.f13005q = null;
        }
        ImageReader imageReader2 = this.f13006r;
        if (imageReader2 != null) {
            imageReader2.close();
            this.f13006r = null;
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        CameraLog.m12954a("StickerMode", "onPause");
        StickerRecycleBinDialog dialogC3019l = this.f12998j;
        if (dialogC3019l != null && dialogC3019l.isShowing()) {
            this.f12998j.dismiss();
        }
        this.f12997i.m17126b();
        this.mCameraUIInterface.mo18026C();
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO)) {
            this.mCameraUIInterface.mo18210f(4, true);
        }
        m12652j();
        super.onPause();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO)) {
            this.mCameraUIInterface.mo18210f(4, true);
        }
        ImageDownloader c3010c = this.f13013y;
        if (c3010c != null) {
            c3010c.m17043a();
            ImageDownloader.m17037b();
        }
        StickerMenu c3015h = this.f12997i;
        if (c3015h != null) {
            c3015h.m17131c();
            this.f12997i = null;
        }
        StickerRecycleBinDialog dialogC3019l = this.f12998j;
        if (dialogC3019l != null) {
            dialogC3019l.m17185c();
            this.f12998j = null;
        }
        ImageStickerTools.m22687b(this.mActivity).m22723e();
        super.onDestroy();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) {
        this.mOrientation = OplusGLSurfaceView_13;
        this.f12997i.m17127b(this.mOrientation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m12625a(final StickerItem stickerItem, boolean z) {
        if (stickerItem == null || this.mCameraInterface.mo10463S() || this.mOneCamera == null) {
            CameraLog.m12967f("StickerMode", "onStickerItemChange, item: " + stickerItem + ", isBlurAnimRunning: " + this.mCameraInterface.mo10463S() + ", mOneCamera: " + this.mOneCamera);
            return false;
        }
        CameraLog.m12959b("StickerMode", "onStickerItemChange, item: " + stickerItem);
        if (getSupportFunction(CameraUIInterface.KEY_STICKER_PROCESS)) {
            if (this.mPreviewEffectProcess != null && (!this.mPreviewEffectProcess.mo22816b(stickerItem) || z)) {
                StickerItem stickerItemMo22842j = this.mPreviewEffectProcess.mo22842j();
                if (stickerItemMo22842j != null) {
                    m12633b(CameraStatisticsUtil.STICKER_MENU_ITEM_USETIME, stickerItemMo22842j.getStickerUUID());
                }
                this.mPreviewEffectProcess.mo22787a(stickerItem);
                if (ImageStickerTools.m22691b(stickerItem)) {
                    this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.t.13
                        @Override // java.lang.Runnable
                        public void run() {
                            if (StickerMode.this.mCameraUIInterface == null) {
                                return;
                            }
                            StickerMode.this.mCameraUIInterface.mo18248n(false, false);
                            StickerMode.this.m12629b();
                            StickerMode.this.mCameraUIInterface.mo18232j(true, false);
                        }
                    });
                    if (this.mbCapModeInit) {
                        applyBeautyParam();
                    }
                } else {
                    this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.t.14
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!StickerMode.this.mbCapModeInit || StickerMode.this.isStickerMenuOpen() || StickerMode.this.mbPaused) {
                                return;
                            }
                            StickerMode.this.mCameraUIInterface.mo18240l(true, false);
                            StickerMode.this.mCameraUIInterface.mo18279v(true);
                        }
                    });
                    if (this.mbCapModeInit) {
                        applyBeautyParam();
                    }
                }
                SharedPreferences.Editor editorEdit = this.mPreferences.edit();
                editorEdit.putString(CameraUIInterface.KEY_CURRENT_STICKER_UUID, stickerItem.getStickerUUID());
                editorEdit.apply();
                if (this.f12997i != null) {
                    if (stickerItemMo22842j != null && stickerItemMo22842j.getCategoryId() != null && !stickerItemMo22842j.getCategoryId().equals(stickerItem.getCategoryId())) {
                        this.f12997i.m17119a(stickerItemMo22842j.getCategoryId());
                    }
                    if (stickerItem.hasMusic()) {
                        this.f12997i.m17135d(stickerItem.getStickerUUID());
                        if (this.mPreviewEffectProcess != null) {
                            this.mPreviewEffectProcess.mo22822d();
                        }
                    } else {
                        this.f12997i.m17141h();
                        this.mPreviewEffectProcess.mo22817c();
                    }
                    if (stickerItem.getDownloadTime() == 0 && !StickerCategoryItem.MY_CATEGORY_ID.equals(stickerItem.getCategoryId()) && !stickerItem.isRecycleBin()) {
                        StickerMediator.m16958a(this.mActivity).m16961a(stickerItem);
                    }
                }
                m12616a(CameraStatisticsUtil.STICKER_MENU_ITEM_SELECTED, stickerItem.getStickerUUID());
                this.mCameraUIInterface.mo18066a().m14132a(new Runnable() { // from class: com.oplus.camera.capmode.t.15
                    @Override // java.lang.Runnable
                    public void run() {
                        CameraLog.m12954a("StickerMode", "onStickerItemChange, success, categoryId: " + stickerItem.getCategoryId());
                        StickerMode.this.mPreviewEffectProcess.mo22829e();
                    }
                });
                this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.t.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (StickerMode.this.f12997i != null) {
                            StickerMode.this.f12997i.m17133c(true);
                        }
                    }
                });
                m12613a(stickerItem, StickerCategoryItem.MY_CATEGORY_ID.equals(stickerItem.getCategoryId()), StickerMsgData.STICKER_OPER_SELECT);
            } else {
                this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.t.17
                    @Override // java.lang.Runnable
                    public void run() {
                        if (StickerMode.this.f12997i != null) {
                            StickerMode.this.f12997i.m17133c(false);
                        }
                    }
                });
                m12632b(stickerItem);
                m12613a(stickerItem, StickerCategoryItem.MY_CATEGORY_ID.equals(stickerItem.getCategoryId()), "cancel");
            }
            this.mActivity.runOnUiThread(new StickerMode_2(stickerItem));
            return true;
        }
        CameraLog.m12954a("StickerMode", "onStickerItemChange, failed index categoryId: " + stickerItem.getCategoryId());
        return true;
    }

    /* compiled from: StickerMode.java */
    /* renamed from: com.oplus.camera.capmode.t$18, reason: invalid class name */
    class StickerMode_2 implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ StickerItem f13028a;

        StickerMode_2(StickerItem stickerItem) {
            this.f13028a = stickerItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (StickerMode.this.mActivity == null) {
                CameraLog.m12967f("StickerMode", "onStickerItemChange, mActivity is null, so return");
                return;
            }
            if (!StickerMode.this.mbCapModeInit) {
                CameraLog.m12966e("StickerMode", "onStickerItemChange, already exited from sticker mode, so return");
                return;
            }
            if (!PopUpWindowManager.m20711c()) {
                StickerMode.this.m12611a(this.f13028a);
                return;
            }
            PopUpWindowManager.m20712d();
            BasicOptionItemList basicOptionItemListM20707b = PopUpWindowManager.m20707b();
            if (basicOptionItemListM20707b != null) {
                final StickerItem stickerItem = this.f13028a;
                basicOptionItemListM20707b.setOnPopUpFadeOutAnimationStartListener(new BasicOptionItemList.OnPopUpFadeOutAnimationStartListener() { // from class: com.oplus.camera.capmode.-$$Lambda$t$18$9g2NJHlzNOD6SDoUUxskFbcHuSc
                    @Override // com.oplus.camera.ui.menu.BasicOptionItemList.OnPopUpFadeOutAnimationStartListener
                    public final void onPopUpFadeOutAnimationEnd() {
                        this.COUIBaseListPopupWindow_12$0.m12676a(stickerItem);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public /* synthetic */ void m12676a(StickerItem stickerItem) {
            StickerMode.this.m12611a(stickerItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12629b() {
        if (!this.mbCapModeInit || isStickerMenuOpen()) {
            return;
        }
        if (this.mCameraUIInterface.mo18043K()) {
            this.mCameraUIInterface.mo18230j(0);
            this.mCameraUIInterface.mo18232j(true, false);
            this.mCameraUIInterface.mo18077a(0, true);
            m12636b(true, false);
            return;
        }
        if (supportBeautyButton()) {
            this.mCameraUIInterface.mo18230j(0);
        } else {
            this.mCameraUIInterface.mo18232j(true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12611a(StickerItem stickerItem) {
        this.mCameraUIInterface.mo18227i(getSupportFunction(CameraUIInterface.KEY_ASSISTANT_LINE));
        this.mCameraUIInterface.mo18258q();
        this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_FILTER_MENU);
        if (ImageStickerTools.m22691b(stickerItem) && this.mCameraUIInterface.mo18023A()) {
            this.mCameraUIInterface.mo18244m(true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12637c() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.t.19
            @Override // java.lang.Runnable
            public void run() {
                if (PopUpWindowManager.m20711c()) {
                    PopUpWindowManager.m20712d();
                }
                StickerMode.this.mCameraUIInterface.mo18227i(StickerMode.this.getSupportFunction(CameraUIInterface.KEY_ASSISTANT_LINE));
                StickerMode.this.mCameraUIInterface.mo18258q();
                StickerMode.this.mCameraUIInterface.mo18216g(CameraUIInterface.KEY_FILTER_MENU);
                if (ImageStickerTools.m22691b(ImageStickerTools.m22687b(StickerMode.this.mActivity).m22706a(StickerMode.this.mPreferences)) && StickerMode.this.mCameraUIInterface.mo18023A()) {
                    StickerMode.this.mCameraUIInterface.mo18244m(true, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12632b(StickerItem stickerItem) {
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(CameraUIInterface.KEY_CURRENT_STICKER_UUID, "unselected_uuid");
        editorEdit.apply();
        if (this.mPreviewEffectProcess != null) {
            StickerItem stickerItemMo22842j = this.mPreviewEffectProcess.mo22842j();
            if (stickerItemMo22842j != null) {
                m12633b(CameraStatisticsUtil.STICKER_MENU_ITEM_USETIME, stickerItemMo22842j.getStickerUUID());
            }
            this.mPreviewEffectProcess.mo22787a((StickerItem) null);
        }
        if (ImageStickerTools.m22691b(stickerItem)) {
            applyBeautyParam();
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        if (stickerItem != null) {
            if (stickerItem.hasMusic()) {
                this.f12997i.m17141h();
                if (this.mPreviewEffectProcess != null) {
                    this.mPreviewEffectProcess.mo22817c();
                }
            }
            m12616a(CameraStatisticsUtil.STICKER_MENU_ITEM_UNSELECTED, stickerItem.getStickerUUID());
        }
        this.mCameraUIInterface.mo18066a().m14132a(new Runnable() { // from class: com.oplus.camera.capmode.t.2
            @Override // java.lang.Runnable
            public void run() {
                CameraLog.m12954a("StickerMode", "unselectedStickerItem");
                if (StickerMode.this.mPreviewEffectProcess != null) {
                    StickerMode.this.mPreviewEffectProcess.mo22829e();
                }
            }
        });
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean updateViewByEnterCameraType() {
        CameraLog.m12954a("StickerMode", "updateViewByEnterCameraType, mStickerMenu: " + this.f12997i);
        if (this.f12997i == null) {
            return false;
        }
        if (!FilmAnimatorUtil.m13481b()) {
            this.f12997i.m17136d(false);
            return true;
        }
        FilmAnimatorUtil.m13464a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.capmode.t.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FilmAnimatorUtil.m13464a((ValueAnimator.AnimatorUpdateListener) null);
                StickerMode.this.f12997i.m17136d(false);
            }
        });
        return true;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        CameraLog.m12954a("StickerMode", "onAfterStartPreview");
        if (!this.mCameraUIInterface.mo18023A()) {
            this.f12997i.m17123a(true);
            this.f12997i.m17129b(true);
        }
        super.onAfterStartPreview(z);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void beforeSwitchToMode(boolean z) {
        super.beforeSwitchToMode(z);
        enableVideoRecordingSound(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int OplusGLSurfaceView_13) {
        super.cameraIdChanged(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onCameraIdChangedAnimationEnd() {
        this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_VIDEO_SIZE);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m12643d() {
        boolean z = RegionCommonFeatureAdapter.m14534c() || this.mPreferences.getBoolean("pref_allow_network_access", false);
        CameraLog.m12954a("StickerMode", "initStickerMediator, allowNetworkAccess: " + z);
        ImageStickerTools.m22687b(this.mActivity).m22711a((Context) this.mActivity);
        ImageStickerTools.m22687b(this.mActivity).m22709a(2, true);
        ImageStickerTools.m22687b(this.mActivity).m22714a(this.f12999k);
        if (z) {
            ImageStickerTools.m22687b(this.mActivity).m22724f();
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        CameraLog.m12954a("StickerMode", "onInitCameraMode");
        this.f12987B = System.currentTimeMillis();
        ImageStickerTools.m22687b(this.mActivity).m22711a((Context) this.mActivity);
        if (this.mPreferences.getBoolean("pref_allow_network_access", false)) {
            ImageStickerTools.m22687b(this.mActivity).m22724f();
        }
        this.mPreviewEffectProcess.mo22833g();
        if (this.f12997i == null) {
            this.f13013y = new ImageDownloader(this.mActivity, R.drawable.sticker_undownload);
            this.f12997i = new StickerMenu(this.mActivity, this.mOrientation, ImageStickerTools.m22687b(this.mActivity).m22706a(this.mPreferences) != null);
            this.f12997i.m17118a(this.f12994I);
            this.f12997i.m17117a(this.f13013y);
        }
        this.f12997i.m17112a();
        this.f12997i.m17137e();
        this.f12997i.m17127b(this.mOrientation);
        this.mCameraUIInterface.mo18187c(this.mActivity.getString(R.string.camera_description_common_shutter_button));
        this.mCameraUIInterface.mo18173b(CameraUIInterface.KEY_PHOTO_RATIO, DcsMsgData.FULL);
        this.mHandler.post(new Runnable() { // from class: com.oplus.camera.capmode.t.4
            @Override // java.lang.Runnable
            public void run() {
                StickerMode.this.f12997i.m17132c(StickerMode.this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, "standard"));
            }
        });
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        CameraLog.m12954a("StickerMode", "onDeinitCameraMode");
        super.onDeInitCameraMode(str);
        this.mCameraUIInterface.mo18030E();
        this.mCameraUIInterface.mo18075a(CameraScreenNail.f14185a.intValue(), 0L, 0L);
        if (this.f12997i.m17140g()) {
            this.f12997i.m17130b(true, false, true);
        }
        this.f12997i.m17139f();
        this.mCameraUIInterface.mo18026C();
        this.mCameraUIInterface.mo18103a(CameraUIInterface.KEY_PHOTO_RATIO, DcsMsgData.FULL);
        updateFaceBeautyLevel(0, false);
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22834g(0);
        }
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO)) {
            this.mCameraUIInterface.mo18210f(4, false);
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        super.onBeforePreview();
        CameraLog.m12952a("StickerMode.onBeforePreview");
        StickerItem stickerItemM22706a = ImageStickerTools.m22687b(this.mActivity).m22706a(this.mPreferences);
        if (stickerItemM22706a != null) {
            m12633b(CameraStatisticsUtil.STICKER_MENU_ITEM_USETIME, stickerItemM22706a.getStickerUUID());
        }
        if (this.mPreviewEffectProcess != null) {
            this.mPreviewEffectProcess.mo22787a(stickerItemM22706a);
        } else {
            CameraLog.m12967f("StickerMode", "updateStickerIndex, mPreferences: " + this.mPreferences);
        }
        this.mHandler.post(new Runnable() { // from class: com.oplus.camera.capmode.t.5
            @Override // java.lang.Runnable
            public void run() {
                StickerMode.this.f12997i.m17132c(StickerMode.this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, "standard"));
            }
        });
        applyBeautyParam();
        CameraLog.m12958b("StickerMode.onBeforePreview");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAnimojiOpen() {
        StickerItem stickerItemMo22842j = this.mPreviewEffectProcess != null ? this.mPreviewEffectProcess.mo22842j() : null;
        if (stickerItemMo22842j == null && this.mActivity != null) {
            stickerItemMo22842j = ImageStickerTools.m22687b(this.mActivity).m22706a(this.mPreferences);
        }
        return getSupportFunction(CameraUIInterface.KEY_OMOJI_PROCESS) && ImageStickerTools.m22691b(stickerItemMo22842j);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isMultiStickerOpen() {
        return ImageStickerTools.m22692c(this.mPreviewEffectProcess != null ? this.mPreviewEffectProcess.mo22842j() : null);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAnyModeAnimationRunning() {
        StickerMenu c3015h = this.f12997i;
        if (c3015h != null) {
            return c3015h.m17142i();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected String[] getCustomBeautyKeys() {
        return CameraUIInterface.KEY_STICKER_CUSTOM_FACEBEAUTY;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int[] getDefaultCustomBeautyValues() {
        return f13117b;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getCurrFilterIndex() {
        int OplusGLSurfaceView_13 = this.mPreferences.getInt(getFilterEffectMenuPreferenceKey(), FilterHelper.f21279a);
        if (isShowAnimojiMenu()) {
            OplusGLSurfaceView_13 = FilterHelper.f21279a;
        }
        return Util.m24205a(OplusGLSurfaceView_13, 0, getFilterTypeList(this.mCameraId).size() - 1);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected List<Integer> getFilterNameIdList(int OplusGLSurfaceView_13) {
        return FilterHelper.f21323m.m22566b(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected List<String> getFilterTypeList(int OplusGLSurfaceView_13) {
        return FilterHelper.f21323m.m22561a(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected boolean getNeedReduceBitRate() {
        return CameraParameter.VideoEncoder.H265.equals(this.mPreferences.getString(CameraUIInterface.KEY_VIDEO_CODEC, this.mActivity.getString(R.string.camera_video_codec_default_value)));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void startShortVideoRecording() {
        StickerMenu c3015h;
        CameraLog.m12954a("StickerMode", "startShortVideoRecording");
        if (this.mCameraInterface.mo10447C() || !isVideoRecordStopped() || (c3015h = this.f12997i) == null || c3015h.m17142i()) {
            StringBuilder sb = new StringBuilder();
            sb.append("startShortVideoRecording, isDoubleFinger: ");
            sb.append(this.mCameraInterface.mo10447C());
            sb.append(", isVideoRecordStopped: ");
            sb.append(isVideoRecordStopped());
            sb.append(", isAnimation: ");
            StickerMenu c3015h2 = this.f12997i;
            sb.append(c3015h2 == null ? "null" : Boolean.valueOf(c3015h2.m17142i()));
            sb.append(", MenuOpen: ");
            StickerMenu c3015h3 = this.f12997i;
            sb.append(c3015h3 != null ? Boolean.valueOf(c3015h3.m17140g()) : "null");
            CameraLog.m12954a("StickerMode", sb.toString());
            return;
        }
        this.mHandler.removeMessages(10);
        try {
            this.mProfile = m12644e();
        } catch (Exception COUIBaseListPopupWindow_8) {
            this.mProfile = null;
            CameraLog.m12956a("StickerMode", "startShortVideoRecording, CamcorderProfile.get fail! ", COUIBaseListPopupWindow_8);
        }
        if (this.mProfile != null) {
            Size previewSize = getPreviewSize(this.mOneCamera.mo13086e());
            CameraLog.m12954a("StickerMode", "startShortVideoRecording, preview width: " + previewSize.getWidth() + ", preview heigth: " + previewSize.getHeight());
            if (!Util.m24169C() && (previewSize.getWidth() > 1920 || previewSize.getHeight() > 1088)) {
                this.mProfile.videoFrameWidth = VideoMode.VIDEO_1080P_WIDTH;
                this.mProfile.videoFrameHeight = 912;
            } else {
                this.mProfile.videoFrameWidth = previewSize.getWidth();
                this.mProfile.videoFrameHeight = previewSize.getHeight();
            }
        }
        this.mHandler.removeCallbacks(this.f12996h);
        this.mHandler.post(this.f12996h);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private CamcorderProfile m12644e() {
        CamcorderProfile camcorderProfile;
        try {
            if (CamcorderProfile.hasProfile(this.mCameraId, 5)) {
                camcorderProfile = CamcorderProfile.get(this.mCameraId, 5);
            } else {
                camcorderProfile = CamcorderProfile.get(this.mCameraId, 4);
            }
            return camcorderProfile;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            CameraLog.m12967f("StickerMode", "getCamcorderProfile, get CamcorderProfile fail");
            return null;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Range<Integer> getVideoFpsRange() {
        Range<Integer>[] rangeArrM13291z = getCameraInfo(this.mCameraId).m13291z();
        if (rangeArrM13291z == null || rangeArrM13291z.length == 0) {
            return super.getVideoFpsRange();
        }
        int OplusGLSurfaceView_13 = -1;
        int iIntValue = 300;
        for (int i2 = 0; i2 < rangeArrM13291z.length; i2++) {
            if (iIntValue > ((Integer) rangeArrM13291z[i2].getLower()).intValue() && ((Integer) rangeArrM13291z[i2].getUpper()).intValue() == 30) {
                iIntValue = ((Integer) rangeArrM13291z[i2].getLower()).intValue();
                OplusGLSurfaceView_13 = i2;
            }
        }
        if (OplusGLSurfaceView_13 >= 0) {
            return rangeArrM13291z[OplusGLSurfaceView_13];
        }
        return super.getVideoFpsRange();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void stopShortVideoRecording() {
        CameraLog.m12954a("StickerMode", "stopShortVideoRecording, isVideoRecordStarted: " + isVideoRecordStarted());
        if (isVideoRecordStopped()) {
            this.mHandler.removeCallbacks(this.f12996h);
            return;
        }
        if (isVideoRecordStarting()) {
            this.mWaitRecordStarted.block();
        }
        if (isVideoRecordStarted()) {
            m17833aj();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSupportShowFilterMenu() {
        return super.isSupportShowFilterMenu() && !isAnimojiOpen();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ce  */
    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 1026
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.StickerMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        if (dcsMsgData == null) {
            return null;
        }
        if (dcsMsgData instanceof CaptureMsgData) {
            return m12599a(dcsMsgData);
        }
        if (dcsMsgData instanceof VideoRecordMsgData) {
            return m12627b(dcsMsgData);
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private DcsMsgData m12599a(DcsMsgData dcsMsgData) {
        StickerItem stickerItemMo22842j;
        if (dcsMsgData == null || !(dcsMsgData instanceof CaptureMsgData)) {
            return null;
        }
        CaptureMsgData captureMsgData = (CaptureMsgData) dcsMsgData;
        captureMsgData.mCaptureMode = ApsConstant.CAPTURE_MODE_STICKER;
        captureMsgData.mCaptureType = 2;
        captureMsgData.mTouchXYValue = this.mCameraInterface.mo10530af();
        captureMsgData.mMemoryValue = String.valueOf(Util.m24468k(this.mActivity) / 1024);
        if (getSupportFunction(CameraUIInterface.KEY_FILTER_PROCESS)) {
            captureMsgData.mFilterType = FilterHelper.m22620b(getCurrFilterIndex(), this.mCameraId);
        }
        if (getSupportFunction(CameraUIInterface.KEY_STICKER_PROCESS) && (stickerItemMo22842j = this.mPreviewEffectProcess.mo22842j()) != null) {
            captureMsgData.mStickerName = stickerItemMo22842j.getStickerName();
            captureMsgData.mStickerType = String.valueOf(stickerItemMo22842j.getMaterialType());
            captureMsgData.mStickerUuid = stickerItemMo22842j.getStickerUUID();
            captureMsgData.mProtocolVersion = String.valueOf(stickerItemMo22842j.getProtocolVersion());
        }
        int[] customBeautyValues = getCustomBeautyValues();
        if (getSupportFunction(CameraFunction.FACE_BEAUTY_CUSTOM)) {
            int length = getCustomBeautyKeys().length;
            captureMsgData.mSmooth = isFaceBeautyOrMakeupOpen() ? 102 : 0;
            if (customBeautyValues != null && length == customBeautyValues.length) {
                captureMsgData.parseFaceBeauty(customBeautyValues);
            }
        } else if (getSupportFunction(CameraFunction.FACE_BEAUTY_COMMON)) {
            captureMsgData.mSmooth = isFaceBeautyOrMakeupOpen() ? 102 : 0;
            if (customBeautyValues != null) {
                captureMsgData.mSmoothDermabrasion = getCustomBeautyValues()[0];
            }
        }
        if (DcsMsgData.FULL.equals(captureMsgData.mPicSizeType)) {
            captureMsgData.mPicSizeType = "16_9";
        }
        return (CaptureMsgData) super.onGetBeforeCaptureMsgCommonData(captureMsgData);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private DcsMsgData m12627b(DcsMsgData dcsMsgData) {
        if (dcsMsgData == null || !(dcsMsgData instanceof VideoRecordMsgData)) {
            return null;
        }
        VideoRecordMsgData videoRecordMsgData = (VideoRecordMsgData) dcsMsgData;
        videoRecordMsgData.mLux = String.valueOf(this.mDcsLux);
        videoRecordMsgData.mCct = String.valueOf(this.mDcsCCT);
        videoRecordMsgData.mIso = String.valueOf(this.mDcsIso);
        videoRecordMsgData.mExp = String.valueOf(this.mDcsExp);
        StickerItem stickerItemMo22842j = this.mPreviewEffectProcess.mo22842j();
        if (stickerItemMo22842j == null) {
            return null;
        }
        videoRecordMsgData.mStickerName = stickerItemMo22842j.getStickerName();
        videoRecordMsgData.mStickerType = String.valueOf(stickerItemMo22842j.getMaterialType());
        videoRecordMsgData.mStickerUuid = stickerItemMo22842j.getStickerUUID();
        videoRecordMsgData.mProtocolVersion = String.valueOf(stickerItemMo22842j.getProtocolVersion());
        return (VideoRecordMsgData) super.onGetBeforeCaptureMsgCommonData(videoRecordMsgData);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetAfterCaptureMsgCommonData(DcsMsgData dcsMsgData, Storage.CameraPicture cameraPicture) {
        CaptureMsgData captureMsgData;
        if (dcsMsgData == null || !(dcsMsgData instanceof CaptureMsgData)) {
            captureMsgData = null;
        } else {
            captureMsgData = (CaptureMsgData) dcsMsgData;
            Size sizeM11107a = Storage.m11107a(Util.m24231a(cameraPicture.f12132e));
            if (sizeM11107a != null) {
                captureMsgData.mWidth = String.valueOf(sizeM11107a.getWidth());
                captureMsgData.mHeight = String.valueOf(sizeM11107a.getHeight());
            }
            if (TextUtils.isEmpty(captureMsgData.mFlashMode)) {
                captureMsgData.mFlashMode = "off";
            }
            captureMsgData.mFlashTrigger = CaptureMsgDataReportUtil.m11167a(getFlashMode());
        }
        return (CaptureMsgData) super.onGetAfterCaptureMsgCommonData(captureMsgData, cameraPicture);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportMenu(String str) {
        if (CameraUIInterface.KEY_PHOTO_RATIO.equals(str) || CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_SETTING.equals(str)) {
            return true;
        }
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_VIDEO_SIZE.equals(str)) {
            return false;
        }
        if (CameraUIInterface.KEY_CAMERA_HDR_MODE.equals(str) || CameraUIInterface.KEY_VIVID_EFFECT.equals(str)) {
            return getSupportFunction(str);
        }
        if ((CameraUIInterface.KEY_FILTER_MENU.equals(str) && (isAnimojiOpen() || isShowAnimojiMenu())) || CameraUIInterface.KEY_VIDEO_FILTER_MENU.equals(str)) {
            return false;
        }
        return super.getSupportMenu(str);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getCanAddMenuOption(String str) {
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            return true;
        }
        return super.getCanAddMenuOption(str);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        CameraLog.m12954a("StickerMode", "onBeforeSnapping");
        if (isAnimojiOpen()) {
            TexturePreview abstractC3428yMo22843j = this.mPreviewEffectProcess.mo22843j(16);
            if (abstractC3428yMo22843j.mo22283a(16) && !abstractC3428yMo22843j.mo22282a()) {
                return false;
            }
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.t.6
            @Override // java.lang.Runnable
            public void run() {
                if (!StickerMode.this.mbPaused) {
                    StickerMode.this.f12997i.m17123a(false);
                    StickerMode.this.f12997i.m17129b(false);
                } else {
                    CameraLog.m12954a("StickerMode", "onBeforeSnapping, return after pause");
                }
            }
        });
        return true;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() {
        m12619a(false, true);
        if (this.mCameraUIInterface.mo18043K()) {
            this.mCameraUIInterface.mo18109a(false, false, false, false);
        }
        this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, false);
        this.mCameraInterface.mo10563d(false);
        this.mCameraUIInterface.mo18215g(4);
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO)) {
            this.mCameraUIInterface.mo18210f(4, true);
        }
        if (!containsBubbleKey(CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO)) {
            updateBubbleValue(CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO, false);
        }
        super.beforeStartRecording();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void afterStopRecording() {
        if (this.f12997i.m17140g()) {
            m12636b(true, true);
            this.mCameraUIInterface.mo18215g(0);
        } else {
            this.mCameraUIInterface.mo18215g(0);
            super.afterStopRecording();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void stopVideoRestoreUIWithControlUI() {
        if (this.f12997i.m17140g()) {
            return;
        }
        m12636b(true, false);
        this.mCameraInterface.mo10492a(true, false);
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void startShutterButtonProgress() {
        super.startShutterButtonProgress();
    }

    @Override // com.oplus.camera.capmode.VideoMode
    protected void stopShutterButtonProgress() {
        this.mCameraUIInterface.mo18091a(getShutterButtonInfo());
        super.stopShutterButtonProgress();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        return !isVideoRecordStopped();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        if ("type_video".equals(str)) {
            return false;
        }
        if ("type_preview_frame".equals(str)) {
            return getSupportFunction(CameraUIInterface.KEY_OMOJI_PROCESS) || getSupportFunction(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER);
        }
        if ("type_still_capture_yuv_main".equals(str) || "type_still_capture_yuv_sub".equals(str) || "type_still_capture_yuv_third".equals(str)) {
            return false;
        }
        if ("type_still_capture_jpeg".equals(str)) {
            return !AlgoSwitchConfig.getSupportApsCapture();
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public CameraRequestTag getCaptureRequestTag(CameraApsDecision cameraApsDecision, boolean z) {
        CameraRequestTag captureRequestTag = super.getCaptureRequestTag(cameraApsDecision, z);
        captureRequestTag.f13402ad = System.currentTimeMillis();
        return captureRequestTag;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onFilterItemChange(int OplusGLSurfaceView_13) {
        super.onFilterItemChange(OplusGLSurfaceView_13);
        m12602a(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mPreviewEffectProcess != null) {
            return false;
        }
        this.mCameraUIInterface.mo18253p().getHitRect(new Rect());
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onShutterButtonLongClick() {
        super.onShutterButtonLongClick();
        this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(1, "button_color_inside_none", "button_shape_ring_none", 0));
        this.mWaitRecordStarted.close();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z, boolean z2) {
        super.onShutterCallback(z, z2);
        if (z2) {
            this.mCameraInterface.mo10558c(0);
            this.mCameraInterface.mo10572h();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onThumbnailUpdated(ThumbnailItem thumbnailItem) {
        synchronized (this.f12995g) {
            this.f13014z = thumbnailItem;
            m12647f();
            CameraLog.m12954a("StickerMode", "onThumbnailUpdated, mRequestHash: " + thumbnailItem.mRequestHash + ", mStickerCaptureTime: " + thumbnailItem.mStickerCaptureTime);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m12647f() {
        if (!m12650h() || this.f13014z == null) {
            CameraLog.m12959b("StickerMode", "savePictureIfReady, mLastThumbnail: " + this.f13014z);
            return;
        }
        m12648g();
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.t.7
                @Override // java.lang.Runnable
                public void run() {
                    if (StickerMode.this.mbDestroyed) {
                        return;
                    }
                    StickerMode.this.onAfterPictureTaken(null, false);
                }
            });
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m12648g() {
        CameraLog.m12954a("StickerMode", "savePictureUseThumb");
        Storage.CameraPicture cameraPicture = new Storage.CameraPicture();
        cameraPicture.f12130c = this.f13014z.mUri;
        cameraPicture.f12149v = true;
        cameraPicture.f12134g = this.f13014z.mJpegName;
        cameraPicture.f12128a = this.f13014z.mResolver;
        cameraPicture.f12139l = this.f13014z.mDate;
        cameraPicture.f12107E = this.f13014z.mbLockScreen;
        cameraPicture.f12136i = ApsConstant.CAPTURE_MODE_STICKER;
        cameraPicture.f12146s = this.mCameraId;
        cameraPicture.f12106D = false;
        cameraPicture.f12135h = getHeicCodecFormat() != null ? getHeicCodecFormat() : CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG;
        cameraPicture.f12132e = m12626a(cameraPicture, this.f13014z.mOriginBitmap, !this.f13014z.mbMirror, this.mbFrontCamera, this.mOrientation, this.f13014z.mTimeStamp);
        ImageSaverThread.m14696a().m14707c(cameraPicture);
        m12651i();
        this.f12990E = cameraPicture;
        if (this.mActivity == null || this.mbPaused) {
            return;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.t.8
            @Override // java.lang.Runnable
            public void run() {
                StickerMode.this.pictureTakenCallback(null, 0, 0, Util.m24243a(256), false, false, 0L, 0);
            }
        });
        this.f12992G = true;
        m12653k();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m12650h() {
        return (this.f13000l == null && this.f13001m == null && this.f13002n == null && this.f13003o == null && this.f13004p == null) ? false : true;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m12651i() {
        this.f13014z = null;
        synchronized (this.f12995g) {
            this.f13000l = null;
            this.f13001m = null;
            this.f13002n = null;
            this.f13003o = null;
            this.f13004p = null;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onReceivePreviewCaptureResult(CaptureResult captureResult) {
        super.onReceivePreviewCaptureResult(captureResult);
        if (this.f12989D) {
            synchronized (this.f12995g) {
                this.f13000l = (Float) captureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
                this.f13001m = (Float) captureResult.get(CaptureResult.LENS_APERTURE);
                this.f13002n = (Integer) captureResult.get(CaptureResult.SENSOR_SENSITIVITY);
                this.f13003o = (Integer) captureResult.get(CaptureResult.CONTROL_AWB_MODE);
                this.f13004p = (Long) captureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
                m12647f();
            }
            this.f12989D = false;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onStartCapturePreviewData() {
        this.f12989D = true;
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult, CameraRequestTag c2693c) {
        super.onCaptureCompleted(cameraCaptureResult, c2693c);
        synchronized (this.f12995g) {
            CaptureResult captureResult = cameraCaptureResult.getCaptureResult();
            this.f13000l = (Float) captureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
            this.f13001m = (Float) captureResult.get(CaptureResult.LENS_APERTURE);
            this.f13002n = (Integer) captureResult.get(CaptureResult.SENSOR_SENSITIVITY);
            this.f13003o = (Integer) captureResult.get(CaptureResult.CONTROL_AWB_MODE);
            this.f13004p = (Long) captureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
            CameraLog.m12954a("StickerMode", "onCaptureCompleted, mCurrentFocalLength: " + this.f13000l + ", mCurrentAperture: " + this.f13001m + ", mCurrentISO: " + this.f13002n + ", mCurrentWhiteBalanceMode: " + this.f13003o + ", mCurrentExposureTime: " + this.f13004p);
            long OplusGLSurfaceView_15 = c2693c.f13402ad;
            if (this.f13014z != null && (this.f13014z.mRequestHash == c2693c.hashCode() || OplusGLSurfaceView_15 == this.f13014z.mStickerCaptureTime)) {
                m12648g();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onCaptureCompleted, captureTime: ");
            sb.append(OplusGLSurfaceView_15);
            sb.append(", mStickerCaptureTime: ");
            sb.append(this.f13014z != null ? Long.valueOf(this.f13014z.mStickerCaptureTime) : null);
            sb.append(", mRequestHash: ");
            sb.append(this.f13014z != null ? Long.valueOf(this.f13014z.mRequestHash) : null);
            sb.append(", requestHashCode: ");
            sb.append(c2693c.hashCode());
            CameraLog.m12954a("StickerMode", sb.toString());
        }
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.t.9
                @Override // java.lang.Runnable
                public void run() {
                    if (StickerMode.this.mbDestroyed) {
                        return;
                    }
                    StickerMode.this.onAfterPictureTaken(null, false);
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private byte[] m12626a(Storage.CameraPicture cameraPicture, Bitmap bitmap, boolean z, boolean z2, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws IOException {
        Bitmap bitmapM24222a;
        byte[] bArrCompressBitmap;
        if (!z2) {
            bitmapM24222a = Util.m24222a(bitmap, OplusGLSurfaceView_13, false);
        } else {
            if ((OplusGLSurfaceView_13 == 90 || OplusGLSurfaceView_13 == 270) && z) {
                OplusGLSurfaceView_13 = (OplusGLSurfaceView_13 + 180) % 360;
            }
            bitmapM24222a = Util.m24222a(bitmap, OplusGLSurfaceView_13, z);
        }
        Bitmap bitmap2 = bitmapM24222a;
        byte[] byteArray = null;
        if (getHeicCodecFormat() != null) {
            OplusExifInterface oplusExifInterface = new OplusExifInterface();
            m12614a(oplusExifInterface, cameraPicture.f12139l);
            HeicProcessor c2789b = new HeicProcessor("heic_8bits".equals(getHeicCodecFormat()));
            c2789b.m14506a(bitmap2, 0, 100, oplusExifInterface, cameraPicture.f12128a, cameraPicture.f12130c);
            c2789b.m14505a();
            return null;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FEATURE_DCIP3_SUPPORT)) {
            bArrCompressBitmap = IccProfile.compressBitmap(bitmap2, 100);
        } else {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } finally {
                }
            } catch (IOException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            if (!bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            bArrCompressBitmap = byteArray;
        }
        return m12655a(bArrCompressBitmap, cameraPicture.f12139l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] m12655a(byte[] r5, long r6) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.String r0 = "addExif, close exif stream, exception: "
            java.lang.String r1 = "StickerMode"
            com.oplus.exif.OplusExifInterface r2 = new com.oplus.exif.OplusExifInterface
            r2.<init>()
            r3 = 0
            r4.m12614a(r2, r6)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L36
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
            com.oplus.camera.CameraLog.m12967f(r1, r4)
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
            com.oplus.camera.CameraLog.m12965d(r1, r7, r6)     // Catch: java.lang.Throwable -> L6f
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
            com.oplus.camera.CameraLog.m12967f(r1, r4)
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
            com.oplus.camera.CameraLog.m12967f(r1, r4)
        L89:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.capmode.StickerMode.m12655a(byte[], long):byte[]");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12614a(OplusExifInterface oplusExifInterface, long OplusGLSurfaceView_15) {
        Location locationMo10595y;
        if (oplusExifInterface == null) {
            CameraLog.m12967f("StickerMode", "buildExif, exifInterface is null");
            return;
        }
        synchronized (this.f12995g) {
            if (this.f13000l != null) {
                oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_FOCAL_LENGTH, new OplusRational((long) (this.f13000l.floatValue() * 100.0f), 100L)));
            }
            if (this.f13001m != null) {
                oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_F_NUMBER, new OplusRational((long) (this.f13001m.floatValue() * 10.0f), 10L)));
            }
            if (this.f13002n != null) {
                oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_ISO_SPEED_RATINGS, Short.valueOf(this.f13002n.shortValue())));
            }
            short s = 0;
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_FLASH, Short.valueOf((isOpenFlash() || isOpenFrontTorch() || ((isAutoFlash() || isAutoFrontTorch()) && this.mbAutoFlash)) ? (short) 1 : (short) 0)));
            if (this.f13003o != null) {
                if (this.f13003o.intValue() != 1) {
                    s = 1;
                }
                oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_WHITE_BALANCE, Short.valueOf(s)));
            }
            if (this.f13004p != null) {
                oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_EXPOSURE_TIME, new OplusRational(this.f13004p.longValue(), C1547C.NANOS_PER_SECOND)));
            }
            if (this.mCameraInterface != null && (locationMo10595y = this.mCameraInterface.mo10595y()) != null) {
                oplusExifInterface.addGpsTags(locationMo10595y.getLatitude(), locationMo10595y.getLongitude());
            }
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_USER_COMMENT, OplusExifTag.EXIF_TAG_PREFIX.concat(String.valueOf(C2735b.m13773a(ApsConstant.CAPTURE_MODE_STICKER, this.mCameraId)))));
            oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_MODEL, Util.m24499v()));
            if (0 != OplusGLSurfaceView_15) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy:MM:dd", Locale.US);
                simpleDateFormat.setTimeZone(Calendar.getInstance().getTimeZone());
                simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
                oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_DATE_TIME, simpleDateFormat.format(Long.valueOf(OplusGLSurfaceView_15))));
                oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_DATE_TIME_ORIGINAL, simpleDateFormat.format(Long.valueOf(OplusGLSurfaceView_15))));
                ZonedDateTime zonedDateTimeOfInstant = ZonedDateTime.ofInstant(Instant.ofEpochMilli(OplusGLSurfaceView_15), ZoneId.systemDefault());
                oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_SUB_SEC_TIME_ORIGINAL, DateTimeFormatter.ofPattern("SSS").format(zonedDateTimeOfInstant)));
                oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_OFFSET_TIME_ORIGINAL, 2, DateTimeFormatter.ofPattern("XXX").format(zonedDateTimeOfInstant)));
                oplusExifInterface.addGpsDateTimeStampTag(OplusGLSurfaceView_15);
                oplusExifInterface.setTag(oplusExifInterface.buildTag(OplusExifInterface.TAG_GPS_DATE_STAMP, simpleDateFormat2.format(Long.valueOf(OplusGLSurfaceView_15))));
            }
        }
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z) {
        CameraLog.m12954a("StickerMode", "onBeforePictureTaken");
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        StickerMenu c3015h;
        CameraLog.m12954a("StickerMode", "onAfterPictureTaken");
        if (this.mCameraInterface == null) {
            return;
        }
        if (this.mCameraInterface.mo10575i()) {
            this.mCameraInterface.mo10584n();
            this.mCameraUIInterface.mo18200d(true, false);
        }
        if (!this.mCameraUIInterface.mo18023A()) {
            this.f12997i.m17123a(true);
            this.f12997i.m17129b(true);
        }
        if (containsBubbleKey(CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO) || isShowAnimojiMenu() || (c3015h = this.f12997i) == null || c3015h.m17140g()) {
            return;
        }
        updateBubbleValue(CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO, true);
        this.mCameraUIInterface.mo18086a((View) null, 4, getBubbleOffsetX(4), getBubbleOffsetY(4));
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        Size sizeM24239a;
        String string = this.mPreferences.getString(CameraUIInterface.KEY_PHOTO_RATIO, this.mActivity.getString(R.string.camera_photo_ratio_default_value));
        List<Size> listM13258a = c2698h.m13258a(getImageFormat());
        if (DcsMsgData.FULL.equals(string)) {
            sizeM24239a = Util.m24239a(listM13258a, BaseMode.PICTURE_SIZE_5M, 0);
        } else {
            sizeM24239a = Util.m24239a(listM13258a, BaseMode.PICTURE_SIZE_5M, Util.m24211a(string));
        }
        return sizeM24239a != null ? sizeM24239a : super.getPictureSize(c2698h);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h) {
        Size sizeM24234a;
        Size pictureSize = getPictureSize(c2698h);
        List<Size> listM13257a = c2698h.m13257a();
        int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_STICKER_TARGET_PREVIEW_HEIGHT);
        if ("standard".equals(Util.m24248a(pictureSize, this.mCameraId))) {
            sizeM24234a = Util.m24234a(configIntValue, listM13257a, 1.3333333333333333d);
        } else if ("16_9".equals(Util.m24248a(pictureSize, this.mCameraId))) {
            sizeM24234a = Util.m24234a(configIntValue, listM13257a, 1.7777777777777777d);
        } else {
            sizeM24234a = "square".equals(Util.m24248a(pictureSize, this.mCameraId)) ? Util.m24234a(configIntValue, listM13257a, 1.0d) : null;
        }
        return sizeM24234a != null ? sizeM24234a : super.getPreviewSize(c2698h);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        if ((this.mCameraInterface == null || this.mCameraInterface.mo10575i()) && !Util.m24169C()) {
            return super.getZSLMode();
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public MainShutterButtonInfo getShutterButtonInfo() {
        String str = "button_shape_ring_none";
        if (this.mPreferences != null) {
            String string = this.mPreferences.getString(CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, this.mActivity.getString(R.string.camera_shutter_mode_default_value));
            if (FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE.equals(string)) {
                str = "button_shape_countdown_ten_seconds";
            } else if ("3".equals(string)) {
                str = "button_shape_countdown_three_seconds";
            }
        }
        return Util.m24352ao() ? new MainShutterButtonInfo(23) : new MainShutterButtonInfo(1, "button_color_inside_none", str, 0);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onTimeSnapShotEnd(boolean z) {
        MainShutterButtonInfo shutterButtonInfo = getShutterButtonInfo();
        shutterButtonInfo.m19230b(0);
        this.mCameraUIInterface.mo18091a(shutterButtonInfo);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needUploadOplusStatistics(String str) {
        if (CameraUIInterface.KEY_FACE_DETECTION.equals(str) && isVideoRecording()) {
            return false;
        }
        return super.needUploadOplusStatistics(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onGetNearMeOnClickData() {
        StringBuilder sb = new StringBuilder();
        int OplusGLSurfaceView_13 = this.f12986A;
        if (OplusGLSurfaceView_13 > 0) {
            String str = CameraStatisticsUtil.format(CameraStatisticsUtil.OMOJI_HUMAN_GENERATE_GIF, String.valueOf(OplusGLSurfaceView_13));
            this.f12986A = 0;
            sb.append(str);
        }
        int i2 = this.f13007s;
        if (i2 > 0) {
            String str2 = CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_RECYCLEBIN_CLICK, String.valueOf(i2));
            this.f13007s = 0;
            sb.append(str2);
        }
        int i3 = this.f13008t;
        if (i3 > 0) {
            String str3 = CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_RECYCLEBIN_DELETEALL, String.valueOf(i3));
            this.f13008t = 0;
            sb.append(str3);
        }
        m12617a(this.f13011w, sb);
        m12634b(this.f13010v, sb);
        this.f13009u = null;
        if (sb.length() > 0) {
            CameraStatisticsUtil.onCommon(this.mActivity, CameraStatisticsUtil.EVENT_MENU_CLICK, sb.toString());
        }
        this.f12987B = System.currentTimeMillis() - this.f12987B;
        long OplusGLSurfaceView_15 = this.f12987B;
        if (OplusGLSurfaceView_15 > 0) {
            CameraStatisticsUtil.onCommon(this.mActivity, CameraStatisticsUtil.EVENT_ENTER_STICKER, CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_MODE_USE_TIME, String.valueOf(OplusGLSurfaceView_15)));
        }
        this.f12987B = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12616a(String str, String str2) {
        if (this.f13011w == null) {
            this.f13011w = new HashMap<>();
        }
        String str3 = str + "_" + str2;
        if (this.f13011w.containsKey(str3)) {
            HashMap<String, Integer> map = this.f13011w;
            map.put(str3, Integer.valueOf(map.get(str3).intValue() + 1));
        } else {
            this.f13011w.put(str3, 1);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12617a(HashMap<String, Integer> map, StringBuilder sb) {
        if (map != null) {
            for (String str : map.keySet()) {
                sb.append(CameraStatisticsUtil.format(str, String.valueOf(map.get(str))));
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m12633b(String str, String str2) {
        String[] strArrSplit;
        if (this.f13010v == null) {
            this.f13010v = new HashMap<>();
        }
        String str3 = this.f13009u;
        if (str3 != null && (strArrSplit = str3.split("\\.")) != null && strArrSplit.length > 1) {
            String str4 = str + "_" + strArrSplit[0];
            long jCurrentTimeMillis = System.currentTimeMillis() - Long.parseLong(strArrSplit[1]);
            if (this.f13010v.containsKey(str4)) {
                HashMap<String, Long> map = this.f13010v;
                map.put(str4, Long.valueOf(map.get(str4).longValue() + jCurrentTimeMillis));
            } else {
                this.f13010v.put(str4, Long.valueOf(jCurrentTimeMillis));
            }
        }
        this.f13009u = str2 + "." + System.currentTimeMillis();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m12634b(HashMap<String, Long> map, StringBuilder sb) {
        if (map != null) {
            for (String str : map.keySet()) {
                sb.append(CameraStatisticsUtil.format(str, String.valueOf(map.get(str))));
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m12624a(StickerItem stickerItem, int OplusGLSurfaceView_13) {
        if (this.mCameraInterface == null) {
            return false;
        }
        if (stickerItem == null || this.mCameraInterface.mo10463S() || isAnyModeAnimationRunning()) {
            CameraLog.m12967f("StickerMode", "onStickerItemClick, item: " + stickerItem + ", isBlurAnimRunning: " + this.mCameraInterface.mo10463S() + ", isAnyModeAnimationRunning: " + isAnyModeAnimationRunning());
            return false;
        }
        if (stickerItem.isRecycleBin()) {
            CameraLog.m12959b("StickerMode", "onStickerItemClick, recycle_bin_sticker_id");
            StickerRecycleBinDialog dialogC3019l = this.f12998j;
            if (dialogC3019l == null || !dialogC3019l.isShowing()) {
                this.f13007s++;
                this.f12998j = new StickerRecycleBinDialog(this.mActivity);
                this.f12998j.show();
                this.f12998j.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.oplus.camera.capmode.t.10
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        CameraLog.m12959b("StickerMode", "onStickerItemClick, onDismiss");
                        ImageStickerTools.m22687b(StickerMode.this.mActivity).m22709a(1, true);
                    }
                });
                this.f12998j.m17183a(new StickerRecycleBinDialog.PlatformImplementations.kt_3() { // from class: com.oplus.camera.capmode.t.11
                    @Override // com.oplus.camera.sticker.p168ui.StickerRecycleBinDialog.PlatformImplementations.kt_3
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo12658a() {
                        StickerMode.m12642d(StickerMode.this);
                    }

                    @Override // com.oplus.camera.sticker.p168ui.StickerRecycleBinDialog.PlatformImplementations.kt_3
                    /* renamed from: PlatformImplementations.kt_3 */
                    public void mo12659a(int i2, boolean z) {
                        StickerMode.this.m12604a(i2, z, "delete");
                    }

                    @Override // com.oplus.camera.sticker.p168ui.StickerRecycleBinDialog.PlatformImplementations.kt_3
                    /* renamed from: IntrinsicsJvm.kt_4 */
                    public void mo12660b(int i2, boolean z) {
                        StickerMode.this.m12604a(i2, z, "cancel");
                    }
                });
            }
            return true;
        }
        if (ImageStickerTools.m22687b(this.mActivity).m22716a(this.mActivity, stickerItem)) {
            return true;
        }
        m12625a(stickerItem, false);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m12620a(View view, StickerItem stickerItem, int OplusGLSurfaceView_13) {
        if (stickerItem == null) {
            CameraLog.m12966e("StickerMode", "onStickwerItemLongClick, item: " + stickerItem);
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onUiModeChanged() {
        super.onUiModeChanged();
        StickerRecycleBinDialog dialogC3019l = this.f12998j;
        if (dialogC3019l != null) {
            dialogC3019l.m17184b();
        }
        ImageStickerTools.m22687b(this.mActivity).m22710a(this.mActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12618a(boolean z) {
        CameraLog.m12954a("StickerMode", "updateStickerImageResource");
        ImageStickerTools.m22687b(this.mActivity).m22713a(this.f12993H, ImageStickerTools.m22687b(this.mActivity).m22706a(this.mPreferences), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12641c(StickerItem stickerItem) {
        if (this.mPreviewEffectProcess == null || stickerItem == null || !ImageStickerTools.m22687b(this.mActivity).m22718b().m22751d(stickerItem.getStickerUUID()) || !this.mPreviewEffectProcess.mo22816b(stickerItem)) {
            return;
        }
        this.mPreviewEffectProcess.mo22829e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12619a(boolean z, boolean z2) {
        CameraLog.m12954a("StickerMode", "hideStickerMenu, includePanle: " + z2);
        this.f12997i.m17114a(4, z, z2);
        this.f12997i.m17123a(false);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m12636b(boolean z, boolean z2) {
        CameraLog.m12954a("StickerMode", "showStickerMenu, needAnim: " + z + ", includePanel: " + z2 + ", isMoreModeShown: " + this.mCameraUIInterface.mo18057R());
        if (this.mCameraUIInterface.mo18057R() || isVideoRecording()) {
            return;
        }
        this.f12997i.m17114a(0, z, z2);
        this.f12997i.m17123a(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int OplusGLSurfaceView_13, boolean z) {
        super.changeModeAllViewWhenAnimation(OplusGLSurfaceView_13, z);
        if (OplusGLSurfaceView_13 != 3) {
            if (OplusGLSurfaceView_13 != 18) {
                return;
            }
            if (z) {
                m12636b(true, false);
                return;
            } else {
                m12619a(true, true);
                return;
            }
        }
        this.f12997i.m17123a((z && this.mbInCapturing) ? false : z);
        if (z) {
            m12636b(true, true);
        } else if (this.f12997i.m17140g()) {
            this.f12997i.m17130b(true, true, false);
        } else {
            m12619a(false, true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        m12619a(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsed() {
        if (this.mCameraInterface.mo10445A() || this.mCameraUIInterface.mo18023A()) {
            return;
        }
        m12636b(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void startScreenTorch() {
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO)) {
            this.mCameraUIInterface.mo18210f(4, false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void stopScreenTorch() {
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO)) {
            this.mCameraUIInterface.mo18086a((View) null, 4, getBubbleOffsetX(4), getBubbleOffsetY(4));
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopUp() {
        String currEffectMenuName = getCurrEffectMenuName();
        if (isStickerMenuOpen()) {
            if (isPanelMode()) {
                this.mCameraUIInterface.mo18097a(this.mActivity.getString(R.string.camera_mode_sticker));
            }
            this.f12997i.m17138e(true);
        } else {
            m12619a(false, true);
        }
        if ("beauty".equals(currEffectMenuName)) {
            CameraStatisticsUtil.onCommon(this.mActivity, CameraStatisticsUtil.EVENT_MENU_CLICK, CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_MODE_CLICK_SMOOTH_MENU, "1"));
        } else if (MenuClickMsgData.KEY_FILTER.equals(currEffectMenuName)) {
            CameraStatisticsUtil.onCommon(this.mActivity, CameraStatisticsUtil.EVENT_MENU_CLICK, CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_MODE_CLICK_FILTER_MENU, "1"));
        }
        this.mCameraUIInterface.mo18112aB();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onEffectMenuPopDown(boolean z) {
        m12636b(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean showEffectMenu() {
        return !this.f12997i.m17140g();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isStickerMenuOpen() {
        StickerMenu c3015h = this.f12997i;
        if (c3015h == null) {
            return false;
        }
        return c3015h.m17140g();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m12654a() {
        if (!isVideoRecordStopped() || this.f12997i.m17142i() || this.mCameraUIInterface.mo18025B()) {
            return true;
        }
        if (!isStickerMenuOpen()) {
            return false;
        }
        if (isPanelMode()) {
            this.mCameraUIInterface.mo18097a(this.mActivity.getString(R.string.camera_mode_sticker));
            this.mCameraUIInterface.mo18077a(0, true);
        } else {
            this.mCameraUIInterface.mo18068a(0, 1);
        }
        this.f12997i.m17138e(false);
        if (!supportBeautyButton()) {
            this.mCameraUIInterface.mo18232j(false, false);
        } else {
            this.mCameraUIInterface.mo18240l(true, false);
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean supportBeautyButton() {
        if (this.mPreviewEffectProcess == null || !ImageStickerTools.m22691b(this.mPreviewEffectProcess.mo22842j())) {
            return super.supportBeautyButton();
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public void forceStopVideoRecording(boolean z) {
        super.forceStopVideoRecording(z);
        m12652j();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        CameraLog.m12954a("StickerMode", "onBackPressed");
        if (m12654a()) {
            if (isVideoRecordStarted()) {
                m12652j();
                return super.onBackPressed();
            }
            if (isVideoRecordStarting()) {
                m12652j();
                stopShortVideoRecording();
            }
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        CameraLog.m12954a("StickerMode", "onSingleTapUp");
        Rect rect = new Rect();
        this.mCameraUIInterface.mo18253p().getHitRect(rect);
        if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        if (m12654a()) {
            return true;
        }
        return isShowAnimojiMenu();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onDown(MotionEvent motionEvent) {
        return super.onDown(motionEvent);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onSwitchCameraButtonClick() {
        super.onSwitchCameraButtonClick();
        CameraStatisticsUtil.onCommon(this.mActivity, CameraStatisticsUtil.EVENT_MENU_CLICK, CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_MODE_SWITCH_CAMERA, "1"));
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m12652j() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18280w();
        }
        LockViewDragLayout.setLongPressState(false);
        LockViewDragLayout.setVolumeDownState(false);
        LockViewDragLayout.setReachBorderState(false);
    }

    /* compiled from: StickerMode.java */
    /* renamed from: com.oplus.camera.capmode.t$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 implements StickerDownloadListener {
        private PlatformImplementations.kt_3() {
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.StickerDownloadListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo12679a(StickerItem stickerItem) throws Throwable {
            if (StickerMode.this.mbDestroyed) {
                return;
            }
            CameraLog.m12959b("StickerMode", "onStickerDownloadStarted, item: " + stickerItem.toString());
            Integer numM22748c = ImageStickerTools.m22687b(StickerMode.this.mActivity).m22718b().m22748c(stickerItem.getStickerUUID());
            if (numM22748c != null) {
                StickerMode.this.f12997i.m17120a(stickerItem.getCategoryId(), numM22748c.intValue(), stickerItem.getDownloadState(), stickerItem.getThumbnailFileUri(), !StickerMode.this.mbPaused, stickerItem);
            }
            StickerMode.this.f12988C = System.currentTimeMillis();
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.StickerDownloadListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo12681b(final StickerItem stickerItem) {
            if (StickerMode.this.mbDestroyed) {
                return;
            }
            if (!StickerMode.this.isVideoRecording() && !StickerMode.this.mCameraInterface.mo10463S() && !StickerMode.this.getIsCapturingState() && StickerMode.this.mbModePreInit) {
                StickerMode.this.m12625a(stickerItem, true);
                StickerMode.this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.t.PlatformImplementations.kt_3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (StickerMode.this.f12998j == null || !StickerMode.this.f12998j.isShowing()) {
                            return;
                        }
                        StickerMode.this.f12998j.m17181a();
                    }
                });
                if (StickerMode.this.mCameraUIInterface != null) {
                    StickerMode.this.mCameraUIInterface.mo18066a().m14132a(new Runnable() { // from class: com.oplus.camera.capmode.t.PlatformImplementations.kt_3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            StickerMode.this.m12641c(stickerItem);
                        }
                    });
                }
            }
            StickerMode.this.m12618a(false);
            StickerMode.this.m12612a(stickerItem, System.currentTimeMillis() - StickerMode.this.f12988C, StickerMsgData.STICKER_OPER_DOWNLOAD, "0");
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.StickerDownloadListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo12680a(StickerItem stickerItem, int OplusGLSurfaceView_13) throws Throwable {
            if (StickerMode.this.mbDestroyed) {
                return;
            }
            Integer numM22748c = ImageStickerTools.m22687b(StickerMode.this.mActivity).m22718b().m22748c(stickerItem.getStickerUUID());
            if (numM22748c != null) {
                StickerMode.this.f12997i.m17120a(stickerItem.getCategoryId(), numM22748c.intValue(), 16, stickerItem.getThumbnailFileUri(), !StickerMode.this.mbPaused, stickerItem);
            }
            StickerMode.this.m12612a(stickerItem, -1L, StickerMsgData.STICKER_OPER_DOWNLOAD, "1");
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.StickerDownloadListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo12682c(final StickerItem stickerItem) {
            if (StickerMode.this.mbDestroyed) {
                return;
            }
            StickerMode.this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.capmode.t.PlatformImplementations.kt_3.3
                @Override // java.lang.Runnable
                public void run() {
                    if (stickerItem != null) {
                        if (StickerMode.this.mPreviewEffectProcess != null && StickerMode.this.mPreviewEffectProcess.mo22842j() != null && TextUtils.equals(stickerItem.getStickerUUID(), StickerMode.this.mPreviewEffectProcess.mo22842j().getStickerUUID())) {
                            StickerMode.this.f12997i.m17133c(false);
                            StickerMode.this.m12632b(stickerItem);
                            if (ImageStickerTools.m22691b(stickerItem)) {
                                StickerMode.this.m12637c();
                            }
                        }
                        StickerMode.this.m12616a(CameraStatisticsUtil.STICKER_RECYCLEBIN_ITEM_DELETE, stickerItem.getStickerUUID());
                    }
                    if (StickerMode.this.f12998j == null || !StickerMode.this.f12998j.isShowing()) {
                        return;
                    }
                    StickerMode.this.f12998j.m17182a(stickerItem);
                }
            });
            StickerMode.this.m12618a(false);
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.StickerDownloadListener
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo12683d(StickerItem stickerItem) {
            if (StickerMode.this.mbDestroyed) {
                return;
            }
            StickerMode.this.m12618a(false);
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.StickerDownloadListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo12678a(int OplusGLSurfaceView_13) {
            if (StickerMode.this.mbDestroyed || OplusGLSurfaceView_13 == 0) {
                return;
            }
            if (OplusGLSurfaceView_13 == 1) {
                StickerMode.this.m12618a(false);
            } else {
                if (OplusGLSurfaceView_13 != 2) {
                    return;
                }
                if (StickerMode.this.mCameraInterface.mo10463S()) {
                    StickerMode.this.m12618a(false);
                } else {
                    StickerMode.this.m12618a(true);
                }
            }
        }

        @Override // com.oplus.camera.p172ui.preview.p177a.StickerDownloadListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo12677a() {
            if (StickerMode.this.mbDestroyed) {
                return;
            }
            StickerMode.this.m12618a(false);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAllowSwitch(CameraConstant.PlatformImplementations.kt_3 aVar) {
        if (isShowAnimojiMenu()) {
            return false;
        }
        return super.isAllowSwitch(aVar);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void updateRatioType() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18173b(CameraUIInterface.KEY_PHOTO_RATIO, DcsMsgData.FULL);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onFaceBeautyItemValueChange(int OplusGLSurfaceView_13, int i2, boolean z) {
        super.onFaceBeautyItemValueChange(OplusGLSurfaceView_13, i2, z);
        m12603a(OplusGLSurfaceView_13, i2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12635b(boolean z) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(false);
        menuClickMsgData.mFuncKeyId = 34;
        menuClickMsgData.mCaptureType = 2;
        m12640c(menuClickMsgData);
        if (z) {
            menuClickMsgData.mFuncKeyResult = 1;
        } else {
            menuClickMsgData.mFuncKeyResult = 2;
        }
        menuClickMsgData.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12615a(String str) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(true);
        menuClickMsgData.mFuncKeyId = 34;
        m12640c(menuClickMsgData);
        menuClickMsgData.mItemValue = str;
        menuClickMsgData.report();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12603a(int OplusGLSurfaceView_13, int i2, boolean z) {
        if (z) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.mActivity);
            menuClickMsgData.buildEvent(true);
            menuClickMsgData.mFuncKeyId = 2;
            if (this.mbFrontCamera) {
                menuClickMsgData.mItem = MenuClickMsgData.KEY_COMMON_CUSTOM_BEAUTY[OplusGLSurfaceView_13];
            }
            menuClickMsgData.mItemValue = String.valueOf(i2);
            m12640c(menuClickMsgData);
            menuClickMsgData.report();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12602a(int OplusGLSurfaceView_13) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(true);
        menuClickMsgData.mFuncKeyId = 4;
        menuClickMsgData.mItemValue = FilterHelper.m22620b(OplusGLSurfaceView_13, this.mCameraId);
        m12640c(menuClickMsgData);
        menuClickMsgData.report();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12613a(StickerItem stickerItem, boolean z, String str) {
        StickerMsgData stickerMsgData = new StickerMsgData(this.mActivity);
        stickerMsgData.buildEvent(StickerMsgData.EVENT_STICKER_SELECT);
        m12640c(stickerMsgData);
        stickerMsgData.mStickerName = stickerItem.getStickerName();
        stickerMsgData.mStickerType = String.valueOf(stickerItem.getMaterialType());
        stickerMsgData.mStickerUuid = stickerItem.getStickerUUID();
        stickerMsgData.mProtocolVersion = String.valueOf(stickerItem.getProtocolVersion());
        if (z) {
            stickerMsgData.mMyDownload = "true";
        } else {
            stickerMsgData.mMyDownload = "false";
        }
        if (StickerMsgData.STICKER_OPER_SELECT.equals(str)) {
            stickerMsgData.mOperType = StickerMsgData.STICKER_OPER_SELECT;
        } else if ("cancel".equals(str)) {
            stickerMsgData.mOperType = "cancel";
        }
        stickerMsgData.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12612a(StickerItem stickerItem, long OplusGLSurfaceView_15, String str, String str2) {
        StickerMsgData stickerMsgData = new StickerMsgData(this.mActivity);
        stickerMsgData.buildEvent("sticker_download");
        m12640c(stickerMsgData);
        stickerMsgData.mStickerName = stickerItem.getStickerName();
        stickerMsgData.mStickerType = String.valueOf(stickerItem.getMaterialType());
        stickerMsgData.mStickerUuid = stickerItem.getStickerUUID();
        stickerMsgData.mProtocolVersion = String.valueOf(stickerItem.getProtocolVersion());
        stickerMsgData.mStickerDownloadCostTime = OplusGLSurfaceView_15;
        stickerMsgData.mZoomValue = String.valueOf(this.mCameraInterface.mo10535ak());
        if (StickerMsgData.STICKER_OPER_DOWNLOAD.equals(str)) {
            stickerMsgData.mOperType = StickerMsgData.STICKER_OPER_DOWNLOAD;
        } else if ("cancel".equals(str)) {
            stickerMsgData.mOperType = "cancel";
        }
        if (str2 != null) {
            stickerMsgData.mDownloadResult = str2;
        }
        stickerMsgData.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12604a(int OplusGLSurfaceView_13, boolean z, String str) {
        StickerMsgData stickerMsgData = new StickerMsgData(this.mActivity);
        stickerMsgData.buildEvent(StickerMsgData.EVENT_STICKER_DELETE);
        m12640c(stickerMsgData);
        stickerMsgData.mSelectCount = OplusGLSurfaceView_13;
        if (z) {
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

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m12640c(DcsMsgData dcsMsgData) {
        if (this.mCameraInterface.mo10575i()) {
            dcsMsgData.mCameraEnterType = String.valueOf(1);
        } else if (this.mCameraInterface.mo10583m()) {
            dcsMsgData.mCameraEnterType = String.valueOf(3);
        } else {
            dcsMsgData.mCameraEnterType = String.valueOf(2);
        }
        dcsMsgData.mCaptureMode = getCameraMode();
        dcsMsgData.mCameraId = this.mCameraInterface.mo10547aw();
        dcsMsgData.mOrientation = this.mOrientation;
        dcsMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.mCameraInterface.mo10547aw()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    public boolean getSupportGestureCapture() {
        StickerRecycleBinDialog dialogC3019l = this.f12998j;
        return (dialogC3019l == null || !dialogC3019l.isShowing()) && super.getSupportGestureCapture();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        m12619a(true, false);
        if (isBubbleOpen(CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO)) {
            this.mCameraUIInterface.mo18210f(4, true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) {
        super.onMoreModeHidden(OplusGLSurfaceView_13);
        if (this.mCameraUIInterface.mo18023A()) {
            return;
        }
        m12636b(true, false);
    }

    @Override // com.oplus.camera.capmode.VideoMode, com.oplus.camera.capmode.BaseMode
    protected boolean isNeedSetZslWhenCapture() {
        return Util.m24169C();
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureFirstFrameArrived(CaptureRequest captureRequest, CameraCaptureResult cameraCaptureResult) {
        super.onCaptureFirstFrameArrived(captureRequest, cameraCaptureResult);
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10480a(captureRequest, cameraCaptureResult);
        }
        if (this.mActivity == null || this.mbPaused) {
            return;
        }
        this.f12991F = true;
        m12653k();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m12653k() {
        if (this.f12992G && this.f12991F) {
            if (this.mCameraInterface != null) {
                this.mCameraInterface.mo10482a(this.f12990E);
            }
            this.f12992G = false;
            this.f12991F = false;
            this.f12990E = null;
        }
    }
}
