package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class s_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public int f113a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public int[] f114b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public int[] f115c;
    public int d_renamed = 0;
    public boolean e_renamed = true;

    public s_renamed(int i_renamed) {
        this.f113a = i_renamed;
        int i2 = this.f113a;
        this.f114b = new int[i2];
        this.f115c = new int[i2];
    }

    public int a_renamed(android.graphics.Bitmap bitmap) {
        int i_renamed;
        int iHashCode = bitmap.hashCode();
        int i2 = 0;
        while (true) {
            if (i2 >= this.f113a) {
                i2 = -1;
                break;
            }
            if (iHashCode == this.f114b[i2]) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            return this.f115c[i2];
        }
        this.d_renamed %= this.f113a;
        int[] iArr = this.f115c;
        int i3 = this.d_renamed;
        if (iArr[i3] == 0) {
            int[] iArr2 = new int[1];
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(iArr2.length, iArr2, 0, 6408, bitmap.getWidth(), bitmap.getHeight());
            i_renamed = iArr2[0];
            this.f115c[this.d_renamed] = i_renamed;
        } else {
            i_renamed = iArr[i3];
        }
        int[] iArr3 = this.f114b;
        int i4 = this.d_renamed;
        iArr3[i4] = iHashCode;
        this.d_renamed = i4 + 1;
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(i_renamed, bitmap.getWidth(), bitmap.getHeight());
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
        if (this.e_renamed) {
            android.opengl.GLES20.glGenerateMipmap(3553);
        }
        android.opengl.GLES20.glBindTexture(3553, 0);
        return i_renamed;
    }

    public void a_renamed() {
        for (int i_renamed : this.f115c) {
            if (i_renamed != 0) {
                a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(i_renamed);
            }
        }
        int i2 = this.f113a;
        this.f115c = new int[i2];
        this.f114b = new int[i2];
        this.d_renamed = 0;
    }

    public void a_renamed(boolean z_renamed) {
        this.e_renamed = z_renamed;
    }
}
