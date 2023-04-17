package urn0000;

// TODO: complete this Segment class

public class Segment {
		private int id; // the id of the segment 
		private int size; // the size of the segment
		private int base; // the base of segment
		private String permissionString=""; // permission string
		/**
		 * default constructor of a Segment
		 */
		public Segment() {
			//TODO: to be completed
		}
		
		/**
		 * the constructor of Segment
		 * @param segmentID the id of the segment
		 * @param size the size of the segment
		 */
		public Segment(int segmentID, int size) {
			super();
			id = segmentID;
			this.size = size;
			
		}
		
		// add or update the permission of the string
		public void addPermisssion(String perm) {
			this.permissionString = perm;
		}
		
		// get the current permission of the segment
		public String getPermission() {
			return this.permissionString;
		}
		
		public String toString() {
			//TODO: print the details of this segment
			return " "+this.id+"  |  "+  (this.base ==0 ? "   "  : this.base) +" |  "+this.size+"   |        "+(this.base ==0 ? 0  : 1)+"      | "+this.permissionString;
		}
		public  int getSize() {
			return this.size;
		}
		public int getID() {
			return this.id;
		}
		public int getBase() {
			return this.base;
		}
		public void resizeSegment(int size) {
			this.size = size;
		}
		public int addBaseToSegment(int base) {
			if(this.base == 0) {
				this.base = base;
				return 1;
			}else {				
				return -1;
			}
		}
		
		public void removeBaseFromSegment() {
			this.base=0;
		}
}

