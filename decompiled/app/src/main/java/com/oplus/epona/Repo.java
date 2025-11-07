package com.oplus.epona;

/* loaded from: classes2.dex */
public interface Repo {
    void dump(java.io.PrintWriter printWriter);

    com.oplus.epona.DynamicProvider findProvider(java.lang.String str);

    com.oplus.epona.provider.ProviderInfo findProviderProviderInfo(java.lang.String str);

    com.oplus.epona.route.RouteInfo findRouteInfo(java.lang.String str);

    void registerProvider(com.oplus.epona.DynamicProvider dynamicProvider);

    void registerProviderInfo(com.oplus.epona.provider.ProviderInfo providerInfo);

    void registerRouteInfo(com.oplus.epona.route.RouteInfo routeInfo);

    void unRegisterProvider(com.oplus.epona.DynamicProvider dynamicProvider);

    void unRegisterProviderInfo(com.oplus.epona.provider.ProviderInfo providerInfo);

    void unRegisterRouteInfo(com.oplus.epona.route.RouteInfo routeInfo);
}
