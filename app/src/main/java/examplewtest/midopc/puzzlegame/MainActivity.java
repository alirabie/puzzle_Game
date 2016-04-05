package examplewtest.midopc.puzzlegame;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;

        import java.util.List;
        import java.util.Random;


public class MainActivity extends AppCompatActivity {


            int CLICKS=0;
            final int CLOSEIMG=R.drawable.close;
            public static int score=0;
            public static int selected=0;
            public static int selectsd2=0;

            int []pics={R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
                    R.drawable.c6,R.drawable.c7,R.drawable.c8
            ,R.drawable.c9};



            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);


       final ImageView bt1=(ImageView)findViewById(R.id.b1);
        bt1.setBackgroundResource(R.drawable.close);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random=new Random();

                int rand=random.nextInt(7);
                bt1.setBackgroundResource(pics[rand]);

                selected=pics[rand];




                }

        });



        final ImageView bt2=(ImageView)findViewById(R.id.b2);
        bt2.setBackgroundResource(R.drawable.close);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int rand = random.nextInt(7);
                bt2.setBackgroundResource(pics[rand]);

                selectsd2 = pics[rand];

                if (selected == selectsd2) {

                    score++;
                    Log.d("Score**********", score + "");
                }
            }
        });

        final ImageView bt3=(ImageView)findViewById(R.id.b3);
        bt3.setBackgroundResource(R.drawable.close);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random=new Random();
                int rand=random.nextInt(7);
                bt3.setBackgroundResource(pics[rand]);
                selectsd2 = pics[rand];

                if (selected == selectsd2) {

                    score++;
                    Log.d("Score**********", score + "");
                }
            }
        });

        final ImageView bt4=(ImageView)findViewById(R.id.b4);
        bt4.setBackgroundResource(R.drawable.close);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random=new Random();
                int rand=random.nextInt(7);
                bt4.setBackgroundResource(pics[rand]);
                selectsd2 = pics[rand];

                if (selected == selectsd2) {

                    score++;
                    Log.d("Score**********", score + "");
                }
            }
        });


        final ImageView bt5=(ImageView)findViewById(R.id.b5);
        bt5.setBackgroundResource(R.drawable.close);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random=new Random();
                int rand=random.nextInt(7);
                bt5.setBackgroundResource(pics[rand]);
                selectsd2 = pics[rand];

                if (selected == selectsd2) {

                    score++;
                    Log.d("Score**********", score + "");
                }
            }
        });

        final ImageView bt6=(ImageView)findViewById(R.id.b6);
        bt6.setBackgroundResource(R.drawable.close);
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random=new Random();
                int rand=random.nextInt(7);
                bt6.setBackgroundResource(pics[rand]);
                selectsd2 = pics[rand];

                if (selected == selectsd2) {

                    score++;
                    Log.d("Score**********", score + "");
                }
            }
        });


        final ImageView bt7=(ImageView)findViewById(R.id.b7);
        bt7.setBackgroundResource(R.drawable.close);
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random=new Random();
                int rand=random.nextInt(7);
                bt7.setBackgroundResource(pics[rand]);
                selectsd2 = pics[rand];

                if (selected == selectsd2) {

                    score++;
                    Log.d("Score**********", score + "");
                }
            }
        });

        final ImageView bt8=(ImageView)findViewById(R.id.b8);
        bt8.setBackgroundResource(R.drawable.close);
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random=new Random();
                int rand=random.nextInt(7);
                bt8.setBackgroundResource(pics[rand]);
                selectsd2 = pics[rand];

                if (selected == selectsd2) {

                    score++;
                    Log.d("Score**********", score + "");
                }
            }
        });


        final ImageView bt9=(ImageView)findViewById(R.id.b9);
        bt9.setBackgroundResource(R.drawable.close);
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random=new Random();
                int rand=random.nextInt(7);
                bt9.setBackgroundResource(pics[rand]);
                selectsd2 = pics[rand];

                if (selected == selectsd2) {

                    score++;
                    Log.d("Score**********", score + "");
                }
            }
        });


    }
}
