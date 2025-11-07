package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

/* compiled from: VersionedParcelParcel.java */
/* renamed from: androidx.versionedparcelable.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
class VersionedParcelParcel extends VersionedParcel {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final SparseIntArray f4779d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Parcel f4780e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final int f4781f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final int f4782g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final String f4783h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f4784i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f4785j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f4786k;

    VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    private VersionedParcelParcel(Parcel parcel, int OplusGLSurfaceView_13, int i2, String str, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.f4779d = new SparseIntArray();
        this.f4784i = -1;
        this.f4785j = 0;
        this.f4786k = -1;
        this.f4780e = parcel;
        this.f4781f = OplusGLSurfaceView_13;
        this.f4782g = i2;
        this.f4785j = this.f4781f;
        this.f4783h = str;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo4937b(int OplusGLSurfaceView_13) {
        while (this.f4785j < this.f4782g) {
            int i2 = this.f4786k;
            if (i2 == OplusGLSurfaceView_13) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(OplusGLSurfaceView_13)) > 0) {
                return false;
            }
            this.f4780e.setDataPosition(this.f4785j);
            int i3 = this.f4780e.readInt();
            this.f4786k = this.f4780e.readInt();
            this.f4785j += i3;
        }
        return this.f4786k == OplusGLSurfaceView_13;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo4941c(int OplusGLSurfaceView_13) {
        mo4936b();
        this.f4784i = OplusGLSurfaceView_13;
        this.f4779d.put(OplusGLSurfaceView_13, this.f4780e.dataPosition());
        mo4914a(0);
        mo4914a(OplusGLSurfaceView_13);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo4936b() {
        int OplusGLSurfaceView_13 = this.f4784i;
        if (OplusGLSurfaceView_13 >= 0) {
            int i2 = this.f4779d.get(OplusGLSurfaceView_13);
            int iDataPosition = this.f4780e.dataPosition();
            this.f4780e.setDataPosition(i2);
            this.f4780e.writeInt(iDataPosition - i2);
            this.f4780e.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected VersionedParcel mo4940c() {
        Parcel parcel = this.f4780e;
        int iDataPosition = parcel.dataPosition();
        int OplusGLSurfaceView_13 = this.f4785j;
        if (OplusGLSurfaceView_13 == this.f4781f) {
            OplusGLSurfaceView_13 = this.f4782g;
        }
        return new VersionedParcelParcel(parcel, iDataPosition, OplusGLSurfaceView_13, this.f4783h + "  ", this.f4776a, this.f4777b, this.f4778c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4928a(byte[] bArr) {
        if (bArr != null) {
            this.f4780e.writeInt(bArr.length);
            this.f4780e.writeByteArray(bArr);
        } else {
            this.f4780e.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4914a(int OplusGLSurfaceView_13) {
        this.f4780e.writeInt(OplusGLSurfaceView_13);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4923a(String str) {
        this.f4780e.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4916a(Parcelable parcelable) {
        this.f4780e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4925a(boolean z) {
        this.f4780e.writeInt(z ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo4921a(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f4780e, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: COUIBaseListPopupWindow_11 */
    protected CharSequence mo4945g() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f4780e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: IntrinsicsJvm.kt_5 */
    public int mo4942d() {
        return this.f4780e.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: COUIBaseListPopupWindow_8 */
    public String mo4943e() {
        return this.f4780e.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: COUIBaseListPopupWindow_12 */
    public byte[] mo4944f() {
        int OplusGLSurfaceView_13 = this.f4780e.readInt();
        if (OplusGLSurfaceView_13 < 0) {
            return null;
        }
        byte[] bArr = new byte[OplusGLSurfaceView_13];
        this.f4780e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: COUIBaseListPopupWindow_10 */
    public <T extends Parcelable> T mo4946h() {
        return (T) this.f4780e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: OplusGLSurfaceView_13 */
    public boolean mo4947i() {
        return this.f4780e.readInt() != 0;
    }
}
