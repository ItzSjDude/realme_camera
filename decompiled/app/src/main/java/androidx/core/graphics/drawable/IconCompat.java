package androidx.core.graphics.drawable;

/* loaded from: classes.dex */
public class IconCompat extends androidx.versionedparcelable.CustomVersionedParcelable {
    static final android.graphics.PorterDuff.Mode h_renamed = android.graphics.PorterDuff.Mode.SRC_IN;

    /* renamed from: a_renamed, reason: collision with root package name */
    public int f925a;

    /* renamed from: b_renamed, reason: collision with root package name */
    java.lang.Object f926b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public byte[] f927c;
    public android.os.Parcelable d_renamed;
    public int e_renamed;
    public int f_renamed;
    public android.content.res.ColorStateList g_renamed;
    android.graphics.PorterDuff.Mode i_renamed;
    public java.lang.String j_renamed;

    private static java.lang.String a_renamed(int i_renamed) {
        switch (i_renamed) {
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

    public static androidx.core.graphics.drawable.IconCompat a_renamed(android.content.res.Resources resources, java.lang.String str, int i_renamed) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("Package must not be_renamed null.");
        }
        if (i_renamed == 0) {
            throw new java.lang.IllegalArgumentException("Drawable resource ID_renamed must not be_renamed 0");
        }
        androidx.core.graphics.drawable.IconCompat iconCompat = new androidx.core.graphics.drawable.IconCompat(2);
        iconCompat.e_renamed = i_renamed;
        if (resources != null) {
            try {
                iconCompat.f926b = resources.getResourceName(i_renamed);
            } catch (android.content.res.Resources.NotFoundException unused) {
                throw new java.lang.IllegalArgumentException("Icon resource cannot be_renamed found");
            }
        } else {
            iconCompat.f926b = str;
        }
        return iconCompat;
    }

    public IconCompat() {
        this.f925a = -1;
        this.f927c = null;
        this.d_renamed = null;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = null;
        this.i_renamed = h_renamed;
        this.j_renamed = null;
    }

    private IconCompat(int i_renamed) {
        this.f925a = -1;
        this.f927c = null;
        this.d_renamed = null;
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = null;
        this.i_renamed = h_renamed;
        this.j_renamed = null;
        this.f925a = i_renamed;
    }

    public java.lang.String a_renamed() {
        if (this.f925a == -1 && android.os.Build.VERSION.SDK_INT >= 23) {
            return a_renamed((android.graphics.drawable.Icon) this.f926b);
        }
        if (this.f925a != 2) {
            throw new java.lang.IllegalStateException("called getResPackage() on_renamed " + this);
        }
        return ((java.lang.String) this.f926b).split(":", -1)[0];
    }

    public int b_renamed() {
        if (this.f925a == -1 && android.os.Build.VERSION.SDK_INT >= 23) {
            return b_renamed((android.graphics.drawable.Icon) this.f926b);
        }
        if (this.f925a != 2) {
            throw new java.lang.IllegalStateException("called getResId() on_renamed " + this);
        }
        return this.e_renamed;
    }

    public android.net.Uri c_renamed() {
        if (this.f925a == -1 && android.os.Build.VERSION.SDK_INT >= 23) {
            return c_renamed((android.graphics.drawable.Icon) this.f926b);
        }
        int i_renamed = this.f925a;
        if (i_renamed != 4 && i_renamed != 6) {
            throw new java.lang.IllegalStateException("called getUri() on_renamed " + this);
        }
        return android.net.Uri.parse((java.lang.String) this.f926b);
    }

    @java.lang.Deprecated
    public android.graphics.drawable.Icon d_renamed() {
        return a_renamed((android.content.Context) null);
    }

