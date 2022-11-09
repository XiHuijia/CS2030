import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Arrays;
import java.lang.Math;
import java.util.function.Supplier;
import java.lang.Double;
class Main {
    
    static boolean isPrime(int n) {
        return n > 1 && IntStream.range(2, n).noneMatch(x -> n % x == 0);
    }

    static int[] twinPrimes(int n) {
        return IntStream.rangeClosed(2, n).filter(x -> isPrime(x) && (isPrime(x+2) || isPrime(x-2))).toArray();
    }

    static int gcd(int m, int n) {
    	//Stream.iterate(new int[]{m, n}, vals -> new int[] {vals[1], vals[0] % vals[1]}).filter(v -> v[1] == 0).findFirst().get()[0];
    	return Stream.iterate(new Pair(m, n) , x -> new Pair(x.getB(), x.getA() % x.getB())).filter(x -> x.getB() == 0).findFirst().map(x -> x.getA()).get();
    }

    static long countRepeats(int... array) {
    	return IntStream.range(1, array.length).filter(x -> x -2 < 0 || array[x] != array[x - 2]).filter(x -> array[x] == array[x - 1]).count();

    }

    static int findMax(Stream<Integer> stream) {
    	Supplier<Stream<Integer>> streamSupplier = () -> stream;
    	return streamSupplier.get().max(Integer::compare).get();
    }

    static int findMin(Stream<Integer> stream) {
    	Supplier<Stream<Integer>> streamSupplier = () -> stream;
    	return streamSupplier.get().min(Integer::compare).get();
    }

    static int findSum(Stream<Integer> stream) {
    	Supplier<Stream<Integer>> streamSupplier = () -> stream;
    	return streamSupplier.get().mapToInt(Integer::intValue).sum();
    }

    static long countStream(Stream<Integer> stream) {
    	Supplier<Stream<Integer>> streamSupplier = () -> stream;
    	return streamSupplier.get().count();
    }

    static double normalizedMean(Stream<Integer> stream) {
    	Object[] objArray = stream.toArray();
        Integer[] intArray = Arrays.copyOf(objArray, objArray.length, Integer[].class);
    	Supplier<Stream<Integer>> streamSupplier = () -> Stream.of(intArray);
    	return countStream(streamSupplier.get()) == 0 || (findSum(streamSupplier.get())/countStream(streamSupplier.get()) - findMin(streamSupplier.get())) == 0 ||(findMax(streamSupplier.get())-findMin(streamSupplier.get())) == 0?
    	0.0:(double)(findSum(streamSupplier.get())/countStream(streamSupplier.get()) - findMin(streamSupplier.get()))/(findMax(streamSupplier.get())-findMin(streamSupplier.get()));
    }
}


