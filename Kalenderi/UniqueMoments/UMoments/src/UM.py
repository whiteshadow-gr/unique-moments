import subprocess
import time

from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

"""
subprocess.call("adb uninstall gr.um.uniquemoments")
subprocess.call("adb install UniqueMoments.apk")
"""

subprocess.call("adb shell pm clear com.android.providers.contacts", shell = True)
device = MonkeyRunner.waitForConnection()
subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'desie' -e phone 6991234567", shell = True)
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Elenh' -e phone 6976454744", shell = True)
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Eirhnh' -e phone 6988191311", shell = True)
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Nikolaos' -e phone 6933435367", shell = True)
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Vasileia' -e phone 6944131215", shell = True)
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Nick' -e phone 6901298347", shell = True)
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Elisavet' -e phone 6939303011", shell = True)
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Alfaios' -e phone 6944135690", shell = True)
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Kwnstantinos' -e phone 6989878288", shell = True)
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
time.sleep( 60 )
device.press('KEYCODE_HOME', MonkeyDevice.DOWN_AND_UP)
subprocess.call("adb push UMTests.jar /data/local/tmp/")
subprocess.call("adb shell uiautomator runtest UMTests.jar -c tests.SearchContactTest", shell = True)