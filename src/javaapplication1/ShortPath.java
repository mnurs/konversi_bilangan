package javaapplication1;
import java.util.*;
public class ShortPath {
    private int[] indexNode;
    String lokasiMin;
    int nilaiMin = 2000;
    private String[] lokasi;
    private Set<Integer> setNode;
    private PriorityQueue<Node> priorityQueue;
    private int jumlahIndex;
    List<List<Node> > listNode;
    
    public ShortPath(int index)
    {
        this.jumlahIndex = index;
        indexNode = new int[index];
        lokasi = new String[index];
        setNode = new HashSet<Integer>();
        priorityQueue = new PriorityQueue<Node>(index, new Node());
    }
 
    public void algoritmaDijkstra(List<List<Node>> listNode, int index)
    {
        this.listNode = listNode;
        for (int i = 0; i < jumlahIndex; i++) indexNode[i] = Integer.MAX_VALUE;
        priorityQueue.add(new Node(index, 0,"Wirosari"));
        indexNode[index] = 0;
        lokasi[index] = "Wirosari";
        while (setNode.size() != jumlahIndex) {
            if (priorityQueue.isEmpty()) return;
            int u = priorityQueue.remove().node;
            if (setNode.contains(u)) continue;
            setNode.add(u);
            menggantiLokasiTerdekat(u);
        }
    }
    
    private void menggantiLokasiTerdekat(int u)
    {
        String lokasiNode = "Wirosari";
        int dataLama = -1;
        int dataBaru = -1;
        for (int i = 0; i < listNode.get(u).size(); i++) {
            Node v = listNode.get(u).get(i);
            if (!setNode.contains(v.node)) {
                lokasiNode = v.lokasi;
                dataLama = v.jarak;
                dataBaru = indexNode[u] + dataLama;
                if (dataBaru < indexNode[v.node]){
                    indexNode[v.node] = dataBaru;
                    lokasi[v.node] = lokasiNode;
                }
                priorityQueue.add(new Node(v.node, indexNode[v.node],lokasi[v.node]));
            }
        }
    }
 
    public static void main(String arg[])
    {
        int jumlahIndex = 15;
        int nodeAwal = 0;
        String lokasi = "Wirosari";
        List<List<Node> > listNode = new ArrayList<List<Node> >();
        for (int i = 0; i < jumlahIndex; i++) {
            List<Node> item = new ArrayList<Node>();
            listNode.add(item);
        }        
        listNode.get(0).add(new Node(1, 400,"Warung Makan Mbak Ida"));
        listNode.get(0).add(new Node(1, 450,"Warung Makan Mbak Ida"));
        listNode.get(0).add(new Node(2, 350,"Warung makan PAK RAN wirosari"));
        listNode.get(0).add(new Node(2, 480,"Warung makan PAK RAN wirosari"));
        listNode.get(0).add(new Node(3, 300,"Warung Makan Mbak Sus Pecel"));
        listNode.get(0).add(new Node(4, 450,"Rumah Makan Mbah Kenci"));
        listNode.get(0).add(new Node(5, 450,"WM.mbah kenci mbak harni"));
        listNode.get(0).add(new Node(5, 460,"WM.mbah kenci mbak harni"));
        listNode.get(0).add(new Node(6, 290,"Kedai Makan"));
        listNode.get(0).add(new Node(7, 280,"Warung Lumayan"));
        listNode.get(0).add(new Node(8, 450,"Warung Sederhana"));
        listNode.get(0).add(new Node(9, 450,"Warung Makan Ungu"));
        listNode.get(0).add(new Node(9, 470,"Warung Makan Ungu"));
        listNode.get(0).add(new Node(10, 290,"ANGKRINGAN HARPINDO WIROSARI"));
        listNode.get(0).add(new Node(11, 850,"Rumah Makan Kauman-Wirosari"));
        listNode.get(0).add(new Node(12, 1000,"Warung sego Mak Tiah"));
        listNode.get(0).add(new Node(13, 900,"Warung Makan Mbak Han"));
        listNode.get(0).add(new Node(13, 700,"Warung Makan Mbak Han"));
        listNode.get(0).add(new Node(14, 1600,"Warung Makan Mutiara Mbak Par"));
        
        ShortPath shortPath = new ShortPath(jumlahIndex);
        shortPath.algoritmaDijkstra(listNode, nodeAwal);
        System.out.println("Jarak terdekat dari "+lokasi+" :");
        for (int i = 1; i < shortPath.indexNode.length; i++){
            System.out.println(lokasi + " ke " + shortPath.lokasi[i] 
                    + " adalah "+ shortPath.indexNode[i] + " m");
            if(shortPath.indexNode[i] < shortPath.nilaiMin){
                shortPath.nilaiMin = shortPath.indexNode[i];
                shortPath.lokasiMin = shortPath.lokasi[i];
            }
        }
        System.out.println("");
        System.out.println("Rumah makan terdekat dari "+shortPath.lokasi[0]+" adalah :");
        System.out.println(shortPath.lokasiMin+" Dengan jarak "+shortPath.nilaiMin+" m");
    }
}

class Node implements Comparator<Node> {
    public int node;
    public int jarak;
    public String lokasi;
    public Node() {}
    public Node(int node, int jarak,String lokasi)
    {
        this.node = node;
        this.jarak = jarak;
        this.lokasi = lokasi;
    }
    @Override public int compare(Node node1, Node node2)
    {  
        if (node1.jarak < node2.jarak) return -1;
        if (node1.jarak > node2.jarak) return 1;
        return 0;
    }
}