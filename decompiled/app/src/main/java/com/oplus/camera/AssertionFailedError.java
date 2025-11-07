package com.oplus.camera;

/* compiled from: AISSnapshotManager.java */
/* loaded from: classes2.dex */
public class b_renamed implements com.oplus.camera.d_renamed {
    private com.oplus.camera.capmode.a_renamed k_renamed;
    private boolean g_renamed = false;
    private boolean h_renamed = false;
    private int i_renamed = -1;
    private int j_renamed = -1;
    private int l_renamed = -1;
    private int m_renamed = 0;
    private int n_renamed = 0;

    public b_renamed(com.oplus.camera.capmode.a_renamed aVar) {
        this.k_renamed = null;
        this.k_renamed = aVar;
    }

    private int h_renamed() {
        if (this.h_renamed) {
            return this.i_renamed;
        }
        return -1;
    }

    public boolean a_renamed() {
        com.oplus.camera.capmode.a_renamed aVar = this.k_renamed;
        if (aVar != null && aVar.s_renamed()) {
            return (this.g_renamed && 1 < this.j_renamed) || 1 < h_renamed();
        }
        com.oplus.camera.capmode.a_renamed aVar2 = this.k_renamed;
        if (aVar2 == null || aVar2.s_renamed()) {
            return false;
        }
        return (this.g_renamed && this.j_renamed > 0) || h_renamed() > 0;
    }

    public void a_renamed(int i_renamed, int i2, int i3) {
        this.j_renamed = i2;
        this.g_renamed = 1 == i_renamed;
        this.h_renamed = 1 == i3;
        com.oplus.camera.e_renamed.a_renamed("AISSnapshotManager", "updateAISStatus, mbAisNeeded: " + this.g_renamed + ", mAISMotionType: " + this.j_renamed + ", onSODStatusCheck: " + h_renamed() + ", mbAISWithinTriggered: " + this.h_renamed);
    }

    public void a_renamed(android.hardware.camera2.CaptureResult captureResult) {
        try {
            int[] iArr = (int[]) captureResult.get(com.oplus.camera.e_renamed.b_renamed.j_renamed);
            if (iArr != null && iArr.length > 0) {
                this.i_renamed = iArr[1] == 0 ? iArr[0] : 2;
            } else {
                this.i_renamed = -1;
            }
        } catch (java.lang.Exception unused) {
        }
        g_renamed();
        com.oplus.camera.e_renamed.a_renamed("AISSnapshotManager", "updateSODStatus, mSODMovementLevel: " + this.i_renamed);
    }

    private void a_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.a_renamed aVar = this.k_renamed;
        if (aVar == null) {
            return;
        }
        aVar.b_renamed(z_renamed);
    }

    public void b_renamed() {
        this.g_renamed = false;
        this.h_renamed = false;
        this.i_renamed = -1;
        this.j_renamed = -1;
        this.l_renamed = -1;
        this.m_renamed = 0;
        this.n_renamed = 0;
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.b_renamed("AISSnapshotManager", "onPause");
        b_renamed();
    }

    public void d_renamed() {
        com.oplus.camera.e_renamed.b_renamed("AISSnapshotManager", "onDestroy");
        b_renamed();
        this.k_renamed = null;
    }

    public boolean e_renamed() {
        com.oplus.camera.e_renamed.a_renamed("AISSnapshotManager", "makeAISDecision");
        com.oplus.camera.capmode.a_renamed aVar = this.k_renamed;
        if (aVar == null || !aVar.p_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("AISSnapshotManager", "makeAISDecision, not support");
            return false;
        }
        if (h_renamed() > 0) {
            a_renamed(false);
        } else {
            a_renamed(3 > this.j_renamed);
        }
        return true;
    }

    public int f_renamed() {
        com.oplus.camera.capmode.a_renamed aVar = this.k_renamed;
        if (aVar == null || !aVar.p_renamed()) {
            return -1;
        }
        if (2 == h_renamed()) {
            return 11;
        }
        if (!this.g_renamed || 2 >= this.j_renamed) {
            return (1 == h_renamed() || (this.g_renamed && this.j_renamed > 0)) ? 1 : -1;
        }
        return 11;
    }

    public boolean a_renamed(java.lang.String[] strArr, float f_renamed) throws java.lang.NumberFormatException {
        boolean z_renamed = false;
        for (java.lang.String str : strArr) {
            java.lang.String[] strArrSplit = str.split(" ");
            if (2 == strArrSplit.length && !strArrSplit[0].isEmpty()) {
                boolean z2 = true;
                if (!strArrSplit[1].isEmpty()) {
                    int length = strArrSplit[1].length() - 1;
                    float f2 = java.lang.Float.parseFloat(strArrSplit[0].substring(1));
                    float f3 = java.lang.Float.parseFloat(strArrSplit[1].substring(0, length));
                    boolean z3 = !strArrSplit[0].contains("[") ? !strArrSplit[0].contains("(") || java.lang.Float.compare(f_renamed, f2) <= 0 : java.lang.Float.compare(f_renamed, f2) < 0;
                    boolean z4 = !strArrSplit[1].contains("]") ? !(strArrSplit[1].contains(")") && z3 && java.lang.Float.compare(f_renamed, f3) < 0) : !z3 || java.lang.Float.compare(f_renamed, f3) > 0;
                    if (!z_renamed && !z4) {
                        z2 = false;
                    }
                    z_renamed = z2;
                }
            }
        }
        return z_renamed;
    }

    public void g_renamed() {
        if (this.k_renamed != null) {
            int iF = f_renamed();
            boolean zQ = this.k_renamed.q_renamed();
            boolean zR = this.k_renamed.r_renamed();
            if (iF == this.l_renamed && zQ == this.m_renamed && zR == this.n_renamed) {
                return;
            }
            this.l_renamed = iF;
            this.m_renamed = zQ ? 1 : 0;
            this.n_renamed = zR ? 1 : 0;
            this.k_renamed.a_renamed(this.l_renamed, this.m_renamed, this.n_renamed);
        }
    }
}
