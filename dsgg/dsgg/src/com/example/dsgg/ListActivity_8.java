package com.example.dsgg;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.kuguo.ad.KuguoAdsManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

@SuppressWarnings("SdCardPath")
public class ListActivity_8 extends Activity {
	Animation myAnimation;
	ImageView imageView1;
	private ViewFlipper viewFlipper;

    private float startX;

    private Animation enter_lefttoright;

    private Animation exit_lefttoright;

    private Animation enter_righttoleft;
    private Animation exit_righttoleft;
	private ListView myList;
	private List<Map<String, Object>> mData;
	String[] u = new String[]{
	"http://img.jdxi.net/upload/2012/8/201208211723067766.jpg",
	"http://img.jdxi.net/upload/2012/8/201208310809047643.jpg",
	"http://img.jdxi.net/upload/2012/8/201208310809486610.jpg",
	"http://img.jdxi.net/upload/2012/9/201209061659184406.jpg",
	
	"http://img.jdxi.net/upload/2012/9/201209041555473781.jpg",
	"http://img.jdxi.net/upload/2012/8/201208281705020321.jpg",
	"http://img.jdxi.net/upload/auto_save_image/2012/08/0929472Xa.jpg",
	"http://img.jdxi.net/upload/2012/8/201208310807498737.jpg",
	
	"http://img.jdxi.net/upload/auto_save_image/2012/08/082653YcG.jpg",
	"http://img.jdxi.net/upload/2012/8/201208131725460008.jpg",
	"http://img.jdxi.net/upload/2012/8/201208111727034580.jpg",
	"http://img.jdxi.net/upload/2012/8/201208011914024412.jpg",
	
	"http://img.jdxi.net/upload/2012/8/201208182148412357.jpg",
	"http://img.jdxi.net/upload/2012/8/201208271731272552.jpg",
	"http://img.jdxi.net/upload/2012/8/201208021707288606.jpg",
	"http://img.jdxi.net/upload/2012/9/201209061700035283.jpg",
	
	"http://img.jdxi.net/upload/2012/8/201208072153294614.jpg",
	"http://img.jdxi.net/upload/2012/8/201208011909307124.jpg",
	"http://img.jdxi.net/upload/2012/7/201207301733373205.jpg",
	"http://img.jdxi.net/upload/2012/7/201207271956165172.jpg",
	
	"http://img.jdxi.net/upload/2012/7/201207301732393087.jpg",
	"http://img.jdxi.net/upload/2012/8/201208031641337373.jpg",
	"http://img.jdxi.net/upload/2012/8/201208011910570086.jpg",
	"http://img.jdxi.net/upload/2012/8/201208011907524717.jpg",
	
	"http://img.jdxi.net/upload/2012/8/201208031638366254.jpg",
	"http://img.jdxi.net/upload/2012/8/201208141555530613.jpg",
	"http://img.jdxi.net/upload/2012/7/201207271956583660.jpg"};
	String fp = "/sdcard/evil/";
	String[] listTitle = new String[]{
			"抓犯人","机器人美肌斯","美肌斯的充电棒","师父的礼物",
			"想太多","性感奥运带操","睡美人","用心射箭",
			"通通小马","超人服","荒岛余生1","怨灵的真相","民宿",
			"性感白雪公主","牧羊女","春妮儿",
			"最后的教导","箱子的妙用","智斗","教鞭",
			"学艺","换瘤子","讲卫生","纹身苦恼","先忙正事","荒岛余生2","一分钱一分货",""};
	String[] n = new String[]{
			listTitle[0]+".jpg",listTitle[1]+".jpg",listTitle[2]+".jpg",
			listTitle[3]+".jpg",listTitle[4]+".jpg",listTitle[5]+".jpg",
			listTitle[6]+".jpg",listTitle[7]+".jpg",listTitle[8]+".jpg",
			listTitle[9]+".jpg",listTitle[10]+".jpg",listTitle[11]+".jpg",
			listTitle[12]+".jpg",listTitle[13]+".jpg",listTitle[14]+".jpg",
			listTitle[15]+".jpg",listTitle[16]+".jpg",listTitle[17]+".jpg",
			listTitle[18]+".jpg",listTitle[19]+".jpg",listTitle[20]+".jpg",
			listTitle[21]+".jpg",listTitle[22]+".jpg",listTitle[23]+".jpg",
			listTitle[24]+".jpg",listTitle[25]+".jpg",listTitle[26]+".jpg"};
	String[] p = new String[]{fp+n[0],fp+n[1],fp+n[2],fp+n[3],
fp+n[4],fp+n[5],fp+n[6],fp+n[7],
			fp+n[8],fp+n[9],fp+n[10],fp+n[11],fp+n[12],fp+n[13],fp+n[14],fp+n[15],fp+n[16],
			fp+n[17],fp+n[18],fp+n[19],fp+n[20],
			fp+n[21],fp+n[22],fp+n[23],fp+n[24],fp+n[25],fp+n[26]};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		enter_lefttoright = AnimationUtils.loadAnimation(this, R.anim.enter_lefttoright);
        exit_lefttoright = AnimationUtils.loadAnimation(this, R.anim.exit_lefttoright);
        enter_righttoleft = AnimationUtils.loadAnimation(this, R.anim.enter_righttoleft);
        exit_righttoleft = AnimationUtils.loadAnimation(this, R.anim.exit_righttoleft);
        
