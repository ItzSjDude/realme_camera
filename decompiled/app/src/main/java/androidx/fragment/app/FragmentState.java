package androidx.fragment.app;

@android.annotation.SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentState implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<androidx.fragment.app.FragmentState> CREATOR = new android.os.Parcelable.Creator<androidx.fragment.app.FragmentState>() { // from class: androidx.fragment.app.FragmentState.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public androidx.fragment.app.FragmentState createFromParcel(android.os.Parcel parcel) {
            return new androidx.fragment.app.FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public androidx.fragment.app.FragmentState[] newArray(int i_renamed) {
            return new androidx.fragment.app.FragmentState[i_renamed];
        }
    };
    final android.os.Bundle mArguments;
    final java.lang.String mClassName;
    final int mContainerId;
    final boolean mDetached;
    final int mFragmentId;
    final boolean mFromLayout;
    final boolean mHidden;
    androidx.fragment.app.Fragment mInstance;
    final int mMaxLifecycleState;
    final boolean mRemoving;
    final boolean mRetainInstance;
    android.os.Bundle mSavedFragmentState;
    final java.lang.String mTag;
    final java.lang.String mWho;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    FragmentState(androidx.fragment.app.Fragment fragment) {
        this.mClassName = fragment.getClass().getName();
        this.mWho = fragment.mWho;
        this.mFromLayout = fragment.mFromLayout;
        this.mFragmentId = fragment.mFragmentId;
        this.mContainerId = fragment.mContainerId;
        this.mTag = fragment.mTag;
        this.mRetainInstance = fragment.mRetainInstance;
        this.mRemoving = fragment.mRemoving;
        this.mDetached = fragment.mDetached;
        this.mArguments = fragment.mArguments;
        this.mHidden = fragment.mHidden;
        this.mMaxLifecycleState = fragment.mMaxState.ordinal();
    }

    FragmentState(android.os.Parcel parcel) {
        this.mClassName = parcel.readString();
        this.mWho = parcel.readString();
        this.mFromLayout = parcel.readInt() != 0;
        this.mFragmentId = parcel.readInt();
        this.mContainerId = parcel.readInt();
        this.mTag = parcel.readString();
        this.mRetainInstance = parcel.readInt() != 0;
        this.mRemoving = parcel.readInt() != 0;
        this.mDetached = parcel.readInt() != 0;
        this.mArguments = parcel.readBundle();
        this.mHidden = parcel.readInt() != 0;
        this.mSavedFragmentState = parcel.readBundle();
        this.mMaxLifecycleState = parcel.readInt();
    }

    public androidx.fragment.app.Fragment instantiate(java.lang.ClassLoader classLoader, androidx.fragment.app.f_renamed fVar) {
        if (this.mInstance == null) {
            android.os.Bundle bundle = this.mArguments;
            if (bundle != null) {
                bundle.setClassLoader(classLoader);
            }
            this.mInstance = fVar.c_renamed(classLoader, this.mClassName);
            this.mInstance.setArguments(this.mArguments);
            android.os.Bundle bundle2 = this.mSavedFragmentState;
            if (bundle2 != null) {
                bundle2.setClassLoader(classLoader);
                this.mInstance.mSavedFragmentState = this.mSavedFragmentState;
            } else {
                this.mInstance.mSavedFragmentState = new android.os.Bundle();
            }
            androidx.fragment.app.Fragment fragment = this.mInstance;
            fragment.mWho = this.mWho;
            fragment.mFromLayout = this.mFromLayout;
            fragment.mRestored = true;
            fragment.mFragmentId = this.mFragmentId;
            fragment.mContainerId = this.mContainerId;
            fragment.mTag = this.mTag;
            fragment.mRetainInstance = this.mRetainInstance;
            fragment.mRemoving = this.mRemoving;
            fragment.mDetached = this.mDetached;
            fragment.mHidden = this.mHidden;
            fragment.mMaxState = androidx.lifecycle.e_renamed.b_renamed.values()[this.mMaxLifecycleState];
            if (androidx.fragment.app.i_renamed.f1142b) {
                android.util.Log.v_renamed("FragmentManager", "Instantiated fragment " + this.mInstance);
            }
        }
        return this.mInstance;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.mClassName);
        sb.append(" (");
        sb.append(this.mWho);
        sb.append(")}:");
        if (this.mFromLayout) {
            sb.append(" fromLayout");
        }
        if (this.mContainerId != 0) {
            sb.append(" id_renamed=0x");
            sb.append(java.lang.Integer.toHexString(this.mContainerId));
        }
        java.lang.String str = this.mTag;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        if (this.mRetainInstance) {
            sb.append(" retainInstance");
        }
        if (this.mRemoving) {
            sb.append(" removing");
        }
        if (this.mDetached) {
            sb.append(" detached");
        }
        if (this.mHidden) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.mClassName);
        parcel.writeString(this.mWho);
        parcel.writeInt(this.mFromLayout ? 1 : 0);
        parcel.writeInt(this.mFragmentId);
        parcel.writeInt(this.mContainerId);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.mRetainInstance ? 1 : 0);
        parcel.writeInt(this.mRemoving ? 1 : 0);
        parcel.writeInt(this.mDetached ? 1 : 0);
        parcel.writeBundle(this.mArguments);
        parcel.writeInt(this.mHidden ? 1 : 0);
        parcel.writeBundle(this.mSavedFragmentState);
        parcel.writeInt(this.mMaxLifecycleState);
    }
}
