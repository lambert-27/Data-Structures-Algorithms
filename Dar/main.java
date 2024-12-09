public class main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // add sites
        graph.addSite("Rock of Donamase");
        graph.addSite("O'Moore Park");
        graph.addSite("Donamase Art Centre");
        graph.addSite("The Heath Golf Club");
        graph.addSite("Emo Court");
        graph.addSite("Portlaoise Heritage Hotel");

        // add edges
        graph.insert("Rock of Donamase", "O'Moore Park", 3.68);
        graph.insert("Rock of Donamase", "The Heath Golf Club", 2.41);
        graph.insert("Rock of Donamase", "Emo Court", 7.71);
        graph.insert("O'Moore Park", "Donamase Art Centre", 6.01);
        graph.insert("Donamase Art Centre", "Portlaoise Heritage Hotel", 8.42);
        graph.insert("The Heath Golf Club", "Donamase Art Centre", 5.52);
        graph.insert("Emo Court", "Portlaoise Heritage Hotel", 9.97);

        // search for sites
        graph.search("Rock of Donamase");
        graph.search("Emo Court");

        // try searching for a nonexistent site
        graph.search("Nonexistent Site");
    }
}
