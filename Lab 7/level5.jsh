Logger<Integer> add(Logger<Integer> logger, int anotherValue) {
    return logger.map(x -> x + anotherValue);
}

Logger<Integer> sum(int n) {
    if (n == 0) {
        return Logger.make(0);
    } else {
    	return add(sum(n - 1), n);
    }
}

Logger<Integer> f(int n) {
   return helper(Logger.<Integer>make(n));
}

Logger<Integer> helper(Logger<Integer> logger) {
	if (logger.test(x -> x == 1)) {
		return logger;
	} else if(logger.test(x -> x %2 == 0)) {
		return helper(logger.map(x -> x/2));
	} else {
		Logger<Integer> newLogger = logger.map(x -> 3 * x);
        return helper(newLogger.map(x -> x + 1));
	}
}
