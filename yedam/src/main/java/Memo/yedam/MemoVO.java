package Memo.yedam;

public class MemoVO {
	private String numb;
	private String title;
	private String writer;
	private String content;

	public String getTitle() {
		return title;
	}
	
	public String getNumb() {
		return numb;
	}

	public void setNumb(String numb) {
		this.numb = numb;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "메모 [메모번호=" + numb + ", 메모제목=" + title + ", 메모작성자=" + writer + ", 메모내용=" + content + "]";
	}
	

}
