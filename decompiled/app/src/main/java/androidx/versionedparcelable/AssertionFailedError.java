package androidx.versionedparcelable;

/* compiled from: VersionedParcelParcel.java */
/* loaded from: classes.dex */
class b_renamed extends androidx.versionedparcelable.a_renamed {
    private final android.util.SparseIntArray d_renamed;
    private final android.os.Parcel e_renamed;
    private final int f_renamed;
    private final int g_renamed;
    private final java.lang.String h_renamed;
    private int i_renamed;
    private int j_renamed;
    private int k_renamed;

    b_renamed(android.os.Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new androidx.collection.ArrayMap(), new androidx.collection.ArrayMap(), new androidx.collection.ArrayMap());
    }

    private b_renamed(android.os.Parcel parcel, int i_renamed, int i2, java.lang.String str, androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Method> arrayMap, androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Method> arrayMap2, androidx.collection.ArrayMap<java.lang.String, java.lang.Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.d_renamed = new android.util.SparseIntArray();
        this.i_renamed = -1;
        this.j_renamed = 0;
        this.k_renamed = -1;
        this.e_renamed = parcel;
        this.f_renamed = i_renamed;
        this.g_renamed = i2;
        this.j_renamed = this.f_renamed;
        this.h_renamed = str;
    }

    @Override // androidx.versionedparcelable.a_renamed
    public boolean b_renamed(int i_renamed) {
        while (this.j_renamed < this.g_renamed) {
            int i2 = this.k_renamed;
            if (i2 == i_renamed) {
                return true;
            }
            if (java.lang.String.valueOf(i2).compareTo(java.lang.String.valueOf(i_renamed)) > 0) {
                return false;
            }
            this.e_renamed.setDataPosition(this.j_renamed);
            int i3 = this.e_renamed.readInt();
            this.k_renamed = this.e_renamed.readInt();
            this.j_renamed += i3;
        }
        return this.k_renamed == i_renamed;
    }

    @Override // androidx.versionedparcelable.a_renamed
    public void c_renamed(int i_renamed) {
        b_renamed();
        this.i_renamed = i_renamed;
        this.d_renamed.put(i_renamed, this.e_renamed.dataPosition());
        a_renamed(0);
        a_renamed(i_renamed);
    }

    @Override // androidx.versionedparcelable.a_renamed
    public void b_renamed() {
        int i_renamed = this.i_renamed;
        if (i_renamed >= 0) {
            int i2 = this.d_renamed.get(i_renamed);
            int iDataPosition = this.e_renamed.dataPosition();
            this.e_renamed.setDataPosition(i2);
            this.e_renamed.writeInt(iDataPosition - i2);
            this.e_renamed.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a_renamed
    protected androidx.versionedparcelable.a_renamed c_renamed() {
        android.os.Parcel parcel = this.e_renamed;
        int iDataPosition = parcel.dataPosition();
        int i_renamed = this.j_renamed;
        if (i_renamed == this.f_renamed) {
            i_renamed = this.g_renamed;
        }
        return new androidx.versionedparcelable.b_renamed(parcel, iDataPosition, i_renamed, this.h_renamed + "  ", this.f1795a, this.f1796b, this.f1797c);
    }

    @Override // androidx.versionedparcelable.a_renamed
    public void a_renamed(byte[] bArr) {
        if (bArr != null) {
            this.e_renamed.writeInt(bArr.length);
            this.e_renamed.writeByteArray(bArr);
        } else {
            this.e_renamed.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.a_renamed
    public void a_renamed(int i_renamed) {
        this.e_renamed.writeInt(i_renamed);
    }

    @Override // androidx.versionedparcelable.a_renamed
    public void a_renamed(java.lang.String str) {
        this.e_renamed.writeString(str);
    }

    @Override // androidx.versionedparcelable.a_renamed
    public void a_renamed(android.os.Parcelable parcelable) {
        this.e_renamed.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a_renamed
    public void a_renamed(boolean z_renamed) {
        this.e_renamed.writeInt(z_renamed ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.a_renamed
    protected void a_renamed(java.lang.CharSequence charSequence) {
        android.text.TextUtils.writeToParcel(charSequence, this.e_renamed, 0);
    }

    @Override // androidx.versionedparcelable.a_renamed
    protected java.lang.CharSequence g_renamed() {
        return (java.lang.CharSequence) android.text.TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.e_renamed);
    }

    @Override // androidx.versionedparcelable.a_renamed
    public int d_renamed() {
        return this.e_renamed.readInt();
    }

    @Override // androidx.versionedparcelable.a_renamed
    public java.lang.String e_renamed() {
        return this.e_renamed.readString();
    }

    @Override // androidx.versionedparcelable.a_renamed
    public byte[] f_renamed() {
        int i_renamed = this.e_renamed.readInt();
        if (i_renamed < 0) {
            return null;
        }
        byte[] bArr = new byte[i_renamed];
        this.e_renamed.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a_renamed
    public <T_renamed extends android.os.Parcelable> T_renamed h_renamed() {
        return (T_renamed) this.e_renamed.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a_renamed
    public boolean i_renamed() {
        return this.e_renamed.readInt() != 0;
    }
}
