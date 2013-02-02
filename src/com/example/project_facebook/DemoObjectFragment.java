package com.example.project_facebook;


import java.util.ArrayList;
import java.util.zip.Inflater;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;

import android.app.ListFragment;
import android.content.Context;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;



public class DemoObjectFragment extends Fragment {

FragmentManager fragmentManager=getFragmentManager();

android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
@Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
              Bundle savedInstanceState) {
// Inflate the layout for this fragment

return inflater.inflate(R.layout.fragment_schedule, container, false);

}

}

class TitlesFragment extends ListFragment{


    private static final int resource = 0;
	private static final int textViewResourceId = 0;

	@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Populate list with our static array of titles.
   Titles[] titles=new Titles[]{};
   	Fragment listView=getFragmentManager().findFragmentById(R.layout.schedule_list);
 TitlesAdapter titlesAdapter=new TitlesAdapter(Context context, int resource, int textViewResourceId,
			TitlesFragment[] objects, int layoutResourceId);
  ((ListFragment) listView).setListAdapter(titlesAdapter); }       

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		getFragmentManager().findFragmentById(R.id.read);
		
		return inflater.inflate(R.layout.list_fragment, container,false);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	
	}

}
class TitlesAdapter extends ArrayAdapter<TitlesFragment>{
	private static final Titles[] myobject = null;


	Context context;
	

	private LayoutInflater inflater = null;
	int layoutResourceId;


	public TitlesAdapter(Context context, int resource, int textViewResourceId,
			TitlesFragment[] objects, int layoutResourceId) {
		super(context, resource, textViewResourceId, objects);
		this.layoutResourceId = layoutResourceId;
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


	view = inflater.inflate(layoutResourceId, parent, false);
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
