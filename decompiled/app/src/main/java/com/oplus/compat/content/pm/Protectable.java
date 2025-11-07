package com.oplus.compat.content.pm;

/* compiled from: UserInfoNative.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.Object f7463a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.pm.UserInfo f7464b;

    private static java.lang.Object a_renamed(java.lang.Object obj) {
        return null;
    }

    /* compiled from: UserInfoNative.java */
    private static class a_renamed {
        public static com.oplus.utils.reflect.RefObject<android.content.pm.UserInfo> user;

        private a_renamed() {
        }

        static {
            com.oplus.utils.reflect.RefClass.load((java.lang.Class<?>) com.oplus.compat.content.pm.c_renamed.a_renamed.class, (java.lang.Class<?>) com.oplus.inner.content.pm.UserInfoWrapper.class);
        }
    }

    public c_renamed(android.content.pm.UserInfo userInfo) {
        this.f7464b = userInfo;
    }

    public c_renamed(java.lang.Object obj) {
        try {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.b_renamed()) {
                this.f7463a = obj;
                this.f7464b = com.oplus.compat.content.pm.c_renamed.a_renamed.user.get(this.f7463a);
            } else {
                if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
                    this.f7463a = obj;
                    this.f7464b = (android.content.pm.UserInfo) a_renamed(this.f7463a);
                    return;
                }
                throw new com.oplus.compat.b_renamed.a_renamed.b_renamed();
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.e_renamed("UserInfoNative", th.toString());
        }
    }
}
