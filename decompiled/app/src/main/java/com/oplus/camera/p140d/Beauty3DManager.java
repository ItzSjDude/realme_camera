package com.oplus.camera.p140d;

import android.app.Activity;
import android.content.res.Resources;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Handler;
import android.os.Message;
import android.util.Size;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p141e.CameraMetadataKey;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.beauty3d.Beauty3DUI;
import com.oplus.camera.p172ui.preview.p177a.ImageBeautyTools;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.util.Util;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: Beauty3DManager.java */
/* renamed from: com.oplus.camera.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class Beauty3DManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private Activity f13128a;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Beauty3DUI f13134g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Beauty3DUIListener f13135h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Beauty3DTools f13136i;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private volatile int f13129b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private volatile boolean f13130c = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f13131d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f13132e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private OneCamera f13133f = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private int[] f13137j = {1};

    /* renamed from: OplusGLSurfaceView_5 */
    private int[] f13138k = {2};

    /* renamed from: OplusGLSurfaceView_14 */
    private int[] f13139l = {3};

    /* renamed from: OplusGLSurfaceView_6 */
    private int f13140m = 0;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f13141n = 0;

    /* renamed from: o */
    private int f13142o = 0;

    /* renamed from: p */
    private int f13143p = 0;

    /* renamed from: q */
    private Handler f13144q = new Handler() { // from class: com.oplus.camera.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.1
        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            TotalCaptureResult totalCaptureResult = (TotalCaptureResult) message.obj;
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == 1) {
                Beauty3DManager.this.m12817c(totalCaptureResult);
                return;
            }
            if (OplusGLSurfaceView_13 == 2) {
                Beauty3DManager.this.m12809a(totalCaptureResult);
            } else {
                if (OplusGLSurfaceView_13 != 3) {
                    return;
                }
                Beauty3DManager.this.m12809a(totalCaptureResult);
                Beauty3DManager.this.m12813b(totalCaptureResult);
            }
        }
    };

    /* renamed from: r */
    private Beauty3DUI.PlatformImplementations.kt_3 f13145r = new Beauty3DUI.PlatformImplementations.kt_3() { // from class: com.oplus.camera.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.2
        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo12862a() {
            if (Beauty3DManager.this.f13135h != null) {
                Beauty3DManager.this.f13135h.mo12298c();
            }
        }

        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DUI.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo12865b() {
            if (Beauty3DManager.this.f13129b == 1 || Beauty3DManager.this.f13135h == null) {
                return;
            }
            Beauty3DManager.this.m12831a(false);
            Beauty3DManager.this.m12826a(1);
            Beauty3DManager.this.f13135h.mo12300d();
            Beauty3DManager.m12815c(Beauty3DManager.this);
        }

        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DUI.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo12866c() {
            if (Beauty3DManager.this.f13129b == 1 || Beauty3DManager.this.f13135h == null) {
                return;
            }
            Beauty3DManager.this.m12831a(false);
            Beauty3DManager.this.m12826a(1);
            Beauty3DManager.this.f13135h.mo12300d();
        }

        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo12864a(boolean z) {
            if (Beauty3DManager.this.f13135h != null) {
                Beauty3DManager.this.m12831a(false);
                Beauty3DManager.this.f13135h.mo12295a(z);
            }
        }

        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DUI.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo12867d() {
            if (Beauty3DManager.this.f13135h != null) {
                Beauty3DManager.this.m12826a(0);
                Beauty3DManager.this.m12831a(false);
                Beauty3DManager.this.f13135h.mo12297b(false);
            }
        }

        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DUI.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo12868e() {
            CameraLog.m12954a("Beauty3DManager", "onEditSave");
            if (ImageBeautyTools.m22674a(Beauty3DManager.this.f13128a) == 0) {
                ImageBeautyTools.m22676c(Beauty3DManager.this.f13128a);
                Beauty3DManager.m12820e(Beauty3DManager.this);
            }
            if (Beauty3DManager.this.f13135h != null) {
                Beauty3DManager.this.m12826a(0);
                Beauty3DManager.this.m12831a(false);
                Beauty3DManager.this.f13135h.mo12297b(true);
            }
        }

        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DUI.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_12 */
        public void mo12869f() {
            if (Beauty3DManager.this.f13135h != null) {
                Beauty3DManager.this.f13135h.mo12299c(false);
            }
        }

        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DUI.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo12863a(String str, int[] iArr) {
            if ("com.oplus.beauty3d.mode".equals(str) && iArr != null && iArr[0] == 3) {
                Beauty3DManager.this.m12826a(10);
            } else if ("com.oplus.beauty3d.scan.state".equals(str) && iArr != null) {
                Beauty3DManager.this.m12826a(2);
            }
            if (iArr != null) {
                Beauty3DManager.this.m12839b(str, iArr);
            }
        }

        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DUI.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_11 */
        public void mo12870g() {
            Beauty3DManager.this.m12826a(8);
            Beauty3DManager.this.m12831a(false);
            if (Beauty3DManager.this.f13135h != null) {
                Beauty3DManager.this.f13135h.mo12301e();
            }
            Beauty3DManager.m12821f(Beauty3DManager.this);
        }

        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DUI.PlatformImplementations.kt_3
        /* renamed from: COUIBaseListPopupWindow_10 */
        public void mo12871h() {
            Beauty3DManager.this.m12858o();
            if (Beauty3DManager.this.f13135h != null) {
                Beauty3DManager.this.f13135h.mo12302f();
            }
            Beauty3DManager.m12822g(Beauty3DManager.this);
        }

        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DUI.PlatformImplementations.kt_3
        /* renamed from: OplusGLSurfaceView_13 */
        public void mo12872i() {
            Beauty3DManager.this.m12826a(6);
            Beauty3DManager.this.m12831a(false);
            if (Beauty3DManager.this.f13135h != null) {
                Beauty3DManager.this.f13135h.mo12296b();
            }
            Beauty3DManager.this.f13131d = false;
        }
    };

    /* renamed from: IntrinsicsJvm.kt_3 */
    static /* synthetic */ int m12815c(Beauty3DManager c2674b) {
        int OplusGLSurfaceView_13 = c2674b.f13140m;
        c2674b.f13140m = OplusGLSurfaceView_13 + 1;
        return OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    static /* synthetic */ int m12820e(Beauty3DManager c2674b) {
        int OplusGLSurfaceView_13 = c2674b.f13141n;
        c2674b.f13141n = OplusGLSurfaceView_13 + 1;
        return OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    static /* synthetic */ int m12821f(Beauty3DManager c2674b) {
        int OplusGLSurfaceView_13 = c2674b.f13143p;
        c2674b.f13143p = OplusGLSurfaceView_13 + 1;
        return OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    static /* synthetic */ int m12822g(Beauty3DManager c2674b) {
        int OplusGLSurfaceView_13 = c2674b.f13142o;
        c2674b.f13142o = OplusGLSurfaceView_13 + 1;
        return OplusGLSurfaceView_13;
    }

    public Beauty3DManager(Activity activity, Beauty3DUIListener interfaceC2676d) {
        this.f13128a = null;
        this.f13134g = null;
        this.f13135h = null;
        this.f13136i = null;
        this.f13128a = activity;
        this.f13135h = interfaceC2676d;
        this.f13134g = new Beauty3DUI(activity);
        this.f13136i = Beauty3DTools.m12873a();
        this.f13136i.m12877a(activity);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12825a() {
        this.f13134g.m18727a(this.f13145r);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12833b() {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            c3140g.m18738d();
        }
        m12840c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12840c() {
        StringBuilder sb = new StringBuilder();
        int OplusGLSurfaceView_13 = this.f13140m;
        if (OplusGLSurfaceView_13 > 0) {
            String str = CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_SCAN_CLICK, String.valueOf(OplusGLSurfaceView_13));
            this.f13140m = 0;
            sb.append(str);
        }
        int i2 = this.f13141n;
        if (i2 > 0) {
            String str2 = CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_SAVE_CLICK, String.valueOf(i2));
            this.f13141n = 0;
            sb.append(str2);
        }
        int i3 = this.f13142o;
        if (i3 > 0) {
            String str3 = CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_DELETE_CLICK, String.valueOf(i3));
            this.f13142o = 0;
            sb.append(str3);
        }
        int i4 = this.f13143p;
        if (i4 > 0) {
            String str4 = CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_START_EDIT_CLICK, String.valueOf(i4));
            this.f13143p = 0;
            sb.append(str4);
        }
        if (sb.length() > 0) {
            CameraStatisticsUtil.onCommon(this.f13128a, CameraStatisticsUtil.EVENT_MENU_CLICK, sb.toString());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m12846d() {
        if (this.f13134g == null) {
            return false;
        }
        m12831a(false);
        return this.f13134g.m18734b(this.f13129b);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m12847e() {
        HashMap<String, int[]> mapM12857n;
        if (this.f13135h == null || (mapM12857n = m12857n()) == null) {
            return;
        }
        for (String str : mapM12857n.keySet()) {
            int[] iArr = mapM12857n.get(str);
            if (iArr != null) {
                m12832a(str, iArr);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m12832a(String str, int[] iArr) {
        OneCamera interfaceC2694d = this.f13133f;
        if (interfaceC2694d == null) {
            return false;
        }
        interfaceC2694d.mo13047a(str, iArr);
        CameraLog.m12954a("Beauty3DManager", "setBeauty3DParams, setParam, key: " + str + ", value: " + iArr[0]);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m12839b(String str, int[] iArr) {
        OneCamera interfaceC2694d = this.f13133f;
        if (interfaceC2694d == null) {
            return false;
        }
        interfaceC2694d.mo13047a(str, iArr);
        this.f13133f.mo13035a((OneCamera.IntrinsicsJvm.kt_3) null);
        CameraLog.m12954a("Beauty3DManager", "submitBeauty3DParams, setParam, key: " + str + ", value: " + iArr[0]);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12828a(Size size) {
        this.f13130c = false;
        if (this.f13129b == 3) {
            m12826a(2);
        } else if (this.f13129b == 10) {
            Beauty3DUI c3140g = this.f13134g;
            if (c3140g != null && c3140g.m18747k() != 0) {
                m12826a(9);
            } else {
                m12826a(8);
            }
        }
        m12836b(size);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m12824a(CaptureResult captureResult) {
        if (!this.f13130c) {
            this.f13144q.removeCallbacksAndMessages(null);
            return this.f13129b;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = captureResult;
        int OplusGLSurfaceView_13 = this.f13129b;
        if (OplusGLSurfaceView_13 == 3) {
            this.f13144q.removeMessages(1);
            messageObtain.what = 1;
            this.f13144q.sendMessage(messageObtain);
        } else if (OplusGLSurfaceView_13 == 7) {
            this.f13144q.removeMessages(2);
            messageObtain.what = 2;
            this.f13144q.sendMessage(messageObtain);
        } else if (OplusGLSurfaceView_13 == 10) {
            this.f13144q.removeMessages(3);
            messageObtain.what = 3;
            this.f13144q.sendMessage(messageObtain);
        }
        return this.f13129b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12829a(OneCamera interfaceC2694d) {
        this.f13133f = interfaceC2694d;
        m12831a(true);
        CameraLog.m12954a("Beauty3DManager", "onBeauty3DSessionConfigured, enterBeauty3D Mode");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12837b(OneCamera interfaceC2694d) {
        this.f13133f = interfaceC2694d;
        CameraLog.m12954a("Beauty3DManager", "onBeauty3DCreateSession, enterBeauty3D Mode");
        if (this.f13129b == 6 || this.f13129b == 7) {
            m12832a("com.oplus.beauty3d.mode", this.f13138k);
            m12847e();
            return;
        }
        if (this.f13129b == 1) {
            m12832a("com.oplus.beauty3d.mode", this.f13137j);
            m12832a("com.oplus.beauty3d.scan.state", new int[]{0});
            return;
        }
        if (this.f13129b == 2) {
            m12832a("com.oplus.beauty3d.mode", this.f13137j);
            m12832a("com.oplus.beauty3d.scan.state", new int[]{1});
            return;
        }
        if (this.f13129b == 8 || this.f13129b == 9) {
            m12832a("com.oplus.beauty3d.mode", this.f13139l);
            if (this.f13129b == 8) {
                m12832a("com.oplus.beauty3d.analyses.rotatedegree", new int[]{0});
                m12832a("com.oplus.beauty3d.custom.position", new int[]{0, 0});
            } else if (this.f13129b == 9) {
                m12847e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m12809a(TotalCaptureResult totalCaptureResult) throws Resources.NotFoundException {
        Object objM13005a = CameraMetadataKey.m13005a(totalCaptureResult, CameraMetadataKey.f13240F);
        if (objM13005a != null && (objM13005a instanceof int[])) {
            int[] iArr = (int[]) objM13005a;
            if (iArr.length == 6 && iArr[0] == 2) {
                m12842c("com.oplus.beauty3d.analyses.result", Arrays.copyOfRange(iArr, 1, 6));
            }
        }
        Object objM13005a2 = CameraMetadataKey.m13005a(totalCaptureResult, CameraMetadataKey.f13241G);
        if (objM13005a2 == null || !(objM13005a2 instanceof int[])) {
            return;
        }
        int[] iArr2 = (int[]) objM13005a2;
        if (iArr2.length == 11 && iArr2[0] == 3) {
            m12842c("com.oplus.beauty3d.analyses.ffd", Arrays.copyOfRange(iArr2, 1, 11));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12835b(CaptureResult captureResult) {
        if (this.f13129b == 2) {
            this.f13144q.post(new Runnable() { // from class: com.oplus.camera.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.3
                @Override // java.lang.Runnable
                public void run() {
                    Beauty3DManager.this.m12826a(3);
                    Beauty3DManager.this.m12838b(true);
                }
            });
        } else if (this.f13129b == 6) {
            this.f13144q.post(new Runnable() { // from class: com.oplus.camera.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.4
                @Override // java.lang.Runnable
                public void run() {
                    Beauty3DManager.this.m12826a(7);
                    Beauty3DManager.this.m12845d(true);
                }
            });
        } else if (this.f13129b == 8 || this.f13129b == 9) {
            this.f13144q.post(new Runnable() { // from class: com.oplus.camera.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.5
                @Override // java.lang.Runnable
                public void run() {
                    Beauty3DManager.this.m12826a(10);
                    Beauty3DManager.this.m12845d(true);
                }
            });
        }
        m12824a(captureResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12813b(TotalCaptureResult totalCaptureResult) throws Resources.NotFoundException {
        CameraLog.m12954a("Beauty3DManager", "onBeauty3DEdit");
        Object objM13005a = CameraMetadataKey.m13005a(totalCaptureResult, CameraMetadataKey.f13242H);
        if (objM13005a == null || !(objM13005a instanceof int[])) {
            return;
        }
        int[] iArr = (int[]) objM13005a;
        if (iArr.length == 2) {
            CameraLog.m12954a("Beauty3DManager", "onBeauty3DEdit, styleResult.length: " + iArr.length);
            m12842c("com.oplus.beauty3d.custom.result", iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12817c(TotalCaptureResult totalCaptureResult) {
        Object objM13005a = CameraMetadataKey.m13005a(totalCaptureResult, CameraMetadataKey.f13243I);
        if (objM13005a == null || !(objM13005a instanceof int[])) {
            return;
        }
        int[] iArr = (int[]) objM13005a;
        if (iArr.length < 2) {
            return;
        }
        CameraLog.m12954a("Beauty3DManager", "onBeautyScanResult, update hint: " + iArr[0]);
        int OplusGLSurfaceView_13 = iArr[1];
        if (this.f13132e != OplusGLSurfaceView_13) {
            this.f13132e = OplusGLSurfaceView_13;
            m12834b(OplusGLSurfaceView_13);
        }
        int i2 = iArr[0];
        if (i2 == 0) {
            CameraLog.m12954a("Beauty3DManager", "onBeautyScanResult, BEAUTY3D_SCAN_SUCCESS");
            int i3 = iArr[1];
            CameraLog.m12954a("Beauty3DManager", "onBeautyScanResult, update process: " + i3);
            if (i3 != 100 || this.f13131d) {
                return;
            }
            m12834b(100);
            this.f13131d = true;
            this.f13144q.removeMessages(1);
            m12855l();
            return;
        }
        if (i2 == 1) {
            int i4 = iArr[1];
            CameraLog.m12954a("Beauty3DManager", "onBeautyScanResult, update process: " + i4);
            m12834b(i4);
            return;
        }
        if (i2 <= 19) {
            m12816c(i2);
            return;
        }
        if (i2 >= 20) {
            CameraLog.m12954a("Beauty3DManager", "onBeautyScanResult, updateHintValue: " + i2);
            m12831a(false);
            m12816c(i2);
            this.f13144q.removeMessages(1);
            this.f13144q.postDelayed(new Runnable() { // from class: com.oplus.camera.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.6
                @Override // java.lang.Runnable
                public void run() {
                    Beauty3DManager.this.m12843c(false);
                    if (Beauty3DManager.this.f13135h != null) {
                        Beauty3DManager.this.f13135h.mo12294a();
                    }
                }
            }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m12849f() {
        return this.f13129b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12826a(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("Beauty3DManager", "setBeauty3DState, mBeauty3DState: " + this.f13129b + " -> " + OplusGLSurfaceView_13);
        this.f13129b = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m12816c(int OplusGLSurfaceView_13) {
        Integer numM12882f = this.f13136i.m12882f(OplusGLSurfaceView_13);
        if (numM12882f != null) {
            m12830a(numM12882f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12831a(boolean z) {
        this.f13130c = z;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m12850g() {
        return this.f13130c;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12836b(Size size) {
        CameraLog.m12954a("Beauty3DManager", "onBeauty3DResume, beauty3dState: " + this.f13129b);
        if (this.f13134g != null) {
            if (this.f13129b == 1) {
                Beauty3DUIListener interfaceC2676d = this.f13135h;
                if (interfaceC2676d != null) {
                    interfaceC2676d.mo12299c(true);
                }
                this.f13134g.m18726a(0, false, Util.m24187O(), Util.m24186N());
                this.f13134g.m18739d(false);
            } else if (this.f13129b == 2) {
                Beauty3DUIListener interfaceC2676d2 = this.f13135h;
                if (interfaceC2676d2 != null) {
                    interfaceC2676d2.mo12299c(true);
                }
                this.f13134g.m18725a(0, false);
                this.f13134g.m18739d(false);
            } else if (this.f13129b == 7 || this.f13129b == 9) {
                Beauty3DUIListener interfaceC2676d3 = this.f13135h;
                if (interfaceC2676d3 != null) {
                    interfaceC2676d3.mo12299c(true);
                }
                if (this.f13129b == 7 && this.f13134g.m18747k() != 1) {
                    if (this.f13134g.m18747k() == 0) {
                        this.f13134g.m18722a();
                    }
                    m12827a(1, size);
                }
                this.f13134g.m18742f();
            } else if (this.f13129b == 8 || this.f13129b == 6) {
                CameraLog.m12954a("Beauty3DManager", "onBeauty3DResume, editUICurrentState: " + this.f13134g.m18747k());
                if (this.f13134g.m18747k() == 0) {
                    m12853j();
                }
                m12827a(this.f13129b == 8 ? 2 : 1, size);
                this.f13134g.m18736c(false);
            }
            if (this.f13129b != 0) {
                this.f13134g.m18746j();
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m12851h() {
        Beauty3DUIListener interfaceC2676d = this.f13135h;
        if (interfaceC2676d != null) {
            interfaceC2676d.mo12299c(false);
        }
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            c3140g.m18726a(0, false, Util.m24187O(), Util.m24186N());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12838b(boolean z) {
        Beauty3DUIListener interfaceC2676d = this.f13135h;
        if (interfaceC2676d != null) {
            interfaceC2676d.mo12299c(false);
        }
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            c3140g.m18739d(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12841c(Size size) {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g == null || size == null) {
            return;
        }
        c3140g.m18732b(Util.m24426d(size.getWidth(), size.getHeight()), Util.m24292a(size), Util.m24187O(), Util.m24186N());
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m12852i() {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            return c3140g.m18737c();
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m12853j() {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            c3140g.m18722a();
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m12854k() {
        if (this.f13135h != null) {
            m12831a(false);
            m12826a(1);
            this.f13135h.mo12300d();
            this.f13140m++;
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m12855l() {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            c3140g.m18748l();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12827a(int OplusGLSurfaceView_13, Size size) {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g == null || size == null) {
            return;
        }
        c3140g.m18724a(OplusGLSurfaceView_13, Util.m24426d(size.getWidth(), size.getHeight()), Util.m24292a(size));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m12844d(Size size) {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g == null || size == null) {
            return;
        }
        c3140g.m18735c(Util.m24426d(size.getWidth(), size.getHeight()), Util.m24292a(size), Util.m24187O(), Util.m24186N());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12830a(Integer num) {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            c3140g.m18728a(num);
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m12856m() {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            c3140g.m18731b();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12834b(final int OplusGLSurfaceView_13) {
        Activity activity = this.f13128a;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_4.7
                @Override // java.lang.Runnable
                public void run() {
                    if (Beauty3DManager.this.f13134g != null) {
                        Beauty3DManager.this.f13134g.m18723a(OplusGLSurfaceView_13);
                    }
                }
            });
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12842c(String str, int[] iArr) throws Resources.NotFoundException {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            c3140g.m18729a(str, iArr);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12843c(boolean z) {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            c3140g.m18733b(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m12845d(boolean z) {
        Beauty3DUIListener interfaceC2676d = this.f13135h;
        if (interfaceC2676d != null) {
            interfaceC2676d.mo12299c(false);
        }
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            c3140g.m18736c(z);
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public HashMap<String, int[]> m12857n() {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            return c3140g.m18743g();
        }
        return null;
    }

    /* renamed from: o */
    public void m12858o() {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            c3140g.m18744h();
        }
    }

    /* renamed from: p */
    public void m12859p() {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            c3140g.m18745i();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m12848e(boolean z) {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            c3140g.m18741e(z);
        }
    }

    /* renamed from: q */
    public void m12860q() {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            c3140g.m18746j();
        }
    }

    /* renamed from: r */
    public void m12861r() {
        Beauty3DUI c3140g = this.f13134g;
        if (c3140g != null) {
            c3140g.m18740e();
        }
        this.f13134g = null;
        this.f13135h = null;
        this.f13129b = 0;
    }
}
