package entity;

import java.io.Serializable;

public class ForumPost implements Serializable {
	private static final long serialVersionUID = 5097340064843130868L;
	
	private String text;
	public ForumPost(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
}
