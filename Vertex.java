package graphs;
import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	private final String data;
	final List<Edge> edges;
	
	public Vertex(final String data){
		
		this.data = data;
		this.edges = new ArrayList<Edge>();
	}	
	public void addEdge(final Vertex endvertex , final Integer weight) {
		this.edges.add(new Edge(this, endvertex ,weight));
	}
	public void removeEdge(final Vertex endvertex) {
		this.edges.removeIf(edge -> edge.getEnd().equals(endvertex));//predicate logic of java //doubt
	}
	public String getData() {
		return this.data;
	}
	public List<Edge> getEdges(){
		return this.edges;
	}
	public void print (final boolean showWeight) {
		
		if (this.edges.size() == 0) {
			System.out.println(this.data + " -> ");
			return;
		}
		
		final StringBuffer sb = new StringBuffer();
		sb.append(this.data + " --> ");
		
		for(int i = 0; i < this.edges.size();++i) {
			sb.append(this.edges.get(i).getEnd().data);
			
			if(showWeight) {
				sb.append("(" + this.edges.get(i).getweight()+ ")");	
			}
			sb.append(", ");
			
		}
		sb.deleteCharAt(sb.length() - 1);
		
		String answer = sb.toString();
		System.out.println(answer);
	}
	 
}
	
	

