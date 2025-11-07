package com.google.android.exoplayer2.drm;

/* loaded from: classes.dex */
public final class DrmInitData implements android.os.Parcelable, java.util.Comparator<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.drm.DrmInitData> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.drm.DrmInitData>() { // from class: com.google.android.exoplayer2.drm.DrmInitData.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.drm.DrmInitData createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.drm.DrmInitData(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.drm.DrmInitData[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.drm.DrmInitData[i_renamed];
        }
    };
    private int hashCode;
    public final int schemeDataCount;
    private final com.google.android.exoplayer2.drm.DrmInitData.SchemeData[] schemeDatas;
    public final java.lang.String schemeType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static com.google.android.exoplayer2.drm.DrmInitData createSessionCreationData(com.google.android.exoplayer2.drm.DrmInitData drmInitData, com.google.android.exoplayer2.drm.DrmInitData drmInitData2) {
        java.lang.String str;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (drmInitData != null) {
            str = drmInitData.schemeType;
            for (com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData : drmInitData.schemeDatas) {
                if (schemeData.hasData()) {
                    arrayList.add(schemeData);
                }
            }
        } else {
            str = null;
        }
        if (drmInitData2 != null) {
            if (str == null) {
                str = drmInitData2.schemeType;
            }
            int size = arrayList.size();
            for (com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData2 : drmInitData2.schemeDatas) {
                if (schemeData2.hasData() && !containsSchemeDataWithUuid(arrayList, size, schemeData2.uuid)) {
                    arrayList.add(schemeData2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.google.android.exoplayer2.drm.DrmInitData(str, arrayList);
    }

    public DrmInitData(java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list) {
        this(null, false, (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) list.toArray(new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[list.size()]));
    }

    public DrmInitData(java.lang.String str, java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> list) {
        this(str, false, (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) list.toArray(new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[list.size()]));
    }

    public DrmInitData(com.google.android.exoplayer2.drm.DrmInitData.SchemeData... schemeDataArr) {
        this((java.lang.String) null, schemeDataArr);
    }

    public DrmInitData(java.lang.String str, com.google.android.exoplayer2.drm.DrmInitData.SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    private DrmInitData(java.lang.String str, boolean z_renamed, com.google.android.exoplayer2.drm.DrmInitData.SchemeData... schemeDataArr) {
        this.schemeType = str;
        schemeDataArr = z_renamed ? (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        java.util.Arrays.sort(schemeDataArr, this);
        this.schemeDatas = schemeDataArr;
        this.schemeDataCount = schemeDataArr.length;
    }

    DrmInitData(android.os.Parcel parcel) {
        this.schemeType = parcel.readString();
        this.schemeDatas = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) parcel.createTypedArray(com.google.android.exoplayer2.drm.DrmInitData.SchemeData.CREATOR);
        this.schemeDataCount = this.schemeDatas.length;
    }

    @java.lang.Deprecated
    public com.google.android.exoplayer2.drm.DrmInitData.SchemeData get(java.util.UUID uuid) {
        for (com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData : this.schemeDatas) {
            if (schemeData.matches(uuid)) {
                return schemeData;
            }
        }
        return null;
    }

    public com.google.android.exoplayer2.drm.DrmInitData.SchemeData get(int i_renamed) {
        return this.schemeDatas[i_renamed];
    }

    public com.google.android.exoplayer2.drm.DrmInitData copyWithSchemeType(java.lang.String str) {
        return com.google.android.exoplayer2.util.Util.areEqual(this.schemeType, str) ? this : new com.google.android.exoplayer2.drm.DrmInitData(str, false, this.schemeDatas);
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            java.lang.String str = this.schemeType;
            this.hashCode = ((str == null ? 0 : str.hashCode()) * 31) + java.util.Arrays.hashCode(this.schemeDatas);
        }
        return this.hashCode;
    }

    @Override // java.util.Comparator
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.drm.DrmInitData drmInitData = (com.google.android.exoplayer2.drm.DrmInitData) obj;
        return com.google.android.exoplayer2.util.Util.areEqual(this.schemeType, drmInitData.schemeType) && java.util.Arrays.equals(this.schemeDatas, drmInitData.schemeDatas);
    }

    @Override // java.util.Comparator
    public int compare(com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData, com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData2) {
        if (com.google.android.exoplayer2.C_renamed.UUID_NIL.equals(schemeData.uuid)) {
            return com.google.android.exoplayer2.C_renamed.UUID_NIL.equals(schemeData2.uuid) ? 0 : 1;
        }
        return schemeData.uuid.compareTo(schemeData2.uuid);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.schemeType);
        parcel.writeTypedArray(this.schemeDatas, 0);
    }

    private static boolean containsSchemeDataWithUuid(java.util.ArrayList<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> arrayList, int i_renamed, java.util.UUID uuid) {
        for (int i2 = 0; i2 < i_renamed; i2++) {
            if (arrayList.get(i2).uuid.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public static final class SchemeData implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.drm.DrmInitData.SchemeData>() { // from class: com.google.android.exoplayer2.drm.DrmInitData.SchemeData.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.google.android.exoplayer2.drm.DrmInitData.SchemeData createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(parcel);
            }

            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.google.android.exoplayer2.drm.DrmInitData.SchemeData[] newArray(int i_renamed) {
                return new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[i_renamed];
            }
        };
        public final byte[] data;
        private int hashCode;
        public final java.lang.String licenseServerUrl;
        public final java.lang.String mimeType;
        public final boolean requiresSecureDecryption;
        private final java.util.UUID uuid;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SchemeData(java.util.UUID uuid, java.lang.String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        public SchemeData(java.util.UUID uuid, java.lang.String str, byte[] bArr, boolean z_renamed) {
            this(uuid, null, str, bArr, z_renamed);
        }

        public SchemeData(java.util.UUID uuid, java.lang.String str, java.lang.String str2, byte[] bArr, boolean z_renamed) {
            this.uuid = (java.util.UUID) com.google.android.exoplayer2.util.Assertions.checkNotNull(uuid);
            this.licenseServerUrl = str;
            this.mimeType = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(str2);
            this.data = bArr;
            this.requiresSecureDecryption = z_renamed;
        }

        SchemeData(android.os.Parcel parcel) {
            this.uuid = new java.util.UUID(parcel.readLong(), parcel.readLong());
            this.licenseServerUrl = parcel.readString();
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.requiresSecureDecryption = parcel.readByte() != 0;
        }

        public boolean matches(java.util.UUID uuid) {
            return com.google.android.exoplayer2.C_renamed.UUID_NIL.equals(this.uuid) || uuid.equals(this.uuid);
        }

        public boolean canReplace(com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData) {
            return hasData() && !schemeData.hasData() && matches(schemeData.uuid);
        }

        public boolean hasData() {
            return this.data != null;
        }

        public com.google.android.exoplayer2.drm.DrmInitData.SchemeData copyWithData(byte[] bArr) {
            return new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(this.uuid, this.licenseServerUrl, this.mimeType, bArr, this.requiresSecureDecryption);
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof com.google.android.exoplayer2.drm.DrmInitData.SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData) obj;
            return com.google.android.exoplayer2.util.Util.areEqual(this.licenseServerUrl, schemeData.licenseServerUrl) && com.google.android.exoplayer2.util.Util.areEqual(this.mimeType, schemeData.mimeType) && com.google.android.exoplayer2.util.Util.areEqual(this.uuid, schemeData.uuid) && java.util.Arrays.equals(this.data, schemeData.data);
        }

        public int hashCode() {
            if (this.hashCode == 0) {
                int iHashCode = this.uuid.hashCode() * 31;
                java.lang.String str = this.licenseServerUrl;
                this.hashCode = ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.mimeType.hashCode()) * 31) + java.util.Arrays.hashCode(this.data);
            }
            return this.hashCode;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.licenseServerUrl);
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte(this.requiresSecureDecryption ? (byte) 1 : (byte) 0);
        }
    }
}
