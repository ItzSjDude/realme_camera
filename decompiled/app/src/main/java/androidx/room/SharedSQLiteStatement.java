package androidx.room;

import androidx.p046f.p047a.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SharedSQLiteStatement.java */
/* renamed from: androidx.room.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public abstract class SharedSQLiteStatement {

    /* renamed from: PlatformImplementations.kt_3 */
    private final AtomicBoolean f4475a = new AtomicBoolean(false);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final RoomDatabase f4476b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private volatile SupportSQLiteStatement f4477c;

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract String mo4680a();

    public SharedSQLiteStatement(RoomDatabase abstractC0750g) {
        this.f4476b = abstractC0750g;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m4682b() {
        this.f4476b.m4643e();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private SupportSQLiteStatement m4679d() {
        return this.f4476b.m4635a(mo4680a());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private SupportSQLiteStatement m4678a(boolean z) {
        if (z) {
            if (this.f4477c == null) {
                this.f4477c = m4679d();
            }
            return this.f4477c;
        }
        return m4679d();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public SupportSQLiteStatement m4683c() {
        m4682b();
        return m4678a(this.f4475a.compareAndSet(false, true));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4681a(SupportSQLiteStatement interfaceC0565f) {
        if (interfaceC0565f == this.f4477c) {
            this.f4475a.set(false);
        }
    }
}
