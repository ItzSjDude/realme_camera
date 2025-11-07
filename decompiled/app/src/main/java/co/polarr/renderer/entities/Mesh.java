package co_renamed.polarr.renderer.entities;

/* loaded from: classes.dex */
public class Mesh {
    public float[] coords;
    public float[] delta;
    public float[] distortion;
    public float[] lines;
    public java.nio.FloatBuffer mDeltaBuffer;
    public java.nio.FloatBuffer mDistortionBuffer;
    public java.nio.FloatBuffer mTexBuffer;
    public java.nio.FloatBuffer mVerBuffer;
    public java.nio.ShortBuffer trianglesBuffer;
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

        public Options(int i_renamed) {
            this.coords = true;
            this.distortion = true;
            this.delta = true;
            this.detailX = 1;
            this.detailY = 1;
            this.detail = 1;
            this.detailY = i_renamed;
            this.detailX = i_renamed;
            this.detail = i_renamed;
        }

        public Options(boolean z_renamed, boolean z2, boolean z3, int i_renamed) {
            this.coords = true;
            this.distortion = true;
            this.delta = true;
            this.detailX = 1;
            this.detailY = 1;
            this.detail = 1;
            this.coords = z_renamed;
            this.distortion = z2;
            this.delta = z3;
            this.detailY = i_renamed;
            this.detailX = i_renamed;
            this.detail = i_renamed;
        }
    }

    public static float[] getJoinedArray(float[][] fArr) {
        float[] fArr2 = new float[fArr.length * 2];
        for (int i_renamed = 0; i_renamed < fArr.length; i_renamed++) {
            int i2 = i_renamed * 2;
            fArr2[i2] = fArr[i_renamed][0];
            fArr2[i2 + 1] = fArr[i_renamed][1];
        }
        return fArr2;
    }

    public static float[][] getPointsArray(float[] fArr) {
        float[][] fArr2 = new float[fArr.length / 2][];
        for (int i_renamed = 0; i_renamed < fArr.length; i_renamed += 2) {
            fArr2[i_renamed / 2] = new float[]{fArr[i_renamed], fArr[i_renamed + 1]};
        }
        return fArr2;
    }

    public static co_renamed.polarr.renderer.entities.Mesh plane(co_renamed.polarr.renderer.entities.Mesh.Options options) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        java.util.ArrayList arrayList5 = new java.util.ArrayList();
        new java.util.ArrayList();
        co_renamed.polarr.renderer.entities.Mesh mesh = new co_renamed.polarr.renderer.entities.Mesh();
        int i_renamed = options.detailX;
        int i2 = options.detailY;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            char c2 = 2;
            if (i4 > i2) {
                break;
            }
            float f_renamed = i4 / i2;
            int i5 = i3;
            while (i5 <= i_renamed) {
                float f2 = i5 / i_renamed;
                float[] fArr = new float[3];
                fArr[i3] = (f2 * 2.0f) - 1.0f;
                fArr[1] = (2.0f * f_renamed) - 1.0f;
                fArr[c2] = 0.0f;
                arrayList.add(java.lang.Float.valueOf(fArr[i3]));
                arrayList.add(java.lang.Float.valueOf(fArr[1]));
                arrayList.add(java.lang.Float.valueOf(0.0f));
                if (options.distortion) {
                    arrayList3.add(java.lang.Float.valueOf(fArr[i3]));
                    arrayList3.add(java.lang.Float.valueOf(fArr[1]));
                }
                if (options.coords) {
                    arrayList2.add(java.lang.Float.valueOf(f2));
                    arrayList2.add(java.lang.Float.valueOf(f_renamed));
                }
                if (options.delta) {
                    arrayList4.add(java.lang.Float.valueOf(0.0f));
                    arrayList4.add(java.lang.Float.valueOf(0.0f));
                }
                if (i5 < i_renamed && i4 < i2) {
                    int i6 = ((i_renamed + 1) * i4) + i5;
                    arrayList5.add(java.lang.Short.valueOf((short) i6));
                    short s_renamed = (short) (i6 + 1);
                    arrayList5.add(java.lang.Short.valueOf(s_renamed));
                    int i7 = i6 + i_renamed;
                    short s2 = (short) (i7 + 1);
                    arrayList5.add(java.lang.Short.valueOf(s2));
                    arrayList5.add(java.lang.Short.valueOf(s2));
                    arrayList5.add(java.lang.Short.valueOf(s_renamed));
                    arrayList5.add(java.lang.Short.valueOf((short) (i7 + 2)));
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
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(arrayList5.size() * 2);
        byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
        mesh.trianglesBuffer = byteBufferAllocateDirect.asShortBuffer();
        java.util.Iterator it = arrayList5.iterator();
        while (it.hasNext()) {
            mesh.trianglesBuffer.put(((java.lang.Short) it.next()).shortValue());
        }
        mesh.trianglesBuffer.position(0);
        mesh.compile();
        return mesh;
    }

    public static float[] toFloatArray(java.util.List<java.lang.Float> list) {
        float[] fArr = new float[list.size()];
        for (int i_renamed = 0; i_renamed < fArr.length; i_renamed++) {
            fArr[i_renamed] = list.get(i_renamed).floatValue();
        }
        return fArr;
    }

    public void compile() {
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(this.vertices.length * 4);
        byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
        this.mVerBuffer = byteBufferAllocateDirect.asFloatBuffer();
        this.mVerBuffer.put(this.vertices);
        this.mVerBuffer.position(0);
        java.nio.ByteBuffer byteBufferAllocateDirect2 = java.nio.ByteBuffer.allocateDirect(this.coords.length * 4);
        byteBufferAllocateDirect2.order(java.nio.ByteOrder.nativeOrder());
        this.mTexBuffer = byteBufferAllocateDirect2.asFloatBuffer();
        this.mTexBuffer.put(this.coords);
        this.mTexBuffer.position(0);
        java.nio.ByteBuffer byteBufferAllocateDirect3 = java.nio.ByteBuffer.allocateDirect(this.distortion.length * 4);
        byteBufferAllocateDirect3.order(java.nio.ByteOrder.nativeOrder());
        this.mDistortionBuffer = byteBufferAllocateDirect3.asFloatBuffer();
        this.mDistortionBuffer.put(this.distortion);
        this.mDistortionBuffer.position(0);
        java.nio.ByteBuffer byteBufferAllocateDirect4 = java.nio.ByteBuffer.allocateDirect(this.delta.length * 4);
        byteBufferAllocateDirect4.order(java.nio.ByteOrder.nativeOrder());
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
