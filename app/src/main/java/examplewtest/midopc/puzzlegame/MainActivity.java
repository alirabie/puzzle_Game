package examplewtest.midopc.puzzlegame;

        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.drawable.BitmapDrawable;
        import android.graphics.drawable.Drawable;
        import android.media.MediaPlayer;
        import android.os.CountDownTimer;
        import android.preference.DialogPreference;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.view.Window;
        import android.view.WindowManager;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.Collections;
        import java.util.List;
        import java.util.Random;
        import java.util.Timer;


public class MainActivity extends AppCompatActivity {

    public static int score = 0;
    final int CLOSEIMG = R.drawable.close;
    public static TextView score1;
    public static TextView timer;
    public ImageView bt1;
    public ImageView bt2;
    public ImageView bt3;
    public ImageView bt4;
    public ImageView bt5;
    public ImageView bt6;
    public ImageView bt7;
    public ImageView bt8;
    public ImageView bt9;


    int n1, n2, n3, n4, n5, n6, n7, n8, n9;

    int[] pics = {R.drawable.c1,
                  R.drawable.c1,
                  R.drawable.c3,
                  R.drawable.c3,
                  R.drawable.c5,
                  R.drawable.c5,
                  R.drawable.c7,
                  R.drawable.c7,
                  R.drawable.c9};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        score1 = (TextView) findViewById(R.id.score);
        timer=(TextView)findViewById(R.id.timer);
        getIntent().setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        //Game Music
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mediaPlayer.start();

        //Random Numbers List
        ArrayList<Integer> nums = new ArrayList<Integer>();

        nums.add(0);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(8);
        Collections.shuffle(nums);


        n1 = nums.get(0);
        n2 = nums.get(1);
        n3 = nums.get(2);
        n4 = nums.get(3);
        n5 = nums.get(4);
        n6 = nums.get(5);
        n7 = nums.get(6);
        n8 = nums.get(7);
        n9 = nums.get(8);



    //Show Photos Timer
    new CountDownTimer(3000,1000){
    public void onTick(long millisUntilFinished) {
        bt1.setBackgroundResource(pics[n1]);
        bt2.setBackgroundResource(pics[n2]);
        bt3.setBackgroundResource(pics[n3]);
        bt4.setBackgroundResource(pics[n4]);
        bt5.setBackgroundResource(pics[n5]);
        bt6.setBackgroundResource(pics[n6]);
        bt7.setBackgroundResource(pics[n7]);
        bt8.setBackgroundResource(pics[n8]);
        bt9.setBackgroundResource(pics[n9]);
    }
    public void onFinish() {
        bt1.setBackgroundResource(CLOSEIMG);
        bt2.setBackgroundResource(CLOSEIMG);
        bt3.setBackgroundResource(CLOSEIMG);
        bt4.setBackgroundResource(CLOSEIMG);
        bt5.setBackgroundResource(CLOSEIMG);
        bt6.setBackgroundResource(CLOSEIMG);
        bt7.setBackgroundResource(CLOSEIMG);
        bt8.setBackgroundResource(CLOSEIMG);
        bt9.setBackgroundResource(CLOSEIMG);
    }

   }.start();




        //Game Timer

        new CountDownTimer(100000,1000){

            public void onTick(long millisUntilFinished) {

                timer.setText(millisUntilFinished/1000+"");

            }
            public void onFinish() {
                //AlertDialog for Close or Open new Game
             new AlertDialog.Builder(MainActivity.this)
                     .setTitle("Game over")
                     .setMessage("Time Out").setIcon(R.drawable.err)
                     .setPositiveButton("Try again ", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             score = 0;
                             finish();
                             getIntent().setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                             startActivity(getIntent());

                         }
                     })
                     .setNegativeButton("Exit Game", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             finish();

                         }
                     }).show();


            }
        }.start();


//Image 1

        bt1 = (ImageView) findViewById(R.id.b1);
        bt1.setBackgroundResource(CLOSEIMG);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt1.setBackgroundResource(pics[n1]);
                if (compare(bt1,bt2)||compare(bt1,bt3)||compare(bt1,bt4)||compare(bt1,bt5)||compare(bt1,bt6)||compare(bt1,bt7)||compare(bt1,bt8)||compare(bt1,bt9))
                    score++;
                score1.setText(score + "");

                new CountDownTimer(3000,1000){

                    public void onTick(long millisUntilFinished) {

                    }
                    public void onFinish() {
                        bt1.setBackgroundResource(R.drawable.close);

                    }



                }.start();

                if(score==4){

                    new AlertDialog.Builder(MainActivity.this).setTitle("Congratulations").setMessage("Good Job").setIcon(R.drawable.good).setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            score = 0;
                            finish();
                            startActivity(getIntent());

                        }
                    })

                            .setNegativeButton("Exit Game", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                }




            }
        });

