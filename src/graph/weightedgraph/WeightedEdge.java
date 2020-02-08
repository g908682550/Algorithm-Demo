package graph.weightedgraph;

public class WeightedEdge implements Comparable<WeightedEdge> {

    int v,w,weight;

    public WeightedEdge(int v,int w,int weight){
        this.v=v;
        this.w=w;
        this.weight=weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    @Override
    public String toString(){
        return String.format("%d-%d: %d",v,w,weight);
    }

    @Override
    public int compareTo(WeightedEdge o) {
         return weight-o.weight;
    }
}
