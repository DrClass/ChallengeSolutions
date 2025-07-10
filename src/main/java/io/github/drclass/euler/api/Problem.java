package io.github.drclass.euler.api;

public interface Problem {
	Result<?> solve();

	default String getName() {
		return this.getClass().getSimpleName();
	}
}
