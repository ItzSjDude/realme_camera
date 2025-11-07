package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import androidx.preference.DialogPreference;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PreferenceFragmentCompat.java */
/* renamed from: androidx.preference.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public abstract class PreferenceFragmentCompat extends Fragment implements DialogPreference.InterfaceC0633a, PreferenceManager.PlatformImplementations.kt_3, PreferenceManager.IntrinsicsJvm.kt_4, PreferenceManager.IntrinsicsJvm.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    RecyclerView f3883a;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private PreferenceManager f3885c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f3886d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f3887e;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Runnable f3889g;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PlatformImplementations.kt_3 f3884b = new PlatformImplementations.kt_3();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f3888f = R.layout.preference_list_fragment;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Handler f3890h = new Handler() { // from class: androidx.preference.COUIBaseListPopupWindow_11.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            PreferenceFragmentCompat.this.m3941b();
        }
    };

    /* renamed from: OplusGLSurfaceView_13 */
    private final Runnable f3891i = new Runnable() { // from class: androidx.preference.COUIBaseListPopupWindow_11.2
        @Override // java.lang.Runnable
        public void run() {
            PreferenceFragmentCompat.this.f3883a.focusableViewAvailable(PreferenceFragmentCompat.this.f3883a);
        }
    };

    /* compiled from: PreferenceFragmentCompat.java */
    /* renamed from: androidx.preference.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean m3955a(PreferenceFragmentCompat abstractC0663g, Preference preference);
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* renamed from: androidx.preference.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean m3956a(PreferenceFragmentCompat abstractC0663g, Preference preference);
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* renamed from: androidx.preference.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_5 */
    public interface IntrinsicsJvm.kt_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean m3957a(PreferenceFragmentCompat abstractC0663g, PreferenceScreen preferenceScreen);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3938a(Bundle bundle, String str);

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void m3946c() {
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void m3947d() {
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public Fragment m3950g() {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
        int OplusGLSurfaceView_13 = typedValue.resourceId;
        if (OplusGLSurfaceView_13 == 0) {
            OplusGLSurfaceView_13 = R.style.PreferenceThemeOverlay;
        }
        getActivity().getTheme().applyStyle(OplusGLSurfaceView_13, false);
        this.f3885c = new PreferenceManager(getContext());
        this.f3885c.m3993a((PreferenceManager.IntrinsicsJvm.kt_4) this);
        mo3938a(bundle, getArguments() != null ? getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.PreferenceFragmentCompat, R.attr.preferenceFragmentCompatStyle, 0);
        this.f3888f = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PreferenceFragmentCompat_android_layout, this.f3888f);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.PreferenceFragmentCompat_android_divider);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.PreferenceFragmentCompat_android_dividerHeight, -1);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PreferenceFragmentCompat_allowDividerAfterLastItem, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(getContext());
        View viewInflate = layoutInflaterCloneInContext.inflate(this.f3888f, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(android.R.id_renamed.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            throw new IllegalStateException("Content has view with id_renamed attribute 'android.R.id_renamed.list_container' that is not PlatformImplementations.kt_3 ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        RecyclerView recyclerViewMo3935a = mo3935a(layoutInflaterCloneInContext, viewGroup2, bundle);
        if (recyclerViewMo3935a == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.f3883a = recyclerViewMo3935a;
        recyclerViewMo3935a.addItemDecoration(this.f3884b);
        m3937a(drawable);
        if (dimensionPixelSize != -1) {
            m3936a(dimensionPixelSize);
        }
        this.f3884b.m3954a(z);
        if (this.f3883a.getParent() == null) {
            viewGroup2.addView(this.f3883a);
        }
        this.f3890h.post(this.f3891i);
        return viewInflate;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3937a(Drawable drawable) {
        this.f3884b.m3953a(drawable);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3936a(int OplusGLSurfaceView_13) {
        this.f3884b.m3952a(OplusGLSurfaceView_13);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreenM3934a;
        super.onViewCreated(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (preferenceScreenM3934a = m3934a()) != null) {
            preferenceScreenM3934a.m3836c(bundle2);
        }
        if (this.f3886d) {
            m3941b();
            Runnable runnable = this.f3889g;
            if (runnable != null) {
                runnable.run();
                this.f3889g = null;
            }
        }
        this.f3887e = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f3885c.m3994a((PreferenceManager.IntrinsicsJvm.kt_3) this);
        this.f3885c.m3992a((PreferenceManager.PlatformImplementations.kt_3) this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f3885c.m3994a((PreferenceManager.IntrinsicsJvm.kt_3) null);
        this.f3885c.m3992a((PreferenceManager.PlatformImplementations.kt_3) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f3890h.removeCallbacks(this.f3891i);
        this.f3890h.removeMessages(1);
        if (this.f3886d) {
            m3933j();
        }
        this.f3883a = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreenM3934a = m3934a();
        if (preferenceScreenM3934a != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreenM3934a.m3814a(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public PreferenceScreen m3934a() {
        return this.f3885c.m3999d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3939a(PreferenceScreen preferenceScreen) {
        if (!this.f3885c.m3996a(preferenceScreen) || preferenceScreen == null) {
            return;
        }
        m3947d();
        this.f3886d = true;
        if (this.f3887e) {
            m3932i();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3942b(int OplusGLSurfaceView_13) {
        m3931h();
        m3939a(this.f3885c.m3989a(getContext(), OplusGLSurfaceView_13, m3934a()));
    }

    @Override // androidx.preference.PreferenceManager.IntrinsicsJvm.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo3940a(Preference preference) {
        if (preference.m3850r() == null) {
            return false;
        }
        boolean zM3956a = m3950g() instanceof IntrinsicsJvm.kt_3 ? ((IntrinsicsJvm.kt_3) m3950g()).m3956a(this, preference) : false;
        if (!zM3956a && (getActivity() instanceof IntrinsicsJvm.kt_3)) {
            zM3956a = ((IntrinsicsJvm.kt_3) getActivity()).m3956a(this, preference);
        }
        if (zM3956a) {
            return true;
        }
        Log.w("PreferenceFragment", "onPreferenceStartFragment is not implemented in the parent activity - attempting to use PlatformImplementations.kt_3 fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set PlatformImplementations.kt_3 transition between the fragments.");
        FragmentManager abstractC0586hM3341j = requireActivity().m3341j();
        Bundle bundleM3852t = preference.m3852t();
        Fragment fragmentMo3384c = abstractC0586hM3341j.mo3399f().mo3384c(requireActivity().getClassLoader(), preference.m3850r());
        fragmentMo3384c.setArguments(bundleM3852t);
        fragmentMo3384c.setTargetFragment(this, 0);
        abstractC0586hM3341j.mo3389a().m3540a(((View) getView().getParent()).getId(), fragmentMo3384c).m3543a((String) null).mo3319b();
        return true;
    }

    @Override // androidx.preference.PreferenceManager.IntrinsicsJvm.kt_4
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3944b(PreferenceScreen preferenceScreen) {
        if ((m3950g() instanceof IntrinsicsJvm.kt_5 ? ((IntrinsicsJvm.kt_5) m3950g()).m3957a(this, preferenceScreen) : false) || !(getActivity() instanceof IntrinsicsJvm.kt_5)) {
            return;
        }
        ((IntrinsicsJvm.kt_5) getActivity()).m3957a(this, preferenceScreen);
    }

    @Override // androidx.preference.DialogPreference.InterfaceC0633a
    /* renamed from: PlatformImplementations.kt_3 */
    public <T extends Preference> T mo3744a(CharSequence charSequence) {
        PreferenceManager c0666j = this.f3885c;
        if (c0666j == null) {
            return null;
        }
        return (T) c0666j.m3988a(charSequence);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m3931h() {
        if (this.f3885c == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m3932i() {
        if (this.f3890h.hasMessages(1)) {
            return;
        }
        this.f3890h.obtainMessage(1).sendToTarget();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m3941b() {
        PreferenceScreen preferenceScreenM3934a = m3934a();
        if (preferenceScreenM3934a != null) {
            m3948e().setAdapter(m3945c(preferenceScreenM3934a));
            preferenceScreenM3934a.mo3804O();
        }
        m3946c();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m3933j() {
        m3948e().setAdapter(null);
        PreferenceScreen preferenceScreenM3934a = m3934a();
        if (preferenceScreenM3934a != null) {
            preferenceScreenM3934a.mo3805P();
        }
        m3947d();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public final RecyclerView m3948e() {
        return this.f3883a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public RecyclerView mo3935a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (getContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R.id_renamed.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R.layout.preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(m3949f());
        recyclerView2.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(recyclerView2));
        return recyclerView2;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public RecyclerView.AbstractC0693i m3949f() {
        return new LinearLayoutManager(getContext());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected RecyclerView.AbstractC0685a m3945c(PreferenceScreen preferenceScreen) {
        return new PreferenceGroupAdapter(preferenceScreen);
    }

    @Override // androidx.preference.PreferenceManager.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3943b(Preference preference) {
        DialogFragment dialogInterfaceOnCancelListenerC0580bM3918a;
        boolean zM3955a = m3950g() instanceof IntrinsicsJvm.kt_4 ? ((IntrinsicsJvm.kt_4) m3950g()).m3955a(this, preference) : false;
        if (!zM3955a && (getActivity() instanceof IntrinsicsJvm.kt_4)) {
            zM3955a = ((IntrinsicsJvm.kt_4) getActivity()).m3955a(this, preference);
        }
        if (!zM3955a && getFragmentManager().mo3388a("androidx.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof EditTextPreference) {
                dialogInterfaceOnCancelListenerC0580bM3918a = EditTextPreferenceDialogFragmentCompat.m3908a(preference.m3791B());
            } else if (preference instanceof ListPreference) {
                dialogInterfaceOnCancelListenerC0580bM3918a = ListPreferenceDialogFragmentCompat.m3915a(preference.m3791B());
            } else if (preference instanceof MultiSelectListPreference) {
                dialogInterfaceOnCancelListenerC0580bM3918a = MultiSelectListPreferenceDialogFragmentCompat.m3918a(preference.m3791B());
            } else {
                throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + preference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying PlatformImplementations.kt_3 custom dialog for this Preference.");
            }
            dialogInterfaceOnCancelListenerC0580bM3918a.setTargetFragment(this, 0);
            dialogInterfaceOnCancelListenerC0580bM3918a.show(getFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
        }
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* renamed from: androidx.preference.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends RecyclerView.AbstractC0692h {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Drawable f3895b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f3896c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f3897d = true;

        PlatformImplementations.kt_3() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0692h
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0704t c0704t) {
            if (this.f3895b == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                View childAt = recyclerView.getChildAt(OplusGLSurfaceView_13);
                if (m3951a(childAt, recyclerView)) {
                    int y = ((int) childAt.getY()) + childAt.getHeight();
                    this.f3895b.setBounds(0, y, width, this.f3896c + y);
                    this.f3895b.draw(canvas);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0692h
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0704t c0704t) {
            if (m3951a(view, recyclerView)) {
                rect.bottom = this.f3896c;
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean m3951a(View view, RecyclerView recyclerView) {
            RecyclerView.AbstractC0707w childViewHolder = recyclerView.getChildViewHolder(view);
            if (!((childViewHolder instanceof PreferenceViewHolder) && ((PreferenceViewHolder) childViewHolder).m4011b())) {
                return false;
            }
            boolean z = this.f3897d;
            int iIndexOfChild = recyclerView.indexOfChild(view);
            if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
                return z;
            }
            RecyclerView.AbstractC0707w childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(iIndexOfChild + 1));
            return (childViewHolder2 instanceof PreferenceViewHolder) && ((PreferenceViewHolder) childViewHolder2).m4009a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m3953a(Drawable drawable) {
            if (drawable != null) {
                this.f3896c = drawable.getIntrinsicHeight();
            } else {
                this.f3896c = 0;
            }
            this.f3895b = drawable;
            PreferenceFragmentCompat.this.f3883a.invalidateItemDecorations();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m3952a(int OplusGLSurfaceView_13) {
            this.f3896c = OplusGLSurfaceView_13;
            PreferenceFragmentCompat.this.f3883a.invalidateItemDecorations();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m3954a(boolean z) {
            this.f3897d = z;
        }
    }
}
