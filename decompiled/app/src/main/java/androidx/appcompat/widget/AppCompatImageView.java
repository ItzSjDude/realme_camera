package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class AppCompatImageView extends android.widget.ImageView implements androidx.core.h_renamed.u_renamed, androidx.core.widget.l_renamed {
    private final androidx.appcompat.widget.e_renamed mBackgroundTintHelper;
    private final androidx.appcompat.widget.m_renamed mImageHelper;

    public AppCompatImageView(android.content.Context context) {
        this(context, null);
    }

    public AppCompatImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(androidx.appcompat.widget.ao_renamed.a_renamed(context), attributeSet, i_renamed);
        this.mBackgroundTintHelper = new androidx.appcompat.widget.e_renamed(this);
        this.mBackgroundTintHelper.a_renamed(attributeSet, i_renamed);
        this.mImageHelper = new androidx.appcompat.widget.m_renamed(this);
        this.mImageHelper.a_renamed(attributeSet, i_renamed);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i_renamed) {
        androidx.appcompat.widget.m_renamed mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.a_renamed(i_renamed);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        super.setImageDrawable(drawable);
        androidx.appcompat.widget.m_renamed mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.d_renamed();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        androidx.appcompat.widget.m_renamed mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.d_renamed();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(android.net.Uri uri) {
        super.setImageURI(uri);
        androidx.appcompat.widget.m_renamed mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.d_renamed();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i_renamed) {
        super.setBackgroundResource(i_renamed);
        androidx.appcompat.widget.e_renamed eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a_renamed(i_renamed);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.e_renamed eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a_renamed(drawable);
        }
    }

    @Override // androidx.core.h_renamed.u_renamed
    public void setSupportBackgroundTintList(android.content.res.ColorStateList colorStateList) {
        androidx.appcompat.widget.e_renamed eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a_renamed(colorStateList);
        }
    }

    @Override // androidx.core.h_renamed.u_renamed
    public android.content.res.ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.e_renamed eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            return eVar.a_renamed();
        }
        return null;
    }

    @Override // androidx.core.h_renamed.u_renamed
    public void setSupportBackgroundTintMode(android.graphics.PorterDuff.Mode mode) {
        androidx.appcompat.widget.e_renamed eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a_renamed(mode);
        }
    }

    @Override // androidx.core.h_renamed.u_renamed
    public android.graphics.PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.e_renamed eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            return eVar.b_renamed();
        }
        return null;
    }

    @Override // androidx.core.widget.l_renamed
    public void setSupportImageTintList(android.content.res.ColorStateList colorStateList) {
        androidx.appcompat.widget.m_renamed mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.a_renamed(colorStateList);
        }
    }

    @Override // androidx.core.widget.l_renamed
    public android.content.res.ColorStateList getSupportImageTintList() {
        androidx.appcompat.widget.m_renamed mVar = this.mImageHelper;
        if (mVar != null) {
            return mVar.b_renamed();
        }
        return null;
    }

    @Override // androidx.core.widget.l_renamed
    public void setSupportImageTintMode(android.graphics.PorterDuff.Mode mode) {
        androidx.appcompat.widget.m_renamed mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.a_renamed(mode);
        }
    }

    @Override // androidx.core.widget.l_renamed
    public android.graphics.PorterDuff.Mode getSupportImageTintMode() {
        androidx.appcompat.widget.m_renamed mVar = this.mImageHelper;
        if (mVar != null) {
            return mVar.c_renamed();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.e_renamed eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.c_renamed();
        }
        androidx.appcompat.widget.m_renamed mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.d_renamed();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.mImageHelper.a_renamed() && super.hasOverlappingRendering();
    }
}
