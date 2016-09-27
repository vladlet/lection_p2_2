package examples.my.com.lection_p2_l2;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static android.R.id.home;

/**
 * Created by vlad on 27/09/16.
 */

public class Activity2 extends AppCompatActivity {

	private BottomSheetBehavior mBottomSheetBehavior;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actitvity2);

		View bottomSheet = findViewById( R.id.bottom_sheet );
		Button button1 = (Button) findViewById( R.id.button_1 );
		Button button2 = (Button) findViewById( R.id.button_2 );
		Button button3 = (Button) findViewById( R.id.button_3 );

		View.OnClickListener clickListener = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				switch( v.getId() ) {
					case R.id.button_1: {
						mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
					}
					break;
					case R.id.button_2: {
						mBottomSheetBehavior.setPeekHeight(300);
						mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
					}
					break;
					case R.id.button_3: {
						BottomSheetDialogFragment bottomSheetDialogFragment = new TutsPlusBottomSheetDialogFragment();
						bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
					}
					break;
				}
			}
		};

		button1.setOnClickListener(clickListener);
		button2.setOnClickListener(clickListener);
		button3.setOnClickListener(clickListener);

		mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

		mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
			@Override
			public void onStateChanged(View bottomSheet, int newState) {
				if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
					mBottomSheetBehavior.setPeekHeight(0);
				}
			}

			@Override
			public void onSlide(View bottomSheet, float slideOffset) {
			}
		});
	}



}
