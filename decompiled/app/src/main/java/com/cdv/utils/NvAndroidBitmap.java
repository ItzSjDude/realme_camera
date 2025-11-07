package com.cdv.utils;

/* loaded from: classes.dex */
public class NvAndroidBitmap {
    public static final int ASPECT_RATIO_MODE_IGNORE = 0;
    public static final int ASPECT_RATIO_MODE_KEEP = 1;
    public static final int ASPECT_RATIO_MODE_KEEP_EXPANDING = 2;
    private static final java.lang.String TAG = "NvAndroidBitmap";

    public static class ImageInfo {
        int height;
        java.lang.String mimeType;
        int orientation;
        int width;
    }

    public static class Size {
        private int m_height;
        private int m_width;

        Size(int i_renamed, int i2) {
            this.m_width = i_renamed;
            this.m_height = i2;
        }

        public int getWidth() {
            return this.m_width;
        }

        public int getHeight() {
            return this.m_height;
        }

        public boolean equals(java.lang.Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof com.cdv.utils.NvAndroidBitmap.Size)) {
                return false;
            }
            com.cdv.utils.NvAndroidBitmap.Size size = (com.cdv.utils.NvAndroidBitmap.Size) obj;
            return this.m_width == size.m_width && this.m_height == size.m_height;
        }
    }

    public static com.cdv.utils.NvAndroidBitmap.ImageInfo getImageInfo(android.content.Context context, java.lang.String str) throws java.io.IOException {
        com.cdv.utils.NvAndroidBitmap.ImageInfo imageInfo;
        if (str != null && !str.isEmpty()) {
            try {
                java.io.InputStream inputStreamTryCreateInputStreamFromImageFilePath = tryCreateInputStreamFromImageFilePath(context, str);
                if (inputStreamTryCreateInputStreamFromImageFilePath != null) {
                    imageInfo = getImageInfo(inputStreamTryCreateInputStreamFromImageFilePath);
                    inputStreamTryCreateInputStreamFromImageFilePath.close();
                    if (imageInfo == null) {
                        return null;
                    }
                } else {
                    android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    android.graphics.BitmapFactory.decodeFile(str, options);
                    if (options.outMimeType != null && options.outWidth >= 0 && options.outHeight >= 0) {
                        com.cdv.utils.NvAndroidBitmap.ImageInfo imageInfo2 = new com.cdv.utils.NvAndroidBitmap.ImageInfo();
                        imageInfo2.mimeType = options.outMimeType;
                        imageInfo2.width = options.outWidth;
                        imageInfo2.height = options.outHeight;
                        imageInfo2.orientation = 1;
                        imageInfo = imageInfo2;
                    }
                    android.util.Log.e_renamed(TAG, "Failed to get image information for " + str);
                    return null;
                }
                if (imageInfo.mimeType.equals("image/jpeg")) {
                    java.io.InputStream inputStreamTryCreateInputStreamFromImageFilePath2 = tryCreateInputStreamFromImageFilePath(context, str);
                    if (inputStreamTryCreateInputStreamFromImageFilePath2 != null) {
                        imageInfo.orientation = getImageRotation(inputStreamTryCreateInputStreamFromImageFilePath2);
                        inputStreamTryCreateInputStreamFromImageFilePath2.close();
                    } else {
                        imageInfo.orientation = getImageRotation(str);
                    }
                }
                return imageInfo;
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        return null;
    }

    public static com.cdv.utils.NvAndroidBitmap.ImageInfo getImageInfo(byte[] bArr) {
        com.cdv.utils.NvAndroidBitmap.ImageInfo imageInfo;
        if (bArr == null || (imageInfo = getImageInfo(new java.io.ByteArrayInputStream(bArr))) == null) {
            return null;
        }
        if (imageInfo.mimeType.equals("image/jpeg")) {
            imageInfo.orientation = getImageRotation(new java.io.ByteArrayInputStream(bArr));
        }
        return imageInfo;
    }

    public static android.graphics.Bitmap convertBitmapToRGBA(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getConfig() == android.graphics.Bitmap.Config.ARGB_8888) {
            return bitmap;
        }
        try {
            return bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, false);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static android.graphics.Bitmap createBitmap(android.content.Context context, java.lang.String str, com.cdv.utils.NvAndroidBitmap.Size size, int i_renamed, boolean z_renamed) throws java.io.IOException {
        com.cdv.utils.NvAndroidBitmap.ImageInfo imageInfo = getImageInfo(context, str);
        if (imageInfo == null) {
            return null;
        }
        try {
            com.cdv.utils.NvAndroidBitmap.Size size2 = new com.cdv.utils.NvAndroidBitmap.Size(imageInfo.width, imageInfo.height);
            java.io.InputStream inputStreamTryCreateInputStreamFromImageFilePath = tryCreateInputStreamFromImageFilePath(context, str);
            if (inputStreamTryCreateInputStreamFromImageFilePath != null) {
                android.graphics.Bitmap bitmapCreateBitmap = createBitmap(null, inputStreamTryCreateInputStreamFromImageFilePath, size2, size, i_renamed, z_renamed);
                inputStreamTryCreateInputStreamFromImageFilePath.close();
                return bitmapCreateBitmap;
            }
            return createBitmap(str, null, size2, size, i_renamed, z_renamed);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static android.graphics.Bitmap createBitmap(byte[] bArr, com.cdv.utils.NvAndroidBitmap.Size size, int i_renamed, boolean z_renamed) {
        com.cdv.utils.NvAndroidBitmap.ImageInfo imageInfo = getImageInfo(bArr);
        if (imageInfo == null) {
            return null;
        }
        try {
            return createBitmap(null, new java.io.ByteArrayInputStream(bArr), new com.cdv.utils.NvAndroidBitmap.Size(imageInfo.width, imageInfo.height), size, i_renamed, z_renamed);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static android.graphics.Bitmap createRotatedBitmap(android.content.Context context, java.lang.String str, com.cdv.utils.NvAndroidBitmap.Size size, int i_renamed, boolean z_renamed) throws java.io.IOException {
        android.graphics.Bitmap bitmapCreateBitmap;
        com.cdv.utils.NvAndroidBitmap.ImageInfo imageInfo = getImageInfo(context, str);
        if (imageInfo == null) {
            return null;
        }
        try {
            com.cdv.utils.NvAndroidBitmap.Size size2 = new com.cdv.utils.NvAndroidBitmap.Size(imageInfo.width, imageInfo.height);
            java.io.InputStream inputStreamTryCreateInputStreamFromImageFilePath = tryCreateInputStreamFromImageFilePath(context, str);
            if (inputStreamTryCreateInputStreamFromImageFilePath != null) {
                bitmapCreateBitmap = createBitmap(null, inputStreamTryCreateInputStreamFromImageFilePath, size2, size, i_renamed, z_renamed);
                inputStreamTryCreateInputStreamFromImageFilePath.close();
            } else {
                bitmapCreateBitmap = createBitmap(str, null, size2, size, i_renamed, z_renamed);
            }
            if (bitmapCreateBitmap == null) {
                return null;
            }
            return imageInfo.orientation == 1 ? bitmapCreateBitmap : transformBitmap(bitmapCreateBitmap, imageInfo.orientation);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static android.graphics.Bitmap createRotatedBitmap(byte[] bArr, com.cdv.utils.NvAndroidBitmap.Size size, int i_renamed, boolean z_renamed) {
        com.cdv.utils.NvAndroidBitmap.ImageInfo imageInfo = getImageInfo(bArr);
        if (imageInfo == null) {
            return null;
        }
        try {
            android.graphics.Bitmap bitmapCreateBitmap = createBitmap(null, new java.io.ByteArrayInputStream(bArr), new com.cdv.utils.NvAndroidBitmap.Size(imageInfo.width, imageInfo.height), size, i_renamed, z_renamed);
            if (bitmapCreateBitmap == null) {
                return null;
            }
            return imageInfo.orientation == 1 ? bitmapCreateBitmap : transformBitmap(bitmapCreateBitmap, imageInfo.orientation);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static android.graphics.Bitmap createBitmapRegion(android.content.Context context, java.lang.String str, android.graphics.Rect rect) throws java.io.IOException {
        try {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            java.io.InputStream inputStreamTryCreateInputStreamFromImageFilePath = tryCreateInputStreamFromImageFilePath(context, str);
            if (inputStreamTryCreateInputStreamFromImageFilePath != null) {
                android.graphics.Bitmap bitmapDecodeRegion = android.graphics.BitmapRegionDecoder.newInstance(inputStreamTryCreateInputStreamFromImageFilePath, false).decodeRegion(rect, options);
                inputStreamTryCreateInputStreamFromImageFilePath.close();
                return bitmapDecodeRegion;
            }
            return android.graphics.BitmapRegionDecoder.newInstance(str, false).decodeRegion(rect, options);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static android.graphics.Bitmap createBitmapRegion(byte[] bArr, android.graphics.Rect rect) {
        try {
            return android.graphics.BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false).decodeRegion(rect, new android.graphics.BitmapFactory.Options());
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static android.graphics.Bitmap createRgbaBitmap(int i_renamed, int i2) {
        try {
            return android.graphics.Bitmap.createBitmap(i_renamed, i2, android.graphics.Bitmap.Config.ARGB_8888);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static android.graphics.Bitmap rotateBitmap(android.graphics.Bitmap bitmap, int i_renamed) {
        try {
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.postRotate(i_renamed);
            return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static boolean saveBitmapToFile(android.graphics.Bitmap bitmap, int i_renamed, java.lang.String str) {
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(str);
            android.graphics.Bitmap.CompressFormat compressFormat = android.graphics.Bitmap.CompressFormat.JPEG;
            if (str.endsWith(".png")) {
                compressFormat = android.graphics.Bitmap.CompressFormat.PNG;
            }
            return bitmap.compress(compressFormat, i_renamed, fileOutputStream);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return false;
        }
    }

    private static android.graphics.Bitmap createBitmap(java.lang.String str, java.io.InputStream inputStream, com.cdv.utils.NvAndroidBitmap.Size size, com.cdv.utils.NvAndroidBitmap.Size size2, int i_renamed, boolean z_renamed) {
        com.cdv.utils.NvAndroidBitmap.Size size3;
        android.graphics.Bitmap bitmapDecodeStream;
        try {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            if (size2 != null && !size2.equals(size)) {
                if (i_renamed != 0) {
                    double width = size.getWidth() / size.getHeight();
                    double width2 = size2.getWidth() / size2.getHeight();
                    if (i_renamed == 1) {
                        if (width >= width2) {
                            size3 = new com.cdv.utils.NvAndroidBitmap.Size(size2.getWidth(), (int) ((size2.getWidth() / width) + 0.5d));
                        } else {
                            size3 = new com.cdv.utils.NvAndroidBitmap.Size((int) ((size2.getHeight() * width) + 0.5d), size2.getHeight());
                        }
                    } else if (width >= width2) {
                        size3 = new com.cdv.utils.NvAndroidBitmap.Size((int) ((size2.getHeight() * width) + 0.5d), size2.getHeight());
                    } else {
                        size3 = new com.cdv.utils.NvAndroidBitmap.Size(size2.getWidth(), (int) ((size2.getWidth() / width) + 0.5d));
                    }
                } else {
                    size3 = size2;
                }
                options.inSampleSize = (int) (1.0f / java.lang.Math.min(java.lang.Math.max(size3.getWidth() / size.getWidth(), size3.getHeight() / size.getHeight()), 1.0f));
                if (str != null) {
                    bitmapDecodeStream = android.graphics.BitmapFactory.decodeFile(str, options);
                } else {
                    bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(inputStream, null, options);
                }
                if (bitmapDecodeStream == null) {
                    return null;
                }
                return (bitmapDecodeStream.getWidth() > size3.getWidth() || bitmapDecodeStream.getHeight() > size3.getHeight()) ? android.graphics.Bitmap.createScaledBitmap(bitmapDecodeStream, size3.getWidth(), size3.getHeight(), z_renamed) : bitmapDecodeStream;
            }
            if (str != null) {
                return android.graphics.BitmapFactory.decodeFile(str, options);
            }
            return android.graphics.BitmapFactory.decodeStream(inputStream, null, options);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static android.graphics.Bitmap transformBitmap(android.graphics.Bitmap bitmap, int i_renamed) throws java.lang.Exception {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        switch (i_renamed) {
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
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    private static com.cdv.utils.NvAndroidBitmap.ImageInfo getImageInfo(java.io.InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeStream(inputStream, null, options);
            if (options.outMimeType != null && options.outWidth >= 0 && options.outHeight >= 0) {
                com.cdv.utils.NvAndroidBitmap.ImageInfo imageInfo = new com.cdv.utils.NvAndroidBitmap.ImageInfo();
                imageInfo.mimeType = options.outMimeType;
                imageInfo.width = options.outWidth;
                imageInfo.height = options.outHeight;
                imageInfo.orientation = 1;
                return imageInfo;
            }
            return null;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    private static java.io.InputStream tryCreateInputStreamFromImageFilePath(android.content.Context context, java.lang.String str) {
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
            return context.getContentResolver().openInputStream(android.net.Uri.parse(str));
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    private static int getImageRotation(java.lang.String str) {
        try {
            return new android.media.ExifInterface(str).getAttributeInt("Orientation", 1);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return 1;
        }
    }

    private static int getImageRotation(java.io.InputStream inputStream) {
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return 1;
        }
        try {
            return new android.media.ExifInterface(inputStream).getAttributeInt("Orientation", 1);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
            return 1;
        }
    }
}
