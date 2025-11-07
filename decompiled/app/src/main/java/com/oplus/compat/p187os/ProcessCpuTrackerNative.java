package com.oplus.compat.p187os;

import com.android.internal.os.ProcessCpuTracker;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.inner.os.ProcessCpuTrackerWrapper;

/* loaded from: classes2.dex */
public class ProcessCpuTrackerNative {
    private static final String TAG = "ProcessCpuTrackerNative";
    private ProcessCpuTracker mProcessCpuTracker;
    private Object mProcessCpuTrackerWrapper;

    private static Object getProcessCpuTrackerWrapper(boolean z) {
        return null;
    }

    private static void updateCompat(Object obj) {
    }

    public ProcessCpuTrackerNative(boolean z) throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            this.mProcessCpuTracker = new ProcessCpuTracker(z);
            return;
        }
        if (VersionUtils.m24886b()) {
            this.mProcessCpuTrackerWrapper = new ProcessCpuTrackerWrapper(z);
        } else if (VersionUtils.m24889e()) {
            this.mProcessCpuTrackerWrapper = getProcessCpuTrackerWrapper(z);
        } else {
            if (VersionUtils.m24895k()) {
                this.mProcessCpuTracker = new ProcessCpuTracker(z);
                return;
            }
            throw new UnSupportedApiVersionException("Not supported before L");
        }
    }

    public void update() throws UnSupportedApiVersionException {
        if (VersionUtils.m24887c()) {
            this.mProcessCpuTracker.update();
            return;
        }
        if (VersionUtils.m24886b()) {
            ((ProcessCpuTrackerWrapper) this.mProcessCpuTrackerWrapper).update();
        } else if (VersionUtils.m24889e()) {
            updateCompat(this.mProcessCpuTrackerWrapper);
        } else {
            if (VersionUtils.m24895k()) {
                this.mProcessCpuTracker.update();
                return;
            }
            throw new UnSupportedApiVersionException("Not supported before L");
        }
    }
}
