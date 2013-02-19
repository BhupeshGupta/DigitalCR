package com.digitalcr.android;

import java.sql.Date;

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




@Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
              Bundle savedInstanceState) {
// Inflate the layout for this fragment

return inflater.inflate(R.layout.fragment_schedule, container, false);

}

public static android.support.v4.app.Fragment newInstance(
		Context applicationContext) {
	// TODO Auto-generated method stub
	return null;
}

}

class TitlesFragment extends ListFragment{


  
	private static final int textViewResourceId = 0;
	TitlesFragment[] objects=null;
	@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Populate list with our static array of titles.
@SuppressWarnings("unused")
Titles[] titles=new Titles[]
		{new Titles(R.drawable.images,""),
		new Titles(R.drawable.images,"")};
   	Fragment listView=getFragmentManager().findFragmentById(R.layout.schedule_list);
TitlesAdapter titlesAdapter=new TitlesAdapter(getActivity(),  R.layout.list_fragment, textViewResourceId,
		titles) ;
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
		FragmentManager fragmentManager=getFragmentManager();
		android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

	}

}
class TitlesAdapter extends ArrayAdapter<TitlesFragment>{
	private static Titles[] myobject = null;


	Context context;
	

	private LayoutInflater inflater = null;



	public TitlesAdapter(Context context, int resource, int textViewResourceId,
			Titles[] myobject) {
		super(context, resource, textViewResourceId);
		
		this.context = context;
		
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.myobject=myobject;

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
