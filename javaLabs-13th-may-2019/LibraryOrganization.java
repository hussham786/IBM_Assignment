abstract class Item{
	private int uIdNo;
	private String title;
	private int numOfCopies;
	private boolean eq;
	private String str;

	Item(int uIdNo,String title, int numOfCopies){
		this.uIdNo = uIdNo;
		this.title = title;
		this.numOfCopies = numOfCopies;
	}

	Item(){

	}

	boolean equals(boolean eq){
		return eq;
	}

	String toString(String str){
		return str;
	}

	int getUIdNo(){
		return uIdNo;
	}
	String getTitle(){
		return title;
	}
	int getNumOfCopies(){
		return numOfCopies;
	}

	void setUIdNo(int uIdNo){
		this.uIdNo = uIdNo;
	}
	void setTitle(String title){
		this.title = title;
	}
	void setNumOfCopies(int numOfCopies){
		this.numOfCopies = numOfCopies;
	}

}

abstract class WrittenItem extends Item{
	private String author;

}

class Book extends WrittenItem{

}

class JournalPaper extends WrittenItem{
	private int yearPublished;
}

abstract class MediaItem extends Item{
	private int runTimedata;
}

class Video extends MediaItem{
	private String director;
	private String genre;
	private int year;

	Video(String director, String genre, int year){
		this.director = director;
		this.genre = genre;
		this.year = year;
	}
	Video(){

	}

	String getDirector(){
		return director;
	}
	String getGenre(){
		return genre;
	}
	int getYear(){
		return year;
	}

	void setDirector(String director){
		this.director = director;
	}
	void setGenre(String genre){
		this.genre = genre;
	}
	void setYear(int year){
		this.year = year;
	}
}

class ClassCD extends MediaItem{
	private String artist;
	private String genre;
	
	ClassCD(String artist, String genre){
		this.artist = artist;
		this.genre = genre;
	}
	ClassCD(){

	}

	String getArtist(){
		return artist;
	}
	String getGenre(){
		return genre;
	}
	void setArtist(String artist){
		this.artist = artist;
	}
	void setGenre(String genre){
		this.genre = genre;
	}
}

class LibraryOrganization{
	public static void main(String[] args) {
		Video video = new Video("SS Rajaumauli", "Action", 2018);
		/*video.setDirector("SS Rajaumauli");
		video.setGenre("Action");
		video.setYear(2018);*/
		Book book = new Book();
		book.setTitle("Half GirlFriend");
		book.setUIdNo(123);
		book.setNumOfCopies(3);

		ClassCD cd = new ClassCD("Allu Arjun", "Emotional");

		System.out.println(video.getDirector());
		System.out.println(video.getGenre());
		System.out.println(video.getYear());

		System.out.println(book.getTitle());
		System.out.println(book.getUIdNo());
		System.out.println(book.getNumOfCopies());

		System.out.println(cd.getArtist());
		System.out.println(cd.getGenre());
		
	}
}