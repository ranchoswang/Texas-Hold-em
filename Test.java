/**
 * Created by Administrator on 2016/11/29.
 */
public class Test {
    public static void main(String[] args){
    	int[] stat = new int[13];
    	int threadN = 10;
    	Thread threads[] = new Thread[threadN];
    	String[] resultString = {" wins", " splits", " loses", " total", " high card",
				" one pair", " two pairs", " three of one kind", " straigt",
				" flush", " full house", " quads", " straight flush"
	};

    	long start = System.currentTimeMillis();
    	for(int i = 0; i < threadN;  i ++){
    		Deck d = new Deck(1000000,stat);
    		int[] my1 = {1,10};
    		int[] my2 = {1,11};
    		int[] oppo1 = {2,12};
    		int[] oppo2 = {3,12};
		int[] flop1 = {1,13};
		int[] flop2 = {4,12};
		int[] flop3 = {1,8};
            d.dealMy1(my1);
            d.dealMy2(my2);
            d.dealOppo1(oppo1);
            d.dealOppo2(oppo2);
	    d.dealFlop1(flop1);
	    d.dealFlop2(flop2);
	    d.dealFlop3(flop3);
            threads[i] = new Thread(d);
            threads[i].start();
    	}
		
		while(Deck.count == 0){
		}
		while(Deck.count != 0){
		}
		for(int i = 0; i < 13; i ++){
			System.out.println((int)(stat[i]*1.0/stat[3]*100)+"% " + resultString[i]);
		}

		long end = System.currentTimeMillis();
		System.out.println("\nTime elapsed " + (end - start) + " ms.");	
    }
	/*
	class ForkRun extends RecursiveTask<Integer[]>{
		private Deck deck;
		private int complex;
		
		
		public ForkRun(int complexity, Deck deck){
			this.deck = deck;
			this.complex = (int) Math.floor(Math.log10(complexity));// 0 -15
		}
		
		protected Integer[] compute{
			
		}
	}
	*/
}
