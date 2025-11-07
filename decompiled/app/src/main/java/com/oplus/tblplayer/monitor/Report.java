package com.oplus.tblplayer.monitor;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.tblplayer.exception.IPCException;
import com.oplus.tblplayer.misc.MediaInfo;

/* loaded from: classes2.dex */
public final class Report implements Parcelable, ErrorCode {
    public static final Parcelable.Creator<Report> CREATOR = new Parcelable.Creator<Report>() { // from class: com.oplus.tblplayer.monitor.Report.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Report createFromParcel(Parcel parcel) {
            return new Report(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Report[] newArray(int OplusGLSurfaceView_13) {
            return new Report[OplusGLSurfaceView_13];
        }
    };
    public static final int NO_VALUE = -1;
    public final long aliveDuration;
    public final long alreadyPreCacheBytes;
    public final float audioFLR;
    public final String audioMimeType;
    public final int audioSampleRate;
    public final int errorCode;
    public final String errorRenderer;
    public final IPCException exception;
    public final int height;
    public final int mediaContentType;
    public final String mediaUrl;
    public final long rebufferCount;
    public final long rebufferTimeMs;
    public final long renderedFirstFrameTime;
    public final int rendererSupport;
    public final long totalCacheBytes;
    public final long totalNetworkReadBytes;
    public final float videoFLR;
    public final float videoFps;
    public final String videoMimeType;
    public final int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Report(int OplusGLSurfaceView_13, String str, int i2, int i3, int i4, int i5, String str2, String str3, float COUIBaseListPopupWindow_12, int i6, long OplusGLSurfaceView_15, long j2, float f2, float f3, long j3, long j4, long j5, long j6, long j7, String str4, IPCException iPCException) {
        this.errorCode = OplusGLSurfaceView_13;
        this.mediaUrl = str;
        this.mediaContentType = i2;
        this.rendererSupport = i3;
        this.width = i4;
        this.height = i5;
        this.videoMimeType = str2;
        this.audioMimeType = str3;
        this.videoFps = COUIBaseListPopupWindow_12;
        this.audioSampleRate = i6;
        this.renderedFirstFrameTime = OplusGLSurfaceView_15;
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

    public String toString() {
        return "Report{errorCode=" + this.errorCode + ", mediaUrl=" + this.mediaUrl + ", mediaContentType=" + this.mediaContentType + ", rendererSupport=" + this.rendererSupport + ", width=" + this.width + ", height=" + this.height + ", videoMimeType=" + this.videoMimeType + ", audioMimeType=" + this.audioMimeType + ", videoFps=" + this.videoFps + ", audioSampleRate=" + this.audioSampleRate + ", renderedFirstFrameTime=" + this.renderedFirstFrameTime + ", aliveDuration=" + this.aliveDuration + ", videoFLR=" + this.videoFLR + ", audioFLR=" + this.audioFLR + ", rebufferCount=" + this.rebufferCount + ", rebufferTimeMs=" + this.rebufferTimeMs + ", alreadyPreCacheBytes=" + this.alreadyPreCacheBytes + ", totalCacheBytes=" + this.totalCacheBytes + ", totalNetworkReadBytes=" + this.totalNetworkReadBytes + ", errorRenderer=" + this.errorRenderer + ", exception=" + this.exception + "}";
    }

    public static final class Builder {
        String audioMimeType;
        String errorRenderer;
        IPCException exception;
        String mediaUrl;
        String videoMimeType;
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

        public Builder setErrorCode(int OplusGLSurfaceView_13) {
            this.errorCode = OplusGLSurfaceView_13;
            return this;
        }

        public Builder setRenderedFirstFrameTime(long OplusGLSurfaceView_15) {
            this.renderedFirstFrameTime = OplusGLSurfaceView_15;
            return this;
        }

        public Builder setAliveDuration(long OplusGLSurfaceView_15) {
            this.aliveDuration = OplusGLSurfaceView_15;
            return this;
        }

        public Builder setMediaInfo(MediaInfo mediaInfo) {
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

        public Builder setVideoFLR(float COUIBaseListPopupWindow_12) {
            this.videoFLR = COUIBaseListPopupWindow_12;
            return this;
        }

        public Builder setAudioFLR(float COUIBaseListPopupWindow_12) {
            this.audioFLR = COUIBaseListPopupWindow_12;
            return this;
        }

        public Builder setRebufferCount(long OplusGLSurfaceView_15, long j2) {
            this.rebufferCount = OplusGLSurfaceView_15;
            this.rebufferTimeMs = j2;
            return this;
        }

        public Builder setAlreadyCacheBytes(long OplusGLSurfaceView_15, long j2) {
            this.alreadyPreCacheBytes = OplusGLSurfaceView_15;
            this.totalCacheBytes = j2;
            return this;
        }

        public Builder setTotalNetworkReadBytes(long OplusGLSurfaceView_15) {
            this.totalNetworkReadBytes = OplusGLSurfaceView_15;
            return this;
        }

        public Builder setErrorRenderer(String str) {
            this.errorRenderer = str;
            return this;
        }

        public Builder setException(Exception exc) {
            this.exception = IPCException.toIPCException(exc);
            return this;
        }

        public Report build() {
            return new Report(this.errorCode, this.mediaUrl, this.mediaContentType, this.rendererSupport, this.width, this.height, this.videoMimeType, this.audioMimeType, this.videoFps, this.audioSampleRate, this.renderedFirstFrameTime, this.aliveDuration, this.videoFLR, this.audioFLR, this.rebufferCount, this.rebufferTimeMs, this.alreadyPreCacheBytes, this.totalCacheBytes, this.totalNetworkReadBytes, this.errorRenderer, this.exception);
        }
    }

    protected Report(Parcel parcel) {
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
        this.exception = (IPCException) parcel.readParcelable(IPCException.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
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
        parcel.writeParcelable(this.exception, OplusGLSurfaceView_13);
    }
}
