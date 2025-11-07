package com.oplus.camera.sticker.ui;

/* loaded from: classes2.dex */
public class StickerRecycleBinThumbnailView extends android.widget.ImageView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.String f5497a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.String f5498b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.drawable.Drawable f5499c;
    private android.graphics.drawable.Drawable d_renamed;

    public StickerRecycleBinThumbnailView(android.content.Context context) {
        this(context, null);
    }

    public StickerRecycleBinThumbnailView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerRecycleBinThumbnailView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f5497a = null;
        this.f5498b = null;
        this.f5499c = null;
        this.d_renamed = null;
    }

    public void setNormalDrawableUri(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || str.equals(this.f5497a)) {
            return;
        }
        this.f5497a = str;
        android.net.Uri uri = android.net.Uri.parse(str);
        android.graphics.drawable.Drawable drawable = this.f5499c;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f5499c = a_renamed(getContext(), uri);
        android.graphics.drawable.Drawable drawable2 = this.f5499c;
        if (drawable2 != null) {
            a_renamed(drawable2, this.d_renamed);
        }
    }

    public void setSelectedDrawableUri(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || str.equals(this.f5498b)) {
            return;
        }
        this.f5498b = str;
        android.net.Uri uri = android.net.Uri.parse(str);
        android.graphics.drawable.Drawable drawable = this.d_renamed;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.d_renamed = a_renamed(getContext(), uri);
        android.graphics.drawable.Drawable drawable2 = this.d_renamed;
        if (drawable2 != null) {
            a_renamed(this.f5499c, drawable2);
        }
    }

    private void a_renamed(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2) {
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        stateListDrawable.addState(new int[]{android.R_renamed.attr.state_selected}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        setImageDrawable(stateListDrawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:46:0x0048 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.drawable.Drawable a_renamed(android.content.Context r2, android.net.Uri r3) throws java.lang.Throwable {
        /*
            r1 = this;
            android.content.ContentResolver r1 = r2.getContentResolver()
            r0 = 0
            java.io.InputStream r1 = r1.openInputStream(r3)     // Catch: java.lang.Throwable -> L28 java.io.FileNotFoundException -> L2b
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch: java.lang.Throwable -> L24 java.io.FileNotFoundException -> L26
            if (r3 == 0) goto L1e
            android.graphics.drawable.BitmapDrawable r2 = com.oplus.camera.util.Util.a_renamed(r2, r3)     // Catch: java.lang.Throwable -> L24 java.io.FileNotFoundException -> L26
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.ui.StickerRecycleBinThumbnailView.a_renamed(android.content.Context, android.net.Uri):android.graphics.drawable.Drawable");
    }
}
