package p061c.p074h;

import p061c.p062a.Iterators.kt_2;
import p061c.p068d.progressionUtil.kt;
import p061c.p070f.p072b.DefaultConstructorMarker;

/* compiled from: Progressions.kt */
/* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_10.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class Progressions.kt implements Iterable<Integer> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final PlatformImplementations.kt_3 f5058a = new PlatformImplementations.kt_3(null);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f5059b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f5060c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final int f5061d;

    public Progressions.kt(int OplusGLSurfaceView_13, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f5059b = OplusGLSurfaceView_13;
        this.f5060c = progressionUtil.kt.m5283a(OplusGLSurfaceView_13, i2, i3);
        this.f5061d = i3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final int m5327a() {
        return this.f5059b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final int m5328b() {
        return this.f5060c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final int m5329c() {
        return this.f5061d;
    }

    @Override // java.lang.Iterable
    /* renamed from: IntrinsicsJvm.kt_5, reason: merged with bridge method [inline-methods] */
    public Iterators.kt_2 iterator() {
        return new ProgressionIterators.kt(this.f5059b, this.f5060c, this.f5061d);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo5331e() {
        if (this.f5061d > 0) {
            if (this.f5059b > this.f5060c) {
                return true;
            }
        } else if (this.f5059b < this.f5060c) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Progressions.kt) {
            if (!mo5331e() || !((Progressions.kt) obj).mo5331e()) {
                Progressions.kt c0984a = (Progressions.kt) obj;
                if (this.f5059b != c0984a.f5059b || this.f5060c != c0984a.f5060c || this.f5061d != c0984a.f5061d) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo5331e()) {
            return -1;
        }
        return this.f5061d + (((this.f5059b * 31) + this.f5060c) * 31);
    }

    public String toString() {
        StringBuilder sb;
        int OplusGLSurfaceView_13;
        if (this.f5061d > 0) {
            sb = new StringBuilder();
            sb.append(this.f5059b);
            sb.append("..");
            sb.append(this.f5060c);
            sb.append(" step ");
            OplusGLSurfaceView_13 = this.f5061d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f5059b);
            sb.append(" downTo ");
            sb.append(this.f5060c);
            sb.append(" step ");
            OplusGLSurfaceView_13 = -this.f5061d;
        }
        sb.append(OplusGLSurfaceView_13);
        return sb.toString();
    }

    /* compiled from: Progressions.kt */
    /* renamed from: IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_10.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {
        private PlatformImplementations.kt_3() {
        }

        public /* synthetic */ PlatformImplementations.kt_3(DefaultConstructorMarker c0970f) {
            this();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final Progressions.kt m5332a(int OplusGLSurfaceView_13, int i2, int i3) {
            return new Progressions.kt(OplusGLSurfaceView_13, i2, i3);
        }
    }
}
