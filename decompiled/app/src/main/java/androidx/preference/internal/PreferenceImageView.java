package androidx.preference.internal;

@android.annotation.SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class PreferenceImageView extends android.widget.ImageView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f1369a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f1370b;

    public PreferenceImageView(android.content.Context context) {
        this(context, null);
    }

    public PreferenceImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f1369a = Integer.MAX_VALUE;
        this.f1370b = Integer.MAX_VALUE;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.preference.R_renamed.styleable.PreferenceImageView, i_renamed, 0);
        setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.preference.R_renamed.styleable.PreferenceImageView_maxWidth, Integer.MAX_VALUE));
        setMaxHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.preference.R_renamed.styleable.PreferenceImageView_maxHeight, Integer.MAX_VALUE));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView
    public void setMaxWidth(int i_renamed) {
        this.f1369a = i_renamed;
        super.setMaxWidth(i_renamed);
    }

    @Override // android.widget.ImageView
    public int getMaxWidth() {
        return this.f1369a;
    }

    @Override // android.widget.ImageView
    public void setMaxHeight(int i_renamed) {
        this.f1370b = i_renamed;
        super.setMaxHeight(i_renamed);
    }

    @Override // android.widget.ImageView
    public int getMaxHeight() {
        return this.f1370b;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i_renamed);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int size = android.view.View.MeasureSpec.getSize(i_renamed);
            int maxWidth = getMaxWidth();
            if (maxWidth != Integer.MAX_VALUE && (maxWidth < size || mode == 0)) {
                i_renamed = android.view.View.MeasureSpec.makeMeasureSpec(maxWidth, Integer.MIN_VALUE);
            }
        }
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int size2 = android.view.View.MeasureSpec.getSize(i2);
            int maxHeight = getMaxHeight();
            if (maxHeight != Integer.MAX_VALUE && (maxHeight < size2 || mode2 == 0)) {
                i2 = android.view.View.MeasureSpec.makeMeasureSpec(maxHeight, Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i_renamed, i2);
    }
}
