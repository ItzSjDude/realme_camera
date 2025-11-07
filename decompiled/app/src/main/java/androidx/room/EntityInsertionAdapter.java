package androidx.room;

import androidx.p046f.p047a.SupportSQLiteStatement;

/* compiled from: EntityInsertionAdapter.java */
/* renamed from: androidx.room.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo4588a(SupportSQLiteStatement interfaceC0565f, T t);

    public EntityInsertionAdapter(RoomDatabase abstractC0750g) {
        super(abstractC0750g);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m4589a(T t) {
        SupportSQLiteStatement interfaceC0565fC = m4683c();
        try {
            mo4588a(interfaceC0565fC, t);
            interfaceC0565fC.mo3277b();
        } finally {
            m4681a(interfaceC0565fC);
        }
    }
}
