package umg.edu.gt.listasenlazadas.circular;

public class RoundRobinPlaylistApp {
	public static void run() {
		
		CircularList<String> playlist = new CircularList<>();

		
		playlist.addLast("Song A");
		playlist.addLast("Song B");
		playlist.addLast("Song C");

		
		System.out.println("Playlist completa:");
		System.out.println(playlist); 

		System.out.println("\nReproducción Round Robin:");

		
		SimpleNode<String> current = playlist.getFirstNode();

		
		for (int i = 0; i < 10; i++) {
			if (current == null)
				break;
			System.out.println("Reproduciendo: " + current.getValue());
			current = current.getNext(); // avanzar al siguiente nodo
		}
	}
}