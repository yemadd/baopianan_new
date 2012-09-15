package com.example.dsgg;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class ListActivity_1 extends Activity {
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
	"http://img.jdxi.net/upload/2012/9/201209011610355146.jpg",
	"http://s1.dwstatic.com/group1/M00/F1/A3/e2d68941c6c267dbdfea8f7abfe98ed7.jpg",
	"http://s1.dwstatic.com/group1/M00/72/9F/7783121a0841e01a33212b8d593f363b.jpg",
	"http://img.jdxi.net/upload/2012/8/201208261706232213.jpg",
	"http://img.jdxi.net/upload/2012/8/201208202044145446.jpg",
	"http://s1.dwstatic.com/group1/M00/72/DC/6ddaec83183246f5cdeec89cbef7d9a9.jpg",
	"http://s1.dwstatic.com/group1/M00/FD/2F/524af7b72a97e8aa14c65d8804dace13.jpg",
	"http://pic10.bengou.com/comicdata/sx/sxjtlzbr12022714/1331021139638/1331021139638.jpg",
	"http://pic10.bengou.com/comicdata/sx/sxjtlzbr12022714/1330323252360/1330323252858.jpg",
	"http://pic10.bengou.com/comicdata/sx/sxjtlzbr12022714/1330323252360/1330323252360.jpg",
	"http://pic10.bengou.com/comicdata/sx/sxjtlzbr12022714/1330323252360/1330323253144.jpg",
	"http://s1.dwstatic.com/group1/M00/B8/22/2fcb102334fa576b3ebdbc2c02264b84.jpg",
	"http://s1.dwstatic.com/group1/M00/44/7C/491e79b6e6152ff771f5ff91d12fa0f6.jpg",
	"http://s1.dwstatic.com/group1/M00/3F/1A/71fdff00aa83a633fb70bd45d33b71ed.jpg",
	"http://s1.dwstatic.com/group1/M00/9D/F5/638b6067e02387bfe390e464b75819d8.jpg",
	"http://s1.dwstatic.com/group1/M00/15/F0/3df14a6202619dc07a6b8ee38d3b9476.jpg",
	"http://s1.dwstatic.com/group1/M00/9B/ED/5d95b804d493fd70b502ba2dc8378d1e.jpg",
	"http://s1.dwstatic.com/group1/M00/DC/DE/765541319e54c50cfdd11f61acccfa6b.jpg",
	"http://s1.dwstatic.com/group1/M00/5F/13/af21d3d3b1abeca42b5e25e6c34cc24a.jpg",
	"http://s1.dwstatic.com/group1/M00/23/81/5ce6d878703de27329f81b5a1c1f29b9.jpg",
	"http://s1.dwstatic.com/group1/M00/23/D1/bbba2a2b7cac6e87df68ce1debf378b0.jpg",
	"http://s1.dwstatic.com/group1/M00/49/46/2dc607015cba6ff5a64ffb7756529464.jpg",
	"http://img.jdxi.net/upload/auto_save_image/2012/08/093801uB3.jpg",
	"http://img.jdxi.net/upload/2012/9/201209061657118868.jpg"};
	String fp = "/sdcard/evil/";
	String[] listTitle = new String[]{
			"消暑","神奇的洞洞","白炽灯的辛苦","使用时间停止术",
			"师父与徒弟","女泰山的救助","胸大哪都吃香","决斗原则",
			"独特的她","过河","我的爱人是料理师","海边性感王","你是怎么知道的",
			"看见美女以后的反应","使用产品前一定要阅读说明书","法术也有副作用",
			"给人带来幸福的排水口","如何为女友挑选泳衣","正确的教学方式","该出手时就该出手",
			"拜师","笔记是不能这么写的！","诱惑","战术"};
	String[] n = new String[]{
			listTitle[0]+".jpg",listTitle[1]+".jpg",listTitle[2]+".jpg",
			listTitle[3]+".jpg",listTitle[4]+".jpg",listTitle[5]+".jpg",
			listTitle[6]+".jpg",listTitle[7]+".jpg",listTitle[8]+".jpg",
			listTitle[9]+".jpg",listTitle[10]+".jpg",listTitle[11]+".jpg",
			listTitle[12]+".jpg",listTitle[13]+".jpg",listTitle[14]+".jpg",
			listTitle[15]+".jpg",listTitle[16]+".jpg",listTitle[17]+".jpg",
			listTitle[18]+".jpg",listTitle[19]+".jpg",listTitle[20]+".jpg",
			listTitle[21]+".jpg",listTitle[22]+".jpg",listTitle[23]+".jpg"};
	String[] p = new String[]{fp+n[0],fp+n[1],fp+n[2],fp+n[3],
fp+n[4],fp+n[5],fp+n[6],fp+n[7],
			fp+n[8],fp+n[9],fp+n[10],fp+n[11],fp+n[12],fp+n[13],fp+n[14],fp+n[15],fp+n[16],
			fp+n[17],fp+n[18],fp+n[19],fp+n[20],
			fp+n[21],fp+n[22],fp+n[23]};
	
	String listText=null;
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
				intent1.setClass(ListActivity_1.this, ImageActivity.class);										
				Bundle bl = new Bundle();
				bl.putString("path", p[arg2]);
				bl.putString("imageUrl", u[arg2]);
				bl.putString("fname",n[arg2]);
				bl.putString("fpath", fp);				
				intent1.putExtras(bl);
				startActivity(intent1);
				
				

			}
			
			
		});
		

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