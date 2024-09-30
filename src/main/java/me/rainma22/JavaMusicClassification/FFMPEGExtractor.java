package me.rainma22.JavaMusicClassification;

import javax.sound.sampled.AudioFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

// a music preprocessor class that processes music files to the pcm_f32le using ffmpeg
public class FFMPEGExtractor {
    private static final byte NUM_CHANNEL = 1;
    private static final String CODEC_NAME = "pcm_f32le";
    private static final int SAMPLE_RATE = 44100;
    private static final byte NUM_BITS_PER_SAMPLE = 32;

    public static final AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_FLOAT, SAMPLE_RATE,
            NUM_BITS_PER_SAMPLE, NUM_CHANNEL, NUM_BITS_PER_SAMPLE / 8, SAMPLE_RATE, false);

    private static final List<String> OUTPUT_PARAM = Arrays.asList(
            "-f", "raw",  //use no container
            "-ar", Integer.toString(SAMPLE_RATE), //set sample rate
            "-vn", //no video output
            "-ac", Byte.toString(NUM_CHANNEL), //set num channel
            "-codec:a", CODEC_NAME  //set codec
    );
    private final ProcessBuilder builder;

    /**
     * creates a new Music Processor with the given path to FFMPEG
     *
     * @param pathToFFMPEG path to FFMPEG
     **/
    public FFMPEGExtractor(String pathToFFMPEG) {
        builder = new ProcessBuilder(pathToFFMPEG);
    }

    /**
     * Returns the process input stream of ffmpeg
     * <br>
     * REQUIRES file indicated by pathToInput to be a file readable by FFMPEG;
     *
     * @param pathToInput path to the Input file
     **/
    public InputStream turnIntoStream(String pathToInput) throws IOException {
        builder.command("-i", pathToInput);
        builder.command(OUTPUT_PARAM);
        builder.command("pipe:1");// output to stdout
        return builder.start().getInputStream();
    }
}
