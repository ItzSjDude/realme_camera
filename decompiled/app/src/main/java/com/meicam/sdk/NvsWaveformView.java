package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsWaveformView extends android.view.View implements com.meicam.sdk.NvsWaveformDataGenerator.WaveformDataCallback {
    private long m_audioFileDuration;
    private java.lang.String m_audioFilePath;
    private long m_audioFileSampleCount;
    private long m_currentTaskId;
    private float[] m_leftWaveformData;
    private boolean m_needUpdateWaveformData;
    private float[] m_rightWaveformData;
    private long m_samplesPerGroup;
    private boolean m_singleChannelMode;
    private long m_trimIn;
    private long m_trimOut;
    private int m_waveformColor;
    private com.meicam.sdk.NvsWaveformDataGenerator m_waveformDataGenerator;

    @Override // android.view.View
    protected void onAttachedToWindow() {
    }

    @Override // com.meicam.sdk.NvsWaveformDataGenerator.WaveformDataCallback
    public void onWaveformDataGenerationFailed(long j_renamed, java.lang.String str, long j2) {
    }

    public NvsWaveformView(android.content.Context context) {
        super(context);
        this.m_audioFileDuration = 0L;
        this.m_audioFileSampleCount = 0L;
        this.m_trimIn = 0L;
        this.m_trimOut = 0L;
        this.m_waveformColor = -16777216;
        this.m_singleChannelMode = false;
        this.m_needUpdateWaveformData = false;
        this.m_currentTaskId = 0L;
        this.m_samplesPerGroup = 0L;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        init();
    }

    public NvsWaveformView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m_audioFileDuration = 0L;
        this.m_audioFileSampleCount = 0L;
        this.m_trimIn = 0L;
        this.m_trimOut = 0L;
        this.m_waveformColor = -16777216;
        this.m_singleChannelMode = false;
        this.m_needUpdateWaveformData = false;
        this.m_currentTaskId = 0L;
        this.m_samplesPerGroup = 0L;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        init();
    }

    public NvsWaveformView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.m_audioFileDuration = 0L;
        this.m_audioFileSampleCount = 0L;
        this.m_trimIn = 0L;
        this.m_trimOut = 0L;
        this.m_waveformColor = -16777216;
        this.m_singleChannelMode = false;
        this.m_needUpdateWaveformData = false;
        this.m_currentTaskId = 0L;
        this.m_samplesPerGroup = 0L;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        init();
    }

    public NvsWaveformView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.m_audioFileDuration = 0L;
        this.m_audioFileSampleCount = 0L;
        this.m_trimIn = 0L;
        this.m_trimOut = 0L;
        this.m_waveformColor = -16777216;
        this.m_singleChannelMode = false;
        this.m_needUpdateWaveformData = false;
        this.m_currentTaskId = 0L;
        this.m_samplesPerGroup = 0L;
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        init();
    }

    public void setAudioFilePath(java.lang.String str) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        java.lang.String str2 = this.m_audioFilePath;
        if (str2 == null || str2 == null || !str2.equals(str)) {
            if (str == null) {
                this.m_audioFilePath = null;
                this.m_audioFileSampleCount = 0L;
                cancelCurrentTask();
                invalidate();
                return;
            }
            com.meicam.sdk.NvsWaveformDataGenerator nvsWaveformDataGenerator = this.m_waveformDataGenerator;
            if (nvsWaveformDataGenerator == null) {
                return;
            }
            long audioFileDuration = nvsWaveformDataGenerator.getAudioFileDuration(str);
            long audioFileSampleCount = this.m_waveformDataGenerator.getAudioFileSampleCount(str);
            if (audioFileDuration <= 0 || audioFileSampleCount <= 0) {
                return;
            }
            this.m_audioFilePath = str;
            this.m_audioFileDuration = audioFileDuration;
            this.m_audioFileSampleCount = audioFileSampleCount;
            this.m_trimIn = 0L;
            this.m_trimOut = audioFileDuration;
            this.m_needUpdateWaveformData = true;
            cancelCurrentTask();
            invalidate();
        }
    }

    public java.lang.String getAudioFilePath() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_audioFilePath;
    }

    public void setTrimIn(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        long jMax = java.lang.Math.max(j_renamed, 0L);
        if (jMax == this.m_trimIn) {
            return;
        }
        this.m_trimIn = jMax;
        validateWaveformData();
    }

    public long getTrimIn() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_trimIn;
    }

    public void setTrimOut(long j_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        long jMin = java.lang.Math.min(java.lang.Math.max(j_renamed, this.m_trimIn + 1), this.m_audioFileDuration);
        if (jMin == this.m_trimOut) {
            return;
        }
        this.m_trimOut = jMin;
        validateWaveformData();
    }

    public long getTrimOut() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_trimOut;
    }

    public void setWaveformColor(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (i_renamed == this.m_waveformColor) {
            return;
        }
        this.m_waveformColor = i_renamed;
        invalidate();
    }

    public int getWaveformColor() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_waveformColor;
    }

    public void setSingleChannelMode(boolean z_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        if (z_renamed == this.m_singleChannelMode) {
            return;
        }
        this.m_singleChannelMode = z_renamed;
        invalidate();
    }

    public boolean getSingleChannelMode() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return this.m_singleChannelMode;
    }

    @Override // com.meicam.sdk.NvsWaveformDataGenerator.WaveformDataCallback
    public void onWaveformDataReady(long j_renamed, java.lang.String str, long j2, long j3, float[] fArr, float[] fArr2) {
        this.m_leftWaveformData = fArr;
        this.m_rightWaveformData = fArr2;
        this.m_samplesPerGroup = j3;
        this.m_currentTaskId = 0L;
        invalidate();
    }

    private void init() {
        if (!isInEditMode()) {
            this.m_waveformDataGenerator = new com.meicam.sdk.NvsWaveformDataGenerator();
            this.m_waveformDataGenerator.setWaveformDataCallback(this);
        }
        setBackgroundColor(-1);
    }

    private long calcExpectedSamplesPerGroup() {
        long j_renamed = (long) (this.m_audioFileSampleCount * ((this.m_trimOut - this.m_trimIn) / this.m_audioFileDuration));
        int width = getWidth();
        if (width <= 0) {
            return 1L;
        }
        return java.lang.Math.max((j_renamed + (width / 2)) / width, 1L);
    }

    private void validateWaveformData() {
        if (this.m_samplesPerGroup <= 0) {
            this.m_needUpdateWaveformData = true;
            cancelCurrentTask();
        } else if (calcExpectedSamplesPerGroup() != this.m_samplesPerGroup) {
            this.m_needUpdateWaveformData = true;
            cancelCurrentTask();
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
        if (i3 != i_renamed) {
            validateWaveformData();
        }
        super.onSizeChanged(i_renamed, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        float[] fArr;
        android.graphics.Rect rect;
        android.graphics.Paint paint;
        com.meicam.sdk.NvsWaveformDataGenerator nvsWaveformDataGenerator;
        com.meicam.sdk.NvsWaveformView nvsWaveformView = this;
        super.onDraw(canvas);
        if (!isInEditMode() && nvsWaveformView.m_audioFileDuration > 0) {
            if (nvsWaveformView.m_needUpdateWaveformData && (nvsWaveformDataGenerator = nvsWaveformView.m_waveformDataGenerator) != null) {
                nvsWaveformView.m_needUpdateWaveformData = false;
                nvsWaveformView.m_currentTaskId = nvsWaveformDataGenerator.generateWaveformData(nvsWaveformView.m_audioFilePath, calcExpectedSamplesPerGroup(), 0L, 0L, 0);
            }
            if (nvsWaveformView.m_samplesPerGroup <= 0 || (fArr = nvsWaveformView.m_leftWaveformData) == null) {
                return;
            }
            int length = fArr.length / 2;
            float[] fArr2 = nvsWaveformView.m_rightWaveformData;
            int length2 = (fArr2 == null || nvsWaveformView.m_singleChannelMode) ? 0 : fArr2.length / 2;
            if (length == 0) {
                return;
            }
            int width = getWidth();
            int height = getHeight();
            if (length2 != 0) {
                height /= 2;
            }
            android.graphics.Rect rect2 = new android.graphics.Rect();
            android.graphics.Paint paint2 = new android.graphics.Paint();
            paint2.setStyle(android.graphics.Paint.Style.FILL);
            paint2.setAntiAlias(false);
            paint2.setColor(nvsWaveformView.m_waveformColor);
            android.graphics.Color.alpha(nvsWaveformView.m_waveformColor);
            paint2.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC));
            long j_renamed = nvsWaveformView.m_trimIn;
            long j2 = nvsWaveformView.m_audioFileDuration;
            int i_renamed = length2;
            long j3 = nvsWaveformView.m_audioFileSampleCount;
            android.graphics.Rect rect3 = rect2;
            android.graphics.Paint paint3 = paint2;
            long j4 = (long) ((j_renamed / j2) * j3);
            long j5 = (long) (((nvsWaveformView.m_trimOut - j_renamed) / j2) * j3);
            if (j5 == 0) {
                return;
            }
            int i2 = 0;
            while (i2 < width) {
                int i3 = (int) ((((long) ((i2 / width) * j5)) + j4) / nvsWaveformView.m_samplesPerGroup);
                if (i3 < length) {
                    float f_renamed = height;
                    float[] fArr3 = nvsWaveformView.m_leftWaveformData;
                    int i4 = i3 * 2;
                    int i5 = (int) (f_renamed * (1.0f - ((fArr3[i4 + 1] + 1.0f) / 2.0f)));
                    int i6 = (int) (f_renamed * (1.0f - ((fArr3[i4] + 1.0f) / 2.0f)));
                    rect = rect3;
                    rect.set(i2, i5, i2 + 1, i6);
                    paint = paint3;
                    canvas.drawRect(rect, paint);
                } else {
                    rect = rect3;
                    paint = paint3;
                }
                int i7 = i_renamed;
                if (i3 < i7) {
                    float f2 = height;
                    float[] fArr4 = nvsWaveformView.m_rightWaveformData;
                    int i8 = i3 * 2;
                    rect.set(i2, ((int) (f2 * (1.0f - ((fArr4[i8 + 1] + 1.0f) / 2.0f)))) + height, i2 + 1, ((int) (f2 * (1.0f - ((fArr4[i8] + 1.0f) / 2.0f)))) + height);
                    canvas.drawRect(rect, paint);
                }
                i2++;
                nvsWaveformView = this;
                paint3 = paint;
                i_renamed = i7;
                rect3 = rect;
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        cancelCurrentTask();
        com.meicam.sdk.NvsWaveformDataGenerator nvsWaveformDataGenerator = this.m_waveformDataGenerator;
        if (nvsWaveformDataGenerator != null) {
            nvsWaveformDataGenerator.setWaveformDataCallback(null);
            this.m_waveformDataGenerator.release();
            this.m_waveformDataGenerator = null;
        }
        super.onDetachedFromWindow();
    }

    private void cancelCurrentTask() {
        if (isInEditMode()) {
            return;
        }
        long j_renamed = this.m_currentTaskId;
        if (j_renamed != 0) {
            com.meicam.sdk.NvsWaveformDataGenerator nvsWaveformDataGenerator = this.m_waveformDataGenerator;
            if (nvsWaveformDataGenerator != null) {
                nvsWaveformDataGenerator.cancelTask(j_renamed);
            }
            this.m_currentTaskId = 0L;
        }
    }
}
