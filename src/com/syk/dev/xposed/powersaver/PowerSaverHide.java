package com.syk.dev.xposed.powersaver;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

/**
 * Xposed module that hides notifications for HTC Power Saver
 * 
 * Created by Steven on 10/6/13.
 */
public class PowerSaverHide implements IXposedHookLoadPackage{
	
	/**
	 * Hook the power application
	 */
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.htc.htcpowermanager"))
            return;

        XposedBridge.log("Adding hooks for package " + lpparam.packageName);
        
        findAndHookMethod("com.htc.htcpowermanager.powersaver.PowerSaverNotificationService", lpparam.classLoader, "addNotification", new XC_MethodReplacement() {
			@Override
			protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
				return null;
			}
        });
    }
}
