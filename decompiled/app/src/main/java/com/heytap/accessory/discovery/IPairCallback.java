package com.heytap.accessory.discovery;

/* loaded from: classes2.dex */
public interface IPairCallback {
    byte[] onPairData(com.heytap.accessory.bean.DeviceInfo deviceInfo, android.os.Bundle bundle);

    void onPairFailure(com.heytap.accessory.bean.DeviceInfo deviceInfo, android.os.Bundle bundle);

    void onPairSuccess(com.heytap.accessory.bean.DeviceInfo deviceInfo, android.os.Bundle bundle);

    int onPairTypeReceived(com.heytap.accessory.bean.DeviceInfo deviceInfo, android.os.Bundle bundle);
}
