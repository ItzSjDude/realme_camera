package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.p035g.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentHostCallback.java */
/* renamed from: androidx.fragment.app.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public abstract class FragmentHostCallback<E> extends FragmentContainer {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Activity f3429a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final FragmentManagerImpl f3430b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Context f3431c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Handler f3432d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final int f3433e;

    @Override // androidx.fragment.app.FragmentContainer
    /* renamed from: PlatformImplementations.kt_3 */
    public View mo3291a(int OplusGLSurfaceView_13) {
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3344a(Fragment fragment, String[] strArr, int OplusGLSurfaceView_13) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3345a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // androidx.fragment.app.FragmentContainer
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo3292a() {
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo3346a(Fragment fragment) {
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo3347a(String str) {
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void mo3348b(Fragment fragment) {
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo3351e() {
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean mo3352f() {
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public abstract E mo3354h();

    FragmentHostCallback(FragmentActivity activityC0581c) {
        this(activityC0581c, activityC0581c, new Handler(), 0);
    }

    FragmentHostCallback(Activity activity, Context context, Handler handler, int OplusGLSurfaceView_13) {
        this.f3430b = new FragmentManagerImpl();
        this.f3429a = activity;
        this.f3431c = (Context) Preconditions.m2537a(context, "context == null");
        this.f3432d = (Handler) Preconditions.m2537a(handler, "handler == null");
        this.f3433e = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public LayoutInflater mo3349c() {
        return LayoutInflater.from(this.f3431c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3342a(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int OplusGLSurfaceView_13, Bundle bundle) {
        if (OplusGLSurfaceView_13 != -1) {
            throw new IllegalStateException("Starting activity with PlatformImplementations.kt_3 requestCode requires PlatformImplementations.kt_3 FragmentActivity host");
        }
        this.f3431c.startActivity(intent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3343a(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int OplusGLSurfaceView_13, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (OplusGLSurfaceView_13 != -1) {
            throw new IllegalStateException("Starting intent sender with PlatformImplementations.kt_3 requestCode requires PlatformImplementations.kt_3 FragmentActivity host");
        }
        ActivityCompat.m2346a(this.f3429a, intentSender, OplusGLSurfaceView_13, intent, i2, i3, i4, bundle);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int mo3353g() {
        return this.f3433e;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    Activity m3385i() {
        return this.f3429a;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    Context m3386j() {
        return this.f3431c;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    Handler m3387k() {
        return this.f3432d;
    }
}
