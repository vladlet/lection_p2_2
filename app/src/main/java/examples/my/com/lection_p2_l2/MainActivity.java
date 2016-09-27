package examples.my.com.lection_p2_l2;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {

	static {
		AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
			recreate();
		}

		Button bt = (Button)findViewById(R.id.button2);
		Button bt2 = (Button)findViewById(R.id.button3);
		bt2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				MainActivity.this.startActivity(new Intent(MainActivity.this, Activity2.class));
			}
		});

		bt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int currentNightMode = getResources().getConfiguration().uiMode
						& Configuration.UI_MODE_NIGHT_MASK;
				switch (currentNightMode) {
					case Configuration.UI_MODE_NIGHT_NO:
						getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
						break;
					case Configuration.UI_MODE_NIGHT_YES:
						getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
						break;
					case Configuration.UI_MODE_NIGHT_UNDEFINED:
						break;
				}
				recreate();
			}
		});


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
