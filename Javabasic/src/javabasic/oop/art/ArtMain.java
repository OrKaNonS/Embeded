package javabasic.oop.art;

public class ArtMain {
	public static void main(String[] args) {
		IArt drawing = new Drawing("피카소가");
		IArt music = new Music("오페라");
		IArt movie = new Movie("범죄도시");
		
		
		drawing.Picture();
		music.Play();
		movie.Act();
		
		
		drawing.Appreciate();
		music.Appreciate();
		movie.Appreciate();
		
		
		
		
		
	}

}
