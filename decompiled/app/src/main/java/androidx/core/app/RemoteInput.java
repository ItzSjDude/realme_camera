package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Set;

/* compiled from: RemoteInput.java */
/* renamed from: androidx.core.app.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public final class RemoteInput {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f2827a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final CharSequence f2828b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final CharSequence[] f2829c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final boolean f2830d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final int f2831e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Bundle f2832f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final Set<String> f2833g;

    /* renamed from: PlatformImplementations.kt_3 */
    public String m2430a() {
        return this.f2827a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public CharSequence m2431b() {
        return this.f2828b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public CharSequence[] m2432c() {
        return this.f2829c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Set<String> m2433d() {
        return this.f2833g;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m2434e() {
        return this.f2830d;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m2435f() {
        return this.f2831e;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public Bundle m2436g() {
        return this.f2832f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static RemoteInput[] m2429a(RemoteInput[] c0437kArr) {
        if (c0437kArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c0437kArr.length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < c0437kArr.length; OplusGLSurfaceView_13++) {
            remoteInputArr[OplusGLSurfaceView_13] = m2428a(c0437kArr[OplusGLSurfaceView_13]);
        }
        return remoteInputArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static RemoteInput m2428a(RemoteInput c0437k) {
        RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(c0437k.m2430a()).setLabel(c0437k.m2431b()).setChoices(c0437k.m2432c()).setAllowFreeFormInput(c0437k.m2434e()).addExtras(c0437k.m2436g());
        if (Build.VERSION.SDK_INT >= 29) {
            builderAddExtras.setEditChoicesBeforeSending(c0437k.m2435f());
        }
        return builderAddExtras.build();
    }
}
