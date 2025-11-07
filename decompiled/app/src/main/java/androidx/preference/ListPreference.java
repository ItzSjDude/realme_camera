package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.p027a.p028a.TypedArrayUtils;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* renamed from: PlatformImplementations.kt_3 */
    private CharSequence[] f3723a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CharSequence[] f3724b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f3725c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f3726d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f3727e;

    public ListPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPreference, OplusGLSurfaceView_13, i2);
        this.f3723a = TypedArrayUtils.m2324d(typedArrayObtainStyledAttributes, R.styleable.ListPreference_entries, R.styleable.ListPreference_android_entries);
        this.f3724b = TypedArrayUtils.m2324d(typedArrayObtainStyledAttributes, R.styleable.ListPreference_entryValues, R.styleable.ListPreference_android_entryValues);
        if (TypedArrayUtils.m2315a(typedArrayObtainStyledAttributes, R.styleable.ListPreference_useSimpleSummaryProvider, R.styleable.ListPreference_useSimpleSummaryProvider, false)) {
            m3819a((Preference.InterfaceC0647e) C0639a.m3774a());
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, OplusGLSurfaceView_13, i2);
        this.f3726d = TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes2, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public ListPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m2306a(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }

    public ListPreference(Context context) {
        this(context, null);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public CharSequence[] m3767l() {
        return this.f3723a;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public CharSequence[] m3768m() {
        return this.f3724b;
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3764a(CharSequence charSequence) {
        super.mo3764a(charSequence);
        if (charSequence == null && this.f3726d != null) {
            this.f3726d = null;
        } else {
            if (charSequence == null || charSequence.equals(this.f3726d)) {
                return;
            }
            this.f3726d = charSequence.toString();
        }
    }

    @Override // androidx.preference.Preference
    /* renamed from: OplusGLSurfaceView_11 */
    public CharSequence mo3769n() {
        if (m3796G() != null) {
            return m3796G().mo3762a(this);
        }
        CharSequence charSequenceM3771p = m3771p();
        CharSequence charSequenceN = super.mo3769n();
        String str = this.f3726d;
        if (str == null) {
            return charSequenceN;
        }
        Object[] objArr = new Object[1];
        if (charSequenceM3771p == null) {
            charSequenceM3771p = "";
        }
        objArr[0] = charSequenceM3771p;
        String str2 = String.format(str, objArr);
        if (TextUtils.equals(str2, charSequenceN)) {
            return charSequenceN;
        }
        Log.w("ListPreference", "Setting PlatformImplementations.kt_3 summary with PlatformImplementations.kt_3 String formatting marker is no longer supported. You should use PlatformImplementations.kt_3 SummaryProvider instead.");
        return str2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3765a(String str) {
        boolean z = !TextUtils.equals(this.f3725c, str);
        if (z || !this.f3727e) {
            this.f3725c = str;
            this.f3727e = true;
            m3842d(str);
            if (z) {
                mo3748i();
            }
        }
    }

    /* renamed from: o */
    public String m3770o() {
        return this.f3725c;
    }

    /* renamed from: p */
    public CharSequence m3771p() {
        CharSequence[] charSequenceArr;
        int iM3763h = m3763h();
        if (iM3763h < 0 || (charSequenceArr = this.f3723a) == null) {
            return null;
        }
        return charSequenceArr[iM3763h];
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m3766b(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f3724b) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.f3724b[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int m3763h() {
        return m3766b(this.f3725c);
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected Object mo3749a(TypedArray typedArray, int OplusGLSurfaceView_13) {
        return typedArray.getString(OplusGLSurfaceView_13);
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3751a(Object obj) {
        m3765a(m3844e((String) obj));
    }

    @Override // androidx.preference.Preference
    /* renamed from: OplusGLSurfaceView_5 */
    protected Parcelable mo3755k() {
        Parcelable parcelableK = super.mo3755k();
        if (m3793D()) {
            return parcelableK;
        }
        SavedState savedState = new SavedState(parcelableK);
        savedState.mValue = m3770o();
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
        m3765a(savedState.mValue);
    }

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.ListPreference.SavedState.1
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
        String mValue;

        SavedState(Parcel parcel) {
            super(parcel);
            this.mValue = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeString(this.mValue);
        }
    }

    /* renamed from: androidx.preference.ListPreference$PlatformImplementations.kt_3 */
    public static final class C0639a implements Preference.InterfaceC0647e<ListPreference> {

        /* renamed from: PlatformImplementations.kt_3 */
        private static C0639a f3728a;

        private C0639a() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static C0639a m3774a() {
            if (f3728a == null) {
                f3728a = new C0639a();
            }
            return f3728a;
        }

        @Override // androidx.preference.Preference.InterfaceC0647e
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public CharSequence mo3762a(ListPreference listPreference) {
            if (TextUtils.isEmpty(listPreference.m3771p())) {
                return listPreference.m3800K().getString(R.string.not_set);
            }
            return listPreference.m3771p();
        }
    }
}
