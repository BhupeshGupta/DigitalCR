package com.example.project_facebook;


import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

public static int i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar=getActionBar();
		Button button=(Button) findViewById(R.id.search_button);
		
	actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	ActionBar.TabListener tabListener=new ActionBar.TabListener() {
		
	
		@Override
		
	
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		
		}
		
		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
			if(tab.toString().equals("schedule")){
				Intent intent=new Intent(getApplicationContext(),DemoObjectFragment.class);
				startActivity(intent);
		}
			else if(tab.toString().equals("shout")){
				
			}
		}
		
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			
			// TODO Auto-generated method stub
			
		}
	};

		actionBar.addTab(actionBar.newTab().setText("schedule").setTabListener(tabListener));
	actionBar.addTab(actionBar.newTab().setText("shout").setTabListener(tabListener));}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.option_menu, menu);
		return true;
	}

}

