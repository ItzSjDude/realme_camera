package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class Message implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.heytap.accessory.bean.Message> CREATOR = new android.os.Parcelable.Creator<com.heytap.accessory.bean.Message>() { // from class: com.heytap.accessory.bean.Message.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.Message createFromParcel(android.os.Parcel parcel) {
            return new com.heytap.accessory.bean.Message(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.heytap.accessory.bean.Message[] newArray(int i_renamed) {
            return new com.heytap.accessory.bean.Message[i_renamed];
        }
    };
    public static final java.lang.String INTENT_EXTRA_ADVERTISE_DATA = "extra_advertise_data";
    public static final java.lang.String INTENT_EXTRA_CONNECT_TYPE = "extra_connect_type";
    public static final java.lang.String INTENT_EXTRA_DEVICE_ADDRESS = "extra_device_address";
    public static final java.lang.String INTENT_EXTRA_DEVICE_ID = "extra_device_id";
    public static final java.lang.String INTENT_EXTRA_DEVICE_NAME = "extra_device_name";
    public static final java.lang.String INTENT_EXTRA_KSC_ALIAS = "extra_ksc_alias";
    public static final java.lang.String INTENT_EXTRA_LAUNCH_TYPE = "extra_launch_type";
    public static final java.lang.String INTENT_EXTRA_LOCAL_DEVICE_ID = "extra_local_device_id";
    public static final java.lang.String INTENT_EXTRA_MAJOR_TYPE = "extra_major_type";
    public static final java.lang.String INTENT_EXTRA_NICK_NAME = "extra_nick_name";
    public static final java.lang.String INTENT_EXTRA_PRODUCT_ACTION = "extra_product_action";
    public static final java.lang.String INTENT_EXTRA_PRODUCT_COMPONENT = "extra_product_component";
    public static final java.lang.String INTENT_EXTRA_PRODUCT_TARGET = "extra_product_target";
    public static final java.lang.String INTENT_EXTRA_PRODUCT_VERSION = "extra_product_version";
    public static final java.lang.String INTENT_EXTRA_PROVIDER_IP = "extra_provider_ip";
    public static final java.lang.String INTENT_EXTRA_PROVIDER_MAC = "extra_provider_mac";
    public static final java.lang.String INTENT_EXTRA_PROVIDER_PORT = "extra_provider_port";
    public static final java.lang.String INTENT_EXTRA_RSSI = "extra_rssi";
    public static final java.lang.String INTENT_EXTRA_SEEKER_AS_GO = "extra_seeker_as_go";
    public static final java.lang.String INTENT_EXTRA_SSID = "extra_ssid";
    public static final java.lang.String INTENT_EXTRA_SUB_TYPE = "extra_sub_type";
    public static final java.lang.String KEY_MSG_AUTH_DATA = "key_msg_auth_data";
    public static final java.lang.String KEY_MSG_AUTH_LIMIT_LENGTH = "key_msg_auth_limit_length";
    public static final java.lang.String KEY_MSG_AUTH_MODE = "key_msg_auth_mode";
    public static final java.lang.String KEY_MSG_CONNECT_DATA = "key_msg_connect_data";
    public static final java.lang.String KEY_MSG_ERROR_CODE = "key_msg_error_code";
    public static final java.lang.String KEY_MSG_PAIR_INFO = "key_msg_pair_info";
    public static final java.lang.String KEY_MSG_RDI = "key_msg_rdi";
    public static final java.lang.String KEY_MSG_TYPE_PAIR_TYPE_RECEIVED = "key_msg_type_pair_type_received";
    public static final java.lang.String SDK_VERSION = "sdk_version";
    private android.os.Bundle mBundle;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Message() {
        this.mBundle = new android.os.Bundle();
    }

    public Message(android.os.Bundle bundle) {
        this.mBundle = bundle == null ? new android.os.Bundle() : bundle;
    }

    public android.os.Bundle getBundle() {
        return this.mBundle;
    }

    protected Message(android.os.Parcel parcel) {
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeBundle(this.mBundle);
    }

    public void readFromParcel(android.os.Parcel parcel) {
        this.mBundle = parcel.readBundle(getClass().getClassLoader());
    }
}
