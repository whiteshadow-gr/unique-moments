import subprocess
import time
from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

device = MonkeyRunner.waitForConnection()

device.drag((10,10),(1000,1000),0.15,4)
"""
subprocess.call('adb push UMTests.jar /data/local/tmp/')

time.sleep (5)
"""
subprocess.call('adb shell uiautomator runtest UMTests.jar -c test.ShowNotificationsTest', shell = True)



subprocess.call('adb shell uiautomator runtest UMTests.jar -c test.ShowNotificationsTest#testExistingContactAlfaios', shell = True)
