package androidx.media;

/* loaded from: classes.dex */
public class AudioAttributesCompat implements androidx.versionedparcelable.c_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final android.util.SparseIntArray f1265b = new android.util.SparseIntArray();

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final int[] f1266c;

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.media.a_renamed f1267a;

    static {
        f1265b.put(5, 1);
        f1265b.put(6, 2);
        f1265b.put(7, 2);
        f1265b.put(8, 1);
        f1265b.put(9, 1);
        f1265b.put(10, 1);
        f1266c = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    AudioAttributesCompat() {
    }

    public int hashCode() {
        return this.f1267a.hashCode();
    }

    public java.lang.String toString() {
        return this.f1267a.toString();
    }

    static java.lang.String a_renamed(int i_renamed) {
        switch (i_renamed) {
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
                return "unknown usage " + i_renamed;
            case 16:
                return "USAGE_ASSISTANT";
        }
    }

    static int a_renamed(boolean z_renamed, int i_renamed, int i2) {
        if ((i_renamed & 1) == 1) {
            return z_renamed ? 1 : 7;
        }
        if ((i_renamed & 4) == 4) {
            return z_renamed ? 0 : 6;
        }
        switch (i2) {
            case 0:
                return z_renamed ? Integer.MIN_VALUE : 3;
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return z_renamed ? 0 : 8;
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
                if (!z_renamed) {
                    return 3;
                }
                throw new java.lang.IllegalArgumentException("Unknown usage value " + i2 + " in_renamed audio attributes");
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof androidx.media.AudioAttributesCompat)) {
            return false;
        }
        androidx.media.AudioAttributesCompat audioAttributesCompat = (androidx.media.AudioAttributesCompat) obj;
        androidx.media.a_renamed aVar = this.f1267a;
        if (aVar == null) {
            return audioAttributesCompat.f1267a == null;
        }
        return aVar.equals(audioAttributesCompat.f1267a);
    }
}
