package com.example.sword;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
	UserDBHelper dbhelper;
	private EditText username, pwd, repwd;
	private Button next;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		dbhelper=new UserDBHelper(this);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);
		username = (EditText) findViewById(R.id.useremail);
		pwd = (EditText) findViewById(R.id.pwd);
		repwd = (EditText) findViewById(R.id.repwd);
		next = (Button) findViewById(R.id.next);

		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Bundle b=new Bundle();
				if(pwd.getText().toString().equals(repwd.getText().toString())){
				b.putString("username", username.getText().toString());
				b.putString("pwd", pwd.getText().toString());
				int i = dbhelper.insertUser(username.getText().toString(), pwd
						.getText().toString());

				if (i != 0)
					Toast.makeText(Register.this, "用户信息注册成功 ", 8000).show();
				else
					Toast.makeText(Register.this, "用户信息注册失败 ", 8000).show();
				
				Intent intent=new Intent(Register.this, Login.class);
				intent.putExtra("data", b);
				startActivity(intent);
				}else
					Toast.makeText(Register.this, "两次输入密码不一致，请重新输入 ", 8000).show();
			}

		});

	}
}