package androidx.preference;

/* loaded from: classes.dex */
public class MultiSelectListPreference extends androidx.preference.DialogPreference {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.CharSequence[] f1305a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.CharSequence[] f1306b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.util.Set<java.lang.String> f1307c;

    public MultiSelectListPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.f1307c = new java.util.HashSet();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.preference.R_renamed.styleable.MultiSelectListPreference, i_renamed, i2);
        this.f1305a = androidx.core.a_renamed.a_renamed.g_renamed.d_renamed(typedArrayObtainStyledAttributes, androidx.preference.R_renamed.styleable.MultiSelectListPreference_entries, androidx.preference.R_renamed.styleable.MultiSelectListPreference_android_entries);
        this.f1306b = androidx.core.a_renamed.a_renamed.g_renamed.d_renamed(typedArrayObtainStyledAttributes, androidx.preference.R_renamed.styleable.MultiSelectListPreference_entryValues, androidx.preference.R_renamed.styleable.MultiSelectListPreference_android_entryValues);
        typedArrayObtainStyledAttributes.recycle();
    }

    public MultiSelectListPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public MultiSelectListPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(context, androidx.preference.R_renamed.attr.dialogPreferenceStyle, android.R_renamed.attr.dialogPreferenceStyle));
    }

    public MultiSelectListPreference(android.content.Context context) {
        this(context, null);
    }

    public void a_renamed(java.lang.CharSequence[] charSequenceArr) {
        this.f1305a = charSequenceArr;
    }

    public java.lang.CharSequence[] h_renamed() {
        return this.f1305a;
    }

    public java.lang.CharSequence[] l_renamed() {
        return this.f1306b;
    }

    public void a_renamed(java.util.Set<java.lang.String> set) {
        this.f1307c.clear();
        this.f1307c.addAll(set);
        b_renamed(set);
        i_renamed();
    }

    public java.util.Set<java.lang.String> m_renamed() {
        return this.f1307c;
    }

    @Override // androidx.preference.Preference
    protected java.lang.Object a_renamed(android.content.res.TypedArray typedArray, int i_renamed) {
        java.lang.CharSequence[] textArray = typedArray.getTextArray(i_renamed);
        java.util.HashSet hashSet = new java.util.HashSet();
        for (java.lang.CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // androidx.preference.Preference
    protected void a_renamed(java.lang.Object obj) {
        a_renamed(c_renamed((java.util.Set<java.lang.String>) obj));
    }

    @Override // androidx.preference.Preference
    protected android.os.Parcelable k_renamed() {
        android.os.Parcelable parcelableK = super.k_renamed();
        if (D_renamed()) {
            return parcelableK;
        }
        androidx.preference.MultiSelectListPreference.SavedState savedState = new androidx.preference.MultiSelectListPreference.SavedState(parcelableK);
        savedState.mValues = m_renamed();
        return savedState;
    }

    @Override // androidx.preference.Preference
    protected void a_renamed(android.os.Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(androidx.preference.MultiSelectListPreference.SavedState.class)) {
            super.a_renamed(parcelable);
            return;
        }
        androidx.preference.MultiSelectListPreference.SavedState savedState = (androidx.preference.MultiSelectListPreference.SavedState) parcelable;
        super.a_renamed(savedState.getSuperState());
        a_renamed(savedState.mValues);
    }

    private static class SavedState extends androidx.preference.Preference.BaseSavedState {
        public static final android.os.Parcelable.Creator<androidx.preference.MultiSelectListPreference.SavedState> CREATOR = new android.os.Parcelable.Creator<androidx.preference.MultiSelectListPreference.SavedState>() { // from class: androidx.preference.MultiSelectListPreference.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.preference.MultiSelectListPreference.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.preference.MultiSelectListPreference.SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.preference.MultiSelectListPreference.SavedState[] newArray(int i_renamed) {
                return new androidx.preference.MultiSelectListPreference.SavedState[i_renamed];
            }
        };
        java.util.Set<java.lang.String> mValues;

        SavedState(android.os.Parcel parcel) {
            super(parcel);
            int i_renamed = parcel.readInt();
            this.mValues = new java.util.HashSet();
            java.lang.String[] strArr = new java.lang.String[i_renamed];
            parcel.readStringArray(strArr);
            java.util.Collections.addAll(this.mValues, strArr);
        }

        SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeInt(this.mValues.size());
            java.util.Set<java.lang.String> set = this.mValues;
            parcel.writeStringArray((java.lang.String[]) set.toArray(new java.lang.String[set.size()]));
        }
    }
}
