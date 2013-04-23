import time
import subprocess

from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

"""initiliazation"""

subprocess.Popen('emulator -avd test')
time.sleep( 27 )
subprocess.call('adb push UItesting.jar /data/local/tmp')
subprocess.call('adb uninstall com.example.myuniquemoments')
subprocess.call('adb install UniqueMoments.apk')
device = MonkeyRunner.waitForConnection()


"""setting up the environment"""

subprocess.call('adb shell pm clear com.android.providers.contacts', shell = True)
device.shell("am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Donald'")
time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 5 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)

device.shell("am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Duffy'")
time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 5 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 4 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 3 )



"""calling the first test subroutine"""

subprocess.call('adb shell uiautomator runtest UItesting.jar -c com.CalendarNamedaysTest', shell = True)




"""tearing down the environment"""

subprocess.call('adb shell pm clear com.android.providers.contacts', shell = True)


