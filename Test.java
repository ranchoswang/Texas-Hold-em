/**
 * Created by Administrator on 2016/11/29.
 */
public class Test {
    public static void main(String[] args){
    	int[] stat = new int[13];
    	int threadN = 10;
    	Thread threads[] = new Thread[threadN];
    	
    	long start = System.currentTimeMillis();
    	for(int i = 0; i < threadN;  i ++){
    		Deck d = new Deck(1000000,stat);
    		int[] my1 = {1,5};
    		int[] my2 = {1,6};
    		int[] oppo1 = {2,14};
    		int[] oppo2 = {3,14};
            d.dealMy1(oppo1);
            d.dealMy2(oppo2);
            d.dealOppo1(my1);
            d.dealOppo2(my2);
            threads[i] = new Thread(d);
            threads[i].start();
    	}
		
		while(Deck.count == 0){
		}
		while(Deck.count != 0){
		}
		for(int i = 0; i < 13; i ++){
			System.out.print((int)(stat[i]*1.0/stat[3]*100)+"% ");
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
