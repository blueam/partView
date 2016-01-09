package com.example.partview_img;

import android.content.Context;

public class UIUtil {
	public static int dip2px(Context paramContext, int paramInt) {
		return (int) (0.5F + paramContext.getResources().getDisplayMetrics().density
				* paramInt);
	}

	public static int px2dip(Context paramContext, int paramInt) {
		float f = paramContext.getResources().getDisplayMetrics().density;
		return (int) (0.5F + paramInt / f);
	}
}