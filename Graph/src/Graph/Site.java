//Name: 	Mark Lambert, Darius Herdes
//Date: 	10/12/2024
//Purpose:	Data Structures & Algorithms Final Assessment 
//Class for Site Objects, allowing us to store extra information (name, coordinates, siteIndex etc)
package Graph;

public class Site {
	private String name;
	//Length 2; 0 for x, 1 for y
	private double coords[] = new double[2];
	private int siteIndex;
	private static int count = 0;
	
	//Constructors
	public Site() 
	{
		setName("");
		setCoOrds(0,0);
	}
	
	public Site(String name, double x, double y) 
	{
		setName(name);
		setCoOrds(x, y);
		setIndex();
	}
	
	//Set name of a site
	public void setName(String name) 
	{
		this.name = name;
	}
	
	//Returns the name of a site
	public String getName() 
	{
		return name;
	}
	
	//Methods to get coordinates
	public double getX() {
		return coords[0];
	}
	
	public double getY() {
		return coords[1];
	}
	
	//Method to set coordinates for Site
	public void setCoOrds(double x, double y) 
	{
		//Index 0 = x coords
		coords[0] = x;
		//Index 1 = y coords
		coords[1] = y;
	}
	
	//Method used to set the index of the site 
	public void setIndex() 
	{
		siteIndex = count;
		count++;
	}
	
	public int getIndex() 
	{
		return siteIndex;
	}
	
	public String toString() 
	{
		return "-------------Site Search Details-------------" + 
				"\nSite Name:	 	" + name + 
				"\nCo-ordinates (x,y): "+ coords[0] + ", " + coords[1]; 
	}
}
