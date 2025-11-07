package androidx.transition;

import android.os.IBinder;

/* compiled from: WindowIdApi14.java */
/* renamed from: androidx.transition.al */
/* loaded from: classes.dex */
class WindowIdApi14 implements WindowIdImpl {

    /* renamed from: PlatformImplementations.kt_3 */
    private final IBinder f4560a;

    WindowIdApi14(IBinder iBinder) {
        this.f4560a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi14) && ((WindowIdApi14) obj).f4560a.equals(this.f4560a);
    }

    public int hashCode() {
        return this.f4560a.hashCode();
    }
}
