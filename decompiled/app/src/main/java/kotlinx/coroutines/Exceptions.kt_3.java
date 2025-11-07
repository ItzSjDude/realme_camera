package kotlinx.coroutines;

/* compiled from: Exceptions.kt */
/* loaded from: classes2.dex */
public final class az_renamed extends java.util.concurrent.CancellationException implements kotlinx.coroutines.r_renamed<kotlinx.coroutines.az_renamed> {
    public final kotlinx.coroutines.ay_renamed job;

    public az_renamed(java.lang.String str, java.lang.Throwable th, kotlinx.coroutines.ay_renamed ayVar) {
        super(str);
        this.job = ayVar;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // java.lang.Throwable
    public java.lang.Throwable fillInStackTrace() {
        if (kotlinx.coroutines.ac_renamed.b_renamed()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new java.lang.StackTraceElement[0]);
        return this;
    }

    @Override // kotlinx.coroutines.r_renamed
    public kotlinx.coroutines.az_renamed createCopy() {
        if (!kotlinx.coroutines.ac_renamed.b_renamed()) {
            return null;
        }
        java.lang.String message = getMessage();
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) message);
        return new kotlinx.coroutines.az_renamed(message, this, this.job);
    }

    @Override // java.lang.Throwable
    public java.lang.String toString() {
        return super.toString() + "; job=" + this.job;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj != this) {
            if (obj instanceof kotlinx.coroutines.az_renamed) {
                kotlinx.coroutines.az_renamed azVar = (kotlinx.coroutines.az_renamed) obj;
                if (!c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) azVar.getMessage(), (java.lang.Object) getMessage()) || !c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(azVar.job, this.job) || !c_renamed.f_renamed.b_renamed.h_renamed.a_renamed(azVar.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        java.lang.String message = getMessage();
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) message);
        int iHashCode = ((message.hashCode() * 31) + this.job.hashCode()) * 31;
        java.lang.Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }
}
