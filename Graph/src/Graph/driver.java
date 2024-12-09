//Name: 	Mark Lambert, Darius Herdes
//Date: 	10/12/2024
//Purpose:	Data Structures & Algorithms Final Assessment 
//Main class
package Graph;

public class driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		
		//Node A
		g.addSite("Rock of Donamase", 52.637827, -6.7937563);
		//Node B
		g.addSite("O'Moore Park", 52.662661, -6.6598326);
		//Node C
		g.addSite("Donamase Art Centre", 52.690146, -6.650620);
		//Node D
		g.addSite("The Heath Golf Club", 52.682317, -6.581056);
		//Node E
		g.addSite("Emo Court", 52.637440, -6.622554);
		//Node F
		g.addSite("Portlaoise Herritage Hotel", 52.590639, -6.499220);
		
		//Print new line for interface purposes
		System.out.println();
		
	
		//Sample search calls
		g.search("Rock of Donamase");
		g.search("Portlaoise Herritage Hotel");
		g.search("Emo Court");		
		
		//Print new line for interface purposes
		System.out.println();
		
		
		//Insertion of node A associated edges
		g.insert("Rock of Donamase", "Emo Court", 7.71);
		g.insert("Rock of Donamase", "The Heath Golf Club", 2.41);
		g.insert("Rock of Donamase", "O'Moore Park", 3.68);
		
		//Insertion of node B associated edges
		g.insert("O'Moore Park", "Donamase Art Centre", 6.01);
		
		//Insertion of node C associated edges
		g.insert("Donamase Art Centre", "The Heath Golf Club", 5.52);
		g.insert("Donamase Art Centre", "Portlaoise Herritage Hotel", 8.42);
		
		//Insertion of node E associated edges
		g.insert("Emo Court", "Portlaoise Herritage Hotel", 9.97);
		
		//Remaining associations complete as un-dirrected graph completes the reverse association automatically
		
		g.allCons("Rock of Donamase");
		g.closest("Rock of Donamase");
	}

}
