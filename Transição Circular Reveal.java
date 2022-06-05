

--------------------------------------- TRANSIÇÃO CIRCULAR REVEAL ------------------------------------


1 - Criamos duas Atidades:

	- MainActivity ; activity_main

	- Main2Activity ; activity_main2



2 - Editamos os Layouts 1 e 2:

	2.1 activity_main: ------ acrescentamos -------------------------------------------------------

		android:background="@color/yellow" 
    		
	    .... tools:context=".MainActivity"> ..... esse já vem

									


	2.2 activity_main2: ------ acrescentamos -------------------------------------------------------

		android:background="@color/white"
    		android:id="@+id/background"

	    .... tools:context=".Main2Activity"> ..... esse já vem




									// background do layout2 é opcional




3 - Acrescentamos em colors:

			<color name="transparente">#00000000</color>




4 - Acrescentamos em theme:
		
    


    		<style name="Theme.Transparente" parent="Theme.AppCompat.Light.NoActionBar">
        		<!-- Customize your theme here. -->

                         <!-- Primary brand color. -->
        			<item name="colorPrimary">@color/purple_500</item>
        			<item name="colorPrimaryVariant">@color/purple_700</item>
        			<item name="colorOnPrimary">@color/white</item>
        		<!-- Secondary brand color. -->
       				 <item name="colorSecondary">@color/teal_200</item>
        			 <item name="colorSecondaryVariant">@color/teal_700</item>
        			 <item name="colorOnSecondary">@color/black</item>



			\\ ----------------- Sem esses codigos a animação circular, apareceria sobre 
			\\ ----------------- um layout branco, e não sobre a activity_main. E esse trecho 
			\\ ----------------- passa esse layout branco para transparente, aparecendo assim 
			\\ ----------------- o layout activity_main por baixo e criando a ilusão perfeita da animação circular reveal;


        		<item name="android:windowIsTranslucent">true</item>
        		<item name="android:statusBarColor">@color/transparente</item>
        		<item name="android:windowBackground">@color/transparente</item>

			\\ ----------------------------------------------------------------------------
        
        		<item name="android:windowTranslucentNavigation">true</item> 			\\ Barra de Navegação Translucida
        		<item name="android:windowTranslucentStatus">true</item>			\\ Barra de Status Translucida


    		</style>





5 - Em Manifest substituimos:


			<activity android:name=".Main2Activity"></activity>

		POR:

			<activity android:name=".Main2Activity"
            			android:screenOrientation="portrait"
            			android:theme="@style/Theme.Transparente"></activity>


												// portrait é para impedir que a tela mude ao virar o smartphone



6 - Crie uma pasta em res:


	-> new 'Directory Resource File' com nome 'anim'
		-> em 'anim' crie um 'Animation Resource File'


			- do_not_move;


				6.1 do_not_move

					<?xml version="1.0" encoding="utf-8"?>
					<set xmlns:android="http://schemas.android.com/apk/res/android">
    						
						<translate android:duration="@android:integer/config_mediumAnimTime"
        						android:toYDelta="0"
        						android:fromYDelta="0"
        						android:toXDelta="0"
        						android:fromXDelta="0"/>
					</set>




7 - MainActivity



		Button btnsub;



	---------------------- Em onCreate ------------------------------------------------------------------------------


		btnsub = findViewById(R.id.btnsub);

		btnsub.setOnClickListener(new View.OnClickListener() {
            		@Override
            		public void onClick(View view) {

                		startActivity(new Intent(MainActivity.this, Main2Activity.class));     // Chamando Atividade 2

            		}
        	});





8 - MainActivity2


	private View background;   						// id do Layout 2 - activity_main2



	---------------------- Em onCreate --------------------------------------------------------------------------------------


		overridePendingTransition(R.anim.do_not_move,R.anim.do_not_move);

        	background = findViewById(R.id.background);



		if (savedInstanceState == null){

            		background.setVisibility(View.INVISIBLE);

            		final ViewTreeObserver viewTreeObserver = background.getViewTreeObserver();

	
			// viewtreeObserver são usados para registrar notificações de mudança nos Listener na Arvore de View.
			// queremos iniciar uma atividade com uma animação diferente, mas o sistema já tinha uma animação preparada
			// então notificamos a mudança, e adicionamos outra pelo 'addOnGlobalLayoutListener'. 



            		if(viewTreeObserver.isAlive()){     					// isAlive indica se este viewTreeObserver esta ativo

                		viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    			@Override
                    			public void onGlobalLayout() {
                        			circularRevealActivity();					      // chamamos o metodo com a animação nova
                        			background.getViewTreeObserver().removeOnGlobalLayoutListener(this);  // exclui a chamada preparada pelo sistema.
                    			}
                		});

            		}

        	}

		---------------------- Fora de onCreate ----------------------------------------------------------------------------------------------------


			private void circularRevealActivity() {

        			int cx = background.getWidth()/2;
        			int cy = background.getHeight()/2; 					


	// altura do objeto a ser animado '/2' começa do meio, se background.getHeight() = 100, entao background.getHeight()/2  = 50

	// se background.getHeight() = 100, entao 2*background.getHeight()/3  = 66

	// cx e cy vão marcar da onde vai iniciar a animação no objeto, aqui no caso o layout.





        			float finalRadius = Math.max(background.getWidth(), background.getHeight());

        			Animator circularReveal = ViewAnimationUtils.createCircularReveal(
                			background,
                			cx,
                			cy,
                			0,				//começa a partir do raio 0, 
                			finalRadius);


        			circularReveal.setDuration(1000);
        			background.setVisibility(View.VISIBLE);
        			circularReveal.start();			
    			}








	