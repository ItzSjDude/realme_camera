package androidx.recyclerview.widget;

import androidx.core.p035g.Pools;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AdapterHelper.java */
/* renamed from: androidx.recyclerview.widget.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
final class AdapterHelper implements OpReorderer.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    final ArrayList<IntrinsicsJvm.kt_4> f4132a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final ArrayList<IntrinsicsJvm.kt_4> f4133b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    final PlatformImplementations.kt_3 f4134c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    Runnable f4135d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    final boolean f4136e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    final OpReorderer f4137f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Pools.PlatformImplementations.kt_3<IntrinsicsJvm.kt_4> f4138g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f4139h;

    /* compiled from: AdapterHelper.java */
    /* renamed from: androidx.recyclerview.widget.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        RecyclerView.AbstractC0707w mo4099a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo4100a(int OplusGLSurfaceView_13, int i2);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo4101a(int OplusGLSurfaceView_13, int i2, Object obj);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo4102a(IntrinsicsJvm.kt_4 bVar);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo4103b(int OplusGLSurfaceView_13, int i2);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo4104b(IntrinsicsJvm.kt_4 bVar);

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo4105c(int OplusGLSurfaceView_13, int i2);

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo4107d(int OplusGLSurfaceView_13, int i2);
    }

    AdapterHelper(PlatformImplementations.kt_3 aVar) {
        this(aVar, false);
    }

    AdapterHelper(PlatformImplementations.kt_3 aVar, boolean z) {
        this.f4138g = new Pools.IntrinsicsJvm.kt_4(30);
        this.f4132a = new ArrayList<>();
        this.f4133b = new ArrayList<>();
        this.f4139h = 0;
        this.f4134c = aVar;
        this.f4136e = z;
        this.f4137f = new OpReorderer(this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4353a() {
        m4356a(this.f4132a);
        m4356a(this.f4133b);
        this.f4139h = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m4361b() {
        this.f4137f.m4492a(this.f4132a);
        int size = this.f4132a.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            IntrinsicsJvm.kt_4 bVar = this.f4132a.get(OplusGLSurfaceView_13);
            int i2 = bVar.f4140a;
            if (i2 == 1) {
                m4349f(bVar);
            } else if (i2 == 2) {
                m4344c(bVar);
            } else if (i2 == 4) {
                m4346d(bVar);
            } else if (i2 == 8) {
                m4343b(bVar);
            }
            Runnable runnable = this.f4135d;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f4132a.clear();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m4364c() {
        int size = this.f4133b.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f4134c.mo4104b(this.f4133b.get(OplusGLSurfaceView_13));
        }
        m4356a(this.f4133b);
        this.f4139h = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4343b(IntrinsicsJvm.kt_4 bVar) {
        m4350g(bVar);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m4344c(IntrinsicsJvm.kt_4 bVar) {
        boolean z;
        boolean z2;
        int OplusGLSurfaceView_13 = bVar.f4141b;
        int i2 = bVar.f4141b + bVar.f4143d;
        int i3 = bVar.f4141b;
        boolean z3 = -1;
        int i4 = 0;
        while (i3 < i2) {
            if (this.f4134c.mo4099a(i3) != null || m4347d(i3)) {
                if (z3) {
                    z = false;
                } else {
                    m4348e(mo4352a(2, OplusGLSurfaceView_13, i4, null));
                    z = true;
                }
                z2 = true;
            } else {
                if (z3) {
                    m4350g(mo4352a(2, OplusGLSurfaceView_13, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                z2 = false;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            z3 = z2;
        }
        if (i4 != bVar.f4143d) {
            mo4354a(bVar);
            bVar = mo4352a(2, OplusGLSurfaceView_13, i4, null);
        }
        if (!z3) {
            m4348e(bVar);
        } else {
            m4350g(bVar);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m4346d(IntrinsicsJvm.kt_4 bVar) {
        int OplusGLSurfaceView_13 = bVar.f4141b;
        int i2 = bVar.f4141b + bVar.f4143d;
        boolean z = -1;
        int i3 = OplusGLSurfaceView_13;
        int i4 = 0;
        for (int i5 = bVar.f4141b; i5 < i2; i5++) {
            if (this.f4134c.mo4099a(i5) != null || m4347d(i5)) {
                if (!z) {
                    m4348e(mo4352a(4, i3, i4, bVar.f4142c));
                    i3 = i5;
                    i4 = 0;
                }
                z = true;
            } else {
                if (z) {
                    m4350g(mo4352a(4, i3, i4, bVar.f4142c));
                    i3 = i5;
                    i4 = 0;
                }
                z = false;
            }
            i4++;
        }
        if (i4 != bVar.f4143d) {
            Object obj = bVar.f4142c;
            mo4354a(bVar);
            bVar = mo4352a(4, i3, i4, obj);
        }
        if (!z) {
            m4348e(bVar);
        } else {
            m4350g(bVar);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m4348e(IntrinsicsJvm.kt_4 bVar) {
        int OplusGLSurfaceView_13;
        if (bVar.f4140a == 1 || bVar.f4140a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iM4345d = m4345d(bVar.f4141b, bVar.f4140a);
        int i2 = bVar.f4141b;
        int i3 = bVar.f4140a;
        if (i3 == 2) {
            OplusGLSurfaceView_13 = 0;
        } else {
            if (i3 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            OplusGLSurfaceView_13 = 1;
        }
        int i4 = iM4345d;
        int i5 = i2;
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.f4143d; i7++) {
            int iM4345d2 = m4345d(bVar.f4141b + (OplusGLSurfaceView_13 * i7), bVar.f4140a);
            int i8 = bVar.f4140a;
            if (i8 == 2 ? iM4345d2 == i4 : i8 == 4 && iM4345d2 == i4 + 1) {
                i6++;
            } else {
                IntrinsicsJvm.kt_4 bVarMo4352a = mo4352a(bVar.f4140a, i4, i6, bVar.f4142c);
                m4355a(bVarMo4352a, i5);
                mo4354a(bVarMo4352a);
                if (bVar.f4140a == 4) {
                    i5 += i6;
                }
                i6 = 1;
                i4 = iM4345d2;
            }
        }
        Object obj = bVar.f4142c;
        mo4354a(bVar);
        if (i6 > 0) {
            IntrinsicsJvm.kt_4 bVarMo4352a2 = mo4352a(bVar.f4140a, i4, i6, obj);
            m4355a(bVarMo4352a2, i5);
            mo4354a(bVarMo4352a2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4355a(IntrinsicsJvm.kt_4 bVar, int OplusGLSurfaceView_13) {
        this.f4134c.mo4102a(bVar);
        int i2 = bVar.f4140a;
        if (i2 == 2) {
            this.f4134c.mo4100a(OplusGLSurfaceView_13, bVar.f4143d);
        } else {
            if (i2 == 4) {
                this.f4134c.mo4101a(OplusGLSurfaceView_13, bVar.f4143d, bVar.f4142c);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int m4345d(int OplusGLSurfaceView_13, int i2) {
        int i3;
        int i4;
        for (int size = this.f4133b.size() - 1; size >= 0; size--) {
            IntrinsicsJvm.kt_4 bVar = this.f4133b.get(size);
            if (bVar.f4140a == 8) {
                if (bVar.f4141b < bVar.f4143d) {
                    i3 = bVar.f4141b;
                    i4 = bVar.f4143d;
                } else {
                    i3 = bVar.f4143d;
                    i4 = bVar.f4141b;
                }
                if (OplusGLSurfaceView_13 >= i3 && OplusGLSurfaceView_13 <= i4) {
                    if (i3 == bVar.f4141b) {
                        if (i2 == 1) {
                            bVar.f4143d++;
                        } else if (i2 == 2) {
                            bVar.f4143d--;
                        }
                        OplusGLSurfaceView_13++;
                    } else {
                        if (i2 == 1) {
                            bVar.f4141b++;
                        } else if (i2 == 2) {
                            bVar.f4141b--;
                        }
                        OplusGLSurfaceView_13--;
                    }
                } else if (OplusGLSurfaceView_13 < bVar.f4141b) {
                    if (i2 == 1) {
                        bVar.f4141b++;
                        bVar.f4143d++;
                    } else if (i2 == 2) {
                        bVar.f4141b--;
                        bVar.f4143d--;
                    }
                }
            } else if (bVar.f4141b <= OplusGLSurfaceView_13) {
                if (bVar.f4140a == 1) {
                    OplusGLSurfaceView_13 -= bVar.f4143d;
                } else if (bVar.f4140a == 2) {
                    OplusGLSurfaceView_13 += bVar.f4143d;
                }
            } else if (i2 == 1) {
                bVar.f4141b++;
            } else if (i2 == 2) {
                bVar.f4141b--;
            }
        }
        for (int size2 = this.f4133b.size() - 1; size2 >= 0; size2--) {
            IntrinsicsJvm.kt_4 bVar2 = this.f4133b.get(size2);
            if (bVar2.f4140a == 8) {
                if (bVar2.f4143d == bVar2.f4141b || bVar2.f4143d < 0) {
                    this.f4133b.remove(size2);
                    mo4354a(bVar2);
                }
            } else if (bVar2.f4143d <= 0) {
                this.f4133b.remove(size2);
                mo4354a(bVar2);
            }
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m4347d(int OplusGLSurfaceView_13) {
        int size = this.f4133b.size();
        for (int i2 = 0; i2 < size; i2++) {
            IntrinsicsJvm.kt_4 bVar = this.f4133b.get(i2);
            if (bVar.f4140a == 8) {
                if (m4351a(bVar.f4143d, i2 + 1) == OplusGLSurfaceView_13) {
                    return true;
                }
            } else if (bVar.f4140a == 1) {
                int i3 = bVar.f4141b + bVar.f4143d;
                for (int i4 = bVar.f4141b; i4 < i3; i4++) {
                    if (m4351a(i4, i2 + 1) == OplusGLSurfaceView_13) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m4349f(IntrinsicsJvm.kt_4 bVar) {
        m4350g(bVar);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m4350g(IntrinsicsJvm.kt_4 bVar) {
        this.f4133b.add(bVar);
        int OplusGLSurfaceView_13 = bVar.f4140a;
        if (OplusGLSurfaceView_13 == 1) {
            this.f4134c.mo4105c(bVar.f4141b, bVar.f4143d);
            return;
        }
        if (OplusGLSurfaceView_13 == 2) {
            this.f4134c.mo4103b(bVar.f4141b, bVar.f4143d);
            return;
        }
        if (OplusGLSurfaceView_13 == 4) {
            this.f4134c.mo4101a(bVar.f4141b, bVar.f4143d, bVar.f4142c);
        } else {
            if (OplusGLSurfaceView_13 == 8) {
                this.f4134c.mo4107d(bVar.f4141b, bVar.f4143d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean m4366d() {
        return this.f4132a.size() > 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m4357a(int OplusGLSurfaceView_13) {
        return (this.f4139h & OplusGLSurfaceView_13) != 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    int m4360b(int OplusGLSurfaceView_13) {
        return m4351a(OplusGLSurfaceView_13, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int m4351a(int OplusGLSurfaceView_13, int i2) {
        int size = this.f4133b.size();
        while (i2 < size) {
            IntrinsicsJvm.kt_4 bVar = this.f4133b.get(i2);
            if (bVar.f4140a == 8) {
                if (bVar.f4141b == OplusGLSurfaceView_13) {
                    OplusGLSurfaceView_13 = bVar.f4143d;
                } else {
                    if (bVar.f4141b < OplusGLSurfaceView_13) {
                        OplusGLSurfaceView_13--;
                    }
                    if (bVar.f4143d <= OplusGLSurfaceView_13) {
                        OplusGLSurfaceView_13++;
                    }
                }
            } else if (bVar.f4141b > OplusGLSurfaceView_13) {
                continue;
            } else if (bVar.f4140a == 2) {
                if (OplusGLSurfaceView_13 < bVar.f4141b + bVar.f4143d) {
                    return -1;
                }
                OplusGLSurfaceView_13 -= bVar.f4143d;
            } else if (bVar.f4140a == 1) {
                OplusGLSurfaceView_13 += bVar.f4143d;
            }
            i2++;
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m4359a(int OplusGLSurfaceView_13, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f4132a.add(mo4352a(4, OplusGLSurfaceView_13, i2, obj));
        this.f4139h |= 4;
        return this.f4132a.size() == 1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean m4362b(int OplusGLSurfaceView_13, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f4132a.add(mo4352a(1, OplusGLSurfaceView_13, i2, null));
        this.f4139h |= 1;
        return this.f4132a.size() == 1;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean m4365c(int OplusGLSurfaceView_13, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f4132a.add(mo4352a(2, OplusGLSurfaceView_13, i2, null));
        this.f4139h |= 2;
        return this.f4132a.size() == 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m4358a(int OplusGLSurfaceView_13, int i2, int i3) {
        if (OplusGLSurfaceView_13 == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f4132a.add(mo4352a(8, OplusGLSurfaceView_13, i2, null));
        this.f4139h |= 8;
        return this.f4132a.size() == 1;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    void m4367e() {
        m4364c();
        int size = this.f4132a.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            IntrinsicsJvm.kt_4 bVar = this.f4132a.get(OplusGLSurfaceView_13);
            int i2 = bVar.f4140a;
            if (i2 == 1) {
                this.f4134c.mo4104b(bVar);
                this.f4134c.mo4105c(bVar.f4141b, bVar.f4143d);
            } else if (i2 == 2) {
                this.f4134c.mo4104b(bVar);
                this.f4134c.mo4100a(bVar.f4141b, bVar.f4143d);
            } else if (i2 == 4) {
                this.f4134c.mo4104b(bVar);
                this.f4134c.mo4101a(bVar.f4141b, bVar.f4143d, bVar.f4142c);
            } else if (i2 == 8) {
                this.f4134c.mo4104b(bVar);
                this.f4134c.mo4107d(bVar.f4141b, bVar.f4143d);
            }
            Runnable runnable = this.f4135d;
            if (runnable != null) {
                runnable.run();
            }
        }
        m4356a(this.f4132a);
        this.f4139h = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m4363c(int OplusGLSurfaceView_13) {
        int size = this.f4132a.size();
        for (int i2 = 0; i2 < size; i2++) {
            IntrinsicsJvm.kt_4 bVar = this.f4132a.get(i2);
            int i3 = bVar.f4140a;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        if (bVar.f4141b == OplusGLSurfaceView_13) {
                            OplusGLSurfaceView_13 = bVar.f4143d;
                        } else {
                            if (bVar.f4141b < OplusGLSurfaceView_13) {
                                OplusGLSurfaceView_13--;
                            }
                            if (bVar.f4143d <= OplusGLSurfaceView_13) {
                                OplusGLSurfaceView_13++;
                            }
                        }
                    }
                } else if (bVar.f4141b > OplusGLSurfaceView_13) {
                    continue;
                } else {
                    if (bVar.f4141b + bVar.f4143d > OplusGLSurfaceView_13) {
                        return -1;
                    }
                    OplusGLSurfaceView_13 -= bVar.f4143d;
                }
            } else if (bVar.f4141b <= OplusGLSurfaceView_13) {
                OplusGLSurfaceView_13 += bVar.f4143d;
            }
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean m4368f() {
        return (this.f4133b.isEmpty() || this.f4132a.isEmpty()) ? false : true;
    }

    /* compiled from: AdapterHelper.java */
    /* renamed from: androidx.recyclerview.widget.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    static final class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        int f4140a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f4141b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        Object f4142c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f4143d;

        IntrinsicsJvm.kt_4(int OplusGLSurfaceView_13, int i2, int i3, Object obj) {
            this.f4140a = OplusGLSurfaceView_13;
            this.f4141b = i2;
            this.f4143d = i3;
            this.f4142c = obj;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        String m4369a() {
            int OplusGLSurfaceView_13 = this.f4140a;
            return OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? OplusGLSurfaceView_13 != 4 ? OplusGLSurfaceView_13 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + m4369a() + ",s:" + this.f4141b + "IntrinsicsJvm.kt_3:" + this.f4143d + ",p:" + this.f4142c + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IntrinsicsJvm.kt_4)) {
                return false;
            }
            IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) obj;
            int OplusGLSurfaceView_13 = this.f4140a;
            if (OplusGLSurfaceView_13 != bVar.f4140a) {
                return false;
            }
            if (OplusGLSurfaceView_13 == 8 && Math.abs(this.f4143d - this.f4141b) == 1 && this.f4143d == bVar.f4141b && this.f4141b == bVar.f4143d) {
                return true;
            }
            if (this.f4143d != bVar.f4143d || this.f4141b != bVar.f4141b) {
                return false;
            }
            Object obj2 = this.f4142c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f4142c)) {
                    return false;
                }
            } else if (bVar.f4142c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f4140a * 31) + this.f4141b) * 31) + this.f4143d;
        }
    }

    @Override // androidx.recyclerview.widget.OpReorderer.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public IntrinsicsJvm.kt_4 mo4352a(int OplusGLSurfaceView_13, int i2, int i3, Object obj) {
        IntrinsicsJvm.kt_4 bVarMo2532a = this.f4138g.mo2532a();
        if (bVarMo2532a == null) {
            return new IntrinsicsJvm.kt_4(OplusGLSurfaceView_13, i2, i3, obj);
        }
        bVarMo2532a.f4140a = OplusGLSurfaceView_13;
        bVarMo2532a.f4141b = i2;
        bVarMo2532a.f4143d = i3;
        bVarMo2532a.f4142c = obj;
        return bVarMo2532a;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4354a(IntrinsicsJvm.kt_4 bVar) {
        if (this.f4136e) {
            return;
        }
        bVar.f4142c = null;
        this.f4138g.mo2533a(bVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4356a(List<IntrinsicsJvm.kt_4> list) {
        int size = list.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            mo4354a(list.get(OplusGLSurfaceView_13));
        }
        list.clear();
    }
}