//Image 2

        bt2 = (ImageView) findViewById(R.id.b2);
        bt2.setBackgroundResource(R.drawable.close);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bt2.setBackgroundResource(pics[n2]);
                if (compare(bt2,bt1)||compare(bt2,bt3)||compare(bt2,bt4)||compare(bt2,bt5)||compare(bt2,bt6)||compare(bt2,bt7)||compare(bt2,bt8)|| compare(bt2, bt9))
                    score++;
                score1.setText(score + "");

                Log.d("GOOOOOOOOOOOOOOOOOOd", score + "");

                new CountDownTimer(3000,1000){

                    public void onTick(long millisUntilFinished) {

                    }
                    public void onFinish() {

                        bt2.setBackgroundResource(R.drawable.close);



                    }



                }.start();

                if(score==4){

                    new AlertDialog.Builder(MainActivity.this).setTitle("Congratulations").setMessage("Good Job").setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            score=0;
                            finish();
                            startActivity(getIntent());

                        }
                    })

                            .setNegativeButton("Exit Game", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                              android.os.Process.killProcess(android.os.Process.myPid());
                                }
                            }).show();
                }



            }
        });

//Image 3

        bt3 = (ImageView) findViewById(R.id.b3);
        bt3.setBackgroundResource(R.drawable.close);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                bt3.setBackgroundResource(pics[n3]);
                if (compare(bt3,bt2)||compare(bt3,bt1)||compare(bt3,bt4)||compare(bt3,bt5)||compare(bt3,bt6)||compare(bt3,bt7)||compare(bt3,bt8)||compare(bt3,bt9))
                    score++;


                score1.setText(score+"");

                Log.d("GOOOOOOOOOOOOOOOOOOd", score + "");
                new CountDownTimer(3000,1000){

                    public void onTick(long millisUntilFinished) {

                    }
                    public void onFinish() {

                        bt3.setBackgroundResource(R.drawable.close);


                    }



                }.start();
                if(score==4){

                    new AlertDialog.Builder(MainActivity.this).setTitle("Congratulations").setMessage("Good Job").setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            score=0;
                            finish();
                            startActivity(getIntent());

                        }
                    })

                            .setNegativeButton("Exit Game", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                }


            }
        });

//Image 4

        bt4 = (ImageView) findViewById(R.id.b4);
        bt4.setBackgroundResource(R.drawable.close);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                bt4.setBackgroundResource(pics[n4]);
                if (compare(bt4,bt2)||compare(bt4,bt3)||compare(bt4,bt1)||compare(bt4,bt5)||compare(bt4,bt6)||compare(bt4,bt7)||compare(bt4,bt8)||compare(bt4,bt9))
                    score++;
                score1.setText(score+"");

                Log.d("GOOOOOOOOOOOOOOOOOOd", score + "");
                new CountDownTimer(3000,1000){

                    public void onTick(long millisUntilFinished) {

                    }
                    public void onFinish() {

                        bt4.setBackgroundResource(R.drawable.close);



                    }



                }.start();

                if(score==4){

                    new AlertDialog.Builder(MainActivity.this).setTitle("Congratulations").setMessage("Good Job").setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            score=0;
                            finish();
                            startActivity(getIntent());

                        }
                    })

                            .setNegativeButton("Exit Game", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                }

            }
        });

//Image 5

        bt5 = (ImageView) findViewById(R.id.b5);
        bt5.setBackgroundResource(R.drawable.close);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                bt5.setBackgroundResource(pics[n5]);
                if (compare(bt5,bt2)||compare(bt5,bt3)||compare(bt5,bt4)||compare(bt5,bt1)||compare(bt5,bt6)||compare(bt5,bt7)||compare(bt5,bt8)||compare(bt5,bt9))
                    score++;
                score1.setText(score+"");

                Log.d("GOOOOOOOOOOOOOOOOOOd", score + "");
                new CountDownTimer(3000,1000){

                    public void onTick(long millisUntilFinished) {

                    }
                    public void onFinish() {

                        bt5.setBackgroundResource(R.drawable.close);


                    }



                }.start();

                if(score==4){

                    new AlertDialog.Builder(MainActivity.this).setTitle("Congratulations").setMessage("Good Job").setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            score=0;
                            finish();
                            startActivity(getIntent());

                        }
                    })

                            .setNegativeButton("Exit Game", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                }

            }
        });

