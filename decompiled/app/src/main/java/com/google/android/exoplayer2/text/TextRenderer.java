package com.google.android.exoplayer2.text;

/* loaded from: classes.dex */
public final class TextRenderer extends com.google.android.exoplayer2.BaseRenderer implements android.os.Handler.Callback {
    private static final int MSG_UPDATE_OUTPUT = 0;
    private static final int REPLACEMENT_STATE_NONE = 0;
    private static final int REPLACEMENT_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REPLACEMENT_STATE_WAIT_END_OF_STREAM = 2;
    private com.google.android.exoplayer2.text.SubtitleDecoder decoder;
    private final com.google.android.exoplayer2.text.SubtitleDecoderFactory decoderFactory;
    private int decoderReplacementState;
    private final com.google.android.exoplayer2.FormatHolder formatHolder;
    private boolean inputStreamEnded;
    private com.google.android.exoplayer2.text.SubtitleInputBuffer nextInputBuffer;
    private com.google.android.exoplayer2.text.SubtitleOutputBuffer nextSubtitle;
    private int nextSubtitleEventIndex;
    private final com.google.android.exoplayer2.text.TextOutput output;
    private final android.os.Handler outputHandler;
    private boolean outputStreamEnded;
    private com.google.android.exoplayer2.Format streamFormat;
    private com.google.android.exoplayer2.text.SubtitleOutputBuffer subtitle;

    @java.lang.Deprecated
    public interface Output extends com.google.android.exoplayer2.text.TextOutput {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    public TextRenderer(com.google.android.exoplayer2.text.TextOutput textOutput, android.os.Looper looper) {
        this(textOutput, looper, com.google.android.exoplayer2.text.SubtitleDecoderFactory.DEFAULT);
    }

