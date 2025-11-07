package com.cdv.io;

/* loaded from: classes.dex */
public class NvAndroidAudioFileReader {
    private static final int ERROR_EOF = 1;
    private static final int ERROR_FAIL = 2;
    private static final int ERROR_OK = 0;
    private static final java.lang.String TAG = "NvAndroidAudioFileReader";
    private static final boolean m_verbose = false;
    private android.media.MediaCodec.BufferInfo m_bufferInfo;
    private android.media.MediaExtractor m_extractor = null;
    private int m_audioTrackIndex = -1;
    private android.media.MediaFormat m_format = null;
    private long m_duration = 0;
    private int m_channelCount = 1;
    private int m_sampleRate = 44100;
    private int m_pcmEncoding = 2;
    private android.media.MediaCodec m_decoder = null;
    private boolean m_decoderSetupFailed = false;
    private boolean m_decoderStarted = false;
    java.nio.ByteBuffer[] m_decoderInputBuffers = null;
    java.nio.ByteBuffer[] m_decoderOutputBuffers = null;
    private boolean m_inputBufferQueued = false;
    private int m_pendingInputFrameCount = 0;
    private boolean m_sawInputEOS = false;
    private boolean m_sawOutputEOS = false;

    public static class AudioFrame {
        java.nio.ByteBuffer audioFrame;
        int channelCount;
        long pts;
        int retCode;
        int sampleCount;
        int sampleRate;
        int sampleSize;
    }

    NvAndroidAudioFileReader() {
        this.m_bufferInfo = null;
        this.m_bufferInfo = new android.media.MediaCodec.BufferInfo();
    }

    public boolean openFile(java.lang.String str, android.content.Context context) {
        if (isValid()) {
            android.util.Log.e_renamed(TAG, "You can't_renamed call OpenFile() twice!");
            return false;
        }
        this.m_extractor = com.cdv.utils.NvAndroidUtils.createMediaExtractorFromMediaFilePath(context, str);
        android.media.MediaExtractor mediaExtractor = this.m_extractor;
        if (mediaExtractor == null) {
            return false;
        }
        int trackCount = mediaExtractor.getTrackCount();
        int i_renamed = 0;
        while (true) {
            if (i_renamed >= trackCount) {
                break;
            }
            if (this.m_extractor.getTrackFormat(i_renamed).getString(com.oplus.tblplayer.misc.IMediaFormat.KEY_MIME).startsWith("audio/")) {
                this.m_audioTrackIndex = i_renamed;
                break;
            }
            i_renamed++;
        }
        int i2 = this.m_audioTrackIndex;
        if (i2 < 0) {
            android.util.Log.e_renamed(TAG, "Failed to find a_renamed audio track from " + str);
            closeFile();
            return false;
        }
        this.m_extractor.selectTrack(i2);
        this.m_format = this.m_extractor.getTrackFormat(this.m_audioTrackIndex);
        int i3 = android.os.Build.VERSION.SDK_INT;
        this.m_duration = this.m_format.getLong("durationUs");
        java.lang.String string = this.m_format.getString(com.oplus.tblplayer.misc.IMediaFormat.KEY_MIME);
        this.m_decoderSetupFailed = false;
        if (setupDecoder(string)) {
            return true;
        }
        this.m_decoderSetupFailed = true;
        closeFile();
        return false;
    }

    public boolean hasDecoderSetupFailed() {
        return this.m_decoderSetupFailed;
    }

