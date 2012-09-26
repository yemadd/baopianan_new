package com.xinggangasfkagk.kagkjgha;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.kuguo.ad.KuguoAdsManager;
import android.app.Activity;
import android.app.ProgressDialog;
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
	private ProgressDialog dialog=null;
    private float startX;

    private Animation enter_lefttoright;

    private Animation exit_lefttoright;

    private Animation enter_righttoleft;
    private Animation exit_righttoleft;
	private ListView myList;
	private List<Map<String, Object>> mData;
	String[] u = new String[]{
			"http://s1.dwstatic.com/group1/M00/7D/EC/370042fb083e699b5b9aab4955c09f7c.jpg",
			"http://s1.dwstatic.com/group1/M00/73/94/0a2ac9f4dc0dda771aa2e55a562774b7.jpg",
			"http://s1.dwstatic.com/group1/M00/98/20/f5cbfcde5cbfc6ad2c6492703c10864c.jpg",
			"http://s1.dwstatic.com/group1/M00/B9/35/951731dae40399b668208456f4c17437.jpg",			
			"http://s1.dwstatic.com/group1/M00/D4/8E/719343b6ff5b7b1ddc3c6bf8a6158680.jpg",
			"http://s1.dwstatic.com/group1/M00/10/94/6737085d6e220cfef2748af371eed4da.jpg",
			"http://s1.dwstatic.com/group1/M00/0B/6F/8dbdf6201af87470ff746757aefcb94b.jpg",
			"http://s1.dwstatic.com/group1/M00/B0/CF/d50cfbf594edc761572feb080db1aecf.jpg",		
			"http://s1.dwstatic.com/group1/M00/97/B6/0dc3417aa6f514fa93d5128e204ad276.jpg",
			"http://s1.dwstatic.com/group1/M00/26/12/8b97dcad1ef3d6b8c7efb0739fc197c4.jpg",
			
			"http://s1.dwstatic.com/group1/M00/43/0C/0c6b3fee185a9f36c2df30962687d235.jpg",
			"http://s1.dwstatic.com/group1/M00/9B/AB/a2498b783d643a4c55078d9b8420562b.jpg",			
			"http://s1.dwstatic.com/group1/M00/00/EB/529e0f594251a9cb308f1d73bbffeec1.jpg",
			"http://s1.dwstatic.com/group1/M00/3D/F2/2c8b7360d5e71ab80c23bf4dbb568311.jpg",
			"http://s1.dwstatic.com/group1/M00/46/D2/e122eb8d0279421710b38928e5571e11.jpg",
			"http://s1.dwstatic.com/group1/M00/7C/65/810540d5bcaefc9fd779e366f6cdda16.jpg",		
			"http://s1.dwstatic.com/group1/M00/F2/13/73f020f544ef74d32bc19734a8a10a57.jpg",
			"http://s1.dwstatic.com/group1/M00/80/20/88f03932e05378707d1b2ad70d0f5313.jpg",
			"http://s1.dwstatic.com/group1/M00/EC/0B/cd74af045f35fea98ea106f0e2d668ad.jpg",
			"http://s1.dwstatic.com/group1/M00/62/FA/faad76069152dd2f226dd8e86010d234.jpg",
			
			"http://s1.dwstatic.com/group1/M00/3D/AE/9f39c83ff6e07a74abe00391979ac4b2.jpg",
			"http://s1.dwstatic.com/group1/M00/8D/E2/c9bc019f02e8f8bdec3389416b342310.jpg",
			"http://s1.dwstatic.com/group1/M00/84/1D/0d5e797cf4bc2be59a35e4a71b6a97c6.jpg",
			"http://s1.dwstatic.com/group1/M00/83/F3/b16481085cb3283800ac20c16c6a1be2.jpg",			
			"http://s1.dwstatic.com/group1/M00/9C/A1/b6b53a29124c417d65c807aeeaa1e734.jpg",
			"http://s1.dwstatic.com/group1/M00/33/A7/2f22e409f798762546c9023d92694db2.jpg",
			"http://s1.dwstatic.com/group1/M00/B5/09/68040586ecd6a161432a5f1d0a345e98.jpg",
			"http://s1.dwstatic.com/group1/M00/A6/79/b34609d335720c5b9893ffbdf6ef7589.jpg",		
			"http://s1.dwstatic.com/group1/M00/83/92/be4d2b742788ae978c4216af98fe38c9.jpg",
			"http://s1.dwstatic.com/group1/M00/9E/46/bc5e64c4be12d2074024cc9f661c259a.jpg",
			
			"http://s1.dwstatic.com/group1/M00/14/AE/43068057ed0fcd3261f1b9e0aa594614.jpg",
			"http://s1.dwstatic.com/group1/M00/C6/F7/3b6d9a79851f9d6868f989affbea564a.jpg",	
			"http://s1.dwstatic.com/group1/M00/F7/E2/03274b00d30c5474cb0bb9f4ef4a0b90.jpg",
			"http://s1.dwstatic.com/group1/M00/5F/0E/80fc5f71b6d8e9a4c761876fc11c5edd.jpg",
			"http://s1.dwstatic.com/group1/M00/37/73/3f055bf5ebe5e8f91ae9223beb91df87.jpg",
			"http://s1.dwstatic.com/group1/M00/41/40/491d41be7889324907868f65a882f132.jpg",		
			"http://s1.dwstatic.com/group1/M00/46/41/e03031ee161eb7f4e51f02e23a44c531.jpg",
			"http://s1.dwstatic.com/group1/M00/60/56/1f665806ad995a10f9b90f17979dd7b1.jpg",
			"http://s1.dwstatic.com/group1/M00/6B/C0/9cddc597dd3e40b98b4ed49f889cf655.jpg",
			"http://s1.dwstatic.com/group1/M00/E4/A6/d6eda5c00aec0f1d6e153914814928b2.jpg",
			
			"http://s1.dwstatic.com/group1/M00/3D/4A/e06e360101c775f7f957da6670ff333b.jpg",
			"http://s1.dwstatic.com/group1/M00/2B/F1/6e8f58520e25dba25bb6e1f0c0ab2dd4.jpg"};
	String fp = "/sdcard/evil/";
	String name = "清新美女自然风采";

	String[] n = new String[]{
			name+1+".jpg",name+2+".jpg",name+3+".jpg",
			name+4+".jpg",name+5+".jpg",name+6+".jpg",
			name+7+".jpg",name+8+".jpg",name+9+".jpg",
			name+10+".jpg",name+11+".jpg",name+12+".jpg",
			name+13+".jpg",name+14+".jpg",name+15+".jpg",
			name+16+".jpg",name+17+".jpg",name+18+".jpg",
			name+19+".jpg",name+20+".jpg",name+21+".jpg",
			name+22+".jpg",name+23+".jpg",name+24+".jpg",
			name+25+".jpg",name+26+".jpg",name+27+".jpg",
			name+28+".jpg",name+29+".jpg",name+30+".jpg",
			name+31+".jpg",name+32+".jpg",name+33+".jpg",
			name+34+".jpg",name+35+".jpg",name+36+".jpg",
			name+37+".jpg",name+38+".jpg",name+39+".jpg",
			name+40+".jpg",name+41+".jpg",name+42+".jpg",};
	String[] p = new String[]{fp+n[0],fp+n[1],fp+n[2],fp+n[3],
fp+n[4],fp+n[5],fp+n[6],fp+n[7],
			fp+n[8],fp+n[9],fp+n[10],fp+n[11],fp+n[12],fp+n[13],fp+n[14],fp+n[15],fp+n[16],
			fp+n[17],fp+n[18],fp+n[19],fp+n[20],
			fp+n[21],fp+n[22],fp+n[23],fp+n[24],fp+n[25],fp+n[26],
			fp+n[27],fp+n[28],fp+n[29],fp+n[30],fp+n[31],fp+n[32],fp+n[33],fp+n[34],fp+n[35],
			fp+n[36],fp+n[37],fp+n[38],fp+n[39],
			fp+n[40],fp+n[41]};

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

		
		for(int i=0;i<41;i++){
			Map<String, Object> map = new HashMap<String, Object>();
			 File file1 = new File(p[i]);
	        	if(file1.exists()){
	        		map.put("img", R.drawable.ic_launch1);
	        	}else{
	        		map.put("img", R.drawable.down_icon);
	        	}
			map.put("title", n[i]);
			
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