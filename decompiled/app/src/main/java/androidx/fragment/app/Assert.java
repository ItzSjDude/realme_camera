package androidx.fragment.app;

@java.lang.Deprecated
/* loaded from: classes.dex */
public class FragmentTabHost extends android.widget.TabHost implements android.widget.TabHost.OnTabChangeListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.ArrayList<androidx.fragment.app.FragmentTabHost.a_renamed> f1124a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f1125b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.fragment.app.h_renamed f1126c;
    private int d_renamed;
    private android.widget.TabHost.OnTabChangeListener e_renamed;
    private androidx.fragment.app.FragmentTabHost.a_renamed f_renamed;
    private boolean g_renamed;

    static final class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final java.lang.String f1127a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final java.lang.Class<?> f1128b;

        /* renamed from: c_renamed, reason: collision with root package name */
        final android.os.Bundle f1129c;
        androidx.fragment.app.Fragment d_renamed;
    }

    static class SavedState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<androidx.fragment.app.FragmentTabHost.SavedState> CREATOR = new android.os.Parcelable.Creator<androidx.fragment.app.FragmentTabHost.SavedState>() { // from class: androidx.fragment.app.FragmentTabHost.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.fragment.app.FragmentTabHost.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.fragment.app.FragmentTabHost.SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.fragment.app.FragmentTabHost.SavedState[] newArray(int i_renamed) {
                return new androidx.fragment.app.FragmentTabHost.SavedState[i_renamed];
            }
        };
        java.lang.String curTab;

        SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(android.os.Parcel parcel) {
            super(parcel);
            this.curTab = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeString(this.curTab);
        }

        public java.lang.String toString() {
            return "FragmentTabHost.SavedState{" + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
        }
    }

    @Override // android.widget.TabHost
    @java.lang.Deprecated
    public void setup() {
        throw new java.lang.IllegalStateException("Must call setup() that takes a_renamed Context and FragmentManager");
    }

    @Override // android.widget.TabHost
    @java.lang.Deprecated
    public void setOnTabChangedListener(android.widget.TabHost.OnTabChangeListener onTabChangeListener) {
        this.e_renamed = onTabChangeListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    @java.lang.Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        java.lang.String currentTabTag = getCurrentTabTag();
        int size = this.f1124a.size();
        androidx.fragment.app.k_renamed kVarA = null;
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            androidx.fragment.app.FragmentTabHost.a_renamed aVar = this.f1124a.get(i_renamed);
            aVar.d_renamed = this.f1126c.a_renamed(aVar.f1127a);
            if (aVar.d_renamed != null && !aVar.d_renamed.isDetached()) {
                if (aVar.f1127a.equals(currentTabTag)) {
                    this.f_renamed = aVar;
                } else {
                    if (kVarA == null) {
                        kVarA = this.f1126c.a_renamed();
                    }
                    kVarA.b_renamed(aVar.d_renamed);
                }
            }
        }
        this.g_renamed = true;
        androidx.fragment.app.k_renamed kVarA2 = a_renamed(currentTabTag, kVarA);
        if (kVarA2 != null) {
            kVarA2.b_renamed();
            this.f1126c.b_renamed();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @java.lang.Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g_renamed = false;
    }

    @Override // android.view.View
    @java.lang.Deprecated
    protected android.os.Parcelable onSaveInstanceState() {
        androidx.fragment.app.FragmentTabHost.SavedState savedState = new androidx.fragment.app.FragmentTabHost.SavedState(super.onSaveInstanceState());
        savedState.curTab = getCurrentTabTag();
        return savedState;
    }

    @Override // android.view.View
    @java.lang.Deprecated
    protected void onRestoreInstanceState(@android.annotation.SuppressLint({"UnknownNullness"}) android.os.Parcelable parcelable) {
        if (!(parcelable instanceof androidx.fragment.app.FragmentTabHost.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        androidx.fragment.app.FragmentTabHost.SavedState savedState = (androidx.fragment.app.FragmentTabHost.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.curTab);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @java.lang.Deprecated
    public void onTabChanged(java.lang.String str) {
        androidx.fragment.app.k_renamed kVarA;
        if (this.g_renamed && (kVarA = a_renamed(str, null)) != null) {
            kVarA.b_renamed();
        }
        android.widget.TabHost.OnTabChangeListener onTabChangeListener = this.e_renamed;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    private androidx.fragment.app.k_renamed a_renamed(java.lang.String str, androidx.fragment.app.k_renamed kVar) {
        androidx.fragment.app.FragmentTabHost.a_renamed aVarA = a_renamed(str);
        if (this.f_renamed != aVarA) {
            if (kVar == null) {
                kVar = this.f1126c.a_renamed();
            }
            androidx.fragment.app.FragmentTabHost.a_renamed aVar = this.f_renamed;
            if (aVar != null && aVar.d_renamed != null) {
                kVar.b_renamed(this.f_renamed.d_renamed);
            }
            if (aVarA != null) {
                if (aVarA.d_renamed == null) {
                    aVarA.d_renamed = this.f1126c.f_renamed().c_renamed(this.f1125b.getClassLoader(), aVarA.f1128b.getName());
                    aVarA.d_renamed.setArguments(aVarA.f1129c);
                    kVar.a_renamed(this.d_renamed, aVarA.d_renamed, aVarA.f1127a);
                } else {
                    kVar.c_renamed(aVarA.d_renamed);
                }
            }
            this.f_renamed = aVarA;
        }
        return kVar;
    }

    private androidx.fragment.app.FragmentTabHost.a_renamed a_renamed(java.lang.String str) {
        int size = this.f1124a.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            androidx.fragment.app.FragmentTabHost.a_renamed aVar = this.f1124a.get(i_renamed);
            if (aVar.f1127a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }
}
