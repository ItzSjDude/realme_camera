package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity_3;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.OnBackPressedDispatcher;
import androidx.collection.SparseArrayCompat;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.p050a.LoaderManager;
import com.meicam.sdk.NvsMediaFileConvertor;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentActivity.java */
/* renamed from: androidx.fragment.app.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity_3 implements ActivityCompat.PlatformImplementations.kt_3, ActivityCompat.IntrinsicsJvm.kt_3 {

    /* renamed from: c_ */
    boolean f3418c_;

    /* renamed from: d_ */
    boolean f3419d_;

    /* renamed from: f_ */
    boolean f3421f_;

    /* renamed from: COUIBaseListPopupWindow_11 */
    boolean f3422g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    boolean f3423h;

    /* renamed from: OplusGLSurfaceView_13 */
    int f3424i;

    /* renamed from: OplusGLSurfaceView_15 */
    SparseArrayCompat<String> f3425j;

    /* renamed from: a_ */
    final FragmentController f3416a_ = FragmentController.m3356a(new PlatformImplementations.kt_3());

    /* renamed from: b_ */
    final LifecycleRegistry f3417b_ = new LifecycleRegistry(this);

    /* renamed from: e_ */
    boolean f3420e_ = true;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3335a(Fragment fragment) {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int OplusGLSurfaceView_13, int i2, Intent intent) {
        this.f3416a_.m3367b();
        int i3 = OplusGLSurfaceView_13 >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = this.f3425j.get(i4);
            this.f3425j.remove(i4);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment fragmentM3358a = this.f3416a_.m3358a(str);
            if (fragmentM3358a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            }
            fragmentM3358a.onActivityResult(OplusGLSurfaceView_13 & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN, i2, intent);
            return;
        }
        ActivityCompat.IntrinsicsJvm.kt_4 bVarM2343a = ActivityCompat.m2343a();
        if (bVarM2343a == null || !bVarM2343a.m2350a(this, OplusGLSurfaceView_13, i2, intent)) {
            super.onActivityResult(OplusGLSurfaceView_13, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.f3416a_.m3363a(z);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.f3416a_.m3369b(z);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3416a_.m3367b();
        this.f3416a_.m3360a(configuration);
    }

    @Override // androidx.activity.ComponentActivity_3, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f3416a_.m3362a((Fragment) null);
        if (bundle != null) {
            this.f3416a_.m3361a(bundle.getParcelable("android:support:fragments"));
            if (bundle.containsKey("android:support:next_request_index")) {
                this.f3424i = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.f3425j = new SparseArrayCompat<>(intArray.length);
                    for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < intArray.length; OplusGLSurfaceView_13++) {
                        this.f3425j.put(intArray[OplusGLSurfaceView_13], stringArray[OplusGLSurfaceView_13]);
                    }
                }
            }
        }
        if (this.f3425j == null) {
            this.f3425j = new SparseArrayCompat<>();
            this.f3424i = 0;
        }
        super.onCreate(bundle);
        this.f3417b_.m3653a(Lifecycle.PlatformImplementations.kt_3.ON_CREATE);
        this.f3416a_.m3372d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int OplusGLSurfaceView_13, Menu menu) {
        if (OplusGLSurfaceView_13 == 0) {
            return this.f3416a_.m3365a(menu, getMenuInflater()) | super.onCreatePanelMenu(OplusGLSurfaceView_13, menu);
        }
        return super.onCreatePanelMenu(OplusGLSurfaceView_13, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewM3334a = m3334a(view, str, context, attributeSet);
        return viewM3334a == null ? super.onCreateView(view, str, context, attributeSet) : viewM3334a;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewM3334a = m3334a((View) null, str, context, attributeSet);
        return viewM3334a == null ? super.onCreateView(str, context, attributeSet) : viewM3334a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    final View m3334a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f3416a_.m3357a(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f3416a_.m3378j();
        this.f3417b_.m3653a(Lifecycle.PlatformImplementations.kt_3.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f3416a_.m3379k();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int OplusGLSurfaceView_13, MenuItem menuItem) {
        if (super.onMenuItemSelected(OplusGLSurfaceView_13, menuItem)) {
            return true;
        }
        if (OplusGLSurfaceView_13 == 0) {
            return this.f3416a_.m3366a(menuItem);
        }
        if (OplusGLSurfaceView_13 != 6) {
            return false;
        }
        return this.f3416a_.m3370b(menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int OplusGLSurfaceView_13, Menu menu) {
        if (OplusGLSurfaceView_13 == 0) {
            this.f3416a_.m3368b(menu);
        }
        super.onPanelClosed(OplusGLSurfaceView_13, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f3419d_ = false;
        this.f3416a_.m3376h();
        this.f3417b_.m3653a(Lifecycle.PlatformImplementations.kt_3.ON_PAUSE);
    }

    @Override // android.app.Activity
    protected void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.f3416a_.m3367b();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f3416a_.m3367b();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f3419d_ = true;
        this.f3416a_.m3367b();
        this.f3416a_.m3380l();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        m3340i();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    protected void m3340i() {
        this.f3417b_.m3653a(Lifecycle.PlatformImplementations.kt_3.ON_RESUME);
        this.f3416a_.m3375g();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int OplusGLSurfaceView_13, View view, Menu menu) {
        if (OplusGLSurfaceView_13 == 0) {
            return this.f3416a_.m3364a(menu) | m3339a(view, menu);
        }
        return super.onPreparePanel(OplusGLSurfaceView_13, view, menu);
    }

    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean m3339a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // androidx.activity.ComponentActivity_3, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m3333e();
        this.f3417b_.m3653a(Lifecycle.PlatformImplementations.kt_3.ON_STOP);
        Parcelable parcelableM3371c = this.f3416a_.m3371c();
        if (parcelableM3371c != null) {
            bundle.putParcelable("android:support:fragments", parcelableM3371c);
        }
        if (this.f3425j.size() > 0) {
            bundle.putInt("android:support:next_request_index", this.f3424i);
            int[] iArr = new int[this.f3425j.size()];
            String[] strArr = new String[this.f3425j.size()];
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3425j.size(); OplusGLSurfaceView_13++) {
                iArr[OplusGLSurfaceView_13] = this.f3425j.keyAt(OplusGLSurfaceView_13);
                strArr[OplusGLSurfaceView_13] = this.f3425j.valueAt(OplusGLSurfaceView_13);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f3420e_ = false;
        if (!this.f3418c_) {
            this.f3418c_ = true;
            this.f3416a_.m3373e();
        }
        this.f3416a_.m3367b();
        this.f3416a_.m3380l();
        this.f3417b_.m3653a(Lifecycle.PlatformImplementations.kt_3.ON_START);
        this.f3416a_.m3374f();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f3420e_ = true;
        m3333e();
        this.f3416a_.m3377i();
        this.f3417b_.m3653a(Lifecycle.PlatformImplementations.kt_3.ON_STOP);
    }

    @Deprecated
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo913d() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f3418c_);
        printWriter.print(" mResumed=");
        printWriter.print(this.f3419d_);
        printWriter.print(" mStopped=");
        printWriter.print(this.f3420e_);
        if (getApplication() != null) {
            LoaderManager.m3683a(this).mo3685a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f3416a_.m3359a().mo3394a(str, fileDescriptor, printWriter, strArr);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public FragmentManager m3341j() {
        return this.f3416a_.m3359a();
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int OplusGLSurfaceView_13) {
        if (!this.f3423h && OplusGLSurfaceView_13 != -1) {
            m3332c(OplusGLSurfaceView_13);
        }
        super.startActivityForResult(intent, OplusGLSurfaceView_13);
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int OplusGLSurfaceView_13, Bundle bundle) {
        if (!this.f3423h && OplusGLSurfaceView_13 != -1) {
            m3332c(OplusGLSurfaceView_13);
        }
        super.startActivityForResult(intent, OplusGLSurfaceView_13, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int OplusGLSurfaceView_13, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        if (!this.f3422g && OplusGLSurfaceView_13 != -1) {
            m3332c(OplusGLSurfaceView_13);
        }
        super.startIntentSenderForResult(intentSender, OplusGLSurfaceView_13, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int OplusGLSurfaceView_13, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (!this.f3422g && OplusGLSurfaceView_13 != -1) {
            m3332c(OplusGLSurfaceView_13);
        }
        super.startIntentSenderForResult(intentSender, OplusGLSurfaceView_13, intent, i2, i3, i4, bundle);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    static void m3332c(int OplusGLSurfaceView_13) {
        if ((OplusGLSurfaceView_13 & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    @Override // androidx.core.app.ActivityCompat.IntrinsicsJvm.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void mo2352b(int OplusGLSurfaceView_13) {
        if (this.f3421f_ || OplusGLSurfaceView_13 == -1) {
            return;
        }
        m3332c(OplusGLSurfaceView_13);
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.PlatformImplementations.kt_3
    public void onRequestPermissionsResult(int OplusGLSurfaceView_13, String[] strArr, int[] iArr) {
        this.f3416a_.m3367b();
        int i2 = (OplusGLSurfaceView_13 >> 16) & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = this.f3425j.get(i3);
            this.f3425j.remove(i3);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment fragmentM3358a = this.f3416a_.m3358a(str);
            if (fragmentM3358a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            }
            fragmentM3358a.onRequestPermissionsResult(OplusGLSurfaceView_13 & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN, strArr, iArr);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3336a(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int OplusGLSurfaceView_13, Bundle bundle) {
        this.f3423h = true;
        try {
            if (OplusGLSurfaceView_13 == -1) {
                ActivityCompat.m2345a(this, intent, -1, bundle);
            } else {
                m3332c(OplusGLSurfaceView_13);
                ActivityCompat.m2345a(this, intent, ((m3331b(fragment) + 1) << 16) + (OplusGLSurfaceView_13 & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN), bundle);
            }
        } finally {
            this.f3423h = false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3337a(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int OplusGLSurfaceView_13, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        this.f3422g = true;
        try {
            if (OplusGLSurfaceView_13 == -1) {
                ActivityCompat.m2346a(this, intentSender, OplusGLSurfaceView_13, intent, i2, i3, i4, bundle);
            } else {
                m3332c(OplusGLSurfaceView_13);
                ActivityCompat.m2346a(this, intentSender, ((m3331b(fragment) + 1) << 16) + (OplusGLSurfaceView_13 & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN), intent, i2, i3, i4, bundle);
            }
        } finally {
            this.f3422g = false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m3331b(Fragment fragment) {
        if (this.f3425j.size() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.f3425j.indexOfKey(this.f3424i) >= 0) {
            this.f3424i = (this.f3424i + 1) % 65534;
        }
        int OplusGLSurfaceView_13 = this.f3424i;
        this.f3425j.put(OplusGLSurfaceView_13, fragment.mWho);
        this.f3424i = (this.f3424i + 1) % 65534;
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3338a(Fragment fragment, String[] strArr, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == -1) {
            ActivityCompat.m2347a(this, strArr, OplusGLSurfaceView_13);
            return;
        }
        m3332c(OplusGLSurfaceView_13);
        try {
            this.f3421f_ = true;
            ActivityCompat.m2347a(this, strArr, ((m3331b(fragment) + 1) << 16) + (OplusGLSurfaceView_13 & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN));
        } finally {
            this.f3421f_ = false;
        }
    }

    /* compiled from: FragmentActivity.java */
    /* renamed from: androidx.fragment.app.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    class PlatformImplementations.kt_3 extends FragmentHostCallback<FragmentActivity> implements OnBackPressedDispatcherOwner, ViewModelStoreOwner {
        public PlatformImplementations.kt_3() {
            super(FragmentActivity.this);
        }

        @Override // androidx.lifecycle.LifecycleOwner
        public Lifecycle getLifecycle() {
            return FragmentActivity.this.f3417b_;
        }

        @Override // androidx.lifecycle.ViewModelStoreOwner
        public ViewModelStore getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        @Override // androidx.activity.OnBackPressedDispatcherOwner
        /* renamed from: IntrinsicsJvm.kt_4 */
        public OnBackPressedDispatcher mo721b() {
            return FragmentActivity.this.mo721b();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo3345a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo3346a(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        /* renamed from: IntrinsicsJvm.kt_3 */
        public LayoutInflater mo3349c() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        /* renamed from: IntrinsicsJvm.kt_5, reason: merged with bridge method [inline-methods] */
        public FragmentActivity mo3354h() {
            return FragmentActivity.this;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo3351e() {
            FragmentActivity.this.mo913d();
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo3342a(Fragment fragment, Intent intent, int OplusGLSurfaceView_13, Bundle bundle) {
            FragmentActivity.this.m3336a(fragment, intent, OplusGLSurfaceView_13, bundle);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo3343a(Fragment fragment, IntentSender intentSender, int OplusGLSurfaceView_13, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
            FragmentActivity.this.m3337a(fragment, intentSender, OplusGLSurfaceView_13, intent, i2, i3, i4, bundle);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo3344a(Fragment fragment, String[] strArr, int OplusGLSurfaceView_13) {
            FragmentActivity.this.m3338a(fragment, strArr, OplusGLSurfaceView_13);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo3347a(String str) {
            return ActivityCompat.m2348a((Activity) FragmentActivity.this, str);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        /* renamed from: COUIBaseListPopupWindow_12 */
        public boolean mo3352f() {
            return FragmentActivity.this.getWindow() != null;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        /* renamed from: COUIBaseListPopupWindow_11 */
        public int mo3353g() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo3348b(Fragment fragment) {
            FragmentActivity.this.m3335a(fragment);
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        /* renamed from: PlatformImplementations.kt_3 */
        public View mo3291a(int OplusGLSurfaceView_13) {
            return FragmentActivity.this.findViewById(OplusGLSurfaceView_13);
        }

        @Override // androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo3292a() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m3333e() {
        while (m3330a(m3341j(), Lifecycle.IntrinsicsJvm.kt_4.CREATED)) {
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m3330a(FragmentManager abstractC0586h, Lifecycle.IntrinsicsJvm.kt_4 bVar) {
        boolean zM3330a = false;
        for (Fragment fragment : abstractC0586h.mo3397d()) {
            if (fragment != null) {
                if (fragment.getLifecycle().mo3638a().isAtLeast(Lifecycle.IntrinsicsJvm.kt_4.STARTED)) {
                    fragment.mLifecycleRegistry.m3655b(bVar);
                    zM3330a = true;
                }
                if (fragment.getHost() != null) {
                    zM3330a |= m3330a(fragment.getChildFragmentManager(), bVar);
                }
            }
        }
        return zM3330a;
    }
}
