package com.example.dsgg;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
public class ImageActivity extends Activity implements OnTouchListener {
	//implements OnTouchListener {
    private ImageView imgview;
    private ImageView img;
	private ProgressDialog dialog = null;
    
    private Matrix matrix=new Matrix();
    private Matrix savedMatrix=new Matrix();
    
    static final int NONE = 0;  
    static final int DRAG = 1;  
    static final int ZOOM = 2;  
    int mode = NONE;  

    // Remember some things for zooming  
    PointF start = new PointF();  
    PointF mid = new PointF();  
    float oldDist = 1f;  
    Bundle bl;
	Intent intent;
	String fname,path,imageUrl,fpath;
    
    //private GestureDetector gesture;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.imagectrl);
		//获取到上一个页面传过来的Intent
				intent=this.getIntent();
				//获取Intent中的Bundle数据
				bl=intent.getExtras();
				 fname=bl.getString("fname");
				 path=bl.getString("path");
			     imageUrl=bl.getString("imageUrl");
			     fpath = bl.getString("fpath");
			     System.out.println(fname);
			     System.out.println(path);
			     System.out.println(imageUrl);
			     System.out.println(fpath);
		imgview=(ImageView)this.findViewById(R.id.imag);
		downloadImage();
		dialog=new ProgressDialog(this);
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		dialog.setIndeterminate(false);
		dialog.setCancelable(true);
		dialog.setMessage("图片加载中，稍等片刻...");
		dialog.show();
		new Thread(){
		public void run(){
			try{
				sleep(1500);
			}catch(InterruptedException e){
				
			}
			finally{
				dialog.dismiss();
			}
		}
	}.start();

		//imgview.setAnimation(AnimationUtils.loadAnimation(this, R.anim.newanim));
		
		
		img=(ImageView)this.findViewById(R.id.imag);
		Matrix mt=img.getImageMatrix();	
		//mt.postRotate(30);
		mt.postScale(0.5f,0.5f);mt.postScale(1.5f,1.5f);
		//mt.postRotate(30, 130, 100);
	    mt.postTranslate(100, 10);
		
		img.setImageMatrix(mt);
		
	
		//imgview.setLongClickable(true);
		
