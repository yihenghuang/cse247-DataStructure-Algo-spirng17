package kwaymergesort;

import timing.Ticker;

public class KWayMergeSort {

	public static Integer[] kwaymergesort(int K, Integer[] input, Ticker ticker) {
		int n = input.length;

	if (n<=1){
		return input;
		
	}
	

		Integer[][] split = new Integer[K][n/K];

		int i=0;
		int j=0;
		int k=0;
		for (i=0; i<K; i++){
			for (j=0; j<n/K; j++){
				split[i][j]=input[k];
				k++;
			}
		}
		n=n/K;
		for (i=0; i<K; i++){
			split[i]=kwaymergesort(K, split[i], ticker);
		}

		Integer[] ans = mergerecursive(split, ticker)[0];
		return ans;
	}


	public static Integer[][] mergerecursive(Integer[][] splits, Ticker ticker) {
		
		for (int j=splits.length; j>1; j=j/2){
			for (int i=0; i<j;i+=2){
				splits[i/2]=mergeTwo(splits[i],splits[i+1],ticker);
			}
		
		}
		return splits;
	}
	
	public static Integer[] mergeTwo(Integer[] input1, Integer[] input2, Ticker tick) {
		Integer[] ans = new Integer[input1.length+input2.length];
		int a=0;
		int b=0; 
		int c=0; 
		while((a<input1.length)&&(b<input2.length)){
			if(input1[a]<input2[b]){
				ans[c]= input1[a]; 
				a++; 
				c++; 
			}
			else {
				ans[c]= input2[b]; 
				b++; 
				c++; 
			}

		}
		while(a<input1.length){
			ans[c]=input1[a]; 
			c++;
			a++; 
			
		}
		while(b<input2.length){
			ans[c]=input2[b]; 
			c++;
			b++; 
			
		}
		return ans; 



	}

}
