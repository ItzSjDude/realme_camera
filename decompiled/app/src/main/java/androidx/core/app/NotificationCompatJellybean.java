package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: NotificationCompatJellybean.java */
/* renamed from: androidx.core.app.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
class NotificationCompatJellybean {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Field f2824b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean f2825c;

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Object f2823a = new Object();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final Object f2826d = new Object();

    /* renamed from: PlatformImplementations.kt_3 */
    public static SparseArray<Bundle> m2426a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            Bundle bundle = list.get(OplusGLSurfaceView_13);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(OplusGLSurfaceView_13, bundle);
            }
        }
        return sparseArray;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bundle m2423a(Notification notification) {
        synchronized (f2823a) {
            if (f2825c) {
                return null;
            }
            try {
                if (f2824b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.COUIBaseListPopupWindow_8("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f2825c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f2824b = declaredField;
                }
                Bundle bundle = (Bundle) f2824b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f2824b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("NotificationCompat", "Unable to access notification extras", COUIBaseListPopupWindow_8);
                f2825c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.COUIBaseListPopupWindow_8("NotificationCompat", "Unable to access notification extras", e2);
                f2825c = true;
                return null;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bundle m2422a(Notification.Builder builder, NotificationCompat.PlatformImplementations.kt_3 aVar) {
        IconCompat iconCompatM2378a = aVar.m2378a();
        builder.addAction(iconCompatM2378a != null ? iconCompatM2378a.m2562b() : 0, aVar.m2379b(), aVar.m2380c());
        Bundle bundle = new Bundle(aVar.m2381d());
        if (aVar.m2383f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", m2427a(aVar.m2383f()));
        }
        if (aVar.m2386i() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", m2427a(aVar.m2386i()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.m2382e());
        return bundle;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static Bundle m2424a(NotificationCompat.PlatformImplementations.kt_3 aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat iconCompatM2378a = aVar.m2378a();
        bundle2.putInt("icon", iconCompatM2378a != null ? iconCompatM2378a.m2562b() : 0);
        bundle2.putCharSequence("title", aVar.m2379b());
        bundle2.putParcelable("actionIntent", aVar.m2380c());
        if (aVar.m2381d() != null) {
            bundle = new Bundle(aVar.m2381d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.m2382e());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", m2427a(aVar.m2383f()));
        bundle2.putBoolean("showsUserInterface", aVar.m2387j());
        bundle2.putInt("semanticAction", aVar.m2384g());
        return bundle2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Bundle m2425a(RemoteInput c0437k) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", c0437k.m2430a());
        bundle.putCharSequence("label", c0437k.m2431b());
        bundle.putCharSequenceArray("choices", c0437k.m2432c());
        bundle.putBoolean("allowFreeFormInput", c0437k.m2434e());
        bundle.putBundle("extras", c0437k.m2436g());
        Set<String> setM2433d = c0437k.m2433d();
        if (setM2433d != null && !setM2433d.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setM2433d.size());
            Iterator<String> it = setM2433d.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Bundle[] m2427a(RemoteInput[] c0437kArr) {
        if (c0437kArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c0437kArr.length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < c0437kArr.length; OplusGLSurfaceView_13++) {
            bundleArr[OplusGLSurfaceView_13] = m2425a(c0437kArr[OplusGLSurfaceView_13]);
        }
        return bundleArr;
    }
}
