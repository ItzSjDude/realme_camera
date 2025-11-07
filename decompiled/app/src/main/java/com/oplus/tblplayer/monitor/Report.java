package com.oplus.tblplayer.monitor;

/* loaded from: classes2.dex */
public final class Report implements android.os.Parcelable, com.oplus.tblplayer.monitor.ErrorCode {
    public static final android.os.Parcelable.Creator<com.oplus.tblplayer.monitor.Report> CREATOR = new android.os.Parcelable.Creator<com.oplus.tblplayer.monitor.Report>() { // from class: com.oplus.tblplayer.monitor.Report.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.oplus.tblplayer.monitor.Report createFromParcel(android.os.Parcel parcel) {
            return new com.oplus.tblplayer.monitor.Report(parcel);
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.oplus.tblplayer.monitor.Report[] newArray(int i_renamed) {
            return new com.oplus.tblplayer.monitor.Report[i_renamed];
        }
    };
    public static final int NO_VALUE = -1;
    public final long aliveDuration;
    public final long alreadyPreCacheBytes;
    public final float audioFLR;
    public final java.lang.String audioMimeType;
    public final int audioSampleRate;
    public final int errorCode;
    public final java.lang.String errorRenderer;
    public final com.oplus.tblplayer.exception.IPCException exception;
    public final int height;
    public final int mediaContentType;
    public final java.lang.String mediaUrl;
    public final long rebufferCount;
    public final long rebufferTimeMs;
    public final long renderedFirstFrameTime;
    public final int rendererSupport;
    public final long totalCacheBytes;
    public final long totalNetworkReadBytes;
    public final float videoFLR;
    public final float videoFps;
    public final java.lang.String videoMimeType;
    public final int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Report(int i_renamed, java.lang.String str, int i2, int i3, int i4, int i5, java.lang.String str2, java.lang.String str3, float f_renamed, int i6, long j_renamed, long j2, float f2, float f3, long j3, long j4, long j5, long j6, long j7, java.lang.String str4, com.oplus.tblplayer.exception.IPCException iPCException) {
        this.errorCode = i_renamed;
        this.mediaUrl = str;
        this.mediaContentType = i2;
        this.rendererSupport = i3;
        this.width = i4;
        this.height = i5;
        this.videoMimeType = str2;
        this.audioMimeType = str3;
        this.videoFps = f_renamed;
        this.audioSampleRate = i6;
        this.renderedFirstFrameTime = j_renamed;
        this.aliveDuration = j2;
        this.videoFLR = f2;
        this.audioFLR = f3;
        this.rebufferCount = j3;
        this.rebufferTimeMs = j4;
        this.alreadyPreCacheBytes = j5;
        this.totalCacheBytes = j6;
        this.totalNetworkReadBytes = j7;
        this.errorRenderer = str4;
        this.exception = iPCException;
    }

    public boolean isHitPreCache() {
        return this.alreadyPreCacheBytes > 0;
    }

    public java.lang.String toString() {
        return "Report{errorCode=" + this.errorCode + ", mediaUrl=" + this.mediaUrl + ", mediaContentType=" + this.mediaContentType + ", rendererSupport=" + this.rendererSupport + ", width=" + this.width + ", height=" + this.height + ", videoMimeType=" + this.videoMimeType + ", audioMimeType=" + this.audioMimeType + ", videoFps=" + this.videoFps + ", audioSampleRate=" + this.audioSampleRate + ", renderedFirstFrameTime=" + this.renderedFirstFrameTime + ", aliveDuration=" + this.aliveDuration + ", videoFLR=" + this.videoFLR + ", audioFLR=" + this.audioFLR + ", rebufferCount=" + this.rebufferCount + ", rebufferTimeMs=" + this.rebufferTimeMs + ", alreadyPreCacheBytes=" + this.alreadyPreCacheBytes + ", totalCacheBytes=" + this.totalCacheBytes + ", totalNetworkReadBytes=" + this.totalNetworkReadBytes + ", errorRenderer=" + this.errorRenderer + ", exception=" + this.exception + "}";
    }

    public static final class Builder {
        java.lang.String audioMimeType;
        java.lang.String errorRenderer;
        com.oplus.tblplayer.exception.IPCException exception;
        java.lang.String mediaUrl;
        java.lang.String videoMimeType;
        int errorCode = -1;
        int mediaContentType = -1;
        int rendererSupport = -1;
        int width = -1;
        int height = -1;
        float videoFps = -1.0f;
        int audioSampleRate = -1;
        long renderedFirstFrameTime = -1;
        long aliveDuration = -1;
        float videoFLR = -1.0f;
        float audioFLR = -1.0f;
        long rebufferCount = -1;
        long rebufferTimeMs = -1;
        long alreadyPreCacheBytes = -1;
        long totalCacheBytes = -1;
        long totalNetworkReadBytes = -1;

        public com.oplus.tblplayer.monitor.Report.Builder setErrorCode(int i_renamed) {
            this.errorCode = i_renamed;
            return this;
        }

