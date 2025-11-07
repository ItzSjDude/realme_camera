package androidx.media;

import java.util.Arrays;

/* compiled from: AudioAttributesImplBase.java */
/* renamed from: androidx.media.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: PlatformImplementations.kt_3 */
    int f3688a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f3689b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f3690c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    int f3691d = -1;

    AudioAttributesImplBase() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m3718a() {
        int OplusGLSurfaceView_13 = this.f3691d;
        return OplusGLSurfaceView_13 != -1 ? OplusGLSurfaceView_13 : AudioAttributesCompat.m3711a(false, this.f3690c, this.f3688a);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m3719b() {
        return this.f3689b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m3720c() {
        return this.f3688a;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m3721d() {
        int OplusGLSurfaceView_13 = this.f3690c;
        int iM3718a = m3718a();
        if (iM3718a == 6) {
            OplusGLSurfaceView_13 |= 4;
        } else if (iM3718a == 7) {
            OplusGLSurfaceView_13 |= 1;
        }
        return OplusGLSurfaceView_13 & 273;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3689b), Integer.valueOf(this.f3690c), Integer.valueOf(this.f3688a), Integer.valueOf(this.f3691d)});
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase c0624c = (AudioAttributesImplBase) obj;
        return this.f3689b == c0624c.m3719b() && this.f3690c == c0624c.m3721d() && this.f3688a == c0624c.m3720c() && this.f3691d == c0624c.f3691d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f3691d != -1) {
            sb.append(" stream=");
            sb.append(this.f3691d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.m3712a(this.f3688a));
        sb.append(" content=");
        sb.append(this.f3689b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f3690c).toUpperCase());
        return sb.toString();
    }
}
