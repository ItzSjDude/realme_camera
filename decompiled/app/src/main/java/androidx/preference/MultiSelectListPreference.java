package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.core.p027a.p028a.TypedArrayUtils;
import androidx.preference.Preference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class MultiSelectListPreference extends DialogPreference {

    /* renamed from: PlatformImplementations.kt_3 */
    private CharSequence[] f3729a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CharSequence[] f3730b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Set<String> f3731c;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f3731c = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MultiSelectListPreference, OplusGLSurfaceView_13, i2);
        this.f3729a = TypedArrayUtils.m2324d(typedArrayObtainStyledAttributes, R.styleable.MultiSelectListPreference_entries, R.styleable.MultiSelectListPreference_android_entries);
        this.f3730b = TypedArrayUtils.m2324d(typedArrayObtainStyledAttributes, R.styleable.MultiSelectListPreference_entryValues, R.styleable.MultiSelectListPreference_android_entryValues);
        typedArrayObtainStyledAttributes.recycle();
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m2306a(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }

    public MultiSelectListPreference(Context context) {
        this(context, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3777a(CharSequence[] charSequenceArr) {
        this.f3729a = charSequenceArr;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public CharSequence[] m3778h() {
        return this.f3729a;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public CharSequence[] m3779l() {
        return this.f3730b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3776a(Set<String> set) {
        this.f3731c.clear();
        this.f3731c.addAll(set);
        m3832b(set);
        mo3748i();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public Set<String> m3780m() {
        return this.f3731c;
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected Object mo3749a(TypedArray typedArray, int OplusGLSurfaceView_13) {
        CharSequence[] textArray = typedArray.getTextArray(OplusGLSurfaceView_13);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3751a(Object obj) {
        m3776a(m3834c((Set<String>) obj));
    }

    @Override // androidx.preference.Preference
    /* renamed from: OplusGLSurfaceView_5 */
    protected Parcelable mo3755k() {
        Parcelable parcelableK = super.mo3755k();
        if (m3793D()) {
            return parcelableK;
        }
        SavedState savedState = new SavedState(parcelableK);
        savedState.mValues = m3780m();
        return savedState;
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3750a(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.mo3750a(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.mo3750a(savedState.getSuperState());
        m3776a(savedState.mValues);
    }

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.MultiSelectListPreference.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        Set<String> mValues;

        SavedState(Parcel parcel) {
            super(parcel);
            int OplusGLSurfaceView_13 = parcel.readInt();
            this.mValues = new HashSet();
            String[] strArr = new String[OplusGLSurfaceView_13];
            parcel.readStringArray(strArr);
            Collections.addAll(this.mValues, strArr);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeInt(this.mValues.size());
            Set<String> set = this.mValues;
            parcel.writeStringArray((String[]) set.toArray(new String[set.size()]));
        }
    }
}
