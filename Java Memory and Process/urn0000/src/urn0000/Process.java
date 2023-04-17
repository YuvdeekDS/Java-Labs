package urn0000;

import java.util.ArrayList;
import java.util.List;

public class Process {
	
	private int pid = 0; // the id of the process
	private SegmentTable segmentTable;
	
	public Process (String processString) {
		//pid++;
		ArrayList<Segment> segmentList = new ArrayList<Segment>();
		
		//Parser Examples
		Parser P = new Parser();
		ArrayList<String>[] list = P.parseInputString(processString);
		
		//assign the first argument as process id from process string after parsing
		this.pid = Integer.valueOf(list[0].get(0));
		
		for(int id = 1; id < list.length; id++) {
			int segmentSize = Integer.valueOf(list[id].get(0));
			Segment segment = new Segment(id, segmentSize);
			//assign permission to segment if exists in second index
			if(list[id].size()  == 2)
			segment.addPermisssion(list[id].get(1));
			segmentList.add(segment);
		}
		
		segmentTable = new SegmentTable(segmentList);
		
	}
	// returns the process id of this process
	public int getProcessId() {
		return this.pid;
	}
	/**
	 * 
	 * @param segments the list of segments that belong to teh process
	 */
	public void resize(String segments) {
		Parser p =new Parser();
		ArrayList<String>[] segmentList = p.parseInputString(segments);
		
		//loop through available segments in segment table
		int index=0;
		for(Segment seg : segmentTable.getSegments()) {
			
			int resizeSize = seg.getSize() + Integer.valueOf(segmentList[index].get(0)); 
			
			//condition evaluation as specified
			if(resizeSize == 0) {
				//remove from table if segment becomes zero
				segmentTable.getSegments().remove(index);
			}else if(resizeSize < 0) {
				//throw error if it becomes negative
				 throw new IllegalArgumentException("Illegal Argument: size of segment is becoming less than zero ");
			}else {
				//resize to given size
				seg.resizeSegment(resizeSize);
			}
			index++;
		}
	}
	
	/**
	 * TODO: return the segment with the input ID
	 * @param id is the segment ID of the process
	 */
	public Segment getSegment(int id) {
		
		Segment s = null;
		ArrayList<Segment> segmentList = this.segmentTable.getSegments();
		for(int i=0;i<segmentList.size();i++) {
			if(segmentList.get(i).getID() ==  id) {
				s = segmentList.get(i);
			}
		}
		return s;
		
	}
	
	public SegmentTable getSegmentTable() {
		return this.segmentTable;
	}
	/**
	 * to print the details of segments of the process
	 */
	public void segmentTable() {

		StringBuilder builder = new StringBuilder();
		builder.append("P"+this.pid+" Segment Table\n");
		builder.append("Sid | base | limit | valid-invalid | permissions\n");
		ArrayList<Segment> segments = this.segmentTable.getSegments();
		
		for(Segment seg : this.segmentTable.getSegments()) {
			builder.append(seg.toString());
			builder.append("\n");
		}
		System.out.print(builder.toString()+"\n");
	}
	/**
	 * output the details of the process, which includes process Id and segment details
	 */

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.pid);
		builder.append(" (");
		builder.append(this.pid+", ");
		ArrayList<Segment> segments = this.segmentTable.getSegments();
		for(Segment seg : segments) {
			builder.append(seg.getSize());
			if(! (segments.indexOf(seg) == segments.size() - 1)) {
				builder.append(", ");
			}
		}
		builder.append(")");
		return builder.toString();
	}
}
