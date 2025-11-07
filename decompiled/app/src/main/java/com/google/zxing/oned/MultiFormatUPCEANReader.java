package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class MultiFormatUPCEANReader extends com.google.zxing.oned.OneDReader {
    private static final com.google.zxing.oned.UPCEANReader[] EMPTY_READER_ARRAY = new com.google.zxing.oned.UPCEANReader[0];
    private final com.google.zxing.oned.UPCEANReader[] readers;

    public MultiFormatUPCEANReader(java.util.Map<com.google.zxing.DecodeHintType, ?> map) {
        java.util.Collection collection = map == null ? null : (java.util.Collection) map.get(com.google.zxing.DecodeHintType.POSSIBLE_FORMATS);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (collection != null) {
            if (collection.contains(com.google.zxing.BarcodeFormat.EAN_13)) {
                arrayList.add(new com.google.zxing.oned.EAN13Reader());
            } else if (collection.contains(com.google.zxing.BarcodeFormat.UPC_A)) {
                arrayList.add(new com.google.zxing.oned.UPCAReader());
            }
            if (collection.contains(com.google.zxing.BarcodeFormat.EAN_8)) {
                arrayList.add(new com.google.zxing.oned.EAN8Reader());
            }
            if (collection.contains(com.google.zxing.BarcodeFormat.UPC_E)) {
                arrayList.add(new com.google.zxing.oned.UPCEReader());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new com.google.zxing.oned.EAN13Reader());
            arrayList.add(new com.google.zxing.oned.EAN8Reader());
            arrayList.add(new com.google.zxing.oned.UPCEReader());
        }
        this.readers = (com.google.zxing.oned.UPCEANReader[]) arrayList.toArray(EMPTY_READER_ARRAY);
    }

    @Override // com.google.zxing.oned.OneDReader
    public com.google.zxing.Result decodeRow(int i_renamed, com.google.zxing.common.BitArray bitArray, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException {
        int[] iArrFindStartGuardPattern = com.google.zxing.oned.UPCEANReader.findStartGuardPattern(bitArray);
        for (com.google.zxing.oned.UPCEANReader uPCEANReader : this.readers) {
            try {
                com.google.zxing.Result resultDecodeRow = uPCEANReader.decodeRow(i_renamed, bitArray, iArrFindStartGuardPattern, map);
                boolean z_renamed = resultDecodeRow.getBarcodeFormat() == com.google.zxing.BarcodeFormat.EAN_13 && resultDecodeRow.getText().charAt(0) == '0';
                java.util.Collection collection = map == null ? null : (java.util.Collection) map.get(com.google.zxing.DecodeHintType.POSSIBLE_FORMATS);
                boolean z2 = collection == null || collection.contains(com.google.zxing.BarcodeFormat.UPC_A);
                if (!z_renamed || !z2) {
                    return resultDecodeRow;
                }
                com.google.zxing.Result result = new com.google.zxing.Result(resultDecodeRow.getText().substring(1), resultDecodeRow.getRawBytes(), resultDecodeRow.getResultPoints(), com.google.zxing.BarcodeFormat.UPC_A);
                result.putAllMetadata(resultDecodeRow.getResultMetadata());
                return result;
            } catch (com.google.zxing.ReaderException unused) {
            }
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        for (com.google.zxing.oned.UPCEANReader uPCEANReader : this.readers) {
            uPCEANReader.reset();
        }
    }
}
