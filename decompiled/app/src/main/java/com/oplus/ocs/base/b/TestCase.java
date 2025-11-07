package com.oplus.ocs.base.b_renamed;

/* loaded from: classes2.dex */
public final class e_renamed {
    public static com.oplus.ocs.base.b_renamed.e_renamed.a_renamed a_renamed(java.lang.Object obj) {
        return new com.oplus.ocs.base.b_renamed.e_renamed.a_renamed(obj);
    }

    public static boolean a_renamed(java.lang.Object obj, java.lang.Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private java.lang.Object f7517a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.util.List<java.lang.String> f7518b = new java.util.ArrayList();

        public a_renamed(java.lang.Object obj) {
            this.f7517a = com.oplus.ocs.base.b_renamed.d_renamed.a_renamed(obj);
        }

        public final com.oplus.ocs.base.b_renamed.e_renamed.a_renamed a_renamed(java.lang.String str, java.lang.Object obj) {
            this.f7518b.add(com.oplus.ocs.base.b_renamed.d_renamed.a_renamed(str + "=" + obj));
            return this;
        }

        public final java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(100);
            sb.append(this.f7517a.getClass().getSimpleName());
            sb.append('{');
            int size = this.f7518b.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                sb.append(this.f7518b.get(i_renamed));
                if (i_renamed < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }
}
