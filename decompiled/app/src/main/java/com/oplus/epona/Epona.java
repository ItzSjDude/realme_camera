package com.oplus.epona;

/* loaded from: classes2.dex */
public class Epona {
    private static final java.lang.String TAG = "Epona";
    private static com.oplus.epona.Epona sInstance;
    private android.app.Application mApp;
    private android.content.Context mContext;
    public static final com.oplus.epona.ipc.local.RemoteTransferController DEFAULT_CONTROLLER = new com.oplus.epona.ipc.local.DefaultTransferController();
    private static final java.lang.Object mLock = new java.lang.Object();
    private static java.util.concurrent.atomic.AtomicBoolean sInitialized = new java.util.concurrent.atomic.AtomicBoolean(false);
    private java.util.Map<java.lang.String, com.oplus.epona.Dumper> mDumpMap = new java.util.concurrent.ConcurrentHashMap();
    private final java.util.List<com.oplus.epona.Interceptor> mInterceptors = new java.util.ArrayList();
    private com.oplus.epona.ipc.local.RemoteTransferController mController = DEFAULT_CONTROLLER;
    private com.oplus.epona.Interceptor mIPCInterceptor = new com.oplus.epona.interceptor.IPCInterceptor();
    private com.oplus.epona.Repo mRepo = new com.oplus.epona.internal.ProviderRepo();
    private com.oplus.epona.Route mRoute = new com.oplus.epona.Route();
    private com.oplus.epona.internal.ActivityStackManager mActivityStackManager = new com.oplus.epona.internal.ActivityStackManager();

    private static void autoRegister() {
    }

    private Epona() {
    }

    public static void init(android.content.Context context) {
        if (sInitialized.getAndSet(true)) {
            return;
        }
        getInstance().attach(context);
        addDumper(com.oplus.epona.ipc.remote.Dispatcher.getInstance());
        com.oplus.epona.utils.Logger.init(context);
        autoRegister();
    }

    public static boolean addInterceptor(com.oplus.epona.Interceptor interceptor) {
        if (interceptor == null) {
            throw new java.lang.NullPointerException("interceptor cannot be_renamed null");
        }
        java.util.List<com.oplus.epona.Interceptor> list = getInstance().mInterceptors;
        if (list.contains(interceptor)) {
            com.oplus.epona.utils.Logger.e_renamed(TAG, "interceptor has been add twice", new java.lang.Object[0]);
            return false;
        }
        return list.add(interceptor);
    }

    public static java.util.List<com.oplus.epona.Interceptor> getInterceptors() {
        return getInstance().mInterceptors;
    }

    public static boolean addDumper(com.oplus.epona.Dumper dumper) {
        java.util.Objects.requireNonNull(dumper);
        getDumper().put(dumper.key(), dumper);
        return true;
    }

    public static java.util.Map<java.lang.String, com.oplus.epona.Dumper> getDumper() {
        return getInstance().mDumpMap;
    }

    public static com.oplus.epona.ipc.local.RemoteTransferController getTransferController() {
        return getInstance().mController;
    }

    public static void setTransferController(com.oplus.epona.ipc.local.RemoteTransferController remoteTransferController) {
        getInstance().mController = remoteTransferController;
    }

    public static void setIPCInterceptor(com.oplus.epona.Interceptor interceptor) {
        getInstance().mIPCInterceptor = interceptor;
    }

    public static com.oplus.epona.Interceptor getIPCInterceptor() {
        return getInstance().mIPCInterceptor;
    }

    public static com.oplus.epona.internal.RealCall newCall(com.oplus.epona.Request request) {
        return getInstance().mRoute.newCall(request);
    }

    public static void register(com.oplus.epona.DynamicProvider dynamicProvider) {
        getInstance().mRepo.registerProvider(dynamicProvider);
    }

    public static void unRegister(com.oplus.epona.DynamicProvider dynamicProvider) {
        getInstance().mRepo.unRegisterProvider(dynamicProvider);
    }

    public static com.oplus.epona.DynamicProvider findComponent(java.lang.String str) {
        return getInstance().mRepo.findProvider(str);
    }

    public static void registerProvider(com.oplus.epona.provider.ProviderInfo providerInfo) {
        getInstance().mRepo.registerProviderInfo(providerInfo);
    }

    public static void unRegisterProvider(com.oplus.epona.provider.ProviderInfo providerInfo) {
        getInstance().mRepo.unRegisterProviderInfo(providerInfo);
    }

    public static com.oplus.epona.provider.ProviderInfo findProviderComponent(java.lang.String str) {
        return getInstance().mRepo.findProviderProviderInfo(str);
    }

    public static void registerRoute(com.oplus.epona.route.RouteInfo routeInfo) {
        getInstance().mRepo.registerRouteInfo(routeInfo);
    }

    public static void unRegisterRoute(com.oplus.epona.route.RouteInfo routeInfo) {
        getInstance().mRepo.unRegisterRouteInfo(routeInfo);
    }

    public static com.oplus.epona.route.RouteInfo findRoute(java.lang.String str) {
        return getInstance().mRepo.findRouteInfo(str);
    }

    public static android.app.Activity getCurrentActivity() {
        return getInstance().mActivityStackManager.getCurrentActivity();
    }

    public static android.app.Application getApplication() {
        return getInstance().mApp;
    }

    public static android.content.Context getContext() {
        return getInstance().mContext;
    }

    public static void dump(java.io.PrintWriter printWriter) {
        getInstance().mRepo.dump(printWriter);
    }

    private void attach(android.content.Context context) {
        this.mContext = context;
        if (context instanceof android.app.Application) {
            this.mApp = (android.app.Application) context;
        } else {
            this.mApp = (android.app.Application) context.getApplicationContext();
        }
        this.mActivityStackManager.attach(this.mApp);
    }

    private static com.oplus.epona.Epona getInstance() {
        synchronized (mLock) {
            if (sInstance == null) {
                sInstance = new com.oplus.epona.Epona();
            }
        }
        return sInstance;
    }
}
