package com.google.android.aidl;

/* loaded from: classes.dex */
public abstract class BaseStub extends android.os.Binder implements android.os.IInterface {
    private static com.google.android.aidl.TransactionInterceptor globalInterceptor;

    @Override // android.os.IInterface
    public android.os.IBinder asBinder() {
        return this;
    }

    protected boolean dispatchTransaction(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
        return false;
    }

    static synchronized void installTransactionInterceptorPackagePrivate(com.google.android.aidl.TransactionInterceptor transactionInterceptor) {
        try {
            if (transactionInterceptor == null) {
                throw new java.lang.IllegalArgumentException("null interceptor");
            }
            if (globalInterceptor != null) {
                throw new java.lang.IllegalStateException("Duplicate TransactionInterceptor installation.");
            }
            globalInterceptor = transactionInterceptor;
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    protected BaseStub(java.lang.String str) {
        attachInterface(this, str);
    }

    protected boolean routeToSuperOrEnforceInterface(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
        if (i_renamed > 16777215) {
            return super.onTransact(i_renamed, parcel, parcel2, i2);
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        return false;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i_renamed, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
        if (routeToSuperOrEnforceInterface(i_renamed, parcel, parcel2, i2)) {
            return true;
        }
        com.google.android.aidl.TransactionInterceptor transactionInterceptor = globalInterceptor;
        if (transactionInterceptor == null) {
            return dispatchTransaction(i_renamed, parcel, parcel2, i2);
        }
        return transactionInterceptor.interceptTransaction(this, i_renamed, parcel, parcel2, i2);
    }
}
