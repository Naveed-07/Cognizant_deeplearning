package graphs;

public class Edge {
	private Vertex start;
	private Vertex end;
	private Integer weight;
	
	public Edge(Vertex startV ,Vertex endV, Integer inputweight) {
		this.start = startV;
		this.end = endV;
		this.weight = inputweight;
	}
	
	public Vertex getStart() {
		return this.start;
	}
	
	public Vertex getEnd() {
		return this.end;
	}
	
	public Integer getweight() {
		return this.weight;
	}
}
