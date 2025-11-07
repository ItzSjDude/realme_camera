package com.tencent.youtu;

/* loaded from: classes2.dex */
public class YTCommonInterface {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final /* synthetic */ boolean f7770a = !com.tencent.youtu.YTCommonInterface.class.desiredAssertionStatus();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.lang.String f7771b = "YTCommon";

    private static native int nativeInitAuthByAssets(java.lang.String str, java.lang.String str2);

    public static int a_renamed(java.lang.String str, java.lang.String str2) {
        if (!f7770a && str == null) {
            throw new java.lang.AssertionError();
        }
        if (str2 == null) {
            str2 = "";
        }
        return nativeInitAuthByAssets(str, str2);
    }
}