//image 6

        bt6 = (ImageView) findViewById(R.id.b6);
        bt6.setBackgroundResource(R.drawable.close);
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                bt6.setBackgroundResource(pics[n6]);
                if (compare(bt6,bt2)||compare(bt6,bt3)||compare(bt6,bt4)||compare(bt6,bt5)||compare(bt6,bt1)||compare(bt6,bt7)||compare(bt6,bt8)||compare(bt6,bt9))
                    score++;
                score1.setText(score+"");

                Log.d("GOOOOOOOOOOOOOOOOOOd", score + "");
                new CountDownTimer(3000,1000){

                    public void onTick(long millisUntilFinished) {

                    }
                    public void onFinish() {

                        bt6.setBackgroundResource(R.drawable.close);


                    }



                }.start();

                if(score==4){

                    new AlertDialog.Builder(MainActivity.this).setTitle("Congratulations").setMessage("Good Job").setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            score=0;
                            finish();
                            startActivity(getIntent());

                        }
                    })

                            .setNegativeButton("Exit Game", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                }

            }
        });

//Image 7

        bt7 = (ImageView) findViewById(R.id.b7);
        bt7.setBackgroundResource(R.drawable.close);
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bt7.setBackgroundResource(pics[n7]);
                if (compare(bt7,bt2)||compare(bt7,bt3)||compare(bt7,bt4)||compare(bt7,bt5)||compare(bt7,bt1)||compare(bt7,bt1)||compare(bt7,bt8)||compare(bt7,bt9))
                    score++;
                score1.setText(score+"");

                Log.d("GOOOOOOOOOOOOOOOOOOd", score + "");
                new CountDownTimer(3000,1000){

                    public void onTick(long millisUntilFinished) {

                    }
                    public void onFinish() {

                        bt7.setBackgroundResource(R.drawable.close);



                    }



                }.start();

                if(score==4){

                    new AlertDialog.Builder(MainActivity.this).setTitle("Congratulations").setMessage("Good Job").setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            score=0;
                            finish();
                            startActivity(getIntent());

                        }
                    })

                            .setNegativeButton("Exit Game", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                }
            }
        });

//Image 8

        bt8 = (ImageView) findViewById(R.id.b8);
        bt8.setBackgroundResource(R.drawable.close);
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bt8.setBackgroundResource(pics[n8]);
                if (compare(bt8,bt2)||compare(bt8,bt3)||compare(bt8,bt4)||compare(bt8,bt5)||compare(bt8,bt6)||compare(bt8,bt7)||compare(bt1,bt8)||compare(bt8,bt9))
                    score++;
                score1.setText(score+"");

                Log.d("GOOOOOOOOOOOOOOOOOOd", score + "");
                new CountDownTimer(3000,1000){

                    public void onTick(long millisUntilFinished) {

                    }
                    public void onFinish() {

                        bt8.setBackgroundResource(R.drawable.close);



                    }



                }.start();

                if(score==4){

                    new AlertDialog.Builder(MainActivity.this).setTitle("Congratulations").setMessage("Good Job").setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            score=0;
                            finish();
                            startActivity(getIntent());

                        }
                    })

                            .setNegativeButton("Exit Game", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                }


            }
        });

//Image 9

        bt9 = (ImageView) findViewById(R.id.b9);
        bt9.setBackgroundResource(R.drawable.close);
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                bt9.setBackgroundResource(pics[n9]);
                if (compare(bt9,bt2)||compare(bt9,bt3)||compare(bt9,bt4)||compare(bt9,bt5)||compare(bt9,bt6)||compare(bt9,bt7)||compare(bt9,bt8)||compare(bt1,bt9))
                    score++;
                score1.setText(score+"");

                Log.d("GOOOOOOOOOOOOOOOOOOd", score + "");
                new CountDownTimer(3000,1000){

                    public void onTick(long millisUntilFinished) {

                    }
                    public void onFinish() {

                        bt9.setBackgroundResource(R.drawable.close);


                    }



                }.start();

                if(score==4){

                    new AlertDialog.Builder(MainActivity.this).setTitle("Congratulations").setMessage("Good Job").setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            score=0;
                            finish();
                            startActivity(getIntent());

                        }
                    })

                            .setNegativeButton("Exit Game", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                }
            }
        });


        Log.d("Alfooo", bt1.getBackground().getConstantState() + "");
        Log.d("Alfooo", bt2.getBackground().getConstantState() + "");
        Log.d("Alfooo", bt3.getBackground() .getConstantState()+ "");
        Log.d("Alfooo", bt4.getBackground().getLevel() + "");






    }

   // Compare Photos

    public Boolean compare(ImageView v1, ImageView v2) {

        if(v1.getBackground().getConstantState()==v2.getBackground().getConstantState())
        {

            v1.setBackgroundResource(R.drawable.good);
            v2.setBackgroundResource(R.drawable.good);
            return true;
        }
        else
          return false;

    }

    @Override
    public void onPause() {
        super.onPause();

        // Remove the activity when its off the screen

        android.os.Process.killProcess(android.os.Process.myPid());
    }

}






