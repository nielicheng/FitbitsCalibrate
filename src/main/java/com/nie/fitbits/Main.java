package com.nie.fitbits;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Main {

	public static void main(String[] args) {

		if(args.length < 1) {
			String message = "Usage: java com.nie.fitbits.Main file \n" + 
		                     "        file: The file that contains instruction list.\n";
			System.out.println(message);
			System.exit(0);
		}
		else {
			String fileName = args[0];
			try {
				
				List<String> instructions = readFile(fileName);
				Invoker invoker = new Invoker();
				List<String> results = invoker.execute(instructions);
				results.stream().forEach(result -> {
					System.out.println(result);
				});
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static List<String> readFile(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		return Files.readAllLines(path);
	}

}
