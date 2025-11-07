package co_renamed.polarr.renderer.entities;

/* loaded from: classes.dex */
public class Cube {
    public byte[] data;
    public java.lang.String filterID;
    public int size;

    public static boolean compareTwoByteArray(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i_renamed = 0; i_renamed < bArr.length; i_renamed++) {
            if (bArr[i_renamed] != bArr2[i_renamed]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] extractAndCheckLutRawDat(java.io.InputStream inputStream) throws java.io.IOException {
        try {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            byte[] bArr2 = new byte[4];
            java.lang.System.arraycopy(bArr, 0, bArr2, 0, 4);
            int i_renamed = java.nio.ByteBuffer.wrap(bArr2).order(java.nio.ByteOrder.LITTLE_ENDIAN).getInt();
            byte[] bArr3 = new byte[i_renamed];
            java.lang.System.arraycopy(bArr, 4, bArr3, 0, i_renamed);
            byte[] bArrB = a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.b_renamed(bArr3);
            byte[] bArr4 = new byte[64];
            int i2 = i_renamed + 4;
            java.lang.System.arraycopy(bArr, i2, bArr4, 0, 64);
            if (!compareTwoByteArray(bArr4, bArrB)) {
                return new byte[256];
            }
            byte[] bArr5 = new byte[bArr.length - i2];
            java.lang.System.arraycopy(bArr, i2, bArr5, 0, bArr5.length);
            return bArr5;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static co_renamed.polarr.renderer.entities.Cube fromEncryptRaw(java.io.InputStream inputStream, java.lang.String str) {
        co_renamed.polarr.renderer.entities.Cube cube = new co_renamed.polarr.renderer.entities.Cube();
        cube.filterID = str;
        cube.data = extractAndCheckLutRawDat(inputStream);
        cube.size = (int) java.lang.Math.pow(cube.data.length / 4, 0.3333333432674408d);
        return cube;
    }

    public static co_renamed.polarr.renderer.entities.Cube fromInputStream(java.io.InputStream inputStream, java.lang.String str) throws java.io.IOException {
        co_renamed.polarr.renderer.entities.Cube cube = new co_renamed.polarr.renderer.entities.Cube();
        cube.filterID = str;
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, "utf8"));
            int i_renamed = 0;
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (!android.text.TextUtils.isEmpty(line.trim()) && !line.startsWith("TITLE")) {
                    if (line.startsWith("LUT_3D_SIZE")) {
                        cube.size = java.lang.Integer.parseInt(line.split(" ")[1]);
                        cube.data = new byte[cube.size * cube.size * cube.size * 4];
                    } else if (!line.startsWith("#") && (line.startsWith("0") || line.startsWith("1") || line.startsWith("."))) {
                        java.lang.String[] strArrSplit = line.split(" ");
                        int i2 = (int) (java.lang.Float.parseFloat(strArrSplit[0]) * 255.0f);
                        int i3 = (int) (java.lang.Float.parseFloat(strArrSplit[1]) * 255.0f);
                        int i4 = (int) (java.lang.Float.parseFloat(strArrSplit[2]) * 255.0f);
                        int i5 = i_renamed + 1;
                        cube.data[i_renamed] = (byte) i2;
                        int i6 = i5 + 1;
                        cube.data[i5] = (byte) i3;
                        int i7 = i6 + 1;
                        cube.data[i6] = (byte) i4;
                        cube.data[i7] = (byte) 255;
                        i_renamed = i7 + 1;
                    }
                }
            }
            bufferedReader.close();
            inputStream.close();
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        return cube;
    }

    public static co_renamed.polarr.renderer.entities.Cube fromRaw(java.io.InputStream inputStream, java.lang.String str) {
        co_renamed.polarr.renderer.entities.Cube cube = new co_renamed.polarr.renderer.entities.Cube();
        cube.filterID = str;
        try {
            int iAvailable = inputStream.available();
            cube.size = (int) java.lang.Math.pow(iAvailable / 4, 0.3333333432674408d);
            cube.data = new byte[iAvailable];
            inputStream.read(cube.data);
        } catch (java.io.IOException e_renamed) {
            e_renamed.printStackTrace();
        }
        return cube;
    }
}
