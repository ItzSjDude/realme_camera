package co.polarr.renderer.entities;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import p000a.p001a.p003b.p010f.C0120m;

/* loaded from: classes.dex */
public class Cube {
    public byte[] data;
    public String filterID;
    public int size;

    public static boolean compareTwoByteArray(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < bArr.length; OplusGLSurfaceView_13++) {
            if (bArr[OplusGLSurfaceView_13] != bArr2[OplusGLSurfaceView_13]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] extractAndCheckLutRawDat(InputStream inputStream) throws IOException {
        try {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 4);
            int OplusGLSurfaceView_13 = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN).getInt();
            byte[] bArr3 = new byte[OplusGLSurfaceView_13];
            System.arraycopy(bArr, 4, bArr3, 0, OplusGLSurfaceView_13);
            byte[] bArrM529b = C0120m.m529b(bArr3);
            byte[] bArr4 = new byte[64];
            int i2 = OplusGLSurfaceView_13 + 4;
            System.arraycopy(bArr, i2, bArr4, 0, 64);
            if (!compareTwoByteArray(bArr4, bArrM529b)) {
                return new byte[256];
            }
            byte[] bArr5 = new byte[bArr.length - i2];
            System.arraycopy(bArr, i2, bArr5, 0, bArr5.length);
            return bArr5;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static Cube fromEncryptRaw(InputStream inputStream, String str) {
        Cube cube = new Cube();
        cube.filterID = str;
        cube.data = extractAndCheckLutRawDat(inputStream);
        cube.size = (int) Math.pow(cube.data.length / 4, 0.3333333432674408d);
        return cube;
    }

    public static Cube fromInputStream(InputStream inputStream, String str) throws IOException {
        Cube cube = new Cube();
        cube.filterID = str;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf8"));
            int OplusGLSurfaceView_13 = 0;
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (!TextUtils.isEmpty(line.trim()) && !line.startsWith("TITLE")) {
                    if (line.startsWith("LUT_3D_SIZE")) {
                        cube.size = Integer.parseInt(line.split(" ")[1]);
                        cube.data = new byte[cube.size * cube.size * cube.size * 4];
                    } else if (!line.startsWith("#") && (line.startsWith("0") || line.startsWith("1") || line.startsWith("."))) {
                        String[] strArrSplit = line.split(" ");
                        int i2 = (int) (Float.parseFloat(strArrSplit[0]) * 255.0f);
                        int i3 = (int) (Float.parseFloat(strArrSplit[1]) * 255.0f);
                        int i4 = (int) (Float.parseFloat(strArrSplit[2]) * 255.0f);
                        int i5 = OplusGLSurfaceView_13 + 1;
                        cube.data[OplusGLSurfaceView_13] = (byte) i2;
                        int i6 = i5 + 1;
                        cube.data[i5] = (byte) i3;
                        int i7 = i6 + 1;
                        cube.data[i6] = (byte) i4;
                        cube.data[i7] = (byte) 255;
                        OplusGLSurfaceView_13 = i7 + 1;
                    }
                }
            }
            bufferedReader.close();
            inputStream.close();
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        return cube;
    }

    public static Cube fromRaw(InputStream inputStream, String str) {
        Cube cube = new Cube();
        cube.filterID = str;
        try {
            int iAvailable = inputStream.available();
            cube.size = (int) Math.pow(iAvailable / 4, 0.3333333432674408d);
            cube.data = new byte[iAvailable];
            inputStream.read(cube.data);
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        return cube;
    }
}
