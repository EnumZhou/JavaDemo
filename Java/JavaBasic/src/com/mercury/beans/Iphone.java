package com.mercury.beans;

public class Iphone implements Comparable<Iphone>{
		private String type;
		private String color;
		private int capacity;
		public Iphone() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Iphone(String type, String color, int capacity) {
			super();
			this.type = type;
			this.color = color;
			this.capacity = capacity;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public int getCapacity() {
			return capacity;
		}
		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}
//		@Override
//		public int hashCode(){
//			return color.hashCode()* 3+type.hashCode() *5+ capacity*7;
//			
//		}
		
		@Override
		public String toString() {
			return "Iphone [type=" + type + ", color=" + color + ", capacity=" + capacity + "]";
		}
		
//		@Override
//		public boolean equals(Object o){
//			
//			if(o==null){return false;}
//			if(!(o instanceof Iphone)){
//				return false;
//			}
//			
//			//retrun true if all fields are the same;
//			return
//		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + capacity;
			result = prime * result + ((color == null) ? 0 : color.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Iphone other = (Iphone) obj;
			if (capacity != other.capacity)
				return false;
			if (color == null) {
				if (other.color != null)
					return false;
			} else if (!color.equals(other.color))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}
		
		@Override
		public int compareTo(Iphone input){
			// return positive: this > input
			// return 0: this=input
			// return negative: this< input
			if(input ==null){
				return 1;
			}
//			if(this.capacity==input.capacity){
//				return 0;
//			}
//			
//			if(this.capacity<input.capacity){
//				return 1;
//			}
//			return 0;
			return input.getCapacity()-this.getCapacity();
			
		}
		
		
		
		
}
