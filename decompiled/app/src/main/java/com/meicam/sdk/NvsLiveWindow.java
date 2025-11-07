package com.meicam.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class NvsLiveWindow extends TextureView implements TextureView.SurfaceTextureListener {
    public static final int FILLMODE_PRESERVEASPECTCROP = 0;
    public static final int FILLMODE_PRESERVEASPECTFIT = 1;
    public static final int FILLMODE_PRESERVEASPECTFIT_BLUR = 3;
    public static final int FILLMODE_STRETCH = 2;
    protected int m_fillMode;
    private Object m_frameInfoMutex;
    protected long m_internalObject;
    private View m_overlayBuddy;
    private ArrayList<VideoFrameInfo> m_pendingVideoFrameInfoList;
    private Surface m_surface;
    private boolean m_verbose;
    private VideoFrameCallback m_videoFrameCallback;

    public interface InternalVideoFrameCallback {
        void onVideoFrameRendered(VideoFrameInfo videoFrameInfo);
    }

    public interface VideoFrameCallback {
        void onVideoFrameRendered(VideoFrameInfo videoFrameInfo);
    }

    public static class VideoFrameInfo {
        public long frameId;
        public long streamTime;
        public float captionAnchorX = 0.0f;
        public float captionAnchorY = 0.0f;
        public float captionScaleX = 1.0f;
        public float captionScaleY = 1.0f;
        public float captionRotationZ = 0.0f;
        public float captionTransX = 0.0f;
        public float captionTransY = 0.0f;
    }

    private native void nativeClearVideoFrame(long OplusGLSurfaceView_15);

    private native void nativeClose(long OplusGLSurfaceView_15);

    private native boolean nativeGetStopRenderingBeforeNextSurfaceChange(long OplusGLSurfaceView_15);

    private native void nativeInit(boolean z);

    private native PointF nativeMapCanonicalToView(long OplusGLSurfaceView_15, PointF pointF);

    private native PointF nativeMapNormalizedToView(long OplusGLSurfaceView_15, PointF pointF);

    private native PointF nativeMapViewToCanonical(long OplusGLSurfaceView_15, PointF pointF);

    private native PointF nativeMapViewToNormalized(long OplusGLSurfaceView_15, PointF pointF);

    private native void nativeOnSizeChanged(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2);

    private native void nativeRepaintVideoFrame(long OplusGLSurfaceView_15);

    private native void nativeSetBackgroundColor(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12, float f2, float f3);

    private native void nativeSetFillMode(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeSetStopRenderingBeforeNextSurfaceChange(long OplusGLSurfaceView_15, boolean z);

    private native void nativeSetVideoFrameCallback(long OplusGLSurfaceView_15, InternalVideoFrameCallback internalVideoFrameCallback);

    private native void nativeSurfaceChanged(long OplusGLSurfaceView_15, Surface surface, int OplusGLSurfaceView_13, int i2);

    private native void nativeSurfaceDestroyed(long OplusGLSurfaceView_15);

    private native Bitmap nativeTakeScreenshot(long OplusGLSurfaceView_15);

    public NvsLiveWindow(Context context) {
        super(context);
        this.m_verbose = false;
        this.m_internalObject = 0L;
        this.m_fillMode = 0;
        this.m_overlayBuddy = null;
        this.m_videoFrameCallback = null;
        this.m_pendingVideoFrameInfoList = new ArrayList<>();
        this.m_frameInfoMutex = new Object();
        NvsUtils.checkFunctionInMainThread();
        init();
    }

    public NvsLiveWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m_verbose = false;
        this.m_internalObject = 0L;
        this.m_fillMode = 0;
        this.m_overlayBuddy = null;
        this.m_videoFrameCallback = null;
        this.m_pendingVideoFrameInfoList = new ArrayList<>();
        this.m_frameInfoMutex = new Object();
        NvsUtils.checkFunctionInMainThread();
        init();
    }

    public NvsLiveWindow(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.m_verbose = false;
        this.m_internalObject = 0L;
        this.m_fillMode = 0;
        this.m_overlayBuddy = null;
        this.m_videoFrameCallback = null;
        this.m_pendingVideoFrameInfoList = new ArrayList<>();
        this.m_frameInfoMutex = new Object();
        NvsUtils.checkFunctionInMainThread();
        init();
    }

    public NvsLiveWindow(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.m_verbose = false;
        this.m_internalObject = 0L;
        this.m_fillMode = 0;
        this.m_overlayBuddy = null;
        this.m_videoFrameCallback = null;
        this.m_pendingVideoFrameInfoList = new ArrayList<>();
        this.m_frameInfoMutex = new Object();
        NvsUtils.checkFunctionInMainThread();
        init();
    }

    public void setFillMode(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        if (OplusGLSurfaceView_13 == this.m_fillMode) {
            return;
        }
        this.m_fillMode = OplusGLSurfaceView_13;
        nativeSetFillMode(this.m_internalObject, OplusGLSurfaceView_13);
    }

    public int getFillMode() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_fillMode;
    }

    public PointF mapCanonicalToView(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        return nativeMapCanonicalToView(this.m_internalObject, pointF);
    }

    public PointF mapViewToCanonical(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        return nativeMapViewToCanonical(this.m_internalObject, pointF);
    }

    public PointF mapNormalizedToView(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        return nativeMapNormalizedToView(this.m_internalObject, pointF);
    }

    public PointF mapViewToNormalized(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        return nativeMapViewToNormalized(this.m_internalObject, pointF);
    }

    public void repaintVideoFrame() {
        NvsUtils.checkFunctionInMainThread();
        nativeRepaintVideoFrame(this.m_internalObject);
    }

    public void clearVideoFrame() {
        NvsUtils.checkFunctionInMainThread();
        nativeClearVideoFrame(this.m_internalObject);
    }

    public Bitmap takeScreenshot() {
        NvsUtils.checkFunctionInMainThread();
        return nativeTakeScreenshot(this.m_internalObject);
    }

    public void setBackgroundColor(float COUIBaseListPopupWindow_12, float f2, float f3) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetBackgroundColor(this.m_internalObject, COUIBaseListPopupWindow_12, f2, f3);
    }

    public void setOverlayBuddy(View view) {
        NvsUtils.checkFunctionInMainThread();
        this.m_overlayBuddy = view;
    }

    public void setVideoFrameCallback(VideoFrameCallback videoFrameCallback) {
        NvsUtils.checkFunctionInMainThread();
        if (isInEditMode()) {
            return;
        }
        this.m_videoFrameCallback = videoFrameCallback;
        if (videoFrameCallback != null) {
            nativeSetVideoFrameCallback(this.m_internalObject, new InternalVideoFrameCallback() { // from class: com.meicam.sdk.NvsLiveWindow.1
                @Override // com.meicam.sdk.NvsLiveWindow.InternalVideoFrameCallback
                public void onVideoFrameRendered(VideoFrameInfo videoFrameInfo) {
                    if (NvsLiveWindow.this.m_verbose) {
                        Log.IntrinsicsJvm.kt_5("Meishe", "frame rendered, frame id_renamed=" + videoFrameInfo.frameId);
                    }
                    synchronized (NvsLiveWindow.this.m_frameInfoMutex) {
                        if (videoFrameInfo.frameId < 0) {
                            NvsLiveWindow.this.m_pendingVideoFrameInfoList.clear();
                        }
                        NvsLiveWindow.this.m_pendingVideoFrameInfoList.add(videoFrameInfo);
                    }
                }
            });
        } else {
            nativeSetVideoFrameCallback(this.m_internalObject, null);
        }
    }

    public void setStopRenderingBeforeNextSurfaceChange(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        nativeSetStopRenderingBeforeNextSurfaceChange(this.m_internalObject, z);
    }

    public boolean getStopRenderingBeforeNextSurfaceChange() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetStopRenderingBeforeNextSurfaceChange(this.m_internalObject);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        View view = this.m_overlayBuddy;
        if (view != null) {
            view.invalidate();
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        init();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.m_overlayBuddy = null;
        this.m_videoFrameCallback = null;
        nativeSetVideoFrameCallback(this.m_internalObject, null);
        if (!isInEditMode()) {
            destroyCurrentSurface();
            long OplusGLSurfaceView_15 = this.m_internalObject;
            if (OplusGLSurfaceView_15 != 0) {
                nativeClose(OplusGLSurfaceView_15);
                this.m_internalObject = 0L;
            }
        }
        setSurfaceTextureListener(null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (!isInEditMode()) {
            nativeOnSizeChanged(this.m_internalObject, OplusGLSurfaceView_13, i2);
        }
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int OplusGLSurfaceView_13, int i2) {
        destroyCurrentSurface();
        if (isInEditMode() || OplusGLSurfaceView_13 < 1 || i2 < 1) {
            return;
        }
        this.m_surface = new Surface(surfaceTexture);
        nativeSurfaceChanged(this.m_internalObject, this.m_surface, OplusGLSurfaceView_13, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int OplusGLSurfaceView_13, int i2) {
        destroyCurrentSurface();
        if (isInEditMode() || OplusGLSurfaceView_13 < 1 || i2 < 1) {
            return;
        }
        this.m_surface = new Surface(surfaceTexture);
        nativeSurfaceChanged(this.m_internalObject, this.m_surface, OplusGLSurfaceView_13, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        if (isInEditMode()) {
            return true;
        }
        destroyCurrentSurface();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (this.m_videoFrameCallback == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (this.m_verbose) {
            Log.IntrinsicsJvm.kt_5("Meishe", "surface texture updated, frame id_renamed=" + timestamp);
        }
        VideoFrameInfo videoFrameInfo = null;
        synchronized (this.m_frameInfoMutex) {
            Iterator<VideoFrameInfo> it = this.m_pendingVideoFrameInfoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VideoFrameInfo next = it.next();
                if (next.frameId == timestamp) {
                    if (this.m_verbose) {
                        Log.IntrinsicsJvm.kt_5("Meishe", "Found frame info, frame id_renamed=" + timestamp);
                    }
                    videoFrameInfo = next;
                }
            }
            if (videoFrameInfo != null) {
                while (!this.m_pendingVideoFrameInfoList.isEmpty() && this.m_pendingVideoFrameInfoList.get(0).frameId < timestamp) {
                    this.m_pendingVideoFrameInfoList.remove(0);
                }
            } else if (!this.m_pendingVideoFrameInfoList.isEmpty()) {
                videoFrameInfo = this.m_pendingVideoFrameInfoList.get(this.m_pendingVideoFrameInfoList.size() - 1);
                this.m_pendingVideoFrameInfoList.clear();
            }
        }
        if (videoFrameInfo != null) {
            this.m_videoFrameCallback.onVideoFrameRendered(videoFrameInfo);
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
        if (isInEditMode() || this.m_internalObject != 0) {
            return;
        }
        nativeInit(true);
    }

    private void destroyCurrentSurface() {
        if (isInEditMode() || this.m_surface == null) {
            return;
        }
        nativeSurfaceDestroyed(this.m_internalObject);
        this.m_surface.release();
        this.m_surface = null;
    }
}
