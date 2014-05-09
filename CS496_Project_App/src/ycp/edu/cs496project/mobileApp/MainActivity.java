package ycp.edu.cs496project.mobileApp;

import java.io.IOException;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;

/**
 * 
 * @author josh coady
 *
 */
public class MainActivity extends Activity {
	
	public static String URI_IP_ADDRESS = "10.0.2.2:8081";
	public static final int ACTIVITY_REQUEST_CODE = 1;
	
	private String username = "josh"; //a player's username
	private String password = "jcoady"; //the player's password
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getWindow().getDecorView().setBackgroundColor(Color.BLACK);
		
		onActivityResult(0, 0, null);
		
		//if a user is not logged in, go to the login/ register activity to either log in or register
		if(username == null || password == null){
			Intent loginIntent = new Intent(this, LoginActivity.class);
			startActivityForResult(loginIntent, ACTIVITY_REQUEST_CODE);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/**
	 * an onClick method to start the game
	 * 
	 * @param v a view
	 * @throws UnknownHostException 
	 */
	public void onPlayClick(View v){
		//create an intent to go to the gameplay activity
		Intent startGameIntent = new Intent(this, MarbleMadness.class);
		startActivity(startGameIntent);
	}
	
	/**
	 * an onClick method to see the game's highscores and the user's trophies
	 * 
	 * @param v a view
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public void onScoreClick(View v) throws UnknownHostException, IOException{
		//start the player info activity
		Intent playerInfoIntent = new Intent(this, PlayerInfoActivity.class);
		startActivity(playerInfoIntent);
	}
	
	//onClick event to go to login 
	public void onGoToLoginClick(View v){
		Intent loginIntent = new Intent(this, LoginActivity.class);
		startActivity(loginIntent);
	}

}
