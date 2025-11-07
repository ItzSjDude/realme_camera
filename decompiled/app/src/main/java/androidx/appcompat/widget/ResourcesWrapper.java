package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ResourcesWrapper.java */
/* renamed from: androidx.appcompat.widget.ai */
/* loaded from: classes.dex */
class ResourcesWrapper extends Resources {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Resources f1806a;

    public ResourcesWrapper(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1806a = resources;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getText(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        return this.f1806a.getQuantityText(OplusGLSurfaceView_13, i2);
    }

    @Override // android.content.res.Resources
    public String getString(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getString(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public String getString(int OplusGLSurfaceView_13, Object... objArr) throws Resources.NotFoundException {
        return this.f1806a.getString(OplusGLSurfaceView_13, objArr);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int OplusGLSurfaceView_13, int i2, Object... objArr) throws Resources.NotFoundException {
        return this.f1806a.getQuantityString(OplusGLSurfaceView_13, i2, objArr);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        return this.f1806a.getQuantityString(OplusGLSurfaceView_13, i2);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int OplusGLSurfaceView_13, CharSequence charSequence) {
        return this.f1806a.getText(OplusGLSurfaceView_13, charSequence);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getTextArray(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getStringArray(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getIntArray(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.obtainTypedArray(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public float getDimension(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getDimension(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getDimensionPixelOffset(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getDimensionPixelSize(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public float getFraction(int OplusGLSurfaceView_13, int i2, int i3) {
        return this.f1806a.getFraction(OplusGLSurfaceView_13, i2, i3);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getDrawable(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int OplusGLSurfaceView_13, Resources.Theme theme) throws Resources.NotFoundException {
        return this.f1806a.getDrawable(OplusGLSurfaceView_13, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        return this.f1806a.getDrawableForDensity(OplusGLSurfaceView_13, i2);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int OplusGLSurfaceView_13, int i2, Resources.Theme theme) {
        return this.f1806a.getDrawableForDensity(OplusGLSurfaceView_13, i2, theme);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getMovie(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public int getColor(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getColor(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getColorStateList(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getBoolean(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public int getInteger(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getInteger(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getLayout(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getAnimation(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getXml(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.openRawResource(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int OplusGLSurfaceView_13, TypedValue typedValue) throws Resources.NotFoundException {
        return this.f1806a.openRawResource(OplusGLSurfaceView_13, typedValue);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.openRawResourceFd(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public void getValue(int OplusGLSurfaceView_13, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f1806a.getValue(OplusGLSurfaceView_13, typedValue, z);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int OplusGLSurfaceView_13, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f1806a.getValueForDensity(OplusGLSurfaceView_13, i2, typedValue, z);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f1806a.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f1806a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f1806a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.f1806a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f1806a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.f1806a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getResourceName(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getResourcePackageName(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getResourceTypeName(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        return this.f1806a.getResourceEntryName(OplusGLSurfaceView_13);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f1806a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f1806a.parseBundleExtra(str, attributeSet, bundle);
    }
}
