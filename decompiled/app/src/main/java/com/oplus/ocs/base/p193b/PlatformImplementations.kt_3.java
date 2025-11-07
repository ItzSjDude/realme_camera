package com.oplus.ocs.base.p193b;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.oplus.ocs.base.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public final class C3646e {
    /* renamed from: PlatformImplementations.kt_3 */
    public static PlatformImplementations.kt_3 m25033a(Object obj) {
        return new PlatformImplementations.kt_3(obj);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m25034a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* renamed from: com.oplus.ocs.base.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private Object f23387a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private List<String> f23388b = new ArrayList();

        public PlatformImplementations.kt_3(Object obj) {
            this.f23387a = C3645d.m25029a(obj);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final PlatformImplementations.kt_3 m25035a(String str, Object obj) {
            this.f23388b.add(C3645d.m25031a(str + "=" + obj));
            return this;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f23387a.getClass().getSimpleName());
            sb.append('{');
            int size = this.f23388b.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                sb.append(this.f23388b.get(OplusGLSurfaceView_13));
                if (OplusGLSurfaceView_13 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }
}