        viewFlipper = (ViewFlipper)findViewById(R.id.viewFilpper);
		myList = (ListView)findViewById(R.id.myListView);
		mData = getData();
		MyAdapter adapter = new MyAdapter(this);
		myList.setAdapter(adapter);
		myList.setOnItemClickListener(new OnItemClickListener(){

			@SuppressWarnings("unchecked")
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub				
				Intent intent1 = new Intent();			
				intent1.setClass(ListActivity_8.this, ImageActivity.class);										
				Bundle bl = new Bundle();
				bl.putString("path", p[arg2]);
				bl.putString("imageUrl", u[arg2]);
				bl.putString("fname",n[arg2]);
				bl.putString("fpath", fp);				
				intent1.putExtras(bl);
				startActivity(intent1);
			}
			
			
		});
		 KuguoAdsManager.getInstance().receivePushMessage(ListActivity_8.this, true);
		 KuguoAdsManager.getInstance().showKuguoSprite(this, 0);
		   
	     KuguoAdsManager.getInstance().showKuguoSprite(this, 1);

	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		
		for(int i=0;i<23;i++){
			Map<String, Object> map = new HashMap<String, Object>();
			 File file1 = new File(p[i]);
	        	if(file1.exists()){
	        		map.put("img", R.drawable.guren);
	        	}else{
	        		map.put("img", R.drawable.down_icon);
	        	}
			map.put("title", listTitle[i]);
			
			list.add(map);
			
		}
	
		return list;
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
	
	public final class ViewHolder{
		public ImageView img;
		public TextView title;
		public TextView info;
		public Button viewBtn;
	}


	
	public class MyAdapter extends BaseAdapter{

		private LayoutInflater mInflater;


		public MyAdapter(Context context){
			this.mInflater = LayoutInflater.from(context);
		}
		public int getCount() {
			// TODO Auto-generated method stub
			return mData.size();
		}

		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder = null;
			if (convertView == null) {

				holder=new ViewHolder();  

				convertView = mInflater.inflate(R.layout.vlist, null);
				holder.img = (ImageView)convertView.findViewById(R.id.img);
				holder.title = (TextView)convertView.findViewById(R.id.title);			
				convertView.setTag(holder);

			}else {

				holder = (ViewHolder)convertView.getTag();
			}


			holder.img.setBackgroundResource((Integer)mData.get(position).get("img"));
			holder.title.setText((String)mData.get(position).get("title"));
			//holder.info.setText((String)mData.get(position).get("info"));

//			holder.viewBtn.setOnClickListener(new View.OnClickListener() {
//
//				
//			});


			return convertView;
		}

	}




}