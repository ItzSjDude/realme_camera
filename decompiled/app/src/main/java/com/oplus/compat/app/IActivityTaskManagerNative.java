package com.oplus.compat.app;

/* loaded from: classes2.dex */
public class IActivityTaskManagerNative {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.util.Map<com.oplus.compat.app.b_renamed, java.lang.Object> f7443a = new java.util.HashMap();

    private static class TaskStackListenerAfterS extends android.app.ITaskStackListener.Stub {

        /* renamed from: a_renamed, reason: collision with root package name */
        private com.oplus.compat.app.b_renamed f7444a;

        public void onActivityDismissingDockedTask() throws android.os.RemoteException {
        }

        public void onActivityForcedResizable(java.lang.String str, int i_renamed, int i2) throws android.os.RemoteException {
        }

        public void onActivityLaunchOnSecondaryDisplayFailed(android.app.ActivityManager.RunningTaskInfo runningTaskInfo, int i_renamed) throws android.os.RemoteException {
        }

        public void onActivityLaunchOnSecondaryDisplayRerouted(android.app.ActivityManager.RunningTaskInfo runningTaskInfo, int i_renamed) throws android.os.RemoteException {
        }

        public void onActivityRequestedOrientationChanged(int i_renamed, int i2) throws android.os.RemoteException {
        }

        public void onActivityRestartAttempt(android.app.ActivityManager.RunningTaskInfo runningTaskInfo, boolean z_renamed, boolean z2, boolean z3) throws android.os.RemoteException {
        }

        public void onActivityRotation(int i_renamed) throws android.os.RemoteException {
        }

        public void onBackPressedOnTaskRoot(android.app.ActivityManager.RunningTaskInfo runningTaskInfo) throws android.os.RemoteException {
        }

        public void onLockTaskModeChanged(int i_renamed) throws android.os.RemoteException {
        }

        public void onRecentTaskListFrozenChanged(boolean z_renamed) throws android.os.RemoteException {
        }

        public void onRecentTaskListUpdated() throws android.os.RemoteException {
        }

        public void onTaskCreated(int i_renamed, android.content.ComponentName componentName) throws android.os.RemoteException {
        }

        public void onTaskDescriptionChanged(android.app.ActivityManager.RunningTaskInfo runningTaskInfo) throws android.os.RemoteException {
        }

        public void onTaskDisplayChanged(int i_renamed, int i2) throws android.os.RemoteException {
        }

        public void onTaskFocusChanged(int i_renamed, boolean z_renamed) throws android.os.RemoteException {
        }

        public void onTaskMovedToBack(android.app.ActivityManager.RunningTaskInfo runningTaskInfo) throws android.os.RemoteException {
        }

        public void onTaskMovedToFront(android.app.ActivityManager.RunningTaskInfo runningTaskInfo) throws android.os.RemoteException {
        }

        public void onTaskProfileLocked(int i_renamed, int i2) throws android.os.RemoteException {
        }

        public void onTaskRemovalStarted(android.app.ActivityManager.RunningTaskInfo runningTaskInfo) throws android.os.RemoteException {
        }

        public void onTaskRemoved(int i_renamed) throws android.os.RemoteException {
        }

        public void onTaskRequestedOrientationChanged(int i_renamed, int i2) throws android.os.RemoteException {
        }

        public void onTaskStackChanged() throws android.os.RemoteException {
        }

        public void onActivityPinned(java.lang.String str, int i_renamed, int i2, int i3) throws android.os.RemoteException {
            this.f7444a.a_renamed(str, i_renamed, i2, i3);
        }

        public void onActivityUnpinned() throws android.os.RemoteException {
            this.f7444a.a_renamed();
        }

        public void onTaskSnapshotChanged(int i_renamed, android.window.TaskSnapshot taskSnapshot) throws android.os.RemoteException {
            this.f7444a.a_renamed(i_renamed, taskSnapshot);
        }
    }

    private static class TaskStackListenerR extends com.oplus.compat.app.ITaskStackListenerR.Stub {

        /* renamed from: a_renamed, reason: collision with root package name */
        private com.oplus.compat.app.b_renamed f7445a;

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void a_renamed(int i_renamed) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void a_renamed(int i_renamed, int i2) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void a_renamed(int i_renamed, android.content.ComponentName componentName) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void a_renamed(int i_renamed, android.os.IBinder iBinder) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void a_renamed(int i_renamed, boolean z_renamed) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void a_renamed(android.app.ActivityManager.RunningTaskInfo runningTaskInfo) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void a_renamed(android.app.ActivityManager.RunningTaskInfo runningTaskInfo, int i_renamed) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void a_renamed(android.app.ActivityManager.RunningTaskInfo runningTaskInfo, boolean z_renamed, boolean z2, boolean z3) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void a_renamed(java.lang.String str, int i_renamed, int i2) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void a_renamed(boolean z_renamed) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void b_renamed() throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void b_renamed(int i_renamed) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void b_renamed(int i_renamed, int i2) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void b_renamed(android.app.ActivityManager.RunningTaskInfo runningTaskInfo) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void b_renamed(android.app.ActivityManager.RunningTaskInfo runningTaskInfo, int i_renamed) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void c_renamed() throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void c_renamed(int i_renamed) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void c_renamed(int i_renamed, int i2) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void c_renamed(android.app.ActivityManager.RunningTaskInfo runningTaskInfo) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void d_renamed() throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void d_renamed(int i_renamed) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void d_renamed(int i_renamed, int i2) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void d_renamed(android.app.ActivityManager.RunningTaskInfo runningTaskInfo) throws android.os.RemoteException {
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void a_renamed(int i_renamed, com.oplus.compat.app.TaskSnapshotNative taskSnapshotNative) throws android.os.RemoteException {
            this.f7445a.a_renamed(i_renamed, taskSnapshotNative);
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void a_renamed(java.lang.String str, int i_renamed, int i2, int i3) throws android.os.RemoteException {
            this.f7445a.a_renamed(str, i_renamed, i2, i3);
        }

        @Override // com.oplus.compat.app.ITaskStackListenerR
        public void a_renamed() throws android.os.RemoteException {
            this.f7445a.a_renamed();
        }
    }
}
