enum Setting {
	OFF("---"),
	LOW("--+"),
	MEDIUM("-++"),
	HIGH("+++");
	
	public final String description;
	
	Setting(String description) {
		this.description = description;
	}
	
	public String toString() {
		return description;
	}
}