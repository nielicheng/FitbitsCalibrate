package com.nie.fitbits;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.nie.fitbits.exception.InstructionFormatException;


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
				CalibrateInvoker invoker = new CalibrateInvoker();
				List<String> results = invoker.doCalibrate(instructions);
				
				results.stream().forEach(result -> {
					System.out.println(result);
				});
				
			} catch (IOException e) {
				System.out.println("Failed reading from file. (" + e.getMessage() + ")");
			} catch (InstructionFormatException e) {
				System.out.println("Wrong formatted instruction found. (" + e.getMessage() + ")");
			}
		}
	}

	/**
	 * Read instructions from file.
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private static List<String> readFile(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		return Files.readAllLines(path);
	}

}
