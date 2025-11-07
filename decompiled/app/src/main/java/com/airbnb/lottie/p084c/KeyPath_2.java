package com.airbnb.lottie.p084c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: KeyPath.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class KeyPath_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final KeyPath_2 f5698a = new KeyPath_2("COMPOSITION");

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final List<String> f5699b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private KeyPathElement_2 f5700c;

    public KeyPath_2(String... strArr) {
        this.f5699b = Arrays.asList(strArr);
    }

    private KeyPath_2(KeyPath_2 c1131e) {
        this.f5699b = new ArrayList(c1131e.f5699b);
        this.f5700c = c1131e.f5700c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public KeyPath_2 m5828a(String str) {
        KeyPath_2 c1131e = new KeyPath_2(this);
        c1131e.f5699b.add(str);
        return c1131e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public KeyPath_2 m5827a(KeyPathElement_2 interfaceC1132f) {
        KeyPath_2 c1131e = new KeyPath_2(this);
        c1131e.f5700c = interfaceC1132f;
        return c1131e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public KeyPathElement_2 m5829a() {
        return this.f5700c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m5830a(String str, int OplusGLSurfaceView_13) {
        if (m5826b(str)) {
            return true;
        }
        if (OplusGLSurfaceView_13 >= this.f5699b.size()) {
            return false;
        }
        return this.f5699b.get(OplusGLSurfaceView_13).equals(str) || this.f5699b.get(OplusGLSurfaceView_13).equals("**") || this.f5699b.get(OplusGLSurfaceView_13).equals("*");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m5831b(String str, int OplusGLSurfaceView_13) {
        if (m5826b(str)) {
            return 0;
        }
        if (this.f5699b.get(OplusGLSurfaceView_13).equals("**")) {
            return (OplusGLSurfaceView_13 != this.f5699b.size() - 1 && this.f5699b.get(OplusGLSurfaceView_13 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m5832c(String str, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 >= this.f5699b.size()) {
            return false;
        }
        boolean z = OplusGLSurfaceView_13 == this.f5699b.size() - 1;
        String str2 = this.f5699b.get(OplusGLSurfaceView_13);
        if (!str2.equals("**")) {
            return (z || (OplusGLSurfaceView_13 == this.f5699b.size() + (-2) && m5825b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.f5699b.get(OplusGLSurfaceView_13 + 1).equals(str)) {
            return OplusGLSurfaceView_13 == this.f5699b.size() + (-2) || (OplusGLSurfaceView_13 == this.f5699b.size() + (-3) && m5825b());
        }
        if (z) {
            return true;
        }
        int i2 = OplusGLSurfaceView_13 + 1;
        if (i2 < this.f5699b.size() - 1) {
            return false;
        }
        return this.f5699b.get(i2).equals(str);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m5833d(String str, int OplusGLSurfaceView_13) {
        return "__container".equals(str) || OplusGLSurfaceView_13 < this.f5699b.size() - 1 || this.f5699b.get(OplusGLSurfaceView_13).equals("**");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m5826b(String str) {
        return "__container".equals(str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m5825b() {
        return this.f5699b.get(r1.size() - 1).equals("**");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f5699b);
        sb.append(",resolved=");
        sb.append(this.f5700c != null);
        sb.append('}');
        return sb.toString();
    }
}
