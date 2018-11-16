package sandbox.lockc.javacert.nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class WatchingFileSystems {
	public static void main(String[] args) throws Exception {
		
		
		WatchService ws = FileSystems.getDefault().newWatchService();
		
		
		Path path = Paths.get("src/main/java/sandbox/lockc/javacert/nio");
		path.register(ws, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE);
		
		for(;;) {
			
			WatchKey wk = ws.take();
			List<WatchEvent<?>> events = wk.pollEvents();
			
			for(WatchEvent<?> event : events) {
				
				System.out.println(event.kind());
				
			}
			wk.reset();
		}
	}
}
;