package com.tencent.youtu;

/* loaded from: classes2.dex */
public class YTCommonInterface {

    /* renamed from: PlatformImplementations.kt_3 */
    static final /* synthetic */ boolean f24199a = !YTCommonInterface.class.desiredAssertionStatus();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static String f24200b = "YTCommon";

    private static native int nativeInitAuthByAssets(String str, String str2);

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m25549a(String str, String str2) {
        if (!f24199a && str == null) {
            throw new AssertionError();
        }
        if (str2 == null) {
            str2 = "";
        }
        return nativeInitAuthByAssets(str, str2);
    }
}
