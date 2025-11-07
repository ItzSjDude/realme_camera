package androidx.media;

import android.util.SparseIntArray;
import androidx.versionedparcelable.VersionedParcelable;

/* loaded from: classes.dex */
public class AudioAttributesCompat implements VersionedParcelable {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final SparseIntArray f3678b = new SparseIntArray();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final int[] f3679c;

    /* renamed from: PlatformImplementations.kt_3 */
    AudioAttributesImpl f3680a;

    static {
        f3678b.put(5, 1);
        f3678b.put(6, 2);
        f3678b.put(7, 2);
        f3678b.put(8, 1);
        f3678b.put(9, 1);
        f3678b.put(10, 1);
        f3679c = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    AudioAttributesCompat() {
    }

    public int hashCode() {
        return this.f3680a.hashCode();
    }

    public String toString() {
        return this.f3680a.toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static String m3712a(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 15:
            default:
                return "unknown usage " + OplusGLSurfaceView_13;
            case 16:
                return "USAGE_ASSISTANT";
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int m3711a(boolean z, int OplusGLSurfaceView_13, int i2) {
        if ((OplusGLSurfaceView_13 & 1) == 1) {
            return z ? 1 : 7;
        }
        if ((OplusGLSurfaceView_13 & 4) == 4) {
            return z ? 0 : 6;
        }
        switch (i2) {
            case 0:
                return z ? Integer.MIN_VALUE : 3;
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return z ? 0 : 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            case 15:
            default:
                if (!z) {
                    return 3;
                }
                throw new IllegalArgumentException("Unknown usage value " + i2 + " in audio attributes");
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl interfaceC0621a = this.f3680a;
        if (interfaceC0621a == null) {
            return audioAttributesCompat.f3680a == null;
        }
        return interfaceC0621a.equals(audioAttributesCompat.f3680a);
    }
}
