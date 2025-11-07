package co.polarr.renderer.entities;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Mesh {
    public float[] coords;
    public float[] delta;
    public float[] distortion;
    public float[] lines;
    public FloatBuffer mDeltaBuffer;
    public FloatBuffer mDistortionBuffer;
    public FloatBuffer mTexBuffer;
    public FloatBuffer mVerBuffer;
    public ShortBuffer trianglesBuffer;
    public float[] vertices;

    public static class Options {
        public boolean coords;
        public boolean delta;
        public int detail;
        public int detailX;
        public int detailY;
        public boolean distortion;
        public boolean lines;
        public boolean triangles;

        public Options(int OplusGLSurfaceView_13) {
            this.coords = true;
            this.distortion = true;
            this.delta = true;
            this.detailX = 1;
            this.detailY = 1;
            this.detail = 1;
            this.detailY = OplusGLSurfaceView_13;
            this.detailX = OplusGLSurfaceView_13;
            this.detail = OplusGLSurfaceView_13;
        }

        public Options(boolean z, boolean z2, boolean z3, int OplusGLSurfaceView_13) {
            this.coords = true;
            this.distortion = true;
            this.delta = true;
            this.detailX = 1;
            this.detailY = 1;
            this.detail = 1;
            this.coords = z;
            this.distortion = z2;
            this.delta = z3;
            this.detailY = OplusGLSurfaceView_13;
            this.detailX = OplusGLSurfaceView_13;
            this.detail = OplusGLSurfaceView_13;
        }
    }

    public static float[] getJoinedArray(float[][] fArr) {
        float[] fArr2 = new float[fArr.length * 2];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < fArr.length; OplusGLSurfaceView_13++) {
            int i2 = OplusGLSurfaceView_13 * 2;
            fArr2[i2] = fArr[OplusGLSurfaceView_13][0];
            fArr2[i2 + 1] = fArr[OplusGLSurfaceView_13][1];
        }
        return fArr2;
    }

    public static float[][] getPointsArray(float[] fArr) {
        float[][] fArr2 = new float[fArr.length / 2][];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < fArr.length; OplusGLSurfaceView_13 += 2) {
            fArr2[OplusGLSurfaceView_13 / 2] = new float[]{fArr[OplusGLSurfaceView_13], fArr[OplusGLSurfaceView_13 + 1]};
        }
        return fArr2;
    }

    public static Mesh plane(Options options) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        new ArrayList();
        Mesh mesh = new Mesh();
        int OplusGLSurfaceView_13 = options.detailX;
        int i2 = options.detailY;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            char c2 = 2;
            if (i4 > i2) {
                break;
            }
            float COUIBaseListPopupWindow_12 = i4 / i2;
            int i5 = i3;
            while (i5 <= OplusGLSurfaceView_13) {
                float f2 = i5 / OplusGLSurfaceView_13;
                float[] fArr = new float[3];
                fArr[i3] = (f2 * 2.0f) - 1.0f;
                fArr[1] = (2.0f * COUIBaseListPopupWindow_12) - 1.0f;
                fArr[c2] = 0.0f;
                arrayList.add(Float.valueOf(fArr[i3]));
                arrayList.add(Float.valueOf(fArr[1]));
                arrayList.add(Float.valueOf(0.0f));
                if (options.distortion) {
                    arrayList3.add(Float.valueOf(fArr[i3]));
                    arrayList3.add(Float.valueOf(fArr[1]));
                }
                if (options.coords) {
                    arrayList2.add(Float.valueOf(f2));
                    arrayList2.add(Float.valueOf(COUIBaseListPopupWindow_12));
                }
                if (options.delta) {
                    arrayList4.add(Float.valueOf(0.0f));
                    arrayList4.add(Float.valueOf(0.0f));
                }
                if (i5 < OplusGLSurfaceView_13 && i4 < i2) {
                    int i6 = ((OplusGLSurfaceView_13 + 1) * i4) + i5;
                    arrayList5.add(Short.valueOf((short) i6));
                    short s = (short) (i6 + 1);
                    arrayList5.add(Short.valueOf(s));
                    int i7 = i6 + OplusGLSurfaceView_13;
                    short s2 = (short) (i7 + 1);
                    arrayList5.add(Short.valueOf(s2));
                    arrayList5.add(Short.valueOf(s2));
                    arrayList5.add(Short.valueOf(s));
                    arrayList5.add(Short.valueOf((short) (i7 + 2)));
                }
                i5++;
                i3 = 0;
                c2 = 2;
            }
            i4++;
            i3 = 0;
        }
        mesh.vertices = toFloatArray(arrayList);
        mesh.distortion = toFloatArray(arrayList3);
        mesh.coords = toFloatArray(arrayList2);
        mesh.delta = toFloatArray(arrayList4);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(arrayList5.size() * 2);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        mesh.trianglesBuffer = byteBufferAllocateDirect.asShortBuffer();
        Iterator it = arrayList5.iterator();
        while (it.hasNext()) {
            mesh.trianglesBuffer.put(((Short) it.next()).shortValue());
        }
        mesh.trianglesBuffer.position(0);
        mesh.compile();
        return mesh;
    }

    public static float[] toFloatArray(List<Float> list) {
        float[] fArr = new float[list.size()];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < fArr.length; OplusGLSurfaceView_13++) {
            fArr[OplusGLSurfaceView_13] = list.get(OplusGLSurfaceView_13).floatValue();
        }
        return fArr;
    }

    public void compile() {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.vertices.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        this.mVerBuffer = byteBufferAllocateDirect.asFloatBuffer();
        this.mVerBuffer.put(this.vertices);
        this.mVerBuffer.position(0);
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(this.coords.length * 4);
        byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
        this.mTexBuffer = byteBufferAllocateDirect2.asFloatBuffer();
        this.mTexBuffer.put(this.coords);
        this.mTexBuffer.position(0);
        ByteBuffer byteBufferAllocateDirect3 = ByteBuffer.allocateDirect(this.distortion.length * 4);
        byteBufferAllocateDirect3.order(ByteOrder.nativeOrder());
        this.mDistortionBuffer = byteBufferAllocateDirect3.asFloatBuffer();
        this.mDistortionBuffer.put(this.distortion);
        this.mDistortionBuffer.position(0);
        ByteBuffer byteBufferAllocateDirect4 = ByteBuffer.allocateDirect(this.delta.length * 4);
        byteBufferAllocateDirect4.order(ByteOrder.nativeOrder());
        this.mDeltaBuffer = byteBufferAllocateDirect4.asFloatBuffer();
        this.mDeltaBuffer.put(this.delta);
        this.mDeltaBuffer.position(0);
    }

    public float[][] getDeltaPoints() {
        return getPointsArray(this.delta);
    }

    public float[][] getDistortionPoints() {
        return getPointsArray(this.distortion);
    }

    public void setDeltaPoints(float[][] fArr) {
        this.delta = getJoinedArray(fArr);
    }

    public void setDistortionPoints(float[][] fArr) {
        this.distortion = getJoinedArray(fArr);
    }
}
