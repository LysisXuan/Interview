import java.util.Arrays;
import java.util.HashMap;

//Question #6

public class FrogJump {
	
	public static void main(String[] args) {
		int[] A = {1,3,1,4,2,5};
		int X = 7;
		int D = 3;
		p(solution(A,X,D));
	
	}
	public static void p(Object obj) {
		System.out.println(obj);
	}

	public static int solution(int[] A, int X, int D) {
        if(X <= D) return 0;
        else if(A==null||A.length==0) return -1;
        
        HashMap<Integer,Integer> leafExistTime = new HashMap<Integer,Integer>();
        leafExistTime.put(0,0);
        leafExistTime.put(X,0);
        for(int i = 0; i<A.length;i++) {
            if(!leafExistTime.containsKey(A[i])) {
                leafExistTime.put(A[i],i);
            }
        }
        
        int[] posTime = new int[X+1];
        Arrays.fill(posTime,Integer.MAX_VALUE);
        for(int pos = 0;pos <=X;pos++) {
            if(!leafExistTime.containsKey(pos)) continue;
            if(pos <= D) posTime[pos] = leafExistTime.get(pos);
            else {
                for(int step = D;step > 0;step--) {
                	int curTime = leafExistTime.get(pos) > posTime[pos-step]?leafExistTime.get(pos):posTime[pos-step];
                    posTime[pos] = Math.min(posTime[pos], curTime);
                }    
            }
        }
        if(posTime[X] < Integer.MAX_VALUE) return posTime[X];
        else return -1;
    }
}
