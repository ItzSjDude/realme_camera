package com.oplus.camera;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OplusWindowManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.oplus.camera.capmode.VideoMode;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p156o.QrCodeRequest;
import com.oplus.camera.p156o.QrCodeResult;
import com.oplus.camera.p156o.WifiResultParser;
import com.oplus.camera.p156o.p157a.QrCodeDispatch;
import com.oplus.camera.p172ui.CameraQrCodeJumpView;
import com.oplus.camera.p172ui.CameraQrCodeView;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.preview.PreviewFrameLayout;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.statistics.model.QrCodeDcsMsgData;
import com.oplus.camera.util.Util;
import com.oplus.camera.util.YuvUtil;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/* compiled from: QrCodeManager.java */
/* renamed from: com.oplus.camera.aa */
/* loaded from: classes2.dex */
public class QrCodeManager implements View.OnClickListener {

    /* renamed from: A */
    private QrCodeDispatch f12158A;

    /* renamed from: B */
    private YuvUtil f12159B;

    /* renamed from: PlatformImplementations.kt_3 */
    private Activity f12162a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private WifiResultParser f12163b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CameraQrCodeJumpView f12164c;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private KeyguardManager f12167f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f12169h;

    /* renamed from: s */
    private QrCodeDcsMsgData f12180s;

    /* renamed from: u */
    private ComboPreferences f12182u;

    /* renamed from: v */
    private CameraInterface f12183v;

    /* renamed from: w */
    private int f12184w;

    /* renamed from: y */
    private Map<DecodeHintType, Object> f12186y;

    /* renamed from: z */
    private QRCodeReader f12187z;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CameraQrCodeView f12165d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private QrCodeResult f12166e = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private QrCodeResult f12168g = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f12170i = false;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f12171j = true;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f12172k = true;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f12173l = false;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f12174m = false;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f12175n = false;

    /* renamed from: o */
    private boolean f12176o = false;

    /* renamed from: p */
    private Handler f12177p = null;

    /* renamed from: q */
    private Handler f12178q = null;

    /* renamed from: r */
    private int f12179r = 0;

    /* renamed from: t */
    private Object f12181t = new Object();

    /* renamed from: x */
    private PlatformImplementations.kt_3 f12185x = null;

    /* renamed from: C */
    private int f12160C = -1;

