package com.example.oops.poly;

public class CustomTheme extends Theme {
    @Override
    public void themeColorScheme() {
        System.out.println("Primary: Green, Secondary: Yellow");
    }

    @Override
    public void darkToLightMode(boolean enabled) {
        if (enabled) {
            System.out.println("Mode: Dark Gray to Amber/White");
        } else {
            System.out.println("Mode disabled");
        }
    }

    // Overloading in child (not overriding)
    public void darkToLightMode(boolean enabled, int brightnessLevel) {
        System.out.println("Enabled: " + enabled + ", brightness: " + brightnessLevel);
    }
}
