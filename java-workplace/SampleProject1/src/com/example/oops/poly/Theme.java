package com.example.oops.poly;

public class Theme {
    public void themeColorScheme() {
        System.out.println("Primary: Red, Secondary: White");
    }

    public void darkToLightMode(boolean enabled) {
        if (enabled) {
            System.out.println("Mode: Black to White");
        } else {
            System.out.println("Mode disabled");
        }
    }
}