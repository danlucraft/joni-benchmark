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
	public void benchmarkSubstringMatch(){
		TestJoni.test_re("foo", "  foo  ");
	}

	@Benchmark(times = 200)
	public void benchmarkDateExact(){
		TestJoni.test_re("\\d\\d\\d\\d-\\d\\d-\\d\\d", "2009-08-54");
	}

	@Benchmark(times = 200)
	public void benchmarkDateInsideString(){
		TestJoni.test_re("\\d\\d\\d\\d-\\d\\d-\\d\\d", "  2009-08-54xx  ");
	}

	@Benchmark(times = 200)
	public void benchmarkAlternation(){
		TestJoni.test_re("((class|module|def|end) \\w+ < )+", "  asdf asdf asd class agrg < def foo < module ads <");
	}

	@After
	public void teardown(){
		// runs after each 
	}
}
