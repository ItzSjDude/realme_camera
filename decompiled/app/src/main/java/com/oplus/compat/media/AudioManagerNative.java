package com.oplus.compat.media;

import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p183b.p184a.VersionUtils;
import com.oplus.epona.Epona;
import com.oplus.epona.Request;
import com.oplus.epona.Response;

/* compiled from: AudioManagerNative.java */
/* renamed from: com.oplus.compat.media.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class AudioManagerNative {

    /* renamed from: PlatformImplementations.kt_3 */
    public static int f23279a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int f23280b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static String f23281c;

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m24917a(AudioManager audioManager, int OplusGLSurfaceView_13) {
    }

    static {
        try {
            if (VersionUtils.m24889e()) {
                f23279a = 7;
                f23281c = "android.media.VOLUME_CHANGED_ACTION";
                f23280b = 4096;
            }
        } catch (Throwable th) {
            Log.COUIBaseListPopupWindow_8("AudioManagerNative", th.toString());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24916a(int OplusGLSurfaceView_13) throws UnSupportedApiVersionException {
        if (VersionUtils.m24888d()) {
            Request requestBuild = new Request.Builder().setComponentName("android.media.AudioManager").setActionName("setRingerModeInternal").build();
            Bundle bundle = new Bundle();
            bundle.putInt("ringerMode", OplusGLSurfaceView_13);
            requestBuild.putBundle(bundle);
            Response responseExecute = Epona.newCall(requestBuild).execute();
            if (responseExecute.isSuccessful()) {
                return;
            }
            Log.COUIBaseListPopupWindow_8("AudioManagerNative", "response code error:" + responseExecute.getCode());
            return;
        }
        if (VersionUtils.m24889e()) {
            try {
                m24917a((AudioManager) Epona.getContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO), OplusGLSurfaceView_13);
                return;
            } catch (Throwable th) {
                Log.COUIBaseListPopupWindow_8("AudioManagerNative", th.toString());
                return;
            }
        }
        throw new UnSupportedApiVersionException("not supported before Q");
    }
}