    public void closeFile() {
        cleanupDecoder();
        android.media.MediaExtractor mediaExtractor = this.m_extractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.m_extractor = null;
            this.m_audioTrackIndex = -1;
            this.m_format = null;
            this.m_duration = 0L;
        }
    }

    public int startPlayback(long j_renamed) {
        if (!isValid()) {
            return 1;
        }
        long jMax = java.lang.Math.max(j_renamed, 0L);
        if (jMax >= this.m_duration) {
            return 1;
        }
        try {
            this.m_extractor.seekTo(jMax, 0);
            if (this.m_sawInputEOS || this.m_sawOutputEOS) {
                cleanupDecoder();
                if (!setupDecoder(this.m_format.getString(com.oplus.tblplayer.misc.IMediaFormat.KEY_MIME))) {
                    return 2;
                }
            } else if (this.m_inputBufferQueued) {
                try {
                    this.m_decoder.flush();
                } catch (java.lang.Exception unused) {
                }
                this.m_inputBufferQueued = false;
                this.m_pendingInputFrameCount = 0;
            }
            return 0;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
            return 2;
        }
    }

    public com.cdv.io.NvAndroidAudioFileReader.AudioFrame getNextAudioFrameForPlayback() {
        if (!isValid()) {
            com.cdv.io.NvAndroidAudioFileReader.AudioFrame audioFrame = new com.cdv.io.NvAndroidAudioFileReader.AudioFrame();
            audioFrame.retCode = 1;
            return audioFrame;
        }
        try {
            return decodeNextFrame();
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
            this.cleanupDecoder();
            return null;
        }
    }

    private boolean isValid() {
        return this.m_decoder != null;
    }

    private boolean setupDecoder(java.lang.String str) {
        try {
            this.m_decoder = android.media.MediaCodec.createDecoderByType(str);
            this.m_decoder.configure(this.m_format, (android.view.Surface) null, (android.media.MediaCrypto) null, 0);
            this.m_decoder.start();
            this.m_decoderStarted = true;
            this.m_decoderInputBuffers = this.m_decoder.getInputBuffers();
            this.m_decoderOutputBuffers = this.m_decoder.getOutputBuffers();
            return true;
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
            cleanupDecoder();
            return false;
        }
    }

    private void cleanupDecoder() {
        android.media.MediaCodec mediaCodec = this.m_decoder;
        if (mediaCodec != null) {
            if (this.m_decoderStarted) {
                try {
                    if (this.m_inputBufferQueued) {
                        try {
                            mediaCodec.flush();
                        } catch (java.lang.Exception unused) {
                        }
                        this.m_inputBufferQueued = false;
                    }
                    this.m_decoder.stop();
                } catch (java.lang.Exception e_renamed) {
                    android.util.Log.e_renamed(TAG, "" + e_renamed.getMessage());
                    e_renamed.printStackTrace();
                }
                this.m_decoderStarted = false;
                this.m_decoderInputBuffers = null;
            }
            this.m_decoder.release();
            this.m_decoder = null;
        }
        this.m_pendingInputFrameCount = 0;
        this.m_sawInputEOS = false;
        this.m_sawOutputEOS = false;
    }

    private com.cdv.io.NvAndroidAudioFileReader.AudioFrame decodeNextFrame() throws android.media.MediaCodec.CryptoException {
        int iDequeueInputBuffer;
        int iMax = java.lang.Math.max(this.m_decoderInputBuffers.length / 3, 2);
        com.cdv.io.NvAndroidAudioFileReader.AudioFrame audioFrame = new com.cdv.io.NvAndroidAudioFileReader.AudioFrame();
        int i_renamed = 0;
        while (true) {
            if (!this.m_sawOutputEOS) {
                if (!this.m_sawInputEOS && (iDequeueInputBuffer = this.m_decoder.dequeueInputBuffer(500L)) >= 0) {
                    int sampleData = this.m_extractor.readSampleData(this.m_decoderInputBuffers[iDequeueInputBuffer], 0);
                    if (sampleData < 0) {
                        this.m_decoder.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                        this.m_sawInputEOS = true;
                    } else {
                        if (this.m_extractor.getSampleTrackIndex() != this.m_audioTrackIndex) {
                            android.util.Log.w_renamed(TAG, "WEIRD: got sample from track " + this.m_extractor.getSampleTrackIndex() + ", expected " + this.m_audioTrackIndex);
                        }
                        this.m_decoder.queueInputBuffer(iDequeueInputBuffer, 0, sampleData, this.m_extractor.getSampleTime(), 0);
                        this.m_inputBufferQueued = true;
                        this.m_pendingInputFrameCount++;
                        this.m_extractor.advance();
                    }
                }
                int iDequeueOutputBuffer = this.m_decoder.dequeueOutputBuffer(this.m_bufferInfo, (this.m_pendingInputFrameCount > iMax || this.m_sawInputEOS) ? 500 : 0);
                int i2 = i_renamed + 1;
                if (iDequeueOutputBuffer != -1) {
                    if (iDequeueOutputBuffer == -3) {
                        this.m_decoderOutputBuffers = this.m_decoder.getOutputBuffers();
                    } else if (iDequeueOutputBuffer == -2) {
                        parseMediaFormat(this.m_decoder.getOutputFormat());
                    } else {
                        if (iDequeueOutputBuffer < 0) {
                            android.util.Log.e_renamed(TAG, "Unexpected result from decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer);
                            return null;
                        }
                        if ((this.m_bufferInfo.flags & 4) != 0) {
                            this.m_sawOutputEOS = true;
                        } else {
                            this.m_pendingInputFrameCount--;
                        }
                        boolean z_renamed = this.m_bufferInfo.size != 0;
                        if (z_renamed) {
                            audioFrame.channelCount = this.m_channelCount;
                            audioFrame.sampleRate = this.m_sampleRate;
                            audioFrame.sampleSize = 16;
                            int i3 = this.m_pcmEncoding;
                            if (i3 == 3) {
                                audioFrame.sampleSize = 8;
                            } else if (i3 == 4) {
                                audioFrame.sampleSize = 32;
                            }
                            audioFrame.sampleCount = this.m_bufferInfo.size / ((audioFrame.sampleSize / 8) * audioFrame.channelCount);
                            try {
                                java.nio.ByteBuffer byteBuffer = this.m_decoderOutputBuffers[iDequeueOutputBuffer];
                                byteBuffer.position(0);
                                byteBuffer.limit(this.m_bufferInfo.size);
                                java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(this.m_bufferInfo.size);
                                byteBufferAllocateDirect.put(byteBuffer);
                                audioFrame.audioFrame = byteBufferAllocateDirect;
                                audioFrame.pts = this.m_bufferInfo.presentationTimeUs;
                                audioFrame.retCode = 0;
                            } catch (java.lang.Exception e_renamed) {
                                e_renamed.printStackTrace();
                                audioFrame.retCode = 2;
                                z_renamed = false;
                            }
                        }
                        this.m_decoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                        if (z_renamed) {
                            return audioFrame;
                        }
                    }
                }
                if (i2 > 100) {
                    android.util.Log.e_renamed(TAG, "We have tried too many times and can't_renamed decode a_renamed frame!");
                    return null;
                }
                i_renamed = i2;
            } else {
                audioFrame.retCode = 1;
                return audioFrame;
            }
        }
    }

    private void parseMediaFormat(android.media.MediaFormat mediaFormat) {
        if (mediaFormat.containsKey("channel-count")) {
            this.m_channelCount = mediaFormat.getInteger("channel-count");
        }
        if (mediaFormat.containsKey("sample-rate")) {
            this.m_sampleRate = mediaFormat.getInteger("sample-rate");
        }
        if (mediaFormat.containsKey("pcm-encoding")) {
            this.m_pcmEncoding = mediaFormat.getInteger("pcm-encoding");
        }
    }
}
