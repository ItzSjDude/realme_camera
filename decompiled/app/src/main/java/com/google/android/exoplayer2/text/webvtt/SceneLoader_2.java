package com.google.android.exoplayer2.text.webvtt;

/* loaded from: classes.dex */
public final class WebvttCue extends com.google.android.exoplayer2.text.Cue {
    public final long endTime;
    public final long startTime;

    public WebvttCue(java.lang.CharSequence charSequence) {
        this(0L, 0L, charSequence);
    }

    public WebvttCue(long j_renamed, long j2, java.lang.CharSequence charSequence) {
        this(j_renamed, j2, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public WebvttCue(long j_renamed, long j2, java.lang.CharSequence charSequence, android.text.Layout.Alignment alignment, float f_renamed, int i_renamed, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, f_renamed, i_renamed, i2, f2, i3, f3);
        this.startTime = j_renamed;
        this.endTime = j2;
    }

    public boolean isNormalCue() {
        return this.line == Float.MIN_VALUE && this.position == Float.MIN_VALUE;
    }

    public static class Builder {
        private static final java.lang.String TAG = "WebvttCueBuilder";
        private long endTime;
        private float line;
        private int lineAnchor;
        private int lineType;
        private float position;
        private int positionAnchor;
        private long startTime;
        private android.text.SpannableStringBuilder text;
        private android.text.Layout.Alignment textAlignment;
        private float width;

        public Builder() {
            reset();
        }

        public void reset() {
            this.startTime = 0L;
            this.endTime = 0L;
            this.text = null;
            this.textAlignment = null;
            this.line = Float.MIN_VALUE;
            this.lineType = Integer.MIN_VALUE;
            this.lineAnchor = Integer.MIN_VALUE;
            this.position = Float.MIN_VALUE;
            this.positionAnchor = Integer.MIN_VALUE;
            this.width = Float.MIN_VALUE;
        }

        public com.google.android.exoplayer2.text.webvtt.WebvttCue build() {
            if (this.position != Float.MIN_VALUE && this.positionAnchor == Integer.MIN_VALUE) {
                derivePositionAnchorFromAlignment();
            }
            return new com.google.android.exoplayer2.text.webvtt.WebvttCue(this.startTime, this.endTime, this.text, this.textAlignment, this.line, this.lineType, this.lineAnchor, this.position, this.positionAnchor, this.width);
        }

        public com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder setStartTime(long j_renamed) {
            this.startTime = j_renamed;
            return this;
        }

        public com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder setEndTime(long j_renamed) {
            this.endTime = j_renamed;
            return this;
        }

        public com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder setText(android.text.SpannableStringBuilder spannableStringBuilder) {
            this.text = spannableStringBuilder;
            return this;
        }

        public com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder setTextAlignment(android.text.Layout.Alignment alignment) {
            this.textAlignment = alignment;
            return this;
        }

        public com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder setLine(float f_renamed) {
            this.line = f_renamed;
            return this;
        }

        public com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder setLineType(int i_renamed) {
            this.lineType = i_renamed;
            return this;
        }

        public com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder setLineAnchor(int i_renamed) {
            this.lineAnchor = i_renamed;
            return this;
        }

        public com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder setPosition(float f_renamed) {
            this.position = f_renamed;
            return this;
        }

        public com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder setPositionAnchor(int i_renamed) {
            this.positionAnchor = i_renamed;
            return this;
        }

        public com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder setWidth(float f_renamed) {
            this.width = f_renamed;
            return this;
        }

        private com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder derivePositionAnchorFromAlignment() {
            if (this.textAlignment == null) {
                this.positionAnchor = Integer.MIN_VALUE;
            } else {
                int i_renamed = com.google.android.exoplayer2.text.webvtt.WebvttCue.SceneLoader_2.$SwitchMap$android$text$Layout$Alignment[this.textAlignment.ordinal()];
                if (i_renamed == 1) {
                    this.positionAnchor = 0;
                } else if (i_renamed == 2) {
                    this.positionAnchor = 1;
                } else if (i_renamed == 3) {
                    this.positionAnchor = 2;
                } else {
                    com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unrecognized alignment: " + this.textAlignment);
                    this.positionAnchor = 0;
                }
            }
            return this;
        }
    }

    /* renamed from: com.google.android.exoplayer2.text.webvtt.WebvttCue$1, reason: invalid class name */
    static /* synthetic */ class SceneLoader_2 {
        static final /* synthetic */ int[] $SwitchMap$android$text$Layout$Alignment = new int[android.text.Layout.Alignment.values().length];

        static {
            try {
                $SwitchMap$android$text$Layout$Alignment[android.text.Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[android.text.Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[android.text.Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }
}
