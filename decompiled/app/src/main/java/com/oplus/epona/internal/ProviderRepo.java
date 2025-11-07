package com.oplus.epona.internal;

/* loaded from: classes2.dex */
public class ProviderRepo implements com.oplus.epona.Repo {
    private static final java.lang.String TAG = "ProviderRepo";
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.oplus.epona.DynamicProvider> mDynamicProviders = new java.util.concurrent.ConcurrentHashMap<>();
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.oplus.epona.provider.ProviderInfo> mProviders = new java.util.concurrent.ConcurrentHashMap<>();
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.oplus.epona.route.RouteInfo> mRoutes = new java.util.concurrent.ConcurrentHashMap<>();

    private boolean isValid(com.oplus.epona.DynamicProvider dynamicProvider) {
        return (dynamicProvider == null || android.text.TextUtils.isEmpty(dynamicProvider.getName())) ? false : true;
    }

    private boolean isValid(com.oplus.epona.provider.ProviderInfo providerInfo) {
        return (providerInfo == null || android.text.TextUtils.isEmpty(providerInfo.getName())) ? false : true;
    }

    private boolean isValid(com.oplus.epona.route.RouteInfo routeInfo) {
        return (routeInfo == null || android.text.TextUtils.isEmpty(routeInfo.getPath())) ? false : true;
    }

    @Override // com.oplus.epona.Repo
    public void registerProvider(com.oplus.epona.DynamicProvider dynamicProvider) {
        if (isValid(dynamicProvider)) {
            com.oplus.epona.utils.Logger.d_renamed(TAG, "register dynamic provider %s_renamed needIPC = %s_renamed", dynamicProvider.getName(), java.lang.Boolean.valueOf(dynamicProvider.needIPC()));
            this.mDynamicProviders.put(dynamicProvider.getName(), dynamicProvider);
            if (dynamicProvider.needIPC()) {
                registerProviderToRemote(dynamicProvider.getName(), dynamicProvider.getClass().getCanonicalName());
            }
        }
    }

    @Override // com.oplus.epona.Repo
    public void unRegisterProvider(com.oplus.epona.DynamicProvider dynamicProvider) {
        if (isValid(dynamicProvider)) {
            com.oplus.epona.utils.Logger.d_renamed(TAG, "unregister dynamic provider %s_renamed", dynamicProvider.getName());
            this.mDynamicProviders.remove(dynamicProvider.getName());
        }
    }

    @Override // com.oplus.epona.Repo
    public com.oplus.epona.DynamicProvider findProvider(java.lang.String str) {
        return this.mDynamicProviders.get(str);
    }

    @Override // com.oplus.epona.Repo
    public void registerProviderInfo(com.oplus.epona.provider.ProviderInfo providerInfo) {
        if (isValid(providerInfo)) {
            com.oplus.epona.utils.Logger.d_renamed(TAG, "register static provider %s_renamed needIPC = %s_renamed", providerInfo.getName(), java.lang.Boolean.valueOf(providerInfo.needIPC()));
            this.mProviders.put(providerInfo.getName(), providerInfo);
            if (providerInfo.needIPC()) {
                registerProviderToRemote(providerInfo.getName(), providerInfo.getClassName());
            }
        }
    }

    @Override // com.oplus.epona.Repo
    public void unRegisterProviderInfo(com.oplus.epona.provider.ProviderInfo providerInfo) {
        if (isValid(providerInfo)) {
            com.oplus.epona.utils.Logger.d_renamed(TAG, "unregister static provider %s_renamed", providerInfo.getName());
            this.mProviders.remove(providerInfo.getName());
        }
    }

    @Override // com.oplus.epona.Repo
    public com.oplus.epona.provider.ProviderInfo findProviderProviderInfo(java.lang.String str) {
        return this.mProviders.get(str);
    }

    @Override // com.oplus.epona.Repo
    public void registerRouteInfo(com.oplus.epona.route.RouteInfo routeInfo) {
        if (isValid(routeInfo)) {
            com.oplus.epona.utils.Logger.d_renamed(TAG, "register static route %s_renamed", routeInfo.getPath());
            this.mRoutes.put(routeInfo.getPath(), routeInfo);
        }
    }

    @Override // com.oplus.epona.Repo
    public void unRegisterRouteInfo(com.oplus.epona.route.RouteInfo routeInfo) {
        if (isValid(routeInfo)) {
            com.oplus.epona.utils.Logger.d_renamed(TAG, "unregister static route %s_renamed", routeInfo.getPath());
            this.mRoutes.remove(routeInfo.getPath());
        }
    }

    @Override // com.oplus.epona.Repo
    public com.oplus.epona.route.RouteInfo findRouteInfo(java.lang.String str) {
        return this.mRoutes.get(str);
    }

    private void registerProviderToRemote(java.lang.String str, java.lang.String str2) {
        com.oplus.epona.Epona.getTransferController().register(str, str2, com.oplus.epona.ipc.local.RemoteTransfer.getInstance());
    }

    @Override // com.oplus.epona.Repo
    public void dump(java.io.PrintWriter printWriter) throws java.lang.NoSuchFieldException {
        printWriter.println("---------start dump epona register info---------");
        printDynamicProviderInfo(printWriter);
        printStaticProviderInfo(printWriter);
        printWriter.println("-------------------- end -----------------------");
    }

    private void printDynamicProviderInfo(java.io.PrintWriter printWriter) {
        printWriter.println("dynamic:");
        for (java.util.Map.Entry<java.lang.String, com.oplus.epona.DynamicProvider> entry : this.mDynamicProviders.entrySet()) {
            if (entry.getValue().getName() != null) {
                printWriter.println(entry.getValue().getName());
            }
        }
        printWriter.println("");
    }

    private void printStaticProviderInfo(java.io.PrintWriter printWriter) throws java.lang.NoSuchFieldException {
        printWriter.println("static:");
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.oplus.epona.provider.ProviderInfo>> it = this.mProviders.entrySet().iterator();
        while (it.hasNext()) {
            com.oplus.epona.provider.ProviderInfo value = it.next().getValue();
            java.lang.String name = value.getName();
            if (name != null) {
                printWriter.println(name + " : ");
            }
            java.util.Map<java.lang.String, com.oplus.epona.provider.ProviderMethodInfo> providerMethodInfo = getProviderMethodInfo(value);
            if (providerMethodInfo != null) {
                for (java.util.Map.Entry<java.lang.String, com.oplus.epona.provider.ProviderMethodInfo> entry : providerMethodInfo.entrySet()) {
                    if (entry != null) {
                        printWriter.println("    -> " + entry.getValue().getMethodName());
                    }
                }
            }
            printWriter.println("");
        }
    }

    private java.util.Map<java.lang.String, com.oplus.epona.provider.ProviderMethodInfo> getProviderMethodInfo(com.oplus.epona.provider.ProviderInfo providerInfo) throws java.lang.NoSuchFieldException {
        if (providerInfo == null) {
            return null;
        }
        try {
            java.lang.reflect.Field declaredField = providerInfo.getClass().getDeclaredField("mMethods");
            declaredField.setAccessible(true);
            return (java.util.Map) declaredField.get(providerInfo);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, e_renamed.toString());
            return null;
        }
    }
}
