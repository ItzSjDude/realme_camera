package androidx.media;

/* compiled from: VolumeProviderCompatApi21.java */
/* loaded from: classes.dex */
class j_renamed {

    /* compiled from: VolumeProviderCompatApi21.java */
    public interface a_renamed {
        void a_renamed(int i_renamed);

        void b_renamed(int i_renamed);
    }

    public static java.lang.Object a_renamed(int i_renamed, int i2, int i3, final androidx.media.j_renamed.a_renamed aVar) {
        return new android.media.VolumeProvider(i_renamed, i2, i3) { // from class: androidx.media.j_renamed.1
            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i4) {
                aVar.a_renamed(i4);
            }

            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i4) {
                aVar.b_renamed(i4);
            }
        };
    }
}
