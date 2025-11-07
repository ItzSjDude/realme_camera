package com.google.zxing.multi.qrcode.detector;

/* loaded from: classes.dex */
public final class MultiDetector extends com.google.zxing.qrcode.detector.Detector {
    private static final com.google.zxing.common.DetectorResult[] EMPTY_DETECTOR_RESULTS = new com.google.zxing.common.DetectorResult[0];

    public MultiDetector(com.google.zxing.common.BitMatrix bitMatrix) {
        super(bitMatrix);
    }

    public com.google.zxing.common.DetectorResult[] detectMulti(java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException {
        com.google.zxing.qrcode.detector.FinderPatternInfo[] finderPatternInfoArrFindMulti = new com.google.zxing.multi.qrcode.detector.MultiFinderPatternFinder(getImage(), map == null ? null : (com.google.zxing.ResultPointCallback) map.get(com.google.zxing.DecodeHintType.NEED_RESULT_POINT_CALLBACK)).findMulti(map);
        if (finderPatternInfoArrFindMulti.length == 0) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.google.zxing.qrcode.detector.FinderPatternInfo finderPatternInfo : finderPatternInfoArrFindMulti) {
            try {
                arrayList.add(processFinderPatternInfo(finderPatternInfo));
            } catch (com.google.zxing.ReaderException unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return EMPTY_DETECTOR_RESULTS;
        }
        return (com.google.zxing.common.DetectorResult[]) arrayList.toArray(EMPTY_DETECTOR_RESULTS);
    }
}
