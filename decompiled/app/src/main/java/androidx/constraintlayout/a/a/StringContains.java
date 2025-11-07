package androidx.constraintlayout.a_renamed.a_renamed;

/* compiled from: Helper.java */
/* loaded from: classes.dex */
public class j_renamed extends androidx.constraintlayout.a_renamed.a_renamed.f_renamed {
    protected androidx.constraintlayout.a_renamed.a_renamed.f_renamed[] ai_renamed = new androidx.constraintlayout.a_renamed.a_renamed.f_renamed[4];
    protected int aj_renamed = 0;

    public void b_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar) {
        int i_renamed = this.aj_renamed + 1;
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed[] fVarArr = this.ai_renamed;
        if (i_renamed > fVarArr.length) {
            this.ai_renamed = (androidx.constraintlayout.a_renamed.a_renamed.f_renamed[]) java.util.Arrays.copyOf(fVarArr, fVarArr.length * 2);
        }
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed[] fVarArr2 = this.ai_renamed;
        int i2 = this.aj_renamed;
        fVarArr2[i2] = fVar;
        this.aj_renamed = i2 + 1;
    }

    public void K_renamed() {
        this.aj_renamed = 0;
    }
}
