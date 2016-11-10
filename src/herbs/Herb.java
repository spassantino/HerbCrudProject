package herbs;

public class Herb {
String scientificName;
String commonName;
String family;
String uses;
String precautions;
String photo;

	public Herb(){
	}

	public Herb(String scientificName, String commonName, String family, String uses, String precautions, String photo) {
	this.scientificName = scientificName;
	this.commonName = commonName;
	this.family = family;
	this.uses = uses;
	this.precautions = precautions;
	this.photo = photo;
}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getUses() {
		return uses;
	}

	public void setUses(String uses) {
		this.uses = uses;
	}

	public String getPrecautions() {
		return precautions;
	}

	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Herb [scientificName=" + scientificName + ", commonName=" + commonName + ", family=" + family + ", uses="
				+ uses + ", precautions=" + precautions + ", photo=" + photo + "]";
	}
}
