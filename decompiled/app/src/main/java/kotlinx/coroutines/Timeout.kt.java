package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* compiled from: Timeout.kt */
/* renamed from: kotlinx.coroutines.bp */
/* loaded from: classes2.dex */
public final class Timeout.kt extends CancellationException implements Debug.common.kt<Timeout.kt> {
    public final Job.kt_5 coroutine;

    public Timeout.kt(String str, Job.kt_5 interfaceC3881ay) {
        super(str);
        this.coroutine = interfaceC3881ay;
    }

    public Timeout.kt(String str) {
        this(str, null);
    }

    @Override // kotlinx.coroutines.Debug.common.kt
    public Timeout.kt createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        Timeout.kt c3913bp = new Timeout.kt(message, this.coroutine);
        c3913bp.initCause(this);
        return c3913bp;
    }
}
