package dataStructures;

import java.util.*;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Graphs
{
    static int time = 0;
    public static void main(String[] args)
    {
        Graph graph = new Graph();
        Vertex r = new Vertex('r');
        Vertex s = new Vertex('s');
        Vertex t = new Vertex('t');
        Vertex u = new Vertex('u');
        Vertex v = new Vertex('v');
        Vertex w = new Vertex('w');
        Vertex x = new Vertex('x');
        Vertex y = new Vertex('y');

        graph.start = s;
        graph.vertices.add(s);
        graph.vertices.add(r);
        graph.vertices.add(t);
        graph.vertices.add(u);
        graph.vertices.add(v);
        graph.vertices.add(w);
        graph.vertices.add(x);
        graph.vertices.add(y);

        s.edges = Arrays.asList(r,w);
        r.edges = Arrays.asList(s,v);
        t.edges = Arrays.asList(u,w,x);
        u.edges = Arrays.asList(t,x,y);
        v.edges = Arrays.asList(r);
        w.edges = Arrays.asList(s,t,x);
        x.edges = Arrays.asList(t,u,w,y);
        y.edges = Arrays.asList(u,x);

        breadthFirstSearch(graph);
        for(Vertex vertex : graph.vertices)
        {
            Character parent = vertex.parent != null ? vertex.parent.value : null;
            System.out.println(vertex.value + " " + vertex.distance + " " + parent + " " + vertex.color + " " + vertex.edges.size());
        }

        pathFromStartToVertex(u);
        System.out.println();

        Graph dirGraph = new Graph();
        Vertex a = new Vertex('a');
        Vertex b = new Vertex('b');
        Vertex c = new Vertex('c');
        Vertex d = new Vertex('d');
        Vertex e = new Vertex('e');
        Vertex f = new Vertex('f');
        Vertex g = new Vertex('g');
        Vertex h = new Vertex('h');

        dirGraph.vertices.add(a);
        dirGraph.vertices.add(b);
        dirGraph.vertices.add(c);
        dirGraph.vertices.add(d);
        dirGraph.vertices.add(e);
        dirGraph.vertices.add(f);
        dirGraph.vertices.add(g);
        dirGraph.vertices.add(h);

        a.edges = Arrays.asList(h,e);
        b.edges = Arrays.asList(d,c);
        c.edges = Arrays.asList(d);
        d.edges = Arrays.asList(a,e);
        e.edges = Arrays.asList(f);
        f.edges = Arrays.asList(h);
        g.edges = Arrays.asList(f);
        h.edges = Arrays.asList(g,e);

        depthFirstSearch(dirGraph);

        for(Vertex vertex : dirGraph.vertices)
        {
            Character parent = vertex.parent != null ? vertex.parent.value : null;
            System.out.println(vertex.value + " " + vertex.startTime + "/" + vertex.endTime + " " + parent + " " + vertex.color + " " + vertex.edges.size());
        }


    }


    private static void depthFirstSearch(Graph graph)
    {
        for (Vertex vertex : graph.vertices)
            vertex.color = Color.WHITE;

        for (Vertex vertex : graph.vertices)
        {
            if(vertex.color == Color.WHITE)
                dfsVisit(vertex);
        }
    }

    private static void dfsVisit(Vertex vertex)
    {
        time++;
        vertex.color = Color.GREY;
        vertex.startTime = time;
        for (Vertex edge : vertex.edges)
        {
            if(edge.color == Color.WHITE)
            {
                edge.parent = vertex;
                dfsVisit(edge);
            }
        }
        vertex.color = Color.BLACK;
        vertex.endTime = ++time;
    }

    private static void pathFromStartToVertex(Vertex vertex)
    {
        if(vertex.parent != null)
            pathFromStartToVertex(vertex.parent);
        System.out.print(vertex.value + " ");
    }

    private static void breadthFirstSearch(Graph graph)
    {
        for (Vertex vertex : graph.vertices)
            vertex.color = Color.WHITE;

        BlockingQueue<Vertex> queue = new ArrayBlockingQueue<Vertex>(graph.vertices.size());
        graph.start.distance = 0;
        graph.start.color = Color.GREY;
        queue.add(graph.start);
        while(!queue.isEmpty())
        {
            Vertex current = queue.remove();
            for(Vertex vertex : current.edges)
            {
                if(vertex.color == Color.WHITE)
                {
                    vertex.color = Color.GREY;
                    vertex.distance = current.distance + 1;
                    vertex.parent = current;
                    queue.add(vertex);
                }
            }
            current.color = Color.BLACK;
        }
    }

    public static void dfsRec(Node root){
        root.visited = true;
        System.out.println(root.value);
        for (Node temp: root.nodes)
            if(!temp.visited)
                dfsRec(temp);
    }

    public static void bfs(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node n = queue.poll();
            System.out.println(n.value);
            for(Node temp: n.nodes)
                if(!temp.visited)
                    queue.add(temp);
            n.visited = true;
        }
    }

    public static void dfs(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Node n = stack.pop();
            System.out.println(n.value);
            for(Node temp : n.nodes){
                if(!temp.visited)
                    stack.push(temp);
            }
            n.visited = true;
        }
    }

    static class Node{
        public char value;
        public List<Node> nodes;
        public boolean visited;

        public Node(char value){
            this.value = value;
            nodes = new ArrayList<>();
        }
    }
}



class Graph
{
    Vertex start;
    Set<Vertex> vertices = new LinkedHashSet<Vertex>();
}

class Vertex
{
    char value;
    Color color;
    Integer distance;
    Vertex parent;
    List<Vertex> edges;
    int startTime;
    int endTime;

    public Vertex(char value)
    {
        this.value = value;
    }
}

enum Color
{
    WHITE, GREY, BLACK
}