package mirror.android.app;

import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefObject;

/* loaded from: classes2.dex */
public class ActivityThread {
    public static RefObject<Object> sPackageManager;

    static {
        RefClass.load((Class<?>) ActivityThread.class, "android.app.ActivityThread");
    }
}
