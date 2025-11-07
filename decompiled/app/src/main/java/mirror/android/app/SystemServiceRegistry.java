package mirror.android.app;

import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefInt;
import com.oplus.utils.reflect.RefObject;
import java.util.Map;

/* loaded from: classes2.dex */
public class SystemServiceRegistry {

    private static class RefInfo {
        public static RefObject<Map<String, ?>> SYSTEM_SERVICE_FETCHERS;
        private static Class<?> TYPE = RefClass.load((Class<?>) RefInfo.class, "android.app.SystemServiceRegistry");

        private RefInfo() {
        }
    }

    private SystemServiceRegistry() {
    }

    public static Object getFetcher(String str) {
        return RefInfo.SYSTEM_SERVICE_FETCHERS.get(null).get(str);
    }

    public static class StaticServiceFetcher {

        private static class RefInfo {
            private static final String CLASS_NAME = "android.app.SystemServiceRegistry$StaticServiceFetcher";
            private static Class<?> TYPE = RefClass.load((Class<?>) RefInfo.class, CLASS_NAME);
            public static RefObject mCachedInstance;

            private RefInfo() {
            }
        }

        public static void setCachedInstance(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException {
            RefInfo.mCachedInstance.set(obj, obj2);
        }
    }

    public static class CachedServiceFetcher {

        private static class RefInfo {
            private static final String CLASS_NAME = "android.app.SystemServiceRegistry$CachedServiceFetcher";
            private static Class<?> TYPE = RefClass.load((Class<?>) RefInfo.class, CLASS_NAME);
            public static RefInt mCacheIndex;

            private RefInfo() {
            }
        }

        public static int getCacheIndex(Object obj) {
            return RefInfo.mCacheIndex.get(obj);
        }
    }
}
