package com.heytap.accessory.discovery;

/* loaded from: classes2.dex */
public interface IDirectCallback {
    void onPairFailure(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message);

    void onPairSuccess(com.heytap.accessory.bean.DeviceInfo deviceInfo, com.heytap.accessory.bean.Message message);
}
