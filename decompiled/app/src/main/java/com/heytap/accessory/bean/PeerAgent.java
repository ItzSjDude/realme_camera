package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class PeerAgent implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.PeerAgent> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.PeerAgent>() { // from class: com.heytap.accessory.bean.PeerAgent.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.PeerAgent[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.PeerAgent[i_renamed];
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.PeerAgent createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.PeerAgent(parcel);
        }
    };
    private static final java.lang.String TAG = "PeerAgent";
    private java.lang.String mAgentId;
    private final java.lang.String mAppHash;
    private final java.lang.String mAppName;
    private final int mMexSupport;
    private final com.heytap.accessory.bean.PeerAccessory mPeerAccessory;
    private final java.lang.String mProfileVersion;
    private final int mSocketSupport;
    private long mTransactionId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PeerAgent(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.heytap.accessory.bean.PeerAccessory peerAccessory, int i_renamed, int i2) {
        this.mProfileVersion = str4;
        this.mPeerAccessory = peerAccessory;
        this.mAgentId = str;
        this.mAppName = str2;
        this.mAppHash = str3;
        this.mMexSupport = i_renamed;
        this.mSocketSupport = i2;
    }

    public PeerAgent(android.os.Parcel parcel) {
        android.util.Log.v_renamed(TAG, "Peeragent:Framework version:".concat(java.lang.String.valueOf(parcel.readInt())));
        this.mAgentId = parcel.readString();
        this.mAppName = parcel.readString();
        java.lang.String string = parcel.readString();
        this.mAppHash = string == null ? "" : string;
        this.mProfileVersion = parcel.readString();
        this.mPeerAccessory = (com.heytap.accessory.bean.PeerAccessory) parcel.readParcelable(com.heytap.accessory.bean.PeerAccessory.class.getClassLoader());
        this.mMexSupport = parcel.readInt();
        this.mSocketSupport = parcel.readInt();
    }

    public void setAgentId(java.lang.String str) {
        this.mAgentId = str;
    }

    public PeerAgent(java.util.List<java.lang.String> list) {
        this.mAgentId = list.get(0);
        this.mAppName = list.get(1);
        this.mAppHash = list.get(2);
        this.mProfileVersion = list.get(3);
        this.mMexSupport = java.lang.Integer.parseInt(list.get(4));
        this.mSocketSupport = java.lang.Integer.parseInt(list.get(5));
        this.mPeerAccessory = new com.heytap.accessory.bean.PeerAccessory(list.subList(6, list.size()));
    }

    public java.util.List<java.lang.String> getContent() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(this.mAgentId);
        arrayList.add(this.mAppName);
        arrayList.add(this.mAppHash);
        arrayList.add(this.mProfileVersion);
        arrayList.add(java.lang.Integer.toString(this.mMexSupport));
        arrayList.add(java.lang.Integer.toString(this.mSocketSupport));
        arrayList.addAll(this.mPeerAccessory.getContent());
        return arrayList;
    }

    public com.heytap.accessory.bean.PeerAccessory getAccessory() {
        return this.mPeerAccessory;
    }

    public java.lang.String getAgentId() {
        return this.mAgentId;
    }

    public java.lang.String getProfileVersion() {
        return this.mProfileVersion;
    }

    public int getMaxAllowedDataSize() {
        com.heytap.accessory.bean.PeerAccessory peerAccessory = this.mPeerAccessory;
        return peerAccessory != null ? peerAccessory.getApduSize() : com.google.android.exoplayer2.source.ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
    }

    public int getMaxAllowedMessageSize() {
        com.heytap.accessory.bean.PeerAccessory peerAccessory = this.mPeerAccessory;
        return peerAccessory != null ? peerAccessory.getApduSize() : com.google.android.exoplayer2.source.ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
    }

    public long getAccessoryId() {
        return this.mPeerAccessory.getId();
    }

    public java.lang.String getAppName() {
        return this.mAppName;
    }

    public java.lang.String getAppHash() {
        return this.mAppHash;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null || !(obj instanceof com.heytap.accessory.bean.PeerAgent)) {
            return false;
        }
        com.heytap.accessory.bean.PeerAgent peerAgent = (com.heytap.accessory.bean.PeerAgent) obj;
        if (getAgentId() == null) {
            android.util.Log.w_renamed(TAG, "Invalid peerAgent instance.Peer ID_renamed - this:null PeerAgent:" + peerAgent.getAgentId());
            return false;
        }
        if (!this.mAgentId.equals(peerAgent.getAgentId())) {
            android.util.Log.w_renamed(TAG, "Invalid peerAgent instance.Peer ID_renamed - this:" + this.mAgentId + " PeerAgent:" + peerAgent.getAgentId());
            return false;
        }
        if (getAppName() == null) {
            if (peerAgent.getAppName() != null) {
                android.util.Log.w_renamed(TAG, "Invalid peerAgent instance.Container ID_renamed - this:null PeerAgent:" + peerAgent.getAppName());
                return false;
            }
        } else if (!this.mAppName.equals(peerAgent.getAppName())) {
            android.util.Log.w_renamed(TAG, "Invalid peerAgent instance.Container ID_renamed - this:" + this.mAppName + " PeerAgent:" + peerAgent.getAppName());
            return false;
        }
        if (peerAgent.getAccessory().getId() == getAccessory().getId()) {
            return true;
        }
        android.util.Log.w_renamed(TAG, "Invalid peerAgent instance.Accessory ID_renamed - this:" + getAccessory().getPeerId() + " PeerAgent:" + peerAgent.getAccessory().getPeerId());
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.mAgentId.hashCode() + 527) * 31;
        java.lang.String str = this.mAppName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        com.heytap.accessory.bean.PeerAccessory peerAccessory = this.mPeerAccessory;
        return iHashCode2 + (peerAccessory != null ? (int) (peerAccessory.getId() ^ (this.mPeerAccessory.getId() >>> 32)) : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(1);
        parcel.writeString(this.mAgentId);
        parcel.writeString(this.mAppName);
        parcel.writeString(this.mAppHash);
        parcel.writeString(this.mProfileVersion);
        parcel.writeParcelable(this.mPeerAccessory, i_renamed);
        parcel.writeInt(this.mMexSupport);
        parcel.writeInt(this.mSocketSupport);
    }

    public int getSsduSize() {
        com.heytap.accessory.bean.PeerAccessory peerAccessory = this.mPeerAccessory;
        if (peerAccessory != null) {
            return peerAccessory.getSsduSize();
        }
        return 65530;
    }

    int getMxduSize() {
        com.heytap.accessory.bean.PeerAccessory peerAccessory = this.mPeerAccessory;
        if (peerAccessory != null) {
            return peerAccessory.getMxduSize();
        }
        return 65524;
    }

    public void setTransactionId(long j_renamed) {
        this.mTransactionId = j_renamed;
    }

    public long getTransactionId() {
        return this.mTransactionId;
    }

    int getEncryptionPaddingLength() {
        return this.mPeerAccessory.getEncryptionPaddingLength();
    }

    public java.lang.String toString() {
        return "PeerAgent - id_renamed:" + this.mAgentId + ", containerId:" + this.mAppName + ", Profile Version:" + this.mProfileVersion + ", " + this.mPeerAccessory.toString() + ", MexSupport:" + this.mMexSupport + ", SocketSupport:" + this.mSocketSupport;
    }
}
