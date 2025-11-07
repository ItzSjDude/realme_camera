package com.oplus.compat.os;

/* loaded from: classes2.dex */
public class ProcessCpuTrackerNative {
    private static final java.lang.String TAG = "ProcessCpuTrackerNative";
    private com.android.internal.os.ProcessCpuTracker mProcessCpuTracker;
    private java.lang.Object mProcessCpuTrackerWrapper;

    private static java.lang.Object getProcessCpuTrackerWrapper(boolean z_renamed) {
        return null;
    }

    private static void updateCompat(java.lang.Object obj) {
    }

    public ProcessCpuTrackerNative(boolean z_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            this.mProcessCpuTracker = new com.android.internal.os.ProcessCpuTracker(z_renamed);
            return;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            this.mProcessCpuTrackerWrapper = new com.oplus.inner.os.ProcessCpuTrackerWrapper(z_renamed);
        } else if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            this.mProcessCpuTrackerWrapper = getProcessCpuTrackerWrapper(z_renamed);
        } else {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
                this.mProcessCpuTracker = new com.android.internal.os.ProcessCpuTracker(z_renamed);
                return;
            }
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not supported before L_renamed");
        }
    }

    public void update() throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.c_renamed()) {
            this.mProcessCpuTracker.update();
            return;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
            ((com.oplus.inner.os.ProcessCpuTrackerWrapper) this.mProcessCpuTrackerWrapper).update();
        } else if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            updateCompat(this.mProcessCpuTrackerWrapper);
        } else {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.k_renamed()) {
                this.mProcessCpuTracker.update();
                return;
            }
            throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("Not supported before L_renamed");
        }
    }
}
