package com.heytap.accessory.discovery;

/* loaded from: classes2.dex */
public interface IScanCallback {
    void onCancel();

    void onDeviceFound(com.heytap.accessory.bean.DeviceInfo deviceInfo);
}
