package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsAVFileInfo {
    static final int AUDIO_MAX_STREAM_COUNT = 4;
    public static final int AV_FILE_TYPE_AUDIO = 1;
    public static final int AV_FILE_TYPE_AUDIOVIDEO = 0;
    public static final int AV_FILE_TYPE_IMAGE = 2;
    public static final int AV_FILE_TYPE_UNKNOWN = -1;
    com.meicam.sdk.NvsAudioStreamInfo[] m_audioStreamInfo = new com.meicam.sdk.NvsAudioStreamInfo[4];
    long m_dataRate;
    long m_duration;
    int m_numAudioStreams;
    int m_numVideoStreams;
    int m_type;
    com.meicam.sdk.NvsVideoStreamInfo m_videoStreamInfo;

    public int getAVFileType() {
        return this.m_type;
    }

    public long getDuration() {
        return this.m_duration;
    }

    public long getDataRate() {
        return this.m_dataRate;
    }

    public int getVideoStreamCount() {
        return this.m_numVideoStreams;
    }

    public int getAudioStreamCount() {
        return this.m_numAudioStreams;
    }

    public long getVideoStreamDuration(int i_renamed) {
        if (i_renamed < this.m_numVideoStreams) {
            return this.m_videoStreamInfo.duration;
        }
        return 0L;
    }

    public com.meicam.sdk.NvsSize getVideoStreamDimension(int i_renamed) {
        com.meicam.sdk.NvsSize nvsSize = new com.meicam.sdk.NvsSize(0, 0);
        if (i_renamed < this.m_numVideoStreams) {
            nvsSize.width = this.m_videoStreamInfo.imageWidth;
            nvsSize.height = this.m_videoStreamInfo.imageHeight;
        }
        return nvsSize;
    }

    public com.meicam.sdk.NvsRational getVideoStreamPixelAspectRatio(int i_renamed) {
        com.meicam.sdk.NvsRational nvsRational = new com.meicam.sdk.NvsRational(1, 1);
        if (i_renamed < this.m_numVideoStreams) {
            nvsRational.num = this.m_videoStreamInfo.pixelAspectRatio.num;
            nvsRational.den = this.m_videoStreamInfo.pixelAspectRatio.den;
        }
        return nvsRational;
    }

    public com.meicam.sdk.NvsRational getVideoStreamFrameRate(int i_renamed) {
        com.meicam.sdk.NvsRational nvsRational = new com.meicam.sdk.NvsRational(1, 1);
        if (i_renamed < this.m_numVideoStreams) {
            nvsRational.num = this.m_videoStreamInfo.frameRate.num;
            nvsRational.den = this.m_videoStreamInfo.frameRate.den;
        }
        return nvsRational;
    }

    public com.meicam.sdk.NvsRational getVideoStreamMaxFrameRate(int i_renamed) {
        com.meicam.sdk.NvsRational nvsRational = new com.meicam.sdk.NvsRational(1, 1);
        if (i_renamed < this.m_numVideoStreams) {
            nvsRational.num = this.m_videoStreamInfo.maxFrameRate.num;
            nvsRational.den = this.m_videoStreamInfo.maxFrameRate.den;
        }
        return nvsRational;
    }

    public int getVideoStreamRotation(int i_renamed) {
        if (i_renamed < this.m_numVideoStreams) {
            return this.m_videoStreamInfo.displayRotation;
        }
        return 0;
    }

    public int getVideoStreamComponentBitCount(int i_renamed) {
        if (i_renamed < this.m_numVideoStreams) {
            return this.m_videoStreamInfo.componentBitCount;
        }
        return 8;
    }

    public int getVideoStreamCodecType(int i_renamed) {
        if (i_renamed < this.m_numVideoStreams) {
            return this.m_videoStreamInfo.videoCodecType;
        }
        return 0;
    }

    public long getAudioStreamDuration(int i_renamed) {
        if (i_renamed < this.m_numAudioStreams) {
            return this.m_audioStreamInfo[i_renamed].duration;
        }
        return 0L;
    }

    public int getAudioStreamSampleRate(int i_renamed) {
        if (i_renamed < this.m_numAudioStreams) {
            return this.m_audioStreamInfo[i_renamed].sampleRate;
        }
        return 0;
    }

    public int getAudioStreamChannelCount(int i_renamed) {
        if (i_renamed < this.m_numAudioStreams) {
            return this.m_audioStreamInfo[i_renamed].channelCount;
        }
        return 0;
    }

    void setAudioStreamInfo(int i_renamed, com.meicam.sdk.NvsAudioStreamInfo nvsAudioStreamInfo) {
        if (i_renamed < this.m_numAudioStreams) {
            this.m_audioStreamInfo[i_renamed] = nvsAudioStreamInfo;
        }
    }
}
