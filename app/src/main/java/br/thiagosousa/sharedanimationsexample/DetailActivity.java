package br.thiagosousa.sharedanimationsexample;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.content.*;
import android.view.*;

public class DetailActivity extends Activity {
	
	private Item item;
	private ImageView image;
	private TextView name;
	private TextView description;
	private LinearLayout container;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		image = findViewById(R.id.list_itemImageView);
		name = findViewById(R.id.list_itemTextViewName);
		description = findViewById(R.id.list_itemTextViewDescription);
		container = findViewById(R.id.activity_detailMainLinearLayout);
		
		//Ocultando a barra de ação
		getActionBar().hide();
		
		item = (Item) getIntent().getSerializableExtra("itemFromMainActivity");
		
		definirAparenciaEExibir(item);
		
	}
	
	public void preencherTela() {
		image.setImageResource(item.getImageID());
		name.setText(item.getName());
		description.setText(item.getDescription());
    container.setGravity(Gravity.CENTER);
	}
	
	public void definirAparenciaEExibir(Item item) {
		
		//se 2|id
		if((item.getItemID() + 1) % 2 == 0) {
			
			//se 3|id
			if((((item.getItemID() + 1 ) % 3) == 0)) {
				preencherTela();
				container.setBackgroundResource(android.R.color.holo_green_light);
			//se apenas 2|id
			} else {
			preencherTela();
			container.setBackgroundResource(android.R.color.holo_red_dark);
			}
			//se 3|id
		}else if((item.getItemID() + 1) % 3 == 0){
			preencherTela();
			container.setBackgroundResource(android.R.color.holo_orange_dark);
			
			//se nanhuma das opcoes
		} else {
			preencherTela();

		}
	}
}
