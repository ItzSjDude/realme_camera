package com.google.android.exoplayer2.video.spherical;

/* loaded from: classes.dex */
public final class Projection {
    public static final int DRAW_MODE_TRIANGLES = 0;
    public static final int DRAW_MODE_TRIANGLES_FAN = 2;
    public static final int DRAW_MODE_TRIANGLES_STRIP = 1;
    public static final int POSITION_COORDS_PER_VERTEX = 3;
    public static final int TEXTURE_COORDS_PER_VERTEX = 2;
    public final com.google.android.exoplayer2.video.spherical.Projection.Mesh leftMesh;
    public final com.google.android.exoplayer2.video.spherical.Projection.Mesh rightMesh;
    public final boolean singleMesh;
    public final int stereoMode;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface DrawMode {
    }

    public static com.google.android.exoplayer2.video.spherical.Projection createEquirectangular(int i_renamed) {
        return createEquirectangular(50.0f, 36, 72, 180.0f, 360.0f, i_renamed);
    }

    public static com.google.android.exoplayer2.video.spherical.Projection createEquirectangular(float f_renamed, int i_renamed, int i2, float f2, float f3, int i3) {
        float f4;
        float f5;
        int i4;
        int i5;
        float f6 = f_renamed;
        int i6 = i_renamed;
        int i7 = i2;
        com.google.android.exoplayer2.util.Assertions.checkArgument(f6 > 0.0f);
        com.google.android.exoplayer2.util.Assertions.checkArgument(i6 >= 1);
        com.google.android.exoplayer2.util.Assertions.checkArgument(i7 >= 1);
        com.google.android.exoplayer2.util.Assertions.checkArgument(f2 > 0.0f && f2 <= 180.0f);
        com.google.android.exoplayer2.util.Assertions.checkArgument(f3 > 0.0f && f3 <= 360.0f);
        float radians = (float) java.lang.Math.toRadians(f2);
        float radians2 = (float) java.lang.Math.toRadians(f3);
        float f7 = radians / i6;
        float f8 = radians2 / i7;
        int i8 = i7 + 1;
        int i9 = ((i8 * 2) + 2) * i6;
        float[] fArr = new float[i9 * 3];
        float[] fArr2 = new float[i9 * 2];
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < i6) {
            float f9 = radians / 2.0f;
            float f10 = (i10 * f7) - f9;
            int i13 = i10 + 1;
            float f11 = (i13 * f7) - f9;
            int i14 = i12;
            int i15 = i11;
            int i16 = 0;
            while (i16 < i8) {
                int i17 = i14;
                int i18 = 2;
                int i19 = i15;
                int i20 = 0;
                while (i20 < i18) {
                    if (i20 == 0) {
                        f4 = f10;
                        f5 = f4;
                    } else {
                        f4 = f10;
                        f5 = f11;
                    }
                    float f12 = i16 * f8;
                    float f13 = f8;
                    int i21 = i19 + 1;
                    int i22 = i13;
                    int i23 = i8;
                    double d_renamed = f6;
                    float f14 = radians;
                    double d2 = (f12 + 3.1415927f) - (radians2 / 2.0f);
                    double d3 = f5;
                    float f15 = f7;
                    fArr[i19] = -((float) (java.lang.Math.sin(d2) * d_renamed * java.lang.Math.cos(d3)));
                    int i24 = i21 + 1;
                    int i25 = i10;
                    int i26 = i16;
                    fArr[i21] = (float) (d_renamed * java.lang.Math.sin(d3));
                    int i27 = i24 + 1;
                    fArr[i24] = (float) (d_renamed * java.lang.Math.cos(d2) * java.lang.Math.cos(d3));
                    int i28 = i17 + 1;
                    fArr2[i17] = f12 / radians2;
                    int i29 = i28 + 1;
                    fArr2[i28] = ((i25 + i20) * f15) / f14;
                    if (i26 == 0 && i20 == 0) {
                        i4 = i2;
                        i5 = i26;
                    } else {
                        i4 = i2;
                        i5 = i26;
                        int i30 = (i5 == i4 && i20 == 1) ? 2 : 2;
                        i17 = i29;
                        i19 = i27;
                        i20++;
                        f10 = f4;
                        i16 = i5;
                        i18 = i30;
                        i10 = i25;
                        i8 = i23;
                        f8 = f13;
                        i13 = i22;
                        radians = f14;
                        f7 = f15;
                        i7 = i4;
                        f6 = f_renamed;
                    }
                    java.lang.System.arraycopy(fArr, i27 - 3, fArr, i27, 3);
                    i27 += 3;
                    java.lang.System.arraycopy(fArr2, i29 - 2, fArr2, i29, 2);
                    i29 += 2;
                    i17 = i29;
                    i19 = i27;
                    i20++;
                    f10 = f4;
                    i16 = i5;
                    i18 = i30;
                    i10 = i25;
                    i8 = i23;
                    f8 = f13;
                    i13 = i22;
                    radians = f14;
                    f7 = f15;
                    i7 = i4;
                    f6 = f_renamed;
                }
                i16++;
                i7 = i7;
                i15 = i19;
                i14 = i17;
                f8 = f8;
                f7 = f7;
                f6 = f_renamed;
            }
            f6 = f_renamed;
            i6 = i_renamed;
            i11 = i15;
            i12 = i14;
            i10 = i13;
        }
        return new com.google.android.exoplayer2.video.spherical.Projection(new com.google.android.exoplayer2.video.spherical.Projection.Mesh(new com.google.android.exoplayer2.video.spherical.Projection.SubMesh(0, fArr, fArr2, 1)), i3);
    }

    public Projection(com.google.android.exoplayer2.video.spherical.Projection.Mesh mesh, int i_renamed) {
        this(mesh, mesh, i_renamed);
    }

    public Projection(com.google.android.exoplayer2.video.spherical.Projection.Mesh mesh, com.google.android.exoplayer2.video.spherical.Projection.Mesh mesh2, int i_renamed) {
        this.leftMesh = mesh;
        this.rightMesh = mesh2;
        this.stereoMode = i_renamed;
        this.singleMesh = mesh == mesh2;
    }

    public static final class SubMesh {
        public static final int VIDEO_TEXTURE_ID = 0;
        public final int mode;
        public final float[] textureCoords;
        public final int textureId;
        public final float[] vertices;

        public SubMesh(int i_renamed, float[] fArr, float[] fArr2, int i2) {
            this.textureId = i_renamed;
            com.google.android.exoplayer2.util.Assertions.checkArgument(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.vertices = fArr;
            this.textureCoords = fArr2;
            this.mode = i2;
        }

        public int getVertexCount() {
            return this.vertices.length / 3;
        }
    }

    public static final class Mesh {
        private final com.google.android.exoplayer2.video.spherical.Projection.SubMesh[] subMeshes;

        public Mesh(com.google.android.exoplayer2.video.spherical.Projection.SubMesh... subMeshArr) {
            this.subMeshes = subMeshArr;
        }

        public int getSubMeshCount() {
            return this.subMeshes.length;
        }

        public com.google.android.exoplayer2.video.spherical.Projection.SubMesh getSubMesh(int i_renamed) {
            return this.subMeshes[i_renamed];
        }
    }
}
