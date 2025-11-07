package androidx.loader.p051b;

import androidx.core.p035g.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Loader.java */
/* renamed from: androidx.loader.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class Loader<D> {

    /* renamed from: PlatformImplementations.kt_3 */
    int f3671a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    PlatformImplementations.kt_3<D> f3672b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean f3673c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean f3674d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean f3675e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean f3676f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    boolean f3677g;

    /* compiled from: Loader.java */
    /* renamed from: androidx.loader.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3<D> {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m3702b() {
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected boolean m3704d() {
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void m3706f() {
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected void m3708h() {
    }

    /* renamed from: OplusGLSurfaceView_15 */
    protected void m3710j() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3700a(PlatformImplementations.kt_3<D> aVar) {
        PlatformImplementations.kt_3<D> aVar2 = this.f3672b;
        if (aVar2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (aVar2 != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f3672b = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m3699a() {
        this.f3673c = true;
        this.f3675e = false;
        this.f3674d = false;
        m3702b();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m3703c() {
        return m3704d();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m3705e() {
        this.f3673c = false;
        m3706f();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m3707g() {
        this.f3674d = true;
        m3708h();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m3709i() {
        m3710j();
        this.f3675e = true;
        this.f3673c = false;
        this.f3674d = false;
        this.f3676f = false;
        this.f3677g = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m3698a(D IntrinsicsJvm.kt_5) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.m2527a(IntrinsicsJvm.kt_5, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.m2527a(this, sb);
        sb.append(" id_renamed=");
        sb.append(this.f3671a);
        sb.append("}");
        return sb.toString();
    }

    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public void m3701a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f3671a);
        printWriter.print(" mListener=");
        printWriter.println(this.f3672b);
        if (this.f3673c || this.f3676f || this.f3677g) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f3673c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f3676f);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f3677g);
        }
        if (this.f3674d || this.f3675e) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f3674d);
            printWriter.print(" mReset=");
            printWriter.println(this.f3675e);
        }
    }
}
