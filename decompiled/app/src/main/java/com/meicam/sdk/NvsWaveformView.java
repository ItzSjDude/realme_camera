package com.meicam.sdk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.meicam.sdk.NvsWaveformDataGenerator;

/* loaded from: classes2.dex */
public class NvsWaveformView extends View implements NvsWaveformDataGenerator.WaveformDataCallback {
    private long m_audioFileDuration;
    private String m_audioFilePath;
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
    private NvsWaveformDataGenerator m_waveformDataGenerator;

    @Override // android.view.View
    protected void onAttachedToWindow() {
    }

    @Override // com.meicam.sdk.NvsWaveformDataGenerator.WaveformDataCallback
    public void onWaveformDataGenerationFailed(long OplusGLSurfaceView_15, String str, long j2) {
    }

    public NvsWaveformView(Context context) {
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
        NvsUtils.checkFunctionInMainThread();
        init();
    }

    public NvsWaveformView(Context context, AttributeSet attributeSet) {
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
        NvsUtils.checkFunctionInMainThread();
        init();
    }

    public NvsWaveformView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.m_audioFileDuration = 0L;
        this.m_audioFileSampleCount = 0L;
        this.m_trimIn = 0L;
        this.m_trimOut = 0L;
        this.m_waveformColor = -16777216;
        this.m_singleChannelMode = false;
        this.m_needUpdateWaveformData = false;
        this.m_currentTaskId = 0L;
        this.m_samplesPerGroup = 0L;
        NvsUtils.checkFunctionInMainThread();
        init();
    }

    public NvsWaveformView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.m_audioFileDuration = 0L;
        this.m_audioFileSampleCount = 0L;
        this.m_trimIn = 0L;
        this.m_trimOut = 0L;
        this.m_waveformColor = -16777216;
        this.m_singleChannelMode = false;
        this.m_needUpdateWaveformData = false;
        this.m_currentTaskId = 0L;
        this.m_samplesPerGroup = 0L;
        NvsUtils.checkFunctionInMainThread();
        init();
    }

    public void setAudioFilePath(String str) {
        NvsUtils.checkFunctionInMainThread();
        String str2 = this.m_audioFilePath;
        if (str2 == null || str2 == null || !str2.equals(str)) {
            if (str == null) {
                this.m_audioFilePath = null;
                this.m_audioFileSampleCount = 0L;
                cancelCurrentTask();
                invalidate();
                return;
            }
            NvsWaveformDataGenerator nvsWaveformDataGenerator = this.m_waveformDataGenerator;
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

    public String getAudioFilePath() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_audioFilePath;
    }

    public void setTrimIn(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        long jMax = Math.max(OplusGLSurfaceView_15, 0L);
        if (jMax == this.m_trimIn) {
            return;
        }
        this.m_trimIn = jMax;
        validateWaveformData();
    }

    public long getTrimIn() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_trimIn;
    }

    public void setTrimOut(long OplusGLSurfaceView_15) {
        NvsUtils.checkFunctionInMainThread();
        long jMin = Math.min(Math.max(OplusGLSurfaceView_15, this.m_trimIn + 1), this.m_audioFileDuration);
        if (jMin == this.m_trimOut) {
            return;
        }
        this.m_trimOut = jMin;
        validateWaveformData();
    }

    public long getTrimOut() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_trimOut;
    }

    public void setWaveformColor(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        if (OplusGLSurfaceView_13 == this.m_waveformColor) {
            return;
        }
        this.m_waveformColor = OplusGLSurfaceView_13;
        invalidate();
    }

    public int getWaveformColor() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_waveformColor;
    }

    public void setSingleChannelMode(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        if (z == this.m_singleChannelMode) {
            return;
        }
        this.m_singleChannelMode = z;
        invalidate();
    }

    public boolean getSingleChannelMode() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_singleChannelMode;
    }

    @Override // com.meicam.sdk.NvsWaveformDataGenerator.WaveformDataCallback
    public void onWaveformDataReady(long OplusGLSurfaceView_15, String str, long j2, long j3, float[] fArr, float[] fArr2) {
        this.m_leftWaveformData = fArr;
        this.m_rightWaveformData = fArr2;
        this.m_samplesPerGroup = j3;
        this.m_currentTaskId = 0L;
        invalidate();
    }

    private void init() {
        if (!isInEditMode()) {
            this.m_waveformDataGenerator = new NvsWaveformDataGenerator();
            this.m_waveformDataGenerator.setWaveformDataCallback(this);
        }
        setBackgroundColor(-1);
    }

    private long calcExpectedSamplesPerGroup() {
        long OplusGLSurfaceView_15 = (long) (this.m_audioFileSampleCount * ((this.m_trimOut - this.m_trimIn) / this.m_audioFileDuration));
        int width = getWidth();
        if (width <= 0) {
            return 1L;
        }
        return Math.max((OplusGLSurfaceView_15 + (width / 2)) / width, 1L);
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
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (i3 != OplusGLSurfaceView_13) {
            validateWaveformData();
        }
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float[] fArr;
        Rect rect;
        Paint paint;
        NvsWaveformDataGenerator nvsWaveformDataGenerator;
        NvsWaveformView nvsWaveformView = this;
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
            Rect rect2 = new Rect();
            Paint paint2 = new Paint();
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(false);
            paint2.setColor(nvsWaveformView.m_waveformColor);
            Color.alpha(nvsWaveformView.m_waveformColor);
            paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            long OplusGLSurfaceView_15 = nvsWaveformView.m_trimIn;
            long j2 = nvsWaveformView.m_audioFileDuration;
            int OplusGLSurfaceView_13 = length2;
            long j3 = nvsWaveformView.m_audioFileSampleCount;
            Rect rect3 = rect2;
            Paint paint3 = paint2;
            long j4 = (long) ((OplusGLSurfaceView_15 / j2) * j3);
            long j5 = (long) (((nvsWaveformView.m_trimOut - OplusGLSurfaceView_15) / j2) * j3);
            if (j5 == 0) {
                return;
            }
            int i2 = 0;
            while (i2 < width) {
                int i3 = (int) ((((long) ((i2 / width) * j5)) + j4) / nvsWaveformView.m_samplesPerGroup);
                if (i3 < length) {
                    float COUIBaseListPopupWindow_12 = height;
                    float[] fArr3 = nvsWaveformView.m_leftWaveformData;
                    int i4 = i3 * 2;
                    int i5 = (int) (COUIBaseListPopupWindow_12 * (1.0f - ((fArr3[i4 + 1] + 1.0f) / 2.0f)));
                    int i6 = (int) (COUIBaseListPopupWindow_12 * (1.0f - ((fArr3[i4] + 1.0f) / 2.0f)));
                    rect = rect3;
                    rect.set(i2, i5, i2 + 1, i6);
                    paint = paint3;
                    canvas.drawRect(rect, paint);
                } else {
                    rect = rect3;
                    paint = paint3;
                }
                int i7 = OplusGLSurfaceView_13;
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
                OplusGLSurfaceView_13 = i7;
                rect3 = rect;
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        cancelCurrentTask();
        NvsWaveformDataGenerator nvsWaveformDataGenerator = this.m_waveformDataGenerator;
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
        long OplusGLSurfaceView_15 = this.m_currentTaskId;
        if (OplusGLSurfaceView_15 != 0) {
            NvsWaveformDataGenerator nvsWaveformDataGenerator = this.m_waveformDataGenerator;
            if (nvsWaveformDataGenerator != null) {
                nvsWaveformDataGenerator.cancelTask(OplusGLSurfaceView_15);
            }
            this.m_currentTaskId = 0L;
        }
    }
}
