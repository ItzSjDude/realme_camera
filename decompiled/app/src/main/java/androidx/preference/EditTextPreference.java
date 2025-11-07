package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.core.p027a.p028a.TypedArrayUtils;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f3720a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private InterfaceC0636a f3721b;

    /* renamed from: androidx.preference.EditTextPreference$PlatformImplementations.kt_3 */
    public interface InterfaceC0636a {
        /* renamed from: PlatformImplementations.kt_3 */
        void m3759a(EditText editText);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EditTextPreference, OplusGLSurfaceView_13, i2);
        if (TypedArrayUtils.m2315a(typedArrayObtainStyledAttributes, R.styleable.EditTextPreference_useSimpleSummaryProvider, R.styleable.EditTextPreference_useSimpleSummaryProvider, false)) {
            m3819a((Preference.InterfaceC0647e) C0637b.m3760a());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m2306a(context, R.attr.editTextPreferenceStyle, android.R.attr.editTextPreferenceStyle));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3752a(String str) {
        boolean zMo3754j = mo3754j();
        this.f3720a = str;
        m3842d(str);
        boolean zMo3754j2 = mo3754j();
        if (zMo3754j2 != zMo3754j) {
            mo3830b(zMo3754j2);
        }
        mo3748i();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public String m3753h() {
        return this.f3720a;
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected Object mo3749a(TypedArray typedArray, int OplusGLSurfaceView_13) {
        return typedArray.getString(OplusGLSurfaceView_13);
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3751a(Object obj) {
        m3752a(m3844e((String) obj));
    }

    @Override // androidx.preference.Preference
    /* renamed from: OplusGLSurfaceView_15 */
    public boolean mo3754j() {
        return TextUtils.isEmpty(this.f3720a) || super.mo3754j();
    }

    @Override // androidx.preference.Preference
    /* renamed from: OplusGLSurfaceView_5 */
    protected Parcelable mo3755k() {
        Parcelable parcelableK = super.mo3755k();
        if (m3793D()) {
            return parcelableK;
        }
        SavedState savedState = new SavedState(parcelableK);
        savedState.mText = m3753h();
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
        m3752a(savedState.mText);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    InterfaceC0636a m3756l() {
        return this.f3721b;
    }

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.EditTextPreference.SavedState.1
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
        String mText;

        SavedState(Parcel parcel) {
            super(parcel);
            this.mText = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeString(this.mText);
        }
    }

    /* renamed from: androidx.preference.EditTextPreference$IntrinsicsJvm.kt_4 */
    public static final class C0637b implements Preference.InterfaceC0647e<EditTextPreference> {

        /* renamed from: PlatformImplementations.kt_3 */
        private static C0637b f3722a;

        private C0637b() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static C0637b m3760a() {
            if (f3722a == null) {
                f3722a = new C0637b();
            }
            return f3722a;
        }

        @Override // androidx.preference.Preference.InterfaceC0647e
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public CharSequence mo3762a(EditTextPreference editTextPreference) {
            if (TextUtils.isEmpty(editTextPreference.m3753h())) {
                return editTextPreference.m3800K().getString(R.string.not_set);
            }
            return editTextPreference.m3753h();
        }
    }
}
