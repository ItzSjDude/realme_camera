package com.coui.appcompat.p099a;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.provider.Settings;
import java.util.HashMap;

/* compiled from: COUISoundLoadUtil.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.q */
/* loaded from: classes.dex */
public class COUISoundLoadUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static COUISoundLoadUtil f6344a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private HashMap<Integer, Integer> f6345b = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private SoundPool f6346c;

    private COUISoundLoadUtil() throws IllegalArgumentException {
        m6462b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized COUISoundLoadUtil m6460a() {
        if (f6344a == null) {
            f6344a = new COUISoundLoadUtil();
        }
        return f6344a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m6462b() throws IllegalArgumentException {
        SoundPool.Builder builder = new SoundPool.Builder();
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setLegacyStreamType(1).build();
        builder.setMaxStreams(1);
        builder.setAudioAttributes(audioAttributesBuild);
        this.f6346c = builder.build();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m6463a(Context context, int OplusGLSurfaceView_13) {
        if (this.f6345b.containsKey(Integer.valueOf(OplusGLSurfaceView_13))) {
            return this.f6345b.get(Integer.valueOf(OplusGLSurfaceView_13)).intValue();
        }
        int iLoad = this.f6346c.load(context, OplusGLSurfaceView_13, 0);
        this.f6345b.put(Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(iLoad));
        return iLoad;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6464a(Context context, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, float f2, int i2, int i3, float f3) {
        if (m6461a(context)) {
            this.f6346c.play(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, f2, i2, i3, f3);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m6461a(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "sound_effects_enabled", 0) != 0;
    }
}
