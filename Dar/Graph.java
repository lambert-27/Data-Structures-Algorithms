class Site {
    String name;
    Edge[] neighbors; // array to store edges
    int neighborCount;

    // constructor only takes the name
    public Site(String name) {
        this.name = name;
        this.neighbors = new Edge[10]; // fixed size
        this.neighborCount = 0;
    }

    // add a neighbor
    public void addNeighbor(Site target, double weight) {
        if (neighborCount < neighbors.length) {
            neighbors[neighborCount++] = new Edge(target, weight);
        } else {
            System.out.println("no space for more neighbors in " + name);
        }
    }
}

class Edge {
    Site target;
    double weight;

    // edge constructor
    public Edge(Site target, double weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class Graph {
    Site[] sites; // array to store all sites
    int siteCount;

    // graph constructor
    public Graph() {
        this.sites = new Site[10]; // fixed size
        this.siteCount = 0;
    }

    // add a new site
    public void addSite(String name) {
        if (siteCount < sites.length) {
            sites[siteCount++] = new Site(name);
        } else {
            System.out.println("no space for more sites.");
        }
    }

    // find a site by name
    public Site findSite(String name) {
        for (int i = 0; i < siteCount; i++) {
            if (sites[i].name.equals(name)) {
                return sites[i];
            }
        }
        return null;
    }

    // add a connection between two sites
    public void insert(String site1Name, String site2Name, double weight) {
        Site site1 = findSite(site1Name);
        Site site2 = findSite(site2Name);

        if (site1 == null || site2 == null) {
            System.out.println("one or both sites not found");
            return;
        }

        site1.addNeighbor(site2, weight);
        site2.addNeighbor(site1, weight); // bidirectional connection
    }

    // search for a site and show its details
    public void search(String siteName) {
        Site site = findSite(siteName);

        if (site == null) {
            System.out.println("site not found");
            return;
        }

        System.out.println("site name: " + site.name);
        System.out.println("neighbors:");
        for (int i = 0; i < site.neighborCount; i++) {
            Edge edge = site.neighbors[i];
            System.out.println(" -> " + edge.target.name + " (distance: " + edge.weight + ")");
        }
    }
}