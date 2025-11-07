package com.oplus.camera.panorama;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.media.Image;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.arcsoft.camera.burstpmk.ProcessResult;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.oplus.camera.AEAFHelp;
import com.oplus.camera.CameraLog;
import com.oplus.camera.CameraMotorManager;
import com.oplus.camera.CameraConstant;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.capmode.VideoMode;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.jni.FormatConverter;
import com.oplus.camera.jni.IccProfile;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OplusCameraCharacteristics;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.camerascreenhint.CameraScreenHintInfo;
import com.oplus.camera.p172ui.camerascreenhint.CameraScreenHintView;
import com.oplus.camera.p172ui.camerascreenhint.CameraScreenHintInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.p172ui.p173a.HintManager;
import com.oplus.camera.p172ui.p173a.HintModel;
import com.oplus.camera.p172ui.preview.p177a.PreviewEffectProcess;
import com.oplus.camera.panorama.FrontPanoramaEngine;
import com.oplus.camera.panorama.RearPanoramaEngine;
import com.oplus.camera.panorama.FrontPanoramaGuideView;
import com.oplus.camera.panorama.PanoramaProgressBar;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.CameraDeviceInfo;
import com.oplus.ocs.camera.CameraPreviewCallback;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: PanoramaCapMode.java */
/* renamed from: com.oplus.camera.panorama.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class PanoramaCapMode extends BaseMode implements FrontPanoramaEngine.PlatformImplementations.kt_3, RearPanoramaEngine.PlatformImplementations.kt_3 {

    /* renamed from: OplusGLSurfaceView_13 */
    private static final Object f15000i = new Object();

    /* renamed from: A */
    private TextView f15001A;

    /* renamed from: B */
    private Resources f15002B;

    /* renamed from: C */
    private Object f15003C;

    /* renamed from: D */
    private RelativeLayout f15004D;

    /* renamed from: E */
    private CameraScreenHintView f15005E;

    /* renamed from: F */
    private Size f15006F;

    /* renamed from: G */
    private Size f15007G;

    /* renamed from: H */
    private Size f15008H;

    /* renamed from: I */
    private PanoramaProgressBar f15009I;

    /* renamed from: J */
    private volatile boolean f15010J;

    /* renamed from: K */
    private volatile boolean f15011K;

    /* renamed from: L */
    private volatile boolean f15012L;

    /* renamed from: M */
    private int f15013M;

    /* renamed from: N */
    private int f15014N;

    /* renamed from: O */
    private int f15015O;

    /* renamed from: P */
    private boolean f15016P;

    /* renamed from: Q */
    private boolean f15017Q;

    /* renamed from: R */
    private volatile int f15018R;

    /* renamed from: S */
    private byte[] f15019S;

    /* renamed from: T */
    private int f15020T;

    /* renamed from: U */
    private int f15021U;

    /* renamed from: V */
    private int f15022V;

    /* renamed from: W */
    private int f15023W;

    /* renamed from: X */
    private int f15024X;

    /* renamed from: Y */
    private int f15025Y;

    /* renamed from: Z */
    private int f15026Z;

    /* renamed from: aa */
    private float f15027aa;

    /* renamed from: ab */
    private int f15028ab;

    /* renamed from: ac */
    private RearPanoramaEngine f15029ac;

    /* renamed from: ad */
    private Bitmap f15030ad;

    /* renamed from: ae */
    private Matrix f15031ae;

    /* renamed from: af */
    private String f15032af;

    /* renamed from: ag */
    private boolean f15033ag;

    /* renamed from: ah */
    private int f15034ah;

    /* renamed from: ai */
    private float f15035ai;

    /* renamed from: aj */
    private int f15036aj;

    /* renamed from: ak */
    private FrontPanoramaEngine f15037ak;

    /* renamed from: al */
    private Bitmap f15038al;

    /* renamed from: am */
    private Handler f15039am;

    /* renamed from: COUIBaseListPopupWindow_11 */
    FrontPanoramaGuideView.InterfaceC2832a f15040g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    PanoramaProgressBar.RearPanoramaInterface f15041h;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f15042j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f15043k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f15044l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f15045m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f15046n;

    /* renamed from: o */
    private int f15047o;

    /* renamed from: p */
    private int f15048p;

    /* renamed from: q */
    private int f15049q;

    /* renamed from: r */
    private int f15050r;

    /* renamed from: s */
    private int f15051s;

    /* renamed from: t */
    private boolean f15052t;

    /* renamed from: u */
    private boolean f15053u;

    /* renamed from: v */
    private boolean f15054v;

    /* renamed from: w */
    private boolean f15055w;

    /* renamed from: x */
    private Bitmap f15056x;

    /* renamed from: y */
    private ImageView f15057y;

    /* renamed from: z */
    private FrontPanoramaGuideView f15058z;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int m15049e(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == -1) {
            return 3;
        }
        if (OplusGLSurfaceView_13 != 2) {
            return OplusGLSurfaceView_13 != 3 ? 0 : 1;
        }
        return 2;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getAssistViewLayoutType() {
        return 2;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public String getCameraMode() {
        return ApsConstant.CAPTURE_MODE_PANORAMA;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public CameraStatisticsUtil.MakerNote getMakerNote() {
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public int getOperatingMode() {
        return 32775;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportQuickJpeg(CameraRequestTag c2693c) {
        return false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getSupportSubMenu(String str) {
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

    @Override // com.oplus.camera.panorama.RearPanoramaEngine.PlatformImplementations.kt_3
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo15096g() {
        this.f15039am.sendEmptyMessage(6);
        synchronized (f15000i) {
            if (this.f15029ac != null) {
                this.f15029ac.m15107a();
            }
        }
    }

    @Override // com.oplus.camera.panorama.RearPanoramaEngine.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo15089a(ProcessResult processResult) throws IOException {
        this.f15010J = false;
        int OplusGLSurfaceView_13 = processResult.width;
        int i2 = processResult.height;
        if (OplusGLSurfaceView_13 <= 0 || i2 <= 0) {
            this.f15039am.sendEmptyMessage(6);
            synchronized (f15000i) {
                if (this.f15029ac != null) {
                    this.f15029ac.m15107a();
                }
            }
            return;
        }
        byte[] bArr = new byte[processResult.imageData.length];
        FormatConverter.rotateAndMirrorYUV(processResult.imageData, bArr, processResult.imageData.length, new int[]{OplusGLSurfaceView_13, OplusGLSurfaceView_13}, new int[]{i2, i2}, OplusGLSurfaceView_13, i2, 90, false);
        if (getHeicCodecFormat() != null) {
            m15091a(bArr, i2, OplusGLSurfaceView_13);
        } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FEATURE_DCIP3_SUPPORT)) {
            m15091a(IccProfile.convertYuv2JpegWithColorProfile(bArr, 95, i2, OplusGLSurfaceView_13), i2, OplusGLSurfaceView_13);
        } else {
            try {
                YuvImage yuvImage = new YuvImage(bArr, 17, i2, OplusGLSurfaceView_13, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, i2, OplusGLSurfaceView_13), 95, byteArrayOutputStream);
                m15091a(byteArrayOutputStream.toByteArray(), i2, OplusGLSurfaceView_13);
                byteArrayOutputStream.close();
            } catch (IOException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        synchronized (f15000i) {
            if (this.f15029ac != null) {
                this.f15029ac.m15107a();
            }
        }
    }

    @Override // com.oplus.camera.panorama.RearPanoramaEngine.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo15094b(final ProcessResult processResult) {
        if (this.f15018R != processResult.direction && this.mActivity != null) {
            this.f15018R = processResult.direction;
            final Rect rect = processResult.updateSmallImageRect;
            Bitmap bitmapM14965a = PanoRenderScriptUtil.m14965a(this.mActivity, processResult.smallImageData, rect.right - rect.left, rect.bottom - rect.top);
            if (bitmapM14965a != null) {
                final Bitmap bitmapM24221a = Util.m24221a(bitmapM14965a, 0, 0, bitmapM14965a.getWidth(), bitmapM14965a.getHeight(), this.f15031ae, true);
                this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_12.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PanoramaCapMode.this.f15009I != null) {
                            PanoramaCapMode.this.f15009I.setAnimationState(3 == PanoramaCapMode.this.f15018R ? 4 : 5);
                            PanoramaCapMode.this.f15009I.m14903a();
                        }
                        PanoramaCapMode c2840f = PanoramaCapMode.this;
                        c2840f.f15030ad = c2840f.m14998a(c2840f.f15030ad, bitmapM24221a, rect);
                    }
                });
                return;
            }
            return;
        }
        if (m15043c(processResult) && this.mActivity != null) {
            final Rect rect2 = processResult.updateSmallImageRect;
            Bitmap bitmapM14965a2 = PanoRenderScriptUtil.m14965a(this.mActivity, processResult.smallImageData, rect2.right - rect2.left, rect2.bottom - rect2.top);
            if (bitmapM14965a2 != null) {
                final Bitmap bitmapM24221a2 = Util.m24221a(bitmapM14965a2, 0, 0, bitmapM14965a2.getWidth(), bitmapM14965a2.getHeight(), this.f15031ae, true);
                this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_12.10
                    @Override // java.lang.Runnable
                    public void run() {
                        PanoramaCapMode c2840f = PanoramaCapMode.this;
                        c2840f.f15030ad = c2840f.m14998a(c2840f.f15030ad, bitmapM24221a2, rect2);
                        PanoramaCapMode.this.f15039am.removeMessages(5);
                        Message messageObtainMessage = PanoramaCapMode.this.f15039am.obtainMessage(5);
                        messageObtainMessage.arg1 = processResult.outputOffset.x;
                        PanoramaCapMode.this.f15039am.sendMessage(messageObtainMessage);
                    }
                });
                return;
            }
            return;
        }
        m15061i();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m15061i() {
        synchronized (f15000i) {
            if (this.f15010J && this.f15029ac != null) {
                this.f15029ac.m15112c();
                this.f15010J = false;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15091a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("PanoramaCapMode", "onRearPanoramaSave, data: " + bArr + ", mbPaused: " + this.mbPaused);
        if (this.mbPaused) {
            return;
        }
        this.f15012L = false;
        this.mCameraInterface.mo10558c(Util.m24352ao() ? 7 : 5);
        this.f15039am.sendEmptyMessage(6);
        if (bArr != null) {
            Storage.CameraPicture cameraPicture = new Storage.CameraPicture();
            cameraPicture.f12132e = bArr;
            cameraPicture.f12135h = getHeicCodecFormat() != null ? getHeicCodecFormat() : CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG;
            cameraPicture.f12147t = Util.m24369b(bArr);
            cameraPicture.mPath = null;
            cameraPicture.f12142o = OplusGLSurfaceView_13;
            cameraPicture.f12143p = i2;
            cameraPicture.f12106D = true;
            cameraPicture.f12107E = this.mbDisplayOnLock;
            cameraPicture.f12131d = this.mCameraInterface.mo10595y();
            if (!this.mbPaused) {
                this.mCameraInterface.mo10483a(cameraPicture, true);
            } else {
                this.f15012L = true;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15004a(byte[] bArr) {
        synchronized (this.f15003C) {
            if (bArr != null) {
                if (this.f15056x != null && !this.f15056x.isRecycled() && this.f15008H != null) {
                    if (this.f15037ak == null || !this.f15037ak.m14952b()) {
                        if (this.f15006F != null && this.mActivity != null && bArr.length > 1) {
                            this.f15056x = PanoRenderScriptUtil.m14966a(this.mActivity, bArr, this.f15006F.getWidth(), this.f15006F.getHeight(), this.f15006F.getWidth() / 6, this.f15006F.getHeight() / 6);
                            Matrix matrix = new Matrix();
                            matrix.postRotate(90.0f);
                            matrix.postScale(1.0f, -1.0f);
                            if (this.f15056x != null) {
                                this.f15056x = Util.m24221a(this.f15056x, 0, 0, this.f15056x.getWidth(), this.f15056x.getHeight(), matrix, true);
                            }
                        }
                        m15093b(this.f15037ak != null ? this.f15037ak.m14946a(this.f15056x) : null);
                        return;
                    }
                    return;
                }
            }
            CameraLog.m12967f("PanoramaCapMode", "processFrontPreviewFrame, data: " + bArr + ", mFrontPreviewBitmap: " + this.f15056x + ", mPictureSize: " + this.f15008H);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onPreviewFrameReceived(Image image) {
        super.onPreviewFrameReceived(image);
        if (image == null || this.mbPaused || !this.f15054v || !this.f15053u || (this.mCameraInterface != null && this.mCameraInterface.mo10449E())) {
            CameraLog.m12959b("PanoramaCapMode", "onPreviewFrameReceived, mbPaused: " + this.mbPaused + ", mbCapInit: " + this.f15054v + ", mbStartPreviewed: " + this.f15053u);
            return true;
        }
        if (this.mbFrontCamera) {
            byte[] bArrM24305a = Util.m24305a(image, 17);
            m15004a(bArrM24305a);
            FrontPanoramaEngine c2838d = this.f15037ak;
            if (c2838d != null) {
                c2838d.m14951b(bArrM24305a);
            }
        } else if (this.f15010J) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PANORAMA_REAR_PROCESS_IMAGE)) {
                synchronized (f15000i) {
                    if (this.f15029ac != null) {
                        this.f15029ac.m15109a(image);
                        return false;
                    }
                }
            } else {
                ByteBuffer[] byteBufferArr = {image.getPlanes()[0].getBuffer(), image.getPlanes()[2].getBuffer()};
                synchronized (f15000i) {
                    if (this.f15029ac != null) {
                        this.f15029ac.m15110a(byteBufferArr);
                    }
                }
                if (Util.m24417c()) {
                    Util.m24250a(Util.m24305a(image, 17), "dump_rear", System.currentTimeMillis() + "_" + this.f15007G.getWidth() + "x" + this.f15007G.getHeight());
                }
            }
        } else {
            this.f15019S = Util.m24306a(image, 17, this.f15019S);
            this.f15039am.removeMessages(7);
            this.f15039am.obtainMessage(7, this.f15019S).sendToTarget();
        }
        return true;
    }

    public PanoramaCapMode(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, PreviewEffectProcess interfaceC3423t) {
        super(activity, interfaceC2646a, cameraUIInterface, interfaceC3423t);
        this.f15042j = VideoMode.VIDEO_1080P_HEIGHT;
        this.f15043k = 282;
        this.f15044l = 0;
        this.f15045m = 0;
        this.f15046n = 0;
        this.f15047o = 0;
        this.f15048p = 0;
        this.f15049q = 0;
        this.f15050r = 42;
        this.f15051s = 0;
        this.f15052t = false;
        this.f15053u = false;
        this.f15054v = false;
        this.f15055w = false;
        this.f15056x = null;
        this.f15057y = null;
        this.f15058z = null;
        this.f15001A = null;
        this.f15002B = null;
        this.f15003C = new Object();
        this.f15004D = null;
        this.f15005E = null;
        this.f15006F = null;
        this.f15007G = null;
        this.f15008H = null;
        this.f15009I = null;
        this.f15010J = false;
        this.f15011K = false;
        this.f15012L = true;
        this.f15013M = 0;
        this.f15014N = 0;
        this.f15015O = 0;
        this.f15017Q = false;
        this.f15018R = -1;
        this.f15019S = null;
        this.f15020T = 0;
        this.f15021U = 0;
        this.f15022V = 0;
        this.f15023W = 0;
        this.f15024X = 0;
        this.f15025Y = 0;
        this.f15026Z = 0;
        this.f15027aa = 0.0f;
        this.f15028ab = 0;
        this.f15029ac = null;
        this.f15030ad = null;
        this.f15031ae = new Matrix();
        this.f15032af = "normal";
        this.f15033ag = false;
        this.f15034ah = 0;
        this.f15035ai = 0.0f;
        this.f15036aj = -2;
        this.f15037ak = null;
        this.f15038al = null;
        this.f15039am = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_12.1
            @Override // android.os.Handler
            public void handleMessage(Message message) throws Resources.NotFoundException {
                switch (message.what) {
                    case 1:
                        if (PanoramaCapMode.this.f15037ak != null) {
                            PanoramaCapMode.this.f15037ak.m14947a();
                        }
                        PanoramaCapMode.this.m15072n();
                        boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
                        PanoramaCapMode.this.m15090a(zBooleanValue);
                        if (zBooleanValue) {
                            return;
                        }
                        PanoramaCapMode.this.mCameraUIInterface.mo18155as();
                        return;
                    case 2:
                        Bitmap bitmap = (Bitmap) message.obj;
                        if (!PanoramaCapMode.this.f15054v || PanoramaCapMode.this.mbPaused || PanoramaCapMode.this.f15057y == null || bitmap == null || bitmap.isRecycled() || !CameraMotorManager.m13703a(PanoramaCapMode.this.mActivity.getApplicationContext()).m13714d()) {
                            return;
                        }
                        PanoramaCapMode.this.f15057y.setImageBitmap(bitmap);
                        if (PanoramaCapMode.this.f15038al != null) {
                            PanoramaCapMode.this.f15038al.recycle();
                            PanoramaCapMode.this.f15038al = null;
                        }
                        PanoramaCapMode.this.f15038al = bitmap;
                        return;
                    case 3:
                        if (!PanoramaCapMode.this.f15054v || PanoramaCapMode.this.mCameraUIInterface.mo18057R()) {
                            return;
                        }
                        PanoramaCapMode.this.m15092b(((Integer) message.obj).intValue());
                        return;
                    case 4:
                        if (PanoramaCapMode.this.f15010J || PanoramaCapMode.this.f15009I == null || PanoramaCapMode.this.f15009I.m14911e() || -1 == PanoramaCapMode.this.f15009I.getDirection()) {
                            return;
                        }
                        PanoramaCapMode.this.f15009I.m14912f();
                        PanoramaCapMode.this.f15009I.m14903a();
                        PanoramaCapMode.this.f15009I.setAnimationState(6);
                        return;
                    case 5:
                        if (!PanoramaCapMode.this.f15010J || PanoramaCapMode.this.f15030ad == null || PanoramaCapMode.this.f15009I == null) {
                            return;
                        }
                        int OplusGLSurfaceView_13 = message.arg1;
                        if (PanoramaCapMode.this.f15028ab == 0) {
                            PanoramaCapMode.this.f15028ab = OplusGLSurfaceView_13;
                        }
                        PanoramaCapMode.this.f15009I.m14906a(PanoramaCapMode.this.f15030ad, PanoramaCapMode.this.f15030ad.getWidth() - PanoramaCapMode.this.f15021U, (int) ((OplusGLSurfaceView_13 - PanoramaCapMode.this.f15028ab) * 0.1f));
                        return;
                    case 6:
                        PanoramaCapMode c2840f = PanoramaCapMode.this;
                        c2840f.setOrientation(c2840f.f15013M);
                        if (PanoramaCapMode.this.f15009I != null) {
                            PanoramaCapMode.this.f15009I.m14905a(PanoramaCapMode.this.f15030ad);
                        }
                        PanoramaCapMode.this.f15011K = false;
                        PanoramaCapMode.this.m15092b(0);
                        CameraLog.m12954a("PanoramaCapMode", "handleMessage, MSG_REAR_PANORAMA_FINISH");
                        PanoramaCapMode.this.mCameraUIInterface.mo18091a(Util.m24352ao() ? new MainShutterButtonInfo(6, "button_color_inside_hasselblad", "button_shape_ring_none", 3) : new MainShutterButtonInfo(11, "button_color_inside_none"));
                        PanoramaCapMode.this.mCameraUIInterface.mo18215g(0);
                        PanoramaCapMode.this.mCameraUIInterface.mo18167b(0, true);
                        PanoramaCapMode.this.mCameraUIInterface.mo18184c(0);
                        PanoramaCapMode.this.mCameraUIInterface.mo18193d(PanoramaCapMode.this.getFrontEnable() ? 0 : 4);
                        PanoramaCapMode.this.mCameraUIInterface.mo18209f(0);
                        if (PanoramaCapMode.this.f15054v) {
                            if (PanoramaCapMode.this.isPanelMode()) {
                                PanoramaCapMode.this.mCameraUIInterface.mo18077a(0, false);
                            } else {
                                PanoramaCapMode.this.mCameraUIInterface.mo18068a(0, 1);
                            }
                        }
                        PanoramaCapMode.this.mCameraUIInterface.mo18200d(true, false);
                        if (!PanoramaCapMode.this.mCameraInterface.mo10596z()) {
                            PanoramaCapMode.this.mCameraInterface.mo10527ac();
                            PanoramaCapMode.this.mOneCamera.mo13071b(false, false);
                            PanoramaCapMode.this.mOneCamera.mo13029a(4, AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
                            PanoramaCapMode.this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, (CaptureRequest.Key) Integer.valueOf(AEAFHelp.m11155c()));
                        }
                        PanoramaCapMode.this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) false);
                        PanoramaCapMode.this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
                        PanoramaCapMode.this.f15052t = false;
                        PanoramaCapMode c2840f2 = PanoramaCapMode.this;
                        c2840f2.pictureTakenCallback(null, 0, 0, Util.m24243a(c2840f2.getImageFormat()), false, false, 0L, 0);
                        return;
                    case 7:
                        synchronized (PanoramaCapMode.f15000i) {
                            if (!PanoramaCapMode.this.f15010J && PanoramaCapMode.this.f15009I != null && PanoramaCapMode.this.f15007G != null && !PanoramaCapMode.this.f15011K) {
                                Bitmap bitmapM14966a = PanoRenderScriptUtil.m14966a(PanoramaCapMode.this.mActivity, (byte[]) message.obj, PanoramaCapMode.this.f15007G.getWidth(), PanoramaCapMode.this.f15007G.getHeight(), PanoramaCapMode.this.f15024X, PanoramaCapMode.this.f15023W);
                                if (!PanoramaCapMode.this.mbPaused && bitmapM14966a != null) {
                                    Bitmap bitmapM24221a = Util.m24221a(bitmapM14966a, 0, 0, bitmapM14966a.getWidth(), bitmapM14966a.getHeight(), PanoramaCapMode.this.f15031ae, true);
                                    PanoramaCapMode.this.f15009I.setFrameSize(bitmapM24221a.getWidth());
                                    PanoramaCapMode.this.f15009I.m14906a(bitmapM24221a, 0, 0);
                                }
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.f15040g = new FrontPanoramaGuideView.InterfaceC2832a() { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_12.7
            @Override // com.oplus.camera.panorama.FrontPanoramaGuideView.InterfaceC2832a
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo14880a(int OplusGLSurfaceView_13) {
                if (PanoramaCapMode.this.f15001A == null || PanoramaCapMode.this.f15058z == null) {
                    return;
                }
                PanoramaCapMode.this.f15001A.setText(PanoramaCapMode.this.f15058z.getCurrentGuideTips());
            }
        };
        this.f15041h = new PanoramaProgressBar.RearPanoramaInterface() { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_12.8
            @Override // com.oplus.camera.panorama.PanoramaProgressBar.RearPanoramaInterface
            public void onReportDirectionChange(int OplusGLSurfaceView_13) {
                PanoramaCapMode.this.m15054f(OplusGLSurfaceView_13);
            }
        };
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean needSurface(String str) {
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
        return this.mCameraInterface.mo10575i();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getFrontEnable() {
        return this.mCameraInterface.mo10575i() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FRONT_PANORAMA_SUPPORT);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onInitCameraMode() {
        CameraLog.m12954a("PanoramaCapMode", "onInitCameraMode()");
        this.f15054v = true;
        this.f15053u = false;
        this.f15016P = false;
        this.f15002B = this.mActivity.getResources();
        m15066k();
        this.f15013M = this.mCameraInterface.mo10591u();
        this.f15013M = this.mbFrontCamera ? this.f15013M : 0;
        this.mCameraUIInterface.mo18174b(true);
        m15039b(true);
        this.mCameraUIInterface.mo18204e(CameraUIInterface.KEY_PHOTO_RATIO);
        this.mCameraUIInterface.mo18164b(2);
        this.mCameraUIInterface.mo18187c(this.mActivity.getString(R.string.camera_description_common_shutter_button));
        m15063j();
        CameraLog.m12954a("PanoramaCapMode", "onInitCameraMode X");
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m15063j() {
        HintManager c3130aMo18233k = this.mCameraUIInterface.mo18233k();
        if (c3130aMo18233k != null) {
            c3130aMo18233k.m18484a(new HintManager.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_12.11
                @Override // com.oplus.camera.p172ui.p173a.HintManager.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo14771a(HintModel c3131b) {
                    if (PanoramaCapMode.this.mbFrontCamera && c3131b.f17461f) {
                        if (PanoramaCapMode.this.f15052t && PanoramaCapMode.this.f15001A != null && PanoramaCapMode.this.f15001A.isShown()) {
                            PanoramaCapMode.this.f15001A.setVisibility(8);
                        }
                        if (PanoramaCapMode.this.f15052t || PanoramaCapMode.this.f15005E == null || !PanoramaCapMode.this.f15005E.isShown()) {
                            return;
                        }
                        PanoramaCapMode.this.f15005E.m18813b(false);
                    }
                }

                @Override // com.oplus.camera.p172ui.p173a.HintManager.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo14770a(int OplusGLSurfaceView_13) {
                    if (PanoramaCapMode.this.mbFrontCamera) {
                        if (PanoramaCapMode.this.f15052t && PanoramaCapMode.this.f15001A != null) {
                            PanoramaCapMode.this.f15001A.setVisibility(0);
                        }
                        if (PanoramaCapMode.this.f15052t || PanoramaCapMode.this.f15005E == null || PanoramaCapMode.this.mCameraUIInterface == null || PanoramaCapMode.this.mCameraUIInterface.mo18057R()) {
                            return;
                        }
                        PanoramaCapMode.this.f15005E.m18806a(new CameraScreenHintInfo.PlatformImplementations.kt_3().m18845a(PanoramaCapMode.this.mActivity.getString(R.string.camera_panorama_front_previewing)).m18846a(true).m18849b(false).m18844a(R.drawable.screen_hint_textview_bg).m18848b(R.color.screen_hint_text_color).m18847a());
                    }
                }
            });
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m15066k() {
        this.f15051s = Util.m24186N();
        this.f15042j = Util.m24498u() ? (int) (Util.getScreenHeight() / 1.3333333333333333d) : Util.getScreenWidth();
        this.f15043k = this.f15002B.getDimensionPixelSize(R.dimen.panorama_rect_height);
        this.f15044l = this.f15002B.getDimensionPixelSize(R.dimen.panorama_rect_to_left);
        this.f15045m = this.f15002B.getDimensionPixelSize(R.dimen.panorama_rect_to_top);
        this.f15046n = this.f15002B.getDimensionPixelSize(R.dimen.panorama_progressbar_margin_top);
        this.f15047o = this.f15002B.getDimensionPixelSize(R.dimen.panorama_progressbar_margin_left);
        this.f15050r = this.f15002B.getDimensionPixelSize(R.dimen.panorama_view_gap);
        int OplusGLSurfaceView_13 = this.f15043k;
        this.f15020T = OplusGLSurfaceView_13 - (this.f15046n * 2);
        this.f15049q = ((this.f15045m + OplusGLSurfaceView_13) - this.f15051s) - this.f15002B.getDimensionPixelSize(R.dimen.panorama_text_extra_offset);
        this.f15022V = Math.round(Util.m24483o() * 150.0f);
        if (this.f15004D == null || Util.m24495t()) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mActivity);
            this.f15004D = (RelativeLayout) layoutInflaterFrom.inflate(this.f15002B.getLayout(R.layout.panorama), (ViewGroup) null);
            this.f15005E = (CameraScreenHintView) layoutInflaterFrom.inflate(this.f15002B.getLayout(R.layout.camera_screen_hint), (ViewGroup) null);
            this.f15005E.setChangeHintColor(true);
            this.f15005E.setChangeHintTextShadow(true);
            this.f15005E.setCameraScreenHintInterface(new CameraScreenHintInterface() { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_12.12
                @Override // com.oplus.camera.p172ui.camerascreenhint.CameraScreenHintInterface
                /* renamed from: PlatformImplementations.kt_3 */
                public boolean mo15097a() {
                    return PanoramaCapMode.this.isBottomGuideEntryViewShown();
                }
            });
            this.f15057y = (ImageView) this.f15004D.findViewById(R.id_renamed.preview_view);
            this.f15058z = (FrontPanoramaGuideView) this.f15004D.findViewById(R.id_renamed.capture_guide_view);
            this.f15058z.setOnDirectionChangeListener(this.f15040g);
            this.f15001A = (TextView) this.f15004D.findViewById(R.id_renamed.capture_guide_tips);
            this.f15009I = new PanoramaProgressBar(this.mActivity);
            this.f15009I.setRearPanoramaInterface(this.f15041h);
            this.f15009I.setForceDarkAllowed(false);
            this.f15009I.setContentDescription(this.mActivity.getString(R.string.camera_description_arrow_left_to_right));
            if (Util.m24495t()) {
                m15080r();
            } else {
                this.f15009I.setRectMarginLeft(0);
            }
            this.f15004D.addView(this.f15005E);
            this.f15004D.addView(this.f15009I);
            this.f15004D.setVisibility(8);
            this.mCameraRootView.removeView(this.f15004D);
            this.mCameraRootView.addView(this.f15004D);
        }
        m15046d(this.mCameraId);
        this.f15009I.m14909c();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onDeInitCameraMode(String str) {
        CameraLog.m12954a("PanoramaCapMode", "onDeInitCameraMode()");
        this.f15054v = false;
        this.f15052t = false;
        this.f15016P = false;
        this.f15005E.m18813b(false);
        Handler handler = this.f15039am;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        m15070m();
        m15078q();
        if (this.mOneCamera != null) {
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_SCENE_MODE, (CaptureRequest.Key) 0);
            this.mOneCamera.mo13071b(false, false);
            this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) false);
            this.mOneCamera.mo13029a(4, AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
        }
        this.mCameraUIInterface.mo18171b(CameraUIInterface.KEY_PHOTO_RATIO, (String) null);
        this.mCameraUIInterface.mo18164b(1);
        HintManager c3130aMo18233k = this.mCameraUIInterface.mo18233k();
        if (c3130aMo18233k != null) {
            c3130aMo18233k.m18484a((HintManager.IntrinsicsJvm.kt_4) null);
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m15068l() {
        if (this.f15004D != null) {
            PanoramaProgressBar panoramaProgressBar = this.f15009I;
            if (panoramaProgressBar != null) {
                panoramaProgressBar.m14910d();
                this.f15004D.removeView(this.f15009I);
                this.f15009I = null;
            }
            if (this.f15005E != null) {
                this.f15005E = null;
            }
            if (this.f15057y != null) {
                this.f15057y = null;
            }
            FrontPanoramaGuideView frontPanoramaGuideView = this.f15058z;
            if (frontPanoramaGuideView != null) {
                frontPanoramaGuideView.m14879b();
                this.f15058z = null;
            }
            if (this.f15001A != null) {
                this.f15001A = null;
            }
            this.f15004D.removeAllViews();
            this.mCameraRootView.removeView(this.f15004D);
            this.f15004D = null;
        }
        m15074o();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m15070m() {
        CameraLog.m12954a("PanoramaCapMode", "releaseRearPanorama");
        synchronized (f15000i) {
            this.f15010J = false;
            if (this.f15029ac != null) {
                this.f15029ac.m15107a();
                this.f15029ac.m15111b();
                this.f15029ac = null;
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onResume(boolean z) {
        CameraLog.m12954a("PanoramaCapMode", "onResume");
        if (this.f15009I != null) {
            if (Util.m24495t()) {
                m15080r();
                this.f15009I.m14904a(this.f15042j, this.f15043k, this.f15044l, this.f15045m, this.f15046n, this.f15047o);
            }
            this.f15009I.m14909c();
            this.f15009I.postInvalidate();
        }
        RelativeLayout relativeLayout = this.f15004D;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
            this.f15004D.setAlpha(1.0f);
        }
        if (this.mbFrontCamera) {
            m15092b(8);
        }
        this.mCameraUIInterface.mo18215g(0);
        this.mCameraUIInterface.mo18092a(getShutterButtonInfo(), false);
        this.mCameraUIInterface.mo18184c(0);
        this.mCameraUIInterface.mo18193d(getFrontEnable() ? 0 : 4);
        this.mCameraUIInterface.mo18209f(0);
        this.mCameraUIInterface.mo18167b(0, true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onCancelTakePicture() {
        this.f15039am.removeCallbacksAndMessages(null);
        PanoramaProgressBar panoramaProgressBar = this.f15009I;
        if (panoramaProgressBar != null) {
            panoramaProgressBar.m14909c();
            this.f15009I.postInvalidate();
        }
        this.mCameraUIInterface.mo18092a(getShutterButtonInfo(), false);
        if (this.mbFrontCamera) {
            this.f15039am.removeMessages(1);
            Handler handler = this.f15039am;
            handler.sendMessage(handler.obtainMessage(1, true));
        } else {
            m15061i();
        }
        this.f15052t = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onPause() {
        CameraLog.m12954a("PanoramaCapMode", "onPause");
        if (this.f15052t) {
            onCancelTakePicture();
        }
        m15070m();
        m15095c(4);
        this.f15057y.setVisibility(4);
        this.mCameraUIInterface.mo18215g(0);
        if (this.mbFrontCamera) {
            this.f15005E.m18813b(false);
        }
        this.f15053u = false;
        this.f15011K = false;
        FrontPanoramaEngine c2838d = this.f15037ak;
        if (c2838d != null) {
            c2838d.m14947a();
            this.f15037ak.m14950b(false);
            this.f15037ak.m14954d();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onDestroy() {
        m15068l();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onBackPressed() {
        FrontPanoramaEngine c2838d = this.f15037ak;
        if (c2838d != null) {
            c2838d.m14955e();
        }
        return super.onBackPressed();
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.f15010J || this.f15052t || this.mbFrontCamera || this.f15009I == null) {
            return false;
        }
        this.f15039am.removeMessages(4);
        this.f15039am.sendEmptyMessageDelayed(4, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        return this.f15009I.m14907a(motionEvent);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePreview() {
        CameraLog.m12954a("PanoramaCapMode", "onBeforePreview");
        this.f15053u = false;
        if (!this.mbFrontCamera) {
            this.f15039am.removeMessages(3);
            this.f15039am.obtainMessage(3, 0).sendToTarget();
        }
        this.mbEnableTuningData = false;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onAfterStartPreview(boolean z) {
        CameraLog.m12954a("PanoramaCapMode", "onAfterStartPreview");
        final boolean z2 = this.f15036aj != Util.m24451g();
        if (!this.f15053u || z2) {
            this.f15036aj = Util.m24451g();
            this.f15053u = true;
            this.f15016P = true;
            this.f15052t = false;
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_12.13
                @Override // java.lang.Runnable
                public void run() throws Resources.NotFoundException {
                    if (PanoramaCapMode.this.mbFrontCamera) {
                        if (PanoramaCapMode.this.f15037ak != null) {
                            PanoramaCapMode.this.f15037ak.m14947a();
                        }
                        PanoramaCapMode.this.m15090a(true);
                        PanoramaCapMode.this.m15076p();
                        return;
                    }
                    PanoramaCapMode c2840f = PanoramaCapMode.this;
                    c2840f.f15007G = c2840f.getPreviewFrameSize(c2840f.mOneCamera.mo13086e());
                    PanoramaCapMode c2840f2 = PanoramaCapMode.this;
                    c2840f2.f15026Z = c2840f2.f15007G.getWidth() / 2;
                    PanoramaCapMode c2840f3 = PanoramaCapMode.this;
                    c2840f3.f15021U = (c2840f3.f15020T * PanoramaCapMode.this.f15007G.getHeight()) / PanoramaCapMode.this.f15007G.getWidth();
                    PanoramaCapMode c2840f4 = PanoramaCapMode.this;
                    c2840f4.f15024X = c2840f4.f15007G.getWidth() / 8;
                    PanoramaCapMode c2840f5 = PanoramaCapMode.this;
                    c2840f5.f15023W = ((c2840f5.f15007G.getHeight() / 8) / 2) * 2;
                    PanoramaCapMode.this.f15027aa = r0.f15020T / PanoramaCapMode.this.f15024X;
                    PanoramaCapMode.this.f15025Y = Util.m24498u() ? (int) (((Util.getScreenHeight() / 1.3333333333333333d) - (PanoramaCapMode.this.f15047o * 2)) / PanoramaCapMode.this.f15027aa) : (int) ((Util.getScreenWidth() - (PanoramaCapMode.this.f15047o * 2)) / PanoramaCapMode.this.f15027aa);
                    if (Util.m24498u()) {
                        PanoramaCapMode.this.f15026Z = (int) (r0.f15042j / PanoramaCapMode.this.f15027aa);
                    }
                    CameraLog.m12959b("PanoramaCapMode", "onAfterStartPreview, mUpdateRectLimit: " + PanoramaCapMode.this.f15026Z + ", mRearThumbnailMaxWidth: " + PanoramaCapMode.this.f15025Y);
                    PanoramaCapMode.this.f15031ae.reset();
                    PanoramaCapMode.this.f15031ae.postRotate(90.0f);
                    PanoramaCapMode.this.f15031ae.postScale(PanoramaCapMode.this.f15027aa, PanoramaCapMode.this.f15027aa);
                    synchronized (PanoramaCapMode.f15000i) {
                        if (PanoramaCapMode.this.f15029ac == null || z2) {
                            PanoramaCapMode.this.f15029ac = new RearPanoramaEngine(PanoramaCapMode.this.mActivity, PanoramaCapMode.this.f15007G.getWidth(), PanoramaCapMode.this.f15007G.getHeight(), PanoramaCapMode.this);
                        }
                    }
                }
            });
            super.onAfterStartPreview(z);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onSessionConfigured() {
        super.onSessionConfigured();
        this.mOneCamera.mo13071b(false, false);
        this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) false);
        this.mOneCamera.mo13029a(4, AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onBeforeSnapping(CameraRequestTag c2693c) {
        CameraLog.m12954a("PanoramaCapMode", "onBeforeSnapping, mOrientation: " + this.f15013M);
        this.f15033ag = true;
        if (this.mbFrontCamera) {
            CameraLog.m12954a("PanoramaCapMode", "createEngine enter, mbPaused: " + this.mbPaused + ", mbStartPreviewed: " + this.f15053u);
            if (this.f15037ak != null && !this.mbPaused && this.f15053u) {
                boolean z = this.mCameraInterface.mo10591u() % 180 == 0;
                this.f15014N = this.mCameraInterface.mo10591u();
                this.f15037ak.m14948a(z);
            }
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_12.14
            @Override // java.lang.Runnable
            public void run() {
                if (!PanoramaCapMode.this.mbPaused) {
                    if (!PanoramaCapMode.this.mbFrontCamera) {
                        synchronized (PanoramaCapMode.f15000i) {
                            if (PanoramaCapMode.this.f15029ac != null && PanoramaCapMode.this.f15009I != null) {
                                PanoramaCapMode.this.f15039am.removeMessages(4);
                                PanoramaCapMode.this.f15030ad = null;
                                PanoramaCapMode.this.f15028ab = 0;
                                PanoramaCapMode.this.f15018R = PanoramaCapMode.this.f15009I.getDirection();
                                PanoramaCapMode.this.f15029ac.m15108a(PanoramaCapMode.this.f15018R);
                                PanoramaCapMode.this.f15010J = true;
                                PanoramaCapMode.this.mCameraUIInterface.mo18107a(true, false);
                            }
                        }
                        PanoramaCapMode.this.f15052t = true;
                        PanoramaCapMode c2840f = PanoramaCapMode.this;
                        c2840f.setOrientation(c2840f.f15013M);
                        PanoramaCapMode.this.m15092b(0);
                        PanoramaCapMode.this.mCameraUIInterface.mo18167b(4, true);
                    }
                    PanoramaCapMode.this.mCameraUIInterface.mo18215g(4);
                    PanoramaCapMode.this.mCameraUIInterface.mo18193d(4);
                    PanoramaCapMode.this.mCameraUIInterface.mo18209f(4);
                    if (PanoramaCapMode.this.isPanelMode()) {
                        PanoramaCapMode.this.mCameraUIInterface.mo18077a(8, false);
                    } else {
                        PanoramaCapMode.this.mCameraUIInterface.mo18068a(8, 1);
                    }
                    MainShutterButtonInfo c3200b = Util.m24352ao() ? new MainShutterButtonInfo(5, "button_color_inside_hasselblad", "button_shape_ring_none", 3) : new MainShutterButtonInfo(10, "button_color_inside_none");
                    c3200b.m19230b(0);
                    PanoramaCapMode.this.mCameraUIInterface.mo18091a(c3200b);
                    return;
                }
                CameraLog.m12954a("PanoramaCapMode", "onBeforeSnapping, return after pause");
            }
        });
        if (1 != this.mOneCamera.mo13122p()) {
            this.mOneCamera.mo13116n();
        }
        this.f15055w = false;
        this.mOneCamera.mo13071b(true, false);
        this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) true);
        this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean onAfterSnapping() {
        CameraLog.m12954a("PanoramaCapMode", "onAfterSnapping");
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_12.15
            @Override // java.lang.Runnable
            public void run() {
                if (PanoramaCapMode.this.mbFrontCamera) {
                    PanoramaCapMode.this.f15005E.m18813b(true);
                    PanoramaCapMode.this.mCameraInterface.mo10558c(Util.m24352ao() ? 6 : 4);
                    PanoramaCapMode.this.f15058z.setNextDirection(1);
                    PanoramaCapMode.this.m15095c(0);
                    PanoramaCapMode.this.f15052t = true;
                    return;
                }
                PanoramaCapMode.this.f15005E.m18802a(PanoramaCapMode.this.f15049q, 0, 0, false);
                PanoramaCapMode.this.f15005E.clearAnimation();
                PanoramaCapMode.this.f15005E.m18806a(new CameraScreenHintInfo.PlatformImplementations.kt_3().m18845a(PanoramaCapMode.this.mActivity.getResources().getString(R.string.camera_panorama_rear_capturing)).m18846a(false).m18849b(true).m18847a());
                PanoramaCapMode.this.mCameraInterface.mo10558c(Util.m24352ao() ? 6 : 4);
                PanoramaCapMode.this.f15011K = true;
            }
        });
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getCanAddMenuOption(String str) {
        if (CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(str) || CameraUIInterface.KEY_PHOTO_RATIO.equals(str)) {
            return false;
        }
        return super.getCanAddMenuOption(str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewFrameSize(OplusCameraCharacteristics c2698h) {
        int OplusGLSurfaceView_13;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(c2698h.m13257a());
        if (this.mbFrontCamera && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_CONFIGURE_STREAM_SIZE_CUSTOM)) {
            CameraDeviceInfo cameraDeviceInfoMo10503aE = this.mCameraInterface != null ? this.mCameraInterface.mo10503aE() : null;
            int[] iArr = cameraDeviceInfoMo10503aE != null ? (int[]) cameraDeviceInfoMo10503aE.get(CameraMetadataKey.f13364u) : null;
            if (iArr != null) {
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    if (i2 % 2 == 0 && (OplusGLSurfaceView_13 = i2 + 1) < iArr.length) {
                        arrayList.add(new Size(iArr[i2], iArr[OplusGLSurfaceView_13]));
                    }
                }
            }
        }
        if (this.mbFrontCamera || Util.m24495t()) {
            return Util.m24379b(arrayList, 1.3333333333333333d, CameraConfig.getConfigIntValue(ConfigDataBase.KEY_FRONT_PANORAMA_MAX_HEIGHT));
        }
        int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_REAR_PANORAMA_MAX_HEIGHT);
        Size sizeM24379b = Util.m24379b(arrayList, Util.m24196X(), configIntValue);
        return sizeM24379b != null ? sizeM24379b : Util.m24413c(arrayList, Util.m24196X(), configIntValue);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPictureSize(OplusCameraCharacteristics c2698h) {
        if (this.mbFrontCamera || Util.m24495t()) {
            return Util.m24378b(c2698h.m13258a(256), 1.3333333333333333d);
        }
        return null;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h, double IntrinsicsJvm.kt_5) {
        if (Util.m24495t()) {
            return super.getPreviewSize(c2698h, 1.3333333333333333d);
        }
        return super.getPreviewSize(c2698h, IntrinsicsJvm.kt_5);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h, String str) {
        if (Util.m24495t()) {
            return super.getPreviewSize(c2698h, 1.3333333333333333d);
        }
        return super.getPreviewSize(c2698h, str);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public Size getPreviewSize(OplusCameraCharacteristics c2698h) {
        if (Util.m24495t()) {
            return super.getPreviewSize(c2698h, 1.3333333333333333d);
        }
        return super.getPreviewSize(c2698h);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean getZSLMode() {
        if (this.mbFrontCamera) {
            return super.getZSLMode();
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public boolean isAllowSwitch(CameraConstant.PlatformImplementations.kt_3 aVar) {
        CameraLog.m12954a("PanoramaCapMode", "isAllowSwitch, mbStartPreviewed: " + this.f15053u);
        if (this.f15016P) {
            return !this.f15052t && this.f15053u;
        }
        return true;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public MainShutterButtonInfo getShutterButtonInfo() {
        MainShutterButtonInfo shutterButtonInfo = super.getShutterButtonInfo();
        if (Util.m24352ao()) {
            shutterButtonInfo.m19226a(23);
        }
        shutterButtonInfo.m19235c("button_shape_ring_none");
        return shutterButtonInfo;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0089  */
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
            com.oplus.camera.capmode.PlatformImplementations.kt_3 r4 = r3.mCameraInterface
            if (r4 == 0) goto Lab
            com.oplus.camera.capmode.PlatformImplementations.kt_3 r3 = r3.mCameraInterface
            boolean r3 = r3.mo10575i()
            if (r3 == 0) goto Lab
            return r2
        Lab:
            return r1
        Lac:
            java.lang.String r3 = "com.oplus.feature.front.panorama.support"
            boolean r3 = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(r3)
            return r3
        Lb3:
            com.oplus.camera.capmode.PlatformImplementations.kt_3 r3 = r3.mCameraInterface
            int r3 = r3.mo10570g()
            if (r3 != r2) goto Lbc
            r1 = r2
        Lbc:
            return r1
        Lbd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.panorama.PanoramaCapMode.getSupportFunction(java.lang.String):boolean");
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected boolean onStopTakePicture() {
        this.f15055w = true;
        this.f15032af = this.mCameraInterface.mo10532ah();
        if (this.mbFrontCamera) {
            CameraLog.m12954a("PanoramaCapMode", "onStopTakePicture, mFrontJpegCount: " + this.f15015O + ", mbSnapShoting: " + this.f15052t);
            int OplusGLSurfaceView_13 = this.f15015O;
            if (OplusGLSurfaceView_13 == 0) {
                return false;
            }
            if (this.f15052t && OplusGLSurfaceView_13 > 0) {
                this.f15052t = false;
                this.f15017Q = true;
                final MainShutterButtonInfo c3200b = new MainShutterButtonInfo(11, "button_color_inside_none");
                c3200b.m19230b(0);
                this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_12.16
                    @Override // java.lang.Runnable
                    public void run() {
                        PanoramaCapMode.this.mCameraUIInterface.mo18091a(c3200b);
                    }
                });
                FrontPanoramaEngine c2838d = this.f15037ak;
                if (c2838d != null) {
                    c2838d.m14953c();
                }
            }
            return true;
        }
        CameraLog.m12954a("PanoramaCapMode", "onStopTakePicture, mbPanning: " + this.f15010J + ", mbSnapShoting: " + this.f15052t + ", mbRearCapturePicSaveDone: " + this.f15012L);
        m15061i();
        return this.f15052t || this.f15009I.m14911e() || !this.f15012L;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onAfterPictureTaken(byte[] bArr, boolean z) {
        if (this.mbFrontCamera) {
            this.mCameraUIInterface.mo18200d(true, false);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15092b(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("PanoramaCapMode", "setProgressBarVisble, visible: " + OplusGLSurfaceView_13);
        CameraScreenHintView cameraScreenHintView = this.f15005E;
        if (cameraScreenHintView == null) {
            return;
        }
        if (OplusGLSurfaceView_13 == 0) {
            cameraScreenHintView.m18802a(this.f15049q, 0, 0, false);
            String string = this.mActivity.getString(R.string.camera_panorama_rear_prepare);
            if (this.f15005E.getHintTextView().getVisibility() != 0 || !string.equals(this.f15005E.getHintTextView().getText())) {
                this.f15005E.clearAnimation();
                this.f15005E.m18806a(new CameraScreenHintInfo.PlatformImplementations.kt_3().m18845a(string).m18846a(false).m18849b(false).m18844a(R.drawable.screen_hint_textview_bg).m18848b(R.color.screen_hint_text_color).m18847a());
            }
        } else {
            cameraScreenHintView.m18813b(false);
        }
        PanoramaProgressBar panoramaProgressBar = this.f15009I;
        if (panoramaProgressBar == null || panoramaProgressBar.getVisibility() == OplusGLSurfaceView_13) {
            return;
        }
        this.f15009I.setVisibility(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void setOrientation(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("PanoramaCapMode", "setOrientation(), orientation: " + OplusGLSurfaceView_13);
        if (this.mbFrontCamera) {
            this.f15013M = OplusGLSurfaceView_13;
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void onBeforePictureTaken(byte[] bArr, boolean z) {
        this.mCameraUIInterface.mo18107a(true, false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void cameraIdChanged(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("PanoramaCapMode", "cameraIdChanged, mCameraId: " + this.mCameraId);
        super.cameraIdChanged(OplusGLSurfaceView_13);
        Handler handler = this.f15039am;
        if (handler != null) {
            handler.removeMessages(3);
            this.f15039am.removeMessages(4);
        }
        PanoramaProgressBar panoramaProgressBar = this.f15009I;
        if (panoramaProgressBar != null) {
            panoramaProgressBar.m14913g();
        }
        m15070m();
        m15078q();
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_12.2
            @Override // java.lang.Runnable
            public void run() {
                if (PanoramaCapMode.this.mbPaused) {
                    return;
                }
                PanoramaCapMode c2840f = PanoramaCapMode.this;
                c2840f.m15046d(c2840f.mCameraId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m15046d(int OplusGLSurfaceView_13) {
        PanoramaProgressBar panoramaProgressBar = this.f15009I;
        if (panoramaProgressBar != null) {
            panoramaProgressBar.m14904a(this.f15042j, this.f15043k, this.f15044l, this.f15045m, this.f15046n, this.f15047o);
        }
        if (CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13)) {
            this.f15057y.setImageBitmap(null);
            m15092b(8);
            return;
        }
        this.f15057y.setVisibility(8);
        this.f15013M = 0;
        PanoramaProgressBar panoramaProgressBar2 = this.f15009I;
        if (panoramaProgressBar2 != null) {
            panoramaProgressBar2.postInvalidate();
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onUpdateCameraSettingMenu() {
        this.mCameraUIInterface.mo18204e(CameraUIInterface.KEY_PHOTO_RATIO);
        super.onUpdateCameraSettingMenu();
    }

    @Override // com.oplus.camera.panorama.FrontPanoramaEngine.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo14961c() {
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_12.3
                @Override // java.lang.Runnable
                public void run() {
                    PanoramaCapMode.this.mCameraUIInterface.mo18107a(true, false);
                }
            });
        }
    }

    @Override // com.oplus.camera.panorama.FrontPanoramaEngine.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo14962d() {
        if (this.mCameraInterface != null) {
            this.mCameraInterface.mo10558c(Util.m24352ao() ? 7 : 5);
        }
    }

    @Override // com.oplus.camera.panorama.FrontPanoramaEngine.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14959a(boolean z, byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("PanoramaCapMode", "onImageDataSave enter");
        if (bArr != null && this.mCameraInterface != null && this.f15008H != null) {
            if (z) {
                i2 = OplusGLSurfaceView_13;
                OplusGLSurfaceView_13 = i2;
            }
            Storage.CameraPicture cameraPicture = new Storage.CameraPicture();
            cameraPicture.f12142o = OplusGLSurfaceView_13;
            cameraPicture.f12143p = i2;
            cameraPicture.f12132e = bArr;
            cameraPicture.f12135h = getHeicCodecFormat() != null ? getHeicCodecFormat() : CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG;
            cameraPicture.f12147t = Util.m24369b(cameraPicture.f12132e);
            cameraPicture.mPath = null;
            cameraPicture.f12106D = true;
            cameraPicture.f12107E = this.mbDisplayOnLock;
            cameraPicture.f12131d = this.mCameraInterface.mo10595y();
            this.mCameraInterface.mo10483a(cameraPicture, true);
        }
        mo14956a();
        this.f15014N = 0;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected Thumbnail.IntrinsicsJvm.kt_3 getAfterStoreRunnable() {
        return new Thumbnail.IntrinsicsJvm.kt_3() { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_12.4
            @Override // com.oplus.camera.p172ui.control.Thumbnail.IntrinsicsJvm.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo12685a(long OplusGLSurfaceView_15) {
                PanoramaCapMode.this.f15012L = true;
            }
        };
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15090a(boolean z) throws Resources.NotFoundException {
        int dimensionPixelOffset;
        int dimensionPixelSize;
        CameraLog.m12954a("PanoramaCapMode", "initFrontPanorama, mbPaused: " + this.mbPaused + ", mbStartPreviewed: " + this.f15053u + ", mViewGroup: " + this.f15004D);
        if (this.mbPaused || this.f15004D == null || !this.f15053u || this.mCameraUIInterface.mo18057R()) {
            return;
        }
        synchronized (this.f15003C) {
            if (this.f15056x != null) {
                this.f15056x.recycle();
                this.f15056x = null;
            }
        }
        this.f15015O = 0;
        this.f15008H = getPictureSize(this.mOneCamera.mo13086e());
        this.f15006F = getPreviewFrameSize(this.mOneCamera.mo13086e());
        if (this.f15006F != null) {
            synchronized (this.f15003C) {
                if (Util.m24495t()) {
                    if (Util.m24498u()) {
                        dimensionPixelOffset = this.f15002B.getDimensionPixelOffset(R.dimen.full_screen_panorama_front_preview_margin_top);
                    } else {
                        dimensionPixelOffset = this.f15002B.getDimensionPixelOffset(R.dimen.out_screen_panorama_front_preview_margin_top);
                    }
                } else {
                    dimensionPixelOffset = this.f15050r + this.f15051s;
                }
                this.f15056x = Util.m24215a((this.f15006F.getHeight() * 2) / 6, this.f15006F.getWidth() / 6, Bitmap.Config.ARGB_8888);
                int width = (int) (((this.f15056x.getWidth() * 1.0f) * this.f15043k) / this.f15056x.getHeight());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, this.f15043k);
                layoutParams.addRule(10);
                layoutParams.addRule(9);
                layoutParams.topMargin = dimensionPixelOffset;
                layoutParams.leftMargin = (Util.getScreenWidth() - width) / 2;
                if (z) {
                    this.f15057y.setImageBitmap(null);
                }
                this.f15057y.setLayoutParams(layoutParams);
                this.f15057y.setVisibility(0);
            }
            this.f15004D.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(14);
            if (Util.m24498u()) {
                dimensionPixelSize = this.f15002B.getDimensionPixelOffset(R.dimen.full_screen_panorama_front_hint_margin_top);
            } else {
                dimensionPixelSize = this.f15002B.getDimensionPixelSize(R.dimen.front_panorama_guide_tips_margin_top) + this.f15051s;
            }
            layoutParams2.topMargin = dimensionPixelSize;
            this.f15001A.setLayoutParams(layoutParams2);
            CameraLog.m12954a("PanoramaCapMode", "initFrontPanorama, mPictureSize: " + this.f15008H.getWidth() + " x " + this.f15008H.getHeight() + ", mPreviewFrameSize: " + this.f15006F.getWidth() + " x " + this.f15006F.getHeight());
        }
        this.f15005E.m18802a(this.f15048p, 0, 0, false);
        CameraScreenHintInfo c3147aM18847a = new CameraScreenHintInfo.PlatformImplementations.kt_3().m18845a(this.mActivity.getString(R.string.camera_panorama_front_previewing)).m18846a(true).m18849b(false).m18844a(R.drawable.screen_hint_textview_bg).m18848b(R.color.screen_hint_text_color).m18847a();
        this.f15005E.setScreenLayoutParams(this.mCameraInterface.mo10519aU());
        this.f15005E.m18806a(c3147aM18847a);
        m15039b(false);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected void hideViewWhileResume() {
        PanoramaProgressBar panoramaProgressBar = this.f15009I;
        if (panoramaProgressBar != null) {
            panoramaProgressBar.setVisibility(8);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void showLowMemory() {
        if (this.mbFrontCamera) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_12.5
                @Override // java.lang.Runnable
                public void run() {
                    PanoramaCapMode.this.f15005E.m18806a(new CameraScreenHintInfo.PlatformImplementations.kt_3().m18845a(PanoramaCapMode.this.mActivity.getString(R.string.camera_toast_camera_Low_memory_hint)).m18846a(false).m18849b(true).m18847a());
                }
            });
        } else {
            this.mCameraUIInterface.mo18070a(R.string.camera_toast_camera_Low_memory_hint, -1, true, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_11 */
    public void m15072n() {
        if (this.f15053u) {
            pictureTakenCallback(null, 0, 0, Util.m24243a(getImageFormat()), false, false, 0L, 0);
        }
        this.mCameraUIInterface.mo18215g(0);
        if (!this.f15017Q && !this.mbPaused) {
            MainShutterButtonInfo c3200b = new MainShutterButtonInfo(11, "button_color_inside_none");
            c3200b.m19230b(0);
            this.mCameraUIInterface.mo18091a(c3200b);
        }
        this.f15017Q = false;
        this.mCameraUIInterface.mo18184c(0);
        this.mCameraUIInterface.mo18193d(0);
        this.mCameraUIInterface.mo18209f(0);
        if (isPanelMode()) {
            this.mCameraUIInterface.mo18077a(0, true);
        } else {
            this.mCameraUIInterface.mo18068a(0, 1);
        }
        this.mOneCamera.mo13071b(false, false);
        this.mOneCamera.mo13032a((CaptureRequest.Key<CaptureRequest.Key>) CaptureRequest.CONTROL_AWB_LOCK, (CaptureRequest.Key) false);
        this.mOneCamera.mo13029a(4, AEAFHelp.m11154b(), AEAFHelp.m11154b(), true);
        this.mOneCamera.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        this.f15052t = false;
        this.f15015O = 0;
        m15095c(4);
    }

    /* renamed from: o */
    private void m15074o() {
        synchronized (this.f15003C) {
            if (this.f15056x != null) {
                this.f15056x.recycle();
                this.f15056x = null;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m15095c(final int OplusGLSurfaceView_13) {
        AlphaAnimation alphaAnimation;
        FrontPanoramaGuideView frontPanoramaGuideView = this.f15058z;
        if (frontPanoramaGuideView != null) {
            if (frontPanoramaGuideView.getVisibility() != OplusGLSurfaceView_13) {
                if (OplusGLSurfaceView_13 == 0) {
                    m15039b(false);
                    alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                }
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_12.6
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        if (OplusGLSurfaceView_13 == 0) {
                            PanoramaCapMode.this.f15058z.setVisibility(OplusGLSurfaceView_13);
                            PanoramaCapMode.this.f15001A.setVisibility(OplusGLSurfaceView_13);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        PanoramaCapMode.this.f15058z.setVisibility(OplusGLSurfaceView_13);
                        PanoramaCapMode.this.f15001A.setVisibility(OplusGLSurfaceView_13);
                    }
                });
                this.f15001A.clearAnimation();
                this.f15001A.startAnimation(alphaAnimation);
                this.f15058z.clearAnimation();
                this.f15058z.startAnimation(alphaAnimation);
                return;
            }
            Animation animation = this.f15058z.getAnimation();
            if (animation != null) {
                animation.reset();
                animation.cancel();
            }
            this.f15001A.clearAnimation();
            this.f15001A.setVisibility(OplusGLSurfaceView_13);
            this.f15058z.clearAnimation();
            this.f15058z.setVisibility(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void changeModeAllViewWhenAnimation(int OplusGLSurfaceView_13, boolean z) {
        super.changeModeAllViewWhenAnimation(OplusGLSurfaceView_13, z);
        if (OplusGLSurfaceView_13 == 2) {
            if (z) {
                Util.m24270a(this.f15004D, 0, (Animation.AnimationListener) null, 300L);
                return;
            }
            this.f15005E.m18813b(false);
            m15039b(true);
            this.f15004D.setVisibility(8);
            return;
        }
        if (OplusGLSurfaceView_13 == 5) {
            if (z) {
                if (this.mbFrontCamera) {
                    return;
                }
                m15092b(0);
                return;
            }
            m15092b(8);
            return;
        }
        if (OplusGLSurfaceView_13 == 18) {
            if (z) {
                return;
            }
            Util.m24270a(this.f15004D, 8, (Animation.AnimationListener) null, 300L);
        } else if (OplusGLSurfaceView_13 == 19 && z) {
            Util.m24270a(this.f15004D, 0, (Animation.AnimationListener) null, 300L);
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetBeforeCaptureMsgCommonData(DcsMsgData dcsMsgData) {
        PanoramaProgressBar panoramaProgressBar;
        if (dcsMsgData == null || !(dcsMsgData instanceof CaptureMsgData)) {
            return null;
        }
        CaptureMsgData captureMsgData = (CaptureMsgData) dcsMsgData;
        captureMsgData.mShutterType = getCameraShutterType();
        if (this.mbFrontCamera || (panoramaProgressBar = this.f15009I) == null) {
            return captureMsgData;
        }
        captureMsgData.mPanoramaDirection = m15049e(panoramaProgressBar.getDirection());
        captureMsgData.mAeAfLock = String.valueOf(this.mCameraInterface.mo10529ae());
        captureMsgData.mTouchXYValue = this.mCameraInterface.mo10530af();
        return captureMsgData;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onPreviewCaptureResult(CameraPreviewCallback.CameraPreviewResult cameraPreviewResult) {
        CaptureResult.Key<int[]> key;
        Object obj;
        super.onPreviewCaptureResult(cameraPreviewResult);
        if (cameraPreviewResult == null || cameraPreviewResult.getCaptureResult() == null) {
            CameraLog.m12967f("PanoramaCapMode", "onPreviewCaptureResult, invalid previewResult: " + cameraPreviewResult);
            return;
        }
        if (this.f15033ag) {
            this.f15033ag = false;
            CaptureResult captureResult = cameraPreviewResult.getCaptureResult();
            if (Util.m24169C()) {
                key = CameraMetadataKey.f13254T;
                obj = CameraMetadataKey.f13255U;
            } else {
                key = CameraMetadataKey.f13295ah;
                obj = CameraMetadataKey.f13257W;
            }
            if (key != null) {
                try {
                    this.f15034ah = ((int[]) captureResult.get(key))[0];
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
            if (obj != null) {
                try {
                    this.f15035ai = ((float[]) captureResult.get(obj))[0];
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public DcsMsgData onGetAfterCaptureMsgCommonData(DcsMsgData dcsMsgData, Storage.CameraPicture cameraPicture) {
        if (dcsMsgData != null && (dcsMsgData instanceof CaptureMsgData)) {
            CaptureMsgData captureMsgData = (CaptureMsgData) dcsMsgData;
            if (this.f15055w) {
                captureMsgData.mShutterType += DcsMsgData.DIVIDER + this.f15032af;
            } else {
                captureMsgData.mShutterType += "|end";
            }
            Size sizeM11107a = Storage.m11107a(Util.m24231a(cameraPicture.f12132e));
            if (sizeM11107a != null) {
                captureMsgData.mWidth = String.valueOf(sizeM11107a.getWidth());
                captureMsgData.mHeight = String.valueOf(sizeM11107a.getHeight());
            }
            captureMsgData.mCCT = String.valueOf(this.f15034ah);
            captureMsgData.mLux = String.valueOf(this.f15035ai);
        }
        return super.onGetAfterCaptureMsgCommonData(dcsMsgData, cameraPicture);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected String getPhotoRatio() {
        if (this.mbFrontCamera) {
            return this.mActivity.getString(R.string.camera_picture_size_standard);
        }
        return this.mActivity.getString(R.string.camera_picture_size_full);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    protected int getSwitchAnimTime(int OplusGLSurfaceView_13) {
        if (CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13)) {
            return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_PANORAMA_TO_REAL_SWITCH_ANIM_TIME);
        }
        return CameraConfig.getConfigIntValue(ConfigDataBase.KEY_PANORAMA_TO_FRONT_SWITCH_ANIM_TIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m15054f(int OplusGLSurfaceView_13) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.mActivity);
        menuClickMsgData.buildEvent(false);
        menuClickMsgData.mCaptureMode = ApsConstant.CAPTURE_MODE_PANORAMA;
        menuClickMsgData.mCaptureType = 0;
        menuClickMsgData.mFuncKeyId = 19;
        menuClickMsgData.mOrientation = this.f15013M;
        menuClickMsgData.mFuncKeyResult = OplusGLSurfaceView_13;
        menuClickMsgData.mRearOrFront = this.mbFrontCamera ? DcsMsgData.FRONT : DcsMsgData.REAR;
        menuClickMsgData.report();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15093b(Bitmap bitmap) {
        if (bitmap == null) {
            CameraLog.m12967f("PanoramaCapMode", "sendToUpdateGuideBitmap error, bitmap is null");
            return;
        }
        Handler handler = this.f15039am;
        if (handler != null) {
            handler.removeMessages(2);
            Message messageObtainMessage = this.f15039am.obtainMessage(2);
            messageObtainMessage.obj = bitmap;
            messageObtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m15076p() {
        CameraLog.m12954a("PanoramaCapMode", "initFrontManager enter");
        this.f15037ak = new FrontPanoramaEngine(this.mActivity, this.f15006F, TextUtils.equals(getMirror(), "on"), this, getCameraInfo(this.mCameraId).m13275j());
    }

    /* renamed from: q */
    private void m15078q() {
        FrontPanoramaEngine c2838d = this.f15037ak;
        if (c2838d != null) {
            c2838d.m14947a();
            this.f15037ak.m14954d();
        }
    }

    @Override // com.oplus.camera.panorama.FrontPanoramaEngine.PlatformImplementations.kt_3
    /* renamed from: COUIBaseListPopupWindow_8 */
    public int mo14963e() {
        int OplusGLSurfaceView_13 = this.f15014N;
        return (OplusGLSurfaceView_13 + (OplusGLSurfaceView_13 % 180 == 0 ? 180 : 90)) % 360;
    }

    @Override // com.oplus.camera.panorama.FrontPanoramaEngine.PlatformImplementations.kt_3
    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean mo14964f() {
        return getHeicCodecFormat() != null;
    }

    @Override // com.oplus.camera.panorama.FrontPanoramaEngine.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14957a(int OplusGLSurfaceView_13) {
        FrontPanoramaGuideView frontPanoramaGuideView = this.f15058z;
        if (frontPanoramaGuideView != null) {
            frontPanoramaGuideView.setNextDirection(OplusGLSurfaceView_13);
        }
    }

    @Override // com.oplus.camera.panorama.FrontPanoramaEngine.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14956a() {
        CameraLog.m12954a("PanoramaCapMode", "sendFrontResetMessage enter");
        if (this.f15039am == null || this.mbPaused) {
            return;
        }
        this.f15039am.removeMessages(1);
        Handler handler = this.f15039am;
        handler.sendMessage(handler.obtainMessage(1, false));
    }

    @Override // com.oplus.camera.panorama.FrontPanoramaEngine.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo14958a(Bitmap bitmap) {
        m15093b(bitmap);
    }

    @Override // com.oplus.camera.panorama.FrontPanoramaEngine.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo14960b() {
        this.f15015O++;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m15043c(ProcessResult processResult) {
        return (3 != this.f15018R ? !(2 != this.f15018R || processResult.updateSmallImageRect.bottom >= this.f15025Y) : this.f15026Z - processResult.updateSmallImageRect.top < this.f15025Y) && Math.abs(processResult.outputOffset.x - this.f15028ab) < this.f15022V;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public Bitmap m14998a(Bitmap bitmap, Bitmap bitmap2, Rect rect) {
        if (3 == this.f15018R) {
            float COUIBaseListPopupWindow_12 = this.f15026Z - rect.top;
            float f2 = this.f15027aa;
            Bitmap bitmapM24215a = Util.m24215a((int) (COUIBaseListPopupWindow_12 * f2), (int) (this.f15024X * f2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapM24215a);
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            }
            canvas.drawBitmap(bitmap2, (int) ((this.f15026Z - rect.bottom) * this.f15027aa), rect.left * this.f15027aa, (Paint) null);
            canvas.save();
            canvas.restore();
            return bitmapM24215a;
        }
        if (2 != this.f15018R) {
            return null;
        }
        float f3 = rect.bottom;
        float f4 = this.f15027aa;
        Bitmap bitmapM24215a2 = Util.m24215a((int) (f3 * f4), (int) (this.f15024X * f4), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmapM24215a2);
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas2.drawBitmap(bitmap, bitmapM24215a2.getWidth() - bitmap.getWidth(), 0.0f, (Paint) null);
        }
        canvas2.drawBitmap(bitmap2, 0.0f, rect.left * this.f15027aa, (Paint) null);
        canvas2.save();
        canvas2.restore();
        return bitmapM24215a2;
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeShown() {
        this.f15057y.setVisibility(8);
        m15092b(8);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public void onMoreModeHidden(int OplusGLSurfaceView_13) {
        super.onMoreModeHidden(OplusGLSurfaceView_13);
        if (CameraCharacteristicsUtil.m12974a(this.mCameraId) && 1 != OplusGLSurfaceView_13) {
            this.f15057y.setVisibility(0);
            this.f15005E.m18806a(new CameraScreenHintInfo.PlatformImplementations.kt_3().m18845a(this.mActivity.getString(R.string.camera_panorama_front_previewing)).m18846a(true).m18849b(false).m18844a(R.drawable.screen_hint_textview_bg).m18848b(R.color.screen_hint_text_color).m18847a());
            m15039b(false);
            return;
        }
        m15092b(0);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m15039b(boolean z) {
        if (this.mCameraUIInterface != null) {
            this.mCameraUIInterface.mo18108a(true, true, z);
        }
    }

    /* renamed from: r */
    private void m15080r() {
        Resources resources = MyApplication.m11092d().getResources();
        if (Util.m24498u()) {
            this.f15042j = (int) (Util.getScreenHeight() / 1.3333333333333333d);
            this.f15045m = resources.getDimensionPixelOffset(R.dimen.full_screen_panorama_rect_margin_top);
            this.f15044l = (Util.getScreenWidth() - this.f15042j) / 2;
        } else {
            this.f15042j = Util.getScreenWidth();
            this.f15045m = resources.getDimensionPixelOffset(R.dimen.out_screen_panorama_rect_margin_top);
            this.f15044l = 0;
        }
        this.f15043k = this.mActivity.getResources().getDimensionPixelOffset(R.dimen.panorama_rect_height);
        this.f15009I.setRectMarginLeft(this.f15044l);
    }

    @Override // com.oplus.camera.capmode.BaseMode
    public ScreenModeConst.PlatformImplementations.kt_3 getPreferredScreenMode(int OplusGLSurfaceView_13) {
        if (!Util.m24498u()) {
            return ScreenModeConst.PlatformImplementations.kt_3.out;
        }
        return ScreenModeConst.PlatformImplementations.kt_3.full;
    }
}
