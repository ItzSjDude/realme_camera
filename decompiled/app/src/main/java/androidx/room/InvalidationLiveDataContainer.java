package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* compiled from: InvalidationLiveDataContainer.java */
/* renamed from: androidx.room.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
class InvalidationLiveDataContainer {

    /* renamed from: PlatformImplementations.kt_3 */
    final Set<LiveData> f4376a = Collections.newSetFromMap(new IdentityHashMap());

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final RoomDatabase f4377b;

    InvalidationLiveDataContainer(RoomDatabase abstractC0750g) {
        this.f4377b = abstractC0750g;
    }
}
