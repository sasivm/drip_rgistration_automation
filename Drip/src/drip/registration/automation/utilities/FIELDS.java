package drip.registration.automation.utilities;

public class FIELDS {

	private String id, type, value;

	public FIELDS(String id, String type) {
		this.id = id;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "FIELDS [id=" + id + ", type=" + type + ", value=" + value + "]";
	}
}
