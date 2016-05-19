package com.example.sword.student;




import com.example.sword.R;
import com.example.sword.R.id;
import com.example.sword.R.layout;
import com.example.sword.teacher.Teacher_my;
import com.example.sword.teacher.Teacher_setting;
import com.example.sword.teacher.Teacher_word;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TextView;

public class Student_content extends TabActivity {
    /** Called when the activity is first created. */
	private TabHost tabHost;
	private TextView main_tab_new_message;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.teacher_content);
        
        main_tab_new_message=(TextView) findViewById(R.id.main_tab_new_message);
        main_tab_new_message.setVisibility(View.VISIBLE);
        main_tab_new_message.setText("10");
        
        tabHost=this.getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent=new Intent().setClass(this, Student_index.class);
        spec=tabHost.newTabSpec("首页").setIndicator("首页").setContent(intent);
        tabHost.addTab(spec);
        
        intent=new Intent().setClass(this,Student_word.class);
        spec=tabHost.newTabSpec("单词").setIndicator("单词").setContent(intent);
        tabHost.addTab(spec);
        
        intent=new Intent().setClass(this, Student_my.class);
        spec=tabHost.newTabSpec("我的").setIndicator("我的").setContent(intent);
        tabHost.addTab(spec);
        
     
        intent=new Intent().setClass(this, Student_setting.class);
        spec=tabHost.newTabSpec("设置").setIndicator("设置").setContent(intent);
        tabHost.addTab(spec);
        tabHost.setCurrentTab(0);
        
        RadioGroup radioGroup=(RadioGroup) this.findViewById(R.id.main_tab_group);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stubs
				switch (checkedId) {
				case R.id.main_tab_addExam://广告
					tabHost.setCurrentTabByTag("首页");
					break;
				case R.id.main_tab_myExam://单词汇总
					tabHost.setCurrentTabByTag("单词");
					break;
				case R.id.main_tab_message://我的学习
					tabHost.setCurrentTabByTag("我的");
					break;
				case R.id.main_tab_settings://设置
					tabHost.setCurrentTabByTag("设置");
					break;
				default:
					//tabHost.setCurrentTabByTag("我的考试");
					break;
				}
			}
		});
    }
    
   
}