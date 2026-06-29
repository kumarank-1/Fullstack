package com.example.oops.poly;

public class OverlodingvsOverriding {
    public static void main(String[] args) {
        Authentication auth = new Authentication();
        auth.login("abc@example.com", "secret");
        auth.login("9999999999", 123456);

        Theme theme = new Theme();
        Theme custom = new CustomTheme();

        theme.themeColorScheme();
        custom.themeColorScheme(); // overridden call
        custom.darkToLightMode(true);
    }
}
