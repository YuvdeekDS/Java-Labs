package urn0000;
import java.util.ArrayList;
//The Memory Class 
public class Memory {

	/**
	 * Declare private variables and use the following methods and new methods
	 * to access them
	 */
	private int OSsize;
	private int total_size;
	private String added_segments_base="";
	private int hole;
	/**
	 * Main Memory Constructor 
	 * @param size is total memory size 
	 */
	public Memory(int size, int os_size) {
		//TODO: this function is to be updated
		this.total_size = size;
		this.OSsize = os_size;
		this.hole = this.total_size - this.OSsize;
	}
	
	/**
	 * Allocate a process to the memory
	 * @param process, a process to be allocated to the memory
	 * @return return 1 if successful, -1 otherwise with an error message
	 */
	public int allocate(Process process) {
				
		// make sure segments of a process are only allocated to the memory once
		// i.e, only allocate segments that aren't loaded in the memory
		boolean isHolechanged = false;
		ArrayList<Segment> segs = process.getSegmentTable().getSegments();
		for(Segment seg: segs) {
			if(this.added_segments_base.contains("S"+seg.getID())) {
				// already added to the process
			}else {
				isHolechanged = true;
				this.allocate(process,seg);
			}
		}
		if(isHolechanged) {			
			return 1;
		}else {
			return -1;
		}
	}
	/**
	 * add a segment of the process to the memory
	 * @param p the process with the segment 
	 * @param seg the segment to be allocated
	 */
	public void allocate(Process p, Segment seg) {
		int prId = p.getProcessId();
		this.added_segments_base +=" [P"+prId+", S"+seg.getID()+": "+seg.getSize()+"] ";
		int isaddedBase = seg.addBaseToSegment(OSsize);
		if(isaddedBase == 1) {			
			this.hole = this.hole - seg.getSize();
		}
	}
	/**
	 * remove a segment of the process from the memory
	 * @param p the process with the segment 
	 * @param seg the segment to be removed from the main memory
	 */
	public int deallocate(Process p, Segment seg) {
		
		int segId = seg.getID();
		Segment segment = p.getSegment(segId);
		if(segment != null) {
//			p.getSegmentTable().getSegments().remove(segment); //in doubt should not remove while deallocation , just remove base
			//after removing segment, modify the hole size and added segments base string
			if(segment.getBase() > 0) {				
				seg.removeBaseFromSegment();
				this.hole = this.hole + seg.getSize();
				this.added_segments_base = this.added_segments_base.replace( " [P"+p.getProcessId()+", S"+segId+": "+segment.getSize()+"] ","");
			}
//				for(Segment updatedSeg: p.getSegmentTable().getSegments()) {
//					this.hole = this.hole - updatedSeg.getSize();
//					this.added_segments_base += " [P"+p.getProcessId()+", S"+updatedSeg.getID()+": "+updatedSeg.getSize()+"] ";
//				}
			return 1;
		}else {
		return -1;
		}
	}
    	
	/**
	 * Deallocate memory allocated to this process
	 * @param process the process to be deallocated
	 * @return return 1 if successful, -1 otherwise with an error message
	 */
	public int deallocate(Process p) {
		
		ArrayList<Segment> segmentTable = p.getSegmentTable().getSegments();
//		int segments_size = segmentTable.size();
//		if(segments_size>0) {
//			segmentTable.clear();
//			this.hole = this.total_size - this.OSsize;
//			this.added_segments_base = "";
//			return 1;
//		}
		 ArrayList<Integer> deallocationResults = new ArrayList<>();
		for(Segment seg: segmentTable) {
			deallocationResults.add(this.deallocate(p, seg));
		}
		System.out.println(deallocationResults.toString()+"<==deall");
		if(deallocationResults.indexOf(-1) >= 0) {
			throw new IllegalAccessError("cannot deallocate process");
		}else {			
			return 1;			
		}
	}
	/**
	 * the process p will be updated
	 * @param p the input process to be updated/resized
	 * @return return 1 if successful, -1 otherwise with an error message
	 */
	public int resizeProcess (Process p) {
		int pid = p.getProcessId();
		
		return 1;
	}
    /**
     * function to display the state of memory to the console
     */
    public void memoryState() {

//        System.out.println("Memory State: (to be completed)\n");
    	System.out.println("[OS"+" "+OSsize+"] |"+ this.added_segments_base +" [Hole "+(this.hole)+"]");
    }
	
}
