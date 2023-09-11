package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Lesson> list = new ArrayList<Lesson>();

		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		System.out.println();

		for (int i = 1; i <= n; i++) {
			System.out.println("Dados da #" + i + " aula: ");
			System.out.printf("Conteúdo ou tarefa (c/t)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Título: ");
			String title = sc.nextLine();

			if (ch == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int sec = sc.nextInt();
				list.add(new Video(title, url, sec));
				System.out.println();
			} else {
				System.out.print("Descrição: ");
				String desc = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int qCount = sc.nextInt();
				list.add(new Task(desc, desc, qCount));
			}

			System.out.println();
		}

		int sum = 0;
		for (Lesson l : list)
			sum += l.duration();

		System.out.printf("DURAÇÃO TOTAL DO CURSO = %d segundos", sum);
		sc.close();

	}
}
