package com.example.btaptuan2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText edtNhap;
    TextView tvXuat;
    Button btnNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//int flag, int mask
        setContentView(R.layout.activity_main);

        //yeu cau 4
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        int n = 10;

        for(int i = 0; i<n; i++){
            numbers.add(random.nextInt(200));
        }
        String le = "";
        String chan = "";
        for (int i = 0; i<n; i++){
            if(numbers.get(i)%2 == 0){
                chan += numbers.get(i).toString() + ", ";
            }
            else{
                le += numbers.get(i).toString() + ", ";
            }
        }
        Log.d("Cac so ngau nhien: ", numbers.toString());
        Log.d("Cac so chan: ", chan);
        Log.d("Cac so le: ", le);

        //yeu cau 5
        edtNhap = findViewById(R.id.edtNhap);
        tvXuat = findViewById(R.id.tvXuat);
        btnNhan = findViewById(R.id.btnNhan);
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoi = edtNhap.getText().toString();
                tvXuat.setText("Bạn đã nhập:   " + chuoi);

                String chuoiNguoc = "";
                String[] array = chuoi.split(" ");
                for (int i = array.length-1; i>=0; i--){
                    chuoiNguoc += array[i] + " ";
                }
                Toast.makeText(MainActivity.this, chuoiNguoc, Toast.LENGTH_LONG).show();
            }
        });
    }
}