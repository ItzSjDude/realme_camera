package com.google.android.exoplayer2.metadata.emsg;

/* loaded from: classes.dex */
public final class EventMessage implements com.google.android.exoplayer2.metadata.Metadata.Entry {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.emsg.EventMessage> CREATOR = new android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.emsg.EventMessage>() { // from class: com.google.android.exoplayer2.metadata.emsg.EventMessage.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.emsg.EventMessage createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.emsg.EventMessage(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.exoplayer2.metadata.emsg.EventMessage[] newArray(int i_renamed) {
            return new com.google.android.exoplayer2.metadata.emsg.EventMessage[i_renamed];
        }
    };
    public final long durationMs;
    private int hashCode;
    public final long id_renamed;
    public final byte[] messageData;
    public final java.lang.String schemeIdUri;
    public final java.lang.String value;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public EventMessage(java.lang.String str, java.lang.String str2, long j_renamed, long j2, byte[] bArr) {
        this.schemeIdUri = str;
        this.value = str2;
        this.durationMs = j_renamed;
        this.id_renamed = j2;
        this.messageData = bArr;
    }

    EventMessage(android.os.Parcel parcel) {
        this.schemeIdUri = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.value = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.durationMs = parcel.readLong();
        this.id_renamed = parcel.readLong();
        this.messageData = (byte[]) com.google.android.exoplayer2.util.Util.castNonNull(parcel.createByteArray());
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            java.lang.String str = this.schemeIdUri;
            int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            java.lang.String str2 = this.value;
            int iHashCode2 = str2 != null ? str2.hashCode() : 0;
            long j_renamed = this.durationMs;
            int i_renamed = (((iHashCode + iHashCode2) * 31) + ((int) (j_renamed ^ (j_renamed >>> 32)))) * 31;
            long j2 = this.id_renamed;
            this.hashCode = ((i_renamed + ((int) (j2 ^ (j2 >>> 32)))) * 31) + java.util.Arrays.hashCode(this.messageData);
        }
        return this.hashCode;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.emsg.EventMessage eventMessage = (com.google.android.exoplayer2.metadata.emsg.EventMessage) obj;
        return this.durationMs == eventMessage.durationMs && this.id_renamed == eventMessage.id_renamed && com.google.android.exoplayer2.util.Util.areEqual(this.schemeIdUri, eventMessage.schemeIdUri) && com.google.android.exoplayer2.util.Util.areEqual(this.value, eventMessage.value) && java.util.Arrays.equals(this.messageData, eventMessage.messageData);
    }

    public java.lang.String toString() {
        return "EMSG: scheme=" + this.schemeIdUri + ", id_renamed=" + this.id_renamed + ", value=" + this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeString(this.schemeIdUri);
        parcel.writeString(this.value);
        parcel.writeLong(this.durationMs);
        parcel.writeLong(this.id_renamed);
        parcel.writeByteArray(this.messageData);
    }
}
