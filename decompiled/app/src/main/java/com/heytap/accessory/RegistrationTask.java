package com.heytap.accessory;

import android.content.Context;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.p103a.SdkLog;
import com.heytap.accessory.p104b.ResourceParserException;
import com.heytap.accessory.p104b.ServiceXmlReader;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* compiled from: RegistrationTask.java */
/* renamed from: com.heytap.accessory.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class RegistrationTask {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f9404a = "PlatformImplementations.kt_3";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f9405b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private PlatformImplementations.kt_3 f9406c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private FutureTask<Void> f9407d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f9408e;

    /* renamed from: IntrinsicsJvm.kt_4 */
    static /* synthetic */ boolean m8370b(RegistrationTask c2149a) {
        c2149a.f9408e = false;
        return false;
    }

    public RegistrationTask(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Invalid context:" + ((Object) null));
        }
        this.f9405b = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final synchronized Future<Void> m8372a() {
        if (this.f9406c == null && this.f9407d == null) {
            this.f9406c = new PlatformImplementations.kt_3(this, (byte) 0);
            this.f9407d = new FutureTask<>(this.f9406c);
        } else {
            throw new IllegalStateException("RegistrationTask instance cannot be reused");
        }
        return this.f9407d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final synchronized void m8373b() {
        if (this.f9406c != null && this.f9407d != null) {
            if (this.f9408e) {
                SdkLog.m8383e(f9404a, "Registration task has already started");
                throw new IllegalStateException("Registration task is already running!");
            }
            new Thread(this.f9407d, "RegistrationThread").start();
            this.f9408e = true;
        } else {
            throw new IllegalStateException("Prepare not called");
        }
    }

    /* compiled from: RegistrationTask.java */
    /* renamed from: com.heytap.accessory.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    class PlatformImplementations.kt_3 implements Callable<Void> {
        /* synthetic */ PlatformImplementations.kt_3(RegistrationTask c2149a, byte b2) {
            this();
        }

        private PlatformImplementations.kt_3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            BaseAdapter defaultAdapter = BaseAdapter.getDefaultAdapter(RegistrationTask.this.f9405b);
            defaultAdapter.bindToFramework();
            try {
                byte[][] bArrM8608a = ServiceXmlReader.m8605a(RegistrationTask.this.f9405b).m8608a(RegistrationTask.this.f9405b.getPackageName());
                if (bArrM8608a == null) {
                    SdkLog.m8383e(RegistrationTask.f9404a, "xmlArray is null");
                    return null;
                }
                SdkLog.m8381c(RegistrationTask.f9404a, "xmlArray.length=" + bArrM8608a.length);
                int OplusGLSurfaceView_13 = 0;
                boolean z = false;
                while (OplusGLSurfaceView_13 < bArrM8608a.length) {
                    try {
                        try {
                            defaultAdapter.registerServices(bArrM8608a[OplusGLSurfaceView_13]);
                            SdkLog.m8381c(RegistrationTask.f9404a, "Services Registered successfully!");
                            z = OplusGLSurfaceView_13 == bArrM8608a.length - 1;
                            synchronized (RegistrationTask.this) {
                                if (z) {
                                    RegistrationTask.m8370b(RegistrationTask.this);
                                }
                            }
                            OplusGLSurfaceView_13++;
                        } catch (GeneralException COUIBaseListPopupWindow_8) {
                            SdkLog.m8379b(RegistrationTask.f9404a, "Registration failed!", COUIBaseListPopupWindow_8);
                            throw COUIBaseListPopupWindow_8;
                        }
                    } catch (Throwable th) {
                        synchronized (RegistrationTask.this) {
                            if (z) {
                                RegistrationTask.m8370b(RegistrationTask.this);
                                throw th;
                            }
                            throw th;
                        }
                    }
                }
                return null;
            } catch (ResourceParserException e2) {
                SdkLog.m8380b(RegistrationTask.f9404a, e2);
                throw new Exception(e2);
            }
        }
    }
}
