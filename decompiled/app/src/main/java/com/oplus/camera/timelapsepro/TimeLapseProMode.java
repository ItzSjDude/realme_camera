package com.oplus.camera.timelapsepro;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import android.text.TextUtils;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.C1547C;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.ZoomConfigure;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Camera;
import com.oplus.camera.R;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.aps.service.CameraCaptureResult;
import com.oplus.camera.aps.util.AlgoSwitchConfig;
import com.oplus.camera.aps.util.CameraApsDecision;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.jni.FormatConverter;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p144g.C2735b;
import com.oplus.camera.p146gl.SurfaceTextureScreenNail;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.inverse.InverseTextView;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.screen.ScreenRelativeLayout;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.screen.p164b.OutScreenMode;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.ReminderMsgData;
import com.oplus.camera.statistics.model.TimeLapseProMsgData;
import com.oplus.camera.timelapsepro.TimeLapseProMenuLayout;
import com.oplus.camera.timelapsepro.p170a.ProParameter;
import com.oplus.camera.timelapsepro.p170a.ExposureParameter;
import com.oplus.camera.timelapsepro.p170a.FocusParameter;
import com.oplus.camera.timelapsepro.p170a.ISOParameter;
import com.oplus.camera.timelapsepro.p170a.ResetParameter;
import com.oplus.camera.timelapsepro.p170a.ShutterParameter;
import com.oplus.camera.timelapsepro.p170a.WhiteBalanceParameter;
import com.oplus.camera.util.Util;
import com.oplus.exif.OplusExifInterface;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPictureCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: TimeLapseProMode.java */
/* renamed from: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class TimeLapseProMode extends BaseMode implements TimeLapseProMenuLayout.IntrinsicsJvm.kt_5, TimeLapseProMenuLayout.COUIBaseListPopupWindow_12 {

    /* renamed from: A */
    private long f16959A;

    /* renamed from: B */
    private boolean f16960B;

    /* renamed from: C */
    private CameraRequestTag f16961C;

    /* renamed from: D */
    private CameraApsDecision f16962D;

    /* renamed from: E */
    private OneCamera.PlatformImplementations.kt_3 f16963E;

    /* renamed from: F */
    private int f16964F;

    /* renamed from: G */
    private boolean f16965G;

    /* renamed from: H */
    private int f16966H;

    /* renamed from: I */
    private int f16967I;

    /* renamed from: J */
    private TimeLapseProMenuLayout f16968J;

    /* renamed from: K */
    private boolean f16969K;

    /* renamed from: L */
    private boolean f16970L;

    /* renamed from: M */
    private boolean f16971M;

    /* renamed from: N */
    private long f16972N;

    /* renamed from: O */
    private long f16973O;

    /* renamed from: P */
    private long f16974P;

    /* renamed from: Q */
    private long f16975Q;

    /* renamed from: R */
    private List<ProParameter> f16976R;

    /* renamed from: S */
    private boolean f16977S;

    /* renamed from: T */
    private boolean f16978T;

    /* renamed from: U */
    private Handler f16979U;

    /* renamed from: V */
    private Handler f16980V;

    /* renamed from: W */
    private RelativeLayout f16981W;

    /* renamed from: X */
    private ImageView f16982X;

    /* renamed from: Y */
    private boolean f16983Y;

    /* renamed from: Z */
    private RenderScript f16984Z;

    /* renamed from: aA */
    private String f16985aA;

    /* renamed from: aB */
    private boolean f16986aB;

    /* renamed from: aC */
    private Map<String, TimeLapseProMsgData> f16987aC;

    /* renamed from: aD */
    private TimeLapseProMenuLayout.COUIBaseListPopupWindow_8 f16988aD;

    /* renamed from: aE */
    private final View.OnClickListener f16989aE;

    /* renamed from: aF */
    private boolean f16990aF;

    /* renamed from: aa */
    private ScriptIntrinsicYuvToRGB f16991aa;

    /* renamed from: ab */
    private Type.Builder f16992ab;

    /* renamed from: ac */
    private Type.Builder f16993ac;

    /* renamed from: ad */
    private int f16994ad;

    /* renamed from: ae */
    private int f16995ae;

    /* renamed from: af */
    private long f16996af;

    /* renamed from: ag */
    private long f16997ag;

    /* renamed from: ah */
    private String f16998ah;

    /* renamed from: ai */
    private float f16999ai;

    /* renamed from: aj */
    private boolean f17000aj;

    /* renamed from: ak */
    private InverseTextView f17001ak;

    /* renamed from: al */
    private Bitmap f17002al;

    /* renamed from: am */
    private Bitmap f17003am;

    /* renamed from: an */
    private FormatConverter f17004an;

    /* renamed from: ao */
    private RelativeLayout.LayoutParams f17005ao;

    /* renamed from: ap */
    private RelativeLayout.LayoutParams f17006ap;

    /* renamed from: aq */
    private boolean f17007aq;

    /* renamed from: ar */
    private boolean f17008ar;

    /* renamed from: as */
    private boolean f17009as;

    /* renamed from: at */
    private boolean f17010at;

    /* renamed from: au */
    private boolean f17011au;

    /* renamed from: av */
    private boolean f17012av;

    /* renamed from: aw */
    private float f17013aw;

    /* renamed from: ax */
    private String f17014ax;

    /* renamed from: ay */
    private String f17015ay;

    /* renamed from: az */
    private String f17016az;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected boolean f17017g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final ConditionVariable f17018h;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f17019i;

    /* renamed from: OplusGLSurfaceView_15 */
    private long f17020j;

    /* renamed from: OplusGLSurfaceView_5 */
    private long f17021k;

    /* renamed from: OplusGLSurfaceView_14 */
    private long f17022l;

    /* renamed from: OplusGLSurfaceView_6 */
    private RecorderHelper f17023m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f17024n;

    /* renamed from: o */
    private boolean f17025o;

    /* renamed from: p */
    private int f17026p;

    /* renamed from: q */
    private int f17027q;

    /* renamed from: r */
    private long f17028r;

    /* renamed from: s */
    private Handler f17029s;

    /* renamed from: t */
    private int f17030t;

    /* renamed from: u */
    private boolean f17031u;

    /* renamed from: v */
    private Object f17032v;

    /* renamed from: w */
    private int f17033w;

    /* renamed from: x */
    private int f17034x;

    /* renamed from: y */
    private volatile int f17035y;

    /* renamed from: z */
    private volatile int f17036z;

    /* renamed from: O */
    private void m17789O() {
    }

    /* renamed from: P */
    private void m17790P() {
    }

    /* renamed from: Q */
    private void m17791Q() {
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String m17866e(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != 0 ? OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? "RECORD_STOPPING" : "RECORD_STOPPED" : "RECORD_STARTING" : "RECORD_STARTED";
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean canShowResumeButton() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.REC_MODE_TIMELASPE_PRO;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getDefaultCaptureNumber() {
        return 1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getHeicCodecFormat() {
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getImageFormat() {
        return 35;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32936;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void hideViewWhileResume() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isSubMenuEnable() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needStoreImage() {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onShareMenuExpand() {
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onStop() {
    }

    public TimeLapseProMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f17018h = new ConditionVariable();
        this.f17019i = "15";
        this.f17020j = 0L;
        this.f17021k = 0L;
        this.f17022l = 14400000L;
        this.f17017g = false;
        this.f17023m = null;
        this.f17024n = false;
        this.f17025o = false;
        this.f17026p = 0;
        this.f17027q = 0;
        this.f17028r = 0L;
        this.f17029s = null;
        this.f17030t = -1;
        this.f17031u = false;
        this.f17032v = new Object();
        this.f17033w = 0;
        this.f17034x = 0;
        this.f17035y = 0;
        this.f17036z = 2;
        this.f16959A = 0L;
        this.f16960B = false;
        this.f16961C = null;
        this.f16962D = null;
        this.f16963E = null;
        this.f16964F = 0;
        this.f16965G = true;
        this.f16966H = 0;
        this.f16967I = 0;
        this.f16968J = null;
        this.f16969K = false;
        this.f16970L = false;
        this.f16971M = false;
        this.f16972N = 0L;
        this.f16973O = 0L;
        this.f16974P = 0L;
        this.f16975Q = 0L;
        this.f16976R = new ArrayList();
        this.f16977S = false;
        this.f16978T = false;
        this.f16979U = null;
        this.f16980V = null;
        this.f16981W = null;
        this.f16982X = null;
        this.f16983Y = false;
        this.f16994ad = 0;
        this.f16995ae = 0;
        this.f16996af = 0L;
        this.f16997ag = 0L;
        this.f16999ai = -1.0f;
        this.f17000aj = false;
        this.f17002al = null;
        this.f17003am = null;
        this.f17004an = null;
        this.f17005ao = null;
        this.f17006ap = null;
        this.f17007aq = false;
        this.f17008ar = false;
        this.f17009as = true;
        this.f17010at = false;
        this.f17011au = false;
        this.f17012av = false;
        this.f17013aw = 0.0f;
        this.f17014ax = "";
        this.f17015ay = "";
        this.f17016az = "";
        this.f16985aA = "";
        this.f16986aB = true;
        this.f16987aC = new HashMap();
        this.f16988aD = new TimeLapseProMenuLayout.COUIBaseListPopupWindow_8() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_10.1
            @Override // com.oplus.camera.timelapsepro.TimeLapseProMenuLayout.COUIBaseListPopupWindow_8
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17768a(String str, String str2) {
            }

            @Override // com.oplus.camera.timelapsepro.TimeLapseProMenuLayout.COUIBaseListPopupWindow_8
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17765a(int OplusGLSurfaceView_13) {
                if (TimeLapseProMode.this.f17029s == null) {
                    return;
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 107;
                messageObtain.arg1 = OplusGLSurfaceView_13;
                if (TimeLapseProMode.this.f17029s.hasMessages(107)) {
                    TimeLapseProMode.this.f17029s.removeMessages(107);
                }
                TimeLapseProMode.this.f17029s.sendMessageDelayed(messageObtain, 33L);
            }

            @Override // com.oplus.camera.timelapsepro.TimeLapseProMenuLayout.COUIBaseListPopupWindow_8
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17767a(String str) {
                CameraLog.m12954a("TimeLapseProMode", "onSpeedValueChanged, speed: " + str);
                TimeLapseProMode.this.m17859d(str);
            }

            @Override // com.oplus.camera.timelapsepro.TimeLapseProMenuLayout.COUIBaseListPopupWindow_8
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17766a(long OplusGLSurfaceView_15) {
                TimeLapseProMode.this.f17021k = OplusGLSurfaceView_15;
                if (OplusGLSurfaceView_15 == 0) {
                    TimeLapseProMode.this.f17022l = 14400000L;
                } else {
                    TimeLapseProMode c3072h = TimeLapseProMode.this;
                    c3072h.f17022l = c3072h.f17021k * ((Long.parseLong(TimeLapseProMode.this.f17019i) * 1000) / TimeLapseProMode.this.m17865e().m17610c());
                }
                CameraLog.m12954a("TimeLapseProMode", "onDurationValueChanged, frames: " + OplusGLSurfaceView_15 + ", mDurationTime: " + TimeLapseProMode.this.f17022l);
            }
        };
        this.f16989aE = new View.OnClickListener() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_10.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int id_renamed = view.getId();
                if (id_renamed == R.id_renamed.time_lapse_pro_setting_button) {
                    TimeLapseProMode.this.m17844b(TimeLapseProMsgData.FUNC_KEY_ID_PARAMS, "1");
                    TimeLapseProMode.this.m17821a(true, false, true, true, false);
                } else {
                    if (id_renamed != R.id_renamed.time_lapse_pro_template_button) {
                        return;
                    }
                    TimeLapseProMode.this.m17844b(TimeLapseProMsgData.FUNC_KEY_ID_TEMPLATE, "1");
                    TimeLapseProMode.this.m17821a(true, true, true, true, false);
                }
            }
        };
        this.f16990aF = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public RecorderHelper m17865e() {
        if (this.f17023m == null) {
            this.f17023m = new RecorderHelper(this.mActivity, this.mCameraInterface, this.mCameraUIInterface, this.mbDisplayOnLock);
            this.f17023m.m17605a(C2735b.m13779b(getCameraMode(), this.mCameraId));
        }
        return this.f17023m;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean canShowTimeLapseProButtons() {
        return !this.mbFrontCamera;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isCaptureModeType() {
        return !isVideoRecording();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getTouchEnable(boolean z, int OplusGLSurfaceView_13, int i2) {
        return this.f16967I == 0 && !isVideoRecording();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        CameraLog.m12954a("TimeLapseProMode", "onSingleTapUp");
        TimeLapseProMenuLayout c3071g = this.f16968J;
        if (c3071g != null && !c3071g.m17756n() && this.f16968J.getVisibility() == 0) {
            m17854c(this.f16968J.m17745c());
            return true;
        }
        m17809a(motionEvent);
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m17870f() {
        return getCurrentScreenMode() != null && 4 == getCurrentScreenMode().mo16539j();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m17873g() {
        return getCurrentScreenMode() != null && 3 == getCurrentScreenMode().mo16539j();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m17876h() {
        return getCurrentScreenMode() != null && 1 == getCurrentScreenMode().mo16539j();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m17854c(boolean z) {
        m17821a(false, z, true, true, false);
        this.mCameraUIInterface.mo18054Q(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17821a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        CameraLog.m12954a("TimeLapseProMode", "showMenu, show: " + z + ", showTemplate: " + z2 + ", needAnim: " + z3 + ", needTranslate: " + z4 + ", fromPause: " + z5);
        if (!m17870f()) {
            m17820a(!z, z3, z4);
            m17847b(!z, z3, z4);
        }
        if (z2) {
            m17819a(z, z3);
        } else {
            m17846b(z, z3);
        }
        if (this.mCameraInterface == null || z5) {
            return;
        }
        if (z && !m17870f()) {
            this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, z4);
            return;
        }
        if (this.f16967I != 2) {
            if (this.f16971M) {
                this.mCameraInterface.mo10506aH();
                this.f16971M = false;
            }
            this.mCameraInterface.mo10492a(true, z4);
            this.mCameraInterface.mo10563d(true);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMenuBackButtonClick() {
        if (this.f16967I != 2) {
            if (this.f16971M) {
                this.mCameraInterface.mo10506aH();
                this.f16971M = false;
            }
            this.mCameraInterface.mo10492a(true, true);
            this.mCameraInterface.mo10563d(true);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17820a(boolean z, boolean z2, boolean z3) {
        if (this.mCameraUIInterface != null) {
            if (z) {
                this.mCameraUIInterface.mo18252o(z2, z3);
            } else {
                this.mCameraUIInterface.mo18256p(z2, z3);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17847b(boolean z, boolean z2, boolean z3) {
        if (this.mCameraUIInterface != null) {
            if (z) {
                this.mCameraUIInterface.mo18260q(z2, z3);
            } else {
                this.mCameraUIInterface.mo18264r(z2, z3);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17819a(boolean z, boolean z2) {
        this.mCameraUIInterface.mo18268s(z, z2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17846b(boolean z, boolean z2) {
        this.mCameraUIInterface.mo18272t(z, z2);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        super.onMoreModeShown();
        m17820a(false, false, false);
        m17847b(false, false, false);
        this.mCameraUIInterface.mo18050O(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) {
        super.onMoreModeHidden(OplusGLSurfaceView_13);
        if (!this.mbFrontCamera) {
            m17820a(true, false, false);
            m17847b(true, false, false);
        }
        this.mCameraUIInterface.mo18049N(true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onLongPress(MotionEvent motionEvent) {
        CameraLog.m12954a("TimeLapseProMode", "onLongPress");
        m17809a(motionEvent);
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17809a(MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.mCameraUIInterface.mo18253p().getHitRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            if (1 == getDefaultAFMode() || 4 == getDefaultAFMode()) {
                m17788N();
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m17877i() {
        CameraLog.m12954a("TimeLapseProMode", "calCarTemplateExposure, iso : " + this.f16994ad + ", exposure : " + this.f16996af);
        long OplusGLSurfaceView_15 = ((long) this.f16994ad) * this.f16996af;
        if (OplusGLSurfaceView_15 >= 1300000000) {
            this.f16995ae = (int) (OplusGLSurfaceView_15 / 1300000000);
            this.f16997ag = 1300000000L;
        } else if (OplusGLSurfaceView_15 >= C1547C.NANOS_PER_SECOND) {
            this.f16995ae = (int) (OplusGLSurfaceView_15 / C1547C.NANOS_PER_SECOND);
            this.f16997ag = C1547C.NANOS_PER_SECOND;
        } else {
            this.f16995ae = (int) (OplusGLSurfaceView_15 / 500000000);
            this.f16997ag = 500000000L;
        }
        CameraLog.m12954a("TimeLapseProMode", "calCarTemplateExposure, snapIso : " + this.f16995ae + ", snapExposure : " + this.f16997ag);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void burstCapture(int OplusGLSurfaceView_13, CameraRequestTag c2693c, OneCamera.PlatformImplementations.kt_3 aVar) throws NumberFormatException {
        if (this.mbPaused || this.mbDestroyed) {
            return;
        }
        this.f17007aq = c2693c.f13384M;
        if (this.f17034x == 0) {
            synchronized (this.mApsDecisionResultLock) {
                this.f16962D = this.mDecisionResult;
            }
        }
        if (!needDelayCloseForCapture() && this.f17009as) {
            CameraLog.m12954a("TimeLapseProMode", "burstCapture, catch preview " + this.f16996af);
            this.f17009as = false;
            this.f17029s.sendEmptyMessage(108);
        }
        if (!this.mbFrontCamera) {
            if (this.f16967I != 0 && !this.f16976R.isEmpty()) {
                m17919b(this.f16976R.get(4).m17454j().get(this.f16976R.get(4).m17455k().indexOf("0.96")));
            }
            if (1 == this.f16967I) {
                m17877i();
                int i2 = this.f16995ae;
                if (i2 > 0) {
                    m17845b(String.valueOf(i2), false);
                }
                long OplusGLSurfaceView_15 = this.f16997ag;
                if (OplusGLSurfaceView_15 > 0) {
                    m17853c(String.valueOf(OplusGLSurfaceView_15), false);
                }
            }
        }
        if (this.f17025o) {
            c2693c.f13404af = this.f16960B ? -1 : this.f17034x + 1;
            this.mCameraUIInterface.mo18107a(true, false);
        }
        if (this.f16972N == 0) {
            this.f16972N = System.currentTimeMillis();
        }
        c2693c.f13403ae = true;
        c2693c.f13431z = 17;
        super.burstCapture(OplusGLSurfaceView_13, c2693c, aVar);
        if (!this.f17025o) {
            m17777C();
        }
        this.f17033w = OplusGLSurfaceView_13;
        this.f16961C = super.getCaptureRequestTag(this.f16962D, false);
        this.f16963E = aVar;
        this.mCaptureStartedCallbackNum = 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onImageReceived(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        if (cameraPictureImage == null || 17 != cameraPictureImage.getFormat()) {
            this.f16983Y = false;
            return false;
        }
        if (cameraPictureImage.getImage() == null) {
            CameraLog.m12967f("TimeLapseProMode", "onImageReceived, image.getImage() is null");
            return false;
        }
        if (this.mCameraUIInterface != null) {
            this.f17008ar = this.mCameraUIInterface.mo18207e();
        }
        if (isSloganOpen()) {
            this.f16990aF = !this.f16990aF;
        }
        CameraLog.m12954a("TimeLapseProMode", "onImageReceived, mReceivedYuvImageNum: " + this.f17035y + ", image : " + cameraPictureImage.toString() + ", mbRearMirrorEnable: " + this.f17008ar + ", mbSloganFlag: " + this.f16990aF);
        this.f16983Y = true;
        this.f16972N = 0L;
        if (this.f17025o && !this.f16990aF) {
            this.f17034x++;
            CameraLog.m12954a("TimeLapseProMode", "onImageReceived, mReceivedRawNum: " + this.f17034x + ", num: " + m17902t());
        }
        if (this.f17036z == 0 && (m17905u() || !this.f17025o)) {
            synchronized (this.f17032v) {
                this.f17035y++;
            }
            CameraLog.m12954a("TimeLapseProMode", "onImageReceived, size: " + m17865e().m17608b() + ", length: " + cameraPictureImage.getImage().length + ", width: " + cameraPictureImage.getWidth() + ", height: " + cameraPictureImage.getHeight() + ", orientation: " + cameraPictureImage.getOrientation() + ", stride: " + cameraPictureImage.getStride() + ", scanLine: " + cameraPictureImage.getScanline() + ", mReceivedYuvNumber: " + this.f17035y + ", mbShouldEncode: " + this.f16986aB);
            if (this.f16986aB) {
                m17816a(cameraPictureImage);
            }
        }
        if (this.f17025o && !this.f16990aF) {
            m17777C();
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17816a(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        long jNv21ToBitmapInit;
        int OplusGLSurfaceView_13;
        int i2;
        int i3;
        if (cameraPictureImage.getImage() == null || 17 != cameraPictureImage.getFormat()) {
            return;
        }
        int width = cameraPictureImage.getWidth();
        int height = cameraPictureImage.getHeight();
        int stride = cameraPictureImage.getStride();
        int scanline = cameraPictureImage.getScanline();
        int orientation = cameraPictureImage.getOrientation();
        byte[] image = cameraPictureImage.getImage();
        if (this.f17004an == null) {
            this.f17004an = new FormatConverter();
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        m17822a(image, this.f17035y, stride, scanline, orientation, strValueOf, "nv21");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f17007aq && this.mbFrontCamera) {
            Util.m24283a(image, width, height, stride, scanline);
            CameraLog.m12954a("TimeLapseProMode", "dealYuvByteData, mirror bitmap : " + (System.currentTimeMillis() - jCurrentTimeMillis));
        }
        if (orientation == 0 || orientation == 180) {
            if (this.f17002al == null) {
                this.f17002al = Util.m24215a(height, width, Bitmap.Config.ARGB_8888);
            }
            if (this.f17003am == null) {
                this.f17003am = Util.m24215a(height, width, Bitmap.Config.ARGB_8888);
            }
            if (!this.f17008ar) {
                jNv21ToBitmapInit = this.f17004an.nv21ToBitmapInit(width, height, stride, scanline, stride, height, width, 1.0f, 1, orientation == 0 ? 1 : 3, 0, 0, 2);
            } else {
                jNv21ToBitmapInit = this.f17004an.nv21ToBitmapInit(width, height, stride, scanline, stride, height, width, 1.0f, 1, 180 == orientation ? 1 : 3, 0, 0, 2);
            }
            long OplusGLSurfaceView_15 = jNv21ToBitmapInit;
            OplusGLSurfaceView_13 = width;
            i2 = height;
            i3 = orientation;
            this.f17004an.nv21ToBitmapProcess(OplusGLSurfaceView_15, image, 0, (isSloganOpen() && this.f16990aF) ? this.f17003am : this.f17002al, i2);
            this.f17004an.nv21ToBitmapUnInit(OplusGLSurfaceView_15);
        } else {
            if (this.f17002al == null) {
                this.f17002al = Util.m24215a(width, height, Bitmap.Config.ARGB_8888);
            }
            if (this.f17003am == null) {
                this.f17003am = Util.m24215a(width, height, Bitmap.Config.ARGB_8888);
            }
            long jNv21ToBitmapInit2 = this.f17004an.nv21ToBitmapInit(width, height, stride, scanline, stride, width, height, 1.0f, 1, (orientation != 90 ? !this.mbFrontCamera : this.mbFrontCamera) ? 2 : 0, 0, 0, 0);
            this.f17004an.nv21ToBitmapProcess(jNv21ToBitmapInit2, image, 0, (isSloganOpen() && this.f16990aF) ? this.f17003am : this.f17002al, width);
            this.f17004an.nv21ToBitmapUnInit(jNv21ToBitmapInit2);
            OplusGLSurfaceView_13 = width;
            i2 = height;
            i3 = orientation;
        }
        CameraLog.m12954a("TimeLapseProMode", "dealYuvByteData, bitmap : " + (System.currentTimeMillis() - jCurrentTimeMillis));
        if (!isSloganOpen() || (isSloganOpen() && this.f16990aF)) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            int i4 = OplusGLSurfaceView_13 * i2;
            byte[] bArr = new byte[(i4 * 3) >> 1];
            byte[] bArr2 = new byte[i4];
            FormatConverter formatConverter = this.f17004an;
            if (formatConverter != null) {
                formatConverter.argbToNv21((isSloganOpen() && this.f16990aF) ? this.f17003am : this.f17002al, bArr, bArr2, 0, true);
                Util.m24432d(bArr, OplusGLSurfaceView_13, i2);
            }
            m17822a(bArr, this.f17035y, OplusGLSurfaceView_13, i2, i3, strValueOf, "nv12");
            m17865e().m17606a(bArr);
            CameraLog.m12954a("TimeLapseProMode", "dealYuvByteData, bitmap to nv12 : " + (System.currentTimeMillis() - jCurrentTimeMillis2));
        }
        if (!isSloganOpen() || (isSloganOpen() && !this.f16990aF)) {
            m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$Z5imcVS7y4bZWt645ICpcDNgN_I
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m17840aq();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aq */
    public /* synthetic */ void m17840aq() {
        if (this.f16981W == null && this.mActivity != null) {
            m17892o();
        }
        ImageView imageView = this.f16982X;
        if (imageView != null) {
            imageView.setImageBitmap(this.f17002al);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17822a(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, String str, String str2) {
        if (this.f17000aj) {
            Util.m24250a(bArr, "capture_yuv", str + "_" + bArr.length + "_time_lapse_yuv_" + OplusGLSurfaceView_13 + "_" + i2 + "_" + i3 + "_" + i4 + "_" + str2 + ".yuv");
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m17881j() {
        Handler handler = this.f16979U;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.f16979U = null;
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m17884k() {
        Handler handler = this.f16980V;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.f16980V = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public void m17887l() throws Resources.NotFoundException {
        if (this.f17001ak == null) {
            this.f17001ak = new InverseTextView(this.mActivity);
            this.f17001ak.setTextColor(this.mActivity.getResources().getColor(R.color.camera_white));
            this.f17001ak.setText(R.string.camera_time_lapse_pro_shooting_hint);
            this.f17001ak.setTextSize(1, 12.0f);
            this.f17001ak.setGravity(17);
            Util.m24275a((TextView) this.f17001ak);
        }
        if (this.f17006ap == null) {
            this.f17006ap = new RelativeLayout.LayoutParams(-2, this.mActivity.getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_recording_shooting_hint_height));
        }
        m17889m();
        ScreenRelativeLayout screenRelativeLayout = (ScreenRelativeLayout) this.mActivity.findViewById(R.id_renamed.camera);
        if (this.f17001ak.getParent() != null) {
            ((ViewGroup) this.f17001ak.getParent()).removeView(this.f17001ak);
        }
        screenRelativeLayout.addView(this.f17001ak, this.f17006ap);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m17889m() throws Resources.NotFoundException {
        int dimensionPixelOffset;
        RelativeLayout.LayoutParams layoutParams = this.f17006ap;
        if (layoutParams != null) {
            layoutParams.addRule(14);
            BaseScreenMode currentScreenMode = getCurrentScreenMode();
            if (currentScreenMode == null) {
                this.f17006ap.topMargin = this.mActivity.getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_recording_shooting_hint_margin_top);
                return;
            }
            int iJ = currentScreenMode.mo16539j();
            if (iJ == 1) {
                RelativeLayout.LayoutParams layoutParams2 = this.f17006ap;
                if (currentScreenMode.mo16570k() == 0) {
                    dimensionPixelOffset = this.mActivity.getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_recording_shooting_hint_margin_top_full);
                } else {
                    dimensionPixelOffset = this.mActivity.getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_recording_shooting_hint_margin_top_full_90);
                }
                layoutParams2.topMargin = dimensionPixelOffset;
                return;
            }
            if (iJ == 4) {
                this.f17006ap.topMargin = this.mActivity.getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_recording_shooting_hint_margin_top_rack);
            } else {
                this.f17006ap.topMargin = this.mActivity.getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_recording_shooting_hint_margin_top);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m17891n() {
        if (this.f17001ak != null) {
            ((ScreenRelativeLayout) this.mActivity.findViewById(R.id_renamed.camera)).removeView(this.f17001ak);
            this.f17001ak = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m17892o() {
        RelativeLayout relativeLayout = (RelativeLayout) this.mActivity.findViewById(R.id_renamed.camera_root);
        this.f16981W = new RelativeLayout(this.mActivity);
        this.f16981W.setLayoutDirection(0);
        this.f16981W.setBackgroundColor(-16777216);
        this.f16982X = new ImageView(this.mActivity);
        this.f16982X.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f16982X.setBackgroundColor(-16777216);
        this.f17005ao = new RelativeLayout.LayoutParams(-2, -2);
        m17897q();
        this.f16981W.addView(this.f16982X, this.f17005ao);
        relativeLayout.addView(this.f16981W, 1, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void m17839ap() {
        if (this.f16981W == null || this.f16982X == null || getCurrentScreenMode() == null || this.f17005ao == null) {
            return;
        }
        this.f16981W.setVisibility(8);
        m17897q();
        this.f16981W.setVisibility(0);
    }

    /* renamed from: q */
    private void m17897q() {
        if (this.f17005ao == null) {
            return;
        }
        Rect rectM17898r = m17898r();
        CameraLog.m12954a("TimeLapseProMode", "addPreview, rect : " + rectM17898r + ", OplusGLSurfaceView_14: " + rectM17898r.left + ", t: " + rectM17898r.top + ", r: " + rectM17898r.right + ", IntrinsicsJvm.kt_4: " + rectM17898r.bottom);
        this.f17005ao.width = rectM17898r.width();
        this.f17005ao.height = rectM17898r.height();
        this.f17005ao.topMargin = rectM17898r.height() % 2 == 0 ? rectM17898r.top : rectM17898r.top - 1;
        RelativeLayout.LayoutParams layoutParams = this.f17005ao;
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        if (this.mbFrontCamera && m17873g()) {
            this.f17005ao.rightMargin = rectM17898r.width() - rectM17898r.right;
        } else {
            this.f17005ao.leftMargin = rectM17898r.left;
        }
    }

    /* renamed from: r */
    private Rect m17898r() {
        Size sizeM24180I = Util.m24180I();
        if (getCurrentScreenMode() != null) {
            return getCurrentScreenMode().mo16558b(sizeM24180I.getHeight(), sizeM24180I.getWidth());
        }
        int screenWidth = Util.getScreenWidth();
        int screenHeight = Util.getScreenHeight();
        int iM24426d = Util.m24426d(sizeM24180I.getWidth(), sizeM24180I.getHeight());
        float width = sizeM24180I.getWidth() / sizeM24180I.getHeight();
        if (7 == iM24426d) {
            int iRound = Math.round(screenHeight / width);
            int OplusGLSurfaceView_13 = (screenWidth - iRound) / 2;
            return new Rect(OplusGLSurfaceView_13, 0, iRound + OplusGLSurfaceView_13, screenHeight);
        }
        int iRound2 = Math.round(width * screenWidth);
        int iM16605c = ((screenHeight - iRound2) / 2) + OutScreenMode.m16605c(iM24426d);
        return new Rect(0, iM16605c, screenWidth, iRound2 + iM16605c);
    }

    /* renamed from: s */
    private void m17900s() {
        CameraLog.m12954a("TimeLapseProMode", "removePreview.");
        if (this.f16984Z != null) {
            this.f16984Z = null;
        }
        if (this.f16991aa != null) {
            this.f16991aa = null;
        }
        if (this.f16992ab != null) {
            this.f16992ab = null;
        }
        if (this.f16993ac != null) {
            this.f16993ac = null;
        }
        Bitmap bitmap = this.f17002al;
        if (bitmap != null) {
            bitmap.recycle();
            this.f17002al = null;
        }
        Bitmap bitmap2 = this.f17003am;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f17003am = null;
        }
        RelativeLayout relativeLayout = this.f16981W;
        if (relativeLayout != null) {
            ImageView imageView = this.f16982X;
            if (imageView != null) {
                relativeLayout.removeView(imageView);
                this.f16982X = null;
            }
            ((RelativeLayout) this.mActivity.findViewById(R.id_renamed.camera_root)).removeView(this.f16981W);
            this.f16981W.setVisibility(8);
            this.f16981W = null;
        }
    }

    /* renamed from: t */
    private int m17902t() {
        return super.getDefaultCaptureNumber();
    }

    /* renamed from: u */
    private boolean m17905u() {
        return this.f17034x > m17902t();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needDelayCloseForCapture() {
        if (C1547C.NANOS_PER_SECOND <= Long.parseLong(m17779E()) || this.f17025o || 1 == this.f16967I) {
            return false;
        }
        return super.needDelayCloseForCapture();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean isStarVideoOpen() {
        return this.f17025o;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m17861d(boolean z) {
        this.f17025o = z;
        this.mOneCamera.mo13097g(z);
        this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() throws NumberFormatException {
        CameraLog.m12954a("TimeLapseProMode", "onInitCameraMode, Start");
        m17918b(2);
        this.f16968J = this.mCameraUIInterface.mo18135aY();
        this.f16967I = this.mPreferences.getInt("pref_time_lapse_pro_template_key", 0);
        this.f17011au = this.f16967I == 2;
        this.f17025o = this.f16967I == 2;
        this.f17012av = false;
        TimeLapseProMenuLayout c3071g = this.f16968J;
        if (c3071g != null) {
            c3071g.setTimeLapseProMenuListener(this.f16988aD);
            this.f16968J.setChangeScreenModeListener(new TimeLapseProMenuLayout.IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$wpSx9MreC6R12QjfsCLm3q7-O5Q
                @Override // com.oplus.camera.timelapsepro.TimeLapseProMenuLayout.IntrinsicsJvm.kt_3
                public final void onChanged() {
                    this.COUIBaseListPopupWindow_12$0.m17839ap();
                }
            });
            this.f16968J.m17740a(this);
            this.f16968J.setReportCallback(this);
        }
        m17913y();
        this.mCameraUIInterface.mo18084a(this.f16989aE);
        int OplusGLSurfaceView_13 = this.f16967I;
        if (OplusGLSurfaceView_13 == 1) {
            m17859d(this.mActivity.getApplicationContext().getResources().getString(R.string.time_lapse_pro_speed_60x));
        } else if (OplusGLSurfaceView_13 == 3) {
            m17859d(this.mActivity.getApplicationContext().getResources().getString(R.string.time_lapse_pro_speed_150x));
        } else {
            m17859d("15");
        }
        this.mCameraUIInterface.mo18187c(this.mActivity.getString(R.string.camera_description_common_shutter_button));
    }

    /* renamed from: v */
    private void m17907v() {
        if (this.f17029s == null) {
            CameraLog.m12954a("TimeLapseProMode", "initTimeLapseProHandler.");
            HandlerThread handlerThread = new HandlerThread("TimeLapseProHandler");
            handlerThread.start();
            this.f17029s = new ZoomSeekBar_4(handlerThread.getLooper());
        }
    }

    /* compiled from: TimeLapseProMode.java */
    /* renamed from: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_10$3, reason: invalid class name */
    class ZoomSeekBar_4 extends Handler {
        ZoomSeekBar_4(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException, NumberFormatException {
            super.handleMessage(message);
            CameraLog.m12954a("TimeLapseProMode", "handleMessage, msg: " + message.what);
            switch (message.what) {
                case 100:
                    Float.valueOf(0.0f);
                    Float COUIBaseListPopupWindow_12 = (Float) message.obj;
                    TimeLapseProMode.this.mCameraInterface.mo10527ac();
                    if (TimeLapseProMode.this.mOneCamera != null) {
                        if (TimeLapseProMode.this.mCameraInterface.mo10596z()) {
                            TimeLapseProMode.this.mCameraInterface.mo10556b(false, false);
                        }
                        TimeLapseProMode.this.mOneCamera.mo13023a(COUIBaseListPopupWindow_12.floatValue(), true);
                        break;
                    }
                    break;
                case 101:
                    TimeLapseProMode.this.m17778D();
                    break;
                case 103:
                    TimeLapseProMode.this.m17776B();
                    break;
                case 104:
                    TimeLapseProMode.this.m17774A();
                    break;
                case 105:
                    TimeLapseProMode.this.m17915z();
                    break;
                case 106:
                    TimeLapseProMode.this.m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_10.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TimeLapseProMode.this.m17794T();
                        }
                    });
                    break;
                case 107:
                    TimeLapseProMode.this.m17858d(message.arg1);
                    break;
                case 108:
                    TimeLapseProMode.this.m17911x();
                    break;
                case 109:
                    TimeLapseProMode.this.f17018h.open();
                    break;
                case 110:
                    TimeLapseProMode.this.m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$3$u8scrOcGy2nzi6-b1-OELjeJ9A8
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.COUIBaseListPopupWindow_12$0.m17924b();
                        }
                    });
                    break;
                case 111:
                    TimeLapseProMode.this.m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$3$6dOaKlANKqe_f7ivlXruTMFLqWI
                        @Override // java.lang.Runnable
                        public final void run() throws Resources.NotFoundException {
                            this.COUIBaseListPopupWindow_12$0.m17923a();
                        }
                    });
                    break;
                case 112:
                    TimeLapseProMode.this.mCameraUIInterface.mo18070a(R.string.camera_time_lapse_pro_shooting_hint, -1, false, true, true);
                    break;
            }
            CameraLog.m12954a("TimeLapseProMode", "handleMessage X, msg: " + message.what);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_4 */
        public /* synthetic */ void m17924b() {
            TimeLapseProMode.this.m17833aj();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public /* synthetic */ void m17923a() throws Resources.NotFoundException {
            TimeLapseProMode.this.m17887l();
        }
    }

    /* renamed from: w */
    private void m17908w() {
        Handler handler = this.f17029s;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f17029s.getLooper().quitSafely();
            this.f17029s = null;
        }
    }

    /* compiled from: TimeLapseProMode.java */
    /* renamed from: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_10$4, reason: invalid class name */
    class DoubleExposureMode_3 extends SurfaceTextureScreenNail.IntrinsicsJvm.kt_4 {
        DoubleExposureMode_3() {
        }

        @Override // com.oplus.camera.p146gl.SurfaceTextureScreenNail.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo10414a(Integer num, final Bitmap bitmap, long OplusGLSurfaceView_15, long j2, CaptureResult captureResult) {
            CameraLog.m12954a("TimeLapseProMode", "onPreviewCaptured, which: " + num);
            super.mo10414a(num, bitmap, OplusGLSurfaceView_15, j2, captureResult);
            TimeLapseProMode.this.m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$4$gkSzpIWQAVEgNRsjg9J8pdvKl94
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m17925b(bitmap);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: IntrinsicsJvm.kt_4 */
        public /* synthetic */ void m17925b(Bitmap bitmap) {
            if (TimeLapseProMode.this.f16981W == null) {
                TimeLapseProMode.this.m17892o();
            }
            if (TimeLapseProMode.this.f16982X != null) {
                TimeLapseProMode.this.f16982X.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m17911x() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18088a((SurfaceTextureScreenNail.IntrinsicsJvm.kt_4) new DoubleExposureMode_3(), false, false, SurfaceTextureScreenNail.IntrinsicsJvm.kt_4.f14252c);
        }
    }

    /* renamed from: y */
    private void m17913y() throws NumberFormatException {
        if (!this.f16976R.isEmpty()) {
            Iterator<ProParameter> it = this.f16976R.iterator();
            while (it.hasNext()) {
                CameraLog.m12954a("TimeLapseProMode", "initProParams, proParameter: " + it.next().toString());
            }
            return;
        }
        OplusCameraCharacteristics cameraInfo = getCameraInfo(this.mCameraId);
        ResetParameter c3052f = new ResetParameter(this.mActivity);
        ISOParameter c3050dM17807a = m17807a(cameraInfo);
        ShutterParameter c3054hM17843b = m17843b(cameraInfo);
        ExposureParameter c3048bM17848c = m17848c(cameraInfo);
        FocusParameter c3049cM17856d = m17856d(cameraInfo);
        WhiteBalanceParameter c3058lM17864e = m17864e(cameraInfo);
        c3052f.m17447b(c3050dM17807a == null || !c3050dM17807a.m17451g() || c3054hM17843b == null || !c3054hM17843b.m17451g() || c3049cM17856d == null || !c3049cM17856d.m17451g() || c3058lM17864e == null || !c3058lM17864e.m17451g() || c3048bM17848c == null || !c3048bM17848c.mo17440d().equals(this.mActivity.getResources().getString(R.string.camera_exposure_compensation_default_value)));
        this.f16976R.add(c3052f);
        this.f16976R.add(c3050dM17807a);
        this.f16976R.add(c3054hM17843b);
        this.f16976R.add(c3048bM17848c);
        this.f16976R.add(c3049cM17856d);
        this.f16976R.add(c3058lM17864e);
        TimeLapseProMenuLayout c3071g = this.f16968J;
        if (c3071g != null) {
            c3071g.setProParameterList(this.f16976R);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ISOParameter m17807a(OplusCameraCharacteristics c2698h) {
        int iM13288w = c2698h.m13288w();
        int iM13286u = c2698h.m13286u();
        int iM13287v = c2698h.m13287v();
        if (iM13287v <= iM13286u) {
            iM13287v = iM13286u;
        }
        if (iM13287v <= 0 || iM13288w <= 0 || iM13288w == iM13287v) {
            return null;
        }
        ISOParameter c3050d = new ISOParameter(this.mActivity);
        List<String> listJ = c3050d.m17454j();
        List<String> listK = c3050d.m17455k();
        while (iM13288w <= iM13287v) {
            listJ.add(Integer.toString(iM13288w));
            listK.add(Integer.toString(iM13288w));
            iM13288w += 100;
        }
        int OplusGLSurfaceView_13 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_iso_key", -1);
        if (OplusGLSurfaceView_13 != -1) {
            c3050d.m17446a(false);
            c3050d.mo17435a(OplusGLSurfaceView_13);
        }
        CameraLog.m12954a("TimeLapseProMode", "generateISOValues, param isoParameter: " + c3050d.toString());
        return c3050d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ShutterParameter m17843b(OplusCameraCharacteristics c2698h) throws NumberFormatException {
        double IntrinsicsJvm.kt_5;
        ShutterParameter c3054h = new ShutterParameter(this.mActivity);
        long jM13290y = c2698h.m13290y();
        long jM13289x = c2698h.m13289x();
        List<Size> listM13258a = c2698h.m13258a(256);
        List<String> listJ = c3054h.m17454j();
        List<String> listK = c3054h.m17455k();
        if (listK != null && listK.size() > 0 && listJ != null && listJ.size() > 0 && Math.abs(1.0f - (m17805a(listM13258a) / Long.valueOf(BaseMode.PICTURE_SIZE_8M).longValue())) <= 0.1f) {
            listK.remove(listK.size() - 1);
            listJ.remove(listJ.size() - 1);
        }
        if (listK != null && listJ != null) {
            Iterator<String> it = listK.iterator();
            long OplusGLSurfaceView_15 = -1;
            while (it.hasNext()) {
                String[] strArrSplit = it.next().split("/");
                if (strArrSplit.length > 1) {
                    IntrinsicsJvm.kt_5 = Double.parseDouble(strArrSplit[0]) / Double.parseDouble(strArrSplit[1].split("s")[0]);
                } else {
                    if (strArrSplit.length == 1) {
                        IntrinsicsJvm.kt_5 = Double.parseDouble(strArrSplit[0].split("s")[0]);
                    }
                    if (OplusGLSurfaceView_15 >= jM13290y || OplusGLSurfaceView_15 > jM13289x) {
                        it.remove();
                    } else {
                        listJ.add(String.valueOf(OplusGLSurfaceView_15));
                    }
                }
                OplusGLSurfaceView_15 = (long) (IntrinsicsJvm.kt_5 * 1.0E9d);
                if (OplusGLSurfaceView_15 >= jM13290y) {
                }
                it.remove();
            }
            long j2 = Long.parseLong(listJ.get(listJ.size() - 1)) / C1547C.NANOS_PER_SECOND;
            long j3 = jM13289x / C1547C.NANOS_PER_SECOND;
            if (j2 < j3) {
                listJ.add(String.valueOf(jM13289x));
                listK.add(j3 + "s");
            }
        }
        int OplusGLSurfaceView_13 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_exposure_time_key", -1);
        if (OplusGLSurfaceView_13 != -1) {
            c3054h.m17446a(false);
            c3054h.mo17435a(OplusGLSurfaceView_13);
        }
        CameraLog.m12954a("TimeLapseProMode", "generateShutterParameter, param shutterParameter: " + c3054h.toString());
        return c3054h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private long m17805a(List<Size> list) {
        long width = 0;
        for (Size size : list) {
            if (size.getWidth() * size.getHeight() > width) {
                width = size.getWidth() * size.getHeight();
            }
        }
        CameraLog.m12954a("TimeLapseProMode", "getMaxPictureSize, max: " + width);
        return width;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ExposureParameter m17848c(OplusCameraCharacteristics c2698h) {
        int iM13281p = c2698h.m13281p();
        int iM13282q = c2698h.m13282q();
        float fM13283r = c2698h.m13283r();
        if ((iM13281p == -1 && iM13282q == -1) || iM13281p > iM13282q || Float.compare(fM13283r, 0.0f) == 0) {
            CameraLog.m12967f("TimeLapseProMode", "generateExposureCompensationValues, return, minIndex: " + iM13281p + ", maxIndex: " + iM13282q);
            return null;
        }
        ExposureParameter c3048b = new ExposureParameter(this.mActivity);
        int size = 0;
        while (iM13281p <= iM13282q) {
            c3048b.m17454j().add(String.valueOf(iM13281p));
            String strM17916a = m17916a(iM13281p, fM13283r);
            if (strM17916a.equals("0.00")) {
                size = c3048b.m17454j().size() - 1;
            }
            c3048b.m17455k().add(strM17916a);
            iM13281p++;
        }
        int OplusGLSurfaceView_13 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_exposure_compensation_key", size);
        TimeLapseProConstant.f16844a = OplusGLSurfaceView_13;
        c3048b.mo17435a(OplusGLSurfaceView_13);
        CameraLog.m12954a("TimeLapseProMode", "generateExposureParameter, param exposureParameter: " + c3048b.toString());
        return c3048b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m17916a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        float f2 = OplusGLSurfaceView_13 * COUIBaseListPopupWindow_12;
        if (f2 <= 0.0f) {
            return String.format(Locale.US, "%.2f", Float.valueOf(f2));
        }
        return "+" + String.format(Locale.US, "%.2f", Float.valueOf(f2));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private FocusParameter m17856d(OplusCameraCharacteristics c2698h) {
        float fM13279n = c2698h.m13279n();
        float fM13278m = c2698h.m13278m();
        if (fM13279n >= fM13278m) {
            fM13279n = fM13278m;
            fM13278m = fM13279n;
        }
        if (Float.compare(fM13278m, 0.0f) <= 0.0f || Float.compare(fM13278m, fM13279n) == 0) {
            CameraLog.m12967f("TimeLapseProMode", "generateFocusValues, return, minFocusDistance: " + fM13278m);
            return null;
        }
        float COUIBaseListPopupWindow_12 = (fM13278m - fM13279n) / 50.0f;
        CameraLog.m12954a("TimeLapseProMode", "generateFocusValues, farFocusDistance: " + fM13279n + ", minFocusDistance: " + fM13278m);
        FocusParameter c3049c = new FocusParameter(this.mActivity);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 <= 50; OplusGLSurfaceView_13++) {
            float f2 = OplusGLSurfaceView_13;
            c3049c.m17454j().add(Float.toString(fM13278m - (COUIBaseListPopupWindow_12 * f2)));
            c3049c.m17455k().add(String.format(Locale.US, "%.2f", Float.valueOf(f2 * 0.02f)));
        }
        int i2 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_focus_mode_key", -1);
        if (i2 != -1) {
            c3049c.m17446a(false);
            c3049c.mo17435a(i2);
        }
        CameraLog.m12954a("TimeLapseProMode", "generateFocusParameter, param focusParameter: " + c3049c.toString());
        return c3049c;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private WhiteBalanceParameter m17864e(OplusCameraCharacteristics c2698h) {
        List<Integer> listM13245B = c2698h.m13245B();
        if (listM13245B == null || listM13245B.size() <= 0) {
            CameraLog.m12967f("TimeLapseProMode", "generateWhiteBalanceValues, return, range: " + listM13245B);
            return null;
        }
        WhiteBalanceParameter c3058l = new WhiteBalanceParameter(this.mActivity);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < listM13245B.size(); OplusGLSurfaceView_13++) {
            int iIntValue = listM13245B.get(OplusGLSurfaceView_13).intValue();
            c3058l.m17454j().add(Integer.toString(iIntValue));
            c3058l.m17455k().add(iIntValue + OplusExifInterface.GpsSpeedRef.KILOMETERS);
        }
        int i2 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_whitebalance_key", -1);
        if (i2 != -1) {
            c3058l.m17446a(false);
            c3058l.mo17435a(i2);
        }
        CameraLog.m12954a("TimeLapseProMode", "generateWhiteBalanceParameter, param whiteBalanceParameter: " + c3058l.toString());
        return c3058l;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSessionConfigured() {
        Handler handler;
        super.onSessionConfigured();
        CameraLog.m12954a("TimeLapseProMode", "onSessionConfigured, mbHaveStopRecord: " + this.f16977S);
        m17907v();
        if (!this.mbFrontCamera && this.f16978T) {
            this.f16978T = false;
            m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$yYYb166yUrkeI7C0hNnTgPxTm-IntrinsicsJvm.kt_3
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m17838ao();
                }
            });
        } else if (this.f16977S && (handler = this.f17029s) != null) {
            handler.sendEmptyMessageDelayed(106, 500L);
        }
        if (this.f16967I != 0 && !this.f16976R.isEmpty() && this.f17029s != null) {
            m17919b(this.f16976R.get(4).m17454j().get(this.f16976R.get(4).m17455k().indexOf("0.96")));
        }
        this.f16983Y = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ao */
    public /* synthetic */ void m17838ao() {
        m17820a(true, true, false);
        m17847b(true, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m17915z() {
        m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$_yh0yvHOmBmPyCFtQSzNbCyIz-Q
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m17837an();
            }
        });
        Handler handler = this.f17029s;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(105, 81L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: an */
    public /* synthetic */ void m17837an() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f16959A;
        this.f16974P = jCurrentTimeMillis;
        if (this.f17021k > 0) {
            long OplusGLSurfaceView_15 = this.f17022l - jCurrentTimeMillis;
            CameraLog.m12954a("TimeLapseProMode", "updateRecordingTime, recordTime: " + OplusGLSurfaceView_15);
            jCurrentTimeMillis = OplusGLSurfaceView_15 < 0 ? 0L : OplusGLSurfaceView_15;
        }
        long j2 = jCurrentTimeMillis;
        this.f16973O = j2;
        this.f16975Q = ((isSloganOpen() ? this.f17035y >> 1 : this.f17035y) * 1000) / m17865e().m17610c();
        this.mCameraUIInterface.mo18080a(j2, this.f16975Q, this.f16965G);
        this.f16964F++;
        this.f16964F %= 6;
        if (this.f16964F == 0) {
            this.f16965G = !this.f16965G;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m17774A() throws Resources.NotFoundException {
        CameraLog.m12954a("TimeLapseProMode", "onStopRecordingMsg, Begin, mbPaused: " + this.mbPaused);
        Handler handler = this.f17029s;
        if (handler != null) {
            handler.removeMessages(105);
            this.f17029s.removeMessages(102);
            this.f17029s.removeMessages(111);
            this.f17029s.removeMessages(112);
        }
        m17918b(3);
        if (!this.mbPaused) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$D-qXchdN3e1Ui40DgsuuY-etDps
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m17836am();
                }
            });
            pictureTakenCallback(null, 0, 0, null, false, false, 0L, 0);
        }
        if (m17865e().m17607a(true)) {
            m17808a(this.f16974P, this.f16975Q);
        }
        m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$QGkaXZVl9eBYXOF5FsYnclyKk0k
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m17835al();
            }
        });
        this.f17034x = 0;
        this.f16975Q = 0L;
        this.f17009as = true;
        m17918b(2);
        Handler handler2 = this.f17029s;
        if (handler2 != null) {
            handler2.sendEmptyMessageDelayed(109, 50L);
        } else {
            this.f17018h.open();
        }
        CameraLog.m12962c("TimeLapseProMode", "onStopRecordingMsg, End");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: am */
    public /* synthetic */ void m17836am() {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10508aJ();
            m17885k(true);
            this.mCameraInterface.mo10465U();
        }
        m17891n();
        if (this.f16967I == 0) {
            this.mCameraUIInterface.mo18067a(R.string.camera_time_lapse_pro_shooting_hint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: al */
    public /* synthetic */ void m17835al() {
        this.mCameraUIInterface.mo18044L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public void m17776B() {
        CameraLog.m12962c("TimeLapseProMode", "onStartRecordingMsg, Begin");
        if (!this.mbPaused && !this.mbDestroyed) {
            m17865e().m17609b(isStarVideoOpen());
            m17865e().m17603a();
            m17865e().m17612d(this.mbFrontCamera);
            m17907v();
            Handler handler = this.f17029s;
            if (handler != null) {
                handler.removeMessages(105);
                this.f17029s.sendEmptyMessageDelayed(105, 81L);
                this.f17029s.removeMessages(102);
                this.f17029s.sendEmptyMessageDelayed(102, 300000L);
            }
            this.f16973O = 0L;
            m17918b(0);
            if (this.mActivity != null) {
                this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$sQ-5hVbjJp12r9LYD-Y4gFSm3Gk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m17834ak();
                    }
                });
            }
        }
        CameraLog.m12962c("TimeLapseProMode", "onStartRecordingMsg, End");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ak */
    public /* synthetic */ void m17834ak() {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10566e(false);
        }
    }

    /* renamed from: C */
    private void m17777C() {
        Handler handler;
        CameraLog.m12962c("TimeLapseProMode", "trySendRepeatBurstCaptureMessage, mbPaused: " + this.mbPaused + ", isVideoRecordStop(): " + m17785K() + ", mbLastCaptureRequest: " + this.f16960B + ", mDelayCap: " + this.f17020j + ", mbStarVideoEnable: " + this.f17025o);
        if (!this.mbPaused && !m17785K() && !this.f16960B && (handler = this.f17029s) != null) {
            if (!this.f17025o) {
                if (this.f17021k > 0) {
                    if (this.f17035y >= (isSloganOpen() ? (this.f17021k - 1) * 2 : this.f17021k - 1)) {
                        this.f17029s.sendEmptyMessageDelayed(110, this.mbFrontCamera ? 500L : this.f17020j);
                        return;
                    }
                }
                this.f17029s.sendEmptyMessageDelayed(101, this.mbFrontCamera ? 500L : this.f17020j);
                return;
            }
            handler.sendEmptyMessage(101);
            return;
        }
        m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$2_omIdGNUHJS42LA31tr9SDdbHo
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m17833aj();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m17778D() throws NumberFormatException {
        int OplusGLSurfaceView_13 = this.f17026p;
        if (OplusGLSurfaceView_13 > 0) {
            m17850c(OplusGLSurfaceView_13);
        }
        CameraRequestTag c2693c = this.f16961C;
        if (c2693c != null) {
            burstCapture(this.f17033w, c2693c, this.f16963E);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public MainShutterButtonInfo getShutterButtonInfo() {
        MainShutterButtonInfo shutterButtonInfo = super.getShutterButtonInfo();
        if (isVideoRecording()) {
            shutterButtonInfo.m19226a(5);
            shutterButtonInfo.m19227a("button_color_inside_none");
            shutterButtonInfo.m19230b(1);
        } else {
            shutterButtonInfo.m19227a("button_color_inside_red");
        }
        shutterButtonInfo.m19235c("button_shape_dial_rotate");
        return shutterButtonInfo;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        if (m17865e() != null) {
            return m17865e().m17608b();
        }
        return super.getPictureSize(c2698h);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
        if ("type_still_capture_jpeg".equals(str)) {
            return !AlgoSwitchConfig.getSupportApsCapture();
        }
        if ("type_reprocess_data_yuv".equals(str)) {
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SURPERNIGHT_REPROCESS_EXTRA_YUV) && !this.mbFrontCamera;
        }
        if ("type_video".equals(str)) {
            return true;
        }
        if ("type_video_frame".equals(str)) {
            return getSupportFunction(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION) && isSloganOpen();
        }
        if ("type_capture".equals(str)) {
            return true;
        }
        return super.needSurface(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult, CameraRequestTag c2693c) throws NumberFormatException {
        Object obj;
        if (Util.m24169C()) {
            obj = CameraMetadataKey.f13255U;
        } else {
            obj = CameraMetadataKey.f13257W;
        }
        this.f17013aw = ((float[]) cameraCaptureResult.getCaptureResult().get(obj))[0];
        CameraLog.m12954a("TimeLapseProMode", "onCaptureCompleted, luxKey: " + this.f17013aw);
        if (this.f17025o) {
            try {
                Integer num = (Integer) cameraCaptureResult.getCaptureResult().get(CameraMetadataKey.f13319bE);
                this.f16986aB = num.intValue() == c2693c.f13404af - 1;
                CameraLog.m12954a("TimeLapseProMode", "onCaptureCompleted, resultFrameFlag: " + num + ", requestFrameFlag: " + c2693c.f13404af);
            } catch (Exception unused) {
                CameraLog.m12954a("TimeLapseProMode", "onCaptureCompleted, do not have CameraMetadataKey.KEY_STAR_MODE_FRAME_FLAG");
            }
        }
        if (isVideoRecordStarted() && 1 == this.f16967I && this.f17013aw < 410.0f && !this.f17012av) {
            this.f17012av = true;
            this.mCameraUIInterface.mo18074a(R.string.camera_time_lapse_pro_over_bright_hint, 5000, new Object[0]);
        }
        if (this.mOneCamera != null && this.f17025o) {
            this.mOneCamera.mo13091f(c2693c.f13404af);
        }
        if (this.mOneCamera != null && 1 == this.f16967I) {
            m17845b((String) null, false);
            m17853c(this.mActivity.getResources().getString(R.string.camera_exposure_time_default_value), true);
        }
        super.onCaptureCompleted(cameraCaptureResult, c2693c);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected boolean m17921c() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PROFESSIONAL_MUTEX_ZOOM_SUPPORT);
    }

    /* renamed from: E */
    private String m17779E() {
        return this.mPreferences == null ? "-1" : this.mPreferences.getString("pref_time_lapse_pro_exposure_time_key", "-1");
    }

    /* renamed from: F */
    private long m17780F() {
        return Long.parseLong(this.mPreferences.getString("pref_time_lapse_pro_exposure_time_key", this.mActivity.getResources().getString(R.string.camera_exposure_time_default_value)));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getCaptureIso() {
        String string = this.mPreferences.getString("pref_time_lapse_pro_iso_key", this.mActivity.getResources().getString(R.string.camera_iso_default_value));
        if (this.mActivity.getResources().getString(R.string.camera_iso_default_value).equals(string)) {
            return this.f17027q;
        }
        return Integer.parseInt(string);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public long getCaptureExposureTime() throws NumberFormatException {
        long OplusGLSurfaceView_15 = Long.parseLong(m17779E());
        return -1 == OplusGLSurfaceView_15 ? this.f17028r : OplusGLSurfaceView_15;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback.CameraPreviewResult r9) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.timelapsepro.TimeLapseProMode.onPreviewCaptureResult(com.oplus.ocs.camera.CameraPreviewCallback$CameraPreviewResult):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m17802a(int OplusGLSurfaceView_13, List<String> list) {
        if (list == null || list.size() <= 0) {
            return -1;
        }
        int iAbs = Math.abs(Integer.parseInt(list.get(0)) - OplusGLSurfaceView_13);
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int i4 = Integer.parseInt(list.get(i3)) - OplusGLSurfaceView_13;
            if (Math.abs(i4) < iAbs) {
                iAbs = Math.abs(i4);
                i2 = i3;
            }
        }
        return i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m17803a(long OplusGLSurfaceView_15, List<String> list) {
        if (list == null || list.size() <= 0) {
            return -1;
        }
        long jAbs = Math.abs(Long.parseLong(list.get(0)) - OplusGLSurfaceView_15);
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            long j2 = Long.parseLong(list.get(i2)) - OplusGLSurfaceView_15;
            if (Math.abs(j2) < jAbs) {
                jAbs = Math.abs(j2);
                OplusGLSurfaceView_13 = i2;
            }
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m17801a(float COUIBaseListPopupWindow_12, List<String> list) {
        if (list == null || list.size() <= 0) {
            return -1;
        }
        float fAbs = Math.abs(Float.parseFloat(list.get(0)) - COUIBaseListPopupWindow_12);
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            float f2 = Float.parseFloat(list.get(i2)) - COUIBaseListPopupWindow_12;
            if (Math.abs(f2) < fAbs) {
                fAbs = Math.abs(f2);
                OplusGLSurfaceView_13 = i2;
            }
        }
        return OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAutoFocus() {
        return TextUtils.equals(this.mPreferences.getString("pref_time_lapse_pro_focus_mode_key", this.mActivity.getString(R.string.camera_focus_mode_default_value)), this.mActivity.getString(R.string.camera_focus_mode_default_value));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0103  */
    @Override // com.oplus.camera.capmode.BaseMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean getSupportFunction(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.timelapsepro.TimeLapseProMode.getSupportFunction(java.lang.String):boolean");
    }

    /* renamed from: G */
    private void m17781G() throws Resources.NotFoundException, NumberFormatException {
        if (this.mOneCamera != null) {
            String string = this.mActivity.getApplicationContext().getResources().getString(R.string.camera_whitebalance_default_value);
            if (this.mPreferences.getString("pref_time_lapse_pro_whitebalance_key", string).equals(string)) {
                m17920b(false);
            } else {
                m17875h(false);
            }
            m17919b((String) null);
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(m17922d()));
            m17845b((String) null, false);
            m17879i(false);
        }
        TimeLapseProMenuLayout c3071g = this.f16968J;
        if (c3071g != null) {
            int OplusGLSurfaceView_13 = this.f16967I;
            if (OplusGLSurfaceView_13 == 0) {
                String strM17749g = c3071g.m17749g();
                m17859d(strM17749g);
                this.f16968J.m17742a(strM17749g);
            } else if (OplusGLSurfaceView_13 == 1) {
                m17859d(this.mActivity.getApplicationContext().getResources().getString(R.string.time_lapse_pro_speed_60x));
            } else if (OplusGLSurfaceView_13 == 3) {
                m17859d(this.mActivity.getApplicationContext().getResources().getString(R.string.time_lapse_pro_speed_150x));
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m17867e(boolean z) throws NumberFormatException {
        m17869f(z);
        this.mPreferences.edit().remove("pref_time_lapse_pro_template_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_sub_setting_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_speed_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_duration_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_iso_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_exposure_time_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_exposure_compensation_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_focus_mode_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_whitebalance_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_index_of_iso_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_index_of_exposure_time_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_index_of_exposure_compensation_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_index_of_focus_mode_key").apply();
        this.mPreferences.edit().remove("pref_time_lapse_pro_index_of_whitebalance_key").apply();
        this.mPreferences.edit().remove(CameraUIInterface.KEY_RESTORE_TIMELAPSE_PRO_PARAMS).apply();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m17869f(boolean z) throws NumberFormatException {
        if (this.mOneCamera == null) {
            return;
        }
        this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_SCENE_MODE, (CaptureRequest.Key) 0);
        m17845b(this.mActivity.getResources().getString(R.string.camera_iso_default_value), false);
        long OplusGLSurfaceView_15 = Long.parseLong(this.mActivity.getResources().getString(R.string.camera_exposure_time_default_value));
        this.mOneCamera.mo13030a(OplusGLSurfaceView_15);
        this.mOneCamera.mo13031a(OplusGLSurfaceView_15, false);
        m17790P();
        this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(m17922d()));
        this.mOneCamera.mo13103i(false);
        if (z) {
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        m17789O();
        m17791Q();
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_10.5
            @Override // java.lang.Runnable
            public void run() {
                TimeLapseProMode.this.m17788N();
            }
        });
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getZoomBarOffset() {
        return super.getZoomBarOffset();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        CameraLog.m12962c("TimeLapseProMode", "onBackPressed, mbInCapturing: " + this.mbInCapturing);
        if (isVideoRecording()) {
            m17833aj();
            return true;
        }
        TimeLapseProMenuLayout c3071g = this.f16968J;
        if (c3071g != null && c3071g.getVisibility() == 0) {
            m17854c(this.f16968J.m17745c());
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureSequenceCompleted() {
        super.onCaptureSequenceCompleted();
        CameraLog.m12962c("TimeLapseProMode", "onCaptureSequenceCompleted");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        if (2 != this.mCameraInterface.mo10570g()) {
            CameraLog.m12967f("TimeLapseProMode", "onStopTakePicture failed, current camera state is " + this.mCameraInterface.mo10570g());
            return false;
        }
        this.mbInCapturing = false;
        setCapturePreviewDataState(2);
        this.mCameraInterface.mo10569f(true);
        this.mCameraUIInterface.mo18107a(true, false);
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDeInitCameraMode(String str) {
        CameraLog.m12962c("TimeLapseProMode", "onDeInitCameraMode");
        m17900s();
        TimeLapseProMenuLayout c3071g = this.f16968J;
        if (c3071g != null) {
            c3071g.setTimeLapseProMenuListener(null);
            this.f16968J.setChangeScreenModeListener(null);
            this.f16968J.m17744b(this);
            this.f16968J.setReportCallback(null);
        }
        if (m17787M()) {
            this.mCameraUIInterface.mo18282w(true);
        }
        m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$TAXae6jkOmRWsPCwHOkTHXkNnXs
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m17832ai();
            }
        });
        if (m17865e() != null) {
            m17865e().m17607a(false);
        }
        m17891n();
        this.f17001ak = null;
        m17860d("0", false);
        if (this.f17023m != null) {
            this.f17023m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ai */
    public /* synthetic */ void m17832ai() {
        this.mCameraUIInterface.mo18136aZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17817a(Runnable runnable) {
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(runnable);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuExpand() {
        super.onZoomMenuExpand();
        if (this.mbFrontCamera) {
            return;
        }
        m17820a(false, true, true);
        m17847b(false, true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onZoomMenuCollapsing() {
        super.onZoomMenuCollapsing();
        if (this.mbFrontCamera) {
            return;
        }
        m17820a(true, true, true);
        m17847b(true, true, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        CameraLog.m12962c("TimeLapseProMode", "onBeforeSnapping, mRecorderStatus: " + this.f17036z);
        if (this.mCameraInterface.mo10450F()) {
            CameraLog.m12954a("TimeLapseProMode", "onBeforeSnapping, being capture mode change!");
            return false;
        }
        if (Storage.f12097w != 0) {
            m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$aZCQ_5ZrV5RsebWv_dfkDQhnwww
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m17831ah();
                }
            });
            return false;
        }
        if (!isVideoRecording() && !this.mCameraInterface.mo10460P()) {
            CameraLog.m12966e("TimeLapseProMode", "onBeforeSnapping, memory or storage is not enough.");
            m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$gVCRx2a1AxDvgM5yPD9nqENKKlU
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m17830ag();
                }
            });
            m17852c(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_MEMORY_CAPTURE);
            return false;
        }
        if (isVideoRecordStarting()) {
            CameraLog.m12966e("TimeLapseProMode", "onBeforeSnapping onVideoShutterButtonClick, starting or error processing ");
            return false;
        }
        if (m17800Z()) {
            return false;
        }
        setCaptureRequestPictureSizeScale();
        if (this.f16967I == 0 && "auto".equals(this.f16998ah)) {
            m17919b(String.valueOf(this.f16999ai));
        }
        this.f17018h.close();
        return m17782H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ah */
    public /* synthetic */ void m17831ah() {
        this.mCameraUIInterface.mo18269t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ag */
    public /* synthetic */ void m17830ag() {
        this.mCameraUIInterface.mo18070a(R.string.camera_toast_camera_Low_memory_hint, -1, true, false, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void updateCaptureParam(CameraRequestTag c2693c) throws Resources.NotFoundException {
        super.updateCaptureParam(c2693c);
        this.mOneCamera.mo13089e(true);
    }

    /* renamed from: H */
    private boolean m17782H() {
        CameraLog.m12962c("TimeLapseProMode", "startRecording, mRecorderStatus: " + this.f17036z);
        if (Camera.f10610l) {
            m17786L();
            return false;
        }
        if (2 != this.f17036z) {
            return false;
        }
        m17918b(1);
        this.f17018h.close();
        this.f16998ah = this.mPreferences.getString("pref_time_lapse_pro_focus_mode_key", this.mActivity.getString(R.string.camera_focus_mode_default_value));
        synchronized (this.f17032v) {
            this.f17035y = 0;
        }
        this.f16990aF = isSloganOpen();
        this.f16959A = System.currentTimeMillis();
        m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$sEhwRZ2hZz3W7b-3_RWH9jBE09M
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.COUIBaseListPopupWindow_12$0.m17829af();
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: af */
    public /* synthetic */ void m17829af() throws Resources.NotFoundException {
        if (this.mCameraInterface != null) {
            m17783I();
        }
        if (this.f16967I == 0) {
            TimeLapseProMenuLayout c3071g = this.f16968J;
            if (c3071g != null && this.f17029s != null) {
                if (c3071g.m17748f()) {
                    if (this.f16968J.isShown()) {
                        this.f17029s.sendEmptyMessage(112);
                    } else {
                        this.f17029s.sendEmptyMessageDelayed(112, 3000L);
                    }
                } else if (this.f16968J.isShown()) {
                    this.f17029s.sendEmptyMessageDelayed(111, 1000L);
                } else {
                    this.f17029s.sendEmptyMessageDelayed(111, 1000L);
                }
            } else {
                this.mCameraUIInterface.mo18070a(R.string.camera_time_lapse_pro_shooting_hint, -1, false, true, true);
            }
        } else {
            m17887l();
        }
        this.mCameraUIInterface.mo18200d(true, false);
        this.mCameraUIInterface.mo18136aZ();
        this.f17034x = 0;
        this.f16960B = false;
        Handler handler = this.f17029s;
        if (handler != null) {
            handler.removeMessages(103);
            this.f17029s.sendEmptyMessage(103);
        }
        this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) true);
    }

    /* renamed from: I */
    private void m17783I() {
        this.mCameraInterface.mo10455K();
        this.mCameraInterface.mo10507aI();
        m17798X();
        m17799Y();
        m17820a(false, true, !m17876h());
        m17847b(false, true, !m17876h());
        this.mCameraUIInterface.mo18050O(true);
        this.mCameraUIInterface.mo18276u(true, true);
        m17865e().m17604a(this.mCameraId);
        this.mCameraInterface.mo10558c(4);
        this.mCameraInterface.mo10456L();
        this.mCameraInterface.mo10488a("normal");
        this.f16969K = this.f16967I != 0;
    }

    /* renamed from: J */
    private void m17784J() {
        CameraLog.m12962c("TimeLapseProMode", "stopRecording, mRecorderStatus: " + this.f17036z);
        Handler handler = this.f17029s;
        if (handler != null) {
            handler.removeMessages(101);
        }
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10558c(5);
        }
        if (m17785K()) {
            return;
        }
        this.f16977S = true;
        this.f17012av = false;
        m17850c(0);
        this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) false);
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10467W();
        }
        m17918b(3);
        if (this.mActivity.getResources().getString(R.string.camera_focus_mode_default_value).equals(this.f16998ah)) {
            m17919b(this.f16998ah);
        }
        Handler handler2 = this.f17029s;
        if (handler2 != null) {
            handler2.sendEmptyMessage(104);
        }
    }

    /* renamed from: K */
    private boolean m17785K() {
        return 3 == this.f17036z || 2 == this.f17036z;
    }

    /* renamed from: L */
    private void m17786L() {
        CameraLog.m12962c("TimeLapseProMode", "showLowBatteryHint");
        if (this.mbPaused || this.mActivity == null) {
            return;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$jN7NkrjgkS7ZaKFUTdxmUe8HNyg
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m17828ae();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ae */
    public /* synthetic */ void m17828ae() {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18070a(R.string.camera_time_lapse_pro_low_battery_hint, -1, true, false, false);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m17850c(int OplusGLSurfaceView_13) {
        if (this.mOneCamera == null) {
            return;
        }
        CameraLog.m12962c("TimeLapseProMode", "setNightMode, nightMode: " + OplusGLSurfaceView_13);
        this.mOneCamera.mo13120o(OplusGLSurfaceView_13);
        this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        CameraLog.m12954a("TimeLapseProMode", "onAfterSnapping");
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onShutterCallback(boolean z, boolean z2) {
        super.onShutterCallback(z, z2);
    }

    @Override // com.oplus.camera.capmode.BaseMode, com.oplus.camera.p141e.OneCamera.PlatformImplementations.kt_3
    public void onCaptureFailed(CaptureRequest captureRequest, CameraRequestTag c2693c) {
        super.onCaptureFailed(captureRequest, c2693c);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z) {
        CameraLog.m12962c("TimeLapseProMode", "onBeforePictureTaken");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        CameraLog.m12954a("TimeLapseProMode", "onAfterPictureTaken");
        this.mCameraUIInterface.mo18200d(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setCameraId(int OplusGLSurfaceView_13) {
        super.setCameraId(OplusGLSurfaceView_13);
        m17865e().m17611c(this.mbFrontCamera);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int OplusGLSurfaceView_13) {
        super.cameraIdChanged(OplusGLSurfaceView_13);
        this.f17010at = true;
        m17865e().m17611c(this.mbFrontCamera);
    }

    /* renamed from: M */
    private boolean m17787M() {
        if (this.mPreferences != null) {
            return "camera_macro".equals(this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main"));
        }
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) {
        if (this.mOrientation == OplusGLSurfaceView_13) {
            return;
        }
        this.mOrientation = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        CameraLog.m12954a("TimeLapseProMode", "onResume");
        this.f17018h.close();
        this.mCameraUIInterface.mo18084a(this.f16989aE);
        this.mCameraUIInterface.mo18036H();
        if (this.f16970L) {
            this.f16970L = false;
            this.mCameraInterface.mo10467W();
        }
        m17907v();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        CameraLog.m12954a("TimeLapseProMode", "onPause");
        this.f16970L = this.f16967I != 0;
        TimeLapseProMenuLayout c3071g = this.f16968J;
        if (c3071g != null) {
            if (c3071g.isShown()) {
                m17821a(false, this.f16968J.m17745c(), true, true, true);
                this.mCameraUIInterface.mo18054Q(false);
            }
            this.f16968J.m17753k();
        }
        if (isVideoRecording()) {
            this.mCameraUIInterface.mo18276u(false, false);
        }
        forceStopVideoRecording(false);
        this.mCameraUIInterface.mo18200d(true, false);
        m17908w();
        m17881j();
        m17884k();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        CameraLog.m12954a("TimeLapseProMode", "onDestroy, " + m17866e(this.f17036z));
        m17900s();
        m17891n();
        TimeLapseProMenuLayout c3071g = this.f16968J;
        if (c3071g != null) {
            c3071g.setTimeLapseProMenuListener(null);
            this.f16968J.setChangeScreenModeListener(null);
            this.f16968J.m17744b(this);
            this.f16968J.setReportCallback(null);
            this.f16968J = null;
        }
        if (this.f17023m != null) {
            this.f17023m = null;
        }
        if (!this.f16987aC.isEmpty()) {
            Iterator<String> it = this.f16987aC.keySet().iterator();
            while (it.hasNext()) {
                TimeLapseProMsgData timeLapseProMsgData = this.f16987aC.get(it.next());
                if (timeLapseProMsgData != null) {
                    timeLapseProMsgData.destroy();
                }
            }
            this.f16987aC.clear();
        }
        if (isVideoRecordStopped()) {
            return;
        }
        CameraLog.m12962c("TimeLapseProMode", "onDestroy, block");
        this.f17018h.block(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        CameraLog.m12959b("TimeLapseProMode", "onAfterStartPreview");
        if (m17787M()) {
            this.mCameraUIInterface.mo18166b(R.string.camera_macro_best_focus_distance_text, 0, R.color.screen_hint_text_color, Integer.valueOf(CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MACRO_BEST_FOCUS_DISTANCE)));
        }
        m17795U();
        super.onAfterStartPreview(z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() throws Resources.NotFoundException, NumberFormatException {
        CameraLog.m12954a("TimeLapseProMode", "onBeforePreview, mbCapModeInit: " + this.mbCapModeInit);
        m17865e().m17604a(this.mCameraId);
        this.mOneCamera.mo13040a((CameraParameter.PreviewKey<CameraParameter.PreviewKey<Float>>) CameraParameter.ZOOM_RATIO, (CameraParameter.PreviewKey<Float>) Float.valueOf(this.mCameraInterface.mo10535ak()));
        if (this.mbFrontCamera) {
            m17869f(true);
            return;
        }
        if (this.mPreferences.getBoolean(CameraUIInterface.KEY_RESTORE_TIMELAPSE_PRO_PARAMS, false)) {
            CameraLog.m12954a("TimeLapseProMode", "onBeforePreview, initParamToAuto");
            m17867e(false);
            m17872g(true);
        } else {
            if (this.mbCapModeInit) {
                m17872g(this.f17010at);
                if (this.f17010at) {
                    this.f17010at = false;
                }
                m17781G();
            }
            m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$QAMmyZjm275QCBmT4EdCooYwk-COUIBaseListPopupWindow_11
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m17827ad();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ad */
    public /* synthetic */ void m17827ad() {
        this.mCameraUIInterface.mo18276u(false, true);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m17872g(boolean z) {
        CameraLog.m12954a("TimeLapseProMode", "initLayoutFromPreference, haveReset: " + z);
        TimeLapseProMenuLayout c3071g = this.f16968J;
        if (c3071g != null) {
            c3071g.m17738a();
            if (z) {
                m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$t76MbWmJDeUyjoPaATqYmTZAXkw
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m17826ac();
                    }
                });
            }
            this.f16967I = this.mPreferences.getInt("pref_time_lapse_pro_template_key", 0);
            if (this.f16967I != 0) {
                this.f16968J.m17754l();
            }
            int OplusGLSurfaceView_13 = this.f16967I;
            if (OplusGLSurfaceView_13 == 1) {
                m17859d(this.mActivity.getApplicationContext().getResources().getString(R.string.time_lapse_pro_speed_60x));
            } else if (OplusGLSurfaceView_13 == 3) {
                m17859d(this.mActivity.getApplicationContext().getResources().getString(R.string.time_lapse_pro_speed_150x));
            } else {
                m17859d("15");
                this.f16968J.m17742a("15");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ac */
    public /* synthetic */ void m17826ac() {
        this.f16968J.m17743b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public void m17788N() {
        if (this.f16976R.isEmpty()) {
            return;
        }
        try {
            if (((FocusParameter) this.f16976R.get(4)).m17451g() || this.f16968J == null) {
                return;
            }
            this.f16968J.m17758p();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m17875h(boolean z) {
        m17818a(this.mPreferences.getString("pref_time_lapse_pro_whitebalance_key", this.mActivity.getResources().getString(R.string.camera_whitebalance_default_value)), z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17818a(String str, boolean z) {
        if (this.mActivity.getResources().getString(R.string.camera_whitebalance_default_value).equals(str)) {
            this.mOneCamera.mo13028a(-1, z);
        }
        if (m17917a(str, this.f16976R.get(5).m17454j())) {
            try {
                this.mOneCamera.mo13028a(Integer.parseInt(str), z);
            } catch (NumberFormatException unused) {
                this.mOneCamera.mo13103i(z);
            }
        } else {
            this.mOneCamera.mo13103i(z);
        }
        CameraLog.m12954a("TimeLapseProMode", "setWhiteBalance, whiteBalance: " + str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m17917a(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17920b(boolean z) {
        this.mOneCamera.mo13103i(z);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m17851c(String str) {
        m17845b(str, true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17845b(String str, boolean z) {
        if (str == null) {
            str = this.mPreferences.getString("pref_time_lapse_pro_iso_key", this.mActivity.getResources().getString(R.string.camera_iso_default_value));
        }
        if (this.mActivity.getResources().getString(R.string.camera_iso_default_value).equals(str)) {
            this.mOneCamera.mo13065b(-1, z);
        } else {
            m17797W();
            this.mOneCamera.mo13128r();
            try {
                this.mOneCamera.mo13065b(Integer.parseInt(str), z);
            } catch (NumberFormatException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                CameraLog.m12954a("TimeLapseProMode", "setISOValue, format iso value error.");
            }
        }
        CameraLog.m12954a("TimeLapseProMode", "setISOValue, iso: " + str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17919b(String str) {
        if (str == null) {
            str = this.mPreferences.getString("pref_time_lapse_pro_focus_mode_key", this.mActivity.getString(R.string.camera_focus_mode_default_value));
        }
        CameraLog.m12954a("TimeLapseProMode", "setFocusValue, focusValue: " + str);
        if (this.mActivity.getString(R.string.camera_focus_mode_default_value).equals(str) || str.isEmpty()) {
            return;
        }
        Handler handler = this.f17029s;
        if (handler != null) {
            handler.removeMessages(100);
            Message messageObtain = Message.obtain();
            messageObtain.what = 100;
            try {
                messageObtain.obj = Float.valueOf(Float.parseFloat(str));
                this.f17029s.sendMessage(messageObtain);
            } catch (NumberFormatException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                CameraLog.m12954a("TimeLapseProMode", "setFocusValue, format value is error.");
            }
        }
        if (this.f17024n) {
            m17882j(false);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m17922d() {
        return Integer.parseInt(this.mPreferences.getString("pref_time_lapse_pro_exposure_compensation_key", this.mActivity.getResources().getString(R.string.camera_exposure_compensation_default_value)));
    }

    /* renamed from: R */
    private void m17792R() throws NumberFormatException {
        m17879i(true);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m17879i(boolean z) throws NumberFormatException {
        String string = this.mPreferences.getString("pref_time_lapse_pro_exposure_time_key", this.mActivity.getResources().getString(R.string.camera_exposure_time_default_value));
        long jLongValue = Long.valueOf(this.mActivity.getResources().getString(R.string.camera_exposure_time_default_value)).longValue();
        try {
            long OplusGLSurfaceView_15 = Long.parseLong(string);
            if (OplusGLSurfaceView_15 != jLongValue) {
                m17797W();
            }
            if (this.mbFrontCamera) {
                this.mOneCamera.mo13031a(jLongValue, z);
            } else {
                this.mOneCamera.mo13031a(OplusGLSurfaceView_15, z);
            }
        } catch (NumberFormatException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            CameraLog.m12954a("TimeLapseProMode", "setExposureTime, format shutter value error.");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m17853c(String str, boolean z) throws NumberFormatException {
        long jLongValue = Long.valueOf(this.mActivity.getResources().getString(R.string.camera_exposure_time_default_value)).longValue();
        long OplusGLSurfaceView_15 = Long.parseLong(str);
        if (OplusGLSurfaceView_15 != jLongValue) {
            m17797W();
        }
        if (this.mbFrontCamera) {
            this.mOneCamera.mo13031a(jLongValue, z);
        } else {
            this.mOneCamera.mo13031a(OplusGLSurfaceView_15, z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m17860d(final String str, boolean z) {
        final Boolean boolValueOf = Boolean.valueOf(z);
        CameraLog.m12954a("TimeLapseProMode", "setFlashModeMenuEnable, exposureTime: " + str + ", mDisPlayFlashIcon: " + boolValueOf);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (Integer.parseInt(str) == 0) {
                if (this.mCameraUIInterface != null) {
                    this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_FLASH_MODE, (String) null);
                    m17855c(true, z);
                }
            } else if (this.mCameraUIInterface != null) {
                m17855c(false, z);
                this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_FLASH_MODE, "off");
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            if (this.mActivity != null) {
                this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_10.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Integer.parseInt(str) == 0) {
                            if (TimeLapseProMode.this.mCameraUIInterface != null) {
                                TimeLapseProMode.this.m17855c(true, boolValueOf.booleanValue());
                                TimeLapseProMode.this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_FLASH_MODE, (String) null);
                                return;
                            }
                            return;
                        }
                        if (TimeLapseProMode.this.mCameraUIInterface != null) {
                            TimeLapseProMode.this.m17855c(false, boolValueOf.booleanValue());
                            TimeLapseProMode.this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_FLASH_MODE, "off");
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17855c(boolean z, boolean z2) {
        if (z2) {
            CameraLog.m12954a("TimeLapseProMode", "showOrHideFlashIcon, enable: " + z + ", isOpenFlash: " + isOpenFlash());
            if (z) {
                displayScreenHintIconInSwitchOn();
            } else {
                this.mCameraUIInterface.mo18108a(false, true, false);
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) throws Resources.NotFoundException, NumberFormatException {
        CameraLog.m12954a("TimeLapseProMode", "onSharedPreferenceChanged, key: " + str + ", " + sharedPreferences);
        if ("pref_time_lapse_pro_whitebalance_key".equals(str)) {
            m17875h(true);
            return;
        }
        if ("pref_time_lapse_pro_iso_key".equals(str)) {
            if (!Camera.f10610l) {
                this.mOneCamera.mo13069b(getFlashMode());
            } else {
                this.mOneCamera.mo13069b("off");
            }
            m17851c((String) null);
            return;
        }
        if ("pref_time_lapse_pro_exposure_compensation_key".equals(str)) {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(m17922d()));
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            return;
        }
        if ("pref_time_lapse_pro_exposure_time_key".equals(str)) {
            if (!Camera.f10610l) {
                this.mOneCamera.mo13069b(getFlashMode());
            } else {
                this.mOneCamera.mo13069b("off");
            }
            m17792R();
            long jM17780F = m17780F();
            if (jM17780F >= 500000000) {
                long OplusGLSurfaceView_15 = jM17780F / 1000000;
                String[] stringArray = this.mActivity.getApplicationContext().getResources().getStringArray(R.array.time_lapse_pro_speeds);
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < stringArray.length; OplusGLSurfaceView_13++) {
                    if (OplusGLSurfaceView_15 < (Long.parseLong(stringArray[OplusGLSurfaceView_13]) * 1000) / m17865e().m17610c()) {
                        TimeLapseProMenuLayout c3071g = this.f16968J;
                        if (c3071g != null) {
                            c3071g.m17739a(OplusGLSurfaceView_13);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            TimeLapseProMenuLayout c3071g2 = this.f16968J;
            if (c3071g2 != null) {
                c3071g2.m17739a(0);
                return;
            }
            return;
        }
        if ("pref_time_lapse_pro_focus_mode_key".equals(str)) {
            if (!this.f16976R.get(4).m17451g()) {
                m17919b((String) null);
            } else {
                if (4 != this.mOneCamera.mo13122p()) {
                    this.mOneCamera.mo13029a(4, AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
                    this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                }
                if (4 == this.mOneCamera.mo13122p() || 1 == this.mOneCamera.mo13122p()) {
                    m17788N();
                }
            }
        } else if (CameraUIInterface.KEY_FLASH_MODE.equals(str)) {
            if (!this.mActivity.getString(R.string.camera_flash_mode_default_value).equals(sharedPreferences.getString(CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(R.string.camera_flash_mode_default_value)))) {
                m17796V();
            }
            m17882j(true);
        }
        super.onSharedPreferenceChanged(sharedPreferences, str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onSwitchCameraButtonClick() {
        super.onSwitchCameraButtonClick();
        this.f16978T = true;
        TimeLapseProMenuLayout c3071g = this.f16968J;
        if (c3071g == null || c3071g.getVisibility() != 0) {
            return;
        }
        if (this.f16968J.m17745c()) {
            m17819a(false, true);
        } else {
            m17846b(false, true);
        }
        this.mCameraUIInterface.mo18054Q(true);
    }

    /* renamed from: S */
    private void m17793S() throws Resources.NotFoundException {
        String string = this.mActivity.getResources().getString(R.string.camera_iso_default_value);
        String string2 = this.mActivity.getResources().getString(R.string.camera_exposure_time_default_value);
        String string3 = this.mActivity.getResources().getString(R.string.camera_whitebalance_default_value);
        String string4 = this.mActivity.getResources().getString(R.string.camera_focus_mode_default_value);
        CameraLog.m12954a("TimeLapseProMode", "logParameters, mPreferences: " + this.mPreferences + ", speed: " + this.f17019i + ", frames: " + this.f17021k + ", ISO: " + this.mPreferences.getString("pref_time_lapse_pro_iso_key", string) + ", shutter: " + this.mPreferences.getString("pref_time_lapse_pro_exposure_time_key", string2) + ", ev: " + this.mPreferences.getString("pref_time_lapse_pro_exposure_compensation_key", this.mActivity.getResources().getString(R.string.camera_exposure_compensation_default_value)) + ", focus: " + this.mPreferences.getString("pref_time_lapse_pro_focus_mode_key", string4) + ", wb: " + this.mPreferences.getString("pref_time_lapse_pro_whitebalance_key", string3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public void m17794T() {
        boolean z = false;
        if (this.f16977S) {
            this.f16977S = false;
            if (this.mCameraInterface != null) {
                this.mCameraInterface.mo10458N();
            }
        }
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18276u(false, true);
            this.mCameraUIInterface.mo18200d(true, false);
            this.mCameraUIInterface.mo18052P(true);
            this.mCameraUIInterface.mo18049N(true);
        }
        if (!this.mbFrontCamera && this.mCameraInterface != null) {
            m17820a(true, true, !m17876h());
            m17847b(true, true, !m17876h());
            if (this.f16971M) {
                this.mCameraInterface.mo10506aH();
                this.f16971M = false;
            }
            if (this.f16967I != 2) {
                CameraInterface interfaceC2646a = this.mCameraInterface;
                if (!m17876h() && !m17870f()) {
                    z = true;
                }
                interfaceC2646a.mo10492a(true, z);
            } else {
                this.f16971M = true;
            }
        }
        TimeLapseProMenuLayout c3071g = this.f16968J;
        if (c3071g != null) {
            c3071g.m17750h();
        }
        m17900s();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setFlashTemporaryDisabled(boolean z) {
        if (getSupportFunction(CameraUIInterface.KEY_SWITCH_CAMERA) && getSupportFunction(CameraUIInterface.KEY_FLASH_MODE) && this.mPreferences != null) {
            String string = this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main");
            String flashMode = getFlashMode();
            boolean z2 = true;
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                if (!"camera_tele".equals(string) || (!"on".equals(flashMode) && !"auto".equals(flashMode))) {
                    z2 = false;
                }
                this.mbFlashTemporaryDisabled = z2;
                return;
            }
            this.mbFlashTemporaryDisabled = !"camera_main".equals(string);
            return;
        }
        this.mbFlashTemporaryDisabled = z;
    }

    /* renamed from: U */
    private void m17795U() {
        if (this.mPreferences == null) {
            return;
        }
        String string = this.mPreferences.getString("pref_time_lapse_pro_exposure_time_key", this.mActivity.getResources().getString(R.string.camera_exposure_time_default_value));
        String string2 = this.mPreferences.getString("pref_time_lapse_pro_iso_key", this.mActivity.getResources().getString(R.string.camera_iso_default_value));
        if (getSupportFunction(CameraUIInterface.KEY_SWITCH_CAMERA) && getSupportFunction(CameraUIInterface.KEY_FLASH_MODE) && this.mActivity.getResources().getString(R.string.camera_exposure_time_default_value).equals(string) && this.mActivity.getResources().getString(R.string.camera_iso_default_value).equals(string2)) {
            String string3 = this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main");
            String flashMode = getFlashMode();
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FLASH_FULL_ZOOM)) {
                if ("camera_tele".equals(string3)) {
                    if ("on".equals(flashMode) || "auto".equals(flashMode)) {
                        this.mbFlashTemporaryDisabled = true;
                        updateFlashState("off");
                        this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_FLASH_MODE, "off");
                    }
                    this.mCameraUIInterface.mo18173b(CameraUIInterface.KEY_FLASH_MODE, "on", "auto");
                } else {
                    this.mbFlashTemporaryDisabled = false;
                    this.mCameraUIInterface.mo18103a(CameraUIInterface.KEY_FLASH_MODE, "on", "auto");
                    this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_FLASH_MODE, (String) null);
                    updateFlashState(flashMode);
                }
            } else if ("camera_main".equals(string3)) {
                this.mbFlashTemporaryDisabled = false;
                updateFlashState(getFlashMode());
                this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_FLASH_MODE, (String) null);
            } else {
                this.mbFlashTemporaryDisabled = true;
                updateFlashState("off");
                this.mCameraUIInterface.mo18099a(CameraUIInterface.KEY_FLASH_MODE, "off");
            }
            this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_FLASH_MODE);
        }
    }

    /* renamed from: V */
    private void m17796V() {
        if ("off".equals(this.mPreferences.getString(CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(R.string.camera_flash_mode_default_value)))) {
            return;
        }
        String string = this.mPreferences.getString("pref_time_lapse_pro_exposure_time_key", this.mActivity.getResources().getString(R.string.camera_exposure_time_default_value));
        String string2 = this.mPreferences.getString("pref_time_lapse_pro_iso_key", this.mActivity.getResources().getString(R.string.camera_iso_default_value));
        this.mActivity.getResources().getString(R.string.camera_exposure_time_default_value).equals(string);
        this.mActivity.getResources().getString(R.string.camera_iso_default_value).equals(string2);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m17882j(boolean z) {
        boolean zEquals = z ? true ^ "off".equals(this.mPreferences.getString(CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(R.string.camera_flash_mode_default_value))) : true;
        if (this.f17024n && zEquals) {
            SharedPreferences.Editor editorEdit = this.mPreferences.edit();
            editorEdit.putString(CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
            editorEdit.apply();
            this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_HIGH_RESOLUTION, "off");
        }
    }

    /* renamed from: W */
    private void m17797W() {
        if ("off".equals(this.mPreferences.getString(CameraUIInterface.KEY_FLASH_MODE, this.mActivity.getString(R.string.camera_flash_mode_default_value)))) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(CameraUIInterface.KEY_FLASH_MODE, "off");
        editorEdit.apply();
        this.mCameraUIInterface.mo18211f(CameraUIInterface.KEY_FLASH_MODE);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isNeedProgressBarInCapture() {
        String string = this.mPreferences.getString("pref_time_lapse_pro_exposure_time_key", this.mActivity.getResources().getString(R.string.camera_exposure_time_default_value));
        return TextUtils.isEmpty(string) || Long.valueOf(string).longValue() >= C1547C.NANOS_PER_SECOND;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int OplusGLSurfaceView_13, boolean z) {
        super.changeModeAllViewWhenAnimation(OplusGLSurfaceView_13, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m17859d(String str) {
        CameraLog.m12954a("TimeLapseProMode", "setRecordSpeed, speed: " + str);
        this.f17019i = str;
        this.f17020j = (Long.parseLong(this.f17019i) * 1000) / ((long) m17865e().m17610c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public synchronized void m17858d(int OplusGLSurfaceView_13) {
        this.f16966H = this.f16967I;
        this.f16967I = OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_13 == this.f16966H) {
            return;
        }
        boolean z = true;
        if (this.f16966H == 1) {
            m17859d("15");
        } else if (this.f16966H != 2 && this.f16966H == 3) {
            m17859d("15");
        }
        if (OplusGLSurfaceView_13 == 1) {
            m17859d(this.mActivity.getApplicationContext().getResources().getString(R.string.time_lapse_pro_speed_60x));
        } else if (OplusGLSurfaceView_13 == 2) {
            if (m17870f()) {
                m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$WOzPRCV2xREsRp7ujOoJiSrJtHU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.COUIBaseListPopupWindow_12$0.m17825ab();
                    }
                });
            } else {
                this.f16971M = true;
                this.mCameraInterface.mo10506aH();
            }
        } else if (OplusGLSurfaceView_13 == 3) {
            m17859d(this.mActivity.getApplicationContext().getResources().getString(R.string.time_lapse_pro_speed_150x));
        }
        if (OplusGLSurfaceView_13 != 0) {
            if (this.f16966H == 0 && !this.f16976R.isEmpty()) {
                m17919b(this.f16976R.get(4).m17454j().get(this.f16976R.get(4).m17455k().indexOf("0.96")));
            }
            this.f17021k = 0L;
        } else {
            if (4 != this.mOneCamera.mo13122p()) {
                this.mOneCamera.mo13029a(4, AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
                this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
            }
            if (4 == this.mOneCamera.mo13122p() || 1 == this.mOneCamera.mo13122p()) {
                m17788N();
            }
        }
        if (m17870f() && OplusGLSurfaceView_13 != 2 && this.f16966H == 2) {
            m17817a(new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$COUIBaseListPopupWindow_10$MaLPRVl6_CGT3xa2Ui9kG3jjUmc
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m17824aa();
                }
            });
        }
        if (OplusGLSurfaceView_13 != 2) {
            z = false;
        }
        m17861d(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ab */
    public /* synthetic */ void m17825ab() {
        this.mCameraInterface.mo10479a(new AnimatorListenerAdapter() { // from class: com.oplus.camera.timelapsepro.COUIBaseListPopupWindow_10.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TimeLapseProMode.this.f16971M = true;
                TimeLapseProMode.this.mCameraInterface.mo10506aH();
            }
        }, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aa */
    public /* synthetic */ void m17824aa() {
        this.mCameraInterface.mo10506aH();
        this.f16971M = false;
        this.mCameraInterface.mo10492a(true, false);
        this.mCameraInterface.mo10563d(true);
    }

    @Override // com.oplus.camera.timelapsepro.TimeLapseProMenuLayout.IntrinsicsJvm.kt_5
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17763a() {
        this.mCameraUIInterface.mo18178ba();
    }

    @Override // com.oplus.camera.timelapsepro.TimeLapseProMenuLayout.IntrinsicsJvm.kt_5
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo17764b() {
        this.mCameraUIInterface.mo18179bb();
    }

    @Override // com.oplus.camera.timelapsepro.TimeLapseProMenuLayout.COUIBaseListPopupWindow_12
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17772a(boolean z) {
        m17844b(z ? TimeLapseProMsgData.FUNC_KEY_ID_TEMPLATE : TimeLapseProMsgData.FUNC_KEY_ID_PARAMS, "2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17844b(String str, String str2) {
        TimeLapseProMsgData timeLapseProMsgDataM17863e = m17863e("funcKey_click");
        timeLapseProMsgDataM17863e.mFuncKeyId = str;
        timeLapseProMsgDataM17863e.mFuncKeyResult = str2;
        timeLapseProMsgDataM17863e.report();
    }

    @Override // com.oplus.camera.timelapsepro.TimeLapseProMenuLayout.COUIBaseListPopupWindow_12
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17771a(String str, String str2) {
        TimeLapseProMsgData timeLapseProMsgDataM17863e = m17863e("funcValue_select");
        timeLapseProMsgDataM17863e.mFuncKeyId = TimeLapseProMsgData.FUNC_KEY_ID_PARAMS;
        timeLapseProMsgDataM17863e.mFuncKeyItem = str;
        timeLapseProMsgDataM17863e.mFuncKeyResult = str2;
        timeLapseProMsgDataM17863e.report();
    }

    @Override // com.oplus.camera.timelapsepro.TimeLapseProMenuLayout.COUIBaseListPopupWindow_12
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17769a(int OplusGLSurfaceView_13) {
        TimeLapseProMsgData timeLapseProMsgDataM17863e = m17863e("funcValue_select");
        timeLapseProMsgDataM17863e.mFuncKeyId = TimeLapseProMsgData.FUNC_KEY_ID_TEMPLATE;
        timeLapseProMsgDataM17863e.mFuncKeyItem = null;
        timeLapseProMsgDataM17863e.mFuncKeyResult = timeLapseProMsgDataM17863e.getTemplateValue(OplusGLSurfaceView_13);
        timeLapseProMsgDataM17863e.report();
    }

    @Override // com.oplus.camera.timelapsepro.TimeLapseProMenuLayout.COUIBaseListPopupWindow_12
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17770a(String str) {
        TimeLapseProMsgData timeLapseProMsgDataM17863e = m17863e("funcMenu_select");
        timeLapseProMsgDataM17863e.mFuncKeyId = TimeLapseProMsgData.FUNC_KEY_ID_PARAMS;
        timeLapseProMsgDataM17863e.mFuncKeyValue = str;
        timeLapseProMsgDataM17863e.report();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private TimeLapseProMsgData m17863e(String str) {
        TimeLapseProMsgData timeLapseProMsgData = this.f16987aC.get(str);
        if (timeLapseProMsgData == null) {
            timeLapseProMsgData = new TimeLapseProMsgData(this.mActivity, getCameraMode());
            timeLapseProMsgData.buildEventId(str);
            this.f16987aC.put(str, timeLapseProMsgData);
        }
        timeLapseProMsgData.mOrientation = this.mOrientation;
        return timeLapseProMsgData;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17808a(long OplusGLSurfaceView_15, long j2) throws Resources.NotFoundException {
        TimeLapseProMsgData timeLapseProMsgDataM17863e = m17863e("videoRecord");
        int OplusGLSurfaceView_13 = this.f16967I;
        if (OplusGLSurfaceView_13 != 0) {
            timeLapseProMsgDataM17863e.mTimeLapseType = String.valueOf(OplusGLSurfaceView_13);
        } else {
            int i2 = this.mPreferences.getInt("pref_time_lapse_pro_speed_key", -1);
            int i3 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_iso_key", -1);
            int i4 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_exposure_time_key", -1);
            int i5 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_exposure_compensation_key", TimeLapseProConstant.f16844a);
            int i6 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_focus_mode_key", -1);
            int i7 = this.mPreferences.getInt("pref_time_lapse_pro_index_of_whitebalance_key", -1);
            if (-1 == i2 && -1 == i3 && -1 == i4 && TimeLapseProConstant.f16844a == i5 && -1 == i6 && -1 == i7) {
                timeLapseProMsgDataM17863e.mTimeLapseType = "default";
            } else {
                timeLapseProMsgDataM17863e.mTimeLapseType = TimeLapseProMsgData.KEY_CUSTOMEIZE;
                String[] stringArray = this.mActivity.getResources().getStringArray(R.array.time_lapse_pro_speeds);
                if (i2 >= 0 && i2 < stringArray.length) {
                    timeLapseProMsgDataM17863e.mPosterizeTime = stringArray[i2];
                }
                if (!this.f16976R.isEmpty()) {
                    if (i3 >= 0 && i3 < this.f16976R.get(1).m17455k().size()) {
                        timeLapseProMsgDataM17863e.mTimeLapseISO = this.f16976R.get(1).m17455k().get(i3);
                    } else {
                        timeLapseProMsgDataM17863e.mTimeLapseISO = "auto";
                    }
                    if (i4 >= 0 && i4 < this.f16976R.get(2).m17455k().size()) {
                        timeLapseProMsgDataM17863e.mTimeLapseEXP = this.f16976R.get(2).m17455k().get(i4);
                    } else {
                        timeLapseProMsgDataM17863e.mTimeLapseEXP = "auto";
                    }
                    if (i5 >= 0 && i5 < this.f16976R.get(3).m17455k().size()) {
                        timeLapseProMsgDataM17863e.mTimeLapseEV = this.f16976R.get(3).m17455k().get(i5);
                    } else if (TimeLapseProConstant.f16844a == i5) {
                        timeLapseProMsgDataM17863e.mTimeLapseEV = "auto";
                    }
                    if (i6 >= 0 && i6 < this.f16976R.get(4).m17455k().size()) {
                        timeLapseProMsgDataM17863e.mTimeLapseFocus = this.f16976R.get(4).m17455k().get(i6);
                    } else {
                        timeLapseProMsgDataM17863e.mTimeLapseFocus = "auto";
                    }
                    if (i7 >= 0 && i7 < this.f16976R.get(5).m17455k().size()) {
                        timeLapseProMsgDataM17863e.mTimeLapseWB = this.f16976R.get(5).m17455k().get(i7);
                    } else {
                        timeLapseProMsgDataM17863e.mTimeLapseWB = "auto";
                    }
                }
            }
        }
        timeLapseProMsgDataM17863e.mVideoTime = String.valueOf(OplusGLSurfaceView_15);
        timeLapseProMsgDataM17863e.mGenerateTime = String.valueOf(j2);
        timeLapseProMsgDataM17863e.mLux = this.f17014ax;
        timeLapseProMsgDataM17863e.mCct = this.f16985aA;
        timeLapseProMsgDataM17863e.mExp = this.f17016az;
        timeLapseProMsgDataM17863e.mIso = this.f17015ay;
        timeLapseProMsgDataM17863e.report();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getHintTextId() {
        if (this.mPreferences == null) {
            return -1;
        }
        String string = this.mPreferences.getString(CameraUIInterface.KEY_SWITCH_CAMERA, "camera_main");
        if ("camera_main".equals(string)) {
            return Util.m24445f(R.string.camera_switch_main);
        }
        if ("camera_ultra_wide".equals(string)) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_IS_UW_FIXED_FOCUS) || Float.compare(this.mOneCamera.mo13086e().m13279n(), 0.0f) == 0) {
                return Util.m24445f(R.string.camera_switch_ultra_wide);
            }
            return Util.m24445f(R.string.camera_switch_ultra_wide_micro_lens);
        }
        if ("camera_tele".equals(string)) {
            return R.string.camera_switch_tele;
        }
        if ("camera_macro".equals(string)) {
            return R.string.camera_switch_macro;
        }
        return -1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isInPreviewArea(MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.mCameraUIInterface.mo18253p().getHitRect(rect);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ZoomConfigure getZoomConfigure() {
        ZoomConfigure zoomConfigure = super.getZoomConfigure();
        zoomConfigure.m11352l(isHighPictureSize());
        zoomConfigure.m11356n(getSupportFunction(CameraUIInterface.KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE));
        zoomConfigure.m11368t(getSupportFunction(CameraUIInterface.KEY_SUPPORT_INSENSOR_ZOOM_20X));
        zoomConfigure.m11370u(getSupportFunction(CameraUIInterface.KEY_SUPPORT_INSENSOR_ZOOM_20X) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_INSENSOR_ZOOM_POINT_3X_SUPPORT));
        return zoomConfigure;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isShowZoomMenu() {
        return !m17921c();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void restoreDefaultMode(boolean z) {
        super.restoreDefaultMode(z);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecording() {
        return isVideoRecordStarted() || isVideoRecordStarting();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStarted() {
        return this.f17036z == 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStarting() {
        return this.f17036z == 1;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStopping() {
        return this.f17036z == 3;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    /* renamed from: onVideoShutterButtonClick, reason: merged with bridge method [inline-methods] */
    public void m17833aj() {
        super.m17833aj();
        if (this.mCameraInterface == null) {
            CameraLog.m12954a("TimeLapseProMode", "onVideoShutterButtonClick mCameraInterface is null.");
            return;
        }
        CameraLog.m12967f("TimeLapseProMode", "onVideoShutterButtonClick, mRecorderStatus: " + this.f17036z + ", mCameraInterface.isAnimationRunning: " + this.mCameraInterface.mo10462R());
        if (this.mCameraInterface.mo10450F()) {
            CameraLog.m12954a("TimeLapseProMode", "onVideoShutterButtonClick, being capture mode change!");
            return;
        }
        if (Storage.f12097w != 0) {
            this.mCameraUIInterface.mo18269t();
            return;
        }
        if (!isVideoRecording() && !this.mCameraInterface.mo10460P()) {
            CameraLog.m12966e("TimeLapseProMode", "onVideoShutterButtonClick, memory or storage is not enough");
            this.mCameraUIInterface.mo18070a(R.string.camera_toast_camera_Low_memory_hint, -1, true, false, false);
            m17852c(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_MEMORY_CAPTURE);
            return;
        }
        CameraLog.m12967f("TimeLapseProMode", "onVideoShutterButtonClick, CameraTest Click Video Button. mRecorderStatus: " + this.f17036z);
        if (isVideoRecordStarted()) {
            Handler handler = this.f17029s;
            if (handler != null && handler.hasMessages(110)) {
                this.f17029s.removeMessages(110);
            }
            m17784J();
            return;
        }
        isVideoRecordStopped();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isVideoRecordStopped() {
        return this.f17036z == 2;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m17885k(boolean z) {
        CameraLog.m12954a("TimeLapseProMode", "onStopVideoRecording, checkRecordTime: " + z);
        this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(6, "button_color_inside_red", "button_shape_dial_rotate", 1));
        if (!this.mbPaused && this.mCameraInterface != null && this.mCameraInterface.mo10575i() && !supportParameterAdjust() && this.mOneCamera != null) {
            this.mCameraInterface.mo10527ac();
            this.mCameraInterface.mo10556b(false, false);
            this.mOneCamera.mo13029a(3, AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
            this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        }
        if (this.mCameraInterface == null || this.mOneCamera == null) {
            return;
        }
        this.mOneCamera.mo13098h();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void beforeStartRecording() throws Resources.NotFoundException {
        m17793S();
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10479a((AnimatorListenerAdapter) null, true, (m17870f() || m17876h()) ? false : true);
        }
        CameraLog.m12962c("TimeLapseProMode", "beforeStartRecording");
        this.mCameraUIInterface.mo18091a(new MainShutterButtonInfo(5, "button_color_inside_red", "button_shape_dial_rotate", 1));
        super.beforeStartRecording();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m17918b(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("TimeLapseProMode", "setVideoRecordState, mRecorderStatus: from " + m17866e(this.f17036z) + " to " + m17866e(OplusGLSurfaceView_13));
        this.f17036z = OplusGLSurfaceView_13;
    }

    /* renamed from: X */
    private void m17798X() {
        this.mActivity.sendBroadcast(new Intent("oplus.multimedia.soundrecorder.stopRecroderNormal"));
    }

    /* renamed from: Y */
    private void m17799Y() {
        this.mActivity.sendBroadcast(new Intent("oplus.camera.record.start"));
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setLowBatteryState(boolean z) {
        this.f17017g = z;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void forceStopVideoRecording(boolean z) {
        if (isVideoRecordStarted() || isVideoRecordStarting()) {
            CameraLog.m12954a("TimeLapseProMode", "forceStopVideoRecording, mRecordSig.block");
            m17784J();
            this.f17018h.close();
            if (!isVideoRecordStarted()) {
                this.f17018h.block();
            }
            CameraLog.m12954a("TimeLapseProMode", "forceStopVideoRecording, mRecordSig.block X");
            m17885k(z);
        }
    }

    /* renamed from: Z */
    private boolean m17800Z() {
        CameraLog.m12954a("TimeLapseProMode", "recDisabledReturn");
        if (!this.f17017g) {
            return false;
        }
        this.mCameraUIInterface.mo18070a(R.string.camera_time_lapse_pro_low_battery_hint, -1, true, false, false);
        m17852c(ReminderMsgData.TYPE_DISABLE_CODE, ReminderMsgData.CODE_BATTERY_VIDEO);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m17852c(String str, String str2) {
        ReminderMsgData reminderMsgData = new ReminderMsgData(this.mActivity, false);
        if (this.mCameraInterface != null) {
            if (this.mCameraInterface.mo10583m()) {
                reminderMsgData.mCameraEnterType = String.valueOf(3);
            }
            reminderMsgData.mCameraId = this.mCameraInterface.mo10548ax();
        }
        reminderMsgData.mCaptureMode = "timeLapse";
        reminderMsgData.mCaptureType = 1;
        reminderMsgData.mOrientation = this.mOrientation;
        reminderMsgData.mReminderTypeValue = str;
        reminderMsgData.mReminderCodeValue = str2;
        reminderMsgData.mbRecording = isVideoRecording();
        reminderMsgData.mRearOrFront = this.mbFrontCamera ? DcsMsgData.FRONT : DcsMsgData.REAR;
        reminderMsgData.report();
    }
}
