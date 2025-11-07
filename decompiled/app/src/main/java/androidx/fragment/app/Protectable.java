package androidx.fragment.app;

/* loaded from: classes.dex */
public class Fragment implements android.content.ComponentCallbacks, android.view.View.OnCreateContextMenuListener, androidx.lifecycle.h_renamed, androidx.lifecycle.t_renamed, androidx.savedstate.c_renamed {
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 4;
    static final int STARTED = 3;
    static final java.lang.Object USE_DEFAULT_TRANSITION = new java.lang.Object();
    boolean mAdded;
    androidx.fragment.app.Fragment.a_renamed mAnimationInfo;
    android.os.Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    androidx.fragment.app.i_renamed mChildFragmentManager;
    android.view.ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    androidx.fragment.app.i_renamed mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    androidx.fragment.app.g_renamed mHost;
    boolean mInLayout;
    android.view.View mInnerView;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private java.lang.Boolean mIsPrimaryNavigationFragment;
    android.view.LayoutInflater mLayoutInflater;
    androidx.lifecycle.i_renamed mLifecycleRegistry;
    androidx.lifecycle.e_renamed.b_renamed mMaxState;
    boolean mMenuVisible;
    androidx.fragment.app.Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    java.lang.Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    android.os.Bundle mSavedFragmentState;
    androidx.savedstate.b_renamed mSavedStateRegistryController;
    java.lang.Boolean mSavedUserVisibleHint;
    android.util.SparseArray<android.os.Parcelable> mSavedViewState;
    int mState;
    java.lang.String mTag;
    androidx.fragment.app.Fragment mTarget;
    int mTargetRequestCode;
    java.lang.String mTargetWho;
    boolean mUserVisibleHint;
    android.view.View mView;
    androidx.fragment.app.o_renamed mViewLifecycleOwner;
    androidx.lifecycle.m_renamed<androidx.lifecycle.h_renamed> mViewLifecycleOwnerLiveData;
    java.lang.String mWho;

    interface c_renamed {
        void a_renamed();

        void b_renamed();
    }

    public void onActivityResult(int i_renamed, int i2, android.content.Intent intent) {
    }

    public void onAttachFragment(androidx.fragment.app.Fragment fragment) {
    }

    public boolean onContextItemSelected(android.view.MenuItem menuItem) {
        return false;
    }

    public android.view.animation.Animation onCreateAnimation(int i_renamed, boolean z_renamed, int i2) {
        return null;
    }

    public android.animation.Animator onCreateAnimator(int i_renamed, boolean z_renamed, int i2) {
        return null;
    }

    public void onCreateOptionsMenu(android.view.Menu menu, android.view.MenuInflater menuInflater) {
    }

    public void onDestroyOptionsMenu() {
    }

    public void onHiddenChanged(boolean z_renamed) {
    }

    public void onMultiWindowModeChanged(boolean z_renamed) {
    }

    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(android.view.Menu menu) {
    }

    public void onPictureInPictureModeChanged(boolean z_renamed) {
    }

    public void onPrepareOptionsMenu(android.view.Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z_renamed) {
    }

    public void onRequestPermissionsResult(int i_renamed, java.lang.String[] strArr, int[] iArr) {
    }

