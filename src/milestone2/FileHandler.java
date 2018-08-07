/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milestone2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryan
 */
public class FileHandler {

    public void writeAll(String report) throws IOException {
        String result = report;
        String filename = "C:\\Users\\Bryan\\Documents\\NetBeansProjects\\Milestone2\\src";
        FileWriter fwriter = new FileWriter(filename);

        BufferedWriter bufwrite = new BufferedWriter(fwriter);

        bufwrite.newLine();
        fwriter.append(result);
        bufwrite.write(result);

    }
}
