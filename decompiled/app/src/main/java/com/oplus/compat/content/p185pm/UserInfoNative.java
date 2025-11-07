package com.oplus.compat.content.p185pm;

import android.content.pm.UserInfo;
import android.util.Log;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.inner.content.pm.UserInfoWrapper;
import com.oplus.utils.reflect.RefClass;
import com.oplus.utils.reflect.RefObject;

/* compiled from: UserInfoNative.java */
/* renamed from: com.oplus.compat.content.pm.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class UserInfoNative {

    /* renamed from: PlatformImplementations.kt_3 */
    private Object f23277a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private UserInfo f23278b;

    /* renamed from: PlatformImplementations.kt_3 */
    private static Object m24911a(Object obj) {
        return null;
    }

    /* compiled from: UserInfoNative.java */
    /* renamed from: com.oplus.compat.content.pm.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {
        public static RefObject<UserInfo> user;

        private PlatformImplementations.kt_3() {
        }

        static {
            RefClass.load((Class<?>) PlatformImplementations.kt_3.class, (Class<?>) UserInfoWrapper.class);
        }
    }

    public UserInfoNative(UserInfo userInfo) {
        this.f23278b = userInfo;
    }

    public UserInfoNative(Object obj) {
        try {
            if (VersionUtils.m24886b()) {
                this.f23277a = obj;
                this.f23278b = PlatformImplementations.kt_3.user.get(this.f23277a);
            } else {
                if (VersionUtils.m24889e()) {
                    this.f23277a = obj;
                    this.f23278b = (UserInfo) m24911a(this.f23277a);
                    return;
                }
                throw new UnSupportedApiVersionException();
            }
        } catch (Throwable th) {
            Log.COUIBaseListPopupWindow_8("UserInfoNative", th.toString());
        }
    }
}
