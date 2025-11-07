package com.sensetime.faceapi.model;

/* loaded from: classes2.dex */
public class FaceConfig {

    public enum FaceImageResize {
        DEFAULT_CONFIG(0),
        RESIZE_320W(2),
        RESIZE_640W(4),
        RESIZE_1280W(8);

        final int value;

        FaceImageResize(int OplusGLSurfaceView_13) {
            this.value = OplusGLSurfaceView_13;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum FaceKeyPointCount {
        POINT_COUNT_21(256),
        POINT_COUNT_106(512);

        final int value;

        FaceKeyPointCount(int OplusGLSurfaceView_13) {
            this.value = OplusGLSurfaceView_13;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum TrackThreadCount {
        DEFAULT_CONFIG(0),
        TWO_THREAD(1114112);

        final int value;

        TrackThreadCount(int OplusGLSurfaceView_13) {
            this.value = OplusGLSurfaceView_13;
        }

        public int getValue() {
            return this.value;
        }
    }
}
