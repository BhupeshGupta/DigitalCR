package com.digitalcr.android;


import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.content.Context;
import android.content.Intent;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

private static final android.support.v4.app.FragmentManager fm = null;


ViewPager viewPager=new ViewPager(getApplicationContext());

Pager_Adapter pager_Adapter=new Pager_Adapter(getApplicationContext(), fm);





@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar=getActionBar();
		
	setUpview();	
			
	setTab();
	
	
		Button button=(Button) findViewById(R.id.search_button);
		
	actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
	
	ActionBar.TabListener tabListener=new ActionBar.TabListener()
	{
	
	
		@Override
		
	
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		
		}
	
		
	
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			
			// TODO Auto-generated method stub
		
		}


		@Override
		public void onTabSelected(Tab tab, FragmentTransaction arg1) {
			// TODO Auto-generated method stub
		viewPager.setCurrentItem(tab.getPosition());
		}
		
	};

	actionBar.addTab(actionBar.newTab().setText("schedule").setTabListener(tabListener));
	
	actionBar.addTab(actionBar.newTab().setText("shout").setTabListener(tabListener))	;}
		

private void setTab() {
	// TODO Auto-generated method stub
	viewPager.setOnPageChangeListener(new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int position) {
			// TODO Auto-generated method stub
			switch(position){
			case 0:
				
			case 1:
				
			}
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}
	} );
	
}


private void setUpview() {
	// TODO Auto-generated method stub
	setContentView(R.layout.shoutpager);
	viewPager=(ViewPager) findViewById(R.id.pager);
	
	pager_Adapter=new Pager_Adapter(getApplicationContext(), fm);
	viewPager.setAdapter(pager_Adapter);
	
}


class Pager_Adapter extends FragmentStatePagerAdapter{

	


	public Pager_Adapter(Context context,android.support.v4.app.FragmentManager fragmentManager) {
		super(fragmentManager);
		// TODO Auto-generated constructor stub
	}


	


	@Override
	public Fragment getItem(int i) {
		
		Fragment f=new Fragment();
		switch(i){
		case 0:
			
			f=DemoObjectFragment.newInstance(getApplicationContext());
			break;
		case 1:
		
			
			f=Shout_Fragment.newInstance(getApplicationContext());
			break;
		}
		return f;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	
	}}
	




	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.option_menu, menu);
		return true;
	}

}

