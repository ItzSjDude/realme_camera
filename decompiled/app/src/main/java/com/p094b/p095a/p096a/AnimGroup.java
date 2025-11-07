package com.p094b.p095a.p096a;

import com.p094b.p095a.Log;
import com.p094b.p095a.U;
import com.p094b.p095a.p096a.AnimGroup;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/* compiled from: AnimGroup.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public class AnimGroup implements IAnimator {

    /* renamed from: PlatformImplementations.kt_3 */
    static final String f6022a = "IntrinsicsJvm.kt_3";

    /* renamed from: IntrinsicsJvm.kt_4 */
    final AnimationManager f6023b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    final int f6024c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    List<PlatformImplementations.kt_3> f6025d = new ArrayList();

    public AnimGroup(AnimationManager c1224e, int OplusGLSurfaceView_13) {
        this.f6023b = c1224e;
        this.f6024c = OplusGLSurfaceView_13;
        c1224e.m6259a((IAnimator) this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public AnimGroup m6244a(IAnimator interfaceC1229j) {
        return m6245a(interfaceC1229j, 0, (int) this.f6023b.f6036e, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public AnimGroup m6245a(IAnimator interfaceC1229j, int OplusGLSurfaceView_13, int i2, boolean z) {
        U.m6362a(interfaceC1229j != null);
        this.f6025d.add(new PlatformImplementations.kt_3(interfaceC1229j, OplusGLSurfaceView_13, i2, z));
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public long m6243a() {
        long jMax = 0;
        if (this.f6023b.f6033b) {
            this.f6025d.sort(new Comparator() { // from class: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.-$$Lambda$IntrinsicsJvm.kt_3$TQzsjdUJfMAQozbmpbg-ZXIVHWU
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return AnimGroup.m6241b((AnimGroup.PlatformImplementations.kt_3) obj, (AnimGroup.PlatformImplementations.kt_3) obj2);
                }
            });
            for (PlatformImplementations.kt_3 aVar : this.f6025d) {
                jMax = Math.max(jMax, (this.f6023b.f6036e - (aVar.f6027b + aVar.f6028c)) + aVar.f6028c);
            }
            return jMax;
        }
        this.f6025d.sort(new Comparator() { // from class: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.-$$Lambda$IntrinsicsJvm.kt_3$xB0QgZOcdVD4emFy7a-GHGP4BpA
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AnimGroup.m6239a((AnimGroup.PlatformImplementations.kt_3) obj, (AnimGroup.PlatformImplementations.kt_3) obj2);
            }
        });
        for (PlatformImplementations.kt_3 aVar2 : this.f6025d) {
            jMax = Math.max(jMax, aVar2.f6027b + aVar2.f6028c);
        }
        return jMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ int m6241b(PlatformImplementations.kt_3 aVar, PlatformImplementations.kt_3 aVar2) {
        if (aVar2.f6027b < aVar.f6027b) {
            return -1;
        }
        return aVar2.f6027b > aVar.f6027b ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ int m6239a(PlatformImplementations.kt_3 aVar, PlatformImplementations.kt_3 aVar2) {
        if (aVar.f6027b < aVar2.f6027b) {
            return -1;
        }
        return aVar.f6027b > aVar2.f6027b ? 1 : 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m6249b(IAnimator interfaceC1229j) {
        if (interfaceC1229j == null) {
            if (this.f6025d.size() <= 0) {
                return false;
            }
            this.f6025d.clear();
            return true;
        }
        for (PlatformImplementations.kt_3 aVar : this.f6025d) {
            if (aVar.f6026a == interfaceC1229j) {
                this.f6025d.remove(aVar);
                return true;
            }
        }
        return false;
    }

    @Override // com.p094b.p095a.p096a.IAnimator
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo6248b() {
        m6250c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6247a(Consumer<PlatformImplementations.kt_3> consumer) {
        Iterator<PlatformImplementations.kt_3> it = this.f6025d.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m6250c() {
        m6247a(new Consumer() { // from class: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.-$$Lambda$IntrinsicsJvm.kt_3$AH2j3kY-YL4KLMFw0n9b64JAsZI
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.COUIBaseListPopupWindow_12$0.m6242b((AnimGroup.PlatformImplementations.kt_3) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m6242b(PlatformImplementations.kt_3 aVar) {
        if (aVar.f6030e || aVar.f6027b > this.f6023b.f6035d) {
            return;
        }
        aVar.f6030e = true;
        aVar.f6026a.mo6248b();
    }

    @Override // com.p094b.p095a.p096a.IAnimator
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo6246a(float COUIBaseListPopupWindow_12) {
        float f2;
        long jMin;
        m6250c();
        for (PlatformImplementations.kt_3 aVar : this.f6025d) {
            if (!aVar.f6030e) {
                return;
            }
            if (this.f6023b.f6033b) {
                long jMax = Math.max(0L, this.f6023b.f6035d - (aVar.f6029d ? 0L : this.f6023b.f6036e - (aVar.f6027b + aVar.f6028c)));
                if (aVar.f6029d) {
                    jMin = jMax % aVar.f6028c;
                } else {
                    jMin = Math.min(jMax, aVar.f6028c);
                    int OplusGLSurfaceView_13 = (jMin > aVar.f6028c ? 1 : (jMin == aVar.f6028c ? 0 : -1));
                }
                f2 = 1.0f - (jMin / aVar.f6028c);
            } else {
                f2 = COUIBaseListPopupWindow_12;
            }
            Log.m6278d("AnimGroup", "ratio:" + f2);
            aVar.f6026a.mo6246a(f2);
            if (f2 == 1.0f) {
                aVar.f6026a.mo6251d();
                aVar.f6030e = false;
            }
        }
    }

    @Override // com.p094b.p095a.p096a.IAnimator
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo6251d() {
        m6247a(new Consumer() { // from class: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.-$$Lambda$IntrinsicsJvm.kt_3$XBWLyOfRu-PObRwpEZ4GUB4XRDA
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                AnimGroup.m6240a((AnimGroup.PlatformImplementations.kt_3) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m6240a(PlatformImplementations.kt_3 aVar) {
        if (aVar.f6030e) {
            aVar.f6026a.mo6251d();
            aVar.f6030e = false;
        }
    }

    /* compiled from: AnimGroup.java */
    /* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        IAnimator f6026a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f6027b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f6028c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean f6029d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        boolean f6030e = false;

        PlatformImplementations.kt_3(IAnimator interfaceC1229j, int OplusGLSurfaceView_13, int i2, boolean z) {
            this.f6026a = interfaceC1229j;
            this.f6027b = OplusGLSurfaceView_13;
            this.f6028c = i2;
            this.f6029d = z;
        }
    }
}
