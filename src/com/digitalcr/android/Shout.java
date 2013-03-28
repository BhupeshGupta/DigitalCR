package com.digitalcr.android;



import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import com.digitalcr.android.DemoObjectFragment.ViewFragment;
import com.digitalcr.android.MainActivity.Pager_Adapter;

import android.app.ActionBar;
import android.app.Activity;


import android.content.Context;
import android.content.Intent;
import android.content.pm.FeatureInfo;
import android.content.res.Configuration;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.CursorAdapter;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;


class Shout extends Fragment{
private static final FragmentManager fm = null;


	Shout_Fragment shout_Fragment=new Shout_Fragment();
	

	}




	


class Shout_Fragment extends ListFragment{
	ViewPager viewPager1=new ViewPager(getActivity());
	// TODO Auto-generated constructor stub
DetailsFragment detailsFragment=new DetailsFragment();
	 boolean mDualPane;
	    static int mCurCheckPosition = 0;


		public static Fragment newInstance(
				Context applicationContext) {
			
			Shout_Fragment shout_Fragment=new Shout_Fragment();
			// TODO Auto-generated method stub
			
			
			return shout_Fragment;}


	    @Override
	    public void onActivityCreated(Bundle savedInstanceState) {
	        super.onActivityCreated(savedInstanceState);



	        // Populate list with our static array of titles.
	        Titles[] titles=new Titles[]
	        		{new Titles(R.drawable.images,""),
	        		new Titles(R.drawable.images,"")};
	       
	          Shout_Fragment listView=(Shout_Fragment) getFragmentManager().findFragmentById(R.layout.list_fragment);	
	           	TitlesAdapter titlesAdapter=new TitlesAdapter(getActivity(), R.layout.shout_list, titles);
	        setListAdapter(titlesAdapter);
	             

	        // Check to see if we have a frame in which to embed the details
	     
	        View detailsFrame = getActivity().findViewById(R.id.details);
	        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

	        if (savedInstanceState != null) {
	            // Restore last state for checked position.
	            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
	        }

	        if (mDualPane) {
	            // In dual-pane mode, the list view highlights the selected item.
	            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	            // Make sure our UI is in the correct state.
	            showDetails(mCurCheckPosition);
	        }
	    }

	 
		@Override
	    public void onSaveInstanceState(Bundle outState) {
	        super.onSaveInstanceState(outState);
	        outState.putInt("curChoice", mCurCheckPosition);
	    }

	    @Override
	    public void onListItemClick(ListView l, View v, int position, long id) {
	        showDetails(position);
	   Intent intent=new Intent(getActivity(),ViewFragment.class);
	   
	        intent.putExtra(getTag(), getArguments());
	        startActivity(intent);
	    }

  
		/**
	     * Helper function to show the details of a selected item, either by
	     * displaying a fragment in-place in the current UI, or starting a
	     * whole new activity in which it is displayed.
	     */
	    void showDetails(int index) {
	        mCurCheckPosition = index;

	        if (mDualPane) {
	            // We can display everything in-place with fragments, so update
	            // the list to highlight the selected item and show the data.
	            getListView().setItemChecked(index, true);

	            // Check what fragment is currently shown, replace if needed.
	 DetailsFragment details=(DetailsFragment) getFragmentManager().findFragmentById(R.id.details);
	            if (details == null ) {
	                // Make new fragment to show this selection.
	             details = DetailsFragment.newInstance(index);

	                // Execute a transaction, replacing any existing fragment
	                // with this one inside the frame.
	                FragmentTransaction ft = getFragmentManager().beginTransaction();
	                if (index == 0) {
	                    ft.replace(R.id.details, details);
	              
	                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
	                ft.commit();
	            }

	        } else {
	            // Otherwise we need to launch a new activity to display
	            // the dialog fragment with selected text.
	            Intent intent = new Intent();
	            intent.setClass(getActivity(), DetailsActivity.class);
	            intent.putExtra("index", index);
	            startActivity(intent);
	        }
	    }
	

    }

	    class TitlesAdapter extends ArrayAdapter<Shout_Fragment>{
	    	private  final Titles[] myobject = null;


	    	Context context;
	    	

	    	private LayoutInflater inflater = null;



	    	public TitlesAdapter(Context context, int resource,
	    			Titles[] myobject) {
	    		super(context, resource);
	    		
	    		this.context = context;
	    		
	    		inflater = (LayoutInflater) context
	    				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	    		// TODO Auto-generated constructor stub
	    	}

	    	@SuppressWarnings("unused")
	    	@Override
	    	public View getView(int position, View convertView, ViewGroup parent) {
	    		// TODO Auto-generated method stub
	         
	    View view;
	    TitlesHolder holder=null;

	    if(convertView== null){


	    	view = inflater.inflate(R.layout.list_fragment, parent, false);
	    	holder =  new 	TitlesHolder();
	    	holder.imageView = (ImageView) view.findViewWithTag(R.id.announce);
	    	holder.editText=(EditText) view.findViewById(R.id.notice);
	    	view.setTag(holder);

	    }

	    Titles titles = myobject[position];
	    for(position=0;position<=myobject.length;position++){
	    holder.imageView.setImageResource(R.id.announce);
	    holder.editText.setText(R.id.notice, null);
	    }



	    		
	    		return super.getView(position, convertView, parent);
	    	}

	    }
	    class TitlesHolder{
	    	ImageView imageView;
	    	EditText editText;
	    }



static class DetailsFragment extends Fragment{
	
    static DetailsFragment f = new DetailsFragment();
    public static int z=0;
	   static Bundle args = new Bundle();
	
	@Override
 
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
    	Shout_data shout_data=new Shout_data(getActivity());
		f=(DetailsFragment) getFragmentManager().findFragmentById(R.id.details);

		ShoutCursorAdapter shoutCursorAdapter=new ShoutCursorAdapter(getActivity(),shout_data.getdata(), R.layout.schedule_list);
   
	String x = null;
	int columns=0;
	
	int y=0;
	while(shoutCursorAdapter.getCursor().getColumnName(y) != null){
		
	Intent intent=new Intent(getActivity(),CrossFadeAnimation.class);
	intent.putExtra(shoutCursorAdapter.getCursor().getColumnName(getId()),z);
		startActivity(intent);
	}
	y++;
	
	
	shoutCursorAdapter.getCursor().getColumnNames().equals(x);
	
	

	
	}



	/**
     * Create a new instance of DetailsFragment, initialized to
     * show the text at 'index'.
     */
    public  static DetailsFragment newInstance(int index) {
    

        // Supply index input as an argument.
       
        args.putInt("", index);
        f.setArguments(args);

        return f;
    }
   
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	
  
				return container;
        
        }

       
}
    
} 










