package com.digitalcr.android;


import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;


import android.app.ActionBar.Tab;
import android.content.Context;
import android.content.Intent;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends  Activity {


private static final FragmentManager fm = null;

ViewPager viewPager=new ViewPager(getApplicationContext());

Pager_Adapter pager_Adapter;





@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	final	ActionBar actionBar=getActionBar();
		
	setUpview();	
		
	viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
		
		 @Override
         public void onPageSelected(int position) {
             actionBar.setSelectedNavigationItem(position);
         }
	});
	
	
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
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub+

		viewPager.setCurrentItem(tab.getPosition());
		}


	};

	actionBar.addTab(actionBar.newTab().setText("schedule").setTabListener(tabListener));
	
	actionBar.addTab(actionBar.newTab().setText("shout").setTabListener(tabListener))	;


}



private void setUpview() {
	// TODO Auto-generated method stub
	
	viewPager=(ViewPager) findViewById(R.id.pager);
	
	pager_Adapter=new Pager_Adapter(this,fm);
	viewPager.setAdapter(pager_Adapter);
	
}


class Pager_Adapter extends FragmentStatePagerAdapter{


	public Pager_Adapter(Context context,FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}


	@Override
	public Fragment getItem(int i) {
		// TODO Auto-generated method stub
	Fragment f=new Fragment();
		switch(i){
		case 0:{
		f=new DemoObjectFragment();
			break;
			}
		case 1:
		{
			
		f=new Shout_Fragment();
		break;
		}
		}
		return f;

	
	
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

