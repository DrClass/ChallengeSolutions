package io.github.drclass.challenges.api;

public interface Problem {
	Result<?> solve();

	default String getName() {
		return this.getClass().getSimpleName();
	}
}
