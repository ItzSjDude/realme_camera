package androidx.core.app;

/* compiled from: NotificationCompatJellybean.java */
/* loaded from: classes.dex */
class j_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.lang.reflect.Field f845b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static boolean f846c;

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.Object f844a = new java.lang.Object();
    private static final java.lang.Object d_renamed = new java.lang.Object();

    public static android.util.SparseArray<android.os.Bundle> a_renamed(java.util.List<android.os.Bundle> list) {
        int size = list.size();
        android.util.SparseArray<android.os.Bundle> sparseArray = null;
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            android.os.Bundle bundle = list.get(i_renamed);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new android.util.SparseArray<>();
                }
                sparseArray.put(i_renamed, bundle);
            }
        }
        return sparseArray;
    }

    public static android.os.Bundle a_renamed(android.app.Notification notification) {
        synchronized (f844a) {
            if (f846c) {
                return null;
            }
            try {
                if (f845b == null) {
                    java.lang.reflect.Field declaredField = android.app.Notification.class.getDeclaredField("extras");
                    if (!android.os.Bundle.class.isAssignableFrom(declaredField.getType())) {
                        android.util.Log.e_renamed("NotificationCompat", "Notification.extras field is_renamed not of_renamed type Bundle");
                        f846c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f845b = declaredField;
                }
                android.os.Bundle bundle = (android.os.Bundle) f845b.get(notification);
                if (bundle == null) {
                    bundle = new android.os.Bundle();
                    f845b.set(notification, bundle);
                }
                return bundle;
            } catch (java.lang.IllegalAccessException e_renamed) {
                android.util.Log.e_renamed("NotificationCompat", "Unable to access notification extras", e_renamed);
                f846c = true;
                return null;
            } catch (java.lang.NoSuchFieldException e2) {
                android.util.Log.e_renamed("NotificationCompat", "Unable to access notification extras", e2);
                f846c = true;
                return null;
            }
        }
    }

    public static android.os.Bundle a_renamed(android.app.Notification.Builder builder, androidx.core.app.h_renamed.a_renamed aVar) {
        androidx.core.graphics.drawable.IconCompat iconCompatA = aVar.a_renamed();
        builder.addAction(iconCompatA != null ? iconCompatA.b_renamed() : 0, aVar.b_renamed(), aVar.c_renamed());
        android.os.Bundle bundle = new android.os.Bundle(aVar.d_renamed());
        if (aVar.f_renamed() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", a_renamed(aVar.f_renamed()));
        }
        if (aVar.i_renamed() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a_renamed(aVar.i_renamed()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e_renamed());
        return bundle;
    }

    static android.os.Bundle a_renamed(androidx.core.app.h_renamed.a_renamed aVar) {
        android.os.Bundle bundle;
        android.os.Bundle bundle2 = new android.os.Bundle();
        androidx.core.graphics.drawable.IconCompat iconCompatA = aVar.a_renamed();
        bundle2.putInt("icon", iconCompatA != null ? iconCompatA.b_renamed() : 0);
        bundle2.putCharSequence("title", aVar.b_renamed());
        bundle2.putParcelable("actionIntent", aVar.c_renamed());
        if (aVar.d_renamed() != null) {
            bundle = new android.os.Bundle(aVar.d_renamed());
        } else {
            bundle = new android.os.Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e_renamed());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", a_renamed(aVar.f_renamed()));
        bundle2.putBoolean("showsUserInterface", aVar.j_renamed());
        bundle2.putInt("semanticAction", aVar.g_renamed());
        return bundle2;
    }

    private static android.os.Bundle a_renamed(androidx.core.app.k_renamed kVar) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("resultKey", kVar.a_renamed());
        bundle.putCharSequence("label", kVar.b_renamed());
        bundle.putCharSequenceArray("choices", kVar.c_renamed());
        bundle.putBoolean("allowFreeFormInput", kVar.e_renamed());
        bundle.putBundle("extras", kVar.g_renamed());
        java.util.Set<java.lang.String> setD = kVar.d_renamed();
        if (setD != null && !setD.isEmpty()) {
            java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>(setD.size());
            java.util.Iterator<java.lang.String> it = setD.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static android.os.Bundle[] a_renamed(androidx.core.app.k_renamed[] kVarArr) {
        if (kVarArr == null) {
            return null;
        }
        android.os.Bundle[] bundleArr = new android.os.Bundle[kVarArr.length];
        for (int i_renamed = 0; i_renamed < kVarArr.length; i_renamed++) {
            bundleArr[i_renamed] = a_renamed(kVarArr[i_renamed]);
        }
        return bundleArr;
    }
}
