package task3;
import java.io.*;
import java.util.Scanner;
 
public class RingProcess {
    
     public static void main(String args[])throws IOException {
	int i,j,k,l,m,n;
	int pro[] = new int[100];
		
	System.out.print("Enter the number of processes: ");
	Scanner in = new Scanner(System.in);
    n = in.nextInt(); 
        
        for(i=0;i<n;i++) {
            System.out.println("For process "+(i+ 1)+"...");
            System.out.print("Process id (1, 2, 3, .., n): ");
            pro[i] = in.nextInt();
        }
         
        System.out.print("Which process will initiate election? ");
        int initiator = in.nextInt() - 1;

        ringElection(initiator,n,pro);

	// TO DO Task: Implement your logic to perform the ring algorithm. 
	// You can initiate a new method or implement your logic in the main method.
		
    }

    public static void ringElection(int initiator, int n, int[] pro) {
        int leader = initiator;
        System.out.println("Process " + pro[initiator] + " starts election");
        for (int i = 0; i < n; i++) {
            int current = (initiator + i) % n;
            int next = (current + 1) % n;
            System.out.println("Process " + pro[current] + " send to Process " + pro[next]);

            if (pro[current]>pro[leader]) {
                leader = current;
            }
            
        }
        System.out.println("Elected leader is Process " + pro[leader]);

    }

}
     