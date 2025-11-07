package kotlin.coroutines.jvm.internal;

/* compiled from: DebugProbes.kt */
@kotlin.Metadata(mv = {1, 4, 0}, bv_renamed = {1, 0, 3}, k_renamed = 2, d1 = {"��\u0012\n_renamed��\n_renamed\u0002\u0018\u0002\n_renamed\u0002\b_renamed\u0003\n_renamed\u0002\u0010\u0002\n_renamed\u0002\b_renamed\u0003\u001a\"\u0010��\u001a\b_renamed\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b_renamed��\u0010\u00022\f_renamed\u0010\u0003\u001a\b_renamed\u0012\u0004\u0012\u0002H\u00020\u0001H��\u001a\u0014\u0010\u0004\u001a\u00020\u00052\n_renamed\u0010\u0006\u001a\u0006\u0012\u0002\b_renamed\u00030\u0001H��\u001a\u0014\u0010\u0007\u001a\u00020\u00052\n_renamed\u0010\u0006\u001a\u0006\u0012\u0002\b_renamed\u00030\u0001H��¨\u0006\b_renamed"}, d2 = {"probeCoroutineCreated", "Lkotlin/coroutines/Continuation;", com.oplus.exif.OplusExifInterface.GpsTrackRef.TRUE_DIRECTION, "completion", "probeCoroutineResumed", "", "frame", "probeCoroutineSuspended", "integration-testing_debugAgentTest"})
/* loaded from: app.apk:DebugProbes.kt_2.bin */
public final class DebugProbes.kt_2 {
    @org.jetbrains.annotations.NotNull
    public static final <T_renamed> kotlin.coroutines.Continuation<T_renamed> probeCoroutineCreated(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T_renamed> continuation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(continuation, "completion");
        return kotlinx.coroutines.debug.internal.DebugProbesImpl.INSTANCE.probeCoroutineCreated$kotlinx_coroutines_core(continuation);
    }

    public static final void probeCoroutineResumed(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(continuation, "frame");
        kotlinx.coroutines.debug.internal.DebugProbesImpl.INSTANCE.probeCoroutineResumed$kotlinx_coroutines_core(continuation);
    }

    public static final void probeCoroutineSuspended(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(continuation, "frame");
        kotlinx.coroutines.debug.internal.DebugProbesImpl.INSTANCE.probeCoroutineSuspended$kotlinx_coroutines_core(continuation);
    }
}
