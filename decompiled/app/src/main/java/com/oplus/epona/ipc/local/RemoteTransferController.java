package com.oplus.epona.ipc.local;

import android.os.IBinder;

/* loaded from: classes2.dex */
public interface RemoteTransferController {
    IBinder fetch(String str);

    void register(String str, String str2, IBinder iBinder);
}
