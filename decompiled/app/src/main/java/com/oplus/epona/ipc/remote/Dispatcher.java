package com.oplus.epona.ipc.remote;

import android.os.IBinder;
import android.os.RemoteException;
import com.oplus.epona.Dumper;
import com.oplus.epona.utils.Logger;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class Dispatcher implements Dumper {
    private static final String TAG = "Dispatcher";
    private static volatile Dispatcher sInstance;
    private Map<String, IBinder> mTransferBinders = new ConcurrentHashMap();
    private Map<String, List<String>> mComponents = new ConcurrentHashMap();

    @Override // com.oplus.epona.Dumper
    public String key() {
        return "oplus_epona";
    }

    private Dispatcher() {
    }

    public static Dispatcher getInstance() {
        if (sInstance == null) {
            synchronized (Dispatcher.class) {
                if (sInstance == null) {
                    sInstance = new Dispatcher();
                }
            }
        }
        return sInstance;
    }

    public boolean registerRemoteTransfer(final String str, IBinder iBinder, final String str2) {
        boolean zContainsKey;
        boolean z = true;
        try {
            try {
                iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.oplus.epona.ipc.remote.-$$Lambda$Dispatcher$ZEmuGOYbS1g9y_A3_hZbYuWWiN0
                    @Override // android.os.IBinder.DeathRecipient
                    public final void binderDied() {
                        this.COUIBaseListPopupWindow_12$0.lambda$registerRemoteTransfer$0$Dispatcher(str, str2);
                    }
                }, 0);
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                Logger.m25002w(TAG, COUIBaseListPopupWindow_8.toString(), new Object[0]);
                if (!this.mTransferBinders.containsKey(str)) {
                }
            }
            if (zContainsKey) {
                z = false;
            }
            Logger.m24999d(TAG, "registerRemoteTransfer: registerSuccess:" + z, new Object[0]);
            return z;
        } finally {
            if (!this.mTransferBinders.containsKey(str)) {
                this.mTransferBinders.put(str, iBinder);
                updateComponent(str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: teardown, reason: merged with bridge method [inline-methods] */
    public void lambda$registerRemoteTransfer$0$Dispatcher(String str, String str2) {
        this.mTransferBinders.remove(str);
        this.mComponents.remove(str2);
    }

    private void printRegisterComponentName(PrintWriter printWriter, List<String> list) {
        if (list == null) {
            return;
        }
        for (String str : list) {
            if (isComponentValid(str)) {
                printWriter.println("    -> " + str);
            }
        }
    }

    private boolean isComponentValid(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    private void updateComponent(String str, String str2) {
        List<String> arrayList = this.mComponents.get(str2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.mComponents.put(str2, arrayList);
        }
        arrayList.add(str);
    }

    public IBinder findRemoteTransfer(String str) {
        return this.mTransferBinders.get(str);
    }

    @Override // com.oplus.epona.Dumper
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.println("--- dump package register components info ---");
        for (Map.Entry<String, List<String>> entry : this.mComponents.entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                printWriter.println(key);
                printRegisterComponentName(printWriter, entry.getValue());
            }
        }
        printWriter.println("------------------- end ---------------------");
    }
}