		//imgview.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.xieer_1));
		imgview.setOnTouchListener(this);
		imgview.setLongClickable(true);
		
	}
	
	private float spacing(MotionEvent event) {  
        float x = event.getX(0) - event.getX(1);  
        float y = event.getY(0) - event.getY(1);  
        return FloatMath.sqrt(x * x + y * y);  
}  

 
      private void midPoint(PointF point, MotionEvent event) {  
        float x = event.getX(0) + event.getX(1);  
        float y = event.getY(0) + event.getY(1);  
        point.set(x / 2, y / 2);  
}  


	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		/*
		Log.d("Infor", "类别:"+event.getAction());
		Log.d("Infor", "mask:"+event.getActionMasked());
		Log.d("Infor", "index:"+event.getActionIndex());
		Log.d("Infor", "points:"+event.getPointerCount());*/
	    Log.d("Infor", "size:"+event.getSize());
	    if(event.getActionMasked()==MotionEvent.ACTION_POINTER_UP)
	    	Log.d("Infor", "多点操作");
	    switch(event.getActionMasked()){
	    case MotionEvent.ACTION_DOWN:
	    	  matrix.set(imgview.getImageMatrix());
	    	  savedMatrix.set(matrix);
	    	  start.set(event.getX(),event.getY());
	    	  Log.d("Infor", "触摸了...");
	    	  mode=DRAG;
	          break;
	    case MotionEvent.ACTION_POINTER_DOWN:  //多点触控
	    	 oldDist=this.spacing(event);
	        if(oldDist>10f){
	    	 Log.d("Infor", "oldDist"+oldDist);
	         savedMatrix.set(matrix);
	    	 midPoint(mid,event);
	    	 mode=ZOOM;
	        }
	        break;
	    case MotionEvent.ACTION_POINTER_UP:
	    	mode=NONE;
	        break;
	    case MotionEvent.ACTION_MOVE:
	    	if(mode==DRAG){         //此实现图片的拖动功能...
	    		matrix.set(savedMatrix);
	    	    matrix.postTranslate(event.getX()-start.x, event.getY()-start.y);
	    	}
	    	    else if(mode==ZOOM){// 此实现图片的缩放功能...
	    	 float newDist=spacing(event);
	    	 if(newDist>10){
	    		 matrix.set(savedMatrix);
	    		 float scale=newDist/oldDist;
	    		 matrix.postScale(scale, scale, mid.x, mid.y);	    		 
	    	 }
	    	    }
	    	break;
	    }
	    imgview.setImageMatrix(matrix);
		return false;
	}	
	private void downloadImage(){

	       String filePath= imageUrl;

	       @SuppressWarnings("unused")
		String imgName = fname;

	         //使用【方法1】取得的是InputStream，直接从InputStream生成bitmap

	        try{
	        	  File file1 = new File(path);
	        	if(file1.exists()){
	        		 Bitmap bm = BitmapFactory.decodeFile(path);
	                    //由File获取图片并转为Bitmap

	                   imgview.setImageBitmap(bm);
	        	}else{

	            Bitmap bitmap = BitmapFactory.decodeStream(getImageStream(filePath));

	            if(bitmap!=null){

	                saveFile(bitmap, fname);  //调用保存方法
	              
	            

	                File file2 = new File(path);

	                if(file2.exists()){     //判断文件是否存在

	                    Bitmap bm = BitmapFactory.decodeFile(path);
	                    //由File获取图片并转为Bitmap

	                   imgview.setImageBitmap(bm);

	                }

	            }

	        }
	        }

	        catch(Exception e) {            
	            Toast.makeText(ImageActivity.this,"下载图片失败，请查看网络状态！", Toast.LENGTH_SHORT).show();  

	            e.printStackTrace();

	        }

	       

	    }

	   

	    //方法1

	    public InputStream getImageStream(String path)throws Exception{     

	        URL url = new URL(path);     

	        HttpURLConnection conn =(HttpURLConnection) url.openConnection();     

	        conn.setConnectTimeout(5*1000);        //设定超时

	        conn.setRequestMethod("GET");   //GET为下载，POST为上传

	        if(conn.getResponseCode()== HttpURLConnection.HTTP_OK){     

	            return conn.getInputStream();         //获得数据流  

	        }     

	        return null;   

	    } 

	   

	    //方法2

	    public byte[] getImage(String path) throws Exception{     

	        URL url = new URL(path);     

	        HttpURLConnection conn =(HttpURLConnection) url.openConnection();     

	        conn.setConnectTimeout(5*1000);   

	        conn.setRequestMethod("GET");    

	        InputStream inStream = conn.getInputStream(); 

	        if(conn.getResponseCode()== HttpURLConnection.HTTP_OK){     

	            return readStream(inStream);     

	        }     

	        return null;     

	    }    

	    public static byte[] readStream(InputStream inStream)throws Exception{     

	        ByteArrayOutputStream outStream = new ByteArrayOutputStream();     

	        byte[]buffer =new byte[1024];     

	        int len =0;     

	        while((len=inStream.read(buffer)) != -1){     

	            outStream.write(buffer, 0, len);     

	        }     

	        outStream.close();     

	        inStream.close();     

	        return outStream.toByteArray();     

	    }   

	   

	    //保存Bitmap为图片文件

	    public void saveFile(Bitmap bitmap, String fileName) throws IOException {  

	        File dirFile = new File(fpath);  

	        if(!dirFile.exists()){  //判断路径是否存在，不存在则创建

	            dirFile.mkdir();  

	        }

	        File savePath = new File(fpath + fileName);  //保存路径

	        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(savePath));  

	        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bos);  //质量压缩为80%

	        bos.flush();  

	        bos.close();  

	    }

}