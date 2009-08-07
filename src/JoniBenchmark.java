import ch.mollusca.benchmarking.After;
import ch.mollusca.benchmarking.Before;
import ch.mollusca.benchmarking.Benchmark;

/*
 * Running:
 * Create a run config for ch.mollusca.benchmarking.BenchmarkRunner
 */
public class JoniBenchmark {
	@Before
	public void setup(){
		// runs before every benchmark run
	}
	
	@Benchmark(times = 200)
	public void benchmarkSomething(){
		int i = 1000000000;
		while(i-- > 0){
			int a = i << 33;
		}
	}
	
	@Benchmark
	public void benchmarkSomethingElse(){
		try{
			Thread.sleep(20);
		} catch(Exception e){
			
		}
	}
	
	@After
	public void teardown(){
		// runs after each 
	}
}
