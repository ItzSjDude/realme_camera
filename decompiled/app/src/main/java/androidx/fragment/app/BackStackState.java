package androidx.fragment.app;

@android.annotation.SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class BackStackState implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<androidx.fragment.app.BackStackState> CREATOR = new android.os.Parcelable.Creator<androidx.fragment.app.BackStackState>() { // from class: androidx.fragment.app.BackStackState.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public androidx.fragment.app.BackStackState createFromParcel(android.os.Parcel parcel) {
            return new androidx.fragment.app.BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public androidx.fragment.app.BackStackState[] newArray(int i_renamed) {
            return new androidx.fragment.app.BackStackState[i_renamed];
        }
    };
    final int mBreadCrumbShortTitleRes;
    final java.lang.CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final java.lang.CharSequence mBreadCrumbTitleText;
    final int[] mCurrentMaxLifecycleStates;
    final java.util.ArrayList<java.lang.String> mFragmentWhos;
    final int mIndex;
    final java.lang.String mName;
    final int[] mOldMaxLifecycleStates;
    final int[] mOps;
    final boolean mReorderingAllowed;
    final java.util.ArrayList<java.lang.String> mSharedElementSourceNames;
    final java.util.ArrayList<java.lang.String> mSharedElementTargetNames;
    final int mTransition;
    final int mTransitionStyle;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackState(androidx.fragment.app.a_renamed aVar) {
        int size = aVar.d_renamed.size();
        this.mOps = new int[size * 5];
        if (!aVar.k_renamed) {
            throw new java.lang.IllegalStateException("Not on_renamed back stack");
        }
        this.mFragmentWhos = new java.util.ArrayList<>(size);
        this.mOldMaxLifecycleStates = new int[size];
        this.mCurrentMaxLifecycleStates = new int[size];
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < size) {
            androidx.fragment.app.k_renamed.a_renamed aVar2 = aVar.d_renamed.get(i_renamed);
            int i3 = i2 + 1;
            this.mOps[i2] = aVar2.f1174a;
            this.mFragmentWhos.add(aVar2.f1175b != null ? aVar2.f1175b.mWho : null);
            int i4 = i3 + 1;
            this.mOps[i3] = aVar2.f1176c;
            int i5 = i4 + 1;
            this.mOps[i4] = aVar2.d_renamed;
            int i6 = i5 + 1;
            this.mOps[i5] = aVar2.e_renamed;
            this.mOps[i6] = aVar2.f_renamed;
            this.mOldMaxLifecycleStates[i_renamed] = aVar2.g_renamed.ordinal();
            this.mCurrentMaxLifecycleStates[i_renamed] = aVar2.h_renamed.ordinal();
            i_renamed++;
            i2 = i6 + 1;
        }
        this.mTransition = aVar.i_renamed;
        this.mTransitionStyle = aVar.j_renamed;
        this.mName = aVar.m_renamed;
        this.mIndex = aVar.f1132c;
        this.mBreadCrumbTitleRes = aVar.n_renamed;
        this.mBreadCrumbTitleText = aVar.o_renamed;
        this.mBreadCrumbShortTitleRes = aVar.p_renamed;
        this.mBreadCrumbShortTitleText = aVar.q_renamed;
        this.mSharedElementSourceNames = aVar.r_renamed;
        this.mSharedElementTargetNames = aVar.s_renamed;
        this.mReorderingAllowed = aVar.t_renamed;
    }

    public BackStackState(android.os.Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mFragmentWhos = parcel.createStringArrayList();
        this.mOldMaxLifecycleStates = parcel.createIntArray();
        this.mCurrentMaxLifecycleStates = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mTransitionStyle = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (java.lang.CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (java.lang.CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
        this.mReorderingAllowed = parcel.readInt() != 0;
    }

    public androidx.fragment.app.a_renamed instantiate(androidx.fragment.app.i_renamed iVar) {
        androidx.fragment.app.a_renamed aVar = new androidx.fragment.app.a_renamed(iVar);
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < this.mOps.length) {
            androidx.fragment.app.k_renamed.a_renamed aVar2 = new androidx.fragment.app.k_renamed.a_renamed();
            int i3 = i_renamed + 1;
            aVar2.f1174a = this.mOps[i_renamed];
            if (androidx.fragment.app.i_renamed.f1142b) {
                android.util.Log.v_renamed("FragmentManager", "Instantiate " + aVar + " op #" + i2 + " base fragment #" + this.mOps[i3]);
            }
            java.lang.String str = this.mFragmentWhos.get(i2);
            if (str != null) {
                aVar2.f1175b = iVar.g_renamed.get(str);
            } else {
                aVar2.f1175b = null;
            }
            aVar2.g_renamed = androidx.lifecycle.e_renamed.b_renamed.values()[this.mOldMaxLifecycleStates[i2]];
            aVar2.h_renamed = androidx.lifecycle.e_renamed.b_renamed.values()[this.mCurrentMaxLifecycleStates[i2]];
            int[] iArr = this.mOps;
            int i4 = i3 + 1;
            aVar2.f1176c = iArr[i3];
            int i5 = i4 + 1;
            aVar2.d_renamed = iArr[i4];
            int i6 = i5 + 1;
            aVar2.e_renamed = iArr[i5];
            aVar2.f_renamed = iArr[i6];
            aVar.e_renamed = aVar2.f1176c;
            aVar.f_renamed = aVar2.d_renamed;
            aVar.g_renamed = aVar2.e_renamed;
            aVar.h_renamed = aVar2.f_renamed;
            aVar.a_renamed(aVar2);
            i2++;
            i_renamed = i6 + 1;
        }
        aVar.i_renamed = this.mTransition;
        aVar.j_renamed = this.mTransitionStyle;
        aVar.m_renamed = this.mName;
        aVar.f1132c = this.mIndex;
        aVar.k_renamed = true;
        aVar.n_renamed = this.mBreadCrumbTitleRes;
        aVar.o_renamed = this.mBreadCrumbTitleText;
        aVar.p_renamed = this.mBreadCrumbShortTitleRes;
        aVar.q_renamed = this.mBreadCrumbShortTitleText;
        aVar.r_renamed = this.mSharedElementSourceNames;
        aVar.s_renamed = this.mSharedElementTargetNames;
        aVar.t_renamed = this.mReorderingAllowed;
        aVar.a_renamed(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeIntArray(this.mOps);
        parcel.writeStringList(this.mFragmentWhos);
        parcel.writeIntArray(this.mOldMaxLifecycleStates);
        parcel.writeIntArray(this.mCurrentMaxLifecycleStates);
        parcel.writeInt(this.mTransition);
        parcel.writeInt(this.mTransitionStyle);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        android.text.TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        android.text.TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList(this.mSharedElementSourceNames);
        parcel.writeStringList(this.mSharedElementTargetNames);
        parcel.writeInt(this.mReorderingAllowed ? 1 : 0);
    }
}
