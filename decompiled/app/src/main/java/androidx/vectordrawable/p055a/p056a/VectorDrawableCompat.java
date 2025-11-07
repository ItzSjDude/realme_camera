package androidx.vectordrawable.p055a.p056a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.collection.ArrayMap;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.p027a.p028a.ComplexColorCompat;
import androidx.core.p027a.p028a.ResourcesCompat;
import androidx.core.p027a.p028a.TypedArrayUtils;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VectorDrawableCompat.java */
/* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class VectorDrawableCompat extends VectorDrawableCommon {

    /* renamed from: PlatformImplementations.kt_3 */
    static final PorterDuff.Mode f4707a = PorterDuff.Mode.SRC_IN;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private COUIBaseListPopupWindow_11 f4708b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PorterDuffColorFilter f4709d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ColorFilter f4710e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f4711f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f4712g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Drawable.ConstantState f4713h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final float[] f4714i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final Matrix f4715j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final Rect f4716k;

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int OplusGLSurfaceView_13) {
        super.setChangingConfigurations(OplusGLSurfaceView_13);
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int OplusGLSurfaceView_13, PorterDuff.Mode mode) {
        super.setColorFilter(OplusGLSurfaceView_13, mode);
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.setHotspotBounds(OplusGLSurfaceView_13, i2, i3, i4);
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    VectorDrawableCompat() {
        this.f4712g = true;
        this.f4714i = new float[9];
        this.f4715j = new Matrix();
        this.f4716k = new Rect();
        this.f4708b = new COUIBaseListPopupWindow_11();
    }

    VectorDrawableCompat(COUIBaseListPopupWindow_11 gVar) {
        this.f4712g = true;
        this.f4714i = new float[9];
        this.f4715j = new Matrix();
        this.f4716k = new Rect();
        this.f4708b = gVar;
        this.f4709d = m4874a(this.f4709d, gVar.f4765c, gVar.f4766d);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.f4706c != null) {
            this.f4706c.mutate();
            return this;
        }
        if (!this.f4711f && super.mutate() == this) {
            this.f4708b = new COUIBaseListPopupWindow_11(this.f4708b);
            this.f4711f = true;
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    Object m4875a(String str) {
        return this.f4708b.f4764b.f4757k.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f4706c != null && Build.VERSION.SDK_INT >= 24) {
            return new COUIBaseListPopupWindow_10(this.f4706c.getConstantState());
        }
        this.f4708b.f4763a = getChangingConfigurations();
        return this.f4708b;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f4706c != null) {
            this.f4706c.draw(canvas);
            return;
        }
        copyBounds(this.f4716k);
        if (this.f4716k.width() <= 0 || this.f4716k.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f4710e;
        if (colorFilter == null) {
            colorFilter = this.f4709d;
        }
        canvas.getMatrix(this.f4715j);
        this.f4715j.getValues(this.f4714i);
        float fAbs = Math.abs(this.f4714i[0]);
        float fAbs2 = Math.abs(this.f4714i[4]);
        float fAbs3 = Math.abs(this.f4714i[1]);
        float fAbs4 = Math.abs(this.f4714i[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iMin = Math.min(2048, (int) (this.f4716k.width() * fAbs));
        int iMin2 = Math.min(2048, (int) (this.f4716k.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.f4716k.left, this.f4716k.top);
        if (m4872a()) {
            canvas.translate(this.f4716k.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f4716k.offsetTo(0, 0);
        this.f4708b.m4902b(iMin, iMin2);
        if (!this.f4712g) {
            this.f4708b.m4898a(iMin, iMin2);
        } else if (!this.f4708b.m4903b()) {
            this.f4708b.m4898a(iMin, iMin2);
            this.f4708b.m4904c();
        }
        this.f4708b.m4899a(canvas, colorFilter, this.f4716k);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        if (this.f4706c != null) {
            return DrawableCompat.m2577c(this.f4706c);
        }
        return this.f4708b.f4764b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int OplusGLSurfaceView_13) {
        if (this.f4706c != null) {
            this.f4706c.setAlpha(OplusGLSurfaceView_13);
        } else if (this.f4708b.f4764b.getRootAlpha() != OplusGLSurfaceView_13) {
            this.f4708b.f4764b.setRootAlpha(OplusGLSurfaceView_13);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f4706c != null) {
            this.f4706c.setColorFilter(colorFilter);
        } else {
            this.f4710e = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        if (this.f4706c != null) {
            return DrawableCompat.m2579e(this.f4706c);
        }
        return this.f4710e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    PorterDuffColorFilter m4874a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int OplusGLSurfaceView_13) {
        if (this.f4706c != null) {
            DrawableCompat.m2568a(this.f4706c, OplusGLSurfaceView_13);
        } else {
            setTintList(ColorStateList.valueOf(OplusGLSurfaceView_13));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f4706c != null) {
            DrawableCompat.m2570a(this.f4706c, colorStateList);
            return;
        }
        COUIBaseListPopupWindow_11 gVar = this.f4708b;
        if (gVar.f4765c != colorStateList) {
            gVar.f4765c = colorStateList;
            this.f4709d = m4874a(this.f4709d, colorStateList, gVar.f4766d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f4706c != null) {
            DrawableCompat.m2573a(this.f4706c, mode);
            return;
        }
        COUIBaseListPopupWindow_11 gVar = this.f4708b;
        if (gVar.f4766d != mode) {
            gVar.f4766d = mode;
            this.f4709d = m4874a(this.f4709d, gVar.f4765c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        COUIBaseListPopupWindow_11 gVar;
        if (this.f4706c != null) {
            return this.f4706c.isStateful();
        }
        return super.isStateful() || ((gVar = this.f4708b) != null && (gVar.m4906d() || (this.f4708b.f4765c != null && this.f4708b.f4765c.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.f4706c != null) {
            return this.f4706c.setState(iArr);
        }
        boolean z = false;
        COUIBaseListPopupWindow_11 gVar = this.f4708b;
        if (gVar.f4765c != null && gVar.f4766d != null) {
            this.f4709d = m4874a(this.f4709d, gVar.f4765c, gVar.f4766d);
            invalidateSelf();
            z = true;
        }
        if (!gVar.m4906d() || !gVar.m4901a(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f4706c != null) {
            return this.f4706c.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f4706c != null) {
            return this.f4706c.getIntrinsicWidth();
        }
        return (int) this.f4708b.f4764b.f4750d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f4706c != null) {
            return this.f4706c.getIntrinsicHeight();
        }
        return (int) this.f4708b.f4764b.f4751e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.f4706c == null) {
            return false;
        }
        DrawableCompat.m2578d(this.f4706c);
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        if (this.f4706c != null) {
            return DrawableCompat.m2575b(this.f4706c);
        }
        return this.f4708b.f4767e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f4706c != null) {
            DrawableCompat.m2574a(this.f4706c, z);
        } else {
            this.f4708b.f4767e = z;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static VectorDrawableCompat m4869a(Resources resources, int OplusGLSurfaceView_13, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            VectorDrawableCompat c0812i = new VectorDrawableCompat();
            c0812i.f4706c = ResourcesCompat.m2302a(resources, OplusGLSurfaceView_13, theme);
            c0812i.f4713h = new COUIBaseListPopupWindow_10(c0812i.f4706c.getConstantState());
            return c0812i;
        }
        try {
            XmlResourceParser xml = resources.getXml(OplusGLSurfaceView_13);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            return m4870a(resources, xml, attributeSetAsAttributeSet, theme);
        } catch (IOException e2) {
            Log.COUIBaseListPopupWindow_8("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.COUIBaseListPopupWindow_8("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static VectorDrawableCompat m4870a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat c0812i = new VectorDrawableCompat();
        c0812i.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0812i;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int m4867a(int OplusGLSurfaceView_13, float f2) {
        return (OplusGLSurfaceView_13 & 16777215) | (((int) (Color.alpha(OplusGLSurfaceView_13) * f2)) << 24);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.f4706c != null) {
            this.f4706c.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.f4706c != null) {
            DrawableCompat.m2572a(this.f4706c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        COUIBaseListPopupWindow_11 gVar = this.f4708b;
        gVar.f4764b = new COUIBaseListPopupWindow_12();
        TypedArray typedArrayM2311a = TypedArrayUtils.m2311a(resources, theme, attributeSet, AndroidResources.f4677a);
        m4871a(typedArrayM2311a, xmlPullParser, theme);
        typedArrayM2311a.recycle();
        gVar.f4763a = getChangingConfigurations();
        gVar.f4773k = true;
        m4873b(resources, xmlPullParser, attributeSet, theme);
        this.f4709d = m4874a(this.f4709d, gVar.f4765c, gVar.f4766d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static PorterDuff.Mode m4868a(int OplusGLSurfaceView_13, PorterDuff.Mode mode) {
        if (OplusGLSurfaceView_13 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (OplusGLSurfaceView_13 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (OplusGLSurfaceView_13 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (OplusGLSurfaceView_13) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4871a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        COUIBaseListPopupWindow_11 gVar = this.f4708b;
        COUIBaseListPopupWindow_12 fVar = gVar.f4764b;
        gVar.f4766d = m4868a(TypedArrayUtils.m2308a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListM2309a = TypedArrayUtils.m2309a(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListM2309a != null) {
            gVar.f4765c = colorStateListM2309a;
        }
        gVar.f4767e = TypedArrayUtils.m2316a(typedArray, xmlPullParser, "autoMirrored", 5, gVar.f4767e);
        fVar.f4752f = TypedArrayUtils.m2305a(typedArray, xmlPullParser, "viewportWidth", 7, fVar.f4752f);
        fVar.f4753g = TypedArrayUtils.m2305a(typedArray, xmlPullParser, "viewportHeight", 8, fVar.f4753g);
        if (fVar.f4752f <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (fVar.f4753g <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        fVar.f4750d = typedArray.getDimension(3, fVar.f4750d);
        fVar.f4751e = typedArray.getDimension(2, fVar.f4751e);
        if (fVar.f4750d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (fVar.f4751e <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        fVar.setAlpha(TypedArrayUtils.m2305a(typedArray, xmlPullParser, "alpha", 4, fVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            fVar.f4755i = string;
            fVar.f4757k.put(string, fVar);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4873b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        COUIBaseListPopupWindow_11 gVar = this.f4708b;
        COUIBaseListPopupWindow_12 fVar = gVar.f4764b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar.f4749c);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                IntrinsicsJvm.kt_3 cVar = (IntrinsicsJvm.kt_3) arrayDeque.peek();
                if ("path".equals(name)) {
                    IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4();
                    bVar.m4883a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f4730b.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.f4757k.put(bVar.getPathName(), bVar);
                    }
                    z = false;
                    gVar.f4763a = bVar.f4745o | gVar.f4763a;
                } else if ("clip-path".equals(name)) {
                    PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3();
                    aVar.m4878a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f4730b.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.f4757k.put(aVar.getPathName(), aVar);
                    }
                    gVar.f4763a = aVar.f4745o | gVar.f4763a;
                } else if ("group".equals(name)) {
                    IntrinsicsJvm.kt_3 cVar2 = new IntrinsicsJvm.kt_3();
                    cVar2.m4888a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f4730b.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        fVar.f4757k.put(cVar2.getGroupName(), cVar2);
                    }
                    gVar.f4763a = cVar2.f4733e | gVar.f4763a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4876a(boolean z) {
        this.f4712g = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m4872a() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && DrawableCompat.m2583i(this) == 1;
    }

    @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f4706c != null) {
            this.f4706c.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        if (this.f4706c != null) {
            return this.f4706c.getChangingConfigurations();
        }
        return this.f4708b.getChangingConfigurations() | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f4706c != null) {
            this.f4706c.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long OplusGLSurfaceView_15) {
        if (this.f4706c != null) {
            this.f4706c.scheduleSelf(runnable, OplusGLSurfaceView_15);
        } else {
            super.scheduleSelf(runnable, OplusGLSurfaceView_15);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.f4706c != null) {
            return this.f4706c.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        if (this.f4706c != null) {
            this.f4706c.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13$COUIBaseListPopupWindow_10 */
    private static class COUIBaseListPopupWindow_10 extends Drawable.ConstantState {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Drawable.ConstantState f4775a;

        public COUIBaseListPopupWindow_10(Drawable.ConstantState constantState) {
            this.f4775a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            VectorDrawableCompat c0812i = new VectorDrawableCompat();
            c0812i.f4706c = (VectorDrawable) this.f4775a.newDrawable();
            return c0812i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat c0812i = new VectorDrawableCompat();
            c0812i.f4706c = (VectorDrawable) this.f4775a.newDrawable(resources);
            return c0812i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat c0812i = new VectorDrawableCompat();
            c0812i.f4706c = (VectorDrawable) this.f4775a.newDrawable(resources, theme);
            return c0812i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f4775a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4775a.getChangingConfigurations();
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13$COUIBaseListPopupWindow_11 */
    private static class COUIBaseListPopupWindow_11 extends Drawable.ConstantState {

        /* renamed from: PlatformImplementations.kt_3 */
        int f4763a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        COUIBaseListPopupWindow_12 f4764b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        ColorStateList f4765c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        PorterDuff.Mode f4766d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        boolean f4767e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        Bitmap f4768f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        ColorStateList f4769g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        PorterDuff.Mode f4770h;

        /* renamed from: OplusGLSurfaceView_13 */
        int f4771i;

        /* renamed from: OplusGLSurfaceView_15 */
        boolean f4772j;

        /* renamed from: OplusGLSurfaceView_5 */
        boolean f4773k;

        /* renamed from: OplusGLSurfaceView_14 */
        Paint f4774l;

        public COUIBaseListPopupWindow_11(COUIBaseListPopupWindow_11 gVar) {
            this.f4765c = null;
            this.f4766d = VectorDrawableCompat.f4707a;
            if (gVar != null) {
                this.f4763a = gVar.f4763a;
                this.f4764b = new COUIBaseListPopupWindow_12(gVar.f4764b);
                if (gVar.f4764b.f4748b != null) {
                    this.f4764b.f4748b = new Paint(gVar.f4764b.f4748b);
                }
                if (gVar.f4764b.f4747a != null) {
                    this.f4764b.f4747a = new Paint(gVar.f4764b.f4747a);
                }
                this.f4765c = gVar.f4765c;
                this.f4766d = gVar.f4766d;
                this.f4767e = gVar.f4767e;
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4899a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f4768f, (Rect) null, rect, m4897a(colorFilter));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m4900a() {
            return this.f4764b.getRootAlpha() < 255;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public Paint m4897a(ColorFilter colorFilter) {
            if (!m4900a() && colorFilter == null) {
                return null;
            }
            if (this.f4774l == null) {
                this.f4774l = new Paint();
                this.f4774l.setFilterBitmap(true);
            }
            this.f4774l.setAlpha(this.f4764b.getRootAlpha());
            this.f4774l.setColorFilter(colorFilter);
            return this.f4774l;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4898a(int OplusGLSurfaceView_13, int i2) {
            this.f4768f.eraseColor(0);
            this.f4764b.m4894a(new Canvas(this.f4768f), OplusGLSurfaceView_13, i2, (ColorFilter) null);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m4902b(int OplusGLSurfaceView_13, int i2) {
            if (this.f4768f == null || !m4905c(OplusGLSurfaceView_13, i2)) {
                this.f4768f = Bitmap.createBitmap(OplusGLSurfaceView_13, i2, Bitmap.Config.ARGB_8888);
                this.f4773k = true;
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean m4905c(int OplusGLSurfaceView_13, int i2) {
            return OplusGLSurfaceView_13 == this.f4768f.getWidth() && i2 == this.f4768f.getHeight();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean m4903b() {
            return !this.f4773k && this.f4769g == this.f4765c && this.f4770h == this.f4766d && this.f4772j == this.f4767e && this.f4771i == this.f4764b.getRootAlpha();
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m4904c() {
            this.f4769g = this.f4765c;
            this.f4770h = this.f4766d;
            this.f4771i = this.f4764b.getRootAlpha();
            this.f4772j = this.f4767e;
            this.f4773k = false;
        }

        public COUIBaseListPopupWindow_11() {
            this.f4765c = null;
            this.f4766d = VectorDrawableCompat.f4707a;
            this.f4764b = new COUIBaseListPopupWindow_12();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4763a;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean m4906d() {
            return this.f4764b.m4895a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m4901a(int[] iArr) {
            boolean zM4896a = this.f4764b.m4896a(iArr);
            this.f4773k |= zM4896a;
            return zM4896a;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13$COUIBaseListPopupWindow_12 */
    private static class COUIBaseListPopupWindow_12 {

        /* renamed from: OplusGLSurfaceView_11 */
        private static final Matrix f4746n = new Matrix();

        /* renamed from: PlatformImplementations.kt_3 */
        Paint f4747a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        Paint f4748b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final IntrinsicsJvm.kt_3 f4749c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        float f4750d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        float f4751e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        float f4752f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        float f4753g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        int f4754h;

        /* renamed from: OplusGLSurfaceView_13 */
        String f4755i;

        /* renamed from: OplusGLSurfaceView_15 */
        Boolean f4756j;

        /* renamed from: OplusGLSurfaceView_5 */
        final ArrayMap<String, Object> f4757k;

        /* renamed from: OplusGLSurfaceView_14 */
        private final Path f4758l;

        /* renamed from: OplusGLSurfaceView_6 */
        private final Path f4759m;

        /* renamed from: o */
        private final Matrix f4760o;

        /* renamed from: p */
        private PathMeasure f4761p;

        /* renamed from: q */
        private int f4762q;

        /* renamed from: PlatformImplementations.kt_3 */
        private static float m4890a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
            return (COUIBaseListPopupWindow_12 * f4) - (f2 * f3);
        }

        public COUIBaseListPopupWindow_12() {
            this.f4760o = new Matrix();
            this.f4750d = 0.0f;
            this.f4751e = 0.0f;
            this.f4752f = 0.0f;
            this.f4753g = 0.0f;
            this.f4754h = 255;
            this.f4755i = null;
            this.f4756j = null;
            this.f4757k = new ArrayMap<>();
            this.f4749c = new IntrinsicsJvm.kt_3();
            this.f4758l = new Path();
            this.f4759m = new Path();
        }

        public void setRootAlpha(int OplusGLSurfaceView_13) {
            this.f4754h = OplusGLSurfaceView_13;
        }

        public int getRootAlpha() {
            return this.f4754h;
        }

        public void setAlpha(float COUIBaseListPopupWindow_12) {
            setRootAlpha((int) (COUIBaseListPopupWindow_12 * 255.0f));
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public COUIBaseListPopupWindow_12(COUIBaseListPopupWindow_12 fVar) {
            this.f4760o = new Matrix();
            this.f4750d = 0.0f;
            this.f4751e = 0.0f;
            this.f4752f = 0.0f;
            this.f4753g = 0.0f;
            this.f4754h = 255;
            this.f4755i = null;
            this.f4756j = null;
            this.f4757k = new ArrayMap<>();
            this.f4749c = new IntrinsicsJvm.kt_3(fVar.f4749c, this.f4757k);
            this.f4758l = new Path(fVar.f4758l);
            this.f4759m = new Path(fVar.f4759m);
            this.f4750d = fVar.f4750d;
            this.f4751e = fVar.f4751e;
            this.f4752f = fVar.f4752f;
            this.f4753g = fVar.f4753g;
            this.f4762q = fVar.f4762q;
            this.f4754h = fVar.f4754h;
            this.f4755i = fVar.f4755i;
            String str = fVar.f4755i;
            if (str != null) {
                this.f4757k.put(str, this);
            }
            this.f4756j = fVar.f4756j;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m4892a(IntrinsicsJvm.kt_3 cVar, Matrix matrix, Canvas canvas, int OplusGLSurfaceView_13, int i2, ColorFilter colorFilter) {
            cVar.f4729a.set(matrix);
            cVar.f4729a.preConcat(cVar.f4732d);
            canvas.save();
            for (int i3 = 0; i3 < cVar.f4730b.size(); i3++) {
                IntrinsicsJvm.kt_5 dVar = cVar.f4730b.get(i3);
                if (dVar instanceof IntrinsicsJvm.kt_3) {
                    m4892a((IntrinsicsJvm.kt_3) dVar, cVar.f4729a, canvas, OplusGLSurfaceView_13, i2, colorFilter);
                } else if (dVar instanceof COUIBaseListPopupWindow_8) {
                    m4893a(cVar, (COUIBaseListPopupWindow_8) dVar, canvas, OplusGLSurfaceView_13, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4894a(Canvas canvas, int OplusGLSurfaceView_13, int i2, ColorFilter colorFilter) {
            m4892a(this.f4749c, f4746n, canvas, OplusGLSurfaceView_13, i2, colorFilter);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m4893a(IntrinsicsJvm.kt_3 cVar, COUIBaseListPopupWindow_8 eVar, Canvas canvas, int OplusGLSurfaceView_13, int i2, ColorFilter colorFilter) {
            float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13 / this.f4752f;
            float f2 = i2 / this.f4753g;
            float fMin = Math.min(COUIBaseListPopupWindow_12, f2);
            Matrix matrix = cVar.f4729a;
            this.f4760o.set(matrix);
            this.f4760o.postScale(COUIBaseListPopupWindow_12, f2);
            float fM4891a = m4891a(matrix);
            if (fM4891a == 0.0f) {
                return;
            }
            eVar.m4889a(this.f4758l);
            Path path = this.f4758l;
            this.f4759m.reset();
            if (eVar.mo4879a()) {
                this.f4759m.setFillType(eVar.f4744n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f4759m.addPath(path, this.f4760o);
                canvas.clipPath(this.f4759m);
                return;
            }
            IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) eVar;
            if (bVar.f4722f != 0.0f || bVar.f4723g != 1.0f) {
                float f3 = (bVar.f4722f + bVar.f4724h) % 1.0f;
                float f4 = (bVar.f4723g + bVar.f4724h) % 1.0f;
                if (this.f4761p == null) {
                    this.f4761p = new PathMeasure();
                }
                this.f4761p.setPath(this.f4758l, false);
                float length = this.f4761p.getLength();
                float f5 = f3 * length;
                float f6 = f4 * length;
                path.reset();
                if (f5 > f6) {
                    this.f4761p.getSegment(f5, length, path, true);
                    this.f4761p.getSegment(0.0f, f6, path, true);
                } else {
                    this.f4761p.getSegment(f5, f6, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f4759m.addPath(path, this.f4760o);
            if (bVar.f4719c.m2272e()) {
                ComplexColorCompat c0418b = bVar.f4719c;
                if (this.f4748b == null) {
                    this.f4748b = new Paint(1);
                    this.f4748b.setStyle(Paint.Style.FILL);
                }
                Paint paint = this.f4748b;
                if (c0418b.m2270c()) {
                    Shader shaderM2266a = c0418b.m2266a();
                    shaderM2266a.setLocalMatrix(this.f4760o);
                    paint.setShader(shaderM2266a);
                    paint.setAlpha(Math.round(bVar.f4721e * 255.0f));
                } else {
                    paint.setShader(null);
                    paint.setAlpha(255);
                    paint.setColor(VectorDrawableCompat.m4867a(c0418b.m2268b(), bVar.f4721e));
                }
                paint.setColorFilter(colorFilter);
                this.f4759m.setFillType(bVar.f4744n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f4759m, paint);
            }
            if (bVar.f4717a.m2272e()) {
                ComplexColorCompat c0418b2 = bVar.f4717a;
                if (this.f4747a == null) {
                    this.f4747a = new Paint(1);
                    this.f4747a.setStyle(Paint.Style.STROKE);
                }
                Paint paint2 = this.f4747a;
                if (bVar.f4726j != null) {
                    paint2.setStrokeJoin(bVar.f4726j);
                }
                if (bVar.f4725i != null) {
                    paint2.setStrokeCap(bVar.f4725i);
                }
                paint2.setStrokeMiter(bVar.f4727k);
                if (c0418b2.m2270c()) {
                    Shader shaderM2266a2 = c0418b2.m2266a();
                    shaderM2266a2.setLocalMatrix(this.f4760o);
                    paint2.setShader(shaderM2266a2);
                    paint2.setAlpha(Math.round(bVar.f4720d * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(VectorDrawableCompat.m4867a(c0418b2.m2268b(), bVar.f4720d));
                }
                paint2.setColorFilter(colorFilter);
                paint2.setStrokeWidth(bVar.f4718b * fMin * fM4891a);
                canvas.drawPath(this.f4759m, paint2);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private float m4891a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fM4890a = m4890a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fM4890a) / fMax;
            }
            return 0.0f;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m4895a() {
            if (this.f4756j == null) {
                this.f4756j = Boolean.valueOf(this.f4749c.mo4885b());
            }
            return this.f4756j.booleanValue();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m4896a(int[] iArr) {
            return this.f4749c.mo4884a(iArr);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13$IntrinsicsJvm.kt_5 */
    private static abstract class IntrinsicsJvm.kt_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo4884a(int[] iArr) {
            return false;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo4885b() {
            return false;
        }

        private IntrinsicsJvm.kt_5() {
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13$IntrinsicsJvm.kt_3 */
    private static class IntrinsicsJvm.kt_3 extends IntrinsicsJvm.kt_5 {

        /* renamed from: PlatformImplementations.kt_3 */
        final Matrix f4729a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final ArrayList<IntrinsicsJvm.kt_5> f4730b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        float f4731c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        final Matrix f4732d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        int f4733e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private float f4734f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private float f4735g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private float f4736h;

        /* renamed from: OplusGLSurfaceView_13 */
        private float f4737i;

        /* renamed from: OplusGLSurfaceView_15 */
        private float f4738j;

        /* renamed from: OplusGLSurfaceView_5 */
        private float f4739k;

        /* renamed from: OplusGLSurfaceView_14 */
        private int[] f4740l;

        /* renamed from: OplusGLSurfaceView_6 */
        private String f4741m;

        public IntrinsicsJvm.kt_3(IntrinsicsJvm.kt_3 cVar, ArrayMap<String, Object> arrayMap) {
            COUIBaseListPopupWindow_8 aVar;
            super();
            this.f4729a = new Matrix();
            this.f4730b = new ArrayList<>();
            this.f4731c = 0.0f;
            this.f4734f = 0.0f;
            this.f4735g = 0.0f;
            this.f4736h = 1.0f;
            this.f4737i = 1.0f;
            this.f4738j = 0.0f;
            this.f4739k = 0.0f;
            this.f4732d = new Matrix();
            this.f4741m = null;
            this.f4731c = cVar.f4731c;
            this.f4734f = cVar.f4734f;
            this.f4735g = cVar.f4735g;
            this.f4736h = cVar.f4736h;
            this.f4737i = cVar.f4737i;
            this.f4738j = cVar.f4738j;
            this.f4739k = cVar.f4739k;
            this.f4740l = cVar.f4740l;
            this.f4741m = cVar.f4741m;
            this.f4733e = cVar.f4733e;
            String str = this.f4741m;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.f4732d.set(cVar.f4732d);
            ArrayList<IntrinsicsJvm.kt_5> arrayList = cVar.f4730b;
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < arrayList.size(); OplusGLSurfaceView_13++) {
                IntrinsicsJvm.kt_5 dVar = arrayList.get(OplusGLSurfaceView_13);
                if (dVar instanceof IntrinsicsJvm.kt_3) {
                    this.f4730b.add(new IntrinsicsJvm.kt_3((IntrinsicsJvm.kt_3) dVar, arrayMap));
                } else {
                    if (dVar instanceof IntrinsicsJvm.kt_4) {
                        aVar = new IntrinsicsJvm.kt_4((IntrinsicsJvm.kt_4) dVar);
                    } else if (dVar instanceof PlatformImplementations.kt_3) {
                        aVar = new PlatformImplementations.kt_3((PlatformImplementations.kt_3) dVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f4730b.add(aVar);
                    if (aVar.f4743m != null) {
                        arrayMap.put(aVar.f4743m, aVar);
                    }
                }
            }
        }

        public IntrinsicsJvm.kt_3() {
            super();
            this.f4729a = new Matrix();
            this.f4730b = new ArrayList<>();
            this.f4731c = 0.0f;
            this.f4734f = 0.0f;
            this.f4735g = 0.0f;
            this.f4736h = 1.0f;
            this.f4737i = 1.0f;
            this.f4738j = 0.0f;
            this.f4739k = 0.0f;
            this.f4732d = new Matrix();
            this.f4741m = null;
        }

        public String getGroupName() {
            return this.f4741m;
        }

        public Matrix getLocalMatrix() {
            return this.f4732d;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4888a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayM2311a = TypedArrayUtils.m2311a(resources, theme, attributeSet, AndroidResources.f4678b);
            m4887a(typedArrayM2311a, xmlPullParser);
            typedArrayM2311a.recycle();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m4887a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f4740l = null;
            this.f4731c = TypedArrayUtils.m2305a(typedArray, xmlPullParser, "rotation", 5, this.f4731c);
            this.f4734f = typedArray.getFloat(1, this.f4734f);
            this.f4735g = typedArray.getFloat(2, this.f4735g);
            this.f4736h = TypedArrayUtils.m2305a(typedArray, xmlPullParser, "scaleX", 3, this.f4736h);
            this.f4737i = TypedArrayUtils.m2305a(typedArray, xmlPullParser, "scaleY", 4, this.f4737i);
            this.f4738j = TypedArrayUtils.m2305a(typedArray, xmlPullParser, "translateX", 6, this.f4738j);
            this.f4739k = TypedArrayUtils.m2305a(typedArray, xmlPullParser, "translateY", 7, this.f4739k);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f4741m = string;
            }
            m4886a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m4886a() {
            this.f4732d.reset();
            this.f4732d.postTranslate(-this.f4734f, -this.f4735g);
            this.f4732d.postScale(this.f4736h, this.f4737i);
            this.f4732d.postRotate(this.f4731c, 0.0f, 0.0f);
            this.f4732d.postTranslate(this.f4738j + this.f4734f, this.f4739k + this.f4735g);
        }

        public float getRotation() {
            return this.f4731c;
        }

        public void setRotation(float COUIBaseListPopupWindow_12) {
            if (COUIBaseListPopupWindow_12 != this.f4731c) {
                this.f4731c = COUIBaseListPopupWindow_12;
                m4886a();
            }
        }

        public float getPivotX() {
            return this.f4734f;
        }

        public void setPivotX(float COUIBaseListPopupWindow_12) {
            if (COUIBaseListPopupWindow_12 != this.f4734f) {
                this.f4734f = COUIBaseListPopupWindow_12;
                m4886a();
            }
        }

        public float getPivotY() {
            return this.f4735g;
        }

        public void setPivotY(float COUIBaseListPopupWindow_12) {
            if (COUIBaseListPopupWindow_12 != this.f4735g) {
                this.f4735g = COUIBaseListPopupWindow_12;
                m4886a();
            }
        }

        public float getScaleX() {
            return this.f4736h;
        }

        public void setScaleX(float COUIBaseListPopupWindow_12) {
            if (COUIBaseListPopupWindow_12 != this.f4736h) {
                this.f4736h = COUIBaseListPopupWindow_12;
                m4886a();
            }
        }

        public float getScaleY() {
            return this.f4737i;
        }

        public void setScaleY(float COUIBaseListPopupWindow_12) {
            if (COUIBaseListPopupWindow_12 != this.f4737i) {
                this.f4737i = COUIBaseListPopupWindow_12;
                m4886a();
            }
        }

        public float getTranslateX() {
            return this.f4738j;
        }

        public void setTranslateX(float COUIBaseListPopupWindow_12) {
            if (COUIBaseListPopupWindow_12 != this.f4738j) {
                this.f4738j = COUIBaseListPopupWindow_12;
                m4886a();
            }
        }

        public float getTranslateY() {
            return this.f4739k;
        }

        public void setTranslateY(float COUIBaseListPopupWindow_12) {
            if (COUIBaseListPopupWindow_12 != this.f4739k) {
                this.f4739k = COUIBaseListPopupWindow_12;
                m4886a();
            }
        }

        @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCompat.IntrinsicsJvm.kt_5
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo4885b() {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4730b.size(); OplusGLSurfaceView_13++) {
                if (this.f4730b.get(OplusGLSurfaceView_13).mo4885b()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCompat.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo4884a(int[] iArr) {
            boolean zMo4884a = false;
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4730b.size(); OplusGLSurfaceView_13++) {
                zMo4884a |= this.f4730b.get(OplusGLSurfaceView_13).mo4884a(iArr);
            }
            return zMo4884a;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13$COUIBaseListPopupWindow_8 */
    private static abstract class COUIBaseListPopupWindow_8 extends IntrinsicsJvm.kt_5 {

        /* renamed from: OplusGLSurfaceView_14 */
        protected PathParser.IntrinsicsJvm.kt_4[] f4742l;

        /* renamed from: OplusGLSurfaceView_6 */
        String f4743m;

        /* renamed from: OplusGLSurfaceView_11 */
        int f4744n;

        /* renamed from: o */
        int f4745o;

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo4879a() {
            return false;
        }

        public COUIBaseListPopupWindow_8() {
            super();
            this.f4742l = null;
            this.f4744n = 0;
        }

        public COUIBaseListPopupWindow_8(COUIBaseListPopupWindow_8 eVar) {
            super();
            this.f4742l = null;
            this.f4744n = 0;
            this.f4743m = eVar.f4743m;
            this.f4745o = eVar.f4745o;
            this.f4742l = PathParser.m2598a(eVar.f4742l);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4889a(Path path) {
            path.reset();
            PathParser.IntrinsicsJvm.kt_4[] bVarArr = this.f4742l;
            if (bVarArr != null) {
                PathParser.IntrinsicsJvm.kt_4.m2605a(bVarArr, path);
            }
        }

        public String getPathName() {
            return this.f4743m;
        }

        public PathParser.IntrinsicsJvm.kt_4[] getPathData() {
            return this.f4742l;
        }

        public void setPathData(PathParser.IntrinsicsJvm.kt_4[] bVarArr) {
            if (!PathParser.m2596a(this.f4742l, bVarArr)) {
                this.f4742l = PathParser.m2598a(bVarArr);
            } else {
                PathParser.m2599b(this.f4742l, bVarArr);
            }
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 extends COUIBaseListPopupWindow_8 {
        @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCompat.COUIBaseListPopupWindow_8
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo4879a() {
            return true;
        }

        PlatformImplementations.kt_3() {
        }

        PlatformImplementations.kt_3(PlatformImplementations.kt_3 aVar) {
            super(aVar);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4878a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.m2317a(xmlPullParser, "pathData")) {
                TypedArray typedArrayM2311a = TypedArrayUtils.m2311a(resources, theme, attributeSet, AndroidResources.f4680d);
                m4877a(typedArrayM2311a, xmlPullParser);
                typedArrayM2311a.recycle();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m4877a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f4743m = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f4742l = PathParser.m2600b(string2);
            }
            this.f4744n = TypedArrayUtils.m2308a(typedArray, xmlPullParser, "fillType", 2, 0);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.vectordrawable.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_13$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 extends COUIBaseListPopupWindow_8 {

        /* renamed from: PlatformImplementations.kt_3 */
        ComplexColorCompat f4717a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        float f4718b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        ComplexColorCompat f4719c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        float f4720d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        float f4721e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        float f4722f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        float f4723g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        float f4724h;

        /* renamed from: OplusGLSurfaceView_13 */
        Paint.Cap f4725i;

        /* renamed from: OplusGLSurfaceView_15 */
        Paint.Join f4726j;

        /* renamed from: OplusGLSurfaceView_5 */
        float f4727k;

        /* renamed from: p */
        private int[] f4728p;

        IntrinsicsJvm.kt_4() {
            this.f4718b = 0.0f;
            this.f4720d = 1.0f;
            this.f4721e = 1.0f;
            this.f4722f = 0.0f;
            this.f4723g = 1.0f;
            this.f4724h = 0.0f;
            this.f4725i = Paint.Cap.BUTT;
            this.f4726j = Paint.Join.MITER;
            this.f4727k = 4.0f;
        }

        IntrinsicsJvm.kt_4(IntrinsicsJvm.kt_4 bVar) {
            super(bVar);
            this.f4718b = 0.0f;
            this.f4720d = 1.0f;
            this.f4721e = 1.0f;
            this.f4722f = 0.0f;
            this.f4723g = 1.0f;
            this.f4724h = 0.0f;
            this.f4725i = Paint.Cap.BUTT;
            this.f4726j = Paint.Join.MITER;
            this.f4727k = 4.0f;
            this.f4728p = bVar.f4728p;
            this.f4717a = bVar.f4717a;
            this.f4718b = bVar.f4718b;
            this.f4720d = bVar.f4720d;
            this.f4719c = bVar.f4719c;
            this.f4744n = bVar.f4744n;
            this.f4721e = bVar.f4721e;
            this.f4722f = bVar.f4722f;
            this.f4723g = bVar.f4723g;
            this.f4724h = bVar.f4724h;
            this.f4725i = bVar.f4725i;
            this.f4726j = bVar.f4726j;
            this.f4727k = bVar.f4727k;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private Paint.Cap m4880a(int OplusGLSurfaceView_13, Paint.Cap cap) {
            if (OplusGLSurfaceView_13 == 0) {
                return Paint.Cap.BUTT;
            }
            if (OplusGLSurfaceView_13 != 1) {
                return OplusGLSurfaceView_13 != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private Paint.Join m4881a(int OplusGLSurfaceView_13, Paint.Join join) {
            if (OplusGLSurfaceView_13 == 0) {
                return Paint.Join.MITER;
            }
            if (OplusGLSurfaceView_13 != 1) {
                return OplusGLSurfaceView_13 != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4883a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayM2311a = TypedArrayUtils.m2311a(resources, theme, attributeSet, AndroidResources.f4679c);
            m4882a(typedArrayM2311a, xmlPullParser, theme);
            typedArrayM2311a.recycle();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m4882a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f4728p = null;
            if (TypedArrayUtils.m2317a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f4743m = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f4742l = PathParser.m2600b(string2);
                }
                this.f4719c = TypedArrayUtils.m2313a(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f4721e = TypedArrayUtils.m2305a(typedArray, xmlPullParser, "fillAlpha", 12, this.f4721e);
                this.f4725i = m4880a(TypedArrayUtils.m2308a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f4725i);
                this.f4726j = m4881a(TypedArrayUtils.m2308a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f4726j);
                this.f4727k = TypedArrayUtils.m2305a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f4727k);
                this.f4717a = TypedArrayUtils.m2313a(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f4720d = TypedArrayUtils.m2305a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f4720d);
                this.f4718b = TypedArrayUtils.m2305a(typedArray, xmlPullParser, "strokeWidth", 4, this.f4718b);
                this.f4723g = TypedArrayUtils.m2305a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f4723g);
                this.f4724h = TypedArrayUtils.m2305a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f4724h);
                this.f4722f = TypedArrayUtils.m2305a(typedArray, xmlPullParser, "trimPathStart", 5, this.f4722f);
                this.f4744n = TypedArrayUtils.m2308a(typedArray, xmlPullParser, "fillType", 13, this.f4744n);
            }
        }

        @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCompat.IntrinsicsJvm.kt_5
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo4885b() {
            return this.f4719c.m2271d() || this.f4717a.m2271d();
        }

        @Override // androidx.vectordrawable.p055a.p056a.VectorDrawableCompat.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo4884a(int[] iArr) {
            return this.f4717a.m2267a(iArr) | this.f4719c.m2267a(iArr);
        }

        int getStrokeColor() {
            return this.f4717a.m2268b();
        }

        void setStrokeColor(int OplusGLSurfaceView_13) {
            this.f4717a.m2269b(OplusGLSurfaceView_13);
        }

        float getStrokeWidth() {
            return this.f4718b;
        }

        void setStrokeWidth(float COUIBaseListPopupWindow_12) {
            this.f4718b = COUIBaseListPopupWindow_12;
        }

        float getStrokeAlpha() {
            return this.f4720d;
        }

        void setStrokeAlpha(float COUIBaseListPopupWindow_12) {
            this.f4720d = COUIBaseListPopupWindow_12;
        }

        int getFillColor() {
            return this.f4719c.m2268b();
        }

        void setFillColor(int OplusGLSurfaceView_13) {
            this.f4719c.m2269b(OplusGLSurfaceView_13);
        }

        float getFillAlpha() {
            return this.f4721e;
        }

        void setFillAlpha(float COUIBaseListPopupWindow_12) {
            this.f4721e = COUIBaseListPopupWindow_12;
        }

        float getTrimPathStart() {
            return this.f4722f;
        }

        void setTrimPathStart(float COUIBaseListPopupWindow_12) {
            this.f4722f = COUIBaseListPopupWindow_12;
        }

        float getTrimPathEnd() {
            return this.f4723g;
        }

        void setTrimPathEnd(float COUIBaseListPopupWindow_12) {
            this.f4723g = COUIBaseListPopupWindow_12;
        }

        float getTrimPathOffset() {
            return this.f4724h;
        }

        void setTrimPathOffset(float COUIBaseListPopupWindow_12) {
            this.f4724h = COUIBaseListPopupWindow_12;
        }
    }
}
