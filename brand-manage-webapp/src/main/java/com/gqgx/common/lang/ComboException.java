package com.gqgx.common.lang;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ComboException
        extends RuntimeException {
    private List<Throwable> list;

    public ComboException() {
        this.list = new LinkedList();
    }

    public ComboException add(Throwable e) {
        this.list.add(e);
        return this;
    }

    public Throwable getCause() {
        return this.list.isEmpty() ? null : (Throwable) this.list.get(0);
    }

    public String getLocalizedMessage() {
        StringBuilder sb = new StringBuilder();
        for (Throwable e : this.list) {
            sb.append(e.getLocalizedMessage()).append('\n');
        }
        return sb.toString();
    }

    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        for (Throwable e : this.list) {
            sb.append(e.getMessage()).append('\n');
        }
        return sb.toString();
    }

//    public StackTraceElement[] getStackTrace() {
//        List<StackTraceElement> eles = new LinkedList();
//        int j=0;
//        int i=0;
//        for (Iterator localIterator = this.list.iterator(); localIterator.hasNext(); i < j) {
//            Throwable e = (Throwable) localIterator.next();
//            StackTraceElement[] arrayOfStackTraceElement;
//            j = (arrayOfStackTraceElement = e.getStackTrace()).length;
//            i = 0;
//            continue;
//            StackTraceElement ste = arrayOfStackTraceElement[i];
//            eles.add(ste);
//            i++;
//        }
//        return (StackTraceElement[]) eles.toArray(new StackTraceElement[eles.size()]);
//    }

    public void printStackTrace() {
        for (Throwable e : this.list) {
            e.printStackTrace();
        }
    }

    public void printStackTrace(PrintStream s) {
        for (Throwable e : this.list) {
            e.printStackTrace(s);
        }
    }

    public void printStackTrace(PrintWriter s) {
        for (Throwable e : this.list) {
            e.printStackTrace(s);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Throwable e : this.list) {
            sb.append(e.toString()).append('\n');
        }
        return sb.toString();
    }
}
