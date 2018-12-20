package br.thiagosousa.sharedanimationsexample;
import java.io.*;

public class Item implements Serializable{
	private String name;
	private String description;
	private int imageID;
	private int itemID;

	public Item(String name, String description, int imageID)
	{
		this.name = name;
		this.description = description;
		this.imageID = imageID;
	}

	public void setItemID(int itemID)
	{
		this.itemID = itemID;
	}

	public int getItemID()
	{
		return itemID;
	}


	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}

	public void setImageID(int imageID)
	{
		this.imageID = imageID;
	}

	public int getImageID()
	{
		return imageID;
	}
}
