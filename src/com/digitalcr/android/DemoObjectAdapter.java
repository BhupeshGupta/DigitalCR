package com.digitalcr.android;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import android.content.Context;
import android.database.Cursor;
import android.hardware.Camera.Size;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

public class DemoObjectAdapter extends CursorAdapter {
private static int i = 0;
View view=null;
Inflater inflater=new  Inflater();
private int layoutResourceId;

	public DemoObjectAdapter(Context context, Cursor c,int layoutResourceId) {
		super(context, c);
		// TODO Auto-generated constructor stub
		this.layoutResourceId=layoutResourceId;
		Inflater inflator=(Inflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}
	

	@Override
	public void bindView(View arg0, Context arg1, Cursor cur) {
		// TODO Auto-generated method stub
		
		
			ImageView imageView=(ImageView) view.findViewById(R.id.announce);
			EditText editText=(EditText) view.findViewById(R.id.notice);
			String[] columns=new String[]{"SNO","SUBJECT","TIME","DEPT_NAME","BATCH","COLLEGE_ID"};
for(i=0;i<=columns.length;i++){
editText.setText(cur.getColumnIndex(columns[i]));

		
}}

	
	@Override
	public View newView(Context arg0, Cursor curser, ViewGroup arg2) {
		return null;
	}

}
