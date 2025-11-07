package com.oplus.camera.screen.a_renamed;

/* compiled from: ScreenModeDecision.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    com.oplus.camera.screen.f_renamed.a_renamed f5353a = com.oplus.camera.screen.f_renamed.a_renamed.out;

    /* renamed from: b_renamed, reason: collision with root package name */
    com.oplus.camera.screen.f_renamed.a_renamed f5354b = com.oplus.camera.screen.f_renamed.a_renamed.out;

    public com.oplus.camera.screen.f_renamed.a_renamed a_renamed(int i_renamed, int i2, int i3, boolean z_renamed, boolean z2) {
        com.oplus.camera.e_renamed.b_renamed("ScreenModeDecision", "getDecisionChangeScreenMode, orientation: " + i_renamed + ", angle: " + i2 + ", cameraid: " + i3 + ", isClick: " + z_renamed + "isRotateOrCameraIdChange: " + z2);
        if (!z_renamed) {
            this.f5354b = a_renamed(i_renamed, i2, i3);
            com.oplus.camera.screen.f_renamed.a_renamed aVar = this.f5353a;
            com.oplus.camera.screen.f_renamed.a_renamed aVar2 = this.f5354b;
            if (aVar != aVar2) {
                this.f5353a = aVar2;
            }
            return this.f5354b;
        }
        return a_renamed(i_renamed, i2, i3, z2);
    }

    private com.oplus.camera.screen.f_renamed.a_renamed a_renamed(int i_renamed, int i2, int i3, boolean z_renamed) {
        com.oplus.camera.screen.f_renamed.a_renamed aVar = com.oplus.camera.screen.f_renamed.a_renamed.common;
        if (this.f5353a == com.oplus.camera.screen.f_renamed.a_renamed.right || this.f5353a == com.oplus.camera.screen.f_renamed.a_renamed.left) {
            if (-1 == com.oplus.camera.util.Util.g_renamed()) {
                aVar = com.oplus.camera.screen.f_renamed.a_renamed.common;
            } else if (com.oplus.camera.util.Util.g_renamed() == 0) {
                aVar = com.oplus.camera.screen.f_renamed.a_renamed.out;
            } else if (com.oplus.camera.util.Util.i_renamed < 60) {
                aVar = i_renamed == 0 ? com.oplus.camera.screen.f_renamed.a_renamed.full : 90 == i_renamed ? com.oplus.camera.screen.f_renamed.a_renamed.low270 : 270 == i_renamed ? com.oplus.camera.screen.f_renamed.a_renamed.low90 : com.oplus.camera.screen.f_renamed.a_renamed.full;
            } else if (com.oplus.camera.util.Util.i_renamed < 150) {
                aVar = i_renamed == 0 ? com.oplus.camera.screen.f_renamed.a_renamed.full : 90 == i_renamed ? com.oplus.camera.screen.f_renamed.a_renamed.rack270 : 270 == i_renamed ? com.oplus.camera.screen.f_renamed.a_renamed.rack90 : com.oplus.camera.screen.f_renamed.a_renamed.full;
            } else if (1 == com.oplus.camera.util.Util.g_renamed()) {
                if (z_renamed && (com.oplus.camera.screen.f_renamed.a_renamed.right == this.f5353a || com.oplus.camera.screen.f_renamed.a_renamed.left == this.f5353a)) {
                    aVar = this.f5353a;
                    if (1 == i3) {
                        aVar = com.oplus.camera.screen.f_renamed.a_renamed.left;
                    } else if (i3 == 0) {
                        aVar = com.oplus.camera.screen.f_renamed.a_renamed.right;
                    }
                } else {
                    aVar = i_renamed == 0 ? com.oplus.camera.screen.f_renamed.a_renamed.full : 90 == i_renamed ? com.oplus.camera.screen.f_renamed.a_renamed.full270 : 270 == i_renamed ? com.oplus.camera.screen.f_renamed.a_renamed.full90 : com.oplus.camera.screen.f_renamed.a_renamed.full;
                }
            }
        } else if (this.f5353a == com.oplus.camera.screen.f_renamed.a_renamed.full || this.f5353a == com.oplus.camera.screen.f_renamed.a_renamed.full90 || this.f5353a == com.oplus.camera.screen.f_renamed.a_renamed.full270) {
            aVar = 1 == i3 ? com.oplus.camera.screen.f_renamed.a_renamed.left : com.oplus.camera.screen.f_renamed.a_renamed.right;
        }
        com.oplus.camera.e_renamed.b_renamed("ScreenModeDecision", "clickDecisionLogic, orientation: " + i_renamed + ", decisionMode: " + aVar);
        return aVar;
    }

    public com.oplus.camera.screen.f_renamed.a_renamed a_renamed(int i_renamed, int i2, int i3) {
        com.oplus.camera.screen.f_renamed.a_renamed aVar;
        com.oplus.camera.screen.f_renamed.a_renamed aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.common;
        if (-1 == com.oplus.camera.util.Util.g_renamed()) {
            aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.common;
        } else if (com.oplus.camera.util.Util.g_renamed() == 0) {
            aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.out;
        } else if (com.oplus.camera.util.Util.i_renamed < 60) {
            if (i_renamed == 0) {
                aVar = i3 == 1 ? com.oplus.camera.screen.f_renamed.a_renamed.left : com.oplus.camera.screen.f_renamed.a_renamed.right;
                aVar2 = aVar;
            } else if (90 == i_renamed) {
                aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.low270;
            } else if (270 == i_renamed) {
                aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.low90;
            } else {
                aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.right;
            }
        } else if (com.oplus.camera.util.Util.i_renamed < 150) {
            if (i_renamed == 0) {
                aVar = i3 == 1 ? com.oplus.camera.screen.f_renamed.a_renamed.left : com.oplus.camera.screen.f_renamed.a_renamed.right;
                aVar2 = aVar;
            } else if (90 == i_renamed) {
                aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.rack270;
            } else if (270 == i_renamed) {
                aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.rack90;
            } else {
                aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.right;
            }
        } else if (1 == com.oplus.camera.util.Util.g_renamed()) {
            if (com.oplus.camera.screen.f_renamed.a_renamed.right == this.f5353a && 1 == i3) {
                aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.left;
            } else if (com.oplus.camera.screen.f_renamed.a_renamed.left == this.f5353a && i3 == 0) {
                aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.right;
            } else if (i_renamed == 0) {
                aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.full;
            } else if (90 == i_renamed) {
                aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.full270;
            } else if (270 == i_renamed) {
                aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.full90;
            } else {
                aVar2 = com.oplus.camera.screen.f_renamed.a_renamed.full;
            }
        }
        com.oplus.camera.e_renamed.b_renamed("ScreenModeDecision", "commonDecisionLogic, orientation: " + i_renamed + ", decisionMode: " + aVar2);
        return aVar2;
    }
}
