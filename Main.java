import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Notes notes = new Notes();

        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.print("Введите команду: ");
            command = scanner.nextLine();

            if (command.equals("add")) {
                Note note = new Note();
                System.out.print("Введите заголовок: ");
                note.setTitle(scanner.nextLine());
                System.out.print("Введите текст: ");
                note.setBody(scanner.nextLine());
                notes.add(note);
                System.out.println("Заметка добавлена.");
            } else if (command.startsWith("get ")) {
                Note note = notes.get(command.split(" ")[1]);
                if (note != null) {
                    System.out.println(note);
                } else {
                    System.out.println("Заметка не найдена.");
                }
            } else if (command.equals("all")) {
                for (Note note : notes.getAll()) {
                    System.out.println(note);
                }
            } else if (command.startsWith("delete ")) {
                notes.remove(command.split(" ")[1]);
                System.out.println("Заметка удалена.");
            } else if (command.startsWith("update ")) {
                Note note = notes.get(command.split(" ")[1]);
                if (note != null) {
                    System.out.print("Введите новый заголовок: ");
                    note.setTitle(scanner.nextLine());
                    System.out.print("Введите новый текст: ");
                    note.setBody(scanner.nextLine());
                    notes.update(note);
                    System.out.println("Заметка обновлена.");
                } else {
                    System.out.println("Заметка не найдена.");
                }
            }

        } while (!command.equals("quit"));

        scanner.close();
    }
}
