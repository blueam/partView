package com.example.partview_img;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {
	private ImageView content;
	private int cuurImg;
	private int[] images = { R.drawable.image1, R.drawable.image2,
			R.drawable.image3, R.drawable.image4, R.drawable.image5 };
	private Button next;
	private ImageView part;

	private void initImageView() {
		content.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
				Bitmap localBitmap = ((BitmapDrawable) content.getDrawable())
						.getBitmap();
				int i = UIUtil.dip2px(getApplicationContext(), 50);
				double d1 = 1.0D * localBitmap.getHeight()
						/ content.getHeight();
				double d2 = 1.0D * localBitmap.getWidth() / content.getWidth();
				double d3 = d1 > d2 ? d2 : d1;
				
				switch (paramMotionEvent.getAction()) {
				case MotionEvent.ACTION_DOWN:
				case MotionEvent.ACTION_MOVE:
					if ((paramMotionEvent.getX() < 0.0F)
							|| (paramMotionEvent.getY() < 0.0F))
						return false;
					int j = (int) (d3 * paramMotionEvent.getX()) - i / 2;
					int k = (int) (d3 * paramMotionEvent.getY()) - i / 2;
					if (j < 0) j = 0;
					if (k < 0) k = 0;
					if (j + i > localBitmap.getWidth())
						j = localBitmap.getWidth() - i;
					if (k + i > localBitmap.getHeight())
						k = localBitmap.getHeight() - i;
					part.setImageBitmap(Bitmap
							.createBitmap(localBitmap, j, k, i, i));
					return true;

				default:
					break;
				}
				return false;
			}
		});
	}

	private void initView() {
		content = ((ImageView) findViewById(R.id.content));
		part = ((ImageView) findViewById(R.id.part));
		next = ((Button) findViewById(R.id.next));
		next.setOnClickListener(this);
		initImageView();
	}

	public void onClick(View paramView) {
		ImageView localImageView = content;
		int[] arrayOfInt = images;
		int i = 1 + cuurImg;
		cuurImg = i;
		localImageView.setImageResource(arrayOfInt[(i % images.length)]);
	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.activity_main);
		initView();
	}
}