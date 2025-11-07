package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class Projection {
    public static final int DRAW_MODE_TRIANGLES = 0;
    public static final int DRAW_MODE_TRIANGLES_FAN = 2;
    public static final int DRAW_MODE_TRIANGLES_STRIP = 1;
    public static final int POSITION_COORDS_PER_VERTEX = 3;
    public static final int TEXTURE_COORDS_PER_VERTEX = 2;
    public final Mesh leftMesh;
    public final Mesh rightMesh;
    public final boolean singleMesh;
    public final int stereoMode;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DrawMode {
    }

    public static Projection createEquirectangular(int OplusGLSurfaceView_13) {
        return createEquirectangular(50.0f, 36, 72, 180.0f, 360.0f, OplusGLSurfaceView_13);
    }

    public static Projection createEquirectangular(float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13, int i2, float f2, float f3, int i3) {
        float f4;
        float f5;
        int i4;
        int i5;
        float f6 = COUIBaseListPopupWindow_12;
        int i6 = OplusGLSurfaceView_13;
        int i7 = i2;
        Assertions.checkArgument(f6 > 0.0f);
        Assertions.checkArgument(i6 >= 1);
        Assertions.checkArgument(i7 >= 1);
        Assertions.checkArgument(f2 > 0.0f && f2 <= 180.0f);
        Assertions.checkArgument(f3 > 0.0f && f3 <= 360.0f);
        float radians = (float) Math.toRadians(f2);
        float radians2 = (float) Math.toRadians(f3);
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
                    double IntrinsicsJvm.kt_5 = f6;
                    float f14 = radians;
                    double d2 = (f12 + 3.1415927f) - (radians2 / 2.0f);
                    double d3 = f5;
                    float f15 = f7;
                    fArr[i19] = -((float) (Math.sin(d2) * IntrinsicsJvm.kt_5 * Math.cos(d3)));
                    int i24 = i21 + 1;
                    int i25 = i10;
                    int i26 = i16;
                    fArr[i21] = (float) (IntrinsicsJvm.kt_5 * Math.sin(d3));
                    int i27 = i24 + 1;
                    fArr[i24] = (float) (IntrinsicsJvm.kt_5 * Math.cos(d2) * Math.cos(d3));
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
                        f6 = COUIBaseListPopupWindow_12;
                    }
                    System.arraycopy(fArr, i27 - 3, fArr, i27, 3);
                    i27 += 3;
                    System.arraycopy(fArr2, i29 - 2, fArr2, i29, 2);
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
                    f6 = COUIBaseListPopupWindow_12;
                }
                i16++;
                i7 = i7;
                i15 = i19;
                i14 = i17;
                f8 = f8;
                f7 = f7;
                f6 = COUIBaseListPopupWindow_12;
            }
            f6 = COUIBaseListPopupWindow_12;
            i6 = OplusGLSurfaceView_13;
            i11 = i15;
            i12 = i14;
            i10 = i13;
        }
        return new Projection(new Mesh(new SubMesh(0, fArr, fArr2, 1)), i3);
    }

    public Projection(Mesh mesh, int OplusGLSurfaceView_13) {
        this(mesh, mesh, OplusGLSurfaceView_13);
    }

    public Projection(Mesh mesh, Mesh mesh2, int OplusGLSurfaceView_13) {
        this.leftMesh = mesh;
        this.rightMesh = mesh2;
        this.stereoMode = OplusGLSurfaceView_13;
        this.singleMesh = mesh == mesh2;
    }

    public static final class SubMesh {
        public static final int VIDEO_TEXTURE_ID = 0;
        public final int mode;
        public final float[] textureCoords;
        public final int textureId;
        public final float[] vertices;

        public SubMesh(int OplusGLSurfaceView_13, float[] fArr, float[] fArr2, int i2) {
            this.textureId = OplusGLSurfaceView_13;
            Assertions.checkArgument(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.vertices = fArr;
            this.textureCoords = fArr2;
            this.mode = i2;
        }

        public int getVertexCount() {
            return this.vertices.length / 3;
        }
    }

    public static final class Mesh {
        private final SubMesh[] subMeshes;

        public Mesh(SubMesh... subMeshArr) {
            this.subMeshes = subMeshArr;
        }

        public int getSubMeshCount() {
            return this.subMeshes.length;
        }

        public SubMesh getSubMesh(int OplusGLSurfaceView_13) {
            return this.subMeshes[OplusGLSurfaceView_13];
        }
    }
}
