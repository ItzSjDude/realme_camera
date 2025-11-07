package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* compiled from: WindowIdApi18.java */
/* renamed from: androidx.transition.am */
/* loaded from: classes.dex */
class WindowIdApi18 implements WindowIdImpl {

    /* renamed from: PlatformImplementations.kt_3 */
    private final WindowId f4561a;

    WindowIdApi18(View view) {
        this.f4561a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi18) && ((WindowIdApi18) obj).f4561a.equals(this.f4561a);
    }

    public int hashCode() {
        return this.f4561a.hashCode();
    }
}
