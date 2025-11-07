package com.oplus.exif;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
class OplusExifReader {
    private static final String TAG = "ExifReader";
    private final OplusExifInterface mInterface;

    OplusExifReader(OplusExifInterface oplusExifInterface) {
        this.mInterface = oplusExifInterface;
    }

    protected OplusExifData read(InputStream inputStream) throws OplusExifInvalidFormatException, IOException {
        OplusExifParser oplusExifParser = OplusExifParser.parse(inputStream, this.mInterface);
        OplusExifData oplusExifData = new OplusExifData(oplusExifParser.getByteOrder());
        for (int next = oplusExifParser.next(); next != 5; next = oplusExifParser.next()) {
            if (next == 0) {
                oplusExifData.addIfdData(new OplusIfdData(oplusExifParser.getCurrentIfd()));
            } else if (next == 1) {
                OplusExifTag tag = oplusExifParser.getTag();
                if (!tag.hasValue()) {
                    oplusExifParser.registerForTagValue(tag);
                } else {
                    oplusExifData.getIfdData(tag.getIfd()).setTag(tag);
                }
            } else if (next == 2) {
                OplusExifTag tag2 = oplusExifParser.getTag();
                if (tag2.getDataType() == 7) {
                    oplusExifParser.readFullTagValue(tag2);
                }
                oplusExifData.getIfdData(tag2.getIfd()).setTag(tag2);
            } else if (next == 3) {
                byte[] bArr = new byte[oplusExifParser.getCompressedImageSize()];
                if (bArr.length == oplusExifParser.read(bArr)) {
                    oplusExifData.setCompressedThumbnail(bArr);
                } else {
                    Log.w(TAG, "Failed to read the compressed thumbnail");
                }
            } else if (next == 4) {
                byte[] bArr2 = new byte[oplusExifParser.getStripSize()];
                if (bArr2.length == oplusExifParser.read(bArr2)) {
                    oplusExifData.setStripBytes(oplusExifParser.getStripIndex(), bArr2);
                } else {
                    Log.w(TAG, "Failed to read the strip bytes");
                }
            }
        }
        return oplusExifData;
    }
}
