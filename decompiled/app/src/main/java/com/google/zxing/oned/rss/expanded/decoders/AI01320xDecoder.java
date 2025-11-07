package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

/* loaded from: classes.dex */
final class AI01320xDecoder extends AI013x0xDecoder {
    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected int checkWeight(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 < 10000 ? OplusGLSurfaceView_13 : OplusGLSurfaceView_13 - 10000;
    }

    AI01320xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    protected void addWeightCode(StringBuilder sb, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }
}
