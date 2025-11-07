package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: COUIBaseListPopupWindow_10 */
    static final PorterDuff.Mode f2944h = PorterDuff.Mode.SRC_IN;

    /* renamed from: PlatformImplementations.kt_3 */
    public int f2945a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    Object f2946b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public byte[] f2947c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Parcelable f2948d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int f2949e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int f2950f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public ColorStateList f2951g;

    /* renamed from: OplusGLSurfaceView_13 */
    PorterDuff.Mode f2952i;

    /* renamed from: OplusGLSurfaceView_15 */
    public String f2953j;

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m2554a(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static IconCompat m2553a(Resources resources, String str, int OplusGLSurfaceView_13) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        }
        if (OplusGLSurfaceView_13 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f2949e = OplusGLSurfaceView_13;
        if (resources != null) {
            try {
                iconCompat.f2946b = resources.getResourceName(OplusGLSurfaceView_13);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f2946b = str;
        }
        return iconCompat;
    }

    public IconCompat() {
        this.f2945a = -1;
        this.f2947c = null;
        this.f2948d = null;
        this.f2949e = 0;
        this.f2950f = 0;
        this.f2951g = null;
        this.f2952i = f2944h;
        this.f2953j = null;
    }

    private IconCompat(int OplusGLSurfaceView_13) {
        this.f2945a = -1;
        this.f2947c = null;
        this.f2948d = null;
        this.f2949e = 0;
        this.f2950f = 0;
        this.f2951g = null;
        this.f2952i = f2944h;
        this.f2953j = null;
        this.f2945a = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m2560a() {
        if (this.f2945a == -1 && Build.VERSION.SDK_INT >= 23) {
            return m2555a((Icon) this.f2946b);
        }
        if (this.f2945a != 2) {
            throw new IllegalStateException("called getResPackage() on " + this);
        }
        return ((String) this.f2946b).split(":", -1)[0];
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m2562b() {
        if (this.f2945a == -1 && Build.VERSION.SDK_INT >= 23) {
            return m2556b((Icon) this.f2946b);
        }
        if (this.f2945a != 2) {
            throw new IllegalStateException("called getResId() on " + this);
        }
        return this.f2949e;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Uri m2563c() {
        if (this.f2945a == -1 && Build.VERSION.SDK_INT >= 23) {
            return m2558c((Icon) this.f2946b);
        }
        int OplusGLSurfaceView_13 = this.f2945a;
        if (OplusGLSurfaceView_13 != 4 && OplusGLSurfaceView_13 != 6) {
            throw new IllegalStateException("called getUri() on " + this);
        }
        return Uri.parse((String) this.f2946b);
    }

    @Deprecated
    /* renamed from: IntrinsicsJvm.kt_5 */
    public Icon m2564d() {
        return m2559a((Context) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Icon m2559a(Context context) {
        Icon iconCreateWithBitmap;
        switch (this.f2945a) {
            case -1:
                return (Icon) this.f2946b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) this.f2946b);
                break;
            case 2:
                iconCreateWithBitmap = Icon.createWithResource(m2560a(), this.f2949e);
                break;
            case 3:
                iconCreateWithBitmap = Icon.createWithData((byte[]) this.f2946b, this.f2949e, this.f2950f);
                break;
            case 4:
                iconCreateWithBitmap = Icon.createWithContentUri((String) this.f2946b);
                break;
            case 5:
                if (Build.VERSION.SDK_INT >= 26) {
                    iconCreateWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) this.f2946b);
                    break;
                } else {
                    iconCreateWithBitmap = Icon.createWithBitmap(m2552a((Bitmap) this.f2946b, false));
                    break;
                }
            case 6:
                if (context == null) {
                    throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + m2563c());
                }
                InputStream inputStreamM2557b = m2557b(context);
                if (inputStreamM2557b == null) {
                    throw new IllegalStateException("Cannot load adaptive icon from uri: " + m2563c());
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    iconCreateWithBitmap = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(inputStreamM2557b));
                    break;
                } else {
                    iconCreateWithBitmap = Icon.createWithBitmap(m2552a(BitmapFactory.decodeStream(inputStreamM2557b), false));
                    break;
                }
        }
        ColorStateList colorStateList = this.f2951g;
        if (colorStateList != null) {
            iconCreateWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f2952i;
        if (mode != f2944h) {
            iconCreateWithBitmap.setTintMode(mode);
        }
        return iconCreateWithBitmap;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private InputStream m2557b(Context context) {
        Uri uriM2563c = m2563c();
        String scheme = uriM2563c.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriM2563c);
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.w("IconCompat", "Unable to load image from URI: " + uriM2563c, COUIBaseListPopupWindow_8);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f2946b));
        } catch (FileNotFoundException e2) {
            Log.w("IconCompat", "Unable to load image from path: " + uriM2563c, e2);
            return null;
        }
    }

    public String toString() {
        if (this.f2945a == -1) {
            return String.valueOf(this.f2946b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(m2554a(this.f2945a));
        switch (this.f2945a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f2946b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f2946b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(m2560a());
                sb.append(" id_renamed=");
                sb.append(String.format("0x%08x", Integer.valueOf(m2562b())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f2949e);
                if (this.f2950f != 0) {
                    sb.append(" off=");
                    sb.append(this.f2950f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f2946b);
                break;
        }
        if (this.f2951g != null) {
            sb.append(" tint=");
            sb.append(this.f2951g);
        }
        if (this.f2952i != f2944h) {
            sb.append(" mode=");
            sb.append(this.f2952i);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo2561a(boolean z) {
        this.f2953j = this.f2952i.name();
        switch (this.f2945a) {
            case -1:
                if (z) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f2948d = (Parcelable) this.f2946b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z) {
                    Bitmap bitmap = (Bitmap) this.f2946b;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f2947c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.f2948d = (Parcelable) this.f2946b;
                return;
            case 2:
                this.f2947c = ((String) this.f2946b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f2947c = (byte[]) this.f2946b;
                return;
            case 4:
            case 6:
                this.f2947c = this.f2946b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo2565e() {
        this.f2952i = PorterDuff.Mode.valueOf(this.f2953j);
        switch (this.f2945a) {
            case -1:
                Parcelable parcelable = this.f2948d;
                if (parcelable != null) {
                    this.f2946b = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f2948d;
                if (parcelable2 != null) {
                    this.f2946b = parcelable2;
                    return;
                }
                byte[] bArr = this.f2947c;
                this.f2946b = bArr;
                this.f2945a = 3;
                this.f2949e = 0;
                this.f2950f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                this.f2946b = new String(this.f2947c, Charset.forName("UTF-16"));
                return;
            case 3:
                this.f2946b = this.f2947c;
                return;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m2555a(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("IconCompat", "Unable to get icon package", COUIBaseListPopupWindow_8);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.COUIBaseListPopupWindow_8("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.COUIBaseListPopupWindow_8("IconCompat", "Unable to get icon package", e3);
            return null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int m2556b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("IconCompat", "Unable to get icon resource", COUIBaseListPopupWindow_8);
            return 0;
        } catch (NoSuchMethodException e2) {
            Log.COUIBaseListPopupWindow_8("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.COUIBaseListPopupWindow_8("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Uri m2558c(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("IconCompat", "Unable to get icon uri", COUIBaseListPopupWindow_8);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.COUIBaseListPopupWindow_8("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.COUIBaseListPopupWindow_8("IconCompat", "Unable to get icon uri", e3);
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static Bitmap m2552a(Bitmap bitmap, boolean z) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float COUIBaseListPopupWindow_12 = iMin;
        float f2 = 0.5f * COUIBaseListPopupWindow_12;
        float f3 = 0.9166667f * f2;
        if (z) {
            float f4 = 0.010416667f * COUIBaseListPopupWindow_12;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, COUIBaseListPopupWindow_12 * 0.020833334f, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2, (-(bitmap.getHeight() - iMin)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }
}
