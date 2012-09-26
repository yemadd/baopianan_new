package com.example.mp3.play;

import android.app.Activity;
import android.content.Intent;

public class Themes{
	private static int sTheme;

	public final static int THEME_DEFAULT = 0;
	public final static int THEME_WHITE = 1;
	public final static int THEME_BLUE = 2;
	public static void changeToTheme(Activity activity, int theme)
	{
		sTheme = theme;
		activity.finish();

		activity.startActivity(new Intent(activity, activity.getClass()));
	}

	/** Set the theme of the activity, according to the configuration. */
	public static void onActivityCreateSetTheme(Activity activity)
	{
		switch (sTheme)
		{
		default:
		case 1:
		  activity.setTheme(R.style.hs);
			break;
		case 2:
			activity.setTheme(R.style.Theme);
			break;
		case 3:
			activity.setTheme(R.style.Theme2);
			break;
		}
	}
}
