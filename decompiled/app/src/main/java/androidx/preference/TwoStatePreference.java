package androidx.preference;

/* loaded from: classes.dex */
public abstract class TwoStatePreference extends androidx.preference.Preference {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected boolean f1329a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.CharSequence f1330b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.CharSequence f1331c;
    private boolean d_renamed;
    private boolean e_renamed;

    public TwoStatePreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
    }

    public TwoStatePreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public TwoStatePreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoStatePreference(android.content.Context context) {
        this(context, null);
    }

    @Override // androidx.preference.Preference
    protected void g_renamed() {
        super.g_renamed();
        boolean z_renamed = !b_renamed();
        if (b_renamed(java.lang.Boolean.valueOf(z_renamed))) {
            e_renamed(z_renamed);
        }
    }

    public boolean b_renamed() {
        return this.f1329a;
    }

    public void e_renamed(boolean z_renamed) {
        boolean z2 = this.f1329a != z_renamed;
        if (z2 || !this.d_renamed) {
            this.f1329a = z_renamed;
            this.d_renamed = true;
            c_renamed(z_renamed);
            if (z2) {
                b_renamed(j_renamed());
                i_renamed();
            }
        }
    }

    @Override // androidx.preference.Preference
    public boolean j_renamed() {
        return (this.e_renamed ? this.f1329a : !this.f1329a) || super.j_renamed();
    }

    public void e_renamed(java.lang.CharSequence charSequence) {
        this.f1330b = charSequence;
        if (b_renamed()) {
            i_renamed();
        }
    }

    public void f_renamed(java.lang.CharSequence charSequence) {
        this.f1331c = charSequence;
        if (b_renamed()) {
            return;
        }
        i_renamed();
    }

    public void f_renamed(boolean z_renamed) {
        this.e_renamed = z_renamed;
    }

    @Override // androidx.preference.Preference
    protected java.lang.Object a_renamed(android.content.res.TypedArray typedArray, int i_renamed) {
        return java.lang.Boolean.valueOf(typedArray.getBoolean(i_renamed, false));
    }

    @Override // androidx.preference.Preference
    protected void a_renamed(java.lang.Object obj) {
        if (obj == null) {
            obj = false;
        }
        e_renamed(d_renamed(((java.lang.Boolean) obj).booleanValue()));
    }

    protected void b_renamed(androidx.preference.l_renamed lVar) {
        b_renamed(lVar.a_renamed(android.R_renamed.id_renamed.summary));
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:22:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:25:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:27:? A_renamed[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void b_renamed(android.view.View r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            return
        L5:
            android.widget.TextView r4 = (android.widget.TextView) r4
            r0 = 1
            boolean r1 = r3.f1329a
            r2 = 0
            if (r1 == 0) goto L1c
            java.lang.CharSequence r1 = r3.f1330b
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L1c
            java.lang.CharSequence r0 = r3.f1330b
            r4.setText(r0)
        L1a:
            r0 = r2
            goto L2e
        L1c:
            boolean r1 = r3.f1329a
            if (r1 != 0) goto L2e
            java.lang.CharSequence r1 = r3.f1331c
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L2e
            java.lang.CharSequence r0 = r3.f1331c
            r4.setText(r0)
            goto L1a
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r3 = r3.n_renamed()
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 != 0) goto L3e
            r4.setText(r3)
            r0 = r2
        L3e:
            r3 = 8
            if (r0 != 0) goto L43
            r3 = r2
        L43:
            int r0 = r4.getVisibility()
            if (r3 == r0) goto L4c
            r4.setVisibility(r3)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.b_renamed(android.view.View):void");
    }

    @Override // androidx.preference.Preference
    protected android.os.Parcelable k_renamed() {
        android.os.Parcelable parcelableK = super.k_renamed();
        if (D_renamed()) {
            return parcelableK;
        }
        androidx.preference.TwoStatePreference.SavedState savedState = new androidx.preference.TwoStatePreference.SavedState(parcelableK);
        savedState.mChecked = b_renamed();
        return savedState;
    }

    @Override // androidx.preference.Preference
    protected void a_renamed(android.os.Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(androidx.preference.TwoStatePreference.SavedState.class)) {
            super.a_renamed(parcelable);
            return;
        }
        androidx.preference.TwoStatePreference.SavedState savedState = (androidx.preference.TwoStatePreference.SavedState) parcelable;
        super.a_renamed(savedState.getSuperState());
        e_renamed(savedState.mChecked);
    }

    static class SavedState extends androidx.preference.Preference.BaseSavedState {
        public static final android.os.Parcelable.Creator<androidx.preference.TwoStatePreference.SavedState> CREATOR = new android.os.Parcelable.Creator<androidx.preference.TwoStatePreference.SavedState>() { // from class: androidx.preference.TwoStatePreference.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.preference.TwoStatePreference.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.preference.TwoStatePreference.SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.preference.TwoStatePreference.SavedState[] newArray(int i_renamed) {
                return new androidx.preference.TwoStatePreference.SavedState[i_renamed];
            }
        };
        boolean mChecked;

        SavedState(android.os.Parcel parcel) {
            super(parcel);
            this.mChecked = parcel.readInt() == 1;
        }

        SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeInt(this.mChecked ? 1 : 0);
        }
    }
}
