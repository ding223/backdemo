package com.gqgx.common.context;

public class InvocationContextHolder {
    private static ThreadLocal<InvocationContext> cachedContext = new ThreadLocal();

    public static InvocationContext getInvocationContext() {
        return (InvocationContext) cachedContext.get();
    }

    static void setInvocationContext(InvocationContext invocationContext) {
        cachedContext.set(invocationContext);
    }
}