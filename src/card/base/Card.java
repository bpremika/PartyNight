package card.base;

public abstract class Card implements Useable {
	private String name;
	private boolean useState;

	public Card(String name) {
		super();
		this.setName(name);
		this.useState = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void use() {
		// TODO card use method
		if (this.useState == false) {
			this.useState = true;
		}
	}

	@Override
	public boolean isUsed() {
		// TODO Auto-generated method stub
		return useState;

	}

}
