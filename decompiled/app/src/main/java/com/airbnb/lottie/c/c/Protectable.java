package com.airbnb.lottie.c_renamed.c_renamed;

/* compiled from: ImageLayer.java */
/* loaded from: classes.dex */
public class c_renamed extends com.airbnb.lottie.c_renamed.c_renamed.a_renamed {
    private final android.graphics.Paint e_renamed;
    private final android.graphics.Rect f_renamed;
    private final android.graphics.Rect g_renamed;
    private com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> h_renamed;

    c_renamed(com.airbnb.lottie.f_renamed fVar, com.airbnb.lottie.c_renamed.c_renamed.d_renamed dVar) {
        super(fVar, dVar);
        this.e_renamed = new com.airbnb.lottie.a_renamed.a_renamed(3);
        this.f_renamed = new android.graphics.Rect();
        this.g_renamed = new android.graphics.Rect();
    }

    @Override // com.airbnb.lottie.c_renamed.c_renamed.a_renamed
    public void b_renamed(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i_renamed) {
        android.graphics.Bitmap bitmapF = f_renamed();
        if (bitmapF == null || bitmapF.isRecycled()) {
            return;
        }
        float fA_renamed = com.airbnb.lottie.f_renamed.h_renamed.a_renamed();
        this.e_renamed.setAlpha(i_renamed);
        com.airbnb.lottie.a_renamed.b_renamed.a_renamed<android.graphics.ColorFilter, android.graphics.ColorFilter> aVar = this.h_renamed;
        if (aVar != null) {
            this.e_renamed.setColorFilter(aVar.g_renamed());
        }
        canvas.save();
        canvas.concat(matrix);
        this.f_renamed.set(0, 0, bitmapF.getWidth(), bitmapF.getHeight());
        this.g_renamed.set(0, 0, (int) (bitmapF.getWidth() * fA_renamed), (int) (bitmapF.getHeight() * fA_renamed));
        canvas.drawBitmap(bitmapF, this.f_renamed, this.g_renamed, this.e_renamed);
        canvas.restore();
    }

    @Override // com.airbnb.lottie.c_renamed.c_renamed.a_renamed, com.airbnb.lottie.a_renamed.a_renamed.e_renamed
    public void a_renamed(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z_renamed) {
        super.a_renamed(rectF, matrix, z_renamed);
        if (f_renamed() != null) {
            rectF.set(0.0f, 0.0f, r3.getWidth() * com.airbnb.lottie.f_renamed.h_renamed.a_renamed(), r3.getHeight() * com.airbnb.lottie.f_renamed.h_renamed.a_renamed());
            this.f2117a.mapRect(rectF);
        }
    }

    private android.graphics.Bitmap f_renamed() {
        return this.f2118b.e_renamed(this.f2119c.g_renamed());
    }

    @Override // com.airbnb.lottie.c_renamed.c_renamed.a_renamed, com.airbnb.lottie.c_renamed.f_renamed
    public <T_renamed> void a_renamed(T_renamed t_renamed, com.airbnb.lottie.g_renamed.c_renamed<T_renamed> cVar) {
        super.a_renamed((com.airbnb.lottie.c_renamed.c_renamed.c_renamed) t_renamed, (com.airbnb.lottie.g_renamed.c_renamed<com.airbnb.lottie.c_renamed.c_renamed.c_renamed>) cVar);
        if (t_renamed == com.airbnb.lottie.k_renamed.E_renamed) {
            if (cVar == null) {
                this.h_renamed = null;
            } else {
                this.h_renamed = new com.airbnb.lottie.a_renamed.b_renamed.p_renamed(cVar);
            }
        }
    }
}
