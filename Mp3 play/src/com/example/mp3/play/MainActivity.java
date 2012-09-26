package com.example.mp3.play;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Themes.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        
      }

      public void onClick(View v)
      {
        switch (v.getId())
        {
        case R.id.button1:
          Themes.changeToTheme(this, 1);
          break;
        case R.id.button2:
          Themes.changeToTheme(this, 2);
          break;
        case R.id.button3:
          Themes.changeToTheme(this, 3);
          break;
        }
        
      }
    
}
