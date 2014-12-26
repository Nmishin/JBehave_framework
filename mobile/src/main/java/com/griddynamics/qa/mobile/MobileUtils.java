package com.griddynamics.qa.mobile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The class contains methods for interaction with mobile platforms and appium server
 *
 * @author dcheremushkin
 */
public class MobileUtils {

    private static final String PATH_TO_ADB = System.getProperty("ADB_PATH")+"/adb";
    private static final String PATH_TO_FRUITSTRAP = System.getProperty("APPIUM_HOME")+"/submodules/fruitstrap/fruitstrap";

    private final static String ANDROID_APP_PACKAGE         = "android.appPackage";
    private static final String IOS_APP_BUNDLE              = "ios.appBundle";

    private static final String ANDROID_BROWSER_PACKAGE     = "org.openqa.selenium.android.app";
    private static final String ANDROID_SELENDROID_PACKAGE  = "io.selendroid";
    private static final String ANDROID_UNLOCK_PACKAGE      = "io.appium.unlock";
    private static final String IOS_SAFARILAUNCHER_BUNDLE   = "com.bytearc.SafariLauncher";

    private static final String OUTPUT_APPIUM_ERRORS = "errors=$(grep 'error: \\|Error :\\|STDERR' ./target/appium.log); [ -n \"$errors\" ]"
            + " && echo -e \"\n--------------------------------------- Appium log ---------------------------------------\""
            + " && echo \"$errors\" && echo \"------------------------------------------------------------------------------------------\n\""
            + " && cat ./target/appium.log >>./target/appium-full.log && echo \"\" >./target/appium.log";

    private static final String UNINSTALL_APPS_COMMAND          = PATH_TO_ADB + " uninstall " + System.getProperty(ANDROID_APP_PACKAGE) + " >/dev/null 2>/dev/null;"
            + PATH_TO_ADB + " uninstall " + ANDROID_BROWSER_PACKAGE + " >/dev/null 2>/dev/null;"
            + PATH_TO_ADB + " uninstall " + ANDROID_SELENDROID_PACKAGE + " >/dev/null 2>/dev/null;"
            + PATH_TO_ADB + " uninstall " + ANDROID_UNLOCK_PACKAGE + " >/dev/null 2>/dev/null;"
            + PATH_TO_FRUITSTRAP + " uninstall --bundle " + System.getProperty(IOS_APP_BUNDLE) + " >/dev/null 2>/dev/null;"
            + PATH_TO_FRUITSTRAP + " uninstall --bundle " + IOS_SAFARILAUNCHER_BUNDLE + " >/dev/null 2>/dev/null;";

    /**
     * Reads appium log and prints errors to current output stream
     */
    public static void outputAppiumErrors() {
        executeShCommand(OUTPUT_APPIUM_ERRORS);
    }

    /**
     * Quietly (with no verbose) tries to uninstall tested and supporting apps from both iOS and Android platforms
     */
    public static void uninstallMobileApps() {
        executeShCommand(UNINSTALL_APPS_COMMAND);
    }

    /**
     * Executes sh-command and prints its output to Maven's stdout
     *
     * @param command - sh-command to execute
     */
    private static void executeShCommand(String command) {
        try {
            String line;
            Process p = new ProcessBuilder("sh", "-c", command).start();
            BufferedReader input = new BufferedReader (new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
            input = new BufferedReader (new InputStreamReader(p.getErrorStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
        }
        catch (Exception err) {
            err.printStackTrace();
        }
    }

}