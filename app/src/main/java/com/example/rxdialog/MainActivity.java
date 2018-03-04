package com.example.rxdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyRxDialog(MainActivity.this)
                        .setTitle("title")
                        .setMessage("Message")
                        .setView(R.layout.layout_dialog_view)
                        .clickView(R.id.text)
                        .setPositiveText("确定")
                        .setNegativeText("取消")
                        .setNeutralText("中立")
                        .dialogToObservable()
                        //.dialogToFlowable()
                        .subscribe(new Consumer<Integer>() {
                            @Override
                            public void accept(Integer integer) throws Exception {
                                switch (integer){
                                    case MyRxDialog.POSITIVE:
                                        Toast.makeText(MainActivity.this, "Positive", Toast.LENGTH_SHORT).show();
                                        break;
                                    case MyRxDialog.NEGATIVE:
                                        Toast.makeText(MainActivity.this, "Negative", Toast.LENGTH_SHORT).show();
                                        break;
                                    case MyRxDialog.NEUTRAL:
                                        Toast.makeText(MainActivity.this, "Neutral", Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.text:
                                        Toast.makeText(MainActivity.this, "点击了TextView", Toast.LENGTH_SHORT).show();
                                        break;
                                    default:
                                        Log.e("MyRxDialog", integer+"");
                                        break;
                                }
                            }
                        });
            }
        });
    }
}
