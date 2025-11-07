package com.oplus.statistics.p202d;

import android.text.TextUtils;
import com.oplus.statistics.p204f.LogUtil;
import com.oplus.statistics.p204f.Supplier;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MemoryPreference.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class MemoryPreference {

    /* renamed from: PlatformImplementations.kt_3 */
    private Map<String, String> f23877a = new HashMap();

    /* renamed from: PlatformImplementations.kt_3 */
    public String m25359a(String str, String str2) {
        String str3 = this.f23877a.get(str);
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m25361b(String str, String str2) {
        this.f23877a.put(str, str2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public long m25358a(final String str, long OplusGLSurfaceView_15) {
        final String str2 = this.f23877a.get(str);
        if (TextUtils.isEmpty(str2)) {
            return OplusGLSurfaceView_15;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException COUIBaseListPopupWindow_8) {
            LogUtil.m25431b("MemoryPreference", new Supplier() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_5.-$$Lambda$PlatformImplementations.kt_3$KQpm2XCU6ZhIY0zoE370SZfZbNk
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return MemoryPreference.m25356b(str, str2, COUIBaseListPopupWindow_8);
                }
            });
            return OplusGLSurfaceView_15;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ String m25356b(String str, String str2, NumberFormatException numberFormatException) {
        return "getLong key=" + str + ", value=" + str2 + ", exception=" + numberFormatException.toString();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m25360b(String str, long OplusGLSurfaceView_15) {
        this.f23877a.put(str, String.valueOf(OplusGLSurfaceView_15));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m25357a(final String str, int OplusGLSurfaceView_13) {
        final String str2 = this.f23877a.get(str);
        if (TextUtils.isEmpty(str2)) {
            return OplusGLSurfaceView_13;
        }
        try {
            return Integer.parseInt(str2);
        } catch (NumberFormatException COUIBaseListPopupWindow_8) {
            LogUtil.m25431b("MemoryPreference", new Supplier() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_5.-$$Lambda$PlatformImplementations.kt_3$7TiW2JTjmCtRUrOfwBFxyKeuSEs
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return MemoryPreference.m25355a(str, str2, COUIBaseListPopupWindow_8);
                }
            });
            return OplusGLSurfaceView_13;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ String m25355a(String str, String str2, NumberFormatException numberFormatException) {
        return "getInt key=" + str + ", value=" + str2 + ", exception=" + numberFormatException.toString();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m25362c(String str, long OplusGLSurfaceView_15) {
        this.f23877a.put(str, String.valueOf(OplusGLSurfaceView_15));
    }
}