        public com.oplus.tblplayer.monitor.Report.Builder setRenderedFirstFrameTime(long j_renamed) {
            this.renderedFirstFrameTime = j_renamed;
            return this;
        }

        public com.oplus.tblplayer.monitor.Report.Builder setAliveDuration(long j_renamed) {
            this.aliveDuration = j_renamed;
            return this;
        }

        public com.oplus.tblplayer.monitor.Report.Builder setMediaInfo(com.oplus.tblplayer.misc.MediaInfo mediaInfo) {
            if (mediaInfo != null) {
                this.mediaUrl = mediaInfo.mediaUrl;
                this.mediaContentType = mediaInfo.mediaContentType;
                this.rendererSupport = (mediaInfo.videoRendererSupport * 10) + mediaInfo.audioRendererSupport;
                this.width = mediaInfo.width;
                this.height = mediaInfo.height;
                this.videoMimeType = mediaInfo.videoMimeType;
                this.videoFps = mediaInfo.videoFps;
                this.audioSampleRate = mediaInfo.audioSampleRate;
                this.audioMimeType = mediaInfo.audioMimeType;
            }
            return this;
        }

        public com.oplus.tblplayer.monitor.Report.Builder setVideoFLR(float f_renamed) {
            this.videoFLR = f_renamed;
            return this;
        }

        public com.oplus.tblplayer.monitor.Report.Builder setAudioFLR(float f_renamed) {
            this.audioFLR = f_renamed;
            return this;
        }

        public com.oplus.tblplayer.monitor.Report.Builder setRebufferCount(long j_renamed, long j2) {
            this.rebufferCount = j_renamed;
            this.rebufferTimeMs = j2;
            return this;
        }

        public com.oplus.tblplayer.monitor.Report.Builder setAlreadyCacheBytes(long j_renamed, long j2) {
            this.alreadyPreCacheBytes = j_renamed;
            this.totalCacheBytes = j2;
            return this;
        }

        public com.oplus.tblplayer.monitor.Report.Builder setTotalNetworkReadBytes(long j_renamed) {
            this.totalNetworkReadBytes = j_renamed;
            return this;
        }

        public com.oplus.tblplayer.monitor.Report.Builder setErrorRenderer(java.lang.String str) {
            this.errorRenderer = str;
            return this;
        }

        public com.oplus.tblplayer.monitor.Report.Builder setException(java.lang.Exception exc) {
            this.exception = com.oplus.tblplayer.exception.IPCException.toIPCException(exc);
            return this;
        }

        public com.oplus.tblplayer.monitor.Report build() {
            return new com.oplus.tblplayer.monitor.Report(this.errorCode, this.mediaUrl, this.mediaContentType, this.rendererSupport, this.width, this.height, this.videoMimeType, this.audioMimeType, this.videoFps, this.audioSampleRate, this.renderedFirstFrameTime, this.aliveDuration, this.videoFLR, this.audioFLR, this.rebufferCount, this.rebufferTimeMs, this.alreadyPreCacheBytes, this.totalCacheBytes, this.totalNetworkReadBytes, this.errorRenderer, this.exception);
        }
    }

    protected Report(android.os.Parcel parcel) {
        this.errorCode = parcel.readInt();
        this.mediaUrl = parcel.readString();
        this.mediaContentType = parcel.readInt();
        this.rendererSupport = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.videoMimeType = parcel.readString();
        this.audioMimeType = parcel.readString();
        this.videoFps = parcel.readFloat();
        this.audioSampleRate = parcel.readInt();
        this.renderedFirstFrameTime = parcel.readLong();
        this.aliveDuration = parcel.readLong();
        this.videoFLR = parcel.readFloat();
        this.audioFLR = parcel.readFloat();
        this.rebufferCount = parcel.readLong();
        this.rebufferTimeMs = parcel.readLong();
        this.alreadyPreCacheBytes = parcel.readLong();
        this.totalCacheBytes = parcel.readLong();
        this.totalNetworkReadBytes = parcel.readLong();
        this.errorRenderer = parcel.readString();
        this.exception = (com.oplus.tblplayer.exception.IPCException) parcel.readParcelable(com.oplus.tblplayer.exception.IPCException.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.mediaUrl);
        parcel.writeInt(this.mediaContentType);
        parcel.writeInt(this.rendererSupport);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.videoMimeType);
        parcel.writeString(this.audioMimeType);
        parcel.writeFloat(this.videoFps);
        parcel.writeInt(this.audioSampleRate);
        parcel.writeLong(this.renderedFirstFrameTime);
        parcel.writeLong(this.aliveDuration);
        parcel.writeFloat(this.videoFLR);
        parcel.writeFloat(this.audioFLR);
        parcel.writeLong(this.rebufferCount);
        parcel.writeLong(this.rebufferTimeMs);
        parcel.writeLong(this.alreadyPreCacheBytes);
        parcel.writeLong(this.totalCacheBytes);
        parcel.writeLong(this.totalNetworkReadBytes);
        parcel.writeString(this.errorRenderer);
        parcel.writeParcelable(this.exception, i_renamed);
    }
}
