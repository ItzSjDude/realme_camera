package com.google.android.exoplayer2.video;

/* loaded from: classes.dex */
public final class ColorInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.video.ColorInfo> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.video.ColorInfo>() { // from class: com.google.android.exoplayer2.video.ColorInfo.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.video.ColorInfo createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.video.ColorInfo(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.video.ColorInfo[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.video.ColorInfo[0];
        }
    };
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    private int hashCode;
    public final byte[] hdrStaticInfo;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ColorInfo(int i_renamed, int i2, int i3, byte[] bArr) {
        this.colorSpace = i_renamed;
        this.colorRange = i2;
        this.colorTransfer = i3;
        this.hdrStaticInfo = bArr;
    }

    ColorInfo(android.os.Parcel parcel) {
        this.colorSpace = parcel.readInt();
        this.colorRange = parcel.readInt();
        this.colorTransfer = parcel.readInt();
        this.hdrStaticInfo = com.google.android.exoplayer2.util.Util.readBoolean(parcel) ? parcel.createByteArray() : null;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.video.ColorInfo colorInfo = (com.google.android.exoplayer2.video.ColorInfo) obj;
        return this.colorSpace == colorInfo.colorSpace && this.colorRange == colorInfo.colorRange && this.colorTransfer == colorInfo.colorTransfer && java.util.Arrays.equals(this.hdrStaticInfo, colorInfo.hdrStaticInfo);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("ColorInfo(");
        sb.append(this.colorSpace);
        sb.append(", ");
        sb.append(this.colorRange);
        sb.append(", ");
        sb.append(this.colorTransfer);
        sb.append(", ");
        sb.append(this.hdrStaticInfo != null);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((((((527 + this.colorSpace) * 31) + this.colorRange) * 31) + this.colorTransfer) * 31) + java.util.Arrays.hashCode(this.hdrStaticInfo);
        }
        return this.hashCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(this.colorSpace);
        parcel.writeInt(this.colorRange);
        parcel.writeInt(this.colorTransfer);
        com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.hdrStaticInfo != null);
        byte[] bArr = this.hdrStaticInfo;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
