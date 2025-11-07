package kotlinx.coroutines;

/* compiled from: Timeout.kt */
/* loaded from: classes2.dex */
public final class bp_renamed extends java.util.concurrent.CancellationException implements kotlinx.coroutines.r_renamed<kotlinx.coroutines.bp_renamed> {
    public final kotlinx.coroutines.ay_renamed coroutine;

    public bp_renamed(java.lang.String str, kotlinx.coroutines.ay_renamed ayVar) {
        super(str);
        this.coroutine = ayVar;
    }

    public bp_renamed(java.lang.String str) {
        this(str, null);
    }

    @Override // kotlinx.coroutines.r_renamed
    public kotlinx.coroutines.bp_renamed createCopy() {
        java.lang.String message = getMessage();
        if (message == null) {
            message = "";
        }
        kotlinx.coroutines.bp_renamed bpVar = new kotlinx.coroutines.bp_renamed(message, this.coroutine);
        bpVar.initCause(this);
        return bpVar;
    }
}
