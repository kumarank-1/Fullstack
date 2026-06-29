package com.example.oops.interfce.app;

class Two {
    private void pvtShow() { System.out.println("[Two] private"); }
    void defShow() { System.out.println("[Two] default"); }
    protected void protShow() { System.out.println("[Two] protected"); }
    public void pubShow() { System.out.println("[Two] public"); }

    void test() {
        pvtShow(); defShow(); protShow(); pubShow();
    }
}
