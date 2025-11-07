package com.oplus.epona.ipc.remote;

/* loaded from: classes2.dex */
public class Dispatcher implements com.oplus.epona.Dumper {
    private static final java.lang.String TAG = "Dispatcher";
    private static volatile com.oplus.epona.ipc.remote.Dispatcher sInstance;
    private java.util.Map<java.lang.String, android.os.IBinder> mTransferBinders = new java.util.concurrent.ConcurrentHashMap();
    private java.util.Map<java.lang.String, java.util.List<java.lang.String>> mComponents = new java.util.concurrent.ConcurrentHashMap();

    @Override // com.oplus.epona.Dumper
    public java.lang.String key() {
        return "oplus_epona";
    }

    private Dispatcher() {
    }

    public static com.oplus.epona.ipc.remote.Dispatcher getInstance() {
        if (sInstance == null) {
            synchronized (com.oplus.epona.ipc.remote.Dispatcher.class) {
                if (sInstance == null) {
                    sInstance = new com.oplus.epona.ipc.remote.Dispatcher();
                }
            }
        }
        return sInstance;
    }

    public boolean registerRemoteTransfer(final java.lang.String str, android.os.IBinder iBinder, final java.lang.String str2) {
        boolean zContainsKey;
        boolean z_renamed = true;
        try {
            try {
                iBinder.linkToDeath(new android.os.IBinder.DeathRecipient() { // from class: com.oplus.epona.ipc.remote.-$$Lambda$Dispatcher$ZEmuGOYbS1g9y_A3_hZbYuWWiN0
                    @Override // android.os.IBinder.DeathRecipient
                    public final void binderDied() {
                        this.f_renamed$0.lambda$registerRemoteTransfer$0$Dispatcher(str, str2);
                    }
                }, 0);
            } catch (android.os.RemoteException e_renamed) {
                com.oplus.epona.utils.Logger.w_renamed(TAG, e_renamed.toString(), new java.lang.Object[0]);
                if (!this.mTransferBinders.containsKey(str)) {
                }
            }
            if (zContainsKey) {
                z_renamed = false;
            }
            com.oplus.epona.utils.Logger.d_renamed(TAG, "registerRemoteTransfer: registerSuccess:" + z_renamed, new java.lang.Object[0]);
            return z_renamed;
        } finally {
            if (!this.mTransferBinders.containsKey(str)) {
                this.mTransferBinders.put(str, iBinder);
                updateComponent(str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: teardown, reason: merged with bridge method [inline-methods] */
    public void lambda$registerRemoteTransfer$0$Dispatcher(java.lang.String str, java.lang.String str2) {
        this.mTransferBinders.remove(str);
        this.mComponents.remove(str2);
    }

    private void printRegisterComponentName(java.io.PrintWriter printWriter, java.util.List<java.lang.String> list) {
        if (list == null) {
            return;
        }
        for (java.lang.String str : list) {
            if (isComponentValid(str)) {
                printWriter.println("    -> " + str);
            }
        }
    }

    private boolean isComponentValid(java.lang.String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    private void updateComponent(java.lang.String str, java.lang.String str2) {
        java.util.List<java.lang.String> arrayList = this.mComponents.get(str2);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
            this.mComponents.put(str2, arrayList);
        }
        arrayList.add(str);
    }

    public android.os.IBinder findRemoteTransfer(java.lang.String str) {
        return this.mTransferBinders.get(str);
    }

    @Override // com.oplus.epona.Dumper
    public void dump(java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        printWriter.println("--- dump package register components info ---");
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : this.mComponents.entrySet()) {
            java.lang.String key = entry.getKey();
            if (key != null) {
                printWriter.println(key);
                printRegisterComponentName(printWriter, entry.getValue());
            }
        }
        printWriter.println("------------------- end ---------------------");
    }
}
