package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() { // from class: androidx.fragment.app.BackStackState.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public BackStackState[] newArray(int OplusGLSurfaceView_13) {
            return new BackStackState[OplusGLSurfaceView_13];
        }
    };
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int[] mCurrentMaxLifecycleStates;
    final ArrayList<String> mFragmentWhos;
    final int mIndex;
    final String mName;
    final int[] mOldMaxLifecycleStates;
    final int[] mOps;
    final boolean mReorderingAllowed;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;
    final int mTransitionStyle;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackState(BackStackRecord c0579a) {
        int size = c0579a.f3509d.size();
        this.mOps = new int[size * 5];
        if (!c0579a.f3516k) {
            throw new IllegalStateException("Not on back stack");
        }
        this.mFragmentWhos = new ArrayList<>(size);
        this.mOldMaxLifecycleStates = new int[size];
        this.mCurrentMaxLifecycleStates = new int[size];
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        while (OplusGLSurfaceView_13 < size) {
            FragmentTransaction.PlatformImplementations.kt_3 aVar = c0579a.f3509d.get(OplusGLSurfaceView_13);
            int i3 = i2 + 1;
            this.mOps[i2] = aVar.f3527a;
            this.mFragmentWhos.add(aVar.f3528b != null ? aVar.f3528b.mWho : null);
            int i4 = i3 + 1;
            this.mOps[i3] = aVar.f3529c;
            int i5 = i4 + 1;
            this.mOps[i4] = aVar.f3530d;
            int i6 = i5 + 1;
            this.mOps[i5] = aVar.f3531e;
            this.mOps[i6] = aVar.f3532f;
            this.mOldMaxLifecycleStates[OplusGLSurfaceView_13] = aVar.f3533g.ordinal();
            this.mCurrentMaxLifecycleStates[OplusGLSurfaceView_13] = aVar.f3534h.ordinal();
            OplusGLSurfaceView_13++;
            i2 = i6 + 1;
        }
        this.mTransition = c0579a.f3514i;
        this.mTransitionStyle = c0579a.f3515j;
        this.mName = c0579a.f3518m;
        this.mIndex = c0579a.f3414c;
        this.mBreadCrumbTitleRes = c0579a.f3519n;
        this.mBreadCrumbTitleText = c0579a.f3520o;
        this.mBreadCrumbShortTitleRes = c0579a.f3521p;
        this.mBreadCrumbShortTitleText = c0579a.f3522q;
        this.mSharedElementSourceNames = c0579a.f3523r;
        this.mSharedElementTargetNames = c0579a.f3524s;
        this.mReorderingAllowed = c0579a.f3525t;
    }

    public BackStackState(Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mFragmentWhos = parcel.createStringArrayList();
        this.mOldMaxLifecycleStates = parcel.createIntArray();
        this.mCurrentMaxLifecycleStates = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mTransitionStyle = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
        this.mReorderingAllowed = parcel.readInt() != 0;
    }

    public BackStackRecord instantiate(FragmentManagerImpl layoutInflaterFactory2C0587i) {
        BackStackRecord c0579a = new BackStackRecord(layoutInflaterFactory2C0587i);
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        while (OplusGLSurfaceView_13 < this.mOps.length) {
            FragmentTransaction.PlatformImplementations.kt_3 aVar = new FragmentTransaction.PlatformImplementations.kt_3();
            int i3 = OplusGLSurfaceView_13 + 1;
            aVar.f3527a = this.mOps[OplusGLSurfaceView_13];
            if (FragmentManagerImpl.f3438b) {
                Log.v("FragmentManager", "Instantiate " + c0579a + " op #" + i2 + " base fragment #" + this.mOps[i3]);
            }
            String str = this.mFragmentWhos.get(i2);
            if (str != null) {
                aVar.f3528b = layoutInflaterFactory2C0587i.f3450g.get(str);
            } else {
                aVar.f3528b = null;
            }
            aVar.f3533g = Lifecycle.IntrinsicsJvm.kt_4.values()[this.mOldMaxLifecycleStates[i2]];
            aVar.f3534h = Lifecycle.IntrinsicsJvm.kt_4.values()[this.mCurrentMaxLifecycleStates[i2]];
            int[] iArr = this.mOps;
            int i4 = i3 + 1;
            aVar.f3529c = iArr[i3];
            int i5 = i4 + 1;
            aVar.f3530d = iArr[i4];
            int i6 = i5 + 1;
            aVar.f3531e = iArr[i5];
            aVar.f3532f = iArr[i6];
            c0579a.f3510e = aVar.f3529c;
            c0579a.f3511f = aVar.f3530d;
            c0579a.f3512g = aVar.f3531e;
            c0579a.f3513h = aVar.f3532f;
            c0579a.m3544a(aVar);
            i2++;
            OplusGLSurfaceView_13 = i6 + 1;
        }
        c0579a.f3514i = this.mTransition;
        c0579a.f3515j = this.mTransitionStyle;
        c0579a.f3518m = this.mName;
        c0579a.f3414c = this.mIndex;
        c0579a.f3516k = true;
        c0579a.f3519n = this.mBreadCrumbTitleRes;
        c0579a.f3520o = this.mBreadCrumbTitleText;
        c0579a.f3521p = this.mBreadCrumbShortTitleRes;
        c0579a.f3522q = this.mBreadCrumbShortTitleText;
        c0579a.f3523r = this.mSharedElementSourceNames;
        c0579a.f3524s = this.mSharedElementTargetNames;
        c0579a.f3525t = this.mReorderingAllowed;
        c0579a.m3312a(1);
        return c0579a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
        parcel.writeIntArray(this.mOps);
        parcel.writeStringList(this.mFragmentWhos);
        parcel.writeIntArray(this.mOldMaxLifecycleStates);
        parcel.writeIntArray(this.mCurrentMaxLifecycleStates);
        parcel.writeInt(this.mTransition);
        parcel.writeInt(this.mTransitionStyle);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList(this.mSharedElementSourceNames);
        parcel.writeStringList(this.mSharedElementTargetNames);
        parcel.writeInt(this.mReorderingAllowed ? 1 : 0);
    }
}
