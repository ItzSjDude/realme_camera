package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes.dex */
public final class Track {
    public static final int TRANSFORMATION_CEA608_CDAT = 1;
    public static final int TRANSFORMATION_NONE = 0;
    public final long durationUs;
    public final long[] editListDurations;
    public final long[] editListMediaTimes;
    public final com.google.android.exoplayer2.Format format;
    public final int id_renamed;
    public final long movieTimescale;
    public final int nalUnitLengthFieldLength;
    private final com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] sampleDescriptionEncryptionBoxes;
    public final int sampleTransformation;
    public final long timescale;
    public final int type;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Transformation {
    }

    public Track(int i_renamed, int i2, long j_renamed, long j2, long j3, com.google.android.exoplayer2.Format format, int i3, com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] trackEncryptionBoxArr, int i4, long[] jArr, long[] jArr2) {
        this.id_renamed = i_renamed;
        this.type = i2;
        this.timescale = j_renamed;
        this.movieTimescale = j2;
        this.durationUs = j3;
        this.format = format;
        this.sampleTransformation = i3;
        this.sampleDescriptionEncryptionBoxes = trackEncryptionBoxArr;
        this.nalUnitLengthFieldLength = i4;
        this.editListDurations = jArr;
        this.editListMediaTimes = jArr2;
    }

    public com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox getSampleDescriptionEncryptionBox(int i_renamed) {
        com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] trackEncryptionBoxArr = this.sampleDescriptionEncryptionBoxes;
        if (trackEncryptionBoxArr == null) {
            return null;
        }
        return trackEncryptionBoxArr[i_renamed];
    }
}
