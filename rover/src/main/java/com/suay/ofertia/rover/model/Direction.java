package com.suay.ofertia.rover.model;

public enum Direction {

	N(0, 1) {
		@Override
		public Direction rightDirection() {
			return E;
		}

		@Override
		public Direction leftDirection() {
			return W;
		}
	},
	S(0, -1) {
		@Override
		public Direction rightDirection() {
			return W;
		}

		@Override
		public Direction leftDirection() {
			return E;
		}
	},
	E(1, 0) {
		@Override
		public Direction rightDirection() {
			return S;
		}

		@Override
		public Direction leftDirection() {
			return N;
		}
	},
	W(-1, 0) {
		@Override
		public Direction rightDirection() {
			return N;
		}

		@Override
		public Direction leftDirection() {
			return S;
		}
	};

	private final int xStep;
	private final int yStep;

	Direction(final int xStep, final int yStep) {
		this.xStep = xStep;
		this.yStep = yStep;
	}

	public abstract Direction rightDirection();

	public abstract Direction leftDirection();

	public int getxStep() {
		return xStep;
	}

	public int getyStep() {
		return yStep;
	}

}
