package androidx.appcompat.widget;

/* compiled from: ResourcesWrapper.java */
/* loaded from: classes.dex */
class ai_renamed extends android.content.res.Resources {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.content.res.Resources f550a;

    public ai_renamed(android.content.res.Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f550a = resources;
    }

    @Override // android.content.res.Resources
    public java.lang.CharSequence getText(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getText(i_renamed);
    }

    @Override // android.content.res.Resources
    public java.lang.CharSequence getQuantityText(int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getQuantityText(i_renamed, i2);
    }

    @Override // android.content.res.Resources
    public java.lang.String getString(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getString(i_renamed);
    }

    @Override // android.content.res.Resources
    public java.lang.String getString(int i_renamed, java.lang.Object... objArr) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getString(i_renamed, objArr);
    }

    @Override // android.content.res.Resources
    public java.lang.String getQuantityString(int i_renamed, int i2, java.lang.Object... objArr) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getQuantityString(i_renamed, i2, objArr);
    }

    @Override // android.content.res.Resources
    public java.lang.String getQuantityString(int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getQuantityString(i_renamed, i2);
    }

    @Override // android.content.res.Resources
    public java.lang.CharSequence getText(int i_renamed, java.lang.CharSequence charSequence) {
        return this.f550a.getText(i_renamed, charSequence);
    }

    @Override // android.content.res.Resources
    public java.lang.CharSequence[] getTextArray(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getTextArray(i_renamed);
    }

    @Override // android.content.res.Resources
    public java.lang.String[] getStringArray(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getStringArray(i_renamed);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getIntArray(i_renamed);
    }

    @Override // android.content.res.Resources
    public android.content.res.TypedArray obtainTypedArray(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.obtainTypedArray(i_renamed);
    }

    @Override // android.content.res.Resources
    public float getDimension(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getDimension(i_renamed);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getDimensionPixelOffset(i_renamed);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getDimensionPixelSize(i_renamed);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i_renamed, int i2, int i3) {
        return this.f550a.getFraction(i_renamed, i2, i3);
    }

    @Override // android.content.res.Resources
    public android.graphics.drawable.Drawable getDrawable(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getDrawable(i_renamed);
    }

    @Override // android.content.res.Resources
    public android.graphics.drawable.Drawable getDrawable(int i_renamed, android.content.res.Resources.Theme theme) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getDrawable(i_renamed, theme);
    }

    @Override // android.content.res.Resources
    public android.graphics.drawable.Drawable getDrawableForDensity(int i_renamed, int i2) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getDrawableForDensity(i_renamed, i2);
    }

    @Override // android.content.res.Resources
    public android.graphics.drawable.Drawable getDrawableForDensity(int i_renamed, int i2, android.content.res.Resources.Theme theme) {
        return this.f550a.getDrawableForDensity(i_renamed, i2, theme);
    }

    @Override // android.content.res.Resources
    public android.graphics.Movie getMovie(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getMovie(i_renamed);
    }

    @Override // android.content.res.Resources
    public int getColor(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getColor(i_renamed);
    }

    @Override // android.content.res.Resources
    public android.content.res.ColorStateList getColorStateList(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getColorStateList(i_renamed);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getBoolean(i_renamed);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getInteger(i_renamed);
    }

    @Override // android.content.res.Resources
    public android.content.res.XmlResourceParser getLayout(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getLayout(i_renamed);
    }

    @Override // android.content.res.Resources
    public android.content.res.XmlResourceParser getAnimation(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getAnimation(i_renamed);
    }

    @Override // android.content.res.Resources
    public android.content.res.XmlResourceParser getXml(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getXml(i_renamed);
    }

    @Override // android.content.res.Resources
    public java.io.InputStream openRawResource(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.openRawResource(i_renamed);
    }

    @Override // android.content.res.Resources
    public java.io.InputStream openRawResource(int i_renamed, android.util.TypedValue typedValue) throws android.content.res.Resources.NotFoundException {
        return this.f550a.openRawResource(i_renamed, typedValue);
    }

    @Override // android.content.res.Resources
    public android.content.res.AssetFileDescriptor openRawResourceFd(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.openRawResourceFd(i_renamed);
    }

    @Override // android.content.res.Resources
    public void getValue(int i_renamed, android.util.TypedValue typedValue, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        this.f550a.getValue(i_renamed, typedValue, z_renamed);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i_renamed, int i2, android.util.TypedValue typedValue, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        this.f550a.getValueForDensity(i_renamed, i2, typedValue, z_renamed);
    }

    @Override // android.content.res.Resources
    public void getValue(java.lang.String str, android.util.TypedValue typedValue, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        this.f550a.getValue(str, typedValue, z_renamed);
    }

    @Override // android.content.res.Resources
    public android.content.res.TypedArray obtainAttributes(android.util.AttributeSet attributeSet, int[] iArr) {
        return this.f550a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(android.content.res.Configuration configuration, android.util.DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        android.content.res.Resources resources = this.f550a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    public android.util.DisplayMetrics getDisplayMetrics() {
        return this.f550a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public android.content.res.Configuration getConfiguration() {
        return this.f550a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public int getIdentifier(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return this.f550a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public java.lang.String getResourceName(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getResourceName(i_renamed);
    }

    @Override // android.content.res.Resources
    public java.lang.String getResourcePackageName(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getResourcePackageName(i_renamed);
    }

    @Override // android.content.res.Resources
    public java.lang.String getResourceTypeName(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getResourceTypeName(i_renamed);
    }

    @Override // android.content.res.Resources
    public java.lang.String getResourceEntryName(int i_renamed) throws android.content.res.Resources.NotFoundException {
        return this.f550a.getResourceEntryName(i_renamed);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(android.content.res.XmlResourceParser xmlResourceParser, android.os.Bundle bundle) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        this.f550a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(java.lang.String str, android.util.AttributeSet attributeSet, android.os.Bundle bundle) throws org.xmlpull.v1.XmlPullParserException {
        this.f550a.parseBundleExtra(str, attributeSet, bundle);
    }
}
