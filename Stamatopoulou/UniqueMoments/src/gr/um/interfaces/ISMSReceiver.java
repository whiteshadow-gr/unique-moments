package gr.um.interfaces;

import android.content.Context;
import android.content.Intent;

public interface ISMSReceiver
{
	public void receiveSms(Context context,Intent intent);
}
