package com.ocean.gradualchange;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

@SuppressWarnings("deprecation")
public class MyLinearLayout extends View {
	
	private LinearGradient gradinet;
	private Paint paint;
	private int width;
	private int height;
	private int start = 0XFFFF8080;
	private int end = 0XFF8080FF;
	
	public MyLinearLayout(Context context) {
		super(context);
		getDisplay(context);
	}

	public MyLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		getDisplay(context);
	}
	
	private void getDisplay(Context context) {
		WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		width = wm.getDefaultDisplay().getWidth();
		height = wm.getDefaultDisplay().getHeight();
	}
	
	public void setGradient(int start,int end){
		this.start = start;
		this.end = end;
		gradinet = new LinearGradient(0, 0, width, height, start, end, Shader.TileMode.MIRROR);
		invalidate();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		System.out.println("!!!!!!!!!!!!!!!!");
		if (paint == null) {
			paint = new Paint();
		}
		if (gradinet == null) {
			gradinet = new LinearGradient(0, 0, width, height, start, end, Shader.TileMode.MIRROR);
		}
		paint.setShader(gradinet);
		canvas.drawRect(0, 0, width	, height, paint);
	}

}
