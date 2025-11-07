package androidx.fragment.app;

@android.annotation.SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentManagerState implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<androidx.fragment.app.FragmentManagerState> CREATOR = new android.os.Parcelable.Creator<androidx.fragment.app.FragmentManagerState>() { // from class: androidx.fragment.app.FragmentManagerState.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public androidx.fragment.app.FragmentManagerState createFromParcel(android.os.Parcel parcel) {
            return new androidx.fragment.app.FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public androidx.fragment.app.FragmentManagerState[] newArray(int i_renamed) {
            return new androidx.fragment.app.FragmentManagerState[i_renamed];
        }
    };
    java.util.ArrayList<androidx.fragment.app.FragmentState> mActive;
    java.util.ArrayList<java.lang.String> mAdded;
    androidx.fragment.app.BackStackState[] mBackStack;
    int mNextFragmentIndex;
    java.lang.String mPrimaryNavActiveWho;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FragmentManagerState() {
        this.mPrimaryNavActiveWho = null;
    }

    public FragmentManagerState(android.os.Parcel parcel) {
        this.mPrimaryNavActiveWho = null;
        this.mActive = parcel.createTypedArrayList(androidx.fragment.app.FragmentState.CREATOR);
        this.mAdded = parcel.createStringArrayList();
        this.mBackStack = (androidx.fragment.app.BackStackState[]) parcel.createTypedArray(androidx.fragment.app.BackStackState.CREATOR);
        this.mPrimaryNavActiveWho = parcel.readString();
        this.mNextFragmentIndex = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeTypedList(this.mActive);
        parcel.writeStringList(this.mAdded);
        parcel.writeTypedArray(this.mBackStack, i_renamed);
        parcel.writeString(this.mPrimaryNavActiveWho);
        parcel.writeInt(this.mNextFragmentIndex);
    }
}
