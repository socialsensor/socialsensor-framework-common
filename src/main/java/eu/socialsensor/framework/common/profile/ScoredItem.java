package eu.socialsensor.framework.common.profile;

public class ScoredItem implements Comparable<ScoredItem> {

	public final String id;
	public final float score;

	public ScoredItem(String id, float score) {
		super();
		this.id = id;
		this.score = score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ScoredItem other = (ScoredItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(ScoredItem o) {
		return (int) (10000 * score - 10000 * o.score);
	}

	@Override
	public String toString() {
		return id + "^" + score;
	}

}
