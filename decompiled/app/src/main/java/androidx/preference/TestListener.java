package androidx.preference;

/* compiled from: PreferenceFragmentCompat.java */
/* loaded from: classes.dex */
public abstract class g_renamed extends androidx.fragment.app.Fragment implements androidx.preference.DialogPreference.a_renamed, androidx.preference.j_renamed.a_renamed, androidx.preference.j_renamed.b_renamed, androidx.preference.j_renamed.c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.recyclerview.widget.RecyclerView f1346a;

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.preference.j_renamed f1348c;
    private boolean d_renamed;
    private boolean e_renamed;
    private java.lang.Runnable g_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.preference.g_renamed.a_renamed f1347b = new androidx.preference.g_renamed.a_renamed();
    private int f_renamed = androidx.preference.R_renamed.layout.preference_list_fragment;
    private android.os.Handler h_renamed = new android.os.Handler() { // from class: androidx.preference.g_renamed.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return;
            }
            androidx.preference.g_renamed.this.b_renamed();
        }
    };
    private final java.lang.Runnable i_renamed = new java.lang.Runnable() { // from class: androidx.preference.g_renamed.2
        @Override // java.lang.Runnable
        public void run() {
            androidx.preference.g_renamed.this.f1346a.focusableViewAvailable(androidx.preference.g_renamed.this.f1346a);
        }
    };

    /* compiled from: PreferenceFragmentCompat.java */
    public interface b_renamed {
        boolean a_renamed(androidx.preference.g_renamed gVar, androidx.preference.Preference preference);
    }

    /* compiled from: PreferenceFragmentCompat.java */
    public interface c_renamed {
        boolean a_renamed(androidx.preference.g_renamed gVar, androidx.preference.Preference preference);
    }

    /* compiled from: PreferenceFragmentCompat.java */
    public interface d_renamed {
        boolean a_renamed(androidx.preference.g_renamed gVar, androidx.preference.PreferenceScreen preferenceScreen);
    }

    public abstract void a_renamed(android.os.Bundle bundle, java.lang.String str);

    protected void c_renamed() {
    }

    protected void d_renamed() {
    }

    public androidx.fragment.app.Fragment g_renamed() {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        android.util.TypedValue typedValue = new android.util.TypedValue();
        getActivity().getTheme().resolveAttribute(androidx.preference.R_renamed.attr.preferenceTheme, typedValue, true);
        int i_renamed = typedValue.resourceId;
        if (i_renamed == 0) {
            i_renamed = androidx.preference.R_renamed.style.PreferenceThemeOverlay;
        }
        getActivity().getTheme().applyStyle(i_renamed, false);
        this.f1348c = new androidx.preference.j_renamed(getContext());
        this.f1348c.a_renamed((androidx.preference.j_renamed.b_renamed) this);
        a_renamed(bundle, getArguments() != null ? getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    @Override // androidx.fragment.app.Fragment
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, androidx.preference.R_renamed.styleable.PreferenceFragmentCompat, androidx.preference.R_renamed.attr.preferenceFragmentCompatStyle, 0);
        this.f_renamed = typedArrayObtainStyledAttributes.getResourceId(androidx.preference.R_renamed.styleable.PreferenceFragmentCompat_android_layout, this.f_renamed);
        android.graphics.drawable.Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(androidx.preference.R_renamed.styleable.PreferenceFragmentCompat_android_divider);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.preference.R_renamed.styleable.PreferenceFragmentCompat_android_dividerHeight, -1);
        boolean z_renamed = typedArrayObtainStyledAttributes.getBoolean(androidx.preference.R_renamed.styleable.PreferenceFragmentCompat_allowDividerAfterLastItem, true);
        typedArrayObtainStyledAttributes.recycle();
        android.view.LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(getContext());
        android.view.View viewInflate = layoutInflaterCloneInContext.inflate(this.f_renamed, viewGroup, false);
        android.view.View viewFindViewById = viewInflate.findViewById(android.R_renamed.id_renamed.list_container);
        if (!(viewFindViewById instanceof android.view.ViewGroup)) {
            throw new java.lang.IllegalStateException("Content has view with id_renamed attribute 'android.R_renamed.id_renamed.list_container' that is_renamed not a_renamed ViewGroup class");
        }
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) viewFindViewById;
        androidx.recyclerview.widget.RecyclerView recyclerViewA = a_renamed(layoutInflaterCloneInContext, viewGroup2, bundle);
        if (recyclerViewA == null) {
            throw new java.lang.RuntimeException("Could not create RecyclerView");
        }
        this.f1346a = recyclerViewA;
        recyclerViewA.addItemDecoration(this.f1347b);
        a_renamed(drawable);
        if (dimensionPixelSize != -1) {
            a_renamed(dimensionPixelSize);
        }
        this.f1347b.a_renamed(z_renamed);
        if (this.f1346a.getParent() == null) {
            viewGroup2.addView(this.f1346a);
        }
        this.h_renamed.post(this.i_renamed);
        return viewInflate;
    }

    public void a_renamed(android.graphics.drawable.Drawable drawable) {
        this.f1347b.a_renamed(drawable);
    }

    public void a_renamed(int i_renamed) {
        this.f1347b.a_renamed(i_renamed);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        android.os.Bundle bundle2;
        androidx.preference.PreferenceScreen preferenceScreenA;
        super.onViewCreated(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (preferenceScreenA = a_renamed()) != null) {
            preferenceScreenA.c_renamed(bundle2);
        }
        if (this.d_renamed) {
            b_renamed();
            java.lang.Runnable runnable = this.g_renamed;
            if (runnable != null) {
                runnable.run();
                this.g_renamed = null;
            }
        }
        this.e_renamed = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f1348c.a_renamed((androidx.preference.j_renamed.c_renamed) this);
        this.f1348c.a_renamed((androidx.preference.j_renamed.a_renamed) this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f1348c.a_renamed((androidx.preference.j_renamed.c_renamed) null);
        this.f1348c.a_renamed((androidx.preference.j_renamed.a_renamed) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.h_renamed.removeCallbacks(this.i_renamed);
        this.h_renamed.removeMessages(1);
        if (this.d_renamed) {
            j_renamed();
        }
        this.f1346a = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        androidx.preference.PreferenceScreen preferenceScreenA = a_renamed();
        if (preferenceScreenA != null) {
            android.os.Bundle bundle2 = new android.os.Bundle();
            preferenceScreenA.a_renamed(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    public androidx.preference.PreferenceScreen a_renamed() {
        return this.f1348c.d_renamed();
    }

    public void a_renamed(androidx.preference.PreferenceScreen preferenceScreen) {
        if (!this.f1348c.a_renamed(preferenceScreen) || preferenceScreen == null) {
            return;
        }
        d_renamed();
        this.d_renamed = true;
        if (this.e_renamed) {
            i_renamed();
        }
    }

    public void b_renamed(int i_renamed) {
        h_renamed();
        a_renamed(this.f1348c.a_renamed(getContext(), i_renamed, a_renamed()));
    }

    @Override // androidx.preference.j_renamed.c_renamed
    public boolean a_renamed(androidx.preference.Preference preference) {
        if (preference.r_renamed() == null) {
            return false;
        }
        boolean zA = g_renamed() instanceof androidx.preference.g_renamed.c_renamed ? ((androidx.preference.g_renamed.c_renamed) g_renamed()).a_renamed(this, preference) : false;
        if (!zA && (getActivity() instanceof androidx.preference.g_renamed.c_renamed)) {
            zA = ((androidx.preference.g_renamed.c_renamed) getActivity()).a_renamed(this, preference);
        }
        if (zA) {
            return true;
        }
        android.util.Log.w_renamed("PreferenceFragment", "onPreferenceStartFragment is_renamed not implemented in_renamed the parent activity - attempting to use a_renamed fallback implementation. You should implement this method so that you can configure the new fragment that will be_renamed displayed, and set a_renamed transition between the fragments.");
        androidx.fragment.app.h_renamed hVarJ = requireActivity().j_renamed();
        android.os.Bundle bundleT = preference.t_renamed();
        androidx.fragment.app.Fragment fragmentC = hVarJ.f_renamed().c_renamed(requireActivity().getClassLoader(), preference.r_renamed());
        fragmentC.setArguments(bundleT);
        fragmentC.setTargetFragment(this, 0);
        hVarJ.a_renamed().a_renamed(((android.view.View) getView().getParent()).getId(), fragmentC).a_renamed((java.lang.String) null).b_renamed();
        return true;
    }

    @Override // androidx.preference.j_renamed.b_renamed
    public void b_renamed(androidx.preference.PreferenceScreen preferenceScreen) {
        if ((g_renamed() instanceof androidx.preference.g_renamed.d_renamed ? ((androidx.preference.g_renamed.d_renamed) g_renamed()).a_renamed(this, preferenceScreen) : false) || !(getActivity() instanceof androidx.preference.g_renamed.d_renamed)) {
            return;
        }
        ((androidx.preference.g_renamed.d_renamed) getActivity()).a_renamed(this, preferenceScreen);
    }

    @Override // androidx.preference.DialogPreference.a_renamed
    public <T_renamed extends androidx.preference.Preference> T_renamed a_renamed(java.lang.CharSequence charSequence) {
        androidx.preference.j_renamed jVar = this.f1348c;
        if (jVar == null) {
            return null;
        }
        return (T_renamed) jVar.a_renamed(charSequence);
    }

    private void h_renamed() {
        if (this.f1348c == null) {
            throw new java.lang.RuntimeException("This should be_renamed called after super.onCreate.");
        }
    }

    private void i_renamed() {
        if (this.h_renamed.hasMessages(1)) {
            return;
        }
        this.h_renamed.obtainMessage(1).sendToTarget();
    }

    void b_renamed() {
        androidx.preference.PreferenceScreen preferenceScreenA = a_renamed();
        if (preferenceScreenA != null) {
            e_renamed().setAdapter(c_renamed(preferenceScreenA));
            preferenceScreenA.O_renamed();
        }
        c_renamed();
    }

    private void j_renamed() {
        e_renamed().setAdapter(null);
        androidx.preference.PreferenceScreen preferenceScreenA = a_renamed();
        if (preferenceScreenA != null) {
            preferenceScreenA.P_renamed();
        }
        d_renamed();
    }

    public final androidx.recyclerview.widget.RecyclerView e_renamed() {
        return this.f1346a;
    }

    public androidx.recyclerview.widget.RecyclerView a_renamed(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        androidx.recyclerview.widget.RecyclerView recyclerView;
        if (getContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (androidx.recyclerview.widget.RecyclerView) viewGroup.findViewById(androidx.preference.R_renamed.id_renamed.recycler_view)) != null) {
            return recyclerView;
        }
        androidx.recyclerview.widget.RecyclerView recyclerView2 = (androidx.recyclerview.widget.RecyclerView) layoutInflater.inflate(androidx.preference.R_renamed.layout.preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(f_renamed());
        recyclerView2.setAccessibilityDelegateCompat(new androidx.preference.k_renamed(recyclerView2));
        return recyclerView2;
    }

    public androidx.recyclerview.widget.RecyclerView.i_renamed f_renamed() {
        return new androidx.recyclerview.widget.LinearLayoutManager(getContext());
    }

    protected androidx.recyclerview.widget.RecyclerView.a_renamed c_renamed(androidx.preference.PreferenceScreen preferenceScreen) {
        return new androidx.preference.h_renamed(preferenceScreen);
    }

    @Override // androidx.preference.j_renamed.a_renamed
    public void b_renamed(androidx.preference.Preference preference) {
        androidx.fragment.app.b_renamed bVarA;
        boolean zA = g_renamed() instanceof androidx.preference.g_renamed.b_renamed ? ((androidx.preference.g_renamed.b_renamed) g_renamed()).a_renamed(this, preference) : false;
        if (!zA && (getActivity() instanceof androidx.preference.g_renamed.b_renamed)) {
            zA = ((androidx.preference.g_renamed.b_renamed) getActivity()).a_renamed(this, preference);
        }
        if (!zA && getFragmentManager().a_renamed("androidx.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof androidx.preference.EditTextPreference) {
                bVarA = androidx.preference.a_renamed.a_renamed(preference.B_renamed());
            } else if (preference instanceof androidx.preference.ListPreference) {
                bVarA = androidx.preference.c_renamed.a_renamed(preference.B_renamed());
            } else if (preference instanceof androidx.preference.MultiSelectListPreference) {
                bVarA = androidx.preference.d_renamed.a_renamed(preference.B_renamed());
            } else {
                throw new java.lang.IllegalArgumentException("Cannot display dialog for an_renamed unknown Preference type: " + preference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a_renamed custom dialog for this Preference.");
            }
            bVarA.setTargetFragment(this, 0);
            bVarA.show(getFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
        }
    }

    /* compiled from: PreferenceFragmentCompat.java */
    private class a_renamed extends androidx.recyclerview.widget.RecyclerView.h_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.graphics.drawable.Drawable f1352b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f1353c;
        private boolean d_renamed = true;

        a_renamed() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h_renamed
        public void onDrawOver(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            if (this.f1352b == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                android.view.View childAt = recyclerView.getChildAt(i_renamed);
                if (a_renamed(childAt, recyclerView)) {
                    int y_renamed = ((int) childAt.getY()) + childAt.getHeight();
                    this.f1352b.setBounds(0, y_renamed, width, this.f1353c + y_renamed);
                    this.f1352b.draw(canvas);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h_renamed
        public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            if (a_renamed(view, recyclerView)) {
                rect.bottom = this.f1353c;
            }
        }

        private boolean a_renamed(android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView) {
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolder = recyclerView.getChildViewHolder(view);
            if (!((childViewHolder instanceof androidx.preference.l_renamed) && ((androidx.preference.l_renamed) childViewHolder).b_renamed())) {
                return false;
            }
            boolean z_renamed = this.d_renamed;
            int iIndexOfChild = recyclerView.indexOfChild(view);
            if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
                return z_renamed;
            }
            androidx.recyclerview.widget.RecyclerView.w_renamed childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(iIndexOfChild + 1));
            return (childViewHolder2 instanceof androidx.preference.l_renamed) && ((androidx.preference.l_renamed) childViewHolder2).a_renamed();
        }

        public void a_renamed(android.graphics.drawable.Drawable drawable) {
            if (drawable != null) {
                this.f1353c = drawable.getIntrinsicHeight();
            } else {
                this.f1353c = 0;
            }
            this.f1352b = drawable;
            androidx.preference.g_renamed.this.f1346a.invalidateItemDecorations();
        }

        public void a_renamed(int i_renamed) {
            this.f1353c = i_renamed;
            androidx.preference.g_renamed.this.f1346a.invalidateItemDecorations();
        }

        public void a_renamed(boolean z_renamed) {
            this.d_renamed = z_renamed;
        }
    }
}
