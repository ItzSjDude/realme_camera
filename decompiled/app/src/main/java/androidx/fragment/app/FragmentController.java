package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.core.p035g.Preconditions;
import androidx.lifecycle.ViewModelStoreOwner;

/* compiled from: FragmentController.java */
/* renamed from: androidx.fragment.app.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class FragmentController {

    /* renamed from: PlatformImplementations.kt_3 */
    private final FragmentHostCallback<?> f3427a;

    /* renamed from: PlatformImplementations.kt_3 */
    public static FragmentController m3356a(FragmentHostCallback<?> abstractC0585g) {
        return new FragmentController((FragmentHostCallback) Preconditions.m2537a(abstractC0585g, "callbacks == null"));
    }

    private FragmentController(FragmentHostCallback<?> abstractC0585g) {
        this.f3427a = abstractC0585g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public FragmentManager m3359a() {
        return this.f3427a.f3430b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Fragment m3358a(String str) {
        return this.f3427a.f3430b.m3470b(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3362a(Fragment fragment) {
        FragmentManagerImpl layoutInflaterFactory2C0587i = this.f3427a.f3430b;
        FragmentHostCallback<?> abstractC0585g = this.f3427a;
        layoutInflaterFactory2C0587i.m3460a(abstractC0585g, abstractC0585g, fragment);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public View m3357a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f3427a.f3430b.onCreateView(view, str, context, attributeSet);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3367b() {
        this.f3427a.f3430b.m3510p();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Parcelable m3371c() {
        return this.f3427a.f3430b.m3508o();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3361a(Parcelable parcelable) {
        FragmentHostCallback<?> abstractC0585g = this.f3427a;
        if (!(abstractC0585g instanceof ViewModelStoreOwner)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        abstractC0585g.f3430b.m3452a(parcelable);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m3372d() {
        this.f3427a.f3430b.m3512q();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m3373e() {
        this.f3427a.f3430b.m3514r();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m3374f() {
        this.f3427a.f3430b.m3517s();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m3375g() {
        this.f3427a.f3430b.m3518t();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m3376h() {
        this.f3427a.f3430b.m3520u();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m3377i() {
        this.f3427a.f3430b.m3521v();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m3378j() {
        this.f3427a.f3430b.m3523x();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3363a(boolean z) {
        this.f3427a.f3430b.m3462a(z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3369b(boolean z) {
        this.f3427a.f3430b.m3478b(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3360a(Configuration configuration) {
        this.f3427a.f3430b.m3450a(configuration);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m3379k() {
        this.f3427a.f3430b.m3524y();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m3365a(Menu menu, MenuInflater menuInflater) {
        return this.f3427a.f3430b.m3465a(menu, menuInflater);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m3364a(Menu menu) {
        return this.f3427a.f3430b.m3464a(menu);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m3366a(MenuItem menuItem) {
        return this.f3427a.f3430b.m3466a(menuItem);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m3370b(MenuItem menuItem) {
        return this.f3427a.f3430b.m3479b(menuItem);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3368b(Menu menu) {
        this.f3427a.f3430b.m3472b(menu);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m3380l() {
        return this.f3427a.f3430b.m3503l();
    }
}
