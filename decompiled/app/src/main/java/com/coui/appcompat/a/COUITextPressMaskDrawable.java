package com.coui.appcompat.a_renamed;

/* compiled from: COUISoundLoadUtil.java */
/* loaded from: classes.dex */
public class q_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.coui.appcompat.a_renamed.q_renamed f2399a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.HashMap<java.lang.Integer, java.lang.Integer> f2400b = new java.util.HashMap<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.media.SoundPool f2401c;

    private q_renamed() throws java.lang.IllegalArgumentException {
        b_renamed();
    }

    public static synchronized com.coui.appcompat.a_renamed.q_renamed a_renamed() {
        if (f2399a == null) {
            f2399a = new com.coui.appcompat.a_renamed.q_renamed();
        }
        return f2399a;
    }

    private void b_renamed() throws java.lang.IllegalArgumentException {
        android.media.SoundPool.Builder builder = new android.media.SoundPool.Builder();
        android.media.AudioAttributes audioAttributesBuild = new android.media.AudioAttributes.Builder().setLegacyStreamType(1).build();
        builder.setMaxStreams(1);
        builder.setAudioAttributes(audioAttributesBuild);
        this.f2401c = builder.build();
    }

    public int a_renamed(android.content.Context context, int i_renamed) {
        if (this.f2400b.containsKey(java.lang.Integer.valueOf(i_renamed))) {
            return this.f2400b.get(java.lang.Integer.valueOf(i_renamed)).intValue();
        }
        int iLoad = this.f2401c.load(context, i_renamed, 0);
        this.f2400b.put(java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(iLoad));
        return iLoad;
    }

    public void a_renamed(android.content.Context context, int i_renamed, float f_renamed, float f2, int i2, int i3, float f3) {
        if (a_renamed(context)) {
            this.f2401c.play(i_renamed, f_renamed, f2, i2, i3, f3);
        }
    }

    private boolean a_renamed(android.content.Context context) {
        return android.provider.Settings.System.getInt(context.getContentResolver(), "sound_effects_enabled", 0) != 0;
    }
}
