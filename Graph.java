package graphs;
import java.util.ArrayList;

public class Graph {
	
	private ArrayList<Vertex> vertices;
	private boolean isWeighted;
	private boolean isDirected;
	
	public Graph(boolean inputIsweighted, boolean inputisDirected) {
		this.vertices = new ArrayList<Vertex>();
		this.isWeighted = inputIsweighted;
		this.isDirected = inputisDirected;
	}
	
	public Vertex addVertex(String data) {
		Vertex newVertex = new Vertex (data);
		this.vertices.add(newVertex);
		return newVertex;
	}
	public void addEdge(Vertex vertex1,Vertex vertex2, Integer weight ) {
		if (!this.isWeighted) {
			weight = null;
		}
		vertex1.addEdge(vertex2, weight);
		if (!this.isDirected) {
			vertex2.addEdge(vertex1, weight);
		}
	}
	public void removeEdge(Vertex vertex1, Vertex vertex2) {
		vertex1.removeEdge(vertex2);
		if(!this.isDirected) {
			vertex2.removeEdge(vertex1);
		}
	}
	public void removeVertex(Vertex vertex) {
		 this.vertices.remove(vertex);
		 
		 for (Vertex vert: this.vertices) {
		    vert.removeEdge(vertex);
		 }

	}
	public ArrayList<Vertex> getVertices() {
		return this.vertices;
	}
	public boolean isWeighted() {
		return this.isWeighted;
	}
	public boolean isDirected() {
		return this.isDirected;
	}
	
	public Vertex getVertexbyValue(String value) {
		for(Vertex vert : vertices) {
			if(vert.getData().equals(value))
				return vert;
		}
		return null;
	}
	public void print() {
		for(Vertex vert : this.vertices) {
			vert.print(isWeighted);
		}
	}
	public static void main(String[] args) {
		
//		Graph busNetwork = new Graph(true,true);
		Graph busNetwork = new Graph(true,false);
		
		Vertex GandhipuramBus = busNetwork.addVertex("Gandhipuram");
		
		Vertex UkkadamBus  = busNetwork.addVertex("Ukkadam");
		
		Vertex RspuramBus = busNetwork.addVertex("Rs puram");
		
		Vertex SaibabaColonybus = busNetwork.addVertex("Saibaba Colony");
		
		busNetwork.addEdge(GandhipuramBus, UkkadamBus, 10);
		busNetwork.addEdge(RspuramBus, SaibabaColonybus, 5);
		busNetwork.addEdge(RspuramBus, UkkadamBus,12);
		busNetwork.addEdge(GandhipuramBus, SaibabaColonybus, 7); 
		
//		busNetwork.removeVertex(UkkadamBus);
//		busNetwork.removeEdge(RspuramBus, SaibabaColonybus);
		busNetwork.print();
		
		System.out.println(busNetwork.isDirected);
		System.out.println(busNetwork.isWeighted);
		
		
		
	}

}
