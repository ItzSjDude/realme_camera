package com.coui.appcompat.preference;

/* loaded from: classes.dex */
public class COUIInputPreference extends com.coui.appcompat.preference.COUIPreference {

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.coui.appcompat.widget.COUIEditText f2582a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.CharSequence f2583b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.CharSequence f2584c;
    private android.content.Context d_renamed;
    private android.view.View e_renamed;
    private boolean f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;

    public COUIInputPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, coui.support.appcompat.R_renamed.attr.couiInputPreferenceStyle);
    }

    public COUIInputPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public COUIInputPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed);
        this.d_renamed = context;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIInputPreference, i_renamed, 0);
        this.f2583b = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIInputPreference_couiContent);
        this.f2584c = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIInputPreference_couiHint);
        typedArrayObtainStyledAttributes.recycle();
        android.content.res.TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.Preference, i_renamed, 0);
        this.f_renamed = typedArrayObtainStyledAttributes2.getText(coui.support.appcompat.R_renamed.styleable.Preference_android_title) != null;
        typedArrayObtainStyledAttributes2.recycle();
        this.g_renamed = context.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_input_edit_text_has_title_padding_top);
        this.h_renamed = context.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_input_edit_text_has_title_padding_bottom);
        this.i_renamed = context.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_input_edit_text_no_title_padding_top);
        this.j_renamed = context.getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_input_edit_text_no_title_padding_bottom);
        this.k_renamed = context.getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.coui_input_preference_padding_end);
        this.f2582a = new com.coui.appcompat.widget.n_renamed(context, attributeSet, coui.support.appcompat.R_renamed.attr.couiInputPreferenceEditTextStyle);
        this.f2582a.setId(android.R_renamed.id_renamed.input);
        this.f2582a.setMaxLines(5);
        this.f2582a.setFastDeletable(true);
        this.f2582a.setVerticalScrollBarEnabled(false);
        this.f2582a.setLineSpacing(0.0f, 1.1f);
        this.f2582a.setGravity(8388627);
        this.f2582a.setTextSize(0, this.d_renamed.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_input_preference_text_size));
        if (this.f_renamed) {
            this.f2582a.setPaddingRelative(0, this.g_renamed, 0, this.h_renamed);
        } else {
            this.f2582a.setPaddingRelative(0, this.i_renamed, 0, this.j_renamed);
            this.f2582a.setBoxBackgroundMode(0);
        }
    }

    public void c_renamed(java.lang.CharSequence charSequence) {
        com.coui.appcompat.widget.COUIEditText cOUIEditText = this.f2582a;
        if (cOUIEditText != null) {
            cOUIEditText.setText(charSequence);
            this.f2583b = charSequence;
            return;
        }
        if (!android.text.TextUtils.equals(this.f2583b, charSequence)) {
            i_renamed();
        }
        boolean zJ = j_renamed();
        this.f2583b = charSequence;
        if (charSequence != null) {
            d_renamed(charSequence.toString());
        }
        boolean zJ2 = j_renamed();
        if (zJ2 != zJ) {
            b_renamed(zJ2);
        }
    }

    public java.lang.CharSequence b_renamed() {
        return this.f2584c;
    }

    @Override // androidx.preference.Preference
    protected java.lang.Object a_renamed(android.content.res.TypedArray typedArray, int i_renamed) {
        return typedArray.getString(i_renamed);
    }

    @Override // androidx.preference.Preference
    protected void a_renamed(boolean z_renamed, java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(this.f2583b)) {
            return;
        }
        c_renamed((java.lang.CharSequence) (z_renamed ? e_renamed(this.f2583b.toString()) : (java.lang.String) obj));
    }

    @Override // androidx.preference.Preference
    public boolean j_renamed() {
        return android.text.TextUtils.isEmpty(this.f2583b) || super.j_renamed();
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        super.a_renamed(lVar);
        this.e_renamed = lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_preference);
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.e_renamed.findViewById(coui.support.appcompat.R_renamed.id_renamed.edittext_container);
        if (viewGroup != null) {
            if (!this.f2582a.equals((android.widget.EditText) viewGroup.findViewById(android.R_renamed.id_renamed.input))) {
                android.view.ViewParent parent = this.f2582a.getParent();
                if (parent != null) {
                    ((android.view.ViewGroup) parent).removeView(this.f2582a);
                }
                viewGroup.removeAllViews();
                viewGroup.addView(this.f2582a, -1, -2);
            }
        }
        java.lang.CharSequence charSequenceB = b_renamed();
        if (!android.text.TextUtils.isEmpty(charSequenceB)) {
            this.f2582a.setTopHint(charSequenceB);
        }
        this.f2582a.setEnabled(y_renamed());
    }

    @Override // androidx.preference.Preference
    protected android.os.Parcelable k_renamed() {
        android.os.Parcelable parcelableK = super.k_renamed();
        if (D_renamed()) {
            return parcelableK;
        }
        com.coui.appcompat.preference.COUIInputPreference.SavedState savedState = new com.coui.appcompat.preference.COUIInputPreference.SavedState(parcelableK);
        java.lang.CharSequence charSequence = this.f2583b;
        if (charSequence != null) {
            savedState.mText = charSequence.toString();
        }
        return savedState;
    }

    @Override // androidx.preference.Preference
    protected void a_renamed(android.os.Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(com.coui.appcompat.preference.COUIInputPreference.SavedState.class)) {
            super.a_renamed(parcelable);
            return;
        }
        com.coui.appcompat.preference.COUIInputPreference.SavedState savedState = (com.coui.appcompat.preference.COUIInputPreference.SavedState) parcelable;
        super.a_renamed(savedState.getSuperState());
        c_renamed((java.lang.CharSequence) savedState.mText);
    }

    private static class SavedState extends android.preference.Preference.BaseSavedState {
        public static final android.os.Parcelable.Creator<com.coui.appcompat.preference.COUIInputPreference.SavedState> CREATOR = new android.os.Parcelable.Creator<com.coui.appcompat.preference.COUIInputPreference.SavedState>() { // from class: com.coui.appcompat.preference.COUIInputPreference.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.coui.appcompat.preference.COUIInputPreference.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.coui.appcompat.preference.COUIInputPreference.SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.coui.appcompat.preference.COUIInputPreference.SavedState[] newArray(int i_renamed) {
                return new com.coui.appcompat.preference.COUIInputPreference.SavedState[i_renamed];
            }
        };
        java.lang.String mText;

        public SavedState(android.os.Parcel parcel) {
            super(parcel);
            this.mText = parcel.readString();
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeString(this.mText);
        }
    }
}