    public TextRenderer(com.google.android.exoplayer2.text.TextOutput textOutput, android.os.Looper looper, com.google.android.exoplayer2.text.SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        this.output = (com.google.android.exoplayer2.text.TextOutput) com.google.android.exoplayer2.util.Assertions.checkNotNull(textOutput);
        this.outputHandler = looper == null ? null : com.google.android.exoplayer2.util.Util.createHandler(looper, this);
        this.decoderFactory = subtitleDecoderFactory;
        this.formatHolder = new com.google.android.exoplayer2.FormatHolder();
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(com.google.android.exoplayer2.Format format) {
        return this.decoderFactory.supportsFormat(format) ? supportsFormatDrm(null, format.drmInitData) ? 4 : 2 : com.google.android.exoplayer2.util.MimeTypes.isText(format.sampleMimeType) ? 1 : 0;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStreamChanged(com.google.android.exoplayer2.Format[] formatArr, long j_renamed) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.streamFormat = formatArr[0];
        if (this.decoder != null) {
            this.decoderReplacementState = 1;
        } else {
            this.decoder = this.decoderFactory.createDecoder(this.streamFormat);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j_renamed, boolean z_renamed) {
        clearOutput();
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        if (this.decoderReplacementState != 0) {
            replaceDecoder();
        } else {
            releaseBuffers();
            this.decoder.flush();
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j_renamed, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        boolean z_renamed;
        if (this.outputStreamEnded) {
            return;
        }
        if (this.nextSubtitle == null) {
            this.decoder.setPositionUs(j_renamed);
            try {
                this.nextSubtitle = this.decoder.dequeueOutputBuffer();
            } catch (com.google.android.exoplayer2.text.SubtitleDecoderException e_renamed) {
                throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e_renamed, getIndex());
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.subtitle != null) {
            long nextEventTime = getNextEventTime();
            z_renamed = false;
            while (nextEventTime <= j_renamed) {
                this.nextSubtitleEventIndex++;
                nextEventTime = getNextEventTime();
                z_renamed = true;
            }
        } else {
            z_renamed = false;
        }
        com.google.android.exoplayer2.text.SubtitleOutputBuffer subtitleOutputBuffer = this.nextSubtitle;
        if (subtitleOutputBuffer != null) {
            if (subtitleOutputBuffer.isEndOfStream()) {
                if (!z_renamed && getNextEventTime() == Long.MAX_VALUE) {
                    if (this.decoderReplacementState == 2) {
                        replaceDecoder();
                    } else {
                        releaseBuffers();
                        this.outputStreamEnded = true;
                    }
                }
            } else if (this.nextSubtitle.timeUs <= j_renamed) {
                com.google.android.exoplayer2.text.SubtitleOutputBuffer subtitleOutputBuffer2 = this.subtitle;
                if (subtitleOutputBuffer2 != null) {
                    subtitleOutputBuffer2.release();
                }
                this.subtitle = this.nextSubtitle;
                this.nextSubtitle = null;
                this.nextSubtitleEventIndex = this.subtitle.getNextEventTimeIndex(j_renamed);
                z_renamed = true;
            }
        }
        if (z_renamed) {
            updateOutput(this.subtitle.getCues(j_renamed));
        }
        if (this.decoderReplacementState == 2) {
            return;
        }
        while (!this.inputStreamEnded) {
            try {
                if (this.nextInputBuffer == null) {
                    this.nextInputBuffer = this.decoder.dequeueInputBuffer();
                    if (this.nextInputBuffer == null) {
                        return;
                    }
                }
                if (this.decoderReplacementState == 1) {
                    this.nextInputBuffer.setFlags(4);
                    this.decoder.queueInputBuffer(this.nextInputBuffer);
                    this.nextInputBuffer = null;
                    this.decoderReplacementState = 2;
                    return;
                }
                int source = readSource(this.formatHolder, this.nextInputBuffer, false);
                if (source == -4) {
                    if (this.nextInputBuffer.isEndOfStream()) {
                        this.inputStreamEnded = true;
                    } else {
                        this.nextInputBuffer.subsampleOffsetUs = this.formatHolder.format.subsampleOffsetUs;
                        this.nextInputBuffer.flip();
                    }
                    this.decoder.queueInputBuffer(this.nextInputBuffer);
                    this.nextInputBuffer = null;
                } else if (source == -3) {
                    return;
                }
            } catch (com.google.android.exoplayer2.text.SubtitleDecoderException e2) {
                throw com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(e2, getIndex());
            }
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        this.streamFormat = null;
        clearOutput();
        releaseDecoder();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    private void releaseBuffers() {
        this.nextInputBuffer = null;
        this.nextSubtitleEventIndex = -1;
        com.google.android.exoplayer2.text.SubtitleOutputBuffer subtitleOutputBuffer = this.subtitle;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.release();
            this.subtitle = null;
        }
        com.google.android.exoplayer2.text.SubtitleOutputBuffer subtitleOutputBuffer2 = this.nextSubtitle;
        if (subtitleOutputBuffer2 != null) {
            subtitleOutputBuffer2.release();
            this.nextSubtitle = null;
        }
    }

    private void releaseDecoder() {
        releaseBuffers();
        this.decoder.release();
        this.decoder = null;
        this.decoderReplacementState = 0;
    }

    private void replaceDecoder() {
        releaseDecoder();
        this.decoder = this.decoderFactory.createDecoder(this.streamFormat);
    }

    private long getNextEventTime() {
        int i_renamed = this.nextSubtitleEventIndex;
        if (i_renamed == -1 || i_renamed >= this.subtitle.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.subtitle.getEventTime(this.nextSubtitleEventIndex);
    }

    private void updateOutput(java.util.List<com.google.android.exoplayer2.text.Cue> list) {
        android.os.Handler handler = this.outputHandler;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            invokeUpdateOutputInternal(list);
        }
    }

    private void clearOutput() {
        updateOutput(java.util.Collections.emptyList());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        if (message.what == 0) {
            invokeUpdateOutputInternal((java.util.List) message.obj);
            return true;
        }
        throw new java.lang.IllegalStateException();
    }

    private void invokeUpdateOutputInternal(java.util.List<com.google.android.exoplayer2.text.Cue> list) {
        this.output.onCues(list);
    }
}
