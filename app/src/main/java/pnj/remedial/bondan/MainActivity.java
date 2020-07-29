package pnj.remedial.bondan;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button actionLogin;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences=getSharedPreferences("user", MODE_PRIVATE);

        if(sharedPreferences.getBoolean("isLogin",false)) {
            Intent intent = new Intent(this,HalamanUtama.class);
            startActivity(intent);
            finish();
        }

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        actionLogin = findViewById(R.id.actionLogin);
        actionLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fungsi
                login();
            }
        });
    }

    void login (){
        if (edtUsername.getText().toString().equals("bondan")&&
                edtPassword.getText().toString().equals("123") ) {
            //fungsi
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isLogin", true);
            editor.putString("email","bondansatrio99@gmail.com");
            editor.putString("nim","4817070443");
            editor.putString("nama","Bondan Satrio");
            editor.putString("kelas","TI-6C");
            editor.commit();

            Intent intent = new Intent(this,HalamanUtama.class);
            startActivity(intent);
            finish();

        } else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage("Terjadi Kesalahan ");
            dialog.setTitle("Error");
            dialog.show();
        }
    }

}