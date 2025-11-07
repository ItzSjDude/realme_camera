package kotlinx.coroutines;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes2.dex */
public abstract class am_renamed extends kotlinx.coroutines.t_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private long f7797b;
    private boolean d_renamed;
    private kotlinx.coroutines.internal.a_renamed<kotlinx.coroutines.ah_renamed<?>> e_renamed;

    private final long c_renamed(boolean z_renamed) {
        if (z_renamed) {
            return com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1;
        }
        return 1L;
    }

    protected void h_renamed() {
    }

    public long b_renamed() {
        return !e_renamed() ? Long.MAX_VALUE : 0L;
    }

    protected boolean c_renamed() {
        return g_renamed();
    }

    protected long d_renamed() {
        kotlinx.coroutines.internal.a_renamed<kotlinx.coroutines.ah_renamed<?>> aVar = this.e_renamed;
        return (aVar == null || aVar.a_renamed()) ? Long.MAX_VALUE : 0L;
    }

    public final boolean e_renamed() {
        kotlinx.coroutines.ah_renamed<?> ahVarB;
        kotlinx.coroutines.internal.a_renamed<kotlinx.coroutines.ah_renamed<?>> aVar = this.e_renamed;
        if (aVar == null || (ahVarB = aVar.b_renamed()) == null) {
            return false;
        }
        ahVarB.run();
        return true;
    }

    public final void a_renamed(kotlinx.coroutines.ah_renamed<?> ahVar) {
        kotlinx.coroutines.internal.a_renamed<kotlinx.coroutines.ah_renamed<?>> aVar = this.e_renamed;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.internal.a_renamed<>();
            this.e_renamed = aVar;
        }
        aVar.a_renamed(ahVar);
    }

    public final boolean f_renamed() {
        return this.f7797b >= c_renamed(true);
    }

    public final boolean g_renamed() {
        kotlinx.coroutines.internal.a_renamed<kotlinx.coroutines.ah_renamed<?>> aVar = this.e_renamed;
        if (aVar != null) {
            return aVar.a_renamed();
        }
        return true;
    }

    public static /* synthetic */ void a_renamed(kotlinx.coroutines.am_renamed amVar, boolean z_renamed, int i_renamed, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in_renamed this target, function: incrementUseCount");
        }
        if ((i_renamed & 1) != 0) {
            z_renamed = false;
        }
        amVar.a_renamed(z_renamed);
    }

    public final void a_renamed(boolean z_renamed) {
        this.f7797b += c_renamed(z_renamed);
        if (z_renamed) {
            return;
        }
        this.d_renamed = true;
    }

    public final void b_renamed(boolean z_renamed) {
        this.f7797b -= c_renamed(z_renamed);
        if (this.f7797b > 0) {
            return;
        }
        if (kotlinx.coroutines.ac_renamed.a_renamed()) {
            if (!(this.f7797b == 0)) {
                throw new java.lang.AssertionError();
            }
        }
        if (this.d_renamed) {
            h_renamed();
        }
    }
}
