package com.google.android.exoplayer2.video.spherical;

/* loaded from: classes.dex */
public final class ProjectionDecoder {
    private static final int MAX_COORDINATE_COUNT = 10000;
    private static final int MAX_TRIANGLE_INDICES = 128000;
    private static final int MAX_VERTEX_COUNT = 32000;
    private static final int TYPE_YTMP = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("ytmp");
    private static final int TYPE_MSHP = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("mshp");
    private static final int TYPE_RAW = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("raw ");
    private static final int TYPE_DFL8 = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("dfl8");
    private static final int TYPE_MESH = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("mesh");
    private static final int TYPE_PROJ = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("proj");

    private static int decodeZigZag(int i_renamed) {
        return (-(i_renamed & 1)) ^ (i_renamed >> 1);
    }

    private ProjectionDecoder() {
    }

    public static com.google.android.exoplayer2.video.spherical.Projection decode(byte[] bArr, int i_renamed) {
        java.util.ArrayList<com.google.android.exoplayer2.video.spherical.Projection.Mesh> proj;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(bArr);
        try {
            proj = isProj(parsableByteArray) ? parseProj(parsableByteArray) : parseMshp(parsableByteArray);
        } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            proj = null;
        }
        if (proj == null) {
            return null;
        }
        int size = proj.size();
        if (size == 1) {
            return new com.google.android.exoplayer2.video.spherical.Projection(proj.get(0), i_renamed);
        }
        if (size != 2) {
            return null;
        }
        return new com.google.android.exoplayer2.video.spherical.Projection(proj.get(0), proj.get(1), i_renamed);
    }

    private static boolean isProj(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(4);
        int i_renamed = parsableByteArray.readInt();
        parsableByteArray.setPosition(0);
        return i_renamed == TYPE_PROJ;
    }

    private static java.util.ArrayList<com.google.android.exoplayer2.video.spherical.Projection.Mesh> parseProj(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int i_renamed;
        parsableByteArray.skipBytes(8);
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        while (position < iLimit && (i_renamed = parsableByteArray.readInt() + position) > position && i_renamed <= iLimit) {
            int i2 = parsableByteArray.readInt();
            if (i2 == TYPE_YTMP || i2 == TYPE_MSHP) {
                parsableByteArray.setLimit(i_renamed);
                return parseMshp(parsableByteArray);
            }
            parsableByteArray.setPosition(i_renamed);
            position = i_renamed;
        }
        return null;
    }

    private static java.util.ArrayList<com.google.android.exoplayer2.video.spherical.Projection.Mesh> parseMshp(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (parsableByteArray.readUnsignedByte() != 0) {
            return null;
        }
        parsableByteArray.skipBytes(7);
        int i_renamed = parsableByteArray.readInt();
        if (i_renamed == TYPE_DFL8) {
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2 = new com.google.android.exoplayer2.util.ParsableByteArray();
            java.util.zip.Inflater inflater = new java.util.zip.Inflater(true);
            try {
                if (!com.google.android.exoplayer2.util.Util.inflate(parsableByteArray, parsableByteArray2, inflater)) {
                    return null;
                }
                inflater.end();
                parsableByteArray = parsableByteArray2;
            } finally {
                inflater.end();
            }
        } else if (i_renamed != TYPE_RAW) {
            return null;
        }
        return parseRawMshpData(parsableByteArray);
    }

    private static java.util.ArrayList<com.google.android.exoplayer2.video.spherical.Projection.Mesh> parseRawMshpData(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        java.util.ArrayList<com.google.android.exoplayer2.video.spherical.Projection.Mesh> arrayList = new java.util.ArrayList<>();
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        while (position < iLimit) {
            int i_renamed = parsableByteArray.readInt() + position;
            if (i_renamed <= position || i_renamed > iLimit) {
                return null;
            }
            if (parsableByteArray.readInt() == TYPE_MESH) {
                com.google.android.exoplayer2.video.spherical.Projection.Mesh mesh = parseMesh(parsableByteArray);
                if (mesh == null) {
                    return null;
                }
                arrayList.add(mesh);
            }
            parsableByteArray.setPosition(i_renamed);
            position = i_renamed;
        }
        return arrayList;
    }

    private static com.google.android.exoplayer2.video.spherical.Projection.Mesh parseMesh(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int i_renamed = parsableByteArray.readInt();
        if (i_renamed > 10000) {
            return null;
        }
        float[] fArr = new float[i_renamed];
        for (int i2 = 0; i2 < i_renamed; i2++) {
            fArr[i2] = parsableByteArray.readFloat();
        }
        int i3 = parsableByteArray.readInt();
        if (i3 > MAX_VERTEX_COUNT) {
            return null;
        }
        double d_renamed = 2.0d;
        double dLog = java.lang.Math.log(2.0d);
        int iCeil = (int) java.lang.Math.ceil(java.lang.Math.log(i_renamed * 2.0d) / dLog);
        com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray = new com.google.android.exoplayer2.util.ParsableBitArray(parsableByteArray.data);
        int i4 = 8;
        parsableBitArray.setPosition(parsableByteArray.getPosition() * 8);
        float[] fArr2 = new float[i3 * 5];
        int i5 = 5;
        int[] iArr = new int[5];
        int i6 = 0;
        int i7 = 0;
        while (i6 < i3) {
            int i8 = 0;
            while (i8 < i5) {
                int iDecodeZigZag = iArr[i8] + decodeZigZag(parsableBitArray.readBits(iCeil));
                if (iDecodeZigZag >= i_renamed || iDecodeZigZag < 0) {
                    return null;
                }
                fArr2[i7] = fArr[iDecodeZigZag];
                iArr[i8] = iDecodeZigZag;
                i8++;
                i7++;
                i5 = 5;
            }
            i6++;
            i5 = 5;
        }
        parsableBitArray.setPosition((parsableBitArray.getPosition() + 7) & (-8));
        int i9 = 32;
        int bits = parsableBitArray.readBits(32);
        com.google.android.exoplayer2.video.spherical.Projection.SubMesh[] subMeshArr = new com.google.android.exoplayer2.video.spherical.Projection.SubMesh[bits];
        int i10 = 0;
        while (i10 < bits) {
            int bits2 = parsableBitArray.readBits(i4);
            int bits3 = parsableBitArray.readBits(i4);
            int bits4 = parsableBitArray.readBits(i9);
            if (bits4 > MAX_TRIANGLE_INDICES) {
                return null;
            }
            int iCeil2 = (int) java.lang.Math.ceil(java.lang.Math.log(i3 * d_renamed) / dLog);
            float[] fArr3 = new float[bits4 * 3];
            float[] fArr4 = new float[bits4 * 2];
            int iDecodeZigZag2 = 0;
            for (int i11 = 0; i11 < bits4; i11++) {
                iDecodeZigZag2 += decodeZigZag(parsableBitArray.readBits(iCeil2));
                if (iDecodeZigZag2 < 0 || iDecodeZigZag2 >= i3) {
                    return null;
                }
                int i12 = i11 * 3;
                int i13 = iDecodeZigZag2 * 5;
                fArr3[i12] = fArr2[i13];
                fArr3[i12 + 1] = fArr2[i13 + 1];
                fArr3[i12 + 2] = fArr2[i13 + 2];
                int i14 = i11 * 2;
                fArr4[i14] = fArr2[i13 + 3];
                fArr4[i14 + 1] = fArr2[i13 + 4];
            }
            subMeshArr[i10] = new com.google.android.exoplayer2.video.spherical.Projection.SubMesh(bits2, fArr3, fArr4, bits3);
            i10++;
            i9 = 32;
            d_renamed = 2.0d;
            i4 = 8;
        }
        return new com.google.android.exoplayer2.video.spherical.Projection.Mesh(subMeshArr);
    }
}
