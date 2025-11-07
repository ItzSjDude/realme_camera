package com.google.android.exoplayer2.audio;

@android.annotation.TargetApi(16)
/* loaded from: classes.dex */
public class MediaCodecAudioRenderer extends com.google.android.exoplayer2.mediacodec.MediaCodecRenderer implements com.google.android.exoplayer2.util.MediaClock {
    private static final int MAX_PENDING_STREAM_CHANGE_COUNT = 10;
    private static final java.lang.String TAG = "MediaCodecAudioRenderer";
    private boolean allowFirstBufferPositionDiscontinuity;
    private boolean allowPositionDiscontinuity;
    private final com.google.android.exoplayer2.audio.AudioSink audioSink;
    private int channelCount;
    private int codecMaxInputSize;
    private boolean codecNeedsDiscardChannelsWorkaround;
    private boolean codecNeedsEosBufferTimestampWorkaround;
    private final android.content.Context context;
    private long currentPositionUs;
    private int encoderDelay;
    private int encoderPadding;
    private final com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher eventDispatcher;
    private long lastInputTimeUs;
    private boolean passthroughEnabled;
    private android.media.MediaFormat passthroughMediaFormat;
    private int pcmEncoding;
    private int pendingStreamChangeCount;
    private final long[] pendingStreamChangeTimesUs;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public com.google.android.exoplayer2.util.MediaClock getMediaClock() {
        return this;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean isNeedDecodeForDecodeOnlyBuffer() {
        return false;
    }

    protected void onAudioSessionId(int i_renamed) {
    }

    protected void onAudioTrackPositionDiscontinuity() {
    }

    protected void onAudioTrackUnderrun(int i_renamed, long j_renamed, long j2) {
    }

    public MediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, (com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto>) null, false);
    }

    public MediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, boolean z_renamed) {
        this(context, mediaCodecSelector, drmSessionManager, z_renamed, null, null);
    }

    public MediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener) {
        this(context, mediaCodecSelector, null, false, handler, audioRendererEventListener);
    }

    public MediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, boolean z_renamed, android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener) {
        this(context, mediaCodecSelector, drmSessionManager, z_renamed, handler, audioRendererEventListener, (com.google.android.exoplayer2.audio.AudioCapabilities) null, new com.google.android.exoplayer2.audio.AudioProcessor[0]);
    }

    public MediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, boolean z_renamed, android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities, com.google.android.exoplayer2.audio.AudioProcessor... audioProcessorArr) {
        this(context, mediaCodecSelector, drmSessionManager, z_renamed, handler, audioRendererEventListener, new com.google.android.exoplayer2.audio.DefaultAudioSink(audioCapabilities, audioProcessorArr));
    }

    public MediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, boolean z_renamed, android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.audio.AudioSink audioSink) {
        super(1, mediaCodecSelector, drmSessionManager, z_renamed, 44100.0f);
        this.context = context.getApplicationContext();
        this.audioSink = audioSink;
        this.lastInputTimeUs = -9223372036854775807L;
        this.pendingStreamChangeTimesUs = new long[10];
        this.eventDispatcher = new com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        audioSink.setListener(new com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.AudioSinkListener());
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int supportsFormat(com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.drm.DrmSessionManager<com.google.android.exoplayer2.drm.FrameworkMediaCrypto> drmSessionManager, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        boolean z_renamed;
        java.lang.String str = format.sampleMimeType;
        if (!com.google.android.exoplayer2.util.MimeTypes.isAudio(str)) {
            return 0;
        }
        int i_renamed = com.google.android.exoplayer2.util.Util.SDK_INT >= 21 ? 32 : 0;
        boolean zSupportsFormatDrm = supportsFormatDrm(drmSessionManager, format.drmInitData);
        int i2 = 8;
        if (zSupportsFormatDrm && allowPassthrough(format.channelCount, str) && mediaCodecSelector.getPassthroughDecoderInfo() != null) {
            return i_renamed | 8 | 4;
        }
        if ((com.google.android.exoplayer2.util.MimeTypes.AUDIO_RAW.equals(str) && !this.audioSink.supportsOutput(format.channelCount, format.pcmEncoding)) || !this.audioSink.supportsOutput(format.channelCount, 2)) {
            return 1;
        }
        com.google.android.exoplayer2.drm.DrmInitData drmInitData = format.drmInitData;
        if (drmInitData != null) {
            z_renamed = false;
            for (int i3 = 0; i3 < drmInitData.schemeDataCount; i3++) {
                z_renamed |= drmInitData.get(i3).requiresSecureDecryption;
            }
        } else {
            z_renamed = false;
        }
        java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> decoderInfos = mediaCodecSelector.getDecoderInfos(format.sampleMimeType, z_renamed);
        if (decoderInfos.isEmpty()) {
            return (!z_renamed || mediaCodecSelector.getDecoderInfos(format.sampleMimeType, false).isEmpty()) ? 1 : 2;
        }
        if (!zSupportsFormatDrm) {
            return 2;
        }
        com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean zIsFormatSupported = mediaCodecInfo.isFormatSupported(format);
        if (zIsFormatSupported && mediaCodecInfo.isSeamlessAdaptationSupported(format)) {
            i2 = 16;
        }
        return i2 | i_renamed | (zIsFormatSupported ? 4 : 3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfos(com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.Format format, boolean z_renamed) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        com.google.android.exoplayer2.mediacodec.MediaCodecInfo passthroughDecoderInfo;
        if (allowPassthrough(format.channelCount, format.sampleMimeType) && (passthroughDecoderInfo = mediaCodecSelector.getPassthroughDecoderInfo()) != null) {
            return java.util.Collections.singletonList(passthroughDecoderInfo);
        }
        return super.getDecoderInfos(mediaCodecSelector, format, z_renamed);
    }

    protected boolean allowPassthrough(int i_renamed, java.lang.String str) {
        return this.audioSink.supportsOutput(i_renamed, com.google.android.exoplayer2.util.MimeTypes.getEncoding(str));
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void configureCodec(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, android.media.MediaCodec mediaCodec, com.google.android.exoplayer2.Format format, android.media.MediaCrypto mediaCrypto, float f_renamed) {
        this.codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format, getStreamFormats());
        this.codecNeedsDiscardChannelsWorkaround = codecNeedsDiscardChannelsWorkaround(mediaCodecInfo.name);
        this.codecNeedsEosBufferTimestampWorkaround = codecNeedsEosBufferTimestampWorkaround(mediaCodecInfo.name);
        this.passthroughEnabled = mediaCodecInfo.passthrough;
        android.media.MediaFormat mediaFormat = getMediaFormat(format, mediaCodecInfo.mimeType == null ? com.google.android.exoplayer2.util.MimeTypes.AUDIO_RAW : mediaCodecInfo.mimeType, this.codecMaxInputSize, f_renamed);
        mediaCodec.configure(mediaFormat, (android.view.Surface) null, mediaCrypto, 0);
        if (this.passthroughEnabled) {
            this.passthroughMediaFormat = mediaFormat;
            this.passthroughMediaFormat.setString(com.oplus.tblplayer.misc.IMediaFormat.KEY_MIME, format.sampleMimeType);
        } else {
            this.passthroughMediaFormat = null;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int canKeepCodec(android.media.MediaCodec mediaCodec, com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2) {
        return (getCodecMaxInputSize(mediaCodecInfo, format2) <= this.codecMaxInputSize && mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, true) && format.encoderDelay == 0 && format.encoderPadding == 0 && format2.encoderDelay == 0 && format2.encoderPadding == 0) ? 1 : 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected float getCodecOperatingRate(float f_renamed, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format[] formatArr) {
        int iMax = -1;
        for (com.google.android.exoplayer2.Format format2 : formatArr) {
            int i_renamed = format2.sampleRate;
            if (i_renamed != -1) {
                iMax = java.lang.Math.max(iMax, i_renamed);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f_renamed;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onCodecInitialized(java.lang.String str, long j_renamed, long j2) {
        this.eventDispatcher.decoderInitialized(str, j_renamed, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onInputFormatChanged(com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.ExoPlaybackException {
        super.onInputFormatChanged(format);
        this.eventDispatcher.inputFormatChanged(format);
        this.pcmEncoding = com.google.android.exoplayer2.util.MimeTypes.AUDIO_RAW.equals(format.sampleMimeType) ? format.pcmEncoding : 2;
        this.channelCount = format.channelCount;
        this.encoderDelay = format.encoderDelay;
        this.encoderPadding = format.encoderPadding;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onOutputFormatChanged(android.media.MediaCodec mediaCodec, android.media.MediaFormat mediaFormat) throws com.google.android.exoplayer2.ExoPlaybackException {
        int encoding;
        int[] iArr;
        int i_renamed;
        android.media.MediaFormat mediaFormat2 = this.passthroughMediaFormat;
        if (mediaFormat2 != null) {
            encoding = com.google.android.exoplayer2.util.MimeTypes.getEncoding(mediaFormat2.getString(com.oplus.tblplayer.misc.IMediaFormat.KEY_MIME));
            mediaFormat = this.passthroughMediaFormat;
        } else {
            encoding = this.pcmEncoding;
        }
        int i2 = encoding;
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.codecNeedsDiscardChannelsWorkaround && integer == 6 && (i_renamed = this.channelCount) < 6) {
            iArr = new int[i_renamed];
            for (int i3 = 0; i3 < this.channelCount; i3++) {
                iArr[i3] = i3;
            }
        } else {
            iArr = null;
        }
        try {
            this.audioSink.configure(i2, integer, integer2, 0, iArr, this.encoderDelay, this.encoderPadding);
        } catch (com.google.android.exoplayer2.audio.AudioSink.ConfigurationException e_renamed) {
            throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e_renamed, getIndex());
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        super.onEnabled(z_renamed);
        this.eventDispatcher.enabled(this.decoderCounters);
        int i_renamed = getConfiguration().tunnelingAudioSessionId;
        if (i_renamed != 0) {
            this.audioSink.enableTunnelingV21(i_renamed);
        } else {
            this.audioSink.disableTunneling();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStreamChanged(com.google.android.exoplayer2.Format[] formatArr, long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        super.onStreamChanged(formatArr, j_renamed);
        if (this.lastInputTimeUs != -9223372036854775807L) {
            int i_renamed = this.pendingStreamChangeCount;
            if (i_renamed == this.pendingStreamChangeTimesUs.length) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Too many stream changes, so dropping change at_renamed " + this.pendingStreamChangeTimesUs[this.pendingStreamChangeCount - 1]);
            } else {
                this.pendingStreamChangeCount = i_renamed + 1;
            }
            this.pendingStreamChangeTimesUs[this.pendingStreamChangeCount - 1] = this.lastInputTimeUs;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        super.onPositionReset(j_renamed, z_renamed);
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "onPositionReset:" + j_renamed);
        this.audioSink.reset();
        this.currentPositionUs = j_renamed;
        this.allowFirstBufferPositionDiscontinuity = true;
        this.allowPositionDiscontinuity = true;
        this.lastInputTimeUs = -9223372036854775807L;
        this.pendingStreamChangeCount = 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onPositionResetInGop(long j_renamed, boolean z_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.util.Log.d_renamed(TAG, "onPositionResetInGop:" + j_renamed);
        onPositionReset(j_renamed, z_renamed);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
        super.onStarted();
        this.audioSink.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
        updateCurrentPosition();
        this.audioSink.pause();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        try {
            this.lastInputTimeUs = -9223372036854775807L;
            this.pendingStreamChangeCount = 0;
            this.audioSink.release();
            try {
                super.onDisabled();
            } finally {
            }
        } catch (java.lang.Throwable th) {
            try {
                super.onDisabled();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return super.isEnded() && this.audioSink.isEnded();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.audioSink.hasPendingData() || super.isReady();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if (getState() == 2) {
            updateCurrentPosition();
        }
        return this.currentPositionUs;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public com.google.android.exoplayer2.PlaybackParameters setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        return this.audioSink.setPlaybackParameters(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters() {
        return this.audioSink.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onQueueInputBuffer(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer) {
        if (this.allowFirstBufferPositionDiscontinuity && !decoderInputBuffer.isDecodeOnly()) {
            if (java.lang.Math.abs(decoderInputBuffer.timeUs - this.currentPositionUs) > 500000) {
                this.currentPositionUs = decoderInputBuffer.timeUs;
            }
            this.allowFirstBufferPositionDiscontinuity = false;
        }
        this.lastInputTimeUs = java.lang.Math.max(decoderInputBuffer.timeUs, this.lastInputTimeUs);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onProcessedOutputBuffer(long j_renamed) {
        while (this.pendingStreamChangeCount != 0 && j_renamed >= this.pendingStreamChangeTimesUs[0]) {
            this.audioSink.handleDiscontinuity();
            this.pendingStreamChangeCount--;
            long[] jArr = this.pendingStreamChangeTimesUs;
            java.lang.System.arraycopy(jArr, 1, jArr, 0, this.pendingStreamChangeCount);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:11:0x001a  */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean processOutputBuffer(long r1, long r3, android.media.MediaCodec r5, java.nio.ByteBuffer r6, int r7, int r8, long r9, boolean r11, com.google.android.exoplayer2.Format r12) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r0 = this;
            boolean r1 = r0.codecNeedsEosBufferTimestampWorkaround
            if (r1 == 0) goto L1a
            r1 = 0
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 != 0) goto L1a
            r1 = r8 & 4
            if (r1 == 0) goto L1a
            long r1 = r0.lastInputTimeUs
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L1a
            goto L1b
        L1a:
            r1 = r9
        L1b:
            boolean r3 = r0.passthroughEnabled
            r4 = 0
            r9 = 1
            if (r3 == 0) goto L29
            r3 = r8 & 2
            if (r3 == 0) goto L29
            r5.releaseOutputBuffer(r7, r4)
            return r9
        L29:
            if (r11 == 0) goto L3b
            r5.releaseOutputBuffer(r7, r4)
            com.google.android.exoplayer2.decoder.DecoderCounters r1 = r0.decoderCounters
            int r2 = r1.skippedOutputBufferCount
            int r2 = r2 + r9
            r1.skippedOutputBufferCount = r2
            com.google.android.exoplayer2.audio.AudioSink r0 = r0.audioSink
            r0.handleDiscontinuity()
            return r9
        L3b:
            com.google.android.exoplayer2.audio.AudioSink r3 = r0.audioSink     // Catch: java.lang.Throwable -> L4f
            boolean r1 = r3.handleBuffer(r6, r1)     // Catch: java.lang.Throwable -> L4f
            if (r1 == 0) goto L4e
            r5.releaseOutputBuffer(r7, r4)     // Catch: java.lang.Throwable -> L4f
            com.google.android.exoplayer2.decoder.DecoderCounters r1 = r0.decoderCounters     // Catch: java.lang.Throwable -> L4f
            int r2 = r1.renderedOutputBufferCount     // Catch: java.lang.Throwable -> L4f
            int r2 = r2 + r9
            r1.renderedOutputBufferCount = r2     // Catch: java.lang.Throwable -> L4f
            return r9
        L4e:
            return r4
        L4f:
            r1 = move-exception
            int r0 = r0.getIndex()
            com.google.android.exoplayer2.ExoPlaybackException r0 = com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(r1, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.processOutputBuffer(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean, com.google.android.exoplayer2.Format):boolean");
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void renderToEndOfStream() throws com.google.android.exoplayer2.ExoPlaybackException {
        try {
            this.audioSink.playToEndOfStream();
        } catch (com.google.android.exoplayer2.audio.AudioSink.WriteException e_renamed) {
            throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e_renamed, getIndex());
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i_renamed, java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (i_renamed == 2) {
            this.audioSink.setVolume(((java.lang.Float) obj).floatValue());
            return;
        }
        if (i_renamed == 3) {
            this.audioSink.setAudioAttributes((com.google.android.exoplayer2.audio.AudioAttributes) obj);
        } else if (i_renamed == 5) {
            this.audioSink.setAuxEffectInfo((com.google.android.exoplayer2.audio.AuxEffectInfo) obj);
        } else {
            super.handleMessage(i_renamed, obj);
        }
    }

    protected int getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format[] formatArr) {
        int codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            return codecMaxInputSize;
        }
        int iMax = codecMaxInputSize;
        for (com.google.android.exoplayer2.Format format2 : formatArr) {
            if (mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, false)) {
                iMax = java.lang.Math.max(iMax, getCodecMaxInputSize(mediaCodecInfo, format2));
            }
        }
        return iMax;
    }

    private int getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.Format format) {
        android.content.pm.PackageManager packageManager;
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 24 && "OMX.google.raw.decoder".equals(mediaCodecInfo.name)) {
            boolean z_renamed = true;
            if (com.google.android.exoplayer2.util.Util.SDK_INT == 23 && (packageManager = this.context.getPackageManager()) != null && packageManager.hasSystemFeature("android.software.leanback")) {
                z_renamed = false;
            }
            if (z_renamed) {
                return -1;
            }
        }
        return format.maxInputSize;
    }

    @android.annotation.SuppressLint({"InlinedApi"})
    protected android.media.MediaFormat getMediaFormat(com.google.android.exoplayer2.Format format, java.lang.String str, int i_renamed, float f_renamed) {
        android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
        mediaFormat.setString(com.oplus.tblplayer.misc.IMediaFormat.KEY_MIME, str);
        mediaFormat.setInteger("channel-count", format.channelCount);
        mediaFormat.setInteger("sample-rate", format.sampleRate);
        com.google.android.exoplayer2.mediacodec.MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        com.google.android.exoplayer2.mediacodec.MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", i_renamed);
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 23) {
            mediaFormat.setInteger(com.heytap.accessory.constant.AFConstants.EXTRA_PRIORITY, 0);
            if (f_renamed != -1.0f) {
                mediaFormat.setFloat("operating-rate", f_renamed);
            }
        }
        if (com.google.android.exoplayer2.util.Util.SDK_INT <= 28 && com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4.equals(format.sampleMimeType)) {
            mediaFormat.setInteger("ac4-is_renamed-sync", 1);
        }
        return mediaFormat;
    }

    private void updateCurrentPosition() {
        long currentPositionUs = this.audioSink.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.allowPositionDiscontinuity) {
                currentPositionUs = java.lang.Math.max(this.currentPositionUs, currentPositionUs);
            }
            this.currentPositionUs = currentPositionUs;
            this.allowPositionDiscontinuity = false;
        }
    }

    private static boolean codecNeedsDiscardChannelsWorkaround(java.lang.String str) {
        return com.google.android.exoplayer2.util.Util.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER) && (com.google.android.exoplayer2.util.Util.DEVICE.startsWith("zeroflte") || com.google.android.exoplayer2.util.Util.DEVICE.startsWith("herolte") || com.google.android.exoplayer2.util.Util.DEVICE.startsWith("heroqlte"));
    }

    private static boolean codecNeedsEosBufferTimestampWorkaround(java.lang.String str) {
        return com.google.android.exoplayer2.util.Util.SDK_INT < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER) && (com.google.android.exoplayer2.util.Util.DEVICE.startsWith("baffin") || com.google.android.exoplayer2.util.Util.DEVICE.startsWith("grand") || com.google.android.exoplayer2.util.Util.DEVICE.startsWith("fortuna") || com.google.android.exoplayer2.util.Util.DEVICE.startsWith("gprimelte") || com.google.android.exoplayer2.util.Util.DEVICE.startsWith("j2y18lte") || com.google.android.exoplayer2.util.Util.DEVICE.startsWith("ms01"));
    }

    private final class AudioSinkListener implements com.google.android.exoplayer2.audio.AudioSink.Listener {
        private AudioSinkListener() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onAudioSessionId(int i_renamed) {
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.this.eventDispatcher.audioSessionId(i_renamed);
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.this.onAudioSessionId(i_renamed);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionDiscontinuity() {
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.this.onAudioTrackPositionDiscontinuity();
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.this.allowPositionDiscontinuity = true;
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onUnderrun(int i_renamed, long j_renamed, long j2) {
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.this.eventDispatcher.audioTrackUnderrun(i_renamed, j_renamed, j2);
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.this.onAudioTrackUnderrun(i_renamed, j_renamed, j2);
        }
    }
}
