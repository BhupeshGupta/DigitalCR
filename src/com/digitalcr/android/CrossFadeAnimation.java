package com.digitalcr.android;

import java.util.ArrayList;

import com.digitalcr.android.Shout_Fragment.DetailsFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CrossFadeAnimation extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Intent intent=new Intent();
		intent.getDataString().equals(DetailsFragment.z);
		View detailsFragment=findViewById(R.id.details);
		ListView mylist=(ListView) findViewById(R.id.list_col);
		ArrayList<String> arraylist=new ArrayList<String>();

		ArrayAdapter<String>  arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.preference_category,arraylist);
				mylist.setAdapter(arrayAdapter);
				
		
				}
				
	}

	
	
