package com.oplus.ocs.base.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.oplus.ocs.base.p193b.C3644c;
import java.util.List;

/* loaded from: classes2.dex */
public class CapabilityInfo implements Parcelable {
    public static final Parcelable.Creator<CapabilityInfo> CREATOR = new Parcelable.Creator<CapabilityInfo>() { // from class: com.oplus.ocs.base.common.CapabilityInfo.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CapabilityInfo[] newArray(int OplusGLSurfaceView_13) {
            return new CapabilityInfo[OplusGLSurfaceView_13];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CapabilityInfo createFromParcel(Parcel parcel) {
            return new CapabilityInfo(parcel);
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    private List<Feature> f23394a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f23395b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private AuthResult f23396c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private IBinder f23397d;
    public String mClassName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CapabilityInfo(List<Feature> list, int OplusGLSurfaceView_13, AuthResult authResult) {
        this(list, OplusGLSurfaceView_13, authResult, null);
    }

    public CapabilityInfo(List<Feature> list, int OplusGLSurfaceView_13, AuthResult authResult, IBinder iBinder) {
        this.f23394a = list;
        this.f23395b = OplusGLSurfaceView_13;
        this.f23396c = authResult;
        this.f23397d = iBinder;
    }

    public List<Feature> getFeatures() {
        return this.f23394a;
    }

    public int getVersion() {
        return this.f23395b;
    }

    public AuthResult getAuthResult() {
        return this.f23396c;
    }

    public IBinder getBinder() {
        return this.f23397d;
    }

    public void setBinder(IBinder iBinder) {
        this.f23397d = iBinder;
    }

    public String getClassName() {
        return this.mClassName;
    }

    public void setClassName(String str) {
        this.mClassName = str;
    }

    protected CapabilityInfo(Parcel parcel) {
        this.f23394a = parcel.readArrayList(Feature.class.getClassLoader());
        this.f23395b = parcel.readInt();
        this.f23396c = (AuthResult) C3644c.m25026a(parcel, AuthResult.class.getClassLoader(), TextUtils.isEmpty(this.mClassName) ? AuthResult.class.getName() : this.mClassName);
        this.f23397d = parcel.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeList(this.f23394a);
        parcel.writeInt(this.f23395b);
        C3644c.m25027a(parcel, this.f23396c, TextUtils.isEmpty(this.mClassName) ? AuthResult.class.getName() : this.mClassName);
        parcel.writeStrongBinder(this.f23397d);
    }
}
