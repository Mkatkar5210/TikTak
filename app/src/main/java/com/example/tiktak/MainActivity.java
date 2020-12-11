package com.example.tiktak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
int term=0;
//1:cross,0:o,2=empty
    boolean gameactive=true;
    int activeplayer=2;
int[] all={2,2,2,2,2,2,2,2,2};
int[][] winnerlist={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
@SuppressLint("WrongConstant")
public void clicked(View view) {
    Button retryy=(Button)findViewById(R.id.button);
        TextView result=(TextView)findViewById(R.id.textView);
    String getresult = null;
        ImageView image=(ImageView)view;
        int tag=Integer.parseInt(image.getTag().toString());
       if(all[tag]==2&&gameactive) {

           if (term == 0) {
               image.setImageResource(R.drawable.o);
               term = 1;
               all[tag]=0;
               activeplayer=0;
           } else if (term == 1) {
               image.setImageResource(R.drawable.croos);
               term = 0;
               all[tag]=1;
               activeplayer=1;
           }

       }

       for(int[] list:winnerlist)
       {
           if(all[list[0]]==all[list[1]]&&all[list[1]]==all[list[2]]&&all[list[0]]!=2) {
               gameactive = false;

               if (activeplayer == 0) {
                   getresult = "O WIN THE MATCH";
               }else if(activeplayer==1){
                   getresult="CROSS WIN THE MATCH";
               }
               result.setText(getresult);
               result.setVisibility(View.VISIBLE);
               retryy.setVisibility(View.VISIBLE);
               Vibrator vibs = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
               vibs.vibrate(1000);
           }
       }
    }

public void retry(View view)
{
    Button retryy=(Button)findViewById(R.id.button);
    TextView result=(TextView)findViewById(R.id.textView);
    result.setVisibility(View.INVISIBLE);
    retryy.setVisibility(View.INVISIBLE);
    GridLayout grid=(GridLayout) findViewById(R.id.grid);
    gameactive=true;
    term=0;
    gameactive=true;
    activeplayer=2;
    all= new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};

for(int i=0;i<grid.getChildCount();i++){

    ImageView counter=(ImageView)grid.getChildAt(i);
    counter.setImageDrawable(null);
}

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}










