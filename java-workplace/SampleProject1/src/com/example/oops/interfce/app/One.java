package com.example.oops.interfce.app;

public class One {
    private int a;
    int b;
    protected int c;
    public int d;

    private void pvtShow() { System.out.println("[One] private"); }
    void defShow() { System.out.println("[One] default"); }
    protected void protShow() { System.out.println("[One] protected"); }
    public void pubShow() { System.out.println("[One] public"); }

    public void testInsideClass() {
        pvtShow(); defShow(); protShow(); pubShow();
    }
}
