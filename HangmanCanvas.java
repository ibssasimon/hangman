/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		removeAll();
		addScaffold();
		
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
		GLabel display = new GLabel(word, 100, getHeight() - 50);
		display.setFont("SansSerif-28");
		add(display);
		
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */

	}
	
	private void addScaffold() {
		GLine scaffold = new GLine(100, SCAFFOLD_HEIGHT - 100, 100, 50);
		add(scaffold);
		GLine scaffold_1 = new GLine(100, 50, 100 + BEAM_LENGTH, 50);
		add(scaffold_1);
		GLine rope = new GLine(100 + BEAM_LENGTH, 50, 100 + BEAM_LENGTH, 50 + ROPE_LENGTH);
		add(rope);
	}
	
	
	public void addHead() {
		GOval head = new GOval( 100 + BEAM_LENGTH - HEAD_RADIUS, 50 + ROPE_LENGTH, HEAD_RADIUS*2, HEAD_RADIUS*2);
		add(head);
	}
	
	public void addBody() {
		GLine body = new GLine(100 + BEAM_LENGTH, 50 + ROPE_LENGTH + (HEAD_RADIUS*2), 100 + BEAM_LENGTH, 100 + ROPE_LENGTH + BODY_LENGTH);
		add(body);
	}
	
	public void addLeftArm() {
		GLine upperLeftArm = new GLine(100 + BEAM_LENGTH, 50 + ROPE_LENGTH + (HEAD_RADIUS*2) + ARM_OFFSET_FROM_HEAD,100 + BEAM_LENGTH - UPPER_ARM_LENGTH,50 + ROPE_LENGTH + (HEAD_RADIUS*2) + ARM_OFFSET_FROM_HEAD);
		add(upperLeftArm);
		GLine bottomLeftArm = new GLine(100 + BEAM_LENGTH - UPPER_ARM_LENGTH,50 + ROPE_LENGTH + (HEAD_RADIUS*2) + ARM_OFFSET_FROM_HEAD, 100 + BEAM_LENGTH - UPPER_ARM_LENGTH, 50 + ROPE_LENGTH + (HEAD_RADIUS*2) + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		add(bottomLeftArm);
	}
	
	public void addRightArm() {
		GLine upperRightArm = new GLine(100 + BEAM_LENGTH, 50 + ROPE_LENGTH + (HEAD_RADIUS*2) + ARM_OFFSET_FROM_HEAD,100 + BEAM_LENGTH + UPPER_ARM_LENGTH, 50 + ROPE_LENGTH + (HEAD_RADIUS*2) + ARM_OFFSET_FROM_HEAD);
		add(upperRightArm);
		GLine bottomRightArm = new GLine(100 + BEAM_LENGTH + UPPER_ARM_LENGTH, 50 + ROPE_LENGTH + (HEAD_RADIUS*2) + ARM_OFFSET_FROM_HEAD, 100 + BEAM_LENGTH + UPPER_ARM_LENGTH, 50 + ROPE_LENGTH + (HEAD_RADIUS*2) + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		add(bottomRightArm);
	}
	
	public void addLeftLeg() {
		GLine leftHip = new GLine(100 + BEAM_LENGTH, 100 + ROPE_LENGTH + BODY_LENGTH, 100 + BEAM_LENGTH - HIP_WIDTH, 100 + ROPE_LENGTH + BODY_LENGTH);
		add(leftHip);
		GLine leftLeg = new GLine(100 + BEAM_LENGTH - HIP_WIDTH, 100 + ROPE_LENGTH + BODY_LENGTH, 100 + BEAM_LENGTH - HIP_WIDTH, 100 + ROPE_LENGTH + BODY_LENGTH + LEG_LENGTH);
		add(leftLeg);
		GLine leftFoot = new GLine(100 + BEAM_LENGTH - HIP_WIDTH, 100 + ROPE_LENGTH + BODY_LENGTH + LEG_LENGTH, 100 + BEAM_LENGTH - HIP_WIDTH - FOOT_LENGTH, 100 + ROPE_LENGTH + BODY_LENGTH + LEG_LENGTH);
		add(leftFoot);
	}
	
	public void addRightLeg() {
		GLine rightHip = new GLine(100 + BEAM_LENGTH, 100 + ROPE_LENGTH + BODY_LENGTH, 100 + BEAM_LENGTH + HIP_WIDTH, 100 + ROPE_LENGTH + BODY_LENGTH);
		add(rightHip);
		GLine rightLeg = new GLine(100 + BEAM_LENGTH + HIP_WIDTH, 100 + ROPE_LENGTH + BODY_LENGTH, 100 + BEAM_LENGTH + HIP_WIDTH, 100 + ROPE_LENGTH + BODY_LENGTH + LEG_LENGTH);
		add(rightLeg);
		GLine rightFoot = new GLine(100 + BEAM_LENGTH + HIP_WIDTH, 100 + ROPE_LENGTH + BODY_LENGTH + LEG_LENGTH, 100 + BEAM_LENGTH + HIP_WIDTH + FOOT_LENGTH, 100 + ROPE_LENGTH + BODY_LENGTH + LEG_LENGTH);
		add(rightFoot);
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
