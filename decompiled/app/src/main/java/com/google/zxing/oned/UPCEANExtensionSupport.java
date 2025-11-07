package com.google.zxing.oned;

/* loaded from: classes.dex */
final class UPCEANExtensionSupport {
    private static final int[] EXTENSION_START_PATTERN = {1, 1, 2};
    private final com.google.zxing.oned.UPCEANExtension2Support twoSupport = new com.google.zxing.oned.UPCEANExtension2Support();
    private final com.google.zxing.oned.UPCEANExtension5Support fiveSupport = new com.google.zxing.oned.UPCEANExtension5Support();

    UPCEANExtensionSupport() {
    }

    com.google.zxing.Result decodeRow(int i_renamed, com.google.zxing.common.BitArray bitArray, int i2) throws com.google.zxing.NotFoundException {
        int[] iArrFindGuardPattern = com.google.zxing.oned.UPCEANReader.findGuardPattern(bitArray, i2, false, EXTENSION_START_PATTERN);
        try {
            return this.fiveSupport.decodeRow(i_renamed, bitArray, iArrFindGuardPattern);
        } catch (com.google.zxing.ReaderException unused) {
            return this.twoSupport.decodeRow(i_renamed, bitArray, iArrFindGuardPattern);
        }
    }
}
