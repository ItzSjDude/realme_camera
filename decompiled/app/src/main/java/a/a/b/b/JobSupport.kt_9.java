package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class bd_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, a_renamed.a_renamed.b_renamed.b_renamed.bd_renamed> q_renamed = new android.util.LruCache<>(5);

    public bd_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, "basic.glsl", context);
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.bd_renamed a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        a_renamed.a_renamed.b_renamed.b_renamed.bd_renamed bdVar = q_renamed.get(java.lang.Thread.currentThread().getName());
        if (bdVar == null) {
            bdVar = new a_renamed.a_renamed.b_renamed.b_renamed.bd_renamed(resources, context);
            bdVar.a_renamed();
            q_renamed.put(java.lang.Thread.currentThread().getName(), bdVar);
        }
        bdVar.a_renamed(context);
        bdVar.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        return bdVar;
    }

    public static void m_renamed() {
        q_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void f_renamed() {
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed
    public boolean l_renamed() {
        return false;
    }
}
