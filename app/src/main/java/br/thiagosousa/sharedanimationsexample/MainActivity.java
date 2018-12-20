package br.thiagosousa.sharedanimationsexample;

import android.app.*;
import android.os.*;
import android.widget.*;
import java.util.*;
import android.widget.AdapterView.*;
import android.view.*;
import android.content.*;
import android.util.*;

public class MainActivity extends Activity  implements OnItemClickListener {
	
	private ListView listView;
	private MyAdapter adapter;
	private List<Item> itens;
	private ImageView image;
	private TextView name;
	private TextView description;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		itens = gerarItens();
		
		listView = findViewById(R.id.mainListView);
		image = findViewById(R.id.list_itemImageView);
		name = findViewById(R.id.list_itemTextViewName);
		description = findViewById(R.id.list_itemTextViewDescription);
		
		adapter = new MyAdapter(itens, this);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		
    }
	
	@Override
	public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4) {
		// TODO: Implement this method
		switch(p3) {
			
			default:
			
			Toast.makeText(this, (p3 + 1) + "° item has clicked", Toast.LENGTH_SHORT).show();
			
			Intent i = new Intent(this, DetailActivity.class);
			i.putExtra("itemFromMainActivity", itens.get(p3));
			
			View view1 = p2.findViewById(R.id.list_itemImageView);
			View view2 = p2.findViewById(R.id.list_itemTextViewName);
			View view3 = p2.findViewById(R.id.list_itemTextViewDescription);
      View view4 = p2.findViewById(R.id.list_itemRelativeLayout);
			
			Pair<View, String> pair1 = Pair.create(view1, view1.getTransitionName());
			Pair<View, String> pair2 = Pair.create(view2, view2.getTransitionName());
			Pair<View, String> pair3 = Pair.create(view3, view3.getTransitionName());
      Pair<View, String> pair4 = Pair.create(view4, view4.getTransitionName());
			
			ActivityOptions options = ActivityOptions
			.makeSceneTransitionAnimation(this, pair1, pair2, pair3);
			startActivity(i, options.toBundle());
		}
	}
	
	public List<Item> gerarItens() {
		List<Item> innerItens= new ArrayList<>();
		
		for(int i = 0; i < 15000; i++) {
			
			Item item = new Item("item " + (i + 1), "this is the item " + (i + 1) + " of the collection", R.drawable.ic_launcher);
			item.setItemID(i);
			innerItens.add(item);
		}
		
		return innerItens;
	}
}
