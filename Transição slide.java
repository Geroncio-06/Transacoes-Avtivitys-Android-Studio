

--------------------------------------- SLIDE TRANSICTION ACTIVITY ---------------------------------------


1 - Crie uma pasta em res:

	-> new 'Directory Resource File' com nome 'anim'
		-> em 'anim' crie 3 'Animation Resource File'

			- 'slide_in_right': slide pela direta

			- 'slide_in_right': slide pela esquerda

			- 'stop_in_x': parado no eixo horizontal


2 - slide_in_right

 		<?xml version="1.0" encoding="utf-8"?>
		<set xmlns:android="http://schemas.android.com/apk/res/android">

    		<translate android:duration="@android:integer/config_mediumAnimTime"
        		android:fromXDelta="100%p"
        		android:toXDelta="0%p"/>

		</set>

3 - slide_in_left

		<?xml version="1.0" encoding="utf-8"?>
		<set xmlns:android="http://schemas.android.com/apk/res/android">

    		<translate android:duration="@android:integer/config_mediumAnimTime"
        		android:fromXDelta="-100%p"
        		android:toXDelta="0%p""/>

		</set>


4 - stop_in_x

		<?xml version="1.0" encoding="utf-8"?>
		<set xmlns:android="http://schemas.android.com/apk/res/android">

    		<translate android:duration="@android:integer/config_mediumAnimTime"
        		android:fromXDelta="-0%p"
        		android:toXDelta="0%p""/>

		</set>


5 - em Activity



		public class MainActivity extends AppCompatActivity {

    			
    			Button btnsub;


    		@Override
    		protected void onCreate(Bundle savedInstanceState) {
        		super.onCreate(savedInstanceState);
        		setContentView(R.layout.activity_main);


 				btnsub = findViewById(R.id.btnsub);
        			
// entrar com slide pela direita ---------------------------------------------------------------------------------------------

	btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.stop_in_x);

                        



            }
        });

// entrar com slide pela direita --------------------------------------------------------------------------------------------------


    			}

		}



-------------------------------------------------------outras animações ------------------------------------------------------------------------


// entrar com slide pela esquerda ---------------------------------------------------------------------------------------------

	btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_left,R.anim.stop_in_x);

                        

// entrar com slide pela esquerda --------------------------------------------------------------------------------------------------
