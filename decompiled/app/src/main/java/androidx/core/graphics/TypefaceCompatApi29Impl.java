package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import androidx.core.p027a.p028a.FontResourcesParserCompat;
import androidx.core.p033e.FontsContractCompat;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: TypefaceCompatApi29Impl.java */
/* renamed from: androidx.core.graphics.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    /* renamed from: PlatformImplementations.kt_3 */
    protected FontsContractCompat.IntrinsicsJvm.kt_4 mo2641a(FontsContractCompat.IntrinsicsJvm.kt_4[] bVarArr, int OplusGLSurfaceView_13) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    /* renamed from: PlatformImplementations.kt_3 */
    protected Typeface mo2640a(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001c A[Catch: IOException -> 0x006e, PHI: r3
      0x001c: PHI (r3v5 android.graphics.fonts.FontFamily$Builder) = (r3v3 android.graphics.fonts.FontFamily$Builder), (r3v1 android.graphics.fonts.FontFamily$Builder) binds: [B:19:0x0051, B:8:0x001a] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {IOException -> 0x006e, blocks: (B:6:0x000e, B:9:0x001c, B:29:0x0061, B:33:0x006a, B:32:0x0066, B:34:0x006d), top: B:52:0x000e, inners: #2 }] */
    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Typeface mo2619a(android.content.Context r11, android.os.CancellationSignal r12, androidx.core.p033e.FontsContractCompat.IntrinsicsJvm.kt_4[] r13, int r14) throws java.lang.Throwable {
        /*
            r10 = this;
            android.content.ContentResolver r10 = r11.getContentResolver()
            int r11 = r13.length
            r0 = 0
            r1 = 0
            r2 = r0
            r3 = r1
        L9:
            r4 = 1
            if (r2 >= r11) goto L71
            r5 = r13[r2]
            android.net.Uri r6 = r5.m2470a()     // Catch: java.io.IOException -> L6e
            java.lang.String r7 = "r"
            android.os.ParcelFileDescriptor r6 = r10.openFileDescriptor(r6, r7, r12)     // Catch: java.io.IOException -> L6e
            if (r6 != 0) goto L20
            if (r6 == 0) goto L6e
        L1c:
            r6.close()     // Catch: java.io.IOException -> L6e
            goto L6e
        L20:
            android.graphics.fonts.Font$Builder r7 = new android.graphics.fonts.Font$Builder     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            int r8 = r5.m2472c()     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            android.graphics.fonts.Font$Builder r7 = r7.setWeight(r8)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            boolean r8 = r5.m2473d()     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            if (r8 == 0) goto L34
            goto L35
        L34:
            r4 = r0
        L35:
            android.graphics.fonts.Font$Builder r4 = r7.setSlant(r4)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            int r5 = r5.m2471b()     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            android.graphics.fonts.Font$Builder r4 = r4.setTtcIndex(r5)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            android.graphics.fonts.Font r4 = r4.build()     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            if (r3 != 0) goto L4e
            android.graphics.fonts.FontFamily$Builder r5 = new android.graphics.fonts.FontFamily$Builder     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
            r3 = r5
            goto L51
        L4e:
            r3.addFont(r4)     // Catch: java.lang.Throwable -> L54 java.lang.Throwable -> L57
        L51:
            if (r6 == 0) goto L6e
            goto L1c
        L54:
            r4 = move-exception
            r5 = r1
            goto L5d
        L57:
            r4 = move-exception
            throw r4     // Catch: java.lang.Throwable -> L59
        L59:
            r5 = move-exception
            r9 = r5
            r5 = r4
            r4 = r9
        L5d:
            if (r6 == 0) goto L6d
            if (r5 == 0) goto L6a
            r6.close()     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L6e
            goto L6d
        L65:
            r6 = move-exception
            r5.addSuppressed(r6)     // Catch: java.io.IOException -> L6e
            goto L6d
        L6a:
            r6.close()     // Catch: java.io.IOException -> L6e
        L6d:
            throw r4     // Catch: java.io.IOException -> L6e
        L6e:
            int r2 = r2 + 1
            goto L9
        L71:
            if (r3 != 0) goto L74
            return r1
        L74:
            android.graphics.fonts.FontStyle r10 = new android.graphics.fonts.FontStyle
            r11 = r14 & 1
            if (r11 == 0) goto L7d
            r11 = 700(0x2bc, float:9.81E-43)
            goto L7f
        L7d:
            r11 = 400(0x190, float:5.6E-43)
        L7f:
            r12 = r14 & 2
            if (r12 == 0) goto L84
            r0 = r4
        L84:
            r10.<init>(r11, r0)
            android.graphics.Typeface$CustomFallbackBuilder r11 = new android.graphics.Typeface$CustomFallbackBuilder
            android.graphics.fonts.FontFamily r12 = r3.build()
            r11.<init>(r12)
            android.graphics.Typeface$CustomFallbackBuilder r10 = r11.setStyle(r10)
            android.graphics.Typeface r10 = r10.build()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi29Impl.mo2619a(android.content.Context, android.os.CancellationSignal, androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4[], int):android.graphics.Typeface");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public Typeface mo2620a(Context context, FontResourcesParserCompat.IntrinsicsJvm.kt_4 bVar, Resources resources, int OplusGLSurfaceView_13) throws IOException {
        FontResourcesParserCompat.IntrinsicsJvm.kt_3[] cVarArrM2281a = bVar.m2281a();
        int length = cVarArrM2281a.length;
        FontFamily.Builder builder = null;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i2 >= length) {
                break;
            }
            FontResourcesParserCompat.IntrinsicsJvm.kt_3 cVar = cVarArrM2281a[i2];
            try {
                Font.Builder weight = new Font.Builder(resources, cVar.m2287f()).setWeight(cVar.m2283b());
                if (!cVar.m2284c()) {
                    i3 = 0;
                }
                Font fontBuild = weight.setSlant(i3).setTtcIndex(cVar.m2286e()).setFontVariationSettings(cVar.m2285d()).build();
                if (builder == null) {
                    builder = new FontFamily.Builder(fontBuild);
                } else {
                    builder.addFont(fontBuild);
                }
            } catch (IOException unused) {
            }
            i2++;
        }
        if (builder == null) {
            return null;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((OplusGLSurfaceView_13 & 1) != 0 ? 700 : 400, (OplusGLSurfaceView_13 & 2) != 0 ? 1 : 0)).build();
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public Typeface mo2631a(Context context, Resources resources, int OplusGLSurfaceView_13, String str, int i2) {
        try {
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(new Font.Builder(resources, OplusGLSurfaceView_13).build()).build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : 400, (i2 & 2) != 0 ? 1 : 0)).build();
        } catch (IOException unused) {
            return null;
        }
    }
}
