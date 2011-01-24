package bullshit.mobile;

import java.util.Random;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Bullshit extends Activity {
    private String[] part1s;
	private String[] part2s;
	private String[] part3s;
	private String[] part4s;
	private TextView text;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        text = (TextView)findViewById(R.id.textview);
        
        Button button = (Button)findViewById(R.id.more);
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				text.setText(getBullShit());
			}
		});
        
        initResources();
        text.setText(getBullShit());
    }
    
    private void initResources() {
    	Resources res = getResources();
    	//TODO: should use a multidimensional array
    	part1s = res.getStringArray(R.array.part1);
    	part2s = res.getStringArray(R.array.part2);
    	part3s = res.getStringArray(R.array.part3);
    	part4s = res.getStringArray(R.array.part4);
    }
    
    private String getBullShit() {
    	Random generator = new Random();
    	return 
    		part1s[generator.nextInt(part1s.length)] + " " +
    		part2s[generator.nextInt(part2s.length)] + " " +
    		part3s[generator.nextInt(part3s.length)] + " " +
    		part4s[generator.nextInt(part4s.length)] + ".";
    }
}