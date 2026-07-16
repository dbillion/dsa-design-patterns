package dp.behavioral.mediator;

import java.util.*;

/** Mediator — chat room broadcasting. */
public final class MediatorDemo {
    public static final class ChatRoom {
        private final List<String> log = new ArrayList<>();
        public void send(String from, String msg) { log.add(from + ": " + msg); }
        public List<String> log() { return List.copyOf(log); }
    }

    public static void main(String[] args) {
        var room = new ChatRoom();
        room.send("Alice", "hi"); room.send("Bob", "hello");
        System.out.println(room.log());
    }
}
