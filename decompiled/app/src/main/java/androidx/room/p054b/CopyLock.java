package androidx.room.p054b;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: CopyLock.java */
/* renamed from: androidx.room.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class CopyLock {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Map<String, Lock> f4348a = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final File f4349b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Lock f4350c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final boolean f4351d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private FileChannel f4352e;

    public CopyLock(String str, File file, boolean z) {
        this.f4349b = new File(file, str + ".lck");
        this.f4350c = m4590a(this.f4349b.getAbsolutePath());
        this.f4351d = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4591a() throws IOException {
        this.f4350c.lock();
        if (this.f4351d) {
            try {
                this.f4352e = new FileOutputStream(this.f4349b).getChannel();
                this.f4352e.lock();
            } catch (IOException COUIBaseListPopupWindow_8) {
                throw new IllegalStateException("Unable to grab copy lock.", COUIBaseListPopupWindow_8);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m4592b() {
        FileChannel fileChannel = this.f4352e;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f4350c.unlock();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Lock m4590a(String str) {
        Lock reentrantLock;
        synchronized (f4348a) {
            reentrantLock = f4348a.get(str);
            if (reentrantLock == null) {
                reentrantLock = new ReentrantLock();
                f4348a.put(str, reentrantLock);
            }
        }
        return reentrantLock;
    }
}
