package co_renamed.polarr.renderer.filters;

/* loaded from: classes.dex */
public class Basic extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.lang.String, co_renamed.polarr.renderer.filters.Basic> r_renamed = new android.util.LruCache<>(5);
    public boolean q_renamed;

    public Basic(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, "basic.glsl", context);
        this.q_renamed = true;
    }

    public static co_renamed.polarr.renderer.filters.Basic a_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        co_renamed.polarr.renderer.filters.Basic basic = r_renamed.get(java.lang.Thread.currentThread().getName());
        if (basic == null) {
            basic = new co_renamed.polarr.renderer.filters.Basic(resources, context);
            basic.a_renamed();
            r_renamed.put(java.lang.Thread.currentThread().getName(), basic);
        }
        basic.a_renamed(context);
        basic.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        basic.q_renamed = true;
        return basic;
    }

    public static co_renamed.polarr.renderer.filters.Basic getInstance(android.content.res.Resources resources) {
        co_renamed.polarr.renderer.filters.Basic basic = r_renamed.get(java.lang.Thread.currentThread().getName());
        if (basic == null) {
            basic = new co_renamed.polarr.renderer.filters.Basic(resources, new co_renamed.polarr.renderer.entities.Context());
            basic.a_renamed();
            r_renamed.put(java.lang.Thread.currentThread().getName(), basic);
        }
        basic.a_renamed(a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed());
        basic.q_renamed = true;
        return basic;
    }

    public static void m_renamed() {
        r_renamed.evictAll();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void draw() {
        super.draw();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void f_renamed() {
        if (this.q_renamed) {
            super.f_renamed();
        }
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public float[] getMatrix() {
        return super.getMatrix();
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed
    public boolean l_renamed() {
        return false;
    }

    public void setInputTextureId(int i_renamed) {
        a_renamed(i_renamed);
    }

    public void setNeedClear(boolean z_renamed) {
        this.q_renamed = z_renamed;
    }
}
