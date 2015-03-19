package com.ocean.gradualchange;

import java.util.ArrayList;
import java.util.List;

import android.animation.ArgbEvaluator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class GradientActivity extends FragmentActivity {

	private ViewPager viewpager;
	private MyLinearLayout view;
	private ImageFragment fragment;
	private ImageFragment fragment2;
	private ImageFragment fragment3;
	private ImageFragment fragment4; 
	private List<Fragment> views = new ArrayList<Fragment>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		view = (MyLinearLayout) findViewById(R.id.my_view);
		
		fragment = new ImageFragment();
		fragment2 = new ImageFragment();
		fragment3 = new ImageFragment();
		fragment4 = new ImageFragment();
		views.add(fragment2);
		views.add(fragment3);
		views.add(fragment4);
		views.add(fragment);
		viewpager.setAdapter(new MyAdapter(getSupportFragmentManager()));
		viewpager.setCurrentItem(0);
		viewpager.setOnPageChangeListener(new PageChangeLisener());
	}
	
	private class MyAdapter extends FragmentPagerAdapter{

		private List<Fragment> list_views;

		public MyAdapter(FragmentManager fm) {
			super(fm);
			list_views = views;
		}

		@Override
		public Fragment getItem(int arg0) {
			return list_views.get(arg0);
		}

		@Override
		public int getCount() {
			return list_views.size();
		}
		
	}
	
	class PageChangeLisener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		@SuppressLint("NewApi")
		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			System.out.println("pixels : " + positionOffsetPixels);
			ArgbEvaluator evaluator = new ArgbEvaluator();
			ArgbEvaluator evaluator2 = new ArgbEvaluator();
			int evaluate = (Integer) evaluator.evaluate(positionOffset, 0XFF8080FF,0XFFFF8080);
			int evaluate2 = (Integer) evaluator2.evaluate(positionOffset, 0XFFFF8080, 0XFF8080FF);
			if (position % 2 == 0) {
				view.setGradient(0XFF8080FF,0XFFFF8080);
				view.setGradient(evaluate, evaluate2);
			}else {
				view.setGradient(0XFFFF8080,0XFF8080FF);
				view.setGradient(evaluate2, evaluate);
			}
		}

		@Override
		public void onPageSelected(int arg0) {
		}
	}
}
