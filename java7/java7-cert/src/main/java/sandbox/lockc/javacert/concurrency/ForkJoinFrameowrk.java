package sandbox.lockc.javacert.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFrameowrk {

	public static void main(String[] args) {
				
		List<Integer> numbers = Arrays.asList(
				1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21);
		
		SumTask task = new SumTask(numbers);
		
		// will use internal common pool
		System.out.println(task.compute());
		
		// will use our pool
		ForkJoinPool pool = new ForkJoinPool(4);
		Integer result = pool.invoke(task);
		System.out.println(result);
		
	}
	
	
	
	
	
	@SuppressWarnings("serial")
	public static class SumTask extends RecursiveTask<Integer> {

		private List<Integer> numbers;
				
		public SumTask(List<Integer> numbers) {
			this.numbers = numbers;
		}
		
		@Override
		public Integer compute() {
			
			if(numbers.size() <= 5) {
				int sum = 0;
				for(Integer number : numbers) {
					sum += number;
				}
				return sum;
			} else {
				List<Integer> firstList = numbers.subList(0, (numbers.size() / 2));
				List<Integer> secondList = numbers.subList(numbers.size() / 2, numbers.size());
				
				SumTask firstHalf = new SumTask(firstList);
				firstHalf.fork();	
				SumTask secondHalf = new SumTask(secondList);
				return firstHalf.join() + secondHalf.compute(); 
				
			}
		}
		
	}

}
