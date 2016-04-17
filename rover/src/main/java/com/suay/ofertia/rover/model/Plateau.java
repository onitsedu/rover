package com.suay.ofertia.rover.model;

public class Plateau {

	private Integer upper;
	private Integer right;

	public Plateau(Integer upper, Integer right) {
		this.upper = upper;
		this.right = right;
	}

	public boolean isRoverOnPlateau(Rover rover) {
		return !(rover.getxPosition() < 0 || rover.getyPosition() < 0 || rover.getyPosition() > this.upper
				|| rover.getxPosition() > right);
	}
}
