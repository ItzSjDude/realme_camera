package com.oplus.compat.app;

import android.app.ActivityManager;
import android.app.ITaskStackListener;
import android.content.ComponentName;
import android.os.IBinder;
import android.os.RemoteException;
import android.window.TaskSnapshot;
import com.oplus.compat.app.ITaskStackListenerR;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class IActivityTaskManagerNative {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Map<ITaskStackListenerNative, Object> f23254a = new HashMap();

    private static class TaskStackListenerAfterS extends ITaskStackListener.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        private ITaskStackListenerNative f23255a;

        public void onActivityDismissingDockedTask() throws RemoteException {
        }

        public void onActivityForcedResizable(String str, int OplusGLSurfaceView_13, int i2) throws RemoteException {
        }

        public void onActivityLaunchOnSecondaryDisplayFailed(ActivityManager.RunningTaskInfo runningTaskInfo, int OplusGLSurfaceView_13) throws RemoteException {
        }

        public void onActivityLaunchOnSecondaryDisplayRerouted(ActivityManager.RunningTaskInfo runningTaskInfo, int OplusGLSurfaceView_13) throws RemoteException {
        }

        public void onActivityRequestedOrientationChanged(int OplusGLSurfaceView_13, int i2) throws RemoteException {
        }

        public void onActivityRestartAttempt(ActivityManager.RunningTaskInfo runningTaskInfo, boolean z, boolean z2, boolean z3) throws RemoteException {
        }

        public void onActivityRotation(int OplusGLSurfaceView_13) throws RemoteException {
        }

        public void onBackPressedOnTaskRoot(ActivityManager.RunningTaskInfo runningTaskInfo) throws RemoteException {
        }

        public void onLockTaskModeChanged(int OplusGLSurfaceView_13) throws RemoteException {
        }

        public void onRecentTaskListFrozenChanged(boolean z) throws RemoteException {
        }

        public void onRecentTaskListUpdated() throws RemoteException {
        }

        public void onTaskCreated(int OplusGLSurfaceView_13, ComponentName componentName) throws RemoteException {
        }

        public void onTaskDescriptionChanged(ActivityManager.RunningTaskInfo runningTaskInfo) throws RemoteException {
        }

        public void onTaskDisplayChanged(int OplusGLSurfaceView_13, int i2) throws RemoteException {
        }

        public void onTaskFocusChanged(int OplusGLSurfaceView_13, boolean z) throws RemoteException {
        }

        public void onTaskMovedToBack(ActivityManager.RunningTaskInfo runningTaskInfo) throws RemoteException {
        }

        public void onTaskMovedToFront(ActivityManager.RunningTaskInfo runningTaskInfo) throws RemoteException {
        }

        public void onTaskProfileLocked(int OplusGLSurfaceView_13, int i2) throws RemoteException {
        }

        public void onTaskRemovalStarted(ActivityManager.RunningTaskInfo runningTaskInfo) throws RemoteException {
        }

        public void onTaskRemoved(int OplusGLSurfaceView_13) throws RemoteException {
        }

        public void onTaskRequestedOrientationChanged(int OplusGLSurfaceView_13, int i2) throws RemoteException {
        }

        public void onTaskStackChanged() throws RemoteException {
        }

        public void onActivityPinned(String str, int OplusGLSurfaceView_13, int i2, int i3) throws RemoteException {
            this.f23255a.m24882a(str, OplusGLSurfaceView_13, i2, i3);
        }

        public void onActivityUnpinned() throws RemoteException {
            this.f23255a.m24880a();
        }

        public void onTaskSnapshotChanged(int OplusGLSurfaceView_13, TaskSnapshot taskSnapshot) throws RemoteException {
            this.f23255a.m24881a(OplusGLSurfaceView_13, taskSnapshot);
        }
    }

    private static class TaskStackListenerR extends ITaskStackListenerR.Stub {

        /* renamed from: PlatformImplementations.kt_3 */
        private ITaskStackListenerNative f23256a;

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo24848a(int OplusGLSurfaceView_13) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo24849a(int OplusGLSurfaceView_13, int i2) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo24850a(int OplusGLSurfaceView_13, ComponentName componentName) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo24851a(int OplusGLSurfaceView_13, IBinder iBinder) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo24853a(int OplusGLSurfaceView_13, boolean z) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo24854a(ActivityManager.RunningTaskInfo runningTaskInfo) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo24855a(ActivityManager.RunningTaskInfo runningTaskInfo, int OplusGLSurfaceView_13) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo24856a(ActivityManager.RunningTaskInfo runningTaskInfo, boolean z, boolean z2, boolean z3) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo24857a(String str, int OplusGLSurfaceView_13, int i2) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo24859a(boolean z) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo24860b() throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo24861b(int OplusGLSurfaceView_13) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo24862b(int OplusGLSurfaceView_13, int i2) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo24863b(ActivityManager.RunningTaskInfo runningTaskInfo) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo24864b(ActivityManager.RunningTaskInfo runningTaskInfo, int OplusGLSurfaceView_13) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo24865c() throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo24866c(int OplusGLSurfaceView_13) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo24867c(int OplusGLSurfaceView_13, int i2) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo24868c(ActivityManager.RunningTaskInfo runningTaskInfo) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo24869d() throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo24870d(int OplusGLSurfaceView_13) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo24871d(int OplusGLSurfaceView_13, int i2) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo24872d(ActivityManager.RunningTaskInfo runningTaskInfo) throws RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo24852a(int OplusGLSurfaceView_13, TaskSnapshotNative taskSnapshotNative) throws RemoteException {
            this.f23256a.m24881a(OplusGLSurfaceView_13, taskSnapshotNative);
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo24858a(String str, int OplusGLSurfaceView_13, int i2, int i3) throws RemoteException {
            this.f23256a.m24882a(str, OplusGLSurfaceView_13, i2, i3);
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo24847a() throws RemoteException {
            this.f23256a.m24880a();
        }
    }
}
