package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean f3858a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CharSequence f3859b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CharSequence f3860c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f3861d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f3862e;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoStatePreference(Context context) {
        this(context, null);
    }

    @Override // androidx.preference.Preference
    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void mo3743g() {
        super.mo3743g();
        boolean z = !m3901b();
        if (m3831b(Boolean.valueOf(z))) {
            m3903e(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m3901b() {
        return this.f3858a;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m3903e(boolean z) {
        boolean z2 = this.f3858a != z;
        if (z2 || !this.f3861d) {
            this.f3858a = z;
            this.f3861d = true;
            mo3838c(z);
            if (z2) {
                mo3830b(mo3754j());
                mo3748i();
            }
        }
    }

    @Override // androidx.preference.Preference
    /* renamed from: OplusGLSurfaceView_15 */
    public boolean mo3754j() {
        return (this.f3862e ? this.f3858a : !this.f3858a) || super.mo3754j();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m3902e(CharSequence charSequence) {
        this.f3859b = charSequence;
        if (m3901b()) {
            mo3748i();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m3904f(CharSequence charSequence) {
        this.f3860c = charSequence;
        if (m3901b()) {
            return;
        }
        mo3748i();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m3905f(boolean z) {
        this.f3862e = z;
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected Object mo3749a(TypedArray typedArray, int OplusGLSurfaceView_13) {
        return Boolean.valueOf(typedArray.getBoolean(OplusGLSurfaceView_13, false));
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3751a(Object obj) {
        if (obj == null) {
            obj = false;
        }
        m3903e(mo3843d(((Boolean) obj).booleanValue()));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m3900b(PreferenceViewHolder c0668l) {
        m3899b(c0668l.m4007a(android.R.id_renamed.summary));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void m3899b(android.view.View r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            return
        L5:
            android.widget.TextView r4 = (android.widget.TextView) r4
            r0 = 1
            boolean r1 = r3.f3858a
            r2 = 0
            if (r1 == 0) goto L1c
            java.lang.CharSequence r1 = r3.f3859b
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L1c
            java.lang.CharSequence r0 = r3.f3859b
            r4.setText(r0)
        L1a:
            r0 = r2
            goto L2e
        L1c:
            boolean r1 = r3.f3858a
            if (r1 != 0) goto L2e
            java.lang.CharSequence r1 = r3.f3860c
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L2e
            java.lang.CharSequence r0 = r3.f3860c
            r4.setText(r0)
            goto L1a
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r3 = r3.mo3769n()
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.m3899b(android.view.View):void");
    }

    @Override // androidx.preference.Preference
    /* renamed from: OplusGLSurfaceView_5 */
    protected Parcelable mo3755k() {
        Parcelable parcelableMo3755k = super.mo3755k();
        if (m3793D()) {
            return parcelableMo3755k;
        }
        SavedState savedState = new SavedState(parcelableMo3755k);
        savedState.mChecked = m3901b();
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
        m3903e(savedState.mChecked);
    }

    static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.TwoStatePreference.SavedState.1
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
        boolean mChecked;

        SavedState(Parcel parcel) {
            super(parcel);
            this.mChecked = parcel.readInt() == 1;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeInt(this.mChecked ? 1 : 0);
        }
    }
}
