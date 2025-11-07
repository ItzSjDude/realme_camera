package mirror.android.app;

/* loaded from: classes2.dex */
public class SystemServiceRegistry {

    private static class RefInfo {
        public static com.oplus.utils.reflect.RefObject<java.util.Map<java.lang.String, ?>> SYSTEM_SERVICE_FETCHERS;
        private static java.lang.Class<?> TYPE = com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) mirror.android.app.SystemServiceRegistry.RefInfo.class, "android.app.SystemServiceRegistry");

        private RefInfo() {
        }
    }

    private SystemServiceRegistry() {
    }

    public static java.lang.Object getFetcher(java.lang.String str) {
        return mirror.android.app.SystemServiceRegistry.RefInfo.SYSTEM_SERVICE_FETCHERS.get(null).get(str);
    }

    public static class StaticServiceFetcher {

        private static class RefInfo {
            private static final java.lang.String CLASS_NAME = "android.app.SystemServiceRegistry$StaticServiceFetcher";
            private static java.lang.Class<?> TYPE = com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) mirror.android.app.SystemServiceRegistry.StaticServiceFetcher.RefInfo.class, CLASS_NAME);
            public static com.oplus.utils.reflect.RefObject mCachedInstance;

            private RefInfo() {
            }
        }

        public static void setCachedInstance(java.lang.Object obj, java.lang.Object obj2) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
            mirror.android.app.SystemServiceRegistry.StaticServiceFetcher.RefInfo.mCachedInstance.set(obj, obj2);
        }
    }

    public static class CachedServiceFetcher {

        private static class RefInfo {
            private static final java.lang.String CLASS_NAME = "android.app.SystemServiceRegistry$CachedServiceFetcher";
            private static java.lang.Class<?> TYPE = com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) mirror.android.app.SystemServiceRegistry.CachedServiceFetcher.RefInfo.class, CLASS_NAME);
            public static com.oplus.utils.reflect.RefInt mCacheIndex;

            private RefInfo() {
            }
        }

        public static int getCacheIndex(java.lang.Object obj) {
            return mirror.android.app.SystemServiceRegistry.CachedServiceFetcher.RefInfo.mCacheIndex.get(obj);
        }
    }
}
