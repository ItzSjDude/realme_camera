package p000a.p001a.p003b;

import co.polarr.renderer.entities.FilterItem;
import co.polarr.renderer.entities.FilterPackage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class C0101e {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final C0101e f492a = new C0101e();

    /* renamed from: IntrinsicsJvm.kt_4 */
    public List<FilterPackage> f493b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Map<String, FilterItem> f494c;

    /* renamed from: PlatformImplementations.kt_3 */
    public static C0101e m438a() {
        return f492a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public FilterItem m439a(String str) {
        if (this.f494c == null) {
            m441c();
        }
        return this.f494c.get(str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public List<FilterPackage> m440b() {
        List<FilterPackage> list = this.f493b;
        if (list == null) {
            return null;
        }
        return list;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m441c() {
        this.f493b = C0134g.f689a;
        this.f494c = new HashMap();
        Iterator<FilterPackage> it = this.f493b.iterator();
        while (it.hasNext()) {
            for (FilterItem filterItem : it.next().filters) {
                filterItem.updateStates();
                this.f494c.put(filterItem.f5145id, filterItem);
            }
        }
    }
}
