package com.oplus.anim.p115c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: KeyPath.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class KeyPath {

    /* renamed from: PlatformImplementations.kt_3 */
    private final List<String> f10312a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private KeyPathElement f10313b;

    public KeyPath(String... strArr) {
        this.f10312a = Arrays.asList(strArr);
    }

    private KeyPath(KeyPath c2357f) {
        this.f10312a = new ArrayList(c2357f.f10312a);
        this.f10313b = c2357f.f10313b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public KeyPath m9136a(String str) {
        KeyPath c2357f = new KeyPath(this);
        c2357f.f10312a.add(str);
        return c2357f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public KeyPath m9135a(KeyPathElement interfaceC2358g) {
        KeyPath c2357f = new KeyPath(this);
        c2357f.f10313b = interfaceC2358g;
        return c2357f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public KeyPathElement m9137a() {
        return this.f10313b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m9138a(String str, int OplusGLSurfaceView_13) {
        if (m9134b(str)) {
            return true;
        }
        if (OplusGLSurfaceView_13 >= this.f10312a.size()) {
            return false;
        }
        return this.f10312a.get(OplusGLSurfaceView_13).equals(str) || this.f10312a.get(OplusGLSurfaceView_13).equals("**") || this.f10312a.get(OplusGLSurfaceView_13).equals("*");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m9139b(String str, int OplusGLSurfaceView_13) {
        if (m9134b(str)) {
            return 0;
        }
        if (this.f10312a.get(OplusGLSurfaceView_13).equals("**")) {
            return (OplusGLSurfaceView_13 != this.f10312a.size() - 1 && this.f10312a.get(OplusGLSurfaceView_13 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m9140c(String str, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 >= this.f10312a.size()) {
            return false;
        }
        boolean z = OplusGLSurfaceView_13 == this.f10312a.size() - 1;
        String str2 = this.f10312a.get(OplusGLSurfaceView_13);
        if (!str2.equals("**")) {
            return (z || (OplusGLSurfaceView_13 == this.f10312a.size() + (-2) && m9133b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.f10312a.get(OplusGLSurfaceView_13 + 1).equals(str)) {
            return OplusGLSurfaceView_13 == this.f10312a.size() + (-2) || (OplusGLSurfaceView_13 == this.f10312a.size() + (-3) && m9133b());
        }
        if (z) {
            return true;
        }
        int i2 = OplusGLSurfaceView_13 + 1;
        if (i2 < this.f10312a.size() - 1) {
            return false;
        }
        return this.f10312a.get(i2).equals(str);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m9141d(String str, int OplusGLSurfaceView_13) {
        return "__container".equals(str) || OplusGLSurfaceView_13 < this.f10312a.size() - 1 || this.f10312a.get(OplusGLSurfaceView_13).equals("**");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m9134b(String str) {
        return "__container".equals(str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m9133b() {
        return this.f10312a.get(r1.size() - 1).equals("**");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f10312a);
        sb.append(",resolved=");
        sb.append(this.f10313b != null);
        sb.append('}');
        return sb.toString();
    }
}
