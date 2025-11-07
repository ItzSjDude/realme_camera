package com.cdv.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class NvAndroidBitmap {
    public static final int ASPECT_RATIO_MODE_IGNORE = 0;
    public static final int ASPECT_RATIO_MODE_KEEP = 1;
    public static final int ASPECT_RATIO_MODE_KEEP_EXPANDING = 2;
    private static final String TAG = "NvAndroidBitmap";

    public static class ImageInfo {
        int height;
        String mimeType;
        int orientation;
        int width;
    }

    public static class Size {
        private int m_height;
        private int m_width;

        Size(int OplusGLSurfaceView_13, int i2) {
            this.m_width = OplusGLSurfaceView_13;
            this.m_height = i2;
        }

        public int getWidth() {
            return this.m_width;
        }

        public int getHeight() {
            return this.m_height;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Size)) {
                return false;
            }
            Size size = (Size) obj;
            return this.m_width == size.m_width && this.m_height == size.m_height;
        }
    }

    public static ImageInfo getImageInfo(Context context, String str) throws IOException {
        ImageInfo imageInfo;
        if (str != null && !str.isEmpty()) {
            try {
                InputStream inputStreamTryCreateInputStreamFromImageFilePath = tryCreateInputStreamFromImageFilePath(context, str);
                if (inputStreamTryCreateInputStreamFromImageFilePath != null) {
                    imageInfo = getImageInfo(inputStreamTryCreateInputStreamFromImageFilePath);
                    inputStreamTryCreateInputStreamFromImageFilePath.close();
                    if (imageInfo == null) {
                        return null;
                    }
                } else {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(str, options);
                    if (options.outMimeType != null && options.outWidth >= 0 && options.outHeight >= 0) {
                        ImageInfo imageInfo2 = new ImageInfo();
                        imageInfo2.mimeType = options.outMimeType;
                        imageInfo2.width = options.outWidth;
                        imageInfo2.height = options.outHeight;
                        imageInfo2.orientation = 1;
                        imageInfo = imageInfo2;
                    }
                    Log.COUIBaseListPopupWindow_8(TAG, "Failed to get image information for " + str);
                    return null;
                }
                if (imageInfo.mimeType.equals("image/jpeg")) {
                    InputStream inputStreamTryCreateInputStreamFromImageFilePath2 = tryCreateInputStreamFromImageFilePath(context, str);
                    if (inputStreamTryCreateInputStreamFromImageFilePath2 != null) {
                        imageInfo.orientation = getImageRotation(inputStreamTryCreateInputStreamFromImageFilePath2);
                        inputStreamTryCreateInputStreamFromImageFilePath2.close();
                    } else {
                        imageInfo.orientation = getImageRotation(str);
                    }
                }
                return imageInfo;
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        return null;
    }

    public static ImageInfo getImageInfo(byte[] bArr) {
        ImageInfo imageInfo;
        if (bArr == null || (imageInfo = getImageInfo(new ByteArrayInputStream(bArr))) == null) {
            return null;
        }
        if (imageInfo.mimeType.equals("image/jpeg")) {
            imageInfo.orientation = getImageRotation(new ByteArrayInputStream(bArr));
        }
        return imageInfo;
    }

    public static Bitmap convertBitmapToRGBA(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            return bitmap;
        }
        try {
            return bitmap.copy(Bitmap.Config.ARGB_8888, false);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static Bitmap createBitmap(Context context, String str, Size size, int OplusGLSurfaceView_13, boolean z) throws IOException {
        ImageInfo imageInfo = getImageInfo(context, str);
        if (imageInfo == null) {
            return null;
        }
        try {
            Size size2 = new Size(imageInfo.width, imageInfo.height);
            InputStream inputStreamTryCreateInputStreamFromImageFilePath = tryCreateInputStreamFromImageFilePath(context, str);
            if (inputStreamTryCreateInputStreamFromImageFilePath != null) {
                Bitmap bitmapCreateBitmap = createBitmap(null, inputStreamTryCreateInputStreamFromImageFilePath, size2, size, OplusGLSurfaceView_13, z);
                inputStreamTryCreateInputStreamFromImageFilePath.close();
                return bitmapCreateBitmap;
            }
            return createBitmap(str, null, size2, size, OplusGLSurfaceView_13, z);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static Bitmap createBitmap(byte[] bArr, Size size, int OplusGLSurfaceView_13, boolean z) {
        ImageInfo imageInfo = getImageInfo(bArr);
        if (imageInfo == null) {
            return null;
        }
        try {
            return createBitmap(null, new ByteArrayInputStream(bArr), new Size(imageInfo.width, imageInfo.height), size, OplusGLSurfaceView_13, z);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static Bitmap createRotatedBitmap(Context context, String str, Size size, int OplusGLSurfaceView_13, boolean z) throws IOException {
        Bitmap bitmapCreateBitmap;
        ImageInfo imageInfo = getImageInfo(context, str);
        if (imageInfo == null) {
            return null;
        }
        try {
            Size size2 = new Size(imageInfo.width, imageInfo.height);
            InputStream inputStreamTryCreateInputStreamFromImageFilePath = tryCreateInputStreamFromImageFilePath(context, str);
            if (inputStreamTryCreateInputStreamFromImageFilePath != null) {
                bitmapCreateBitmap = createBitmap(null, inputStreamTryCreateInputStreamFromImageFilePath, size2, size, OplusGLSurfaceView_13, z);
                inputStreamTryCreateInputStreamFromImageFilePath.close();
            } else {
                bitmapCreateBitmap = createBitmap(str, null, size2, size, OplusGLSurfaceView_13, z);
            }
            if (bitmapCreateBitmap == null) {
                return null;
            }
            return imageInfo.orientation == 1 ? bitmapCreateBitmap : transformBitmap(bitmapCreateBitmap, imageInfo.orientation);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static Bitmap createRotatedBitmap(byte[] bArr, Size size, int OplusGLSurfaceView_13, boolean z) {
        ImageInfo imageInfo = getImageInfo(bArr);
        if (imageInfo == null) {
            return null;
        }
        try {
            Bitmap bitmapCreateBitmap = createBitmap(null, new ByteArrayInputStream(bArr), new Size(imageInfo.width, imageInfo.height), size, OplusGLSurfaceView_13, z);
            if (bitmapCreateBitmap == null) {
                return null;
            }
            return imageInfo.orientation == 1 ? bitmapCreateBitmap : transformBitmap(bitmapCreateBitmap, imageInfo.orientation);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static Bitmap createBitmapRegion(Context context, String str, Rect rect) throws IOException {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            InputStream inputStreamTryCreateInputStreamFromImageFilePath = tryCreateInputStreamFromImageFilePath(context, str);
            if (inputStreamTryCreateInputStreamFromImageFilePath != null) {
                Bitmap bitmapDecodeRegion = BitmapRegionDecoder.newInstance(inputStreamTryCreateInputStreamFromImageFilePath, false).decodeRegion(rect, options);
                inputStreamTryCreateInputStreamFromImageFilePath.close();
                return bitmapDecodeRegion;
            }
            return BitmapRegionDecoder.newInstance(str, false).decodeRegion(rect, options);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static Bitmap createBitmapRegion(byte[] bArr, Rect rect) {
        try {
            return BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false).decodeRegion(rect, new BitmapFactory.Options());
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static Bitmap createRgbaBitmap(int OplusGLSurfaceView_13, int i2) {
        try {
            return Bitmap.createBitmap(OplusGLSurfaceView_13, i2, Bitmap.Config.ARGB_8888);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int OplusGLSurfaceView_13) {
        try {
            Matrix matrix = new Matrix();
            matrix.postRotate(OplusGLSurfaceView_13);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static boolean saveBitmapToFile(Bitmap bitmap, int OplusGLSurfaceView_13, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            if (str.endsWith(".png")) {
                compressFormat = Bitmap.CompressFormat.PNG;
            }
            return bitmap.compress(compressFormat, OplusGLSurfaceView_13, fileOutputStream);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    private static Bitmap createBitmap(String str, InputStream inputStream, Size size, Size size2, int OplusGLSurfaceView_13, boolean z) {
        Size size3;
        Bitmap bitmapDecodeStream;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (size2 != null && !size2.equals(size)) {
                if (OplusGLSurfaceView_13 != 0) {
                    double width = size.getWidth() / size.getHeight();
                    double width2 = size2.getWidth() / size2.getHeight();
                    if (OplusGLSurfaceView_13 == 1) {
                        if (width >= width2) {
                            size3 = new Size(size2.getWidth(), (int) ((size2.getWidth() / width) + 0.5d));
                        } else {
                            size3 = new Size((int) ((size2.getHeight() * width) + 0.5d), size2.getHeight());
                        }
                    } else if (width >= width2) {
                        size3 = new Size((int) ((size2.getHeight() * width) + 0.5d), size2.getHeight());
                    } else {
                        size3 = new Size(size2.getWidth(), (int) ((size2.getWidth() / width) + 0.5d));
                    }
                } else {
                    size3 = size2;
                }
                options.inSampleSize = (int) (1.0f / Math.min(Math.max(size3.getWidth() / size.getWidth(), size3.getHeight() / size.getHeight()), 1.0f));
                if (str != null) {
                    bitmapDecodeStream = BitmapFactory.decodeFile(str, options);
                } else {
                    bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                }
                if (bitmapDecodeStream == null) {
                    return null;
                }
                return (bitmapDecodeStream.getWidth() > size3.getWidth() || bitmapDecodeStream.getHeight() > size3.getHeight()) ? Bitmap.createScaledBitmap(bitmapDecodeStream, size3.getWidth(), size3.getHeight(), z) : bitmapDecodeStream;
            }
            if (str != null) {
                return BitmapFactory.decodeFile(str, options);
            }
            return BitmapFactory.decodeStream(inputStream, null, options);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap transformBitmap(Bitmap bitmap, int OplusGLSurfaceView_13) throws Exception {
        Matrix matrix = new Matrix();
        switch (OplusGLSurfaceView_13) {
            case 2:
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.postRotate(180.0f);
                break;
            case 4:
                matrix.postScale(1.0f, -1.0f);
                break;
            case 5:
                matrix.postScale(-1.0f, 1.0f);
                matrix.postRotate(270.0f);
                break;
            case 6:
                matrix.postRotate(90.0f);
                break;
            case 7:
                matrix.postScale(-1.0f, 1.0f);
                matrix.postRotate(90.0f);
                break;
            case 8:
                matrix.postRotate(270.0f);
                break;
            default:
                return bitmap;
        }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    private static ImageInfo getImageInfo(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, options);
            if (options.outMimeType != null && options.outWidth >= 0 && options.outHeight >= 0) {
                ImageInfo imageInfo = new ImageInfo();
                imageInfo.mimeType = options.outMimeType;
                imageInfo.width = options.outWidth;
                imageInfo.height = options.outHeight;
                imageInfo.orientation = 1;
                return imageInfo;
            }
            return null;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    private static InputStream tryCreateInputStreamFromImageFilePath(Context context, String str) {
        try {
            if (str.startsWith("assets:/")) {
                if (context == null) {
                    return null;
                }
                return context.getAssets().open(str.substring(8));
            }
            if (!str.startsWith("content://") || context == null) {
                return null;
            }
            return context.getContentResolver().openInputStream(Uri.parse(str));
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    private static int getImageRotation(String str) {
        try {
            return new ExifInterface(str).getAttributeInt("Orientation", 1);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return 1;
        }
    }

    private static int getImageRotation(InputStream inputStream) {
        if (Build.VERSION.SDK_INT < 24) {
            return 1;
        }
        try {
            return new ExifInterface(inputStream).getAttributeInt("Orientation", 1);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return 1;
        }
    }
}
