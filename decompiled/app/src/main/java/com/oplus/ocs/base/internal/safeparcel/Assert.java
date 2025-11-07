package com.oplus.ocs.base.internal.safeparcel;

/* loaded from: classes2.dex */
public final class a_renamed {
    public static int a_renamed(android.os.Parcel parcel, int i_renamed) {
        c_renamed(parcel, i_renamed);
        return parcel.readInt();
    }

    public static int b_renamed(android.os.Parcel parcel, int i_renamed) {
        return (i_renamed & (-65536)) != -65536 ? (i_renamed >> 16) & com.meicam.sdk.NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN : parcel.readInt();
    }

    private static void c_renamed(android.os.Parcel parcel, int i_renamed) {
        int iB = b_renamed(parcel, i_renamed);
        if (iB == 4) {
            return;
        }
        throw new com.oplus.ocs.base.internal.safeparcel.a_renamed.C0144a("Expected size 4 got " + iB + " (0x" + java.lang.Integer.toHexString(iB) + ")");
    }

    /* renamed from: com.oplus.ocs.base.internal.safeparcel.a_renamed$a_renamed, reason: collision with other inner class name */
    public static class C0144a extends java.lang.RuntimeException {
        public C0144a(java.lang.String str) {
            super(str);
        }
    }
}
