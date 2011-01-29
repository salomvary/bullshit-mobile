package bullshit.mobile;

import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Bullshit extends Activity {
    private String[] part1;
	private String[] part2;
	private String[] part3;
	private String[] part4;
	private TextView text;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        text = (TextView)findViewById(R.id.textview);
        
        OnClickListener listener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				text.setText(getBullShit());
			}
		};
        View main = findViewById(R.id.main);
        main.setOnClickListener(listener);
        Button button = (Button)findViewById(R.id.more);
        button.setOnClickListener(listener);
        
        initResources();
        text.setText(getBullShit());
    }
    
    private void initResources() {
    	Resources res = getResources();
    	//TODO: should use a multidimensional array
    	part1 = res.getStringArray(R.array.part1);
    	part2 = res.getStringArray(R.array.part2);
    	part3 = res.getStringArray(R.array.part3);
    	part4 = res.getStringArray(R.array.part4);
    }
    
    private String getBullShit() {
    	Random generator = new Random();
    	return 
    		part1[generator.nextInt(part1.length)] + " " +
    		part2[generator.nextInt(part2.length)] + " " +
    		part3[generator.nextInt(part3.length)] + " " +
    		part4[generator.nextInt(part4.length)] + ".";
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
		case R.id.about_menu:
			about();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
    }

	private void about() {
		showDialog(R.layout.about_dialog);
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		//no switch because we only have one dialog
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.about_dialog);
		dialog.setTitle(R.string.about_title);
		dialog.findViewById(R.id.layout_root).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		return dialog;
	}
}