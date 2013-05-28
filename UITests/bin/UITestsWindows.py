import time
import subprocess

from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice


"""initiliazation"""

"""subprocess.Popen('emulator -avd test')
time.sleep( 27 )"""


subprocess.call('adb uninstall gr.um.uniquemoments')
subprocess.call('adb install UniqueMoments.apk') 
subprocess.call('adb push UITests.jar /data/local/tmp/')
device = MonkeyRunner.waitForConnection()


"""setting up the environment"""

subprocess.call("adb shell pm clear com.android.providers.contacts", shell = True)
time.sleep( 7 )
subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'desie' -e phone 6991234567", shell = True)

time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 5 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)

subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Elenh' -e phone 6976454744", shell = True)

time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 5 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)

subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Eirhnh' -e phone 6988191311", shell = True)

time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 5 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)

subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Nikolaos' -e phone 6933435367", shell = True)

time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 5 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)

subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Vasileia' -e phone 6944131215", shell = True)

time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 5 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)

subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Nick' -e phone 6901298347", shell = True)

time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 5 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)

subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Elisavet' -e phone 6939303011", shell = True)

time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 5 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)

subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Alfaios' -e phone 6944135690", shell = True)

time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 5 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)

subprocess.call("adb shell am start -a  android.intent.action.INSERT -t vnd.android.cursor.dir/contact -e name 'Kwnstantinos' -e phone 6989878288", shell = True)
time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 5 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
time.sleep( 7 )
device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)

time.sleep( 7 )



"""calling tests - Kalenderi"""

subprocess.call("adb shell uiautomator runtest UITests.jar -c com.SearchContactTest", shell = True)

device.drag((10,10),(1000,1000),0.15,4)

subprocess.call('adb shell uiautomator runtest UMTests.jar -c com.ShowNotificationsTest#testExistingContactAlfaios', shell = True)

device.drag((10,10),(1000,1000),0.15,4)

subprocess.call('adb shell uiautomator runtest UMTests.jar -c com.ShowNotificationsTest#testExistingContactSinesios', shell = True)

device.drag((10,10),(1000,1000),0.15,4)

subprocess.call('adb shell uiautomator runtest UMTests.jar -c com.ShowNotificationsTest#testExistingContactAleksandros', shell = True)

device.drag((10,10),(1000,1000),0.15,4)

subprocess.call('adb shell uiautomator runtest UMTests.jar -c com.ShowNotificationsTest#testExistingContactElenh', shell = True)

device.drag((10,10),(1000,1000),0.15,4)

subprocess.call('adb shell uiautomator runtest UMTests.jar -c com.ShowNotificationsTest#testExistingContactStefanos', shell = True)





"""setting up the environment"""

subprocess.call('adb shell pm clear com.android.providers.contacts', shell = True)
subprocess.call('adb uninstall gr.um.uniquemoments')
subprocess.call('adb install UniqueMoment.apk') 



"""calling tests - Foulidis"""

subprocess.call('adb shell uiautomator runtest UITests.jar -c com.AddEventTest', shell = True)
subprocess.call('adb shell uiautomator runtest UITests.jar -c com.sendMessageTest', shell = True)




"""setting up the environment"""

subprocess.call('adb shell pm clear com.android.providers.contacts', shell = True)
subprocess.call('adb uninstall gr.um.uniquemoments')
subprocess.call('adb install UniqueMoment.apk') 




"""calling tests - Gkina"""

subprocess.call('adb shell uiautomator runtest UITests.jar -c com.RecallTest', shell = True)
subprocess.call('adb shell uiautomator runtest UITests.jar -c com.RecallLastCommunicationTest', shell = True)
subprocess.call('adb shell uiautomator runtest UITests.jar -c com.RecallCommunicationTest', shell = True)


"""setting up the environment"""

subprocess.call('adb shell pm clear com.android.providers.contacts', shell = True)
subprocess.call('adb uninstall gr.um.uniquemoments')
subprocess.call('adb install UniqueMoment.apk') 




"""calling tests - Charalampidou"""

subprocess.call('adb shell uiautomator runtest UITests.jar -c com.ContactsTest', shell = True)
subprocess.call('adb shell uiautomator runtest UITests.jar -c com.CreateContactsTest', shell = True)
subprocess.call('adb shell uiautomator runtest UITests.jar -c com.DeleteContactsTest', shell = True)
subprocess.call('adb shell uiautomator runtest UITests.jar -c com.EditContactsTest', shell = True)
subprocess.call('adb shell uiautomator runtest UITests.jar -c com.ShowContactsTest', shell = True)

