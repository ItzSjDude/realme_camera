package com.oplus.camera.screen.p163a;

import com.oplus.camera.CameraLog;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.util.Util;

/* compiled from: ScreenModeDecision.java */
/* renamed from: com.oplus.camera.screen.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class ScreenModeDecision {

    /* renamed from: PlatformImplementations.kt_3 */
    ScreenModeConst.PlatformImplementations.kt_3 f15987a = ScreenModeConst.PlatformImplementations.kt_3.out;

    /* renamed from: IntrinsicsJvm.kt_4 */
    ScreenModeConst.PlatformImplementations.kt_3 f15988b = ScreenModeConst.PlatformImplementations.kt_3.out;

    /* renamed from: PlatformImplementations.kt_3 */
    public ScreenModeConst.PlatformImplementations.kt_3 m16466a(int OplusGLSurfaceView_13, int i2, int i3, boolean z, boolean z2) {
        CameraLog.m12959b("ScreenModeDecision", "getDecisionChangeScreenMode, orientation: " + OplusGLSurfaceView_13 + ", angle: " + i2 + ", cameraid: " + i3 + ", isClick: " + z + "isRotateOrCameraIdChange: " + z2);
        if (!z) {
            this.f15988b = m16465a(OplusGLSurfaceView_13, i2, i3);
            ScreenModeConst.PlatformImplementations.kt_3 aVar = this.f15987a;
            ScreenModeConst.PlatformImplementations.kt_3 aVar2 = this.f15988b;
            if (aVar != aVar2) {
                this.f15987a = aVar2;
            }
            return this.f15988b;
        }
        return m16464a(OplusGLSurfaceView_13, i2, i3, z2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ScreenModeConst.PlatformImplementations.kt_3 m16464a(int OplusGLSurfaceView_13, int i2, int i3, boolean z) {
        ScreenModeConst.PlatformImplementations.kt_3 aVar = ScreenModeConst.PlatformImplementations.kt_3.common;
        if (this.f15987a == ScreenModeConst.PlatformImplementations.kt_3.right || this.f15987a == ScreenModeConst.PlatformImplementations.kt_3.left) {
            if (-1 == Util.m24451g()) {
                aVar = ScreenModeConst.PlatformImplementations.kt_3.common;
            } else if (Util.m24451g() == 0) {
                aVar = ScreenModeConst.PlatformImplementations.kt_3.out;
            } else if (Util.f23001i < 60) {
                aVar = OplusGLSurfaceView_13 == 0 ? ScreenModeConst.PlatformImplementations.kt_3.full : 90 == OplusGLSurfaceView_13 ? ScreenModeConst.PlatformImplementations.kt_3.low270 : 270 == OplusGLSurfaceView_13 ? ScreenModeConst.PlatformImplementations.kt_3.low90 : ScreenModeConst.PlatformImplementations.kt_3.full;
            } else if (Util.f23001i < 150) {
                aVar = OplusGLSurfaceView_13 == 0 ? ScreenModeConst.PlatformImplementations.kt_3.full : 90 == OplusGLSurfaceView_13 ? ScreenModeConst.PlatformImplementations.kt_3.rack270 : 270 == OplusGLSurfaceView_13 ? ScreenModeConst.PlatformImplementations.kt_3.rack90 : ScreenModeConst.PlatformImplementations.kt_3.full;
            } else if (1 == Util.m24451g()) {
                if (z && (ScreenModeConst.PlatformImplementations.kt_3.right == this.f15987a || ScreenModeConst.PlatformImplementations.kt_3.left == this.f15987a)) {
                    aVar = this.f15987a;
                    if (1 == i3) {
                        aVar = ScreenModeConst.PlatformImplementations.kt_3.left;
                    } else if (i3 == 0) {
                        aVar = ScreenModeConst.PlatformImplementations.kt_3.right;
                    }
                } else {
                    aVar = OplusGLSurfaceView_13 == 0 ? ScreenModeConst.PlatformImplementations.kt_3.full : 90 == OplusGLSurfaceView_13 ? ScreenModeConst.PlatformImplementations.kt_3.full270 : 270 == OplusGLSurfaceView_13 ? ScreenModeConst.PlatformImplementations.kt_3.full90 : ScreenModeConst.PlatformImplementations.kt_3.full;
                }
            }
        } else if (this.f15987a == ScreenModeConst.PlatformImplementations.kt_3.full || this.f15987a == ScreenModeConst.PlatformImplementations.kt_3.full90 || this.f15987a == ScreenModeConst.PlatformImplementations.kt_3.full270) {
            aVar = 1 == i3 ? ScreenModeConst.PlatformImplementations.kt_3.left : ScreenModeConst.PlatformImplementations.kt_3.right;
        }
        CameraLog.m12959b("ScreenModeDecision", "clickDecisionLogic, orientation: " + OplusGLSurfaceView_13 + ", decisionMode: " + aVar);
        return aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ScreenModeConst.PlatformImplementations.kt_3 m16465a(int OplusGLSurfaceView_13, int i2, int i3) {
        ScreenModeConst.PlatformImplementations.kt_3 aVar;
        ScreenModeConst.PlatformImplementations.kt_3 aVar2 = ScreenModeConst.PlatformImplementations.kt_3.common;
        if (-1 == Util.m24451g()) {
            aVar2 = ScreenModeConst.PlatformImplementations.kt_3.common;
        } else if (Util.m24451g() == 0) {
            aVar2 = ScreenModeConst.PlatformImplementations.kt_3.out;
        } else if (Util.f23001i < 60) {
            if (OplusGLSurfaceView_13 == 0) {
                aVar = i3 == 1 ? ScreenModeConst.PlatformImplementations.kt_3.left : ScreenModeConst.PlatformImplementations.kt_3.right;
                aVar2 = aVar;
            } else if (90 == OplusGLSurfaceView_13) {
                aVar2 = ScreenModeConst.PlatformImplementations.kt_3.low270;
            } else if (270 == OplusGLSurfaceView_13) {
                aVar2 = ScreenModeConst.PlatformImplementations.kt_3.low90;
            } else {
                aVar2 = ScreenModeConst.PlatformImplementations.kt_3.right;
            }
        } else if (Util.f23001i < 150) {
            if (OplusGLSurfaceView_13 == 0) {
                aVar = i3 == 1 ? ScreenModeConst.PlatformImplementations.kt_3.left : ScreenModeConst.PlatformImplementations.kt_3.right;
                aVar2 = aVar;
            } else if (90 == OplusGLSurfaceView_13) {
                aVar2 = ScreenModeConst.PlatformImplementations.kt_3.rack270;
            } else if (270 == OplusGLSurfaceView_13) {
                aVar2 = ScreenModeConst.PlatformImplementations.kt_3.rack90;
            } else {
                aVar2 = ScreenModeConst.PlatformImplementations.kt_3.right;
            }
        } else if (1 == Util.m24451g()) {
            if (ScreenModeConst.PlatformImplementations.kt_3.right == this.f15987a && 1 == i3) {
                aVar2 = ScreenModeConst.PlatformImplementations.kt_3.left;
            } else if (ScreenModeConst.PlatformImplementations.kt_3.left == this.f15987a && i3 == 0) {
                aVar2 = ScreenModeConst.PlatformImplementations.kt_3.right;
            } else if (OplusGLSurfaceView_13 == 0) {
                aVar2 = ScreenModeConst.PlatformImplementations.kt_3.full;
            } else if (90 == OplusGLSurfaceView_13) {
                aVar2 = ScreenModeConst.PlatformImplementations.kt_3.full270;
            } else if (270 == OplusGLSurfaceView_13) {
                aVar2 = ScreenModeConst.PlatformImplementations.kt_3.full90;
            } else {
                aVar2 = ScreenModeConst.PlatformImplementations.kt_3.full;
            }
        }
        CameraLog.m12959b("ScreenModeDecision", "commonDecisionLogic, orientation: " + OplusGLSurfaceView_13 + ", decisionMode: " + aVar2);
        return aVar2;
    }
}
