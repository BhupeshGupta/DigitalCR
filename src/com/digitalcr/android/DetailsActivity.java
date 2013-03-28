package com.digitalcr.android;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.digitalcr.android.Shout_Fragment.DetailsFragment;


    class DetailsActivity extends Activity {
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            if (getResources().getConfiguration().orientation
                    == Configuration.ORIENTATION_LANDSCAPE) {
                // If the screen is now in landscape mode, we can show the
                // dialog in-line with the list so we don't need this activity.
                finish();
                return;
            }

            if (savedInstanceState == null) {
                // During initial setup, plug in the details fragment.
          	 
          	 Intent intent=new Intent(getApplicationContext(),DetailsFragment.class);
          	 
          	 startActivity(intent);
          	 
          	  
            }
        }
    }

