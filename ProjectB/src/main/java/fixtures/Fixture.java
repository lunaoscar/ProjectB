package fixtures;

public abstract class Fixture {
	protected String name;
	protected String strShortD;
	protected String strLongD;

	public Fixture(String name, String strShortD, String strLongD) {
		super();
		this.name = name;
		this.strShortD = strShortD;
		this.strLongD = strLongD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStrShortD() {
		return strShortD;
	}

	public void setStrShortD(String strShortD) {
		this.strShortD = strShortD;
	}

	public String getStrLongD() {
		return strLongD;
	}

	public void setStrLongD(String strLongD) {
		this.strLongD = strLongD;
	}

//-------------------------double check the override later-------------------------------

	@Override
	public String toString() {
		return name + "\n" + strShortD + "\n" + strLongD + "";
	}
}
	