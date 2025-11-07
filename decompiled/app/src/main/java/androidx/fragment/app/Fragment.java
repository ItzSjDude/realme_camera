package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.SharedElementCallback;
import androidx.core.p035g.DebugUtils;
import androidx.core.p036h.LayoutInflaterCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.LiveData;
import androidx.loader.p050a.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner {
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 4;
    static final int STARTED = 3;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    boolean mAdded;
    C0572a mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    FragmentManagerImpl mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManagerImpl mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback mHost;
    boolean mInLayout;
    View mInnerView;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry;
    Lifecycle.IntrinsicsJvm.kt_4 mMaxState;
    boolean mMenuVisible;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    SavedStateRegistryController mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    FragmentViewLifecycleOwner mViewLifecycleOwner;
    MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData;
    String mWho;

    /* renamed from: androidx.fragment.app.Fragment$IntrinsicsJvm.kt_3 */
    interface InterfaceC0574c {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo3296a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo3297b();
    }

    public void onActivityResult(int OplusGLSurfaceView_13, int i2, Intent intent) {
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public Animation onCreateAnimation(int OplusGLSurfaceView_13, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int OplusGLSurfaceView_13, boolean z, int i2) {
        return null;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public void onDestroyOptionsMenu() {
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    public void onRequestPermissionsResult(int OplusGLSurfaceView_13, String[] strArr, int[] iArr) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public LifecycleOwner getViewLifecycleOwner() {
        FragmentViewLifecycleOwner c0593o = this.mViewLifecycleOwner;
        if (c0593o != null) {
            return c0593o;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null OplusGLSurfaceView_13.COUIBaseListPopupWindow_8., before onCreateView() or after onDestroyView()");
    }

    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        FragmentManagerImpl layoutInflaterFactory2C0587i = this.mFragmentManager;
        if (layoutInflaterFactory2C0587i == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        return layoutInflaterFactory2C0587i.m3471b(this);
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.m4692a();
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.fragment.app.Fragment.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        final Bundle mState;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState(Bundle bundle) {
            this.mState = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle;
            this.mState = parcel.readBundle();
            if (classLoader == null || (bundle = this.mState) == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            parcel.writeBundle(this.mState);
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$IntrinsicsJvm.kt_4 */
    public static class C0573b extends RuntimeException {
        public C0573b(String str, Exception exc) {
            super(str, exc);
        }
    }

    public Fragment() {
        this.mState = 0;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new Runnable() { // from class: androidx.fragment.app.Fragment.1
            @Override // java.lang.Runnable
            public void run() {
                Fragment.this.startPostponedEnterTransition();
            }
        };
        this.mMaxState = Lifecycle.IntrinsicsJvm.kt_4.RESUMED;
        this.mViewLifecycleOwnerLiveData = new MutableLiveData<>();
        initLifecycle();
    }

    public Fragment(int OplusGLSurfaceView_13) {
        this();
        this.mContentLayoutId = OplusGLSurfaceView_13;
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.m4691a(this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.mLifecycleRegistry.mo3639a(new LifecycleEventObserver() { // from class: androidx.fragment.app.Fragment.2
                @Override // androidx.lifecycle.LifecycleEventObserver
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo714a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar) {
                    if (aVar != Lifecycle.PlatformImplementations.kt_3.ON_STOP || Fragment.this.mView == null) {
                        return;
                    }
                    Fragment.this.mView.cancelPendingInputEvents();
                }
            });
        }
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Fragment fragmentNewInstance = FragmentFactory.m3382b(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragmentNewInstance.getClass().getClassLoader());
                fragmentNewInstance.setArguments(bundle);
            }
            return fragmentNewInstance;
        } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
            throw new C0573b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", COUIBaseListPopupWindow_8);
        } catch (InstantiationException e2) {
            throw new C0573b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new C0573b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new C0573b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mInnerView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.m3606a(Lifecycle.PlatformImplementations.kt_3.ON_CREATE);
        }
    }

    final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        DebugUtils.m2527a(this, sb);
        sb.append(" (");
        sb.append(this.mWho);
        sb.append(")");
        if (this.mFragmentId != 0) {
            sb.append(" id_renamed=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" ");
            sb.append(this.mTag);
        }
        sb.append('}');
        return sb.toString();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final String getTag() {
        return this.mTag;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final boolean isStateSaved() {
        FragmentManagerImpl layoutInflaterFactory2C0587i = this.mFragmentManager;
        if (layoutInflaterFactory2C0587i == null) {
            return false;
        }
        return layoutInflaterFactory2C0587i.mo3400g();
    }

    public void setInitialSavedState(SavedState savedState) {
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        this.mSavedFragmentState = (savedState == null || savedState.mState == null) ? null : savedState.mState;
    }

    public void setTargetFragment(Fragment fragment, int OplusGLSurfaceView_13) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentManager fragmentManager2 = fragment != null ? fragment.getFragmentManager() : null;
        if (fragmentManager != null && fragmentManager2 != null && fragmentManager != fragmentManager2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as PlatformImplementations.kt_3 target fragment");
        }
        for (Fragment targetFragment = fragment; targetFragment != null; targetFragment = targetFragment.getTargetFragment()) {
            if (targetFragment == this) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create PlatformImplementations.kt_3 target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager != null && fragment.mFragmentManager != null) {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        } else {
            this.mTargetWho = null;
            this.mTarget = fragment;
        }
        this.mTargetRequestCode = OplusGLSurfaceView_13;
    }

    public final Fragment getTargetFragment() {
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        FragmentManagerImpl layoutInflaterFactory2C0587i = this.mFragmentManager;
        if (layoutInflaterFactory2C0587i == null || this.mTargetWho == null) {
            return null;
        }
        return layoutInflaterFactory2C0587i.f3450g.get(this.mTargetWho);
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public Context getContext() {
        FragmentHostCallback abstractC0585g = this.mHost;
        if (abstractC0585g == null) {
            return null;
        }
        return abstractC0585g.m3386j();
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to PlatformImplementations.kt_3 context.");
    }

    public final FragmentActivity getActivity() {
        FragmentHostCallback abstractC0585g = this.mHost;
        if (abstractC0585g == null) {
            return null;
        }
        return (FragmentActivity) abstractC0585g.m3385i();
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Object getHost() {
        FragmentHostCallback abstractC0585g = this.mHost;
        if (abstractC0585g == null) {
            return null;
        }
        return abstractC0585g.mo3354h();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to PlatformImplementations.kt_3 host.");
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    public final CharSequence getText(int OplusGLSurfaceView_13) {
        return getResources().getText(OplusGLSurfaceView_13);
    }

    public final String getString(int OplusGLSurfaceView_13) {
        return getResources().getString(OplusGLSurfaceView_13);
    }

    public final String getString(int OplusGLSurfaceView_13, Object... objArr) {
        return getResources().getString(OplusGLSurfaceView_13, objArr);
    }

    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final FragmentManager requireFragmentManager() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with PlatformImplementations.kt_3 fragment manager.");
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
        }
        return this.mChildFragmentManager;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not PlatformImplementations.kt_3 child Fragment, it is directly attached to " + getContext());
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isResumed() {
        return this.mState >= 4;
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
        FragmentManagerImpl layoutInflaterFactory2C0587i = this.mFragmentManager;
        if (layoutInflaterFactory2C0587i == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            layoutInflaterFactory2C0587i.m3484d(this);
        } else {
            layoutInflaterFactory2C0587i.m3487e(this);
        }
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            this.mHost.mo3351e();
        }
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.mo3351e();
            }
        }
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 3 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            this.mFragmentManager.m3489f(this);
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = this.mState < 3 && !z;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @Deprecated
    public LoaderManager getLoaderManager() {
        return LoaderManager.m3683a(this);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        FragmentHostCallback abstractC0585g = this.mHost;
        if (abstractC0585g == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        abstractC0585g.mo3342a(this, intent, -1, bundle);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int OplusGLSurfaceView_13) {
        startActivityForResult(intent, OplusGLSurfaceView_13, null);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int OplusGLSurfaceView_13, Bundle bundle) {
        FragmentHostCallback abstractC0585g = this.mHost;
        if (abstractC0585g == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        abstractC0585g.mo3342a(this, intent, OplusGLSurfaceView_13, bundle);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int OplusGLSurfaceView_13, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        FragmentHostCallback abstractC0585g = this.mHost;
        if (abstractC0585g == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        abstractC0585g.mo3343a(this, intentSender, OplusGLSurfaceView_13, intent, i2, i3, i4, bundle);
    }

    public final void requestPermissions(String[] strArr, int OplusGLSurfaceView_13) {
        FragmentHostCallback abstractC0585g = this.mHost;
        if (abstractC0585g == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        abstractC0585g.mo3344a(this, strArr, OplusGLSurfaceView_13);
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        FragmentHostCallback abstractC0585g = this.mHost;
        if (abstractC0585g != null) {
            return abstractC0585g.mo3347a(str);
        }
        return false;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    LayoutInflater performGetLayoutInflater(Bundle bundle) {
        this.mLayoutInflater = onGetLayoutInflater(bundle);
        return this.mLayoutInflater;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) throws IllegalAccessException, IllegalArgumentException {
        FragmentHostCallback abstractC0585g = this.mHost;
        if (abstractC0585g == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterMo3349c = abstractC0585g.mo3349c();
        LayoutInflaterCompat.m2781a(layoutInflaterMo3349c, this.mChildFragmentManager.m3444C());
        return layoutInflaterMo3349c;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        FragmentHostCallback abstractC0585g = this.mHost;
        Activity activityM3385i = abstractC0585g == null ? null : abstractC0585g.m3385i();
        if (activityM3385i != null) {
            this.mCalled = false;
            onInflate(activityM3385i, attributeSet, bundle);
        }
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        FragmentHostCallback abstractC0585g = this.mHost;
        Activity activityM3385i = abstractC0585g == null ? null : abstractC0585g.m3385i();
        if (activityM3385i != null) {
            this.mCalled = false;
            onAttach(activityM3385i);
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager.m3463a(1)) {
            return;
        }
        this.mChildFragmentManager.m3512q();
    }

    void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.m3452a(parcelable);
        this.mChildFragmentManager.m3512q();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int OplusGLSurfaceView_13 = this.mContentLayoutId;
        if (OplusGLSurfaceView_13 != 0) {
            return layoutInflater.inflate(OplusGLSurfaceView_13, viewGroup, false);
        }
        return null;
    }

    public View getView() {
        return this.mView;
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return PlatformImplementations.kt_3 View from onCreateView() or this was called before onCreateView().");
    }

    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onResume() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public void setEnterSharedElementCallback(SharedElementCallback abstractC0438l) {
        ensureAnimationInfo().f3396o = abstractC0438l;
    }

    public void setExitSharedElementCallback(SharedElementCallback abstractC0438l) {
        ensureAnimationInfo().f3397p = abstractC0438l;
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().f3388g = obj;
    }

    public Object getEnterTransition() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            return null;
        }
        return c0572a.f3388g;
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().f3389h = obj;
    }

    public Object getReturnTransition() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            return null;
        }
        return c0572a.f3389h == USE_DEFAULT_TRANSITION ? getEnterTransition() : this.mAnimationInfo.f3389h;
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().f3390i = obj;
    }

    public Object getExitTransition() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            return null;
        }
        return c0572a.f3390i;
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().f3391j = obj;
    }

    public Object getReenterTransition() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            return null;
        }
        return c0572a.f3391j == USE_DEFAULT_TRANSITION ? getExitTransition() : this.mAnimationInfo.f3391j;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().f3392k = obj;
    }

    public Object getSharedElementEnterTransition() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            return null;
        }
        return c0572a.f3392k;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().f3393l = obj;
    }

    public Object getSharedElementReturnTransition() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            return null;
        }
        return c0572a.f3393l == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : this.mAnimationInfo.f3393l;
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().f3395n = Boolean.valueOf(z);
    }

    public boolean getAllowEnterTransitionOverlap() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null || c0572a.f3395n == null) {
            return true;
        }
        return this.mAnimationInfo.f3395n.booleanValue();
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().f3394m = Boolean.valueOf(z);
    }

    public boolean getAllowReturnTransitionOverlap() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null || c0572a.f3394m == null) {
            return true;
        }
        return this.mAnimationInfo.f3394m.booleanValue();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().f3398q = true;
    }

    public final void postponeEnterTransition(long OplusGLSurfaceView_15, TimeUnit timeUnit) {
        Handler handler;
        ensureAnimationInfo().f3398q = true;
        FragmentManagerImpl layoutInflaterFactory2C0587i = this.mFragmentManager;
        if (layoutInflaterFactory2C0587i != null) {
            handler = layoutInflaterFactory2C0587i.f3457n.m3387k();
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(OplusGLSurfaceView_15));
    }

    public void startPostponedEnterTransition() {
        FragmentManagerImpl layoutInflaterFactory2C0587i = this.mFragmentManager;
        if (layoutInflaterFactory2C0587i == null || layoutInflaterFactory2C0587i.f3457n == null) {
            ensureAnimationInfo().f3398q = false;
        } else if (Looper.myLooper() != this.mFragmentManager.f3457n.m3387k().getLooper()) {
            this.mFragmentManager.f3457n.m3387k().postAtFrontOfQueue(new Runnable() { // from class: androidx.fragment.app.Fragment.3
                @Override // java.lang.Runnable
                public void run() {
                    Fragment.this.callStartTransitionListener();
                }
            });
        } else {
            callStartTransitionListener();
        }
    }

    void callStartTransitionListener() {
        InterfaceC0574c interfaceC0574c;
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            interfaceC0574c = null;
        } else {
            c0572a.f3398q = false;
            interfaceC0574c = c0572a.f3399r;
            this.mAnimationInfo.f3399r = null;
        }
        if (interfaceC0574c != null) {
            interfaceC0574c.mo3296a();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (getNextAnim() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(getNextAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.mInnerView != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(getStateAfterAnimating());
        }
        if (getContext() != null) {
            LoaderManager.m3683a(this).mo3685a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.mo3394a(str + "  ", fileDescriptor, printWriter, strArr);
    }

    Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.m3470b(str);
    }

    void performAttach() {
        this.mChildFragmentManager.m3460a(this.mHost, new FragmentContainer() { // from class: androidx.fragment.app.Fragment.4
            @Override // androidx.fragment.app.FragmentContainer
            /* renamed from: PlatformImplementations.kt_3 */
            public View mo3291a(int OplusGLSurfaceView_13) {
                if (Fragment.this.mView == null) {
                    throw new IllegalStateException("Fragment " + this + " does not have PlatformImplementations.kt_3 view");
                }
                return Fragment.this.mView.findViewById(OplusGLSurfaceView_13);
            }

            @Override // androidx.fragment.app.FragmentContainer
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo3292a() {
                return Fragment.this.mView != null;
            }
        }, this);
        this.mCalled = false;
        onAttach(this.mHost.m3386j());
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
    }

    void performCreate(Bundle bundle) {
        this.mChildFragmentManager.m3510p();
        this.mState = 1;
        this.mCalled = false;
        this.mSavedStateRegistryController.m4693a(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
        }
        this.mLifecycleRegistry.m3653a(Lifecycle.PlatformImplementations.kt_3.ON_CREATE);
    }

    void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.m3510p();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new FragmentViewLifecycleOwner();
        this.mView = onCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null) {
            this.mViewLifecycleOwner.m3605a();
            this.mViewLifecycleOwnerLiveData.mo3615a((MutableLiveData<LifecycleOwner>) this.mViewLifecycleOwner);
        } else {
            if (this.mViewLifecycleOwner.m3607b()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
        }
    }

    void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.m3510p();
        this.mState = 2;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
        this.mChildFragmentManager.m3514r();
    }

    void performStart() {
        this.mChildFragmentManager.m3510p();
        this.mChildFragmentManager.m3503l();
        this.mState = 3;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
        this.mLifecycleRegistry.m3653a(Lifecycle.PlatformImplementations.kt_3.ON_START);
        if (this.mView != null) {
            this.mViewLifecycleOwner.m3606a(Lifecycle.PlatformImplementations.kt_3.ON_START);
        }
        this.mChildFragmentManager.m3517s();
    }

    void performResume() {
        this.mChildFragmentManager.m3510p();
        this.mChildFragmentManager.m3503l();
        this.mState = 4;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
        this.mLifecycleRegistry.m3653a(Lifecycle.PlatformImplementations.kt_3.ON_RESUME);
        if (this.mView != null) {
            this.mViewLifecycleOwner.m3606a(Lifecycle.PlatformImplementations.kt_3.ON_RESUME);
        }
        this.mChildFragmentManager.m3518t();
        this.mChildFragmentManager.m3503l();
    }

    void noteStateNotSaved() {
        this.mChildFragmentManager.m3510p();
    }

    void performPrimaryNavigationFragmentChanged() {
        boolean zM3467a = this.mFragmentManager.m3467a(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != zM3467a) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(zM3467a);
            onPrimaryNavigationFragmentChanged(zM3467a);
            this.mChildFragmentManager.m3525z();
        }
    }

    void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        this.mChildFragmentManager.m3462a(z);
    }

    void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        this.mChildFragmentManager.m3478b(z);
    }

    void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.m3450a(configuration);
    }

    void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.m3524y();
    }

    boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return z | this.mChildFragmentManager.m3465a(menu, menuInflater);
    }

    boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return z | this.mChildFragmentManager.m3464a(menu);
    }

    boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        return (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) || this.mChildFragmentManager.m3466a(menuItem);
    }

    boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        return onContextItemSelected(menuItem) || this.mChildFragmentManager.m3479b(menuItem);
    }

    void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.m3472b(menu);
    }

    void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.m4694b(bundle);
        Parcelable parcelableM3508o = this.mChildFragmentManager.m3508o();
        if (parcelableM3508o != null) {
            bundle.putParcelable("android:support:fragments", parcelableM3508o);
        }
    }

    void performPause() {
        this.mChildFragmentManager.m3520u();
        if (this.mView != null) {
            this.mViewLifecycleOwner.m3606a(Lifecycle.PlatformImplementations.kt_3.ON_PAUSE);
        }
        this.mLifecycleRegistry.m3653a(Lifecycle.PlatformImplementations.kt_3.ON_PAUSE);
        this.mState = 3;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    void performStop() {
        this.mChildFragmentManager.m3521v();
        if (this.mView != null) {
            this.mViewLifecycleOwner.m3606a(Lifecycle.PlatformImplementations.kt_3.ON_STOP);
        }
        this.mLifecycleRegistry.m3653a(Lifecycle.PlatformImplementations.kt_3.ON_STOP);
        this.mState = 2;
        this.mCalled = false;
        onStop();
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    void performDestroyView() {
        this.mChildFragmentManager.m3522w();
        if (this.mView != null) {
            this.mViewLifecycleOwner.m3606a(Lifecycle.PlatformImplementations.kt_3.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        LoaderManager.m3683a(this).mo3684a();
        this.mPerformedCreateView = false;
    }

    void performDestroy() {
        this.mChildFragmentManager.m3523x();
        this.mLifecycleRegistry.m3653a(Lifecycle.PlatformImplementations.kt_3.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void performDetach() {
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
        }
        if (this.mChildFragmentManager.mo3398e()) {
            return;
        }
        this.mChildFragmentManager.m3523x();
        this.mChildFragmentManager = new FragmentManagerImpl();
    }

    void setOnStartEnterTransitionListener(InterfaceC0574c interfaceC0574c) {
        ensureAnimationInfo();
        if (interfaceC0574c == this.mAnimationInfo.f3399r) {
            return;
        }
        if (interfaceC0574c != null && this.mAnimationInfo.f3399r != null) {
            throw new IllegalStateException("Trying to set PlatformImplementations.kt_3 replacement startPostponedEnterTransition on " + this);
        }
        if (this.mAnimationInfo.f3398q) {
            this.mAnimationInfo.f3399r = interfaceC0574c;
        }
        if (interfaceC0574c != null) {
            interfaceC0574c.mo3297b();
        }
    }

    private C0572a ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new C0572a();
        }
        return this.mAnimationInfo;
    }

    int getNextAnim() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            return 0;
        }
        return c0572a.f3385d;
    }

    void setNextAnim(int OplusGLSurfaceView_13) {
        if (this.mAnimationInfo == null && OplusGLSurfaceView_13 == 0) {
            return;
        }
        ensureAnimationInfo().f3385d = OplusGLSurfaceView_13;
    }

    int getNextTransition() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            return 0;
        }
        return c0572a.f3386e;
    }

    void setNextTransition(int OplusGLSurfaceView_13, int i2) {
        if (this.mAnimationInfo == null && OplusGLSurfaceView_13 == 0 && i2 == 0) {
            return;
        }
        ensureAnimationInfo();
        C0572a c0572a = this.mAnimationInfo;
        c0572a.f3386e = OplusGLSurfaceView_13;
        c0572a.f3387f = i2;
    }

    int getNextTransitionStyle() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            return 0;
        }
        return c0572a.f3387f;
    }

    SharedElementCallback getEnterTransitionCallback() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            return null;
        }
        return c0572a.f3396o;
    }

    SharedElementCallback getExitTransitionCallback() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            return null;
        }
        return c0572a.f3397p;
    }

    View getAnimatingAway() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            return null;
        }
        return c0572a.f3382a;
    }

    void setAnimatingAway(View view) {
        ensureAnimationInfo().f3382a = view;
    }

    void setAnimator(Animator animator) {
        ensureAnimationInfo().f3383b = animator;
    }

    Animator getAnimator() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            return null;
        }
        return c0572a.f3383b;
    }

    int getStateAfterAnimating() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            return 0;
        }
        return c0572a.f3384c;
    }

    void setStateAfterAnimating(int OplusGLSurfaceView_13) {
        ensureAnimationInfo().f3384c = OplusGLSurfaceView_13;
    }

    boolean isPostponed() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            return false;
        }
        return c0572a.f3398q;
    }

    boolean isHideReplaced() {
        C0572a c0572a = this.mAnimationInfo;
        if (c0572a == null) {
            return false;
        }
        return c0572a.f3400s;
    }

    void setHideReplaced(boolean z) {
        ensureAnimationInfo().f3400s = z;
    }

    /* renamed from: androidx.fragment.app.Fragment$PlatformImplementations.kt_3 */
    static class C0572a {

        /* renamed from: PlatformImplementations.kt_3 */
        View f3382a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        Animator f3383b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f3384c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f3385d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        int f3386e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        int f3387f;

        /* renamed from: OplusGLSurfaceView_6 */
        Boolean f3394m;

        /* renamed from: OplusGLSurfaceView_11 */
        Boolean f3395n;

        /* renamed from: q */
        boolean f3398q;

        /* renamed from: r */
        InterfaceC0574c f3399r;

        /* renamed from: s */
        boolean f3400s;

        /* renamed from: COUIBaseListPopupWindow_11 */
        Object f3388g = null;

        /* renamed from: COUIBaseListPopupWindow_10 */
        Object f3389h = Fragment.USE_DEFAULT_TRANSITION;

        /* renamed from: OplusGLSurfaceView_13 */
        Object f3390i = null;

        /* renamed from: OplusGLSurfaceView_15 */
        Object f3391j = Fragment.USE_DEFAULT_TRANSITION;

        /* renamed from: OplusGLSurfaceView_5 */
        Object f3392k = null;

        /* renamed from: OplusGLSurfaceView_14 */
        Object f3393l = Fragment.USE_DEFAULT_TRANSITION;

        /* renamed from: o */
        SharedElementCallback f3396o = null;

        /* renamed from: p */
        SharedElementCallback f3397p = null;

        C0572a() {
        }
    }
}
