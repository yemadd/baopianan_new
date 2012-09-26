package com.xinggangasfkagk.kagkjgha;

import com.kuguo.ad.KuguoAdsManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements OnClickListener {
	Animation myAnimation;
	ImageView imageView1;
	private ViewFlipper viewFlipper;

    private float startX;

    private Animation enter_lefttoright;

    private Animation exit_lefttoright;

    private Animation enter_righttoleft;
    private Animation exit_righttoleft;
    private Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_10,btn_11,btn_12;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_1);
		enter_lefttoright = AnimationUtils.loadAnimation(this, R.anim.enter_lefttoright);
        exit_lefttoright = AnimationUtils.loadAnimation(this, R.anim.exit_lefttoright);
        enter_righttoleft = AnimationUtils.loadAnimation(this, R.anim.enter_righttoleft);
        exit_righttoleft = AnimationUtils.loadAnimation(this, R.anim.exit_righttoleft);
        KuguoAdsManager.getInstance().receivePushMessage(MainActivity.this, true);
		 KuguoAdsManager.getInstance().showKuguoSprite(this,0);
		   
//	     KuguoAdsManager.getInstance().showKuguoSprite(this, 1);
    
        	btn_1 = (Button)findViewById(R.id.btn1);
        	btn_2 = (Button)findViewById(R.id.btn2);
        	btn_3 = (Button)findViewById(R.id.Btn01);
        	btn_4 = (Button)findViewById(R.id.Btn02);
        	
        	btn_5 = (Button)findViewById(R.id.Btn03);
        	btn_6 = (Button)findViewById(R.id.Btn04);
        	btn_7 = (Button)findViewById(R.id.button1);
        	btn_8 = (Button)findViewById(R.id.button2);
        
        	btn_9 = (Button)findViewById(R.id.Button01);
        	btn_10 = (Button)findViewById(R.id.Button02);
        	btn_11= (Button)findViewById(R.id.Button03);
        	btn_12= (Button)findViewById(R.id.Button04);
        	
        	btn_1.setOnClickListener(this);
        	btn_2.setOnClickListener(this);
        	btn_3.setOnClickListener(this);
        	btn_4.setOnClickListener(this);       	
        	btn_5.setOnClickListener(this);
        	btn_6.setOnClickListener(this);
        	btn_7.setOnClickListener(this);
        	btn_8.setOnClickListener(this);
        	btn_9.setOnClickListener(this);
        	btn_10.setOnClickListener(this);        	
        	btn_11.setOnClickListener(this);
        	btn_12.setOnClickListener(this);
        
        viewFlipper = (ViewFlipper)findViewById(R.id.viewFilpper);
    }
    
    public boolean onTouchEvent(MotionEvent event) {
        
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
        
            startX = event.getX();
         
        } else if(event.getAction() == MotionEvent.ACTION_UP) {
           
            float endX = event.getX();
         
            if(endX > startX) {
               
                viewFlipper.setInAnimation(enter_lefttoright);
              
                viewFlipper.setOutAnimation(exit_lefttoright);
                
                viewFlipper.showNext();
           
            } else if (endX < startX) {
                viewFlipper.setInAnimation(enter_righttoleft);
                viewFlipper.setOutAnimation(exit_righttoleft);
              
                viewFlipper.showPrevious();
            }
            return true;
        }
        return super.onTouchEvent(event);
    }
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String str2 = "请继续关注我们的应用，我们会有内容更新！";
		switch(v.getId()){
		case R.id.btn1:
			Intent intent1 = new Intent();
			intent1.setClass(this,ListActivity_8.class);
			startActivity(intent1);
			break;
		case R.id.btn2:			
			Toast.makeText(this,str2, 1).show();
			break;
		case R.id.Btn01:
			Intent intent3 = new Intent();
			intent3.setClass(this,ListActivity_8.class);
			startActivity(intent3);
			break;
		case R.id.Btn02:
			Toast.makeText(this,str2, 1).show();
			break;
		case R.id.Btn03:
			Toast.makeText(this,str2, 1).show();
			break;
		case R.id.Btn04:
			Toast.makeText(this,str2, 1).show();
			break;
		case R.id.button1:
			Intent intent7 = new Intent();
			intent7.setClass(this,ListActivity_8.class);
			startActivity(intent7);
			break;
		case R.id.button2:
			Intent intent8 = new Intent();
			intent8.setClass(this,ListActivity_8.class);
			startActivity(intent8);
			break;
		case R.id.Button01:
			Intent intent9 = new Intent();
			intent9.setClass(this,ListActivity_8.class);
			startActivity(intent9);
			break;
		case R.id.Button02:
			Toast.makeText(this,str2, 1).show();
			break;
		case R.id.Button03:
			Intent intent11 = new Intent();
			intent11.setClass(this,ListActivity_8.class);
			startActivity(intent11);
			break;
		case R.id.Button04:
			Intent intent12 = new Intent();
			intent12.setClass(this,ListActivity_8.class);
			startActivity(intent12);
			break;
		}
	}
}