    public void onSaveInstanceState(android.os.Bundle bundle) {
    }

    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
    }

    @Override // androidx.lifecycle.h_renamed
    public androidx.lifecycle.e_renamed getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public androidx.lifecycle.h_renamed getViewLifecycleOwner() {
        androidx.fragment.app.o_renamed oVar = this.mViewLifecycleOwner;
        if (oVar != null) {
            return oVar;
        }
        throw new java.lang.IllegalStateException("Can't_renamed access the Fragment View's_renamed LifecycleOwner when getView() is_renamed null i_renamed.e_renamed., before onCreateView() or after onDestroyView()");
    }

    public androidx.lifecycle.LiveData<androidx.lifecycle.h_renamed> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.t_renamed
    public androidx.lifecycle.s_renamed getViewModelStore() {
        androidx.fragment.app.i_renamed iVar = this.mFragmentManager;
        if (iVar == null) {
            throw new java.lang.IllegalStateException("Can't_renamed access ViewModels from detached fragment");
        }
        return iVar.b_renamed(this);
    }

    @Override // androidx.savedstate.c_renamed
    public final androidx.savedstate.a_renamed getSavedStateRegistry() {
        return this.mSavedStateRegistryController.a_renamed();
    }

    @android.annotation.SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<androidx.fragment.app.Fragment.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<androidx.fragment.app.Fragment.SavedState>() { // from class: androidx.fragment.app.Fragment.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.fragment.app.Fragment.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.fragment.app.Fragment.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.fragment.app.Fragment.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new androidx.fragment.app.Fragment.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.fragment.app.Fragment.SavedState[] newArray(int i_renamed) {
                return new androidx.fragment.app.Fragment.SavedState[i_renamed];
            }
        };
        final android.os.Bundle mState;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState(android.os.Bundle bundle) {
            this.mState = bundle;
        }

        SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            android.os.Bundle bundle;
            this.mState = parcel.readBundle();
            if (classLoader == null || (bundle = this.mState) == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            parcel.writeBundle(this.mState);
        }
    }

    public static class b_renamed extends java.lang.RuntimeException {
        public b_renamed(java.lang.String str, java.lang.Exception exc) {
            super(str, exc);
        }
    }

    public Fragment() {
        this.mState = 0;
        this.mWho = java.util.UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new androidx.fragment.app.i_renamed();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new java.lang.Runnable() { // from class: androidx.fragment.app.Fragment.1
            @Override // java.lang.Runnable
            public void run() {
                androidx.fragment.app.Fragment.this.startPostponedEnterTransition();
            }
        };
        this.mMaxState = androidx.lifecycle.e_renamed.b_renamed.RESUMED;
        this.mViewLifecycleOwnerLiveData = new androidx.lifecycle.m_renamed<>();
        initLifecycle();
    }

    public Fragment(int i_renamed) {
        this();
        this.mContentLayoutId = i_renamed;
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new androidx.lifecycle.i_renamed(this);
        this.mSavedStateRegistryController = androidx.savedstate.b_renamed.a_renamed(this);
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            this.mLifecycleRegistry.a_renamed(new androidx.lifecycle.f_renamed() { // from class: androidx.fragment.app.Fragment.2
                @Override // androidx.lifecycle.f_renamed
                public void a_renamed(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.e_renamed.a_renamed aVar) {
                    if (aVar != androidx.lifecycle.e_renamed.a_renamed.ON_STOP || androidx.fragment.app.Fragment.this.mView == null) {
                        return;
                    }
                    androidx.fragment.app.Fragment.this.mView.cancelPendingInputEvents();
                }
            });
        }
    }

    @java.lang.Deprecated
    public static androidx.fragment.app.Fragment instantiate(android.content.Context context, java.lang.String str) {
        return instantiate(context, str, null);
    }

    @java.lang.Deprecated
    public static androidx.fragment.app.Fragment instantiate(android.content.Context context, java.lang.String str, android.os.Bundle bundle) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        try {
            androidx.fragment.app.Fragment fragmentNewInstance = androidx.fragment.app.f_renamed.b_renamed(context.getClassLoader(), str).getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragmentNewInstance.getClass().getClassLoader());
                fragmentNewInstance.setArguments(bundle);
            }
            return fragmentNewInstance;
        } catch (java.lang.IllegalAccessException e_renamed) {
            throw new androidx.fragment.app.Fragment.b_renamed("Unable to instantiate fragment " + str + ": make sure class name exists, is_renamed public, and has an_renamed empty constructor that is_renamed public", e_renamed);
        } catch (java.lang.InstantiationException e2) {
            throw new androidx.fragment.app.Fragment.b_renamed("Unable to instantiate fragment " + str + ": make sure class name exists, is_renamed public, and has an_renamed empty constructor that is_renamed public", e2);
        } catch (java.lang.NoSuchMethodException e3) {
            throw new androidx.fragment.app.Fragment.b_renamed("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (java.lang.reflect.InvocationTargetException e4) {
            throw new androidx.fragment.app.Fragment.b_renamed("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an_renamed exception", e4);
        }
    }

    final void restoreViewState(android.os.Bundle bundle) {
        android.util.SparseArray<android.os.Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mInnerView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new androidx.fragment.app.p_renamed("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_CREATE);
        }
    }

    final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean equals(java.lang.Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        androidx.core.g_renamed.a_renamed.a_renamed(this, sb);
        sb.append(" (");
        sb.append(this.mWho);
        sb.append(")");
        if (this.mFragmentId != 0) {
            sb.append(" id_renamed=0x");
            sb.append(java.lang.Integer.toHexString(this.mFragmentId));
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

    public final java.lang.String getTag() {
        return this.mTag;
    }

    public void setArguments(android.os.Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new java.lang.IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public final android.os.Bundle getArguments() {
        return this.mArguments;
    }

    public final android.os.Bundle requireArguments() {
        android.os.Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final boolean isStateSaved() {
        androidx.fragment.app.i_renamed iVar = this.mFragmentManager;
        if (iVar == null) {
            return false;
        }
        return iVar.g_renamed();
    }

    public void setInitialSavedState(androidx.fragment.app.Fragment.SavedState savedState) {
        if (this.mFragmentManager != null) {
            throw new java.lang.IllegalStateException("Fragment already added");
        }
        this.mSavedFragmentState = (savedState == null || savedState.mState == null) ? null : savedState.mState;
    }

    public void setTargetFragment(androidx.fragment.app.Fragment fragment, int i_renamed) {
        androidx.fragment.app.h_renamed fragmentManager = getFragmentManager();
        androidx.fragment.app.h_renamed fragmentManager2 = fragment != null ? fragment.getFragmentManager() : null;
        if (fragmentManager != null && fragmentManager2 != null && fragmentManager != fragmentManager2) {
            throw new java.lang.IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be_renamed set as_renamed a_renamed target fragment");
        }
        for (androidx.fragment.app.Fragment targetFragment = fragment; targetFragment != null; targetFragment = targetFragment.getTargetFragment()) {
            if (targetFragment == this) {
                throw new java.lang.IllegalArgumentException("Setting " + fragment + " as_renamed the target of_renamed " + this + " would create a_renamed target cycle");
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
        this.mTargetRequestCode = i_renamed;
    }

    public final androidx.fragment.app.Fragment getTargetFragment() {
        androidx.fragment.app.Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        androidx.fragment.app.i_renamed iVar = this.mFragmentManager;
        if (iVar == null || this.mTargetWho == null) {
            return null;
        }
        return iVar.g_renamed.get(this.mTargetWho);
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public android.content.Context getContext() {
        androidx.fragment.app.g_renamed gVar = this.mHost;
        if (gVar == null) {
            return null;
        }
        return gVar.j_renamed();
    }

    public final android.content.Context requireContext() {
        android.content.Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " not attached to a_renamed context.");
    }

    public final androidx.fragment.app.c_renamed getActivity() {
        androidx.fragment.app.g_renamed gVar = this.mHost;
        if (gVar == null) {
            return null;
        }
        return (androidx.fragment.app.c_renamed) gVar.i_renamed();
    }

    public final androidx.fragment.app.c_renamed requireActivity() {
        androidx.fragment.app.c_renamed activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " not attached to an_renamed activity.");
    }

    public final java.lang.Object getHost() {
        androidx.fragment.app.g_renamed gVar = this.mHost;
        if (gVar == null) {
            return null;
        }
        return gVar.h_renamed();
    }

    public final java.lang.Object requireHost() {
        java.lang.Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " not attached to a_renamed host.");
    }

    public final android.content.res.Resources getResources() {
        return requireContext().getResources();
    }

    public final java.lang.CharSequence getText(int i_renamed) {
        return getResources().getText(i_renamed);
    }

    public final java.lang.String getString(int i_renamed) {
        return getResources().getString(i_renamed);
    }

    public final java.lang.String getString(int i_renamed, java.lang.Object... objArr) {
        return getResources().getString(i_renamed, objArr);
    }

    public final androidx.fragment.app.h_renamed getFragmentManager() {
        return this.mFragmentManager;
    }

    public final androidx.fragment.app.h_renamed requireFragmentManager() {
        androidx.fragment.app.h_renamed fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " not associated with a_renamed fragment manager.");
    }

    public final androidx.fragment.app.h_renamed getChildFragmentManager() {
        if (this.mHost == null) {
            throw new java.lang.IllegalStateException("Fragment " + this + " has not been attached yet.");
        }
        return this.mChildFragmentManager;
    }

    public final androidx.fragment.app.Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final androidx.fragment.app.Fragment requireParentFragment() {
        androidx.fragment.app.Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new java.lang.IllegalStateException("Fragment " + this + " is_renamed not attached to any Fragment or host");
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " is_renamed not a_renamed child Fragment, it is_renamed directly attached to " + getContext());
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
        android.view.View view;
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

    public void setRetainInstance(boolean z_renamed) {
        this.mRetainInstance = z_renamed;
        androidx.fragment.app.i_renamed iVar = this.mFragmentManager;
        if (iVar == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z_renamed) {
            iVar.d_renamed(this);
        } else {
            iVar.e_renamed(this);
        }
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public void setHasOptionsMenu(boolean z_renamed) {
        if (this.mHasMenu != z_renamed) {
            this.mHasMenu = z_renamed;
            if (!isAdded() || isHidden()) {
                return;
            }
            this.mHost.e_renamed();
        }
    }

    public void setMenuVisibility(boolean z_renamed) {
        if (this.mMenuVisible != z_renamed) {
            this.mMenuVisible = z_renamed;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.e_renamed();
            }
        }
    }

    @java.lang.Deprecated
    public void setUserVisibleHint(boolean z_renamed) {
        if (!this.mUserVisibleHint && z_renamed && this.mState < 3 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            this.mFragmentManager.f_renamed(this);
        }
        this.mUserVisibleHint = z_renamed;
        this.mDeferStart = this.mState < 3 && !z_renamed;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = java.lang.Boolean.valueOf(z_renamed);
        }
    }

    @java.lang.Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @java.lang.Deprecated
    public androidx.loader.a_renamed.a_renamed getLoaderManager() {
        return androidx.loader.a_renamed.a_renamed.a_renamed(this);
    }

    public void startActivity(@android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(@android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent, android.os.Bundle bundle) {
        androidx.fragment.app.g_renamed gVar = this.mHost;
        if (gVar == null) {
            throw new java.lang.IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        gVar.a_renamed(this, intent, -1, bundle);
    }

    public void startActivityForResult(@android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent, int i_renamed) {
        startActivityForResult(intent, i_renamed, null);
    }

    public void startActivityForResult(@android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent, int i_renamed, android.os.Bundle bundle) {
        androidx.fragment.app.g_renamed gVar = this.mHost;
        if (gVar == null) {
            throw new java.lang.IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        gVar.a_renamed(this, intent, i_renamed, bundle);
    }

    public void startIntentSenderForResult(@android.annotation.SuppressLint({"UnknownNullness"}) android.content.IntentSender intentSender, int i_renamed, android.content.Intent intent, int i2, int i3, int i4, android.os.Bundle bundle) throws android.content.IntentSender.SendIntentException {
        androidx.fragment.app.g_renamed gVar = this.mHost;
        if (gVar == null) {
            throw new java.lang.IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        gVar.a_renamed(this, intentSender, i_renamed, intent, i2, i3, i4, bundle);
    }

    public final void requestPermissions(java.lang.String[] strArr, int i_renamed) {
        androidx.fragment.app.g_renamed gVar = this.mHost;
        if (gVar == null) {
            throw new java.lang.IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        gVar.a_renamed(this, strArr, i_renamed);
    }

    public boolean shouldShowRequestPermissionRationale(java.lang.String str) {
        androidx.fragment.app.g_renamed gVar = this.mHost;
        if (gVar != null) {
            return gVar.a_renamed(str);
        }
        return false;
    }

    public android.view.LayoutInflater onGetLayoutInflater(android.os.Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public final android.view.LayoutInflater getLayoutInflater() {
        android.view.LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    android.view.LayoutInflater performGetLayoutInflater(android.os.Bundle bundle) {
        this.mLayoutInflater = onGetLayoutInflater(bundle);
        return this.mLayoutInflater;
    }

    @java.lang.Deprecated
    public android.view.LayoutInflater getLayoutInflater(android.os.Bundle bundle) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        androidx.fragment.app.g_renamed gVar = this.mHost;
        if (gVar == null) {
            throw new java.lang.IllegalStateException("onGetLayoutInflater() cannot be_renamed executed until the Fragment is_renamed attached to the FragmentManager.");
        }
        android.view.LayoutInflater layoutInflaterC = gVar.c_renamed();
        androidx.core.h_renamed.e_renamed.a_renamed(layoutInflaterC, this.mChildFragmentManager.C_renamed());
        return layoutInflaterC;
    }

    public void onInflate(android.content.Context context, android.util.AttributeSet attributeSet, android.os.Bundle bundle) {
        this.mCalled = true;
        androidx.fragment.app.g_renamed gVar = this.mHost;
        android.app.Activity activityI = gVar == null ? null : gVar.i_renamed();
        if (activityI != null) {
            this.mCalled = false;
            onInflate(activityI, attributeSet, bundle);
        }
    }

    @java.lang.Deprecated
    public void onInflate(android.app.Activity activity, android.util.AttributeSet attributeSet, android.os.Bundle bundle) {
        this.mCalled = true;
    }

    public void onAttach(android.content.Context context) {
        this.mCalled = true;
        androidx.fragment.app.g_renamed gVar = this.mHost;
        android.app.Activity activityI = gVar == null ? null : gVar.i_renamed();
        if (activityI != null) {
            this.mCalled = false;
            onAttach(activityI);
        }
    }

    @java.lang.Deprecated
    public void onAttach(android.app.Activity activity) {
        this.mCalled = true;
    }

    public void onCreate(android.os.Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager.a_renamed(1)) {
            return;
        }
        this.mChildFragmentManager.q_renamed();
    }

    void restoreChildFragmentState(android.os.Bundle bundle) {
        android.os.Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.a_renamed(parcelable);
        this.mChildFragmentManager.q_renamed();
    }

    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        int i_renamed = this.mContentLayoutId;
        if (i_renamed != 0) {
            return layoutInflater.inflate(i_renamed, viewGroup, false);
        }
        return null;
    }

    public android.view.View getView() {
        return this.mView;
    }

    public final android.view.View requireView() {
        android.view.View view = getView();
        if (view != null) {
            return view;
        }
        throw new java.lang.IllegalStateException("Fragment " + this + " did not return a_renamed View from onCreateView() or this was called before onCreateView().");
    }

    public void onActivityCreated(android.os.Bundle bundle) {
        this.mCalled = true;
    }

    public void onViewStateRestored(android.os.Bundle bundle) {
        this.mCalled = true;
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onResume() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
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
        this.mWho = java.util.UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new androidx.fragment.app.i_renamed();
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
    public void onCreateContextMenu(android.view.ContextMenu contextMenu, android.view.View view, android.view.ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void registerForContextMenu(android.view.View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public void unregisterForContextMenu(android.view.View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public void setEnterSharedElementCallback(androidx.core.app.l_renamed lVar) {
        ensureAnimationInfo().o_renamed = lVar;
    }

    public void setExitSharedElementCallback(androidx.core.app.l_renamed lVar) {
        ensureAnimationInfo().p_renamed = lVar;
    }

    public void setEnterTransition(java.lang.Object obj) {
        ensureAnimationInfo().g_renamed = obj;
    }

    public java.lang.Object getEnterTransition() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.g_renamed;
    }

    public void setReturnTransition(java.lang.Object obj) {
        ensureAnimationInfo().h_renamed = obj;
    }

    public java.lang.Object getReturnTransition() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.h_renamed == USE_DEFAULT_TRANSITION ? getEnterTransition() : this.mAnimationInfo.h_renamed;
    }

    public void setExitTransition(java.lang.Object obj) {
        ensureAnimationInfo().i_renamed = obj;
    }

    public java.lang.Object getExitTransition() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.i_renamed;
    }

    public void setReenterTransition(java.lang.Object obj) {
        ensureAnimationInfo().j_renamed = obj;
    }

    public java.lang.Object getReenterTransition() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.j_renamed == USE_DEFAULT_TRANSITION ? getExitTransition() : this.mAnimationInfo.j_renamed;
    }

    public void setSharedElementEnterTransition(java.lang.Object obj) {
        ensureAnimationInfo().k_renamed = obj;
    }

    public java.lang.Object getSharedElementEnterTransition() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.k_renamed;
    }

    public void setSharedElementReturnTransition(java.lang.Object obj) {
        ensureAnimationInfo().l_renamed = obj;
    }

    public java.lang.Object getSharedElementReturnTransition() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.l_renamed == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : this.mAnimationInfo.l_renamed;
    }

    public void setAllowEnterTransitionOverlap(boolean z_renamed) {
        ensureAnimationInfo().n_renamed = java.lang.Boolean.valueOf(z_renamed);
    }

    public boolean getAllowEnterTransitionOverlap() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null || aVar.n_renamed == null) {
            return true;
        }
        return this.mAnimationInfo.n_renamed.booleanValue();
    }

    public void setAllowReturnTransitionOverlap(boolean z_renamed) {
        ensureAnimationInfo().m_renamed = java.lang.Boolean.valueOf(z_renamed);
    }

    public boolean getAllowReturnTransitionOverlap() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null || aVar.m_renamed == null) {
            return true;
        }
        return this.mAnimationInfo.m_renamed.booleanValue();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().q_renamed = true;
    }

    public final void postponeEnterTransition(long j_renamed, java.util.concurrent.TimeUnit timeUnit) {
        android.os.Handler handler;
        ensureAnimationInfo().q_renamed = true;
        androidx.fragment.app.i_renamed iVar = this.mFragmentManager;
        if (iVar != null) {
            handler = iVar.n_renamed.k_renamed();
        } else {
            handler = new android.os.Handler(android.os.Looper.getMainLooper());
        }
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j_renamed));
    }

    public void startPostponedEnterTransition() {
        androidx.fragment.app.i_renamed iVar = this.mFragmentManager;
        if (iVar == null || iVar.n_renamed == null) {
            ensureAnimationInfo().q_renamed = false;
        } else if (android.os.Looper.myLooper() != this.mFragmentManager.n_renamed.k_renamed().getLooper()) {
            this.mFragmentManager.n_renamed.k_renamed().postAtFrontOfQueue(new java.lang.Runnable() { // from class: androidx.fragment.app.Fragment.3
                @Override // java.lang.Runnable
                public void run() {
                    androidx.fragment.app.Fragment.this.callStartTransitionListener();
                }
            });
        } else {
            callStartTransitionListener();
        }
    }

    void callStartTransitionListener() {
        androidx.fragment.app.Fragment.c_renamed cVar;
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            cVar = null;
        } else {
            aVar.q_renamed = false;
            cVar = aVar.r_renamed;
            this.mAnimationInfo.r_renamed = null;
        }
        if (cVar != null) {
            cVar.a_renamed();
        }
    }

    public void dump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(java.lang.Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(java.lang.Integer.toHexString(this.mContainerId));
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
        androidx.fragment.app.Fragment targetFragment = getTargetFragment();
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
            androidx.loader.a_renamed.a_renamed.a_renamed(this).a_renamed(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.a_renamed(str + "  ", fileDescriptor, printWriter, strArr);
    }

    androidx.fragment.app.Fragment findFragmentByWho(java.lang.String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.b_renamed(str);
    }

    void performAttach() {
        this.mChildFragmentManager.a_renamed(this.mHost, new androidx.fragment.app.d_renamed() { // from class: androidx.fragment.app.Fragment.4
            @Override // androidx.fragment.app.d_renamed
            public android.view.View a_renamed(int i_renamed) {
                if (androidx.fragment.app.Fragment.this.mView == null) {
                    throw new java.lang.IllegalStateException("Fragment " + this + " does not have a_renamed view");
                }
                return androidx.fragment.app.Fragment.this.mView.findViewById(i_renamed);
            }

            @Override // androidx.fragment.app.d_renamed
            public boolean a_renamed() {
                return androidx.fragment.app.Fragment.this.mView != null;
            }
        }, this);
        this.mCalled = false;
        onAttach(this.mHost.j_renamed());
        if (this.mCalled) {
            return;
        }
        throw new androidx.fragment.app.p_renamed("Fragment " + this + " did not call through to super.onAttach()");
    }

    void performCreate(android.os.Bundle bundle) {
        this.mChildFragmentManager.p_renamed();
        this.mState = 1;
        this.mCalled = false;
        this.mSavedStateRegistryController.a_renamed(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new androidx.fragment.app.p_renamed("Fragment " + this + " did not call through to super.onCreate()");
        }
        this.mLifecycleRegistry.a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_CREATE);
    }

    void performCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        this.mChildFragmentManager.p_renamed();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new androidx.fragment.app.o_renamed();
        this.mView = onCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a_renamed();
            this.mViewLifecycleOwnerLiveData.a_renamed((androidx.lifecycle.m_renamed<androidx.lifecycle.h_renamed>) this.mViewLifecycleOwner);
        } else {
            if (this.mViewLifecycleOwner.b_renamed()) {
                throw new java.lang.IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
        }
    }

    void performActivityCreated(android.os.Bundle bundle) {
        this.mChildFragmentManager.p_renamed();
        this.mState = 2;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new androidx.fragment.app.p_renamed("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
        this.mChildFragmentManager.r_renamed();
    }

    void performStart() {
        this.mChildFragmentManager.p_renamed();
        this.mChildFragmentManager.l_renamed();
        this.mState = 3;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new androidx.fragment.app.p_renamed("Fragment " + this + " did not call through to super.onStart()");
        }
        this.mLifecycleRegistry.a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_START);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_START);
        }
        this.mChildFragmentManager.s_renamed();
    }

    void performResume() {
        this.mChildFragmentManager.p_renamed();
        this.mChildFragmentManager.l_renamed();
        this.mState = 4;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new androidx.fragment.app.p_renamed("Fragment " + this + " did not call through to super.onResume()");
        }
        this.mLifecycleRegistry.a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_RESUME);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_RESUME);
        }
        this.mChildFragmentManager.t_renamed();
        this.mChildFragmentManager.l_renamed();
    }

    void noteStateNotSaved() {
        this.mChildFragmentManager.p_renamed();
    }

    void performPrimaryNavigationFragmentChanged() {
        boolean zA = this.mFragmentManager.a_renamed(this);
        java.lang.Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != zA) {
            this.mIsPrimaryNavigationFragment = java.lang.Boolean.valueOf(zA);
            onPrimaryNavigationFragmentChanged(zA);
            this.mChildFragmentManager.z_renamed();
        }
    }

    void performMultiWindowModeChanged(boolean z_renamed) {
        onMultiWindowModeChanged(z_renamed);
        this.mChildFragmentManager.a_renamed(z_renamed);
    }

    void performPictureInPictureModeChanged(boolean z_renamed) {
        onPictureInPictureModeChanged(z_renamed);
        this.mChildFragmentManager.b_renamed(z_renamed);
    }

    void performConfigurationChanged(android.content.res.Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.a_renamed(configuration);
    }

    void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.y_renamed();
    }

    boolean performCreateOptionsMenu(android.view.Menu menu, android.view.MenuInflater menuInflater) {
        boolean z_renamed = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z_renamed = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return z_renamed | this.mChildFragmentManager.a_renamed(menu, menuInflater);
    }

    boolean performPrepareOptionsMenu(android.view.Menu menu) {
        boolean z_renamed = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z_renamed = true;
            onPrepareOptionsMenu(menu);
        }
        return z_renamed | this.mChildFragmentManager.a_renamed(menu);
    }

    boolean performOptionsItemSelected(android.view.MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        return (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) || this.mChildFragmentManager.a_renamed(menuItem);
    }

    boolean performContextItemSelected(android.view.MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        return onContextItemSelected(menuItem) || this.mChildFragmentManager.b_renamed(menuItem);
    }

    void performOptionsMenuClosed(android.view.Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.b_renamed(menu);
    }

    void performSaveInstanceState(android.os.Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b_renamed(bundle);
        android.os.Parcelable parcelableO = this.mChildFragmentManager.o_renamed();
        if (parcelableO != null) {
            bundle.putParcelable("android:support:fragments", parcelableO);
        }
    }

    void performPause() {
        this.mChildFragmentManager.u_renamed();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_PAUSE);
        }
        this.mLifecycleRegistry.a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_PAUSE);
        this.mState = 3;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
            return;
        }
        throw new androidx.fragment.app.p_renamed("Fragment " + this + " did not call through to super.onPause()");
    }

    void performStop() {
        this.mChildFragmentManager.v_renamed();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_STOP);
        }
        this.mLifecycleRegistry.a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_STOP);
        this.mState = 2;
        this.mCalled = false;
        onStop();
        if (this.mCalled) {
            return;
        }
        throw new androidx.fragment.app.p_renamed("Fragment " + this + " did not call through to super.onStop()");
    }

    void performDestroyView() {
        this.mChildFragmentManager.w_renamed();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new androidx.fragment.app.p_renamed("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        androidx.loader.a_renamed.a_renamed.a_renamed(this).a_renamed();
        this.mPerformedCreateView = false;
    }

    void performDestroy() {
        this.mChildFragmentManager.x_renamed();
        this.mLifecycleRegistry.a_renamed(androidx.lifecycle.e_renamed.a_renamed.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
            return;
        }
        throw new androidx.fragment.app.p_renamed("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void performDetach() {
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new androidx.fragment.app.p_renamed("Fragment " + this + " did not call through to super.onDetach()");
        }
        if (this.mChildFragmentManager.e_renamed()) {
            return;
        }
        this.mChildFragmentManager.x_renamed();
        this.mChildFragmentManager = new androidx.fragment.app.i_renamed();
    }

    void setOnStartEnterTransitionListener(androidx.fragment.app.Fragment.c_renamed cVar) {
        ensureAnimationInfo();
        if (cVar == this.mAnimationInfo.r_renamed) {
            return;
        }
        if (cVar != null && this.mAnimationInfo.r_renamed != null) {
            throw new java.lang.IllegalStateException("Trying to set a_renamed replacement startPostponedEnterTransition on_renamed " + this);
        }
        if (this.mAnimationInfo.q_renamed) {
            this.mAnimationInfo.r_renamed = cVar;
        }
        if (cVar != null) {
            cVar.b_renamed();
        }
    }

    private androidx.fragment.app.Fragment.a_renamed ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new androidx.fragment.app.Fragment.a_renamed();
        }
        return this.mAnimationInfo;
    }

    int getNextAnim() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.d_renamed;
    }

    void setNextAnim(int i_renamed) {
        if (this.mAnimationInfo == null && i_renamed == 0) {
            return;
        }
        ensureAnimationInfo().d_renamed = i_renamed;
    }

    int getNextTransition() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.e_renamed;
    }

    void setNextTransition(int i_renamed, int i2) {
        if (this.mAnimationInfo == null && i_renamed == 0 && i2 == 0) {
            return;
        }
        ensureAnimationInfo();
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        aVar.e_renamed = i_renamed;
        aVar.f_renamed = i2;
    }

    int getNextTransitionStyle() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f_renamed;
    }

    androidx.core.app.l_renamed getEnterTransitionCallback() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.o_renamed;
    }

    androidx.core.app.l_renamed getExitTransitionCallback() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.p_renamed;
    }

    android.view.View getAnimatingAway() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f1121a;
    }

    void setAnimatingAway(android.view.View view) {
        ensureAnimationInfo().f1121a = view;
    }

    void setAnimator(android.animation.Animator animator) {
        ensureAnimationInfo().f1122b = animator;
    }

    android.animation.Animator getAnimator() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f1122b;
    }

    int getStateAfterAnimating() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f1123c;
    }

    void setStateAfterAnimating(int i_renamed) {
        ensureAnimationInfo().f1123c = i_renamed;
    }

    boolean isPostponed() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            return false;
        }
        return aVar.q_renamed;
    }

    boolean isHideReplaced() {
        androidx.fragment.app.Fragment.a_renamed aVar = this.mAnimationInfo;
        if (aVar == null) {
            return false;
        }
        return aVar.s_renamed;
    }

    void setHideReplaced(boolean z_renamed) {
        ensureAnimationInfo().s_renamed = z_renamed;
    }

    static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        android.view.View f1121a;

        /* renamed from: b_renamed, reason: collision with root package name */
        android.animation.Animator f1122b;

        /* renamed from: c_renamed, reason: collision with root package name */
        int f1123c;
        int d_renamed;
        int e_renamed;
        int f_renamed;
        java.lang.Boolean m_renamed;
        java.lang.Boolean n_renamed;
        boolean q_renamed;
        androidx.fragment.app.Fragment.c_renamed r_renamed;
        boolean s_renamed;
        java.lang.Object g_renamed = null;
        java.lang.Object h_renamed = androidx.fragment.app.Fragment.USE_DEFAULT_TRANSITION;
        java.lang.Object i_renamed = null;
        java.lang.Object j_renamed = androidx.fragment.app.Fragment.USE_DEFAULT_TRANSITION;
        java.lang.Object k_renamed = null;
        java.lang.Object l_renamed = androidx.fragment.app.Fragment.USE_DEFAULT_TRANSITION;
        androidx.core.app.l_renamed o_renamed = null;
        androidx.core.app.l_renamed p_renamed = null;

        a_renamed() {
        }
    }
}
