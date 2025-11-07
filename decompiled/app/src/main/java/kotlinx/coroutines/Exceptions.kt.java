package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: Exceptions.kt */
/* renamed from: kotlinx.coroutines.az */
/* loaded from: classes2.dex */
public final class Exceptions.kt extends CancellationException implements Debug.common.kt<Exceptions.kt> {
    public final Job.kt_5 job;

    public Exceptions.kt(String str, Throwable th, Job.kt_5 interfaceC3881ay) {
        super(str);
        this.job = interfaceC3881ay;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (Debug.kt.m25575b()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // kotlinx.coroutines.Debug.common.kt
    public Exceptions.kt createCopy() {
        if (!Debug.kt.m25575b()) {
            return null;
        }
        String message = getMessage();
        Intrinsics.m5296a((Object) message);
        return new Exceptions.kt(message, this, this.job);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Exceptions.kt) {
                Exceptions.kt c3882az = (Exceptions.kt) obj;
                if (!Intrinsics.m5299a((Object) c3882az.getMessage(), (Object) getMessage()) || !Intrinsics.m5299a(c3882az.job, this.job) || !Intrinsics.m5299a(c3882az.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String message = getMessage();
        Intrinsics.m5296a((Object) message);
        int iHashCode = ((message.hashCode() * 31) + this.job.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }
}
