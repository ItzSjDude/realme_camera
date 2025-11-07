package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

/* compiled from: AudioAttributesImplApi21.java */
@TargetApi(21)
/* renamed from: androidx.media.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: PlatformImplementations.kt_3 */
    AudioAttributes f3686a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f3687b = -1;

    AudioAttributesImplApi21() {
    }

    public int hashCode() {
        return this.f3686a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f3686a.equals(((AudioAttributesImplApi21) obj).f3686a);
        }
        return false;
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f3686a;
    }
}