    public android.graphics.drawable.Icon a_renamed(android.content.Context context) {
        android.graphics.drawable.Icon iconCreateWithBitmap;
        switch (this.f925a) {
            case -1:
                return (android.graphics.drawable.Icon) this.f926b;
            case 0:
            default:
                throw new java.lang.IllegalArgumentException("Unknown type");
            case 1:
                iconCreateWithBitmap = android.graphics.drawable.Icon.createWithBitmap((android.graphics.Bitmap) this.f926b);
                break;
            case 2:
                iconCreateWithBitmap = android.graphics.drawable.Icon.createWithResource(a_renamed(), this.e_renamed);
                break;
            case 3:
                iconCreateWithBitmap = android.graphics.drawable.Icon.createWithData((byte[]) this.f926b, this.e_renamed, this.f_renamed);
                break;
            case 4:
                iconCreateWithBitmap = android.graphics.drawable.Icon.createWithContentUri((java.lang.String) this.f926b);
                break;
            case 5:
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    iconCreateWithBitmap = android.graphics.drawable.Icon.createWithAdaptiveBitmap((android.graphics.Bitmap) this.f926b);
                    break;
                } else {
                    iconCreateWithBitmap = android.graphics.drawable.Icon.createWithBitmap(a_renamed((android.graphics.Bitmap) this.f926b, false));
                    break;
                }
            case 6:
                if (context == null) {
                    throw new java.lang.IllegalArgumentException("Context is_renamed required to resolve the file uri of_renamed the icon: " + c_renamed());
                }
                java.io.InputStream inputStreamB = b_renamed(context);
                if (inputStreamB == null) {
                    throw new java.lang.IllegalStateException("Cannot load adaptive icon from uri: " + c_renamed());
                }
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    iconCreateWithBitmap = android.graphics.drawable.Icon.createWithAdaptiveBitmap(android.graphics.BitmapFactory.decodeStream(inputStreamB));
                    break;
                } else {
                    iconCreateWithBitmap = android.graphics.drawable.Icon.createWithBitmap(a_renamed(android.graphics.BitmapFactory.decodeStream(inputStreamB), false));
                    break;
                }
        }
        android.content.res.ColorStateList colorStateList = this.g_renamed;
        if (colorStateList != null) {
            iconCreateWithBitmap.setTintList(colorStateList);
        }
        android.graphics.PorterDuff.Mode mode = this.i_renamed;
        if (mode != h_renamed) {
            iconCreateWithBitmap.setTintMode(mode);
        }
        return iconCreateWithBitmap;
    }

    private java.io.InputStream b_renamed(android.content.Context context) {
        android.net.Uri uriC = c_renamed();
        java.lang.String scheme = uriC.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriC);
            } catch (java.lang.Exception e_renamed) {
                android.util.Log.w_renamed("IconCompat", "Unable to load image from URI: " + uriC, e_renamed);
                return null;
            }
        }
        try {
            return new java.io.FileInputStream(new java.io.File((java.lang.String) this.f926b));
        } catch (java.io.FileNotFoundException e2) {
            android.util.Log.w_renamed("IconCompat", "Unable to load image from path: " + uriC, e2);
            return null;
        }
    }

    public java.lang.String toString() {
        if (this.f925a == -1) {
            return java.lang.String.valueOf(this.f926b);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Icon(typ=");
        sb.append(a_renamed(this.f925a));
        switch (this.f925a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((android.graphics.Bitmap) this.f926b).getWidth());
                sb.append("x_renamed");
                sb.append(((android.graphics.Bitmap) this.f926b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(a_renamed());
                sb.append(" id_renamed=");
                sb.append(java.lang.String.format("0x%08x", java.lang.Integer.valueOf(b_renamed())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.e_renamed);
                if (this.f_renamed != 0) {
                    sb.append(" off=");
                    sb.append(this.f_renamed);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f926b);
                break;
        }
        if (this.g_renamed != null) {
            sb.append(" tint=");
            sb.append(this.g_renamed);
        }
        if (this.i_renamed != h_renamed) {
            sb.append(" mode=");
            sb.append(this.i_renamed);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void a_renamed(boolean z_renamed) {
        this.j_renamed = this.i_renamed.name();
        switch (this.f925a) {
            case -1:
                if (z_renamed) {
                    throw new java.lang.IllegalArgumentException("Can't_renamed serialize Icon created with IconCompat#createFromIcon");
                }
                this.d_renamed = (android.os.Parcelable) this.f926b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z_renamed) {
                    android.graphics.Bitmap bitmap = (android.graphics.Bitmap) this.f926b;
                    java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f927c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.d_renamed = (android.os.Parcelable) this.f926b;
                return;
            case 2:
                this.f927c = ((java.lang.String) this.f926b).getBytes(java.nio.charset.Charset.forName("UTF-16"));
                return;
            case 3:
                this.f927c = (byte[]) this.f926b;
                return;
            case 4:
            case 6:
                this.f927c = this.f926b.toString().getBytes(java.nio.charset.Charset.forName("UTF-16"));
                return;
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void e_renamed() {
        this.i_renamed = android.graphics.PorterDuff.Mode.valueOf(this.j_renamed);
        switch (this.f925a) {
            case -1:
                android.os.Parcelable parcelable = this.d_renamed;
                if (parcelable != null) {
                    this.f926b = parcelable;
                    return;
                }
                throw new java.lang.IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                android.os.Parcelable parcelable2 = this.d_renamed;
                if (parcelable2 != null) {
                    this.f926b = parcelable2;
                    return;
                }
                byte[] bArr = this.f927c;
                this.f926b = bArr;
                this.f925a = 3;
                this.e_renamed = 0;
                this.f_renamed = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                this.f926b = new java.lang.String(this.f927c, java.nio.charset.Charset.forName("UTF-16"));
                return;
            case 3:
                this.f926b = this.f927c;
                return;
        }
    }

    private static java.lang.String a_renamed(android.graphics.drawable.Icon icon) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (java.lang.String) icon.getClass().getMethod("getResPackage", new java.lang.Class[0]).invoke(icon, new java.lang.Object[0]);
        } catch (java.lang.IllegalAccessException e_renamed) {
            android.util.Log.e_renamed("IconCompat", "Unable to get icon package", e_renamed);
            return null;
        } catch (java.lang.NoSuchMethodException e2) {
            android.util.Log.e_renamed("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (java.lang.reflect.InvocationTargetException e3) {
            android.util.Log.e_renamed("IconCompat", "Unable to get icon package", e3);
            return null;
        }
    }

    private static int b_renamed(android.graphics.drawable.Icon icon) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((java.lang.Integer) icon.getClass().getMethod("getResId", new java.lang.Class[0]).invoke(icon, new java.lang.Object[0])).intValue();
        } catch (java.lang.IllegalAccessException e_renamed) {
            android.util.Log.e_renamed("IconCompat", "Unable to get icon resource", e_renamed);
            return 0;
        } catch (java.lang.NoSuchMethodException e2) {
            android.util.Log.e_renamed("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (java.lang.reflect.InvocationTargetException e3) {
            android.util.Log.e_renamed("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }

    private static android.net.Uri c_renamed(android.graphics.drawable.Icon icon) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (android.net.Uri) icon.getClass().getMethod("getUri", new java.lang.Class[0]).invoke(icon, new java.lang.Object[0]);
        } catch (java.lang.IllegalAccessException e_renamed) {
            android.util.Log.e_renamed("IconCompat", "Unable to get icon uri", e_renamed);
            return null;
        } catch (java.lang.NoSuchMethodException e2) {
            android.util.Log.e_renamed("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (java.lang.reflect.InvocationTargetException e3) {
            android.util.Log.e_renamed("IconCompat", "Unable to get icon uri", e3);
            return null;
        }
    }

    static android.graphics.Bitmap a_renamed(android.graphics.Bitmap bitmap, boolean z_renamed) {
        int iMin = (int) (java.lang.Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(iMin, iMin, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        android.graphics.Paint paint = new android.graphics.Paint(3);
        float f_renamed = iMin;
        float f2 = 0.5f * f_renamed;
        float f3 = 0.9166667f * f2;
        if (z_renamed) {
            float f4 = 0.010416667f * f_renamed;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f_renamed * 0.020833334f, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        android.graphics.BitmapShader bitmapShader = new android.graphics.BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2, (-(bitmap.getHeight() - iMin)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }
}
