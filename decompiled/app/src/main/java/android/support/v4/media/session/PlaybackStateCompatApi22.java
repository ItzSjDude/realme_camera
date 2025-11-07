package android.support.v4.media.session;

/* loaded from: classes.dex */
class PlaybackStateCompatApi22 {
    public static android.os.Bundle getExtras(java.lang.Object obj) {
        return ((android.media.session.PlaybackState) obj).getExtras();
    }

    public static java.lang.Object newInstance(int i_renamed, long j_renamed, long j2, float f_renamed, long j3, java.lang.CharSequence charSequence, long j4, java.util.List<java.lang.Object> list, long j5, android.os.Bundle bundle) {
        android.media.session.PlaybackState.Builder builder = new android.media.session.PlaybackState.Builder();
        builder.setState(i_renamed, j_renamed, f_renamed, j4);
        builder.setBufferedPosition(j2);
        builder.setActions(j3);
        builder.setErrorMessage(charSequence);
        java.util.Iterator<java.lang.Object> it = list.iterator();
        while (it.hasNext()) {
            builder.addCustomAction((android.media.session.PlaybackState.CustomAction) it.next());
        }
        builder.setActiveQueueItemId(j5);
        builder.setExtras(bundle);
        return builder.build();
    }

    private PlaybackStateCompatApi22() {
    }
}
