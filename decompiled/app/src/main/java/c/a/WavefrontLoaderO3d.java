package c_renamed.a_renamed;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableCollections.kt */
/* loaded from: classes.dex */
public class o_renamed extends c_renamed.a_renamed.n_renamed {
    public static final <T_renamed> boolean a_renamed(java.util.Collection<? super T_renamed> collection, java.lang.Iterable<? extends T_renamed> iterable) {
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(collection, "$this$addAll");
        c_renamed.f_renamed.b_renamed.h_renamed.d_renamed(iterable, "elements");
        if (iterable instanceof java.util.Collection) {
            return collection.addAll((java.util.Collection) iterable);
        }
        boolean z_renamed = false;
        java.util.Iterator<? extends T_renamed> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z_renamed = true;
            }
        }
        return z_renamed;
    }
}
