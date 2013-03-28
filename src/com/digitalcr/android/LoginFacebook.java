package com.digitalcr.android;



import java.net.URL;

import org.apache.http.io.SessionInputBuffer;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.service.textservice.SpellCheckerService.Session;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.*;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;
import com.facebook.android.Util;
import com.facebook.model.*;

public class LoginFacebook extends Activity {

    public static final String mAPP_ID = "437755416309030";
	
Facebook mFacebook=new Facebook(mAPP_ID);
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		mFacebook.authorizeCallback(requestCode, resultCode, data);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_button);
		OnClickListener loginButtonListener;
		Button button=((Button)findViewById(R.id.authButton));}
	ImageView imageView=(ImageView) findViewById(R.id.ProfilePic);
	View.OnClickListener onClickListener=new View.OnClickListener() {
		
		@SuppressWarnings("deprecation")
		@Override
		public void onClick(View v) throws FacebookError {
			// TODO Auto-generated method stub
			
			if(!mFacebook.isSessionValid()){
				imageView.setVisibility(ImageView.INVISIBLE);
				Toast.makeText(getApplicationContext(), "Authorising", Toast.LENGTH_LONG);
				
				mFacebook.authorize(getParent(), new String[]{""}, new LoginDialogListener());}
						
			else {
	imageView.setVisibility(ImageView.VISIBLE);
			try {
			JSONObject json = Util.parseJson(mFacebook.request("me"));
			String facebookID = json.getString("id");
			String firstName = json.getString("first_name");
			String lastName = json.getString("last_name");
	
			}
			catch(Exception error){
				
				
			}
			
			}
			}
	};


class LoginDialogListener implements DialogListener {
public void onComplete(Bundle values) {
	URL imageUrl=null;
try {
//The user has logged in, so now you can query and use their Facebook info
JSONObject json = Util.parseJson(mFacebook.request("me"));

String facebookID= json.getString("id");
String firstName = json.getString("first_name");
String lastName = json.getString("last_name");
String email=json.getString("email");
String education=json.getString("education");
ImageView imageView=(ImageView) findViewById(R.id.ProfilePic);
imageUrl=new URL("http://graph.facebook.com/"+facebookID+"/pictures?type=small");
Bitmap bmp=BitmapFactory.decodeStream(imageUrl.openConnection().getInputStream());
imageView.setImageBitmap(bmp);
Toast.makeText( LoginFacebook.this, "Thank you for Logging In, " + firstName + " " + lastName + "!", Toast.LENGTH_SHORT).show();
TextView textview=(TextView) findViewById(R.id.selected_courses);
if(education==Schedule_data.COLLEGE_NAME){

textview.setText(Schedule_data.COURSE);
	
}
else
	Toast.makeText(getApplicationContext(), "Add Your College", Toast.LENGTH_LONG).show();
}
catch( Exception error ) {
Toast.makeText( LoginFacebook.this, error.toString(), Toast.LENGTH_SHORT).show();
}
}
public void onFacebookError(FacebookError error) {
Toast.makeText( LoginFacebook.this, "Something went wrong. Please try again.", Toast.LENGTH_LONG).show();
}
public void onError(DialogError error) {
Toast.makeText(LoginFacebook.this, "something is wrong", Toast.LENGTH_LONG);
}
public void onCancel() {
Toast.makeText(LoginFacebook.this, "Something went wrong. Please try again.", Toast.LENGTH_LONG).show();
}
}
}
		
	

	
	
	

