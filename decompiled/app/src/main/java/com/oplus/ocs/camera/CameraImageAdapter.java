package com.oplus.ocs.camera;

/* loaded from: classes2.dex */
abstract class CameraImageAdapter {
    public String getCameraType() {
        return null;
    }

    public int getFormat() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }

    public byte[] getImage() {
        return null;
    }

    public int getOrientation() {
        return 0;
    }

    public int getScanline() {
        return 0;
    }

    public int getSourceType() {
        return 0;
    }

    public int getStride() {
        return 0;
    }

    public long getTimestamp() {
        return 0L;
    }

    public int getWidth() {
        return 0;
    }

    CameraImageAdapter() {
    }
}
