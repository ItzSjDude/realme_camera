package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public final class SinglePeriodTimeline extends com.google.android.exoplayer2.Timeline {
    private static final java.lang.Object UID = new java.lang.Object();
    private final boolean isDynamic;
    private final boolean isSeekable;
    private final long periodDurationUs;
    private final long presentationStartTimeMs;
    private final java.lang.Object tag;
    private final long windowDefaultStartPositionUs;
    private final long windowDurationUs;
    private final long windowPositionInPeriodUs;
    private final long windowStartTimeMs;

    @Override // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        return 1;
    }

    public SinglePeriodTimeline(long j_renamed, boolean z_renamed, boolean z2) {
        this(j_renamed, z_renamed, z2, null);
    }

    public SinglePeriodTimeline(long j_renamed, boolean z_renamed, boolean z2, java.lang.Object obj) {
        this(j_renamed, j_renamed, 0L, 0L, z_renamed, z2, obj);
    }

    public SinglePeriodTimeline(long j_renamed, long j2, long j3, long j4, boolean z_renamed, boolean z2, java.lang.Object obj) {
        this(-9223372036854775807L, -9223372036854775807L, j_renamed, j2, j3, j4, z_renamed, z2, obj);
    }

    public SinglePeriodTimeline(long j_renamed, long j2, long j3, long j4, long j5, long j6, boolean z_renamed, boolean z2, java.lang.Object obj) {
        this.presentationStartTimeMs = j_renamed;
        this.windowStartTimeMs = j2;
        this.periodDurationUs = j3;
        this.windowDurationUs = j4;
        this.windowPositionInPeriodUs = j5;
        this.windowDefaultStartPositionUs = j6;
        this.isSeekable = z_renamed;
        this.isDynamic = z2;
        this.tag = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0030 A_renamed[PHI: r1
      0x0030: PHI (r1v4 long) = (r1v3 long), (r1v3 long), (r1v5 long) binds: [B_renamed:7:0x0019, B_renamed:9:0x001f, B_renamed:14:0x002d] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.Timeline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.exoplayer2.Timeline.Window getWindow(int r19, com.google.android.exoplayer2.Timeline.Window r20, boolean r21, long r22) {
        /*
            r18 = this;
            r0 = r18
            r1 = 0
            r2 = 1
            r3 = r19
            com.google.android.exoplayer2.util.Assertions.checkIndex(r3, r1, r2)
            if (r21 == 0) goto Le
            java.lang.Object r1 = r0.tag
            goto Lf
        Le:
            r1 = 0
        Lf:
            r3 = r1
            long r1 = r0.windowDefaultStartPositionUs
            boolean r4 = r0.isDynamic
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L30
            r7 = 0
            int r4 = (r22 > r7 ? 1 : (r22 == r7 ? 0 : -1))
            if (r4 == 0) goto L30
            long r7 = r0.windowDurationUs
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 != 0) goto L29
        L27:
            r10 = r5
            goto L31
        L29:
            long r1 = r1 + r22
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 <= 0) goto L30
            goto L27
        L30:
            r10 = r1
        L31:
            long r4 = r0.presentationStartTimeMs
            long r6 = r0.windowStartTimeMs
            boolean r8 = r0.isSeekable
            boolean r9 = r0.isDynamic
            long r12 = r0.windowDurationUs
            r14 = 0
            r15 = 0
            long r0 = r0.windowPositionInPeriodUs
            r2 = r20
            r16 = r0
            com.google.android.exoplayer2.Timeline$Window r0 = r2.set(r3, r4, r6, r8, r9, r10, r12, r14, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SinglePeriodTimeline.getWindow(int, com.google.android.exoplayer2.Timeline$Window, boolean, long):com.google.android.exoplayer2.Timeline$Window");
    }

    @Override // com.google.android.exoplayer2.Timeline
    public com.google.android.exoplayer2.Timeline.Period getPeriod(int i_renamed, com.google.android.exoplayer2.Timeline.Period period, boolean z_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkIndex(i_renamed, 0, 1);
        return period.set(null, z_renamed ? UID : null, 0, this.periodDurationUs, -this.windowPositionInPeriodUs);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getIndexOfPeriod(java.lang.Object obj) {
        return UID.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public java.lang.Object getUidOfPeriod(int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkIndex(i_renamed, 0, 1);
        return UID;
    }
}
