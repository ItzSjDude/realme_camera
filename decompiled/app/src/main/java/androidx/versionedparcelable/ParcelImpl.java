package androidx.versionedparcelable;

@android.annotation.SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelImpl implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<androidx.versionedparcelable.ParcelImpl> CREATOR = new android.os.Parcelable.Creator<androidx.versionedparcelable.ParcelImpl>() { // from class: androidx.versionedparcelable.ParcelImpl.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public androidx.versionedparcelable.ParcelImpl createFromParcel(android.os.Parcel parcel) {
            return new androidx.versionedparcelable.ParcelImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public androidx.versionedparcelable.ParcelImpl[] newArray(int i_renamed) {
            return new androidx.versionedparcelable.ParcelImpl[i_renamed];
        }
    };
    private final androidx.versionedparcelable.c_renamed mParcel;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelImpl(androidx.versionedparcelable.c_renamed cVar) {
        this.mParcel = cVar;
    }

    protected ParcelImpl(android.os.Parcel parcel) {
        this.mParcel = new androidx.versionedparcelable.b_renamed(parcel).j_renamed();
    }

    public <T_renamed extends androidx.versionedparcelable.c_renamed> T_renamed getVersionedParcel() {
        return (T_renamed) this.mParcel;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        new androidx.versionedparcelable.b_renamed(parcel).a_renamed(this.mParcel);
    }
}
