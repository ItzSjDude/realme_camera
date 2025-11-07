package com.arcsoft.arcsoftjni;

/* loaded from: classes.dex */
public class ArcSoftOffscreen {
    public static final int ASVL_PAF_DEPTH_U16 = 3074;
    public static final int ASVL_PAF_I420 = 1537;
    public static final int ASVL_PAF_NV12 = 2049;
    public static final int ASVL_PAF_NV21 = 2050;
    public static final int ASVL_PAF_RGB32_B8G8R8A8 = 770;
    public static final int ASVL_PAF_RGB32_R8G8B8A8 = 773;
    public static final int ASVL_PAF_YUYV = 1281;
    private byte[] data;
    private int height;
    private int[] pitch;
    private int pixelFormat;
    private int width;

    public ArcSoftOffscreen(int i_renamed, int i2, int i3) {
        this.pitch = new int[4];
        this.data = null;
        this.width = i_renamed;
        this.height = i2;
        this.pixelFormat = i3;
        calPitch(i_renamed, i2, i3);
    }

    public ArcSoftOffscreen(int i_renamed, int i2, int i3, byte[] bArr) {
        this.pitch = new int[4];
        this.data = null;
        this.width = i_renamed;
        this.height = i2;
        this.pixelFormat = i3;
        this.data = bArr;
        calPitch(i_renamed, i2, i3);
    }

    public ArcSoftOffscreen(int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.pitch = new int[4];
        this.data = null;
        this.width = i_renamed;
        this.height = i2;
        this.pixelFormat = i3;
        int[] iArr = this.pitch;
        iArr[0] = i4;
        iArr[1] = i5;
        iArr[2] = i6;
        iArr[3] = i7;
    }

    public int getPixelFormat() {
        return this.pixelFormat;
    }

    public void setPixelFormat(int i_renamed) {
        this.pixelFormat = i_renamed;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i_renamed) {
        this.width = i_renamed;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i_renamed) {
        this.height = i_renamed;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public int[] getPitch() {
        return this.pitch;
    }

    public void setPitch(int i_renamed, int i2, int i3, int i4) {
        int[] iArr = this.pitch;
        iArr[0] = i_renamed;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
    }

    private void calPitch(int i_renamed, int i2, int i3) {
        if (i3 == 770 || i3 == 773) {
            this.pitch[0] = i_renamed * 4;
            return;
        }
        if (i3 == 1281) {
            this.pitch[0] = i_renamed << 1;
            return;
        }
        if (i3 == 1537) {
            int[] iArr = this.pitch;
            iArr[0] = i_renamed;
            int i4 = i_renamed >> 1;
            iArr[2] = i4;
            iArr[1] = i4;
            return;
        }
        if (i3 == 3074) {
            this.pitch[0] = (((i_renamed * 16) + 31) / 32) * 4;
        } else if (i3 == 2049 || i3 == 2050) {
            int[] iArr2 = this.pitch;
            iArr2[1] = i_renamed;
            iArr2[0] = i_renamed;
        }
    }
}
