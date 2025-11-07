package com.oplus.compat.media;

/* compiled from: AudioManagerNative.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static int f7465a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public static int f7466b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public static java.lang.String f7467c;

    private static void a_renamed(android.media.AudioManager audioManager, int i_renamed) {
    }

    static {
        try {
            if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
                f7465a = 7;
                f7467c = "android.media.VOLUME_CHANGED_ACTION";
                f7466b = 4096;
            }
        } catch (java.lang.Throwable th) {
            android.util.Log.e_renamed("AudioManagerNative", th.toString());
        }
    }

    public static void a_renamed(int i_renamed) throws com.oplus.compat.b_renamed.a_renamed.b_renamed {
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.d_renamed()) {
            com.oplus.epona.Request requestBuild = new com.oplus.epona.Request.Builder().setComponentName("android.media.AudioManager").setActionName("setRingerModeInternal").build();
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("ringerMode", i_renamed);
            requestBuild.putBundle(bundle);
            com.oplus.epona.Response responseExecute = com.oplus.epona.Epona.newCall(requestBuild).execute();
            if (responseExecute.isSuccessful()) {
                return;
            }
            android.util.Log.e_renamed("AudioManagerNative", "response code error:" + responseExecute.getCode());
            return;
        }
        if (com.oplus.compat.b_renamed.a_renamed.c_renamed.e_renamed()) {
            try {
                a_renamed((android.media.AudioManager) com.oplus.epona.Epona.getContext().getSystemService(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_AUDIO), i_renamed);
                return;
            } catch (java.lang.Throwable th) {
                android.util.Log.e_renamed("AudioManagerNative", th.toString());
                return;
            }
        }
        throw new com.oplus.compat.b_renamed.a_renamed.b_renamed("not supported before Q_renamed");
    }
}
