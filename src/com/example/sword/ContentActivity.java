package com.example.sword;




import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TextView;

public class ContentActivity extends TabActivity {
    /** Called when the activity is first created. */
	private TabHost tabHost;
	private TextView main_tab_new_message;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_content);
        
        main_tab_new_message=(TextView) findViewById(R.id.main_tab_new_message);
        main_tab_new_message.setVisibility(View.VISIBLE);
        main_tab_new_message.setText("10");
        
        tabHost=this.getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent=new Intent().setClass(this, Index.class);
        spec=tabHost.newTabSpec("��ҳ").setIndicator("��ҳ").setContent(intent);
        tabHost.addTab(spec);
        
        intent=new Intent().setClass(this,Word.class);
        spec=tabHost.newTabSpec("����").setIndicator("����").setContent(intent);
        tabHost.addTab(spec);
        
        intent=new Intent().setClass(this, My.class);
        spec=tabHost.newTabSpec("�ҵ�").setIndicator("�ҵ�").setContent(intent);
        tabHost.addTab(spec);
        
     
        intent=new Intent().setClass(this, Setting.class);
        spec=tabHost.newTabSpec("����").setIndicator("����").setContent(intent);
        tabHost.addTab(spec);
        tabHost.setCurrentTab(0);
        
        RadioGroup radioGroup=(RadioGroup) this.findViewById(R.id.main_tab_group);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.main_tab_addExam://���
					tabHost.setCurrentTabByTag("��ҳ");
					break;
				case R.id.main_tab_myExam://���ʻ���
					tabHost.setCurrentTabByTag("����");
					break;
				case R.id.main_tab_message://�ҵ�ѧϰ
					tabHost.setCurrentTabByTag("�ҵ�");
					break;
				case R.id.main_tab_settings://����
					tabHost.setCurrentTabByTag("����");
					break;
				default:
					//tabHost.setCurrentTabByTag("�ҵĿ���");
					break;
				}
			}
		});
    }
    
   
}