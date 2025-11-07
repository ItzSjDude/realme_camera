package com.google.zxing.pdf417.decoder;

/* loaded from: classes.dex */
final class BarcodeValue {
    private final java.util.Map<java.lang.Integer, java.lang.Integer> values = new java.util.HashMap();

    BarcodeValue() {
    }

    void setValue(int i_renamed) {
        java.lang.Integer num = this.values.get(java.lang.Integer.valueOf(i_renamed));
        if (num == null) {
            num = 0;
        }
        this.values.put(java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(num.intValue() + 1));
    }

    int[] getValue() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int iIntValue = -1;
        for (java.util.Map.Entry<java.lang.Integer, java.lang.Integer> entry : this.values.entrySet()) {
            if (entry.getValue().intValue() > iIntValue) {
                iIntValue = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == iIntValue) {
                arrayList.add(entry.getKey());
            }
        }
        return com.google.zxing.pdf417.PDF417Common.toIntArray(arrayList);
    }

    java.lang.Integer getConfidence(int i_renamed) {
        return this.values.get(java.lang.Integer.valueOf(i_renamed));
    }
}
