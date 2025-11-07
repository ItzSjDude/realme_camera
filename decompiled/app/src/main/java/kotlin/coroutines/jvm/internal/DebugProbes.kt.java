package kotlin.coroutines.jvm.internal;

import com.oplus.exif.OplusExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: DebugProbes.kt */
@Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, OplusGLSurfaceView_5 = 2, d1 = {"��\u0012\OplusGLSurfaceView_11��\OplusGLSurfaceView_11\u0002\u0018\u0002\OplusGLSurfaceView_11\u0002\IntrinsicsJvm.kt_4\u0003\OplusGLSurfaceView_11\u0002\u0010\u0002\OplusGLSurfaceView_11\u0002\IntrinsicsJvm.kt_4\u0003\u001a\"\u0010��\u001a\IntrinsicsJvm.kt_4\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\IntrinsicsJvm.kt_4��\u0010\u00022\COUIBaseListPopupWindow_12\u0010\u0003\u001a\IntrinsicsJvm.kt_4\u0012\u0004\u0012\u0002H\u00020\u0001H��\u001a\u0014\u0010\u0004\u001a\u00020\u00052\OplusGLSurfaceView_11\u0010\u0006\u001a\u0006\u0012\u0002\IntrinsicsJvm.kt_4\u00030\u0001H��\u001a\u0014\u0010\u0007\u001a\u00020\u00052\OplusGLSurfaceView_11\u0010\u0006\u001a\u0006\u0012\u0002\IntrinsicsJvm.kt_4\u00030\u0001H��¨\u0006\IntrinsicsJvm.kt_4"}, d2 = {"probeCoroutineCreated", "Lkotlin/coroutines/Continuation;", OplusExifInterface.GpsTrackRef.TRUE_DIRECTION, "completion", "probeCoroutineResumed", "", "frame", "probeCoroutineSuspended", "integration-testing_debugAgentTest"})
/* loaded from: app.apk:DebugProbes.kt.bin */
public final class DebugProbes.kt {
    @NotNull
    public static final <T> Continuation<T> probeCoroutineCreated(@NotNull Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return DebugProbesImpl.INSTANCE.probeCoroutineCreated$kotlinx_coroutines_core(continuation);
    }

    public static final void probeCoroutineResumed(@NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "frame");
        DebugProbesImpl.INSTANCE.probeCoroutineResumed$kotlinx_coroutines_core(continuation);
    }

    public static final void probeCoroutineSuspended(@NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "frame");
        DebugProbesImpl.INSTANCE.probeCoroutineSuspended$kotlinx_coroutines_core(continuation);
    }
}
