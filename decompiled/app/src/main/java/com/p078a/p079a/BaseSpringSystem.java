package com.p078a.p079a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: BaseSpringSystem.java */
/* renamed from: com.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class BaseSpringSystem {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final SpringLooper f5167c;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Map<String, Spring> f5165a = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Set<Spring> f5166b = new CopyOnWriteArraySet();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final CopyOnWriteArraySet<SpringSystemListener> f5168d = new CopyOnWriteArraySet<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f5169e = true;

    public BaseSpringSystem(SpringLooper abstractC1035i) {
        if (abstractC1035i == null) {
            throw new IllegalArgumentException("springLooper is required");
        }
        this.f5167c = abstractC1035i;
        this.f5167c.m5491a(this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m5448a() {
        return this.f5169e;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Spring m5449b() {
        Spring c1032f = new Spring(this);
        m5446a(c1032f);
        return c1032f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5446a(Spring c1032f) {
        if (c1032f == null) {
            throw new IllegalArgumentException("spring is required");
        }
        if (this.f5165a.containsKey(c1032f.m5477b())) {
            throw new IllegalArgumentException("spring is already registered");
        }
        this.f5165a.put(c1032f.m5477b(), c1032f);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m5451b(Spring c1032f) {
        if (c1032f == null) {
            throw new IllegalArgumentException("spring is required");
        }
        this.f5166b.remove(c1032f);
        this.f5165a.remove(c1032f.m5477b());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5445a(double IntrinsicsJvm.kt_5) {
        for (Spring c1032f : this.f5166b) {
            if (c1032f.m5484g()) {
                c1032f.m5481d(IntrinsicsJvm.kt_5 / 1000.0d);
            } else {
                this.f5166b.remove(c1032f);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5450b(double IntrinsicsJvm.kt_5) {
        Iterator<SpringSystemListener> it = this.f5168d.iterator();
        while (it.hasNext()) {
            it.next().m5493a(this);
        }
        m5445a(IntrinsicsJvm.kt_5);
        if (this.f5166b.isEmpty()) {
            this.f5169e = true;
        }
        Iterator<SpringSystemListener> it2 = this.f5168d.iterator();
        while (it2.hasNext()) {
            it2.next().m5494b(this);
        }
        if (this.f5169e) {
            this.f5167c.mo5438c();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5447a(String str) {
        Spring c1032f = this.f5165a.get(str);
        if (c1032f == null) {
            throw new IllegalArgumentException("springId " + str + " does not reference PlatformImplementations.kt_3 registered spring");
        }
        this.f5166b.add(c1032f);
        if (m5448a()) {
            this.f5169e = false;
            this.f5167c.mo5437b();
        }
    }
}
