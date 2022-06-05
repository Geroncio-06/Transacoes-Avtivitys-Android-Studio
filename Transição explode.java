

-------------------------------- ANIMATION EXPLODE ---------------------------------

1 - Crie uma pasta em res:

	-> new 'Directory Resource File' com nome 'anim'
		-> em 'anim' crie dois 'Animation Resource File'

			- 'uptodown': de cima para baixo

			- 'downtoup': de baixo para cima


2 - uptodown

 		<?xml version="1.0" encoding="utf-8"?>
		<set xmlns:android="http://schemas.android.com/apk/res/android">

    		<translate android:duration="800"
        		android:fromYDelta="-100%p"
        		android:toYDelta="0%p"/>

		</set>

3 - downtoup

		<?xml version="1.0" encoding="utf-8"?>
		<set xmlns:android="http://schemas.android.com/apk/res/android">

    		<translate android:duration="800"
        		android:fromYDelta="100%p"
        		android:toYDelta="0%p""/>

		</set>


4 - em Activity



		public class MainActivity extends AppCompatActivity {

    			LinearLayout b11, b12;  			// objeto a ser animado, não necessariamente tem que ser sempre um Layout.
    			Animation uptodown, downtoup;
    			Button btnsub;


    		@Override
    		protected void onCreate(Bundle savedInstanceState) {
        		super.onCreate(savedInstanceState);
        		setContentView(R.layout.activity_main);


 				btnsub = findViewById(R.id.btnsub);
        			b11 = findViewById(R.id.b11);
        			b12 = findViewById(R.id.b12);

        			uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        			downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);


        			b11.setAnimation(uptodown);
        			b12.setAnimation(downtoup);

// sair com explosão ---------------------------------------------------------------------------------------------

	btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.in_uptodown);
                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.in_downtoup);
                b11.startAnimation(animation);
                b12.startAnimation(animation2);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                        finish();

                        b11.setVisibility(View.INVISIBLE);
                        b12.setVisibility(View.INVISIBLE);
                    }
                },600);

// sair com explosão --------------------------------------------------------------------------------------------------

            }
        });


    			}

		}




---------------------------------------- OUTRAS ANIMAÇÕES -------------------------------------------------------------------



			- 'lefttoright': da esquerda para direita

			- 'righttoleft': da direita para esquerda


			- 'dlefttoright_uptodown': da diagonal esquerda para direita, e de cima para baixo

			- 'drighttoleft_uptodown': da diagonal direita para esquerda, e de cima para baixo


			- 'dlefttoright_downtoup': da diagonal esquerda para direita, e de baixo para cima

			- 'drighttoleft_downtoup': da diagonal direita para esquerda, e de baixo para cima




2 - lefttoright

 		<?xml version="1.0" encoding="utf-8"?>
		<set xmlns:android="http://schemas.android.com/apk/res/android">

    		<translate android:duration="800"
        		android:fromXDelta="-100%p"
        		android:toXDelta="0%p"/>

		</set>

3 - righttoleft

		<?xml version="1.0" encoding="utf-8"?>
		<set xmlns:android="http://schemas.android.com/apk/res/android">

    		<translate android:duration="800"
        		android:fromXDelta="100%p"
        		android:toXDelta="0%p"/>

		</set>


4 - dlefttoright_uptodown

 		<?xml version="1.0" encoding="utf-8"?>
		<set xmlns:android="http://schemas.android.com/apk/res/android">

    		<translate android:duration="800"
        		android:fromXDelta="-100%p"
        		android:toXDelta="0%p"
			android:fromXDelta="-100%p"
        		android:toXDelta="0%p"/>

		</set>


5 - drighttoleft_uptodown

		<?xml version="1.0" encoding="utf-8"?>
		<set xmlns:android="http://schemas.android.com/apk/res/android">

    		<translate android:duration="800"
        		android:fromXDelta="100%p"
        		android:toXDelta="0%p""
			android:fromXDelta="-100%p"
        		android:toXDelta="0%p"/>

		</set>




4 - dlefttoright_downtoup

 		<?xml version="1.0" encoding="utf-8"?>
		<set xmlns:android="http://schemas.android.com/apk/res/android">

    		<translate android:duration="800"
        		android:fromXDelta="-100%p"
        		android:toXDelta="0%p"
			android:fromYDelta="100%p"
        		android:toYDelta="0%p""/>

		</set>


5 - drighttoleft_downtoup

		<?xml version="1.0" encoding="utf-8"?>
		<set xmlns:android="http://schemas.android.com/apk/res/android">

    		<translate android:duration="800"
        		android:fromXDelta="100%p"
        		android:toXDelta="0%p""
			android:fromYDelta="100%p"
        		android:toYDelta="0%p""/>

		</set>

