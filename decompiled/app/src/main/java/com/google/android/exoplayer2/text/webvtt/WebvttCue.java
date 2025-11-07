package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Log;

/* loaded from: classes.dex */
public final class WebvttCue extends Cue {
    public final long endTime;
    public final long startTime;

    public WebvttCue(CharSequence charSequence) {
        this(0L, 0L, charSequence);
    }

    public WebvttCue(long OplusGLSurfaceView_15, long j2, CharSequence charSequence) {
        this(OplusGLSurfaceView_15, j2, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public WebvttCue(long OplusGLSurfaceView_15, long j2, CharSequence charSequence, Layout.Alignment alignment, float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, COUIBaseListPopupWindow_12, OplusGLSurfaceView_13, i2, f2, i3, f3);
        this.startTime = OplusGLSurfaceView_15;
        this.endTime = j2;
    }

    public boolean isNormalCue() {
        return this.line == Float.MIN_VALUE && this.position == Float.MIN_VALUE;
    }

    public static class Builder {
        private static final String TAG = "WebvttCueBuilder";
        private long endTime;
        private float line;
        private int lineAnchor;
        private int lineType;
        private float position;
        private int positionAnchor;
        private long startTime;
        private SpannableStringBuilder text;
        private Layout.Alignment textAlignment;
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

        public WebvttCue build() {
            if (this.position != Float.MIN_VALUE && this.positionAnchor == Integer.MIN_VALUE) {
                derivePositionAnchorFromAlignment();
            }
            return new WebvttCue(this.startTime, this.endTime, this.text, this.textAlignment, this.line, this.lineType, this.lineAnchor, this.position, this.positionAnchor, this.width);
        }

        public Builder setStartTime(long OplusGLSurfaceView_15) {
            this.startTime = OplusGLSurfaceView_15;
            return this;
        }

        public Builder setEndTime(long OplusGLSurfaceView_15) {
            this.endTime = OplusGLSurfaceView_15;
            return this;
        }

        public Builder setText(SpannableStringBuilder spannableStringBuilder) {
            this.text = spannableStringBuilder;
            return this;
        }

        public Builder setTextAlignment(Layout.Alignment alignment) {
            this.textAlignment = alignment;
            return this;
        }

        public Builder setLine(float COUIBaseListPopupWindow_12) {
            this.line = COUIBaseListPopupWindow_12;
            return this;
        }

        public Builder setLineType(int OplusGLSurfaceView_13) {
            this.lineType = OplusGLSurfaceView_13;
            return this;
        }

        public Builder setLineAnchor(int OplusGLSurfaceView_13) {
            this.lineAnchor = OplusGLSurfaceView_13;
            return this;
        }

        public Builder setPosition(float COUIBaseListPopupWindow_12) {
            this.position = COUIBaseListPopupWindow_12;
            return this;
        }

        public Builder setPositionAnchor(int OplusGLSurfaceView_13) {
            this.positionAnchor = OplusGLSurfaceView_13;
            return this;
        }

        public Builder setWidth(float COUIBaseListPopupWindow_12) {
            this.width = COUIBaseListPopupWindow_12;
            return this;
        }

        private Builder derivePositionAnchorFromAlignment() {
            if (this.textAlignment == null) {
                this.positionAnchor = Integer.MIN_VALUE;
            } else {
                int OplusGLSurfaceView_13 = C16681.$SwitchMap$android$text$Layout$Alignment[this.textAlignment.ordinal()];
                if (OplusGLSurfaceView_13 == 1) {
                    this.positionAnchor = 0;
                } else if (OplusGLSurfaceView_13 == 2) {
                    this.positionAnchor = 1;
                } else if (OplusGLSurfaceView_13 == 3) {
                    this.positionAnchor = 2;
                } else {
                    Log.m8324w(TAG, "Unrecognized alignment: " + this.textAlignment);
                    this.positionAnchor = 0;
                }
            }
            return this;
        }
    }

    /* renamed from: com.google.android.exoplayer2.text.webvtt.WebvttCue$1 */
    static /* synthetic */ class C16681 {
        static final /* synthetic */ int[] $SwitchMap$android$text$Layout$Alignment = new int[Layout.Alignment.values().length];

        static {
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
