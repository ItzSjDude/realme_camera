package org.junit.experimental.theories;

/* loaded from: classes2.dex */
public abstract class PotentialAssignment {
    public abstract java.lang.String getDescription() throws org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException;

    public abstract java.lang.Object getValue() throws org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException;

    public static class CouldNotGenerateValueException extends java.lang.Exception {
        private static final long serialVersionUID = 1;

        public CouldNotGenerateValueException() {
        }

        public CouldNotGenerateValueException(java.lang.Throwable th) {
            super(th);
        }
    }

    public static org.junit.experimental.theories.PotentialAssignment forValue(final java.lang.String str, final java.lang.Object obj) {
        return new org.junit.experimental.theories.PotentialAssignment() { // from class: org.junit.experimental.theories.PotentialAssignment.1
            @Override // org.junit.experimental.theories.PotentialAssignment
            public java.lang.Object getValue() {
                return obj;
            }

            public java.lang.String toString() {
                return java.lang.String.format("[%s_renamed]", obj);
            }

            @Override // org.junit.experimental.theories.PotentialAssignment
            public java.lang.String getDescription() {
                java.lang.String str2;
                java.lang.Object obj2 = obj;
                if (obj2 == null) {
                    str2 = "null";
                } else {
                    try {
                        str2 = java.lang.String.format("\"%s_renamed\"", obj2);
                    } catch (java.lang.Throwable th) {
                        str2 = java.lang.String.format("[toString() threw %s_renamed: %s_renamed]", th.getClass().getSimpleName(), th.getMessage());
                    }
                }
                return java.lang.String.format("%s_renamed <from %s_renamed>", str2, str);
            }
        };
    }
}
