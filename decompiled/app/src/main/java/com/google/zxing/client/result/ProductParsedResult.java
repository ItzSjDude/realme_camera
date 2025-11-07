package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class ProductParsedResult extends com.google.zxing.client.result.ParsedResult {
    private final java.lang.String normalizedProductID;
    private final java.lang.String productID;

    ProductParsedResult(java.lang.String str) {
        this(str, str);
    }

    ProductParsedResult(java.lang.String str, java.lang.String str2) {
        super(com.google.zxing.client.result.ParsedResultType.PRODUCT);
        this.productID = str;
        this.normalizedProductID = str2;
    }

    public java.lang.String getProductID() {
        return this.productID;
    }

    public java.lang.String getNormalizedProductID() {
        return this.normalizedProductID;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        return this.productID;
    }
}
