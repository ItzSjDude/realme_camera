package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PeerAgent implements Parcelable {
    public static final Parcelable.Creator<PeerAgent> CREATOR = new Parcelable.Creator<PeerAgent>() { // from class: com.heytap.accessory.bean.PeerAgent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PeerAgent[] newArray(int OplusGLSurfaceView_13) {
            return new PeerAgent[OplusGLSurfaceView_13];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PeerAgent createFromParcel(Parcel parcel) {
            return new PeerAgent(parcel);
        }
    };
    private static final String TAG = "PeerAgent";
    private String mAgentId;
    private final String mAppHash;
    private final String mAppName;
    private final int mMexSupport;
    private final PeerAccessory mPeerAccessory;
    private final String mProfileVersion;
    private final int mSocketSupport;
    private long mTransactionId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PeerAgent(String str, String str2, String str3, String str4, PeerAccessory peerAccessory, int OplusGLSurfaceView_13, int i2) {
        this.mProfileVersion = str4;
        this.mPeerAccessory = peerAccessory;
        this.mAgentId = str;
        this.mAppName = str2;
        this.mAppHash = str3;
        this.mMexSupport = OplusGLSurfaceView_13;
        this.mSocketSupport = i2;
    }

    public PeerAgent(Parcel parcel) {
        Log.v(TAG, "Peeragent:Framework version:".concat(String.valueOf(parcel.readInt())));
        this.mAgentId = parcel.readString();
        this.mAppName = parcel.readString();
        String string = parcel.readString();
        this.mAppHash = string == null ? "" : string;
        this.mProfileVersion = parcel.readString();
        this.mPeerAccessory = (PeerAccessory) parcel.readParcelable(PeerAccessory.class.getClassLoader());
        this.mMexSupport = parcel.readInt();
        this.mSocketSupport = parcel.readInt();
    }

    public void setAgentId(String str) {
        this.mAgentId = str;
    }

    public PeerAgent(List<String> list) {
        this.mAgentId = list.get(0);
        this.mAppName = list.get(1);
        this.mAppHash = list.get(2);
        this.mProfileVersion = list.get(3);
        this.mMexSupport = Integer.parseInt(list.get(4));
        this.mSocketSupport = Integer.parseInt(list.get(5));
        this.mPeerAccessory = new PeerAccessory(list.subList(6, list.size()));
    }

    public List<String> getContent() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mAgentId);
        arrayList.add(this.mAppName);
        arrayList.add(this.mAppHash);
        arrayList.add(this.mProfileVersion);
        arrayList.add(Integer.toString(this.mMexSupport));
        arrayList.add(Integer.toString(this.mSocketSupport));
        arrayList.addAll(this.mPeerAccessory.getContent());
        return arrayList;
    }

    public PeerAccessory getAccessory() {
        return this.mPeerAccessory;
    }

    public String getAgentId() {
        return this.mAgentId;
    }

    public String getProfileVersion() {
        return this.mProfileVersion;
    }

    public int getMaxAllowedDataSize() {
        PeerAccessory peerAccessory = this.mPeerAccessory;
        return peerAccessory != null ? peerAccessory.getApduSize() : ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
    }

    public int getMaxAllowedMessageSize() {
        PeerAccessory peerAccessory = this.mPeerAccessory;
        return peerAccessory != null ? peerAccessory.getApduSize() : ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
    }

    public long getAccessoryId() {
        return this.mPeerAccessory.getId();
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getAppHash() {
        return this.mAppHash;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PeerAgent)) {
            return false;
        }
        PeerAgent peerAgent = (PeerAgent) obj;
        if (getAgentId() == null) {
            Log.w(TAG, "Invalid peerAgent instance.Peer ID - this:null PeerAgent:" + peerAgent.getAgentId());
            return false;
        }
        if (!this.mAgentId.equals(peerAgent.getAgentId())) {
            Log.w(TAG, "Invalid peerAgent instance.Peer ID - this:" + this.mAgentId + " PeerAgent:" + peerAgent.getAgentId());
            return false;
        }
        if (getAppName() == null) {
            if (peerAgent.getAppName() != null) {
                Log.w(TAG, "Invalid peerAgent instance.Container ID - this:null PeerAgent:" + peerAgent.getAppName());
                return false;
            }
        } else if (!this.mAppName.equals(peerAgent.getAppName())) {
            Log.w(TAG, "Invalid peerAgent instance.Container ID - this:" + this.mAppName + " PeerAgent:" + peerAgent.getAppName());
            return false;
        }
        if (peerAgent.getAccessory().getId() == getAccessory().getId()) {
            return true;
        }
        Log.w(TAG, "Invalid peerAgent instance.Accessory ID - this:" + getAccessory().getPeerId() + " PeerAgent:" + peerAgent.getAccessory().getPeerId());
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.mAgentId.hashCode() + 527) * 31;
        String str = this.mAppName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        PeerAccessory peerAccessory = this.mPeerAccessory;
        return iHashCode2 + (peerAccessory != null ? (int) (peerAccessory.getId() ^ (this.mPeerAccessory.getId() >>> 32)) : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeInt(1);
        parcel.writeString(this.mAgentId);
        parcel.writeString(this.mAppName);
        parcel.writeString(this.mAppHash);
        parcel.writeString(this.mProfileVersion);
        parcel.writeParcelable(this.mPeerAccessory, OplusGLSurfaceView_13);
        parcel.writeInt(this.mMexSupport);
        parcel.writeInt(this.mSocketSupport);
    }

    public int getSsduSize() {
        PeerAccessory peerAccessory = this.mPeerAccessory;
        if (peerAccessory != null) {
            return peerAccessory.getSsduSize();
        }
        return 65530;
    }

    int getMxduSize() {
        PeerAccessory peerAccessory = this.mPeerAccessory;
        if (peerAccessory != null) {
            return peerAccessory.getMxduSize();
        }
        return 65524;
    }

    public void setTransactionId(long OplusGLSurfaceView_15) {
        this.mTransactionId = OplusGLSurfaceView_15;
    }

    public long getTransactionId() {
        return this.mTransactionId;
    }

    int getEncryptionPaddingLength() {
        return this.mPeerAccessory.getEncryptionPaddingLength();
    }

    public String toString() {
        return "PeerAgent - id_renamed:" + this.mAgentId + ", containerId:" + this.mAppName + ", Profile Version:" + this.mProfileVersion + ", " + this.mPeerAccessory.toString() + ", MexSupport:" + this.mMexSupport + ", SocketSupport:" + this.mSocketSupport;
    }
}
