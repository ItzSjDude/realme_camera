package com.oplus.tblplayer.misc;

/* loaded from: classes2.dex */
public interface ITrackInfo {
    public static final int MEDIA_TRACK_TYPE_AUDIO = 2;
    public static final int MEDIA_TRACK_TYPE_METADATA = 5;
    public static final int MEDIA_TRACK_TYPE_SUBTITLE = 4;
    public static final int MEDIA_TRACK_TYPE_TIMEDTEXT = 3;
    public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0;
    public static final int MEDIA_TRACK_TYPE_VIDEO = 1;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface TrackType {
    }

    com.oplus.tblplayer.misc.IMediaFormat getFormat();

    java.lang.String getLanguage();

    int getTrackType();

    java.lang.String toLineString();
}
