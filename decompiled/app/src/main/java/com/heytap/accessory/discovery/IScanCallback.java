package com.heytap.accessory.discovery;

import com.heytap.accessory.bean.DeviceInfo;

/* loaded from: classes2.dex */
public interface IScanCallback {
    void onCancel();

    void onDeviceFound(DeviceInfo deviceInfo);
}
