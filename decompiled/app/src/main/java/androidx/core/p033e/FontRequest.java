package androidx.core.p033e;

import android.util.Base64;
import androidx.core.p035g.Preconditions;
import java.util.List;

/* compiled from: FontRequest.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public final class FontRequest {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f2841a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final String f2842b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final String f2843c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final List<List<byte[]>> f2844d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final int f2845e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final String f2846f;

    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f2841a = (String) Preconditions.m2536a(str);
        this.f2842b = (String) Preconditions.m2536a(str2);
        this.f2843c = (String) Preconditions.m2536a(str3);
        this.f2844d = (List) Preconditions.m2536a(list);
        this.f2846f = this.f2841a + "-" + this.f2842b + "-" + this.f2843c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m2450a() {
        return this.f2841a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m2451b() {
        return this.f2842b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public String m2452c() {
        return this.f2843c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public List<List<byte[]>> m2453d() {
        return this.f2844d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m2454e() {
        return this.f2845e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public String m2455f() {
        return this.f2846f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f2841a + ", mProviderPackage: " + this.f2842b + ", mQuery: " + this.f2843c + ", mCertificates:");
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f2844d.size(); OplusGLSurfaceView_13++) {
            sb.append(" [");
            List<byte[]> list = this.f2844d.get(OplusGLSurfaceView_13);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f2845e);
        return sb.toString();
    }
}
