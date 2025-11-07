package androidx.core.h_renamed;

/* compiled from: PointerIconCompat.java */
/* loaded from: classes.dex */
public final class s_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.Object f991a;

    private s_renamed(java.lang.Object obj) {
        this.f991a = obj;
    }

    public java.lang.Object a_renamed() {
        return this.f991a;
    }

    public static androidx.core.h_renamed.s_renamed a_renamed(android.content.Context context, int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return new androidx.core.h_renamed.s_renamed(android.view.PointerIcon.getSystemIcon(context, i_renamed));
        }
        return new androidx.core.h_renamed.s_renamed(null);
    }
}
