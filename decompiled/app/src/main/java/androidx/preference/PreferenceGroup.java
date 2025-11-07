package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.p027a.p028a.TypedArrayUtils;
import androidx.preference.Preference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {

    /* renamed from: PlatformImplementations.kt_3 */
    final SimpleArrayMap<String, Long> f3776a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Handler f3777b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private List<Preference> f3778c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f3779d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f3780e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f3781f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f3782g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private InterfaceC0650a f3783h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final Runnable f3784i;

    /* renamed from: androidx.preference.PreferenceGroup$PlatformImplementations.kt_3 */
    public interface InterfaceC0650a {
        /* renamed from: PlatformImplementations.kt_3 */
        void m3881a();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected boolean mo3873e() {
        return true;
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f3776a = new SimpleArrayMap<>();
        this.f3777b = new Handler();
        this.f3779d = true;
        this.f3780e = 0;
        this.f3781f = false;
        this.f3782g = Integer.MAX_VALUE;
        this.f3783h = null;
        this.f3784i = new Runnable() { // from class: androidx.preference.PreferenceGroup.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    PreferenceGroup.this.f3776a.clear();
                }
            }
        };
        this.f3778c = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PreferenceGroup, OplusGLSurfaceView_13, i2);
        this.f3779d = TypedArrayUtils.m2315a(typedArrayObtainStyledAttributes, R.styleable.PreferenceGroup_orderingFromXml, R.styleable.PreferenceGroup_orderingFromXml, true);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.PreferenceGroup_initialExpandedChildrenCount)) {
            m3877i(TypedArrayUtils.m2307a(typedArrayObtainStyledAttributes, R.styleable.PreferenceGroup_initialExpandedChildrenCount, R.styleable.PreferenceGroup_initialExpandedChildrenCount, Integer.MAX_VALUE));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m3872e(boolean z) {
        this.f3779d = z;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m3877i(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != Integer.MAX_VALUE && !m3792C()) {
            Log.COUIBaseListPopupWindow_8("PreferenceGroup", getClass().getSimpleName() + " should have PlatformImplementations.kt_3 key defined if it contains an expandable preference");
        }
        this.f3782g = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m3864b() {
        return this.f3782g;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3865b(Preference preference) {
        m3867c(preference);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m3866c() {
        return this.f3778c.size();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public Preference m3878j(int OplusGLSurfaceView_13) {
        return this.f3778c.get(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m3867c(Preference preference) {
        long jM3987a;
        if (this.f3778c.contains(preference)) {
            return true;
        }
        if (preference.m3791B() != null) {
            PreferenceGroup preferenceGroupR = this;
            while (preferenceGroupR.m3807R() != null) {
                preferenceGroupR = preferenceGroupR.m3807R();
            }
            String strM3791B = preference.m3791B();
            if (preferenceGroupR.m3869d((CharSequence) strM3791B) != null) {
                Log.COUIBaseListPopupWindow_8("PreferenceGroup", "Found duplicated key: \"" + strM3791B + "\". This can cause unintended behaviour, please use unique keys for every preference.");
            }
        }
        if (preference.m3855w() == Integer.MAX_VALUE) {
            if (this.f3779d) {
                int OplusGLSurfaceView_13 = this.f3780e;
                this.f3780e = OplusGLSurfaceView_13 + 1;
                preference.m3835c(OplusGLSurfaceView_13);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).m3872e(this.f3779d);
            }
        }
        int iBinarySearch = Collections.binarySearch(this.f3778c, preference);
        if (iBinarySearch < 0) {
            iBinarySearch = (iBinarySearch * (-1)) - 1;
        }
        if (!m3874e(preference)) {
            return false;
        }
        synchronized (this) {
            this.f3778c.add(iBinarySearch, preference);
        }
        PreferenceManager c0666jN = m3803N();
        String strM3791B2 = preference.m3791B();
        if (strM3791B2 != null && this.f3776a.containsKey(strM3791B2)) {
            jM3987a = this.f3776a.get(strM3791B2).longValue();
            this.f3776a.remove(strM3791B2);
        } else {
            jM3987a = c0666jN.m3987a();
        }
        preference.m3823a(c0666jN, jM3987a);
        preference.m3821a(this);
        if (this.f3781f) {
            preference.mo3804O();
        }
        m3802M();
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m3871d(Preference preference) {
        boolean zM3863f = m3863f(preference);
        m3802M();
        return zM3863f;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m3868c(CharSequence charSequence) {
        Preference preferenceM3869d = m3869d(charSequence);
        if (preferenceM3869d == null) {
            return false;
        }
        return preferenceM3869d.m3807R().m3871d(preferenceM3869d);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m3863f(Preference preference) {
        boolean zRemove;
        synchronized (this) {
            preference.m3808S();
            if (preference.m3807R() == this) {
                preference.m3821a((PreferenceGroup) null);
            }
            zRemove = this.f3778c.remove(preference);
            if (zRemove) {
                String strM3791B = preference.m3791B();
                if (strM3791B != null) {
                    this.f3776a.put(strM3791B, Long.valueOf(preference.mo3839c_()));
                    this.f3777b.removeCallbacks(this.f3784i);
                    this.f3777b.post(this.f3784i);
                }
                if (this.f3781f) {
                    preference.mo3805P();
                }
            }
        }
        return zRemove;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m3870d() {
        synchronized (this) {
            List<Preference> list = this.f3778c;
            for (int size = list.size() - 1; size >= 0; size--) {
                m3863f(list.get(0));
            }
        }
        m3802M();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected boolean m3874e(Preference preference) {
        preference.m3828b(this, mo3754j());
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public <T extends Preference> T m3869d(CharSequence charSequence) {
        T t;
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (TextUtils.equals(m3791B(), charSequence)) {
            return this;
        }
        int iM3866c = m3866c();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM3866c; OplusGLSurfaceView_13++) {
            PreferenceGroup preferenceGroup = (T) m3878j(OplusGLSurfaceView_13);
            if (TextUtils.equals(preferenceGroup.m3791B(), charSequence)) {
                return preferenceGroup;
            }
            if ((preferenceGroup instanceof PreferenceGroup) && (t = (T) preferenceGroup.m3869d(charSequence)) != null) {
                return t;
            }
        }
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public InterfaceC0650a m3875f() {
        return this.f3783h;
    }

    @Override // androidx.preference.Preference
    /* renamed from: O */
    public void mo3804O() {
        super.mo3804O();
        this.f3781f = true;
        int iM3866c = m3866c();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM3866c; OplusGLSurfaceView_13++) {
            m3878j(OplusGLSurfaceView_13).mo3804O();
        }
    }

    @Override // androidx.preference.Preference
    /* renamed from: P */
    public void mo3805P() {
        super.mo3805P();
        this.f3781f = false;
        int iM3866c = m3866c();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM3866c; OplusGLSurfaceView_13++) {
            m3878j(OplusGLSurfaceView_13).mo3805P();
        }
    }

    @Override // androidx.preference.Preference
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3830b(boolean z) {
        super.mo3830b(z);
        int iM3866c = m3866c();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM3866c; OplusGLSurfaceView_13++) {
            m3878j(OplusGLSurfaceView_13).m3828b(this, z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    void m3876h() {
        synchronized (this) {
            Collections.sort(this.f3778c);
        }
    }

    @Override // androidx.preference.Preference
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo3827b(Bundle bundle) {
        super.mo3827b(bundle);
        int iM3866c = m3866c();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM3866c; OplusGLSurfaceView_13++) {
            m3878j(OplusGLSurfaceView_13).mo3827b(bundle);
        }
    }

    @Override // androidx.preference.Preference
    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void mo3841d(Bundle bundle) {
        super.mo3841d(bundle);
        int iM3866c = m3866c();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM3866c; OplusGLSurfaceView_13++) {
            m3878j(OplusGLSurfaceView_13).mo3841d(bundle);
        }
    }

    @Override // androidx.preference.Preference
    /* renamed from: OplusGLSurfaceView_5 */
    protected Parcelable mo3755k() {
        return new SavedState(super.mo3755k(), this.f3782g);
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3750a(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.mo3750a(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f3782g = savedState.mInitialExpandedChildrenCount;
        super.mo3750a(savedState.getSuperState());
    }

    static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.PreferenceGroup.SavedState.1
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
        int mInitialExpandedChildrenCount;

        SavedState(Parcel parcel) {
            super(parcel);
            this.mInitialExpandedChildrenCount = parcel.readInt();
        }

        SavedState(Parcelable parcelable, int OplusGLSurfaceView_13) {
            super(parcelable);
            this.mInitialExpandedChildrenCount = OplusGLSurfaceView_13;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeInt(this.mInitialExpandedChildrenCount);
        }
    }
}
