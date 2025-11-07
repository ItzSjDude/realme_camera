package a_renamed.a_renamed.b_renamed;

/* loaded from: classes.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final a_renamed.a_renamed.b_renamed.e_renamed f60a = new a_renamed.a_renamed.b_renamed.e_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    public java.util.List<co_renamed.polarr.renderer.entities.FilterPackage> f61b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public java.util.Map<java.lang.String, co_renamed.polarr.renderer.entities.FilterItem> f62c;

    public static a_renamed.a_renamed.b_renamed.e_renamed a_renamed() {
        return f60a;
    }

    public co_renamed.polarr.renderer.entities.FilterItem a_renamed(java.lang.String str) {
        if (this.f62c == null) {
            c_renamed();
        }
        return this.f62c.get(str);
    }

    public java.util.List<co_renamed.polarr.renderer.entities.FilterPackage> b_renamed() {
        java.util.List<co_renamed.polarr.renderer.entities.FilterPackage> list = this.f61b;
        if (list == null) {
            return null;
        }
        return list;
    }

    public void c_renamed() {
        this.f61b = a_renamed.a_renamed.b_renamed.g_renamed.f155a;
        this.f62c = new java.util.HashMap();
        java.util.Iterator<co_renamed.polarr.renderer.entities.FilterPackage> it = this.f61b.iterator();
        while (it.hasNext()) {
            for (co_renamed.polarr.renderer.entities.FilterItem filterItem : it.next().filters) {
                filterItem.updateStates();
                this.f62c.put(filterItem.id_renamed, filterItem);
            }
        }
    }
}
