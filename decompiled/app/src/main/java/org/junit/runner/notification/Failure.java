package org.junit.runner.notification;

/* loaded from: classes2.dex */
public class Failure implements java.io.Serializable {
    private static final long serialVersionUID = 1;
    private final org.junit.runner.Description fDescription;
    private final java.lang.Throwable fThrownException;

    public Failure(org.junit.runner.Description description, java.lang.Throwable th) {
        this.fThrownException = th;
        this.fDescription = description;
    }

    public java.lang.String getTestHeader() {
        return this.fDescription.getDisplayName();
    }

    public org.junit.runner.Description getDescription() {
        return this.fDescription;
    }

    public java.lang.Throwable getException() {
        return this.fThrownException;
    }

    public java.lang.String toString() {
        return getTestHeader() + ": " + this.fThrownException.getMessage();
    }

    public java.lang.String getTrace() {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        getException().printStackTrace(new java.io.PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public java.lang.String getMessage() {
        return getException().getMessage();
    }
}
