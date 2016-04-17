package com.suay.ofertia.rover.model;

import java.util.List;

import com.suay.ofertia.rover.commnads.RoverAction;

public class Rover {

	private int xPosition;
	private int yPosition;
	private Direction direction;

	private Plateau plateau;

	private List<RoverAction> actions;

	public Rover(int xPosition, int yPosition, Direction direction, Plateau plateau) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.direction = direction;
		this.setPlateau(plateau);
	}

	public String printLocation() {
		return this.xPosition + " " + this.yPosition + " " + this.direction.toString();
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public List<RoverAction> getActions() {
		return actions;
	}

	public void setActions(List<RoverAction> actions) {
		this.actions = actions;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

}
