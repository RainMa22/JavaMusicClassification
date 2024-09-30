package me.rainma22.JavaMusicClassification;

import java.util.Scanner;

import static me.rainma22.JavaMusicClassification.utils.ProcessUtils.isProgramRunnable;

public class Main {
    private static String pathToFFMPEG = "ffmpeg";
    public static void main(String[] args) {
        boolean shouldExit = false;

        while (!shouldExit) {
            if (isProgramRunnable(pathToFFMPEG)) {
                shouldExit = true;
                startApplication(args);
            } else {
                System.out.println("Please enter the path to FFMpeg(type 'exit' to exit):");
                Scanner scanner = new Scanner(System.in);
                pathToFFMPEG = scanner.nextLine();
                if (pathToFFMPEG.equalsIgnoreCase("exit")){
                    shouldExit = true;
                }
            }
        }

    }
    private static void startApplication(String[] args){
        if (args.length == 0) args = new String[]{""};
        MusicPreprocessor preprocessor = new MusicPreprocessor(pathToFFMPEG);
        switch (args[0].toLowerCase()){
            case "train":
                //start preprocessing dataset
                //start training
                //save training model
                //blah blah blah.
                break;
            case "predict":
                //preprocess given audio input
                //load saved model
                //predict and print prediction
                //exit
                break;
            default:
                System.out.println("bad args, returning");
                //print usage
                break;
        }
    }
}