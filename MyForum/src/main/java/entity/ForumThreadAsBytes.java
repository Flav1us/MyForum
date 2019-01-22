package entity;

import javax.persistence.*;

@Entity
@Table(name="forumthread")
public class ForumThreadAsBytes {
    @Id
    @GeneratedValue()
    private int id;

	@Column(name="bytes")
	private byte[] thread;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public ForumThreadAsBytes(byte[] thread) {
		this.thread = thread;
	}

	public byte[] getThread() {
		return thread;
	}

	public void setThread(byte[] thread) {
		this.thread = thread;
	}
}
