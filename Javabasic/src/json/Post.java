package json;

public class Post {
	
	private int userid;
	private int id;
	String title;
	String body;
	
	public Post() {
		
	}
	
	public Post(int userid, int id, String title, String body) {
		super();
		this.userid = userid;
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Post [userid=" + userid + ", id=" + id + ", title=" + title + ", body=" + body + "]";
	}

}
