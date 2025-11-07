package com.oplus.camera.sticker.p168ui;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class StickerRecycleBinThumbnailView extends ImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f16304a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String f16305b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Drawable f16306c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Drawable f16307d;

    public StickerRecycleBinThumbnailView(Context context) {
        this(context, null);
    }

    public StickerRecycleBinThumbnailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerRecycleBinThumbnailView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f16304a = null;
        this.f16305b = null;
        this.f16306c = null;
        this.f16307d = null;
    }

    public void setNormalDrawableUri(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.f16304a)) {
            return;
        }
        this.f16304a = str;
        Uri uri = Uri.parse(str);
        Drawable drawable = this.f16306c;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f16306c = m17004a(getContext(), uri);
        Drawable drawable2 = this.f16306c;
        if (drawable2 != null) {
            m17005a(drawable2, this.f16307d);
        }
    }

    public void setSelectedDrawableUri(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.f16305b)) {
            return;
        }
        this.f16305b = str;
        Uri uri = Uri.parse(str);
        Drawable drawable = this.f16307d;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f16307d = m17004a(getContext(), uri);
        Drawable drawable2 = this.f16307d;
        if (drawable2 != null) {
            m17005a(this.f16306c, drawable2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17005a(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_selected}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        setImageDrawable(stateListDrawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.drawable.Drawable m17004a(android.content.Context r2, android.net.Uri r3) throws java.lang.Throwable {
        /*
            r1 = this;
            android.content.ContentResolver r1 = r2.getContentResolver()
            r0 = 0
            java.io.InputStream r1 = r1.openInputStream(r3)     // Catch: java.lang.Throwable -> L28 java.io.FileNotFoundException -> L2b
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch: java.lang.Throwable -> L24 java.io.FileNotFoundException -> L26
            if (r3 == 0) goto L1e
            android.graphics.drawable.BitmapDrawable r2 = com.oplus.camera.util.Util.m24227a(r2, r3)     // Catch: java.lang.Throwable -> L24 java.io.FileNotFoundException -> L26
            if (r1 == 0) goto L1d
            r1.close()     // Catch: java.io.IOException -> L19
            goto L1d
        L19:
            r1 = move-exception
            r1.printStackTrace()
        L1d:
            return r2
        L1e:
            if (r1 == 0) goto L3a
            r1.close()     // Catch: java.io.IOException -> L36
            goto L3a
        L24:
            r2 = move-exception
            goto L46
        L26:
            r3 = move-exception
            goto L2d
        L28:
            r2 = move-exception
            r1 = r0
            goto L46
        L2b:
            r3 = move-exception
            r1 = r0
        L2d:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L3a
            r1.close()     // Catch: java.io.IOException -> L36
            goto L3a
        L36:
            r1 = move-exception
            r1.printStackTrace()
        L3a:
            android.content.res.Resources r1 = r2.getResources()
            r2 = 2131232270(0x7f08060e, float:1.8080645E38)
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2, r0)
            return r1
        L46:
            if (r1 == 0) goto L50
            r1.close()     // Catch: java.io.IOException -> L4c
            goto L50
        L4c:
            r1 = move-exception
            r1.printStackTrace()
        L50:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.p168ui.StickerRecycleBinThumbnailView.m17004a(android.content.Context, android.net.Uri):android.graphics.drawable.Drawable");
    }
}
