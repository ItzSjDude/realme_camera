package com.oplus.camera;

import android.hardware.camera2.CaptureResult;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p141e.CameraMetadataKey;

/* compiled from: AISSnapshotManager.java */
/* renamed from: com.oplus.camera.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class AISSnapshotManager implements CameraConstant {

    /* renamed from: OplusGLSurfaceView_5 */
    private CameraInterface f12549k;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f12545g = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f12546h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f12547i = -1;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f12548j = -1;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f12550l = -1;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f12551m = 0;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f12552n = 0;

    public AISSnapshotManager(CameraInterface interfaceC2646a) {
        this.f12549k = null;
        this.f12549k = interfaceC2646a;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int m11644h() {
        if (this.f12546h) {
            return this.f12547i;
        }
        return -1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m11647a() {
        CameraInterface interfaceC2646a = this.f12549k;
        if (interfaceC2646a != null && interfaceC2646a.mo10589s()) {
            return (this.f12545g && 1 < this.f12548j) || 1 < m11644h();
        }
        CameraInterface interfaceC2646a2 = this.f12549k;
        if (interfaceC2646a2 == null || interfaceC2646a2.mo10589s()) {
            return false;
        }
        return (this.f12545g && this.f12548j > 0) || m11644h() > 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11645a(int OplusGLSurfaceView_13, int i2, int i3) {
        this.f12548j = i2;
        this.f12545g = 1 == OplusGLSurfaceView_13;
        this.f12546h = 1 == i3;
        CameraLog.m12954a("AISSnapshotManager", "updateAISStatus, mbAisNeeded: " + this.f12545g + ", mAISMotionType: " + this.f12548j + ", onSODStatusCheck: " + m11644h() + ", mbAISWithinTriggered: " + this.f12546h);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11646a(CaptureResult captureResult) {
        try {
            int[] iArr = (int[]) captureResult.get(CameraMetadataKey.f13353j);
            if (iArr != null && iArr.length > 0) {
                this.f12547i = iArr[1] == 0 ? iArr[0] : 2;
            } else {
                this.f12547i = -1;
            }
        } catch (Exception unused) {
        }
        m11654g();
        CameraLog.m12954a("AISSnapshotManager", "updateSODStatus, mSODMovementLevel: " + this.f12547i);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m11643a(boolean z) {
        CameraInterface interfaceC2646a = this.f12549k;
        if (interfaceC2646a == null) {
            return;
        }
        interfaceC2646a.mo10555b(z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11649b() {
        this.f12545g = false;
        this.f12546h = false;
        this.f12547i = -1;
        this.f12548j = -1;
        this.f12550l = -1;
        this.f12551m = 0;
        this.f12552n = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m11650c() {
        CameraLog.m12959b("AISSnapshotManager", "onPause");
        m11649b();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m11651d() {
        CameraLog.m12959b("AISSnapshotManager", "onDestroy");
        m11649b();
        this.f12549k = null;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m11652e() {
        CameraLog.m12954a("AISSnapshotManager", "makeAISDecision");
        CameraInterface interfaceC2646a = this.f12549k;
        if (interfaceC2646a == null || !interfaceC2646a.mo10586p()) {
            CameraLog.m12954a("AISSnapshotManager", "makeAISDecision, not support");
            return false;
        }
        if (m11644h() > 0) {
            m11643a(false);
        } else {
            m11643a(3 > this.f12548j);
        }
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m11653f() {
        CameraInterface interfaceC2646a = this.f12549k;
        if (interfaceC2646a == null || !interfaceC2646a.mo10586p()) {
            return -1;
        }
        if (2 == m11644h()) {
            return 11;
        }
        if (!this.f12545g || 2 >= this.f12548j) {
            return (1 == m11644h() || (this.f12545g && this.f12548j > 0)) ? 1 : -1;
        }
        return 11;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m11648a(String[] strArr, float COUIBaseListPopupWindow_12) throws NumberFormatException {
        boolean z = false;
        for (String str : strArr) {
            String[] strArrSplit = str.split(" ");
            if (2 == strArrSplit.length && !strArrSplit[0].isEmpty()) {
                boolean z2 = true;
                if (!strArrSplit[1].isEmpty()) {
                    int length = strArrSplit[1].length() - 1;
                    float f2 = Float.parseFloat(strArrSplit[0].substring(1));
                    float f3 = Float.parseFloat(strArrSplit[1].substring(0, length));
                    boolean z3 = !strArrSplit[0].contains("[") ? !strArrSplit[0].contains("(") || Float.compare(COUIBaseListPopupWindow_12, f2) <= 0 : Float.compare(COUIBaseListPopupWindow_12, f2) < 0;
                    boolean z4 = !strArrSplit[1].contains("]") ? !(strArrSplit[1].contains(")") && z3 && Float.compare(COUIBaseListPopupWindow_12, f3) < 0) : !z3 || Float.compare(COUIBaseListPopupWindow_12, f3) > 0;
                    if (!z && !z4) {
                        z2 = false;
                    }
                    z = z2;
                }
            }
        }
        return z;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m11654g() {
        if (this.f12549k != null) {
            int iM11653f = m11653f();
            boolean zMo10587q = this.f12549k.mo10587q();
            boolean zMo10588r = this.f12549k.mo10588r();
            if (iM11653f == this.f12550l && zMo10587q == this.f12551m && zMo10588r == this.f12552n) {
                return;
            }
            this.f12550l = iM11653f;
            this.f12551m = zMo10587q ? 1 : 0;
            this.f12552n = zMo10588r ? 1 : 0;
            this.f12549k.mo10474a(this.f12550l, this.f12551m, this.f12552n);
        }
    }
}
