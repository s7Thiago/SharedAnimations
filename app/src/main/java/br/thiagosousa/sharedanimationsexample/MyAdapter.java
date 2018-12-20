package br.thiagosousa.sharedanimationsexample;																																																								
import android.widget.*;
import android.view.*;
import java.util.*;
import android.content.*;

public class MyAdapter extends BaseAdapter {
	
	private List<Item> lisItens;
	private Context context;

	public MyAdapter(List<Item> lisItens, Context context){
		this.lisItens = lisItens;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO: Implement this method
		return lisItens.size();
	}

	@Override
	public Object getItem(int p1) {
		// TODO: Implement this method
		return lisItens.get(p1);
	}

	@Override
	public long getItemId(int p1){
		// TODO: Implement this method
		return p1;
	}

	@Override
	public View getView(int p1, View p2, ViewGroup p3){
		Item item = (Item) getItem(p1);
		
		View linha;
		ViewHolder mHolder = null;
		
		//Reaproveitando a convertview, ou criando se não existir
		if(p2 == null) {
		linha = LayoutInflater.from(context).inflate(R.layout.list_item, p3, false);
		mHolder = new ViewHolder(linha);
		linha.setTag(mHolder);
		} else {
			linha = p2;
			mHolder = (ViewHolder) linha.getTag();
		}
		
		//Linkando as views
		mHolder.image.setImageResource(item.getImageID());
		mHolder.name.setText(item.getName());
		mHolder.description.setText(item.getDescription());
		
		// TODO: Implement this method
		return linha;
	}
	
}

class ViewHolder{
	ImageView image;
	TextView name;
	TextView description;

	public ViewHolder(View view)
{
		this.image = view.findViewById(R.id.list_itemImageView);
		this.name = view.findViewById(R.id.list_itemTextViewName);
		this.description = view.findViewById(R.id.list_itemTextViewDescription);
	}
	
	
}
