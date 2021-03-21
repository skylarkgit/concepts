package com.skylark.collection;

public class IDEHashCode {

	class TestAutoHashInnerClass {
		String name;
		int id;
		float age;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + Float.floatToIntBits(age);
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
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
			TestAutoHashInnerClass other = (TestAutoHashInnerClass) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (Float.floatToIntBits(age) != Float.floatToIntBits(other.age))
				return false;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		private IDEHashCode getOuterType() {
			return IDEHashCode.this;
		}
		
		
	}
	
}

class TestAutoHashOuterClass {
	String name;
	int id;
	float age;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(age);
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		TestAutoHashOuterClass other = (TestAutoHashOuterClass) obj;
		if (Float.floatToIntBits(age) != Float.floatToIntBits(other.age))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