    /* renamed from: D */
    private Handler f12161D = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.aa.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 != 1) {
                if (OplusGLSurfaceView_13 == 2) {
                    if (message.obj != null && QrCodeManager.this.f12164c != null && QrCodeManager.this.f12164c.getParent() != null) {
                        QrCodeManager.this.f12164c.m18000a(((Boolean) message.obj).booleanValue());
                    }
                    QrCodeManager.this.m11201s();
                    return;
                }
                if (OplusGLSurfaceView_13 == 4) {
                    QrCodeManager.this.m11201s();
                    return;
                } else {
                    if (OplusGLSurfaceView_13 != 5) {
                        return;
                    }
                    QrCodeManager.this.m11196n();
                    return;
                }
            }
            if (message.obj != null && QrCodeManager.this.f12164c != null && !QrCodeManager.this.f12170i && QrCodeManager.this.f12172k && !QrCodeManager.this.f12175n) {
                QrCodeManager.this.f12166e = (QrCodeResult) message.obj;
                if (QrCodeManager.this.f12168g == null || !TextUtils.equals(QrCodeManager.this.f12168g.m14805a(), QrCodeManager.this.f12166e.m14805a()) || !QrCodeManager.this.f12174m) {
                    CameraLog.m12954a("QrCodeManager", "handleMessage, MSG_QR_CODE_RESULT: " + QrCodeManager.this.f12172k);
                    QrCodeManager.this.m11206a();
                    QrCodeManager.this.m11210a(true);
                    QrCodeManager.this.m11200r();
                    return;
                }
                QrCodeManager.this.m11215c();
                return;
            }
            QrCodeManager.this.m11215c();
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11206a() {
        CameraLog.m12954a("QrCodeManager", "clearHistory, mHistoryQrCodeScanResult: " + this.f12168g + " ,mQrCodeScanResult: " + this.f12166e);
        this.f12168g = null;
        this.f12174m = false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11213b() {
        this.f12177p.removeMessages(6);
        this.f12177p.removeMessages(2);
        this.f12177p.removeMessages(8);
        this.f12177p.removeMessages(9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_11 */
    public void m11196n() {
        CameraQrCodeJumpView cameraQrCodeJumpView = this.f12164c;
        if (cameraQrCodeJumpView != null && cameraQrCodeJumpView.getParent() != null && this.f12164c.m18002b()) {
            this.f12164c.clearAnimation();
            this.f12164c.setVisibility(8);
        }
        CameraQrCodeView cameraQrCodeView = this.f12165d;
        if (cameraQrCodeView == null || !cameraQrCodeView.m18019a()) {
            return;
        }
        this.f12165d.clearAnimation();
        this.f12165d.setVisibility(4);
    }

    public QrCodeManager(Activity activity, ComboPreferences comboPreferences, CameraInterface interfaceC2646a, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        this.f12162a = null;
        this.f12163b = null;
        this.f12164c = null;
        this.f12167f = null;
        this.f12180s = null;
        this.f12182u = null;
        this.f12183v = null;
        this.f12184w = 255;
        this.f12186y = null;
        this.f12187z = null;
        this.f12158A = null;
        this.f12159B = null;
        this.f12162a = activity;
        this.f12182u = comboPreferences;
        this.f12183v = interfaceC2646a;
        this.f12184w = OplusGLSurfaceView_13;
        PreviewFrameLayout previewFrameLayout = (PreviewFrameLayout) this.f12162a.findViewById(R.id_renamed.frame_layout);
        int top = previewFrameLayout.getTop();
        int height = previewFrameLayout.getHeight();
        int dimensionPixelSize = this.f12162a.getResources().getDimensionPixelSize(R.dimen.pi_ultra_wide_hint_layout_margin_top);
        this.f12163b = new WifiResultParser();
        this.f12169h = (int) (Util.getScreenWidth() * 1.3333333333333333d);
        this.f12164c = (CameraQrCodeJumpView) LayoutInflater.from(activity).inflate(R.layout.camera_qrcode_hint_layout, (ViewGroup) null);
        this.f12164c.setId(R.id_renamed.rl_qr_code_click);
        this.f12164c.m17999a(dimensionPixelSize, top, height, 0);
        this.f12164c.setOnClickListener(this);
        this.f12164c.setDefaultPreviewHeight(this.f12169h);
        this.f12167f = (KeyguardManager) activity.getApplicationContext().getSystemService("keyguard");
        this.f12180s = new QrCodeDcsMsgData(activity);
        this.f12158A = new QrCodeDispatch();
        this.f12187z = new QRCodeReader();
        this.f12186y = new Hashtable();
        this.f12186y.put(DecodeHintType.CHARACTER_SET, "utf-8");
        this.f12186y.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        this.f12186y.put(DecodeHintType.POSSIBLE_FORMATS, BarcodeFormat.QR_CODE);
        if (this.f12159B == null) {
            this.f12159B = new YuvUtil();
        }
        m11197o();
        if (m11199q().getPackageManager() == null) {
            CameraLog.m12967f("QrCodeManager", "QrCodeManager, mbIsWifiQrcodeShare, cannot get packageManager!");
        }
    }

    /* renamed from: o */
    private void m11197o() {
        HandlerThread handlerThread = new HandlerThread("CameraQrCode");
        handlerThread.start();
        HandlerThread handlerThread2 = new HandlerThread("CameraQrCodeJump");
        handlerThread2.start();
        this.f12178q = new Handler(handlerThread2.getLooper());
        this.f12177p = new Handler(handlerThread.getLooper()) { // from class: com.oplus.camera.aa.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int OplusGLSurfaceView_13 = message.what;
                if (OplusGLSurfaceView_13 == 3) {
                    if (message.obj == null || QrCodeManager.this.f12170i || !QrCodeManager.this.f12172k) {
                        return;
                    }
                    QrCodeRequest c2816a = (QrCodeRequest) message.obj;
                    QrCodeResult c2824bM11173a = QrCodeManager.this.m11173a(c2816a.m14796a(), c2816a.m14797b(), c2816a.m14798c());
                    if (c2824bM11173a == null || c2824bM11173a.m14809d() == null || QrCodeManager.this.f12161D == null || QrCodeManager.this.f12170i) {
                        QrCodeManager.this.m11198p();
                    } else {
                        QrCodeManager.this.m11176a(c2824bM11173a);
                        return;
                    }
                }
                switch (OplusGLSurfaceView_13) {
                    case 6:
                        CameraLog.m12954a("QrCodeManager", "handleMessage, MSG_QR_CODE_CHECK_LEAVE");
                        QrCodeManager.this.f12177p.removeMessages(8);
                        QrCodeManager.this.m11228m();
                        break;
                    case 7:
                        CameraLog.m12954a("QrCodeManager", "handleMessage, MSG_QR_CODE_JUMP_DELAY");
                        QrCodeManager.this.m11228m();
                        QrCodeManager.this.f12175n = false;
                        break;
                    case 8:
                        QrCodeManager.this.m11217d(true);
                        if (QrCodeManager.this.m11223h()) {
                            QrCodeManager.this.m11214b(true);
                            break;
                        }
                        break;
                    case 9:
                        QrCodeManager.this.m11220e(true);
                        break;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m11198p() {
        this.f12161D.removeMessages(4);
        this.f12161D.sendEmptyMessage(4);
        if (this.f12174m && !this.f12177p.hasMessages(6)) {
            CameraLog.m12954a("QrCodeManager", "qrCodeEmpty, MSG_QR_CODE_CHECK_LEAVE");
            Handler handler = this.f12177p;
            handler.sendMessageDelayed(handler.obtainMessage(6), 1000L);
        }
        if (this.f12174m || this.f12177p.hasMessages(9)) {
            return;
        }
        CameraLog.m12954a("QrCodeManager", "qrCodeEmpty, QR_CODE_MAX_DETECTION_TIME");
        Handler handler2 = this.f12177p;
        handler2.sendMessageDelayed(handler2.obtainMessage(9), 15000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m11176a(QrCodeResult c2824b) {
        this.f12177p.removeMessages(6);
        this.f12177p.removeMessages(9);
        QrCodeResult c2824b2 = this.f12166e;
        if (c2824b2 == null || !TextUtils.equals(c2824b2.m14805a(), c2824b.m14805a()) || !this.f12177p.hasMessages(8)) {
            this.f12177p.removeMessages(8);
            Handler handler = this.f12177p;
            handler.sendMessageDelayed(handler.obtainMessage(8), 10000L);
        }
        this.f12161D.removeMessages(1);
        this.f12161D.removeMessages(4);
        this.f12161D.obtainMessage(1, c2824b).sendToTarget();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11211a(byte[] bArr, Rect rect, Size size, int OplusGLSurfaceView_13, int i2) {
        if (this.f12170i || !this.f12172k || this.f12173l) {
            return;
        }
        m11227l();
        int i3 = (int) (OplusGLSurfaceView_13 / (i2 / 720.0f));
        byte[] bArrM24512a = this.f12159B.m24512a(bArr, OplusGLSurfaceView_13, i2, i3, VideoMode.VIDEO_720P_HEIGHT);
        this.f12177p.removeMessages(3);
        this.f12177p.obtainMessage(3, new QrCodeRequest(bArrM24512a, rect, size, i3, VideoMode.VIDEO_720P_HEIGHT)).sendToTarget();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private QrCodeResult m11170a(Result result, int OplusGLSurfaceView_13, int i2) {
        if (result == null || TextUtils.isEmpty(result.getText()) || m11199q() == null) {
            CameraLog.m12954a("QrCodeManager", "innerConvertResult, result is null");
            return null;
        }
        CameraLog.m12954a("QrCodeManager", "innerConvertResult, result: " + result.getText());
        RectF rectFM11169a = m11169a(result.getResultPoints());
        if (rectFM11169a == null) {
            return null;
        }
        if (this.f12163b.m14818a(result.getText())) {
            return new QrCodeResult(result.getText(), QrCodeResult.PlatformImplementations.kt_3.WIFI, null, rectFM11169a, OplusGLSurfaceView_13, i2);
        }
        return new QrCodeResult(result.getText(), QrCodeResult.PlatformImplementations.kt_3.NONE, null, rectFM11169a, OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private RectF m11169a(ResultPoint[] resultPointArr) {
        if (4 != resultPointArr.length) {
            return null;
        }
        RectF rectF = new RectF();
        float x = (resultPointArr[0].getX() + resultPointArr[2].getX()) / 2.0f;
        float y = (resultPointArr[0].getY() + resultPointArr[2].getY()) / 2.0f;
        float fSqrt = ((float) Math.sqrt(Math.pow(resultPointArr[0].getX() - resultPointArr[2].getX(), 2.0d) + Math.pow(resultPointArr[0].getY() - resultPointArr[2].getY(), 2.0d))) / 2.0f;
        rectF.left = x - fSqrt;
        rectF.top = y - fSqrt;
        rectF.right = x + fSqrt;
        rectF.bottom = y + fSqrt;
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public QrCodeResult m11173a(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        Result resultM11205a;
        CameraLog.m12954a("QrCodeManager", "decode, width: " + OplusGLSurfaceView_13 + ", height: " + i2);
        Result resultM11205a2 = m11205a(bArr, OplusGLSurfaceView_13, i2, this.f12160C);
        if (resultM11205a2 == null) {
            this.f12160C = -1;
            int iNextInt = new Random().nextInt(this.f12158A.m14802a());
            resultM11205a = m11205a(bArr, OplusGLSurfaceView_13, i2, iNextInt);
            if (resultM11205a != null) {
                this.f12160C = iNextInt;
            } else {
                this.f12160C = -1;
            }
        } else {
            resultM11205a = resultM11205a2;
        }
        return m11170a(resultM11205a, OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Result m11205a(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3) {
        PlanarYUVLuminanceSource planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, OplusGLSurfaceView_13, i2, 0, 0, OplusGLSurfaceView_13, i2, false);
        if (-1 != i3) {
            this.f12158A.m14803a(i3).mo14799a(planarYUVLuminanceSource.getMatrix(), planarYUVLuminanceSource.getWidth(), planarYUVLuminanceSource.getHeight());
        }
        try {
            try {
                return this.f12187z.decode(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource)), this.f12186y);
            } catch (ChecksumException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                this.f12187z.reset();
                return null;
            } catch (FormatException e2) {
                e2.printStackTrace();
                this.f12187z.reset();
                return null;
            } catch (NotFoundException e3) {
                e3.printStackTrace();
                this.f12187z.reset();
                return null;
            }
        } finally {
            this.f12187z.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11182b(QrCodeResult c2824b) {
        if (this.f12162a == null || this.f12170i) {
            CameraLog.m12959b("QrCodeManager", "handleCodeResult activity is destroyed");
            return;
        }
        if (c2824b.m14812g()) {
            return;
        }
        QrCodeResult.PlatformImplementations.kt_3 aVarM14808c = c2824b.m14808c();
        String strM14805a = c2824b.m14805a();
        if (aVarM14808c == QrCodeResult.PlatformImplementations.kt_3.NONE) {
            m11180a(strM14805a);
            return;
        }
        if (aVarM14808c == QrCodeResult.PlatformImplementations.kt_3.WIFI) {
            Intent intent = new Intent("wireless.settings.WLAN_CONNECT");
            intent.setPackage("com.oplus.wirelesssettings");
            intent.putExtra("rawResult", strM14805a);
            try {
                this.f12162a.startActivity(intent);
                m11175a(3, true);
                return;
            } catch (Exception COUIBaseListPopupWindow_8) {
                CameraLog.m12967f("QrCodeManager", "handleCodeResult, innerHandleCodeResult COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
                m11180a(strM14805a);
                return;
            }
        }
        m11180a(strM14805a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m11175a(int OplusGLSurfaceView_13, boolean z) {
        synchronized (this.f12181t) {
            if (this.f12180s != null) {
                this.f12180s.buildEventId(z);
                m11177a(this.f12180s);
                if (z) {
                    this.f12180s.mProtocol = OplusGLSurfaceView_13;
                }
                this.f12180s.report();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m11180a(java.lang.String r8) {
        /*
            r7 = this;
            android.app.Activity r0 = r7.f12162a
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            java.util.regex.Pattern r0 = android.util.Patterns.WEB_URL
            java.util.regex.Matcher r0 = r0.matcher(r8)
            boolean r0 = r0.matches()
            java.lang.String r2 = "searchCode COUIBaseListPopupWindow_8: "
            java.lang.String r3 = "QrCodeManager"
            r4 = 1
            if (r0 != 0) goto L20
            boolean r0 = android.webkit.URLUtil.isValidUrl(r8)
            if (r0 == 0) goto L1e
            goto L20
        L1e:
            r5 = r1
            goto L52
        L20:
            java.lang.String r0 = com.oplus.camera.util.Util.m24453g(r8)
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.content.Intent r5 = new android.content.Intent
            java.lang.String r6 = "android.intent.action.VIEW"
            r5.<init>(r6, r0)
            android.app.Activity r0 = r7.f12162a     // Catch: java.lang.Exception -> L3c
            r0.startActivity(r5)     // Catch: java.lang.Exception -> L3c
            r7.m11175a(r4, r4)     // Catch: java.lang.Exception -> L39
            r5 = r4
            goto L52
        L39:
            r0 = move-exception
            r5 = r4
            goto L3e
        L3c:
            r0 = move-exception
            r5 = r1
        L3e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            com.oplus.camera.CameraLog.m12967f(r3, r0)
            r7.f12175n = r1
        L52:
            if (r5 != 0) goto La9
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r6 = "android.intent.action.WEB_SEARCH"
            r0.<init>(r6)
            java.lang.String r6 = "query"
            r0.putExtra(r6, r8)
            android.content.Context r8 = r7.m11199q()
            java.lang.String r6 = "com.heytap.browser"
            boolean r8 = com.oplus.camera.util.Util.m24435d(r8, r6)
            if (r8 == 0) goto L70
            r0.setPackage(r6)
            goto L81
        L70:
            android.content.Context r8 = r7.m11199q()
            java.lang.String r6 = "com.android.chrome"
            boolean r8 = com.oplus.camera.util.Util.m24435d(r8, r6)
            if (r8 != 0) goto L81
            java.lang.String r8 = "com.android.browser"
            r0.setPackage(r8)
        L81:
            r8 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r8)
            android.app.Activity r8 = r7.f12162a     // Catch: java.lang.Exception -> L92
            r8.startActivity(r0)     // Catch: java.lang.Exception -> L92
            r8 = 4
            r7.m11175a(r8, r4)     // Catch: java.lang.Exception -> L90
            goto Laa
        L90:
            r8 = move-exception
            goto L94
        L92:
            r8 = move-exception
            r4 = r5
        L94:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            com.oplus.camera.CameraLog.m12967f(r3, r8)
            r7.f12175n = r1
            goto Laa
        La9:
            r4 = r5
        Laa:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.QrCodeManager.m11180a(java.lang.String):boolean");
    }

    /* renamed from: q */
    private Context m11199q() {
        Activity activity = this.f12162a;
        if (activity != null) {
            return activity.getApplicationContext();
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11208a(ViewGroup viewGroup) throws Resources.NotFoundException {
        if (viewGroup == null || this.f12164c == null) {
            return;
        }
        PreviewFrameLayout previewFrameLayout = (PreviewFrameLayout) this.f12162a.findViewById(R.id_renamed.frame_layout);
        this.f12165d = (CameraQrCodeView) previewFrameLayout.findViewById(R.id_renamed.qrcode_view);
        if (this.f12165d == null) {
            this.f12165d = (CameraQrCodeView) this.f12162a.getLayoutInflater().inflate(R.layout.view_stub_qrcode_view, previewFrameLayout).findViewById(R.id_renamed.qrcode_view);
        }
        viewGroup.removeView(this.f12164c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, m11199q().getResources().getDimensionPixelSize(R.dimen.ai_notice_view_height));
        layoutParams.addRule(14);
        layoutParams.addRule(2, R.id_renamed.control_panel_layout);
        int top = previewFrameLayout.getTop();
        int height = previewFrameLayout.getHeight();
        int dimensionPixelSize = this.f12162a.getResources().getDimensionPixelSize(R.dimen.pi_ultra_wide_hint_layout_margin_top);
        layoutParams.bottomMargin = this.f12162a.getResources().getDimensionPixelSize(R.dimen.qr_code_vertical_margin_bottom);
        viewGroup.addView(this.f12164c, layoutParams);
        this.f12164c.m17999a(dimensionPixelSize, top, height, 0);
        this.f12164c.setVisibility(8);
        this.f12164c.findViewById(R.id_renamed.camera_qr_code_hint_next).setRotation(this.f12164c.getLayoutDirection() == 1 ? 180.0f : 0.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11210a(boolean z) {
        CameraQrCodeJumpView cameraQrCodeJumpView = this.f12164c;
        if (cameraQrCodeJumpView == null || this.f12162a == null || this.f12166e == null || this.f12170i || cameraQrCodeJumpView.getParent() == null) {
            return;
        }
        this.f12164c.setOrientation(this.f12179r);
        if (this.f12164c.m18002b()) {
            this.f12164c.m17998a();
        } else {
            this.f12164c.m18001a(true, z);
            m11175a(0, false);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11214b(boolean z) {
        if (this.f12164c == null || this.f12162a == null || this.f12166e == null || !m11224i()) {
            Handler handler = this.f12161D;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (this.f12161D != null) {
                this.f12177p.removeCallbacksAndMessages(null);
                return;
            }
            return;
        }
        this.f12161D.removeMessages(2);
        this.f12161D.removeMessages(1);
        this.f12177p.removeMessages(3);
        this.f12161D.obtainMessage(2, Boolean.valueOf(z)).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m11200r() {
        CameraQrCodeView cameraQrCodeView = this.f12165d;
        if (cameraQrCodeView != null && this.f12171j) {
            cameraQrCodeView.m18017a(this.f12166e.m14809d(), this.f12166e.m14810e(), this.f12166e.m14811f());
            return;
        }
        CameraQrCodeView cameraQrCodeView2 = this.f12165d;
        if (cameraQrCodeView2 != null) {
            cameraQrCodeView2.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m11201s() {
        CameraQrCodeView cameraQrCodeView = this.f12165d;
        if (cameraQrCodeView == null || this.f12170i) {
            return;
        }
        cameraQrCodeView.m18018a(true);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m11215c() {
        CameraLog.m12954a("QrCodeManager", "clearQrCodeView, canScanQrCode: " + this.f12172k + ", mbPause: " + this.f12170i + ", isMainThread: " + m11218d());
        if (this.f12170i || !m11223h()) {
            return;
        }
        if (!m11218d()) {
            this.f12161D.removeCallbacksAndMessages(null);
            this.f12177p.removeCallbacksAndMessages(null);
            this.f12161D.sendEmptyMessage(5);
            return;
        }
        m11196n();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m11218d() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11207a(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("QrCodeManager", "setOrientation: " + OplusGLSurfaceView_13);
        this.f12179r = OplusGLSurfaceView_13;
        if (m11223h()) {
            this.f12164c.setOrientation(this.f12179r);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m11219e() {
        CameraLog.m12954a("QrCodeManager", "onResume");
        this.f12170i = false;
        this.f12176o = false;
        CameraQrCodeJumpView cameraQrCodeJumpView = this.f12164c;
        if (cameraQrCodeJumpView != null) {
            cameraQrCodeJumpView.m18004d();
        }
        CameraQrCodeView cameraQrCodeView = this.f12165d;
        if (cameraQrCodeView != null) {
            cameraQrCodeView.m18021c();
        }
        if (this.f12175n) {
            this.f12177p.removeMessages(7);
            Handler handler = this.f12177p;
            handler.sendMessageDelayed(handler.obtainMessage(7), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        } else {
            m11206a();
        }
        m11216c(true);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m11221f() {
        CameraLog.m12954a("QrCodeManager", "onPause");
        this.f12170i = true;
        this.f12176o = false;
        CameraQrCodeJumpView cameraQrCodeJumpView = this.f12164c;
        if (cameraQrCodeJumpView != null) {
            cameraQrCodeJumpView.m18003c();
        }
        CameraQrCodeView cameraQrCodeView = this.f12165d;
        if (cameraQrCodeView != null) {
            cameraQrCodeView.m18020b();
        }
        PlatformImplementations.kt_3 aVar = this.f12185x;
        if (aVar != null) {
            aVar.m11230a(true);
        }
        m11216c(false);
        this.f12161D.removeCallbacksAndMessages(null);
        this.f12177p.removeCallbacksAndMessages(null);
        this.f12178q.removeCallbacksAndMessages(null);
        this.f12179r = 0;
        this.f12160C = -1;
        m11196n();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m11222g() {
        CameraLog.m12954a("QrCodeManager", "onDestroy");
        PlatformImplementations.kt_3 aVar = this.f12185x;
        if (aVar != null) {
            aVar.m11230a(true);
        }
        this.f12161D.removeCallbacksAndMessages(null);
        this.f12177p.removeCallbacksAndMessages(null);
        this.f12178q.removeCallbacksAndMessages(null);
        this.f12162a = null;
        this.f12167f = null;
        synchronized (this.f12181t) {
            this.f12183v = null;
            this.f12182u = null;
            this.f12180s = null;
        }
        try {
            this.f12177p.getLooper().quitSafely();
            this.f12177p = null;
            this.f12178q.getLooper().quitSafely();
            this.f12178q = null;
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("QrCodeManager", "onDestroy, quit handler: " + COUIBaseListPopupWindow_8.toString());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m11216c(boolean z) {
        this.f12172k = z;
        if (this.f12172k) {
            return;
        }
        m11215c();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m11223h() {
        CameraQrCodeJumpView cameraQrCodeJumpView;
        CameraQrCodeView cameraQrCodeView = this.f12165d;
        return (cameraQrCodeView != null && cameraQrCodeView.m18019a()) || ((cameraQrCodeJumpView = this.f12164c) != null && cameraQrCodeJumpView.m18002b());
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m11224i() {
        CameraQrCodeJumpView cameraQrCodeJumpView;
        CameraQrCodeView cameraQrCodeView = this.f12165d;
        return cameraQrCodeView != null && cameraQrCodeView.m18019a() && (cameraQrCodeJumpView = this.f12164c) != null && cameraQrCodeJumpView.m18002b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m11212a(MotionEvent motionEvent) {
        CameraQrCodeJumpView cameraQrCodeJumpView = this.f12164c;
        if (cameraQrCodeJumpView != null && cameraQrCodeJumpView.m18002b() && m11178a(this.f12164c, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            CameraLog.m12954a("QrCodeManager", "needTouchEvent, QrCode is show and dispatchTouchEvent");
            if (1 == motionEvent.getAction()) {
                m11215c();
            }
            return true;
        }
        if (motionEvent.getAction() == 0) {
            CameraLog.m12954a("QrCodeManager", "needTouchEvent, isShowQrCodeView: " + m11223h());
        }
        if (m11223h() && motionEvent.getAction() == 0) {
            this.f12175n = false;
            m11213b();
            m11217d(true);
            m11215c();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m11178a(View view, int OplusGLSurfaceView_13, int i2) {
        int measuredWidth;
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight2 = iArr[0];
        int measuredWidth2 = iArr[1];
        int i3 = this.f12179r;
        if (270 == i3) {
            measuredHeight2 -= view.getMeasuredHeight();
            measuredWidth = view.getMeasuredHeight() + measuredHeight2;
            measuredHeight = view.getMeasuredWidth();
        } else if (90 == i3) {
            measuredWidth2 -= view.getMeasuredWidth();
            measuredWidth = view.getMeasuredHeight() + measuredHeight2;
            measuredHeight = view.getMeasuredWidth();
        } else {
            measuredWidth = view.getMeasuredWidth() + measuredHeight2;
            measuredHeight = view.getMeasuredHeight();
        }
        return i2 >= measuredWidth2 && i2 <= measuredHeight + measuredWidth2 && OplusGLSurfaceView_13 >= measuredHeight2 && OplusGLSurfaceView_13 <= measuredWidth;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m11217d(boolean z) {
        this.f12174m = z;
        if (this.f12174m) {
            this.f12168g = this.f12166e;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m11220e(boolean z) {
        this.f12173l = z;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m11225j() {
        return this.f12173l;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m11226k() {
        CameraQrCodeJumpView cameraQrCodeJumpView = this.f12164c;
        if (cameraQrCodeJumpView != null) {
            cameraQrCodeJumpView.m18005e();
        }
    }

    /* renamed from: t */
    private void m11202t() {
        CameraLog.m12954a("QrCodeManager", "requestKeyguard");
        this.f12176o = true;
        try {
            new OplusWindowManager().requestKeyguard("unlockOrShowSecurity");
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("QrCodeManager", "requestKeyguard: " + COUIBaseListPopupWindow_8.toString());
        } catch (NoSuchMethodError e2) {
            CameraLog.m12967f("QrCodeManager", "requestKeyguard: " + e2.toString());
        }
    }

    /* renamed from: u */
    private boolean m11203u() {
        KeyguardManager keyguardManager;
        return (this.f12162a == null || (keyguardManager = this.f12167f) == null || !keyguardManager.isDeviceLocked()) ? false : true;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m11227l() {
        if (!this.f12176o || m11203u()) {
            return;
        }
        this.f12176o = false;
        m11204v();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m11177a(QrCodeDcsMsgData qrCodeDcsMsgData) {
        if (qrCodeDcsMsgData == null) {
            return;
        }
        CameraInterface interfaceC2646a = this.f12183v;
        if (interfaceC2646a != null) {
            if (interfaceC2646a.mo10551b() != null) {
                qrCodeDcsMsgData.mCameraEnterType = String.valueOf(this.f12183v.mo10551b().m13317J());
            }
            qrCodeDcsMsgData.mCameraId = this.f12183v.mo10547aw();
        }
        ComboPreferences comboPreferences = this.f12182u;
        if (comboPreferences != null) {
            qrCodeDcsMsgData.mCaptureMode = comboPreferences.getString(CameraUIInterface.KEY_CAMERA_MODE, "");
        }
        qrCodeDcsMsgData.mOrientation = this.f12179r;
        qrCodeDcsMsgData.mScreenBrightness = Settings.System.getInt(this.f12162a.getContentResolver(), CameraStatisticsUtil.SCREEN_BRIGHTNESS, (int) (this.f12184w * 0.4f));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11209a(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        m11208a(viewGroup);
        m11207a(OplusGLSurfaceView_13);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m11228m() {
        this.f12177p.removeMessages(8);
        m11206a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f12175n = true;
        if (m11203u()) {
            m11202t();
        } else {
            m11204v();
        }
    }

    /* renamed from: v */
    private void m11204v() {
        if (this.f12166e == null || this.f12178q == null) {
            return;
        }
        CameraLog.m12954a("QrCodeManager", "jump, QR code jump");
        PlatformImplementations.kt_3 aVar = this.f12185x;
        if (aVar != null) {
            this.f12178q.removeCallbacks(aVar);
            this.f12185x.m11230a(true);
        }
        this.f12185x = new PlatformImplementations.kt_3();
        this.f12185x.m11229a(this.f12166e);
        this.f12178q.post(this.f12185x);
        m11217d(true);
        m11215c();
    }

    /* compiled from: QrCodeManager.java */
    /* renamed from: com.oplus.camera.aa$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        QrCodeResult f12190a;

        private PlatformImplementations.kt_3() {
            this.f12190a = null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m11229a(QrCodeResult c2824b) {
            this.f12190a = new QrCodeResult(c2824b.m14805a(), c2824b.m14808c(), c2824b.m14807b(), c2824b.m14809d(), c2824b.m14810e(), c2824b.m14811f());
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m11230a(boolean z) {
            QrCodeResult c2824b = this.f12190a;
            if (c2824b != null) {
                c2824b.m14806a(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            QrCodeResult c2824b = this.f12190a;
            if (c2824b != null) {
                QrCodeManager.this.m11182b(c2824b);
                this.f12190a = null;
            }
        }
    }
}
