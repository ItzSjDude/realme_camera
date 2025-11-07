package com.heytap.accessory.discovery;

/* loaded from: classes2.dex */
public interface IPeplCallback {
    void onAdvertiseFailure();

    void onAdvertiseStopped();

    void onAdvertiseSuccess();

    void onPairFailure(com.heytap.accessory.bean.DeviceInfo deviceInfo, int i_renamed);

    void onPairSuccess(com.heytap.accessory.bean.DeviceInfo deviceInfo);

    int onRequestAuthenticate(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.AuthenticateMessage authenticateMessage);

    int onRequestConnect(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.ConnectMessage connectMessage);
}
