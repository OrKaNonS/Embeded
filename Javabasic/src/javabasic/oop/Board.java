package javabasic.oop;

public class Board {

	private int articNo;
	private String articleSubject;
	private String articleContent;
	private String articleWriter;

	
	
	public Board(int articNo, String articleSubject, String articleContent, String articleWriter) {
		super(); // super는 object로 상위클래스 이다.
		this.articNo = articNo;
		this.articleSubject = articleSubject;
		this.articleContent = articleContent;
		this.articleWriter = articleWriter;
	}

	public int getArticNo() {
		return articNo;
	}

	public void setArticNo(int articNo) {
		this.articNo = articNo;
	}

	public String getArticleSubject() {
		return articleSubject;
	}

	public void setArticleSubject(String articleSubject) {
		this.articleSubject = articleSubject;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getArticleWriter() {
		return articleWriter;
	}

	public void setArticleWriter(String articleWriter) {
		this.articleWriter = articleWriter;
	}

	@Override
	public String toString() {
		return "Board [articNo=" + articNo + ", articleSubject=" + articleSubject + ", articleContent=" + articleContent
				+ ", articleWriter=" + articleWriter + "]";
	}

} // class





























