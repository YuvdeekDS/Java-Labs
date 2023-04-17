package urn0000;

import java.util.ArrayList;

/**
 * This class defines the Segment Table of a Process.
 * TODO: this class is incomplete
 */

public class SegmentTable {
	
	private ArrayList<Segment> segments;
	
	/*
	 * Constructor of SegmentTable
	 */
	public SegmentTable(ArrayList<Segment> seg) {
		this.segments = seg;
		
	}
	
	public ArrayList<Segment> getSegments(){
		return this.segments;
	}
	

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		for(Segment seg : segments ) {
			builder.append(seg.toString()+", ");
		}
		builder.append(")");
		return builder.toString();
	}

}
