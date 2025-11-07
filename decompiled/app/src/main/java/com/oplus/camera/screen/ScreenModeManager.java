package com.oplus.camera.screen;

import android.app.Activity;
import android.view.View;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.capmode.BaseMode;
import com.oplus.camera.p172ui.menu.facebeauty.RotateAnimationView;
import com.oplus.camera.screen.ScreenModeChangeAnimation;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.screen.p163a.ScreenSwitchController;
import com.oplus.camera.screen.p163a.IScreenSwitchInterface;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.screen.p164b.CommonScreenMode;
import com.oplus.camera.screen.p164b.FullScreenMode0;
import com.oplus.camera.screen.p164b.FullScreenMode270;
import com.oplus.camera.screen.p164b.FullScreenMode90;
import com.oplus.camera.screen.p164b.LeftScreenMode;
import com.oplus.camera.screen.p164b.OutScreenMode;
import com.oplus.camera.screen.p164b.RackScreenMode270;
import com.oplus.camera.screen.p164b.RackScreenMode90;
import com.oplus.camera.screen.p164b.RightScreenMode;
import com.oplus.camera.statistics.DcsUtil;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ScreenModeManager.java */
/* renamed from: com.oplus.camera.screen.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class ScreenModeManager implements IScreenSwitchInterface {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Activity f16038c;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private BaseScreenMode f16041f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ScreenSwitchController f16043h;

    /* renamed from: OplusGLSurfaceView_15 */
    private BaseMode f16045j;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private IUIManager f16039d = null;

    /* renamed from: PlatformImplementations.kt_3 */
    public List<BaseScreenMode> f16036a = new ArrayList();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private BaseScreenMode f16040e = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ScreenModeChangeAnimation f16042g = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f16044i = false;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ScreenModeConst.PlatformImplementations.kt_3 f16037b = ScreenModeConst.PlatformImplementations.kt_3.out;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f16046k = false;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f16047l = false;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f16048m = false;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f16049n = 1;

    /* renamed from: o */
    private boolean f16050o = true;

    /* renamed from: p */
    private boolean f16051p = true;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16662c() {
    }

    public ScreenModeManager(Activity activity) {
        this.f16038c = null;
        this.f16041f = null;
        this.f16043h = null;
        this.f16038c = activity;
        this.f16043h = new ScreenSwitchController(activity, this);
        int length = ScreenModeConst.PlatformImplementations.kt_3.values().length;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            switch (r5[OplusGLSurfaceView_13]) {
                case common:
                    this.f16036a.add(new CommonScreenMode());
                    break;
                case out:
                    this.f16036a.add(new OutScreenMode());
                    break;
                case full:
                    this.f16036a.add(new FullScreenMode0());
                    break;
                case full90:
                    this.f16036a.add(new FullScreenMode90());
                    break;
                case full270:
                    this.f16036a.add(new FullScreenMode270());
                    break;
                case left:
                    this.f16036a.add(new LeftScreenMode());
                    break;
                case right:
                    this.f16036a.add(new RightScreenMode());
                    break;
                case rack90:
                    this.f16036a.add(new RackScreenMode90());
                    break;
                case rack270:
                    this.f16036a.add(new RackScreenMode270());
                    break;
            }
        }
        if (Util.m24495t()) {
            this.f16041f = this.f16036a.get(ScreenModeConst.PlatformImplementations.kt_3.out.ordinal());
            DcsUtil.sFoldType = this.f16041f.mo16495a(this.f16047l);
        } else {
            this.f16041f = this.f16036a.get(ScreenModeConst.PlatformImplementations.kt_3.common.ordinal());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16656a(ScreenModeConst.PlatformImplementations.kt_3 aVar, boolean z, boolean z2) {
        ScreenModeConst.PlatformImplementations.kt_3 aVar2;
        BaseScreenMode abstractC2934a;
        CameraLog.m12967f("ScreenModeManager", "changeScreenMode, screenMode: " + aVar + ", forceChange: " + z + ", fromClick: " + z2 + ", mbStopped: " + this.f16048m);
        if (this.f16048m) {
            return;
        }
        this.f16046k = z;
        this.f16047l = z2;
        boolean z3 = true;
        if (aVar == ScreenModeConst.PlatformImplementations.kt_3.low90) {
            aVar2 = ScreenModeConst.PlatformImplementations.kt_3.rack90;
        } else if (aVar == ScreenModeConst.PlatformImplementations.kt_3.low270) {
            aVar2 = ScreenModeConst.PlatformImplementations.kt_3.rack270;
        } else {
            z3 = false;
            aVar2 = aVar;
        }
        BaseScreenMode abstractC2934a2 = this.f16036a.get(aVar2.ordinal());
        if (this.f16039d == null || this.f16038c == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("changeScreenMode, targetScreenMode: ");
        sb.append(abstractC2934a2);
        sb.append(", mCurrentScreenMode: ");
        sb.append(this.f16041f);
        sb.append(", mCapMode: ");
        BaseMode baseMode = this.f16045j;
        sb.append(baseMode == null ? null : baseMode.getCameraMode());
        CameraLog.m12967f("ScreenModeManager", sb.toString());
        if (this.f16045j != null && abstractC2934a2.mo16509c().contains(this.f16045j.getCameraMode())) {
            if (this.f16041f.mo16509c().contains(this.f16045j.getCameraMode())) {
                return;
            } else {
                abstractC2934a2 = this.f16036a.get(this.f16045j.getPreferredScreenMode(this.f16043h.m16488c()).ordinal());
            }
        }
        if (z || (abstractC2934a = this.f16041f) != abstractC2934a2) {
            m16648a(aVar, abstractC2934a2);
            if (this.f16041f.mo16631r()) {
                this.f16041f.mo16624b(z3);
            }
            if (this.f16044i) {
                if (this.f16042g == null) {
                    this.f16042g = new ScreenModeChangeAnimation(new ScreenModeChangeAnimation.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.screen.COUIBaseListPopupWindow_11.1
                        @Override // com.oplus.camera.screen.ScreenModeChangeAnimation.IntrinsicsJvm.kt_4
                        /* renamed from: PlatformImplementations.kt_3 */
                        public View mo16644a() {
                            return ScreenModeManager.this.f16038c.findViewById(R.id_renamed.camera);
                        }

                        @Override // com.oplus.camera.screen.ScreenModeChangeAnimation.IntrinsicsJvm.kt_4
                        /* renamed from: IntrinsicsJvm.kt_4 */
                        public View mo16645b() {
                            return ScreenModeManager.this.f16038c.findViewById(R.id_renamed.gallery_container);
                        }

                        @Override // com.oplus.camera.screen.ScreenModeChangeAnimation.IntrinsicsJvm.kt_4
                        /* renamed from: IntrinsicsJvm.kt_3 */
                        public void mo16646c() {
                            ScreenModeManager.this.f16039d.mo16492a(ScreenModeManager.this.f16040e, ScreenModeManager.this.f16041f);
                            ScreenModeManager.this.f16039d.mo16493a(ScreenModeManager.this.f16041f, ScreenModeManager.this.f16046k);
                            ScreenModeManager.this.f16039d.mo16491a(ScreenModeManager.this.f16041f);
                        }
                    });
                }
                this.f16042g.m16640a();
            } else {
                this.f16039d.mo16492a(this.f16040e, this.f16041f);
                this.f16039d.mo16493a(this.f16041f, this.f16046k);
                this.f16039d.mo16491a(this.f16041f);
            }
        } else if (abstractC2934a.mo16630q() != z3) {
            m16648a(aVar, abstractC2934a2);
            this.f16039d.mo16492a(this.f16040e, this.f16041f);
            this.f16041f.mo16624b(z3);
            this.f16039d.mo16493a(this.f16041f, this.f16046k);
            this.f16039d.mo16491a(this.f16041f);
        }
        DcsUtil.sFoldType = this.f16041f.mo16495a(this.f16047l);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16648a(ScreenModeConst.PlatformImplementations.kt_3 aVar, BaseScreenMode abstractC2934a) {
        this.f16040e = this.f16041f;
        this.f16041f = abstractC2934a;
        this.f16037b = aVar;
        this.f16043h.m16484a(aVar);
    }

    @Override // com.oplus.camera.screen.p163a.IScreenSwitchInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public BaseScreenMode mo16411a() {
        return this.f16041f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16654a(int OplusGLSurfaceView_13) {
        ScreenSwitchController c2932e = this.f16043h;
        if (c2932e != null) {
            c2932e.m16481a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16660b(int OplusGLSurfaceView_13) {
        ScreenSwitchController c2932e = this.f16043h;
        if (c2932e != null) {
            c2932e.m16487b(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m16659b() {
        if (this.f16041f.mo16504a()) {
            return this.f16043h.m16488c();
        }
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16657a(boolean z) {
        this.f16048m = z;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m16664d() {
        this.f16044i = true;
        this.f16048m = false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m16665e() {
        ScreenModeChangeAnimation c2951e = this.f16042g;
        if (c2951e != null) {
            c2951e.m16642b();
        }
        this.f16044i = false;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m16666f() {
        this.f16048m = true;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m16667g() {
        this.f16038c = null;
        ScreenSwitchController c2932e = this.f16043h;
        if (c2932e != null) {
            c2932e.m16480a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16655a(IUIManager interfaceC2933b) {
        this.f16039d = interfaceC2933b;
    }

    @Override // com.oplus.camera.screen.p163a.IScreenSwitchInterface
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo16413b(ScreenModeConst.PlatformImplementations.kt_3 aVar, boolean z, boolean z2) {
        if (z || (aVar != null && !aVar.name().equals(this.f16037b.name()))) {
            CameraLog.m12959b("ScreenModeManager", "notifyFolderChange : " + aVar.name());
            m16656a(aVar, z, z2);
        }
        DcsUtil.sFoldType = this.f16041f.mo16495a(z2);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m16668h() {
        ScreenSwitchController c2932e = this.f16043h;
        if (c2932e != null) {
            c2932e.m16486b();
        }
    }

    @Override // com.oplus.camera.screen.p163a.IScreenSwitchInterface
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo16412a(BaseMode baseMode) {
        this.f16045j = baseMode;
        m16650b(baseMode);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m16650b(BaseMode baseMode) {
        ScreenSwitchController c2932e = this.f16043h;
        ScreenModeConst.PlatformImplementations.kt_3 preferredScreenMode = (c2932e == null || baseMode == null) ? null : baseMode.getPreferredScreenMode(c2932e.m16488c());
        if (ScreenModeConst.PlatformImplementations.kt_3.left != preferredScreenMode && ScreenModeConst.PlatformImplementations.kt_3.right != preferredScreenMode && ScreenModeConst.PlatformImplementations.kt_3.common != preferredScreenMode) {
            this.f16050o = false;
        } else {
            this.f16050o = true;
        }
    }

    @Override // com.oplus.camera.screen.p163a.IScreenSwitchInterface
    /* renamed from: OplusGLSurfaceView_13 */
    public ScreenModeConst.PlatformImplementations.kt_3 mo16414i() {
        return this.f16037b;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public ScreenSwitchController m16669j() {
        return this.f16043h;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16661b(boolean z) {
        RotateAnimationView rotateAnimationView = (RotateAnimationView) this.f16038c.findViewById(R.id_renamed.screen_mode_switch_button);
        if (rotateAnimationView != null) {
            if (z) {
                rotateAnimationView.setImageResource(R.drawable.ic_screen_mode_expand);
            } else {
                rotateAnimationView.setImageResource(R.drawable.icon_screen_mode_switch);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m16670k() {
        return this.f16041f.mo16517i() && this.f16050o && this.f16051p;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m16671l() {
        Activity activity = this.f16038c;
        if (activity != null) {
            activity.findViewById(R.id_renamed.camera).setAlpha(1.0f);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16663c(int OplusGLSurfaceView_13) {
        ScreenSwitchController c2932e = this.f16043h;
        if (c2932e != null) {
            c2932e.m16490d(OplusGLSurfaceView_13);
        }
        int i2 = this.f16049n;
        this.f16051p = (2 == i2 || 3 == i2) ? false : true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m16658a(String str) {
        ScreenSwitchController c2932e;
        boolean z = true;
        if (this.f16045j == null) {
            return true;
        }
        if (!this.f16041f.mo16509c().contains(this.f16045j.getCameraMode()) && ((c2932e = this.f16043h) == null || !c2932e.m16485a(str))) {
            z = false;
        }
        CameraLog.m12959b("ScreenModeManager", "checkIfScreenModeNeedChange, needChange: " + z);
        return z;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public BaseScreenMode m16672m() {
        return this.f16040e;
    }
}
