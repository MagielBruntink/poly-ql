package nl.uva.sc.parser;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import nl.uva.sc.datatypes.IndexGenerator;
import nl.uva.sc.datatypes.IndexGeneratorStop;
import nl.uva.sc.datatypes.RecursiveIndexGenerator;

public class BookParser {

    /**
     * Starts the parser with standard UTF-8 encoding
     * 
     * @throws IOException
     *             If the file is invalid or it cannot be parsed with UTF-8 encoding
     */
    public void parse(final File bookFile) throws IOException {
        parse(Charset.forName("UTF-8"), bookFile);
    }

    /**
     * Starts the parser
     * 
     * @throws IOException
     *             If the file is invalid or it cannot be parsed given the character encoding
     */
    public void parse(final Charset encoding, final File bookFile) throws IOException {
        removeStopwords(new ArrayList<>(Arrays.asList(encoding
                .decode(ByteBuffer.wrap(Files.readAllBytes(bookFile.toPath()))).toString()
                .toLowerCase().replaceAll("[^a-z\\s]", " ").replaceAll("(\\s[a-z](?=\\s))", " ")
                .replaceAll("\\s+", " ").split(" "))));
    }

    /**
     * Generate a word list out of a line array
     * 
     * @param lineArray
     *            The line array to generate the word list of
     * @return A word list containing all words from the line array
     */
    private void removeStopwords(final List<String> lineArray) {

        lineArray
                .removeAll(Arrays
                        .asList("a,able,about,across,after,all,almost,also,am,among,an,and,any,are,as,at,be,because,been,but,by,can,cannot,could,dear,did,do,does,either,else,ever,every,for,from,get,got,had,has,have,he,her,hers,him,his,how,however,i,if,in,into,is,it,its,just,least,let,like,likely,may,me,might,most,must,my,neither,no,nor,not,of,off,often,on,only,or,other,our,own,rather,said,say,says,she,should,since,so,some,than,that,the,their,them,then,there,these,they,this,tis,to,too,twas,us,wants,was,we,were,what,when,where,which,while,who,whom,why,will,with,would,yet,you,your"
                                .split(",")));

        generateRecoursiveIndex(
                new ArrayList<RecursiveIndexGenerator>(Collections.nCopies(
                        new HashSet<>(lineArray).size() - 1, new IndexGenerator())), new HashSet<>(
                        lineArray).iterator(), lineArray, new HashMap<String, Integer>());
    }

    private void generateRecoursiveIndex(final List<RecursiveIndexGenerator> recList,
            final Iterator<String> uniqueWords, final List<String> allWords,
            final Map<String, Integer> index) {

        recList.add(new IndexGeneratorStop());
        recList.remove(0).generateIndex(recList, uniqueWords, uniqueWords.next(), allWords, index);
    }
}
