
public class FloydWarshall {

    static int infinity = 9999;
    private int V = 4; //number of vertices

    void floydWarshall(int graph[][]){
        int A[][] = new int[V][V];
        
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                A[i][j] = graph[i][j]; //assign the values i.e. creating A0
            }
        }

        for(int k = 0; k < V; k++){
            for(int i = 0; i < V; i++){
                for(int j = 0; j < V; j++){
                    if(A[i][k] + A[k][j] < A[i][j]){
                        A[i][j] = A[i][k] + A[k][j];
                    }
                }
            }
        }

        printSol(A);
    }

    void printSol(int A[][]){
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(A[i][j] == infinity){
                    System.out.print(" ∞ ");
                }else{
                    System.out.print(A[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {

        int graph[][] = {{0, 3, infinity, 5},
                        {2, 0, infinity, 4},
                        {infinity, 1, 0, infinity},
                        {infinity, infinity, 2, 0}};

        FloydWarshall fd = new FloydWarshall();
        fd.floydWarshall(graph);
        
    }
}
