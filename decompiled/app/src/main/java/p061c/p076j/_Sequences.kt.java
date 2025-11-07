package p061c.p076j;

import com.android.providers.downloads.Downloads;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p061c.p062a.C0887h;
import p061c.p070f.p072b.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Sequences.kt */
/* renamed from: IntrinsicsJvm.kt_3.OplusGLSurfaceView_15.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class _Sequences.kt extends _SequencesJvm.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final <T, C extends Collection<? super T>> C m5343a(Sequence.kt<? extends T> interfaceC0994b, C c2) {
        Intrinsics.m5305d(interfaceC0994b, "$this$toCollection");
        Intrinsics.m5305d(c2, Downloads.Impl.COLUMN_DESTINATION);
        Iterator<? extends T> itMo5340a = interfaceC0994b.mo5340a();
        while (itMo5340a.hasNext()) {
            c2.add(itMo5340a.next());
        }
        return c2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final <T> List<T> m5344b(Sequence.kt<? extends T> interfaceC0994b) {
        Intrinsics.m5305d(interfaceC0994b, "$this$toList");
        return C0887h.m5228a(C0995c.m5345c(interfaceC0994b));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final <T> List<T> m5345c(Sequence.kt<? extends T> interfaceC0994b) {
        Intrinsics.m5305d(interfaceC0994b, "$this$toMutableList");
        return (List) C0995c.m5343a(interfaceC0994b, new ArrayList());
    }
}
