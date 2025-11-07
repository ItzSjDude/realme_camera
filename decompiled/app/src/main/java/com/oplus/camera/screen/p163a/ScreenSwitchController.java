package com.oplus.camera.screen.p163a;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.oplus.camera.CameraLog;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.screen.FolderAngleDetectService;
import com.oplus.camera.screen.p163a.IScreenSwitchInterface;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.util.Util;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/* compiled from: ScreenSwitchController.java */
/* renamed from: com.oplus.camera.screen.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class ScreenSwitchController {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Context f15992d;

    /* renamed from: OplusGLSurfaceView_13 */
    private Handler f15997i;

    /* renamed from: PlatformImplementations.kt_3 */
    private ContentResolver f15989a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private IScreenSwitchInterface f15990b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ScreenModeDecision f15991c = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f15993e = 1;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f15994f = -1;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f15995g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f15996h = Util.f23001i;

    /* renamed from: OplusGLSurfaceView_15 */
    private BaseMode f15998j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private ArrayList<String> f15999k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f16000l = false;

    /* renamed from: OplusGLSurfaceView_6 */
    private final IScreenSwitchInterface.PlatformImplementations.kt_3 f16001m = new IScreenSwitchInterface.PlatformImplementations.kt_3() { // from class: com.oplus.camera.screen.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.1
        @Override // com.oplus.camera.screen.p163a.IScreenSwitchInterface.PlatformImplementations.kt_3
        public void onEvent(int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            CameraLog.m12954a("ScreenSwitchController", "onEvent, state: " + OplusGLSurfaceView_13);
            if (ScreenSwitchController.this.f15997i == null || !Util.m24498u()) {
                return;
            }
            ScreenSwitchController c2932e = ScreenSwitchController.this;
            if (c2932e.m16475e(c2932e.f15996h) != ScreenSwitchController.this.m16475e(OplusGLSurfaceView_13)) {
                Util.m24182J();
                ScreenSwitchController.this.f15997i.removeCallbacksAndMessages(null);
                Message messageObtain = Message.obtain();
                messageObtain.what = 100;
                ScreenSwitchController.this.f15997i.sendMessage(messageObtain);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m16475e(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 60) {
            return 3;
        }
        return OplusGLSurfaceView_13 < 150 ? 2 : 1;
    }

    public ScreenSwitchController(Context context, IScreenSwitchInterface interfaceC2928a) {
        this.f15992d = null;
        this.f15997i = null;
        this.f15992d = context;
        m16469a(interfaceC2928a);
        FolderAngleDetectService.m16408a(this.f16001m);
        this.f15997i = new Handler() { // from class: com.oplus.camera.screen.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 100:
                        if (2 != ScreenSwitchController.this.f15993e && 3 != ScreenSwitchController.this.f15993e) {
                            ScreenSwitchController.this.f15996h = Util.f23001i;
                            ScreenSwitchController.this.f15990b.mo16413b(ScreenSwitchController.this.f15991c.m16466a(ScreenSwitchController.this.f15994f, Util.f23001i, ScreenSwitchController.this.f15995g, false, false), false, false);
                            ScreenSwitchController.this.f16000l = false;
                            break;
                        }
                        break;
                    case 101:
                        ScreenSwitchController.this.f15990b.mo16413b(ScreenSwitchController.this.f15991c.m16466a(ScreenSwitchController.this.f15994f, Util.f23001i, ScreenSwitchController.this.f15995g, true, false), false, true);
                        ScreenSwitchController c2932e = ScreenSwitchController.this;
                        c2932e.f16000l = c2932e.f15990b.mo16411a().mo16599o();
                        break;
                    case 102:
                        ScreenSwitchController.this.f15990b.mo16413b(ScreenSwitchController.this.f15991c.m16466a(ScreenSwitchController.this.f15994f, Util.f23001i, ScreenSwitchController.this.f15995g, ScreenSwitchController.this.f16000l, true), false, ScreenSwitchController.this.f16000l);
                        break;
                    case 103:
                        ScreenSwitchController.this.f15990b.mo16413b(ScreenSwitchController.this.f15991c.m16466a(ScreenSwitchController.this.f15994f, Util.f23001i, ScreenSwitchController.this.f15995g, ScreenSwitchController.this.f16000l, true), false, ScreenSwitchController.this.f16000l);
                        break;
                }
            }
        };
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16469a(IScreenSwitchInterface interfaceC2928a) {
        this.f15989a = this.f15992d.getContentResolver();
        this.f15991c = new ScreenModeDecision();
        this.f15990b = interfaceC2928a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16481a(int OplusGLSurfaceView_13) {
        CameraLog.m12959b("ScreenSwitchController", "setOrientation, mOrientation: " + this.f15994f + " --> " + OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 != this.f15994f) {
            this.f15994f = OplusGLSurfaceView_13;
            int i2 = this.f15993e;
            if (2 == i2 || 3 == i2) {
                m16489c(this.f15994f);
                return;
            }
            Util.m24449f();
            this.f15997i.removeCallbacksAndMessages(null);
            Message messageObtain = Message.obtain();
            messageObtain.what = 102;
            this.f15997i.sendMessage(messageObtain);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16487b(int OplusGLSurfaceView_13) {
        if (this.f15995g != OplusGLSurfaceView_13) {
            CameraLog.m12954a("ScreenSwitchController", "updateCameraId, " + this.f15995g + "-->" + OplusGLSurfaceView_13);
            this.f15995g = OplusGLSurfaceView_13;
            this.f15997i.removeCallbacksAndMessages(null);
            Message messageObtain = Message.obtain();
            messageObtain.what = 103;
            this.f15997i.sendMessage(messageObtain);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16483a(BaseMode baseMode) {
        int OplusGLSurfaceView_13;
        ScreenModeConst.PlatformImplementations.kt_3 aVarM16466a;
        if (baseMode == null || this.f15998j == baseMode || 2 == (OplusGLSurfaceView_13 = this.f15993e) || 3 == OplusGLSurfaceView_13) {
            return;
        }
        CameraLog.m12959b("ScreenSwitchController", "updateCapMode, mode: " + baseMode.getCameraMode());
        this.f15998j = baseMode;
        this.f15990b.mo16412a(baseMode);
        BaseScreenMode abstractC2934aMo16411a = this.f15990b.mo16411a();
        ScreenModeConst.PlatformImplementations.kt_3 aVarMo16414i = this.f15990b.mo16414i();
        this.f15999k = abstractC2934aMo16411a.mo16509c();
        if (this.f15999k == null) {
            return;
        }
        ScreenModeConst.PlatformImplementations.kt_3 preferredScreenMode = baseMode.getPreferredScreenMode(this.f15994f);
        CameraLog.m12959b("ScreenSwitchController", "updateCapMode, preferredScreenMode: " + preferredScreenMode);
        if ((this.f15999k.contains(baseMode.getCameraMode()) && ScreenModeConst.PlatformImplementations.kt_3.common != preferredScreenMode) || (Util.m24498u() && ScreenModeConst.PlatformImplementations.kt_3.out == aVarMo16414i)) {
            CameraLog.m12959b("ScreenSwitchController", "updateCapMode, notifyFolderChange, preferredScreenMode: " + preferredScreenMode);
            this.f16000l = false;
            this.f15990b.mo16413b(preferredScreenMode, true, false);
            return;
        }
        if ((this.f16000l && abstractC2934aMo16411a.mo16599o()) || (aVarM16466a = this.f15991c.m16466a(this.f15994f, Util.f23001i, this.f15995g, false, false)) == this.f15990b.mo16414i()) {
            return;
        }
        CameraLog.m12959b("ScreenSwitchController", "updateCapMode, targetScreenMode: " + aVarM16466a);
        this.f15990b.mo16413b(aVarM16466a, true, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16482a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2) {
        if (z2 || !this.f16000l) {
            this.f15996h = Util.f23001i;
            BaseMode baseMode = this.f15998j;
            if (baseMode != null && baseMode.getLockedScreenMode() != null) {
                this.f15990b.mo16413b(this.f15998j.getLockedScreenMode(), z2, z);
            } else {
                this.f15990b.mo16413b(this.f15991c.m16466a(OplusGLSurfaceView_13, Util.f23001i, i2, z, false), z2, z);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16489c(int OplusGLSurfaceView_13) {
        ScreenModeConst.PlatformImplementations.kt_3 aVar;
        ScreenModeConst.PlatformImplementations.kt_3 aVar2 = ScreenModeConst.PlatformImplementations.kt_3.common;
        if (-1 == Util.m24451g()) {
            aVar = ScreenModeConst.PlatformImplementations.kt_3.common;
        } else if (Util.m24451g() == 0) {
            aVar = ScreenModeConst.PlatformImplementations.kt_3.out;
        } else if (OplusGLSurfaceView_13 == 0) {
            aVar = ScreenModeConst.PlatformImplementations.kt_3.full;
        } else if (90 == OplusGLSurfaceView_13) {
            aVar = ScreenModeConst.PlatformImplementations.kt_3.full270;
        } else if (270 == OplusGLSurfaceView_13) {
            aVar = ScreenModeConst.PlatformImplementations.kt_3.full90;
        } else {
            aVar = ScreenModeConst.PlatformImplementations.kt_3.full;
        }
        this.f15990b.mo16413b(aVar, false, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16480a() {
        Handler handler = this.f15997i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f15997i = null;
        }
        this.f15992d = null;
        FolderAngleDetectService.m16410b(this.f16001m);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16484a(ScreenModeConst.PlatformImplementations.kt_3 aVar) {
        ScreenModeDecision c2931d = this.f15991c;
        c2931d.f15988b = aVar;
        c2931d.f15987a = aVar;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16486b() {
        Handler handler = this.f15997i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Message messageObtain = Message.obtain();
            messageObtain.what = 101;
            this.f15997i.sendMessage(messageObtain);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m16488c() {
        return this.f15994f;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m16490d(int OplusGLSurfaceView_13) {
        this.f15993e = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m16485a(String str) {
        ScreenModeConst.PlatformImplementations.kt_3 aVarValueOf = ScreenModeConst.PlatformImplementations.kt_3.valueOf(str);
        boolean z = aVarValueOf != this.f15991c.m16465a(this.f15994f, Util.f23001i, this.f15995g);
        boolean z2 = this.f16000l && (aVarValueOf == ScreenModeConst.PlatformImplementations.kt_3.left || aVarValueOf == ScreenModeConst.PlatformImplementations.kt_3.right);
        CameraLog.m12959b("ScreenSwitchController", "checkIfScreenModeNeedChange, needChange: " + z + ", needLock: " + z2);
        return z && !z2;
    }
}
