package com.oplus.statistics.b_renamed;

/* compiled from: PageVisitBean.java */
/* loaded from: classes2.dex */
public class h_renamed extends com.oplus.statistics.b_renamed.m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f7659a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private long f7660b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f7661c;

    @Override // com.oplus.statistics.b_renamed.m_renamed
    public int b_renamed() {
        return com.heytap.accessory.CommonStatusCodes.TIME_EXPIRED;
    }

    public h_renamed(android.content.Context context) {
        super(context);
    }

    public java.lang.String a_renamed() {
        return this.f7659a;
    }

    public void a_renamed(java.lang.String str) {
        this.f7659a = str;
        a_renamed("time", this.f7659a);
    }

    public long c_renamed() {
        return this.f7660b;
    }

    public void a_renamed(long j_renamed) {
        this.f7660b = j_renamed;
        a_renamed(com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, this.f7660b);
    }

    public java.lang.String d_renamed() {
        return this.f7661c;
    }

    public void b_renamed(java.lang.String str) {
        this.f7661c = str;
        a_renamed("activities", this.f7661c);
    }

    public java.lang.String toString() {
        return "time is_renamed :" + a_renamed() + "\nduration is_renamed :" + c_renamed() + "\nactivities is_renamed :" + d_renamed() + "\n_renamed";
    }
}
