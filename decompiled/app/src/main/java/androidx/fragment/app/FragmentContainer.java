package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* compiled from: FragmentContainer.java */
/* renamed from: androidx.fragment.app.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public abstract class FragmentContainer {
    /* renamed from: PlatformImplementations.kt_3 */
    public abstract View mo3291a(int OplusGLSurfaceView_13);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract boolean mo3292a();

    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public Fragment m3355a(Context context, String str, Bundle bundle) {
        return Fragment.instantiate(context, str, bundle);
    }
}
